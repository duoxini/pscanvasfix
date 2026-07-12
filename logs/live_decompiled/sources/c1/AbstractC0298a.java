package c1;

import a1.InterfaceC0223c;
import a1.v;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import b1.C0292a;
import d1.AbstractC0336a;
import f1.C0358f;
import g1.C0366b;
import h1.s;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;
import m1.AbstractC0464g;
import m1.AbstractC0465h;
import n1.C0483b;

/* renamed from: c1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0298a implements AbstractC0336a.b, k, e {

    /* renamed from: e, reason: collision with root package name */
    private final com.oplus.anim.n f7289e;

    /* renamed from: f, reason: collision with root package name */
    protected final AbstractC0395b f7290f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f7292h;

    /* renamed from: i, reason: collision with root package name */
    final Paint f7293i;

    /* renamed from: j, reason: collision with root package name */
    private final AbstractC0336a f7294j;

    /* renamed from: k, reason: collision with root package name */
    private final AbstractC0336a f7295k;

    /* renamed from: l, reason: collision with root package name */
    private final List f7296l;

    /* renamed from: m, reason: collision with root package name */
    private final AbstractC0336a f7297m;

    /* renamed from: n, reason: collision with root package name */
    private AbstractC0336a f7298n;

    /* renamed from: o, reason: collision with root package name */
    private AbstractC0336a f7299o;

    /* renamed from: p, reason: collision with root package name */
    float f7300p;

    /* renamed from: q, reason: collision with root package name */
    private d1.c f7301q;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f7285a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f7286b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f7287c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f7288d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List f7291g = new ArrayList();

    /* renamed from: c1.a$b */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f7302a;

        /* renamed from: b, reason: collision with root package name */
        private final u f7303b;

        private b(u uVar) {
            this.f7302a = new ArrayList();
            this.f7303b = uVar;
        }
    }

    AbstractC0298a(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, Paint.Cap cap, Paint.Join join, float f3, g1.d dVar, C0366b c0366b, List list, C0366b c0366b2) {
        C0292a c0292a = new C0292a(1);
        this.f7293i = c0292a;
        this.f7300p = 0.0f;
        this.f7289e = nVar;
        this.f7290f = abstractC0395b;
        c0292a.setStyle(Paint.Style.STROKE);
        c0292a.setStrokeCap(cap);
        c0292a.setStrokeJoin(join);
        c0292a.setStrokeMiter(f3);
        this.f7295k = dVar.a();
        this.f7294j = c0366b.a();
        if (c0366b2 == null) {
            this.f7297m = null;
        } else {
            this.f7297m = c0366b2.a();
        }
        this.f7296l = new ArrayList(list.size());
        this.f7292h = new float[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f7296l.add(((C0366b) list.get(i3)).a());
        }
        abstractC0395b.k(this.f7295k);
        abstractC0395b.k(this.f7294j);
        for (int i4 = 0; i4 < this.f7296l.size(); i4++) {
            abstractC0395b.k((AbstractC0336a) this.f7296l.get(i4));
        }
        AbstractC0336a abstractC0336a = this.f7297m;
        if (abstractC0336a != null) {
            abstractC0395b.k(abstractC0336a);
        }
        this.f7295k.a(this);
        this.f7294j.a(this);
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((AbstractC0336a) this.f7296l.get(i5)).a(this);
        }
        AbstractC0336a abstractC0336a2 = this.f7297m;
        if (abstractC0336a2 != null) {
            abstractC0336a2.a(this);
        }
        if (abstractC0395b.x() != null) {
            AbstractC0336a a3 = abstractC0395b.x().a().a();
            this.f7299o = a3;
            a3.a(this);
            abstractC0395b.k(this.f7299o);
        }
        if (abstractC0395b.z() != null) {
            this.f7301q = new d1.c(this, abstractC0395b, abstractC0395b.z());
        }
    }

    private void g(Matrix matrix) {
        v.a("StrokeContent#applyDashPattern");
        if (this.f7296l.isEmpty()) {
            v.b("StrokeContent#applyDashPattern");
            return;
        }
        float h3 = AbstractC0465h.h(matrix);
        for (int i3 = 0; i3 < this.f7296l.size(); i3++) {
            this.f7292h[i3] = ((Float) ((AbstractC0336a) this.f7296l.get(i3)).h()).floatValue();
            if (i3 % 2 == 0) {
                float[] fArr = this.f7292h;
                if (fArr[i3] < 1.0f) {
                    fArr[i3] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f7292h;
                if (fArr2[i3] < 0.1f) {
                    fArr2[i3] = 0.1f;
                }
            }
            float[] fArr3 = this.f7292h;
            fArr3[i3] = fArr3[i3] * h3;
        }
        AbstractC0336a abstractC0336a = this.f7297m;
        this.f7293i.setPathEffect(new DashPathEffect(this.f7292h, abstractC0336a == null ? 0.0f : h3 * ((Float) abstractC0336a.h()).floatValue()));
        v.b("StrokeContent#applyDashPattern");
    }

    private void k(Canvas canvas, b bVar, Matrix matrix) {
        v.a("StrokeContent#applyTrimPath");
        if (bVar.f7303b == null) {
            v.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f7286b.reset();
        for (int size = bVar.f7302a.size() - 1; size >= 0; size--) {
            this.f7286b.addPath(((m) bVar.f7302a.get(size)).d(), matrix);
        }
        float floatValue = ((Float) bVar.f7303b.k().h()).floatValue() / 100.0f;
        float floatValue2 = ((Float) bVar.f7303b.g().h()).floatValue() / 100.0f;
        float floatValue3 = ((Float) bVar.f7303b.h().h()).floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f7286b, this.f7293i);
            v.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f7285a.setPath(this.f7286b, false);
        float length = this.f7285a.getLength();
        while (this.f7285a.nextContour()) {
            length += this.f7285a.getLength();
        }
        float f3 = floatValue3 * length;
        float f4 = (floatValue * length) + f3;
        float min = Math.min((floatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = bVar.f7302a.size() - 1; size2 >= 0; size2--) {
            this.f7287c.set(((m) bVar.f7302a.get(size2)).d());
            this.f7287c.transform(matrix);
            this.f7285a.setPath(this.f7287c, false);
            float length2 = this.f7285a.getLength();
            if (min > length) {
                float f6 = min - length;
                if (f6 < f5 + length2 && f5 < f6) {
                    AbstractC0465h.a(this.f7287c, f4 > length ? (f4 - length) / length2 : 0.0f, Math.min(f6 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f7287c, this.f7293i);
                    f5 += length2;
                }
            }
            float f7 = f5 + length2;
            if (f7 >= f4 && f5 <= min) {
                if (f7 > min || f4 >= f5) {
                    AbstractC0465h.a(this.f7287c, f4 < f5 ? 0.0f : (f4 - f5) / length2, min > f7 ? 1.0f : (min - f5) / length2, 0.0f);
                    canvas.drawPath(this.f7287c, this.f7293i);
                } else {
                    canvas.drawPath(this.f7287c, this.f7293i);
                }
            }
            f5 += length2;
        }
        v.b("StrokeContent#applyTrimPath");
    }

    @Override // c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        v.a("StrokeContent#getBounds");
        this.f7286b.reset();
        for (int i3 = 0; i3 < this.f7291g.size(); i3++) {
            b bVar = (b) this.f7291g.get(i3);
            for (int i4 = 0; i4 < bVar.f7302a.size(); i4++) {
                this.f7286b.addPath(((m) bVar.f7302a.get(i4)).d(), matrix);
            }
        }
        this.f7286b.computeBounds(this.f7288d, false);
        float p3 = ((d1.d) this.f7294j).p();
        RectF rectF2 = this.f7288d;
        float f3 = p3 / 2.0f;
        rectF2.set(rectF2.left - f3, rectF2.top - f3, rectF2.right + f3, rectF2.bottom + f3);
        rectF.set(this.f7288d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        v.b("StrokeContent#getBounds");
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f7289e.invalidateSelf();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.l() == s.a.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.b(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = (c) list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.l() == s.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f7291g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.b(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f7302a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f7291g.add(bVar);
        }
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        d1.c cVar;
        d1.c cVar2;
        d1.c cVar3;
        d1.c cVar4;
        d1.c cVar5;
        if (obj == InterfaceC0223c.f3196d) {
            this.f7295k.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3211s) {
            this.f7294j.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3188K) {
            AbstractC0336a abstractC0336a = this.f7298n;
            if (abstractC0336a != null) {
                this.f7290f.I(abstractC0336a);
            }
            if (c0483b == null) {
                this.f7298n = null;
                return;
            }
            d1.q qVar = new d1.q(c0483b);
            this.f7298n = qVar;
            qVar.a(this);
            this.f7290f.k(this.f7298n);
            return;
        }
        if (obj == InterfaceC0223c.f3202j) {
            AbstractC0336a abstractC0336a2 = this.f7299o;
            if (abstractC0336a2 != null) {
                abstractC0336a2.n(c0483b);
                return;
            }
            d1.q qVar2 = new d1.q(c0483b);
            this.f7299o = qVar2;
            qVar2.a(this);
            this.f7290f.k(this.f7299o);
            return;
        }
        if (obj == InterfaceC0223c.f3197e && (cVar5 = this.f7301q) != null) {
            cVar5.b(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3184G && (cVar4 = this.f7301q) != null) {
            cVar4.f(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3185H && (cVar3 = this.f7301q) != null) {
            cVar3.c(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3186I && (cVar2 = this.f7301q) != null) {
            cVar2.d(c0483b);
        } else {
            if (obj != InterfaceC0223c.f3187J || (cVar = this.f7301q) == null) {
                return;
            }
            cVar.g(c0483b);
        }
    }

    @Override // c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        v.a("StrokeContent#draw");
        if (AbstractC0465h.i(matrix)) {
            v.b("StrokeContent#draw");
            return;
        }
        this.f7293i.setAlpha(AbstractC0464g.c((int) ((((i3 / 255.0f) * ((d1.f) this.f7295k).p()) / 100.0f) * 255.0f), 0, 255));
        this.f7293i.setStrokeWidth(((d1.d) this.f7294j).p() * AbstractC0465h.h(matrix));
        if (this.f7293i.getStrokeWidth() <= 0.0f) {
            v.b("StrokeContent#draw");
            return;
        }
        g(matrix);
        AbstractC0336a abstractC0336a = this.f7298n;
        if (abstractC0336a != null) {
            this.f7293i.setColorFilter((ColorFilter) abstractC0336a.h());
        }
        AbstractC0336a abstractC0336a2 = this.f7299o;
        if (abstractC0336a2 != null) {
            float floatValue = ((Float) abstractC0336a2.h()).floatValue();
            if (floatValue == 0.0f) {
                this.f7293i.setMaskFilter(null);
            } else if (floatValue != this.f7300p) {
                this.f7293i.setMaskFilter(this.f7290f.y(floatValue));
            }
            this.f7300p = floatValue;
        }
        d1.c cVar = this.f7301q;
        if (cVar != null) {
            cVar.a(this.f7293i);
        }
        for (int i4 = 0; i4 < this.f7291g.size(); i4++) {
            b bVar = (b) this.f7291g.get(i4);
            if (bVar.f7303b != null) {
                k(canvas, bVar, matrix);
            } else {
                v.a("StrokeContent#buildPath");
                this.f7286b.reset();
                for (int size = bVar.f7302a.size() - 1; size >= 0; size--) {
                    this.f7286b.addPath(((m) bVar.f7302a.get(size)).d(), matrix);
                }
                v.b("StrokeContent#buildPath");
                v.a("StrokeContent#drawPath");
                canvas.drawPath(this.f7286b, this.f7293i);
                v.b("StrokeContent#drawPath");
            }
        }
        v.b("StrokeContent#draw");
    }
}
