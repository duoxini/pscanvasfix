package com.color.pscanvasfix.compat;

import android.graphics.Rect;

import com.color.pscanvasfix.hook.PsCanvasSymbols.ResizeFocusMethods;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.util.List;

/** Routes an otherwise inert short divider to the adjacent OEM resize target. */
public final class ThreeTaskResizeFocusCompat {
    private static final int OEM_SPRING_BACK = 6;
    private static final float MAX_START_TO_THRESHOLD = 0.20f;
    private static final float REBASED_START_TO_THRESHOLD = 0.10f;

    private ThreeTaskResizeFocusCompat() {}

    public static void selectAdjacentFocus(Object containerView, Object bar, float deltaX,
                                           float deltaY, String panoramaActiveMethod,
                                           ResizeFocusMethods methods, ReflectionAccess access) {
        if (bar == null || !SplitBar502Compat.shouldPreserveOemThreeTaskResize(
                containerView, true, panoramaActiveMethod)) {
            return;
        }
        try {
            Object adapter = access.callMethod(containerView, "getAdapter");
            int layout = (Integer) access.callMethod(adapter, "n");
            int currentFocus = (Integer) access.callMethod(adapter, methods.focusedIndex());
            boolean verticalBar = (Boolean) access.callMethod(bar, methods.verticalBar());
            int targetFocus = adjacentFocus(layout, verticalBar, currentFocus, deltaX, deltaY);
            if (targetFocus < 0) {
                return;
            }
            Object controller = access.callMethod(containerView, "getContainerController");
            access.callMethod(controller, methods.selectFocus(), targetFocus);
            PsCanvasLog.d("three-task short divider focus " + currentFocus + "->" + targetFocus
                    + " layout=" + layout);
        } catch (Throwable t) {
            PsCanvasLog.e("three-task short divider focus failed", t);
        }
    }

    static int adjacentFocus(int layout, boolean verticalBar, int currentFocus,
                             float deltaX, float deltaY) {
        if (layout < 4 || layout > 7 || verticalBar != (layout == 4 || layout == 5)) {
            return -1;
        }
        int singleWindow = (layout == 4 || layout == 6) ? 0 : 2;
        float delta = verticalBar ? deltaX : deltaY;
        if (currentFocus != singleWindow || !Float.isFinite(delta) || delta == 0f) {
            return -1;
        }
        // The OEM policy can narrow the focused member of the pair. A positive
        // drag moves into the trailing window; a negative drag moves into the leading one.
        int leadingWindow = singleWindow == 0 ? 1 : 0;
        return delta > 0f ? leadingWindow + 1 : leadingWindow;
    }

    public static void alignMainDividerThreshold(Object containerView, Object bar,
                                                String panoramaActiveMethod,
                                                ResizeFocusMethods methods, ReflectionAccess access) {
        if (bar == null || !SplitBar502Compat.shouldPreserveOemThreeTaskResize(
                containerView, true, panoramaActiveMethod)) {
            return;
        }
        try {
            int mode = (Integer) access.callMethod(containerView, "getDragModeType");
            // These OEM modes narrow the single large pane from the long divider.
            if (mode != 13 && mode != 14) {
                return;
            }
            float[] thresholds = (float[]) access.callMethod(containerView, "getDragModes");
            if (thresholds == null || thresholds.length != 1) {
                return;
            }
            int[] actions = (int[]) access.callMethod(containerView, "getDragTargetAction");
            List<?> slots = (List<?>) access.callMethod(containerView, "getOriginalLocations");
            Rect viewport = (Rect) access.callMethod(containerView, "getWindowMetricsBounds");
            if (slots == null || slots.size() != 3 || viewport == null || viewport.isEmpty()) {
                return;
            }
            Object adapter = access.callMethod(containerView, "getAdapter");
            int layout = (Integer) access.callMethod(adapter, "n");
            boolean vertical = (Boolean) access.callMethod(bar, methods.verticalBar());
            if (layout < 4 || layout > 7 || vertical != (layout >= 6)) {
                return;
            }
            // The policy uses the visible gap between the slots for its spring
            // origin. The split-bar view's bounds can be in canvas coordinates.
            Rect before = (Rect) slots.get(0);
            Rect after = (Rect) slots.get((layout == 4 || layout == 6) ? 1 : 2);
            int beforeEdge = vertical ? before.right : before.bottom;
            int afterEdge = vertical ? after.left : after.top;
            int center = beforeEdge + (afterEdge - beforeEdge) / 2;
            int span = vertical ? viewport.width() : viewport.height();
            float threshold = mainDividerThreshold(thresholds[0], actions, center, span);
            if (threshold == thresholds[0]) {
                return;
            }
            access.callMethod(containerView, "setDragModes", new float[]{threshold});
            PsCanvasLog.d("three-task main divider threshold " + thresholds[0] + "->"
                    + threshold + " at " + center + "/" + span + " mode=" + mode);
        } catch (Throwable t) {
            PsCanvasLog.e("three-task main divider threshold failed", t);
        }
    }

    static float mainDividerThreshold(float threshold, int[] actions, int center, int span) {
        if (span <= 0 || center < 0 || center > span || !Float.isFinite(threshold)
                || actions == null || actions.length != 2) {
            return threshold;
        }
        // OEM modes 13/14 put the threshold at the center of the display even when
        // the visible divider has moved to an edge. Keep the action and rebase the
        // travel to the same tenth-screen gap as the OEM centered snap zones.
        if (actions[0] == OEM_SPRING_BACK && actions[1] >= 3 && actions[1] <= 5
                && threshold - center > span * MAX_START_TO_THRESHOLD) {
            return center + span * REBASED_START_TO_THRESHOLD;
        }
        if (actions[1] == OEM_SPRING_BACK && actions[0] >= 3 && actions[0] <= 5
                && center - threshold > span * MAX_START_TO_THRESHOLD) {
            return center - span * REBASED_START_TO_THRESHOLD;
        }
        return threshold;
    }
}
