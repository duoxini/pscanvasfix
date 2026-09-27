package com.color.pscanvasfix.hook;

import java.util.Collections;
import java.util.List;

/**
 * Narrow fallback names whose behavioral identity has been verified against
 * archived APKs. Every hint must still pass its resolver-side structural
 * contract; a name by itself never enables a capability.
 */
public final class KnownSymbolHints {
    private static final List<String> PANORAMA_ACTIVE_METHODS =
            Collections.singletonList("M");
    private static final List<String> PANORAMA_ENTER_METHODS =
            Collections.singletonList("z");
    private static final List<String> PANORAMA_EXIT_METHODS =
            Collections.singletonList("A");
    private static final List<String> TWO_TASK_PREDICATE_METHODS =
            Collections.singletonList("b0");
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

    public static List<String> panoramaActiveMethods() {
        return PANORAMA_ACTIVE_METHODS;
    }

    public static List<String> panoramaEnterMethods() {
        return PANORAMA_ENTER_METHODS;
    }

    public static List<String> panoramaExitMethods() {
        return PANORAMA_EXIT_METHODS;
    }

    public static List<String> twoTaskPredicateMethods() {
        return TWO_TASK_PREDICATE_METHODS;
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
