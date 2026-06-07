package com.color.pscanvasfix.compat;

import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class AtmCompat {
    private static volatile Object cachedAtm;
    private static volatile ClassLoader cachedClassLoader;

    private AtmCompat() {
    }

    public static Object getAtm(ClassLoader classLoader) {
        if (cachedAtm != null && cachedClassLoader == classLoader) {
            return cachedAtm;
        }
        synchronized (AtmCompat.class) {
            if (cachedAtm != null && cachedClassLoader == classLoader) {
                return cachedAtm;
            }
            Class<?> atmClass = XposedHelpers.findClass("android.app.ActivityTaskManager", classLoader);
            Object atm = invokeStaticNoThrow(atmClass, "getInstance");
            if (atm == null) {
                atm = invokeStaticNoThrow(atmClass, "getService");
            }
            cachedAtm = atm;
            cachedClassLoader = classLoader;
            return atm;
        }
    }

    public static List<?> getTasks(ClassLoader classLoader, int maxNum, boolean filterOnlyVisibleRecents) {
        Object atm = getAtm(classLoader);
        if (atm == null) {
            return Collections.emptyList();
        }
        Object result = XposedHelpers.callMethod(atm, "getTasks", new Object[]{Integer.valueOf(maxNum), Boolean.valueOf(filterOnlyVisibleRecents)});
        return result == null ? Collections.emptyList() : (List) result;
    }

    public static List<?> getTasks(ClassLoader classLoader, int maxNum) {
        Object atm = getAtm(classLoader);
        if (atm != null) {
            try {
                Object result = XposedHelpers.callMethod(atm, "getTasks", new Object[]{Integer.valueOf(maxNum)});
                return result == null ? Collections.emptyList() : (List) result;
            } catch (Throwable th) {
                Object result2 = XposedHelpers.callMethod(atm, "getTasks", new Object[]{Integer.valueOf(maxNum), false});
                return result2 == null ? Collections.emptyList() : (List) result2;
            }
        }
        return Collections.emptyList();
    }

    public static List<?> getRecentTasks(ClassLoader classLoader, int maxNum, int flags, int userId) {
        Object atm = getAtm(classLoader);
        if (atm == null) {
            return Collections.emptyList();
        }
        Object result = XposedHelpers.callMethod(atm, "getRecentTasks", new Object[]{Integer.valueOf(maxNum), Integer.valueOf(flags), Integer.valueOf(userId)});
        return result == null ? Collections.emptyList() : (List) result;
    }

    public static boolean setFocusedTask(ClassLoader classLoader, int taskId) {
        if (taskId <= 0) {
            return false;
        }
        try {
            Class<?> atmClass = XposedHelpers.findClass("android.app.ActivityTaskManager", classLoader);
            Object service = invokeStaticNoThrow(atmClass, "getService");
            if (service == null) {
                service = getAtm(classLoader);
            }
            if (service == null) {
                return false;
            }
            XposedHelpers.callMethod(service, "setFocusedTask", new Object[]{Integer.valueOf(taskId)});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean moveTaskToBack(ClassLoader classLoader, int taskId) {
        if (taskId <= 0) {
            return false;
        }
        try {
            Class<?> managerClass = XposedHelpers.findClass("android.app.OplusActivityTaskManager", classLoader);
            Object manager = XposedHelpers.callStaticMethod(managerClass, "getInstance", new Object[0]);
            XposedHelpers.callMethod(manager, "moveTaskToBack", new Object[]{Integer.valueOf(taskId), true});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean removeTask(ClassLoader classLoader, int taskId) {
        if (taskId <= 0) {
            return false;
        }
        try {
            Class<?> atmClass = XposedHelpers.findClass("android.app.ActivityTaskManager", classLoader);
            Object service = invokeStaticNoThrow(atmClass, "getService");
            if (service == null) {
                service = getAtm(classLoader);
            }
            if (service == null) {
                return false;
            }
            XposedHelpers.callMethod(service, "removeTask", new Object[]{Integer.valueOf(taskId)});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Object invokeStaticNoThrow(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }
}
