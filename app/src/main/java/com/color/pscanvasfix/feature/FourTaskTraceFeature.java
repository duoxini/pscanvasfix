package com.color.pscanvasfix.feature;

import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.ModuleLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/** Observer-only trace hooks for the four-task feasibility gate. */
public final class FourTaskTraceFeature {
    public static final String GROUP_ID = "four_task_trace_observation";
    public static final String HOOK_CONTROLLER_APPEND =
            "trace.four_task.controller_append";
    public static final String HOOK_ADAPTER_INSERT =
            "trace.four_task.adapter_insert";
    public static final String HOOK_ADAPTER_REMOVE =
            "trace.four_task.adapter_remove";
    public static final String HOOK_CONTROLLER_REMOVE =
            "trace.four_task.controller_remove";
    public static final String HOOK_CONTROLLER_FOCUS =
            "trace.four_task.controller_focus";
    public static final String HOOK_DECOR_BIND =
            "trace.four_task.decor_bind";
    public static final String HOOK_DECOR_ATTACH =
            "trace.four_task.decor_attach";
    public static final String HOOK_TASK_CREATED =
            "trace.four_task.task_created";
    public static final String HOOK_BOUNDS_SUBMIT =
            "trace.four_task.bounds_submit";
    public static final String HOOK_FLEXIBLE_RELEASE =
            "trace.four_task.flexible_release";

    private static final String PREFIX = "[FourTask][Trace]";
    private static final AtomicLong SEQUENCE = new AtomicLong();
    private static final long TRACE_STARTED_NANOS = System.nanoTime();
    private static final String TRACE_SESSION = Long.toHexString(System.currentTimeMillis());

    private FourTaskTraceFeature() {
    }

    /** Immutable target contract supplied by the resolver/orchestration layer. */
    public static final class Config {
        public final Class<?> controllerClass;
        public final String controllerAppendMethod;
        public final String controllerRemoveMethod;
        public final String controllerFocusMethod;
        public final Class<?> adapterClass;
        public final String adapterInsertMethod;
        public final String adapterRemoveMethod;
        public final Class<?> taskDataClass;
        public final Class<?> decorClass;
        public final String decorBindMethod;
        public final String decorAttachMethod;
        public final Class<?> lifecycleClass;
        public final String taskCreatedMethod;
        public final Class<?> flexibleTaskViewClass;
        public final String boundsSubmitMethod;
        public final String flexibleReleaseMethod;
        public final Class<?> rectClass;
        public final Class<?> componentNameClass;

        public Config(Class<?> controllerClass, String controllerAppendMethod,
                      String controllerRemoveMethod, String controllerFocusMethod,
                      Class<?> adapterClass, String adapterInsertMethod,
                      String adapterRemoveMethod,
                      Class<?> taskDataClass,
                      Class<?> decorClass, String decorBindMethod,
                      String decorAttachMethod,
                      Class<?> lifecycleClass, String taskCreatedMethod,
                      Class<?> flexibleTaskViewClass, String boundsSubmitMethod,
                      String flexibleReleaseMethod,
                      Class<?> rectClass, Class<?> componentNameClass) {
            this.controllerClass = Objects.requireNonNull(controllerClass,
                    "controllerClass");
            this.controllerAppendMethod = requireName(controllerAppendMethod,
                    "controllerAppendMethod");
            this.controllerRemoveMethod = requireName(controllerRemoveMethod,
                    "controllerRemoveMethod");
            this.controllerFocusMethod = requireName(controllerFocusMethod,
                    "controllerFocusMethod");
            this.adapterClass = Objects.requireNonNull(adapterClass, "adapterClass");
            this.adapterInsertMethod = requireName(adapterInsertMethod,
                    "adapterInsertMethod");
            this.adapterRemoveMethod = requireName(adapterRemoveMethod,
                    "adapterRemoveMethod");
            this.taskDataClass = Objects.requireNonNull(taskDataClass, "taskDataClass");
            this.decorClass = Objects.requireNonNull(decorClass, "decorClass");
            this.decorBindMethod = requireName(decorBindMethod, "decorBindMethod");
            this.decorAttachMethod = requireName(decorAttachMethod,
                    "decorAttachMethod");
            this.lifecycleClass = Objects.requireNonNull(lifecycleClass,
                    "lifecycleClass");
            this.taskCreatedMethod = requireName(taskCreatedMethod, "taskCreatedMethod");
            this.flexibleTaskViewClass = Objects.requireNonNull(flexibleTaskViewClass,
                    "flexibleTaskViewClass");
            this.boundsSubmitMethod = requireName(boundsSubmitMethod,
                    "boundsSubmitMethod");
            this.flexibleReleaseMethod = optionalName(flexibleReleaseMethod,
                    "flexibleReleaseMethod");
            this.rectClass = Objects.requireNonNull(rectClass, "rectClass");
            this.componentNameClass = Objects.requireNonNull(componentNameClass,
                    "componentNameClass");
        }
    }

