package com.color.pscanvasfix.feature.resize;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

/** Versioned, pixel-independent payload for saved two/three-task Normal layouts. */
public final class SavedSplitLayoutCodec {
    public static final int CURRENT_VERSION = 1;
    public static final int RATIO_SCALE = 10_000;
    private static final String PREFIX = "pscanvas-layout";

    private SavedSplitLayoutCodec() {
    }

    public static String encode(Layout layout) {
        Objects.requireNonNull(layout, "layout");
        validate(layout.taskCount, layout.layoutOrientation,
                layout.dividerRatios, layout.slotOrderFingerprint);
        String fingerprint = Base64.getUrlEncoder().withoutPadding().encodeToString(
                layout.slotOrderFingerprint.getBytes(StandardCharsets.UTF_8));
        return PREFIX + ';' + CURRENT_VERSION + ';' + layout.taskCount + ';'
                + layout.layoutOrientation + ';' + join(layout.dividerRatios) + ';' + fingerprint;
    }

    public static Optional<Layout> decode(String encoded) {
        if (encoded == null || encoded.length() > 4096) {
            return Optional.empty();
        }
        try {
            String[] parts = encoded.split(";", -1);
            if (parts.length != 6 || !PREFIX.equals(parts[0])) {
                return Optional.empty();
            }
            int version = Integer.parseInt(parts[1]);
            if (version != CURRENT_VERSION) {
                return Optional.empty();
            }
            int taskCount = Integer.parseInt(parts[2]);
            int orientation = Integer.parseInt(parts[3]);
            int[] ratios = parseRatios(parts[4]);
            String fingerprint = new String(Base64.getUrlDecoder().decode(parts[5]),
                    StandardCharsets.UTF_8);
            validate(taskCount, orientation, ratios, fingerprint);
            return Optional.of(new Layout(taskCount, orientation, ratios, fingerprint));
        } catch (IllegalArgumentException ignored) {
            return Optional.empty();
        }
    }

    private static String join(int[] ratios) {
        StringBuilder value = new StringBuilder();
        for (int index = 0; index < ratios.length; index++) {
            if (index > 0) {
                value.append(',');
            }
            value.append(ratios[index]);
        }
        return value.toString();
    }

    private static int[] parseRatios(String value) {
        if (value.isEmpty()) {
            return new int[0];
        }
        String[] fields = value.split(",", -1);
        int[] ratios = new int[fields.length];
        for (int index = 0; index < fields.length; index++) {
            ratios[index] = Integer.parseInt(fields[index]);
        }
        return ratios;
    }

    private static void validate(int taskCount, int orientation, int[] ratios,
                                 String fingerprint) {
        Objects.requireNonNull(ratios, "ratios");
        Objects.requireNonNull(fingerprint, "fingerprint");
        if (taskCount != 2 && taskCount != 3) {
            throw new IllegalArgumentException("Only two/three-task layouts are supported");
        }
        if (orientation < 0 || orientation > 7) {
            throw new IllegalArgumentException("Unsupported layout orientation");
        }
        if (ratios.length != taskCount - 1) {
            throw new IllegalArgumentException("Divider count does not match task count");
        }
        int previous = 0;
        for (int ratio : ratios) {
            if (ratio <= previous || ratio >= RATIO_SCALE) {
                throw new IllegalArgumentException("Divider ratios must be increasing and bounded");
            }
            previous = ratio;
        }
        if (fingerprint.isEmpty() || fingerprint.length() > 1024) {
            throw new IllegalArgumentException("Invalid slot order fingerprint");
        }
    }

    public static final class Layout {
        private final int taskCount;
        private final int layoutOrientation;
        private final int[] dividerRatios;
        private final String slotOrderFingerprint;

        public Layout(int taskCount, int layoutOrientation, int[] dividerRatios,
                      String slotOrderFingerprint) {
            validate(taskCount, layoutOrientation, dividerRatios, slotOrderFingerprint);
            this.taskCount = taskCount;
            this.layoutOrientation = layoutOrientation;
            this.dividerRatios = dividerRatios.clone();
            this.slotOrderFingerprint = slotOrderFingerprint;
        }

        public int taskCount() {
            return taskCount;
        }

        public int layoutOrientation() {
            return layoutOrientation;
        }

        public int[] dividerRatios() {
            return dividerRatios.clone();
        }

        public String slotOrderFingerprint() {
            return slotOrderFingerprint;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Layout)) {
                return false;
            }
            Layout that = (Layout) other;
            return taskCount == that.taskCount
                    && layoutOrientation == that.layoutOrientation
                    && Arrays.equals(dividerRatios, that.dividerRatios)
                    && slotOrderFingerprint.equals(that.slotOrderFingerprint);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(taskCount, layoutOrientation, slotOrderFingerprint);
            return 31 * result + Arrays.hashCode(dividerRatios);
        }
    }
}
