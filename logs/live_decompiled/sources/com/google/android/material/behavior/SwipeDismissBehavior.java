package com.google.android.material.behavior;

import A.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import androidx.core.view.y;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    A.c f9399a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9400b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9402d;

    /* renamed from: c, reason: collision with root package name */
    private float f9401c = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    int f9403e = 2;

    /* renamed from: f, reason: collision with root package name */
    float f9404f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    float f9405g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    float f9406h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    private final c.AbstractC0002c f9407i = new a();

    class a extends c.AbstractC0002c {

        /* renamed from: a, reason: collision with root package name */
        private int f9408a;

        /* renamed from: b, reason: collision with root package name */
        private int f9409b = -1;

        a() {
        }

        private boolean a(View view, float f3) {
            if (f3 == 0.0f) {
                return Math.abs(view.getLeft() - this.f9408a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f9404f);
            }
            boolean z3 = y.x(view) == 1;
            int i3 = SwipeDismissBehavior.this.f9403e;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                if (z3) {
                    if (f3 >= 0.0f) {
                        return false;
                    }
                } else if (f3 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i3 != 1) {
                return false;
            }
            if (z3) {
                if (f3 <= 0.0f) {
                    return false;
                }
            } else if (f3 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // A.c.AbstractC0002c
        public int clampViewPositionHorizontal(View view, int i3, int i4) {
            int width;
            int width2;
            int width3;
            boolean z3 = y.x(view) == 1;
            int i5 = SwipeDismissBehavior.this.f9403e;
            if (i5 == 0) {
                if (z3) {
                    width = this.f9408a - view.getWidth();
                    width2 = this.f9408a;
                } else {
                    width = this.f9408a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i5 != 1) {
                width = this.f9408a - view.getWidth();
                width2 = this.f9408a + view.getWidth();
            } else if (z3) {
                width = this.f9408a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f9408a - view.getWidth();
                width2 = this.f9408a;
            }
            return SwipeDismissBehavior.c(width, i3, width2);
        }

        @Override // A.c.AbstractC0002c
        public int clampViewPositionVertical(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // A.c.AbstractC0002c
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // A.c.AbstractC0002c
        public void onViewCaptured(View view, int i3) {
            this.f9409b = i3;
            this.f9408a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // A.c.AbstractC0002c
        public void onViewDragStateChanged(int i3) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // A.c.AbstractC0002c
        public void onViewPositionChanged(View view, int i3, int i4, int i5, int i6) {
            float width = this.f9408a + (view.getWidth() * SwipeDismissBehavior.this.f9405g);
            float width2 = this.f9408a + (view.getWidth() * SwipeDismissBehavior.this.f9406h);
            float f3 = i3;
            if (f3 <= width) {
                view.setAlpha(1.0f);
            } else if (f3 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.b(0.0f, 1.0f - SwipeDismissBehavior.e(width, width2, f3), 1.0f));
            }
        }

        @Override // A.c.AbstractC0002c
        public void onViewReleased(View view, float f3, float f4) {
            int i3;
            boolean z3;
            this.f9409b = -1;
            int width = view.getWidth();
            if (a(view, f3)) {
                int left = view.getLeft();
                int i4 = this.f9408a;
                i3 = left < i4 ? i4 - width : i4 + width;
                z3 = true;
            } else {
                i3 = this.f9408a;
                z3 = false;
            }
            if (SwipeDismissBehavior.this.f9399a.F(i3, view.getTop())) {
                y.a0(view, new c(view, z3));
            } else if (z3) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        @Override // A.c.AbstractC0002c
        public boolean tryCaptureView(View view, int i3) {
            int i4 = this.f9409b;
            return (i4 == -1 || i4 == i3) && SwipeDismissBehavior.this.a(view);
        }
    }

    class b implements g {
        b() {
        }

        @Override // androidx.core.view.accessibility.g
        public boolean perform(View view, g.a aVar) {
            if (!SwipeDismissBehavior.this.a(view)) {
                return false;
            }
            boolean z3 = y.x(view) == 1;
            int i3 = SwipeDismissBehavior.this.f9403e;
            y.T(view, (!(i3 == 0 && z3) && (i3 != 1 || z3)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    private class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final View f9412e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f9413f;

        c(View view, boolean z3) {
            this.f9412e = view;
            this.f9413f = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.c cVar = SwipeDismissBehavior.this.f9399a;
            if (cVar != null && cVar.k(true)) {
                y.a0(this.f9412e, this);
            } else if (this.f9413f) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    static float b(float f3, float f4, float f5) {
        return Math.min(Math.max(f3, f4), f5);
    }

    static int c(int i3, int i4, int i5) {
        return Math.min(Math.max(i3, i4), i5);
    }

    private void d(ViewGroup viewGroup) {
        if (this.f9399a == null) {
            this.f9399a = this.f9402d ? A.c.l(viewGroup, this.f9401c, this.f9407i) : A.c.m(viewGroup, this.f9407i);
        }
    }

    static float e(float f3, float f4, float f5) {
        return (f5 - f3) / (f4 - f3);
    }

    private void i(View view) {
        y.c0(view, 1048576);
        if (a(view)) {
            y.e0(view, d.a.f5101y, null, new b());
        }
    }

    public boolean a(View view) {
        return true;
    }

    public void f(float f3) {
        this.f9406h = b(0.0f, f3, 1.0f);
    }

    public void g(float f3) {
        this.f9405g = b(0.0f, f3, 1.0f);
    }

    public void h(int i3) {
        this.f9403e = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z3 = this.f9400b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z3 = coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f9400b = z3;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f9400b = false;
        }
        if (!z3) {
            return false;
        }
        d(coordinatorLayout);
        return this.f9399a.G(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, view, i3);
        if (y.v(view) == 0) {
            y.u0(view, 1);
            i(view);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        A.c cVar = this.f9399a;
        if (cVar == null) {
            return false;
        }
        cVar.z(motionEvent);
        return true;
    }
}
