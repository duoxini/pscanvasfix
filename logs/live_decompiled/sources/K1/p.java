package k1;

import android.graphics.Color;
import h1.C0375d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l1.c;
import m1.AbstractC0460c;
import m1.AbstractC0464g;

/* loaded from: classes.dex */
public class p implements N {

    /* renamed from: a, reason: collision with root package name */
    private int f12268a;

    public p(int i3) {
        this.f12268a = i3;
    }

    private C0375d b(C0375d c0375d, List list) {
        int i3 = this.f12268a * 4;
        if (list.size() <= i3) {
            return c0375d;
        }
        float[] d3 = c0375d.d();
        int[] c3 = c0375d.c();
        int size = (list.size() - i3) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i4 = 0;
        while (i3 < list.size()) {
            if (i3 % 2 == 0) {
                fArr[i4] = ((Float) list.get(i3)).floatValue();
            } else {
                fArr2[i4] = ((Float) list.get(i3)).floatValue();
                i4++;
            }
            i3++;
        }
        float[] e3 = e(c0375d.d(), fArr);
        int length = e3.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            float f3 = e3[i5];
            int binarySearch = Arrays.binarySearch(d3, f3);
            int binarySearch2 = Arrays.binarySearch(fArr, f3);
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i5] = c(f3, fArr2[binarySearch2], d3, c3);
            } else {
                iArr[i5] = d(f3, c3[binarySearch], fArr, fArr2);
            }
        }
        return new C0375d(e3, iArr);
    }

    private int d(float f3, int i3, float[] fArr, float[] fArr2) {
        float i4;
        if (fArr2.length < 2 || f3 <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i3), Color.green(i3), Color.blue(i3));
        }
        for (int i5 = 1; i5 < fArr.length; i5++) {
            float f4 = fArr[i5];
            if (f4 >= f3 || i5 == fArr.length - 1) {
                if (f4 <= f3) {
                    i4 = fArr2[i5];
                } else {
                    int i6 = i5 - 1;
                    float f5 = fArr[i6];
                    i4 = AbstractC0464g.i(fArr2[i6], fArr2[i5], (f3 - f5) / (f4 - f5));
                }
                return Color.argb((int) (i4 * 255.0f), Color.red(i3), Color.green(i3), Color.blue(i3));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    protected static float[] e(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            float f3 = i4 < fArr.length ? fArr[i4] : Float.NaN;
            float f4 = i5 < fArr2.length ? fArr2[i5] : Float.NaN;
            if (Float.isNaN(f4) || f3 < f4) {
                fArr3[i6] = f3;
                i4++;
            } else if (Float.isNaN(f3) || f4 < f3) {
                fArr3[i6] = f4;
                i5++;
            } else {
                fArr3[i6] = f3;
                i4++;
                i5++;
                i3++;
            }
        }
        return i3 == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i3);
    }

    int c(float f3, float f4, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f3 == fArr[0]) {
            return iArr[0];
        }
        for (int i3 = 1; i3 < fArr.length; i3++) {
            float f5 = fArr[i3];
            if (f5 >= f3 || i3 == fArr.length - 1) {
                int i4 = i3 - 1;
                float f6 = fArr[i4];
                float f7 = (f3 - f6) / (f5 - f6);
                int i5 = iArr[i3];
                int i6 = iArr[i4];
                return Color.argb((int) (f4 * 255.0f), AbstractC0460c.c(f7, Color.red(i6), Color.red(i5)), AbstractC0460c.c(f7, Color.green(i6), Color.green(i5)), AbstractC0460c.c(f7, Color.blue(i6), Color.blue(i5)));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    @Override // k1.N
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0375d a(l1.c cVar, float f3) {
        ArrayList arrayList = new ArrayList();
        boolean z3 = cVar.N() == c.b.BEGIN_ARRAY;
        if (z3) {
            cVar.b();
        }
        while (cVar.j()) {
            arrayList.add(Float.valueOf((float) cVar.p()));
        }
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.f12268a = 2;
        }
        if (z3) {
            cVar.g();
        }
        if (this.f12268a == -1) {
            this.f12268a = arrayList.size() / 4;
        }
        int i3 = this.f12268a;
        float[] fArr = new float[i3];
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.f12268a * 4; i6++) {
            int i7 = i6 / 4;
            double floatValue = ((Float) arrayList.get(i6)).floatValue();
            int i8 = i6 % 4;
            if (i8 == 0) {
                if (i7 > 0) {
                    float f4 = (float) floatValue;
                    if (fArr[i7 - 1] >= f4) {
                        fArr[i7] = f4 + 0.01f;
                    }
                }
                fArr[i7] = (float) floatValue;
            } else if (i8 == 1) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i8 == 2) {
                i5 = (int) (floatValue * 255.0d);
            } else if (i8 == 3) {
                iArr[i7] = Color.argb(255, i4, i5, (int) (floatValue * 255.0d));
            }
        }
        return b(new C0375d(fArr, iArr), arrayList);
    }
}
