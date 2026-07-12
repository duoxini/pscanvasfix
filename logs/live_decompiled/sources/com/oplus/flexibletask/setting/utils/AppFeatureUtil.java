package com.oplus.flexibletask.setting.utils;

import android.content.Context;

/* loaded from: classes.dex */
public class AppFeatureUtil {
    private static final String FEATURE_LIGHT_OS_ANIMATION = "com.android.launcher.light_animator";
    private static final String FEATURE_LIGHT_OS_GESTURE_INTO_ZOOM = "com.android.launcher.force_enable_floating_window";
    private static final String FEATURE_LIGHT_WEIGHT_OS = "com.android.launcher.light_weight_os";
    private static final String FEATURE_MINIPROGRAM_EVENT_TRACKING = "com.oplus.exserviceui.miniprogram_event_tracking";

    public static boolean isGestureUnsupported(Context context) {
        return (lightOsAnimationSupport(context) && !linghtOsGestureIntoZoomSupport(context)) || lightWeightOsSupport(context);
    }

    public static boolean lightOsAnimationSupport(Context context) {
        return o1.b.f(context.getContentResolver(), FEATURE_LIGHT_OS_ANIMATION);
    }

    public static boolean lightWeightOsSupport(Context context) {
        return o1.b.f(context.getContentResolver(), FEATURE_LIGHT_WEIGHT_OS);
    }

    public static boolean linghtOsGestureIntoZoomSupport(Context context) {
        return o1.b.f(context.getContentResolver(), FEATURE_LIGHT_OS_GESTURE_INTO_ZOOM);
    }

    public static boolean miniProgramEventTrackingSupport(Context context) {
        return o1.b.b(context.getContentResolver(), FEATURE_MINIPROGRAM_EVENT_TRACKING, false);
    }
}
