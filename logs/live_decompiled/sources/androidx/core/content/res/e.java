package androidx.core.content.res;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
abstract class e {
    public static int[] a(int[] iArr, int i3, int i4) {
        if (i3 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i3)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr = iArr2;
        }
        iArr[i3] = i4;
        return iArr;
    }

    public static Object[] b(Object[] objArr, int i3, Object obj) {
        if (i3 + 1 > objArr.length) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), c(i3));
            System.arraycopy(objArr, 0, objArr2, 0, i3);
            objArr = objArr2;
        }
        objArr[i3] = obj;
        return objArr;
    }

    public static int c(int i3) {
        if (i3 <= 4) {
            return 8;
        }
        return i3 * 2;
    }
}
