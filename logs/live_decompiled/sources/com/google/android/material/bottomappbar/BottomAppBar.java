package com.google.android.material.bottomappbar;

import H0.i;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.p;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.y;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: e, reason: collision with root package name */
    private static final int f9415e = i.f646k;

    static /* synthetic */ void i(BottomAppBar bottomAppBar) {
        throw null;
    }

    static /* synthetic */ View j(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e, reason: collision with root package name */
        private final Rect f9416e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference f9417f;

        /* renamed from: g, reason: collision with root package name */
        private int f9418g;

        /* renamed from: h, reason: collision with root package name */
        private final View.OnLayoutChangeListener f9419h;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                p.a(Behavior.this.f9417f.get());
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f9419h = new a();
            this.f9416e = new Rect();
        }

        public boolean j(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i3) {
            this.f9417f = new WeakReference(bottomAppBar);
            View j3 = BottomAppBar.j(bottomAppBar);
            if (j3 != null && !y.O(j3)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) j3.getLayoutParams();
                fVar.f4780d = 49;
                this.f9418g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                BottomAppBar.i(bottomAppBar);
            }
            coordinatorLayout.I(bottomAppBar, i3);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i3);
        }

        public boolean k(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i3, int i4) {
            throw null;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            p.a(view);
            return j(coordinatorLayout, null, i3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            p.a(view);
            return k(coordinatorLayout, null, view2, view3, i3, i4);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9419h = new a();
            this.f9416e = new Rect();
        }
    }
}
