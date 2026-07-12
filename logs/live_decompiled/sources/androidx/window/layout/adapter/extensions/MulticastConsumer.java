package androidx.window.layout.adapter.extensions;

import D2.k;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import p2.q;

/* loaded from: classes.dex */
public final class MulticastConsumer implements androidx.core.util.a, Consumer<WindowLayoutInfo> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7216a;

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantLock f7217b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.window.layout.WindowLayoutInfo f7218c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f7219d;

    public MulticastConsumer(Context context) {
        k.e(context, "context");
        this.f7216a = context;
        this.f7217b = new ReentrantLock();
        this.f7219d = new LinkedHashSet();
    }

    @Override // androidx.core.util.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo windowLayoutInfo) {
        k.e(windowLayoutInfo, "value");
        ReentrantLock reentrantLock = this.f7217b;
        reentrantLock.lock();
        try {
            this.f7218c = ExtensionsWindowLayoutInfoAdapter.f7215a.b(this.f7216a, windowLayoutInfo);
            Iterator it = this.f7219d.iterator();
            while (it.hasNext()) {
                ((androidx.core.util.a) it.next()).accept(this.f7218c);
            }
            q qVar = q.f12810a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(androidx.core.util.a aVar) {
        k.e(aVar, "listener");
        ReentrantLock reentrantLock = this.f7217b;
        reentrantLock.lock();
        try {
            androidx.window.layout.WindowLayoutInfo windowLayoutInfo = this.f7218c;
            if (windowLayoutInfo != null) {
                aVar.accept(windowLayoutInfo);
            }
            this.f7219d.add(aVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f7219d.isEmpty();
    }

    public final void d(androidx.core.util.a aVar) {
        k.e(aVar, "listener");
        ReentrantLock reentrantLock = this.f7217b;
        reentrantLock.lock();
        try {
            this.f7219d.remove(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }
}
