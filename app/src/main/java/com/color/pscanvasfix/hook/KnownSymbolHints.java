package com.color.pscanvasfix.hook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Narrow fallback names whose behavioral identity has been verified against
 * archived APKs. Every hint must still pass its resolver-side structural
 * contract; a name by itself never enables a capability.
 */
public final class KnownSymbolHints {
    static final String CANVAS_PACKAGE = "com.oplus.pscanvas.canvasmode.canvas.";
    static final String CANVAS_UTILITY = CANVAS_PACKAGE + "util.FlexibleWindowUtil";
    static final String GESTURE_MANAGER = CANVAS_PACKAGE + "A";
    static final String ANIMATION_MANAGER = "f2.D";
    static final String DRAG_MANAGER = "f2.E";
    static final String DRAG_STATE = "f2.a";
    static final PsCanvasSymbols.AnimationMethods ANIMATION_METHODS =
            new PsCanvasSymbols.AnimationMethods("F0", "T0", "c0", "n0", "w0");
    static final PsCanvasSymbols.DragMethods DRAG_METHODS =
            new PsCanvasSymbols.DragMethods(DRAG_STATE, "d", "e", "f", "g");
    static final PsCanvasSymbols.AnimationMethods LEGACY_ANIMATION_METHODS =
            new PsCanvasSymbols.AnimationMethods("H0", "U0", "e0", "p0", "y0");
    static final PsCanvasSymbols.DragMethods LEGACY_DRAG_METHODS =
            new PsCanvasSymbols.DragMethods("x1.a", "b", "c", "d", "e");
    static final PsCanvasSymbols.LayoutMethods CANVAS_LAYOUT_METHODS =
            new PsCanvasSymbols.LayoutMethods("o", "n", "V1", "n3", "V");
    static final PsCanvasSymbols.LayoutMethods LEGACY_LAYOUT_METHODS =
            new PsCanvasSymbols.LayoutMethods("o", "n", "M1", "e3", "R");
    static final String CONTROLLER = CANVAS_PACKAGE + "v0";
    static final String SPRING_CONTROLLER = CANVAS_PACKAGE + "G";
    static final String SPRING_STATE_DESCRIPTOR =
            "Lcom/oplus/pscanvas/canvasmode/canvas/G$c;";
    static final String RESIZE_FOCUS_ADAPTER = "c2.c";
    static final PsCanvasSymbols.ResizeFocusMethods RESIZE_FOCUS_METHODS =
            new PsCanvasSymbols.ResizeFocusMethods("i2.e", "g", "k", "h", "F");
    private static final PanoramaMethods LEGACY_PANORAMA =
            new PanoramaMethods("M", "z", "A", "b0", null);
    private static final PanoramaMethods UPDATED_PANORAMA =
            new PanoramaMethods("P", "B", "C", "e0", GESTURE_MANAGER);
    private static final List<String> SAVED_LAYOUT_RESTORE_METHODS =
            List.of("K1", "T1", "W1", "r2");
    private static final List<String> P4_CONTROLLER_APPEND_METHODS =
            java.util.Arrays.asList("b", "d");
    private static final List<String> P4_CONTROLLER_REMOVE_METHODS =
            java.util.Arrays.asList("A", "B");
    private static final List<String> P4_CONTROLLER_FOCUS_METHODS =
            java.util.Arrays.asList("F", "G");
    private static final List<String> P4_CONTROLLER_COUNT_METHODS =
            java.util.Arrays.asList("i", "k");
    private static final List<String> P4_ADAPTER_ADD_METHODS =
            Collections.singletonList("a");
    private static final List<String> P4_ADAPTER_DIRECT_REMOVE_METHODS =
            java.util.Arrays.asList("V", "X");

    private KnownSymbolHints() {
    }

    public static List<String> twoTaskPredicateMethods() {
        return Collections.singletonList(LEGACY_PANORAMA.twoTaskPredicate());
    }

    static PanoramaMethods panoramaContract(String manager) {
        return (CANVAS_PACKAGE + "P0").equals(manager)
                ? UPDATED_PANORAMA : LEGACY_PANORAMA;
    }

    record PanoramaMethods(String active, String enter, String exit,
                           String twoTaskPredicate, String gestureClass) {}

    static List<String> savedLayoutRestoreMethods() {
        return SAVED_LAYOUT_RESTORE_METHODS;
    }

    public static List<String> p4ControllerAppendMethods() {
        return P4_CONTROLLER_APPEND_METHODS;
    }

    public static List<String> p4ControllerRemoveMethods() {
        return P4_CONTROLLER_REMOVE_METHODS;
    }

    public static List<String> p4ControllerFocusMethods() {
        return P4_CONTROLLER_FOCUS_METHODS;
    }

    public static List<String> p4ControllerCountMethods() {
        return P4_CONTROLLER_COUNT_METHODS;
    }

    public static List<String> p4AdapterAddMethods() {
        return P4_ADAPTER_ADD_METHODS;
    }

    public static List<String> p4AdapterDirectRemoveMethods() {
        return P4_ADAPTER_DIRECT_REMOVE_METHODS;
    }
}
