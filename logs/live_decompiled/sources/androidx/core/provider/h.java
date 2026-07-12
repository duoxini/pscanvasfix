package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
abstract class h {

    private static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f4968a;

        /* renamed from: b, reason: collision with root package name */
        private int f4969b;

        /* renamed from: androidx.core.provider.h$a$a, reason: collision with other inner class name */
        private static class C0067a extends Thread {

            /* renamed from: e, reason: collision with root package name */
            private final int f4970e;

            C0067a(Runnable runnable, String str, int i3) {
                super(runnable, str);
                this.f4970e = i3;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f4970e);
                super.run();
            }
        }

        a(String str, int i3) {
            this.f4968a = str;
            this.f4969b = i3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0067a(runnable, this.f4968a, this.f4969b);
        }
    }

    private static class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private Callable f4971e;

        /* renamed from: f, reason: collision with root package name */
        private androidx.core.util.a f4972f;

        /* renamed from: g, reason: collision with root package name */
        private Handler f4973g;

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ androidx.core.util.a f4974e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f4975f;

            a(androidx.core.util.a aVar, Object obj) {
                this.f4974e = aVar;
                this.f4975f = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4974e.accept(this.f4975f);
            }
        }

        b(Handler handler, Callable callable, androidx.core.util.a aVar) {
            this.f4971e = callable;
            this.f4972f = aVar;
            this.f4973g = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f4971e.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f4973g.post(new a(this.f4972f, obj));
        }
    }

    static ThreadPoolExecutor a(String str, int i3, int i4) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i4, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i3));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static void b(Executor executor, Callable callable, androidx.core.util.a aVar) {
        executor.execute(new b(androidx.core.provider.b.a(), callable, aVar));
    }

    static Object c(ExecutorService executorService, Callable callable, int i3) {
        try {
            return executorService.submit(callable).get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (ExecutionException e4) {
            throw new RuntimeException(e4);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
