package r;

import java.util.ArrayList;

/* loaded from: classes.dex */
class m {

    /* renamed from: h, reason: collision with root package name */
    public static int f13106h;

    /* renamed from: c, reason: collision with root package name */
    p f13109c;

    /* renamed from: d, reason: collision with root package name */
    p f13110d;

    /* renamed from: f, reason: collision with root package name */
    int f13112f;

    /* renamed from: g, reason: collision with root package name */
    int f13113g;

    /* renamed from: a, reason: collision with root package name */
    public int f13107a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13108b = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f13111e = new ArrayList();

    public m(p pVar, int i3) {
        this.f13109c = null;
        this.f13110d = null;
        int i4 = f13106h;
        this.f13112f = i4;
        f13106h = i4 + 1;
        this.f13109c = pVar;
        this.f13110d = pVar;
        this.f13113g = i3;
    }

    private long c(f fVar, long j3) {
        p pVar = fVar.f13082d;
        if (pVar instanceof k) {
            return j3;
        }
        int size = fVar.f13089k.size();
        long j4 = j3;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) fVar.f13089k.get(i3);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f13082d != pVar) {
                    j4 = Math.min(j4, c(fVar2, fVar2.f13084f + j3));
                }
            }
        }
        if (fVar != pVar.f13140i) {
            return j4;
        }
        long j5 = j3 - pVar.j();
        return Math.min(Math.min(j4, c(pVar.f13139h, j5)), j5 - pVar.f13139h.f13084f);
    }

    private long d(f fVar, long j3) {
        p pVar = fVar.f13082d;
        if (pVar instanceof k) {
            return j3;
        }
        int size = fVar.f13089k.size();
        long j4 = j3;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) fVar.f13089k.get(i3);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f13082d != pVar) {
                    j4 = Math.max(j4, d(fVar2, fVar2.f13084f + j3));
                }
            }
        }
        if (fVar != pVar.f13139h) {
            return j4;
        }
        long j5 = j3 + pVar.j();
        return Math.max(Math.max(j4, d(pVar.f13140i, j5)), j5 - pVar.f13140i.f13084f);
    }

    public void a(p pVar) {
        this.f13111e.add(pVar);
        this.f13110d = pVar;
    }

    public long b(q.f fVar, int i3) {
        p pVar = this.f13109c;
        if (pVar instanceof c) {
            if (((c) pVar).f13137f != i3) {
                return 0L;
            }
        } else if (i3 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i3 == 0 ? fVar.f12902e : fVar.f12904f).f13139h;
        f fVar3 = (i3 == 0 ? fVar.f12902e : fVar.f12904f).f13140i;
        boolean contains = pVar.f13139h.f13090l.contains(fVar2);
        boolean contains2 = this.f13109c.f13140i.f13090l.contains(fVar3);
        long j3 = this.f13109c.j();
        if (!contains || !contains2) {
            if (contains) {
                return Math.max(d(this.f13109c.f13139h, r12.f13084f), this.f13109c.f13139h.f13084f + j3);
            }
            if (!contains2) {
                return (r12.f13139h.f13084f + this.f13109c.j()) - this.f13109c.f13140i.f13084f;
            }
            return Math.max(-c(this.f13109c.f13140i, r12.f13084f), (-this.f13109c.f13140i.f13084f) + j3);
        }
        long d3 = d(this.f13109c.f13139h, 0L);
        long c3 = c(this.f13109c.f13140i, 0L);
        long j4 = d3 - j3;
        p pVar2 = this.f13109c;
        int i4 = pVar2.f13140i.f13084f;
        if (j4 >= (-i4)) {
            j4 += i4;
        }
        int i5 = pVar2.f13139h.f13084f;
        long j5 = ((-c3) - j3) - i5;
        if (j5 >= i5) {
            j5 -= i5;
        }
        float o3 = pVar2.f13133b.o(i3);
        float f3 = o3 > 0.0f ? (long) ((j5 / o3) + (j4 / (1.0f - o3))) : 0L;
        long j6 = ((long) ((f3 * o3) + 0.5f)) + j3 + ((long) ((f3 * (1.0f - o3)) + 0.5f));
        p pVar3 = this.f13109c;
        return (pVar3.f13139h.f13084f + j6) - pVar3.f13140i.f13084f;
    }
}
