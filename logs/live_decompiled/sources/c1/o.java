package c1;

import a1.InterfaceC0223c;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import d1.AbstractC0336a;
import f1.C0358f;
import h1.C0382k;
import h1.s;
import i1.AbstractC0395b;
import java.util.List;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class o implements AbstractC0336a.b, k, m {

    /* renamed from: c, reason: collision with root package name */
    private final String f7394c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f7395d;

    /* renamed from: e, reason: collision with root package name */
    private final com.oplus.anim.n f7396e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0336a f7397f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0336a f7398g;

    /* renamed from: h, reason: collision with root package name */
    private final AbstractC0336a f7399h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7402k;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7392a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f7393b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private final b f7400i = new b();

    /* renamed from: j, reason: collision with root package name */
    private AbstractC0336a f7401j = null;

    public o(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0382k c0382k) {
        this.f7394c = c0382k.c();
        this.f7395d = c0382k.f();
        this.f7396e = nVar;
        AbstractC0336a a3 = c0382k.d().a();
        this.f7397f = a3;
        AbstractC0336a a4 = c0382k.e().a();
        this.f7398g = a4;
        AbstractC0336a a5 = c0382k.b().a();
        this.f7399h = a5;
        abstractC0395b.k(a3);
        abstractC0395b.k(a4);
        abstractC0395b.k(a5);
        a3.a(this);
        a4.a(this);
        a5.a(this);
    }

    private void g() {
        this.f7402k = false;
        this.f7396e.invalidateSelf();
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
    }

    @Override // c1.m
    public Path d() {
        AbstractC0336a abstractC0336a;
        if (this.f7402k) {
            return this.f7392a;
        }
        this.f7392a.reset();
        if (this.f7395d) {
            this.f7402k = true;
            return this.f7392a;
        }
        PointF pointF = (PointF) this.f7398g.h();
        float f3 = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        AbstractC0336a abstractC0336a2 = this.f7399h;
        float p3 = abstractC0336a2 == null ? 0.0f : ((d1.d) abstractC0336a2).p();
        if (p3 == 0.0f && (abstractC0336a = this.f7401j) != null) {
            p3 = Math.min(((Float) abstractC0336a.h()).floatValue(), Math.min(f3, f4));
        }
        float min = Math.min(f3, f4);
        if (p3 > min) {
            p3 = min;
        }
        PointF pointF2 = (PointF) this.f7397f.h();
        this.f7392a.moveTo(pointF2.x + f3, (pointF2.y - f4) + p3);
        this.f7392a.lineTo(pointF2.x + f3, (pointF2.y + f4) - p3);
        if (p3 > 0.0f) {
            RectF rectF = this.f7393b;
            float f5 = pointF2.x;
            float f6 = p3 * 2.0f;
            float f7 = pointF2.y;
            rectF.set((f5 + f3) - f6, (f7 + f4) - f6, f5 + f3, f7 + f4);
            this.f7392a.arcTo(this.f7393b, 0.0f, 90.0f, false);
        }
        this.f7392a.lineTo((pointF2.x - f3) + p3, pointF2.y + f4);
        if (p3 > 0.0f) {
            RectF rectF2 = this.f7393b;
            float f8 = pointF2.x;
            float f9 = pointF2.y;
            float f10 = p3 * 2.0f;
            rectF2.set(f8 - f3, (f9 + f4) - f10, (f8 - f3) + f10, f9 + f4);
            this.f7392a.arcTo(this.f7393b, 90.0f, 90.0f, false);
        }
        this.f7392a.lineTo(pointF2.x - f3, (pointF2.y - f4) + p3);
        if (p3 > 0.0f) {
            RectF rectF3 = this.f7393b;
            float f11 = pointF2.x;
            float f12 = pointF2.y;
            float f13 = p3 * 2.0f;
            rectF3.set(f11 - f3, f12 - f4, (f11 - f3) + f13, (f12 - f4) + f13);
            this.f7392a.arcTo(this.f7393b, 180.0f, 90.0f, false);
        }
        this.f7392a.lineTo((pointF2.x + f3) - p3, pointF2.y - f4);
        if (p3 > 0.0f) {
            RectF rectF4 = this.f7393b;
            float f14 = pointF2.x;
            float f15 = p3 * 2.0f;
            float f16 = pointF2.y;
            rectF4.set((f14 + f3) - f15, f16 - f4, f14 + f3, (f16 - f4) + f15);
            this.f7392a.arcTo(this.f7393b, 270.0f, 90.0f, false);
        }
        this.f7392a.close();
        this.f7400i.b(this.f7392a);
        this.f7402k = true;
        return this.f7392a;
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
                    this.f7400i.a(uVar);
                    uVar.b(this);
                }
            }
            if (cVar instanceof q) {
                this.f7401j = ((q) cVar).h();
            }
        }
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        if (obj == InterfaceC0223c.f3204l) {
            this.f7398g.n(c0483b);
        } else if (obj == InterfaceC0223c.f3206n) {
            this.f7397f.n(c0483b);
        } else if (obj == InterfaceC0223c.f3205m) {
            this.f7399h.n(c0483b);
        }
    }

    @Override // c1.c
    public String j() {
        return this.f7394c;
    }
}
