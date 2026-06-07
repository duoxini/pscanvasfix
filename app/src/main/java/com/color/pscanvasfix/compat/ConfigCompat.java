package com.color.pscanvasfix.compat;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConfigCompat {
    private static final Pattern BOUNDS_PATTERN = Pattern.compile("mBounds=Rect\\((\\d+), (\\d+) - (\\d+), (\\d+)\\)");
    private static final Pattern MAX_BOUNDS_PATTERN = Pattern.compile("mMaxBounds=Rect\\((\\d+), (\\d+) - (\\d+), (\\d+)\\)");

    private ConfigCompat() {
    }

    public static Rect getBounds(Configuration config, Context context) {
        Rect fromWindowConfiguration = readBoundsFromWindowConfiguration(getWindowConfigurationObject(config));
        if (isValid(fromWindowConfiguration)) {
            return fromWindowConfiguration;
        }
        return getBoundsFromContext(context);
    }

    public static Rect getMaxBounds(Configuration config, Context context) {
        Rect fromWindowConfiguration = readMaxBoundsFromWindowConfiguration(getWindowConfigurationObject(config));
        if (isValid(fromWindowConfiguration)) {
            return fromWindowConfiguration;
        }
        return getBounds(config, context);
    }

    public static int getMaxHeight(Context context) {
        return getMaxBounds(context.getResources().getConfiguration(), context).height();
    }

    public static int getMaxWidth(Context context) {
        return getMaxBounds(context.getResources().getConfiguration(), context).width();
    }

    public static Object getWindowConfigurationObject(Configuration config) {
        if (config == null) {
            return null;
        }
        Object legacy = readLegacyField(config);
        if (legacy != null) {
            return legacy;
        }
        Object fromExt = readFromWindowConfigurationExt(config);
        if (fromExt != null) {
            return fromExt;
        }
        Object fromWrapper = readFromCompatWrapper(config);
        if (fromWrapper != null) {
            return fromWrapper;
        }
        return createWindowConfigurationFromToString(config.toString());
    }

    private static Object readLegacyField(Configuration config) {
        try {
            Field field = Configuration.class.getDeclaredField("windowConfiguration");
            field.setAccessible(true);
            return field.get(config);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Object readFromWindowConfigurationExt(Configuration config) {
        try {
            Field extField = Configuration.class.getDeclaredField("mWindowConfigurationExt");
            extField.setAccessible(true);
            Object ext = extField.get(config);
            if (ext == null) {
                return null;
            }
            Method method = ext.getClass().getDeclaredMethod("getCompatWindowConfiguration");
            method.setAccessible(true);
            return method.invoke(ext);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Object readFromCompatWrapper(Configuration config) {
        String[] methodNames = {"getCompatWindowConfigurationWrapper", "getWindowConfiguration"};
        for (String methodName : methodNames) {
            try {
                Method method = Configuration.class.getDeclaredMethod(methodName);
                method.setAccessible(true);
                Object wrapper = method.invoke(config);
                if (wrapper == null) {
                    continue;
                }
                if (isWindowConfigurationClass(wrapper.getClass())) {
                    return wrapper;
                }
                Method getter = wrapper.getClass().getDeclaredMethod("getWindowConfiguration");
                getter.setAccessible(true);
                return getter.invoke(wrapper);
            } catch (Throwable ignored) {
            }
        }
        return null;
    }

    private static Object createWindowConfigurationFromToString(String text) {
        Rect bounds = parseRect(text, MAX_BOUNDS_PATTERN);
        if (!isValid(bounds)) {
            bounds = parseRect(text, BOUNDS_PATTERN);
        }
        if (!isValid(bounds)) {
            return null;
        }
        try {
            Class<?> windowConfigurationClass = Class.forName("android.app.WindowConfiguration");
            Object windowConfiguration = windowConfigurationClass.newInstance();
            Method setBounds = windowConfigurationClass.getDeclaredMethod("setBounds", Rect.class);
            setBounds.invoke(windowConfiguration, bounds);
            Method setMaxBounds = windowConfigurationClass.getDeclaredMethod("setMaxBounds", Rect.class);
            setMaxBounds.invoke(windowConfiguration, bounds);
            return windowConfiguration;
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Rect readBoundsFromWindowConfiguration(Object windowConfiguration) {
        if (windowConfiguration == null) {
            return null;
        }
        try {
            Method getBounds = windowConfiguration.getClass().getDeclaredMethod("getBounds");
            return copyRect((Rect) getBounds.invoke(windowConfiguration));
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Rect readMaxBoundsFromWindowConfiguration(Object windowConfiguration) {
        if (windowConfiguration == null) {
            return null;
        }
        try {
            Method getMaxBounds = windowConfiguration.getClass().getDeclaredMethod("getMaxBounds");
            return copyRect((Rect) getMaxBounds.invoke(windowConfiguration));
        } catch (Throwable ignored) {
            return readBoundsFromWindowConfiguration(windowConfiguration);
        }
    }

    private static Rect parseRect(String text, Pattern pattern) {
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) {
            return null;
        }
        return new Rect(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4))
        );
    }

    private static Rect getBoundsFromContext(Context context) {
        if (context != null) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                if (windowManager != null) {
                    return windowManager.getCurrentWindowMetrics().getBounds();
                }
            } catch (Throwable ignored) {
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private static boolean isWindowConfigurationClass(Class<?> clazz) {
        return "android.app.WindowConfiguration".equals(clazz.getName());
    }

    private static Rect copyRect(Rect rect) {
        return rect == null ? null : new Rect(rect);
    }

    private static boolean isValid(Rect rect) {
        return rect != null && rect.left >= 0 && rect.top >= 0 && rect.right > rect.left && rect.bottom > rect.top;
    }
}
