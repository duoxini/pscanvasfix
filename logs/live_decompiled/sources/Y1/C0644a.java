package y1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0644a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile C0644a f14499c;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorC0159a f14500a;

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f14501b;

    /* renamed from: y1.a$a, reason: collision with other inner class name */
    public static class ExecutorC0159a implements Executor {

        /* renamed from: e, reason: collision with root package name */
        private Handler f14502e = new Handler(Looper.getMainLooper());

        public boolean a(Runnable runnable) {
            return this.f14502e.hasCallbacks(runnable);
        }

        public void b(Runnable runnable, long j3) {
            this.f14502e.postDelayed(runnable, j3);
        }

        public void c(Runnable runnable) {
            this.f14502e.removeCallbacks(runnable);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f14502e.post(runnable);
        }
    }

    private C0644a() {
        this(new ExecutorC0159a(), Executors.newFixedThreadPool(3));
    }

    public static C0644a a() {
        if (f14499c == null) {
            synchronized (C0644a.class) {
                try {
                    if (f14499c == null) {
                        f14499c = new C0644a();
                    }
                } finally {
                }
            }
        }
        return f14499c;
    }

    public ExecutorC0159a b() {
        return this.f14500a;
    }

    public Future c(Callable callable) {
        return this.f14501b.submit(callable);
    }

    private C0644a(ExecutorC0159a executorC0159a, ExecutorService executorService) {
        this.f14500a = executorC0159a;
        this.f14501b = executorService;
    }
}
