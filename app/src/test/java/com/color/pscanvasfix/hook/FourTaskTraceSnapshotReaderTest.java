package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.feature.FourTaskTraceFeature;
import com.color.pscanvasfix.runtime.JavaReflectionBackend;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public final class FourTaskTraceSnapshotReaderTest {
    @Test
    public void controllerAppendReadsThreeIndependentCounts() {
        Fixture fixture = new Fixture();
        FourTaskTraceFeature.Snapshot snapshot = reader(symbols()).capture(
                "controller_append", "after", fixture.controller, fixture.taskData,
                new Object[]{fixture.taskData});

        assertEquals(3, snapshot.adapterCount);
        assertEquals(3, snapshot.containerChildCount);
        assertEquals(3, snapshot.taskDataCount);
        assertEquals(2, snapshot.slot);
        assertEquals(103, snapshot.taskId);
        assertArrayEquals(new int[]{101, 102, 103}, snapshot.taskIds);
        assertEquals("pkg/.Task103", snapshot.componentName);
    }

    @Test
    public void countFailuresStayLocalToTheirSnapshotFields() {
        PsCanvasSymbols.RoleSymbol symbols = symbols();
        Fixture fixture = new Fixture();

        fixture.controller.failTaskCount = true;
        FourTaskTraceFeature.Snapshot taskFailure = reader(symbols).capture(
                "controller_append", "after", fixture.controller, null, null);
        assertEquals(3, taskFailure.adapterCount);
        assertEquals(3, taskFailure.containerChildCount);
        assertEquals(-1, taskFailure.taskDataCount);

        fixture.controller.failTaskCount = false;
        fixture.controller.adapter.failCount = true;
        FourTaskTraceFeature.Snapshot adapterFailure = reader(symbols).capture(
                "controller_append", "after", fixture.controller, null, null);
        assertEquals(-1, adapterFailure.adapterCount);
        assertEquals(3, adapterFailure.containerChildCount);
        assertEquals(3, adapterFailure.taskDataCount);

        fixture.controller.adapter.failCount = false;
        fixture.controller.container.failChildren = true;
        FourTaskTraceFeature.Snapshot childFailure = reader(symbols).capture(
                "controller_append", "after", fixture.controller, null, null);
        assertEquals(3, childFailure.adapterCount);
        assertEquals(-1, childFailure.containerChildCount);
        assertEquals(3, childFailure.taskDataCount);
    }

    @Test
    public void adapterInsertReadsCountOnlyFromReceiver() {
        Adapter receiver = new Adapter();
        receiver.items.addAll(Arrays.asList(
                new TaskData(201), new TaskData(202), new TaskData(203)));
        TaskData candidate = (TaskData) receiver.items.get(2);
        FourTaskTraceFeature.Snapshot snapshot = reader(symbols()).capture(
                "adapter_insert", "after", receiver, candidate, new Object[0]);

        assertEquals(3, snapshot.adapterCount);
        assertEquals(2, snapshot.slot);
        assertEquals(203, snapshot.taskId);
        assertArrayEquals(new int[]{201, 202, 203}, snapshot.taskIds);
        assertEquals(-1, snapshot.containerChildCount);
        assertEquals(-1, snapshot.taskDataCount);
    }

    @Test
    public void taskCreatedUsesOnlyPrimitiveIdAndFlattenedComponent() {
        Component component = new Component();
        Object[] arguments = {Integer.valueOf(41), component};

        FourTaskTraceFeature.Snapshot snapshot = reader(symbols()).capture(
                "task_created", "after", new Object(), component, arguments);

        assertEquals(41, snapshot.taskId);
        assertEquals("pkg/.Fourth\nActivity", snapshot.componentName);
        assertEquals(1, component.flattenCalls);
        assertArrayEquals(new Object[]{Integer.valueOf(41), component}, arguments);
    }

    @Test
    public void decorAndSubmitBoundsAreIndependentPrimitiveCopies() {
        MutableRect bindRect = new MutableRect(10, 20, 310, 620);
        MutableRect submitRect = new MutableRect(30, 40, 330, 640);
        Object[] bindArguments = {new Object(), bindRect, Float.valueOf(1f)};
        Object[] submitArguments = {submitRect};

        FourTaskTraceFeature.Snapshot bind = reader(symbols()).capture(
                "decor_bind", "after", new Object(), new Object(), bindArguments);
        FourTaskTraceFeature.Snapshot submit = reader(symbols()).capture(
                "bounds_submit", "after", new Object(), submitRect, submitArguments);

        bindRect.left = 99;
        submitRect.bottom = 999;
        assertBounds(bind.bounds, 10, 20, 310, 620);
        assertBounds(submit.bounds, 30, 40, 330, 640);
        assertArrayEquals(new Object[]{bindArguments[0], bindRect, Float.valueOf(1f)},
                bindArguments);
        assertArrayEquals(new Object[]{submitRect}, submitArguments);
    }

    @Test
    public void oneUnreadableRectCoordinateDoesNotHideTheOthers() {
        PartiallyReadableRect rect = new PartiallyReadableRect();

        FourTaskTraceFeature.Snapshot snapshot = reader(symbols()).capture(
                "bounds_submit", "after", new Object(), rect, new Object[]{rect});

        assertBounds(snapshot.bounds, 1, -1, 301, 601);
    }

    @Test
    public void missingArgumentsAndUnknownEventsReturnUnavailableFields() {
        FourTaskTraceSnapshotReader reader = reader(symbols());

        FourTaskTraceFeature.Snapshot missing = reader.capture(
                "task_created", "after", null, null, new Object[0]);
        assertEquals(-1, missing.taskId);
        assertNull(missing.componentName);

        FourTaskTraceFeature.Snapshot unknown = reader.capture(
                "decor_attach", "after", null, null, null);
        assertEquals(-1, unknown.adapterCount);
        assertNull(unknown.bounds);
    }

    private static FourTaskTraceSnapshotReader reader(PsCanvasSymbols.RoleSymbol symbols) {
        return new FourTaskTraceSnapshotReader(
                new ReflectionAccess(new JavaReflectionBackend()), symbols);
    }

    private static PsCanvasSymbols.RoleSymbol symbols() {
        PsCanvasSymbols.RoleSymbol symbols =
                new PsCanvasSymbols.RoleSymbol(PsCanvasSymbols.Role.P4_TRACE_CHAIN);
        symbols.p4ControllerTaskCountMethod = "taskCount";
        symbols.p4ControllerAdapterField = "adapter";
        symbols.p4AdapterCountMethod = "getCount";
        symbols.p4AdapterItemMethod = "getItem";
        symbols.p4TaskDataTaskIdMethod = "taskId";
        symbols.p4TaskDataIntentMethod = "intent";
        symbols.p4DecorTaskDataField = "taskData";
        symbols.p4FlexibleTaskIdMethod = "getTaskId";
        symbols.p4ControllerContainerField = "container";
        symbols.p4ContainerChildrenGetter = "getChildren";
        return symbols;
    }

    private static void assertBounds(FourTaskTraceFeature.Bounds bounds,
                                     int left, int top, int right, int bottom) {
        assertEquals(left, bounds.left);
        assertEquals(top, bounds.top);
        assertEquals(right, bounds.right);
        assertEquals(bottom, bounds.bottom);
    }

    private static final class Fixture {
        final TaskData taskData = new TaskData(103);
        final Controller controller = new Controller();

        Fixture() {
            controller.adapter.items.addAll(
                    Arrays.asList(new TaskData(101), new TaskData(102), taskData));
            controller.container.children.addAll(
                    Arrays.asList(new Object(), new Object(), new Object()));
        }
    }

    private static final class Controller {
        final Adapter adapter = new Adapter();
        final Container container = new Container();
        boolean failTaskCount;

        @SuppressWarnings("unused")
        private int taskCount() {
            if (failTaskCount) {
                throw new IllegalStateException("task count unavailable");
            }
            return 3;
        }
    }

    private static final class Adapter {
        final List<Object> items = new ArrayList<>();
        boolean failCount;

        @SuppressWarnings("unused")
        private int getCount() {
            if (failCount) {
                throw new IllegalStateException("adapter count unavailable");
            }
            return items.size();
        }

        @SuppressWarnings("unused")
        private Object getItem(int index) {
            return items.get(index);
        }
    }

    private static final class Container {
        final List<Object> children = new ArrayList<>();
        boolean failChildren;

        @SuppressWarnings("unused")
        private List<Object> getChildren() {
            if (failChildren) {
                throw new IllegalStateException("children unavailable");
            }
            return children;
        }
    }

    private static final class TaskData {
        final int id;
        final Intent intent;

        TaskData(int id) {
            this.id = id;
            this.intent = new Intent(new Component("pkg/.Task" + id));
        }

        @SuppressWarnings("unused")
        private int taskId() {
            return id;
        }

        @SuppressWarnings("unused")
        private Intent intent() {
            return intent;
        }
    }

    private static final class Intent {
        final Component component;

        Intent(Component component) {
            this.component = component;
        }

        @SuppressWarnings("unused")
        private Component getComponent() {
            return component;
        }
    }

    private static final class Component {
        int flattenCalls;
        final String flattened;

        Component() {
            this("pkg/.Fourth\nActivity");
        }

        Component(String flattened) {
            this.flattened = flattened;
        }

        @SuppressWarnings("unused")
        private String flattenToShortString() {
            flattenCalls++;
            return flattened;
        }

        @Override
        public String toString() {
            throw new AssertionError("component must not be serialized");
        }
    }

    private static final class MutableRect {
        int left;
        int top;
        int right;
        int bottom;

        MutableRect(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    private static final class PartiallyReadableRect {
        int left = 1;
        String top = "unreadable as int";
        int right = 301;
        int bottom = 601;
    }
}
