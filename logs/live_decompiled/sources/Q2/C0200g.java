package Q2;

/* renamed from: Q2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0200g extends RuntimeException {

    /* renamed from: e, reason: collision with root package name */
    private final transient t2.g f1984e;

    public C0200g(t2.g gVar) {
        this.f1984e = gVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f1984e.toString();
    }
}
