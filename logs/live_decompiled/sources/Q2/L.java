package Q2;

import L2.w0;

/* loaded from: classes.dex */
final class L {

    /* renamed from: a, reason: collision with root package name */
    public final t2.g f1974a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f1975b;

    /* renamed from: c, reason: collision with root package name */
    private final w0[] f1976c;

    /* renamed from: d, reason: collision with root package name */
    private int f1977d;

    public L(t2.g gVar, int i3) {
        this.f1974a = gVar;
        this.f1975b = new Object[i3];
        this.f1976c = new w0[i3];
    }

    public final void a(w0 w0Var, Object obj) {
        Object[] objArr = this.f1975b;
        int i3 = this.f1977d;
        objArr[i3] = obj;
        w0[] w0VarArr = this.f1976c;
        this.f1977d = i3 + 1;
        D2.k.c(w0Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        w0VarArr[i3] = w0Var;
    }

    public final void b(t2.g gVar) {
        int length = this.f1976c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i3 = length - 1;
            w0 w0Var = this.f1976c[length];
            D2.k.b(w0Var);
            w0Var.K(gVar, this.f1975b[length]);
            if (i3 < 0) {
                return;
            } else {
                length = i3;
            }
        }
    }
}
