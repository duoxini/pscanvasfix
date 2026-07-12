package v2;

import java.io.Serializable;
import p2.C0511k;
import p2.l;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0610a implements InterfaceC0593d, e, Serializable {

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC0593d f13849e;

    public AbstractC0610a(InterfaceC0593d interfaceC0593d) {
        this.f13849e = interfaceC0593d;
    }

    protected void a() {
    }

    public InterfaceC0593d create(InterfaceC0593d interfaceC0593d) {
        D2.k.e(interfaceC0593d, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // v2.e
    public e getCallerFrame() {
        InterfaceC0593d interfaceC0593d = this.f13849e;
        if (interfaceC0593d instanceof e) {
            return (e) interfaceC0593d;
        }
        return null;
    }

    public final InterfaceC0593d getCompletion() {
        return this.f13849e;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t2.InterfaceC0593d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        while (true) {
            h.b(this);
            AbstractC0610a abstractC0610a = this;
            InterfaceC0593d interfaceC0593d = abstractC0610a.f13849e;
            D2.k.b(interfaceC0593d);
            try {
                invokeSuspend = abstractC0610a.invokeSuspend(obj);
            } catch (Throwable th) {
                C0511k.a aVar = C0511k.f12803f;
                obj = C0511k.b(l.a(th));
            }
            if (invokeSuspend == AbstractC0603b.c()) {
                return;
            }
            obj = C0511k.b(invokeSuspend);
            abstractC0610a.a();
            if (!(interfaceC0593d instanceof AbstractC0610a)) {
                interfaceC0593d.resumeWith(obj);
                return;
            }
            this = interfaceC0593d;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        D2.k.e(interfaceC0593d, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
