package m2;

import android.os.Handler;
import android.os.Looper;
import m2.h;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f12457a = new Handler(Looper.getMainLooper());

    public static final void a(C2.l lVar, Object obj) {
        D2.k.e(lVar, "$block");
        lVar.f(obj);
    }

    public static final void b(final h.a aVar, final h hVar) {
        D2.k.e(aVar, "block");
        f12457a.post(new Runnable() { // from class: m2.j
            @Override // java.lang.Runnable
            public final void run() {
                k.a(C2.l.this, hVar);
            }
        });
    }
}
