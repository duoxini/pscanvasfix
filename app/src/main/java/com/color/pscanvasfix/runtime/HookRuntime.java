package com.color.pscanvasfix.runtime;

import io.github.libxposed.api.XposedInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Modern libxposed adapter that keeps framework types inside the runtime layer. */
public final class HookRuntime {
    @FunctionalInterface
    interface Interceptor {
        Object intercept(InvocationChain chain) throws Throwable;
    }

    interface InvocationChain {
        Executable executable();

        Object receiver();

        Object[] args();

        Object proceed(Object[] args) throws Throwable;
    }

    interface InstalledHook {
        Executable executable();

        String id();

        void unhook();
    }

    interface FrameworkBridge {
        InstalledHook install(Executable executable, String id, Interceptor interceptor);

        Object invokeOrigin(Executable executable, Object receiver, Object[] args)
                throws Throwable;
    }

    /** Project-owned handle returned to hook installers. */
    public interface HookHandle {
        Executable executable();

        String id();

        void unhook();
    }

    /** One registration transaction. A failed group rejects later installs and rolls back on commit. */
    public final class Group {
        private final String id;
        private final List<ManagedHookHandle> handles = new ArrayList<>();
        private boolean closed;
        private boolean committed;
        private boolean failed;

        private Group(String id) {
            this.id = id;
        }

        public String id() {
            return id;
        }

        public boolean isCommitted() {
            return committed;
        }

        public boolean isClosed() {
            return closed;
        }

        public List<HookHandle> handles() {
            return Collections.unmodifiableList(new ArrayList<HookHandle>(handles));
        }

        public boolean commit() {
            return commitGroup(this);
        }

        public void rollback() {
            rollbackGroup(this);
        }
    }

    private static final Map<String, Class<?>> PRIMITIVES;

    static {
        Map<String, Class<?>> primitives = new HashMap<>();
        primitives.put("boolean", boolean.class);
        primitives.put("byte", byte.class);
        primitives.put("char", char.class);
        primitives.put("short", short.class);
        primitives.put("int", int.class);
        primitives.put("long", long.class);
        primitives.put("float", float.class);
        primitives.put("double", double.class);
        primitives.put("void", void.class);
        PRIMITIVES = Collections.unmodifiableMap(primitives);
    }

    private final FrameworkBridge framework;
    private final ModuleLogger logger;
    private final Map<String, ManagedHookHandle> activeHooks = new HashMap<>();
    private Group activeGroup;

    public HookRuntime(XposedInterface framework) {
        this(new ModernFrameworkBridge(framework), new ModuleLogger("PsCanvasHookRuntime",
                new AndroidLogSink(), new ModernXposedLogSink()));
    }

    HookRuntime(FrameworkBridge framework) {
        this(framework, new ModuleLogger("PsCanvasHookRuntime",
                (level, tag, message, throwable) -> {
                }));
    }

    HookRuntime(FrameworkBridge framework, ModuleLogger logger) {
        this.framework = Objects.requireNonNull(framework, "framework");
        this.logger = Objects.requireNonNull(logger, "logger");
    }

    public synchronized Group beginGroup(String id) {
        if (activeGroup != null) {
            throw new IllegalStateException("Hook group already active: " + activeGroup.id);
        }
        String stableId = requireStableId(id, "group id");
        activeGroup = new Group(stableId);
        return activeGroup;
    }

    public synchronized void commitGroup() {
        if (activeGroup == null) {
            throw new IllegalStateException("No active hook group");
        }
        commitGroup(activeGroup);
    }

    public synchronized void rollback() {
        if (activeGroup != null) {
            rollbackGroup(activeGroup);
        }
    }

    public HookHandle findAndHookMethod(Class<?> owner, String methodName,
                                        Object... parameterTypesAndCallback) {
        return findAndHookMethod(null, owner, methodName, parameterTypesAndCallback);
    }

    public HookHandle findAndHookMethod(String hookId, Class<?> owner, String methodName,
                                        Object... parameterTypesAndCallback) {
        ensureGroupAcceptsRegistration();
        Objects.requireNonNull(owner, "owner");
        try {
            ParsedHook parsed = parse(owner.getClassLoader(), parameterTypesAndCallback);
            Method method = owner.getDeclaredMethod(methodName, parsed.parameterTypes);
            method.setAccessible(true);
            return register(method, hookId, parsed.callback);
        } catch (Throwable throwable) {
            throw registrationFailure(owner.getName() + "#" + methodName, throwable);
        }
    }

