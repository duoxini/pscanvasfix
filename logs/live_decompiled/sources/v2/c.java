package V2;

import D2.k;
import U2.o;

/* loaded from: classes.dex */
public abstract class c {
    public static final int a(int[] iArr, int i3, int i4, int i5) {
        k.e(iArr, "<this>");
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int i8 = iArr[i7];
            if (i8 < i3) {
                i4 = i7 + 1;
            } else {
                if (i8 <= i3) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return (-i4) - 1;
    }

    public static final int b(o oVar, int i3) {
        k.e(oVar, "<this>");
        int a3 = a(oVar.r(), i3 + 1, 0, oVar.s().length);
        return a3 >= 0 ? a3 : ~a3;
    }
}
