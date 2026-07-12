package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3384a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList f3385b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private androidx.core.util.a f3386c;

    public g(boolean z3) {
        this.f3384a = z3;
    }

    void a(a aVar) {
        this.f3385b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f3384a;
    }

    public final void d() {
        Iterator it = this.f3385b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    void e(a aVar) {
        this.f3385b.remove(aVar);
    }

    public final void f(boolean z3) {
        this.f3384a = z3;
        androidx.core.util.a aVar = this.f3386c;
        if (aVar != null) {
            aVar.accept(Boolean.valueOf(z3));
        }
    }

    void g(androidx.core.util.a aVar) {
        this.f3386c = aVar;
    }
}
