package com.color.pscanvasfix.hook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Known-symbol data source.
 *
 * <p>It is <em>no longer</em> the compatibility gate. The SHA-256 check was a
 * single-build whitelist that hard-killed the whole module for every other build.
 * The install path now resolves roles structurally (see
 * {@link PsCanvasSymbolResolver}) and only consults this table as a
 * cross-generation fallback for the roles whose signatures are not unique.</p>
 *
 * <p>{@code fallback=true} / {@code source=KNOWN_SYMBOL} must be logged whenever
 * a capability was resolved from here rather than structurally.</p>
 */
public final class PsCanvasCompatibilityProfile {
    public static final String SHA_260608 =
            "1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3";

    /** This profile is only a hint source; structural resolution is authoritative. */
    public static final boolean FALLBACK = true;

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

    // Cross-generation known-symbol candidate names. Order matters: earlier names
    // are preferred, and the resolver skips names already claimed by another role.
    private static final List<String> KNOWN_SSTO_FLEXIBLE =
            Arrays.asList("x1.r", "x1.x");
    private static final List<String> KNOWN_THREE_SPLIT_ANIM =
            Arrays.asList("x1.x", "x1.D");
    private static final List<String> KNOWN_THREE_SPLIT_DRAG =
            Arrays.asList("x1.y", "x1.E");
    private static final List<String> KNOWN_CANVAS_CONTROLLER =
            Arrays.asList(
                    "com.oplus.pscanvas.canvasmode.canvas.r0",
                    "com.oplus.pscanvas.canvasmode.canvas.s0");

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

    /**
     * Legacy lookup, kept only for diagnostics / bug reports. Returning {@code null}
     * here must <strong>never</strong> disable the module; install() no longer gates
     * on it.
     */
    public static PsCanvasCompatibilityProfile find(String sha256) {
        if (sha256 == null) {
            return null;
        }
        return PROFILE_260608.sha256.equals(sha256.toLowerCase(Locale.ROOT))
                ? PROFILE_260608 : null;
    }

    /** Cross-generation known-symbol candidate class names for one role. */
    public static List<String> knownClassNames(PsCanvasSymbols.Role role) {
        switch (role) {
            case SSTO_FLEXIBLE:
                return KNOWN_SSTO_FLEXIBLE;
            case THREE_SPLIT_ANIM:
                return KNOWN_THREE_SPLIT_ANIM;
            case THREE_SPLIT_DRAG:
                return KNOWN_THREE_SPLIT_DRAG;
            case CANVAS_CONTROLLER:
                return KNOWN_CANVAS_CONTROLLER;
            default:
                return Collections.emptyList();
        }
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
