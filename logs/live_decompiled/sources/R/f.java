package r;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d, reason: collision with root package name */
    p f13082d;

    /* renamed from: f, reason: collision with root package name */
    int f13084f;

    /* renamed from: g, reason: collision with root package name */
    public int f13085g;

    /* renamed from: a, reason: collision with root package name */
    public d f13079a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13080b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13081c = false;

    /* renamed from: e, reason: collision with root package name */
    a f13083e = a.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    int f13086h = 1;

    /* renamed from: i, reason: collision with root package name */
    g f13087i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13088j = false;

    /* renamed from: k, reason: collision with root package name */
    List f13089k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    List f13090l = new ArrayList();

    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f13082d = pVar;
    }

    @Override // r.d
    public void a(d dVar) {
        Iterator it = this.f13090l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f13088j) {
                return;
            }
        }
        this.f13081c = true;
        d dVar2 = this.f13079a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f13080b) {
            this.f13082d.a(this);
            return;
        }
        f fVar = null;
        int i3 = 0;
        for (f fVar2 : this.f13090l) {
            if (!(fVar2 instanceof g)) {
                i3++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i3 == 1 && fVar.f13088j) {
            g gVar = this.f13087i;
            if (gVar != null) {
                if (!gVar.f13088j) {
                    return;
                } else {
                    this.f13084f = this.f13086h * gVar.f13085g;
                }
            }
            d(fVar.f13085g + this.f13084f);
        }
        d dVar3 = this.f13079a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f13089k.add(dVar);
        if (this.f13088j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f13090l.clear();
        this.f13089k.clear();
        this.f13088j = false;
        this.f13085g = 0;
        this.f13081c = false;
        this.f13080b = false;
    }

    public void d(int i3) {
        if (this.f13088j) {
            return;
        }
        this.f13088j = true;
        this.f13085g = i3;
        for (d dVar : this.f13089k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13082d.f13133b.r());
        sb.append(":");
        sb.append(this.f13083e);
        sb.append("(");
        sb.append(this.f13088j ? Integer.valueOf(this.f13085g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f13090l.size());
        sb.append(":d=");
        sb.append(this.f13089k.size());
        sb.append(">");
        return sb.toString();
    }
}
