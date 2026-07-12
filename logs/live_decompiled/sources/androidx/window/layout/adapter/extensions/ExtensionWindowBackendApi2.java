package androidx.window.layout.adapter.extensions;

import D2.k;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import p2.q;

/* loaded from: classes.dex */
public final class ExtensionWindowBackendApi2 implements WindowBackend {

    /* renamed from: a, reason: collision with root package name */
    private final WindowLayoutComponent f7211a;

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantLock f7212b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f7213c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f7214d;

    public ExtensionWindowBackendApi2(WindowLayoutComponent windowLayoutComponent) {
        k.e(windowLayoutComponent, "component");
        this.f7211a = windowLayoutComponent;
        this.f7212b = new ReentrantLock();
        this.f7213c = new LinkedHashMap();
        this.f7214d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(androidx.core.util.a aVar) {
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f7212b;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f7214d.get(aVar);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f7213c.get(context);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.d(aVar);
            this.f7214d.remove(aVar);
            if (multicastConsumer.c()) {
                this.f7213c.remove(context);
                this.f7211a.removeWindowLayoutInfoListener(multicastConsumer);
            }
            q qVar = q.f12810a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, androidx.core.util.a aVar) {
        q qVar;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f7212b;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f7213c.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.b(aVar);
                this.f7214d.put(aVar, context);
                qVar = q.f12810a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.f7213c.put(context, multicastConsumer2);
                this.f7214d.put(aVar, context);
                multicastConsumer2.b(aVar);
                this.f7211a.addWindowLayoutInfoListener(context, multicastConsumer2);
            }
            q qVar2 = q.f12810a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
