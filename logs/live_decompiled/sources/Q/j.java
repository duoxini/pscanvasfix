package q;

import n.C0474d;
import q.e;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f12994a = new boolean[3];

    static void a(f fVar, C0474d c0474d, e eVar) {
        eVar.f12932t = -1;
        eVar.f12934u = -1;
        e.b bVar = fVar.f12893Z[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.f12893Z[0] == e.b.MATCH_PARENT) {
            int i3 = eVar.f12882O.f12843g;
            int U3 = fVar.U() - eVar.f12884Q.f12843g;
            d dVar = eVar.f12882O;
            dVar.f12845i = c0474d.q(dVar);
            d dVar2 = eVar.f12884Q;
            dVar2.f12845i = c0474d.q(dVar2);
            c0474d.f(eVar.f12882O.f12845i, i3);
            c0474d.f(eVar.f12884Q.f12845i, U3);
            eVar.f12932t = 2;
            eVar.L0(i3, U3);
        }
        if (fVar.f12893Z[1] == bVar2 || eVar.f12893Z[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i4 = eVar.f12883P.f12843g;
        int v3 = fVar.v() - eVar.f12885R.f12843g;
        d dVar3 = eVar.f12883P;
        dVar3.f12845i = c0474d.q(dVar3);
        d dVar4 = eVar.f12885R;
        dVar4.f12845i = c0474d.q(dVar4);
        c0474d.f(eVar.f12883P.f12845i, i4);
        c0474d.f(eVar.f12885R.f12845i, v3);
        if (eVar.f12917l0 > 0 || eVar.T() == 8) {
            d dVar5 = eVar.f12886S;
            dVar5.f12845i = c0474d.q(dVar5);
            c0474d.f(eVar.f12886S.f12845i, eVar.f12917l0 + i4);
        }
        eVar.f12934u = 2;
        eVar.b1(i4, v3);
    }

    public static final boolean b(int i3, int i4) {
        return (i3 & i4) == i4;
    }
}
