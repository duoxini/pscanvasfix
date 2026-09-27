package com.color.pscanvasfix.core;

import com.color.pscanvasfix.config.ModulePreferences;

import java.util.Objects;

/** Computes effective feature state from the immutable Preference AND Capability inputs. */
public final class FeatureManager {
    public enum Feature {
        ADJUSTABLE_WINDOW_SIZE,
        FOUR_TASK_CANVAS
    }

    public enum Status {
        ENABLED,
        DISABLED_BY_USER,
        DISABLED_CAPABILITY_MISSING,
        DISABLED_AMBIGUOUS,
        UNVERIFIED
    }

    private final ModulePreferences.Snapshot preferences;
    private final CapabilitySet capabilities;

    public FeatureManager(ModulePreferences.Snapshot preferences, CapabilitySet capabilities) {
        this.preferences = Objects.requireNonNull(preferences, "preferences");
        this.capabilities = Objects.requireNonNull(capabilities, "capabilities");
    }

    public Status status(Feature feature) {
        Objects.requireNonNull(feature, "feature");
        switch (feature) {
            case ADJUSTABLE_WINDOW_SIZE:
                return resolve(preferences.adjustableWindowSizeEnabled(),
                        capabilities.adjustableWindowSize());
            case FOUR_TASK_CANVAS:
                return resolve(preferences.fourTaskCanvasEnabled(),
                        capabilities.fourTaskCanvas());
            default:
                throw new AssertionError("Unhandled feature: " + feature);
        }
    }

    public boolean isEnabled(Feature feature) {
        return status(feature) == Status.ENABLED;
    }

    private static Status resolve(boolean preferred, CapabilitySet.State capability) {
        if (!preferred) {
            return Status.DISABLED_BY_USER;
        }
        switch (capability) {
            case READY:
                return Status.ENABLED;
            case MISSING:
                return Status.DISABLED_CAPABILITY_MISSING;
            case AMBIGUOUS:
                return Status.DISABLED_AMBIGUOUS;
            case UNVERIFIED:
                return Status.UNVERIFIED;
            default:
                throw new AssertionError("Unhandled capability: " + capability);
        }
    }
}
