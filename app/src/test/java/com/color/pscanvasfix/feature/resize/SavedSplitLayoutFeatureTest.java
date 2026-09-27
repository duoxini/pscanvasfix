package com.color.pscanvasfix.feature.resize;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public final class SavedSplitLayoutFeatureTest {
    @Test
    public void validatesOnlyFiniteInteriorRatios() {
        assertTrue(SavedSplitLayoutFeature.isValidTwoTaskRatio(0.5f));
        assertFalse(SavedSplitLayoutFeature.isValidTwoTaskRatio(0.0f));
        assertFalse(SavedSplitLayoutFeature.isValidTwoTaskRatio(1.0f));
        assertFalse(SavedSplitLayoutFeature.isValidTwoTaskRatio(Float.NaN));
        assertFalse(SavedSplitLayoutFeature.isValidTwoTaskRatio(Float.POSITIVE_INFINITY));
    }

    @Test
    public void fingerprintPreservesSlotAndUserOrder() {
        assertEquals("a.pkg:0|b.pkg:999", SavedSplitLayoutFeature.fingerprint(
                new String[]{"a.pkg", "b.pkg"}, new int[]{0, 999}));
        assertEquals("b.pkg:999|a.pkg:0", SavedSplitLayoutFeature.fingerprint(
                new String[]{"b.pkg", "a.pkg"}, new int[]{999, 0}));
    }

    @Test
    public void fingerprintRejectsIncompleteInputs() {
        assertNull(SavedSplitLayoutFeature.fingerprint(null, new int[]{0}));
        assertNull(SavedSplitLayoutFeature.fingerprint(
                new String[]{"a.pkg"}, new int[]{0, 1}));
        assertNull(SavedSplitLayoutFeature.fingerprint(
                new String[]{""}, new int[]{0}));
    }

    @Test
    public void codecAcceptsThreeTaskUpdateMarker() {
        SavedSplitLayoutCodec.Layout layout = new SavedSplitLayoutCodec.Layout(
                3, 3, new int[]{3333, 6666}, "a.pkg:0|b.pkg:0|c.pkg:0");
        assertEquals(layout, SavedSplitLayoutCodec.decode(
                SavedSplitLayoutCodec.encode(layout)).orElse(null));
    }

    @Test
    public void shortcutIdMatchesOemUserZeroFormat() {
        assertEquals("a.pkg|b.pkg:999|c.pkg", SavedSplitLayoutFeature.shortcutId(
                new String[]{"a.pkg", "b.pkg", "c.pkg"}, new int[]{0, 999, 0}));
    }

    @Test
    public void shortcutMemberComparisonAllowsThreeTaskReorderOnly() {
        assertTrue(SavedSplitLayoutFeature.sameShortcutMembers(
                "a.pkg|b.pkg|c.pkg", "a.pkg|c.pkg|b.pkg"));
        assertFalse(SavedSplitLayoutFeature.sameShortcutMembers(
                "a.pkg|b.pkg|c.pkg", "a.pkg|b.pkg|d.pkg"));
        assertFalse(SavedSplitLayoutFeature.sameShortcutMembers(
                "a.pkg|a.pkg|b.pkg", "a.pkg|b.pkg|b.pkg"));
    }

    @Test
    public void newLaunchClearsShortcutStateButConfigurationRecreatePreservesIt() {
        assertTrue(SavedSplitLayoutFeature.shouldResetShortcutState(
                SavedSplitLayoutFeature.ActivityLifecycleEvent.ON_CREATE, null));
        assertFalse(SavedSplitLayoutFeature.shouldResetShortcutState(
                SavedSplitLayoutFeature.ActivityLifecycleEvent.ON_CREATE, new Object()));
    }

    @Test
    public void newIntentAlwaysClearsPreviousShortcutState() {
        assertTrue(SavedSplitLayoutFeature.shouldResetShortcutState(
                SavedSplitLayoutFeature.ActivityLifecycleEvent.ON_NEW_INTENT, null));
        assertTrue(SavedSplitLayoutFeature.shouldResetShortcutState(
                SavedSplitLayoutFeature.ActivityLifecycleEvent.ON_NEW_INTENT, new Object()));
    }

    @Test
    public void updateRecordsIdOnlyWhenUpdateSucceeds() {
        assertEquals(Boolean.TRUE, SavedSplitLayoutFeature.forcedRequestPinResult(
                SavedSplitLayoutFeature.ShortcutWritePath.UPDATE, true));
        assertEquals(Boolean.FALSE, SavedSplitLayoutFeature.forcedRequestPinResult(
                SavedSplitLayoutFeature.ShortcutWritePath.UPDATE, false));
        assertTrue(SavedSplitLayoutFeature.shouldRecordShortcutId(
                SavedSplitLayoutFeature.ShortcutWritePath.UPDATE, true));
        assertFalse(SavedSplitLayoutFeature.shouldRecordShortcutId(
                SavedSplitLayoutFeature.ShortcutWritePath.UPDATE, false));
        assertTrue(SavedSplitLayoutFeature.shouldShowSavedToast(
                SavedSplitLayoutFeature.ShortcutWritePath.UPDATE, true));
        assertFalse(SavedSplitLayoutFeature.shouldShowSavedToast(
                SavedSplitLayoutFeature.ShortcutWritePath.UPDATE, false));
    }

    @Test
    public void firstPinRecordsIdOnlyWhenOriginalRequestIsAccepted() {
        assertNull(SavedSplitLayoutFeature.forcedRequestPinResult(
                SavedSplitLayoutFeature.ShortcutWritePath.PIN, true));
        assertTrue(SavedSplitLayoutFeature.shouldRecordShortcutId(
                SavedSplitLayoutFeature.ShortcutWritePath.PIN, true));
        assertFalse(SavedSplitLayoutFeature.shouldRecordShortcutId(
                SavedSplitLayoutFeature.ShortcutWritePath.PIN, false));
        assertFalse(SavedSplitLayoutFeature.shouldRecordShortcutId(
                SavedSplitLayoutFeature.ShortcutWritePath.PIN, null));
        assertFalse(SavedSplitLayoutFeature.shouldShowSavedToast(
                SavedSplitLayoutFeature.ShortcutWritePath.PIN, true));
    }
}
