package m;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: m.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0451a extends g implements Map {

    /* renamed from: l, reason: collision with root package name */
    AbstractC0456f f12327l;

    /* renamed from: m.a$a, reason: collision with other inner class name */
    class C0136a extends AbstractC0456f {
        C0136a() {
        }

        @Override // m.AbstractC0456f
        protected void a() {
            C0451a.this.clear();
        }

        @Override // m.AbstractC0456f
        protected Object b(int i3, int i4) {
            return C0451a.this.f12376f[(i3 << 1) + i4];
        }

        @Override // m.AbstractC0456f
        protected Map c() {
            return C0451a.this;
        }

        @Override // m.AbstractC0456f
        protected int d() {
            return C0451a.this.f12377g;
        }

        @Override // m.AbstractC0456f
        protected int e(Object obj) {
            return C0451a.this.f(obj);
        }

        @Override // m.AbstractC0456f
        protected int f(Object obj) {
            return C0451a.this.h(obj);
        }

        @Override // m.AbstractC0456f
        protected void g(Object obj, Object obj2) {
            C0451a.this.put(obj, obj2);
        }

        @Override // m.AbstractC0456f
        protected void h(int i3) {
            C0451a.this.k(i3);
        }

        @Override // m.AbstractC0456f
        protected Object i(int i3, Object obj) {
            return C0451a.this.l(i3, obj);
        }
    }

    public C0451a() {
    }

    private AbstractC0456f n() {
        if (this.f12327l == null) {
            this.f12327l = new C0136a();
        }
        return this.f12327l;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return n().m();
    }

    public boolean o(Collection collection) {
        return AbstractC0456f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f12377g + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return n().n();
    }

    public C0451a(g gVar) {
        super(gVar);
    }
}
