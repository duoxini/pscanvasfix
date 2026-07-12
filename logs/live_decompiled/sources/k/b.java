package k;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b implements Iterable {

    /* renamed from: e, reason: collision with root package name */
    c f12190e;

    /* renamed from: f, reason: collision with root package name */
    private c f12191f;

    /* renamed from: g, reason: collision with root package name */
    private WeakHashMap f12192g = new WeakHashMap();

    /* renamed from: h, reason: collision with root package name */
    private int f12193h = 0;

    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f12197d;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f12196c;
        }
    }

    /* renamed from: k.b$b, reason: collision with other inner class name */
    private static class C0135b extends e {
        C0135b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.b.e
        c b(c cVar) {
            return cVar.f12196c;
        }

        @Override // k.b.e
        c c(c cVar) {
            return cVar.f12197d;
        }
    }

    static class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        final Object f12194a;

        /* renamed from: b, reason: collision with root package name */
        final Object f12195b;

        /* renamed from: c, reason: collision with root package name */
        c f12196c;

        /* renamed from: d, reason: collision with root package name */
        c f12197d;

        c(Object obj, Object obj2) {
            this.f12194a = obj;
            this.f12195b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f12194a.equals(cVar.f12194a) && this.f12195b.equals(cVar.f12195b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f12194a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f12195b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f12195b.hashCode() ^ this.f12194a.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f12194a + "=" + this.f12195b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class d implements Iterator, f {

        /* renamed from: a, reason: collision with root package name */
        private c f12198a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12199b = true;

        d() {
        }

        @Override // k.b.f
        public void a(c cVar) {
            c cVar2 = this.f12198a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f12197d;
                this.f12198a = cVar3;
                this.f12199b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f12199b) {
                this.f12199b = false;
                this.f12198a = b.this.f12190e;
            } else {
                c cVar = this.f12198a;
                this.f12198a = cVar != null ? cVar.f12196c : null;
            }
            return this.f12198a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12199b) {
                return b.this.f12190e != null;
            }
            c cVar = this.f12198a;
            return (cVar == null || cVar.f12196c == null) ? false : true;
        }
    }

    private static abstract class e implements Iterator, f {

        /* renamed from: a, reason: collision with root package name */
        c f12201a;

        /* renamed from: b, reason: collision with root package name */
        c f12202b;

        e(c cVar, c cVar2) {
            this.f12201a = cVar2;
            this.f12202b = cVar;
        }

        private c e() {
            c cVar = this.f12202b;
            c cVar2 = this.f12201a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // k.b.f
        public void a(c cVar) {
            if (this.f12201a == cVar && cVar == this.f12202b) {
                this.f12202b = null;
                this.f12201a = null;
            }
            c cVar2 = this.f12201a;
            if (cVar2 == cVar) {
                this.f12201a = b(cVar2);
            }
            if (this.f12202b == cVar) {
                this.f12202b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f12202b;
            this.f12202b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12202b != null;
        }
    }

    interface f {
        void a(c cVar);
    }

    public Iterator a() {
        C0135b c0135b = new C0135b(this.f12191f, this.f12190e);
        this.f12192g.put(c0135b, Boolean.FALSE);
        return c0135b;
    }

    public Map.Entry b() {
        return this.f12190e;
    }

    protected c c(Object obj) {
        c cVar = this.f12190e;
        while (cVar != null && !cVar.f12194a.equals(obj)) {
            cVar = cVar.f12196c;
        }
        return cVar;
    }

    public d d() {
        d dVar = new d();
        this.f12192g.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry e() {
        return this.f12191f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    protected c f(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f12193h++;
        c cVar2 = this.f12191f;
        if (cVar2 == null) {
            this.f12190e = cVar;
            this.f12191f = cVar;
            return cVar;
        }
        cVar2.f12196c = cVar;
        cVar.f12197d = cVar2;
        this.f12191f = cVar;
        return cVar;
    }

    public Object g(Object obj, Object obj2) {
        c c3 = c(obj);
        if (c3 != null) {
            return c3.f12195b;
        }
        f(obj, obj2);
        return null;
    }

    public Object h(Object obj) {
        c c3 = c(obj);
        if (c3 == null) {
            return null;
        }
        this.f12193h--;
        if (!this.f12192g.isEmpty()) {
            Iterator it = this.f12192g.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(c3);
            }
        }
        c cVar = c3.f12197d;
        if (cVar != null) {
            cVar.f12196c = c3.f12196c;
        } else {
            this.f12190e = c3.f12196c;
        }
        c cVar2 = c3.f12196c;
        if (cVar2 != null) {
            cVar2.f12197d = cVar;
        } else {
            this.f12191f = cVar;
        }
        c3.f12196c = null;
        c3.f12197d = null;
        return c3.f12195b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((Map.Entry) it.next()).hashCode();
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f12190e, this.f12191f);
        this.f12192g.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f12193h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
