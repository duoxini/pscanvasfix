package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.transition.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0284d extends F {

    /* renamed from: androidx.transition.d$a */
    class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6702a;

        a(View view) {
            this.f6702a = view;
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            y.g(this.f6702a, 1.0f);
            y.a(this.f6702a);
            lVar.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.d$b */
    private static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f6704a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6705b = false;

        b(View view) {
            this.f6704a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.g(this.f6704a, 1.0f);
            if (this.f6705b) {
                this.f6704a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.view.y.K(this.f6704a) && this.f6704a.getLayerType() == 0) {
                this.f6705b = true;
                this.f6704a.setLayerType(2, null);
            }
        }
    }

    public C0284d(int i3) {
        w(i3);
    }

    private Animator x(View view, float f3, float f4) {
        if (f3 == f4) {
            return null;
        }
        y.g(view, f3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) y.f6759b, f4);
        ofFloat.addListener(new b(view));
        addListener(new a(view));
        return ofFloat;
    }

    private static float y(r rVar, float f3) {
        Float f4;
        return (rVar == null || (f4 = (Float) rVar.f6749a.get("android:fade:transitionAlpha")) == null) ? f3 : f4.floatValue();
    }

    @Override // androidx.transition.F, androidx.transition.l
    public void captureStartValues(r rVar) {
        super.captureStartValues(rVar);
        rVar.f6749a.put("android:fade:transitionAlpha", Float.valueOf(y.c(rVar.f6750b)));
    }

    @Override // androidx.transition.F
    public Animator s(ViewGroup viewGroup, View view, r rVar, r rVar2) {
        float y3 = y(rVar, 0.0f);
        return x(view, y3 != 1.0f ? y3 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.F
    public Animator u(ViewGroup viewGroup, View view, r rVar, r rVar2) {
        y.e(view);
        return x(view, y(rVar, 1.0f), 0.0f);
    }

    public C0284d() {
    }
}
