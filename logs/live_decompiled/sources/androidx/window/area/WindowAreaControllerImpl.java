package androidx.window.area;

import D2.g;
import D2.k;
import D2.s;
import android.app.Activity;
import android.os.Binder;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.window.area.WindowAreaCapability;
import androidx.window.area.WindowAreaControllerImpl;
import androidx.window.area.WindowAreaInfo;
import androidx.window.area.utils.DeviceUtils;
import androidx.window.core.BuildConfig;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import java.util.HashMap;
import java.util.concurrent.Executor;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class WindowAreaControllerImpl implements WindowAreaController {

    /* renamed from: g, reason: collision with root package name */
    public static final Companion f6879g = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final String f6880h = s.b(WindowAreaControllerImpl.class).b();

    /* renamed from: a, reason: collision with root package name */
    private final WindowAreaComponent f6881a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6882b;

    /* renamed from: c, reason: collision with root package name */
    private Consumer f6883c;

    /* renamed from: d, reason: collision with root package name */
    private WindowAreaCapability.Status f6884d;

    /* renamed from: e, reason: collision with root package name */
    private WindowAreaCapability.Status f6885e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f6886f;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class RearDisplayPresentationSessionConsumer implements Consumer<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final Executor f6887a;

        /* renamed from: b, reason: collision with root package name */
        private final WindowAreaPresentationSessionCallback f6888b;

        /* renamed from: c, reason: collision with root package name */
        private final WindowAreaComponent f6889c;

        /* renamed from: d, reason: collision with root package name */
        private int f6890d;

        public RearDisplayPresentationSessionConsumer(Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback, WindowAreaComponent windowAreaComponent) {
            k.e(executor, "executor");
            k.e(windowAreaPresentationSessionCallback, "windowAreaPresentationSessionCallback");
            k.e(windowAreaComponent, "windowAreaComponent");
            this.f6887a = executor;
            this.f6888b = windowAreaPresentationSessionCallback;
            this.f6889c = windowAreaComponent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i3, int i4, RearDisplayPresentationSessionConsumer rearDisplayPresentationSessionConsumer) {
            k.e(rearDisplayPresentationSessionConsumer, "this$0");
            if (i3 == 0) {
                rearDisplayPresentationSessionConsumer.f6888b.a(null);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    rearDisplayPresentationSessionConsumer.f6888b.b(true);
                    return;
                }
                Log.e(WindowAreaControllerImpl.f6880h, "Invalid session state value received: " + i3);
                return;
            }
            if (i4 == 2) {
                rearDisplayPresentationSessionConsumer.f6888b.b(false);
                return;
            }
            WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback = rearDisplayPresentationSessionConsumer.f6888b;
            WindowAreaComponent windowAreaComponent = rearDisplayPresentationSessionConsumer.f6889c;
            ExtensionWindowAreaPresentation rearDisplayPresentation = windowAreaComponent.getRearDisplayPresentation();
            k.b(rearDisplayPresentation);
            windowAreaPresentationSessionCallback.c(new RearDisplayPresentationSessionPresenterImpl(windowAreaComponent, rearDisplayPresentation));
        }

        @Override // androidx.window.extensions.core.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            b(num.intValue());
        }

        public void b(final int i3) {
            final int i4 = this.f6890d;
            this.f6890d = i3;
            this.f6887a.execute(new Runnable() { // from class: androidx.window.area.a
                @Override // java.lang.Runnable
                public final void run() {
                    WindowAreaControllerImpl.RearDisplayPresentationSessionConsumer.c(i3, i4, this);
                }
            });
        }
    }

    public static final class RearDisplaySessionConsumer implements Consumer<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final Executor f6891a;

        /* renamed from: b, reason: collision with root package name */
        private final WindowAreaSessionCallback f6892b;

        /* renamed from: c, reason: collision with root package name */
        private final WindowAreaComponent f6893c;

        /* renamed from: d, reason: collision with root package name */
        private WindowAreaSession f6894d;

        public RearDisplaySessionConsumer(Executor executor, WindowAreaSessionCallback windowAreaSessionCallback, WindowAreaComponent windowAreaComponent) {
            k.e(executor, "executor");
            k.e(windowAreaSessionCallback, "appCallback");
            k.e(windowAreaComponent, "extensionsComponent");
            this.f6891a = executor;
            this.f6892b = windowAreaSessionCallback;
            this.f6893c = windowAreaComponent;
        }

        private final void d() {
            this.f6894d = null;
            this.f6891a.execute(new Runnable() { // from class: androidx.window.area.c
                @Override // java.lang.Runnable
                public final void run() {
                    WindowAreaControllerImpl.RearDisplaySessionConsumer.e(WindowAreaControllerImpl.RearDisplaySessionConsumer.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(RearDisplaySessionConsumer rearDisplaySessionConsumer) {
            k.e(rearDisplaySessionConsumer, "this$0");
            rearDisplaySessionConsumer.f6892b.a(null);
        }

        private final void f() {
            final RearDisplaySessionImpl rearDisplaySessionImpl = new RearDisplaySessionImpl(this.f6893c);
            this.f6894d = rearDisplaySessionImpl;
            this.f6891a.execute(new Runnable() { // from class: androidx.window.area.b
                @Override // java.lang.Runnable
                public final void run() {
                    WindowAreaControllerImpl.RearDisplaySessionConsumer.g(WindowAreaControllerImpl.RearDisplaySessionConsumer.this, rearDisplaySessionImpl);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(RearDisplaySessionConsumer rearDisplaySessionConsumer, WindowAreaSession windowAreaSession) {
            k.e(rearDisplaySessionConsumer, "this$0");
            k.e(windowAreaSession, "$it");
            rearDisplaySessionConsumer.f6892b.b(windowAreaSession);
        }

        @Override // androidx.window.extensions.core.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            c(num.intValue());
        }

        public void c(int i3) {
            if (i3 == 0) {
                d();
                return;
            }
            if (i3 == 1) {
                f();
                return;
            }
            if (BuildConfig.f6942a.a() == VerificationMode.STRICT) {
                Log.d(WindowAreaControllerImpl.f6880h, "Received an unknown session status value: " + i3);
            }
            d();
        }
    }

    private final boolean j(WindowAreaInfo windowAreaInfo) {
        for (Object obj : windowAreaInfo.a().values()) {
            k.d(obj, "windowAreaInfo.capabilityMap.values");
            if (!k.a(((WindowAreaCapability) obj).a(), WindowAreaCapability.Status.f6871d)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback) {
        if (k.a(this.f6884d, WindowAreaCapability.Status.f6874g)) {
            windowAreaSessionCallback.a(new IllegalStateException("The WindowArea feature is currently active, WindowAreaInfo#getActiveSessioncan be used to get an instance of the current active session"));
        } else {
            if (!k.a(this.f6884d, WindowAreaCapability.Status.f6873f)) {
                windowAreaSessionCallback.a(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
                return;
            }
            RearDisplaySessionConsumer rearDisplaySessionConsumer = new RearDisplaySessionConsumer(executor, windowAreaSessionCallback, this.f6881a);
            this.f6883c = rearDisplaySessionConsumer;
            this.f6881a.startRearDisplaySession(activity, rearDisplaySessionConsumer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback) {
        if (!k.a(this.f6885e, WindowAreaCapability.Status.f6873f)) {
            windowAreaPresentationSessionCallback.a(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
        } else {
            WindowAreaComponent windowAreaComponent = this.f6881a;
            windowAreaComponent.startRearDisplayPresentationSession(activity, new RearDisplayPresentationSessionConsumer(executor, windowAreaPresentationSessionCallback, windowAreaComponent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int i3) {
        WindowMetrics a3;
        if (this.f6882b >= 3) {
            WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.f7194a;
            DisplayMetrics rearDisplayMetrics = this.f6881a.getRearDisplayMetrics();
            k.d(rearDisplayMetrics, "windowAreaComponent.rearDisplayMetrics");
            a3 = companion.a(rearDisplayMetrics);
        } else {
            DeviceUtils deviceUtils = DeviceUtils.f6933a;
            String str = Build.MANUFACTURER;
            k.d(str, "MANUFACTURER");
            String str2 = Build.MODEL;
            k.d(str2, "MODEL");
            DisplayMetrics a4 = deviceUtils.a(str, str2);
            if (a4 == null) {
                throw new IllegalArgumentException("DeviceUtils rear display metrics entry should not be null");
            }
            a3 = WindowMetricsCalculator.f7194a.a(a4);
        }
        WindowAreaCapability.Status a5 = WindowAreaAdapter.f6862a.a(i3);
        this.f6884d = a5;
        o(WindowAreaCapability.Operation.f6866c, a5, a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(ExtensionWindowAreaStatus extensionWindowAreaStatus) {
        this.f6885e = WindowAreaAdapter.f6862a.a(extensionWindowAreaStatus.getWindowAreaStatus());
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.f7194a;
        DisplayMetrics windowAreaDisplayMetrics = extensionWindowAreaStatus.getWindowAreaDisplayMetrics();
        k.d(windowAreaDisplayMetrics, "extensionWindowAreaStatus.windowAreaDisplayMetrics");
        o(WindowAreaCapability.Operation.f6867d, this.f6885e, companion.a(windowAreaDisplayMetrics));
    }

    private final void o(WindowAreaCapability.Operation operation, WindowAreaCapability.Status status, WindowMetrics windowMetrics) {
        WindowAreaInfo windowAreaInfo = (WindowAreaInfo) this.f6886f.get("WINDOW_AREA_REAR_DISPLAY");
        if (!k.a(status, WindowAreaCapability.Status.f6871d)) {
            if (windowAreaInfo == null) {
                windowAreaInfo = new WindowAreaInfo(windowMetrics, WindowAreaInfo.Type.f6917c, new Binder("WINDOW_AREA_REAR_DISPLAY"), this.f6881a);
            }
            windowAreaInfo.a().put(operation, new WindowAreaCapability(operation, status));
            windowAreaInfo.b(windowMetrics);
            this.f6886f.put("WINDOW_AREA_REAR_DISPLAY", windowAreaInfo);
            return;
        }
        if (windowAreaInfo != null) {
            if (j(windowAreaInfo)) {
                this.f6886f.remove("WINDOW_AREA_REAR_DISPLAY");
            } else {
                windowAreaInfo.a().put(operation, new WindowAreaCapability(operation, status));
            }
        }
    }

    public O2.c i() {
        return O2.e.a(new WindowAreaControllerImpl$windowAreaInfos$1(this, null));
    }
}
