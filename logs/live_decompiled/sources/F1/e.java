package F1;

import H1.n;
import K1.g;
import android.content.Context;

/* loaded from: classes.dex */
public abstract class e extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String b(Throwable th) {
        return "recordCommon: addTrackEvent exception:" + th;
    }

    public static void c(Context context, G1.a aVar) {
        try {
            n.c().a(context, aVar);
        } catch (Throwable th) {
            K1.f.b("CommonAgent", new g() { // from class: F1.d
                @Override // K1.g
                public final Object get() {
                    String b3;
                    b3 = e.b(th);
                    return b3;
                }
            });
        }
    }
}
