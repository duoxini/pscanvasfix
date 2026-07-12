package M2;

import D2.k;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import p2.C0511k;
import p2.l;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1598a;
    private static volatile Choreographer choreographer;

    static {
        Object b3;
        try {
            C0511k.a aVar = C0511k.f12803f;
            b3 = C0511k.b(new c(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            C0511k.a aVar2 = C0511k.f12803f;
            b3 = C0511k.b(l.a(th));
        }
        f1598a = (d) (C0511k.f(b3) ? null : b3);
    }

    public static final Handler a(Looper looper, boolean z3) {
        if (!z3) {
            return new Handler(looper);
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        k.c(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }
}
