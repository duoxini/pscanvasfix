package d1;

import a1.InterfaceC0223c;
import android.graphics.Matrix;
import android.graphics.PointF;
import d1.AbstractC0336a;
import i1.AbstractC0395b;
import java.util.Collections;
import n1.C0483b;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f11056a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f11057b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f11058c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f11059d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f11060e;

    /* renamed from: f, reason: collision with root package name */
    private AbstractC0336a f11061f;

    /* renamed from: g, reason: collision with root package name */
    private AbstractC0336a f11062g;

    /* renamed from: h, reason: collision with root package name */
    private AbstractC0336a f11063h;

    /* renamed from: i, reason: collision with root package name */
    private AbstractC0336a f11064i;

    /* renamed from: j, reason: collision with root package name */
    private AbstractC0336a f11065j;

    /* renamed from: k, reason: collision with root package name */
    private d f11066k;

    /* renamed from: l, reason: collision with root package name */
    private d f11067l;

    /* renamed from: m, reason: collision with root package name */
    private AbstractC0336a f11068m;

    /* renamed from: n, reason: collision with root package name */
    private AbstractC0336a f11069n;

    public p(g1.l lVar) {
        this.f11061f = lVar.c() == null ? null : lVar.c().a();
        this.f11062g = lVar.f() == null ? null : lVar.f().a();
        this.f11063h = lVar.h() == null ? null : lVar.h().a();
        this.f11064i = lVar.g() == null ? null : lVar.g().a();
        d dVar = lVar.i() == null ? null : (d) lVar.i().a();
        this.f11066k = dVar;
        if (dVar != null) {
            this.f11057b = new Matrix();
            this.f11058c = new Matrix();
            this.f11059d = new Matrix();
            this.f11060e = new float[9];
        } else {
            this.f11057b = null;
            this.f11058c = null;
            this.f11059d = null;
            this.f11060e = null;
        }
        this.f11067l = lVar.j() == null ? null : (d) lVar.j().a();
        if (lVar.e() != null) {
            this.f11065j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f11068m = lVar.k().a();
        } else {
            this.f11068m = null;
        }
        if (lVar.d() != null) {
            this.f11069n = lVar.d().a();
        } else {
            this.f11069n = null;
        }
    }

    private void d() {
        for (int i3 = 0; i3 < 9; i3++) {
            this.f11060e[i3] = 0.0f;
        }
    }

    public void a(AbstractC0395b abstractC0395b) {
        abstractC0395b.k(this.f11065j);
        abstractC0395b.k(this.f11068m);
        abstractC0395b.k(this.f11069n);
        abstractC0395b.k(this.f11061f);
        abstractC0395b.k(this.f11062g);
        abstractC0395b.k(this.f11063h);
        abstractC0395b.k(this.f11064i);
        abstractC0395b.k(this.f11066k);
        abstractC0395b.k(this.f11067l);
    }

    public void b(AbstractC0336a.b bVar) {
        AbstractC0336a abstractC0336a = this.f11065j;
        if (abstractC0336a != null) {
            abstractC0336a.a(bVar);
        }
        AbstractC0336a abstractC0336a2 = this.f11068m;
        if (abstractC0336a2 != null) {
            abstractC0336a2.a(bVar);
        }
        AbstractC0336a abstractC0336a3 = this.f11069n;
        if (abstractC0336a3 != null) {
            abstractC0336a3.a(bVar);
        }
        AbstractC0336a abstractC0336a4 = this.f11061f;
        if (abstractC0336a4 != null) {
            abstractC0336a4.a(bVar);
        }
        AbstractC0336a abstractC0336a5 = this.f11062g;
        if (abstractC0336a5 != null) {
            abstractC0336a5.a(bVar);
        }
        AbstractC0336a abstractC0336a6 = this.f11063h;
        if (abstractC0336a6 != null) {
            abstractC0336a6.a(bVar);
        }
        AbstractC0336a abstractC0336a7 = this.f11064i;
        if (abstractC0336a7 != null) {
            abstractC0336a7.a(bVar);
        }
        d dVar = this.f11066k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f11067l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public boolean c(Object obj, C0483b c0483b) {
        if (obj == InterfaceC0223c.f3198f) {
            AbstractC0336a abstractC0336a = this.f11061f;
            if (abstractC0336a == null) {
                this.f11061f = new q(c0483b, new PointF());
                return true;
            }
            abstractC0336a.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3199g) {
            AbstractC0336a abstractC0336a2 = this.f11062g;
            if (abstractC0336a2 == null) {
                this.f11062g = new q(c0483b, new PointF());
                return true;
            }
            abstractC0336a2.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3200h) {
            AbstractC0336a abstractC0336a3 = this.f11062g;
            if (abstractC0336a3 instanceof n) {
                ((n) abstractC0336a3).r(c0483b);
                return true;
            }
        }
        if (obj == InterfaceC0223c.f3201i) {
            AbstractC0336a abstractC0336a4 = this.f11062g;
            if (abstractC0336a4 instanceof n) {
                ((n) abstractC0336a4).s(c0483b);
                return true;
            }
        }
        if (obj == InterfaceC0223c.f3207o) {
            AbstractC0336a abstractC0336a5 = this.f11063h;
            if (abstractC0336a5 == null) {
                this.f11063h = new q(c0483b, new n1.d());
                return true;
            }
            abstractC0336a5.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3208p) {
            AbstractC0336a abstractC0336a6 = this.f11064i;
            if (abstractC0336a6 == null) {
                this.f11064i = new q(c0483b, Float.valueOf(0.0f));
                return true;
            }
            abstractC0336a6.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3195c) {
            AbstractC0336a abstractC0336a7 = this.f11065j;
            if (abstractC0336a7 == null) {
                this.f11065j = new q(c0483b, 100);
                return true;
            }
            abstractC0336a7.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3180C) {
            AbstractC0336a abstractC0336a8 = this.f11068m;
            if (abstractC0336a8 == null) {
                this.f11068m = new q(c0483b, Float.valueOf(100.0f));
                return true;
            }
            abstractC0336a8.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3181D) {
            AbstractC0336a abstractC0336a9 = this.f11069n;
            if (abstractC0336a9 == null) {
                this.f11069n = new q(c0483b, Float.valueOf(100.0f));
                return true;
            }
            abstractC0336a9.n(c0483b);
            return true;
        }
        if (obj == InterfaceC0223c.f3209q) {
            if (this.f11066k == null) {
                this.f11066k = new d(Collections.singletonList(new n1.c(Float.valueOf(0.0f))));
            }
            this.f11066k.n(c0483b);
            return true;
        }
        if (obj != InterfaceC0223c.f3210r) {
            return false;
        }
        if (this.f11067l == null) {
            this.f11067l = new d(Collections.singletonList(new n1.c(Float.valueOf(0.0f))));
        }
        this.f11067l.n(c0483b);
        return true;
    }

    public AbstractC0336a e() {
        return this.f11069n;
    }

    public Matrix f() {
        PointF pointF;
        PointF pointF2;
        this.f11056a.reset();
        AbstractC0336a abstractC0336a = this.f11062g;
        if (abstractC0336a != null && (pointF2 = (PointF) abstractC0336a.h()) != null) {
            float f3 = pointF2.x;
            if (f3 != 0.0f || pointF2.y != 0.0f) {
                this.f11056a.preTranslate(f3, pointF2.y);
            }
        }
        AbstractC0336a abstractC0336a2 = this.f11064i;
        if (abstractC0336a2 != null) {
            float floatValue = abstractC0336a2 instanceof q ? ((Float) abstractC0336a2.h()).floatValue() : ((d) abstractC0336a2).p();
            if (floatValue != 0.0f) {
                this.f11056a.preRotate(floatValue);
            }
        }
        if (this.f11066k != null) {
            float cos = this.f11067l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.p()) + 90.0f));
            float sin = this.f11067l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.p()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.p()));
            d();
            float[] fArr = this.f11060e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f4 = -sin;
            fArr[3] = f4;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f11057b.setValues(fArr);
            d();
            float[] fArr2 = this.f11060e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f11058c.setValues(fArr2);
            d();
            float[] fArr3 = this.f11060e;
            fArr3[0] = cos;
            fArr3[1] = f4;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f11059d.setValues(fArr3);
            this.f11058c.preConcat(this.f11057b);
            this.f11059d.preConcat(this.f11058c);
            this.f11056a.preConcat(this.f11059d);
        }
        AbstractC0336a abstractC0336a3 = this.f11063h;
        if (abstractC0336a3 != null) {
            n1.d dVar = (n1.d) abstractC0336a3.h();
            if (dVar.b() != 1.0f || dVar.c() != 1.0f) {
                this.f11056a.preScale(dVar.b(), dVar.c());
            }
        }
        AbstractC0336a abstractC0336a4 = this.f11061f;
        if (abstractC0336a4 != null && (pointF = (PointF) abstractC0336a4.h()) != null) {
            float f5 = pointF.x;
            if (f5 != 0.0f || pointF.y != 0.0f) {
                this.f11056a.preTranslate(-f5, -pointF.y);
            }
        }
        return this.f11056a;
    }

    public Matrix g(float f3) {
        AbstractC0336a abstractC0336a = this.f11062g;
        PointF pointF = abstractC0336a == null ? null : (PointF) abstractC0336a.h();
        AbstractC0336a abstractC0336a2 = this.f11063h;
        n1.d dVar = abstractC0336a2 == null ? null : (n1.d) abstractC0336a2.h();
        this.f11056a.reset();
        if (pointF != null) {
            this.f11056a.preTranslate(pointF.x * f3, pointF.y * f3);
        }
        if (dVar != null) {
            double d3 = f3;
            this.f11056a.preScale((float) Math.pow(dVar.b(), d3), (float) Math.pow(dVar.c(), d3));
        }
        AbstractC0336a abstractC0336a3 = this.f11064i;
        if (abstractC0336a3 != null) {
            float floatValue = ((Float) abstractC0336a3.h()).floatValue();
            AbstractC0336a abstractC0336a4 = this.f11061f;
            PointF pointF2 = abstractC0336a4 != null ? (PointF) abstractC0336a4.h() : null;
            this.f11056a.preRotate(floatValue * f3, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return this.f11056a;
    }

    public AbstractC0336a h() {
        return this.f11065j;
    }

    public AbstractC0336a i() {
        return this.f11068m;
    }

    public void j(float f3) {
        AbstractC0336a abstractC0336a = this.f11065j;
        if (abstractC0336a != null) {
            abstractC0336a.m(f3);
        }
        AbstractC0336a abstractC0336a2 = this.f11068m;
        if (abstractC0336a2 != null) {
            abstractC0336a2.m(f3);
        }
        AbstractC0336a abstractC0336a3 = this.f11069n;
        if (abstractC0336a3 != null) {
            abstractC0336a3.m(f3);
        }
        AbstractC0336a abstractC0336a4 = this.f11061f;
        if (abstractC0336a4 != null) {
            abstractC0336a4.m(f3);
        }
        AbstractC0336a abstractC0336a5 = this.f11062g;
        if (abstractC0336a5 != null) {
            abstractC0336a5.m(f3);
        }
        AbstractC0336a abstractC0336a6 = this.f11063h;
        if (abstractC0336a6 != null) {
            abstractC0336a6.m(f3);
        }
        AbstractC0336a abstractC0336a7 = this.f11064i;
        if (abstractC0336a7 != null) {
            abstractC0336a7.m(f3);
        }
        d dVar = this.f11066k;
        if (dVar != null) {
            dVar.m(f3);
        }
        d dVar2 = this.f11067l;
        if (dVar2 != null) {
            dVar2.m(f3);
        }
    }
}
