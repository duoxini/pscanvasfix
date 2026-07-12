package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.core.view.animation.a$a, reason: collision with other inner class name */
    static class C0072a {
        static PathInterpolator a(float f3, float f4) {
            return new PathInterpolator(f3, f4);
        }

        static PathInterpolator b(float f3, float f4, float f5, float f6) {
            return new PathInterpolator(f3, f4, f5, f6);
        }

        static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f3, float f4, float f5, float f6) {
        return C0072a.b(f3, f4, f5, f6);
    }
}
