package m;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: m.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0452b implements Collection, Set {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f12329i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final Object[] f12330j = new Object[0];

    /* renamed from: k, reason: collision with root package name */
    private static Object[] f12331k;

    /* renamed from: l, reason: collision with root package name */
    private static int f12332l;

    /* renamed from: m, reason: collision with root package name */
    private static Object[] f12333m;

    /* renamed from: n, reason: collision with root package name */
    private static int f12334n;

    /* renamed from: e, reason: collision with root package name */
    private int[] f12335e;

    /* renamed from: f, reason: collision with root package name */
    Object[] f12336f;

    /* renamed from: g, reason: collision with root package name */
    int f12337g;

    /* renamed from: h, reason: collision with root package name */
    private AbstractC0456f f12338h;

    /* renamed from: m.b$a */
    class a extends AbstractC0456f {
        a() {
        }

        @Override // m.AbstractC0456f
        protected void a() {
            C0452b.this.clear();
        }

        @Override // m.AbstractC0456f
        protected Object b(int i3, int i4) {
            return C0452b.this.f12336f[i3];
        }

        @Override // m.AbstractC0456f
        protected Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // m.AbstractC0456f
        protected int d() {
            return C0452b.this.f12337g;
        }

        @Override // m.AbstractC0456f
        protected int e(Object obj) {
            return C0452b.this.indexOf(obj);
        }

        @Override // m.AbstractC0456f
        protected int f(Object obj) {
            return C0452b.this.indexOf(obj);
        }

        @Override // m.AbstractC0456f
        protected void g(Object obj, Object obj2) {
            C0452b.this.add(obj);
        }

        @Override // m.AbstractC0456f
        protected void h(int i3) {
            C0452b.this.g(i3);
        }

        @Override // m.AbstractC0456f
        protected Object i(int i3, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public C0452b() {
        this(0);
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (C0452b.class) {
                try {
                    Object[] objArr = f12333m;
                    if (objArr != null) {
                        this.f12336f = objArr;
                        f12333m = (Object[]) objArr[0];
                        this.f12335e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f12334n--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (C0452b.class) {
                try {
                    Object[] objArr2 = f12331k;
                    if (objArr2 != null) {
                        this.f12336f = objArr2;
                        f12331k = (Object[]) objArr2[0];
                        this.f12335e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f12332l--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f12335e = new int[i3];
        this.f12336f = new Object[i3];
    }

    private static void c(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (C0452b.class) {
                try {
                    if (f12334n < 10) {
                        objArr[0] = f12333m;
                        objArr[1] = iArr;
                        for (int i4 = i3 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f12333m = objArr;
                        f12334n++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0452b.class) {
                try {
                    if (f12332l < 10) {
                        objArr[0] = f12331k;
                        objArr[1] = iArr;
                        for (int i5 = i3 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f12331k = objArr;
                        f12332l++;
                    }
                } finally {
                }
            }
        }
    }

    private AbstractC0456f d() {
        if (this.f12338h == null) {
            this.f12338h = new a();
        }
        return this.f12338h;
    }

    private int e(Object obj, int i3) {
        int i4 = this.f12337g;
        if (i4 == 0) {
            return -1;
        }
        int a3 = AbstractC0453c.a(this.f12335e, i4, i3);
        if (a3 < 0 || obj.equals(this.f12336f[a3])) {
            return a3;
        }
        int i5 = a3 + 1;
        while (i5 < i4 && this.f12335e[i5] == i3) {
            if (obj.equals(this.f12336f[i5])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = a3 - 1; i6 >= 0 && this.f12335e[i6] == i3; i6--) {
            if (obj.equals(this.f12336f[i6])) {
                return i6;
            }
        }
        return ~i5;
    }

    private int f() {
        int i3 = this.f12337g;
        if (i3 == 0) {
            return -1;
        }
        int a3 = AbstractC0453c.a(this.f12335e, i3, 0);
        if (a3 < 0 || this.f12336f[a3] == null) {
            return a3;
        }
        int i4 = a3 + 1;
        while (i4 < i3 && this.f12335e[i4] == 0) {
            if (this.f12336f[i4] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a3 - 1; i5 >= 0 && this.f12335e[i5] == 0; i5--) {
            if (this.f12336f[i5] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i3;
        int e3;
        if (obj == null) {
            e3 = f();
            i3 = 0;
        } else {
            int hashCode = obj.hashCode();
            i3 = hashCode;
            e3 = e(obj, hashCode);
        }
        if (e3 >= 0) {
            return false;
        }
        int i4 = ~e3;
        int i5 = this.f12337g;
        int[] iArr = this.f12335e;
        if (i5 >= iArr.length) {
            int i6 = 8;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.f12336f;
            a(i6);
            int[] iArr2 = this.f12335e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f12336f, 0, objArr.length);
            }
            c(iArr, objArr, this.f12337g);
        }
        int i7 = this.f12337g;
        if (i4 < i7) {
            int[] iArr3 = this.f12335e;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f12336f;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f12337g - i4);
        }
        this.f12335e[i4] = i3;
        this.f12336f[i4] = obj;
        this.f12337g++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        b(this.f12337g + collection.size());
        Iterator it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= add(it.next());
        }
        return z3;
    }

    public void b(int i3) {
        int[] iArr = this.f12335e;
        if (iArr.length < i3) {
            Object[] objArr = this.f12336f;
            a(i3);
            int i4 = this.f12337g;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f12335e, 0, i4);
                System.arraycopy(objArr, 0, this.f12336f, 0, this.f12337g);
            }
            c(iArr, objArr, this.f12337g);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i3 = this.f12337g;
        if (i3 != 0) {
            c(this.f12335e, this.f12336f, i3);
            this.f12335e = f12329i;
            this.f12336f = f12330j;
            this.f12337g = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f12337g; i3++) {
                try {
                    if (!set.contains(h(i3))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public Object g(int i3) {
        Object[] objArr = this.f12336f;
        Object obj = objArr[i3];
        int i4 = this.f12337g;
        if (i4 <= 1) {
            c(this.f12335e, objArr, i4);
            this.f12335e = f12329i;
            this.f12336f = f12330j;
            this.f12337g = 0;
        } else {
            int[] iArr = this.f12335e;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                int i5 = i4 - 1;
                this.f12337g = i5;
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    System.arraycopy(iArr, i6, iArr, i3, i5 - i3);
                    Object[] objArr2 = this.f12336f;
                    System.arraycopy(objArr2, i6, objArr2, i3, this.f12337g - i3);
                }
                this.f12336f[this.f12337g] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                this.f12337g--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f12335e, 0, i3);
                    System.arraycopy(objArr, 0, this.f12336f, 0, i3);
                }
                int i7 = this.f12337g;
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    System.arraycopy(iArr, i8, this.f12335e, i3, i7 - i3);
                    System.arraycopy(objArr, i8, this.f12336f, i3, this.f12337g - i3);
                }
            }
        }
        return obj;
    }

    public Object h(int i3) {
        return this.f12336f[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f12335e;
        int i3 = this.f12337g;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12337g <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= remove(it.next());
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z3 = false;
        for (int i3 = this.f12337g - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f12336f[i3])) {
                g(i3);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f12337g;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i3 = this.f12337g;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f12336f, 0, objArr, 0, i3);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12337g * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.f12337g; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object h3 = h(i3);
            if (h3 != this) {
                sb.append(h3);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0452b(int i3) {
        if (i3 == 0) {
            this.f12335e = f12329i;
            this.f12336f = f12330j;
        } else {
            a(i3);
        }
        this.f12337g = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f12337g) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f12337g);
        }
        System.arraycopy(this.f12336f, 0, objArr, 0, this.f12337g);
        int length = objArr.length;
        int i3 = this.f12337g;
        if (length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
