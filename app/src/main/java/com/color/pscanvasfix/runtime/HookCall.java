package com.color.pscanvasfix.runtime;

import java.lang.reflect.Executable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Project-owned state for one intercepted invocation.
 *
 * <p>The argument array is copied from the framework chain before callbacks run. Callbacks may
 * update its elements; {@link HookRuntime} explicitly passes a second copy to
 * {@code Chain.proceed(Object[])}.</p>
 */
public final class HookCall {
    @FunctionalInterface
    interface OriginalInvoker {
        Object invoke(Executable executable, Object receiver, Object[] args) throws Throwable;
    }

    public final Executable method;
    public final Object thisObject;
    public final Object[] args;

    private final OriginalInvoker originalInvoker;
    private Map<String, Object> extras;
    private Object result;
    private Throwable throwable;
    private boolean returnEarly;

    static final class Outcome {
        private final Object result;
        private final Throwable throwable;
        private final boolean returnEarly;

        private Outcome(Object result, Throwable throwable, boolean returnEarly) {
            this.result = result;
            this.throwable = throwable;
            this.returnEarly = returnEarly;
        }
    }

    HookCall(Executable method, Object thisObject, Object[] args,
             OriginalInvoker originalInvoker) {
        this.method = Objects.requireNonNull(method, "method");
        this.thisObject = thisObject;
        this.args = args == null ? new Object[0] : args.clone();
        this.originalInvoker = Objects.requireNonNull(originalInvoker, "originalInvoker");
    }

    public Object getResult() {
        return result;
    }

    /** Sets the invocation result and clears any pending throwable. */
    public void setResult(Object result) {
        this.result = result;
        this.throwable = null;
        this.returnEarly = true;
    }

    public boolean hasThrowable() {
        return throwable != null;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    /** Sets the invocation throwable and clears any pending result. */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
        this.result = null;
        this.returnEarly = true;
    }

    /** Stores state shared only by the before/after callbacks of this invocation. */
    public void setObjectExtra(String key, Object value) {
        Objects.requireNonNull(key, "key");
        if (extras == null) {
            extras = new HashMap<>();
        }
        extras.put(key, value);
    }

    public Object getObjectExtra(String key) {
        Objects.requireNonNull(key, "key");
        return extras == null ? null : extras.get(key);
    }

    /** Calls the OEM origin directly with the callback's current copied arguments. */
    public Object invokeOriginal() throws Throwable {
        return invokeOriginal(args);
    }

    /** Calls the OEM origin directly with a defensive copy of the supplied arguments. */
    public Object invokeOriginal(Object[] originArgs) throws Throwable {
        Object[] copiedArgs = originArgs == null ? new Object[0] : originArgs.clone();
        return originalInvoker.invoke(method, thisObject, copiedArgs);
    }

    boolean shouldReturnEarly() {
        return returnEarly;
    }

    void completeWithResult(Object result) {
        this.result = result;
        this.throwable = null;
    }

    void completeWithThrowable(Throwable throwable) {
        this.throwable = Objects.requireNonNull(throwable, "throwable");
        this.result = null;
    }

    Outcome snapshotOutcome() {
        return new Outcome(result, throwable, returnEarly);
    }

    void restoreOutcome(Outcome outcome) {
        this.result = outcome.result;
        this.throwable = outcome.throwable;
        this.returnEarly = outcome.returnEarly;
    }

    void resetForProceed() {
        this.result = null;
        this.throwable = null;
        this.returnEarly = false;
    }
}
