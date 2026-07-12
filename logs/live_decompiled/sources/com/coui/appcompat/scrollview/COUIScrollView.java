package com.coui.appcompat.scrollview;

import Y.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import c2.AbstractC0299a;
import java.util.ArrayList;
import o0.b;
import o0.e;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public class COUIScrollView extends ScrollView {

    /* renamed from: A, reason: collision with root package name */
    private final int[] f8971A;

    /* renamed from: B, reason: collision with root package name */
    private int f8972B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f8973C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f8974D;

    /* renamed from: E, reason: collision with root package name */
    private a f8975E;

    /* renamed from: F, reason: collision with root package name */
    private long f8976F;

    /* renamed from: G, reason: collision with root package name */
    private int f8977G;

    /* renamed from: H, reason: collision with root package name */
    private int f8978H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f8979I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f8980J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f8981K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f8982L;

    /* renamed from: M, reason: collision with root package name */
    private float f8983M;

    /* renamed from: N, reason: collision with root package name */
    private Paint f8984N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f8985O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f8986P;

    /* renamed from: Q, reason: collision with root package name */
    private int f8987Q;

    /* renamed from: R, reason: collision with root package name */
    private float f8988R;

    /* renamed from: S, reason: collision with root package name */
    private float f8989S;

    /* renamed from: T, reason: collision with root package name */
    private float f8990T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f8991U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f8992V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f8993W;

    /* renamed from: a0, reason: collision with root package name */
    private Boolean f8994a0;

    /* renamed from: e, reason: collision with root package name */
    private int f8995e;

    /* renamed from: f, reason: collision with root package name */
    private long f8996f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f8997g;

    /* renamed from: h, reason: collision with root package name */
    private b f8998h;

    /* renamed from: i, reason: collision with root package name */
    private e f8999i;

    /* renamed from: j, reason: collision with root package name */
    private int f9000j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9001k;

    /* renamed from: l, reason: collision with root package name */
    private View f9002l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9003m;

    /* renamed from: n, reason: collision with root package name */
    private VelocityTracker f9004n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9005o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f9006p;

    /* renamed from: q, reason: collision with root package name */
    private int f9007q;

    /* renamed from: r, reason: collision with root package name */
    private int f9008r;

    /* renamed from: s, reason: collision with root package name */
    private int f9009s;

    /* renamed from: t, reason: collision with root package name */
    private int f9010t;

    /* renamed from: u, reason: collision with root package name */
    private int f9011u;

    /* renamed from: v, reason: collision with root package name */
    private float f9012v;

    /* renamed from: w, reason: collision with root package name */
    private int f9013w;

    /* renamed from: x, reason: collision with root package name */
    private float f9014x;

    /* renamed from: y, reason: collision with root package name */
    private int f9015y;

    /* renamed from: z, reason: collision with root package name */
    private final int[] f9016z;

    static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0111a();

        /* renamed from: e, reason: collision with root package name */
        public int f9017e;

        /* renamed from: com.coui.appcompat.scrollview.COUIScrollView$a$a, reason: collision with other inner class name */
        class C0111a implements Parcelable.Creator {
            C0111a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel, a.class.getClassLoader());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "ScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f9017e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f9017e);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9017e = parcel.readInt();
        }
    }

    public COUIScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean a() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    private static int b(int i3, int i4, int i5) {
        if (i4 >= i5 || i3 < 0) {
            return 0;
        }
        return i4 + i3 > i5 ? i5 - i4 : i3;
    }

    private boolean c(View view, MotionEvent motionEvent) {
        boolean z3 = true;
        int[] iArr = {0, 1};
        for (int i3 = 0; i3 < 2; i3++) {
            motionEvent.setAction(iArr[i3]);
            z3 &= view.dispatchTouchEvent(motionEvent);
        }
        return z3;
    }

    private void d(int i3) {
        if (i3 != 0) {
            if (this.f9006p) {
                A(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private void e() {
        this.f9003m = false;
        w();
        if (this.f8973C) {
            this.f8973C = false;
        }
    }

    private View f(boolean z3, int i3, int i4) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i4) {
                boolean z5 = i3 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z4 = z5;
                } else {
                    boolean z6 = (z3 && top < view.getTop()) || (!z3 && bottom > view.getBottom());
                    if (z4) {
                        if (z5) {
                            if (!z6) {
                            }
                            view = view2;
                        }
                    } else if (z5) {
                        view = view2;
                        z4 = true;
                    } else {
                        if (!z6) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private View g(MotionEvent motionEvent) {
        View view = null;
        if (!n(motionEvent)) {
            return null;
        }
        Rect rect = new Rect();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0 || childAt.getAnimation() != null) {
                childAt.getHitRect(rect);
                boolean contains = rect.contains(((int) motionEvent.getX()) + getScrollX(), ((int) motionEvent.getY()) + getScrollY());
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(getScrollX() - childAt.getLeft(), getScrollY() - childAt.getTop());
                if (contains && c(childAt, obtain)) {
                    view = childAt;
                }
                obtain.recycle();
            }
        }
        Log.d("COUIScrollView", "findViewToDispatchClickEvent: target: " + view);
        return view;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private float getVelocityAlongScrollableDirection() {
        if (this.f8998h == null || (getNestedScrollAxes() & 2) != 0) {
            return 0.0f;
        }
        return this.f8998h.f();
    }

    private void h(int i3) {
        boolean z3 = (getScrollY() > 0 || i3 > 0) && (getScrollY() < getScrollRange() || i3 < 0);
        float f3 = i3;
        if (dispatchNestedPreFling(0.0f, f3)) {
            return;
        }
        dispatchNestedFling(0.0f, f3, z3);
        if (z3) {
            fling(i3);
        }
    }

    private boolean i(float f3, float f4) {
        return !(this.f8985O || (this.f8986P && r())) || f3 == 0.0f || ((double) Math.abs(f4 / f3)) > Math.tan(((double) this.f8988R) * 0.017453292519943295d);
    }

    private boolean j(int i3, int i4) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i4 >= childAt.getTop() - scrollY && i4 < childAt.getBottom() - scrollY && i3 >= childAt.getLeft() && i3 < childAt.getRight();
    }

    private void k(Context context) {
        if (this.f8998h == null) {
            e eVar = new e(context);
            this.f8999i = eVar;
            eVar.H(2.15f);
            this.f8999i.E(true);
            this.f8998h = this.f8999i;
            setEnableFlingSpeedIncrease(true);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f9007q = viewConfiguration.getScaledTouchSlop();
        this.f9008r = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9009s = viewConfiguration.getScaledMaximumFlingVelocity();
        int i3 = displayMetrics.heightPixels;
        this.f9013w = i3;
        this.f9010t = i3;
        this.f9011u = i3;
        this.f9012v = viewConfiguration.getScaledVerticalScrollFactor();
        this.f8995e = displayMetrics.heightPixels;
    }

    private void l() {
        VelocityTracker velocityTracker = this.f9004n;
        if (velocityTracker == null) {
            this.f9004n = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void m() {
        if (this.f9004n == null) {
            this.f9004n = VelocityTracker.obtain();
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int y3 = (int) (motionEvent.getY() - this.f8978H);
        return System.currentTimeMillis() - this.f8976F < 100 && ((int) Math.sqrt((double) (y3 * y3))) < 10;
    }

    private Boolean o() {
        if (this.f8994a0 == null) {
            this.f8994a0 = Boolean.valueOf(AbstractC0647b.e());
        }
        return this.f8994a0;
    }

    private boolean p(float f3, float f4) {
        return !this.f8991U || Math.abs(f3) > this.f8989S || Math.abs(f4) > this.f8989S;
    }

    private boolean q(View view) {
        return !t(view, 0, getHeight());
    }

    private boolean r() {
        return getScrollY() < 0 || getScrollY() > getScrollRange();
    }

    private static boolean s(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && s((View) parent, view2);
    }

    private boolean t(View view, int i3, int i4) {
        view.getDrawingRect(this.f8997g);
        offsetDescendantRectToMyCoords(view, this.f8997g);
        return this.f8997g.bottom + i3 >= getScrollY() && this.f8997g.top - i3 <= getScrollY() + i4;
    }

    private void u(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f9015y) {
            int i3 = action == 0 ? 1 : 0;
            this.f8977G = (int) motionEvent.getX(i3);
            int y3 = (int) motionEvent.getY(i3);
            this.f9000j = y3;
            this.f8978H = y3;
            this.f9015y = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f9004n;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void v() {
        if (this.f8993W) {
            performHapticFeedback(307);
        }
    }

    private void w() {
        VelocityTracker velocityTracker = this.f9004n;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9004n = null;
        }
    }

    private boolean x(int i3, int i4, int i5) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z3 = false;
        boolean z4 = i3 == 33;
        View f3 = f(z4, i4, i5);
        if (f3 == null) {
            f3 = this;
        }
        if (i4 < scrollY || i5 > i6) {
            d(z4 ? i4 - scrollY : i5 - i6);
            z3 = true;
        }
        if (f3 != findFocus()) {
            f3.requestFocus(i3);
        }
        return z3;
    }

    private boolean y(Rect rect, boolean z3) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z4 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z4) {
            if (z3) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                A(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z4;
    }

    private void z(int i3, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b3 = b(i3, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b4 = b(i4, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b3 == getScrollX() && b4 == getScrollY()) {
                return;
            }
            scrollTo(b3, b4);
        }
    }

    public final void A(int i3, int i4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f8996f > 250) {
            int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            int max2 = Math.max(0, Math.min(i4 + scrollY, max)) - scrollY;
            b bVar = this.f8998h;
            if (bVar != null) {
                bVar.startScroll(getScrollX(), scrollY, 0, max2);
            }
            postInvalidateOnAnimation();
        } else {
            b bVar2 = this.f8998h;
            if (bVar2 != null && !bVar2.g()) {
                this.f8990T = this.f8998h.f() != 0.0f ? this.f8983M : 0.0f;
                this.f8998h.abortAnimation();
                if (this.f8974D) {
                    this.f8974D = false;
                }
            }
            scrollBy(i3, i4);
        }
        this.f8996f = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.widget.ScrollView
    public boolean arrowScroll(int i3) {
        int bottom;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !t(findNextFocus, maxScrollAmount, getHeight())) {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0 && (bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom())) < maxScrollAmount) {
                maxScrollAmount = bottom;
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            d(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f8997g);
            offsetDescendantRectToMyCoords(findNextFocus, this.f8997g);
            d(computeScrollDeltaToGetChildRectOnScreen(this.f8997g));
            findNextFocus.requestFocus(i3);
        }
        if (findFocus == null || !findFocus.isFocused() || !q(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        b bVar = this.f8998h;
        if (bVar == null || !bVar.computeScrollOffset()) {
            if (this.f8974D) {
                this.f8974D = false;
                return;
            }
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int b3 = this.f8998h.b();
        int i3 = this.f8998h.i();
        if (scrollX != b3 || scrollY != i3) {
            overScrollBy(b3 - scrollX, i3 - scrollY, scrollX, scrollY, 0, getScrollRange(), 0, this.f9011u, false);
        }
        if (awakenScrollBars()) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f8985O || (this.f8986P && r())) {
            float velocityAlongScrollableDirection = getVelocityAlongScrollableDirection();
            if (motionEvent.getActionMasked() == 0 && this.f8987Q >= Math.abs(velocityAlongScrollableDirection)) {
                b bVar2 = this.f8998h;
                float f3 = 0.0f;
                if (bVar2 != null && bVar2.f() != 0.0f) {
                    f3 = this.f8983M;
                }
                this.f8990T = f3;
                b bVar3 = this.f8998h;
                if (bVar3 != null) {
                    bVar3.abortAnimation();
                }
                stopNestedScroll();
            }
            if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && (bVar = this.f8998h) != null && bVar.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.f8997g.setEmpty();
        if (!a()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 111) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? arrowScroll(33) : fullScroll(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? arrowScroll(130) : fullScroll(130);
        }
        if (keyCode != 62) {
            return false;
        }
        pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.widget.ScrollView
    public void fling(int i3) {
        this.f8983M = i3;
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            b bVar = this.f8998h;
            if (bVar != null) {
                bVar.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            }
            if (!this.f8974D) {
                this.f8974D = true;
            }
            postInvalidateOnAnimation();
        }
    }

    @Override // android.widget.ScrollView
    public boolean fullScroll(int i3) {
        int childCount;
        boolean z3 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f8997g;
        rect.top = 0;
        rect.bottom = height;
        if (z3 && (childCount = getChildCount()) > 0) {
            this.f8997g.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            Rect rect2 = this.f8997g;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f8997g;
        return x(i3, rect3.top, rect3.bottom);
    }

    public int getScrollableRange() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    protected void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.widget.ScrollView
    public boolean isFillViewport() {
        return this.f9005o;
    }

    @Override // android.widget.ScrollView
    public boolean isSmoothScrollingEnabled() {
        return this.f9006p;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8973C) {
            this.f8973C = false;
        }
        if (this.f8974D) {
            this.f8974D = false;
        }
        e eVar = this.f8999i;
        if (eVar != null) {
            eVar.u();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 8) {
            int round = Math.round((motionEvent.isFromSource(2) ? motionEvent.getAxisValue(9) : motionEvent.isFromSource(4194304) ? motionEvent.getAxisValue(26) : 0.0f) * this.f9012v);
            if (round != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY - round;
                if (i3 < 0) {
                    scrollRange = 0;
                } else if (i3 <= scrollRange) {
                    scrollRange = i3;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f9003m) {
            return true;
        }
        if (super.onInterceptTouchEvent(motionEvent) && this.f9003m) {
            return true;
        }
        int i3 = action & 255;
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = this.f9015y;
                    if (i4 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i4);
                        if (findPointerIndex == -1) {
                            Log.e("COUIScrollView", "Invalid pointerId=" + i4 + " in onInterceptTouchEvent");
                        } else {
                            int x3 = (int) motionEvent.getX(findPointerIndex);
                            int y3 = (int) motionEvent.getY(findPointerIndex);
                            int abs = Math.abs(x3 - this.f8977G);
                            int abs2 = Math.abs(y3 - this.f8978H);
                            if (abs2 > this.f9007q && (2 & getNestedScrollAxes()) == 0 && i(abs, abs2)) {
                                this.f9003m = true;
                                this.f9000j = y3;
                                m();
                                this.f9004n.addMovement(motionEvent);
                                this.f8972B = 0;
                                if (!this.f8973C) {
                                    this.f8973C = true;
                                }
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i3 != 3) {
                    if (i3 == 5) {
                        this.f8977G = (int) motionEvent.getX(0);
                        this.f8978H = (int) motionEvent.getY(0);
                    } else if (i3 == 6) {
                        u(motionEvent);
                    }
                }
            }
            this.f9003m = false;
            this.f9015y = -1;
            w();
            b bVar = this.f8998h;
            if (bVar != null && bVar.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll();
        } else {
            b bVar2 = this.f8998h;
            float f3 = bVar2 != null ? bVar2.f() : 0.0f;
            this.f8979I = Math.abs(f3) > 0.0f && Math.abs(f3) < 250.0f && p(this.f8983M, this.f8990T);
            this.f8980J = r();
            this.f8976F = System.currentTimeMillis();
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (j((int) motionEvent.getX(), y4)) {
                this.f8977G = x4;
                this.f9000j = y4;
                this.f8978H = y4;
                this.f9015y = motionEvent.getPointerId(0);
                l();
                this.f9004n.addMovement(motionEvent);
                b bVar3 = this.f8998h;
                if (bVar3 != null) {
                    bVar3.computeScrollOffset();
                }
                b bVar4 = this.f8998h;
                if (bVar4 != null && !bVar4.g()) {
                    z3 = true;
                }
                this.f9003m = z3;
                if (z3 && !this.f8973C) {
                    this.f8973C = true;
                }
                startNestedScroll(2);
            } else {
                this.f9003m = false;
                w();
            }
        }
        return this.f9003m;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f9001k = false;
        View view = this.f9002l;
        if (view != null && s(view, this)) {
            scrollToDescendant(this.f9002l);
        }
        this.f9002l = null;
        if (!isLaidOut()) {
            a aVar = this.f8975E;
            if (aVar != null) {
                A0.b.c(this, aVar.f9017e);
                this.f8975E = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i6 - i4) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                A0.b.c(this, max);
            } else if (getScrollY() < 0) {
                A0.b.c(this, 0);
            }
        }
        z(getScrollX(), getScrollY());
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f9005o && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int paddingLeft = getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin;
            int measuredHeight = getMeasuredHeight() - (((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin);
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, paddingLeft, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        if (z3) {
            return false;
        }
        h((int) f4);
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z3, boolean z4) {
        if (getScrollY() == i4 && getScrollX() == i3) {
            return;
        }
        if ((i4 < 0 || i4 > getScrollRange()) && this.f8974D) {
            int scrollRange = i4 >= getScrollRange() ? getScrollRange() : 0;
            i4 = g.a(scrollRange, i4 - scrollRange, this.f8995e);
        }
        if (getOverScrollMode() == 2 || (getOverScrollMode() == 1 && getChildAt(0).getHeight() <= getScrollableRange())) {
            i4 = Math.min(Math.max(i4, 0), getScrollRange());
        }
        if (getScrollY() >= 0 && i4 < 0 && this.f8974D) {
            v();
            e eVar = this.f8999i;
            if (eVar != null) {
                eVar.notifyVerticalEdgeReached(i4, 0, this.f9011u);
            }
        }
        if (getScrollY() <= getScrollRange() && i4 > getScrollRange() && this.f8974D) {
            v();
            e eVar2 = this.f8999i;
            if (eVar2 != null) {
                eVar2.notifyVerticalEdgeReached(i4, getScrollRange(), this.f9011u);
            }
        }
        scrollTo(i3, i4);
        invalidateParentIfNeeded();
        awakenScrollBars();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i3) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        if (findNextFocus == null || q(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i3, rect);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.f8975E = aVar;
        requestLayout();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f9017e = getScrollY();
        return aVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f8995e = getContext().getResources().getDisplayMetrics().heightPixels;
        b bVar = this.f8998h;
        if (bVar != null) {
            bVar.abortAnimation();
        }
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !t(findFocus, 0, i6)) {
            return;
        }
        findFocus.getDrawingRect(this.f8997g);
        offsetDescendantRectToMyCoords(findFocus, this.f8997g);
        d(computeScrollDeltaToGetChildRectOnScreen(this.f8997g));
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01a0  */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollview.COUIScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        e eVar = this.f8999i;
        if (eVar == null || i3 == 0) {
            return;
        }
        eVar.abortAnimation();
        this.f8999i.u();
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3) {
        onOverScrolled(i5 + i3, i6 + i4, false, false);
        return false;
    }

    @Override // android.widget.ScrollView
    public boolean pageScroll(int i3) {
        boolean z3 = i3 == 130;
        int height = getHeight();
        if (z3) {
            this.f8997g.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f8997g.top + height > childAt.getBottom()) {
                    this.f8997g.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f8997g.top = getScrollY() - height;
            Rect rect = this.f8997g;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        Rect rect2 = this.f8997g;
        int i4 = rect2.top;
        int i5 = height + i4;
        rect2.bottom = i5;
        return x(i3, i4, i5);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 != null && view2.getRevealOnFocusHint()) {
            if (this.f9001k) {
                this.f9002l = view2;
            } else {
                scrollToDescendant(view2);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return y(rect, z3);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        if (z3) {
            w();
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.widget.ScrollView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f9001k = true;
        super.requestLayout();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void scrollTo(int i3, int i4) {
        if (getChildCount() > 0) {
            if (getScrollX() == i3 && getScrollY() == i4) {
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (o().booleanValue()) {
                A0.b.b(this, i3);
                A0.b.c(this, i4);
                onScrollChanged(i3, i4, scrollX, scrollY);
            } else {
                super.scrollTo(i3, i4);
            }
            if (awakenScrollBars()) {
                return;
            }
            postInvalidateOnAnimation();
        }
    }

    @Override // android.widget.ScrollView
    public void scrollToDescendant(View view) {
        if (this.f9001k) {
            this.f9002l = view;
            return;
        }
        view.getDrawingRect(this.f8997g);
        offsetDescendantRectToMyCoords(view, this.f8997g);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.f8997g);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    public void setAvoidAccidentalTouch(boolean z3) {
        this.f8991U = z3;
    }

    public void setCustomOverScrollDistFactor(float f3) {
        int i3 = (int) (this.f9013w * f3);
        this.f9010t = i3;
        this.f9011u = i3;
    }

    public void setDispatchEventWhileOverScrolling(boolean z3) {
        this.f8986P = z3;
    }

    public void setDispatchEventWhileScrolling(boolean z3) {
        this.f8985O = z3;
    }

    public void setDispatchEventWhileScrollingThreshold(int i3) {
        this.f8987Q = i3;
    }

    public void setEnableFlingSpeedIncrease(boolean z3) {
        e eVar = this.f8999i;
        if (eVar != null) {
            eVar.D(z3);
        }
    }

    public void setEnableVibrator(boolean z3) {
        this.f8993W = z3;
    }

    public void setEventFilterTangent(float f3) {
        this.f8988R = f3;
    }

    public void setFastFlingThreshold(float f3) {
        this.f8989S = Math.max(f3, 0.0f);
    }

    @Override // android.widget.ScrollView
    public void setFillViewport(boolean z3) {
        if (z3 != this.f9005o) {
            this.f9005o = z3;
            requestLayout();
        }
    }

    public void setIsUseOptimizedScroll(boolean z3) {
        this.f8992V = z3;
    }

    public void setItemClickableWhileOverScrolling(boolean z3) {
        this.f8982L = z3;
    }

    public void setItemClickableWhileSlowScrolling(boolean z3) {
        this.f8981K = z3;
    }

    @Override // android.widget.ScrollView
    public void setSmoothScrollingEnabled(boolean z3) {
        this.f9006p = z3;
    }

    public void setSpringOverScrollerDebug(boolean z3) {
        e eVar = this.f8999i;
        if (eVar != null) {
            eVar.C(z3);
        }
    }

    public COUIScrollView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUIScrollView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8995e = 0;
        this.f8997g = new Rect();
        this.f8998h = null;
        this.f8999i = null;
        this.f9001k = true;
        this.f9002l = null;
        this.f9003m = false;
        this.f9006p = true;
        this.f9014x = 1.0f;
        this.f9015y = -1;
        this.f9016z = new int[2];
        this.f8971A = new int[2];
        this.f8973C = false;
        this.f8974D = false;
        this.f8981K = true;
        this.f8982L = true;
        this.f8984N = new Paint();
        this.f8985O = false;
        this.f8986P = false;
        this.f8987Q = 2500;
        this.f8988R = 20.0f;
        this.f8989S = 1500.0f;
        this.f8991U = true;
        this.f8992V = true;
        this.f8993W = true;
        this.f8994a0 = null;
        k(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0299a.f7442g, i3, 0);
        this.f8993W = obtainStyledAttributes.getBoolean(AbstractC0299a.f7443h, true);
        obtainStyledAttributes.recycle();
    }
}