    public HookHandle findAndHookMethod(String className, ClassLoader classLoader,
                                        String methodName, Object... parameterTypesAndCallback) {
        return findAndHookMethod(null, className, classLoader, methodName,
                parameterTypesAndCallback);
    }

    public HookHandle findAndHookMethod(String hookId, String className,
                                        ClassLoader classLoader, String methodName,
                                        Object... parameterTypesAndCallback) {
        ensureGroupAcceptsRegistration();
        Objects.requireNonNull(className, "className");
        try {
            Class<?> owner = resolveClass(className, classLoader);
            return findAndHookMethod(hookId, owner, methodName, parameterTypesAndCallback);
        } catch (Throwable throwable) {
            throw registrationFailure(className + "#" + methodName, throwable);
        }
    }

    public HookHandle findAndHookConstructor(Class<?> owner,
                                             Object... parameterTypesAndCallback) {
        return findAndHookConstructor(null, owner, parameterTypesAndCallback);
    }

    public HookHandle findAndHookConstructor(String hookId, Class<?> owner,
                                             Object... parameterTypesAndCallback) {
        ensureGroupAcceptsRegistration();
        Objects.requireNonNull(owner, "owner");
        try {
            ParsedHook parsed = parse(owner.getClassLoader(), parameterTypesAndCallback);
            Constructor<?> constructor = owner.getDeclaredConstructor(parsed.parameterTypes);
            constructor.setAccessible(true);
            return register(constructor, hookId, parsed.callback);
        } catch (Throwable throwable) {
            throw registrationFailure(owner.getName() + "#<init>", throwable);
        }
    }

    public HookHandle findAndHookConstructor(String className, ClassLoader classLoader,
                                             Object... parameterTypesAndCallback) {
        return findAndHookConstructor(null, className, classLoader,
                parameterTypesAndCallback);
    }

    public HookHandle findAndHookConstructor(String hookId, String className,
                                             ClassLoader classLoader,
                                             Object... parameterTypesAndCallback) {
        ensureGroupAcceptsRegistration();
        Objects.requireNonNull(className, "className");
        try {
            Class<?> owner = resolveClass(className, classLoader);
            return findAndHookConstructor(hookId, owner, parameterTypesAndCallback);
        } catch (Throwable throwable) {
            throw registrationFailure(className + "#<init>", throwable);
        }
    }

    /** Invokes the unhooked OEM origin rather than continuing the interceptor chain. */
    public Object invokeOriginalMethod(Executable executable, Object receiver, Object[] args)
            throws Throwable {
        Objects.requireNonNull(executable, "executable");
        Object[] copiedArgs = args == null ? new Object[0] : args.clone();
        try {
            return framework.invokeOrigin(executable, receiver, copiedArgs);
        } catch (InvocationTargetException exception) {
            if (exception.getCause() != null) {
                throw exception.getCause();
            }
            throw exception;
        }
    }

    private HookHandle register(Executable executable, String requestedId,
                                HookCallback callback) {
        String hookId = requestedId == null || requestedId.isBlank()
                ? exactSignature(executable) : requireStableId(requestedId, "hook id");
        synchronized (this) {
            if (activeGroup != null && activeGroup.failed) {
                throw new IllegalStateException(
                        "Hook group already failed: " + activeGroup.id);
            }
            if (activeHooks.containsKey(hookId)) {
                throw registrationFailure(hookId,
                        new IllegalArgumentException("Hook ID already installed: " + hookId));
            }
        }

        try {
            Interceptor interceptor = callback instanceof HookReplacement
                    ? chain -> interceptReplacement((HookReplacement) callback, chain)
                    : chain -> interceptCallback(callback, chain);
            InstalledHook installed = framework.install(executable, hookId, interceptor);
            ManagedHookHandle handle = new ManagedHookHandle(installed);
            synchronized (this) {
                if (activeHooks.put(hookId, handle) != null) {
                    installed.unhook();
                    throw new IllegalStateException("Hook ID installed concurrently: " + hookId);
                }
                if (activeGroup != null) {
                    activeGroup.handles.add(handle);
                }
            }
            return handle;
        } catch (Throwable throwable) {
            throw registrationFailure(hookId, throwable);
        }
    }

