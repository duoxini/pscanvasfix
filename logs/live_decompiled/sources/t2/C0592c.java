package t2;

import C2.p;
import D2.k;
import D2.l;
import java.io.Serializable;
import t2.g;

/* renamed from: t2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0592c implements g, Serializable {

    /* renamed from: e, reason: collision with root package name */
    private final g f13686e;

    /* renamed from: f, reason: collision with root package name */
    private final g.b f13687f;

    /* renamed from: t2.c$a */
    static final class a extends l implements p {

        /* renamed from: e, reason: collision with root package name */
        public static final a f13688e = new a();

        a() {
            super(2);
        }

        @Override // C2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, g.b bVar) {
            k.e(str, "acc");
            k.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public C0592c(g gVar, g.b bVar) {
        k.e(gVar, "left");
        k.e(bVar, "element");
        this.f13686e = gVar;
        this.f13687f = bVar;
    }

    private final boolean d(g.b bVar) {
        return k.a(a(bVar.getKey()), bVar);
    }

    private final boolean e(C0592c c0592c) {
        while (d(c0592c.f13687f)) {
            g gVar = c0592c.f13686e;
            if (!(gVar instanceof C0592c)) {
                k.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((g.b) gVar);
            }
            c0592c = (C0592c) gVar;
        }
        return false;
    }

    private final int f() {
        int i3 = 2;
        while (true) {
            g gVar = this.f13686e;
            this = gVar instanceof C0592c ? (C0592c) gVar : null;
            if (this == null) {
                return i3;
            }
            i3++;
        }
    }

    @Override // t2.g
    public g N(g.c cVar) {
        k.e(cVar, "key");
        if (this.f13687f.a(cVar) != null) {
            return this.f13686e;
        }
        g N3 = this.f13686e.N(cVar);
        return N3 == this.f13686e ? this : N3 == h.f13692e ? this.f13687f : new C0592c(N3, this.f13687f);
    }

    @Override // t2.g
    public g.b a(g.c cVar) {
        k.e(cVar, "key");
        while (true) {
            g.b a3 = this.f13687f.a(cVar);
            if (a3 != null) {
                return a3;
            }
            g gVar = this.f13686e;
            if (!(gVar instanceof C0592c)) {
                return gVar.a(cVar);
            }
            this = (C0592c) gVar;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C0592c) {
                C0592c c0592c = (C0592c) obj;
                if (c0592c.f() != f() || !c0592c.e(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // t2.g
    public Object g(Object obj, p pVar) {
        k.e(pVar, "operation");
        return pVar.invoke(this.f13686e.g(obj, pVar), this.f13687f);
    }

    public int hashCode() {
        return this.f13686e.hashCode() + this.f13687f.hashCode();
    }

    @Override // t2.g
    public g p(g gVar) {
        return g.a.a(this, gVar);
    }

    public String toString() {
        return '[' + ((String) g("", a.f13688e)) + ']';
    }
}
