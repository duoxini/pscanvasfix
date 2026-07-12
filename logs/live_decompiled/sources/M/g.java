package m;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    static Object[] f12371h;

    /* renamed from: i, reason: collision with root package name */
    static int f12372i;

    /* renamed from: j, reason: collision with root package name */
    static Object[] f12373j;

    /* renamed from: k, reason: collision with root package name */
    static int f12374k;

    /* renamed from: e, reason: collision with root package name */
    int[] f12375e;

    /* renamed from: f, reason: collision with root package name */
    Object[] f12376f;

    /* renamed from: g, reason: collision with root package name */
    int f12377g;

    public g() {
        this.f12375e = AbstractC0453c.f12340a;
        this.f12376f = AbstractC0453c.f12342c;
        this.f12377g = 0;
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (g.class) {
                try {
                    Object[] objArr = f12373j;
                    if (objArr != null) {
                        this.f12376f = objArr;
                        f12373j = (Object[]) objArr[0];
                        this.f12375e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f12374k--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (g.class) {
                try {
                    Object[] objArr2 = f12371h;
                    if (objArr2 != null) {
                        this.f12376f = objArr2;
                        f12371h = (Object[]) objArr2[0];
                        this.f12375e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f12372i--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f12375e = new int[i3];
        this.f12376f = new Object[i3 << 1];
    }

    private static int b(int[] iArr, int i3, int i4) {
        try {
            return AbstractC0453c.a(iArr, i3, i4);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                try {
                    if (f12374k < 10) {
                        objArr[0] = f12373j;
                        objArr[1] = iArr;
                        for (int i4 = (i3 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f12373j = objArr;
                        f12374k++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                try {
                    if (f12372i < 10) {
                        objArr[0] = f12371h;
                        objArr[1] = iArr;
                        for (int i5 = (i3 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f12371h = objArr;
                        f12372i++;
                    }
                } finally {
                }
            }
        }
    }

    public void c(int i3) {
        int i4 = this.f12377g;
        int[] iArr = this.f12375e;
        if (iArr.length < i3) {
            Object[] objArr = this.f12376f;
            a(i3);
            if (this.f12377g > 0) {
                System.arraycopy(iArr, 0, this.f12375e, 0, i4);
                System.arraycopy(objArr, 0, this.f12376f, 0, i4 << 1);
            }
            d(iArr, objArr, i4);
        }
        if (this.f12377g != i4) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i3 = this.f12377g;
        if (i3 > 0) {
            int[] iArr = this.f12375e;
            Object[] objArr = this.f12376f;
            this.f12375e = AbstractC0453c.f12340a;
            this.f12376f = AbstractC0453c.f12342c;
            this.f12377g = 0;
            d(iArr, objArr, i3);
        }
        if (this.f12377g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i3) {
        int i4 = this.f12377g;
        if (i4 == 0) {
            return -1;
        }
        int b3 = b(this.f12375e, i4, i3);
        if (b3 < 0 || obj.equals(this.f12376f[b3 << 1])) {
            return b3;
        }
        int i5 = b3 + 1;
        while (i5 < i4 && this.f12375e[i5] == i3) {
            if (obj.equals(this.f12376f[i5 << 1])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = b3 - 1; i6 >= 0 && this.f12375e[i6] == i3; i6--) {
            if (obj.equals(this.f12376f[i6 << 1])) {
                return i6;
            }
        }
        return ~i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f12377g; i3++) {
                try {
                    Object i4 = i(i3);
                    Object m3 = m(i3);
                    Object obj2 = gVar.get(i4);
                    if (m3 == null) {
                        if (obj2 != null || !gVar.containsKey(i4)) {
                            return false;
                        }
                    } else if (!m3.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f12377g; i5++) {
                try {
                    Object i6 = i(i5);
                    Object m4 = m(i5);
                    Object obj3 = map.get(i6);
                    if (m4 == null) {
                        if (obj3 != null || !map.containsKey(i6)) {
                            return false;
                        }
                    } else if (!m4.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i3 = this.f12377g;
        if (i3 == 0) {
            return -1;
        }
        int b3 = b(this.f12375e, i3, 0);
        if (b3 < 0 || this.f12376f[b3 << 1] == null) {
            return b3;
        }
        int i4 = b3 + 1;
        while (i4 < i3 && this.f12375e[i4] == 0) {
            if (this.f12376f[i4 << 1] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = b3 - 1; i5 >= 0 && this.f12375e[i5] == 0; i5--) {
            if (this.f12376f[i5 << 1] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int f3 = f(obj);
        return f3 >= 0 ? this.f12376f[(f3 << 1) + 1] : obj2;
    }

    int h(Object obj) {
        int i3 = this.f12377g * 2;
        Object[] objArr = this.f12376f;
        if (obj == null) {
            for (int i4 = 1; i4 < i3; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i3; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f12375e;
        Object[] objArr = this.f12376f;
        int i3 = this.f12377g;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            i6 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return i6;
    }

    public Object i(int i3) {
        return this.f12376f[i3 << 1];
    }

    public boolean isEmpty() {
        return this.f12377g <= 0;
    }

    public void j(g gVar) {
        int i3 = gVar.f12377g;
        c(this.f12377g + i3);
        if (this.f12377g != 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                put(gVar.i(i4), gVar.m(i4));
            }
        } else if (i3 > 0) {
            System.arraycopy(gVar.f12375e, 0, this.f12375e, 0, i3);
            System.arraycopy(gVar.f12376f, 0, this.f12376f, 0, i3 << 1);
            this.f12377g = i3;
        }
    }

    public Object k(int i3) {
        Object[] objArr = this.f12376f;
        int i4 = i3 << 1;
        Object obj = objArr[i4 + 1];
        int i5 = this.f12377g;
        int i6 = 0;
        if (i5 <= 1) {
            d(this.f12375e, objArr, i5);
            this.f12375e = AbstractC0453c.f12340a;
            this.f12376f = AbstractC0453c.f12342c;
        } else {
            int i7 = i5 - 1;
            int[] iArr = this.f12375e;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    int i9 = i7 - i3;
                    System.arraycopy(iArr, i8, iArr, i3, i9);
                    Object[] objArr2 = this.f12376f;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i4, i9 << 1);
                }
                Object[] objArr3 = this.f12376f;
                int i10 = i7 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i5 != this.f12377g) {
                    throw new ConcurrentModificationException();
                }
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f12375e, 0, i3);
                    System.arraycopy(objArr, 0, this.f12376f, 0, i4);
                }
                if (i3 < i7) {
                    int i11 = i3 + 1;
                    int i12 = i7 - i3;
                    System.arraycopy(iArr, i11, this.f12375e, i3, i12);
                    System.arraycopy(objArr, i11 << 1, this.f12376f, i4, i12 << 1);
                }
            }
            i6 = i7;
        }
        if (i5 != this.f12377g) {
            throw new ConcurrentModificationException();
        }
        this.f12377g = i6;
        return obj;
    }

    public Object l(int i3, Object obj) {
        int i4 = (i3 << 1) + 1;
        Object[] objArr = this.f12376f;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    public Object m(int i3) {
        return this.f12376f[(i3 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i3;
        int e3;
        int i4 = this.f12377g;
        if (obj == null) {
            e3 = g();
            i3 = 0;
        } else {
            int hashCode = obj.hashCode();
            i3 = hashCode;
            e3 = e(obj, hashCode);
        }
        if (e3 >= 0) {
            int i5 = (e3 << 1) + 1;
            Object[] objArr = this.f12376f;
            Object obj3 = objArr[i5];
            objArr[i5] = obj2;
            return obj3;
        }
        int i6 = ~e3;
        int[] iArr = this.f12375e;
        if (i4 >= iArr.length) {
            int i7 = 8;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i7 = 4;
            }
            Object[] objArr2 = this.f12376f;
            a(i7);
            if (i4 != this.f12377g) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f12375e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f12376f, 0, objArr2.length);
            }
            d(iArr, objArr2, i4);
        }
        if (i6 < i4) {
            int[] iArr3 = this.f12375e;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f12376f;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f12377g - i6) << 1);
        }
        int i9 = this.f12377g;
        if (i4 == i9) {
            int[] iArr4 = this.f12375e;
            if (i6 < iArr4.length) {
                iArr4[i6] = i3;
                Object[] objArr4 = this.f12376f;
                int i10 = i6 << 1;
                objArr4[i10] = obj;
                objArr4[i10 + 1] = obj2;
                this.f12377g = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int f3 = f(obj);
        if (f3 >= 0) {
            return k(f3);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int f3 = f(obj);
        if (f3 >= 0) {
            return l(f3, obj2);
        }
        return null;
    }

    public int size() {
        return this.f12377g;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12377g * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f12377g; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object i4 = i(i3);
            if (i4 != this) {
                sb.append(i4);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object m3 = m(i3);
            if (m3 != this) {
                sb.append(m3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int f3 = f(obj);
        if (f3 < 0) {
            return false;
        }
        Object m3 = m(f3);
        if (obj2 != m3 && (obj2 == null || !obj2.equals(m3))) {
            return false;
        }
        k(f3);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int f3 = f(obj);
        if (f3 < 0) {
            return false;
        }
        Object m3 = m(f3);
        if (m3 != obj2 && (obj2 == null || !obj2.equals(m3))) {
            return false;
        }
        l(f3, obj3);
        return true;
    }

    public g(g gVar) {
        this();
        if (gVar != null) {
            j(gVar);
        }
    }
}
