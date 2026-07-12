package com.oplus.pscanvas.canvasmode.canvas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.oplus.pscanvas.canvasmode.canvas.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0305a {

    /* renamed from: b, reason: collision with root package name */
    private static C0305a f10503b;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f10504a = Executors.newFixedThreadPool(3);

    private C0305a() {
    }

    public static synchronized C0305a a() {
        C0305a c0305a;
        synchronized (C0305a.class) {
            try {
                if (f10503b == null) {
                    f10503b = new C0305a();
                }
                c0305a = f10503b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0305a;
    }

    public void b(Runnable runnable) {
        this.f10504a.execute(runnable);
    }

    public Future c(Runnable runnable) {
        return this.f10504a.submit(runnable);
    }

    public Future d(Callable callable) {
        return this.f10504a.submit(callable);
    }
}
