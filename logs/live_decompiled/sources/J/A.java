package J;

import java.util.concurrent.atomic.AtomicBoolean;
import p2.AbstractC0506f;
import p2.InterfaceC0505e;

/* loaded from: classes.dex */
public abstract class A {

    /* renamed from: a, reason: collision with root package name */
    private final u f931a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f932b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0505e f933c;

    static final class a extends D2.l implements C2.a {
        a() {
            super(0);
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final N.k invoke() {
            return A.this.d();
        }
    }

    public A(u uVar) {
        D2.k.e(uVar, "database");
        this.f931a = uVar;
        this.f932b = new AtomicBoolean(false);
        this.f933c = AbstractC0506f.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final N.k d() {
        return this.f931a.f(e());
    }

    private final N.k f() {
        return (N.k) this.f933c.getValue();
    }

    private final N.k g(boolean z3) {
        return z3 ? f() : d();
    }

    public N.k b() {
        c();
        return g(this.f932b.compareAndSet(false, true));
    }

    protected void c() {
        this.f931a.c();
    }

    protected abstract String e();

    public void h(N.k kVar) {
        D2.k.e(kVar, "statement");
        if (kVar == f()) {
            this.f932b.set(false);
        }
    }
}
