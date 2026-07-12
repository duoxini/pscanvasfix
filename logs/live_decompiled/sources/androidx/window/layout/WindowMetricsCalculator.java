package androidx.window.layout;

import C2.l;
import D2.k;
import android.util.DisplayMetrics;
import androidx.core.view.J;
import androidx.window.core.Bounds;

/* loaded from: classes.dex */
public interface WindowMetricsCalculator {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f7194a = Companion.f7195a;

    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f7195a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        private static l f7196b = WindowMetricsCalculator$Companion$decorator$1.f7197e;

        private Companion() {
        }

        public final WindowMetrics a(DisplayMetrics displayMetrics) {
            k.e(displayMetrics, "displayMetrics");
            Bounds bounds = new Bounds(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            J a3 = new J.b().a();
            k.d(a3, "Builder().build()");
            return new WindowMetrics(bounds, a3);
        }
    }
}
