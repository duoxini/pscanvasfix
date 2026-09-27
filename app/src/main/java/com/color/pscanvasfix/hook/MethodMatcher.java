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
    public static final String DESC_OBJECT = "Ljava/lang/Object;";
    public static final String DESC_INT_ARRAY = "[I";
    public static final String DESC_BUNDLE = "Landroid/os/Bundle;";
    public static final String DESC_CONTEXT = "Landroid/content/Context;";
    public static final String DESC_INTENT = "Landroid/content/Intent;";
    public static final String DESC_CONTAINER_VIEW =
            "Lcom/oplus/pscanvas/canvasmode/canvas/view/ContainerView;";
    public static final String DESC_DRAGGABLE_VIEW_GROUP =
            "Lcom/oplus/pscanvas/canvasmode/canvas/view/DraggableCanvasViewGroup;";
    public static final String DESC_MOTION_EVENT = "Landroid/view/MotionEvent;";
    public static final String DESC_RECT = "Landroid/graphics/Rect;";
    public static final String DESC_COMPONENT_NAME = "Landroid/content/ComponentName;";
    public static final String DESC_TRANSACTION = "Landroid/view/SurfaceControl$Transaction;";
    public static final String DESC_SURFACE_CONTROL = "Landroid/view/SurfaceControl;";
    public static final String DESC_EMBEDDED_DECOR =
            "Lcom/oplus/pscanvas/canvasmode/canvas/view/EmbeddedViewDecor;";
    public static final String DESC_FLEXIBLE_TASK_VIEW =
            "Lcom/oplus/flexiblewindow/FlexibleTaskView;";
    public static final String DESC_FLEXIBLE_TASK_VIEW_LISTENER =
            "Lcom/oplus/flexiblewindow/FlexibleTaskView$Listener;";
    public static final String DESC_CONTAINER_ACTIVITY =
            "Lcom/oplus/pscanvas/canvasmode/canvas/ContainerActivity;";
    public static final String DESC_HANDLER = "Landroid/os/Handler;";
    public static final String DESC_VOID = "V";
    public static final String DESC_BOOLEAN = "Z";
    public static final String DESC_STRING_ARRAY = "[Ljava/lang/String;";
    public static final String DESC_BOOLEAN_ARRAY = "[Z";

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

    /** Stable constructor of the OEM PanoramaModeManager across all four fixtures. */
    public static boolean isPanoramaManagerConstructor(DexMethod method) {
        return "<init>".equals(method.name)
                && params(method, DESC_DRAGGABLE_VIEW_GROUP, DESC_CONTAINER_VIEW,
                DESC_CONTAINER_ACTIVITY, DESC_HANDLER)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact no-argument primitive-boolean method contract. */
    public static boolean isNoArgBoolean(DexMethod method) {
        return method.paramDescriptors.isEmpty()
                && DESC_BOOLEAN.equals(method.returnDescriptor);
    }

    /** Exact one-boolean-argument void method contract. */
    public static boolean isBooleanVoid(DexMethod method) {
        return params(method, DESC_BOOLEAN) && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Stable shortcut-manager constructor. */
    public static boolean isContextConstructor(DexMethod method) {
        return "<init>".equals(method.name)
                && params(method, DESC_CONTEXT)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** New-generation saved-combination entry carrying the live ContainerView. */
    public static boolean isSavedLayoutSaveEntry(DexMethod method) {
        return params(method, DESC_LIST, DESC_INT, DESC_INT, DESC_CONTAINER_VIEW)
                && DESC_BOOLEAN.equals(method.returnDescriptor);
    }

    /** Private shortcut builder fed with the resolved package/user arrays. */
    public static boolean isSavedLayoutShortcutBuild(DexMethod method) {
        return params(method, DESC_STRING_ARRAY, DESC_INT_ARRAY, DESC_INT, DESC_INT,
                DESC_BOOLEAN_ARRAY, DESC_BOOLEAN_ARRAY, DESC_LIST)
                && DESC_BOOLEAN.equals(method.returnDescriptor);
    }

    /** Existing deterministic shortcut lookup. */
    public static boolean isSavedLayoutExists(DexMethod method) {
        return params(method, DESC_LIST) && DESC_BOOLEAN.equals(method.returnDescriptor);
    }

    /** ContainerActivity's flexible-task restore entry. */
    public static boolean isBundleBoolean(DexMethod method) {
        return params(method, DESC_BUNDLE) && DESC_BOOLEAN.equals(method.returnDescriptor);
    }

    /** Exact ContainerActivity creation callback used to clear process-stale shortcut state. */
    public static boolean isActivityOnCreate(DexMethod method) {
        return "onCreate".equals(method.name)
                && params(method, DESC_BUNDLE)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact ContainerActivity new-intent callback used to refresh shortcut state. */
    public static boolean isActivityOnNewIntent(DexMethod method) {
        return "onNewIntent".equals(method.name)
                && params(method, DESC_INTENT)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact P4 controller/adapter method contract: {@code (TaskData) -> void}. */
    public static boolean isTaskDataVoid(DexMethod method, String taskDataDescriptor) {
        return taskDataDescriptor != null
                && params(method, taskDataDescriptor)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact adapter item accessor contract: {@code (int) -> TaskData}. */
    public static boolean isTaskDataAtIndex(DexMethod method, String taskDataDescriptor) {
        return taskDataDescriptor != null
                && params(method, DESC_INT)
                && (taskDataDescriptor.equals(method.returnDescriptor)
                || DESC_OBJECT.equals(method.returnDescriptor));
    }

    /** Exact no-argument Intent accessor contract. */
    public static boolean isNoArgIntent(DexMethod method) {
        return method.paramDescriptors.isEmpty()
                && DESC_INTENT.equals(method.returnDescriptor);
    }

    /** Exact no-argument ComponentName accessor contract. */
    public static boolean isNoArgComponentName(DexMethod method) {
        return method.paramDescriptors.isEmpty()
                && DESC_COMPONENT_NAME.equals(method.returnDescriptor);
    }

    /** Exact P4 controller count contract: {@code () -> int}. */
    public static boolean isNoArgInt(DexMethod method) {
        return method.paramDescriptors.isEmpty()
                && DESC_INT.equals(method.returnDescriptor);
    }

    /** Exact EmbeddedViewDecor bind observation point. */
    public static boolean isEmbeddedTaskBind(DexMethod method, String taskDataDescriptor) {
        return taskDataDescriptor != null
                && params(method, taskDataDescriptor, DESC_RECT, "F")
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact {@code onAttachedToWindow() -> void} observation point. */
    public static boolean isOnAttachedToWindow(DexMethod method) {
        return "onAttachedToWindow".equals(method.name)
                && method.paramDescriptors.isEmpty()
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact FlexibleTaskView.Listener callback observation point. */
    public static boolean isOnTaskCreated(DexMethod method) {
        return "onTaskCreated".equals(method.name)
                && params(method, DESC_INT, DESC_COMPONENT_NAME)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact FlexibleTaskView WM-bounds observation point. */
    public static boolean isFlexibleTaskResize(DexMethod method) {
        return "resize".equals(method.name)
                && params(method, DESC_RECT)
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact FlexibleTaskView cleanup observation point. */
    public static boolean isFlexibleTaskRelease(DexMethod method) {
        return "release".equals(method.name)
                && method.paramDescriptors.isEmpty()
                && DESC_VOID.equals(method.returnDescriptor);
    }

    /** Exact FlexibleTaskView task identity accessor. */
    public static boolean isFlexibleTaskId(DexMethod method) {
        return "getTaskId".equals(method.name) && isNoArgInt(method);
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
