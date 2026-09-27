package com.color.pscanvasfix.runtime;

import io.github.libxposed.api.XposedInterface;

import org.junit.Test;

import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public final class HookRuntimeTest {
    @Test
    public void beforeCopiesAndRewritesArgumentsThenAfterOverridesResult() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        AtomicReference<Object[]> callbackArgs = new AtomicReference<>();
        List<String> order = new ArrayList<>();

        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                "fixture.rewrite", Fixture.class, "join", String.class, int.class,
                new HookCallback() {
                    @Override
                    protected void beforeHookedMethod(HookCall param) {
                        order.add("before");
                        callbackArgs.set(param.args);
                        param.args[0] = "b";
                        param.args[1] = 2;
                    }

                    @Override
                    protected void afterHookedMethod(HookCall param) {
                        order.add("after");
                        param.setResult(param.getResult() + "!");
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> {
                    order.add("origin");
                    return args[0] + String.valueOf(args[1]);
                });

        Object result = bridge.lastInterceptor.intercept(chain);

        assertEquals("b2!", result);
        assertEquals(Arrays.asList("before", "origin", "after"), order);
        assertArrayEquals(new Object[]{"a", 1}, chain.frameworkArgs);
        assertArrayEquals(new Object[]{"b", 2}, chain.proceededArgs);
        assertNotSame(callbackArgs.get(), chain.proceededArgs);
        assertEquals(1, chain.proceedCount);
    }

    @Test
    public void beforeCanShortCircuitWithNullAndAfterStillRuns() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        boolean[] afterRan = {false};
        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                Fixture.class, "join", String.class, int.class, new HookCallback() {
                    @Override
                    protected void beforeHookedMethod(HookCall param) {
                        param.setResult(null);
                    }

                    @Override
                    protected void afterHookedMethod(HookCall param) {
                        afterRan[0] = true;
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> "unexpected");

        assertNull(bridge.lastInterceptor.intercept(chain));
        assertTrue(afterRan[0]);
        assertEquals(0, chain.proceedCount);
    }

    @Test
    public void oemThrowableRunsAfterAndRethrowsSameInstance() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        IllegalStateException oemFailure = new IllegalStateException("oem");
        AtomicReference<Throwable> observed = new AtomicReference<>();
        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                Fixture.class, "join", String.class, int.class, new HookCallback() {
                    @Override
                    protected void afterHookedMethod(HookCall param) {
                        observed.set(param.getThrowable());
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> {
                    throw oemFailure;
                });

        Throwable thrown = assertThrows(Throwable.class,
                () -> bridge.lastInterceptor.intercept(chain));
        assertSame(oemFailure, observed.get());
        assertSame(oemFailure, thrown);
        assertEquals(1, chain.proceedCount);
    }

    @Test
    public void afterCanRecoverFromOemThrowable() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                Fixture.class, "join", String.class, int.class, new HookCallback() {
                    @Override
                    protected void afterHookedMethod(HookCall param) {
                        assertTrue(param.hasThrowable());
                        param.setResult("fallback");
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> {
                    throw new IllegalArgumentException("oem");
                });

        assertEquals("fallback", bridge.lastInterceptor.intercept(chain));
    }

    @Test
    public void beforeCallbackFailureContinuesOriginAndSkipsAfter() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        boolean[] afterRan = {false};
        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                Fixture.class, "join", String.class, int.class, new HookCallback() {
                    @Override
                    protected void beforeHookedMethod(HookCall param) {
                        param.args[0] = "changed";
                        param.setResult(null);
                        throw new IllegalStateException("callback");
                    }

                    @Override
                    protected void afterHookedMethod(HookCall param) {
                        afterRan[0] = true;
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> args[0] + String.valueOf(args[1]));

        assertEquals("changed1", bridge.lastInterceptor.intercept(chain));
        assertEquals(1, chain.proceedCount);
        assertFalse(afterRan[0]);
    }

    @Test
    public void afterCallbackFailureRestoresOriginalOutcome() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                Fixture.class, "join", String.class, int.class, new HookCallback() {
                    @Override
                    protected void afterHookedMethod(HookCall param) {
                        param.setResult("corrupt");
                        throw new IllegalStateException("callback");
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> "origin");

        assertEquals("origin", bridge.lastInterceptor.intercept(chain));
        assertEquals(1, chain.proceedCount);
    }

    @Test
    public void replacementSkipsProceedAndUsesUnwrappedOrigin() throws Throwable {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        HookRuntime.HookHandle handle = runtime.findAndHookMethod(
                Fixture.class, "join", String.class, int.class, new HookReplacement() {
                    @Override
                    protected Object replaceHookedMethod(HookCall param) throws Throwable {
                        param.args[0] = "origin";
                        return param.invokeOriginal() + "!";
                    }
                });
        TestChain chain = new TestChain(handle.executable(), new Fixture(),
                new Object[]{"a", 1}, args -> "unexpected");

        assertEquals("origin1!", bridge.lastInterceptor.intercept(chain));
        assertEquals(0, chain.proceedCount);
        assertEquals(1, bridge.originCount);

        Method throwing = Fixture.class.getDeclaredMethod("throwOem");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> runtime.invokeOriginalMethod(throwing, new Fixture(), new Object[0]));
        assertEquals("specific-oem", thrown.getMessage());
    }

    @Test
    public void generatesExactIdsAndResolvesNamedTypesAndConstructors() throws Exception {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);

        HookRuntime.HookHandle method = runtime.findAndHookMethod(
                Fixture.class.getName(), Fixture.class.getClassLoader(), "join",
                String.class.getName(), "int", new HookCallback() {
                });
        HookRuntime.HookHandle constructor = runtime.findAndHookConstructor(
                Fixture.class, new HookCallback() {
                });

        assertEquals(Fixture.class.getName() + "#join(java.lang.String,int):java.lang.String",
                method.id());
        assertEquals(Fixture.class.getName() + "#<init>()", constructor.id());
    }

    @Test
    public void failedGroupRegistrationRollsBackAndCommitReturnsFalse() {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        HookRuntime.Group group = runtime.beginGroup("anim.drag");
        runtime.findAndHookMethod("first", Fixture.class, "join",
                String.class, int.class, new HookCallback() {
                });
        bridge.failNextInstall = true;

        assertThrows(IllegalStateException.class,
                () -> runtime.findAndHookMethod("second", Fixture.class, "other",
                        new HookCallback() {
                        }));

        assertTrue(bridge.unhookedIds.isEmpty());
        assertThrows(IllegalStateException.class,
                () -> runtime.findAndHookMethod("third", Fixture.class, "other",
                        new HookCallback() {
                        }));
        assertFalse(runtime.commitGroup(group));
        assertEquals(Arrays.asList("first"), bridge.unhookedIds);
        assertTrue(group.isClosed());
        assertFalse(group.isCommitted());
    }

    @Test
    public void explicitRollbackUnhooksInReverseRegistrationOrder() {
        FakeBridge bridge = new FakeBridge();
        HookRuntime runtime = new HookRuntime(bridge);
        HookRuntime.Group group = runtime.beginGroup("two-hooks");
        runtime.findAndHookMethod("one", Fixture.class, "join",
                String.class, int.class, new HookCallback() {
                });
        runtime.findAndHookMethod("two", Fixture.class, "other", new HookCallback() {
        });

        runtime.rollbackGroup(group);

        assertEquals(Arrays.asList("two", "one"), bridge.unhookedIds);
        assertTrue(group.isClosed());
    }

    @Test
    public void modernBridgeSetsStableIdAndProtectiveMode() {
        AtomicReference<String> id = new AtomicReference<>();
        AtomicReference<XposedInterface.ExceptionMode> mode = new AtomicReference<>();
        AtomicReference<Executable> executable = new AtomicReference<>();
        XposedInterface.HookHandle modernHandle = proxy(
                XposedInterface.HookHandle.class, (object, method, args) -> {
                    switch (method.getName()) {
                        case "getExecutable":
                            return executable.get();
                        case "getId":
                            return id.get();
                        case "unhook":
                            return null;
                        default:
                            throw new UnsupportedOperationException(method.getName());
                    }
                });
        AtomicReference<XposedInterface.HookBuilder> builderRef = new AtomicReference<>();
        XposedInterface.HookBuilder builder = proxy(
                XposedInterface.HookBuilder.class, (object, method, args) -> {
                    switch (method.getName()) {
                        case "setId":
                            id.set((String) args[0]);
                            return builderRef.get();
                        case "setExceptionMode":
                            mode.set((XposedInterface.ExceptionMode) args[0]);
                            return builderRef.get();
                        case "setPriority":
                            return builderRef.get();
                        case "intercept":
                            return modernHandle;
                        default:
                            throw new UnsupportedOperationException(method.getName());
                    }
                });
        builderRef.set(builder);
        XposedInterface framework = proxy(XposedInterface.class, (object, method, args) -> {
            if (method.getName().equals("hook")) {
                executable.set((Executable) args[0]);
                return builder;
            }
            throw new UnsupportedOperationException(method.getName());
        });

        new HookRuntime(framework).findAndHookMethod(
                "stable.id", Fixture.class, "other", new HookCallback() {
                });

        assertEquals("stable.id", id.get());
        assertSame(XposedInterface.ExceptionMode.PROTECTIVE, mode.get());
    }

    @SuppressWarnings("unchecked")
    private static <T> T proxy(Class<T> type, java.lang.reflect.InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, handler);
    }

    private interface ProceedAction {
        Object proceed(Object[] args) throws Throwable;
    }

    private static final class TestChain implements HookRuntime.InvocationChain {
        private final Executable executable;
        private final Object receiver;
        private final Object[] frameworkArgs;
        private final ProceedAction action;
        private Object[] proceededArgs;
        private int proceedCount;

        private TestChain(Executable executable, Object receiver, Object[] frameworkArgs,
                          ProceedAction action) {
            this.executable = executable;
            this.receiver = receiver;
            this.frameworkArgs = frameworkArgs;
            this.action = action;
        }

        @Override
        public Executable executable() {
            return executable;
        }

        @Override
        public Object receiver() {
            return receiver;
        }

        @Override
        public Object[] args() {
            return frameworkArgs;
        }

        @Override
        public Object proceed(Object[] args) throws Throwable {
            proceedCount++;
            proceededArgs = args;
            return action.proceed(args);
        }
    }

    private static final class FakeBridge implements HookRuntime.FrameworkBridge {
        private HookRuntime.Interceptor lastInterceptor;
        private final List<String> unhookedIds = new ArrayList<>();
        private boolean failNextInstall;
        private int originCount;

        @Override
        public HookRuntime.InstalledHook install(Executable executable, String id,
                                                HookRuntime.Interceptor interceptor) {
            if (failNextInstall) {
                failNextInstall = false;
                throw new IllegalStateException("install failed");
            }
            lastInterceptor = interceptor;
            return new HookRuntime.InstalledHook() {
                @Override
                public Executable executable() {
                    return executable;
                }

                @Override
                public String id() {
                    return id;
                }

                @Override
                public void unhook() {
                    unhookedIds.add(id);
                }
            };
        }

        @Override
        public Object invokeOrigin(Executable executable, Object receiver, Object[] args)
                throws Throwable {
            originCount++;
            if (executable instanceof Method) {
                ((Method) executable).setAccessible(true);
                return ((Method) executable).invoke(receiver, args);
            }
            throw new UnsupportedOperationException(executable.toString());
        }
    }

    private static final class Fixture {
        private Fixture() {
        }

        @SuppressWarnings("unused")
        private String join(String value, int number) {
            return value + number;
        }

        @SuppressWarnings("unused")
        private String other() {
            return "other";
        }

        @SuppressWarnings("unused")
        private void throwOem() {
            throw new IllegalArgumentException("specific-oem");
        }
    }
}
