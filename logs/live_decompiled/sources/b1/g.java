package B1;

import android.content.Context;
import android.util.Log;
import com.oplus.view.IJankManager;
import com.oplus.view.JankManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f184a = l.f202b;

    private static String a(int i3) {
        switch (i3) {
            case 401:
                return "MASK_ANIMATION_THREE_TO_TWO";
            case 402:
                return "MASK_ANIMATION_TWO_TO_ONE";
            case 403:
                return "MASK_ANIMATION_CHANGE_TWO_TASK_ORIENTATION";
            case 404:
                return "MASK_ANIMATION_ENLARGE_SMALL";
            case 405:
                return "MASK_ANIMATION_REPLACE";
            case 406:
                return "MASK_ANIMATION_SCROLL_SPLIT_BAR";
            default:
                return String.valueOf(i3);
        }
    }

    private static void b(Context context, int i3) {
        if (f184a) {
            Log.d("FlexibleWindowJankAnalyticsUtils", "beginGfxScene animationType=" + i3 + ", description=" + a(i3) + ", jankType=2, SKIPPED_FRAME=6");
        }
        JankManager.getInstance().gfxSceneBegin(context, e(context, i3));
    }

    public static void c(Context context, int i3) {
        if (i3 > 0 && context != null) {
            d(context, i3);
            b(context, i3);
        } else if (f184a) {
            Log.d("FlexibleWindowJankAnalyticsUtils", "beginLatencyAndGfxScene return.  animationType: " + i3);
        }
    }

    public static void d(Context context, int i3) {
        if (f184a) {
            Log.d("FlexibleWindowJankAnalyticsUtils", "beginLatencyScene animationType=" + i3 + ", description=" + a(i3) + ", jankType=0, latencyThresholdMs=2000");
        }
        JankManager.getInstance().latencySceneBegin(context, f(context, i3));
    }

    private static IJankManager.SceneInfo e(Context context, int i3) {
        IJankManager.SceneInfo sceneInfo = new IJankManager.SceneInfo();
        sceneInfo.initBasicInfo(context, 2, i3, a(i3));
        sceneInfo.updateThreshold(0L, 0L, 0, 0L, 6, 0L);
        return sceneInfo;
    }

    private static IJankManager.SceneInfo f(Context context, int i3) {
        IJankManager.SceneInfo sceneInfo = new IJankManager.SceneInfo();
        sceneInfo.initBasicInfo(context, 0, i3, a(i3));
        sceneInfo.updateThreshold(2000000000L, 0L, 0, 0L, 0, 0L);
        return sceneInfo;
    }

    private static void g(Context context, int i3) {
        if (f184a) {
            Log.d("FlexibleWindowJankAnalyticsUtils", "endGfxScene animationType=" + i3 + ", description=" + a(i3) + ", jankType=2, SKIPPED_FRAME=6");
        }
        JankManager.getInstance().gfxSceneEnd(context, i3);
    }

    public static void h(Context context, int i3) {
        if (i3 > 0 && context != null) {
            i(context, i3);
            g(context, i3);
        } else if (f184a) {
            Log.d("FlexibleWindowJankAnalyticsUtils", "endLatencyAndGfxScene return.  animationType: " + i3);
        }
    }

    public static void i(Context context, int i3) {
        if (f184a) {
            Log.d("FlexibleWindowJankAnalyticsUtils", "endLatencyScene animationType=" + i3 + ", description=" + a(i3) + ", jankType=0, latencyThresholdMs=2000");
        }
        JankManager.getInstance().latencySceneEnd(context, i3, (ArrayList) null);
    }
}
