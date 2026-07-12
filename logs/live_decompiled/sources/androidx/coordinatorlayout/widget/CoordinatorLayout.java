package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.AbstractC0256e;
import androidx.core.view.J;
import androidx.core.view.q;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.t;
import androidx.core.view.y;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t.AbstractC0585a;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements q, r {

    /* renamed from: A, reason: collision with root package name */
    static final ThreadLocal f4750A;

    /* renamed from: B, reason: collision with root package name */
    static final Comparator f4751B;

    /* renamed from: C, reason: collision with root package name */
    private static final androidx.core.util.e f4752C;

    /* renamed from: y, reason: collision with root package name */
    static final String f4753y;

    /* renamed from: z, reason: collision with root package name */
    static final Class[] f4754z;

    /* renamed from: e, reason: collision with root package name */
    private final List f4755e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a f4756f;

    /* renamed from: g, reason: collision with root package name */
    private final List f4757g;

    /* renamed from: h, reason: collision with root package name */
    private final List f4758h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f4759i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f4760j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f4761k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4762l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4763m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f4764n;

    /* renamed from: o, reason: collision with root package name */
    private View f4765o;

    /* renamed from: p, reason: collision with root package name */
    private View f4766p;

    /* renamed from: q, reason: collision with root package name */
    private g f4767q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4768r;

    /* renamed from: s, reason: collision with root package name */
    private J f4769s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4770t;

    /* renamed from: u, reason: collision with root package name */
    private Drawable f4771u;

    /* renamed from: v, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f4772v;

    /* renamed from: w, reason: collision with root package name */
    private t f4773w;

    /* renamed from: x, reason: collision with root package name */
    private final s f4774x;

    class a implements t {
        a() {
        }

        @Override // androidx.core.view.t
        public J onApplyWindowInsets(View view, J j3) {
            return CoordinatorLayout.this.W(j3);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c {
        public c() {
        }

        public static Object getTag(View view) {
            return ((f) view.getLayoutParams()).f4794r;
        }

        public static void setTag(View view, Object obj) {
            ((f) view.getLayoutParams()).f4794r = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            return getScrimOpacity(coordinatorLayout, view) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public J onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, J j3) {
            return j3;
        }

        public void onAttachedToLayoutParams(f fVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4, boolean z3) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z3) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
            if (i5 == 0) {
                onNestedPreScroll(coordinatorLayout, view, view2, i3, i4, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7) {
            if (i7 == 0) {
                onNestedScroll(coordinatorLayout, view, view2, i3, i4, i5, i6);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            if (i4 == 0) {
                onNestedScrollAccepted(coordinatorLayout, view, view2, view3, i3);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            if (i4 == 0) {
                return onStartNestedScroll(coordinatorLayout, view, view2, view3, i3);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3) {
            if (i3 == 0) {
                onStopNestedScroll(coordinatorLayout, view, view2);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            iArr[0] = iArr[0] + i5;
            iArr[1] = iArr[1] + i6;
            onNestedScroll(coordinatorLayout, view, view2, i3, i4, i5, i6, i7);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4772v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4772v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    static class i implements Comparator {
        i() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float I3 = y.I(view);
            float I4 = y.I(view2);
            if (I3 > I4) {
                return -1;
            }
            return I3 < I4 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f4753y = r02 != null ? r02.getName() : null;
        f4751B = new i();
        f4754z = new Class[]{Context.class, AttributeSet.class};
        f4750A = new ThreadLocal();
        f4752C = new androidx.core.util.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0585a.f13335a);
    }

    private boolean A(View view) {
        return this.f4756f.j(view);
    }

    private void C(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        Rect a3 = a();
        a3.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f4769s != null && y.u(this) && !y.u(view)) {
            a3.left += this.f4769s.i();
            a3.top += this.f4769s.k();
            a3.right -= this.f4769s.j();
            a3.bottom -= this.f4769s.h();
        }
        Rect a4 = a();
        AbstractC0256e.a(S(fVar.f4779c), view.getMeasuredWidth(), view.getMeasuredHeight(), a3, a4, i3);
        view.layout(a4.left, a4.top, a4.right, a4.bottom);
        O(a3);
        O(a4);
    }

    private void D(View view, View view2, int i3) {
        Rect a3 = a();
        Rect a4 = a();
        try {
            t(view2, a3);
            u(view, i3, a3, a4);
            view.layout(a4.left, a4.top, a4.right, a4.bottom);
        } finally {
            O(a3);
            O(a4);
        }
    }

    private void E(View view, int i3, int i4) {
        f fVar = (f) view.getLayoutParams();
        int b3 = AbstractC0256e.b(T(fVar.f4779c), i4);
        int i5 = b3 & 7;
        int i6 = b3 & FeedbackActivity.SHOW_NO_NETWORK;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 == 1) {
            i3 = width - i3;
        }
        int w3 = w(i3) - measuredWidth;
        if (i5 == 1) {
            w3 += measuredWidth / 2;
        } else if (i5 == 5) {
            w3 += measuredWidth;
        }
        int i7 = i6 != 16 ? i6 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(w3, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void F(View view, Rect rect, int i3) {
        boolean z3;
        boolean z4;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        if (y.O(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c e3 = fVar.e();
            Rect a3 = a();
            Rect a4 = a();
            a4.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (e3 == null || !e3.getInsetDodgeRect(this, view, a3)) {
                a3.set(a4);
            } else if (!a4.contains(a3)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a3.toShortString() + " | Bounds:" + a4.toShortString());
            }
            O(a4);
            if (a3.isEmpty()) {
                O(a3);
                return;
            }
            int b3 = AbstractC0256e.b(fVar.f4784h, i3);
            boolean z5 = true;
            if ((b3 & 48) != 48 || (i8 = (a3.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f4786j) >= (i9 = rect.top)) {
                z3 = false;
            } else {
                V(view, i9 - i8);
                z3 = true;
            }
            if ((b3 & 80) == 80 && (height = ((getHeight() - a3.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f4786j) < (i7 = rect.bottom)) {
                V(view, height - i7);
                z3 = true;
            }
            if (!z3) {
                V(view, 0);
            }
            if ((b3 & 3) != 3 || (i5 = (a3.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f4785i) >= (i6 = rect.left)) {
                z4 = false;
            } else {
                U(view, i6 - i5);
                z4 = true;
            }
            if ((b3 & 5) != 5 || (width = ((getWidth() - a3.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f4785i) >= (i4 = rect.right)) {
                z5 = z4;
            } else {
                U(view, width - i4);
            }
            if (!z5) {
                U(view, 0);
            }
            O(a3);
        }
    }

    static c K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f4753y;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f4750A;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f4754z);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(context, attributeSet);
        } catch (Exception e3) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e3);
        }
    }

    private boolean L(MotionEvent motionEvent, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f4757g;
        z(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) list.get(i4);
            f fVar = (f) view.getLayoutParams();
            c e3 = fVar.e();
            if (!(z3 || z4) || actionMasked == 0) {
                if (!z3 && e3 != null) {
                    if (i3 == 0) {
                        z3 = e3.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i3 == 1) {
                        z3 = e3.onTouchEvent(this, view, motionEvent);
                    }
                    if (z3) {
                        this.f4765o = view;
                    }
                }
                boolean c3 = fVar.c();
                boolean h3 = fVar.h(this, view);
                z4 = h3 && !c3;
                if (h3 && !z4) {
                    break;
                }
            } else if (e3 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    e3.onInterceptTouchEvent(this, view, motionEvent2);
                } else if (i3 == 1) {
                    e3.onTouchEvent(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z3;
    }

    private void M() {
        this.f4755e.clear();
        this.f4756f.c();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f y3 = y(childAt);
            y3.d(this, childAt);
            this.f4756f.b(childAt);
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != i3) {
                    View childAt2 = getChildAt(i4);
                    if (y3.b(this, childAt, childAt2)) {
                        if (!this.f4756f.d(childAt2)) {
                            this.f4756f.b(childAt2);
                        }
                        this.f4756f.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f4755e.addAll(this.f4756f.i());
        Collections.reverse(this.f4755e);
    }

    private static void O(Rect rect) {
        rect.setEmpty();
        f4752C.a(rect);
    }

    private void Q(boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            c e3 = ((f) childAt.getLayoutParams()).e();
            if (e3 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z3) {
                    e3.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    e3.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            ((f) getChildAt(i4).getLayoutParams()).l();
        }
        this.f4765o = null;
        this.f4762l = false;
    }

    private static int R(int i3) {
        if (i3 == 0) {
            return 17;
        }
        return i3;
    }

    private static int S(int i3) {
        if ((i3 & 7) == 0) {
            i3 |= 8388611;
        }
        return (i3 & FeedbackActivity.SHOW_NO_NETWORK) == 0 ? i3 | 48 : i3;
    }

    private static int T(int i3) {
        if (i3 == 0) {
            return 8388661;
        }
        return i3;
    }

    private void U(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        int i4 = fVar.f4785i;
        if (i4 != i3) {
            y.T(view, i3 - i4);
            fVar.f4785i = i3;
        }
    }

    private void V(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        int i4 = fVar.f4786j;
        if (i4 != i3) {
            y.U(view, i3 - i4);
            fVar.f4786j = i3;
        }
    }

    private void X() {
        if (!y.u(this)) {
            y.x0(this, null);
            return;
        }
        if (this.f4773w == null) {
            this.f4773w = new a();
        }
        y.x0(this, this.f4773w);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect rect = (Rect) f4752C.b();
        return rect == null ? new Rect() : rect;
    }

    private static int c(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
    }

    private void d(f fVar, Rect rect, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i4) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i3 + max, i4 + max2);
    }

    private J e(J j3) {
        c e3;
        if (j3.o()) {
            return j3;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (y.u(childAt) && (e3 = ((f) childAt.getLayoutParams()).e()) != null) {
                j3 = e3.onApplyWindowInsets(this, childAt, j3);
                if (j3.o()) {
                    break;
                }
            }
        }
        return j3;
    }

    private void v(View view, int i3, Rect rect, Rect rect2, f fVar, int i4, int i5) {
        int b3 = AbstractC0256e.b(R(fVar.f4779c), i3);
        int b4 = AbstractC0256e.b(S(fVar.f4780d), i3);
        int i6 = b3 & 7;
        int i7 = b3 & FeedbackActivity.SHOW_NO_NETWORK;
        int i8 = b4 & 7;
        int i9 = b4 & FeedbackActivity.SHOW_NO_NETWORK;
        int width = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            width -= i4 / 2;
        } else if (i6 != 5) {
            width -= i4;
        }
        if (i7 == 16) {
            height -= i5 / 2;
        } else if (i7 != 80) {
            height -= i5;
        }
        rect2.set(width, height, i4 + width, i5 + height);
    }

    private int w(int i3) {
        int[] iArr = this.f4764n;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    private void z(List list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator comparator = f4751B;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public boolean B(View view, int i3, int i4) {
        Rect a3 = a();
        t(view, a3);
        try {
            return a3.contains(i3, i4);
        } finally {
            O(a3);
        }
    }

    void G(View view, int i3) {
        c e3;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f4787k != null) {
            Rect a3 = a();
            Rect a4 = a();
            Rect a5 = a();
            t(fVar.f4787k, a3);
            q(view, false, a4);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            v(view, i3, a3, a5, fVar, measuredWidth, measuredHeight);
            boolean z3 = (a5.left == a4.left && a5.top == a4.top) ? false : true;
            d(fVar, a5, measuredWidth, measuredHeight);
            int i4 = a5.left - a4.left;
            int i5 = a5.top - a4.top;
            if (i4 != 0) {
                y.T(view, i4);
            }
            if (i5 != 0) {
                y.U(view, i5);
            }
            if (z3 && (e3 = fVar.e()) != null) {
                e3.onDependentViewChanged(this, view, fVar.f4787k);
            }
            O(a3);
            O(a4);
            O(a5);
        }
    }

    final void H(int i3) {
        boolean z3;
        int x3 = y.x(this);
        int size = this.f4755e.size();
        Rect a3 = a();
        Rect a4 = a();
        Rect a5 = a();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) this.f4755e.get(i4);
            f fVar = (f) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (fVar.f4788l == ((View) this.f4755e.get(i5))) {
                        G(view, x3);
                    }
                }
                q(view, true, a4);
                if (fVar.f4783g != 0 && !a4.isEmpty()) {
                    int b3 = AbstractC0256e.b(fVar.f4783g, x3);
                    int i6 = b3 & FeedbackActivity.SHOW_NO_NETWORK;
                    if (i6 == 48) {
                        a3.top = Math.max(a3.top, a4.bottom);
                    } else if (i6 == 80) {
                        a3.bottom = Math.max(a3.bottom, getHeight() - a4.top);
                    }
                    int i7 = b3 & 7;
                    if (i7 == 3) {
                        a3.left = Math.max(a3.left, a4.right);
                    } else if (i7 == 5) {
                        a3.right = Math.max(a3.right, getWidth() - a4.left);
                    }
                }
                if (fVar.f4784h != 0 && view.getVisibility() == 0) {
                    F(view, a3, x3);
                }
                if (i3 != 2) {
                    x(view, a5);
                    if (!a5.equals(a4)) {
                        N(view, a4);
                    }
                }
                for (int i8 = i4 + 1; i8 < size; i8++) {
                    View view2 = (View) this.f4755e.get(i8);
                    f fVar2 = (f) view2.getLayoutParams();
                    c e3 = fVar2.e();
                    if (e3 != null && e3.layoutDependsOn(this, view2, view)) {
                        if (i3 == 0 && fVar2.f()) {
                            fVar2.j();
                        } else {
                            if (i3 != 2) {
                                z3 = e3.onDependentViewChanged(this, view2, view);
                            } else {
                                e3.onDependentViewRemoved(this, view2, view);
                                z3 = true;
                            }
                            if (i3 == 1) {
                                fVar2.o(z3);
                            }
                        }
                    }
                }
            }
        }
        O(a3);
        O(a4);
        O(a5);
    }

    public void I(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f4787k;
        if (view2 != null) {
            D(view, view2, i3);
            return;
        }
        int i4 = fVar.f4781e;
        if (i4 >= 0) {
            E(view, i4, i3);
        } else {
            C(view, i3);
        }
    }

    public void J(View view, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    void N(View view, Rect rect) {
        ((f) view.getLayoutParams()).p(rect);
    }

    void P() {
        if (this.f4763m && this.f4767q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4767q);
        }
        this.f4768r = false;
    }

    final J W(J j3) {
        if (androidx.core.util.c.a(this.f4769s, j3)) {
            return j3;
        }
        this.f4769s = j3;
        boolean z3 = false;
        boolean z4 = j3 != null && j3.k() > 0;
        this.f4770t = z4;
        if (!z4 && getBackground() == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        J e3 = e(j3);
        requestLayout();
        return e3;
    }

    void b() {
        if (this.f4763m) {
            if (this.f4767q == null) {
                this.f4767q = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4767q);
        }
        this.f4768r = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f4777a;
        if (cVar != null) {
            float scrimOpacity = cVar.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.f4759i == null) {
                    this.f4759i = new Paint();
                }
                this.f4759i.setColor(fVar.f4777a.getScrimColor(this, view));
                this.f4759i.setAlpha(c(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f4759i);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4771u;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public void f(View view) {
        List g3 = this.f4756f.g(view);
        if (g3 == null || g3.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < g3.size(); i3++) {
            View view2 = (View) g3.get(i3);
            c e3 = ((f) view2.getLayoutParams()).e();
            if (e3 != null) {
                e3.onDependentViewChanged(this, view2, view);
            }
        }
    }

    void g() {
        int childCount = getChildCount();
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (A(getChildAt(i3))) {
                z3 = true;
                break;
            }
            i3++;
        }
        if (z3 != this.f4768r) {
            if (z3) {
                b();
            } else {
                P();
            }
        }
    }

    final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f4755e);
    }

    public final J getLastWindowInsets() {
        return this.f4769s;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4774x.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f4771u;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // androidx.core.view.q
    public void h(View view, View view2, int i3, int i4) {
        c e3;
        this.f4774x.c(view, view2, i3, i4);
        this.f4766p = view2;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.i(i4) && (e3 = fVar.e()) != null) {
                e3.onNestedScrollAccepted(this, childAt, view, view2, i3, i4);
            }
        }
    }

    @Override // androidx.core.view.q
    public void i(View view, int i3) {
        this.f4774x.d(view, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.i(i3)) {
                c e3 = fVar.e();
                if (e3 != null) {
                    e3.onStopNestedScroll(this, childAt, view, i3);
                }
                fVar.k(i3);
                fVar.j();
            }
        }
        this.f4766p = null;
    }

    @Override // androidx.core.view.q
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        c e3;
        int childCount = getChildCount();
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(i5) && (e3 = fVar.e()) != null) {
                    int[] iArr2 = this.f4760j;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    e3.onNestedPreScroll(this, childAt, view, i3, i4, iArr2, i5);
                    int[] iArr3 = this.f4760j;
                    i6 = i3 > 0 ? Math.max(i6, iArr3[0]) : Math.min(i6, iArr3[0]);
                    int[] iArr4 = this.f4760j;
                    i7 = i4 > 0 ? Math.max(i7, iArr4[1]) : Math.min(i7, iArr4[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (z3) {
            H(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // androidx.core.view.r
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        c e3;
        boolean z3;
        int min;
        int childCount = getChildCount();
        boolean z4 = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(i7) && (e3 = fVar.e()) != null) {
                    int[] iArr2 = this.f4760j;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    e3.onNestedScroll(this, childAt, view, i3, i4, i5, i6, i7, iArr2);
                    int[] iArr3 = this.f4760j;
                    i8 = i5 > 0 ? Math.max(i8, iArr3[0]) : Math.min(i8, iArr3[0]);
                    if (i6 > 0) {
                        z3 = true;
                        min = Math.max(i9, this.f4760j[1]);
                    } else {
                        z3 = true;
                        min = Math.min(i9, this.f4760j[1]);
                    }
                    i9 = min;
                    z4 = z3;
                }
            }
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (z4) {
            H(1);
        }
    }

    @Override // androidx.core.view.q
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        m(view, i3, i4, i5, i6, 0, this.f4761k);
    }

    @Override // androidx.core.view.q
    public boolean o(View view, View view2, int i3, int i4) {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c e3 = fVar.e();
                if (e3 != null) {
                    boolean onStartNestedScroll = e3.onStartNestedScroll(this, childAt, view, view2, i3, i4);
                    z3 |= onStartNestedScroll;
                    fVar.q(i4, onStartNestedScroll);
                } else {
                    fVar.q(i4, false);
                }
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.f4768r) {
            if (this.f4767q == null) {
                this.f4767q = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4767q);
        }
        if (this.f4769s == null && y.u(this)) {
            y.f0(this);
        }
        this.f4763m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.f4768r && this.f4767q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4767q);
        }
        View view = this.f4766p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f4763m = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f4770t || this.f4771u == null) {
            return;
        }
        J j3 = this.f4769s;
        int k3 = j3 != null ? j3.k() : 0;
        if (k3 > 0) {
            this.f4771u.setBounds(0, 0, getWidth(), k3);
            this.f4771u.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean L3 = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return L3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        c e3;
        int x3 = y.x(this);
        int size = this.f4755e.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) this.f4755e.get(i7);
            if (view.getVisibility() != 8 && ((e3 = ((f) view.getLayoutParams()).e()) == null || !e3.onLayoutChild(this, view, x3))) {
                I(view, x3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011c, code lost:
    
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z3) {
        c e3;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(0) && (e3 = fVar.e()) != null) {
                    z4 |= e3.onNestedFling(this, childAt, view, f3, f4, z3);
                }
            }
        }
        if (z4) {
            H(1);
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        c e3;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.i(0) && (e3 = fVar.e()) != null) {
                    z3 |= e3.onNestedPreFling(this, childAt, view, f3, f4);
                }
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        j(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        n(view, i3, i4, i5, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        h(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        SparseArray sparseArray = hVar.f4796e;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            c e3 = y(childAt).e();
            if (id != -1 && e3 != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                e3.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            c e3 = ((f) childAt.getLayoutParams()).e();
            if (id != -1 && e3 != null && (onSaveInstanceState = e3.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        hVar.f4796e = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return o(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f4765o
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.L(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f4765o
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.e()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f4765o
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f4765o
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.Q(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void q(View view, boolean z3, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z3) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List r(View view) {
        List h3 = this.f4756f.h(view);
        this.f4758h.clear();
        if (h3 != null) {
            this.f4758h.addAll(h3);
        }
        return this.f4758h;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        c e3 = ((f) view.getLayoutParams()).e();
        if (e3 == null || !e3.onRequestChildRectangleOnScreen(this, view, rect, z3)) {
            return super.requestChildRectangleOnScreen(view, rect, z3);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        super.requestDisallowInterceptTouchEvent(z3);
        if (!z3 || this.f4762l) {
            return;
        }
        Q(false);
        this.f4762l = true;
    }

    public List s(View view) {
        List g3 = this.f4756f.g(view);
        this.f4758h.clear();
        if (g3 != null) {
            this.f4758h.addAll(g3);
        }
        return this.f4758h;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z3) {
        super.setFitsSystemWindows(z3);
        X();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4772v = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f4771u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f4771u = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f4771u.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.g(this.f4771u, y.x(this));
                this.f4771u.setVisible(getVisibility() == 0, false);
                this.f4771u.setCallback(this);
            }
            y.Z(this);
        }
    }

    public void setStatusBarBackgroundColor(int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(int i3) {
        setStatusBarBackground(i3 != 0 ? androidx.core.content.a.e(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f4771u;
        if (drawable == null || drawable.isVisible() == z3) {
            return;
        }
        this.f4771u.setVisible(z3, false);
    }

    void t(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void u(View view, int i3, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i3, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4771u;
    }

    void x(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f y(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f4778b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.n(behavior);
                fVar.f4778b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.n((c) dVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e3) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e3);
                    }
                }
                fVar.f4778b = true;
            }
        }
        return fVar;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4755e = new ArrayList();
        this.f4756f = new androidx.coordinatorlayout.widget.a();
        this.f4757g = new ArrayList();
        this.f4758h = new ArrayList();
        this.f4760j = new int[2];
        this.f4761k = new int[2];
        this.f4774x = new s(this);
        TypedArray obtainStyledAttributes = i3 == 0 ? context.obtainStyledAttributes(attributeSet, t.c.f13338b, 0, t.b.f13336a) : context.obtainStyledAttributes(attributeSet, t.c.f13338b, i3, 0);
        if (i3 == 0) {
            saveAttributeDataForStyleable(context, t.c.f13338b, attributeSet, obtainStyledAttributes, 0, t.b.f13336a);
        } else {
            saveAttributeDataForStyleable(context, t.c.f13338b, attributeSet, obtainStyledAttributes, i3, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(t.c.f13339c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f4764n = resources.getIntArray(resourceId);
            float f3 = resources.getDisplayMetrics().density;
            int length = this.f4764n.length;
            for (int i4 = 0; i4 < length; i4++) {
                this.f4764n[i4] = (int) (r12[i4] * f3);
            }
        }
        this.f4771u = obtainStyledAttributes.getDrawable(t.c.f13340d);
        obtainStyledAttributes.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (y.v(this) == 0) {
            y.u0(this, 1);
        }
    }

    protected static class h extends AbstractC0645a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        SparseArray f4796e;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f4796e = new SparseArray(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
                this.f4796e.append(iArr[i3], readParcelableArray[i3]);
            }
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            SparseArray sparseArray = this.f4796e;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = this.f4796e.keyAt(i4);
                parcelableArr[i4] = (Parcelable) this.f4796e.valueAt(i4);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i3);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        c f4777a;

        /* renamed from: b, reason: collision with root package name */
        boolean f4778b;

        /* renamed from: c, reason: collision with root package name */
        public int f4779c;

        /* renamed from: d, reason: collision with root package name */
        public int f4780d;

        /* renamed from: e, reason: collision with root package name */
        public int f4781e;

        /* renamed from: f, reason: collision with root package name */
        int f4782f;

        /* renamed from: g, reason: collision with root package name */
        public int f4783g;

        /* renamed from: h, reason: collision with root package name */
        public int f4784h;

        /* renamed from: i, reason: collision with root package name */
        int f4785i;

        /* renamed from: j, reason: collision with root package name */
        int f4786j;

        /* renamed from: k, reason: collision with root package name */
        View f4787k;

        /* renamed from: l, reason: collision with root package name */
        View f4788l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f4789m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f4790n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f4791o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f4792p;

        /* renamed from: q, reason: collision with root package name */
        final Rect f4793q;

        /* renamed from: r, reason: collision with root package name */
        Object f4794r;

        public f(int i3, int i4) {
            super(i3, i4);
            this.f4778b = false;
            this.f4779c = 0;
            this.f4780d = 0;
            this.f4781e = -1;
            this.f4782f = -1;
            this.f4783g = 0;
            this.f4784h = 0;
            this.f4793q = new Rect();
        }

        private void m(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f4782f);
            this.f4787k = findViewById;
            if (findViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f4788l = null;
                    this.f4787k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f4782f) + " to anchor view " + view);
            }
            if (findViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f4788l = null;
                this.f4787k = null;
                return;
            }
            for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f4788l = null;
                    this.f4787k = null;
                    return;
                }
                if (parent instanceof View) {
                    findViewById = parent;
                }
            }
            this.f4788l = findViewById;
        }

        private boolean r(View view, int i3) {
            int b3 = AbstractC0256e.b(((f) view.getLayoutParams()).f4783g, i3);
            return b3 != 0 && (AbstractC0256e.b(this.f4784h, i3) & b3) == b3;
        }

        private boolean s(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f4787k.getId() != this.f4782f) {
                return false;
            }
            View view2 = this.f4787k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f4788l = null;
                    this.f4787k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f4788l = view2;
            return true;
        }

        boolean a() {
            return this.f4787k == null && this.f4782f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f4788l || r(view2, y.x(coordinatorLayout)) || ((cVar = this.f4777a) != null && cVar.layoutDependsOn(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f4777a == null) {
                this.f4789m = false;
            }
            return this.f4789m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f4782f == -1) {
                this.f4788l = null;
                this.f4787k = null;
                return null;
            }
            if (this.f4787k == null || !s(view, coordinatorLayout)) {
                m(view, coordinatorLayout);
            }
            return this.f4787k;
        }

        public c e() {
            return this.f4777a;
        }

        boolean f() {
            return this.f4792p;
        }

        Rect g() {
            return this.f4793q;
        }

        boolean h(CoordinatorLayout coordinatorLayout, View view) {
            boolean z3 = this.f4789m;
            if (z3) {
                return true;
            }
            c cVar = this.f4777a;
            boolean blocksInteractionBelow = (cVar != null ? cVar.blocksInteractionBelow(coordinatorLayout, view) : false) | z3;
            this.f4789m = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        boolean i(int i3) {
            if (i3 == 0) {
                return this.f4790n;
            }
            if (i3 != 1) {
                return false;
            }
            return this.f4791o;
        }

        void j() {
            this.f4792p = false;
        }

        void k(int i3) {
            q(i3, false);
        }

        void l() {
            this.f4789m = false;
        }

        public void n(c cVar) {
            c cVar2 = this.f4777a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.onDetachedFromLayoutParams();
                }
                this.f4777a = cVar;
                this.f4794r = null;
                this.f4778b = true;
                if (cVar != null) {
                    cVar.onAttachedToLayoutParams(this);
                }
            }
        }

        void o(boolean z3) {
            this.f4792p = z3;
        }

        void p(Rect rect) {
            this.f4793q.set(rect);
        }

        void q(int i3, boolean z3) {
            if (i3 == 0) {
                this.f4790n = z3;
            } else {
                if (i3 != 1) {
                    return;
                }
                this.f4791o = z3;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4778b = false;
            this.f4779c = 0;
            this.f4780d = 0;
            this.f4781e = -1;
            this.f4782f = -1;
            this.f4783g = 0;
            this.f4784h = 0;
            this.f4793q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.c.f13341e);
            this.f4779c = obtainStyledAttributes.getInteger(t.c.f13342f, 0);
            this.f4782f = obtainStyledAttributes.getResourceId(t.c.f13343g, -1);
            this.f4780d = obtainStyledAttributes.getInteger(t.c.f13344h, 0);
            this.f4781e = obtainStyledAttributes.getInteger(t.c.f13348l, -1);
            this.f4783g = obtainStyledAttributes.getInt(t.c.f13347k, 0);
            this.f4784h = obtainStyledAttributes.getInt(t.c.f13346j, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(t.c.f13345i);
            this.f4778b = hasValue;
            if (hasValue) {
                this.f4777a = CoordinatorLayout.K(context, attributeSet, obtainStyledAttributes.getString(t.c.f13345i));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f4777a;
            if (cVar != null) {
                cVar.onAttachedToLayoutParams(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f4778b = false;
            this.f4779c = 0;
            this.f4780d = 0;
            this.f4781e = -1;
            this.f4782f = -1;
            this.f4783g = 0;
            this.f4784h = 0;
            this.f4793q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4778b = false;
            this.f4779c = 0;
            this.f4780d = 0;
            this.f4781e = -1;
            this.f4782f = -1;
            this.f4783g = 0;
            this.f4784h = 0;
            this.f4793q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4778b = false;
            this.f4779c = 0;
            this.f4780d = 0;
            this.f4781e = -1;
            this.f4782f = -1;
            this.f4783g = 0;
            this.f4784h = 0;
            this.f4793q = new Rect();
        }
    }
}
