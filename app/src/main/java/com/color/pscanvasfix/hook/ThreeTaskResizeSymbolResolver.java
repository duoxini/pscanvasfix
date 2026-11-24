package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.ResizeFocusMethods;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Source;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Status;

import java.util.Arrays;
import java.util.List;

/** Validates every OEM entry point that is unblocked for three-task resizing. */
final class ThreeTaskResizeSymbolResolver {
    private static final String CONTAINER_VIEW =
            "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView";
    private static final String SPRING_CONTROLLER =
            "com.oplus.pscanvas.canvasmode.canvas.E";
    private static final String SPRING_STATE =
            "Lcom/oplus/pscanvas/canvasmode/canvas/E$c;";

    private ThreeTaskResizeSymbolResolver() {
    }

    static void resolveInto(PsCanvasSymbols out, List<DexClass> dexClasses) {
        RoleSymbol symbol = out.role(Role.THREE_TASK_RESIZE);
        DexClass container = findClass(dexClasses, CONTAINER_VIEW);
        DexClass updatedSpring = findClass(dexClasses, KnownSymbolHints.SPRING_CONTROLLER);
        if (container != null && updatedSpring != null && resolveContract(symbol, container,
                updatedSpring, KnownSymbolHints.SPRING_STATE_DESCRIPTOR,
                "o3", "N2", "p2", "o1", "S")) {
            symbol.resizeFocusMethods = resolveFocusMethods(container, dexClasses);
            symbol.threeTaskResizeCanAlignThreshold = symbol.resizeFocusMethods != null
                    && canAlignThreshold(container);
            return;
        }
        DexClass spring = findClass(dexClasses, SPRING_CONTROLLER);
        if (container == null || spring == null) {
            symbol.status = Status.SKIPPED;
            symbol.source = Source.NONE;
            return;
        }

        resolveContract(symbol, container, spring, SPRING_STATE,
                "f3", "E2", "i2", "i1", "R");
    }

    private static ResizeFocusMethods resolveFocusMethods(
            DexClass container, List<DexClass> dexClasses) {
        ResizeFocusMethods methods = KnownSymbolHints.RESIZE_FOCUS_METHODS;
        String state = KnownSymbolHints.SPRING_STATE_DESCRIPTOR;
        String controller = KnownSymbolHints.CONTROLLER;
        String adapter = KnownSymbolHints.RESIZE_FOCUS_ADAPTER;
        if (uniqueNamed(findClass(dexClasses, methods.policyClass()),
                methods.calculateDragMode(), MethodMatcher.DESC_BOOLEAN,
                descriptor(container.name), state, "F", "F") == null
                || uniqueNamed(findSpringState(dexClasses), methods.verticalBar(),
                        MethodMatcher.DESC_BOOLEAN) == null
                || uniqueNamed(container, "getContainerController", descriptor(controller)) == null
                || uniqueNamed(findClass(dexClasses, controller),
                        methods.selectFocus(), MethodMatcher.DESC_VOID, "I") == null
                || uniqueNamed(container, "getAdapter", descriptor(adapter)) == null
                || uniqueNamed(findClass(dexClasses, adapter), methods.focusedIndex(), "I") == null) {
            return null;
        }
        return methods;
    }

    private static boolean canAlignThreshold(DexClass container) {
        return uniqueNamed(container, "getDragModeType", "I") != null
                && uniqueNamed(container, "getDragModes", "[F") != null
                && uniqueNamed(container, "setDragModes", MethodMatcher.DESC_VOID, "[F") != null
                && uniqueNamed(container, "getDragTargetAction", "[I") != null
                && uniqueNamed(container, "getWindowMetricsBounds", MethodMatcher.DESC_RECT) != null
                && uniqueNamed(container, "getOriginalLocations", MethodMatcher.DESC_LIST) != null;
    }