    /** Read-only snapshot boundary implemented with already-resolved accessors. */
    @FunctionalInterface
    public interface SnapshotReader {
        Snapshot capture(String event, String phase, Object receiver,
                         Object candidate, Object[] arguments) throws Throwable;
    }

    /** Values safe to emit without serializing OEM objects or full intents. */
    public static final class Snapshot {
        public final int adapterCount;
        public final int containerChildCount;
        public final int taskDataCount;
        public final int slot;
        public final int taskId;
        public final int[] taskIds;
        public final String componentName;
        public final Bounds bounds;

        public Snapshot(int adapterCount, int containerChildCount, int taskDataCount,
                        int slot, int taskId, int[] taskIds, String componentName,
                        Bounds bounds) {
            this.adapterCount = adapterCount;
            this.containerChildCount = containerChildCount;
            this.taskDataCount = taskDataCount;
            this.slot = slot;
            this.taskId = taskId;
            this.taskIds = taskIds == null ? new int[0] : taskIds.clone();
            this.componentName = componentName;
            this.bounds = bounds;
        }

        public static Snapshot unavailable() {
            return new Snapshot(-1, -1, -1, -1, -1, null, null, null);
        }
    }

    /** Primitive rectangle copy that does not depend on Android framework types. */
    public static final class Bounds {
        public final int left;
        public final int top;
        public final int right;
        public final int bottom;

