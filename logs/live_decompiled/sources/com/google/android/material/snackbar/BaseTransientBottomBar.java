package com.google.android.material.snackbar;

import H0.j;
import R0.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.y;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar {

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: j, reason: collision with root package name */
        private final a f9746j = new a(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.f9746j.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f9746j.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    public static class a {
        public a(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.g(0.1f);
            swipeDismissBehavior.f(0.6f);
            swipeDismissBehavior.h(0);
        }

        public boolean a(View view) {
            return view instanceof b;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.b().e(null);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.b().f(null);
            }
        }
    }

    protected static class b extends FrameLayout {

        /* renamed from: n, reason: collision with root package name */
        private static final View.OnTouchListener f9747n = new a();

        /* renamed from: e, reason: collision with root package name */
        private int f9748e;

        /* renamed from: f, reason: collision with root package name */
        private final float f9749f;

        /* renamed from: g, reason: collision with root package name */
        private final float f9750g;

        /* renamed from: h, reason: collision with root package name */
        private final int f9751h;

        /* renamed from: i, reason: collision with root package name */
        private final int f9752i;

        /* renamed from: j, reason: collision with root package name */
        private ColorStateList f9753j;

        /* renamed from: k, reason: collision with root package name */
        private PorterDuff.Mode f9754k;

        /* renamed from: l, reason: collision with root package name */
        private Rect f9755l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f9756m;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected b(Context context, AttributeSet attributeSet) {
            super(V0.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, j.U4);
            if (obtainStyledAttributes.hasValue(j.b5)) {
                y.r0(this, obtainStyledAttributes.getDimensionPixelSize(j.b5, 0));
            }
            this.f9748e = obtainStyledAttributes.getInt(j.X4, 0);
            this.f9749f = obtainStyledAttributes.getFloat(j.Y4, 1.0f);
            setBackgroundTintList(c.a(context2, obtainStyledAttributes, j.Z4));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(j.a5, -1), PorterDuff.Mode.SRC_IN));
            this.f9750g = obtainStyledAttributes.getFloat(j.W4, 1.0f);
            this.f9751h = obtainStyledAttributes.getDimensionPixelSize(j.V4, -1);
            this.f9752i = obtainStyledAttributes.getDimensionPixelSize(j.c5, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f9747n);
            setFocusable(true);
            if (getBackground() == null) {
                y.n0(this, a());
            }
        }

        private Drawable a() {
            float dimension = getResources().getDimension(H0.c.f513M);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(L0.a.i(this, H0.a.f482n, H0.a.f479k, getBackgroundOverlayColorAlpha()));
            if (this.f9753j == null) {
                return androidx.core.graphics.drawable.a.l(gradientDrawable);
            }
            Drawable l3 = androidx.core.graphics.drawable.a.l(gradientDrawable);
            androidx.core.graphics.drawable.a.i(l3, this.f9753j);
            return l3;
        }

        private void b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f9755l = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        }

        float getActionTextColorAlpha() {
            return this.f9750g;
        }

        int getAnimationMode() {
            return this.f9748e;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f9749f;
        }

        int getMaxInlineActionWidth() {
            return this.f9752i;
        }

        int getMaxWidth() {
            return this.f9751h;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            y.f0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
            super.onLayout(z3, i3, i4, i5, i6);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (this.f9751h > 0) {
                int measuredWidth = getMeasuredWidth();
                int i5 = this.f9751h;
                if (measuredWidth > i5) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
                }
            }
        }

        void setAnimationMode(int i3) {
            this.f9748e = i3;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f9753j != null) {
                drawable = androidx.core.graphics.drawable.a.l(drawable.mutate());
                androidx.core.graphics.drawable.a.i(drawable, this.f9753j);
                androidx.core.graphics.drawable.a.j(drawable, this.f9754k);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f9753j = colorStateList;
            if (getBackground() != null) {
                Drawable l3 = androidx.core.graphics.drawable.a.l(getBackground().mutate());
                androidx.core.graphics.drawable.a.i(l3, colorStateList);
                androidx.core.graphics.drawable.a.j(l3, this.f9754k);
                if (l3 != getBackground()) {
                    super.setBackgroundDrawable(l3);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f9754k = mode;
            if (getBackground() != null) {
                Drawable l3 = androidx.core.graphics.drawable.a.l(getBackground().mutate());
                androidx.core.graphics.drawable.a.j(l3, mode);
                if (l3 != getBackground()) {
                    super.setBackgroundDrawable(l3);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f9756m || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            b((ViewGroup.MarginLayoutParams) layoutParams);
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f9747n);
            super.setOnClickListener(onClickListener);
        }
    }
}
