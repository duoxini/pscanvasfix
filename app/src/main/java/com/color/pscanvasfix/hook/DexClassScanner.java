package com.color.pscanvasfix.hook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Minimal, self-contained DEX reader used as the single source of truth for
 * structural symbol detection.
 *
 * <p>It is deliberately dependency-free (java.util.zip + java.nio only) so the
 * exact same scan runs both at runtime (inside the Xposed host process, over the
 * installed APK) and in a plain JVM unit test (over the four archived APKs).
 * Only the {@code class_def} pool is unneeded here: the flat {@code method_ids} /
 * {@code field_ids} pools carry their owning {@code class_idx}, so a per-class
 * method+field view is rebuilt directly from them.</p>
 *
 * <p>Only the string / type / proto / method / field pools are read. Everything
 * is names+descriptors; nothing is executed or loaded, so this also runs in a
 * host where the obfuscated classes are not yet on the classpath.</p>
 */
public final class DexClassScanner {

    /** Prefix used to detect primary dex entry names: classes.dex, classes2.dex ... */
    private static final Pattern DEX_ENTRY = Pattern.compile("^classes\\d*\\.dex$");

    private DexClassScanner() {
    }

    /** Scan every classes*.dex under the given APK (a zip) and merge by class name. */
    public static List<DexClass> scanApk(File apk) {
        if (apk == null || !apk.isFile()) {
            return Collections.emptyList();
        }
        Map<String, DexClass> merged = new LinkedHashMap<>();
        try (ZipFile zip = new ZipFile(apk)) {
            for (var entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = entries.nextElement();
                if (!DEX_ENTRY.matcher(entry.getName()).matches()) {
                    continue;
                }
                try (InputStream input = zip.getInputStream(entry)) {
                    byte[] data = readAll(input);
                    for (DexClass cls : parse(data)) {
                        DexClass prior = merged.get(cls.name);
                        if (prior == null) {
                            merged.put(cls.name, cls);
                        } else {
                            prior.merge(cls);
                        }
                    }
                }
            }
        } catch (IOException | RuntimeException ignored) {
            // A corrupt / partially-read APK must never stall hook installation.
            return Collections.emptyList();
        }
        return new ArrayList<>(merged.values());
    }

    /** Parse one DEX file (the raw {@code classes*.dex} byte stream). */
    public static List<DexClass> parse(byte[] data) {
        if (data == null || data.length < 0x70) {
            return Collections.emptyList();
        }
        if (data[0] != 'd' || data[1] != 'e' || data[2] != 'x' || data[3] != '\n') {
            return Collections.emptyList();
        }
        try {
            return new Parser(data).parse();
        } catch (RuntimeException ignored) {
            return Collections.emptyList();
        }
    }

    private static byte[] readAll(InputStream input) throws IOException {
        ByteArrayOutputStreamSink out = new ByteArrayOutputStreamSink();
        byte[] buffer = new byte[32 * 1024];
        for (int read; (read = input.read(buffer)) != -1; ) {
            out.write(buffer, 0, read);
        }
        return out.toByteArray();
    }

    /** Tiny byte-array accumulator to avoid depending on a {@code ByteArrayOutputStream} subclass. */
    private static final class ByteArrayOutputStreamSink {
        private byte[] buf = new byte[256];
        private int size;

        void write(byte[] data, int offset, int len) {
            ensure(len);
            System.arraycopy(data, offset, buf, size, len);
            size += len;
        }

        private void ensure(int extra) {
            if (size + extra <= buf.length) {
                return;
            }
            byte[] next = new byte[Math.max(buf.length * 2, size + extra)];
            System.arraycopy(buf, 0, next, 0, size);
            buf = next;
        }

        byte[] toByteArray() {
            byte[] out = new byte[size];
            System.arraycopy(buf, 0, out, 0, size);
            return out;
        }
    }

    /** A single class reconstructed from the flat DEX pools. */
    public static final class DexClass {
        public final String name;
        public final List<DexMethod> methods = new ArrayList<>();
        public final List<DexField> fields = new ArrayList<>();

