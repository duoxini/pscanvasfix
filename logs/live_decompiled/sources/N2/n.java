package N2;

import L2.B0;
import N2.h;
import Q2.M;
import Q2.v;
import p2.AbstractC0501a;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public class n extends b {

    /* renamed from: q, reason: collision with root package name */
    private final int f1674q;

    /* renamed from: r, reason: collision with root package name */
    private final a f1675r;

    public n(int i3, a aVar, C2.l lVar) {
        super(i3, lVar);
        this.f1674q = i3;
        this.f1675r = aVar;
        if (aVar == a.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + D2.s.b(b.class).b() + " instead").toString());
        }
        if (i3 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i3 + " was specified").toString());
    }

    static /* synthetic */ Object C0(n nVar, Object obj, InterfaceC0593d interfaceC0593d) {
        M d3;
        Object F02 = nVar.F0(obj, true);
        if (!(F02 instanceof h.a)) {
            return p2.q.f12810a;
        }
        h.c(F02);
        C2.l lVar = nVar.f1639f;
        if (lVar == null || (d3 = v.d(lVar, obj, null, 2, null)) == null) {
            throw nVar.L();
        }
        AbstractC0501a.a(d3, nVar.L());
        throw d3;
    }

    private final Object D0(Object obj, boolean z3) {
        C2.l lVar;
        M d3;
        Object f3 = super.f(obj);
        if (h.e(f3) || h.d(f3)) {
            return f3;
        }
        if (!z3 || (lVar = this.f1639f) == null || (d3 = v.d(lVar, obj, null, 2, null)) == null) {
            return h.f1669a.c(p2.q.f12810a);
        }
        throw d3;
    }

    private final Object E0(Object obj) {
        i iVar;
        Object obj2 = c.f1648d;
        i iVar2 = (i) b.f1633l.get(this);
        while (true) {
            long andIncrement = b.f1629h.getAndIncrement(this);
            long j3 = andIncrement & 1152921504606846975L;
            boolean V3 = V(andIncrement);
            int i3 = c.f1646b;
            long j4 = j3 / i3;
            int i4 = (int) (j3 % i3);
            if (iVar2.f1961g != j4) {
                i G3 = G(j4, iVar2);
                if (G3 != null) {
                    iVar = G3;
                } else if (V3) {
                    return h.f1669a.a(L());
                }
            } else {
                iVar = iVar2;
            }
            int x02 = x0(iVar, i4, obj, j3, obj2, V3);
            if (x02 == 0) {
                iVar.b();
                return h.f1669a.c(p2.q.f12810a);
            }
            if (x02 == 1) {
                return h.f1669a.c(p2.q.f12810a);
            }
            if (x02 == 2) {
                if (V3) {
                    iVar.p();
                    return h.f1669a.a(L());
                }
                B0 b02 = obj2 instanceof B0 ? (B0) obj2 : null;
                if (b02 != null) {
                    j0(b02, iVar, i4);
                }
                C((iVar.f1961g * i3) + i4);
                return h.f1669a.c(p2.q.f12810a);
            }
            if (x02 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (x02 == 4) {
                if (j3 < K()) {
                    iVar.b();
                }
                return h.f1669a.a(L());
            }
            if (x02 == 5) {
                iVar.b();
            }
            iVar2 = iVar;
        }
    }

    private final Object F0(Object obj, boolean z3) {
        return this.f1675r == a.DROP_LATEST ? D0(obj, z3) : E0(obj);
    }

    @Override // N2.b
    protected boolean W() {
        return this.f1675r == a.DROP_OLDEST;
    }

    @Override // N2.b, N2.s
    public Object f(Object obj) {
        return F0(obj, false);
    }

    @Override // N2.b, N2.s
    public Object n(Object obj, InterfaceC0593d interfaceC0593d) {
        return C0(this, obj, interfaceC0593d);
    }
}
