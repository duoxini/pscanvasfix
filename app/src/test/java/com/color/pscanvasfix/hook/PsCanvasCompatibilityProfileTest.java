package com.color.pscanvasfix.hook;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public final class PsCanvasCompatibilityProfileTest {
    private static final String SHA_260608 =
            "1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3";

    @Test
    public void selectsKnown260608ProfileAndRejectsUnknownApk() {
        PsCanvasCompatibilityProfile profile = PsCanvasCompatibilityProfile.find(SHA_260608);

        assertEquals("260608", profile.id());
        assertNull(PsCanvasCompatibilityProfile.find("deadbeef"));
    }

    @Test
    public void exposesVerified260608RoleAndMethodMappings() {
        PsCanvasCompatibilityProfile profile = PsCanvasCompatibilityProfile.find(SHA_260608);

        assertEquals("x1.x", profile.sstoFlexibleClass());
        assertEquals("t0", profile.scaleMethod());
        assertEquals("I", profile.intentListMethod());
        assertEquals("H", profile.launchBoundsMethod());
        assertEquals("Z", profile.maskAnimationMethod());
        assertEquals("x1.D", profile.threeSplitAnimClass());
        assertEquals("x1.E", profile.threeSplitDragClass());
        assertEquals("com.oplus.pscanvas.canvasmode.canvas.s0", profile.canvasControllerClass());
    }

    @Test
    public void fingerprintsApkContentWithSha256() throws Exception {
        File apk = File.createTempFile("pscanvas", ".apk");
        try (FileOutputStream output = new FileOutputStream(apk)) {
            output.write("abc".getBytes("UTF-8"));
        }

        assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
                ApkFingerprint.sha256(apk.getAbsolutePath()));
        assertNull(ApkFingerprint.sha256(null));
        apk.delete();
    }
}
