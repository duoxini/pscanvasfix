package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexField;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;

import org.junit.Assume;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/** Offline contract tests for the debug-only P4 trace symbol chain. */
public final class P4TraceSymbolResolverTest {
    private static final String CONTAINER =
            "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView";
    private static final String DECOR =
            "com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor";
    private static final String CALLBACK = DECOR + "$FlexibleTaskViewCallback";
    private static final String FLEXIBLE = "com.oplus.flexiblewindow.FlexibleTaskView";

    private static final String[][] EXPECTED = {
            {"251215", "com.oplus.pscanvas.canvasmode.canvas.l0", "p1.c", "Lp1/d;",
                    "b", "A", "F", "i", "a0"},
            {"260403", "com.oplus.pscanvas.canvasmode.canvas.r0", "u1.c", "Lu1/d;",
                    "d", "B", "G", "k", "j0"},
            {"260512", "com.oplus.pscanvas.canvasmode.canvas.s0", "u1.c", "Lu1/d;",
                    "d", "B", "G", "k", "j0"},
            {"260608", "com.oplus.pscanvas.canvasmode.canvas.s0", "u1.c", "Lu1/d;",
                    "d", "B", "G", "k", "k0"},
    };

    @Test
    public void resolvesCompleteP4TraceChainAcrossExactFourFixtures() {
        String directory = System.getProperty("pscanvas.apk.dir", "").trim();
        Assume.assumeTrue("set -Dpscanvas.apk.dir=<fixture directory>",
                !directory.isEmpty());
        for (String[] expected : EXPECTED) {
            File apk = new File(directory, "多窗口(" + expected[0] + ").apk");
            assertTrue("missing exact fixture " + apk, apk.isFile());
            PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(
                    DexClassScanner.scanApk(apk));
            RoleSymbol p4 = symbols.role(Role.P4_TRACE_CHAIN);

            assertTrue("P4 trace chain for " + expected[0] + " "
                    + (p4.candidates.isEmpty() ? "no-candidate"
                    : p4.candidates.get(0).hints), p4.available());
            assertEquals(PsCanvasSymbols.Status.FALLBACK, p4.status);
            assertEquals(PsCanvasSymbols.Source.KNOWN_SYMBOL, p4.source);
            assertEquals(expected[1], p4.className);
            assertEquals(expected[2], p4.p4AdapterClass);
            assertEquals(expected[3], p4.p4TaskDataDescriptor);
            assertEquals(expected[4], p4.p4ControllerAppendMethod);
            assertEquals(expected[5], p4.p4ControllerRemoveMethod);
            assertEquals(expected[6], p4.p4ControllerFocusMethod);
            assertEquals(expected[7], p4.p4ControllerTaskCountMethod);
            assertEquals(expected[8], p4.p4EmbeddedBindMethod);
            assertEquals("a", p4.p4ControllerContainerField);
            assertEquals("b", p4.p4ControllerAdapterField);
            assertEquals("getAdapter", p4.p4ContainerAdapterGetter);
            assertEquals("getContainerController", p4.p4ContainerControllerGetter);
            assertEquals("getChildEmbeddedViewList", p4.p4ContainerChildrenGetter);
            assertEquals("a", p4.p4AdapterAddMethod);
            assertTrue(Arrays.asList("V", "X").contains(p4.p4AdapterRemoveMethod));
            assertEquals("getCount", p4.p4AdapterCountMethod);
            assertEquals("getItem", p4.p4AdapterItemMethod);
            assertEquals("f", p4.p4TaskDataIntentMethod);
            assertEquals("251215".equals(expected[0]) ? "q"
                    : "260403".equals(expected[0]) ? "s" : "t",
                    p4.p4TaskDataTaskIdMethod);
            assertEquals(DECOR, p4.p4EmbeddedViewDecorClass);
            assertEquals("onAttachedToWindow", p4.p4EmbeddedAttachedMethod);
            assertTrue(p4.p4DecorTaskDataField != null);
            assertEquals(CALLBACK, p4.p4TaskCreatedCallbackClass);
            assertEquals("onTaskCreated", p4.p4TaskCreatedMethod);
            assertEquals(FLEXIBLE, p4.p4FlexibleTaskViewClass);
            assertEquals("resize", p4.p4FlexibleResizeMethod);
            assertEquals("release", p4.p4FlexibleReleaseMethod);
            assertTrue(p4.p4FlexibleTaskIdMethod == null
                    || "getTaskId".equals(p4.p4FlexibleTaskIdMethod));

            String report = CapabilityReport.render(null, 0, symbols);
            assertTrue(report.contains("p4TraceChain=ENABLED"));
            assertTrue(report.contains("p4.controllerAppend=" + expected[4]));
            System.out.println("P4 " + expected[0] + ": controller=" + p4.className
                    + " append=" + p4.p4ControllerAppendMethod
                    + " adapter=" + p4.p4AdapterClass + "." + p4.p4AdapterAddMethod
                    + " bind=" + p4.p4EmbeddedBindMethod
                    + " attached=" + p4.p4EmbeddedAttachedMethod
                    + " created=" + p4.p4TaskCreatedMethod
                    + " resize=" + p4.p4FlexibleResizeMethod);
        }
    }

