package X0;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class c extends AbstractMap implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    private static final Comparator f2836m = new a();

    /* renamed from: e, reason: collision with root package name */
    private final Comparator f2837e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f2838f;

    /* renamed from: g, reason: collision with root package name */
    e f2839g;

    /* renamed from: h, reason: collision with root package name */
    int f2840h;

    /* renamed from: i, reason: collision with root package name */
    int f2841i;

    /* renamed from: j, reason: collision with root package name */
    final e f2842j;

    /* renamed from: k, reason: collision with root package name */
    private b f2843k;

    /* renamed from: l, reason: collision with root package name */
    private C0045c f2844l;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && c.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e c3;
            if (!(obj instanceof Map.Entry) || (c3 = c.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            c.this.f(c3, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.f2840h;
        }
    }

    /* renamed from: X0.c$c, reason: collision with other inner class name */
    final class C0045c extends AbstractSet {

        /* renamed from: X0.c$c$a */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f2858f;
            }
        }

        C0045c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return c.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return c.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.f2840h;
        }
    }

    private abstract class d implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        e f2849a;

        /* renamed from: b, reason: collision with root package name */
        e f2850b = null;

        /* renamed from: c, reason: collision with root package name */
        int f2851c;

        d() {
            this.f2849a = c.this.f2842j.f2856d;
            this.f2851c = c.this.f2841i;
        }

        final e a() {
            e eVar = this.f2849a;
            c cVar = c.this;
            if (eVar == cVar.f2842j) {
                throw new NoSuchElementException();
            }
            if (cVar.f2841i != this.f2851c) {
                throw new ConcurrentModificationException();
            }
            this.f2849a = eVar.f2856d;
            this.f2850b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f2849a != c.this.f2842j;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f2850b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            c.this.f(eVar, true);
            this.f2850b = null;
            this.f2851c = c.this.f2841i;
        }
    }

    public c(boolean z3) {
        this(f2836m, z3);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(e eVar, boolean z3) {
        while (eVar != null) {
            e eVar2 = eVar.f2854b;
            e eVar3 = eVar.f2855c;
            int i3 = eVar2 != null ? eVar2.f2861i : 0;
            int i4 = eVar3 != null ? eVar3.f2861i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                e eVar4 = eVar3.f2854b;
                e eVar5 = eVar3.f2855c;
                int i6 = (eVar4 != null ? eVar4.f2861i : 0) - (eVar5 != null ? eVar5.f2861i : 0);
                if (i6 == -1 || (i6 == 0 && !z3)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z3) {
                    return;
                }
            } else if (i5 == 2) {
                e eVar6 = eVar2.f2854b;
                e eVar7 = eVar2.f2855c;
                int i7 = (eVar6 != null ? eVar6.f2861i : 0) - (eVar7 != null ? eVar7.f2861i : 0);
                if (i7 == 1 || (i7 == 0 && !z3)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z3) {
                    return;
                }
            } else if (i5 == 0) {
                eVar.f2861i = i3 + 1;
                if (z3) {
                    return;
                }
            } else {
                eVar.f2861i = Math.max(i3, i4) + 1;
                if (!z3) {
                    return;
                }
            }
            eVar = eVar.f2853a;
        }
    }

    private void h(e eVar, e eVar2) {
        e eVar3 = eVar.f2853a;
        eVar.f2853a = null;
        if (eVar2 != null) {
            eVar2.f2853a = eVar3;
        }
        if (eVar3 == null) {
            this.f2839g = eVar2;
        } else if (eVar3.f2854b == eVar) {
            eVar3.f2854b = eVar2;
        } else {
            eVar3.f2855c = eVar2;
        }
    }

    private void i(e eVar) {
        e eVar2 = eVar.f2854b;
        e eVar3 = eVar.f2855c;
        e eVar4 = eVar3.f2854b;
        e eVar5 = eVar3.f2855c;
        eVar.f2855c = eVar4;
        if (eVar4 != null) {
            eVar4.f2853a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f2854b = eVar;
        eVar.f2853a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f2861i : 0, eVar4 != null ? eVar4.f2861i : 0) + 1;
        eVar.f2861i = max;
        eVar3.f2861i = Math.max(max, eVar5 != null ? eVar5.f2861i : 0) + 1;
    }

    private void j(e eVar) {
        e eVar2 = eVar.f2854b;
        e eVar3 = eVar.f2855c;
        e eVar4 = eVar2.f2854b;
        e eVar5 = eVar2.f2855c;
        eVar.f2854b = eVar5;
        if (eVar5 != null) {
            eVar5.f2853a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f2855c = eVar;
        eVar.f2853a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f2861i : 0, eVar5 != null ? eVar5.f2861i : 0) + 1;
        eVar.f2861i = max;
        eVar2.f2861i = Math.max(max, eVar4 != null ? eVar4.f2861i : 0) + 1;
    }

    e b(Object obj, boolean z3) {
        int i3;
        e eVar;
        Comparator comparator = this.f2837e;
        e eVar2 = this.f2839g;
        if (eVar2 != null) {
            Comparable comparable = comparator == f2836m ? (Comparable) obj : null;
            while (true) {
                i3 = comparable != null ? comparable.compareTo(eVar2.f2858f) : comparator.compare(obj, eVar2.f2858f);
                if (i3 == 0) {
                    return eVar2;
                }
                e eVar3 = i3 < 0 ? eVar2.f2854b : eVar2.f2855c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i3 = 0;
        }
        if (!z3) {
            return null;
        }
        e eVar4 = this.f2842j;
        if (eVar2 != null) {
            eVar = new e(this.f2838f, eVar2, obj, eVar4, eVar4.f2857e);
            if (i3 < 0) {
                eVar2.f2854b = eVar;
            } else {
                eVar2.f2855c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f2836m && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f2838f, eVar2, obj, eVar4, eVar4.f2857e);
            this.f2839g = eVar;
        }
        this.f2840h++;
        this.f2841i++;
        return eVar;
    }

    e c(Map.Entry entry) {
        e d3 = d(entry.getKey());
        if (d3 == null || !a(d3.f2860h, entry.getValue())) {
            return null;
        }
        return d3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f2839g = null;
        this.f2840h = 0;
        this.f2841i++;
        e eVar = this.f2842j;
        eVar.f2857e = eVar;
        eVar.f2856d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    e d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f2843k;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f2843k = bVar2;
        return bVar2;
    }

    void f(e eVar, boolean z3) {
        int i3;
        if (z3) {
            e eVar2 = eVar.f2857e;
            eVar2.f2856d = eVar.f2856d;
            eVar.f2856d.f2857e = eVar2;
        }
        e eVar3 = eVar.f2854b;
        e eVar4 = eVar.f2855c;
        e eVar5 = eVar.f2853a;
        int i4 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f2854b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f2855c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f2840h--;
            this.f2841i++;
            return;
        }
        e b3 = eVar3.f2861i > eVar4.f2861i ? eVar3.b() : eVar4.a();
        f(b3, false);
        e eVar6 = eVar.f2854b;
        if (eVar6 != null) {
            i3 = eVar6.f2861i;
            b3.f2854b = eVar6;
            eVar6.f2853a = b3;
            eVar.f2854b = null;
        } else {
            i3 = 0;
        }
        e eVar7 = eVar.f2855c;
        if (eVar7 != null) {
            i4 = eVar7.f2861i;
            b3.f2855c = eVar7;
            eVar7.f2853a = b3;
            eVar.f2855c = null;
        }
        b3.f2861i = Math.max(i3, i4) + 1;
        h(eVar, b3);
    }

    e g(Object obj) {
        e d3 = d(obj);
        if (d3 != null) {
            f(d3, true);
        }
        return d3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e d3 = d(obj);
        if (d3 != null) {
            return d3.f2860h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        C0045c c0045c = this.f2844l;
        if (c0045c != null) {
            return c0045c;
        }
        C0045c c0045c2 = new C0045c();
        this.f2844l = c0045c2;
        return c0045c2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f2838f) {
            throw new NullPointerException("value == null");
        }
        e b3 = b(obj, true);
        Object obj3 = b3.f2860h;
        b3.f2860h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e g3 = g(obj);
        if (g3 != null) {
            return g3.f2860h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2840h;
    }

    public c(Comparator comparator, boolean z3) {
        this.f2840h = 0;
        this.f2841i = 0;
        this.f2837e = comparator == null ? f2836m : comparator;
        this.f2838f = z3;
        this.f2842j = new e(z3);
    }

    static final class e implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        e f2853a;

        /* renamed from: b, reason: collision with root package name */
        e f2854b;

        /* renamed from: c, reason: collision with root package name */
        e f2855c;

        /* renamed from: d, reason: collision with root package name */
        e f2856d;

        /* renamed from: e, reason: collision with root package name */
        e f2857e;

        /* renamed from: f, reason: collision with root package name */
        final Object f2858f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f2859g;

        /* renamed from: h, reason: collision with root package name */
        Object f2860h;

        /* renamed from: i, reason: collision with root package name */
        int f2861i;

        e(boolean z3) {
            this.f2858f = null;
            this.f2859g = z3;
            this.f2857e = this;
            this.f2856d = this;
        }

        public e a() {
            e eVar = this.f2854b;
            while (true) {
                e eVar2 = eVar;
                e eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f2854b;
            }
        }

        public e b() {
            e eVar = this.f2855c;
            while (true) {
                e eVar2 = eVar;
                e eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f2855c;
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f2858f;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.f2860h;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f2858f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f2860h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f2858f;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f2860h;
            return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f2859g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f2860h;
            this.f2860h = obj;
            return obj2;
        }

        public String toString() {
            return this.f2858f + "=" + this.f2860h;
        }

        e(boolean z3, e eVar, Object obj, e eVar2, e eVar3) {
            this.f2853a = eVar;
            this.f2858f = obj;
            this.f2859g = z3;
            this.f2861i = 1;
            this.f2856d = eVar2;
            this.f2857e = eVar3;
            eVar3.f2856d = this;
            eVar2.f2857e = this;
        }
    }
}
