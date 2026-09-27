package com.color.pscanvasfix.feature.resize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Pure adjacent-slot geometry for the one-dimensional Classic Canvas. */
public final class ClassicCanvasBoundsSolver {
    private ClassicCanvasBoundsSolver() {
    }

    public enum Axis {
        HORIZONTAL,
        VERTICAL
    }

    /** Immutable platform-independent bounds used by JVM tests and the future Android adapter. */
    public static final class Bounds {
        public final int left;
        public final int top;
        public final int right;
        public final int bottom;

        public Bounds(int left, int top, int right, int bottom) {
            if (right <= left || bottom <= top) {
                throw new IllegalArgumentException("Bounds must have positive width and height");
            }
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public int width() {
            return right - left;
        }

        public int height() {
            return bottom - top;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bounds)) {
                return false;
            }
            Bounds that = (Bounds) other;
            return left == that.left && top == that.top
                    && right == that.right && bottom == that.bottom;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, top, right, bottom);
        }

        @Override
        public String toString() {
            return "Bounds{" + left + ',' + top + ',' + right + ',' + bottom + '}';
        }
    }

    /**
     * Moves one divider while preserving the gap between its two adjacent slots and every
     * non-adjacent slot. Oversized deltas are clamped so both affected slots retain minSize.
     */
    public static List<Bounds> resizeAdjacent(List<Bounds> current,
                                               int dividerIndex,
                                               int delta,
                                               int minSize,
                                               Axis axis) {
        Objects.requireNonNull(current, "current");
        Objects.requireNonNull(axis, "axis");
        if (current.size() < 2) {
            throw new IllegalArgumentException("At least two slots are required");
        }
        if (dividerIndex < 0 || dividerIndex >= current.size() - 1) {
            throw new IllegalArgumentException("Invalid divider index: " + dividerIndex);
        }
        if (minSize <= 0) {
            throw new IllegalArgumentException("minSize must be positive");
        }

        Bounds first = Objects.requireNonNull(current.get(dividerIndex), "left/top slot");
        Bounds second = Objects.requireNonNull(current.get(dividerIndex + 1), "right/bottom slot");
        int firstSize = axis == Axis.HORIZONTAL ? first.width() : first.height();
        int secondSize = axis == Axis.HORIZONTAL ? second.width() : second.height();
        if (firstSize < minSize || secondSize < minSize) {
            throw new IllegalArgumentException("Current adjacent slots violate minSize");
        }
        if (axis == Axis.HORIZONTAL && first.right > second.left) {
            throw new IllegalArgumentException("Horizontal slots overlap or are unordered");
        }
        if (axis == Axis.VERTICAL && first.bottom > second.top) {
            throw new IllegalArgumentException("Vertical slots overlap or are unordered");
        }

        long minimumDelta = (long) minSize - firstSize;
        long maximumDelta = (long) secondSize - minSize;
        int appliedDelta = (int) Math.max(minimumDelta, Math.min(maximumDelta, (long) delta));

        Bounds resizedFirst;
        Bounds resizedSecond;
        if (axis == Axis.HORIZONTAL) {
            resizedFirst = new Bounds(first.left, first.top,
                    Math.addExact(first.right, appliedDelta), first.bottom);
            resizedSecond = new Bounds(Math.addExact(second.left, appliedDelta), second.top,
                    second.right, second.bottom);
        } else {
            resizedFirst = new Bounds(first.left, first.top, first.right,
                    Math.addExact(first.bottom, appliedDelta));
            resizedSecond = new Bounds(second.left, Math.addExact(second.top, appliedDelta),
                    second.right, second.bottom);
        }

        ArrayList<Bounds> result = new ArrayList<>(current);
        result.set(dividerIndex, resizedFirst);
        result.set(dividerIndex + 1, resizedSecond);
        return Collections.unmodifiableList(result);
    }
}
