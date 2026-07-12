package q;

import java.util.ArrayList;
import java.util.Arrays;
import r.o;

/* loaded from: classes.dex */
public abstract class i extends e implements h {

    /* renamed from: L0, reason: collision with root package name */
    public e[] f12992L0 = new e[4];

    /* renamed from: M0, reason: collision with root package name */
    public int f12993M0 = 0;

    @Override // q.h
    public void a(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i3 = this.f12993M0 + 1;
        e[] eVarArr = this.f12992L0;
        if (i3 > eVarArr.length) {
            this.f12992L0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f12992L0;
        int i4 = this.f12993M0;
        eVarArr2[i4] = eVar;
        this.f12993M0 = i4 + 1;
    }

    @Override // q.h
    public void b(f fVar) {
    }

    @Override // q.h
    public void c() {
        this.f12993M0 = 0;
        Arrays.fill(this.f12992L0, (Object) null);
    }

    public void n1(ArrayList arrayList, int i3, o oVar) {
        for (int i4 = 0; i4 < this.f12993M0; i4++) {
            oVar.a(this.f12992L0[i4]);
        }
        for (int i5 = 0; i5 < this.f12993M0; i5++) {
            r.i.a(this.f12992L0[i5], i3, arrayList, oVar);
        }
    }

    public int o1(int i3) {
        int i4;
        int i5;
        for (int i6 = 0; i6 < this.f12993M0; i6++) {
            e eVar = this.f12992L0[i6];
            if (i3 == 0 && (i5 = eVar.f12875I0) != -1) {
                return i5;
            }
            if (i3 == 1 && (i4 = eVar.f12877J0) != -1) {
                return i4;
            }
        }
        return -1;
    }
}
