package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.f;
import androidx.core.provider.g;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final g.c f4930a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f4931b;

    /* renamed from: androidx.core.provider.a$a, reason: collision with other inner class name */
    class RunnableC0066a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g.c f4932e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Typeface f4933f;

        RunnableC0066a(g.c cVar, Typeface typeface) {
            this.f4932e = cVar;
            this.f4933f = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4932e.b(this.f4933f);
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g.c f4935e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f4936f;

        b(g.c cVar, int i3) {
            this.f4935e = cVar;
            this.f4936f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4935e.a(this.f4936f);
        }
    }

    a(g.c cVar, Handler handler) {
        this.f4930a = cVar;
        this.f4931b = handler;
    }

    private void a(int i3) {
        this.f4931b.post(new b(this.f4930a, i3));
    }

    private void c(Typeface typeface) {
        this.f4931b.post(new RunnableC0066a(this.f4930a, typeface));
    }

    void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f4959a);
        } else {
            a(eVar.f4960b);
        }
    }
}
