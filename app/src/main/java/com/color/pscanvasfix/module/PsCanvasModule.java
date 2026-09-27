package com.color.pscanvasfix.module;

import android.content.pm.ApplicationInfo;

import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.config.ModulePreferences;
import com.color.pscanvasfix.hook.PsCanvasHooks;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.ModernXposedLogSink;
import com.color.pscanvasfix.runtime.PackageLoadContext;

import java.util.concurrent.atomic.AtomicBoolean;

import io.github.libxposed.api.XposedModule;

/** Modern libxposed lifecycle entry for the PsCanvas target process. */
public final class PsCanvasModule extends XposedModule {
    private static final String TARGET_PACKAGE = "com.oplus.pscanvas";

    private final AtomicBoolean installStarted = new AtomicBoolean();
    private volatile String processName;

    @Override
    public void onModuleLoaded(ModuleLoadedParam param) {
        ModernXposedLogSink.attach(this);
        processName = param.getProcessName();
        PsCanvasLog.i("module loaded process=" + processName
                + " framework=" + getFrameworkName()
                + " version=" + getFrameworkVersion()
                + " api=" + getApiVersion());
    }

    @Override
    public void onPackageReady(PackageReadyParam param) {
        String packageName = param.getPackageName();
        ApplicationInfo appInfo = param.getApplicationInfo();
        PsCanvasLog.i("package ready package=" + packageName
                + " process=" + processName
                + " firstPackage=" + param.isFirstPackage());
        if (appInfo == null) {
            PsCanvasLog.e("package ready ignored: ApplicationInfo missing", null);
            return;
        }
        String targetProcess = appInfo.processName == null ? packageName : appInfo.processName;
        if (!TARGET_PACKAGE.equals(packageName) || !targetProcess.equals(processName)) {
            return;
        }
        if (!installStarted.compareAndSet(false, true)) {
            PsCanvasLog.w("package ready ignored: hooks already installed or installing");
            return;
        }
        ModulePreferences.Snapshot preferences = readPreferenceSnapshot();
        PackageLoadContext context = new PackageLoadContext(
                packageName, appInfo, param.getClassLoader(), preferences);
        PsCanvasHooks.install(context, new HookRuntime(this));
    }

    private ModulePreferences.Snapshot readPreferenceSnapshot() {
        try {
            ModulePreferences.Snapshot snapshot = ModulePreferences.readSnapshot(
                    getRemotePreferences(ModulePreferences.PREFERENCES_NAME));
            PsCanvasLog.i("preference snapshot loaded " + snapshot);
            return snapshot;
        } catch (RuntimeException exception) {
            PsCanvasLog.e("preference snapshot unavailable; optional features disabled",
                    exception);
            return ModulePreferences.Snapshot.defaults();
        }
    }
}
