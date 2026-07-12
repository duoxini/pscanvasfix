package r2;

import D2.k;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import q2.AbstractC0520C;
import q2.AbstractC0532b;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
public final class d implements Map, Serializable {

    /* renamed from: r, reason: collision with root package name */
    public static final a f13253r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    private static final d f13254s;

    /* renamed from: e, reason: collision with root package name */
    private Object[] f13255e;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f13256f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f13257g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f13258h;

    /* renamed from: i, reason: collision with root package name */
    private int f13259i;

    /* renamed from: j, reason: collision with root package name */
    private int f13260j;

    /* renamed from: k, reason: collision with root package name */
    private int f13261k;

    /* renamed from: l, reason: collision with root package name */
    private int f13262l;

    /* renamed from: m, reason: collision with root package name */
    private int f13263m;

    /* renamed from: n, reason: collision with root package name */
    private r2.f f13264n;

    /* renamed from: o, reason: collision with root package name */
    private g f13265o;

    /* renamed from: p, reason: collision with root package name */
    private r2.e f13266p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13267q;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i3) {
            return Integer.highestOneBit(H2.d.b(i3, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i3) {
            return Integer.numberOfLeadingZeros(i3) + 1;
        }

        public final d e() {
            return d.f13254s;
        }

        private a() {
        }
    }

    public static final class b extends C0147d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            k.e(dVar, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public c next() {
            a();
            if (b() >= d().f13260j) {
                throw new NoSuchElementException();
            }
            int b3 = b();
            f(b3 + 1);
            g(b3);
            c cVar = new c(d(), c());
            e();
            return cVar;
        }

        public final void i(StringBuilder sb) {
            k.e(sb, "sb");
            if (b() >= d().f13260j) {
                throw new NoSuchElementException();
            }
            int b3 = b();
            f(b3 + 1);
            g(b3);
            Object obj = d().f13255e[c()];
            if (obj == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = d().f13256f;
            k.b(objArr);
            Object obj2 = objArr[c()];
            if (obj2 == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int j() {
            if (b() >= d().f13260j) {
                throw new NoSuchElementException();
            }
            int b3 = b();
            f(b3 + 1);
            g(b3);
            Object obj = d().f13255e[c()];
            int hashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = d().f13256f;
            k.b(objArr);
            Object obj2 = objArr[c()];
            int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return hashCode2;
        }
    }

    public static final class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        private final d f13268a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13269b;

        public c(d dVar, int i3) {
            k.e(dVar, "map");
            this.f13268a = dVar;
            this.f13269b = i3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (k.a(entry.getKey(), getKey()) && k.a(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f13268a.f13255e[this.f13269b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object[] objArr = this.f13268a.f13256f;
            k.b(objArr);
            return objArr[this.f13269b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            this.f13268a.l();
            Object[] j3 = this.f13268a.j();
            int i3 = this.f13269b;
            Object obj2 = j3[i3];
            j3[i3] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: r2.d$d, reason: collision with other inner class name */
    public static class C0147d {

        /* renamed from: a, reason: collision with root package name */
        private final d f13270a;

        /* renamed from: b, reason: collision with root package name */
        private int f13271b;

        /* renamed from: c, reason: collision with root package name */
        private int f13272c;

        /* renamed from: d, reason: collision with root package name */
        private int f13273d;

        public C0147d(d dVar) {
            k.e(dVar, "map");
            this.f13270a = dVar;
            this.f13272c = -1;
            this.f13273d = dVar.f13262l;
            e();
        }

        public final void a() {
            if (this.f13270a.f13262l != this.f13273d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.f13271b;
        }

        public final int c() {
            return this.f13272c;
        }

        public final d d() {
            return this.f13270a;
        }

        public final void e() {
            while (this.f13271b < this.f13270a.f13260j) {
                int[] iArr = this.f13270a.f13257g;
                int i3 = this.f13271b;
                if (iArr[i3] >= 0) {
                    return;
                } else {
                    this.f13271b = i3 + 1;
                }
            }
        }

        public final void f(int i3) {
            this.f13271b = i3;
        }

        public final void g(int i3) {
            this.f13272c = i3;
        }

        public final boolean hasNext() {
            return this.f13271b < this.f13270a.f13260j;
        }

        public final void remove() {
            a();
            if (this.f13272c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.f13270a.l();
            this.f13270a.L(this.f13272c);
            this.f13272c = -1;
            this.f13273d = this.f13270a.f13262l;
        }
    }

    public static final class e extends C0147d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(dVar);
            k.e(dVar, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().f13260j) {
                throw new NoSuchElementException();
            }
            int b3 = b();
            f(b3 + 1);
            g(b3);
            Object obj = d().f13255e[c()];
            e();
            return obj;
        }
    }

    public static final class f extends C0147d implements Iterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(dVar);
            k.e(dVar, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().f13260j) {
                throw new NoSuchElementException();
            }
            int b3 = b();
            f(b3 + 1);
            g(b3);
            Object[] objArr = d().f13256f;
            k.b(objArr);
            Object obj = objArr[c()];
            e();
            return obj;
        }
    }

    static {
        d dVar = new d(0);
        dVar.f13267q = true;
        f13254s = dVar;
    }

    private d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i3, int i4) {
        this.f13255e = objArr;
        this.f13256f = objArr2;
        this.f13257g = iArr;
        this.f13258h = iArr2;
        this.f13259i = i3;
        this.f13260j = i4;
        this.f13261k = f13253r.d(x());
    }

    private final int B(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f13261k;
    }

    private final boolean D(Collection collection) {
        boolean z3 = false;
        if (collection.isEmpty()) {
            return false;
        }
        r(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (E((Map.Entry) it.next())) {
                z3 = true;
            }
        }
        return z3;
    }

    private final boolean E(Map.Entry entry) {
        int i3 = i(entry.getKey());
        Object[] j3 = j();
        if (i3 >= 0) {
            j3[i3] = entry.getValue();
            return true;
        }
        int i4 = (-i3) - 1;
        if (k.a(entry.getValue(), j3[i4])) {
            return false;
        }
        j3[i4] = entry.getValue();
        return true;
    }

    private final boolean F(int i3) {
        int B3 = B(this.f13255e[i3]);
        int i4 = this.f13259i;
        while (true) {
            int[] iArr = this.f13258h;
            if (iArr[B3] == 0) {
                iArr[B3] = i3 + 1;
                this.f13257g[i3] = B3;
                return true;
            }
            i4--;
            if (i4 < 0) {
                return false;
            }
            B3 = B3 == 0 ? x() - 1 : B3 - 1;
        }
    }

    private final void G() {
        this.f13262l++;
    }

    private final void H(int i3) {
        G();
        if (this.f13260j > size()) {
            m();
        }
        int i4 = 0;
        if (i3 != x()) {
            this.f13258h = new int[i3];
            this.f13261k = f13253r.d(i3);
        } else {
            AbstractC0538h.m(this.f13258h, 0, 0, x());
        }
        while (i4 < this.f13260j) {
            int i5 = i4 + 1;
            if (!F(i4)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i4 = i5;
        }
    }

    private final void J(int i3) {
        int c3 = H2.d.c(this.f13259i * 2, x() / 2);
        int i4 = 0;
        int i5 = i3;
        do {
            i3 = i3 == 0 ? x() - 1 : i3 - 1;
            i4++;
            if (i4 > this.f13259i) {
                this.f13258h[i5] = 0;
                return;
            }
            int[] iArr = this.f13258h;
            int i6 = iArr[i3];
            if (i6 == 0) {
                iArr[i5] = 0;
                return;
            }
            if (i6 < 0) {
                iArr[i5] = -1;
            } else {
                int i7 = i6 - 1;
                if (((B(this.f13255e[i7]) - i3) & (x() - 1)) >= i4) {
                    this.f13258h[i5] = i6;
                    this.f13257g[i7] = i5;
                }
                c3--;
            }
            i5 = i3;
            i4 = 0;
            c3--;
        } while (c3 >= 0);
        this.f13258h[i5] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int i3) {
        r2.c.f(this.f13255e, i3);
        J(this.f13257g[i3]);
        this.f13257g[i3] = -1;
        this.f13263m = size() - 1;
        G();
    }

    private final boolean N(int i3) {
        int v3 = v();
        int i4 = this.f13260j;
        int i5 = v3 - i4;
        int size = i4 - size();
        return i5 < i3 && i5 + size >= i3 && size >= v() / 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] j() {
        Object[] objArr = this.f13256f;
        if (objArr != null) {
            return objArr;
        }
        Object[] d3 = r2.c.d(v());
        this.f13256f = d3;
        return d3;
    }

    private final void m() {
        int i3;
        Object[] objArr = this.f13256f;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = this.f13260j;
            if (i4 >= i3) {
                break;
            }
            if (this.f13257g[i4] >= 0) {
                Object[] objArr2 = this.f13255e;
                objArr2[i5] = objArr2[i4];
                if (objArr != null) {
                    objArr[i5] = objArr[i4];
                }
                i5++;
            }
            i4++;
        }
        r2.c.g(this.f13255e, i5, i3);
        if (objArr != null) {
            r2.c.g(objArr, i5, this.f13260j);
        }
        this.f13260j = i5;
    }

    private final boolean p(Map map) {
        return size() == map.size() && n(map.entrySet());
    }

    private final void q(int i3) {
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        if (i3 > v()) {
            int d3 = AbstractC0532b.f13035e.d(v(), i3);
            this.f13255e = r2.c.e(this.f13255e, d3);
            Object[] objArr = this.f13256f;
            this.f13256f = objArr != null ? r2.c.e(objArr, d3) : null;
            int[] copyOf = Arrays.copyOf(this.f13257g, d3);
            k.d(copyOf, "copyOf(...)");
            this.f13257g = copyOf;
            int c3 = f13253r.c(d3);
            if (c3 > x()) {
                H(c3);
            }
        }
    }

    private final void r(int i3) {
        if (N(i3)) {
            H(x());
        } else {
            q(this.f13260j + i3);
        }
    }

    private final int t(Object obj) {
        int B3 = B(obj);
        int i3 = this.f13259i;
        while (true) {
            int i4 = this.f13258h[B3];
            if (i4 == 0) {
                return -1;
            }
            if (i4 > 0) {
                int i5 = i4 - 1;
                if (k.a(this.f13255e[i5], obj)) {
                    return i5;
                }
            }
            i3--;
            if (i3 < 0) {
                return -1;
            }
            B3 = B3 == 0 ? x() - 1 : B3 - 1;
        }
    }

    private final int u(Object obj) {
        int i3 = this.f13260j;
        while (true) {
            i3--;
            if (i3 < 0) {
                return -1;
            }
            if (this.f13257g[i3] >= 0) {
                Object[] objArr = this.f13256f;
                k.b(objArr);
                if (k.a(objArr[i3], obj)) {
                    return i3;
                }
            }
        }
    }

    private final int x() {
        return this.f13258h.length;
    }

    public Collection A() {
        g gVar = this.f13265o;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f13265o = gVar2;
        return gVar2;
    }

    public final e C() {
        return new e(this);
    }

    public final boolean I(Map.Entry entry) {
        k.e(entry, "entry");
        l();
        int t3 = t(entry.getKey());
        if (t3 < 0) {
            return false;
        }
        Object[] objArr = this.f13256f;
        k.b(objArr);
        if (!k.a(objArr[t3], entry.getValue())) {
            return false;
        }
        L(t3);
        return true;
    }

    public final int K(Object obj) {
        l();
        int t3 = t(obj);
        if (t3 < 0) {
            return -1;
        }
        L(t3);
        return t3;
    }

    public final boolean M(Object obj) {
        l();
        int u3 = u(obj);
        if (u3 < 0) {
            return false;
        }
        L(u3);
        return true;
    }

    public final f O() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        l();
        AbstractC0520C it = new H2.c(0, this.f13260j - 1).iterator();
        while (it.hasNext()) {
            int a3 = it.a();
            int[] iArr = this.f13257g;
            int i3 = iArr[a3];
            if (i3 >= 0) {
                this.f13258h[i3] = 0;
                iArr[a3] = -1;
            }
        }
        r2.c.g(this.f13255e, 0, this.f13260j);
        Object[] objArr = this.f13256f;
        if (objArr != null) {
            r2.c.g(objArr, 0, this.f13260j);
        }
        this.f13263m = 0;
        this.f13260j = 0;
        G();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return t(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return u(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return w();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && p((Map) obj));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int t3 = t(obj);
        if (t3 < 0) {
            return null;
        }
        Object[] objArr = this.f13256f;
        k.b(objArr);
        return objArr[t3];
    }

    @Override // java.util.Map
    public int hashCode() {
        b s3 = s();
        int i3 = 0;
        while (s3.hasNext()) {
            i3 += s3.j();
        }
        return i3;
    }

    public final int i(Object obj) {
        l();
        while (true) {
            int B3 = B(obj);
            int c3 = H2.d.c(this.f13259i * 2, x() / 2);
            int i3 = 0;
            while (true) {
                int i4 = this.f13258h[B3];
                if (i4 <= 0) {
                    if (this.f13260j < v()) {
                        int i5 = this.f13260j;
                        int i6 = i5 + 1;
                        this.f13260j = i6;
                        this.f13255e[i5] = obj;
                        this.f13257g[i5] = B3;
                        this.f13258h[B3] = i6;
                        this.f13263m = size() + 1;
                        G();
                        if (i3 > this.f13259i) {
                            this.f13259i = i3;
                        }
                        return i5;
                    }
                    r(1);
                } else {
                    if (k.a(this.f13255e[i4 - 1], obj)) {
                        return -i4;
                    }
                    i3++;
                    if (i3 > c3) {
                        H(x() * 2);
                        break;
                    }
                    B3 = B3 == 0 ? x() - 1 : B3 - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map k() {
        l();
        this.f13267q = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f13254s;
        k.c(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return y();
    }

    public final void l() {
        if (this.f13267q) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean n(Collection collection) {
        k.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!o((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean o(Map.Entry entry) {
        k.e(entry, "entry");
        int t3 = t(entry.getKey());
        if (t3 < 0) {
            return false;
        }
        Object[] objArr = this.f13256f;
        k.b(objArr);
        return k.a(objArr[t3], entry.getValue());
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        l();
        int i3 = i(obj);
        Object[] j3 = j();
        if (i3 >= 0) {
            j3[i3] = obj2;
            return null;
        }
        int i4 = (-i3) - 1;
        Object obj3 = j3[i4];
        j3[i4] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        k.e(map, "from");
        l();
        D(map.entrySet());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        int K3 = K(obj);
        if (K3 < 0) {
            return null;
        }
        Object[] objArr = this.f13256f;
        k.b(objArr);
        Object obj2 = objArr[K3];
        r2.c.f(objArr, K3);
        return obj2;
    }

    public final b s() {
        return new b(this);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return z();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b s3 = s();
        int i3 = 0;
        while (s3.hasNext()) {
            if (i3 > 0) {
                sb.append(", ");
            }
            s3.i(sb);
            i3++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        k.d(sb2, "toString(...)");
        return sb2;
    }

    public final int v() {
        return this.f13255e.length;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return A();
    }

    public Set w() {
        r2.e eVar = this.f13266p;
        if (eVar != null) {
            return eVar;
        }
        r2.e eVar2 = new r2.e(this);
        this.f13266p = eVar2;
        return eVar2;
    }

    public Set y() {
        r2.f fVar = this.f13264n;
        if (fVar != null) {
            return fVar;
        }
        r2.f fVar2 = new r2.f(this);
        this.f13264n = fVar2;
        return fVar2;
    }

    public int z() {
        return this.f13263m;
    }

    public d() {
        this(8);
    }

    public d(int i3) {
        this(r2.c.d(i3), null, new int[i3], new int[f13253r.c(i3)], 2, 0);
    }
}
