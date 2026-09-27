package com.color.pscanvasfix.compat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import com.color.pscanvasfix.runtime.JavaReflectionBackend;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class I0Compat {
    private static final ReflectionAccess DEFAULT_REFLECTION_ACCESS =
            new ReflectionAccess(new JavaReflectionBackend());
    private static volatile ReflectionAccess reflectionAccess = DEFAULT_REFLECTION_ACCESS;
    private static final String UTIL = "B1.l";
    private static final String TASK_DATA = "u1.C0601d";

    private I0Compat() {
    }

    public static List<?> run(Context context, List<?> intents, int layoutOrientation, ClassLoader classLoader) {
        ClassLoader loader = classLoader;
        if (context != null && context.getClassLoader() != null) {
            loader = context.getClassLoader();
        }
        injectDisplayBounds(context, intents);
        try {
            Bundle bundle = (Bundle) reflectionAccess.callStaticMethod(
                    reflectionAccess.findClass(UTIL, loader),
                    "n",
                    intents,
                    layoutOrientation,
                    null
            );
            clearDisplayBounds(intents);
            return parseTaskDataList(context, intents, bundle, loader);
        } catch (Throwable throwable) {
            PsCanvasLog.e("o0 compat failed:", throwable);
            return null;
        }
    }

    private static void injectDisplayBounds(Context context, List<?> intents) {
        Rect bounds = ConfigCompat.getBounds(context.getResources().getConfiguration(), context);
        for (Object intent : intents) {
            if (intent instanceof Intent) {
                ((Intent) intent).putExtra("ps_config_display_bound", bounds);
            }
        }
    }

    private static void clearDisplayBounds(List<?> intents) {
        for (Object intent : intents) {
            if (intent instanceof Intent) {
                ((Intent) intent).putExtra("ps_config_display_bound", new Rect());
            }
        }
    }

    private static List<?> parseTaskDataList(Context context, List<?> intents, Bundle bundle, ClassLoader classLoader) {
        ArrayList<?> layoutInfoList;
        if (bundle == null || (layoutInfoList = bundle.getParcelableArrayList("androidx.flexible.layout.info.list", Bundle.class)) == null) {
            return null;
        }
        Class<?> taskDataClass = resolveTaskDataClass(classLoader);
        if (taskDataClass == null) {
            PsCanvasLog.w("task data class not found");
            return null;
        }
        ArrayList<Object> result = new ArrayList<>();
        for (int index = 0; index < layoutInfoList.size(); index++) {
            Bundle item = (Bundle) layoutInfoList.get(index);
            Intent intent = (Intent) intents.get(index);
            int resizeMode = item.getInt("androidx.flexible.ResizeMode", 0);
            if (resizeMode == 0) {
                PsCanvasLog.e("app does not support pocket studio", null);
                return null;
            }
            Rect launchBounds = item.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
            Object taskData = reflectionAccess.newInstance(taskDataClass, launchBounds, 0, intent);
            populateTaskData(taskData, item, launchBounds);
            result.add(taskData);
        }
        return result;
    }

    private static void populateTaskData(Object taskData, Bundle bundle, Rect launchBounds) {
        reflectionAccess.callMethod(taskData, "h0", bundle.getInt("key_single_app_split_disable_resize", 0));
        reflectionAccess.callMethod(taskData, "Y", bundle.getBoolean("key_single_app_split_is_package_has_inner_task", false));
        reflectionAccess.callMethod(taskData, "L", bundle.get("androidx.flexible.LaunchFillInBounds"));
        reflectionAccess.callMethod(taskData, "Q", bundle.getBoolean("androidx.flexible.IsOriginalResizable", false));
        reflectionAccess.callMethod(taskData, "b0", bundle.get("androidx.flexible.LaunchPredictBounds"));
        reflectionAccess.callMethod(taskData, "a0", bundle.get("androidx.flexible.LaunchPredictMaxBounds"));
        reflectionAccess.callMethod(taskData, "Z", bundle.get("androidx.flexible.LaunchPredictFillInBounds"));
        reflectionAccess.callMethod(taskData, "U", bundle.get("androidx.flexible.LaunchHorizontalBounds"));
        reflectionAccess.callMethod(taskData, "V", bundle.get("androidx.flexible.LaunchVerticalBounds"));
        if (bundle.get("androidx.flexible.LaunchPredictResizeableMode") != null) {
            reflectionAccess.callMethod(taskData, "c0", bundle.getInt("androidx.flexible.LaunchPredictResizeableMode"));
        }
        if (launchBounds == null || launchBounds.isEmpty()) {
            return;
        }
        int resizeMode = bundle.getInt("androidx.flexible.ResizeMode", 0);
        reflectionAccess.callMethod(taskData, "g0", resizeMode);
        if (resizeMode == 2) {
            Object ratio = bundle.get("androidx.flexible.CompatRatio");
            if (ratio instanceof Float) {
                reflectionAccess.callMethod(taskData, "e0", ratio);
            }
            reflectionAccess.callMethod(taskData, "K", bundle.get("androidx.flexible.LaunchMaxBounds"));
        }
        reflectionAccess.callMethod(taskData, "W", bundle.get("androidx.flexible.LaunchMaxBounds"));
        Rect preferredBounds = bundle.getParcelable("androidx.flexible.LaunchPreferredBounds", Rect.class);
        if ((resizeMode == 1 || resizeMode == 3) && preferredBounds != null && !preferredBounds.isEmpty()) {
            reflectionAccess.callMethod(taskData, "P", true);
        }
        reflectionAccess.callMethod(taskData, "X", bundle.getInt("androidx.flexible.ScreenOrientation", -2));
        reflectionAccess.callMethod(taskData, "i0", bundle.get("androidx.flexible.StableRect"));
        reflectionAccess.callMethod(taskData, "s0", bundle.get("androidx.flexible.WindowMetricsBounds"));
        reflectionAccess.callMethod(taskData, "R", bundle.getBoolean("androidx.activity.ParallelWindowMode", false));
    }

    private static Class<?> resolveTaskDataClass(ClassLoader classLoader) {
        String[] candidates = {TASK_DATA, "u1.d"};
        for (String name : candidates) {
            try {
                return Class.forName(name, false, classLoader);
            } catch (Throwable ignored) {
            }
            try {
                return reflectionAccess.findClass(name, classLoader);
            } catch (Throwable ignored) {
            }
        }
        return null;
    }

    static synchronized void setReflectionAccessForTests(ReflectionAccess access) {
        reflectionAccess = Objects.requireNonNull(access, "access");
    }

    static synchronized void resetReflectionAccessForTests() {
        reflectionAccess = DEFAULT_REFLECTION_ACCESS;
    }
}
