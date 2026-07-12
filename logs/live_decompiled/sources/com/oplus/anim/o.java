package com.oplus.anim;

import a1.C0224d;
import a1.InterfaceC0222b;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import m1.AbstractC0462e;

/* loaded from: classes.dex */
public class o {

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f10132e = Executors.newCachedThreadPool();

    /* renamed from: f, reason: collision with root package name */
    private static boolean f10133f = false;

    /* renamed from: a, reason: collision with root package name */
    private final Set f10134a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f10135b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f10136c;

    /* renamed from: d, reason: collision with root package name */
    private volatile C0224d f10137d;

    private class a extends FutureTask {
        a(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                o.this.k((C0224d) get());
            } catch (InterruptedException | ExecutionException e3) {
                o.this.k(new C0224d(e3));
            }
        }
    }

    public o(Callable callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        C0224d c0224d = this.f10137d;
        if (c0224d == null) {
            return;
        }
        if (c0224d.b() != null) {
            h(c0224d.b());
        } else {
            f(c0224d.a());
        }
    }

    private synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f10135b);
        if (arrayList.isEmpty()) {
            AbstractC0462e.d("EffectiveAnimation encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC0222b) it.next()).a(th);
        }
    }

    private void g() {
        this.f10136c.post(new Runnable() { // from class: a1.e
            @Override // java.lang.Runnable
            public final void run() {
                com.oplus.anim.o.this.e();
            }
        });
    }

    private synchronized void h(Object obj) {
        Iterator it = new ArrayList(this.f10134a).iterator();
        while (it.hasNext()) {
            ((InterfaceC0222b) it.next()).a(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(C0224d c0224d) {
        if (this.f10137d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f10137d = c0224d;
        g();
    }

    public synchronized o c(InterfaceC0222b interfaceC0222b) {
        try {
            C0224d c0224d = this.f10137d;
            if (c0224d != null && c0224d.a() != null) {
                interfaceC0222b.a(c0224d.a());
            }
            this.f10135b.add(interfaceC0222b);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized o d(InterfaceC0222b interfaceC0222b) {
        try {
            C0224d c0224d = this.f10137d;
            if (c0224d != null && c0224d.b() != null) {
                interfaceC0222b.a(c0224d.b());
            }
            this.f10134a.add(interfaceC0222b);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized o i(InterfaceC0222b interfaceC0222b) {
        this.f10135b.remove(interfaceC0222b);
        return this;
    }

    public synchronized o j(InterfaceC0222b interfaceC0222b) {
        this.f10134a.remove(interfaceC0222b);
        return this;
    }

    o(Callable callable, boolean z3) {
        this.f10134a = new LinkedHashSet(1);
        this.f10135b = new LinkedHashSet(1);
        this.f10137d = null;
        if (!f10133f || Looper.myLooper() == null) {
            this.f10136c = new Handler(Looper.getMainLooper());
        } else {
            this.f10136c = new Handler(Looper.myLooper());
        }
        if (!z3) {
            f10132e.execute(new a(callable));
            return;
        }
        try {
            k((C0224d) callable.call());
        } catch (Throwable th) {
            k(new C0224d(th));
        }
    }
}
