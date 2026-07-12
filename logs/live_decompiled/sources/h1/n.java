package H1;

import android.content.Context;

/* loaded from: classes.dex */
public class n implements m {

    /* renamed from: a, reason: collision with root package name */
    private m f873a;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static n f874a = new n();
    }

    private void b(Context context) {
        if (this.f873a != null) {
            return;
        }
        if (K1.h.a(context)) {
            this.f873a = new l();
        } else {
            this.f873a = new q();
        }
    }

    public static n c() {
        return b.f874a;
    }

    @Override // H1.m
    public void a(Context context, G1.c cVar) {
        b(context);
        this.f873a.a(context, cVar);
    }

    private n() {
    }
}