        DexClass(String name) {
            this.name = name;
        }

        void merge(DexClass other) {
            methods.addAll(other.methods);
            fields.addAll(other.fields);
        }
    }

    /** A method as seen from the DEX (no reflection; never loads the class). */
    public static final class DexMethod {
        public final String name;
        public final String returnDescriptor;
        public final List<String> paramDescriptors;

        DexMethod(String name, String returnDescriptor, List<String> paramDescriptors) {
            this.name = name;
            this.returnDescriptor = returnDescriptor;
            this.paramDescriptors = Collections.unmodifiableList(
                    new ArrayList<>(paramDescriptors));
        }

        /** Canonical key, e.g. {@code (Landroid/view/ScaleGestureDetector;I)}. */
        public String signatureKey() {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            for (String param : paramDescriptors) {
                sb.append(param);
            }
            sb.append(')');
            return sb.toString();
        }
    }

    /** A field as seen from the DEX. */
    public static final class DexField {
        public final String name;
        public final String typeDescriptor;

        DexField(String name, String typeDescriptor) {
            this.name = name;
            this.typeDescriptor = typeDescriptor;
        }
    }

    /** @return binary class name ({@code Lx1/x;} -> {@code x1.x}). */
    private static String binaryName(String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return descriptor;
        }
        if (descriptor.charAt(0) == 'L' && descriptor.charAt(descriptor.length() - 1) == ';') {
            return descriptor.substring(1, descriptor.length() - 1).replace('/', '.');
        }
        return descriptor;
    }

    private static final class Parser {
        private final byte[] data;
        private final ByteBuffer bb;
        private String[] strings;

        // Proto/type bookkeeping, populated before method_ids are walked.
        private String[] typeDescriptors;
        private Proto[] protos = new Proto[0];

        /**
         * Some ColorOS dex files (observed on the 260608 firmware) store type_idx
         * entries inside type_lists as 16-bit values padded to a 4-byte boundary,
         * instead of the standard 32-bit values. Detected once per file: when any
         * type_list read with 32-bit items yields an out-of-range type_idx, the
         * whole file is parsed with 16-bit items. A genuine standard dex never
         * produces an out-of-range index, so the probe is deterministic.
         */
        private boolean typeListU16;

        private int stringIdsSize;
        private int stringIdsOff;
        private int typeIdsSize;
        private int typeIdsOff;
        private int protoIdsSize;
        private int protoIdsOff;
        private int fieldIdsSize;
        private int fieldIdsOff;
        private int methodIdsSize;
        private int methodIdsOff;

        Parser(byte[] data) {
            this.data = data;
            this.bb = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
            this.strings = new String[0];
        }

        List<DexClass> parse() {
            bb.position(0x38);
            stringIdsSize = bb.getInt();
            stringIdsOff = bb.getInt();
            typeIdsSize = bb.getInt();
            typeIdsOff = bb.getInt();
            protoIdsSize = bb.getInt();
            protoIdsOff = bb.getInt();
            fieldIdsSize = bb.getInt();
            fieldIdsOff = bb.getInt();
            methodIdsSize = bb.getInt();
            methodIdsOff = bb.getInt();

            strings = readStrings();
            readTypes();
            detectTypeListFormat();
            readProtos();

            Map<String, DexClass> byName = new LinkedHashMap<>();

            for (int i = 0; i < fieldIdsSize; i++) {
                int base = fieldIdsOff + i * 8;
                int classIdx = bb.getShort(base) & 0xffff;
                int typeIdx = bb.getShort(base + 2) & 0xffff;
                int nameIdx = bb.getInt(base + 4);
                byName.computeIfAbsent(binaryName(typeDescriptors[classIdx]), DexClass::new)
                        .fields.add(new DexField(strings[nameIdx], typeDescriptors[typeIdx]));
            }

            for (int i = 0; i < methodIdsSize; i++) {
                int base = methodIdsOff + i * 8;
                int classIdx = bb.getShort(base) & 0xffff;
                int protoIdx = bb.getShort(base + 2) & 0xffff;
                int nameIdx = bb.getInt(base + 4);
                String className = binaryName(typeDescriptors[classIdx]);
                Proto proto = protos[protoIdx];
                DexMethod method = new DexMethod(
                        strings[nameIdx],
                        proto.returnType,
                        proto.params);
                byName.computeIfAbsent(className, DexClass::new).methods.add(method);
            }

            return new ArrayList<>(byName.values());
        }

        private String[] readStrings() {
            String[] out = new String[stringIdsSize];
            for (int i = 0; i < stringIdsSize; i++) {
                int off = bb.getInt(stringIdsOff + i * 4);
                MUtf8 result = readMutf8(off);
                out[i] = result.text;
            }
            return out;
        }

        private void readTypes() {
            typeDescriptors = new String[typeIdsSize];
            for (int i = 0; i < typeIdsSize; i++) {
                int descIdx = bb.getInt(typeIdsOff + i * 4);
                typeDescriptors[i] = strings[descIdx];
            }
        }

        private void readProtos() {
            protos = new Proto[protoIdsSize];
            for (int i = 0; i < protoIdsSize; i++) {
                int base = protoIdsOff + i * 12;
                int returnTypeIdx = bb.getInt(base + 4);
                int parametersOff = bb.getInt(base + 8);
                List<String> params = parametersOff == 0
                        ? Collections.emptyList()
                        : readTypeList(parametersOff);
                protos[i] = new Proto(typeDescriptors[returnTypeIdx], params);
            }
        }

        /**
         * Probe every type_list with 32-bit items; the first out-of-range
         * type_idx flips the file into the 16-bit layout (see
         * {@link #typeListU16}). A standard dex keeps 32-bit items throughout,
         * so probing all lists is deterministic in both directions.
         */
        private void detectTypeListFormat() {
            typeListU16 = false;
            for (int i = 0; i < protoIdsSize; i++) {
                int parametersOff = bb.getInt(protoIdsOff + i * 12 + 8);
                if (parametersOff == 0) {
                    continue;
                }
                int size = bb.getInt(parametersOff);
                if (size <= 0 || size > 512) {
                    continue;
                }
                for (int k = 0; k < size; k++) {
                    int typeIdx = bb.getInt(parametersOff + 4 + k * 4);
                    if (typeIdx < 0 || typeIdx >= typeIdsSize) {
                        typeListU16 = true;
                        return;
                    }
                }
            }
        }

        private List<String> readTypeList(int offset) {
            int size = bb.getInt(offset);
            List<String> params = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                int typeIdx = typeListU16
                        ? bb.getShort(offset + 4 + i * 2) & 0xffff
                        : bb.getInt(offset + 4 + i * 4);
                params.add(typeDescriptors[typeIdx]);
            }
            return params;
        }

        /** @return the MUTF-8 string at {@code offset}; never null. */
        private MUtf8 readMutf8(int offset) {
            // uleb128 utf16 length (ignored; just need the zero-terminated bytes)
            int pos = offset;
            int length = 0;
            while (true) {
                int b = data[pos++] & 0xff;
                length |= (b & 0x7f);
                if ((b & 0x80) == 0) {
                    break;
                }
                length <<= 7;
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                int b = data[pos++] & 0xff;
                if (b == 0) {
                    break;
                }
                int codePoint;
                if (b < 0x80) {
                    codePoint = b;
                } else if ((b & 0xe0) == 0xc0) {
                    int b2 = data[pos++] & 0x3f;
                    codePoint = ((b & 0x1f) << 6) | b2;
                } else {
                    int b2 = data[pos++] & 0x3f;
                    int b3 = data[pos++] & 0x3f;
                    codePoint = ((b & 0x0f) << 12) | (b2 << 6) | b3;
                }
                sb.appendCodePoint(codePoint);
            }
            return new MUtf8(sb.toString());
        }

        private static final class Proto {
            final String returnType;
            final List<String> params;

            Proto(String returnType, List<String> params) {
                this.returnType = returnType;
                this.params = params;
            }
        }

        private static final class MUtf8 {
            final String text;

            MUtf8(String text) {
                this.text = text;
            }
        }
    }
}
