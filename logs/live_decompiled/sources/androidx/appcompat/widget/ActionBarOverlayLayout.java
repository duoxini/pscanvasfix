package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.J;
import androidx.preference.Preference;
import e.AbstractC0339a;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements C, androidx.core.view.q, androidx.core.view.r {

    /* renamed from: J, reason: collision with root package name */
    static final int[] f3829J = {AbstractC0339a.f11087b, R.attr.windowContentOverlay};

    /* renamed from: A, reason: collision with root package name */
    private androidx.core.view.J f3830A;

    /* renamed from: B, reason: collision with root package name */
    private androidx.core.view.J f3831B;

    /* renamed from: C, reason: collision with root package name */
    private d f3832C;

    /* renamed from: D, reason: collision with root package name */
    private OverScroller f3833D;

    /* renamed from: E, reason: collision with root package name */
    ViewPropertyAnimator f3834E;

    /* renamed from: F, reason: collision with root package name */
    final AnimatorListenerAdapter f3835F;

    /* renamed from: G, reason: collision with root package name */
    private final Runnable f3836G;

    /* renamed from: H, reason: collision with root package name */
    private final Runnable f3837H;

    /* renamed from: I, reason: collision with root package name */
    private final androidx.core.view.s f3838I;

    /* renamed from: e, reason: collision with root package name */
    private int f3839e;

    /* renamed from: f, reason: collision with root package name */
    private int f3840f;

    /* renamed from: g, reason: collision with root package name */
    private ContentFrameLayout f3841g;

    /* renamed from: h, reason: collision with root package name */
    ActionBarContainer f3842h;

    /* renamed from: i, reason: collision with root package name */
    private D f3843i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f3844j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3845k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3846l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3847m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3848n;

    /* renamed from: o, reason: collision with root package name */
    boolean f3849o;

    /* renamed from: p, reason: collision with root package name */
    private int f3850p;

    /* renamed from: q, reason: collision with root package name */
    private int f3851q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f3852r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f3853s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f3854t;

    /* renamed from: u, reason: collision with root package name */
    private final Rect f3855u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f3856v;

    /* renamed from: w, reason: collision with root package name */
    private final Rect f3857w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f3858x;

    /* renamed from: y, reason: collision with root package name */
    private androidx.core.view.J f3859y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.core.view.J f3860z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3834E = null;
            actionBarOverlayLayout.f3849o = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3834E = null;
            actionBarOverlayLayout.f3849o = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3834E = actionBarOverlayLayout.f3842h.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f3835F);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f3834E = actionBarOverlayLayout.f3842h.animate().translationY(-ActionBarOverlayLayout.this.f3842h.getHeight()).setListener(ActionBarOverlayLayout.this.f3835F);
        }
    }

    public interface d {
        void a(boolean z3);

        void b();

        void c();

        void d(int i3);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i3, int i4) {
            super(i3, i4);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3840f = 0;
        this.f3852r = new Rect();
        this.f3853s = new Rect();
        this.f3854t = new Rect();
        this.f3855u = new Rect();
        this.f3856v = new Rect();
        this.f3857w = new Rect();
        this.f3858x = new Rect();
        androidx.core.view.J j3 = androidx.core.view.J.f5026b;
        this.f3859y = j3;
        this.f3860z = j3;
        this.f3830A = j3;
        this.f3831B = j3;
        this.f3835F = new a();
        this.f3836G = new b();
        this.f3837H = new c();
        v(context);
        this.f3838I = new androidx.core.view.s(this);
    }

    private void A() {
        u();
        this.f3836G.run();
    }

    private boolean B(float f3) {
        this.f3833D.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Preference.DEFAULT_ORDER);
        return this.f3833D.getFinalY() > this.f3842h.getHeight();
    }

    private void p() {
        u();
        this.f3837H.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean q(android.view.View r2, android.graphics.Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        /*
            r1 = this;
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r1 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r1
            r2 = 1
            if (r4 == 0) goto L13
            int r4 = r1.leftMargin
            int r0 = r3.left
            if (r4 == r0) goto L13
            r1.leftMargin = r0
            r4 = r2
            goto L14
        L13:
            r4 = 0
        L14:
            if (r5 == 0) goto L1f
            int r5 = r1.topMargin
            int r0 = r3.top
            if (r5 == r0) goto L1f
            r1.topMargin = r0
            r4 = r2
        L1f:
            if (r7 == 0) goto L2a
            int r5 = r1.rightMargin
            int r7 = r3.right
            if (r5 == r7) goto L2a
            r1.rightMargin = r7
            r4 = r2
        L2a:
            if (r6 == 0) goto L35
            int r5 = r1.bottomMargin
            int r3 = r3.bottom
            if (r5 == r3) goto L35
            r1.bottomMargin = r3
            goto L36
        L35:
            r2 = r4
        L36:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private D t(View view) {
        if (view instanceof D) {
            return (D) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3829J);
        this.f3839e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f3844j = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f3845k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f3833D = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.f3837H, 600L);
    }

    private void y() {
        u();
        postDelayed(this.f3836G, 600L);
    }

    @Override // androidx.appcompat.widget.C
    public void a(Menu menu, MenuPresenter.Callback callback) {
        z();
        this.f3843i.a(menu, callback);
    }

    @Override // androidx.appcompat.widget.C
    public boolean b() {
        z();
        return this.f3843i.b();
    }

    @Override // androidx.appcompat.widget.C
    public boolean c() {
        z();
        return this.f3843i.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.C
    public boolean d() {
        z();
        return this.f3843i.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3844j == null || this.f3845k) {
            return;
        }
        int bottom = this.f3842h.getVisibility() == 0 ? (int) (this.f3842h.getBottom() + this.f3842h.getTranslationY() + 0.5f) : 0;
        this.f3844j.setBounds(0, bottom, getWidth(), this.f3844j.getIntrinsicHeight() + bottom);
        this.f3844j.draw(canvas);
    }

    @Override // androidx.appcompat.widget.C
    public boolean e() {
        z();
        return this.f3843i.e();
    }

    @Override // androidx.appcompat.widget.C
    public void f() {
        z();
        this.f3843i.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.C
    public boolean g() {
        z();
        return this.f3843i.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f3842h;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3838I.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f3843i.getTitle();
    }

    @Override // androidx.core.view.q
    public void h(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // androidx.core.view.q
    public void i(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.q
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i3, i4, iArr);
        }
    }

    @Override // androidx.appcompat.widget.C
    public void k(int i3) {
        z();
        if (i3 == 2) {
            this.f3843i.s();
        } else if (i3 == 5) {
            this.f3843i.u();
        } else {
            if (i3 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.C
    public void l() {
        z();
        this.f3843i.h();
    }

    @Override // androidx.core.view.r
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        n(view, i3, i4, i5, i6, i7);
    }

    @Override // androidx.core.view.q
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i3, i4, i5, i6);
        }
    }

    @Override // androidx.core.view.q
    public boolean o(View view, View view2, int i3, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i3);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        androidx.core.view.J w3 = androidx.core.view.J.w(windowInsets, this);
        boolean q3 = q(this.f3842h, new Rect(w3.i(), w3.k(), w3.j(), w3.h()), true, true, false, true);
        androidx.core.view.y.e(this, w3, this.f3852r);
        Rect rect = this.f3852r;
        androidx.core.view.J m3 = w3.m(rect.left, rect.top, rect.right, rect.bottom);
        this.f3859y = m3;
        boolean z3 = true;
        if (!this.f3860z.equals(m3)) {
            this.f3860z = this.f3859y;
            q3 = true;
        }
        if (this.f3853s.equals(this.f3852r)) {
            z3 = q3;
        } else {
            this.f3853s.set(this.f3852r);
        }
        if (z3) {
            requestLayout();
        }
        return w3.a().c().b().u();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        androidx.core.view.y.f0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredHeight;
        z();
        measureChildWithMargins(this.f3842h, i3, 0, i4, 0);
        e eVar = (e) this.f3842h.getLayoutParams();
        int max = Math.max(0, this.f3842h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f3842h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f3842h.getMeasuredState());
        boolean z3 = (androidx.core.view.y.H(this) & 256) != 0;
        if (z3) {
            measuredHeight = this.f3839e;
            if (this.f3847m && this.f3842h.getTabContainer() != null) {
                measuredHeight += this.f3839e;
            }
        } else {
            measuredHeight = this.f3842h.getVisibility() != 8 ? this.f3842h.getMeasuredHeight() : 0;
        }
        this.f3854t.set(this.f3852r);
        androidx.core.view.J j3 = this.f3859y;
        this.f3830A = j3;
        if (this.f3846l || z3) {
            this.f3830A = new J.b(this.f3830A).c(androidx.core.graphics.b.b(j3.i(), this.f3830A.k() + measuredHeight, this.f3830A.j(), this.f3830A.h())).a();
        } else {
            Rect rect = this.f3854t;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f3830A = j3.m(0, measuredHeight, 0, 0);
        }
        q(this.f3841g, this.f3854t, true, true, true, true);
        if (!this.f3831B.equals(this.f3830A)) {
            androidx.core.view.J j4 = this.f3830A;
            this.f3831B = j4;
            androidx.core.view.y.f(this.f3841g, j4);
        }
        measureChildWithMargins(this.f3841g, i3, 0, i4, 0);
        e eVar2 = (e) this.f3841g.getLayoutParams();
        int max3 = Math.max(max, this.f3841g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f3841g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f3841g.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        if (!this.f3848n || !z3) {
            return false;
        }
        if (B(f4)) {
            p();
        } else {
            A();
        }
        this.f3849o = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        int i7 = this.f3850p + i4;
        this.f3850p = i7;
        setActionBarHideOffset(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f3838I.b(view, view2, i3);
        this.f3850p = getActionBarHideOffset();
        u();
        d dVar = this.f3832C;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if ((i3 & 2) == 0 || this.f3842h.getVisibility() != 0) {
            return false;
        }
        return this.f3848n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f3848n && !this.f3849o) {
            if (this.f3850p <= this.f3842h.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f3832C;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i3) {
        super.onWindowSystemUiVisibilityChanged(i3);
        z();
        int i4 = this.f3851q ^ i3;
        this.f3851q = i3;
        boolean z3 = (i3 & 4) == 0;
        boolean z4 = (i3 & 256) != 0;
        d dVar = this.f3832C;
        if (dVar != null) {
            dVar.a(!z4);
            if (z3 || !z4) {
                this.f3832C.b();
            } else {
                this.f3832C.e();
            }
        }
        if ((i4 & 256) == 0 || this.f3832C == null) {
            return;
        }
        androidx.core.view.y.f0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f3840f = i3;
        d dVar = this.f3832C;
        if (dVar != null) {
            dVar.d(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i3) {
        u();
        this.f3842h.setTranslationY(-Math.max(0, Math.min(i3, this.f3842h.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f3832C = dVar;
        if (getWindowToken() != null) {
            this.f3832C.d(this.f3840f);
            int i3 = this.f3851q;
            if (i3 != 0) {
                onWindowSystemUiVisibilityChanged(i3);
                androidx.core.view.y.f0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z3) {
        this.f3847m = z3;
    }

    public void setHideOnContentScrollEnabled(boolean z3) {
        if (z3 != this.f3848n) {
            this.f3848n = z3;
            if (z3) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i3) {
        z();
        this.f3843i.setIcon(i3);
    }

    public void setLogo(int i3) {
        z();
        this.f3843i.m(i3);
    }

    public void setOverlayMode(boolean z3) {
        this.f3846l = z3;
        this.f3845k = z3 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z3) {
    }

    public void setUiOptions(int i3) {
    }

    @Override // androidx.appcompat.widget.C
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f3843i.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.C
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f3843i.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.f3836G);
        removeCallbacks(this.f3837H);
        ViewPropertyAnimator viewPropertyAnimator = this.f3834E;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f3846l;
    }

    void z() {
        if (this.f3841g == null) {
            this.f3841g = (ContentFrameLayout) findViewById(e.f.f11191b);
            this.f3842h = (ActionBarContainer) findViewById(e.f.f11192c);
            this.f3843i = t(findViewById(e.f.f11190a));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f3843i.setIcon(drawable);
    }
}
