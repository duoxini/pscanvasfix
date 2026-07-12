package androidx.window.layout.adapter.sidecar;

import D2.g;
import D2.k;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import p2.q;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {

    /* renamed from: f, reason: collision with root package name */
    public static final Companion f7233f = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final SidecarInterface f7234a;

    /* renamed from: b, reason: collision with root package name */
    private final SidecarAdapter f7235b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f7236c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f7237d;

    /* renamed from: e, reason: collision with root package name */
    private DistinctElementCallback f7238e;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            k.e(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.f6980j.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* renamed from: a, reason: collision with root package name */
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface f7239a;

        /* renamed from: b, reason: collision with root package name */
        private final ReentrantLock f7240b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakHashMap f7241c;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            k.e(extensionCallbackInterface, "callbackInterface");
            this.f7239a = extensionCallbackInterface;
            this.f7240b = new ReentrantLock();
            this.f7241c = new WeakHashMap();
        }

        @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void a(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            k.e(activity, "activity");
            k.e(windowLayoutInfo, "newLayout");
            ReentrantLock reentrantLock = this.f7240b;
            reentrantLock.lock();
            try {
                if (k.a(windowLayoutInfo, (WindowLayoutInfo) this.f7241c.get(activity))) {
                    return;
                }
                reentrantLock.unlock();
                this.f7239a.a(activity, windowLayoutInfo);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(Activity activity) {
            k.e(activity, "activity");
            ReentrantLock reentrantLock = this.f7240b;
            reentrantLock.lock();
            try {
                this.f7241c.put(activity, null);
                q qVar = q.f12810a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        private final SidecarCompat f7242e;

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference f7243f;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            k.e(sidecarCompat, "sidecarCompat");
            k.e(activity, "activity");
            this.f7242e = sidecarCompat;
            this.f7243f = new WeakReference(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            k.e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.f7243f.get();
            IBinder a3 = SidecarCompat.f7233f.a(activity);
            if (activity == null || a3 == null) {
                return;
            }
            this.f7242e.j(a3, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            k.e(view, "view");
        }
    }

    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            SidecarInterface h3;
            k.e(sidecarDeviceState, "newDeviceState");
            Collection<Activity> values = SidecarCompat.this.f7236c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : values) {
                IBinder a3 = SidecarCompat.f7233f.a(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (a3 != null && (h3 = sidecarCompat.h()) != null) {
                    sidecarWindowLayoutInfo = h3.getWindowLayoutInfo(a3);
                }
                DistinctElementCallback distinctElementCallback = sidecarCompat.f7238e;
                if (distinctElementCallback != null) {
                    distinctElementCallback.a(activity, sidecarCompat.f7235b.e(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            SidecarDeviceState sidecarDeviceState;
            k.e(iBinder, "windowToken");
            k.e(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f7236c.get(iBinder);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = SidecarCompat.this.f7235b;
            SidecarInterface h3 = SidecarCompat.this.h();
            if (h3 == null || (sidecarDeviceState = h3.getDeviceState()) == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo e3 = sidecarAdapter.e(sidecarWindowLayoutInfo, sidecarDeviceState);
            DistinctElementCallback distinctElementCallback = SidecarCompat.this.f7238e;
            if (distinctElementCallback != null) {
                distinctElementCallback.a(activity, e3);
            }
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        k.e(sidecarAdapter, "sidecarAdapter");
        this.f7234a = sidecarInterface;
        this.f7235b = sidecarAdapter;
        this.f7236c = new LinkedHashMap();
        this.f7237d = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k(final Activity activity) {
        if (this.f7237d.get(activity) == null && (activity instanceof androidx.core.content.b)) {
            androidx.core.util.a aVar = new androidx.core.util.a() { // from class: androidx.window.layout.adapter.sidecar.a
                @Override // androidx.core.util.a
                public final void accept(Object obj) {
                    SidecarCompat.l(SidecarCompat.this, activity, (Configuration) obj);
                }
            };
            this.f7237d.put(activity, aVar);
            ((androidx.core.content.b) activity).addOnConfigurationChangedListener(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SidecarCompat sidecarCompat, Activity activity, Configuration configuration) {
        k.e(sidecarCompat, "this$0");
        k.e(activity, "$activity");
        DistinctElementCallback distinctElementCallback = sidecarCompat.f7238e;
        if (distinctElementCallback != null) {
            distinctElementCallback.a(activity, sidecarCompat.i(activity));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(Activity activity) {
        androidx.core.util.a aVar = (androidx.core.util.a) this.f7237d.get(activity);
        if (aVar == null) {
            return;
        }
        if (activity instanceof androidx.core.content.b) {
            ((androidx.core.content.b) activity).removeOnConfigurationChangedListener(aVar);
        }
        this.f7237d.remove(activity);
    }

    @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void a(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        k.e(extensionCallbackInterface, "extensionCallback");
        this.f7238e = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.f7234a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f7235b, new TranslatingCallback()));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void b(Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(activity, "activity");
        IBinder a3 = f7233f.a(activity);
        if (a3 == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f7234a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(a3);
        }
        m(activity);
        DistinctElementCallback distinctElementCallback = this.f7238e;
        if (distinctElementCallback != null) {
            distinctElementCallback.b(activity);
        }
        boolean z3 = this.f7236c.size() == 1;
        this.f7236c.remove(a3);
        if (!z3 || (sidecarInterface = this.f7234a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void c(Activity activity) {
        k.e(activity, "activity");
        IBinder a3 = f7233f.a(activity);
        if (a3 != null) {
            j(a3, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    public final SidecarInterface h() {
        return this.f7234a;
    }

    public final WindowLayoutInfo i(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        k.e(activity, "activity");
        IBinder a3 = f7233f.a(activity);
        if (a3 == null) {
            return new WindowLayoutInfo(AbstractC0544n.j());
        }
        SidecarInterface sidecarInterface = this.f7234a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(a3) : null;
        SidecarAdapter sidecarAdapter = this.f7235b;
        SidecarInterface sidecarInterface2 = this.f7234a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void j(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(iBinder, "windowToken");
        k.e(activity, "activity");
        this.f7236c.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f7234a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.f7236c.size() == 1 && (sidecarInterface = this.f7234a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        DistinctElementCallback distinctElementCallback = this.f7238e;
        if (distinctElementCallback != null) {
            distinctElementCallback.a(activity, i(activity));
        }
        k(activity);
    }

    public boolean n() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f7234a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Class cls5 = Void.TYPE;
            if (!k.a(returnType, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f7234a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f7234a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f7234a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!k.a(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f7234a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!k.a(returnType3, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f7234a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!k.a(returnType4, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                k.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) invoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            k.d(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
                return true;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object invoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                k.c(invoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (k.a(arrayList, (List) invoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f7233f.b(context), new SidecarAdapter(null, 1, null));
        k.e(context, "context");
    }
}
