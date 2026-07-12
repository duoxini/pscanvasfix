package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private int f9394a;

    /* renamed from: b, reason: collision with root package name */
    private int f9395b;

    /* renamed from: c, reason: collision with root package name */
    private int f9396c;

    /* renamed from: d, reason: collision with root package name */
    private ViewPropertyAnimator f9397d;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f9397d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f9394a = 0;
        this.f9395b = 2;
        this.f9396c = 0;
    }

    private void b(View view, int i3, long j3, TimeInterpolator timeInterpolator) {
        this.f9397d = view.animate().translationY(i3).setInterpolator(timeInterpolator).setDuration(j3).setListener(new a());
    }

    public boolean c() {
        return this.f9395b == 1;
    }

    public boolean d() {
        return this.f9395b == 2;
    }

    public void e(View view) {
        f(view, true);
    }

    public void f(View view, boolean z3) {
        if (c()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f9397d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f9395b = 1;
        int i3 = this.f9394a + this.f9396c;
        if (z3) {
            b(view, i3, 175L, I0.a.f916c);
        } else {
            view.setTranslationY(i3);
        }
    }

    public void g(View view) {
        h(view, true);
    }

    public void h(View view, boolean z3) {
        if (d()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f9397d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f9395b = 2;
        if (z3) {
            b(view, 0, 225L, I0.a.f917d);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
        this.f9394a = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, view, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (i4 > 0) {
            e(view);
        } else if (i4 < 0) {
            g(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        return i3 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9394a = 0;
        this.f9395b = 2;
        this.f9396c = 0;
    }
}
