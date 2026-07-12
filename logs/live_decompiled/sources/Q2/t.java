package Q2;

import L2.o0;
import java.util.List;
import p2.C0504d;

/* loaded from: classes.dex */
public abstract class t {
    private static final u a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        d();
        throw new C0504d();
    }

    static /* synthetic */ u b(Throwable th, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            th = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(o0 o0Var) {
        return o0Var.f0() instanceof u;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final o0 e(r rVar, List list) {
        try {
            return rVar.c(list);
        } catch (Throwable th) {
            return a(th, rVar.b());
        }
    }
}
