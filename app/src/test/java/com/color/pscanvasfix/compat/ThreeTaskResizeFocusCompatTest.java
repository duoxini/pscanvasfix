package com.color.pscanvasfix.compat;

import org.junit.Test;

import static com.color.pscanvasfix.compat.ThreeTaskResizeFocusCompat.adjacentFocus;
import static com.color.pscanvasfix.compat.ThreeTaskResizeFocusCompat.mainDividerThreshold;
import static org.junit.Assert.assertEquals;

public final class ThreeTaskResizeFocusCompatTest {
    @Test
    public void shortDividerUsesTheTaskInTheDragDirection() {
        assertEquals(1, adjacentFocus(4, true, 0, -80, 80));
        assertEquals(2, adjacentFocus(4, true, 0, 80, -80));
        assertEquals(0, adjacentFocus(5, true, 2, -80, 80));
        assertEquals(1, adjacentFocus(5, true, 2, 80, -80));
        assertEquals(1, adjacentFocus(6, false, 0, 80, -80));
        assertEquals(2, adjacentFocus(6, false, 0, -80, 80));
        assertEquals(0, adjacentFocus(7, false, 2, 80, -80));
        assertEquals(1, adjacentFocus(7, false, 2, -80, 80));
    }

    @Test
    public void leavesTheMainDividerAndExistingAdjacentFocusToTheSystem() {
        assertEquals(-1, adjacentFocus(6, true, 0, 80, 80));
        assertEquals(-1, adjacentFocus(4, false, 0, 80, 80));
        assertEquals(-1, adjacentFocus(3, true, 0, 80, 80));
        assertEquals(-1, adjacentFocus(6, false, 1, 80, 80));
        assertEquals(-1, adjacentFocus(7, false, -1, 80, 80));
        assertEquals(-1, adjacentFocus(5, true, 2, 0, 80));
        assertEquals(-1, adjacentFocus(6, false, 0, 80, Float.NaN));
    }

    @Test
    public void rebasesTheDistantMainDividerThresholdInEitherDirection() {
        assertEquals(420f, mainDividerThreshold(1200f, new int[]{6, 5}, 180, 2400), 0f);
        assertEquals(1980f, mainDividerThreshold(1200f, new int[]{3, 6}, 2220, 2400), 0f);
    }

    @Test
    public void preservesReachableThresholdsAndOtherOemActions() {
        assertEquals(1200f, mainDividerThreshold(1200f, new int[]{6, 5}, 900, 2400), 0f);
        assertEquals(1200f, mainDividerThreshold(1200f, new int[]{3, 6}, 180, 2400), 0f);
        assertEquals(1200f, mainDividerThreshold(1200f, new int[]{6, 6}, 180, 2400), 0f);
        assertEquals(1200f, mainDividerThreshold(1200f, new int[]{0, 5}, 180, 2400), 0f);
        assertEquals(1200f, mainDividerThreshold(1200f, new int[]{6, 5}, -20, 2400), 0f);
    }
}
