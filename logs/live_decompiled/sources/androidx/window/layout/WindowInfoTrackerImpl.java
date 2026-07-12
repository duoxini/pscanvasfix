package androidx.window.layout;

import D2.k;
import L2.O;
import O2.c;
import O2.e;
import android.app.Activity;
import androidx.window.layout.adapter.WindowBackend;

/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {

    /* renamed from: b, reason: collision with root package name */
    private final WindowMetricsCalculator f7177b;

    /* renamed from: c, reason: collision with root package name */
    private final WindowBackend f7178c;

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        k.e(windowMetricsCalculator, "windowMetricsCalculator");
        k.e(windowBackend, "windowBackend");
        this.f7177b = windowMetricsCalculator;
        this.f7178c = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public c a(Activity activity) {
        k.e(activity, "activity");
        return e.e(e.a(new WindowInfoTrackerImpl$windowLayoutInfo$2(this, activity, null)), O.c());
    }
}
