package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f5019a;

    /* renamed from: b, reason: collision with root package name */
    Runnable f5020b = null;

    /* renamed from: c, reason: collision with root package name */
    Runnable f5021c = null;

    /* renamed from: d, reason: collision with root package name */
    int f5022d = -1;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ F f5023a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5024b;

        a(F f3, View view) {
            this.f5023a = f3;
            this.f5024b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5023a.c(this.f5024b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5023a.a(this.f5024b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f5023a.b(this.f5024b);
        }
    }

    static class b {
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    E(View view) {
        this.f5019a = new WeakReference(view);
    }

    private void i(View view, F f3) {
        if (f3 != null) {
            view.animate().setListener(new a(f3, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public E b(float f3) {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().alpha(f3);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f5019a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public E f(long j3) {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().setDuration(j3);
        }
        return this;
    }

    public E g(Interpolator interpolator) {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public E h(F f3) {
        View view = (View) this.f5019a.get();
        if (view != null) {
            i(view, f3);
        }
        return this;
    }

    public E j(long j3) {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().setStartDelay(j3);
        }
        return this;
    }

    public E k(final H h3) {
        final View view = (View) this.f5019a.get();
        if (view != null) {
            b.a(view.animate(), h3 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.D
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    H.this.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public E m(float f3) {
        View view = (View) this.f5019a.get();
        if (view != null) {
            view.animate().translationY(f3);
        }
        return this;
    }
}
