package com.coui.appcompat.dialog.widget;

import M1.f;
import P1.d;
import P1.g;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.J;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.statement.COUIMaxHeightScrollView;
import com.oplus.graphics.OplusOutline;
import com.oplus.graphics.OplusOutlineAdapter;
import d0.AbstractC0335a;
import h0.AbstractC0371a;
import n0.AbstractC0481a;
import y0.j;

/* loaded from: classes.dex */
public class COUIAlertDialogMaxLinearLayout extends LinearLayout {

    /* renamed from: A, reason: collision with root package name */
    private COUIButtonBarLayout f7701A;

    /* renamed from: B, reason: collision with root package name */
    private COUIAlertDialogMessageView f7702B;

    /* renamed from: C, reason: collision with root package name */
    private LinearLayout f7703C;

    /* renamed from: D, reason: collision with root package name */
    private View f7704D;

    /* renamed from: E, reason: collision with root package name */
    private View f7705E;

    /* renamed from: F, reason: collision with root package name */
    private int f7706F;

    /* renamed from: G, reason: collision with root package name */
    private int f7707G;

    /* renamed from: H, reason: collision with root package name */
    private int f7708H;

    /* renamed from: I, reason: collision with root package name */
    private int f7709I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f7710J;

    /* renamed from: K, reason: collision with root package name */
    private int f7711K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f7712L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f7713M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f7714N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f7715O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f7716P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f7717Q;

    /* renamed from: R, reason: collision with root package name */
    private int f7718R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f7719S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f7720T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f7721U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f7722V;

    /* renamed from: W, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f7723W;

    /* renamed from: e, reason: collision with root package name */
    private final String f7724e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f7725f;

    /* renamed from: g, reason: collision with root package name */
    private int f7726g;

    /* renamed from: h, reason: collision with root package name */
    private int f7727h;

    /* renamed from: i, reason: collision with root package name */
    private int f7728i;

    /* renamed from: j, reason: collision with root package name */
    private int f7729j;

    /* renamed from: k, reason: collision with root package name */
    private int f7730k;

    /* renamed from: l, reason: collision with root package name */
    private int f7731l;

    /* renamed from: m, reason: collision with root package name */
    private int f7732m;

    /* renamed from: n, reason: collision with root package name */
    private int f7733n;

    /* renamed from: o, reason: collision with root package name */
    private int f7734o;

    /* renamed from: p, reason: collision with root package name */
    private int f7735p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7736q;

    /* renamed from: r, reason: collision with root package name */
    private int f7737r;

    /* renamed from: s, reason: collision with root package name */
    private int f7738s;

    /* renamed from: t, reason: collision with root package name */
    private View f7739t;

    /* renamed from: u, reason: collision with root package name */
    private View f7740u;

    /* renamed from: v, reason: collision with root package name */
    private FrameLayout f7741v;

    /* renamed from: w, reason: collision with root package name */
    private FrameLayout f7742w;

    /* renamed from: x, reason: collision with root package name */
    private COUIMaxHeightNestedScrollView f7743x;

    /* renamed from: y, reason: collision with root package name */
    private COUIMaxHeightScrollView f7744y;

    /* renamed from: z, reason: collision with root package name */
    private COUIDialogTitle f7745z;

