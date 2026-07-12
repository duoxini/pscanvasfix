package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public abstract class d {

    static class a {
        static void a(EdgeEffect edgeEffect, float f3, float f4) {
            edgeEffect.onPull(f3, f4);
        }
    }

    private static class b {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f3, float f4) {
            try {
                return edgeEffect.onPullDistance(f3, f4);
            } catch (Throwable unused) {
                edgeEffect.onPull(f3, f4);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        return b.a(context, attributeSet);
    }

    public static float b(EdgeEffect edgeEffect) {
        return b.b(edgeEffect);
    }

    public static void c(EdgeEffect edgeEffect, float f3, float f4) {
        a.a(edgeEffect, f3, f4);
    }

    public static float d(EdgeEffect edgeEffect, float f3, float f4) {
        return b.c(edgeEffect, f3, f4);
    }
}
