package J;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: J.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0165c {

    /* renamed from: m, reason: collision with root package name */
    public static final a f943m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public N.h f944a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f945b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f946c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f947d;

    /* renamed from: e, reason: collision with root package name */
    private long f948e;

    /* renamed from: f, reason: collision with root package name */
    private final Executor f949f;

    /* renamed from: g, reason: collision with root package name */
    private int f950g;

    /* renamed from: h, reason: collision with root package name */
    private long f951h;

    /* renamed from: i, reason: collision with root package name */
    private N.g f952i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f953j;

    /* renamed from: k, reason: collision with root package name */
    private final Runnable f954k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f955l;

    /* renamed from: J.c$a */
    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    public C0165c(long j3, TimeUnit timeUnit, Executor executor) {
        D2.k.e(timeUnit, "autoCloseTimeUnit");
        D2.k.e(executor, "autoCloseExecutor");
        this.f945b = new Handler(Looper.getMainLooper());
        this.f947d = new Object();
        this.f948e = timeUnit.toMillis(j3);
        this.f949f = executor;
        this.f951h = SystemClock.uptimeMillis();
        this.f954k = new Runnable() { // from class: J.a
            @Override // java.lang.Runnable
            public final void run() {
                C0165c.f(C0165c.this);
            }
        };
        this.f955l = new Runnable() { // from class: J.b
            @Override // java.lang.Runnable
            public final void run() {
                C0165c.c(C0165c.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C0165c c0165c) {
        p2.q qVar;
        D2.k.e(c0165c, "this$0");
        synchronized (c0165c.f947d) {
            try {
                if (SystemClock.uptimeMillis() - c0165c.f951h < c0165c.f948e) {
                    return;
                }
                if (c0165c.f950g != 0) {
                    return;
                }
                Runnable runnable = c0165c.f946c;
                if (runnable != null) {
                    runnable.run();
                    qVar = p2.q.f12810a;
                } else {
                    qVar = null;
                }
                if (qVar == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                N.g gVar = c0165c.f952i;
                if (gVar != null && gVar.isOpen()) {
                    gVar.close();
                }
                c0165c.f952i = null;
                p2.q qVar2 = p2.q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C0165c c0165c) {
        D2.k.e(c0165c, "this$0");
        c0165c.f949f.execute(c0165c.f955l);
    }

    public final void d() {
        synchronized (this.f947d) {
            try {
                this.f953j = true;
                N.g gVar = this.f952i;
                if (gVar != null) {
                    gVar.close();
                }
                this.f952i = null;
                p2.q qVar = p2.q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.f947d) {
            try {
                int i3 = this.f950g;
                if (i3 <= 0) {
                    throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
                }
                int i4 = i3 - 1;
                this.f950g = i4;
                if (i4 == 0) {
                    if (this.f952i == null) {
                        return;
                    } else {
                        this.f945b.postDelayed(this.f954k, this.f948e);
                    }
                }
                p2.q qVar = p2.q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object g(C2.l lVar) {
        D2.k.e(lVar, "block");
        try {
            return lVar.f(j());
        } finally {
            e();
        }
    }

    public final N.g h() {
        return this.f952i;
    }

    public final N.h i() {
        N.h hVar = this.f944a;
        if (hVar != null) {
            return hVar;
        }
        D2.k.n("delegateOpenHelper");
        return null;
    }

    public final N.g j() {
        synchronized (this.f947d) {
            this.f945b.removeCallbacks(this.f954k);
            this.f950g++;
            if (this.f953j) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            N.g gVar = this.f952i;
            if (gVar != null && gVar.isOpen()) {
                return gVar;
            }
            N.g P3 = i().P();
            this.f952i = P3;
            return P3;
        }
    }

    public final void k(N.h hVar) {
        D2.k.e(hVar, "delegateOpenHelper");
        n(hVar);
    }

    public final boolean l() {
        return !this.f953j;
    }

    public final void m(Runnable runnable) {
        D2.k.e(runnable, "onAutoClose");
        this.f946c = runnable;
    }

    public final void n(N.h hVar) {
        D2.k.e(hVar, "<set-?>");
        this.f944a = hVar;
    }
}
