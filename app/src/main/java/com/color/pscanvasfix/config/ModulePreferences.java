package com.color.pscanvasfix.config;

import android.content.SharedPreferences;

import java.util.Objects;

/** Read-only module preferences shared by the manager and target process. */
public final class ModulePreferences {
    public static final String PREFERENCES_NAME = "module_preferences";
    public static final String KEY_ADJUSTABLE_WINDOW_SIZE = "adjustable_window_size";
    public static final String KEY_FOUR_TASK_CANVAS = "four_task_canvas";

    public static final boolean DEFAULT_ADJUSTABLE_WINDOW_SIZE = false;
    public static final boolean DEFAULT_FOUR_TASK_CANVAS = false;

    private ModulePreferences() {
    }

    /**
     * Reads one immutable decision snapshot. Any unavailable or invalid read fails closed for
     * the entire snapshot, so a partially read configuration can never enable a feature.
     */
    public static Snapshot readSnapshot(SharedPreferences preferences) {
        if (preferences == null) {
            return Snapshot.defaults();
        }
        try {
            boolean adjustableWindowSize = preferences.getBoolean(
                    KEY_ADJUSTABLE_WINDOW_SIZE, DEFAULT_ADJUSTABLE_WINDOW_SIZE);
            boolean fourTaskCanvas = preferences.getBoolean(
                    KEY_FOUR_TASK_CANVAS, DEFAULT_FOUR_TASK_CANVAS);
            return Snapshot.of(adjustableWindowSize, fourTaskCanvas);
        } catch (RuntimeException ignored) {
            return Snapshot.defaults();
        }
    }

    /** Immutable preference values captured before feature installation. */
    public static final class Snapshot {
        private static final Snapshot DEFAULTS = new Snapshot(
                DEFAULT_ADJUSTABLE_WINDOW_SIZE, DEFAULT_FOUR_TASK_CANVAS);

        private final boolean adjustableWindowSizeEnabled;
        private final boolean fourTaskCanvasEnabled;

        private Snapshot(boolean adjustableWindowSizeEnabled, boolean fourTaskCanvasEnabled) {
            this.adjustableWindowSizeEnabled = adjustableWindowSizeEnabled;
            this.fourTaskCanvasEnabled = fourTaskCanvasEnabled;
        }

        public static Snapshot defaults() {
            return DEFAULTS;
        }

        public static Snapshot of(boolean adjustableWindowSizeEnabled,
                                  boolean fourTaskCanvasEnabled) {
            if (!adjustableWindowSizeEnabled && !fourTaskCanvasEnabled) {
                return DEFAULTS;
            }
            return new Snapshot(adjustableWindowSizeEnabled, fourTaskCanvasEnabled);
        }

        public boolean adjustableWindowSizeEnabled() {
            return adjustableWindowSizeEnabled;
        }

        public boolean fourTaskCanvasEnabled() {
            return fourTaskCanvasEnabled;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot that = (Snapshot) other;
            return adjustableWindowSizeEnabled == that.adjustableWindowSizeEnabled
                    && fourTaskCanvasEnabled == that.fourTaskCanvasEnabled;
        }

        @Override
        public int hashCode() {
            return Objects.hash(adjustableWindowSizeEnabled, fourTaskCanvasEnabled);
        }

        @Override
        public String toString() {
            return "Snapshot{"
                    + "adjustableWindowSizeEnabled=" + adjustableWindowSizeEnabled
                    + ", fourTaskCanvasEnabled=" + fourTaskCanvasEnabled
                    + '}';
        }
    }
}
