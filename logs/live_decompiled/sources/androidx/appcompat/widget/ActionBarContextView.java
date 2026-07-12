package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0227a {

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f3815m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f3816n;

    /* renamed from: o, reason: collision with root package name */
    private View f3817o;

    /* renamed from: p, reason: collision with root package name */
    private View f3818p;

    /* renamed from: q, reason: collision with root package name */
    private View f3819q;

    /* renamed from: r, reason: collision with root package name */
    private LinearLayout f3820r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f3821s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f3822t;

    /* renamed from: u, reason: collision with root package name */
    private int f3823u;

    /* renamed from: v, reason: collision with root package name */
    private int f3824v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3825w;

    /* renamed from: x, reason: collision with root package name */
    private int f3826x;

    class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f3827e;

        a(androidx.appcompat.view.b bVar) {
            this.f3827e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f3827e.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f3820r == null) {
            LayoutInflater.from(getContext()).inflate(e.g.f11216a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f3820r = linearLayout;
            this.f3821s = (TextView) linearLayout.findViewById(e.f.f11194e);
            this.f3822t = (TextView) this.f3820r.findViewById(e.f.f11193d);
            if (this.f3823u != 0) {
                this.f3821s.setTextAppearance(getContext(), this.f3823u);
            }
            if (this.f3824v != 0) {
                this.f3822t.setTextAppearance(getContext(), this.f3824v);
            }
        }
        this.f3821s.setText(this.f3815m);
        this.f3822t.setText(this.f3816n);
        boolean isEmpty = TextUtils.isEmpty(this.f3815m);
        boolean isEmpty2 = TextUtils.isEmpty(this.f3816n);
        this.f3822t.setVisibility(!isEmpty2 ? 0 : 8);
        this.f3820r.setVisibility((isEmpty && isEmpty2) ? 8 : 0);
        if (this.f3820r.getParent() == null) {
            addView(this.f3820r);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0227a
    public /* bridge */ /* synthetic */ androidx.core.view.E f(int i3, long j3) {
        return super.f(i3, j3);
    }

    public void g() {
        if (this.f3817o == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0227a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0227a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f3816n;
    }

    public CharSequence getTitle() {
        return this.f3815m;
    }

    public void h(androidx.appcompat.view.b bVar) {
        View view = this.f3817o;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f3826x, (ViewGroup) this, false);
            this.f3817o = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f3817o);
        }
        View findViewById = this.f3817o.findViewById(e.f.f11198i);
        this.f3818p = findViewById;
        findViewById.setOnClickListener(new a(bVar));
        MenuBuilder menuBuilder = (MenuBuilder) bVar.c();
        C0229c c0229c = this.f4188h;
        if (c0229c != null) {
            c0229c.i();
        }
        C0229c c0229c2 = new C0229c(getContext());
        this.f4188h = c0229c2;
        c0229c2.t(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.f4188h, this.f4186f);
        ActionMenuView actionMenuView = (ActionMenuView) this.f4188h.getMenuView(this);
        this.f4187g = actionMenuView;
        androidx.core.view.y.n0(actionMenuView, null);
        addView(this.f4187g, layoutParams);
    }

    public boolean j() {
        return this.f3825w;
    }

    public void k() {
        removeAllViews();
        this.f3819q = null;
        this.f4187g = null;
        this.f4188h = null;
        View view = this.f3818p;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        C0229c c0229c = this.f4188h;
        if (c0229c != null) {
            return c0229c.u();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0229c c0229c = this.f4188h;
        if (c0229c != null) {
            c0229c.l();
            this.f4188h.m();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0227a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        boolean b3 = b0.b(this);
        int paddingRight = b3 ? (i5 - i3) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.f3817o;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3817o.getLayoutParams();
            int i7 = b3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = b3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d3 = AbstractC0227a.d(paddingRight, i7, b3);
            paddingRight = AbstractC0227a.d(d3 + e(this.f3817o, d3, paddingTop, paddingTop2, b3), i8, b3);
        }
        int i9 = paddingRight;
        LinearLayout linearLayout = this.f3820r;
        if (linearLayout != null && this.f3819q == null && linearLayout.getVisibility() != 8) {
            i9 += e(this.f3820r, i9, paddingTop, paddingTop2, b3);
        }
        int i10 = i9;
        View view2 = this.f3819q;
        if (view2 != null) {
            e(view2, i10, paddingTop, paddingTop2, b3);
        }
        int paddingLeft = b3 ? getPaddingLeft() : (i5 - i3) - getPaddingRight();
        ActionMenuView actionMenuView = this.f4187g;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b3);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i4) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i3);
        int i5 = this.f4189i;
        if (i5 <= 0) {
            i5 = View.MeasureSpec.getSize(i4);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i6 = i5 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        View view = this.f3817o;
        if (view != null) {
            int c3 = c(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3817o.getLayoutParams();
            paddingLeft = c3 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f4187g;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f4187g, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f3820r;
        if (linearLayout != null && this.f3819q == null) {
            if (this.f3825w) {
                this.f3820r.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f3820r.getMeasuredWidth();
                boolean z3 = measuredWidth <= paddingLeft;
                if (z3) {
                    paddingLeft -= measuredWidth;
                }
                this.f3820r.setVisibility(z3 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.f3819q;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i7 = layoutParams.width;
            int i8 = i7 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i7 >= 0) {
                paddingLeft = Math.min(i7, paddingLeft);
            }
            int i9 = layoutParams.height;
            int i10 = i9 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i9 >= 0) {
                i6 = Math.min(i9, i6);
            }
            this.f3819q.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i8), View.MeasureSpec.makeMeasureSpec(i6, i10));
        }
        if (this.f4189i > 0) {
            setMeasuredDimension(size, i5);
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i11) {
                i11 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i11);
    }

    @Override // androidx.appcompat.widget.AbstractC0227a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0227a
    public void setContentHeight(int i3) {
        this.f4189i = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f3819q;
        if (view2 != null) {
            removeView(view2);
        }
        this.f3819q = view;
        if (view != null && (linearLayout = this.f3820r) != null) {
            removeView(linearLayout);
            this.f3820r = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3816n = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3815m = charSequence;
        i();
        androidx.core.view.y.m0(this, charSequence);
    }

    public void setTitleOptional(boolean z3) {
        if (z3 != this.f3825w) {
            requestLayout();
        }
        this.f3825w = z3;
    }

    @Override // androidx.appcompat.widget.AbstractC0227a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11092g);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        V w3 = V.w(context, attributeSet, e.j.f11452y, i3, 0);
        androidx.core.view.y.n0(this, w3.g(e.j.f11456z));
        this.f3823u = w3.n(e.j.f11266D, 0);
        this.f3824v = w3.n(e.j.f11262C, 0);
        this.f4189i = w3.m(e.j.f11258B, 0);
        this.f3826x = w3.n(e.j.f11254A, e.g.f11219d);
        w3.x();
    }
}
