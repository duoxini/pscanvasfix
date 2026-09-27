package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.feature.FourTaskTraceFeature;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.util.Collection;
import java.util.Objects;

/**
 * Best-effort, observer-only snapshots for the P4 trace hooks.
 * Bounds are copies of event-local bind/request arguments, never actual WM bounds.
 */
public final class FourTaskTraceSnapshotReader
        implements FourTaskTraceFeature.SnapshotReader {
    private static final int UNAVAILABLE = -1;

    private final ReflectionAccess reflection;
    private final PsCanvasSymbols.RoleSymbol config;

    public FourTaskTraceSnapshotReader(ReflectionAccess reflection,
                                       PsCanvasSymbols.RoleSymbol config) {
        this.reflection = Objects.requireNonNull(reflection, "reflection");
        this.config = Objects.requireNonNull(config, "config");
    }

    @Override
    public FourTaskTraceFeature.Snapshot capture(String event, String phase,
                                                 Object receiver, Object candidate,
                                                 Object[] arguments) {
        if ("controller_append".equals(event)
                || "controller_remove".equals(event)
                || "controller_focus".equals(event)) {
            return controllerSnapshot(receiver, candidate);
        }
        if ("adapter_insert".equals(event) || "adapter_remove".equals(event)) {
            return adapterSnapshot(receiver, candidate);
        }
        if ("decor_bind".equals(event)) {
            return taskDataSnapshot(candidate, UNAVAILABLE, UNAVAILABLE, UNAVAILABLE,
                    null, readBounds(argument(arguments, 1)));
        }
        if ("task_created".equals(event)) {
            return snapshot(UNAVAILABLE, UNAVAILABLE, UNAVAILABLE,
                    readIntArgument(arguments, 0),
                    readComponent(argument(arguments, 1)), null);
        }
        if ("bounds_submit".equals(event)) {
            return flexibleTaskSnapshot(receiver, readBounds(argument(arguments, 0)));
        }
        if ("flexible_release".equals(event)) {
            return flexibleTaskSnapshot(receiver, null);
        }
        if ("decor_attach".equals(event)) {
            Object taskData = readObjectField(receiver, config.p4DecorTaskDataField);
            return taskDataSnapshot(taskData, UNAVAILABLE, UNAVAILABLE, UNAVAILABLE,
                    null, null);
        }
        return FourTaskTraceFeature.Snapshot.unavailable();
    }

    private FourTaskTraceFeature.Snapshot controllerSnapshot(Object controller,
                                                               Object candidate) {
        int taskDataCount = readCount(controller, config.p4ControllerTaskCountMethod);
        Object adapter = readObjectField(controller, config.p4ControllerAdapterField);
        int adapterCount = readCount(adapter, config.p4AdapterCountMethod);
        int childCount = readChildrenCount(controller,
                config.p4ControllerContainerField, config.p4ContainerChildrenGetter);
        return taskDataSnapshot(candidate, adapterCount, childCount, taskDataCount,
                readTaskIds(adapter, adapterCount), null);
    }

    private FourTaskTraceFeature.Snapshot adapterSnapshot(Object adapter,
                                                           Object candidate) {
        int adapterCount = readCount(adapter, config.p4AdapterCountMethod);
        return taskDataSnapshot(candidate, adapterCount, UNAVAILABLE, UNAVAILABLE,
                readTaskIds(adapter, adapterCount), null);
    }

    private FourTaskTraceFeature.Snapshot taskDataSnapshot(
            Object taskData, int adapterCount, int childCount, int taskDataCount,
            int[] taskIds, FourTaskTraceFeature.Bounds eventBounds) {
        int taskId = readTaskId(taskData);
        int slot = UNAVAILABLE;
        if (taskIds != null && taskId >= 0) {
            for (int index = 0; index < taskIds.length; index++) {
                if (taskIds[index] == taskId) {
                    slot = index;
                    break;
                }
            }
        }
        return new FourTaskTraceFeature.Snapshot(
                adapterCount, childCount, taskDataCount, slot, taskId, taskIds,
                readTaskDataComponent(taskData), eventBounds);
    }

    private FourTaskTraceFeature.Snapshot flexibleTaskSnapshot(
            Object flexibleTaskView, FourTaskTraceFeature.Bounds bounds) {
        return new FourTaskTraceFeature.Snapshot(
                UNAVAILABLE, UNAVAILABLE, UNAVAILABLE, UNAVAILABLE,
                readCount(flexibleTaskView, config.p4FlexibleTaskIdMethod),
                null, null, bounds);
    }

    private int[] readTaskIds(Object adapter, int count) {
        if (adapter == null || count < 0 || config.p4AdapterItemMethod == null) {
            return null;
        }
        int[] taskIds = new int[count];
        for (int index = 0; index < count; index++) {
            try {
                Object taskData = reflection.callMethod(
                        adapter, config.p4AdapterItemMethod, index);
                taskIds[index] = readTaskId(taskData);
            } catch (Throwable ignored) {
                taskIds[index] = UNAVAILABLE;
            }
        }
        return taskIds;
    }

    private int readTaskId(Object taskData) {
        return readCount(taskData, config.p4TaskDataTaskIdMethod);
    }

    private String readTaskDataComponent(Object taskData) {
        if (taskData == null || config.p4TaskDataIntentMethod == null) {
            return null;
        }
        try {
            Object intent = reflection.callMethod(taskData, config.p4TaskDataIntentMethod);
            Object component = intent == null
                    ? null : reflection.callMethod(intent, "getComponent");
            return readComponent(component);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private int readChildrenCount(Object owner, String fieldName, String methodName) {
        Object container = readObjectField(owner, fieldName);
        if (container == null || methodName == null) {
            return UNAVAILABLE;
        }
        try {
            Object children = reflection.callMethod(container, methodName);
            return children instanceof Collection<?>
                    ? ((Collection<?>) children).size() : UNAVAILABLE;
        } catch (Throwable ignored) {
            return UNAVAILABLE;
        }
    }

    private Object readObjectField(Object owner, String fieldName) {
        if (owner == null || fieldName == null) {
            return null;
        }
        try {
            return reflection.getObjectField(owner, fieldName);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private int readCount(Object receiver, String methodName) {
        if (receiver == null || methodName == null) {
            return UNAVAILABLE;
        }
        try {
            Object value = reflection.callMethod(receiver, methodName);
            return value instanceof Number ? ((Number) value).intValue() : UNAVAILABLE;
        } catch (Throwable ignored) {
            return UNAVAILABLE;
        }
    }

    private int readIntArgument(Object[] arguments, int index) {
        Object value = argument(arguments, index);
        return value instanceof Number ? ((Number) value).intValue() : UNAVAILABLE;
    }

    private String readComponent(Object component) {
        if (component == null) {
            return null;
        }
        try {
            Object value = reflection.callMethod(component, "flattenToShortString");
            return value instanceof String ? (String) value : null;
        } catch (Throwable ignored) {
            return null;
        }
    }

    private FourTaskTraceFeature.Bounds readBounds(Object rect) {
        if (rect == null) {
            return null;
        }
        return new FourTaskTraceFeature.Bounds(
                readRectCoordinate(rect, "left"),
                readRectCoordinate(rect, "top"),
                readRectCoordinate(rect, "right"),
                readRectCoordinate(rect, "bottom"));
    }

    private int readRectCoordinate(Object rect, String fieldName) {
        try {
            return reflection.getIntField(rect, fieldName);
        } catch (Throwable ignored) {
            return UNAVAILABLE;
        }
    }

    private static Object argument(Object[] arguments, int index) {
        return arguments != null && index >= 0 && index < arguments.length
                ? arguments[index] : null;
    }

    private static FourTaskTraceFeature.Snapshot snapshot(
            int adapterCount, int childCount, int taskDataCount, int taskId,
            String component, FourTaskTraceFeature.Bounds bounds) {
        return new FourTaskTraceFeature.Snapshot(
                adapterCount, childCount, taskDataCount,
                UNAVAILABLE, taskId, null, component, bounds);
    }
}
