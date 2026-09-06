package com.color.pscanvasfix.compat;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class PanoramaModeCompatTest {

    @Test
    public void keepsNativeThreeColumnLayoutFor502Canvas() {
        assertEquals(3, PanoramaModeCompat.to502CanvasLayout(3, 3));
        assertEquals(3, PanoramaModeCompat.to502CanvasLayout(2, 3));
        assertEquals(5, PanoramaModeCompat.to502CanvasLayout(3, 5));
    }

    @Test
    public void uses502PortraitColumnAspectRatio() {
        assertEquals(800, PanoramaModeCompat.equalColumnWidth(1200));
        assertEquals(1, PanoramaModeCompat.equalColumnWidth(1));
    }

    /**
     * Landscape three-split uses portrait columns (1113x2400): the 502
     * equal-width replacement applies. Portrait-device three-split uses
     * landscape rows (2400x1685) stacked vertically: OEM slots must be
     * kept, otherwise the 1123-wide replacement letterboxes the task
     * surfaces (2400x1685) and the apps fail to fill the window.
     */
    @Test
    public void keepsOemLandscapeRowBoundsUntouched() {
        // Landscape device: 1113 wide x 2400 tall portrait columns -> normalize.
        assertTrue(PanoramaModeCompat.isPortraitColumn(1113, 2400));
        assertTrue(PanoramaModeCompat.isPortraitColumn(1600, 2400));
        assertTrue(PanoramaModeCompat.isPortraitColumn(1685, 2400));
        // Portrait device: 2400 wide x 1685 tall landscape rows -> keep OEM.
        assertFalse(PanoramaModeCompat.isPortraitColumn(2400, 1685));
        assertFalse(PanoramaModeCompat.isPortraitColumn(2400, 1200));
        // Square edge case: rows win (keep OEM).
        assertFalse(PanoramaModeCompat.isPortraitColumn(1685, 1685));
    }

    @Test
    public void entersOnlyForThreeAppsInPanoramaLayoutRange() {
        assertTrue(PanoramaModeCompat.shouldEnterFromPinch(3, 3));
        assertTrue(PanoramaModeCompat.shouldEnterFromPinch(3, 4));
        assertTrue(PanoramaModeCompat.shouldEnterFromPinch(3, 7));

        assertFalse(PanoramaModeCompat.shouldEnterFromPinch(2, 4));
        assertFalse(PanoramaModeCompat.shouldEnterFromPinch(4, 4));
        assertFalse(PanoramaModeCompat.shouldEnterFromPinch(3, 8));
    }
}
