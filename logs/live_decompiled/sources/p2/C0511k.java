package p2;

import java.io.Serializable;

/* renamed from: p2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0511k implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f12803f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final Object f12804e;

    /* renamed from: p2.k$a */
    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: p2.k$b */
    public static final class b implements Serializable {

        /* renamed from: e, reason: collision with root package name */
        public final Throwable f12805e;

        public b(Throwable th) {
            D2.k.e(th, "exception");
            this.f12805e = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && D2.k.a(this.f12805e, ((b) obj).f12805e);
        }

        public int hashCode() {
            return this.f12805e.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f12805e + ')';
        }
    }

    private /* synthetic */ C0511k(Object obj) {
        this.f12804e = obj;
    }

    public static final /* synthetic */ C0511k a(Object obj) {
        return new C0511k(obj);
    }

    public static Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof C0511k) && D2.k.a(obj, ((C0511k) obj2).h());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f12805e;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static String g(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f12804e, obj);
    }

    public final /* synthetic */ Object h() {
        return this.f12804e;
    }

    public int hashCode() {
        return e(this.f12804e);
    }

    public String toString() {
        return g(this.f12804e);
    }
}
