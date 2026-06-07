package com.color.pscanvasfix;

import com.color.pscanvasfix.hook.PsCanvasHooks;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public final class MainHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        PsCanvasHooks.install(lpparam);
    }
}
