package com.color.pscanvasfix.feature.resize;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public final class SavedSplitLayoutCodecTest {

    @Test
    public void roundTripsTwoTaskRatioAndUnicodeSlotFingerprint() {
        SavedSplitLayoutCodec.Layout source = new SavedSplitLayoutCodec.Layout(
                2, 1, new int[]{3750}, "用户0:浏览器|用户0:笔记");

        Optional<SavedSplitLayoutCodec.Layout> decoded =
                SavedSplitLayoutCodec.decode(SavedSplitLayoutCodec.encode(source));

        assertTrue(decoded.isPresent());
        assertEquals(source, decoded.get());
        assertArrayEquals(new int[]{3750}, decoded.get().dividerRatios());
    }

    @Test
    public void roundTripsThreeTaskDividerPositions() {
        SavedSplitLayoutCodec.Layout source = new SavedSplitLayoutCodec.Layout(
                3, 3, new int[]{2800, 6900}, "a:0|b:0|c:999");

        assertEquals(source,
                SavedSplitLayoutCodec.decode(SavedSplitLayoutCodec.encode(source)).get());
    }

    @Test
    public void rejectsUnknownVersionMalformedPayloadAndInvalidRatios() {
        assertFalse(SavedSplitLayoutCodec.decode(
                "pscanvas-layout;2;2;1;5000;YQ").isPresent());
        assertFalse(SavedSplitLayoutCodec.decode("not-a-layout").isPresent());
        assertFalse(SavedSplitLayoutCodec.decode(
                "pscanvas-layout;1;3;1;7000,6000;YQ").isPresent());

        assertThrows(IllegalArgumentException.class,
                () -> new SavedSplitLayoutCodec.Layout(3, 1,
                        new int[]{5000}, "a|b|c"));
        assertThrows(IllegalArgumentException.class,
                () -> new SavedSplitLayoutCodec.Layout(2, 1,
                        new int[]{10_000}, "a|b"));
    }

    @Test
    public void layoutDefensivelyCopiesDividerArray() {
        int[] ratios = {4200};
        SavedSplitLayoutCodec.Layout layout = new SavedSplitLayoutCodec.Layout(
                2, 0, ratios, "a|b");
        ratios[0] = 9000;

        assertArrayEquals(new int[]{4200}, layout.dividerRatios());
    }
}
