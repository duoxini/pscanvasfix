package Y0;

import W0.d;
import W0.e;
import W0.h;
import Z0.b;
import Z0.c;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: A, reason: collision with root package name */
    public static final W0.j f2944A;

    /* renamed from: B, reason: collision with root package name */
    public static final W0.j f2945B;

    /* renamed from: C, reason: collision with root package name */
    public static final W0.k f2946C;

    /* renamed from: D, reason: collision with root package name */
    public static final W0.j f2947D;

    /* renamed from: E, reason: collision with root package name */
    public static final W0.k f2948E;

    /* renamed from: F, reason: collision with root package name */
    public static final W0.j f2949F;

    /* renamed from: G, reason: collision with root package name */
    public static final W0.k f2950G;

    /* renamed from: H, reason: collision with root package name */
    public static final W0.j f2951H;

    /* renamed from: I, reason: collision with root package name */
    public static final W0.k f2952I;

    /* renamed from: J, reason: collision with root package name */
    public static final W0.j f2953J;

    /* renamed from: K, reason: collision with root package name */
    public static final W0.k f2954K;

    /* renamed from: L, reason: collision with root package name */
    public static final W0.j f2955L;

    /* renamed from: M, reason: collision with root package name */
    public static final W0.k f2956M;

    /* renamed from: N, reason: collision with root package name */
    public static final W0.j f2957N;

    /* renamed from: O, reason: collision with root package name */
    public static final W0.k f2958O;

    /* renamed from: P, reason: collision with root package name */
    public static final W0.j f2959P;

    /* renamed from: Q, reason: collision with root package name */
    public static final W0.k f2960Q;

    /* renamed from: R, reason: collision with root package name */
    public static final W0.j f2961R;

    /* renamed from: S, reason: collision with root package name */
    public static final W0.k f2962S;

    /* renamed from: T, reason: collision with root package name */
    public static final W0.j f2963T;

    /* renamed from: U, reason: collision with root package name */
    public static final W0.k f2964U;

    /* renamed from: V, reason: collision with root package name */
    public static final W0.j f2965V;

    /* renamed from: W, reason: collision with root package name */
    public static final W0.k f2966W;

    /* renamed from: X, reason: collision with root package name */
    public static final W0.k f2967X;

    /* renamed from: a, reason: collision with root package name */
    public static final W0.j f2968a;

    /* renamed from: b, reason: collision with root package name */
    public static final W0.k f2969b;

    /* renamed from: c, reason: collision with root package name */
    public static final W0.j f2970c;

    /* renamed from: d, reason: collision with root package name */
    public static final W0.k f2971d;

    /* renamed from: e, reason: collision with root package name */
    public static final W0.j f2972e;

    /* renamed from: f, reason: collision with root package name */
    public static final W0.j f2973f;

    /* renamed from: g, reason: collision with root package name */
    public static final W0.k f2974g;

    /* renamed from: h, reason: collision with root package name */
    public static final W0.j f2975h;

    /* renamed from: i, reason: collision with root package name */
    public static final W0.k f2976i;

    /* renamed from: j, reason: collision with root package name */
    public static final W0.j f2977j;

    /* renamed from: k, reason: collision with root package name */
    public static final W0.k f2978k;

    /* renamed from: l, reason: collision with root package name */
    public static final W0.j f2979l;

    /* renamed from: m, reason: collision with root package name */
    public static final W0.k f2980m;

    /* renamed from: n, reason: collision with root package name */
    public static final W0.j f2981n;

    /* renamed from: o, reason: collision with root package name */
    public static final W0.k f2982o;

    /* renamed from: p, reason: collision with root package name */
    public static final W0.j f2983p;

    /* renamed from: q, reason: collision with root package name */
    public static final W0.k f2984q;

    /* renamed from: r, reason: collision with root package name */
    public static final W0.j f2985r;

    /* renamed from: s, reason: collision with root package name */
    public static final W0.k f2986s;

    /* renamed from: t, reason: collision with root package name */
    public static final W0.j f2987t;

    /* renamed from: u, reason: collision with root package name */
    public static final W0.j f2988u;

    /* renamed from: v, reason: collision with root package name */
    public static final W0.j f2989v;

    /* renamed from: w, reason: collision with root package name */
    public static final W0.j f2990w;

    /* renamed from: x, reason: collision with root package name */
    public static final W0.k f2991x;

    /* renamed from: y, reason: collision with root package name */
    public static final W0.j f2992y;

    /* renamed from: z, reason: collision with root package name */
    public static final W0.j f2993z;

    static /* synthetic */ class A {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2994a;

        static {
            int[] iArr = new int[b.values().length];
            f2994a = iArr;
            try {
                iArr[b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2994a[b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2994a[b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2994a[b.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2994a[b.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2994a[b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    class B extends W0.j {
        B() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean b(Z0.a aVar) {
            b k02 = aVar.k0();
            if (k02 != b.NULL) {
                return k02 == b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.i0())) : Boolean.valueOf(aVar.a0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Boolean bool) {
            cVar.f0(bool);
        }
    }

    class C extends W0.j {
        C() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return Boolean.valueOf(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Boolean bool) {
            cVar.h0(bool == null ? "null" : bool.toString());
        }
    }

    class D extends W0.j {
        D() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Number b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            try {
                int c02 = aVar.c0();
                if (c02 <= 255 && c02 >= -128) {
                    return Byte.valueOf((byte) c02);
                }
                throw new W0.i("Lossy conversion from " + c02 + " to byte; at path " + aVar.u());
            } catch (NumberFormatException e3) {
                throw new W0.i(e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Number number) {
            if (number == null) {
                cVar.G();
            } else {
                cVar.e0(number.byteValue());
            }
        }
    }

    class E extends W0.j {
        E() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Number b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            try {
                int c02 = aVar.c0();
                if (c02 <= 65535 && c02 >= -32768) {
                    return Short.valueOf((short) c02);
                }
                throw new W0.i("Lossy conversion from " + c02 + " to short; at path " + aVar.u());
            } catch (NumberFormatException e3) {
                throw new W0.i(e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Number number) {
            if (number == null) {
                cVar.G();
            } else {
                cVar.e0(number.shortValue());
            }
        }
    }

    class F extends W0.j {
        F() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Number b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.c0());
            } catch (NumberFormatException e3) {
                throw new W0.i(e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Number number) {
            if (number == null) {
                cVar.G();
            } else {
                cVar.e0(number.intValue());
            }
        }
    }

    class G extends W0.j {
        G() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(Z0.a aVar) {
            try {
                return new AtomicInteger(aVar.c0());
            } catch (NumberFormatException e3) {
                throw new W0.i(e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, AtomicInteger atomicInteger) {
            cVar.e0(atomicInteger.get());
        }
    }

    class H extends W0.j {
        H() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(Z0.a aVar) {
            return new AtomicBoolean(aVar.a0());
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, AtomicBoolean atomicBoolean) {
            cVar.i0(atomicBoolean.get());
        }
    }

    /* renamed from: Y0.a$a, reason: collision with other inner class name */
    class C0046a extends W0.j {
        C0046a() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(Z0.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.G()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.c0()));
                } catch (NumberFormatException e3) {
                    throw new W0.i(e3);
                }
            }
            aVar.j();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i3 = 0; i3 < size; i3++) {
                atomicIntegerArray.set(i3, ((Integer) arrayList.get(i3)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, AtomicIntegerArray atomicIntegerArray) {
            cVar.c();
            int length = atomicIntegerArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                cVar.e0(atomicIntegerArray.get(i3));
            }
            cVar.j();
        }
    }

    /* renamed from: Y0.a$b, reason: case insensitive filesystem */
    class C0207b extends W0.j {
        C0207b() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Number b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return Long.valueOf(aVar.d0());
            } catch (NumberFormatException e3) {
                throw new W0.i(e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Number number) {
            if (number == null) {
                cVar.G();
            } else {
                cVar.e0(number.longValue());
            }
        }
    }

    /* renamed from: Y0.a$c, reason: case insensitive filesystem */
    class C0208c extends W0.j {
        C0208c() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Number b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return Float.valueOf((float) aVar.b0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Number number) {
            if (number == null) {
                cVar.G();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.g0(number);
        }
    }

    /* renamed from: Y0.a$d, reason: case insensitive filesystem */
    class C0209d extends W0.j {
        C0209d() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Number b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return Double.valueOf(aVar.b0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Number number) {
            if (number == null) {
                cVar.G();
            } else {
                cVar.d0(number.doubleValue());
            }
        }
    }

    /* renamed from: Y0.a$e, reason: case insensitive filesystem */
    class C0210e extends W0.j {
        C0210e() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Character b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            if (i02.length() == 1) {
                return Character.valueOf(i02.charAt(0));
            }
            throw new W0.i("Expecting character, got: " + i02 + "; at " + aVar.u());
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Character ch) {
            cVar.h0(ch == null ? null : String.valueOf(ch));
        }
    }

    /* renamed from: Y0.a$f, reason: case insensitive filesystem */
    class C0211f extends W0.j {
        C0211f() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(Z0.a aVar) {
            b k02 = aVar.k0();
            if (k02 != b.NULL) {
                return k02 == b.BOOLEAN ? Boolean.toString(aVar.a0()) : aVar.i0();
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, String str) {
            cVar.h0(str);
        }
    }

    /* renamed from: Y0.a$g, reason: case insensitive filesystem */
    class C0212g extends W0.j {
        C0212g() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            try {
                return new BigDecimal(i02);
            } catch (NumberFormatException e3) {
                throw new W0.i("Failed parsing '" + i02 + "' as BigDecimal; at path " + aVar.u(), e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, BigDecimal bigDecimal) {
            cVar.g0(bigDecimal);
        }
    }

    /* renamed from: Y0.a$h, reason: case insensitive filesystem */
    class C0213h extends W0.j {
        C0213h() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BigInteger b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            try {
                return new BigInteger(i02);
            } catch (NumberFormatException e3) {
                throw new W0.i("Failed parsing '" + i02 + "' as BigInteger; at path " + aVar.u(), e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, BigInteger bigInteger) {
            cVar.g0(bigInteger);
        }
    }

    class i extends W0.j {
        i() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public X0.b b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return new X0.b(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, X0.b bVar) {
            cVar.g0(bVar);
        }
    }

    class j extends W0.j {
        j() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return new StringBuilder(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, StringBuilder sb) {
            cVar.h0(sb == null ? null : sb.toString());
        }
    }

    class k extends W0.j {
        k() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Class b(Z0.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends W0.j {
        l() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return new StringBuffer(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, StringBuffer stringBuffer) {
            cVar.h0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    class m extends W0.j {
        m() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public URL b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            if ("null".equals(i02)) {
                return null;
            }
            return new URL(i02);
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, URL url) {
            cVar.h0(url == null ? null : url.toExternalForm());
        }
    }

    class n extends W0.j {
        n() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public URI b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            try {
                String i02 = aVar.i0();
                if ("null".equals(i02)) {
                    return null;
                }
                return new URI(i02);
            } catch (URISyntaxException e3) {
                throw new W0.c(e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, URI uri) {
            cVar.h0(uri == null ? null : uri.toASCIIString());
        }
    }

    class o extends W0.j {
        o() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public InetAddress b(Z0.a aVar) {
            if (aVar.k0() != b.NULL) {
                return InetAddress.getByName(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, InetAddress inetAddress) {
            cVar.h0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    class p extends W0.j {
        p() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public UUID b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            try {
                return UUID.fromString(i02);
            } catch (IllegalArgumentException e3) {
                throw new W0.i("Failed parsing '" + i02 + "' as UUID; at path " + aVar.u(), e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, UUID uuid) {
            cVar.h0(uuid == null ? null : uuid.toString());
        }
    }

    class q extends W0.j {
        q() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Currency b(Z0.a aVar) {
            String i02 = aVar.i0();
            try {
                return Currency.getInstance(i02);
            } catch (IllegalArgumentException e3) {
                throw new W0.i("Failed parsing '" + i02 + "' as Currency; at path " + aVar.u(), e3);
            }
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Currency currency) {
            cVar.h0(currency.getCurrencyCode());
        }
    }

    class r extends W0.j {
        r() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Calendar b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            aVar.b();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (aVar.k0() != b.END_OBJECT) {
                String e02 = aVar.e0();
                int c02 = aVar.c0();
                if ("year".equals(e02)) {
                    i3 = c02;
                } else if ("month".equals(e02)) {
                    i4 = c02;
                } else if ("dayOfMonth".equals(e02)) {
                    i5 = c02;
                } else if ("hourOfDay".equals(e02)) {
                    i6 = c02;
                } else if ("minute".equals(e02)) {
                    i7 = c02;
                } else if ("second".equals(e02)) {
                    i8 = c02;
                }
            }
            aVar.l();
            return new GregorianCalendar(i3, i4, i5, i6, i7, i8);
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Calendar calendar) {
            if (calendar == null) {
                cVar.G();
                return;
            }
            cVar.g();
            cVar.q("year");
            cVar.e0(calendar.get(1));
            cVar.q("month");
            cVar.e0(calendar.get(2));
            cVar.q("dayOfMonth");
            cVar.e0(calendar.get(5));
            cVar.q("hourOfDay");
            cVar.e0(calendar.get(11));
            cVar.q("minute");
            cVar.e0(calendar.get(12));
            cVar.q("second");
            cVar.e0(calendar.get(13));
            cVar.l();
        }
    }

    class s extends W0.j {
        s() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Locale b(Z0.a aVar) {
            if (aVar.k0() == b.NULL) {
                aVar.g0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.i0(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, Locale locale) {
            cVar.h0(locale == null ? null : locale.toString());
        }
    }

    class t extends W0.j {
        t() {
        }

        private W0.b e(Z0.a aVar, b bVar) {
            int i3 = A.f2994a[bVar.ordinal()];
            if (i3 == 1) {
                return new h(new X0.b(aVar.i0()));
            }
            if (i3 == 2) {
                return new h(aVar.i0());
            }
            if (i3 == 3) {
                return new h(Boolean.valueOf(aVar.a0()));
            }
            if (i3 == 6) {
                aVar.g0();
                return d.f2587e;
            }
            throw new IllegalStateException("Unexpected token: " + bVar);
        }

        private W0.b f(Z0.a aVar, b bVar) {
            int i3 = A.f2994a[bVar.ordinal()];
            if (i3 == 4) {
                aVar.a();
                return new W0.a();
            }
            if (i3 != 5) {
                return null;
            }
            aVar.b();
            return new e();
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public W0.b b(Z0.a aVar) {
            b k02 = aVar.k0();
            W0.b f3 = f(aVar, k02);
            if (f3 == null) {
                return e(aVar, k02);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.G()) {
                    String e02 = f3 instanceof e ? aVar.e0() : null;
                    b k03 = aVar.k0();
                    W0.b f4 = f(aVar, k03);
                    boolean z3 = f4 != null;
                    if (f4 == null) {
                        f4 = e(aVar, k03);
                    }
                    if (f3 instanceof W0.a) {
                        ((W0.a) f3).h(f4);
                    } else {
                        ((e) f3).h(e02, f4);
                    }
                    if (z3) {
                        arrayDeque.addLast(f3);
                        f3 = f4;
                    }
                } else {
                    if (f3 instanceof W0.a) {
                        aVar.j();
                    } else {
                        aVar.l();
                    }
                    if (arrayDeque.isEmpty()) {
                        return f3;
                    }
                    f3 = (W0.b) arrayDeque.removeLast();
                }
            }
        }

        @Override // W0.j
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, W0.b bVar) {
            if (bVar == null || bVar.e()) {
                cVar.G();
                return;
            }
            if (bVar.g()) {
                h c3 = bVar.c();
                if (c3.m()) {
                    cVar.g0(c3.i());
                    return;
                } else if (c3.k()) {
                    cVar.i0(c3.h());
                    return;
                } else {
                    cVar.h0(c3.j());
                    return;
                }
            }
            if (bVar.d()) {
                cVar.c();
                Iterator it = bVar.a().iterator();
                while (it.hasNext()) {
                    c(cVar, (W0.b) it.next());
                }
                cVar.j();
                return;
            }
            if (!bVar.f()) {
                throw new IllegalArgumentException("Couldn't write " + bVar.getClass());
            }
            cVar.g();
            for (Map.Entry entry : bVar.b().i()) {
                cVar.q((String) entry.getKey());
                c(cVar, (W0.b) entry.getValue());
            }
            cVar.l();
        }
    }

    class u implements W0.k {
        u() {
        }
    }

    class v extends W0.j {
        v() {
        }

        @Override // W0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BitSet b(Z0.a aVar) {
            BitSet bitSet = new BitSet();
            aVar.a();
            b k02 = aVar.k0();
            int i3 = 0;
            while (k02 != b.END_ARRAY) {
                int i4 = A.f2994a[k02.ordinal()];
                boolean z3 = true;
                if (i4 == 1 || i4 == 2) {
                    int c02 = aVar.c0();
                    if (c02 == 0) {
                        z3 = false;
                    } else if (c02 != 1) {
                        throw new W0.i("Invalid bitset value " + c02 + ", expected 0 or 1; at path " + aVar.u());
                    }
                } else {
                    if (i4 != 3) {
                        throw new W0.i("Invalid bitset value type: " + k02 + "; at path " + aVar.d());
                    }
                    z3 = aVar.a0();
                }
                if (z3) {
                    bitSet.set(i3);
                }
                i3++;
                k02 = aVar.k0();
            }
            aVar.j();
            return bitSet;
        }

        @Override // W0.j
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(c cVar, BitSet bitSet) {
            cVar.c();
            int length = bitSet.length();
            for (int i3 = 0; i3 < length; i3++) {
                cVar.e0(bitSet.get(i3) ? 1L : 0L);
            }
            cVar.j();
        }
    }

    class w implements W0.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f2995a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ W0.j f2996b;

        w(Class cls, W0.j jVar) {
            this.f2995a = cls;
            this.f2996b = jVar;
        }

        public String toString() {
            return "Factory[type=" + this.f2995a.getName() + ",adapter=" + this.f2996b + "]";
        }
    }

    class x implements W0.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f2997a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f2998b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ W0.j f2999c;

        x(Class cls, Class cls2, W0.j jVar) {
            this.f2997a = cls;
            this.f2998b = cls2;
            this.f2999c = jVar;
        }

        public String toString() {
            return "Factory[type=" + this.f2998b.getName() + "+" + this.f2997a.getName() + ",adapter=" + this.f2999c + "]";
        }
    }

    class y implements W0.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f3000a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f3001b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ W0.j f3002c;

        y(Class cls, Class cls2, W0.j jVar) {
            this.f3000a = cls;
            this.f3001b = cls2;
            this.f3002c = jVar;
        }

        public String toString() {
            return "Factory[type=" + this.f3000a.getName() + "+" + this.f3001b.getName() + ",adapter=" + this.f3002c + "]";
        }
    }

    class z implements W0.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f3003a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ W0.j f3004b;

        z(Class cls, W0.j jVar) {
            this.f3003a = cls;
            this.f3004b = jVar;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f3003a.getName() + ",adapter=" + this.f3004b + "]";
        }
    }

    static {
        W0.j a3 = new k().a();
        f2968a = a3;
        f2969b = a(Class.class, a3);
        W0.j a4 = new v().a();
        f2970c = a4;
        f2971d = a(BitSet.class, a4);
        B b3 = new B();
        f2972e = b3;
        f2973f = new C();
        f2974g = b(Boolean.TYPE, Boolean.class, b3);
        D d3 = new D();
        f2975h = d3;
        f2976i = b(Byte.TYPE, Byte.class, d3);
        E e3 = new E();
        f2977j = e3;
        f2978k = b(Short.TYPE, Short.class, e3);
        F f3 = new F();
        f2979l = f3;
        f2980m = b(Integer.TYPE, Integer.class, f3);
        W0.j a5 = new G().a();
        f2981n = a5;
        f2982o = a(AtomicInteger.class, a5);
        W0.j a6 = new H().a();
        f2983p = a6;
        f2984q = a(AtomicBoolean.class, a6);
        W0.j a7 = new C0046a().a();
        f2985r = a7;
        f2986s = a(AtomicIntegerArray.class, a7);
        f2987t = new C0207b();
        f2988u = new C0208c();
        f2989v = new C0209d();
        C0210e c0210e = new C0210e();
        f2990w = c0210e;
        f2991x = b(Character.TYPE, Character.class, c0210e);
        C0211f c0211f = new C0211f();
        f2992y = c0211f;
        f2993z = new C0212g();
        f2944A = new C0213h();
        f2945B = new i();
        f2946C = a(String.class, c0211f);
        j jVar = new j();
        f2947D = jVar;
        f2948E = a(StringBuilder.class, jVar);
        l lVar = new l();
        f2949F = lVar;
        f2950G = a(StringBuffer.class, lVar);
        m mVar = new m();
        f2951H = mVar;
        f2952I = a(URL.class, mVar);
        n nVar = new n();
        f2953J = nVar;
        f2954K = a(URI.class, nVar);
        o oVar = new o();
        f2955L = oVar;
        f2956M = d(InetAddress.class, oVar);
        p pVar = new p();
        f2957N = pVar;
        f2958O = a(UUID.class, pVar);
        W0.j a8 = new q().a();
        f2959P = a8;
        f2960Q = a(Currency.class, a8);
        r rVar = new r();
        f2961R = rVar;
        f2962S = c(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        f2963T = sVar;
        f2964U = a(Locale.class, sVar);
        t tVar = new t();
        f2965V = tVar;
        f2966W = d(W0.b.class, tVar);
        f2967X = new u();
    }

    public static W0.k a(Class cls, W0.j jVar) {
        return new w(cls, jVar);
    }

    public static W0.k b(Class cls, Class cls2, W0.j jVar) {
        return new x(cls, cls2, jVar);
    }

    public static W0.k c(Class cls, Class cls2, W0.j jVar) {
        return new y(cls, cls2, jVar);
    }

    public static W0.k d(Class cls, W0.j jVar) {
        return new z(cls, jVar);
    }
}
