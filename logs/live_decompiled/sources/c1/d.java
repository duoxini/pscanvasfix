package c1;

import a1.C0221a;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import b1.C0292a;
import d1.AbstractC0336a;
import f1.C0358f;
import h1.C0387p;
import h1.InterfaceC0374c;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;
import m1.AbstractC0465h;
import n1.C0483b;

/* loaded from: classes.dex */
public class d implements e, m, AbstractC0336a.b, f1.g {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f7305a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f7306b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f7307c;

    /* renamed from: d, reason: collision with root package name */
    private final Path f7308d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f7309e;

    /* renamed from: f, reason: collision with root package name */
    private final String f7310f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f7311g;

    /* renamed from: h, reason: collision with root package name */
    private final List f7312h;

    /* renamed from: i, reason: collision with root package name */
    private final com.oplus.anim.n f7313i;

    /* renamed from: j, reason: collision with root package name */
    private List f7314j;

    /* renamed from: k, reason: collision with root package name */
    private d1.p f7315k;

    public d(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0387p c0387p, C0221a c0221a) {
        this(nVar, abstractC0395b, c0387p.c(), c0387p.d(), g(nVar, c0221a, abstractC0395b, c0387p.b()), k(c0387p.b()));
    }

    private static List g(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            c a3 = ((InterfaceC0374c) list.get(i3)).a(nVar, c0221a, abstractC0395b);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    static g1.l k(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            InterfaceC0374c interfaceC0374c = (InterfaceC0374c) list.get(i3);
            if (interfaceC0374c instanceof g1.l) {
                return (g1.l) interfaceC0374c;
            }
        }
        return null;
    }

    private boolean o() {
        int i3 = 0;
        for (int i4 = 0; i4 < this.f7312h.size(); i4++) {
            if ((this.f7312h.get(i4) instanceof e) && (i3 = i3 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        this.f7307c.set(matrix);
        d1.p pVar = this.f7315k;
        if (pVar != null) {
            this.f7307c.preConcat(pVar.f());
        }
        this.f7309e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f7312h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f7312h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f7309e, this.f7307c, z3);
                rectF.union(this.f7309e);
            }
        }
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        if (c0358f.g(j(), i3) || "__container".equals(j())) {
            if (!"__container".equals(j())) {
                c0358f2 = c0358f2.a(j());
                if (c0358f.c(j(), i3)) {
                    list.add(c0358f2.i(this));
                }
            }
            if (c0358f.h(j(), i3)) {
                int e3 = i3 + c0358f.e(j(), i3);
                for (int i4 = 0; i4 < this.f7312h.size(); i4++) {
                    c cVar = (c) this.f7312h.get(i4);
                    if (cVar instanceof f1.g) {
                        ((f1.g) cVar).b(c0358f, e3, list, c0358f2);
                    }
                }
            }
        }
    }

    @Override // c1.m
    public Path d() {
        this.f7307c.reset();
        d1.p pVar = this.f7315k;
        if (pVar != null) {
            this.f7307c.set(pVar.f());
        }
        this.f7308d.reset();
        if (this.f7311g) {
            return this.f7308d;
        }
        for (int size = this.f7312h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f7312h.get(size);
            if (cVar instanceof m) {
                this.f7308d.addPath(((m) cVar).d(), this.f7307c);
            }
        }
        return this.f7308d;
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f7313i.invalidateSelf();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f7312h.size());
        arrayList.addAll(list);
        for (int size = this.f7312h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f7312h.get(size);
            cVar.f(arrayList, this.f7312h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        d1.p pVar = this.f7315k;
        if (pVar != null) {
            pVar.c(obj, c0483b);
        }
    }

    @Override // c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f7311g) {
            return;
        }
        this.f7307c.set(matrix);
        d1.p pVar = this.f7315k;
        if (pVar != null) {
            this.f7307c.preConcat(pVar.f());
            i3 = (int) (((((this.f7315k.h() == null ? 100 : ((Integer) this.f7315k.h().h()).intValue()) / 100.0f) * i3) / 255.0f) * 255.0f);
        }
        boolean z3 = this.f7313i.b0() && o() && i3 != 255;
        if (z3) {
            this.f7306b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.f7306b, this.f7307c, true);
            this.f7305a.setAlpha(i3);
            AbstractC0465h.o(canvas, this.f7306b, this.f7305a);
        }
        if (z3) {
            i3 = 255;
        }
        for (int size = this.f7312h.size() - 1; size >= 0; size--) {
            Object obj = this.f7312h.get(size);
            if (obj instanceof e) {
                ((e) obj).i(canvas, this.f7307c, i3);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // c1.c
    public String j() {
        return this.f7310f;
    }

    public List l() {
        return this.f7312h;
    }

    List m() {
        if (this.f7314j == null) {
            this.f7314j = new ArrayList();
            for (int i3 = 0; i3 < this.f7312h.size(); i3++) {
                c cVar = (c) this.f7312h.get(i3);
                if (cVar instanceof m) {
                    this.f7314j.add((m) cVar);
                }
            }
        }
        return this.f7314j;
    }

    Matrix n() {
        d1.p pVar = this.f7315k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f7307c.reset();
        return this.f7307c;
    }

    d(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, String str, boolean z3, List list, g1.l lVar) {
        this.f7305a = new C0292a();
        this.f7306b = new RectF();
        this.f7307c = new Matrix();
        this.f7308d = new Path();
        this.f7309e = new RectF();
        this.f7310f = str;
        this.f7313i = nVar;
        this.f7311g = z3;
        this.f7312h = list;
        if (lVar != null) {
            d1.p b3 = lVar.b();
            this.f7315k = b3;
            b3.a(abstractC0395b);
            this.f7315k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).g(list.listIterator(list.size()));
        }
    }
}
