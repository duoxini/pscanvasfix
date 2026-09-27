package com.color.pscanvasfix.runtime;

/** Before/after callback for a project-owned hook invocation. */
public abstract class HookCallback {
    protected void beforeHookedMethod(HookCall param) throws Throwable {
    }

    protected void afterHookedMethod(HookCall param) throws Throwable {
    }
}
