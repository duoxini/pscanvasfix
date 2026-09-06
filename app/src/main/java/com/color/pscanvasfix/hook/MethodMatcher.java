package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexField;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;

import java.util.List;

/**
 * Stable-signature matching on top of {@link DexMethod}/{@link DexField}.
 *
 * <p>Class names and short method names are obfuscated and change every build, so
 * these matchers ignore names entirely and compare the parameter / return type
 * descriptors read from the DEX. The only place the (unstable) method name is
 * kept is as a *hint* for the caller; the authoritative identity is the
 * signature.</p>
 */
public final class MethodMatcher {

    // DEX type descriptors (note the '/', ';', '[' conventions).
    public static final String DESC_SCALE_DETECTOR = "Landroid/view/ScaleGestureDetector;";
    public static final String DESC_INT = "I";
    public static final String DESC_LIST = "Ljava/util/List;";
    public static final String DESC_INT_ARRAY = "[I";
    public static final String DESC_BUNDLE = "Landroid/os/Bundle;";
    public static final String DESC_CONTEXT = "Landroid/content/Context;";
    public static final String DESC_CONTAINER_VIEW =
            "Lcom/oplus/pscanvas/canvasmode/canvas/view/ContainerView;";
    public static final String DESC_DRAGGABLE_VIEW_GROUP =
            "Lcom/oplus/pscanvas/canvasmode/canvas/view/DraggableCanvasViewGroup;";
    public static final String DESC_MOTION_EVENT = "Landroid/view/MotionEvent;";
    public static final String DESC_TRANSACTION = "Landroid/view/SurfaceControl$Transaction;";
    public static final String DESC_SURFACE_CONTROL = "Landroid/view/SurfaceControl;";
    public static final String DESC_EMBEDDED_DECOR =
            "Lcom/oplus/pscanvas/canvasmode/canvas/view/EmbeddedViewDecor;";
    public static final String DESC_FLEXIBLE_TASK_VIEW =
            "Lcom/oplus/flexiblewindow/FlexibleTaskView;";

    private MethodMatcher() {
    }

    // ---------------------------------------------------------------------
    // SStoFlexible (x1.r / x1.x) signatures
    // ---------------------------------------------------------------------

    /** {@code t0/f0(ScaleGestureDetector, int)} — the most stable SStoFlexible marker. */
    public static boolean isScaleGestureDetectorInt(DexMethod method) {
        return params(method, DESC_SCALE_DETECTOR, DESC_INT);
    }

    /** {@code H(B( List, int[]) -> Bundle} — launch bounds normalizer. */
    public static boolean isLaunchBounds(DexMethod method) {
        return params(method, DESC_LIST, DESC_INT_ARRAY) && DESC_BUNDLE.equals(method.returnDescriptor);
    }

    /** {@code I() -> List} — intent list accessor. */
    public static boolean isIntentList(DexMethod method) {
        return DESC_LIST.equals(method.returnDescriptor) && method.paramDescriptors.isEmpty();
    }

    /**
     * {@code Z(Transaction, SurfaceControl x4, EmbeddedViewDecor, int, FlexibleTaskView)}
     * — panorama mask animation. Matched on parameter count + the stable end types
     * only, to tolerate the four SurfaceControl / the EmbeddedViewDecor variations.
     */
    public static boolean isMaskAnimation(DexMethod method) {
        List<String> params = method.paramDescriptors;
        if (params.size() != 8) {
            return false;
        }
        return DESC_TRANSACTION.equals(params.get(0))
                && DESC_EMBEDDED_DECOR.equals(params.get(5))
                && DESC_INT.equals(params.get(6))
                && DESC_FLEXIBLE_TASK_VIEW.equals(params.get(7));
    }

    /** {@code <init>(Context, ContainerView, DraggableCanvasViewGroup)} — 502 canonical ctor. */
    public static boolean isSstoFlexibleConstructor(DexMethod method) {
        return "<init>".equals(method.name)
                && params(method, DESC_CONTEXT, DESC_CONTAINER_VIEW, DESC_DRAGGABLE_VIEW_GROUP);
    }

    // ---------------------------------------------------------------------
    // Field signatures
    // ---------------------------------------------------------------------

    /** A field typed as the canvas {@code ContainerView}. */
    public static boolean isContainerViewField(DexField field) {
        return DESC_CONTAINER_VIEW.equals(field.typeDescriptor);
    }

    /** A field typed as {@code Bundle}. */
    public static boolean isBundleField(DexField field) {
        return DESC_BUNDLE.equals(field.typeDescriptor);
    }

    // ---------------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------------

    private static boolean params(DexMethod method, String... descriptors) {
        List<String> actual = method.paramDescriptors;
        if (actual.size() != descriptors.length) {
            return false;
        }
        for (int i = 0; i < descriptors.length; i++) {
            if (!descriptors[i].equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }

    // ---------------------------------------------------------------------
    // Weak signature predicates (used for structural validation of the
    // non-SStoFlexible roles, where signatures are not unique).
    // ---------------------------------------------------------------------

    /** Has a single {@code boolean} parameter method (U0 / O style). */
    public static boolean hasBooleanMethod(DexMethod method) {
        return params(method, "Z");
    }

    /** Has a {@code (int, int)} parameter method (e0 style). */
    public static boolean hasTwoIntMethod(DexMethod method) {
        return params(method, DESC_INT, DESC_INT);
    }

    /** Has a method whose last parameter is a {@code MotionEvent} (b/c/d style). */
    public static boolean hasMotionEventMethod(DexMethod method) {
        List<String> params = method.paramDescriptors;
        return !params.isEmpty() && DESC_MOTION_EVENT.equals(params.get(params.size() - 1));
    }

    /** Has a method taking an {@code EmbeddedViewDecor} parameter (e/i2 style). */
    public static boolean hasEmbeddedDecorParam(DexMethod method) {
        return method.paramDescriptors.contains(DESC_EMBEDDED_DECOR);
    }

    /** Short human label for a matched signature, for capability logs. */
    public static String label(DexMethod method) {
        return method.name + method.signatureKey();
    }
}
