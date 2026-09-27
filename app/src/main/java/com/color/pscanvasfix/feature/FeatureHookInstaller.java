package com.color.pscanvasfix.feature;

import com.color.pscanvasfix.runtime.HookRuntime;

/** Package-local registration bridge shared by behavior features. */
final class FeatureHookInstaller {
    private FeatureHookInstaller() {
    }

    static void register(HookRuntime hookRuntime, String hookId, String className,
                         ClassLoader classLoader, String methodName,
                         Object... registrationArgs) {
        hookRuntime.findAndHookMethod(
                hookId, className, classLoader, methodName, registrationArgs);
    }
}
