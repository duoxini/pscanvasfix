package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.e;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.InterfaceC0267c;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Q.a {

    static class a extends e.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    static class b implements e.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5210a;

        class a extends e.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e.h f5211a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f5212b;

            a(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f5211a = hVar;
                this.f5212b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.h
            public void a(Throwable th) {
                try {
                    this.f5211a.a(th);
                } finally {
                    this.f5212b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.h
            public void b(m mVar) {
                try {
                    this.f5211a.b(mVar);
                } finally {
                    this.f5212b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f5210a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.g
        public void a(final e.h hVar) {
            final ThreadPoolExecutor b3 = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            b3.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.b.this.d(hVar, b3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(e.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                j a3 = androidx.emoji2.text.c.a(this.f5210a);
                if (a3 == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                a3.c(threadPoolExecutor);
                a3.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th) {
                hVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.i.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.h()) {
                    e.b().k();
                }
            } finally {
                androidx.core.os.i.b();
            }
        }
    }

    @Override // Q.a
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // Q.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        e.g(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        final AbstractC0272h lifecycle = ((androidx.lifecycle.o) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new InterfaceC0267c() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public void onResume(androidx.lifecycle.o oVar) {
                EmojiCompatInitializer.this.e();
                lifecycle.c(this);
            }
        });
    }

    void e() {
        androidx.emoji2.text.b.d().postDelayed(new c(), 500L);
    }
}
