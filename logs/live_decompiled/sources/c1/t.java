package c1;

import a1.InterfaceC0223c;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import d1.AbstractC0336a;
import d1.C0337b;
import h1.C0389r;
import i1.AbstractC0395b;
import n1.C0483b;

/* loaded from: classes.dex */
public class t extends AbstractC0298a {

    /* renamed from: r, reason: collision with root package name */
    private final AbstractC0395b f7424r;

    /* renamed from: s, reason: collision with root package name */
    private final String f7425s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f7426t;

    /* renamed from: u, reason: collision with root package name */
    private final AbstractC0336a f7427u;

    /* renamed from: v, reason: collision with root package name */
    private AbstractC0336a f7428v;

    public t(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0389r c0389r) {
        super(nVar, abstractC0395b, c0389r.b().a(), c0389r.e().a(), c0389r.g(), c0389r.i(), c0389r.j(), c0389r.f(), c0389r.d());
        this.f7424r = abstractC0395b;
        this.f7425s = c0389r.h();
        this.f7426t = c0389r.k();
        AbstractC0336a a3 = c0389r.c().a();
        this.f7427u = a3;
        a3.a(this);
        abstractC0395b.k(a3);
    }

    @Override // c1.AbstractC0298a, f1.g
    public void h(Object obj, C0483b c0483b) {
        super.h(obj, c0483b);
        if (obj == InterfaceC0223c.f3194b) {
            this.f7427u.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3188K) {
            AbstractC0336a abstractC0336a = this.f7428v;
            if (abstractC0336a != null) {
                this.f7424r.I(abstractC0336a);
            }
            if (c0483b == null) {
                this.f7428v = null;
                return;
            }
            d1.q qVar = new d1.q(c0483b);
            this.f7428v = qVar;
            qVar.a(this);
            this.f7424r.k(this.f7427u);
        }
    }

    @Override // c1.AbstractC0298a, c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f7426t) {
            return;
        }
        this.f7293i.setColor(((C0337b) this.f7427u).p());
        AbstractC0336a abstractC0336a = this.f7428v;
        if (abstractC0336a != null) {
            this.f7293i.setColorFilter((ColorFilter) abstractC0336a.h());
        }
        super.i(canvas, matrix, i3);
    }

    @Override // c1.c
    public String j() {
        return this.f7425s;
    }
}
