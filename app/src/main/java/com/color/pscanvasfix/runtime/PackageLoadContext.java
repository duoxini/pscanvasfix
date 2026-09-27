package com.color.pscanvasfix.runtime;

import android.content.pm.ApplicationInfo;

import com.color.pscanvasfix.config.ModulePreferences;

import java.util.Objects;

/** Project-owned package-load data passed from the modern module entry point. */
public final class PackageLoadContext {
    public final String packageName;
    public final ApplicationInfo appInfo;
    public final ClassLoader classLoader;
    public final ModulePreferences.Snapshot preferences;

    public PackageLoadContext(String packageName, ApplicationInfo appInfo,
                              ClassLoader classLoader) {
        this(packageName, appInfo, classLoader, ModulePreferences.Snapshot.defaults());
    }

    public PackageLoadContext(String packageName, ApplicationInfo appInfo,
                              ClassLoader classLoader,
                              ModulePreferences.Snapshot preferences) {
        this.packageName = Objects.requireNonNull(packageName, "packageName");
        this.appInfo = Objects.requireNonNull(appInfo, "appInfo");
        this.classLoader = Objects.requireNonNull(classLoader, "classLoader");
        this.preferences = Objects.requireNonNull(preferences, "preferences");
    }
}
