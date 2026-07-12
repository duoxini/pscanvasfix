package c1;

import d1.AbstractC0336a;
import h1.s;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class u implements c, AbstractC0336a.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f7429a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7430b;

    /* renamed from: c, reason: collision with root package name */
    private final List f7431c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final s.a f7432d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0336a f7433e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0336a f7434f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0336a f7435g;

    public u(AbstractC0395b abstractC0395b, h1.s sVar) {
        this.f7429a = sVar.c();
        this.f7430b = sVar.g();
        this.f7432d = sVar.f();
        AbstractC0336a a3 = sVar.e().a();
        this.f7433e = a3;
        AbstractC0336a a4 = sVar.b().a();
        this.f7434f = a4;
        AbstractC0336a a5 = sVar.d().a();
        this.f7435g = a5;
        abstractC0395b.k(a3);
        abstractC0395b.k(a4);
        abstractC0395b.k(a5);
        a3.a(this);
        a4.a(this);
        a5.a(this);
    }

    void b(AbstractC0336a.b bVar) {
        this.f7431c.add(bVar);
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        for (int i3 = 0; i3 < this.f7431c.size(); i3++) {
            ((AbstractC0336a.b) this.f7431c.get(i3)).e();
        }
    }

    @Override // c1.c
    public void f(List list, List list2) {
    }

    public AbstractC0336a g() {
        return this.f7434f;
    }

    public AbstractC0336a h() {
        return this.f7435g;
    }

    public AbstractC0336a k() {
        return this.f7433e;
    }

    s.a l() {
        return this.f7432d;
    }

    public boolean m() {
        return this.f7430b;
    }
}
