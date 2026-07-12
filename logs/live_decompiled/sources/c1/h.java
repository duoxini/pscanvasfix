package c1;

import a1.C0221a;
import a1.InterfaceC0223c;
import a1.v;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import b1.C0292a;
import d1.AbstractC0336a;
import f1.C0358f;
import h1.C0375d;
import h1.C0376e;
import h1.EnumC0378g;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;
import m.C0454d;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class h implements e, AbstractC0336a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final String f7337a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7338b;

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC0395b f7339c;

    /* renamed from: d, reason: collision with root package name */
    private final C0454d f7340d = new C0454d();

    /* renamed from: e, reason: collision with root package name */
    private final C0454d f7341e = new C0454d();

    /* renamed from: f, reason: collision with root package name */
    private final Path f7342f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f7343g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f7344h;

    /* renamed from: i, reason: collision with root package name */
    private final List f7345i;

    /* renamed from: j, reason: collision with root package name */
    private final EnumC0378g f7346j;

    /* renamed from: k, reason: collision with root package name */
    private final AbstractC0336a f7347k;

    /* renamed from: l, reason: collision with root package name */
    private final AbstractC0336a f7348l;

    /* renamed from: m, reason: collision with root package name */
    private final AbstractC0336a f7349m;

    /* renamed from: n, reason: collision with root package name */
    private final AbstractC0336a f7350n;

    /* renamed from: o, reason: collision with root package name */
    private AbstractC0336a f7351o;

    /* renamed from: p, reason: collision with root package name */
    private d1.q f7352p;

    /* renamed from: q, reason: collision with root package name */
    private final com.oplus.anim.n f7353q;

    /* renamed from: r, reason: collision with root package name */
    private final int f7354r;

    /* renamed from: s, reason: collision with root package name */
    private AbstractC0336a f7355s;

    /* renamed from: t, reason: collision with root package name */
    float f7356t;

    /* renamed from: u, reason: collision with root package name */
    private d1.c f7357u;

    public h(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b, C0376e c0376e) {
        Path path = new Path();
        this.f7342f = path;
        this.f7343g = new C0292a(1);
        this.f7344h = new RectF();
        this.f7345i = new ArrayList();
        this.f7356t = 0.0f;
        this.f7339c = abstractC0395b;
        this.f7337a = c0376e.f();
        this.f7338b = c0376e.i();
        this.f7353q = nVar;
        this.f7346j = c0376e.e();
        path.setFillType(c0376e.c());
        this.f7354r = (int) (c0221a.d() / 32.0f);
        AbstractC0336a a3 = c0376e.d().a();
        this.f7347k = a3;
        a3.a(this);
        abstractC0395b.k(a3);
        AbstractC0336a a4 = c0376e.g().a();
        this.f7348l = a4;
        a4.a(this);
        abstractC0395b.k(a4);
        AbstractC0336a a5 = c0376e.h().a();
        this.f7349m = a5;
        a5.a(this);
        abstractC0395b.k(a5);
        AbstractC0336a a6 = c0376e.b().a();
        this.f7350n = a6;
        a6.a(this);
        abstractC0395b.k(a6);
        if (abstractC0395b.x() != null) {
            AbstractC0336a a7 = abstractC0395b.x().a().a();
            this.f7355s = a7;
            a7.a(this);
            abstractC0395b.k(this.f7355s);
        }
        if (abstractC0395b.z() != null) {
            this.f7357u = new d1.c(this, abstractC0395b, abstractC0395b.z());
        }
    }

    private int[] g(int[] iArr) {
        d1.q qVar = this.f7352p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i3 = 0;
            if (iArr.length == numArr.length) {
                while (i3 < iArr.length) {
                    iArr[i3] = numArr[i3].intValue();
                    i3++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i3 < numArr.length) {
                    iArr[i3] = numArr[i3].intValue();
                    i3++;
                }
            }
        }
        return iArr;
    }

    private int k() {
        int round = Math.round(this.f7349m.f() * this.f7354r);
        int round2 = Math.round(this.f7350n.f() * this.f7354r);
        int round3 = Math.round(this.f7347k.f() * this.f7354r);
        int i3 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i3 = i3 * 31 * round2;
        }
        return round3 != 0 ? i3 * 31 * round3 : i3;
    }

    private LinearGradient l() {
        long k3 = k();
        LinearGradient linearGradient = (LinearGradient) this.f7340d.e(k3);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f7349m.h();
        PointF pointF2 = (PointF) this.f7350n.h();
        C0375d c0375d = (C0375d) this.f7347k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, g(c0375d.c()), c0375d.d(), Shader.TileMode.CLAMP);
        this.f7340d.i(k3, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient m() {
        long k3 = k();
        RadialGradient radialGradient = (RadialGradient) this.f7341e.e(k3);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f7349m.h();
        PointF pointF2 = (PointF) this.f7350n.h();
        C0375d c0375d = (C0375d) this.f7347k.h();
        int[] g3 = g(c0375d.c());
        float[] d3 = c0375d.d();
        float f3 = pointF.x;
        float f4 = pointF.y;
        float hypot = (float) Math.hypot(pointF2.x - f3, pointF2.y - f4);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f3, f4, hypot, g3, d3, Shader.TileMode.CLAMP);
        this.f7341e.i(k3, radialGradient2);
        return radialGradient2;
    }

    @Override // c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        this.f7342f.reset();
        for (int i3 = 0; i3 < this.f7345i.size(); i3++) {
            this.f7342f.addPath(((m) this.f7345i.get(i3)).d(), matrix);
        }
        this.f7342f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f7353q.invalidateSelf();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        for (int i3 = 0; i3 < list2.size(); i3++) {
            c cVar = (c) list2.get(i3);
            if (cVar instanceof m) {
                this.f7345i.add((m) cVar);
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
        if (obj == InterfaceC0223c.f3196d) {
            this.f7348l.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3188K) {
            AbstractC0336a abstractC0336a = this.f7351o;
            if (abstractC0336a != null) {
                this.f7339c.I(abstractC0336a);
            }
            if (c0483b == null) {
                this.f7351o = null;
                return;
            }
            d1.q qVar = new d1.q(c0483b);
            this.f7351o = qVar;
            qVar.a(this);
            this.f7339c.k(this.f7351o);
            return;
        }
        if (obj == InterfaceC0223c.f3189L) {
            d1.q qVar2 = this.f7352p;
            if (qVar2 != null) {
                this.f7339c.I(qVar2);
            }
            if (c0483b == null) {
                this.f7352p = null;
                return;
            }
            this.f7340d.a();
            this.f7341e.a();
            d1.q qVar3 = new d1.q(c0483b);
            this.f7352p = qVar3;
            qVar3.a(this);
            this.f7339c.k(this.f7352p);
            return;
        }
        if (obj == InterfaceC0223c.f3202j) {
            AbstractC0336a abstractC0336a2 = this.f7355s;
            if (abstractC0336a2 != null) {
                abstractC0336a2.n(c0483b);
                return;
            }
            d1.q qVar4 = new d1.q(c0483b);
            this.f7355s = qVar4;
            qVar4.a(this);
            this.f7339c.k(this.f7355s);
            return;
        }
        if (obj == InterfaceC0223c.f3197e && (cVar5 = this.f7357u) != null) {
            cVar5.b(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3184G && (cVar4 = this.f7357u) != null) {
            cVar4.f(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3185H && (cVar3 = this.f7357u) != null) {
            cVar3.c(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3186I && (cVar2 = this.f7357u) != null) {
            cVar2.d(c0483b);
        } else {
            if (obj != InterfaceC0223c.f3187J || (cVar = this.f7357u) == null) {
                return;
            }
            cVar.g(c0483b);
        }
    }

    @Override // c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f7338b) {
            return;
        }
        v.a("GradientFillContent#draw");
        this.f7342f.reset();
        for (int i4 = 0; i4 < this.f7345i.size(); i4++) {
            this.f7342f.addPath(((m) this.f7345i.get(i4)).d(), matrix);
        }
        this.f7342f.computeBounds(this.f7344h, false);
        Shader l3 = this.f7346j == EnumC0378g.LINEAR ? l() : m();
        l3.setLocalMatrix(matrix);
        this.f7343g.setShader(l3);
        AbstractC0336a abstractC0336a = this.f7351o;
        if (abstractC0336a != null) {
            this.f7343g.setColorFilter((ColorFilter) abstractC0336a.h());
        }
        AbstractC0336a abstractC0336a2 = this.f7355s;
        if (abstractC0336a2 != null) {
            float floatValue = ((Float) abstractC0336a2.h()).floatValue();
            if (floatValue == 0.0f) {
                this.f7343g.setMaskFilter(null);
            } else if (floatValue != this.f7356t) {
                this.f7343g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f7356t = floatValue;
        }
        d1.c cVar = this.f7357u;
        if (cVar != null) {
            cVar.a(this.f7343g);
        }
        this.f7343g.setAlpha(AbstractC0464g.c((int) ((((i3 / 255.0f) * ((Integer) this.f7348l.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f7342f, this.f7343g);
        v.b("GradientFillContent#draw");
    }

    @Override // c1.c
    public String j() {
        return this.f7337a;
    }
}
