package L2;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class f0 extends CancellationException {

    /* renamed from: e, reason: collision with root package name */
    public final transient e0 f1270e;

    public f0(String str, Throwable th, e0 e0Var) {
        super(str);
        this.f1270e = e0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof f0) {
                f0 f0Var = (f0) obj;
                if (!D2.k.a(f0Var.getMessage(), getMessage()) || !D2.k.a(f0Var.f1270e, this.f1270e) || !D2.k.a(f0Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        D2.k.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f1270e.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f1270e;
    }
}