        public Bounds(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    public static void declareHooks(HookRegistry hookRegistry, Config config) {
        Objects.requireNonNull(hookRegistry, "hookRegistry");
        Objects.requireNonNull(config, "config");
        hookRegistry.declare(HOOK_CONTROLLER_APPEND,
                target(config.controllerClass, config.controllerAppendMethod)
                        + "(TaskData); before+after observer");
        hookRegistry.declare(HOOK_ADAPTER_INSERT,
                target(config.adapterClass, config.adapterInsertMethod)
                        + "(TaskData); after observer");
        hookRegistry.declare(HOOK_ADAPTER_REMOVE,
                target(config.adapterClass, config.adapterRemoveMethod)
                        + "(TaskData); before+after observer");
        hookRegistry.declare(HOOK_CONTROLLER_REMOVE,
                target(config.controllerClass, config.controllerRemoveMethod)
                        + "(TaskData); before+after observer");
        hookRegistry.declare(HOOK_CONTROLLER_FOCUS,
                target(config.controllerClass, config.controllerFocusMethod)
                        + "(TaskData); before+after observer");
        hookRegistry.declare(HOOK_DECOR_BIND,
                target(config.decorClass, config.decorBindMethod)
                        + "(TaskData,Rect,float); after observer");
        hookRegistry.declare(HOOK_DECOR_ATTACH,
                target(config.decorClass, config.decorAttachMethod)
                        + "(); after observer");
        hookRegistry.declare(HOOK_TASK_CREATED,
                target(config.lifecycleClass, config.taskCreatedMethod)
                        + "(int,ComponentName); after observer");
        hookRegistry.declare(HOOK_BOUNDS_SUBMIT,
                target(config.flexibleTaskViewClass, config.boundsSubmitMethod)
                        + "(Rect); after observer");
        if (config.flexibleReleaseMethod != null) {
            hookRegistry.declare(HOOK_FLEXIBLE_RELEASE,
                    target(config.flexibleTaskViewClass, config.flexibleReleaseMethod)
                            + "(); before+after observer");
        }
    }

    /** Installs the complete trace set atomically; partial observation is rejected. */
    public static boolean install(HookRuntime hookRuntime, HookRegistry hookRegistry,
                                  ModuleLogger logger, SnapshotReader snapshotReader,
                                  Config config) {
        Objects.requireNonNull(hookRuntime, "hookRuntime");
        Objects.requireNonNull(hookRegistry, "hookRegistry");
        Objects.requireNonNull(logger, "logger");
        Objects.requireNonNull(snapshotReader, "snapshotReader");
        Objects.requireNonNull(config, "config");

        HookRuntime.Group group = null;
        List<String> installedIds = new ArrayList<>();
        String installingId = null;
        try {
            group = hookRuntime.beginGroup(GROUP_ID);

            installingId = HOOK_CONTROLLER_APPEND;
            hookRuntime.findAndHookMethod(HOOK_CONTROLLER_APPEND,
                    config.controllerClass, config.controllerAppendMethod,
                    config.taskDataClass, new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            observe(logger, snapshotReader, "controller_append", "before",
                                    call.thisObject, argument(call, 0), call.args, "pending");
                        }

                        @Override
                        protected void afterHookedMethod(HookCall call) {
                            observe(logger, snapshotReader, "controller_append", "after",
                                    call.thisObject, argument(call, 0), call.args,
                                    outcome(call));
                        }
                    });
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_ADAPTER_REMOVE;
            hookRuntime.findAndHookMethod(HOOK_ADAPTER_REMOVE,
                    config.adapterClass, config.adapterRemoveMethod,
                    config.taskDataClass, beforeAfterObserver(logger, snapshotReader,
                            "adapter_remove"));
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_CONTROLLER_REMOVE;
            hookRuntime.findAndHookMethod(HOOK_CONTROLLER_REMOVE,
                    config.controllerClass, config.controllerRemoveMethod,
                    config.taskDataClass, beforeAfterObserver(logger, snapshotReader,
                            "controller_remove"));
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_CONTROLLER_FOCUS;
            hookRuntime.findAndHookMethod(HOOK_CONTROLLER_FOCUS,
                    config.controllerClass, config.controllerFocusMethod,
                    config.taskDataClass, beforeAfterObserver(logger, snapshotReader,
                            "controller_focus"));
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_ADAPTER_INSERT;
            hookRuntime.findAndHookMethod(HOOK_ADAPTER_INSERT,
                    config.adapterClass, config.adapterInsertMethod,
                    config.taskDataClass, afterObserver(logger, snapshotReader,
                            "adapter_insert"));
            markInstalled(hookRegistry, installedIds, installingId);

            if (config.flexibleReleaseMethod != null) {
                installingId = HOOK_FLEXIBLE_RELEASE;
                hookRuntime.findAndHookMethod(HOOK_FLEXIBLE_RELEASE,
                        config.flexibleTaskViewClass, config.flexibleReleaseMethod,
                        beforeAfterObserver(logger, snapshotReader, "flexible_release"));
                markInstalled(hookRegistry, installedIds, installingId);
            }

            installingId = HOOK_DECOR_BIND;
            hookRuntime.findAndHookMethod(HOOK_DECOR_BIND,
                    config.decorClass, config.decorBindMethod,
                    config.taskDataClass, config.rectClass, Float.TYPE,
                    afterObserver(logger, snapshotReader, "decor_bind"));
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_DECOR_ATTACH;
            hookRuntime.findAndHookMethod(HOOK_DECOR_ATTACH,
                    config.decorClass, config.decorAttachMethod,
                    afterObserver(logger, snapshotReader, "decor_attach"));
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_TASK_CREATED;
            hookRuntime.findAndHookMethod(HOOK_TASK_CREATED,
                    config.lifecycleClass, config.taskCreatedMethod,
                    Integer.TYPE, config.componentNameClass,
                    afterObserver(logger, snapshotReader, "task_created"));
            markInstalled(hookRegistry, installedIds, installingId);

            installingId = HOOK_BOUNDS_SUBMIT;
            hookRuntime.findAndHookMethod(HOOK_BOUNDS_SUBMIT,
                    config.flexibleTaskViewClass, config.boundsSubmitMethod,
                    config.rectClass,
                    afterObserver(logger, snapshotReader, "bounds_submit"));
            markInstalled(hookRegistry, installedIds, installingId);

            if (!hookRuntime.commitGroup(group)) {
                markRolledBack(hookRegistry, installedIds,
                        "trace group commit rejected", null);
                safeError(logger, PREFIX + " install commit rejected", null);
                return false;
            }
            safeInfo(logger, PREFIX + " install group=" + GROUP_ID
                    + " hooks=" + installedIds.size());
            return true;
        } catch (Throwable failure) {
            if (group != null && !group.isClosed()) {
                try {
                    hookRuntime.rollbackGroup(group);
                } catch (Throwable rollbackFailure) {
                    failure.addSuppressed(rollbackFailure);
                }
            }
            markRolledBack(hookRegistry, installedIds,
                    "trace group rolled back", failure);
            markFailedOrSkipped(hookRegistry, installingId, failure);
            safeError(logger, PREFIX + " install failed id="
                    + safeValue(installingId), failure);
            return false;
        }
    }

