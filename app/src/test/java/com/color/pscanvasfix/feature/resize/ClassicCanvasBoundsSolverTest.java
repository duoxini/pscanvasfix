package com.color.pscanvasfix.feature.resize;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.color.pscanvasfix.feature.resize.ClassicCanvasBoundsSolver.Axis.HORIZONTAL;
import static com.color.pscanvasfix.feature.resize.ClassicCanvasBoundsSolver.Axis.VERTICAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public final class ClassicCanvasBoundsSolverTest {

    @Test
    public void movesOnlySelectedHorizontalPairAndPreservesGapAndOuterSpan() {
        List<ClassicCanvasBoundsSolver.Bounds> before = Arrays.asList(
                bounds(0, 0, 300, 500),
                bounds(320, 0, 620, 500),
                bounds(640, 0, 940, 500));

        List<ClassicCanvasBoundsSolver.Bounds> after =
                ClassicCanvasBoundsSolver.resizeAdjacent(before, 0, 80, 120, HORIZONTAL);

        assertEquals(bounds(0, 0, 380, 500), after.get(0));
        assertEquals(bounds(400, 0, 620, 500), after.get(1));
        assertEquals(before.get(2), after.get(2));
        assertEquals(20, after.get(1).left - after.get(0).right);
        assertEquals(before.get(0).left, after.get(0).left);
        assertEquals(before.get(1).right, after.get(1).right);
    }

    @Test
    public void clampsExtremeDeltaToBothMinimumWidths() {
        List<ClassicCanvasBoundsSolver.Bounds> before = Arrays.asList(
                bounds(0, 0, 400, 500),
                bounds(410, 0, 810, 500),
                bounds(820, 0, 1220, 500));

        List<ClassicCanvasBoundsSolver.Bounds> growLeft =
                ClassicCanvasBoundsSolver.resizeAdjacent(before, 0, 10_000, 150, HORIZONTAL);
        assertEquals(650, growLeft.get(0).width());
        assertEquals(150, growLeft.get(1).width());

        List<ClassicCanvasBoundsSolver.Bounds> growRight =
                ClassicCanvasBoundsSolver.resizeAdjacent(before, 1, -10_000, 150, HORIZONTAL);
        assertEquals(150, growRight.get(1).width());
        assertEquals(650, growRight.get(2).width());
    }

    @Test
    public void supportsVerticalAdjacentSlots() {
        List<ClassicCanvasBoundsSolver.Bounds> before = Arrays.asList(
                bounds(0, 0, 500, 300),
                bounds(0, 320, 500, 620));

        List<ClassicCanvasBoundsSolver.Bounds> after =
                ClassicCanvasBoundsSolver.resizeAdjacent(before, 0, -60, 100, VERTICAL);

        assertEquals(bounds(0, 0, 500, 240), after.get(0));
        assertEquals(bounds(0, 260, 500, 620), after.get(1));
    }

    @Test
    public void rejectsInvalidDividerOrOverlappingSlots() {
        List<ClassicCanvasBoundsSolver.Bounds> valid = Arrays.asList(
                bounds(0, 0, 300, 500), bounds(320, 0, 620, 500));
        assertThrows(IllegalArgumentException.class,
                () -> ClassicCanvasBoundsSolver.resizeAdjacent(valid, 1, 0, 100, HORIZONTAL));

        List<ClassicCanvasBoundsSolver.Bounds> overlapping = Arrays.asList(
                bounds(0, 0, 350, 500), bounds(320, 0, 620, 500));
        assertThrows(IllegalArgumentException.class,
                () -> ClassicCanvasBoundsSolver.resizeAdjacent(
                        overlapping, 0, 0, 100, HORIZONTAL));
    }

    private static ClassicCanvasBoundsSolver.Bounds bounds(
            int left, int top, int right, int bottom) {
        return new ClassicCanvasBoundsSolver.Bounds(left, top, right, bottom);
    }
}
