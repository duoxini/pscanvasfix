package g1;

import d1.AbstractC0336a;
import h1.C0375d;
import java.util.Arrays;
import java.util.List;

/* renamed from: g1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0367c extends n {
    public C0367c(List list) {
        super(e(list));
    }

    private static n1.c d(n1.c cVar) {
        C0375d c0375d = (C0375d) cVar.f12574b;
        C0375d c0375d2 = (C0375d) cVar.f12575c;
        if (c0375d == null || c0375d2 == null || c0375d.d().length == c0375d2.d().length) {
            return cVar;
        }
        float[] f3 = f(c0375d.d(), c0375d2.d());
        return cVar.b(c0375d.a(f3), c0375d2.a(f3));
    }

    private static List e(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.set(i3, d((n1.c) list.get(i3)));
        }
        return list;
    }

    static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f3 = Float.NaN;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            float f4 = fArr3[i4];
            if (f4 != f3) {
                fArr3[i3] = f4;
                i3++;
                f3 = fArr3[i4];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i3);
    }

    @Override // g1.m
    public AbstractC0336a a() {
        return new d1.e(this.f11691a);
    }

    @Override // g1.n, g1.m
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // g1.n, g1.m
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // g1.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
