package androidx.window.layout.adapter.extensions;

import D2.k;
import D2.s;
import android.app.Activity;
import android.content.Context;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import p2.q;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class ExtensionWindowBackendApi1 implements WindowBackend {

    /* renamed from: a, reason: collision with root package name */
    private final WindowLayoutComponent f7205a;

    /* renamed from: b, reason: collision with root package name */
    private final ConsumerAdapter f7206b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantLock f7207c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f7208d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f7209e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f7210f;

    public ExtensionWindowBackendApi1(WindowLayoutComponent windowLayoutComponent, ConsumerAdapter consumerAdapter) {
        k.e(windowLayoutComponent, "component");
        k.e(consumerAdapter, "consumerAdapter");
        this.f7205a = windowLayoutComponent;
        this.f7206b = consumerAdapter;
        this.f7207c = new ReentrantLock();
        this.f7208d = new LinkedHashMap();
        this.f7209e = new LinkedHashMap();
        this.f7210f = new LinkedHashMap();
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(androidx.core.util.a aVar) {
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f7207c;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f7209e.get(aVar);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f7208d.get(context);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.d(aVar);
            this.f7209e.remove(aVar);
            if (multicastConsumer.c()) {
                this.f7208d.remove(context);
                ConsumerAdapter.Subscription subscription = (ConsumerAdapter.Subscription) this.f7210f.remove(multicastConsumer);
                if (subscription != null) {
                    subscription.a();
                }
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
        ReentrantLock reentrantLock = this.f7207c;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f7208d.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.b(aVar);
                this.f7209e.put(aVar, context);
                qVar = q.f12810a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.f7208d.put(context, multicastConsumer2);
                this.f7209e.put(aVar, context);
                multicastConsumer2.b(aVar);
                if (!(context instanceof Activity)) {
                    multicastConsumer2.accept(new WindowLayoutInfo(AbstractC0544n.j()));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f7210f.put(multicastConsumer2, this.f7206b.d(this.f7205a, s.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(multicastConsumer2)));
                }
            }
            q qVar2 = q.f12810a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
