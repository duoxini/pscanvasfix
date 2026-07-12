package r;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c extends p {

    /* renamed from: k, reason: collision with root package name */
    ArrayList f13068k;

    /* renamed from: l, reason: collision with root package name */
    private int f13069l;

    public c(q.e eVar, int i3) {
        super(eVar);
        this.f13068k = new ArrayList();
        this.f13137f = i3;
        q();
    }

    private void q() {
        q.e eVar;
        q.e eVar2 = this.f13133b;
        q.e J3 = eVar2.J(this.f13137f);
        while (true) {
            q.e eVar3 = J3;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                J3 = eVar2.J(this.f13137f);
            }
        }
        this.f13133b = eVar;
        this.f13068k.add(eVar.L(this.f13137f));
        q.e H3 = eVar.H(this.f13137f);
        while (H3 != null) {
            this.f13068k.add(H3.L(this.f13137f));
            H3 = H3.H(this.f13137f);
        }
        Iterator it = this.f13068k.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            int i3 = this.f13137f;
            if (i3 == 0) {
                pVar.f13133b.f12898c = this;
            } else if (i3 == 1) {
                pVar.f13133b.f12900d = this;
            }
        }
        if (this.f13137f == 0 && ((q.f) this.f13133b.I()).L1() && this.f13068k.size() > 1) {
            ArrayList arrayList = this.f13068k;
            this.f13133b = ((p) arrayList.get(arrayList.size() - 1)).f13133b;
        }
        this.f13069l = this.f13137f == 0 ? this.f13133b.x() : this.f13133b.Q();
    }

    private q.e r() {
        for (int i3 = 0; i3 < this.f13068k.size(); i3++) {
            p pVar = (p) this.f13068k.get(i3);
            if (pVar.f13133b.T() != 8) {
                return pVar.f13133b;
            }
        }
        return null;
    }

    private q.e s() {
        for (int size = this.f13068k.size() - 1; size >= 0; size--) {
            p pVar = (p) this.f13068k.get(size);
            if (pVar.f13133b.T() != 8) {
                return pVar.f13133b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:288:0x03fe, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9  */
    @Override // r.p, r.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(r.d r27) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.c.a(r.d):void");
    }

    @Override // r.p
    void d() {
        Iterator it = this.f13068k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).d();
        }
        int size = this.f13068k.size();
        if (size < 1) {
            return;
        }
        q.e eVar = ((p) this.f13068k.get(0)).f13133b;
        q.e eVar2 = ((p) this.f13068k.get(size - 1)).f13133b;
        if (this.f13137f == 0) {
            q.d dVar = eVar.f12882O;
            q.d dVar2 = eVar2.f12884Q;
            f i3 = i(dVar, 0);
            int e3 = dVar.e();
            q.e r3 = r();
            if (r3 != null) {
                e3 = r3.f12882O.e();
            }
            if (i3 != null) {
                b(this.f13139h, i3, e3);
            }
            f i4 = i(dVar2, 0);
            int e4 = dVar2.e();
            q.e s3 = s();
            if (s3 != null) {
                e4 = s3.f12884Q.e();
            }
            if (i4 != null) {
                b(this.f13140i, i4, -e4);
            }
        } else {
            q.d dVar3 = eVar.f12883P;
            q.d dVar4 = eVar2.f12885R;
            f i5 = i(dVar3, 1);
            int e5 = dVar3.e();
            q.e r4 = r();
            if (r4 != null) {
                e5 = r4.f12883P.e();
            }
            if (i5 != null) {
                b(this.f13139h, i5, e5);
            }
            f i6 = i(dVar4, 1);
            int e6 = dVar4.e();
            q.e s4 = s();
            if (s4 != null) {
                e6 = s4.f12885R.e();
            }
            if (i6 != null) {
                b(this.f13140i, i6, -e6);
            }
        }
        this.f13139h.f13079a = this;
        this.f13140i.f13079a = this;
    }

    @Override // r.p
    public void e() {
        for (int i3 = 0; i3 < this.f13068k.size(); i3++) {
            ((p) this.f13068k.get(i3)).e();
        }
    }

    @Override // r.p
    void f() {
        this.f13134c = null;
        Iterator it = this.f13068k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
    }

    @Override // r.p
    public long j() {
        int size = this.f13068k.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j3 = j3 + r4.f13139h.f13084f + ((p) this.f13068k.get(i3)).j() + r4.f13140i.f13084f;
        }
        return j3;
    }

    @Override // r.p
    boolean m() {
        int size = this.f13068k.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!((p) this.f13068k.get(i3)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f13137f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f13068k.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            sb.append("<");
            sb.append(pVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
