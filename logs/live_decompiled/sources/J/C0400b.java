package j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: j.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0400b extends AbstractC0401c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f12133a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f12134b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f12135c;

    /* renamed from: j.b$a */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f12136a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f12136a.getAndIncrement())));
            return thread;
        }
    }

    private static Handler d(Looper looper) {
        return Handler.createAsync(looper);
    }

    @Override // j.AbstractC0401c
    public void a(Runnable runnable) {
        this.f12134b.execute(runnable);
    }

    @Override // j.AbstractC0401c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // j.AbstractC0401c
    public void c(Runnable runnable) {
        if (this.f12135c == null) {
            synchronized (this.f12133a) {
                try {
                    if (this.f12135c == null) {
                        this.f12135c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f12135c.post(runnable);
    }
}