    private static HookCallback afterObserver(ModuleLogger logger,
                                              SnapshotReader snapshotReader,
                                              String event) {
        return new HookCallback() {
            @Override
            protected void afterHookedMethod(HookCall call) {
                observe(logger, snapshotReader, event, "after", call.thisObject,
                        argument(call, 0), call.args, outcome(call));
            }
        };
    }

    private static HookCallback beforeAfterObserver(ModuleLogger logger,
                                                     SnapshotReader snapshotReader,
                                                     String event) {
        return new HookCallback() {
            @Override
            protected void beforeHookedMethod(HookCall call) {
                observe(logger, snapshotReader, event, "before", call.thisObject,
                        argument(call, 0), call.args, "pending");
            }

            @Override
            protected void afterHookedMethod(HookCall call) {
                observe(logger, snapshotReader, event, "after", call.thisObject,
                        argument(call, 0), call.args, outcome(call));
            }
        };
    }

    static void observe(ModuleLogger logger, SnapshotReader snapshotReader,
                        String event, String phase, Object receiver, Object candidate,
                        Object[] arguments, String outcome) {
        try {
            Object[] copiedArguments = arguments == null
                    ? new Object[0] : arguments.clone();
            Snapshot snapshot;
            try {
                snapshot = snapshotReader.capture(event, phase, receiver,
                        candidate, copiedArguments);
            } catch (Throwable ignored) {
                snapshot = Snapshot.unavailable();
            }
            if (snapshot == null) {
                snapshot = Snapshot.unavailable();
            }
            String message = format(event, phase, receiver, candidate,
                    outcome, snapshot);
            safeInfo(logger, message);
        } catch (Throwable ignored) {
            // Diagnostics are never allowed to alter the intercepted call.
        }
    }

