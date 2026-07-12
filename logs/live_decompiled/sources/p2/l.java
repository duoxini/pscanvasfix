package p2;

import p2.C0511k;

/* loaded from: classes.dex */
public abstract class l {
    public static final Object a(Throwable th) {
        D2.k.e(th, "exception");
        return new C0511k.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof C0511k.b) {
            throw ((C0511k.b) obj).f12805e;
        }
    }
}
