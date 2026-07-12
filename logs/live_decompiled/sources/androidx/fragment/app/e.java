package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.e;
import androidx.fragment.app.u;

/* loaded from: classes.dex */
abstract class e {

    class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f5419a;

        a(Fragment fragment) {
            this.f5419a = fragment;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            if (this.f5419a.getAnimatingAway() != null) {
                View animatingAway = this.f5419a.getAnimatingAway();
                this.f5419a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.f5419a.setAnimator(null);
        }
    }

    class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5420a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f5421b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ u.g f5422c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f5423d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f5421b.getAnimatingAway() != null) {
                    b.this.f5421b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f5422c.a(bVar.f5421b, bVar.f5423d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, u.g gVar, androidx.core.os.e eVar) {
            this.f5420a = viewGroup;
            this.f5421b = fragment;
            this.f5422c = gVar;
            this.f5423d = eVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5420a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5425a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5426b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f5427c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u.g f5428d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f5429e;

        c(ViewGroup viewGroup, View view, Fragment fragment, u.g gVar, androidx.core.os.e eVar) {
            this.f5425a = viewGroup;
            this.f5426b = view;
            this.f5427c = fragment;
            this.f5428d = gVar;
            this.f5429e = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5425a.endViewTransition(this.f5426b);
            Animator animator2 = this.f5427c.getAnimator();
            this.f5427c.setAnimator(null);
            if (animator2 == null || this.f5425a.indexOfChild(this.f5426b) >= 0) {
                return;
            }
            this.f5428d.a(this.f5427c, this.f5429e);
        }
    }

    static void a(Fragment fragment, d dVar, u.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.e eVar = new androidx.core.os.e();
        eVar.c(new a(fragment));
        gVar.b(fragment, eVar);
        if (dVar.f5430a != null) {
            RunnableC0081e runnableC0081e = new RunnableC0081e(dVar.f5430a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            runnableC0081e.setAnimationListener(new b(viewGroup, fragment, gVar, eVar));
            fragment.mView.startAnimation(runnableC0081e);
            return;
        }
        Animator animator = dVar.f5431b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, eVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z3, boolean z4) {
        return z4 ? z3 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z3 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static d c(Context context, Fragment fragment, boolean z3, boolean z4) {
        int nextTransition = fragment.getNextTransition();
        int b3 = b(fragment, z3, z4);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(E.b.f348c) != null) {
            fragment.mContainer.setTag(E.b.f348c, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z3, b3);
        if (onCreateAnimation != null) {
            return new d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z3, b3);
        if (onCreateAnimator != null) {
            return new d(onCreateAnimator);
        }
        if (b3 == 0 && nextTransition != 0) {
            b3 = d(nextTransition, z3);
        }
        if (b3 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b3));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b3);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                } catch (Resources.NotFoundException e3) {
                    throw e3;
                } catch (RuntimeException unused) {
                }
            }
            try {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, b3);
                if (loadAnimator != null) {
                    return new d(loadAnimator);
                }
            } catch (RuntimeException e4) {
                if (equals) {
                    throw e4;
                }
                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b3);
                if (loadAnimation2 != null) {
                    return new d(loadAnimation2);
                }
            }
        }
        return null;
    }

    private static int d(int i3, boolean z3) {
        if (i3 == 4097) {
            return z3 ? E.a.f344e : E.a.f345f;
        }
        if (i3 == 4099) {
            return z3 ? E.a.f342c : E.a.f343d;
        }
        if (i3 != 8194) {
            return -1;
        }
        return z3 ? E.a.f340a : E.a.f341b;
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f5430a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f5431b;

        d(Animation animation) {
            this.f5430a = animation;
            this.f5431b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.f5430a = null;
            this.f5431b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    static class RunnableC0081e extends AnimationSet implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final ViewGroup f5432e;

        /* renamed from: f, reason: collision with root package name */
        private final View f5433f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5434g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f5435h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f5436i;

        RunnableC0081e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f5436i = true;
            this.f5432e = viewGroup;
            this.f5433f = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation) {
            this.f5436i = true;
            if (this.f5434g) {
                return !this.f5435h;
            }
            if (!super.getTransformation(j3, transformation)) {
                this.f5434g = true;
                androidx.core.view.v.a(this.f5432e, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5434g || !this.f5436i) {
                this.f5432e.endViewTransition(this.f5433f);
                this.f5435h = true;
            } else {
                this.f5436i = false;
                this.f5432e.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation, float f3) {
            this.f5436i = true;
            if (this.f5434g) {
                return !this.f5435h;
            }
            if (!super.getTransformation(j3, transformation, f3)) {
                this.f5434g = true;
                androidx.core.view.v.a(this.f5432e, this);
            }
            return true;
        }
    }
}
