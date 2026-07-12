package androidx.window.layout.adapter.sidecar;

import D2.g;
import D2.k;
import android.app.Activity;
import android.content.Context;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import p2.q;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class SidecarWindowBackend implements WindowBackend {

    /* renamed from: d, reason: collision with root package name */
    private static volatile SidecarWindowBackend f7246d;

    /* renamed from: a, reason: collision with root package name */
    private ExtensionInterfaceCompat f7248a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f7249b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f7245c = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final ReentrantLock f7247e = new ReentrantLock();

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final SidecarWindowBackend a(Context context) {
            k.e(context, "context");
            if (SidecarWindowBackend.f7246d == null) {
                ReentrantLock reentrantLock = SidecarWindowBackend.f7247e;
                reentrantLock.lock();
                try {
                    if (SidecarWindowBackend.f7246d == null) {
                        SidecarWindowBackend.f7246d = new SidecarWindowBackend(SidecarWindowBackend.f7245c.b(context));
                    }
                    q qVar = q.f12810a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            SidecarWindowBackend sidecarWindowBackend = SidecarWindowBackend.f7246d;
            k.b(sidecarWindowBackend);
            return sidecarWindowBackend;
        }

        public final ExtensionInterfaceCompat b(Context context) {
            k.e(context, "context");
            try {
                if (!c(SidecarCompat.f7233f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.n()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(Version version) {
            return version != null && version.compareTo(Version.f6980j.a()) >= 0;
        }

        private Companion() {
        }
    }

    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        public ExtensionListenerImpl() {
        }

        @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void a(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            k.e(activity, "activity");
            k.e(windowLayoutInfo, "newLayout");
            Iterator it = SidecarWindowBackend.this.g().iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = (WindowLayoutChangeCallbackWrapper) it.next();
                if (k.a(windowLayoutChangeCallbackWrapper.d(), activity)) {
                    windowLayoutChangeCallbackWrapper.b(windowLayoutInfo);
                }
            }
        }
    }

    public static final class WindowLayoutChangeCallbackWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f7251a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f7252b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.core.util.a f7253c;

        /* renamed from: d, reason: collision with root package name */
        private WindowLayoutInfo f7254d;

        public WindowLayoutChangeCallbackWrapper(Activity activity, Executor executor, androidx.core.util.a aVar) {
            k.e(activity, "activity");
            k.e(executor, "executor");
            k.e(aVar, "callback");
            this.f7251a = activity;
            this.f7252b = executor;
            this.f7253c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            k.e(windowLayoutChangeCallbackWrapper, "this$0");
            k.e(windowLayoutInfo, "$newLayoutInfo");
            windowLayoutChangeCallbackWrapper.f7253c.accept(windowLayoutInfo);
        }

        public final void b(final WindowLayoutInfo windowLayoutInfo) {
            k.e(windowLayoutInfo, "newLayoutInfo");
            this.f7254d = windowLayoutInfo;
            this.f7252b.execute(new Runnable() { // from class: androidx.window.layout.adapter.sidecar.b
                @Override // java.lang.Runnable
                public final void run() {
                    SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.c(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.this, windowLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f7251a;
        }

        public final androidx.core.util.a e() {
            return this.f7253c;
        }

        public final WindowLayoutInfo f() {
            return this.f7254d;
        }
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.f7248a = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.f7248a;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.a(new ExtensionListenerImpl());
        }
    }

    private final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7249b;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (k.a(((WindowLayoutChangeCallbackWrapper) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat = this.f7248a;
        if (extensionInterfaceCompat != null) {
            extensionInterfaceCompat.b(activity);
        }
    }

    private final boolean h(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7249b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (k.a(((WindowLayoutChangeCallbackWrapper) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(androidx.core.util.a aVar) {
        k.e(aVar, "callback");
        synchronized (f7247e) {
            try {
                if (this.f7248a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f7249b.iterator();
                while (it.hasNext()) {
                    WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = (WindowLayoutChangeCallbackWrapper) it.next();
                    if (windowLayoutChangeCallbackWrapper.e() == aVar) {
                        k.d(windowLayoutChangeCallbackWrapper, "callbackWrapper");
                        arrayList.add(windowLayoutChangeCallbackWrapper);
                    }
                }
                this.f7249b.removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f(((WindowLayoutChangeCallbackWrapper) it2.next()).d());
                }
                q qVar = q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, androidx.core.util.a aVar) {
        Object obj;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        q qVar = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ReentrantLock reentrantLock = f7247e;
            reentrantLock.lock();
            try {
                ExtensionInterfaceCompat extensionInterfaceCompat = this.f7248a;
                if (extensionInterfaceCompat == null) {
                    aVar.accept(new WindowLayoutInfo(AbstractC0544n.j()));
                    return;
                }
                boolean h3 = h(activity);
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, aVar);
                this.f7249b.add(windowLayoutChangeCallbackWrapper);
                if (h3) {
                    Iterator it = this.f7249b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (k.a(activity, ((WindowLayoutChangeCallbackWrapper) obj).d())) {
                                break;
                            }
                        }
                    }
                    WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) obj;
                    WindowLayoutInfo f3 = windowLayoutChangeCallbackWrapper2 != null ? windowLayoutChangeCallbackWrapper2.f() : null;
                    if (f3 != null) {
                        windowLayoutChangeCallbackWrapper.b(f3);
                    }
                } else {
                    extensionInterfaceCompat.c(activity);
                }
                q qVar2 = q.f12810a;
                reentrantLock.unlock();
                qVar = q.f12810a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (qVar == null) {
            aVar.accept(new WindowLayoutInfo(AbstractC0544n.j()));
        }
    }

    public final CopyOnWriteArrayList g() {
        return this.f7249b;
    }
}
