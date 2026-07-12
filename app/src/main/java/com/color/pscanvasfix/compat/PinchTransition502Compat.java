package com.color.pscanvasfix.compat;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.XposedHelpers;

/**
 * 502 S1.p pinch-to-flexible core: dummy prepare (I) and layout-aware bounds remap (x).
 */
public final class PinchTransition502Compat {
    private static final String UTIL = "B1.l";

    private PinchTransition502Compat() {
    }

    /** Sync f14114H from live adapter.n() — 502 reads layout at bounds calc time. */
    public static void syncLiveLayoutOrient(Object splitPolicy) {
        if (splitPolicy == null) {
            return;
        }
        try {
            Object containerView = ObfFieldCompat.getObject(
                    splitPolicy, ObfFieldCompat.R_CONTAINER, "f14129b");
            if (containerView == null) {
                containerView = SplitPolicyCompat.findContainerView(splitPolicy);
            }
            if (containerView == null) {
                return;
            }
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null) {
                return;
            }
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            ObfFieldCompat.setInt(splitPolicy, ObfFieldCompat.R_LAYOUT_ORIENT, "f14114H", layout);
            PsCanvasLog.d("syncLiveLayoutOrient layout=" + layout);
        } catch (Throwable throwable) {
            PsCanvasLog.e("syncLiveLayoutOrient failed", throwable);
        }
    }

    /** 502 S1.p.I() — dummy prepare_switch with [0] and empty rect. */
    public static void run502DummyPrepare(final ClassLoader classLoader) {
        new Handler(Looper.getMainLooper()).post(() -> {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("prepare_switch_to_flexible_window", true);
                ArrayList<Rect> launchBounds = new ArrayList<>();
                launchBounds.add(new Rect());
                float[] scales = {1.0f};
                XposedHelpers.callStaticMethod(
                        XposedHelpers.findClass(UTIL, classLoader),
                        "t0",
                        new int[]{0},
                        launchBounds,
                        scales,
                        bundle);
                PsCanvasLog.d("502 dummy prepare t0([0]) done");
            } catch (Throwable throwable) {
                PsCanvasLog.e("502 dummy prepare failed", throwable);
            }
        });
    }

    /** Port 502 S1.p.x() — replace 700 x1.r.L(). */
    @SuppressWarnings("unchecked")
    public static void apply502LayoutRemap(Object splitPolicy, ArrayList<?> boundsList) {
        if (splitPolicy == null || boundsList == null || boundsList.isEmpty()) {
            return;
        }
        try {
            Object containerView = ObfFieldCompat.getObject(
                    splitPolicy, ObfFieldCompat.R_CONTAINER, "f14129b");
            if (containerView == null) {
                containerView = SplitPolicyCompat.findContainerView(splitPolicy);
            }
            if (containerView == null) {
                return;
            }
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null) {
                return;
            }
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            ObfFieldCompat.setInt(splitPolicy, ObfFieldCompat.R_LAYOUT_ORIENT, "f14114H", layout);

            List<Object> masks = (List<Object>) ObfFieldCompat.getObject(
                    splitPolicy, ObfFieldCompat.R_MASKS, "f14145r");
            List<Object> entries = (List<Object>) ObfFieldCompat.getObject(
                    splitPolicy, ObfFieldCompat.R_ENTRIES, "f14111E");
            if (masks == null || entries == null) {
                PsCanvasLog.w("502 layout remap: mask/entry list null");
                return;
            }
            int size = boundsList.size();
            PsCanvasLog.d("502 layout remap layout=" + layout + " size=" + size);

            if (layout == 7 || layout == 1 || (layout == 3 && !isFirstAdapterItemPeek(adapter))) {
                for (int index = 0; index < size; index++) {
                    applyLaunchInfo(splitPolicy, masks, entries, boundsList, index, index);
                }
                return;
            }
            if (layout == 6) {
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 0, 1);
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 1, 2);
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 2, 0);
                return;
            }
            if (layout == 5) {
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 0, 1);
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 1, 0);
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 2, 2);
                return;
            }
            if (layout == 4) {
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 0, 0);
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 1, 2);
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, 2, 1);
                return;
            }
            int last = size - 1;
            for (int maskIndex = last; maskIndex >= 0; maskIndex--) {
                int bundleIndex = last - maskIndex;
                applyLaunchInfo(splitPolicy, masks, entries, boundsList, bundleIndex, maskIndex);
            }
        } catch (Throwable throwable) {
            PsCanvasLog.e("502 layout remap failed", throwable);
        }
    }

    private static boolean isFirstAdapterItemPeek(Object adapter) {
        try {
            Object item = XposedHelpers.callMethod(adapter, "getItem", 0);
            if (item == null) {
                return false;
            }
            return (Boolean) XposedHelpers.callMethod(item, "B");
        } catch (Throwable throwable) {
            return false;
        }
    }

    /**
     * Layout 4 panorama: peek slot uses rectList[0] (full scroll canvas). Mask animation must use
     * the decor's visible launch rect so all three apps shrink in sync (502 behavior).
     */
    public static void fixPanoramaMaskAnimRect(Object splitPolicy, Object embeddedDecor) {
        if (splitPolicy == null || embeddedDecor == null) {
            return;
        }
        try {
            Object containerView = ObfFieldCompat.getObject(
                    splitPolicy, ObfFieldCompat.R_CONTAINER, "f14129b");
            if (containerView == null) {
                containerView = SplitPolicyCompat.findContainerView(splitPolicy);
            }
            if (containerView == null) {
                return;
            }
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null || ((Integer) XposedHelpers.callMethod(adapter, "n")) != 4) {
                return;
            }
            Rect union = (Rect) XposedHelpers.callMethod(containerView, "getRectListUnion");
            if (union == null || union.width() <= 0 || union.height() <= 0) {
                return;
            }
            Rect launchRect = (Rect) XposedHelpers.callMethod(embeddedDecor, "getLaunchRect");
            if (launchRect == null || launchRect.width() <= 0 || launchRect.height() <= 0) {
                return;
            }
            if (launchRect.width() >= union.width() - 32) {
                return;
            }

            @SuppressWarnings("unchecked")
            List<Object> masks = (List<Object>) ObfFieldCompat.getObject(
                    splitPolicy, ObfFieldCompat.R_MASKS, "f14145r");
            if (masks == null || masks.isEmpty()) {
                return;
            }
            Object mask = masks.get(masks.size() - 1);
            Object maskDecor = XposedHelpers.getObjectField(mask, "f14169f");
            if (maskDecor != embeddedDecor) {
                return;
            }
            Rect animRect = (Rect) XposedHelpers.getObjectField(mask, "f14170g");
            if (animRect == null || animRect.width() < union.width() - 32) {
                return;
            }
            animRect.set(launchRect);
            Object taskData = XposedHelpers.callMethod(embeddedDecor, "getTaskData");
            int taskId = taskData != null
                    ? ((Integer) XposedHelpers.callMethod(taskData, "s")).intValue() : 0;
            PsCanvasLog.d("fixPanoramaMaskAnimRect task=" + taskId
                    + " " + union.width() + "x" + union.height()
                    + " -> " + launchRect.width() + "x" + launchRect.height());
        } catch (Throwable throwable) {
            PsCanvasLog.e("fixPanoramaMaskAnimRect failed", throwable);
        }
    }

    private static void applyLaunchInfo(Object splitPolicy, List<Object> masks, List<Object> entries,
                                        ArrayList<?> boundsList, int bundleIndex, int maskIndex) {
        if (bundleIndex < 0 || bundleIndex >= boundsList.size()
                || maskIndex < 0 || maskIndex >= masks.size()
                || bundleIndex >= entries.size()) {
            return;
        }
        Object mask = masks.get(maskIndex);
        Object bundle = boundsList.get(bundleIndex);
        Object entry = entries.get(bundleIndex);
        XposedHelpers.callMethod(splitPolicy, "K", mask, bundle, entry);
    }
}
