package com.coui.appcompat.searchview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Insets;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class s implements WindowInsetsAnimationControlListener {

    /* renamed from: e, reason: collision with root package name */
    public static final a f9220e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Interpolator f9221f = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);

    /* renamed from: g, reason: collision with root package name */
    private static final TypeEvaluator f9222g = new TypeEvaluator() { // from class: com.coui.appcompat.searchview.q
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f3, Object obj, Object obj2) {
            Insets d3;
            d3 = s.d(f3, (Insets) obj, (Insets) obj2);
            return d3;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final boolean f9223a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9224b;

    /* renamed from: c, reason: collision with root package name */
    private final Interpolator f9225c;

    /* renamed from: d, reason: collision with root package name */
    private Animator f9226d;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WindowInsetsAnimationController f9227a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9228b;

        b(WindowInsetsAnimationController windowInsetsAnimationController, boolean z3) {
            this.f9227a = windowInsetsAnimationController;
            this.f9228b = z3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            D2.k.e(animator, "animation");
            if (this.f9227a.isCancelled()) {
                return;
            }
            this.f9227a.finish(this.f9228b);
        }
    }

    public s(boolean z3, int i3, Interpolator interpolator) {
        D2.k.e(interpolator, "mInsetsInterpolator");
        this.f9223a = z3;
        this.f9224b = i3;
        this.f9225c = interpolator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Insets d(float f3, Insets insets, Insets insets2) {
        D2.k.e(insets, "startValue");
        D2.k.e(insets2, "endValue");
        return Insets.of((int) (insets.left + ((insets2.left - r0) * f3)), (int) (insets.top + ((insets2.top - r1) * f3)), (int) (insets.right + ((insets2.right - r2) * f3)), (int) (insets.bottom + (f3 * (insets2.bottom - r6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(float f3) {
        return Math.min(1.0f, 2 * f3);
    }

    private final Interpolator f() {
        return this.f9223a ? new Interpolator() { // from class: com.coui.appcompat.searchview.r
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f3) {
                float e3;
                e3 = s.e(f3);
                return e3;
            }
        } : f9221f;
    }

    private final ValueAnimator g(final WindowInsetsAnimationController windowInsetsAnimationController, boolean z3) {
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.f9224b);
        ofFloat.setInterpolator(new LinearInterpolator());
        final Interpolator interpolator = this.f9225c;
        final Interpolator f3 = f();
        final Insets hiddenStateInsets = z3 ? windowInsetsAnimationController.getHiddenStateInsets() : windowInsetsAnimationController.getShownStateInsets();
        D2.k.d(hiddenStateInsets, "if (show) controller.hid…ntroller.shownStateInsets");
        final Insets shownStateInsets = z3 ? windowInsetsAnimationController.getShownStateInsets() : windowInsetsAnimationController.getHiddenStateInsets();
        D2.k.d(shownStateInsets, "if (show) controller.sho…troller.hiddenStateInsets");
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.h(windowInsetsAnimationController, ofFloat, this, interpolator, hiddenStateInsets, shownStateInsets, f3, valueAnimator);
            }
        });
        ofFloat.addListener(new b(windowInsetsAnimationController, z3));
        ofFloat.start();
        D2.k.d(ofFloat, "animator");
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WindowInsetsAnimationController windowInsetsAnimationController, ValueAnimator valueAnimator, s sVar, Interpolator interpolator, Insets insets, Insets insets2, Interpolator interpolator2, ValueAnimator valueAnimator2) {
        D2.k.e(windowInsetsAnimationController, "$controller");
        D2.k.e(sVar, "this$0");
        D2.k.e(interpolator, "$insetsInterpolator");
        D2.k.e(insets, "$start");
        D2.k.e(insets2, "$end");
        D2.k.e(interpolator2, "$alphaInterpolator");
        D2.k.e(valueAnimator2, "animation");
        if (!windowInsetsAnimationController.isReady()) {
            valueAnimator.cancel();
            return;
        }
        float animatedFraction = valueAnimator2.getAnimatedFraction();
        windowInsetsAnimationController.setInsetsAndAlpha((Insets) f9222g.evaluate(interpolator.getInterpolation(animatedFraction), insets, insets2), interpolator2.getInterpolation(sVar.f9223a ? animatedFraction : 1 - animatedFraction), animatedFraction);
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        Animator animator = this.f9226d;
        if (animator != null) {
            D2.k.b(animator);
            animator.cancel();
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        D2.k.e(windowInsetsAnimationController, "controller");
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i3) {
        D2.k.e(windowInsetsAnimationController, "controller");
        this.f9226d = g(windowInsetsAnimationController, this.f9223a);
    }
}
