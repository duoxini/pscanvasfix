package J;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class C implements Executor {

    /* renamed from: e, reason: collision with root package name */
    private final Executor f937e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f938f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f939g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f940h;

    public C(Executor executor) {
        D2.k.e(executor, "executor");
        this.f937e = executor;
        this.f938f = new ArrayDeque();
        this.f940h = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable, C c3) {
        D2.k.e(runnable, "$command");
        D2.k.e(c3, "this$0");
        try {
            runnable.run();
        } finally {
            c3.c();
        }
    }

    public final void c() {
        synchronized (this.f940h) {
            try {
                Object poll = this.f938f.poll();
                Runnable runnable = (Runnable) poll;
                this.f939g = runnable;
                if (poll != null) {
                    this.f937e.execute(runnable);
                }
                p2.q qVar = p2.q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        D2.k.e(runnable, "command");
        synchronized (this.f940h) {
            try {
                this.f938f.offer(new Runnable() { // from class: J.B
                    @Override // java.lang.Runnable
                    public final void run() {
                        C.b(runnable, this);
                    }
                });
                if (this.f939g == null) {
                    c();
                }
                p2.q qVar = p2.q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
