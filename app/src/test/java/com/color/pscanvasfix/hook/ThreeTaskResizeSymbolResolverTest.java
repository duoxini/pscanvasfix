package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;

import org.junit.Assume;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Offline fail-closed contract for all OEM paths unblocked by three-task resize. */
public final class ThreeTaskResizeSymbolResolverTest {
    private static final String CONTAINER_VIEW =
            "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView";
    private static final String SPRING_CONTROLLER =
            "com.oplus.pscanvas.canvasmode.canvas.E";
    private static final String SPRING_STATE =
            "Lcom/oplus/pscanvas/canvasmode/canvas/E$c;";

    @Test
    public void onlyNewGenerationFixturesExposeCompleteResizeContract() {
        String directory = System.getProperty("pscanvas.apk.dir", "").trim();
        Assume.assumeTrue("set -Dpscanvas.apk.dir=<fixture directory>",
                !directory.isEmpty());
        String[] versions = {"251215", "260403", "260512", "260608"};
        for (String version : versions) {
            File apk = new File(directory, "\u591a\u7a97\u53e3(" + version + ").apk");
            assertTrue("missing exact fixture " + apk, apk.isFile());
            RoleSymbol symbol = PsCanvasSymbolResolver.resolve(
                    DexClassScanner.scanApk(apk)).role(Role.THREE_TASK_RESIZE);
            if ("251215".equals(version)) {
                assertFalse("classic fixture has no 700 spring path", symbol.available());
            } else {
                assertTrue("resize role for " + version, symbol.available());
                assertEquals(CONTAINER_VIEW, symbol.className);
                assertEquals(SPRING_CONTROLLER, symbol.threeTaskResizeSpringClass);
                assertEquals("f3", symbol.threeTaskResizeRectUpdateMethod);
                assertEquals("E2", symbol.threeTaskResizeScrollStartMethod);
                assertEquals("i2", symbol.threeTaskResizeEnlargeMethod);
                assertEquals("i1", symbol.threeTaskResizePredicateMethod);
                assertTrue(symbol.threeTaskResizeSpringDragMethod.equals("u0")
                        || symbol.threeTaskResizeSpringDragMethod.equals("v0"));
                assertEquals("R", symbol.threeTaskResizeSpringInitMethod);
            }
        }
    }

    @Test
    public void missingAnyUnblockedEntryFailsClosed() {
        List<DexClass> complete = fixtureClasses();
        assertTrue(PsCanvasSymbolResolver.resolve(complete)
                .role(Role.THREE_TASK_RESIZE).available());

        DexClass spring = complete.get(1);
        spring.methods.remove(spring.methods.size() - 1);
        RoleSymbol missing = PsCanvasSymbolResolver.resolve(complete)
                .role(Role.THREE_TASK_RESIZE);
        assertFalse(missing.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, missing.status);
    }

    private static List<DexClass> fixtureClasses() {
        List<DexClass> classes = new ArrayList<>();
        DexClass container = new DexClass(CONTAINER_VIEW);
        container.methods.add(method("f3", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_LIST));
        container.methods.add(method("E2", MethodMatcher.DESC_LIST));
        container.methods.add(method("i2", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_LIST, "F", "F", SPRING_STATE));
        container.methods.add(method("i1", MethodMatcher.DESC_BOOLEAN));
        classes.add(container);
        DexClass spring = new DexClass(SPRING_CONTROLLER);
        spring.methods.add(method("v0", MethodMatcher.DESC_VOID,
                SPRING_STATE, "F", "F", "F", "F"));
        spring.methods.add(method("R", MethodMatcher.DESC_VOID));
        classes.add(spring);
        return classes;
    }

    private static DexMethod method(String name, String returnDescriptor,
                                    String... parameters) {
        return new DexMethod(name, returnDescriptor, Arrays.asList(parameters));
    }
}
