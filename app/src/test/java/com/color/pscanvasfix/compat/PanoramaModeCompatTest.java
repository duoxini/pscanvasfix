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
