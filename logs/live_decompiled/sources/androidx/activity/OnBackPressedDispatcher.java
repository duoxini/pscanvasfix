package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.o;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f3368a;

    /* renamed from: c, reason: collision with root package name */
    private androidx.core.util.a f3370c;

    /* renamed from: d, reason: collision with root package name */
    private OnBackInvokedCallback f3371d;

    /* renamed from: e, reason: collision with root package name */
    private OnBackInvokedDispatcher f3372e;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque f3369b = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    private boolean f3373f = false;

    private class LifecycleOnBackPressedCancellable implements androidx.lifecycle.l, androidx.activity.a {

        /* renamed from: e, reason: collision with root package name */
        private final AbstractC0272h f3374e;

        /* renamed from: f, reason: collision with root package name */
        private final g f3375f;

        /* renamed from: g, reason: collision with root package name */
        private androidx.activity.a f3376g;

        LifecycleOnBackPressedCancellable(AbstractC0272h abstractC0272h, g gVar) {
            this.f3374e = abstractC0272h;
            this.f3375f = gVar;
            abstractC0272h.a(this);
        }

        @Override // androidx.lifecycle.l
        public void a(o oVar, AbstractC0272h.b bVar) {
            if (bVar == AbstractC0272h.b.ON_START) {
                this.f3376g = OnBackPressedDispatcher.this.c(this.f3375f);
                return;
            }
            if (bVar != AbstractC0272h.b.ON_STOP) {
                if (bVar == AbstractC0272h.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f3376g;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f3374e.c(this);
            this.f3375f.e(this);
            androidx.activity.a aVar = this.f3376g;
            if (aVar != null) {
                aVar.cancel();
                this.f3376g = null;
            }
        }
    }

    static class a {
        static OnBackInvokedCallback a(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new j(runnable);
        }

        static void b(Object obj, int i3, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i3, (OnBackInvokedCallback) obj2);
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class b implements androidx.activity.a {

        /* renamed from: e, reason: collision with root package name */
        private final g f3378e;

        b(g gVar) {
            this.f3378e = gVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f3369b.remove(this.f3378e);
            this.f3378e.e(this);
            if (androidx.core.os.a.b()) {
                this.f3378e.g(null);
                OnBackPressedDispatcher.this.h();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f3368a = runnable;
        if (androidx.core.os.a.b()) {
            this.f3370c = new androidx.core.util.a() { // from class: androidx.activity.h
                @Override // androidx.core.util.a
                public final void accept(Object obj) {
                    OnBackPressedDispatcher.this.e((Boolean) obj);
                }
            };
            this.f3371d = a.a(new Runnable() { // from class: androidx.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    OnBackPressedDispatcher.this.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Boolean bool) {
        if (androidx.core.os.a.b()) {
            h();
        }
    }

    public void b(o oVar, g gVar) {
        AbstractC0272h lifecycle = oVar.getLifecycle();
        if (lifecycle.b() == AbstractC0272h.c.DESTROYED) {
            return;
        }
        gVar.a(new LifecycleOnBackPressedCancellable(lifecycle, gVar));
        if (androidx.core.os.a.b()) {
            h();
            gVar.g(this.f3370c);
        }
    }

    androidx.activity.a c(g gVar) {
        this.f3369b.add(gVar);
        b bVar = new b(gVar);
        gVar.a(bVar);
        if (androidx.core.os.a.b()) {
            h();
            gVar.g(this.f3370c);
        }
        return bVar;
    }

    public boolean d() {
        Iterator descendingIterator = this.f3369b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (((g) descendingIterator.next()).c()) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        Iterator descendingIterator = this.f3369b.descendingIterator();
        while (descendingIterator.hasNext()) {
            g gVar = (g) descendingIterator.next();
            if (gVar.c()) {
                gVar.b();
                return;
            }
        }
        Runnable runnable = this.f3368a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void g(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.f3372e = onBackInvokedDispatcher;
        h();
    }

    void h() {
        boolean d3 = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f3372e;
        if (onBackInvokedDispatcher != null) {
            if (d3 && !this.f3373f) {
                a.b(onBackInvokedDispatcher, 0, this.f3371d);
                this.f3373f = true;
            } else {
                if (d3 || !this.f3373f) {
                    return;
                }
                a.c(onBackInvokedDispatcher, this.f3371d);
                this.f3373f = false;
            }
        }
    }
}
