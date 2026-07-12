package c1;

import a1.InterfaceC0223c;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import d1.AbstractC0336a;
import f1.C0358f;
import h1.C0383l;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class p implements e, m, j, AbstractC0336a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f7403a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Path f7404b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final com.oplus.anim.n f7405c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0395b f7406d;

    /* renamed from: e, reason: collision with root package name */
    private final String f7407e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f7408f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0336a f7409g;

    /* renamed from: h, reason: collision with root package name */
    private final AbstractC0336a f7410h;

    /* renamed from: i, reason: collision with root package name */
    private final d1.p f7411i;

    /* renamed from: j, reason: collision with root package name */
    private d f7412j;

    public p(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0383l c0383l) {
        this.f7405c = nVar;
        this.f7406d = abstractC0395b;
        this.f7407e = c0383l.c();
        this.f7408f = c0383l.f();
        AbstractC0336a a3 = c0383l.b().a();
        this.f7409g = a3;
        abstractC0395b.k(a3);
        a3.a(this);
        AbstractC0336a a4 = c0383l.d().a();
        this.f7410h = a4;
        abstractC0395b.k(a4);
        a4.a(this);
        d1.p b3 = c0383l.e().b();
        this.f7411i = b3;
        b3.a(abstractC0395b);
        b3.b(this);
    }

    @Override // c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        this.f7412j.a(rectF, matrix, z3);
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0464g.k(c0358f, i3, list, c0358f2, this);
        for (int i4 = 0; i4 < this.f7412j.l().size(); i4++) {
            c cVar = (c) this.f7412j.l().get(i4);
            if (cVar instanceof k) {
                AbstractC0464g.k(c0358f, i3, list, c0358f2, (k) cVar);
            }
        }
    }

    @Override // c1.m
    public Path d() {
        Path d3 = this.f7412j.d();
        this.f7404b.reset();
        float floatValue = ((Float) this.f7409g.h()).floatValue();
        float floatValue2 = ((Float) this.f7410h.h()).floatValue();
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f7403a.set(this.f7411i.g(i3 + floatValue2));
            this.f7404b.addPath(d3, this.f7403a);
        }
        return this.f7404b;
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f7405c.invalidateSelf();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        this.f7412j.f(list, list2);
    }

    @Override // c1.j
    public void g(ListIterator listIterator) {
        if (this.f7412j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((c) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f7412j = new d(this.f7405c, this.f7406d, "Repeater", this.f7408f, arrayList, null);
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        if (this.f7411i.c(obj, c0483b)) {
            return;
        }
        if (obj == InterfaceC0223c.f3213u) {
            this.f7409g.n(c0483b);
        } else if (obj == InterfaceC0223c.f3214v) {
            this.f7410h.n(c0483b);
        }
    }

    @Override // c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        float floatValue = ((Float) this.f7409g.h()).floatValue();
        float floatValue2 = ((Float) this.f7410h.h()).floatValue();
        float floatValue3 = ((Float) this.f7411i.i().h()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f7411i.e().h()).floatValue() / 100.0f;
        for (int i4 = ((int) floatValue) - 1; i4 >= 0; i4--) {
            this.f7403a.set(matrix);
            float f3 = i4;
            this.f7403a.preConcat(this.f7411i.g(f3 + floatValue2));
            this.f7412j.i(canvas, this.f7403a, (int) (i3 * AbstractC0464g.i(floatValue3, floatValue4, f3 / floatValue)));
        }
    }

    @Override // c1.c
    public String j() {
        return this.f7407e;
    }
}
