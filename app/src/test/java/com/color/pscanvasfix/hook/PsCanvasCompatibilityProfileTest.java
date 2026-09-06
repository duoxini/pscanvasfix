package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;

import org.junit.Assume;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Offline Resolver verification over the four archived target APKs.
 *
 * <p>The scan/scoring core is pure JDK ({@link DexClassScanner}/{@link
 * PsCanvasSymbolResolver}/{@link CapabilityReport}), so this runs as a plain JVM
 * unit test without an emulator.</p>
 *
 * <p>Runtime:</p>
 * <pre>
 *   gradlew test --tests com.color.pscanvasfix.hook.PsCanvasCompatibilityProfileTest \
 *       -Dpscanvas.apk.dir="E:\...\file"     (dir containing 多窗口(251215).apk ...)
 * </pre>
 *
 * <p>If the property is absent, the APK-dependent tests are skipped (they are
 * non-fatal so a bare {@code gradlew test} still passes before the archive is
 * plugged in). The diagnostics-only tests always run.</p>
 */
public final class PsCanvasCompatibilityProfileTest {

    // Expected role mapping per generation:
    //   sstoFlexible / anim / drag / canvasController.
    // 251215 (old 502 baseline) has NO x1.* classes: structural scoring finds no
    // reliable SSTO_FLEXIBLE symbol (verified against the real APK), so the role
    // group is expected to be SKIPPED. 260403 is structurally resolvable and
    // maps to the same known symbols as 251215 was assumed to use.
    private static final String[][] EXPECTED = {
            {"251215", null, null, null, null},
            {"260403", "x1.r", "x1.x", "x1.y", "com.oplus.pscanvas.canvasmode.canvas.r0"},
            {"260512", "x1.x", "x1.D", "x1.E", "com.oplus.pscanvas.canvasmode.canvas.s0"},
            {"260608", "x1.x", "x1.D", "x1.E", "com.oplus.pscanvas.canvasmode.canvas.s0"},
    };

    // ------------------------------------------------------------------
    // Always-on diagnostics tests
    // ------------------------------------------------------------------

    @Test
    public void knownProfileLookupIsDiagnosticOnly() {
        assertEquals("260608", PsCanvasCompatibilityProfile.find(
                PsCanvasCompatibilityProfile.SHA_260608).id());
        assertNull(PsCanvasCompatibilityProfile.find("deadbeef"));
        assertNull(PsCanvasCompatibilityProfile.find(null));
        assertTrue("profile is now only a fallback hint, never a gate",
                PsCanvasCompatibilityProfile.FALLBACK);
    }

    @Test
    public void knownClassNamesCoverBothGenerations() {
        assertTrue(PsCanvasCompatibilityProfile.knownClassNames(Role.SSTO_FLEXIBLE)
                .contains("x1.r"));
        assertTrue(PsCanvasCompatibilityProfile.knownClassNames(Role.SSTO_FLEXIBLE)
                .contains("x1.x"));
        assertTrue(PsCanvasCompatibilityProfile.knownClassNames(Role.CANVAS_CONTROLLER)
                .contains("com.oplus.pscanvas.canvasmode.canvas.r0"));
        assertTrue(PsCanvasCompatibilityProfile.knownClassNames(Role.CANVAS_CONTROLLER)
                .contains("com.oplus.pscanvas.canvasmode.canvas.s0"));
    }

    @Test
    public void fingerprintsApkContentWithSha256() throws Exception {
        File apk = File.createTempFile("pscanvas", ".apk");
        try (java.io.FileOutputStream output = new java.io.FileOutputStream(apk)) {
            output.write("abc".getBytes("UTF-8"));
        }
        assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
                ApkFingerprint.sha256(apk.getAbsolutePath()));
        assertNull(ApkFingerprint.sha256(null));
        apk.delete();
    }

    // ------------------------------------------------------------------
    // Offline Resolver verification (needs the APK archive)
    // ------------------------------------------------------------------

    @Test
    public void resolvesRolesAcrossFourGenerations() {
        String dir = directory();
        Assume.assumeTrue("Set -Dpscanvas.apk.dir=<dir with the 4 apks> to run",
                !dir.isEmpty());

        boolean any = false;
        for (String[] expected : EXPECTED) {
            File apk = findApk(new File(dir), expected[0]);
            if (apk == null) {
                System.out.println("PsCanvasFix-test: missing APK for tag " + expected[0]);
                continue;
            }
            any = true;
            List<DexClass> dex = DexClassScanner.scanApk(apk);
            PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(dex);
            String report = CapabilityReport.render(
                    ApkFingerprint.collect(apk.getAbsolutePath()), dex.size(), symbols);
            System.out.println("\n" + report);

            if (expected[1] == null) {
                // Old-generation APK: no reliable symbol -> the group must be
                // skipped rather than installed onto an unverified guess.
                assertFalse("sstoFlexible must be SKIPPED for " + expected[0],
                        symbols.role(Role.SSTO_FLEXIBLE).available());
                continue;
            }
            assertEquals("sstoFlexible for " + expected[0],
                    expected[1],
                    symbols.role(Role.SSTO_FLEXIBLE).className);
            assertEquals("threeSplitAnim for " + expected[0],
                    expected[2],
                    symbols.role(Role.THREE_SPLIT_ANIM).className);
            assertEquals("threeSplitDrag for " + expected[0],
                    expected[3],
                    symbols.role(Role.THREE_SPLIT_DRAG).className);
            assertEquals("canvasController for " + expected[0],
                    expected[4],
                    symbols.role(Role.CANVAS_CONTROLLER).className);
            assertNotNull("sstoFlexible must be available (READY or fallback) for "
                    + expected[0], symbols.role(Role.SSTO_FLEXIBLE).className);
        }
        Assume.assumeTrue("no APK found under " + dir, any);
    }

    /** Exercise the resolver on the 260608 APK and check candidate/status sanity. */
    @Test
    public void resolverReportsStructuredCapabilities() {
        String dir = directory();
        Assume.assumeTrue("Set -Dpscanvas.apk.dir=<dir with the 4 apks> to run",
                !dir.isEmpty());
        File apk = findApk(new File(dir), "260608");
        Assume.assumeNotNull("missing 260608 APK", apk);

        List<DexClass> dex = DexClassScanner.scanApk(apk);
        PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(dex);
        RoleSymbol ssto = symbols.role(Role.SSTO_FLEXIBLE);
        assertTrue("sstoFlexible must be usable on 260608", ssto.available());
        assertEquals("x1.x", ssto.className);

        String report = CapabilityReport.render(
                ApkFingerprint.collect(apk.getAbsolutePath()), dex.size(), symbols);
        assertTrue(report.contains("capability report"));
        assertTrue(report.contains("sstoFlexible=ENABLED"));
        System.out.println("\n" + report);
    }

    private static String directory() {
        String dir = System.getProperty("pscanvas.apk.dir");
        if (dir == null || dir.trim().isEmpty()) {
            dir = System.getenv("PSCANVAS_APK_DIR");
        }
        return dir == null ? "" : dir.trim();
    }

    private static File findApk(File dir, String tag) {
        File[] files = dir.listFiles();
        if (files == null) {
            return null;
        }
        for (File file : files) {
            if (file.isFile() && file.getName().contains(tag)) {
                return file;
            }
        }
        return null;
    }
}