    @Test
    public void unknownControllerAppendHintFailsClosed() {
        PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(
                syntheticTraceClasses("unknown", false));
        RoleSymbol p4 = symbols.role(Role.P4_TRACE_CHAIN);

        assertFalse(p4.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, p4.status);
        assertNull(p4.p4ControllerAppendMethod);
    }

    @Test
    public void multipleHintedControllerAppendMethodsFailClosed() {
        PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(
                syntheticTraceClasses("d", true));
        RoleSymbol p4 = symbols.role(Role.P4_TRACE_CHAIN);

        assertFalse(p4.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, p4.status);
    }

    @Test
    public void p4RoleDoesNotBroadenLegacyCanvasControllerRole() {
        PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolve(
                syntheticTraceClasses("d", false));
        RoleSymbol p4 = symbols.role(Role.P4_TRACE_CHAIN);
        RoleSymbol legacy = symbols.role(Role.CANVAS_CONTROLLER);

        assertTrue(p4.available());
        assertNull(legacy.p4ControllerAppendMethod);
        assertFalse(p4 == legacy);
    }

    private static List<DexClass> syntheticTraceClasses(String appendName,
                                                        boolean addSecondAppend) {
        String task = "Lfixture/TaskData;";
        String adapterDescriptor = "Lfixture/Adapter;";
        String controllerDescriptor = "Lfixture/Controller;";
        DexClass container = dexClass(CONTAINER);
        container.methods.add(method("getAdapter", adapterDescriptor));
        container.methods.add(method("getContainerController", controllerDescriptor));
        container.methods.add(method("getChildEmbeddedViewList", MethodMatcher.DESC_LIST));

        DexClass controller = dexClass("fixture.Controller");
        controller.fields.add(field("container", MethodMatcher.DESC_CONTAINER_VIEW));
        controller.fields.add(field("adapter", adapterDescriptor));
        controller.methods.add(method(appendName, MethodMatcher.DESC_VOID, task));
        if (addSecondAppend) {
            controller.methods.add(method("b", MethodMatcher.DESC_VOID, task));
        }
        controller.methods.add(method("B", MethodMatcher.DESC_VOID, task));
        controller.methods.add(method("G", MethodMatcher.DESC_VOID, task));
        controller.methods.add(method("k", MethodMatcher.DESC_INT));

        DexClass adapter = dexClass("fixture.Adapter");
        adapter.methods.add(method("a", MethodMatcher.DESC_VOID, task));
        adapter.methods.add(method("X", MethodMatcher.DESC_VOID, task));
        adapter.methods.add(method("getCount", MethodMatcher.DESC_INT));
        adapter.methods.add(method("getItem", task, MethodMatcher.DESC_INT));

        DexClass taskData = dexClass("fixture.TaskData");
        taskData.methods.add(method("f", MethodMatcher.DESC_INTENT));
        taskData.methods.add(method("u", MethodMatcher.DESC_COMPONENT_NAME));
        taskData.methods.add(method("t", MethodMatcher.DESC_INT));

        DexClass decor = dexClass(DECOR);
        decor.fields.add(field("task", task));
        decor.fields.add(field("view", MethodMatcher.DESC_FLEXIBLE_TASK_VIEW));
        decor.fields.add(field("listener", MethodMatcher.DESC_FLEXIBLE_TASK_VIEW_LISTENER));
        decor.methods.add(method("getTaskData", task));
        decor.methods.add(method("bind", MethodMatcher.DESC_VOID,
                task, MethodMatcher.DESC_RECT, "F"));
        decor.methods.add(method("onAttachedToWindow", MethodMatcher.DESC_VOID));

        DexClass callback = dexClass(CALLBACK);
        callback.methods.add(method("onTaskCreated", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_INT, MethodMatcher.DESC_COMPONENT_NAME));
        DexClass flexible = dexClass(FLEXIBLE);
        flexible.methods.add(method("resize", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_RECT));
        flexible.methods.add(method("release", MethodMatcher.DESC_VOID));
        flexible.methods.add(method("getTaskId", MethodMatcher.DESC_INT));
        return new ArrayList<>(Arrays.asList(
                container, controller, adapter, taskData, decor, callback, flexible));
    }

    private static DexClass dexClass(String name) {
        return new DexClass(name);
    }

    private static DexField field(String name, String descriptor) {
        return new DexField(name, descriptor);
    }

    private static DexMethod method(String name, String result, String... params) {
        return new DexMethod(name, result,
                params.length == 0 ? Collections.emptyList() : Arrays.asList(params));
    }
}