    class a implements View.OnApplyWindowInsetsListener {
        a() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            COUIAlertDialogMaxLinearLayout.this.h();
            return windowInsets;
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            COUIAlertDialogMaxLinearLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            COUIAlertDialogMaxLinearLayout.this.f();
            return true;
        }
    }

    class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            COUIAlertDialogMaxLinearLayout.this.setOutLineProviderInternal(outline);
        }
    }

    public COUIAlertDialogMaxLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7724e = "DialogMaxLinearLayout";
        this.f7725f = new Rect();
        this.f7729j = -1;
        this.f7730k = -1;
        this.f7708H = 5;
        this.f7712L = false;
        this.f7713M = false;
        this.f7714N = false;
        this.f7715O = false;
        this.f7717Q = false;
        this.f7719S = false;
        this.f7720T = false;
        this.f7721U = false;
        this.f7722V = false;
        this.f7723W = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f1852o);
        this.f7726g = obtainStyledAttributes.getDimensionPixelSize(g.f1855r, 0);
        this.f7727h = obtainStyledAttributes.getDimensionPixelSize(g.f1854q, 0);
        this.f7731l = getResources().getDimensionPixelSize(P1.b.f1796u);
        this.f7732m = getResources().getDimensionPixelSize(P1.b.f1794s);
        int dimensionPixelSize = getResources().getDimensionPixelSize(P1.b.f1771T);
        this.f7734o = dimensionPixelSize;
        this.f7733n = dimensionPixelSize;
        this.f7735p = getResources().getDimensionPixelSize(P1.b.f1770S);
        this.f7737r = getResources().getDimensionPixelSize(P1.b.f1768Q);
        this.f7738s = getResources().getDimensionPixelSize(P1.b.f1769R);
        this.f7706F = getResources().getDimensionPixelSize(P1.b.f1793r);
        this.f7707G = getResources().getDimensionPixelSize(P1.b.f1793r);
        this.f7709I = getResources().getDimensionPixelSize(P1.b.f1799x);
        this.f7713M = AbstractC0481a.f();
        this.f7711K = obtainStyledAttributes.getDimensionPixelSize(g.f1853p, -1);
        obtainStyledAttributes.recycle();
    }

    private boolean d() {
        return this.f7719S || this.f7720T || this.f7721U || this.f7722V;
    }

    private int e(int i3, int i4) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), i4), View.MeasureSpec.getMode(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i3;
        if (this.f7740u == null || this.f7701A == null) {
            AbstractC0371a.c("DialogMaxLinearLayout", "performFirstLayoutAdjust: required views are null, skip adjustment");
            return;
        }
        getWindowVisibleDisplayFrame(this.f7725f);
        int height = this.f7725f.height() - this.f7733n;
        int measuredHeight = getMeasuredHeight() - this.f7733n;
        if (this.f7740u.getMeasuredHeight() <= 0 || (i3 = this.f7728i) <= 0 || measuredHeight >= i3 || height < i3) {
            return;
        }
        int max = Math.max(0, Math.round((i3 - measuredHeight) / 2.0f));
        COUIDialogTitle cOUIDialogTitle = this.f7745z;
        if (cOUIDialogTitle != null) {
            int paddingStart = cOUIDialogTitle.getPaddingStart();
            int paddingEnd = this.f7745z.getPaddingEnd();
            COUIDialogTitle cOUIDialogTitle2 = this.f7745z;
            cOUIDialogTitle2.setPaddingRelative(paddingStart, cOUIDialogTitle2.getPaddingTop() + max, paddingEnd, this.f7745z.getPaddingBottom() + max);
        }
        int i4 = this.f7728i;
        int i5 = this.f7733n;
        int i6 = i4 + i5;
        int i7 = height + i5;
        int i8 = this.f7727h;
        if (i8 > 0) {
            i7 = Math.min(i7, i8);
        }
        if (getChildAt(0) != null) {
            getChildAt(0).setMinimumHeight(this.f7728i);
        }
        setMinimumHeight(Math.min(i6, i7));
        this.f7740u.setMinimumHeight(this.f7728i - ((View) this.f7701A.getParent()).getMeasuredHeight());
        requestLayout();
    }

    private void g() {
        if (this.f7718R > 0) {
            InsetDrawable insetDrawable = (InsetDrawable) getBackground();
            insetDrawable.getPadding(this.f7725f);
            Rect rect = this.f7725f;
            int i3 = this.f7718R;
            rect.bottom = i3;
            this.f7727h += i3 - this.f7734o;
            AbstractC0371a.a("DialogMaxLinearLayout", "refresh paddingBottom:" + this.f7725f.top);
            Drawable drawable = insetDrawable.getDrawable();
            Rect rect2 = this.f7725f;
            setBackground(new InsetDrawable(drawable, rect2.left, rect2.top, rect2.right, rect2.bottom));
            Rect rect3 = this.f7725f;
            this.f7733n = rect3.top + rect3.bottom;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Insets insets;
        Activity c3 = j.c(getContext());
        boolean z3 = true;
        if (c3 != null) {
            boolean z4 = (c3.getWindow().getDecorView().getRootWindowInsets() == null || (insets = c3.getWindow().getDecorView().getRootWindowInsets().getInsets(J.l.g())) == null || insets.top != 0) ? false : true;
            boolean z5 = (c3.getWindow().getAttributes().flags & 1024) == 1024;
            boolean z6 = (c3.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4;
            if (!z5 && !z6) {
                z3 = z4;
            }
        } else {
            z3 = getRootView().getRootWindowInsets() != null ? true ^ getRootView().getRootWindowInsets().isVisible(J.l.g()) : false;
        }
        if (this.f7716P != z3 && (getBackground() instanceof InsetDrawable)) {
            InsetDrawable insetDrawable = (InsetDrawable) getBackground();
            insetDrawable.getPadding(this.f7725f);
            if (z3) {
                Rect rect = this.f7725f;
                int i3 = rect.bottom;
                rect.top = i3;
                this.f7727h += i3;
            } else {
                Rect rect2 = this.f7725f;
                rect2.top = 0;
                this.f7727h -= rect2.bottom;
            }
            AbstractC0371a.a("DialogMaxLinearLayout", "refresh paddingTop:" + this.f7725f.top);
            Drawable drawable = insetDrawable.getDrawable();
            Rect rect3 = this.f7725f;
            setBackground(new InsetDrawable(drawable, rect3.left, rect3.top, rect3.right, rect3.bottom));
            Rect rect4 = this.f7725f;
            this.f7733n = rect4.top + rect4.bottom;
        }
        this.f7716P = z3;
    }

    private void i() {
        int i3;
        if (this.f7711K == -1) {
            if (this.f7714N) {
                if (!this.f7713M) {
                    i3 = M1.c.f1343A;
                } else if (j()) {
                    i3 = M1.c.f1344B;
                } else {
                    if (AbstractC0481a.a() == 1) {
                        i3 = M1.c.f1343A;
                    }
                    i3 = 0;
                }
                this.f7711K = AbstractC0335a.c(getContext(), i3);
            } else {
                if (!this.f7713M) {
                    i3 = M1.c.f1349G;
                } else if (j()) {
                    i3 = M1.c.f1350H;
                } else {
                    if (AbstractC0481a.a() == 1) {
                        i3 = M1.c.f1349G;
                    }
                    i3 = 0;
                }
                this.f7711K = AbstractC0335a.c(getContext(), i3);
            }
        }
        if (this.f7711K > 0) {
            setClipToOutline(true);
            setOutlineProvider(new c());
        }
    }

    private boolean j() {
        return AbstractC0481a.a() == 0 || this.f7712L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutLineProviderInternal(Outline outline) {
        int measuredWidth;
        int measuredHeight;
        int i3;
        int i4;
        if (this.f7714N || this.f7715O) {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
            if (this.f7715O) {
                measuredHeight += this.f7711K;
            }
            i3 = 0;
            i4 = 0;
        } else {
            int i5 = this.f7735p;
            int i6 = this.f7718R;
            int i7 = i6 > 0 ? this.f7733n - i6 : this.f7733n - this.f7734o;
            measuredWidth = getMeasuredWidth() - (this.f7735p * 2);
            measuredHeight = getMeasuredHeight() - this.f7733n;
            i3 = i5;
            i4 = i7;
        }
        if (!AbstractC0481a.g(this.f7712L)) {
            outline.setRoundRect(i3, i4, i3 + measuredWidth, i4 + measuredHeight, this.f7711K);
        } else if (j()) {
            new OplusOutline(outline).setSmoothRoundRect(i3, i4, i3 + measuredWidth, i4 + measuredHeight, this.f7711K, this.f7714N ? AbstractC0335a.i(getContext(), f.f1462v) : AbstractC0335a.i(getContext(), f.f1463w));
        } else if (AbstractC0481a.a() == 1) {
            new OplusOutlineAdapter(outline, AbstractC0481a.a()).setSmoothRoundRect(i3, i4, i3 + measuredWidth, i4 + measuredHeight, this.f7711K);
        }
        AbstractC0371a.d("DialogMaxLinearLayout", "getOutline: mBlurBackgroundWindow = " + this.f7712L + " isSupportRoundCornerWhenBlur=" + AbstractC0481a.e() + " mIsSupportSmoothRoundCorner=" + this.f7713M + " mRadius=" + this.f7711K);
    }

    public int getMaxWidth() {
        return this.f7726g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.f7717Q) {
            getRootView().setOnApplyWindowInsetsListener(this.f7723W);
        } else {
            h();
        }
        Drawable drawable = getContext().getDrawable(P1.c.f1802a);
        if (((drawable instanceof NinePatchDrawable) || (drawable instanceof BitmapDrawable)) && !this.f7715O) {
            AbstractC0371a.f("DialogMaxLinearLayout", "Use theme background,no need to clipCorner!");
        } else {
            i();
        }
        g();
        if (d()) {
            getViewTreeObserver().addOnPreDrawListener(new b());
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        getRootView().setOnApplyWindowInsetsListener(null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        View findViewById;
        COUIAlertDialogMessageView cOUIAlertDialogMessageView;
        FrameLayout frameLayout;
        int i7;
        COUIMaxHeightScrollView cOUIMaxHeightScrollView;
        int measuredHeight;
        int i8 = this.f7726g;
        if (i8 > 0) {
            i3 = e(i3, i8);
        }
        int i9 = this.f7727h;
        if (i9 > 0) {
            i4 = e(i4, i9);
        }
        super.onMeasure(i3, i4);
        int measuredHeight2 = getMeasuredHeight();
        if (this.f7744y == null) {
            try {
                this.f7740u = findViewById(d.f1828y);
                this.f7741v = (FrameLayout) findViewById(d.f1815l);
                this.f7742w = (FrameLayout) findViewById(d.f1812i);
                this.f7739t = findViewById(d.f1809f);
                this.f7745z = (COUIDialogTitle) findViewById(d.f1804a);
                this.f7702B = (COUIAlertDialogMessageView) findViewById(R.id.message);
                this.f7743x = (COUIMaxHeightNestedScrollView) findViewById(d.f1824u);
                this.f7744y = (COUIMaxHeightScrollView) findViewById(d.f1805b);
                this.f7701A = (COUIButtonBarLayout) findViewById(d.f1807d);
            } catch (Exception e3) {
                Log.e("DialogMaxLinearLayout", "Failed to get type conversion. message e:" + e3.getMessage());
                this.f7736q = false;
                return;
            }
        }
        if (this.f7702B != null) {
            i5 = this.f7702B.getLineCount();
            i6 = this.f7745z.getLineCount();
        } else {
            i5 = 0;
            i6 = 0;
        }
        getWindowVisibleDisplayFrame(this.f7725f);
        int height = this.f7725f.height();
        int i10 = this.f7733n;
        int i11 = height - i10;
        int i12 = measuredHeight2 - i10;
        if (measuredHeight2 <= 0 || i12 >= (i7 = this.f7728i) || i11 < i7) {
            if (this.f7730k != -1) {
                boolean z3 = i6 > 1;
                boolean z4 = i5 > 1;
                boolean z5 = this.f7701A.getButtonCount() > 1 && this.f7701A.getOrientation() == 1;
                FrameLayout frameLayout2 = this.f7742w;
                boolean z6 = frameLayout2 != null && frameLayout2.getMeasuredHeight() > this.f7738s;
                if ((z3 || z4 || z5 || z6) && (findViewById = findViewById(this.f7730k)) != null && findViewById.getPaddingTop() != this.f7731l) {
                    findViewById.setPadding(findViewById.getPaddingStart(), this.f7731l, findViewById.getPaddingEnd(), this.f7732m);
                    super.onMeasure(i3, i4);
                }
            }
        } else if (this.f7729j != -1 && !d() && (cOUIMaxHeightScrollView = (COUIMaxHeightScrollView) findViewById(this.f7729j)) != null && cOUIMaxHeightScrollView.getMinHeight() != (measuredHeight = cOUIMaxHeightScrollView.getMeasuredHeight() + (this.f7728i - i12))) {
            cOUIMaxHeightScrollView.setMinHeight(measuredHeight);
            super.onMeasure(i3, i4);
        }
        COUIAlertDialogMessageView cOUIAlertDialogMessageView2 = this.f7702B;
        boolean z7 = (cOUIAlertDialogMessageView2 == null || TextUtils.isEmpty(cOUIAlertDialogMessageView2.getText())) ? false : true;
        FrameLayout frameLayout3 = this.f7742w;
        boolean z8 = frameLayout3 != null && frameLayout3.getChildCount() > 0;
        COUIDialogTitle cOUIDialogTitle = this.f7745z;
        if (cOUIDialogTitle == null || TextUtils.isEmpty(cOUIDialogTitle.getText())) {
            return;
        }
        if ((z7 || z8) && this.f7736q) {
            if (this.f7703C != null && (((cOUIAlertDialogMessageView = this.f7702B) != null && cOUIAlertDialogMessageView.getParent() == this.f7703C) || ((frameLayout = this.f7742w) != null && frameLayout.getParent() == this.f7703C))) {
                COUIAlertDialogMessageView cOUIAlertDialogMessageView3 = this.f7702B;
                if (cOUIAlertDialogMessageView3 != null) {
                    ViewParent parent = cOUIAlertDialogMessageView3.getParent();
                    LinearLayout linearLayout = this.f7703C;
                    if (parent == linearLayout) {
                        linearLayout.removeView(this.f7702B);
                        View view = this.f7704D;
                        if (view != null) {
                            this.f7703C.removeView(view);
                        }
                        View view2 = this.f7705E;
                        if (view2 != null) {
                            this.f7703C.removeView(view2);
                        }
                        COUIAlertDialogMessageView cOUIAlertDialogMessageView4 = this.f7702B;
                        cOUIAlertDialogMessageView4.setPaddingRelative(this.f7706F, cOUIAlertDialogMessageView4.getPaddingTop(), this.f7707G, this.f7702B.getPaddingBottom());
                        this.f7743x.addView(this.f7702B);
                    }
                }
                FrameLayout frameLayout4 = this.f7742w;
                if (frameLayout4 != null) {
                    ViewParent parent2 = frameLayout4.getParent();
                    LinearLayout linearLayout2 = this.f7703C;
                    if (parent2 == linearLayout2) {
                        linearLayout2.removeView(this.f7742w);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7742w.getLayoutParams();
                        marginLayoutParams.setMarginStart(marginLayoutParams.getMarginStart() + (this.f7706F - this.f7708H));
                        this.f7741v.addView(this.f7742w);
                    }
                }
                if (this.f7710J && this.f7701A != null && (this.f7701A.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    this.f7701A.setTopMarginFlag(true);
                }
                super.onMeasure(i3, i4);
            }
            if (COUIResponsiveUtils.isSmallScreenDp(j.p(getContext(), j.j(getContext()))) && ((z7 && this.f7739t.getMeasuredHeight() < this.f7737r) || (z8 && this.f7742w.getMeasuredHeight() < this.f7738s))) {
                if (this.f7703C == null) {
                    this.f7703C = new LinearLayout(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 48;
                    this.f7703C.setLayoutParams(layoutParams);
                    this.f7703C.setOrientation(1);
                    this.f7744y.removeAllViews();
                    this.f7744y.addView(this.f7703C);
                    this.f7703C.addView(this.f7745z);
                    if (z7) {
                        this.f7704D = new View(getContext());
                        this.f7704D.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f7731l));
                    }
                    if (z8) {
                        this.f7705E = new View(getContext());
                        this.f7705E.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f7731l));
                    }
                }
                if (z7 && this.f7702B.getParent() != this.f7703C) {
                    COUIAlertDialogMessageView cOUIAlertDialogMessageView5 = this.f7702B;
                    cOUIAlertDialogMessageView5.setPaddingRelative(0, cOUIAlertDialogMessageView5.getPaddingTop(), 0, this.f7702B.getPaddingBottom());
                    this.f7743x.removeView(this.f7702B);
                    this.f7703C.addView(this.f7704D);
                    this.f7703C.addView(this.f7702B);
                }
                if (z8 && this.f7742w.getParent() != this.f7703C) {
                    this.f7741v.removeView(this.f7742w);
                    LinearLayoutCompat.a aVar = new LinearLayoutCompat.a(-2, -2);
                    aVar.setMarginStart(aVar.getMarginStart() - (this.f7706F - this.f7708H));
                    this.f7703C.addView(this.f7705E);
                    this.f7703C.addView(this.f7742w, aVar);
                }
                if (this.f7701A != null && (this.f7701A.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f7701A.getLayoutParams();
                    if (marginLayoutParams2.topMargin == this.f7709I) {
                        marginLayoutParams2.topMargin = 0;
                        this.f7701A.setLayoutParams(marginLayoutParams2);
                        this.f7710J = true;
                        this.f7701A.setTopMarginFlag(false);
                    }
                }
                super.onMeasure(i3, i4);
            }
            if (this.f7701A != null) {
                COUIMaxHeightNestedScrollView cOUIMaxHeightNestedScrollView = (COUIMaxHeightNestedScrollView) this.f7701A.getParent();
                cOUIMaxHeightNestedScrollView.setMaxHeight(-1);
                super.onMeasure(i3, i4);
                int measuredHeight3 = this.f7740u.getMeasuredHeight() + this.f7739t.getMeasuredHeight() + this.f7741v.getMeasuredHeight() + cOUIMaxHeightNestedScrollView.getMeasuredHeight() + this.f7733n;
                if (measuredHeight3 > getMeasuredHeight()) {
                    cOUIMaxHeightNestedScrollView.setMaxHeight(getMeasuredHeight() - (measuredHeight3 - cOUIMaxHeightNestedScrollView.getMeasuredHeight()));
                    super.onMeasure(i3, i4);
                }
            }
        }
    }

    public void setBlurBackgroundWindow(boolean z3) {
        this.f7712L = z3;
    }

    public void setCustomDialogPaddingBottom(int i3) {
        if (i3 >= this.f7734o) {
            this.f7718R = i3;
        } else {
            AbstractC0371a.c("DialogMaxLinearLayout", "setCustomDialogPaddingBottom can't be less than 24dp");
        }
    }

    public void setHasLoading(boolean z3) {
        this.f7714N = z3;
    }

    public void setHasMessageMerge(boolean z3) {
        this.f7736q = z3;
    }

    @Deprecated
    public void setIsSupportRoundCornerWhenBlur(boolean z3) {
    }

    public void setIsTiny(boolean z3) {
        this.f7715O = z3;
    }

    public void setMaxHeight(int i3) {
        this.f7727h = i3;
    }

    public void setMaxWidth(int i3) {
        this.f7726g = i3;
    }

    public void setNeedMinHeight(int i3) {
        this.f7728i = i3;
    }

    public void setNeedReMeasureLayoutId(int i3) {
        this.f7729j = i3;
    }

    public void setNeedSetPaddingLayoutId(int i3) {
        this.f7730k = i3;
    }

    public void setSupportDynamicMarginTop(boolean z3) {
        this.f7717Q = z3;
    }
}
