package S2;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: m, reason: collision with root package name */
    public static final c f2156m = new c();

    private c() {
        super(l.f2169c, l.f2170d, l.f2171e, l.f2167a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // L2.A
    public String toString() {
        return "Dispatchers.Default";
    }
}
