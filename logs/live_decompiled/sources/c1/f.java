package c1;

import a1.InterfaceC0223c;
import android.graphics.Path;
import android.graphics.PointF;
import d1.AbstractC0336a;
import f1.C0358f;
import h1.C0373b;
import h1.s;
import i1.AbstractC0395b;
import java.util.List;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class f implements m, AbstractC0336a.b, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f7317b;

    /* renamed from: c, reason: collision with root package name */
    private final com.oplus.anim.n f7318c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0336a f7319d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0336a f7320e;

    /* renamed from: f, reason: collision with root package name */
    private final C0373b f7321f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7323h;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7316a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final b f7322g = new b();

    public f(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0373b c0373b) {
        this.f7317b = c0373b.b();
        this.f7318c = nVar;
        AbstractC0336a a3 = c0373b.d().a();
        this.f7319d = a3;
        AbstractC0336a a4 = c0373b.c().a();
        this.f7320e = a4;
        this.f7321f = c0373b;
        abstractC0395b.k(a3);
        abstractC0395b.k(a4);
        a3.a(this);
        a4.a(this);
    }

    private void g() {
        this.f7323h = false;
        this.f7318c.invalidateSelf();
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
    }

    @Override // c1.m
    public Path d() {
        if (this.f7323h) {
            return this.f7316a;
        }
        this.f7316a.reset();
        if (this.f7321f.e()) {
            this.f7323h = true;
            return this.f7316a;
        }
        PointF pointF = (PointF) this.f7319d.h();
        float f3 = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        float f5 = f3 * 0.55228f;
        float f6 = 0.55228f * f4;
        this.f7316a.reset();
        if (this.f7321f.f()) {
            float f7 = -f4;
            this.f7316a.moveTo(0.0f, f7);
            float f8 = 0.0f - f5;
            float f9 = -f3;
            float f10 = 0.0f - f6;
            this.f7316a.cubicTo(f8, f7, f9, f10, f9, 0.0f);
            float f11 = f6 + 0.0f;
            this.f7316a.cubicTo(f9, f11, f8, f4, 0.0f, f4);
            float f12 = f5 + 0.0f;
            this.f7316a.cubicTo(f12, f4, f3, f11, f3, 0.0f);
            this.f7316a.cubicTo(f3, f10, f12, f7, 0.0f, f7);
        } else {
            float f13 = -f4;
            this.f7316a.moveTo(0.0f, f13);
            float f14 = f5 + 0.0f;
            float f15 = 0.0f - f6;
            this.f7316a.cubicTo(f14, f13, f3, f15, f3, 0.0f);
            float f16 = f6 + 0.0f;
            this.f7316a.cubicTo(f3, f16, f14, f4, 0.0f, f4);
            float f17 = 0.0f - f5;
            float f18 = -f3;
            this.f7316a.cubicTo(f17, f4, f18, f16, f18, 0.0f);
            this.f7316a.cubicTo(f18, f15, f17, f13, 0.0f, f13);
        }
        PointF pointF2 = (PointF) this.f7320e.h();
        this.f7316a.offset(pointF2.x, pointF2.y);
        this.f7316a.close();
        this.f7322g.b(this.f7316a);
        this.f7323h = true;
        return this.f7316a;
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        g();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            c cVar = (c) list.get(i3);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.l() == s.a.SIMULTANEOUSLY) {
                    this.f7322g.a(uVar);
                    uVar.b(this);
                }
            }
        }
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        if (obj == InterfaceC0223c.f3203k) {
            this.f7319d.n(c0483b);
        } else if (obj == InterfaceC0223c.f3206n) {
            this.f7320e.n(c0483b);
        }
    }

    @Override // c1.c
    public String j() {
        return this.f7317b;
    }
}
