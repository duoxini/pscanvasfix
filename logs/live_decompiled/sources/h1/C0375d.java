package h1;

import java.util.Arrays;
import m1.AbstractC0460c;
import m1.AbstractC0464g;

/* renamed from: h1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0375d {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f11887a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f11888b;

    public C0375d(float[] fArr, int[] iArr) {
        this.f11887a = fArr;
        this.f11888b = iArr;
    }

    private int b(float f3) {
        int binarySearch = Arrays.binarySearch(this.f11887a, f3);
        if (binarySearch >= 0) {
            return this.f11888b[binarySearch];
        }
        int i3 = -(binarySearch + 1);
        if (i3 == 0) {
            return this.f11888b[0];
        }
        int[] iArr = this.f11888b;
        if (i3 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f11887a;
        int i4 = i3 - 1;
        float f4 = fArr[i4];
        return AbstractC0460c.c((f3 - f4) / (fArr[i3] - f4), iArr[i4], iArr[i3]);
    }

    public C0375d a(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            iArr[i3] = b(fArr[i3]);
        }
        return new C0375d(fArr, iArr);
    }

    public int[] c() {
        return this.f11888b;
    }

    public float[] d() {
        return this.f11887a;
    }

    public int e() {
        return this.f11888b.length;
    }

    public void f(C0375d c0375d, C0375d c0375d2, float f3) {
        if (c0375d.f11888b.length == c0375d2.f11888b.length) {
            for (int i3 = 0; i3 < c0375d.f11888b.length; i3++) {
                this.f11887a[i3] = AbstractC0464g.i(c0375d.f11887a[i3], c0375d2.f11887a[i3], f3);
                this.f11888b[i3] = AbstractC0460c.c(f3, c0375d.f11888b[i3], c0375d2.f11888b[i3]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + c0375d.f11888b.length + " vs " + c0375d2.f11888b.length + ")");
    }
}
