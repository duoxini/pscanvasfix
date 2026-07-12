package c1;

import android.graphics.Path;
import d1.AbstractC0336a;
import h1.C0388q;
import h1.s;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class r implements m, AbstractC0336a.b {

    /* renamed from: b, reason: collision with root package name */
    private final String f7418b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f7419c;

    /* renamed from: d, reason: collision with root package name */
    private final com.oplus.anim.n f7420d;

    /* renamed from: e, reason: collision with root package name */
    private final d1.m f7421e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7422f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7417a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final b f7423g = new b();

    public r(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0388q c0388q) {
        this.f7418b = c0388q.b();
        this.f7419c = c0388q.d();
        this.f7420d = nVar;
        d1.m a3 = c0388q.c().a();
        this.f7421e = a3;
        abstractC0395b.k(a3);
        a3.a(this);
    }

    private void b() {
        this.f7422f = false;
        this.f7420d.invalidateSelf();
    }

    @Override // c1.m
    public Path d() {
        if (this.f7422f) {
            return this.f7417a;
        }
        this.f7417a.reset();
        if (this.f7419c) {
            this.f7422f = true;
            return this.f7417a;
        }
        Path path = (Path) this.f7421e.h();
        if (path == null) {
            return this.f7417a;
        }
        this.f7417a.set(path);
        this.f7417a.setFillType(Path.FillType.EVEN_ODD);
        this.f7423g.b(this.f7417a);
        this.f7422f = true;
        return this.f7417a;
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        b();
    }

    @Override // c1.c
    public void f(List list, List list2) {
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            c cVar = (c) list.get(i3);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.l() == s.a.SIMULTANEOUSLY) {
                    this.f7423g.a(uVar);
                    uVar.b(this);
                }
            }
            if (cVar instanceof s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f7421e.q(arrayList);
    }
}
