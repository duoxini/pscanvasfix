package com.color.pscanvasfix.compat;

import android.content.Context;

import java.lang.reflect.Field;

import de.robv.android.xposed.XposedHelpers;

/**
 * 502 has no ThreeSplitAnimManager / ThreeSplitDragManager — block 700-only touch shrink/enlarge
 * when canvas is in panorama 3-app layout (orientation 4–7).
 */
public final class ThreeSplitTouch502Compat {

    private ThreeSplitTouch502Compat() {
    }

    /** True when canvas hosts exactly three apps (502/700 i1()). */
    public static boolean isThreeAppCanvas(Object containerView) {
        if (containerView == null) {
            return false;
        }
        try {
            if (Boolean.TRUE.equals(XposedHelpers.callMethod(containerView, "i1"))) {
                return true;
            }
        } catch (Throwable ignored) {
        }
        try {
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter != null) {
                return (Integer) XposedHelpers.callMethod(adapter, "getCount") == 3;
            }
        } catch (Throwable ignored) {
        }
        return false;
    }

    /**
     * 502: five-finger pinch in 3-app canvas sync-shrinks on canvas (not split-to-flexible).
     * NOTE: Canvas sync pinch requires re-wiring ScaleGestureDetector to ContainerView
     * which is not feasible via Xposed hooks alone. Return false to allow the normal
     * split-to-flexible path to handle pinch → floating windows.
     * The adapter layout remap (3→4) ensures correct panorama 2+1 visual display.
     */
    public static boolean shouldUseCanvasSyncPinch(Object containerView) {
        return false;
    }

    /** True when 3-app canvas uses panorama layout and pinch transition is not active. */
    public static boolean isPanoramaThreeSplit(Object containerView) {
        if (containerView == null || SplitPolicyCompat.inTransition()) {
            return false;
        }
        if (!isThreeAppCanvas(containerView)) {
            return false;
        }
        try {
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null) {
                return false;
            }
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            return layout >= 4 && layout <= 7;
        } catch (Throwable ignored) {
            return false;
        }
    }

    public static boolean shouldBlockTouchAnim(Object animOrDragHolder) {
        return isAnyPanoramaMode(findContainerView(animOrDragHolder));
    }

    public static Object findContainerView(Object holder) {
        if (holder == null) {
            return null;
        }
        if (holder.getClass().getName().contains("ContainerView")) {
            return holder;
        }
        for (Field field : holder.getClass().getDeclaredFields()) {
            if (!field.getType().getName().contains("ContainerView")) {
                continue;
            }
            try {
                field.setAccessible(true);
                Object value = field.get(holder);
                if (value != null) {
                    return value;
                }
            } catch (Throwable ignored) {
            }
        }
        return SplitPolicyCompat.findContainerView(holder);
    }

    /** 502 R(index,1): adapter focus + panorama pan via ContainerView.T (not three-split shrink). */
    public static boolean focusWithPan(Object containerView, int index) {
        if (containerView == null || index < 0) {
            return false;
        }
        try {
            return Boolean.TRUE.equals(XposedHelpers.callMethod(containerView, "V", index, 1));
        } catch (Throwable throwable) {
            PsCanvasLog.e("focusWithPan failed index=" + index, throwable);
            return false;
        }
    }

    /** Resolve ContainerView from gesture manager (field g, split policy, or activity v0). */
    public static Object getGestureContainerView(Object gestureOuter) {
        if (gestureOuter == null) {
            return null;
        }
        Object containerView = ObfFieldCompat.getObject(gestureOuter,
                ObfFieldCompat.GESTURE_CONTAINER, "f10952g");
        if (containerView != null) {
            return containerView;
        }
        containerView = scanContainerViewField(gestureOuter);
        if (containerView != null) {
            return containerView;
        }
        Object splitPolicy = ObfFieldCompat.getObject(gestureOuter,
                ObfFieldCompat.GESTURE_SPLIT_POLICY, "f10948c");
        containerView = SplitPolicyCompat.findContainerView(splitPolicy);
        if (containerView != null) {
            return containerView;
        }
        Object activity = ObfFieldCompat.getObject(gestureOuter,
                ObfFieldCompat.GESTURE_ACTIVITY, "f10947b");
        if (activity == null) {
            activity = ObfFieldCompat.getObject(gestureOuter,
                    ObfFieldCompat.GESTURE_CONTEXT, "f10950e");
        }
        if (activity != null) {
            try {
                return XposedHelpers.callMethod(activity, "v0");
            } catch (Throwable ignored) {
            }
        }
        try {
            Object context = ObfFieldCompat.getObject(gestureOuter,
                    ObfFieldCompat.GESTURE_CONTEXT, "f10950e");
            if (context instanceof Context) {
                Object resolvedActivity = XposedHelpers.callStaticMethod(
                        XposedHelpers.findClass("B1.l", context.getClass().getClassLoader()),
                        "O1", context);
                if (resolvedActivity != null) {
                    return XposedHelpers.callMethod(resolvedActivity, "v0");
                }
            }
        } catch (Throwable ignored) {
        }
        return null;
    }

    private static Object scanContainerViewField(Object holder) {
        for (Field field : holder.getClass().getDeclaredFields()) {
            if (!field.getType().getName().contains("ContainerView")) {
                continue;
            }
            try {
                field.setAccessible(true);
                Object value = field.get(holder);
                if (value != null) {
                    return value;
                }
            } catch (Throwable ignored) {
            }
        }
        return null;
    }

    /** Clear mScaling / split-policy blockers after a dead-end flexible pinch. */
    public static void resetThreeAppPinchState(Object gestureOuter, Class<?> gestureClass) {
        if (gestureOuter == null || gestureClass == null) {
            return;
        }
        if (!isThreeAppCanvas(getGestureContainerView(gestureOuter))) {
            return;
        }
        ObfFieldCompat.setBoolean(gestureOuter, ObfFieldCompat.GESTURE_SCALING,
                "f10936B", false);
        ObfFieldCompat.setObject(gestureOuter, ObfFieldCompat.GESTURE_SPLIT_POLICY,
                "f10948c", null);
    }

    /** Prepare 502 canvas sync-shrink pinch for 3-app canvas (clear blockers + f10934L). */
    public static boolean prepareThreeAppCanvasPinch(Object gestureOuter, Class<?> gestureClass) {
        if (gestureOuter == null || gestureClass == null) {
            return false;
        }
        // Only block when canvas sync pinch is enabled
        if (!shouldUseCanvasSyncPinch(null)) {
            return false;
        }
        Object containerView = getGestureContainerView(gestureOuter);
        if (!isThreeAppCanvas(containerView)) {
            return false;
        }
        ObfFieldCompat.setGestureSplitEnabled(gestureClass, false);
        ObfFieldCompat.setObject(gestureOuter, ObfFieldCompat.GESTURE_SPLIT_POLICY,
                "f10948c", null);
        int pointerCount = ObfFieldCompat.getInt(gestureOuter,
                ObfFieldCompat.GESTURE_POINTER_COUNT, "f10935A");
        if (pointerCount > 3) {
            ObfFieldCompat.setBoolean(gestureOuter, ObfFieldCompat.GESTURE_SCALING,
                    "f10936B", false);
        }
        try {
            XposedHelpers.callMethod(containerView, "setIsSwitchToZoomAnim", false);
        } catch (Throwable ignored) {
        }
        boolean splitFlag = ObfFieldCompat.getGestureSplitEnabled(gestureClass, true);
        PsCanvasLog.d("3-app pinch prep pointers=" + pointerCount
                + " f10934L=" + splitFlag + " sync-shrink");
        return true;
    }

    /** Called from T/onScaleBegin before ScaleGestureDetector — uses live pointer count. */
    public static boolean forceCanvasSyncPinch(Object gestureOuter, Class<?> gestureClass,
                                               int pointerCount) {
        if (gestureOuter == null || gestureClass == null || pointerCount <= 3) {
            return false;
        }
        // Only block x1.r path when canvas sync pinch is enabled
        if (!shouldUseCanvasSyncPinch(null)) {
            return false;
        }
        Object containerView = getGestureContainerView(gestureOuter);
        if (!isThreeAppCanvas(containerView)) {
            return false;
        }
        ObfFieldCompat.setGestureSplitEnabled(gestureClass, false);
        ObfFieldCompat.setObject(gestureOuter, ObfFieldCompat.GESTURE_SPLIT_POLICY,
                "f10948c", null);
        ObfFieldCompat.setBoolean(gestureOuter, ObfFieldCompat.GESTURE_SCALING,
                "f10936B", false);
        try {
            XposedHelpers.callMethod(containerView, "setIsSwitchToZoomAnim", false);
        } catch (Throwable ignored) {
        }
        boolean splitFlag = ObfFieldCompat.getGestureSplitEnabled(gestureClass, true);
        PsCanvasLog.d("3-app force sync pinch pointers=" + pointerCount + " f10934L=" + splitFlag);
        return !splitFlag;
    }

    /** Undo x1.r path if onScaleBegin already committed flexible branch. */
    public static void undoFlexiblePinchBegin(Object gestureOuter, Class<?> gestureClass) {
        if (gestureOuter == null || gestureClass == null) {
            return;
        }
        // Only undo when canvas sync pinch is enabled
        if (!shouldUseCanvasSyncPinch(null)) {
            return;
        }
        Object containerView = getGestureContainerView(gestureOuter);
        if (!isThreeAppCanvas(containerView)) {
            return;
        }
        Object splitPolicy = ObfFieldCompat.getObject(gestureOuter,
                ObfFieldCompat.GESTURE_SPLIT_POLICY, "f10948c");
        if (splitPolicy == null) {
            return;
        }
        ObfFieldCompat.setObject(gestureOuter, ObfFieldCompat.GESTURE_SPLIT_POLICY,
                "f10948c", null);
        ObfFieldCompat.setBoolean(gestureOuter, ObfFieldCompat.GESTURE_SCALING,
                "f10936B", false);
        ObfFieldCompat.setGestureSplitEnabled(gestureClass, false);
        PsCanvasLog.d("3-app undo x1.r onScaleBegin (retry canvas sync)");
    }

    public static void syncGestureSplitFlagForThreeApp(Class<?> gestureClass, Object containerView) {
        if (gestureClass == null || !isThreeAppCanvas(containerView)) {
            return;
        }
        ObfFieldCompat.setGestureSplitEnabled(gestureClass, false);
        PsCanvasLog.d("f10934L=false for 3-app canvas");
    }

    public static Object findContainerViewFromAdapter(Object adapter) {
        if (adapter == null) {
            return null;
        }
        try {
            Context context = (Context) XposedHelpers.callMethod(adapter, "getContext");
            Object activity = XposedHelpers.callStaticMethod(
                    XposedHelpers.findClass("B1.l", adapter.getClass().getClassLoader()),
                    "O1", context);
            if (activity == null) {
                return null;
            }
            return XposedHelpers.callMethod(activity, "v0");
        } catch (Throwable ignored) {
            return null;
        }
    }

    /** True when adapter.H is invoked from CanvasGestureManager handleUp / onTouchEventByGesture. */
    public static boolean isGestureManagerFocusSwitch() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (int index = 0; index < Math.min(trace.length, 20); index++) {
            String className = trace[index].getClassName();
            if (!className.contains("canvas.y") && !className.contains("C0332y")) {
                continue;
            }
            String methodName = trace[index].getMethodName();
            if ("N".equals(methodName) || "T".equals(methodName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Block adapter.H(index) in panorama 3-split to prevent 700 tap-to-enlarge.
     * 502 does NOT auto-enlarge on single tap in panorama — only 4-finger pinch
     * out triggers exit/transition. Simply block the focus call entirely.
     */
    public static boolean redirectGestureFocusToPan(Object adapter, int index) {
        if (!isGestureManagerFocusSwitch()) {
            return false;
        }
        Object containerView = findContainerViewFromAdapter(adapter);
        if (!isThreeAppCanvas(containerView)) {
            return false;
        }
        try {
            if (!Boolean.TRUE.equals(XposedHelpers.callMethod(containerView, "G1", index))) {
                return false;
            }
            // 502: single tap in panorama does NOT auto-enlarge.
            // Block adapter.H(index) entirely — no pan, no enlarge.
            PsCanvasLog.d("blocked tap-to-enlarge in panorama index=" + index);
            return true; // true = BLOCK the original adapter.H(index)
        } catch (Throwable throwable) {
            PsCanvasLog.e("redirectGestureFocusToPan failed index=" + index, throwable);
            return false;
        }
    }

    /** Scan ContainerView for panorama mode manager field (live dex compat). */
    private static Object findPanoramaManager(Object containerView) {
        if (containerView == null) return null;
        // Try known field names first
        for (String name : new String[]{"I", "f10736I", "H"}) {
            try {
                Object val = XposedHelpers.getObjectField(containerView, name);
                if (val != null && val.getClass().getName().contains("A0")) {
                    return val;
                }
            } catch (Throwable ignored) {}
        }
        // Scan all fields for panorama manager type
        for (java.lang.reflect.Field f : containerView.getClass().getDeclaredFields()) {
            if (f.getType().getName().contains("A0") || f.getType().getSimpleName().equals("A0")) {
                try {
                    f.setAccessible(true);
                    Object val = f.get(containerView);
                    if (val != null) return val;
                } catch (Throwable ignored) {}
            }
        }
        return null;
    }

    public static void focusIndexOnly(Object containerView, int index) {
        if (containerView == null || index < 0) {
            return;
        }
        try {
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter != null) {
                XposedHelpers.callMethod(adapter, "H", index);
            }
        } catch (Throwable throwable) {
            PsCanvasLog.e("focusIndexOnly failed index=" + index, throwable);
        }
    }

    /**
     * Check if the current adapter orientation is portrait (vertical) panorama.
     * 502 portrait layout: adapter.i() returns the portrait task count,
     * adapter.n() returns layout orientation (4-7 for panorama).
     *
     * In portrait mode: all three apps are stacked vertically with the
     * top two fully visible and the bottom one peeking (or vice versa).
     */
    public static boolean isPortraitPanorama(Object containerView) {
        if (containerView == null || !isThreeAppCanvas(containerView)) {
            return false;
        }
        try {
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null) return false;
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            int portraitCount = (Integer) XposedHelpers.callMethod(adapter, "i");
            // Portrait panorama: layout >= 4 (panorama range) with portrait tasks
            return layout >= 4 && layout <= 7 && portraitCount >= 1;
        } catch (Throwable ignored) {
            return false;
        }
    }

    /**
     * Check if we're in any panorama mode (landscape or portrait).
     * Orientation-agnostic version used by hooks that need to apply
     * 502 behavior regardless of device orientation.
     */
    public static boolean isAnyPanoramaMode(Object containerView) {
        return isPanoramaThreeSplit(containerView) || isPortraitPanorama(containerView);
    }
}
