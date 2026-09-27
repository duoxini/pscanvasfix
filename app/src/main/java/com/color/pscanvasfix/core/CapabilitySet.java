package com.color.pscanvasfix.core;

import java.util.Objects;

/** Capability evidence for user-configurable features that are not implemented yet. */
public final class CapabilitySet {
    public enum State {
        READY,
        MISSING,
        AMBIGUOUS,
        UNVERIFIED
    }

    private static final CapabilitySet UNVERIFIED = new CapabilitySet(
            State.UNVERIFIED, State.UNVERIFIED);

    private final State adjustableWindowSize;
    private final State fourTaskCanvas;

    private CapabilitySet(State adjustableWindowSize, State fourTaskCanvas) {
        this.adjustableWindowSize = Objects.requireNonNull(
                adjustableWindowSize, "adjustableWindowSize");
        this.fourTaskCanvas = Objects.requireNonNull(fourTaskCanvas, "fourTaskCanvas");
    }

    public static CapabilitySet of(State adjustableWindowSize, State fourTaskCanvas) {
        if (adjustableWindowSize == State.UNVERIFIED
                && fourTaskCanvas == State.UNVERIFIED) {
            return UNVERIFIED;
        }
        return new CapabilitySet(adjustableWindowSize, fourTaskCanvas);
    }

    public static CapabilitySet unverified() {
        return UNVERIFIED;
    }

    public State adjustableWindowSize() {
        return adjustableWindowSize;
    }

    public State fourTaskCanvas() {
        return fourTaskCanvas;
    }
}
