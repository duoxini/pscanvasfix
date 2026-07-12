package com.coui.component.responsiveui.status;

import D2.k;
import L2.AbstractC0175g;
import L2.O;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.p;
import androidx.window.layout.FoldingFeature;
import com.coui.component.responsiveui.ResponsiveUILog;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final class WindowFeatureUtil {
    public static final WindowFeatureUtil INSTANCE = new WindowFeatureUtil();

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f9356a;

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9356a = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("WindowFeatureUtil", 3);
    }

    private WindowFeatureUtil() {
    }

    public static final boolean isBookPosture(FoldingFeature foldingFeature) {
        k.e(foldingFeature, "foldingFeature");
        if (f9356a) {
            Log.d("WindowFeatureUtil", "[isBookPosture] state: " + foldingFeature.getState() + ", orientation: " + foldingFeature.a());
        }
        return k.a(foldingFeature.getState(), FoldingFeature.State.f7153d) && k.a(foldingFeature.a(), FoldingFeature.Orientation.f7148c);
    }

    public static final boolean isSupportWindowFeature() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object invoke = cls.getDeclaredMethod("getInstance", null).invoke(null, null);
            if (invoke == null) {
                return false;
            }
            Object invoke2 = cls.getDeclaredMethod("hasFeature", String.class).invoke(invoke, "oplus.software.display.google_extension_layout");
            k.c(invoke2, "null cannot be cast to non-null type kotlin.Boolean");
            if (f9356a) {
                Log.d("WindowFeatureUtil", "[isSupportWindowFeature] " + invoke2);
            }
            return ((Boolean) invoke2).booleanValue();
        } catch (Exception e3) {
            Log.e("WindowFeatureUtil", "[isSupportWindowFeature] " + e3);
            return false;
        }
    }

    public static final boolean isTableTopPosture(FoldingFeature foldingFeature) {
        k.e(foldingFeature, "foldingFeature");
        if (f9356a) {
            Log.d("WindowFeatureUtil", "[isTableTopPosture] state: " + foldingFeature.getState() + ", orientation: " + foldingFeature.a());
        }
        return k.a(foldingFeature.getState(), FoldingFeature.State.f7153d) && k.a(foldingFeature.a(), FoldingFeature.Orientation.f7149d);
    }

    public final void trackWindowFeature(ComponentActivity componentActivity, Consumer<WindowFeature> consumer) {
        k.e(componentActivity, "activity");
        k.e(consumer, "action");
        AbstractC0175g.b(p.a(componentActivity), O.c(), null, new WindowFeatureUtil$trackWindowFeature$1(componentActivity, consumer, null), 2, null);
    }
}
