package c1;

import a1.InterfaceC0223c;
import android.graphics.Path;
import android.graphics.PointF;
import d1.AbstractC0336a;
import f1.C0358f;
import h1.C0381j;
import h1.s;
import i1.AbstractC0395b;
import java.util.List;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class n implements m, AbstractC0336a.b, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f7377b;

    /* renamed from: c, reason: collision with root package name */
    private final com.oplus.anim.n f7378c;

    /* renamed from: d, reason: collision with root package name */
    private final C0381j.a f7379d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f7380e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f7381f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0336a f7382g;

    /* renamed from: h, reason: collision with root package name */
    private final AbstractC0336a f7383h;

    /* renamed from: i, reason: collision with root package name */
    private final AbstractC0336a f7384i;

    /* renamed from: j, reason: collision with root package name */
    private final AbstractC0336a f7385j;

    /* renamed from: k, reason: collision with root package name */
    private final AbstractC0336a f7386k;

    /* renamed from: l, reason: collision with root package name */
    private final AbstractC0336a f7387l;

    /* renamed from: m, reason: collision with root package name */
    private final AbstractC0336a f7388m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7390o;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7376a = new Path();

    /* renamed from: n, reason: collision with root package name */
    private final b f7389n = new b();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7391a;

        static {
            int[] iArr = new int[C0381j.a.values().length];
            f7391a = iArr;
            try {
                iArr[C0381j.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7391a[C0381j.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0381j c0381j) {
        this.f7378c = nVar;
        this.f7377b = c0381j.d();
        C0381j.a j3 = c0381j.j();
        this.f7379d = j3;
        this.f7380e = c0381j.k();
        this.f7381f = c0381j.l();
        AbstractC0336a a3 = c0381j.g().a();
        this.f7382g = a3;
        AbstractC0336a a4 = c0381j.h().a();
        this.f7383h = a4;
        AbstractC0336a a5 = c0381j.i().a();
        this.f7384i = a5;
        AbstractC0336a a6 = c0381j.e().a();
        this.f7386k = a6;
        AbstractC0336a a7 = c0381j.f().a();
        this.f7388m = a7;
        C0381j.a aVar = C0381j.a.STAR;
        if (j3 == aVar) {
            this.f7385j = c0381j.b().a();
            this.f7387l = c0381j.c().a();
        } else {
            this.f7385j = null;
            this.f7387l = null;
        }
        abstractC0395b.k(a3);
        abstractC0395b.k(a4);
        abstractC0395b.k(a5);
        abstractC0395b.k(a6);
        abstractC0395b.k(a7);
        if (j3 == aVar) {
            abstractC0395b.k(this.f7385j);
            abstractC0395b.k(this.f7387l);
        }
        a3.a(this);
        a4.a(this);
        a5.a(this);
        a6.a(this);
        a7.a(this);
        if (j3 == aVar) {
            this.f7385j.a(this);
            this.f7387l.a(this);
        }
    }

    private void g() {
        int i3;
        double d3;
        double d4;
        double d5;
        int floor = (int) Math.floor(((Float) this.f7382g.h()).floatValue());
        double radians = Math.toRadians((this.f7384i == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d6 = floor;
        float floatValue = ((Float) this.f7388m.h()).floatValue() / 100.0f;
        float floatValue2 = ((Float) this.f7386k.h()).floatValue();
        double d7 = floatValue2;
        float cos = (float) (Math.cos(radians) * d7);
        float sin = (float) (Math.sin(radians) * d7);
        this.f7376a.moveTo(cos, sin);
        double d8 = (float) (6.283185307179586d / d6);
        double d9 = radians + d8;
        double ceil = Math.ceil(d6);
        int i4 = 0;
        while (i4 < ceil) {
            float cos2 = (float) (Math.cos(d9) * d7);
            double d10 = ceil;
            float sin2 = (float) (d7 * Math.sin(d9));
            if (floatValue != 0.0f) {
                d4 = d7;
                i3 = i4;
                d3 = d9;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d5 = d8;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f3 = floatValue2 * floatValue * 0.25f;
                this.f7376a.cubicTo(cos - (cos3 * f3), sin - (sin3 * f3), cos2 + (((float) Math.cos(atan22)) * f3), sin2 + (f3 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i3 = i4;
                d3 = d9;
                d4 = d7;
                d5 = d8;
                this.f7376a.lineTo(cos2, sin2);
            }
            d9 = d3 + d5;
            i4 = i3 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d10;
            d7 = d4;
            d8 = d5;
        }
        PointF pointF = (PointF) this.f7383h.h();
        this.f7376a.offset(pointF.x, pointF.y);
        this.f7376a.close();
    }

    private void k() {
        int i3;
        float f3;
        float f4;
        double d3;
        float f5;
        float f6;
        float f7;
        float f8;
        double d4;
        float f9;
        float f10;
        float f11;
        double d5;
        float floatValue = ((Float) this.f7382g.h()).floatValue();
        double radians = Math.toRadians((this.f7384i == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d6 = floatValue;
        float f12 = (float) (6.283185307179586d / d6);
        if (this.f7381f) {
            f12 *= -1.0f;
        }
        float f13 = f12 / 2.0f;
        float f14 = floatValue - ((int) floatValue);
        int i4 = (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1));
        if (i4 != 0) {
            radians += (1.0f - f14) * f13;
        }
        float floatValue2 = ((Float) this.f7386k.h()).floatValue();
        float floatValue3 = ((Float) this.f7385j.h()).floatValue();
        AbstractC0336a abstractC0336a = this.f7387l;
        float floatValue4 = abstractC0336a != null ? ((Float) abstractC0336a.h()).floatValue() / 100.0f : 0.0f;
        AbstractC0336a abstractC0336a2 = this.f7388m;
        float floatValue5 = abstractC0336a2 != null ? ((Float) abstractC0336a2.h()).floatValue() / 100.0f : 0.0f;
        if (i4 != 0) {
            f6 = ((floatValue2 - floatValue3) * f14) + floatValue3;
            i3 = i4;
            double d7 = f6;
            float cos = (float) (d7 * Math.cos(radians));
            f5 = (float) (d7 * Math.sin(radians));
            this.f7376a.moveTo(cos, f5);
            d3 = radians + ((f12 * f14) / 2.0f);
            f3 = cos;
            f4 = f13;
        } else {
            i3 = i4;
            double d8 = floatValue2;
            float cos2 = (float) (Math.cos(radians) * d8);
            float sin = (float) (d8 * Math.sin(radians));
            this.f7376a.moveTo(cos2, sin);
            f3 = cos2;
            f4 = f13;
            d3 = radians + f4;
            f5 = sin;
            f6 = 0.0f;
        }
        double ceil = Math.ceil(d6) * 2.0d;
        int i5 = 0;
        float f15 = f4;
        float f16 = f3;
        boolean z3 = false;
        while (true) {
            double d9 = i5;
            if (d9 >= ceil) {
                PointF pointF = (PointF) this.f7383h.h();
                this.f7376a.offset(pointF.x, pointF.y);
                this.f7376a.close();
                return;
            }
            float f17 = z3 ? floatValue2 : floatValue3;
            if (f6 == 0.0f || d9 != ceil - 2.0d) {
                f7 = f12;
                f8 = f15;
            } else {
                f7 = f12;
                f8 = (f12 * f14) / 2.0f;
            }
            if (f6 == 0.0f || d9 != ceil - 1.0d) {
                d4 = d9;
                f9 = f6;
                f6 = f17;
            } else {
                d4 = d9;
                f9 = f6;
            }
            double d10 = f6;
            double d11 = ceil;
            float cos3 = (float) (d10 * Math.cos(d3));
            float sin2 = (float) (d10 * Math.sin(d3));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f7376a.lineTo(cos3, sin2);
                d5 = d3;
                f10 = floatValue4;
                f11 = floatValue5;
            } else {
                f10 = floatValue4;
                double atan2 = (float) (Math.atan2(f5, f16) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                f11 = floatValue5;
                d5 = d3;
                double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f18 = z3 ? f10 : f11;
                float f19 = z3 ? f11 : f10;
                float f20 = (z3 ? floatValue3 : floatValue2) * f18 * 0.47829f;
                float f21 = cos4 * f20;
                float f22 = f20 * sin3;
                float f23 = (z3 ? floatValue2 : floatValue3) * f19 * 0.47829f;
                float f24 = cos5 * f23;
                float f25 = f23 * sin4;
                if (i3 != 0) {
                    if (i5 == 0) {
                        f21 *= f14;
                        f22 *= f14;
                    } else if (d4 == d11 - 1.0d) {
                        f24 *= f14;
                        f25 *= f14;
                    }
                }
                this.f7376a.cubicTo(f16 - f21, f5 - f22, cos3 + f24, sin2 + f25, cos3, sin2);
            }
            d3 = d5 + f8;
            z3 = !z3;
            i5++;
            f16 = cos3;
            f5 = sin2;
            floatValue5 = f11;
            floatValue4 = f10;
            f6 = f9;
            f12 = f7;
            ceil = d11;
        }
    }

    private void l() {
        this.f7390o = false;
        this.f7378c.invalidateSelf();
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
    }

    @Override // c1.m
    public Path d() {
        if (this.f7390o) {
            return this.f7376a;
        }
        this.f7376a.reset();
        if (this.f7380e) {
            this.f7390o = true;
            return this.f7376a;
        }
        int i3 = a.f7391a[this.f7379d.ordinal()];
        if (i3 == 1) {
            k();
        } else if (i3 == 2) {
            g();
        }
        this.f7376a.close();
        this.f7389n.b(this.f7376a);
        this.f7390o = true;
        return this.f7376a;
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        l();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            c cVar = (c) list.get(i3);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.l() == s.a.SIMULTANEOUSLY) {
                    this.f7389n.a(uVar);
                    uVar.b(this);
                }
            }
        }
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        AbstractC0336a abstractC0336a;
        AbstractC0336a abstractC0336a2;
        if (obj == InterfaceC0223c.f3215w) {
            this.f7382g.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3216x) {
            this.f7384i.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3206n) {
            this.f7383h.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3217y && (abstractC0336a2 = this.f7385j) != null) {
            abstractC0336a2.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3218z) {
            this.f7386k.n(c0483b);
            return;
        }
        if (obj == InterfaceC0223c.f3178A && (abstractC0336a = this.f7387l) != null) {
            abstractC0336a.n(c0483b);
        } else if (obj == InterfaceC0223c.f3179B) {
            this.f7388m.n(c0483b);
        }
    }

    @Override // c1.c
    public String j() {
        return this.f7377b;
    }
}
