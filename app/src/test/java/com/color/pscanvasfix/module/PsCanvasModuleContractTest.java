package com.color.pscanvasfix.module;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Source and packaging contract for the atomic modern libxposed entry cutover. */
public final class PsCanvasModuleContractTest {
    @Test
    public void entryFiltersTargetMainProcessAndInstallsOnceAtPackageReady()
            throws IOException {
        String source = read("app/src/main/java/com/color/pscanvasfix/module/PsCanvasModule.java");

        assertTrue(source.contains("extends XposedModule"));
        assertTrue(source.contains("public void onModuleLoaded(ModuleLoadedParam param)"));
        assertTrue(source.contains("ModernXposedLogSink.attach(this);"));
        assertTrue(source.contains("processName = param.getProcessName();"));
        assertTrue(source.contains("public void onPackageReady(PackageReadyParam param)"));
        assertTrue(source.contains("firstPackage=\" + param.isFirstPackage()"));
        assertTrue(source.contains("!TARGET_PACKAGE.equals(packageName)"));
        assertTrue(source.contains("!targetProcess.equals(processName)"));
        assertTrue(source.contains("installStarted.compareAndSet(false, true)"));
        assertTrue(source.contains("param.getClassLoader()"));
        assertTrue(source.contains("getRemotePreferences(ModulePreferences.PREFERENCES_NAME)"));
        assertTrue(source.contains("readPreferenceSnapshot()"));
        assertTrue(source.contains("PsCanvasHooks.install(context, new HookRuntime(this));"));
        assertFalse(source.contains("onPackageLoaded("));
    }

    @Test
    public void modernMetadataAndDependencyReplaceLegacySurfaces() throws IOException {
        assertEquals("com.color.pscanvasfix.module.PsCanvasModule\n",
                normalized("app/src/main/resources/META-INF/xposed/java_init.list"));
        assertEquals("com.oplus.pscanvas\n",
                normalized("app/src/main/resources/META-INF/xposed/scope.list"));
        assertEquals("minApiVersion=102\ntargetApiVersion=102\nstaticScope=true\n"
                        + "exceptionMode=protective\nautoHotReload=false\n",
                normalized("app/src/main/resources/META-INF/xposed/module.prop"));

        String gradle = read("app/build.gradle");
        String settings = read("settings.gradle");
        String manifest = read("app/src/main/AndroidManifest.xml");
        assertTrue(gradle.contains("compileOnly 'io.github.libxposed:api:102.0.0'"));
        assertFalse(gradle.contains("de.robv.android.xposed"));
        assertFalse(settings.contains("api.xposed.info"));
        assertFalse(manifest.contains("<meta-data"));
        assertFalse(Files.exists(root().resolve("app/src/main/assets/xposed_init")));
    }

    private static String normalized(String relative) throws IOException {
        return read(relative).replace("\r\n", "\n");
    }

    private static String read(String relative) throws IOException {
        return new String(Files.readAllBytes(root().resolve(relative)), StandardCharsets.UTF_8);
    }

    private static Path root() {
        Path root = Paths.get(System.getProperty("user.dir"));
        if (!Files.isDirectory(root.resolve("app"))) {
            root = root.getParent();
        }
        return root;
    }
}
