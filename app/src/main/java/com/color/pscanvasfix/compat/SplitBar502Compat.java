package com.color.pscanvasfix.compat;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Block 700-only three-split-together and split-bar drag behaviors.
 *
 * 502 has NO:
 *   - Three-split-together callback (onEnterThreeSplitTogether / onExitThreeSplitTogether)
 *   - Spring-based three-split drag handler (E.u0)
 *   - Scroll split bar in three-split (E2)
 *   - Enlarge for three-split view (i2)
 *   - Three-split-together sub-surface z-ordering
 *   - Panorama getLaunchRect() override
 *
 * All these paths must be blocked so 502 panorama layout 4 (2+1 peek)
 * is never overridden by 700 three-equal-column layout.
 */
public final class SplitBar502Compat {

    private SplitBar502Compat() {}

    // ---- P0: Three-split-together callback chain ----

    /**
     * Block containerView.e3() when i3==3 (three-split-together entry).
     * 502 has no three-split-together mode — the onEnterThreeSplitTogether
     * callback must not trigger 3-equal-column layout setup.
     * Allow i3==0 (exit from three-split-together) to proceed.
     */
    public static void blockE3Entry(XC_MethodHook.MethodHookParam param) {
        int layoutParam = (Integer) param.args[2];
        if (layoutParam == 3) {
            PsCanvasLog.d("blocked e3 three-split-together entry (i3=3)");
            param.setResult(null);
            return;
        }
        PsCanvasLog.d("e3 exit allowed i3=" + layoutParam);
    }

    /**
     * Block containerView.f3() — update resizable split rects for three-split.
     * 700 uses this when entering three-split-together mode to recalculate
     * bounds for 3 equal columns. 502 panorama manages this via adapter n().
     */
    public static void blockF3(XC_MethodHook.MethodHookParam param) {
        try {
            Object containerView = param.thisObject;
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter != null) {
                int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
                if (layout >= 4 && layout <= 7) {
                    PsCanvasLog.d("blocked f3 in panorama layout=" + layout);
                    param.setResult(null);
                    return;
                }
            }
        } catch (Throwable ignored) {
        }
        PsCanvasLog.d("blocked f3 (panorama context)");
        param.setResult(null);
    }

    /**
     * Block containerView.E2() — startScrollSplitBarInThreeSplit.
     * 502 has no three-split scroll bar animation. Returns empty list.
     */
    public static void blockE2Entry(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked E2 startScrollSplitBarInThreeSplit");
        param.setResult(new java.util.ArrayList());
    }

    /**
     * Block containerView.i2() — startEnlarge for three-split view.
     * 502 uses ContainerView.V(index, 1) for panorama pan instead of
     * 700's drag-to-enlarge in three-split mode.
     */
    public static void blockI2(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked i2 startEnlarge in three-split");
        param.setResult(null);
    }

    // ---- P1: SplitBar three-split drag ----

    /**
     * Block E.u0() — spring-based three-split split-bar drag handler.
     * 502 uses direction-switch methods C/D/E/F/G (C0328z) instead of
     * 700's unified spring physics drag. Block entirely so the canvas
     * never enters three-split drag mode.
     */
    public static void blockEU0(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked E.u0 three-split spring drag");
        param.setResult(null);
    }

    /**
     * Block E.R() — spring animation initialization for three-split drag.
     * Must be blocked because u0() depends on the SpringAnimation
     * created here (SpringForce with stiffness=0.15, dampingRatio=0.0).
     */
    public static void blockER(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked E.R spring animation init");
        param.setResult(null);
    }

    // ---- P2: Z-Order + getLaunchRect ----

    /**
     * Block the three-split-together branch in ContainerView.setLayerOrder().
     * 700 adds a B1.s.z() sub-surface branch (layers 1-4) when in
     * three-split-together mode. 502 only has simple layers 0-2.
     * The actual blocking is done via B1.s.z() hook (always returns false).
     */
    public static void blockThreeSplitLayerOrder(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("setLayerOrder: simple branch (three-split-together blocked)");
    }

    /**
     * Block panorama getLaunchRect() override in EmbeddedViewDecor.
     * 700 line 1028: if (B1.s.H() && item.B()) return item.i()
     * This returns match-parent rect in panorama mode instead of normal rect.
     * 502 always uses item.n() — force it.
     *
     * NOTE: Uses getTaskData() method (public API) instead of direct field
     * access because jadx field names (f10863i) differ from live dex names.
     */
    public static void blockPanoramaLaunchRectOverride(XC_MethodHook.MethodHookParam param) {
        try {
            Object decor = param.thisObject;
            Object parent = XposedHelpers.callMethod(decor, "getParent");
            if (parent == null) return;
            Object adapter = XposedHelpers.callMethod(parent, "getAdapter");
            if (adapter == null) return;
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            if (layout >= 4 && layout <= 7) {
                // Use public getTaskData() method instead of direct field (live dex compat)
                Object taskData = XposedHelpers.callMethod(decor, "getTaskData");
                if (taskData != null) {
                    Object normalRect = XposedHelpers.callMethod(taskData, "n");
                    // Rate-limit: only log first occurrence per layout session
                    param.setResult(normalRect);
                }
            }
        } catch (Throwable t) {
            PsCanvasLog.e("blockPanoramaLaunchRectOverride failed", t);
        }
    }
}
