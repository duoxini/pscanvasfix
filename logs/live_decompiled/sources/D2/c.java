package D2;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements I2.a, Serializable {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f315k = a.f322e;

    /* renamed from: e, reason: collision with root package name */
    private transient I2.a f316e;

    /* renamed from: f, reason: collision with root package name */
    protected final Object f317f;

    /* renamed from: g, reason: collision with root package name */
    private final Class f318g;

    /* renamed from: h, reason: collision with root package name */
    private final String f319h;

    /* renamed from: i, reason: collision with root package name */
    private final String f320i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f321j;

    private static class a implements Serializable {

        /* renamed from: e, reason: collision with root package name */
        private static final a f322e = new a();

        private a() {
        }
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z3) {
        this.f317f = obj;
        this.f318g = cls;
        this.f319h = str;
        this.f320i = str2;
        this.f321j = z3;
    }

    public I2.a a() {
        I2.a aVar = this.f316e;
        if (aVar != null) {
            return aVar;
        }
        I2.a b3 = b();
        this.f316e = b3;
        return b3;
    }

    protected abstract I2.a b();

    public Object c() {
        return this.f317f;
    }

    public String d() {
        return this.f319h;
    }

    public I2.d g() {
        Class cls = this.f318g;
        if (cls == null) {
            return null;
        }
        return this.f321j ? s.c(cls) : s.b(cls);
    }

    public String h() {
        return this.f320i;
    }
}
