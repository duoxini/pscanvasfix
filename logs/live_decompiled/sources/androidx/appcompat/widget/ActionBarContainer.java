package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private boolean f3805e;

    /* renamed from: f, reason: collision with root package name */
    private View f3806f;

    /* renamed from: g, reason: collision with root package name */
    private View f3807g;

    /* renamed from: h, reason: collision with root package name */
    private View f3808h;

    /* renamed from: i, reason: collision with root package name */
    Drawable f3809i;

    /* renamed from: j, reason: collision with root package name */
    Drawable f3810j;

    /* renamed from: k, reason: collision with root package name */
    Drawable f3811k;

    /* renamed from: l, reason: collision with root package name */
    boolean f3812l;

    /* renamed from: m, reason: collision with root package name */
    boolean f3813m;

    /* renamed from: n, reason: collision with root package name */
    private int f3814n;

    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.view.y.n0(this, new C0228b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f11356a);
        this.f3809i = obtainStyledAttributes.getDrawable(e.j.f11360b);
        this.f3810j = obtainStyledAttributes.getDrawable(e.j.f11368d);
        this.f3814n = obtainStyledAttributes.getDimensionPixelSize(e.j.f11392j, -1);
        boolean z3 = true;
        if (getId() == e.f.f11181G) {
            this.f3812l = true;
            this.f3811k = obtainStyledAttributes.getDrawable(e.j.f11364c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f3812l ? this.f3809i != null || this.f3810j != null : this.f3811k != null) {
            z3 = false;
        }
        setWillNotDraw(z3);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3809i;
        if (drawable != null && drawable.isStateful()) {
            this.f3809i.setState(getDrawableState());
        }
        Drawable drawable2 = this.f3810j;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f3810j.setState(getDrawableState());
        }
        Drawable drawable3 = this.f3811k;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f3811k.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f3806f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3809i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f3810j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f3811k;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3807g = findViewById(e.f.f11190a);
        this.f3808h = findViewById(e.f.f11195f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3805e || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        Drawable drawable;
        super.onLayout(z3, i3, i4, i5, i6);
        View view = this.f3806f;
        boolean z4 = true;
        boolean z5 = false;
        boolean z6 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i7 = layoutParams.bottomMargin;
            view.layout(i3, measuredHeight2 - i7, i5, measuredHeight - i7);
        }
        if (this.f3812l) {
            Drawable drawable2 = this.f3811k;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z4 = z5;
        } else {
            if (this.f3809i != null) {
                if (this.f3807g.getVisibility() == 0) {
                    this.f3809i.setBounds(this.f3807g.getLeft(), this.f3807g.getTop(), this.f3807g.getRight(), this.f3807g.getBottom());
                } else {
                    View view2 = this.f3808h;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f3809i.setBounds(0, 0, 0, 0);
                    } else {
                        this.f3809i.setBounds(this.f3808h.getLeft(), this.f3808h.getTop(), this.f3808h.getRight(), this.f3808h.getBottom());
                    }
                }
                z5 = true;
            }
            this.f3813m = z6;
            if (z6 && (drawable = this.f3810j) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            z4 = z5;
        }
        if (z4) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        int i5;
        if (this.f3807g == null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE && (i5 = this.f3814n) >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
        if (this.f3807g == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        View view = this.f3806f;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f3807g) ? a(this.f3807g) : !b(this.f3808h) ? a(this.f3808h) : 0) + a(this.f3806f), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i4) : Preference.DEFAULT_ORDER));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f3809i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f3809i);
        }
        this.f3809i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f3807g;
            if (view != null) {
                this.f3809i.setBounds(view.getLeft(), this.f3807g.getTop(), this.f3807g.getRight(), this.f3807g.getBottom());
            }
        }
        boolean z3 = false;
        if (!this.f3812l ? !(this.f3809i != null || this.f3810j != null) : this.f3811k == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f3811k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f3811k);
        }
        this.f3811k = drawable;
        boolean z3 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3812l && (drawable2 = this.f3811k) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f3812l ? !(this.f3809i != null || this.f3810j != null) : this.f3811k == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f3810j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f3810j);
        }
        this.f3810j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3813m && (drawable2 = this.f3810j) != null) {
                drawable2.setBounds(this.f3806f.getLeft(), this.f3806f.getTop(), this.f3806f.getRight(), this.f3806f.getBottom());
            }
        }
        boolean z3 = false;
        if (!this.f3812l ? !(this.f3809i != null || this.f3810j != null) : this.f3811k == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(O o3) {
        View view = this.f3806f;
        if (view != null) {
            removeView(view);
        }
        this.f3806f = o3;
    }

    public void setTransitioning(boolean z3) {
        this.f3805e = z3;
        setDescendantFocusability(z3 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f3809i;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
        Drawable drawable2 = this.f3810j;
        if (drawable2 != null) {
            drawable2.setVisible(z3, false);
        }
        Drawable drawable3 = this.f3811k;
        if (drawable3 != null) {
            drawable3.setVisible(z3, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f3809i && !this.f3812l) || (drawable == this.f3810j && this.f3813m) || ((drawable == this.f3811k && this.f3812l) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback, i3);
        }
        return null;
    }
}
