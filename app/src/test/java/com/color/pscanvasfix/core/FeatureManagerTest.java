package com.color.pscanvasfix.core;

import com.color.pscanvasfix.config.ModulePreferences;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public final class FeatureManagerTest {
    @Test
    public void exhaustivelyCombinesPreferencesAndCapabilitiesWithoutCrossTalk() {
        boolean[] preferences = {false, true};
        for (boolean adjustablePreference : preferences) {
            for (boolean fourTaskPreference : preferences) {
                for (CapabilitySet.State adjustableCapability : CapabilitySet.State.values()) {
                    for (CapabilitySet.State fourTaskCapability : CapabilitySet.State.values()) {
                        FeatureManager manager = new FeatureManager(
                                ModulePreferences.Snapshot.of(
                                        adjustablePreference, fourTaskPreference),
                                CapabilitySet.of(adjustableCapability, fourTaskCapability));

                        assertStatus(manager, FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE,
                                expected(adjustablePreference, adjustableCapability));
                        assertStatus(manager, FeatureManager.Feature.FOUR_TASK_CANVAS,
                                expected(fourTaskPreference, fourTaskCapability));
                    }
                }
            }
        }
    }

    @Test
    public void defaultInputsKeepBothFutureFeaturesDisabledByUser() {
        FeatureManager manager = new FeatureManager(
                ModulePreferences.Snapshot.defaults(), CapabilitySet.unverified());

        assertEquals(FeatureManager.Status.DISABLED_BY_USER,
                manager.status(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE));
        assertEquals(FeatureManager.Status.DISABLED_BY_USER,
                manager.status(FeatureManager.Feature.FOUR_TASK_CANVAS));
        assertFalse(manager.isEnabled(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE));
        assertFalse(manager.isEnabled(FeatureManager.Feature.FOUR_TASK_CANVAS));
    }

    @Test
    public void rejectsAbsentDecisionInputs() {
        assertThrows(NullPointerException.class,
                () -> new FeatureManager(null, CapabilitySet.unverified()));
        assertThrows(NullPointerException.class,
                () -> new FeatureManager(ModulePreferences.Snapshot.defaults(), null));

        FeatureManager manager = new FeatureManager(
                ModulePreferences.Snapshot.defaults(), CapabilitySet.unverified());
        assertThrows(NullPointerException.class, () -> manager.status(null));
        assertThrows(NullPointerException.class, () -> manager.isEnabled(null));
    }

    private static void assertStatus(FeatureManager manager, FeatureManager.Feature feature,
                                     FeatureManager.Status expected) {
        assertEquals(expected, manager.status(feature));
        if (expected == FeatureManager.Status.ENABLED) {
            assertTrue(manager.isEnabled(feature));
        } else {
            assertFalse(manager.isEnabled(feature));
        }
    }

    private static FeatureManager.Status expected(boolean preferred,
                                                  CapabilitySet.State capability) {
        if (!preferred) {
            return FeatureManager.Status.DISABLED_BY_USER;
        }
        switch (capability) {
            case READY:
                return FeatureManager.Status.ENABLED;
            case MISSING:
                return FeatureManager.Status.DISABLED_CAPABILITY_MISSING;
            case AMBIGUOUS:
                return FeatureManager.Status.DISABLED_AMBIGUOUS;
            case UNVERIFIED:
                return FeatureManager.Status.UNVERIFIED;
            default:
                throw new AssertionError("Unhandled capability: " + capability);
        }
    }
}