    private Object interceptCallback(HookCallback callback, InvocationChain chain)
            throws Throwable {
        HookCall call = new HookCall(chain.executable(), chain.receiver(), chain.args(),
                this::invokeOriginalMethod);
        boolean beforeCompleted = false;
        try {
            callback.beforeHookedMethod(call);
            beforeCompleted = true;
        } catch (Throwable callbackFailure) {
            call.resetForProceed();
            logCallbackFailure("before", chain.executable(), callbackFailure);
        }
        if (!call.shouldReturnEarly()) {
            try {
                call.completeWithResult(chain.proceed(call.args.clone()));
            } catch (Throwable throwable) {
                call.completeWithThrowable(throwable);
            }
        }

        if (beforeCompleted) {
            HookCall.Outcome originalOutcome = call.snapshotOutcome();
            try {
                callback.afterHookedMethod(call);
            } catch (Throwable callbackFailure) {
                call.restoreOutcome(originalOutcome);
                logCallbackFailure("after", chain.executable(), callbackFailure);
            }
        }
        if (call.hasThrowable()) {
            throw call.getThrowable();
        }
        return call.getResult();
    }

    private Object interceptReplacement(HookReplacement replacement, InvocationChain chain)
            throws Throwable {
        HookCall call = new HookCall(chain.executable(), chain.receiver(), chain.args(),
                this::invokeOriginalMethod);
        try {
            return replacement.replaceHookedMethod(call);
        } catch (Throwable callbackFailure) {
            logCallbackFailure("replacement", chain.executable(), callbackFailure);
            return chain.proceed(call.args.clone());
        }
    }

    private void logCallbackFailure(String phase, Executable executable, Throwable throwable) {
        try {
            logger.e("hook callback failed phase=" + phase + " target="
                    + exactSignature(executable), throwable);
        } catch (Throwable ignoredSinkFailure) {
            // Logging must never change hook control flow.
        }
    }

    public synchronized boolean commitGroup(Group group) {
        Objects.requireNonNull(group, "group");
        if (group.failed) {
            if (!group.closed) {
                rollbackGroup(group);
            }
            return false;
        }
        requireActiveGroup(group);
        group.committed = true;
        group.closed = true;
        activeGroup = null;
        return true;
    }

    public synchronized void rollbackGroup(Group group) {
        Objects.requireNonNull(group, "group");
        if (group.closed) {
            if (group.committed) {
                throw new IllegalStateException("Hook group already committed: " + group.id);
            }
            return;
        }
        requireActiveGroup(group);
        Throwable firstFailure = null;
        for (int i = group.handles.size() - 1; i >= 0; i--) {
            try {
                group.handles.get(i).unhook();
            } catch (Throwable throwable) {
                if (firstFailure == null) {
                    firstFailure = throwable;
                } else {
                    firstFailure.addSuppressed(throwable);
                }
            }
        }
        group.closed = true;
        activeGroup = null;
        if (firstFailure != null) {
            throwUnchecked(firstFailure);
        }
    }

    private synchronized RuntimeException registrationFailure(String target,
                                                              Throwable throwable) {
        Throwable cause = unwrapRegistrationFailure(throwable);
        if (activeGroup != null && !activeGroup.closed) {
            activeGroup.failed = true;
        }
        if (cause instanceof RuntimeException) {
            return (RuntimeException) cause;
        }
        if (cause instanceof Error) {
            throw (Error) cause;
        }
        return new IllegalStateException("Failed to install hook: " + target, cause);
    }

    private void requireActiveGroup(Group group) {
        if (activeGroup != group) {
            throw new IllegalStateException("Hook group is not active: " + group.id);
        }
    }

    private synchronized void ensureGroupAcceptsRegistration() {
        if (activeGroup != null && activeGroup.failed) {
            throw new IllegalStateException("Hook group already failed: " + activeGroup.id);
        }
    }

    private static ParsedHook parse(ClassLoader classLoader,
                                    Object[] parameterTypesAndCallback) {
        if (parameterTypesAndCallback == null || parameterTypesAndCallback.length == 0) {
            throw new IllegalArgumentException("Callback must be the final argument");
        }
        Object callbackObject = parameterTypesAndCallback[parameterTypesAndCallback.length - 1];
        if (!(callbackObject instanceof HookCallback)) {
            throw new IllegalArgumentException("Final argument must be HookCallback");
        }

        Class<?>[] parameterTypes = new Class<?>[parameterTypesAndCallback.length - 1];
        for (int i = 0; i < parameterTypes.length; i++) {
            Object parameterType = parameterTypesAndCallback[i];
            if (parameterType instanceof Class<?>) {
                parameterTypes[i] = (Class<?>) parameterType;
            } else if (parameterType instanceof String) {
                parameterTypes[i] = resolveClass((String) parameterType, classLoader);
            } else {
                throw new IllegalArgumentException(
                        "Parameter type at index " + i + " must be Class or class name");
            }
        }
        return new ParsedHook(parameterTypes, (HookCallback) callbackObject);
    }

