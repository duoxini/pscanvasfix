package c1;

import a1.InterfaceC0223c;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import d1.AbstractC0336a;
import h1.C0375d;
import h1.C0377f;
import h1.EnumC0378g;
import i1.AbstractC0395b;
import m.C0454d;
import n1.C0483b;

/* loaded from: classes.dex */
public class i extends AbstractC0298a {

    /* renamed from: A, reason: collision with root package name */
    private final AbstractC0336a f7358A;

    /* renamed from: B, reason: collision with root package name */
    private d1.q f7359B;

    /* renamed from: r, reason: collision with root package name */
    private final String f7360r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f7361s;

    /* renamed from: t, reason: collision with root package name */
    private final C0454d f7362t;

    /* renamed from: u, reason: collision with root package name */
    private final C0454d f7363u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f7364v;

    /* renamed from: w, reason: collision with root package name */
    private final EnumC0378g f7365w;

    /* renamed from: x, reason: collision with root package name */
    private final int f7366x;

    /* renamed from: y, reason: collision with root package name */
    private final AbstractC0336a f7367y;

    /* renamed from: z, reason: collision with root package name */
    private final AbstractC0336a f7368z;

    public i(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0377f c0377f) {
        super(nVar, abstractC0395b, c0377f.b().a(), c0377f.g().a(), c0377f.i(), c0377f.k(), c0377f.m(), c0377f.h(), c0377f.c());
        this.f7362t = new C0454d();
        this.f7363u = new C0454d();
        this.f7364v = new RectF();
        this.f7360r = c0377f.j();
        this.f7365w = c0377f.f();
        this.f7361s = c0377f.n();
        this.f7366x = (int) (nVar.G().d() / 32.0f);
        AbstractC0336a a3 = c0377f.e().a();
        this.f7367y = a3;
        a3.a(this);
        abstractC0395b.k(a3);
        AbstractC0336a a4 = c0377f.l().a();
        this.f7368z = a4;
        a4.a(this);
        abstractC0395b.k(a4);
        AbstractC0336a a5 = c0377f.d().a();
        this.f7358A = a5;
        a5.a(this);
        abstractC0395b.k(a5);
    }

    private int[] l(int[] iArr) {
        d1.q qVar = this.f7359B;
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

    private int m() {
        int round = Math.round(this.f7368z.f() * this.f7366x);
        int round2 = Math.round(this.f7358A.f() * this.f7366x);
        int round3 = Math.round(this.f7367y.f() * this.f7366x);
        int i3 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i3 = i3 * 31 * round2;
        }
        return round3 != 0 ? i3 * 31 * round3 : i3;
    }

    private LinearGradient n() {
        long m3 = m();
        LinearGradient linearGradient = (LinearGradient) this.f7362t.e(m3);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f7368z.h();
        PointF pointF2 = (PointF) this.f7358A.h();
        C0375d c0375d = (C0375d) this.f7367y.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, l(c0375d.c()), c0375d.d(), Shader.TileMode.CLAMP);
        this.f7362t.i(m3, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient o() {
        long m3 = m();
        RadialGradient radialGradient = (RadialGradient) this.f7363u.e(m3);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f7368z.h();
        PointF pointF2 = (PointF) this.f7358A.h();
        C0375d c0375d = (C0375d) this.f7367y.h();
        int[] l3 = l(c0375d.c());
        float[] d3 = c0375d.d();
        RadialGradient radialGradient2 = new RadialGradient(pointF.x, pointF.y, (float) Math.hypot(pointF2.x - r7, pointF2.y - r8), l3, d3, Shader.TileMode.CLAMP);
        this.f7363u.i(m3, radialGradient2);
        return radialGradient2;
    }

    @Override // c1.AbstractC0298a, f1.g
    public void h(Object obj, C0483b c0483b) {
        super.h(obj, c0483b);
        if (obj == InterfaceC0223c.f3189L) {
            d1.q qVar = this.f7359B;
            if (qVar != null) {
                this.f7290f.I(qVar);
            }
            if (c0483b == null) {
                this.f7359B = null;
                return;
            }
            d1.q qVar2 = new d1.q(c0483b);
            this.f7359B = qVar2;
            qVar2.a(this);
            this.f7290f.k(this.f7359B);
        }
    }

    @Override // c1.AbstractC0298a, c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f7361s) {
            return;
        }
        a(this.f7364v, matrix, false);
        Shader n3 = this.f7365w == EnumC0378g.LINEAR ? n() : o();
        n3.setLocalMatrix(matrix);
        this.f7293i.setShader(n3);
        super.i(canvas, matrix, i3);
    }

    @Override // c1.c
    public String j() {
        return this.f7360r;
    }
}
