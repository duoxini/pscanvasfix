package L2;

/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x0 f1311a = new x0();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f1312b = Q2.I.a(new Q2.D("ThreadLocalEventLoop"));

    private x0() {
    }

    public final S a() {
        ThreadLocal threadLocal = f1312b;
        S s3 = (S) threadLocal.get();
        if (s3 != null) {
            return s3;
        }
        S a3 = V.a();
        threadLocal.set(a3);
        return a3;
    }

    public final void b() {
        f1312b.set(null);
    }

    public final void c(S s3) {
        f1312b.set(s3);
    }
}
