package com.color.pscanvasfix.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

public final class CapabilitySetTest {
    @Test
    public void preservesEveryCapabilityStateIndependently() {
        for (CapabilitySet.State adjustable : CapabilitySet.State.values()) {
            for (CapabilitySet.State fourTask : CapabilitySet.State.values()) {
                CapabilitySet capabilities = CapabilitySet.of(adjustable, fourTask);

                assertEquals(adjustable, capabilities.adjustableWindowSize());
                assertEquals(fourTask, capabilities.fourTaskCanvas());
            }
        }
    }

    @Test
    public void defaultSetIsHonestlyUnverified() {
        CapabilitySet capabilities = CapabilitySet.unverified();

        assertEquals(CapabilitySet.State.UNVERIFIED,
                capabilities.adjustableWindowSize());
        assertEquals(CapabilitySet.State.UNVERIFIED, capabilities.fourTaskCanvas());
        assertSame(capabilities, CapabilitySet.of(
                CapabilitySet.State.UNVERIFIED, CapabilitySet.State.UNVERIFIED));
    }

    @Test
    public void rejectsMissingCapabilityEvidence() {
        assertThrows(NullPointerException.class,
                () -> CapabilitySet.of(null, CapabilitySet.State.READY));
        assertThrows(NullPointerException.class,
                () -> CapabilitySet.of(CapabilitySet.State.READY, null));
    }
}
