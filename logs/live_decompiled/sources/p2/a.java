package P2;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a extends CancellationException {

    /* renamed from: e, reason: collision with root package name */
    public final transient O2.d f1859e;

    public a(O2.d dVar) {
        super("Flow was aborted, no more elements needed");
        this.f1859e = dVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
