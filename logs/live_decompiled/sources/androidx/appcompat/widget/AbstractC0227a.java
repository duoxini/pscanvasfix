package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import e.AbstractC0339a;

/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0227a extends ViewGroup {

    /* renamed from: e, reason: collision with root package name */
    protected final C0056a f4185e;

    /* renamed from: f, reason: collision with root package name */
    protected final Context f4186f;

    /* renamed from: g, reason: collision with root package name */
    protected ActionMenuView f4187g;

    /* renamed from: h, reason: collision with root package name */
    protected C0229c f4188h;

    /* renamed from: i, reason: collision with root package name */
    protected int f4189i;

    /* renamed from: j, reason: collision with root package name */
    protected androidx.core.view.E f4190j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4191k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4192l;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0056a implements androidx.core.view.F {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4193a = false;

        /* renamed from: b, reason: collision with root package name */
        int f4194b;

        protected C0056a() {
        }

        @Override // androidx.core.view.F
        public void a(View view) {
            if (this.f4193a) {
                return;
            }
            AbstractC0227a abstractC0227a = AbstractC0227a.this;
            abstractC0227a.f4190j = null;
            AbstractC0227a.super.setVisibility(this.f4194b);
        }

        @Override // androidx.core.view.F
        public void b(View view) {
            AbstractC0227a.super.setVisibility(0);
            this.f4193a = false;
        }

        @Override // androidx.core.view.F
        public void c(View view) {
            this.f4193a = true;
        }

        public C0056a d(androidx.core.view.E e3, int i3) {
            AbstractC0227a.this.f4190j = e3;
            this.f4194b = i3;
            return this;
        }
    }

    AbstractC0227a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4185e = new C0056a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(AbstractC0339a.f11086a, typedValue, true) || typedValue.resourceId == 0) {
            this.f4186f = context;
        } else {
            this.f4186f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i3, int i4, boolean z3) {
        return z3 ? i3 - i4 : i3 + i4;
    }

    protected int c(View view, int i3, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i4);
        return Math.max(0, (i3 - view.getMeasuredWidth()) - i5);
    }

    protected int e(View view, int i3, int i4, int i5, boolean z3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i4 + ((i5 - measuredHeight) / 2);
        if (z3) {
            view.layout(i3 - measuredWidth, i6, i3, measuredHeight + i6);
        } else {
            view.layout(i3, i6, i3 + measuredWidth, measuredHeight + i6);
        }
        return z3 ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.E f(int i3, long j3) {
        androidx.core.view.E e3 = this.f4190j;
        if (e3 != null) {
            e3.c();
        }
        if (i3 != 0) {
            androidx.core.view.E b3 = androidx.core.view.y.d(this).b(0.0f);
            b3.f(j3);
            b3.h(this.f4185e.d(b3, i3));
            return b3;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.E b4 = androidx.core.view.y.d(this).b(1.0f);
        b4.f(j3);
        b4.h(this.f4185e.d(b4, i3));
        return b4;
    }

    public int getAnimatedVisibility() {
        return this.f4190j != null ? this.f4185e.f4194b : getVisibility();
    }

    public int getContentHeight() {
        return this.f4189i;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.j.f11356a, AbstractC0339a.f11088c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(e.j.f11392j, 0));
        obtainStyledAttributes.recycle();
        C0229c c0229c = this.f4188h;
        if (c0229c != null) {
            c0229c.p(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4192l = false;
        }
        if (!this.f4192l) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f4192l = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f4192l = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4191k = false;
        }
        if (!this.f4191k) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f4191k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4191k = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i3);

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != getVisibility()) {
            androidx.core.view.E e3 = this.f4190j;
            if (e3 != null) {
                e3.c();
            }
            super.setVisibility(i3);
        }
    }
}
