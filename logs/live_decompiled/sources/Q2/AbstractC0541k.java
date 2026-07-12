package q2;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0541k extends AbstractC0540j {

    /* renamed from: q2.k$a */
    public static final class a extends AbstractC0532b implements RandomAccess {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int[] f13049f;

        a(int[] iArr) {
            this.f13049f = iArr;
        }

        @Override // q2.AbstractC0531a
        public int a() {
            return this.f13049f.length;
        }

        public boolean b(int i3) {
            return AbstractC0542l.p(this.f13049f, i3);
        }

        @Override // q2.AbstractC0532b, java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(int i3) {
            return Integer.valueOf(this.f13049f[i3]);
        }

        @Override // q2.AbstractC0531a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return b(((Number) obj).intValue());
            }
            return false;
        }

        public int d(int i3) {
            return AbstractC0542l.x(this.f13049f, i3);
        }

        public int e(int i3) {
            return AbstractC0542l.C(this.f13049f, i3);
        }

        @Override // q2.AbstractC0532b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return d(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // q2.AbstractC0531a, java.util.Collection
        public boolean isEmpty() {
            return this.f13049f.length == 0;
        }

        @Override // q2.AbstractC0532b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return e(((Number) obj).intValue());
            }
            return -1;
        }
    }

    public static List e(int[] iArr) {
        D2.k.e(iArr, "<this>");
        return new a(iArr);
    }

    public static List f(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        List a3 = AbstractC0543m.a(objArr);
        D2.k.d(a3, "asList(...)");
        return a3;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        D2.k.e(bArr, "<this>");
        D2.k.e(bArr2, "destination");
        System.arraycopy(bArr, i4, bArr2, i3, i5 - i4);
        return bArr2;
    }

    public static Object[] h(Object[] objArr, Object[] objArr2, int i3, int i4, int i5) {
        D2.k.e(objArr, "<this>");
        D2.k.e(objArr2, "destination");
        System.arraycopy(objArr, i4, objArr2, i3, i5 - i4);
        return objArr2;
    }

    public static /* synthetic */ byte[] i(byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = bArr.length;
        }
        return AbstractC0538h.g(bArr, bArr2, i3, i4, i5);
    }

    public static /* synthetic */ Object[] j(Object[] objArr, Object[] objArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = objArr.length;
        }
        return AbstractC0538h.h(objArr, objArr2, i3, i4, i5);
    }

    public static byte[] k(byte[] bArr, int i3, int i4) {
        D2.k.e(bArr, "<this>");
        AbstractC0539i.c(i4, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i3, i4);
        D2.k.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] l(Object[] objArr, int i3, int i4) {
        D2.k.e(objArr, "<this>");
        AbstractC0539i.c(i4, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i3, i4);
        D2.k.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static void m(int[] iArr, int i3, int i4, int i5) {
        D2.k.e(iArr, "<this>");
        Arrays.fill(iArr, i4, i5, i3);
    }

    public static final void n(Object[] objArr, Object obj, int i3, int i4) {
        D2.k.e(objArr, "<this>");
        Arrays.fill(objArr, i3, i4, obj);
    }

    public static final void o(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }
}
