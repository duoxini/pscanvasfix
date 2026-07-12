package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class v implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: e, reason: collision with root package name */
    private final View f5129e;

    /* renamed from: f, reason: collision with root package name */
    private ViewTreeObserver f5130f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f5131g;

    private v(View view, Runnable runnable) {
        this.f5129e = view;
        this.f5130f = view.getViewTreeObserver();
        this.f5131g = runnable;
    }

    public static v a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        v vVar = new v(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(vVar);
        view.addOnAttachStateChangeListener(vVar);
        return vVar;
    }

    public void b() {
        if (this.f5130f.isAlive()) {
            this.f5130f.removeOnPreDrawListener(this);
        } else {
            this.f5129e.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f5129e.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f5131g.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f5130f = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