    private static String format(String event, String phase, Object receiver,
                                 Object candidate, String outcome, Snapshot snapshot) {
        StringBuilder message = new StringBuilder(PREFIX)
                .append(" traceSession=").append(TRACE_SESSION)
                .append(" seq=").append(SEQUENCE.incrementAndGet())
                .append(" elapsedMs=")
                .append((System.nanoTime() - TRACE_STARTED_NANOS) / 1_000_000L)
                .append(" event=").append(safeValue(event))
                .append(" phase=").append(safeValue(phase))
                .append(" thread=").append(safeValue(Thread.currentThread().getName()))
                .append(" receiver=").append(identity(receiver))
                .append(" candidate=").append(identity(candidate))
                .append(" outcome=").append(safeValue(outcome))
                .append(" adapter=").append(snapshot.adapterCount)
                .append(" child=").append(snapshot.containerChildCount)
                .append(" taskData=").append(snapshot.taskDataCount)
                .append(" slot=").append(snapshot.slot)
                .append(" taskId=").append(snapshot.taskId)
                .append(" taskIds=").append(intArray(snapshot.taskIds));
        if (snapshot.componentName != null) {
            message.append(" component=").append(safeValue(snapshot.componentName));
        }
        if (snapshot.bounds != null) {
            message.append(" bounds=")
                    .append(snapshot.bounds.left).append(',')
                    .append(snapshot.bounds.top).append(',')
                    .append(snapshot.bounds.right).append(',')
                    .append(snapshot.bounds.bottom);
        }
        return message.toString();
    }

    private static String outcome(HookCall call) {
        return call.hasThrowable() ? "oem_throwable" : "oem_returned";
    }

    private static Object argument(HookCall call, int index) {
        return call.args.length > index ? call.args[index] : null;
    }

    private static String target(Class<?> owner, String methodName) {
        return owner.getName() + "#" + methodName;
    }

    private static String identity(Object value) {
        if (value == null) {
            return "null";
        }
        return value.getClass().getName() + '@'
                + Integer.toHexString(System.identityHashCode(value));
    }

    private static String intArray(int[] values) {
        StringBuilder result = new StringBuilder("[");
        for (int index = 0; index < values.length; index++) {
            if (index > 0) {
                result.append(',');
            }
            result.append(values[index]);
        }
        return result.append(']').toString();
    }

    private static String safeValue(String value) {
        if (value == null) {
            return "null";
        }
        StringBuilder sanitized = new StringBuilder();
        int limit = Math.min(value.length(), 160);
        for (int index = 0; index < limit; index++) {
            char character = value.charAt(index);
            sanitized.append(Character.isISOControl(character) || Character.isWhitespace(character)
                    ? '_' : character);
        }
        return sanitized.toString();
    }

    private static String requireName(String value, String label) {
        Objects.requireNonNull(value, label);
        if (value.isBlank() || !value.equals(value.trim())) {
            throw new IllegalArgumentException(label + " must be non-blank and trimmed");
        }
        return value;
    }

    private static String optionalName(String value, String label) {
        return value == null ? null : requireName(value, label);
    }

    private static void markInstalled(HookRegistry hookRegistry, List<String> installedIds,
                                      String hookId) {
        hookRegistry.markInstalled(hookId, "observer installed in " + GROUP_ID);
        installedIds.add(hookId);
    }

    private static void markRolledBack(HookRegistry hookRegistry, List<String> installedIds,
                                       String detail, Throwable failure) {
        for (String hookId : installedIds) {
            try {
                hookRegistry.markRolledBack(hookId, detail, failure);
            } catch (Throwable ignored) {
                // Registry diagnostics must not affect target startup.
            }
        }
    }

    private static void markFailedOrSkipped(HookRegistry hookRegistry,
                                            String failedId, Throwable failure) {
        for (HookRegistry.Entry entry : hookRegistry.snapshot()) {
            if (entry.status() != HookRegistry.Status.PLANNED) {
                continue;
            }
            try {
                if (entry.id().equals(failedId)) {
                    hookRegistry.markFailed(entry.id(), "observer install failed", failure);
                } else if (entry.id().startsWith("trace.four_task.")) {
                    hookRegistry.markSkipped(entry.id(), "atomic trace group unavailable");
                }
            } catch (Throwable ignored) {
                // Registry diagnostics must not affect target startup.
            }
        }
    }

    private static void safeInfo(ModuleLogger logger, String message) {
        try {
            logger.i(message);
        } catch (Throwable ignored) {
            // Logging must never affect an OEM callback.
        }
    }

    private static void safeError(ModuleLogger logger, String message, Throwable failure) {
        try {
            logger.e(message, failure);
        } catch (Throwable ignored) {
            // Logging must never affect target startup.
        }
    }
}
