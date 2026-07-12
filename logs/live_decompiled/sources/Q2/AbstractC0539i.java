package q2;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0539i {
    public static final Object[] a(Object[] objArr, int i3) {
        D2.k.e(objArr, "reference");
        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i3);
        D2.k.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }

    public static int b(Object[] objArr) {
        return Arrays.deepHashCode(objArr);
    }

    public static final void c(int i3, int i4) {
        if (i3 <= i4) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i4 + ").");
    }
}
