package com.coui.appcompat.scrollview;

import Y.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
import android.widget.FrameLayout;
import androidx.appcompat.app.p;
import androidx.core.view.y;
import androidx.core.widget.NestedScrollView;
import androidx.preference.Preference;
import c2.AbstractC0299a;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.util.ArrayList;
import o0.e;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public abstract class a extends NestedScrollView {

    /* renamed from: A0, reason: collision with root package name */
    private float f9018A0;

    /* renamed from: B0, reason: collision with root package name */
    private boolean f9019B0;

    /* renamed from: C0, reason: collision with root package name */
    private Boolean f9020C0;

    /* renamed from: I, reason: collision with root package name */
    private int f9021I;

    /* renamed from: J, reason: collision with root package name */
    private long f9022J;

    /* renamed from: K, reason: collision with root package name */
    private int f9023K;

    /* renamed from: L, reason: collision with root package name */
    private int f9024L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f9025M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f9026N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f9027O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f9028P;

    /* renamed from: Q, reason: collision with root package name */
    private float f9029Q;

    /* renamed from: R, reason: collision with root package name */
    private Paint f9030R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f9031S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f9032T;

    /* renamed from: U, reason: collision with root package name */
    private int f9033U;

    /* renamed from: V, reason: collision with root package name */
    private float f9034V;

    /* renamed from: W, reason: collision with root package name */
    private float f9035W;

    /* renamed from: a0, reason: collision with root package name */
    private float f9036a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f9037b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f9038c0;

    /* renamed from: d0, reason: collision with root package name */
    private ArrayList f9039d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f9040e0;

    /* renamed from: f0, reason: collision with root package name */
    private final Rect f9041f0;

    /* renamed from: g0, reason: collision with root package name */
    private o0.b f9042g0;

    /* renamed from: h0, reason: collision with root package name */
    private e f9043h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f9044i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f9045j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f9046k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f9047l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f9048m0;

    /* renamed from: n0, reason: collision with root package name */
    private VelocityTracker f9049n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f9050o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f9051p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f9052q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f9053r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f9054s0;

    /* renamed from: t0, reason: collision with root package name */
    private final int[] f9055t0;

    /* renamed from: u0, reason: collision with root package name */
    private final int[] f9056u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f9057v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f9058w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f9059x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f9060y0;

    /* renamed from: z0, reason: collision with root package name */
    private C0112a f9061z0;

    /* renamed from: com.coui.appcompat.scrollview.a$a, reason: collision with other inner class name */
    static class C0112a extends View.BaseSavedState {
        public static final Parcelable.Creator<C0112a> CREATOR = new C0113a();

        /* renamed from: e, reason: collision with root package name */
        public int f9062e;

        /* renamed from: com.coui.appcompat.scrollview.a$a$a, reason: collision with other inner class name */
        class C0113a implements Parcelable.Creator {
            C0113a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0112a createFromParcel(Parcel parcel) {
                return new C0112a(parcel, C0112a.class.getClassLoader());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C0112a[] newArray(int i3) {
                return new C0112a[i3];
            }
        }

        C0112a(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "NestedScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f9062e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f9062e);
        }

        C0112a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9062e = parcel.readInt();
        }
    }

    public interface b {
    }

    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9021I = 0;
        this.f9027O = true;
        this.f9028P = true;
        this.f9030R = new Paint();
        this.f9031S = false;
        this.f9032T = false;
        this.f9033U = 2500;
        this.f9034V = 20.0f;
        this.f9035W = 1500.0f;
        this.f9037b0 = true;
        this.f9038c0 = true;
        this.f9039d0 = new ArrayList();
        this.f9040e0 = true;
        this.f9041f0 = new Rect();
        this.f9042g0 = null;
        this.f9043h0 = null;
        this.f9045j0 = true;
        this.f9046k0 = false;
        this.f9047l0 = null;
        this.f9048m0 = false;
        this.f9050o0 = true;
        this.f9054s0 = -1;
        this.f9055t0 = new int[2];
        this.f9056u0 = new int[2];
        this.f9019B0 = false;
        this.f9020C0 = null;
        a0(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0299a.f7440e, i3, 0);
        this.f9040e0 = obtainStyledAttributes.getBoolean(AbstractC0299a.f7441f, true);
        obtainStyledAttributes.recycle();
    }

    private void B() {
        if (this.f9049n0 == null) {
            this.f9049n0 = VelocityTracker.obtain();
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
        view.getDrawingRect(this.f9041f0);
        offsetDescendantRectToMyCoords(view, this.f9041f0);
        return this.f9041f0.bottom + i3 >= getScrollY() && this.f9041f0.top - i3 <= getScrollY() + i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void F(int r9, int r10, int[] r11) {
        /*
            r8 = this;
            int r1 = r8.getScrollY()
            int r2 = r8.getOverScrollMode()
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == r3) goto L21
            int r2 = r8.getOverScrollMode()
            if (r2 != r5) goto L43
            android.view.View r2 = r8.getChildAt(r4)
            int r2 = r2.getHeight()
            int r3 = r8.getHeight()
            if (r2 > r3) goto L43
        L21:
            int r2 = r8.getScrollY()
            int r2 = r2 + r9
            if (r2 >= 0) goto L2e
            int r2 = r8.getScrollY()
            int r2 = -r2
            goto L44
        L2e:
            int r2 = r8.getScrollY()
            int r2 = r2 + r9
            int r3 = r8.getScrollRange()
            if (r2 <= r3) goto L43
            int r2 = r8.getScrollRange()
            int r3 = r8.getScrollY()
            int r2 = r2 - r3
            goto L44
        L43:
            r2 = r9
        L44:
            r8.scrollBy(r4, r2)
            int r3 = r8.getScrollY()
            int r3 = r3 - r1
            if (r11 == 0) goto L53
            r1 = r11[r5]
            int r1 = r1 + r3
            r11[r5] = r1
        L53:
            int r4 = r2 - r3
            r5 = 0
            r6 = 0
            r1 = 0
            r0 = r8
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r10
            r7 = r11
            r0.l(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollview.a.F(int, int, int[]):void");
    }

    private void G(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f9054s0) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f9023K = (int) motionEvent.getX(i3);
            int y3 = (int) motionEvent.getY(i3);
            this.f9044i0 = y3;
            this.f9024L = y3;
            this.f9054s0 = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f9049n0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void J() {
        VelocityTracker velocityTracker = this.f9049n0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9049n0 = null;
        }
    }

    private void L(boolean z3) {
        if (z3) {
            U(2, 1);
        } else {
            W(1);
        }
        this.f9058w0 = getScrollY();
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
        view.getDrawingRect(this.f9041f0);
        offsetDescendantRectToMyCoords(view, this.f9041f0);
        int f3 = f(this.f9041f0);
        if (f3 != 0) {
            scrollBy(0, f3);
        }
    }

    private boolean X(View view, MotionEvent motionEvent) {
        boolean z3 = true;
        int[] iArr = {0, 1};
        for (int i3 = 0; i3 < 2; i3++) {
            motionEvent.setAction(iArr[i3]);
            z3 &= view.dispatchTouchEvent(motionEvent);
        }
        return z3;
    }

    private View Y(MotionEvent motionEvent) {
        View view = null;
        if (!b0(motionEvent)) {
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
                if (contains && X(childAt, obtain)) {
                    view = childAt;
                }
                obtain.recycle();
            }
        }
        Log.d("COUINestedScrollView", "findViewToDispatchClickEvent: target: " + view);
        return view;
    }

    private boolean Z(float f3, float f4) {
        return !(this.f9031S || (this.f9032T && e0())) || f3 == 0.0f || ((double) Math.abs(f4 / f3)) > Math.tan(((double) this.f9034V) * 0.017453292519943295d);
    }

    private void a() {
        o0.b bVar = this.f9042g0;
        if (bVar != null) {
            bVar.abortAnimation();
        }
        W(1);
    }

    private void a0(Context context) {
        if (this.f9042g0 == null) {
            e eVar = new e(context);
            this.f9043h0 = eVar;
            eVar.H(2.15f);
            this.f9043h0.E(true);
            this.f9042g0 = this.f9043h0;
            setEnableFlingSpeedIncrease(true);
        }
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f9051p0 = viewConfiguration.getScaledTouchSlop();
        this.f9052q0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9053r0 = viewConfiguration.getScaledMaximumFlingVelocity();
        int i3 = displayMetrics.heightPixels;
        this.f9059x0 = i3;
        this.f9060y0 = i3;
        this.f9021I = i3;
    }

    private boolean b0(MotionEvent motionEvent) {
        int y3 = (int) (motionEvent.getY() - this.f9024L);
        return System.currentTimeMillis() - this.f9022J < 100 && ((int) Math.sqrt((double) (y3 * y3))) < 10;
    }

    private Boolean c0() {
        if (this.f9020C0 == null) {
            this.f9020C0 = Boolean.valueOf(AbstractC0647b.e());
        }
        return this.f9020C0;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private boolean d0(float f3, float f4) {
        return !this.f9037b0 || Math.abs(f3) > this.f9035W || Math.abs(f4) > this.f9035W;
    }

    private static int e(int i3, int i4, int i5) {
        if (i4 >= i5 || i3 < 0) {
            return 0;
        }
        return i4 + i3 > i5 ? i5 - i4 : i3;
    }

    private boolean e0() {
        return getScrollY() < 0 || getScrollY() > getScrollRange();
    }

    private void f0() {
        if (this.f9040e0) {
            performHapticFeedback(307);
        }
    }

    private void g0(int i3, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int e3 = e(i3, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int e4 = e(i4, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (e3 == getScrollX() && e4 == getScrollY()) {
                return;
            }
            scrollTo(e3, e4);
        }
    }

    private float getVelocityAlongScrollableDirection() {
        if (this.f9042g0 == null || (getNestedScrollAxes() & 2) != 0) {
            return 0.0f;
        }
        return this.f9042g0.f();
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f9018A0 == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f9018A0 = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f9018A0;
    }

    private void p(int i3) {
        if (i3 != 0) {
            if (this.f9050o0) {
                Q(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private void r() {
        this.f9048m0 = false;
        J();
        W(0);
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

    private boolean y(int i3, int i4) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i4 >= childAt.getTop() - scrollY && i4 < childAt.getBottom() - scrollY && i3 >= childAt.getLeft() && i3 < childAt.getRight();
    }

    private void z() {
        VelocityTracker velocityTracker = this.f9049n0;
        if (velocityTracker == null) {
            this.f9049n0 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean H(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            int r4 = r12.getPaddingLeft()
            int r3 = r3 - r4
            int r4 = r12.getPaddingRight()
            int r3 = r3 - r4
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L1d
            r2 = r5
            goto L1e
        L1d:
            r2 = r4
        L1e:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            int r7 = r12.getPaddingTop()
            int r6 = r6 - r7
            int r7 = r12.getPaddingBottom()
            int r6 = r6 - r7
            if (r3 <= r6) goto L34
            r3 = r5
            goto L35
        L34:
            r3 = r4
        L35:
            if (r1 == 0) goto L3e
            if (r1 != r5) goto L3c
            if (r2 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r4
            goto L3f
        L3e:
            r2 = r5
        L3f:
            if (r1 == 0) goto L48
            if (r1 != r5) goto L46
            if (r3 == 0) goto L46
            goto L48
        L46:
            r1 = r4
            goto L49
        L48:
            r1 = r5
        L49:
            int r3 = r15 + r13
            if (r2 != 0) goto L4f
            r6 = r4
            goto L51
        L4f:
            r6 = r19
        L51:
            int r7 = r16 + r14
            if (r1 != 0) goto L57
            r8 = r4
            goto L59
        L57:
            r8 = r20
        L59:
            int r9 = -r6
            int r6 = r6 + r17
            int r10 = -r8
            int r8 = r8 + r18
            if (r2 != 0) goto L6b
            if (r3 <= r6) goto L66
            r2 = r5
            r3 = r6
            goto L6c
        L66:
            if (r3 >= r9) goto L6b
            r2 = r5
            r3 = r9
            goto L6c
        L6b:
            r2 = r4
        L6c:
            if (r1 != 0) goto L78
            if (r7 <= r8) goto L73
            r1 = r5
            r7 = r8
            goto L79
        L73:
            if (r7 >= r10) goto L78
            r1 = r5
            r7 = r10
            goto L79
        L78:
            r1 = r4
        L79:
            o0.b r6 = r0.f9042g0
            if (r6 == 0) goto L9c
            if (r1 == 0) goto L9c
            boolean r6 = r12.x(r5)
            if (r6 != 0) goto L9c
            o0.b r6 = r0.f9042g0
            r8 = 0
            int r9 = r12.getScrollRange()
            r10 = 0
            r11 = 0
            r13 = r6
            r14 = r3
            r15 = r7
            r16 = r10
            r17 = r11
            r18 = r8
            r19 = r9
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L9c:
            r12.onOverScrolled(r3, r7, r2, r1)
            if (r2 != 0) goto La3
            if (r1 == 0) goto La4
        La3:
            r4 = r5
        La4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollview.a.H(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean I(int i3) {
        boolean z3 = i3 == 130;
        int height = getHeight();
        if (z3) {
            this.f9041f0.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f9041f0;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f9041f0.top = getScrollY() - height;
            Rect rect2 = this.f9041f0;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f9041f0;
        int i4 = rect3.top;
        int i5 = height + i4;
        rect3.bottom = i5;
        return M(i3, i4, i5);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void W(int i3) {
        super.W(i3);
    }

    @Override // androidx.core.widget.NestedScrollView
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
            findNextFocus.getDrawingRect(this.f9041f0);
            offsetDescendantRectToMyCoords(findNextFocus, this.f9041f0);
            p(f(this.f9041f0));
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        o0.b bVar = this.f9042g0;
        if (bVar == null || !bVar.computeScrollOffset()) {
            if (this.f9019B0) {
                this.f9019B0 = false;
                return;
            }
            return;
        }
        int i3 = this.f9042g0.i();
        if (!d() && getOverScrollMode() != 0 && (i3 < 0 || i3 > getScrollRange())) {
            a();
            this.f9042g0.abortAnimation();
            return;
        }
        int i4 = i3 - this.f9058w0;
        this.f9058w0 = i3;
        int[] iArr = this.f9056u0;
        iArr[1] = 0;
        k(0, i4, iArr, null, 1);
        int i5 = i4 - this.f9056u0[1];
        int scrollRange = getScrollRange();
        if (i5 != 0) {
            int scrollY = getScrollY();
            H(0, i5, getScrollX(), scrollY, 0, scrollRange, 0, this.f9060y0, false);
            int scrollY2 = getScrollY() - scrollY;
            int[] iArr2 = this.f9056u0;
            iArr2[1] = 0;
            l(0, scrollY2, 0, i5 - scrollY2, this.f9055t0, 1, iArr2);
            int i6 = this.f9056u0[1];
        }
        if (this.f9042g0.g()) {
            W(1);
        } else {
            y.Z(this);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        o0.b bVar;
        if (this.f9031S || (this.f9032T && e0())) {
            float velocityAlongScrollableDirection = getVelocityAlongScrollableDirection();
            Log.d("COUINestedScrollView", "dispatchTouchEvent: current velocity " + velocityAlongScrollableDirection + " threshold " + this.f9033U);
            if (motionEvent.getActionMasked() == 0 && this.f9033U >= Math.abs(velocityAlongScrollableDirection)) {
                o0.b bVar2 = this.f9042g0;
                float f3 = 0.0f;
                if (bVar2 != null && bVar2.f() != 0.0f) {
                    f3 = this.f9029Q;
                }
                this.f9036a0 = f3;
                o0.b bVar3 = this.f9042g0;
                if (bVar3 != null) {
                    bVar3.abortAnimation();
                }
                stopNestedScroll();
            }
            if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && (bVar = this.f9042g0) != null && bVar.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCOUIScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public int getScrollableRange() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    protected void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.r
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        F(i6, i7, iArr);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.q
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        F(i6, i7, null);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9046k0 = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.f9043h0;
        if (eVar != null) {
            eVar.u();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f9048m0) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY - verticalScrollFactorCompat;
                if (i3 < 0) {
                    scrollRange = 0;
                } else if (i3 <= scrollRange) {
                    scrollRange = i3;
                }
                if (scrollRange != scrollY) {
                    scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f9048m0) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = this.f9054s0;
                    if (i4 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i4);
                        if (findPointerIndex == -1) {
                            Log.e("COUINestedScrollView", "Invalid pointerId=" + i4 + " in onInterceptTouchEvent");
                        } else {
                            int x3 = (int) motionEvent.getX(findPointerIndex);
                            int y3 = (int) motionEvent.getY(findPointerIndex);
                            int abs = Math.abs(x3 - this.f9023K);
                            int abs2 = Math.abs(y3 - this.f9024L);
                            if (abs2 > this.f9051p0 && (2 & getNestedScrollAxes()) == 0 && Z(abs, abs2)) {
                                this.f9048m0 = true;
                                this.f9044i0 = y3;
                                B();
                                this.f9049n0.addMovement(motionEvent);
                                this.f9057v0 = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i3 != 3) {
                    if (i3 == 5) {
                        this.f9023K = (int) motionEvent.getX(0);
                        this.f9024L = (int) motionEvent.getY(0);
                    } else if (i3 == 6) {
                        G(motionEvent);
                    }
                }
            }
            this.f9048m0 = false;
            this.f9054s0 = -1;
            J();
            o0.b bVar = this.f9042g0;
            if (bVar != null && bVar.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                y.Z(this);
            }
            W(0);
        } else {
            o0.b bVar2 = this.f9042g0;
            float f3 = bVar2 != null ? bVar2.f() : 0.0f;
            boolean d02 = d0(this.f9029Q, this.f9036a0);
            this.f9025M = Math.abs(f3) > 0.0f && Math.abs(f3) < 250.0f && d02;
            this.f9026N = e0();
            this.f9022J = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("onInterceptTouchEvent: ACTION_DOWN, isFastFlingY = ");
            sb.append(d02);
            sb.append(", isSlowScrolling = ");
            sb.append(this.f9025M);
            sb.append(", \nMath.abs(scrollVelocityY) > 0 = ");
            sb.append(Math.abs(f3) > 0.0f);
            sb.append(", \nscrollVelocityY = ");
            sb.append(f3);
            sb.append(", \nMath.abs(scrollVelocityY) < SLOW_SCROLL_THRESHOLD = ");
            sb.append(Math.abs(f3) < 250.0f);
            sb.append(", \nisOverScrolling = ");
            sb.append(this.f9026N);
            sb.append(", scrollVelocityY = ");
            sb.append(Math.abs(f3));
            sb.append(", mFlingVelocityY = ");
            sb.append(this.f9029Q);
            Log.d("COUINestedScrollView", sb.toString());
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (y((int) motionEvent.getX(), y4)) {
                this.f9023K = x4;
                this.f9044i0 = y4;
                this.f9024L = y4;
                this.f9054s0 = motionEvent.getPointerId(0);
                z();
                this.f9049n0.addMovement(motionEvent);
                o0.b bVar3 = this.f9042g0;
                if (bVar3 != null) {
                    bVar3.computeScrollOffset();
                }
                o0.b bVar4 = this.f9042g0;
                this.f9048m0 = (bVar4 == null || bVar4.g()) ? false : true;
                U(2, 0);
            } else {
                this.f9048m0 = false;
                J();
            }
        }
        return this.f9048m0;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int scrollY = getScrollY();
        super.onLayout(z3, i3, i4, i5, i6);
        this.f9045j0 = false;
        View view = this.f9047l0;
        if (view != null && D(view, this)) {
            N(this.f9047l0);
        }
        this.f9047l0 = null;
        if (!this.f9046k0) {
            if (this.f9061z0 != null) {
                scrollTo(getScrollX(), this.f9061z0.f9062e);
                this.f9061z0 = null;
            }
            A0.b.c(this, scrollY);
        }
        A0.b.c(this, scrollY);
        g0(getScrollX(), getScrollY());
        this.f9046k0 = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        F(i6, 0, null);
        this.f9058w0 += i6;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z3, boolean z4) {
        if (getScrollY() == i4 && getScrollX() == i3) {
            return;
        }
        if ((i4 < 0 || i4 > getScrollRange()) && this.f9019B0) {
            int scrollRange = i4 >= getScrollRange() ? getScrollRange() : 0;
            i4 = g.a(scrollRange, i4 - scrollRange, this.f9021I);
        }
        if (getOverScrollMode() == 2 || (getOverScrollMode() == 1 && getChildAt(0).getHeight() <= getScrollableRange())) {
            i4 = Math.min(Math.max(i4, 0), getScrollRange());
        }
        if (getScrollY() >= 0 && i4 < 0 && this.f9019B0) {
            f0();
            e eVar = this.f9043h0;
            if (eVar != null) {
                eVar.notifyVerticalEdgeReached(i4, 0, this.f9060y0);
            }
        }
        if (getScrollY() <= getScrollRange() && i4 > getScrollRange() && this.f9019B0) {
            f0();
            e eVar2 = this.f9043h0;
            if (eVar2 != null) {
                eVar2.notifyVerticalEdgeReached(i4, getScrollRange(), this.f9060y0);
            }
        }
        this.f9058w0 = i4;
        scrollTo(i3, i4);
        invalidateParentIfNeeded();
        awakenScrollBars();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0112a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0112a c0112a = (C0112a) parcelable;
        super.onRestoreInstanceState(c0112a.getSuperState());
        this.f9061z0 = c0112a;
        requestLayout();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        C0112a c0112a = new C0112a(super.onSaveInstanceState());
        c0112a.f9062e = getScrollY();
        return c0112a;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
        super.onScrollChanged(i3, i4, i5, i6);
        if (this.f9039d0.size() <= 0) {
            return;
        }
        p.a(this.f9039d0.get(0));
        throw null;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f9021I = getContext().getResources().getDisplayMetrics().heightPixels;
        if (getScrollY() > getScrollRange()) {
            A0.b.c(this, getScrollRange());
            scrollTo(getScrollX(), getScrollY());
        }
        o0.b bVar = this.f9042g0;
        if (bVar != null) {
            bVar.abortAnimation();
        }
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !E(findFocus, 0, i6)) {
            return;
        }
        findFocus.getDrawingRect(this.f9041f0);
        offsetDescendantRectToMyCoords(findFocus, this.f9041f0);
        p(f(this.f9041f0));
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        o0.b bVar;
        B();
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = false;
        if (actionMasked == 0) {
            this.f9057v0 = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f9057v0);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                boolean e02 = e0();
                boolean z4 = this.f9027O && this.f9025M;
                if (this.f9028P && this.f9026N && e02) {
                    z3 = true;
                }
                if (z4 || z3) {
                    Y(motionEvent);
                }
                if (this.f9048m0) {
                    B();
                    VelocityTracker velocityTracker = this.f9049n0;
                    velocityTracker.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, this.f9053r0);
                    int yVelocity = (int) velocityTracker.getYVelocity(this.f9054s0);
                    if (Math.abs(yVelocity) <= this.f9052q0) {
                        o0.b bVar2 = this.f9042g0;
                        if (bVar2 != null && bVar2.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            y.Z(this);
                        }
                    } else if (getScrollY() < 0) {
                        if (yVelocity > -1500) {
                            o0.b bVar3 = this.f9042g0;
                            if (bVar3 != null) {
                                bVar3.j(-yVelocity);
                            }
                            o0.b bVar4 = this.f9042g0;
                            if (bVar4 != null && bVar4.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                                y.Z(this);
                            }
                        } else {
                            int i3 = -yVelocity;
                            float f3 = i3;
                            if (!dispatchNestedPreFling(0.0f, f3)) {
                                dispatchNestedFling(0.0f, f3, true);
                                u(i3);
                            }
                        }
                    } else if (getScrollY() <= getScrollRange()) {
                        int i4 = -yVelocity;
                        float f4 = i4;
                        if (!dispatchNestedPreFling(0.0f, f4)) {
                            dispatchNestedFling(0.0f, f4, true);
                            u(i4);
                        }
                    } else if (yVelocity < 1500) {
                        o0.b bVar5 = this.f9042g0;
                        if (bVar5 != null) {
                            bVar5.j(-yVelocity);
                        }
                        o0.b bVar6 = this.f9042g0;
                        if (bVar6 != null && bVar6.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            y.Z(this);
                        }
                    } else {
                        int i5 = -yVelocity;
                        float f5 = i5;
                        if (!dispatchNestedPreFling(0.0f, f5)) {
                            dispatchNestedFling(0.0f, f5, true);
                            u(i5);
                        }
                    }
                    if (getScrollY() < 0 || getScrollY() > getScrollRange()) {
                        f0();
                    }
                    this.f9054s0 = -1;
                    r();
                }
            } else if (actionMasked == 2) {
                o0.b bVar7 = this.f9042g0;
                if ((bVar7 instanceof e) && this.f9038c0) {
                    ((e) bVar7).J();
                }
                int findPointerIndex = motionEvent.findPointerIndex(this.f9054s0);
                if (findPointerIndex == -1) {
                    Log.e("COUINestedScrollView", "Invalid pointerId=" + this.f9054s0 + " in onTouchEvent");
                } else {
                    int y3 = (int) motionEvent.getY(findPointerIndex);
                    int i6 = this.f9044i0 - y3;
                    if (!this.f9048m0 && Math.abs(i6) > this.f9051p0) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f9048m0 = true;
                        i6 = i6 > 0 ? i6 - this.f9051p0 : i6 + this.f9051p0;
                    }
                    int i7 = i6;
                    if (this.f9048m0) {
                        if (k(0, i7, this.f9056u0, this.f9055t0, 0)) {
                            i7 -= this.f9056u0[1];
                            this.f9057v0 += this.f9055t0[1];
                        }
                        this.f9044i0 = y3 - this.f9055t0[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        if (getScrollY() < 0) {
                            i7 = g.b(i7, getScrollY(), this.f9059x0);
                        } else if (getScrollY() > getScrollRange()) {
                            i7 = g.b(i7, getScrollY() - getScrollRange(), this.f9059x0);
                        }
                        int i8 = i7;
                        if (H(0, i8, 0, getScrollY(), 0, scrollRange, 0, this.f9060y0, true) && !x(0)) {
                            this.f9049n0.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f9056u0;
                        iArr[1] = 0;
                        l(0, scrollY2, 0, i8 - scrollY2, this.f9055t0, 0, iArr);
                        int i9 = this.f9044i0;
                        int i10 = this.f9055t0[1];
                        this.f9044i0 = i9 - i10;
                        this.f9057v0 += i10;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f9048m0 && getChildCount() > 0 && (bVar = this.f9042g0) != null && bVar.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    y.Z(this);
                }
                this.f9054s0 = -1;
                r();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f9023K = (int) motionEvent.getX(actionIndex);
                int y4 = (int) motionEvent.getY(actionIndex);
                this.f9044i0 = y4;
                this.f9024L = y4;
                this.f9054s0 = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                G(motionEvent);
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f9054s0);
                if (findPointerIndex2 == -1) {
                    Log.e("COUINestedScrollView", "Invalid pointerId=" + this.f9054s0 + " in onTouchEvent ACTION_POINTER_UP");
                } else {
                    this.f9044i0 = (int) motionEvent.getY(findPointerIndex2);
                }
            }
        } else {
            if (getChildCount() == 0) {
                obtain.recycle();
                return false;
            }
            o0.b bVar8 = this.f9042g0;
            boolean z5 = (bVar8 == null || bVar8.g()) ? false : true;
            this.f9048m0 = z5;
            if (z5 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            o0.b bVar9 = this.f9042g0;
            if (bVar9 != null && !bVar9.g()) {
                this.f9036a0 = this.f9042g0.f() != 0.0f ? this.f9029Q : 0.0f;
                this.f9042g0.abortAnimation();
                if (this.f9019B0) {
                    this.f9019B0 = false;
                }
            }
            this.f9023K = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            this.f9044i0 = y5;
            this.f9024L = y5;
            this.f9054s0 = motionEvent.getPointerId(0);
            U(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f9049n0;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        e eVar;
        super.onVisibilityChanged(view, i3);
        if (i3 == 0 || (eVar = this.f9043h0) == null) {
            return;
        }
        eVar.abortAnimation();
        this.f9043h0.u();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f9045j0) {
            this.f9047l0 = view2;
        } else {
            N(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        if (z3) {
            J();
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f9045j0 = true;
        super.requestLayout();
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean s(KeyEvent keyEvent) {
        this.f9041f0.setEmpty();
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void scrollTo(int i3, int i4) {
        if (getChildCount() > 0) {
            if (getScrollX() == i3 && getScrollY() == i4) {
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (c0().booleanValue()) {
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

    public void setAvoidAccidentalTouch(boolean z3) {
        this.f9037b0 = z3;
    }

    public void setDispatchEventWhileOverScrolling(boolean z3) {
        this.f9032T = z3;
    }

    public void setDispatchEventWhileScrolling(boolean z3) {
        this.f9031S = z3;
    }

    public void setDispatchEventWhileScrollingThreshold(int i3) {
        this.f9033U = i3;
    }

    public void setEnableFlingSpeedIncrease(boolean z3) {
        e eVar = this.f9043h0;
        if (eVar != null) {
            eVar.D(z3);
        }
    }

    public void setEnableVibrator(boolean z3) {
        this.f9040e0 = z3;
    }

    public void setEventFilterTangent(float f3) {
        this.f9034V = f3;
    }

    public void setFastFlingThreshold(float f3) {
        this.f9035W = Math.max(f3, 0.0f);
    }

    public void setIsUseOptimizedScroll(boolean z3) {
        this.f9038c0 = z3;
    }

    public void setItemClickableWhileOverScrolling(boolean z3) {
        this.f9028P = z3;
    }

    public void setItemClickableWhileSlowScrolling(boolean z3) {
        this.f9027O = z3;
    }

    public void setOnScrollChangeListener(b bVar) {
    }

    @Override // androidx.core.widget.NestedScrollView
    public void setSmoothScrollingEnabled(boolean z3) {
        this.f9050o0 = z3;
    }

    public void setSpringOverScrollerDebug(boolean z3) {
        e eVar = this.f9043h0;
        if (eVar != null) {
            eVar.C(z3);
        }
    }

    @Override // androidx.core.widget.NestedScrollView
    public void u(int i3) {
        this.f9029Q = i3;
        if (getChildCount() > 0) {
            o0.b bVar = this.f9042g0;
            if (bVar != null) {
                bVar.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, 0, 0);
            }
            L(true);
            if (this.f9019B0) {
                return;
            }
            this.f9019B0 = true;
        }
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean v(int i3) {
        int childCount;
        boolean z3 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f9041f0;
        rect.top = 0;
        rect.bottom = height;
        if (z3 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f9041f0.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f9041f0;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f9041f0;
        return M(i3, rect3.top, rect3.bottom);
    }
}
