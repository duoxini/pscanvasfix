package com.color.pscanvasfix.config;

import android.content.SharedPreferences;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public final class ModulePreferencesTest {
    @Test
    public void declaresStableKeysAndClosedDefaults() {
        assertEquals("module_preferences", ModulePreferences.PREFERENCES_NAME);
        assertEquals("adjustable_window_size", ModulePreferences.KEY_ADJUSTABLE_WINDOW_SIZE);
        assertEquals("four_task_canvas", ModulePreferences.KEY_FOUR_TASK_CANVAS);
        assertFalse(ModulePreferences.DEFAULT_ADJUSTABLE_WINDOW_SIZE);
        assertFalse(ModulePreferences.DEFAULT_FOUR_TASK_CANVAS);

        ModulePreferences.Snapshot defaults = ModulePreferences.Snapshot.defaults();
        assertFalse(defaults.adjustableWindowSizeEnabled());
        assertFalse(defaults.fourTaskCanvasEnabled());
        assertSame(defaults, ModulePreferences.Snapshot.of(false, false));
    }

    @Test
    public void readsBothBooleansWithoutOpeningAnEditorOrWriting() {
        Map<String, Boolean> values = new HashMap<>();
        values.put(ModulePreferences.KEY_ADJUSTABLE_WINDOW_SIZE, true);
        values.put(ModulePreferences.KEY_FOUR_TASK_CANVAS, false);
        List<String> calls = new ArrayList<>();
        SharedPreferences preferences = proxy((proxy, method, args) -> {
            calls.add(method.getName());
            if (!"getBoolean".equals(method.getName())) {
                throw new AssertionError("Unexpected SharedPreferences operation: "
                        + method.getName());
            }
            assertFalse((Boolean) args[1]);
            return values.getOrDefault((String) args[0], (Boolean) args[1]);
        });

        ModulePreferences.Snapshot snapshot = ModulePreferences.readSnapshot(preferences);

        assertTrue(snapshot.adjustableWindowSizeEnabled());
        assertFalse(snapshot.fourTaskCanvasEnabled());
        assertEquals(List.of("getBoolean", "getBoolean"), calls);
    }

    @Test
    public void producesIndependentImmutableValueSnapshots() {
        ModulePreferences.Snapshot first = ModulePreferences.Snapshot.of(true, false);
        ModulePreferences.Snapshot second = ModulePreferences.Snapshot.of(false, true);

        assertNotSame(first, second);
        assertTrue(first.adjustableWindowSizeEnabled());
        assertFalse(first.fourTaskCanvasEnabled());
        assertFalse(second.adjustableWindowSizeEnabled());
        assertTrue(second.fourTaskCanvasEnabled());
        assertEquals(first, ModulePreferences.Snapshot.of(true, false));
        assertEquals(first.hashCode(), ModulePreferences.Snapshot.of(true, false).hashCode());
    }

    @Test
    public void nullPreferencesFailClosed() {
        assertSame(ModulePreferences.Snapshot.defaults(),
                ModulePreferences.readSnapshot(null));
    }

    @Test
    public void firstReadFailureFailsEntireSnapshotClosed() {
        SharedPreferences preferences = proxy((proxy, method, args) -> {
            throw new SecurityException("remote preferences unavailable");
        });

        assertSame(ModulePreferences.Snapshot.defaults(),
                ModulePreferences.readSnapshot(preferences));
    }

    @Test
    public void laterReadFailureDiscardsEarlierEnabledValue() {
        SharedPreferences preferences = proxy((proxy, method, args) -> {
            if (ModulePreferences.KEY_ADJUSTABLE_WINDOW_SIZE.equals(args[0])) {
                return true;
            }
            throw new IllegalStateException("remote preferences became unavailable");
        });

        ModulePreferences.Snapshot snapshot = ModulePreferences.readSnapshot(preferences);

        assertFalse(snapshot.adjustableWindowSizeEnabled());
        assertFalse(snapshot.fourTaskCanvasEnabled());
        assertSame(ModulePreferences.Snapshot.defaults(), snapshot);
    }

    private static SharedPreferences proxy(java.lang.reflect.InvocationHandler handler) {
        return (SharedPreferences) Proxy.newProxyInstance(
                SharedPreferences.class.getClassLoader(),
                new Class<?>[]{SharedPreferences.class},
                handler);
    }
}
