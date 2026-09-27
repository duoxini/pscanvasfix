package com.color.pscanvasfix.runtime;

/** Complete method replacement; the OEM origin runs only when the callback invokes it explicitly. */
public abstract class HookReplacement extends HookCallback {
    protected abstract Object replaceHookedMethod(HookCall param) throws Throwable;
}
