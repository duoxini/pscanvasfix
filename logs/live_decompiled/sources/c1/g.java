package c1;

import a1.InterfaceC0223c;
import a1.v;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import b1.C0292a;
import d1.AbstractC0336a;
import d1.C0337b;
import f1.C0358f;
import h1.C0386o;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class g implements e, AbstractC0336a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Path f7324a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f7325b;

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC0395b f7326c;

    /* renamed from: d, reason: collision with root package name */
    private final String f7327d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f7328e;

    /* renamed from: f, reason: collision with root package name */
    private final List f7329f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0336a f7330g;

    /* renamed from: h, reason: collision with root package name */
    private final AbstractC0336a f7331h;

    /* renamed from: i, reason: collision with root package name */
    private AbstractC0336a f7332i;

    /* renamed from: j, reason: collision with root package name */
    private final com.oplus.anim.n f7333j;

    /* renamed from: k, reason: collision with root package name */
    private AbstractC0336a f7334k;

    /* renamed from: l, reason: collision with root package name */
    float f7335l;

    /* renamed from: m, reason: collision with root package name */
    private d1.c f7336m;

    public g(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0386o c0386o) {
        Path path = new Path();
        this.f7324a = path;
        this.f7325b = new C0292a(1);
        this.f7329f = new ArrayList();
        this.f7326c = abstractC0395b;
        this.f7327d = c0386o.d();
        this.f7328e = c0386o.f();
        this.f7333j = nVar;
        if (abstractC0395b.x() != null) {
            AbstractC0336a a3 = abstractC0395b.x().a().a();
            this.f7334k = a3;
            a3.a(this);
            abstractC0395b.k(this.f7334k);
        }
        if (abstractC0395b.z() != null) {
            this.f7336m = new d1.c(this, abstractC0395b, abstractC0395b.z());
        }
        if (c0386o.b() == null || c0386o.e() == null) {
            this.f7330g = null;
            this.f7331h = null;
            return;
        }
        path.setFillType(c0386o.c());
        AbstractC0336a a4 = c0386o.b().a();
        this.f7330g = a4;
        a4.a(this);
        abstractC0395b.k(a4);
        AbstractC0336a a5 = c0386o.e().a();
        this.f7331h = a5;
        a5.a(this);
        abstractC0395b.k(a5);
    }

    @Override // c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        this.f7324a.reset();
        for (int i3 = 0; i3 < this.f7329f.size(); i3++) {
            this.f7324a.addPath(((m) this.f7329f.get(i3)).d(), matrix);
        }
        this.f7324a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f7333j.invalidateSelf();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        for (int i3 = 0; i3 < list2.size(); i3++) {
            c cVar = (c) list2.get(i3);
            if (cVar instanceof m) {
                this.f7329f.add((m) cVar);
            }
        }
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        d1.c cVar;
        d1.c cVar2;
        d1.c cVar3;
        d1.c cVar4;
        d1.c cVar5;
        if (obj == InterfaceC0223c.f3193a) {
            this.f7330g.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3196d) {
            this.f7331h.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3188K) {
            AbstractC0336a abstractC0336a = this.f7332i;
            if (abstractC0336a != null) {
                this.f7326c.I(abstractC0336a);
            }
            if (c0483b == null) {
                this.f7332i = null;
                return;
            }
            d1.q qVar = new d1.q(c0483b);
            this.f7332i = qVar;
            qVar.a(this);
            this.f7326c.k(this.f7332i);
            return;
        }
        if (obj == InterfaceC0223c.f3202j) {
            AbstractC0336a abstractC0336a2 = this.f7334k;
            if (abstractC0336a2 != null) {
                abstractC0336a2.n(c0483b);
                return;
            }
            d1.q qVar2 = new d1.q(c0483b);
            this.f7334k = qVar2;
            qVar2.a(this);
            this.f7326c.k(this.f7334k);
            return;
        }
        if (obj == InterfaceC0223c.f3197e && (cVar5 = this.f7336m) != null) {
            cVar5.b(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3184G && (cVar4 = this.f7336m) != null) {
            cVar4.f(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3185H && (cVar3 = this.f7336m) != null) {
            cVar3.c(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3186I && (cVar2 = this.f7336m) != null) {
            cVar2.d(c0483b);
        } else {
            if (obj != InterfaceC0223c.f3187J || (cVar = this.f7336m) == null) {
                return;
            }
            cVar.g(c0483b);
        }
    }

    @Override // c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f7328e) {
            return;
        }
        v.a("FillContent#draw");
        this.f7325b.setColor((AbstractC0464g.c((int) ((((i3 / 255.0f) * ((Integer) this.f7331h.h()).intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((C0337b) this.f7330g).p() & 16777215));
        AbstractC0336a abstractC0336a = this.f7332i;
        if (abstractC0336a != null) {
            this.f7325b.setColorFilter((ColorFilter) abstractC0336a.h());
        }
        AbstractC0336a abstractC0336a2 = this.f7334k;
        if (abstractC0336a2 != null) {
            float floatValue = ((Float) abstractC0336a2.h()).floatValue();
            if (floatValue == 0.0f) {
                this.f7325b.setMaskFilter(null);
            } else if (floatValue != this.f7335l) {
                this.f7325b.setMaskFilter(this.f7326c.y(floatValue));
            }
            this.f7335l = floatValue;
        }
        d1.c cVar = this.f7336m;
        if (cVar != null) {
            cVar.a(this.f7325b);
        }
        this.f7324a.reset();
        for (int i4 = 0; i4 < this.f7329f.size(); i4++) {
            this.f7324a.addPath(((m) this.f7329f.get(i4)).d(), matrix);
        }
        canvas.drawPath(this.f7324a, this.f7325b);
        v.b("FillContent#draw");
    }

    @Override // c1.c
    public String j() {
        return this.f7327d;
    }
}
