package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.g;
import androidx.emoji2.text.e;
import androidx.emoji2.text.j;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class j extends e.c {

    /* renamed from: j, reason: collision with root package name */
    private static final a f5275j = new a();

    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return androidx.core.provider.g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, androidx.core.provider.e eVar) {
            return androidx.core.provider.g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements e.g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5276a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.provider.e f5277b;

        /* renamed from: c, reason: collision with root package name */
        private final a f5278c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f5279d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private Handler f5280e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f5281f;

        /* renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f5282g;

        /* renamed from: h, reason: collision with root package name */
        e.h f5283h;

        /* renamed from: i, reason: collision with root package name */
        private ContentObserver f5284i;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f5285j;

        b(Context context, androidx.core.provider.e eVar, a aVar) {
            androidx.core.util.h.e(context, "Context cannot be null");
            androidx.core.util.h.e(eVar, "FontRequest cannot be null");
            this.f5276a = context.getApplicationContext();
            this.f5277b = eVar;
            this.f5278c = aVar;
        }

        private void b() {
            synchronized (this.f5279d) {
                try {
                    this.f5283h = null;
                    ContentObserver contentObserver = this.f5284i;
                    if (contentObserver != null) {
                        this.f5278c.c(this.f5276a, contentObserver);
                        this.f5284i = null;
                    }
                    Handler handler = this.f5280e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f5285j);
                    }
                    this.f5280e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f5282g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f5281f = null;
                    this.f5282g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private g.b e() {
            try {
                g.a b3 = this.f5278c.b(this.f5276a, this.f5277b);
                if (b3.c() == 0) {
                    g.b[] b4 = b3.b();
                    if (b4 == null || b4.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return b4[0];
                }
                throw new RuntimeException("fetchFonts failed (" + b3.c() + ")");
            } catch (PackageManager.NameNotFoundException e3) {
                throw new RuntimeException("provider not found", e3);
            }
        }

        @Override // androidx.emoji2.text.e.g
        public void a(e.h hVar) {
            androidx.core.util.h.e(hVar, "LoaderCallback cannot be null");
            synchronized (this.f5279d) {
                this.f5283h = hVar;
            }
            d();
        }

        void c() {
            synchronized (this.f5279d) {
                try {
                    if (this.f5283h == null) {
                        return;
                    }
                    try {
                        g.b e3 = e();
                        int b3 = e3.b();
                        if (b3 == 2) {
                            synchronized (this.f5279d) {
                            }
                        }
                        if (b3 != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + b3 + ")");
                        }
                        try {
                            androidx.core.os.i.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface a3 = this.f5278c.a(this.f5276a, e3);
                            ByteBuffer a4 = androidx.core.graphics.g.a(this.f5276a, null, e3.d());
                            if (a4 == null || a3 == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            m b4 = m.b(a3, a4);
                            androidx.core.os.i.b();
                            synchronized (this.f5279d) {
                                try {
                                    e.h hVar = this.f5283h;
                                    if (hVar != null) {
                                        hVar.b(b4);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            androidx.core.os.i.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f5279d) {
                            try {
                                e.h hVar2 = this.f5283h;
                                if (hVar2 != null) {
                                    hVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void d() {
            synchronized (this.f5279d) {
                try {
                    if (this.f5283h == null) {
                        return;
                    }
                    if (this.f5281f == null) {
                        ThreadPoolExecutor b3 = androidx.emoji2.text.b.b("emojiCompat");
                        this.f5282g = b3;
                        this.f5281f = b3;
                    }
                    this.f5281f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.b.this.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f5279d) {
                this.f5281f = executor;
            }
        }
    }

    public j(Context context, androidx.core.provider.e eVar) {
        super(new b(context, eVar, f5275j));
    }

    public j c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
