package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
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
        DexClass spring = findClass(dexClasses, SPRING_CONTROLLER);
        if (container == null || spring == null) {
            symbol.status = Status.SKIPPED;
            symbol.source = Source.NONE;
            return;
        }

        DexMethod rectUpdate = uniqueNamed(container, "f3", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_LIST);
        DexMethod scrollStart = uniqueNamed(container, "E2", MethodMatcher.DESC_LIST);
        DexMethod enlarge = uniqueNamed(container, "i2", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_LIST, "F", "F", SPRING_STATE);
        DexMethod threeTask = uniqueNamed(container, "i1", MethodMatcher.DESC_BOOLEAN);
        DexMethod springDrag = uniqueSignature(spring, MethodMatcher.DESC_VOID,
                SPRING_STATE, "F", "F", "F", "F");
        DexMethod springInit = uniqueNamed(spring, "R", MethodMatcher.DESC_VOID);

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
                Arrays.asList("f3", "E2", "i2", "i1", "E.springDrag", "E.R"));
        if (rectUpdate == null || scrollStart == null || enlarge == null
                || threeTask == null || springDrag == null || springInit == null) {
            symbol.status = Status.AMBIGUOUS;
            symbol.source = Source.KNOWN_SYMBOL;
            return;
        }

        symbol.status = Status.FALLBACK;
        symbol.source = Source.KNOWN_SYMBOL;
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
