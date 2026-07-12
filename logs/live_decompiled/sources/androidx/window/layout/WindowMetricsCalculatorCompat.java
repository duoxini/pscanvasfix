package androidx.window.layout;

import D2.k;
import android.content.Context;
import androidx.core.view.J;
import androidx.window.layout.util.ContextCompatHelperApi30;
import java.util.ArrayList;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {

    /* renamed from: b, reason: collision with root package name */
    public static final WindowMetricsCalculatorCompat f7199b = new WindowMetricsCalculatorCompat();

    /* renamed from: c, reason: collision with root package name */
    private static final String f7200c;

    /* renamed from: d, reason: collision with root package name */
    private static final ArrayList f7201d;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        k.d(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f7200c = simpleName;
        f7201d = AbstractC0544n.f(Integer.valueOf(J.l.g()), Integer.valueOf(J.l.f()), Integer.valueOf(J.l.a()), Integer.valueOf(J.l.c()), Integer.valueOf(J.l.i()), Integer.valueOf(J.l.e()), Integer.valueOf(J.l.j()), Integer.valueOf(J.l.b()));
    }

    private WindowMetricsCalculatorCompat() {
    }

    public WindowMetrics a(Context context) {
        k.e(context, "context");
        return ContextCompatHelperApi30.f7263a.b(context);
    }
}
