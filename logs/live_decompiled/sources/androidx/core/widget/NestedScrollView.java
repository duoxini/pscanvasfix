package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.C0252a;
import androidx.core.view.accessibility.d;
import androidx.core.view.n;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.w;
import androidx.core.view.y;
import androidx.preference.Preference;
import java.util.ArrayList;
import u.AbstractC0596a;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements r, o, w {

    /* renamed from: F, reason: collision with root package name */
    private static final float f5146F = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: G, reason: collision with root package name */
    private static final a f5147G = new a();

    /* renamed from: H, reason: collision with root package name */
    private static final int[] f5148H = {R.attr.fillViewport};

    /* renamed from: A, reason: collision with root package name */
    private d f5149A;

    /* renamed from: B, reason: collision with root package name */
    private final s f5150B;

    /* renamed from: C, reason: collision with root package name */
    private final p f5151C;

    /* renamed from: D, reason: collision with root package name */
    private float f5152D;

    /* renamed from: E, reason: collision with root package name */
    private c f5153E;

    /* renamed from: e, reason: collision with root package name */
    private final float f5154e;

    /* renamed from: f, reason: collision with root package name */
    private long f5155f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f5156g;

    /* renamed from: h, reason: collision with root package name */
    private OverScroller f5157h;

    /* renamed from: i, reason: collision with root package name */
    public EdgeEffect f5158i;

    /* renamed from: j, reason: collision with root package name */
    public EdgeEffect f5159j;

    /* renamed from: k, reason: collision with root package name */
    private int f5160k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5161l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5162m;

    /* renamed from: n, reason: collision with root package name */
    private View f5163n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5164o;

    /* renamed from: p, reason: collision with root package name */
    private VelocityTracker f5165p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5166q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5167r;

    /* renamed from: s, reason: collision with root package name */
    private int f5168s;

    /* renamed from: t, reason: collision with root package name */
    private int f5169t;

    /* renamed from: u, reason: collision with root package name */
    private int f5170u;

    /* renamed from: v, reason: collision with root package name */
    private int f5171v;

    /* renamed from: w, reason: collision with root package name */
    private final int[] f5172w;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f5173x;

    /* renamed from: y, reason: collision with root package name */
    private int f5174y;

    /* renamed from: z, reason: collision with root package name */
    private int f5175z;

    static class a extends C0252a {
        a() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.view.accessibility.f.a(accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.view.accessibility.f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.Q(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.j0(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.b(d.a.f5094r);
                dVar.b(d.a.f5062C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.b(d.a.f5093q);
                dVar.b(d.a.f5064E);
            }
        }

        @Override // androidx.core.view.C0252a
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (super.performAccessibilityAction(view, i3, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i3 != 4096) {
                if (i3 == 8192 || i3 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.T(0, max, true);
                    return true;
                }
                if (i3 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.T(0, min, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface c {
        void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6);
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public int f5176e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f5176e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f5176e);
        }

        d(Parcel parcel) {
            super(parcel);
            this.f5176e = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0596a.f13695c);
    }

    private void A() {
        this.f5157h = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f5168s = viewConfiguration.getScaledTouchSlop();
        this.f5169t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5170u = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if (this.f5165p == null) {
            this.f5165p = VelocityTracker.obtain();
        }
    }

    private boolean C(View view) {
        return !E(view, 0, getHeight());
    }

    private static boolean D(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && D((View) parent, view2);
    }

    private boolean E(View view, int i3, int i4) {
        view.getDrawingRect(this.f5156g);
        offsetDescendantRectToMyCoords(view, this.f5156g);
        return this.f5156g.bottom + i3 >= getScrollY() && this.f5156g.top - i3 <= getScrollY() + i4;
    }

    private void F(int i3, int i4, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i3);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f5151C.e(0, scrollY2, 0, i3 - scrollY2, null, i4, iArr);
    }

    private void G(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f5171v) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f5160k = (int) motionEvent.getY(i3);
            this.f5171v = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f5165p;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void J() {
        VelocityTracker velocityTracker = this.f5165p;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5165p = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int K(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f5158i
            float r0 = androidx.core.widget.d.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f5158i
            float r4 = -r4
            float r4 = androidx.core.widget.d.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f5158i
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f5158i
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f5159j
            float r0 = androidx.core.widget.d.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f5159j
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.d.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f5159j
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f5159j
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.K(int, float):int");
    }

    private void L(boolean z3) {
        if (z3) {
            U(2, 1);
        } else {
            W(1);
        }
        this.f5175z = getScrollY();
        y.Z(this);
    }

    private boolean M(int i3, int i4, int i5) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z3 = false;
        boolean z4 = i3 == 33;
        View t3 = t(z4, i4, i5);
        if (t3 == null) {
            t3 = this;
        }
        if (i4 < scrollY || i5 > i6) {
            p(z4 ? i4 - scrollY : i5 - i6);
            z3 = true;
        }
        if (t3 != findFocus()) {
            t3.requestFocus(i3);
        }
        return z3;
    }

    private void N(View view) {
        view.getDrawingRect(this.f5156g);
        offsetDescendantRectToMyCoords(view, this.f5156g);
        int f3 = f(this.f5156g);
        if (f3 != 0) {
            scrollBy(0, f3);
        }
    }

    private boolean O(Rect rect, boolean z3) {
        int f3 = f(rect);
        boolean z4 = f3 != 0;
        if (z4) {
            if (z3) {
                scrollBy(0, f3);
            } else {
                Q(0, f3);
            }
        }
        return z4;
    }

    private boolean P(EdgeEffect edgeEffect, int i3) {
        if (i3 > 0) {
            return true;
        }
        return w(-i3) < androidx.core.widget.d.b(edgeEffect) * ((float) getHeight());
    }

    private void R(int i3, int i4, int i5, boolean z3) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f5155f > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f5157h.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i4 + scrollY, Math.max(0, height - height2))) - scrollY, i5);
            L(z3);
        } else {
            if (!this.f5157h.isFinished()) {
                a();
            }
            scrollBy(i3, i4);
        }
        this.f5155f = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean V(MotionEvent motionEvent) {
        boolean z3;
        if (androidx.core.widget.d.b(this.f5158i) != 0.0f) {
            androidx.core.widget.d.d(this.f5158i, 0.0f, motionEvent.getX() / getWidth());
            z3 = true;
        } else {
            z3 = false;
        }
        if (androidx.core.widget.d.b(this.f5159j) == 0.0f) {
            return z3;
        }
        androidx.core.widget.d.d(this.f5159j, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void a() {
        this.f5157h.abortAnimation();
        W(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int e(int i3, int i4, int i5) {
        if (i4 >= i5 || i3 < 0) {
            return 0;
        }
        return i4 + i3 > i5 ? i5 - i4 : i3;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f5152D == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f5152D = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f5152D;
    }

    private void p(int i3) {
        if (i3 != 0) {
            if (this.f5167r) {
                Q(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private boolean q(int i3) {
        if (androidx.core.widget.d.b(this.f5158i) != 0.0f) {
            if (P(this.f5158i, i3)) {
                this.f5158i.onAbsorb(i3);
            } else {
                u(-i3);
            }
        } else {
            if (androidx.core.widget.d.b(this.f5159j) == 0.0f) {
                return false;
            }
            int i4 = -i3;
            if (P(this.f5159j, i4)) {
                this.f5159j.onAbsorb(i4);
            } else {
                u(i4);
            }
        }
        return true;
    }

    private void r() {
        this.f5164o = false;
        J();
        W(0);
        this.f5158i.onRelease();
        this.f5159j.onRelease();
    }

    private View t(boolean z3, int i3, int i4) {
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

    private float w(int i3) {
        double log = Math.log((Math.abs(i3) * 0.35f) / (this.f5154e * 0.015f));
        float f3 = f5146F;
        return (float) (this.f5154e * 0.015f * Math.exp((f3 / (f3 - 1.0d)) * log));
    }

    private boolean y(int i3, int i4) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i4 >= childAt.getTop() - scrollY && i4 < childAt.getBottom() - scrollY && i3 >= childAt.getLeft() && i3 < childAt.getRight();
    }

    private void z() {
        VelocityTracker velocityTracker = this.f5165p;
        if (velocityTracker == null) {
            this.f5165p = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    boolean H(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3) {
        boolean z4;
        boolean z5;
        int overScrollMode = getOverScrollMode();
        boolean z6 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z7 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        boolean z9 = overScrollMode == 0 || (overScrollMode == 1 && z7);
        int i11 = i5 + i3;
        int i12 = !z8 ? 0 : i9;
        int i13 = i6 + i4;
        int i14 = !z9 ? 0 : i10;
        int i15 = -i12;
        int i16 = i12 + i7;
        int i17 = -i14;
        int i18 = i14 + i8;
        if (i11 > i16) {
            i11 = i16;
            z4 = true;
        } else if (i11 < i15) {
            z4 = true;
            i11 = i15;
        } else {
            z4 = false;
        }
        if (i13 > i18) {
            i13 = i18;
            z5 = true;
        } else if (i13 < i17) {
            z5 = true;
            i13 = i17;
        } else {
            z5 = false;
        }
        if (z5 && !x(1)) {
            this.f5157h.springBack(i11, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i11, i13, z4, z5);
        return z4 || z5;
    }

    public boolean I(int i3) {
        boolean z3 = i3 == 130;
        int height = getHeight();
        if (z3) {
            this.f5156g.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f5156g;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f5156g.top = getScrollY() - height;
            Rect rect2 = this.f5156g;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f5156g;
        int i4 = rect3.top;
        int i5 = height + i4;
        rect3.bottom = i5;
        return M(i3, i4, i5);
    }

    public final void Q(int i3, int i4) {
        R(i3, i4, 250, false);
    }

    void S(int i3, int i4, int i5, boolean z3) {
        R(i3 - getScrollX(), i4 - getScrollY(), i5, z3);
    }

    void T(int i3, int i4, boolean z3) {
        S(i3, i4, 250, z3);
    }

    public boolean U(int i3, int i4) {
        return this.f5151C.q(i3, i4);
    }

    public void W(int i3) {
        this.f5151C.s(i3);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean b(int i3) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !E(findNextFocus, maxScrollAmount, getHeight())) {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            p(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f5156g);
            offsetDescendantRectToMyCoords(findNextFocus, this.f5156g);
            p(f(this.f5156g));
            findNextFocus.requestFocus(i3);
        }
        if (findFocus == null || !findFocus.isFocused() || !C(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f5157h.isFinished()) {
            return;
        }
        this.f5157h.computeScrollOffset();
        int currY = this.f5157h.getCurrY();
        int g3 = g(currY - this.f5175z);
        this.f5175z = currY;
        int[] iArr = this.f5173x;
        iArr[1] = 0;
        k(0, g3, iArr, null, 1);
        int i3 = g3 - this.f5173x[1];
        int scrollRange = getScrollRange();
        if (i3 != 0) {
            int scrollY = getScrollY();
            H(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i4 = i3 - scrollY2;
            int[] iArr2 = this.f5173x;
            iArr2[1] = 0;
            l(0, scrollY2, 0, i4, this.f5172w, 1, iArr2);
            i3 = i4 - this.f5173x[1];
        }
        if (i3 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i3 < 0) {
                    if (this.f5158i.isFinished()) {
                        this.f5158i.onAbsorb((int) this.f5157h.getCurrVelocity());
                    }
                } else if (this.f5159j.isFinished()) {
                    this.f5159j.onAbsorb((int) this.f5157h.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f5157h.isFinished()) {
            W(1);
        } else {
            y.Z(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z3) {
        return this.f5151C.a(f3, f4, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return this.f5151C.b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return k(i3, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return this.f5151C.f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i4 = 0;
        if (!this.f5158i.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i3 = getPaddingLeft();
            } else {
                i3 = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i3, min);
            this.f5158i.setSize(width, height);
            if (this.f5158i.draw(canvas)) {
                y.Z(this);
            }
            canvas.restoreToCount(save);
        }
        if (this.f5159j.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            i4 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            max -= getPaddingBottom();
        }
        canvas.translate(i4 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f5159j.setSize(width2, height2);
        if (this.f5159j.draw(canvas)) {
            y.Z(this);
        }
        canvas.restoreToCount(save2);
    }

    protected int f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i4, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i4 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    int g(int i3) {
        int height = getHeight();
        if (i3 > 0 && androidx.core.widget.d.b(this.f5158i) != 0.0f) {
            int round = Math.round(((-height) / 4.0f) * androidx.core.widget.d.d(this.f5158i, ((-i3) * 4.0f) / height, 0.5f));
            if (round != i3) {
                this.f5158i.finish();
            }
            return i3 - round;
        }
        if (i3 >= 0 || androidx.core.widget.d.b(this.f5159j) == 0.0f) {
            return i3;
        }
        float f3 = height;
        int round2 = Math.round((f3 / 4.0f) * androidx.core.widget.d.d(this.f5159j, (i3 * 4.0f) / f3, 0.5f));
        if (round2 != i3) {
            this.f5159j.finish();
        }
        return i3 - round2;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f5150B.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // androidx.core.view.q
    public void h(View view, View view2, int i3, int i4) {
        this.f5150B.c(view, view2, i3, i4);
        U(2, i4);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return x(0);
    }

    @Override // androidx.core.view.q
    public void i(View view, int i3) {
        this.f5150B.d(view, i3);
        W(i3);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f5151C.m();
    }

    @Override // androidx.core.view.q
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        k(i3, i4, iArr, null, i5);
    }

    public boolean k(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return this.f5151C.d(i3, i4, iArr, iArr2, i5);
    }

    public void l(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        this.f5151C.e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    @Override // androidx.core.view.r
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        F(i6, i7, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i4) {
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.q
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        F(i6, i7, null);
    }

    @Override // androidx.core.view.q
    public boolean o(View view, View view2, int i3, int i4) {
        return (i3 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5162m = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z3;
        int i3 = 0;
        if (motionEvent.getAction() == 8 && !this.f5164o) {
            float axisValue = n.b(motionEvent, 2) ? motionEvent.getAxisValue(9) : n.b(motionEvent, 4194304) ? motionEvent.getAxisValue(26) : 0.0f;
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i4 = scrollY - verticalScrollFactorCompat;
                if (i4 < 0) {
                    if (!c() || n.b(motionEvent, 8194)) {
                        z3 = 0;
                    } else {
                        androidx.core.widget.d.d(this.f5158i, (-i4) / getHeight(), 0.5f);
                        this.f5158i.onRelease();
                        invalidate();
                        z3 = 1;
                    }
                } else if (i4 > scrollRange) {
                    if (c() && !n.b(motionEvent, 8194)) {
                        androidx.core.widget.d.d(this.f5159j, (i4 - scrollRange) / getHeight(), 0.5f);
                        this.f5159j.onRelease();
                        invalidate();
                        i3 = 1;
                    }
                    z3 = i3;
                    i3 = scrollRange;
                } else {
                    z3 = 0;
                    i3 = i4;
                }
                if (i3 == scrollY) {
                    return z3;
                }
                super.scrollTo(getScrollX(), i3);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z3 = true;
        if (action == 2 && this.f5164o) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = this.f5171v;
                    if (i4 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i4);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i4 + " in onInterceptTouchEvent");
                        } else {
                            int y3 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y3 - this.f5160k) > this.f5168s && (2 & getNestedScrollAxes()) == 0) {
                                this.f5164o = true;
                                this.f5160k = y3;
                                B();
                                this.f5165p.addMovement(motionEvent);
                                this.f5174y = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i3 != 3) {
                    if (i3 == 6) {
                        G(motionEvent);
                    }
                }
            }
            this.f5164o = false;
            this.f5171v = -1;
            J();
            if (this.f5157h.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                y.Z(this);
            }
            W(0);
        } else {
            int y4 = (int) motionEvent.getY();
            if (y((int) motionEvent.getX(), y4)) {
                this.f5160k = y4;
                this.f5171v = motionEvent.getPointerId(0);
                z();
                this.f5165p.addMovement(motionEvent);
                this.f5157h.computeScrollOffset();
                if (!V(motionEvent) && this.f5157h.isFinished()) {
                    z3 = false;
                }
                this.f5164o = z3;
                U(2, 0);
            } else {
                if (!V(motionEvent) && this.f5157h.isFinished()) {
                    z3 = false;
                }
                this.f5164o = z3;
                J();
            }
        }
        return this.f5164o;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        int i7 = 0;
        this.f5161l = false;
        View view = this.f5163n;
        if (view != null && D(view, this)) {
            N(this.f5163n);
        }
        this.f5163n = null;
        if (!this.f5162m) {
            if (this.f5149A != null) {
                scrollTo(getScrollX(), this.f5149A.f5176e);
                this.f5149A = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i7 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e3 = e(scrollY, paddingTop, i7);
            if (e3 != scrollY) {
                scrollTo(getScrollX(), e3);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f5162m = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f5166q && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        if (z3) {
            return false;
        }
        dispatchNestedFling(0.0f, f4, true);
        u((int) f4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return dispatchNestedPreFling(f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        j(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        F(i6, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        h(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z3, boolean z4) {
        super.scrollTo(i3, i4);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i3) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        if (findNextFocus == null || C(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.f5149A = dVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f5176e = getScrollY();
        return dVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
        super.onScrollChanged(i3, i4, i5, i6);
        c cVar = this.f5153E;
        if (cVar != null) {
            cVar.a(this, i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !E(findFocus, 0, i6)) {
            return;
        }
        findFocus.getDrawingRect(this.f5156g);
        offsetDescendantRectToMyCoords(findFocus, this.f5156g);
        p(f(this.f5156g));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return o(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01d7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f5161l) {
            this.f5163n = view2;
        } else {
            N(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return O(rect, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        if (z3) {
            J();
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f5161l = true;
        super.requestLayout();
    }

    public boolean s(KeyEvent keyEvent) {
        this.f5156g.setEmpty();
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
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
            return !keyEvent.isAltPressed() ? b(33) : v(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? b(130) : v(130);
        }
        if (keyCode != 62) {
            return false;
        }
        I(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int e3 = e(i3, width, width2);
            int e4 = e(i4, height, height2);
            if (e3 == getScrollX() && e4 == getScrollY()) {
                return;
            }
            super.scrollTo(e3, e4);
        }
    }

    public void setFillViewport(boolean z3) {
        if (z3 != this.f5166q) {
            this.f5166q = z3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        this.f5151C.n(z3);
    }

    public void setOnScrollChangeListener(c cVar) {
    }

    public void setSmoothScrollingEnabled(boolean z3) {
        this.f5167r = z3;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return U(i3, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        W(0);
    }

    public void u(int i3) {
        if (getChildCount() > 0) {
            this.f5157h.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, 0, 0);
            L(true);
        }
    }

    public boolean v(int i3) {
        int childCount;
        boolean z3 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f5156g;
        rect.top = 0;
        rect.bottom = height;
        if (z3 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f5156g.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f5156g;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f5156g;
        return M(i3, rect3.top, rect3.bottom);
    }

    public boolean x(int i3) {
        return this.f5151C.l(i3);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f5156g = new Rect();
        this.f5161l = true;
        this.f5162m = false;
        this.f5163n = null;
        this.f5164o = false;
        this.f5167r = true;
        this.f5171v = -1;
        this.f5172w = new int[2];
        this.f5173x = new int[2];
        this.f5158i = androidx.core.widget.d.a(context, attributeSet);
        this.f5159j = androidx.core.widget.d.a(context, attributeSet);
        this.f5154e = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5148H, i3, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f5150B = new s(this);
        this.f5151C = new p(this);
        setNestedScrollingEnabled(true);
        y.j0(this, f5147G);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
