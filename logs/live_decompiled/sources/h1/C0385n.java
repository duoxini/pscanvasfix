package h1;

import android.graphics.PointF;
import f1.C0353a;
import java.util.ArrayList;
import java.util.List;
import m1.AbstractC0462e;
import m1.AbstractC0464g;

/* renamed from: h1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0385n {

    /* renamed from: a, reason: collision with root package name */
    private final List f11960a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f11961b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11962c;

    public C0385n(PointF pointF, boolean z3, List list) {
        this.f11961b = pointF;
        this.f11962c = z3;
        this.f11960a = new ArrayList(list);
    }

    public List a() {
        return this.f11960a;
    }

    public PointF b() {
        return this.f11961b;
    }

    public void c(C0385n c0385n, C0385n c0385n2, float f3) {
        if (this.f11961b == null) {
            this.f11961b = new PointF();
        }
        this.f11962c = c0385n.d() || c0385n2.d();
        if (c0385n.a().size() != c0385n2.a().size()) {
            AbstractC0462e.c("Curves must have the same number of control points. Shape 1: " + c0385n.a().size() + "\tShape 2: " + c0385n2.a().size());
        }
        int min = Math.min(c0385n.a().size(), c0385n2.a().size());
        if (this.f11960a.size() < min) {
            for (int size = this.f11960a.size(); size < min; size++) {
                this.f11960a.add(new C0353a());
            }
        } else if (this.f11960a.size() > min) {
            for (int size2 = this.f11960a.size() - 1; size2 >= min; size2--) {
                List list = this.f11960a;
                list.remove(list.size() - 1);
            }
        }
        PointF b3 = c0385n.b();
        PointF b4 = c0385n2.b();
        f(AbstractC0464g.i(b3.x, b4.x, f3), AbstractC0464g.i(b3.y, b4.y, f3));
        for (int size3 = this.f11960a.size() - 1; size3 >= 0; size3--) {
            C0353a c0353a = (C0353a) c0385n.a().get(size3);
            C0353a c0353a2 = (C0353a) c0385n2.a().get(size3);
            PointF a3 = c0353a.a();
            PointF b5 = c0353a.b();
            PointF c3 = c0353a.c();
            PointF a4 = c0353a2.a();
            PointF b6 = c0353a2.b();
            PointF c4 = c0353a2.c();
            ((C0353a) this.f11960a.get(size3)).d(AbstractC0464g.i(a3.x, a4.x, f3), AbstractC0464g.i(a3.y, a4.y, f3));
            ((C0353a) this.f11960a.get(size3)).e(AbstractC0464g.i(b5.x, b6.x, f3), AbstractC0464g.i(b5.y, b6.y, f3));
            ((C0353a) this.f11960a.get(size3)).f(AbstractC0464g.i(c3.x, c4.x, f3), AbstractC0464g.i(c3.y, c4.y, f3));
        }
    }

    public boolean d() {
        return this.f11962c;
    }

    public void e(boolean z3) {
        this.f11962c = z3;
    }

    public void f(float f3, float f4) {
        if (this.f11961b == null) {
            this.f11961b = new PointF();
        }
        this.f11961b.set(f3, f4);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f11960a.size() + "closed=" + this.f11962c + '}';
    }

    public C0385n() {
        this.f11960a = new ArrayList();
    }
}
