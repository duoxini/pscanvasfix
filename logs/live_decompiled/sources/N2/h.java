package N2;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1669a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final c f1670b = new c();

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1671a;

        public a(Throwable th) {
            this.f1671a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && D2.k.a(this.f1671a, ((a) obj).f1671a);
        }

        public int hashCode() {
            Throwable th = this.f1671a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // N2.h.c
        public String toString() {
            return "Closed(" + this.f1671a + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(D2.g gVar) {
            this();
        }

        public final Object a(Throwable th) {
            return h.b(new a(th));
        }

        public final Object b() {
            return h.b(h.f1670b);
        }

        public final Object c(Object obj) {
            return h.b(obj);
        }

        private b() {
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static Object b(Object obj) {
        return obj;
    }

    public static final Throwable c(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f1671a;
        }
        return null;
    }

    public static final boolean d(Object obj) {
        return obj instanceof a;
    }

    public static final boolean e(Object obj) {
        return !(obj instanceof c);
    }
}