    private static DexClass findSpringState(List<DexClass> dexClasses) {
        String state = KnownSymbolHints.SPRING_STATE_DESCRIPTOR;
        return findClass(dexClasses, state.substring(1, state.length() - 1).replace('/', '.'));
    }

    private static String descriptor(String className) {
        return "L" + className.replace('.', '/') + ";";
    }

    private static boolean resolveContract(RoleSymbol symbol, DexClass container, DexClass spring,
                                           String springState, String rectUpdateName,
                                           String scrollStartName, String enlargeName,
                                           String threeTaskName, String springInitName) {
        DexMethod rectUpdate = uniqueNamed(container, rectUpdateName, MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_LIST);
        DexMethod scrollStart = uniqueNamed(container, scrollStartName, MethodMatcher.DESC_LIST);
        DexMethod enlarge = uniqueNamed(container, enlargeName, MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_LIST, "F", "F", springState);
        DexMethod threeTask = uniqueNamed(container, threeTaskName, MethodMatcher.DESC_BOOLEAN);
        DexMethod springDrag = uniqueSignature(spring, MethodMatcher.DESC_VOID,
                springState, "F", "F", "F", "F");
        DexMethod springInit = uniqueNamed(spring, springInitName, MethodMatcher.DESC_VOID);

        symbol.className = container.name;
        symbol.threeTaskResizeSpringClass = spring.name;
        symbol.threeTaskResizeRectUpdateMethod = nameOf(rectUpdate);
        symbol.threeTaskResizeScrollStartMethod = nameOf(scrollStart);
        symbol.threeTaskResizeEnlargeMethod = nameOf(enlarge);
        symbol.threeTaskResizePredicateMethod = nameOf(threeTask);
        symbol.threeTaskResizeSpringDragMethod = nameOf(springDrag);
        symbol.threeTaskResizeSpringInitMethod = nameOf(springInit);
        symbol.threeTaskResizeSpringStateClass = "c";
        symbol.score = 10 * countPresent(rectUpdate, scrollStart, enlarge,
                threeTask, springDrag, springInit);
        symbol.addCandidate(container.name, symbol.score,
                Arrays.asList(rectUpdateName, scrollStartName, enlargeName,
                        threeTaskName, "springDrag", springInitName));
        if (rectUpdate == null || scrollStart == null || enlarge == null
                || threeTask == null || springDrag == null || springInit == null) {
            symbol.status = Status.AMBIGUOUS;
            symbol.source = Source.KNOWN_SYMBOL;
            return false;
        }

        symbol.status = Status.FALLBACK;
        symbol.source = Source.KNOWN_SYMBOL;
        return true;
    }

    private static DexClass findClass(List<DexClass> classes, String name) {
        DexClass match = null;
        for (DexClass cls : classes) {
            if (!name.equals(cls.name)) {
                continue;
            }
            if (match != null) {
                return null;
            }
            match = cls;
        }
        return match;
    }

    private static DexMethod uniqueNamed(DexClass cls, String name,
                                         String returnType, String... parameters) {
        if (cls == null) {
            return null;
        }
        DexMethod match = null;
        for (DexMethod method : cls.methods) {
            if (!name.equals(method.name)
                    || !returnType.equals(method.returnDescriptor)
                    || !method.paramDescriptors.equals(Arrays.asList(parameters))) {
                continue;
            }
            if (match != null) {
                return null;
            }
            match = method;
        }
        return match;
    }

    private static DexMethod uniqueSignature(DexClass cls, String returnType,
                                             String... parameters) {
        DexMethod match = null;
        for (DexMethod method : cls.methods) {
            if (!returnType.equals(method.returnDescriptor)
                    || !method.paramDescriptors.equals(Arrays.asList(parameters))) {
                continue;
            }
            if (match != null) {
                return null;
            }
            match = method;
        }
        return match;
    }

    private static int countPresent(Object... values) {
        int count = 0;
        for (Object value : values) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }

    private static String nameOf(DexMethod method) {
        return method == null ? null : method.name;
    }
}
