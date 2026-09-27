package com.color.pscanvasfix.feature;

import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.ModuleLogger;

import io.github.libxposed.api.XposedInterface;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class FourTaskTraceFeatureTest {
    @Test
    public void observerUsesDefensiveArgumentsAndEmitsSanitizedSnapshot() {
        List<String> messages = new ArrayList<>();
        ModuleLogger logger = logger((level, tag, message, throwable) -> messages.add(message));
        Object[] original = {"original"};

        FourTaskTraceFeature.observe(logger,
                (event, phase, receiver, candidate, arguments) -> {
                    arguments[0] = "changed only in trace copy";
                    return new FourTaskTraceFeature.Snapshot(
                            4, 4, 4, 3, 104,
                            new int[]{101, 102, 103, 104},
                            "pkg/.Fourth\nActivity",
                            new FourTaskTraceFeature.Bounds(30, 40, 330, 640));
                }, "controller_append", "after", new Controller(), new TaskData(),
                original, "oem_returned");

        assertArrayEquals(new Object[]{"original"}, original);
        assertEquals(1, messages.size());
        String message = messages.get(0);
        assertTrue(message.startsWith("[FourTask][Trace]"));
        assertTrue(message.contains(" traceSession="));
        assertTrue(message.contains(" elapsedMs="));
        assertTrue(message.contains("adapter=4 child=4 taskData=4"));
        assertTrue(message.contains("taskIds=[101,102,103,104]"));
        assertTrue(message.contains("component=pkg/.Fourth_Activity"));
        assertTrue(message.contains("bounds=30,40,330,640"));
    }

    @Test
    public void snapshotAndLoggerFailuresAreSwallowed() {
        ModuleLogger failingLogger = logger((level, tag, message, throwable) -> {
            throw new IllegalStateException("sink failure");
        });

        FourTaskTraceFeature.observe(failingLogger,
                (event, phase, receiver, candidate, arguments) -> {
                    throw new IllegalArgumentException("snapshot failure");
                }, "decor_bind", "after", new Decor(), new TaskData(),
                new Object[]{new Object()}, "oem_returned");
    }

    @Test
    public void failedAtomicInstallUnhooksInReverseOrder() {
        List<String> unhooked = new ArrayList<>();
        AtomicInteger installs = new AtomicInteger();
        AtomicReference<String> currentId = new AtomicReference<>();
        AtomicReference<Executable> currentExecutable = new AtomicReference<>();
        XposedInterface framework = framework(unhooked, installs, 4,
                currentId, currentExecutable);
        HookRuntime runtime = new HookRuntime(framework);
        HookRegistry registry = new HookRegistry();
        FourTaskTraceFeature.Config config = config();
        FourTaskTraceFeature.declareHooks(registry, config);

        boolean installed = FourTaskTraceFeature.install(runtime, registry,
                logger((level, tag, message, throwable) -> {
                }), (event, phase, receiver, candidate, arguments) ->
                        FourTaskTraceFeature.Snapshot.unavailable(), config);

        assertFalse(installed);
        assertEquals(Arrays.asList(
                FourTaskTraceFeature.HOOK_CONTROLLER_REMOVE,
                FourTaskTraceFeature.HOOK_ADAPTER_REMOVE,
                FourTaskTraceFeature.HOOK_CONTROLLER_APPEND), unhooked);
        for (HookRegistry.Entry entry : registry.snapshot()) {
            assertTrue(entry.status() == HookRegistry.Status.FAILED
                    || entry.status() == HookRegistry.Status.SKIPPED);
        }
    }

    @Test
    public void successfulInstallRegistersExactlyTenStableObserverIds() {
        List<String> installedIds = new ArrayList<>();
        XposedInterface framework = framework(new ArrayList<>(), new AtomicInteger(), -1,
                new AtomicReference<>(), new AtomicReference<>(), installedIds);
        HookRuntime runtime = new HookRuntime(framework);
        HookRegistry registry = new HookRegistry();
        FourTaskTraceFeature.Config config = config();
        FourTaskTraceFeature.declareHooks(registry, config);

        assertTrue(FourTaskTraceFeature.install(runtime, registry,
                logger((level, tag, message, throwable) -> {
                }), (event, phase, receiver, candidate, arguments) ->
                        FourTaskTraceFeature.Snapshot.unavailable(), config));

        assertEquals(Arrays.asList(
                FourTaskTraceFeature.HOOK_CONTROLLER_APPEND,
                FourTaskTraceFeature.HOOK_ADAPTER_REMOVE,
                FourTaskTraceFeature.HOOK_CONTROLLER_REMOVE,
                FourTaskTraceFeature.HOOK_CONTROLLER_FOCUS,
                FourTaskTraceFeature.HOOK_ADAPTER_INSERT,
                FourTaskTraceFeature.HOOK_FLEXIBLE_RELEASE,
                FourTaskTraceFeature.HOOK_DECOR_BIND,
                FourTaskTraceFeature.HOOK_DECOR_ATTACH,
                FourTaskTraceFeature.HOOK_TASK_CREATED,
                FourTaskTraceFeature.HOOK_BOUNDS_SUBMIT), installedIds);
        for (HookRegistry.Entry entry : registry.snapshot()) {
            assertEquals(HookRegistry.Status.INSTALLED, entry.status());
        }
    }

    @Test
    public void productionSourceContainsNoControlFlowOrActiveTaskActions()
            throws IOException {
        String source = source();

        assertFalse(source.contains("setResult("));
        assertFalse(source.contains("setThrowable("));
        assertFalse(source.contains("invokeOriginalMethod("));
        assertFalse(source.contains("invokeOriginal("));
        assertFalse(source.contains("startActivity("));
        assertFalse(source.contains("startTask("));
        assertFalse(source.contains("setFocusedTask("));
        assertFalse(source.contains("removeTask("));
        assertFalse(source.contains(".resize("));
        assertFalse(source.contains("BuildConfig"));
        assertTrue(source.contains("[FourTask][Trace]"));
        assertTrue(source.contains("beginGroup(GROUP_ID)"));
        assertTrue(source.contains("rollbackGroup(group)"));
    }

    private static FourTaskTraceFeature.Config config() {
        return new FourTaskTraceFeature.Config(
                Controller.class, "append", "remove", "focus",
                Adapter.class, "insert", "remove",
                TaskData.class,
                Decor.class, "bind", "attach",
                Lifecycle.class, "taskCreated",
                FlexibleTaskView.class, "submitBounds", "release",
                Object.class, Object.class);
    }

    private static ModuleLogger logger(ModuleLogger.Sink sink) {
        return new ModuleLogger("FourTaskTraceFeatureTest", sink);
    }

    private static XposedInterface framework(List<String> unhooked,
                                             AtomicInteger installs, int failAt,
                                             AtomicReference<String> currentId,
                                             AtomicReference<Executable> currentExecutable) {
        return framework(unhooked, installs, failAt, currentId, currentExecutable,
                new ArrayList<>());
    }

    private static XposedInterface framework(List<String> unhooked,
                                             AtomicInteger installs, int failAt,
                                             AtomicReference<String> currentId,
                                             AtomicReference<Executable> currentExecutable,
                                             List<String> installedIds) {
        AtomicReference<XposedInterface.HookBuilder> builderReference =
                new AtomicReference<>();
        XposedInterface.HookBuilder builder = proxy(
                XposedInterface.HookBuilder.class, (object, method, arguments) -> {
                    switch (method.getName()) {
                        case "setId":
                            currentId.set((String) arguments[0]);
                            return builderReference.get();
                        case "setExceptionMode":
                        case "setPriority":
                            return builderReference.get();
                        case "intercept":
                            int installNumber = installs.incrementAndGet();
                            if (installNumber == failAt) {
                                throw new IllegalStateException("install failure "
                                        + installNumber);
                            }
                            String installedId = currentId.get();
                            Executable executable = currentExecutable.get();
                            installedIds.add(installedId);
                            return hookHandle(executable, installedId, unhooked);
                        default:
                            throw new UnsupportedOperationException(method.getName());
                    }
                });
        builderReference.set(builder);
        return proxy(XposedInterface.class, (object, method, arguments) -> {
            if (method.getName().equals("hook")) {
                currentExecutable.set((Executable) arguments[0]);
                return builder;
            }
            if (method.getName().equals("log")) {
                return null;
            }
            throw new UnsupportedOperationException(method.getName());
        });
    }

    private static XposedInterface.HookHandle hookHandle(Executable executable, String id,
                                                          List<String> unhooked) {
        return proxy(XposedInterface.HookHandle.class, (object, method, arguments) -> {
            switch (method.getName()) {
                case "getExecutable":
                    return executable;
                case "getId":
                    return id;
                case "unhook":
                    unhooked.add(id);
                    return null;
                default:
                    throw new UnsupportedOperationException(method.getName());
            }
        });
    }

    @SuppressWarnings("unchecked")
    private static <T> T proxy(Class<T> type, java.lang.reflect.InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, handler);
    }

    private static String source() throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve(
                "app/src/main/java/com/color/pscanvasfix/feature/FourTaskTraceFeature.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/feature/FourTaskTraceFeature.java");
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8)
                .replace("\r\n", "\n");
    }

    private static final class TaskData {
    }

    private static final class Controller {
        @SuppressWarnings("unused")
        private void append(TaskData taskData) {
        }

        @SuppressWarnings("unused")
        private void remove(TaskData taskData) {
        }

        @SuppressWarnings("unused")
        private void focus(TaskData taskData) {
        }
    }

    private static final class Adapter {
        @SuppressWarnings("unused")
        private void insert(TaskData taskData) {
        }

        @SuppressWarnings("unused")
        private void remove(TaskData taskData) {
        }
    }

    private static final class Decor {
        @SuppressWarnings("unused")
        private void bind(TaskData taskData, Object bounds, float scale) {
        }

        @SuppressWarnings("unused")
        private void attach() {
        }
    }

    private static final class Lifecycle {
        @SuppressWarnings("unused")
        private void taskCreated(int taskId, Object componentName) {
        }
    }

    private static final class FlexibleTaskView {
        @SuppressWarnings("unused")
        private void submitBounds(Object bounds) {
        }

        @SuppressWarnings("unused")
        private void release() {
        }
    }
}
