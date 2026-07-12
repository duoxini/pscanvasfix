package androidx.window.layout;

import D2.k;
import D2.s;
import O2.c;
import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import p2.AbstractC0506f;
import p2.InterfaceC0505e;

/* loaded from: classes.dex */
public interface WindowInfoTracker {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f7170a = Companion.f7171a;

    public static final class Companion {

        /* renamed from: b, reason: collision with root package name */
        private static final boolean f7172b = false;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f7171a = new Companion();

        /* renamed from: c, reason: collision with root package name */
        private static final String f7173c = s.b(WindowInfoTracker.class).b();

        /* renamed from: d, reason: collision with root package name */
        private static final InterfaceC0505e f7174d = AbstractC0506f.a(WindowInfoTracker$Companion$extensionBackend$2.f7176e);

        /* renamed from: e, reason: collision with root package name */
        private static WindowInfoTrackerDecorator f7175e = EmptyDecorator.f7142a;

        private Companion() {
        }

        public final WindowBackend c() {
            return (WindowBackend) f7174d.getValue();
        }

        public final WindowInfoTracker d(Context context) {
            k.e(context, "context");
            WindowBackend c3 = c();
            if (c3 == null) {
                c3 = SidecarWindowBackend.f7245c.a(context);
            }
            return f7175e.a(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.f7199b, c3));
        }
    }

    c a(Activity activity);
}
