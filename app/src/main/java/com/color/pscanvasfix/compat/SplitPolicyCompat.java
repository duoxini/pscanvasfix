package com.color.pscanvasfix.compat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceControl;
import android.view.View;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class SplitPolicyCompat {
    private static final String TAG = "PsCanvasFix";

    private SplitPolicyCompat() {
    }

    public static List<Object> getTransitionEntries(Object splitPolicy) {
        if (splitPolicy == null) {
            return new ArrayList();
        }
        for (Field field : splitPolicy.getClass().getDeclaredFields()) {
            if (List.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(splitPolicy);
                    if (value instanceof List) {
                        List<?> list = (List) value;
                        if (!list.isEmpty() && isTransitionEntry(list.get(0))) {
                            @SuppressWarnings("unchecked")
                            List<Object> typed = (List<Object>) list;
                            return typed;
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
        return new ArrayList();
    }

    public static Context findContext(Object splitPolicy) {
        if (splitPolicy == null) {
            return null;
        }
        for (Field field : splitPolicy.getClass().getDeclaredFields()) {
            if (Context.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(splitPolicy);
                    if (value instanceof Context) {
                        return (Context) value;
                    }
                    continue;
                } catch (Throwable th) {
                }
            }
        }
        return null;
    }

    public static Object findContainerView(Object splitPolicy) {
        Object obj = null;
        if (splitPolicy == null) {
            return null;
        }
        for (Field field : splitPolicy.getClass().getDeclaredFields()) {
            if (field.getType().getName().contains("ContainerView")) {
                try {
                    field.setAccessible(true);
                    return field.get(splitPolicy);
                } catch (Throwable th) {
                }
            }
        }
        return obj;
    }

    public static Set<Integer> getEmbeddedCanvasTaskIds(Object splitPolicy) {
        List<?> embeddedViews = null;
        Object taskData;
        Set<Integer> taskIds = new HashSet<>();
        Object containerView = findContainerView(splitPolicy);
        if (containerView == null) {
            return taskIds;
        }
        try {
            embeddedViews = (List) XposedHelpers.callMethod(containerView, "getChildEmbeddedViewList", new Object[0]);
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: getEmbeddedCanvasTaskIds failed: " + throwable);
        }
        if (embeddedViews == null) {
            return taskIds;
        }
        for (Object embeddedView : embeddedViews) {
            if (embeddedView != null && (taskData = XposedHelpers.callMethod(embeddedView, "getTaskData", new Object[0])) != null) {
                taskIds.add(Integer.valueOf(((Integer) XposedHelpers.callMethod(taskData, "s", new Object[0])).intValue()));
            }
        }
        return taskIds;
    }

    public static List<Object> getEmbeddedTransitionEntries(Object splitPolicy) {
        List<Object> entries = getTransitionEntries(splitPolicy);
        Set<Integer> embeddedTaskIds = getEmbeddedCanvasTaskIds(splitPolicy);
        if (embeddedTaskIds.isEmpty()) {
            return entries;
        }
        List<Object> filtered = new ArrayList<>();
        for (Object entry : entries) {
            if (embeddedTaskIds.contains(Integer.valueOf(getTaskId(entry)))) {
                filtered.add(entry);
            }
        }
        return filtered;
    }

    public static int resolveContainerTaskId(Object splitPolicy, ClassLoader classLoader) {
        Activity activity = null;
        try {
            Context context = findContext(splitPolicy);
            Object containerView = findContainerView(splitPolicy);
            if (context != null && containerView != null) {
                Object resolved = XposedHelpers.callMethod(containerView, "Q2", context);
                if (resolved instanceof Activity) {
                    activity = (Activity) resolved;
                }
            }
        } catch (Throwable th) {
        }
        if (activity == null) {
            return 0;
        }
        try {
            return (Integer) XposedHelpers.callMethod(activity, "u0");
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: resolveContainerTaskId failed: " + throwable);
            return 0;
        }
    }

    public static int[] extractTaskIds(Object splitPolicy) {
        return toTaskIdArray(getEmbeddedTransitionEntries(splitPolicy));
    }

    public static Object findEmbeddedDecorByTaskId(Object splitPolicy, int taskId) {
        List<?> embeddedViews = null;
        Object taskData;
        Object containerView = findContainerView(splitPolicy);
        if (containerView == null || taskId <= 0) {
            return null;
        }
        try {
            embeddedViews = (List) XposedHelpers.callMethod(containerView, "getChildEmbeddedViewList", new Object[0]);
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: findEmbeddedDecorByTaskId failed: " + throwable);
        }
        if (embeddedViews == null) {
            return null;
        }
        for (Object embeddedView : embeddedViews) {
            if (embeddedView != null && (taskData = XposedHelpers.callMethod(embeddedView, "getTaskData", new Object[0])) != null && ((Integer) XposedHelpers.callMethod(taskData, "s", new Object[0])).intValue() == taskId) {
                return embeddedView;
            }
        }
        return null;
    }

    private static int[] toTaskIdArray(List<Object> entries) {
        int[] taskIds = new int[entries.size()];
        for (int index = 0; index < entries.size(); index++) {
            taskIds[index] = getTaskId(entries.get(index));
        }
        return taskIds;
    }

    private static Object getEmbeddedDecor(Object entry) {
        Object obj = null;
        if (entry == null) {
            return null;
        }
        for (Field field : entry.getClass().getDeclaredFields()) {
            if (field.getType().getName().contains("EmbeddedViewDecor")) {
                try {
                    field.setAccessible(true);
                    return field.get(entry);
                } catch (Throwable th) {
                }
            }
        }
        return obj;
    }

    private static boolean isEmbeddedDecorReady(Object decor) {
        try {
            return ((Boolean) XposedHelpers.callMethod(decor, "getInitialized", new Object[0])).booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public static void hideCanvasImmediately(Object splitPolicy) {
        Object containerView = findContainerView(splitPolicy);
        if (!(containerView instanceof View)) {
            return;
        }
        View view = (View) containerView;
        view.setAlpha(0.0f);
        view.setVisibility(View.GONE);
    }

    public static void restoreCanvasVisibility(Object splitPolicy) {
        Object containerView = findContainerView(splitPolicy);
        if (!(containerView instanceof View)) {
            return;
        }
        View view = (View) containerView;
        view.setAlpha(1.0f);
        view.setVisibility(View.VISIBLE);
    }

    public static void hideEmbeddedViews(Object splitPolicy) {
        Object containerView = findContainerView(splitPolicy);
        if (containerView == null) {
            return;
        }
        try {
            List<?> embeddedViews = (List) XposedHelpers.callMethod(containerView, "getChildEmbeddedViewList", new Object[0]);
            if (embeddedViews == null) {
                return;
            }
            for (Object embeddedView : embeddedViews) {
                if (embeddedView instanceof View) {
                    View view = (View) embeddedView;
                    view.animate().cancel();
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: hideEmbeddedViews failed: " + throwable);
        }
    }

    public static void clearFlexibleAnimating(Object splitPolicy) {
        Object containerView = findContainerView(splitPolicy);
        if (containerView == null) {
            return;
        }
        try {
            XposedHelpers.callMethod(containerView, "setIsToFlexibleAnimating", new Object[]{false});
        } catch (Throwable th) {
        }
    }

    public static void sanitizeTransitionEntries(Object splitPolicy, Context context) {
        if (splitPolicy == null || context == null) {
            return;
        }
        Rect maxBounds = ConfigCompat.getMaxBounds(context.getResources().getConfiguration(), context);
        for (Object entry : getTransitionEntries(splitPolicy)) {
            Rect launchBounds = getLaunchBounds(entry);
            if (launchBounds != null && isValid(launchBounds)) {
                Rect fixed = clampRect(launchBounds, maxBounds);
                if (!fixed.equals(launchBounds)) {
                    setLaunchBounds(entry, fixed);
                    XposedBridge.log("PsCanvasFix: sanitized transition entry bounds from " + launchBounds + " to " + fixed);
                }
            }
        }
    }

    public static int getTaskId(Object entry) {
        Object decor = getEmbeddedDecor(entry);
        if (decor != null) {
            try {
                Object taskData = XposedHelpers.callMethod(decor, "getTaskData", new Object[0]);
                if (taskData != null) {
                    return ((Integer) XposedHelpers.callMethod(taskData, "s", new Object[0])).intValue();
                }
            } catch (Throwable throwable) {
                XposedBridge.log("PsCanvasFix: getTaskId from decor failed: " + throwable);
            }
        }
        Integer taskId = findTaskIdField(entry);
        if (taskId == null) {
            return 0;
        }
        return taskId.intValue();
    }

    private static Integer findTaskIdField(Object obj) {
        if (obj == null) {
            return null;
        }
        Integer candidate = null;
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.getType() != Integer.TYPE) {
                continue;
            }
            try {
                field.setAccessible(true);
                int value = field.getInt(obj);
                if (value > 100) {
                    return value;
                }
                if (value > 0 && candidate == null) {
                    candidate = value;
                }
            } catch (Throwable ignored) {
            }
        }
        return candidate;
    }

    public static Rect getLaunchBounds(Object entry) {
        return findLaunchBoundsField(entry);
    }

    public static float getLaunchScale(Object entry) {
        Float scale = findFloatField(entry);
        if (scale == null) {
            return 1.0f;
        }
        return scale.floatValue();
    }

    public static void setLaunchBounds(Object entry, Rect bounds) {
        if (entry == null || bounds == null) {
            return;
        }
        for (Field field : entry.getClass().getDeclaredFields()) {
            if (field.getType() == Rect.class) {
                try {
                    field.setAccessible(true);
                    Object current = field.get(entry);
                    if ((current instanceof Rect) && isLikelyLaunchBounds((Rect) current)) {
                        field.set(entry, new Rect(bounds));
                        return;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private static boolean isTransitionEntry(Object entry) {
        if (entry == null) {
            return false;
        }
        boolean hasDecor = false;
        boolean hasTaskId = false;
        boolean hasLaunchBounds = false;
        for (Field field : entry.getClass().getDeclaredFields()) {
            Class<?> type = field.getType();
            if (type.getName().contains("EmbeddedViewDecor")) {
                hasDecor = true;
            } else if (type == Integer.TYPE) {
                hasTaskId = true;
            } else if (type == Rect.class) {
                hasLaunchBounds = true;
            }
        }
        return hasDecor && hasTaskId && hasLaunchBounds;
    }

    private static Integer findIntField(Object entry, boolean preferPositive) {
        Integer candidate = null;
        for (Field field : entry.getClass().getDeclaredFields()) {
            if (field.getType() == Integer.TYPE) {
                try {
                    field.setAccessible(true);
                    int value = field.getInt(entry);
                    if ((!preferPositive || value > 0) && (candidate == null || value > candidate.intValue())) {
                        candidate = Integer.valueOf(value);
                    }
                } catch (Throwable th) {
                }
            }
        }
        return candidate;
    }

    private static Float findFloatField(Object entry) {
        Field[] declaredFields = entry.getClass().getDeclaredFields();
        int length = declaredFields.length;
        for (int i = 0; i < length; i++) {
            Field field = declaredFields[i];
            if (field.getType() == Float.TYPE) {
                try {
                    field.setAccessible(true);
                    float value = field.getFloat(entry);
                    if (value > 0.0f && value <= 2.0f) {
                        return Float.valueOf(value);
                    }
                } catch (Throwable th) {
                }
            }
        }
        return null;
    }

    private static Rect findLaunchBoundsField(Object entry) {
        Rect maskCandidate = null;
        Rect launchCandidate = null;
        for (Field field : entry.getClass().getDeclaredFields()) {
            if (field.getType() == Rect.class) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(entry);
                    if (value instanceof Rect) {
                        Rect rect = (Rect) value;
                        if (isValid(rect)) {
                            if (isLikelyLaunchBounds(rect)) {
                                launchCandidate = rect;
                            } else {
                                maskCandidate = rect;
                            }
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
        return launchCandidate != null ? launchCandidate : maskCandidate;
    }

    private static boolean isLikelyLaunchBounds(Rect rect) {
        return rect.width() < 2200 || rect.height() < 3200;
    }

    private static boolean isValid(Rect rect) {
        return rect != null && rect.width() > 0 && rect.height() > 0;
    }

    private static Rect clampRect(Rect source, Rect maxBounds) {
        Rect rect = new Rect(source);
        if (rect.right > maxBounds.right) {
            int width = rect.width();
            rect.right = maxBounds.right;
            rect.left = rect.right - width;
        }
        int width2 = rect.left;
        if (width2 < maxBounds.left) {
            int width3 = rect.width();
            rect.left = maxBounds.left;
            rect.right = rect.left + width3;
        }
        int width4 = rect.bottom;
        if (width4 > maxBounds.bottom) {
            int height = rect.height();
            rect.bottom = maxBounds.bottom;
            rect.top = rect.bottom - height;
        }
        int height2 = rect.top;
        if (height2 < maxBounds.top) {
            int height3 = rect.height();
            rect.top = maxBounds.top;
            rect.bottom = rect.top + height3;
        }
        if (!isValid(rect)) {
            rect.intersect(maxBounds);
        }
        return rect;
    }

    private static boolean hasSurfaceControlField(Object entry) {
        for (Field field : entry.getClass().getDeclaredFields()) {
            if (SurfaceControl.class.isAssignableFrom(field.getType())) {
                return true;
            }
        }
        return false;
    }
}
