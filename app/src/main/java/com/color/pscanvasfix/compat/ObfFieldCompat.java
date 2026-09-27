package com.color.pscanvasfix.compat;

import com.color.pscanvasfix.runtime.JavaReflectionBackend;
import com.color.pscanvasfix.runtime.ReflectionAccess;
import java.util.Objects;

/**
 * Runtime dex uses short obfuscated names (t, B, y...). Jadx shows f14147t etc.
 */
public final class ObfFieldCompat {
    private static final ReflectionAccess DEFAULT_REFLECTION_ACCESS =
            new ReflectionAccess(new JavaReflectionBackend());
    private static volatile ReflectionAccess reflectionAccess = DEFAULT_REFLECTION_ACCESS;

    // x1.r (SStoFlexible)
    public static final String R_INIT = "t";
    public static final String R_SCALE_END = "B";
    public static final String R_SCALE_MOVED = "D";
    public static final String R_NOT_SUPPORT_ZOOM = "v";
    public static final String R_SCALE = "c";
    public static final String R_INIT_MASK = "u";
    public static final String R_CHANGE_STATE = "y";
    public static final String R_MASK_ANIM = "n";
    public static final String R_CHANGE_ANIM = "o";
    public static final String R_SPRING = "F";
    public static final String R_SPRING_END = "b0";
    public static final String R_STATE = "G";
    public static final String R_LAYOUT_ORIENT = "H";
    public static final String R_EMBEDDED_DECORS = "I";
    public static final String R_CACHED_FLEX_BUNDLE = "L";
    public static final String R_MASKS = "r";
    public static final String R_ENTRIES = "E";
    public static final String R_CONTAINER = "b";

    // u1.c adapter: n()=f, t()=q
    public static final String ADAPTER_LAYOUT_T = "q";

    // com.oplus.pscanvas.canvasmode.canvas.y (gesture)
    public static final String GESTURE_SPLIT_ENABLED = "L";
    public static final String GESTURE_POINTER_COUNT = "A";
    public static final String GESTURE_SPLIT_POLICY = "c";
    public static final String GESTURE_CONTAINER = "g";
    public static final String GESTURE_SCALING = "B";
    public static final String GESTURE_PANORAMA = "u";
    public static final String GESTURE_ACTIVITY = "b";
    public static final String GESTURE_CONTEXT = "e";

    // u1.c (adapter layout)
    public static final String ADAPTER_LAYOUT = "f";

    private ObfFieldCompat() {
    }

    public static boolean getBoolean(Object target, String primary, String fallback) {
        return getBoolean(target, primary, fallback, false);
    }

    public static boolean getBoolean(Object target, String primary, String fallback, boolean defaultValue) {
        try {
            return reflectionAccess.getBooleanField(target, primary);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                try {
                    return reflectionAccess.getBooleanField(target, fallback);
                } catch (Throwable ignored) {
                }
            }
            PsCanvasLog.e("getBoolean failed for " + primary + ":", primaryError);
            return defaultValue;
        }
    }

    public static void setBoolean(Object target, String primary, String fallback, boolean value) {
        try {
            reflectionAccess.setBooleanField(target, primary, value);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                reflectionAccess.setBooleanField(target, fallback, value);
                return;
            }
            throw primaryError;
        }
    }

    public static int getInt(Object target, String primary, String fallback) {
        try {
            return reflectionAccess.getIntField(target, primary);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                return reflectionAccess.getIntField(target, fallback);
            }
            throw primaryError;
        }
    }

    public static void setInt(Object target, String primary, String fallback, int value) {
        try {
            reflectionAccess.setIntField(target, primary, value);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                reflectionAccess.setIntField(target, fallback, value);
                return;
            }
            throw primaryError;
        }
    }

    public static float getFloat(Object target, String primary, String fallback) {
        try {
            return reflectionAccess.getFloatField(target, primary);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                return reflectionAccess.getFloatField(target, fallback);
            }
            throw primaryError;
        }
    }

    public static Object getObject(Object target, String primary, String fallback) {
        try {
            return reflectionAccess.getObjectField(target, primary);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                return reflectionAccess.getObjectField(target, fallback);
            }
            throw primaryError;
        }
    }

    public static void setObject(Object target, String primary, String fallback, Object value) {
        try {
            reflectionAccess.setObjectField(target, primary, value);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                reflectionAccess.setObjectField(target, fallback, value);
                return;
            }
            throw primaryError;
        }
    }

    public static void setStaticBoolean(Class<?> clazz, String primary, String fallback, boolean value) {
        if (setStaticBooleanQuiet(clazz, primary, value)) {
            return;
        }
        if (fallback != null && setStaticBooleanQuiet(clazz, fallback, value)) {
            return;
        }
        throw new IllegalStateException("setStaticBoolean failed for " + primary + "/" + fallback);
    }

    /** Prefer jadx name f10934L over short L — wrong field breaks pinch routing. */
    public static void setGestureSplitEnabled(Class<?> gestureClass, boolean value) {
        if (gestureClass == null) {
            return;
        }
        if (setStaticBooleanQuiet(gestureClass, "f10934L", value)) {
            return;
        }
        if (setStaticBooleanQuiet(gestureClass, GESTURE_SPLIT_ENABLED, value)) {
            return;
        }
        for (java.lang.reflect.Field field : gestureClass.getDeclaredFields()) {
            if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())
                    || field.getType() != boolean.class) {
                continue;
            }
            try {
                field.setAccessible(true);
                field.setBoolean(null, value);
                PsCanvasLog.w("setGestureSplitEnabled via scan " + field.getName()
                        + "=" + value);
                return;
            } catch (Throwable ignored) {
            }
        }
        PsCanvasLog.w("setGestureSplitEnabled failed for " + gestureClass.getName());
    }

    public static boolean getGestureSplitEnabled(Class<?> gestureClass, boolean defaultValue) {
        if (gestureClass == null) {
            return defaultValue;
        }
        try {
            return reflectionAccess.getStaticBooleanField(gestureClass, "f10934L");
        } catch (Throwable ignored) {
        }
        return getStaticBoolean(gestureClass, GESTURE_SPLIT_ENABLED, "f10934L", defaultValue);
    }

    private static boolean setStaticBooleanQuiet(Class<?> clazz, String name, boolean value) {
        try {
            reflectionAccess.setStaticBooleanField(clazz, name, value);
            return true;
        } catch (Throwable ignored) {
            return false;
        }
    }

    public static boolean getStaticBoolean(Class<?> clazz, String primary, String fallback, boolean defaultValue) {
        try {
            return reflectionAccess.getStaticBooleanField(clazz, primary);
        } catch (Throwable primaryError) {
            if (fallback != null) {
                try {
                    return reflectionAccess.getStaticBooleanField(clazz, fallback);
                } catch (Throwable ignored) {
                }
            }
            PsCanvasLog.e("getStaticBoolean failed for " + primary + ":", primaryError);
            return defaultValue;
        }
    }

    static synchronized void setReflectionAccessForTests(ReflectionAccess access) {
        reflectionAccess = Objects.requireNonNull(access, "access");
    }

    static synchronized void resetReflectionAccessForTests() {
        reflectionAccess = DEFAULT_REFLECTION_ACCESS;
    }
}