    private static Class<?> resolveClass(String className, ClassLoader classLoader) {
        Class<?> primitive = PRIMITIVES.get(className);
        if (primitive != null) {
            return primitive;
        }
        try {
            return Class.forName(className, false, classLoader);
        } catch (ClassNotFoundException exception) {
            throw new IllegalArgumentException("Class not found: " + className, exception);
        }
    }

    static String exactSignature(Executable executable) {
        StringBuilder signature = new StringBuilder(executable.getDeclaringClass().getName())
                .append('#');
        if (executable instanceof Constructor<?>) {
            signature.append("<init>");
        } else {
            signature.append(executable.getName());
        }
        signature.append('(');
        Class<?>[] parameterTypes = executable.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                signature.append(',');
            }
            signature.append(parameterTypes[i].getTypeName());
        }
        signature.append(')');
        if (executable instanceof Method) {
            signature.append(':').append(((Method) executable).getReturnType().getTypeName());
        }
        return signature.toString();
    }

    private static String requireStableId(String id, String label) {
        Objects.requireNonNull(id, label);
        if (id.isBlank() || !id.equals(id.trim())) {
            throw new IllegalArgumentException(label + " must be non-blank and trimmed");
        }
        return id;
    }

    private static Throwable unwrapRegistrationFailure(Throwable throwable) {
        if (throwable instanceof InvocationTargetException
                && ((InvocationTargetException) throwable).getCause() != null) {
            return ((InvocationTargetException) throwable).getCause();
        }
        return throwable;
    }

    private static void throwUnchecked(Throwable throwable) {
        HookRuntime.<RuntimeException>throwAny(throwable);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void throwAny(Throwable throwable) throws T {
        throw (T) throwable;
    }

    private static final class ParsedHook {
        private final Class<?>[] parameterTypes;
        private final HookCallback callback;

        private ParsedHook(Class<?>[] parameterTypes, HookCallback callback) {
            this.parameterTypes = parameterTypes;
            this.callback = callback;
        }
    }

    private final class ManagedHookHandle implements HookHandle {
        private final InstalledHook delegate;
        private boolean unhooked;

        private ManagedHookHandle(InstalledHook delegate) {
            this.delegate = Objects.requireNonNull(delegate, "delegate");
        }

        @Override
        public Executable executable() {
            return delegate.executable();
        }

        @Override
        public String id() {
            return delegate.id();
        }

        @Override
        public synchronized void unhook() {
            if (unhooked) {
                return;
            }
            delegate.unhook();
            unhooked = true;
            synchronized (HookRuntime.this) {
                activeHooks.remove(id(), this);
            }
        }
    }

    private static final class ModernFrameworkBridge implements FrameworkBridge {
        private final XposedInterface framework;

        private ModernFrameworkBridge(XposedInterface framework) {
            this.framework = Objects.requireNonNull(framework, "framework");
        }

        @Override
        public InstalledHook install(Executable executable, String id,
                                     Interceptor interceptor) {
            XposedInterface.HookHandle handle = framework.hook(executable)
                    .setId(id)
                    .setExceptionMode(XposedInterface.ExceptionMode.PROTECTIVE)
                    .intercept(chain -> interceptor.intercept(new InvocationChain() {
                        @Override
                        public Executable executable() {
                            return chain.getExecutable();
                        }

                        @Override
                        public Object receiver() {
                            return chain.getThisObject();
                        }

                        @Override
                        public Object[] args() {
                            return chain.getArgs().toArray();
                        }

                        @Override
                        public Object proceed(Object[] args) throws Throwable {
                            return chain.proceed(args);
                        }
                    }));
            return new InstalledHook() {
                @Override
                public Executable executable() {
                    return handle.getExecutable();
                }

                @Override
                public String id() {
                    return handle.getId();
                }

                @Override
                public void unhook() {
                    handle.unhook();
                }
            };
        }

        @Override
        public Object invokeOrigin(Executable executable, Object receiver, Object[] args)
                throws Throwable {
            try {
                if (executable instanceof Method) {
                    return framework.getInvoker((Method) executable)
                            .setType(XposedInterface.Invoker.Type.ORIGIN)
                            .invoke(receiver, args);
                }
                if (executable instanceof Constructor<?>) {
                    return framework.getInvoker((Constructor<?>) executable)
                            .setType(XposedInterface.Invoker.Type.ORIGIN)
                            .newInstance(args);
                }
                throw new IllegalArgumentException("Unsupported executable: " + executable);
            } catch (InvocationTargetException exception) {
                if (exception.getCause() != null) {
                    throw exception.getCause();
                }
                throw exception;
            }
        }
    }
}
