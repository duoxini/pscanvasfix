package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import r0.C0559a;
import r0.C0561c;

/* loaded from: classes.dex */
public class ListSelectedItemLayout extends d implements com.coui.appcompat.list.c {

    /* renamed from: e, reason: collision with root package name */
    private final RectF f8746e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8747f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8748g;

    /* renamed from: h, reason: collision with root package name */
    private C0561c f8749h;

    /* renamed from: i, reason: collision with root package name */
    private C0559a f8750i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f8751j;

    /* renamed from: k, reason: collision with root package name */
    protected int f8752k;

    /* renamed from: l, reason: collision with root package name */
    protected Interpolator f8753l;

    /* renamed from: m, reason: collision with root package name */
    protected Interpolator f8754m;

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(MotionEvent motionEvent) {
        if (isEnabled() && isClickable() && this.f8747f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                d();
            } else if (action == 1 || action == 3) {
                f();
            }
        }
    }

    private void c() {
        this.f8750i = new C0559a(getContext(), 1);
        Path layoutPath = getLayoutPath();
        if (layoutPath != null) {
            this.f8750i.C(layoutPath);
        } else {
            this.f8750i.D(this.f8746e, 0.0f, 0.0f);
        }
        C0561c c0561c = new C0561c(new Drawable[]{getBackground() == null ? new ColorDrawable(0) : getBackground(), this.f8750i});
        this.f8749h = c0561c;
        c0561c.i(this.f8747f);
        super.setBackground(this.f8749h);
    }

    public void a(boolean z3) {
        this.f8748g = z3;
    }

    public void d() {
        e(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f8748g) {
            if (isEnabled() && motionEvent.getActionMasked() == 9) {
                this.f8750i.A(true, true, true);
            }
            if (motionEvent.getActionMasked() == 10) {
                this.f8750i.A(false, false, true);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f8748g) {
            b(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(boolean z3) {
        C0561c c0561c = this.f8749h;
        if (c0561c == null) {
            return;
        }
        if (!z3) {
            c0561c.i(false);
        }
        this.f8749h.g(true);
        if (z3) {
            return;
        }
        this.f8749h.i(true);
    }

    public void f() {
        g(true);
    }

    public void g(boolean z3) {
        C0561c c0561c = this.f8749h;
        if (c0561c == null) {
            return;
        }
        if (!z3) {
            c0561c.i(false);
        }
        this.f8749h.g(false);
        if (z3) {
            return;
        }
        this.f8749h.i(true);
    }

    protected Path getLayoutPath() {
        return null;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f8746e.set(0.0f, 0.0f, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f8748g) {
            b(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        C0561c c0561c = this.f8749h;
        if (c0561c == null) {
            super.setBackground(drawable);
        } else if (drawable == null) {
            c0561c.h(new ColorDrawable(0));
        } else {
            c0561c.h(drawable);
        }
    }

    @Deprecated
    public void setBackgroundAnimationDrawable(Drawable drawable) {
    }

    public void setBackgroundAnimationEnabled(boolean z3) {
        this.f8747f = z3;
        C0561c c0561c = this.f8749h;
        if (c0561c == null) {
            return;
        }
        c0561c.i(z3);
    }

    public void setConfigurationChangeListener(com.coui.appcompat.list.b bVar) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        if (!z3 && isEnabled()) {
            f();
        }
        super.setEnabled(z3);
    }

    public void setPositionInGroup(int i3) {
    }

    public void setPressScaleEffectEnable(boolean z3) {
        C0561c c0561c = this.f8749h;
        if (c0561c == null) {
            return;
        }
        if (z3) {
            c0561c.b(this);
        } else {
            c0561c.a();
        }
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8746e = new RectF();
        this.f8747f = true;
        this.f8748g = false;
        this.f8751j = false;
        this.f8752k = 2;
        this.f8753l = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        this.f8754m = new Y.d();
        c();
        setDefaultFocusHighlightEnabled(false);
    }
}
