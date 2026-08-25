package com.color.pscanvasfix.hook;

import java.util.Locale;

/** Immutable, verified symbol map for one PsCanvas APK build. */
public final class PsCanvasCompatibilityProfile {
    public static final String SHA_260608 =
            "1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3";

    private static final PsCanvasCompatibilityProfile PROFILE_260608 =
            new PsCanvasCompatibilityProfile(
                    "260608",
                    SHA_260608,
                    "x1.x",
                    "x1.D",
                    "x1.E",
                    "com.oplus.pscanvas.canvasmode.canvas.s0",
                    "t0",
                    "I",
                    "H",
                    "Z");

    private final String id;
    private final String sha256;
    private final String sstoFlexibleClass;
    private final String threeSplitAnimClass;
    private final String threeSplitDragClass;
    private final String canvasControllerClass;
    private final String scaleMethod;
    private final String intentListMethod;
    private final String launchBoundsMethod;
    private final String maskAnimationMethod;

    private PsCanvasCompatibilityProfile(String id, String sha256, String sstoFlexibleClass,
                                         String threeSplitAnimClass, String threeSplitDragClass,
                                         String canvasControllerClass, String scaleMethod,
                                         String intentListMethod, String launchBoundsMethod,
                                         String maskAnimationMethod) {
        this.id = id;
        this.sha256 = sha256;
        this.sstoFlexibleClass = sstoFlexibleClass;
        this.threeSplitAnimClass = threeSplitAnimClass;
        this.threeSplitDragClass = threeSplitDragClass;
        this.canvasControllerClass = canvasControllerClass;
        this.scaleMethod = scaleMethod;
        this.intentListMethod = intentListMethod;
        this.launchBoundsMethod = launchBoundsMethod;
        this.maskAnimationMethod = maskAnimationMethod;
    }

    public static PsCanvasCompatibilityProfile find(String sha256) {
        if (sha256 == null) {
            return null;
        }
        return PROFILE_260608.sha256.equals(sha256.toLowerCase(Locale.ROOT))
                ? PROFILE_260608 : null;
    }

    public String id() { return id; }
    public String sha256() { return sha256; }
    public String sstoFlexibleClass() { return sstoFlexibleClass; }
    public String threeSplitAnimClass() { return threeSplitAnimClass; }
    public String threeSplitDragClass() { return threeSplitDragClass; }
    public String canvasControllerClass() { return canvasControllerClass; }
    public String scaleMethod() { return scaleMethod; }
    public String intentListMethod() { return intentListMethod; }
    public String launchBoundsMethod() { return launchBoundsMethod; }
    public String maskAnimationMethod() { return maskAnimationMethod; }
}
