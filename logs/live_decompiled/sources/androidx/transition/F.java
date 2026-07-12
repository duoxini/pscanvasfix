package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.l;

/* loaded from: classes.dex */
public abstract class F extends l {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f6646f = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: e, reason: collision with root package name */
    private int f6647e = 3;

    class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6648a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6649b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6650c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f6648a = viewGroup;
            this.f6649b = view;
            this.f6650c = view2;
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void a(l lVar) {
            v.a(this.f6648a).remove(this.f6649b);
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void b(l lVar) {
            if (this.f6649b.getParent() == null) {
                v.a(this.f6648a).add(this.f6649b);
            } else {
                F.this.cancel();
            }
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            this.f6650c.setTag(i.f6720a, null);
            v.a(this.f6648a).remove(this.f6649b);
            lVar.removeListener(this);
        }
    }

    private static class b extends AnimatorListenerAdapter implements l.g {

        /* renamed from: a, reason: collision with root package name */
        private final View f6652a;

        /* renamed from: b, reason: collision with root package name */
        private final int f6653b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f6654c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f6655d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6656e;

        /* renamed from: f, reason: collision with root package name */
        boolean f6657f = false;

        b(View view, int i3, boolean z3) {
            this.f6652a = view;
            this.f6653b = i3;
            this.f6654c = (ViewGroup) view.getParent();
            this.f6655d = z3;
            g(true);
        }

        private void f() {
            if (!this.f6657f) {
                y.h(this.f6652a, this.f6653b);
                ViewGroup viewGroup = this.f6654c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z3) {
            ViewGroup viewGroup;
            if (!this.f6655d || this.f6656e == z3 || (viewGroup = this.f6654c) == null) {
                return;
            }
            this.f6656e = z3;
            v.b(viewGroup, z3);
        }

        @Override // androidx.transition.l.g
        public void a(l lVar) {
            g(false);
        }

        @Override // androidx.transition.l.g
        public void b(l lVar) {
            g(true);
        }

        @Override // androidx.transition.l.g
        public void c(l lVar) {
        }

        @Override // androidx.transition.l.g
        public void d(l lVar) {
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            f();
            lVar.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6657f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f6657f) {
                return;
            }
            y.h(this.f6652a, this.f6653b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f6657f) {
                return;
            }
            y.h(this.f6652a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f6658a;

        /* renamed from: b, reason: collision with root package name */
        boolean f6659b;

        /* renamed from: c, reason: collision with root package name */
        int f6660c;

        /* renamed from: d, reason: collision with root package name */
        int f6661d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f6662e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f6663f;

        c() {
        }
    }

    private void captureValues(r rVar) {
        rVar.f6749a.put("android:visibility:visibility", Integer.valueOf(rVar.f6750b.getVisibility()));
        rVar.f6749a.put("android:visibility:parent", rVar.f6750b.getParent());
        int[] iArr = new int[2];
        rVar.f6750b.getLocationOnScreen(iArr);
        rVar.f6749a.put("android:visibility:screenLocation", iArr);
    }

    private c r(r rVar, r rVar2) {
        c cVar = new c();
        cVar.f6658a = false;
        cVar.f6659b = false;
        if (rVar == null || !rVar.f6749a.containsKey("android:visibility:visibility")) {
            cVar.f6660c = -1;
            cVar.f6662e = null;
        } else {
            cVar.f6660c = ((Integer) rVar.f6749a.get("android:visibility:visibility")).intValue();
            cVar.f6662e = (ViewGroup) rVar.f6749a.get("android:visibility:parent");
        }
        if (rVar2 == null || !rVar2.f6749a.containsKey("android:visibility:visibility")) {
            cVar.f6661d = -1;
            cVar.f6663f = null;
        } else {
            cVar.f6661d = ((Integer) rVar2.f6749a.get("android:visibility:visibility")).intValue();
            cVar.f6663f = (ViewGroup) rVar2.f6749a.get("android:visibility:parent");
        }
        if (rVar != null && rVar2 != null) {
            int i3 = cVar.f6660c;
            int i4 = cVar.f6661d;
            if (i3 == i4 && cVar.f6662e == cVar.f6663f) {
                return cVar;
            }
            if (i3 != i4) {
                if (i3 == 0) {
                    cVar.f6659b = false;
                    cVar.f6658a = true;
                } else if (i4 == 0) {
                    cVar.f6659b = true;
                    cVar.f6658a = true;
                }
            } else if (cVar.f6663f == null) {
                cVar.f6659b = false;
                cVar.f6658a = true;
            } else if (cVar.f6662e == null) {
                cVar.f6659b = true;
                cVar.f6658a = true;
            }
        } else if (rVar == null && cVar.f6661d == 0) {
            cVar.f6659b = true;
            cVar.f6658a = true;
        } else if (rVar2 == null && cVar.f6660c == 0) {
            cVar.f6659b = false;
            cVar.f6658a = true;
        }
        return cVar;
    }

    @Override // androidx.transition.l
    public void captureEndValues(r rVar) {
        captureValues(rVar);
    }

    @Override // androidx.transition.l
    public void captureStartValues(r rVar) {
        captureValues(rVar);
    }

    @Override // androidx.transition.l
    public Animator createAnimator(ViewGroup viewGroup, r rVar, r rVar2) {
        c r3 = r(rVar, rVar2);
        if (!r3.f6658a) {
            return null;
        }
        if (r3.f6662e == null && r3.f6663f == null) {
            return null;
        }
        return r3.f6659b ? t(viewGroup, rVar, r3.f6660c, rVar2, r3.f6661d) : v(viewGroup, rVar, r3.f6660c, rVar2, r3.f6661d);
    }

    @Override // androidx.transition.l
    public String[] getTransitionProperties() {
        return f6646f;
    }

    @Override // androidx.transition.l
    public boolean isTransitionRequired(r rVar, r rVar2) {
        if (rVar == null && rVar2 == null) {
            return false;
        }
        if (rVar != null && rVar2 != null && rVar2.f6749a.containsKey("android:visibility:visibility") != rVar.f6749a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c r3 = r(rVar, rVar2);
        if (r3.f6658a) {
            return r3.f6660c == 0 || r3.f6661d == 0;
        }
        return false;
    }

    public abstract Animator s(ViewGroup viewGroup, View view, r rVar, r rVar2);

    public Animator t(ViewGroup viewGroup, r rVar, int i3, r rVar2, int i4) {
        if ((this.f6647e & 1) != 1 || rVar2 == null) {
            return null;
        }
        if (rVar == null) {
            View view = (View) rVar2.f6750b.getParent();
            if (r(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f6658a) {
                return null;
            }
        }
        return s(viewGroup, rVar2.f6750b, rVar, rVar2);
    }

    public abstract Animator u(ViewGroup viewGroup, View view, r rVar, r rVar2);

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r10.mCanRemoveViews != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator v(android.view.ViewGroup r11, androidx.transition.r r12, int r13, androidx.transition.r r14, int r15) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.F.v(android.view.ViewGroup, androidx.transition.r, int, androidx.transition.r, int):android.animation.Animator");
    }

    public void w(int i3) {
        if ((i3 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f6647e = i3;
    }
}
