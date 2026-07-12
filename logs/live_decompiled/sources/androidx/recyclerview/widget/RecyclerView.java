package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.C0252a;
import androidx.core.view.accessibility.d;
import androidx.preference.Preference;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.m;
import androidx.recyclerview.widget.q;
import androidx.recyclerview.widget.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.view.w, androidx.core.view.o {
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.m mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    h mAdapter;
    a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private k mChildDrawingOrderCallback;
    d mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private l mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.g mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private t mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    m mItemAnimator;
    private m.a mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<o> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    p mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final y mObserver;
    private List<r> mOnChildAttachStateListeners;
    private s mOnFlingListener;
    private final ArrayList<t> mOnItemTouchListeners;
    final List<E> mPendingAccessibilityImportanceChange;
    z mPendingSavedState;
    boolean mPostedAnimatorRunner;
    g.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final w mRecycler;
    x mRecyclerListener;
    final List<x> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private u mScrollListener;
    private List<u> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.view.p mScrollingChildHelper;
    final B mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final D mViewFlinger;
    private final r.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.r mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    public static abstract class A {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f6295b;

        /* renamed from: c, reason: collision with root package name */
        private p f6296c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6297d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6298e;

        /* renamed from: f, reason: collision with root package name */
        private View f6299f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f6301h;

        /* renamed from: a, reason: collision with root package name */
        private int f6294a = -1;

        /* renamed from: g, reason: collision with root package name */
        private final a f6300g = new a(0, 0);

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f6302a;

            /* renamed from: b, reason: collision with root package name */
            private int f6303b;

            /* renamed from: c, reason: collision with root package name */
            private int f6304c;

            /* renamed from: d, reason: collision with root package name */
            private int f6305d;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f6306e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f6307f;

            /* renamed from: g, reason: collision with root package name */
            private int f6308g;

            public a(int i3, int i4) {
                this(i3, i4, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f6306e != null && this.f6304c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f6304c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f6305d >= 0;
            }

            public void b(int i3) {
                this.f6305d = i3;
            }

            void c(RecyclerView recyclerView) {
                int i3 = this.f6305d;
                if (i3 >= 0) {
                    this.f6305d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i3);
                    this.f6307f = false;
                } else {
                    if (!this.f6307f) {
                        this.f6308g = 0;
                        return;
                    }
                    e();
                    recyclerView.mViewFlinger.e(this.f6302a, this.f6303b, this.f6304c, this.f6306e);
                    int i4 = this.f6308g + 1;
                    this.f6308g = i4;
                    if (i4 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f6307f = false;
                }
            }

            public void d(int i3, int i4, int i5, Interpolator interpolator) {
                this.f6302a = i3;
                this.f6303b = i4;
                this.f6304c = i5;
                this.f6306e = interpolator;
                this.f6307f = true;
            }

            public a(int i3, int i4, int i5, Interpolator interpolator) {
                this.f6305d = -1;
                this.f6307f = false;
                this.f6308g = 0;
                this.f6302a = i3;
                this.f6303b = i4;
                this.f6304c = i5;
                this.f6306e = interpolator;
            }
        }

        public interface b {
            PointF a(int i3);
        }

        public PointF a(int i3) {
            Object e3 = e();
            if (e3 instanceof b) {
                return ((b) e3).a(i3);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i3) {
            return this.f6295b.mLayout.C(i3);
        }

        public int c() {
            return this.f6295b.mLayout.J();
        }

        public int d(View view) {
            return this.f6295b.getChildLayoutPosition(view);
        }

        public p e() {
            return this.f6296c;
        }

        public int f() {
            return this.f6294a;
        }

        public boolean g() {
            return this.f6297d;
        }

        public boolean h() {
            return this.f6298e;
        }

        protected void i(PointF pointF) {
            float f3 = pointF.x;
            float f4 = pointF.y;
            float sqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i3, int i4) {
            PointF a3;
            RecyclerView recyclerView = this.f6295b;
            if (this.f6294a == -1 || recyclerView == null) {
                r();
            }
            if (this.f6297d && this.f6299f == null && this.f6296c != null && (a3 = a(this.f6294a)) != null) {
                float f3 = a3.x;
                if (f3 != 0.0f || a3.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f3), (int) Math.signum(a3.y), null);
                }
            }
            this.f6297d = false;
            View view = this.f6299f;
            if (view != null) {
                if (d(view) == this.f6294a) {
                    o(this.f6299f, recyclerView.mState, this.f6300g);
                    this.f6300g.c(recyclerView);
                    r();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f6299f = null;
                }
            }
            if (this.f6298e) {
                l(i3, i4, recyclerView.mState, this.f6300g);
                boolean a4 = this.f6300g.a();
                this.f6300g.c(recyclerView);
                if (a4 && this.f6298e) {
                    this.f6297d = true;
                    recyclerView.mViewFlinger.d();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f6299f = view;
            }
        }

        protected abstract void l(int i3, int i4, B b3, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, B b3, a aVar);

        public void p(int i3) {
            this.f6294a = i3;
        }

        void q(RecyclerView recyclerView, p pVar) {
            recyclerView.mViewFlinger.f();
            if (this.f6301h) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f6295b = recyclerView;
            this.f6296c = pVar;
            int i3 = this.f6294a;
            if (i3 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f6309a = i3;
            this.f6298e = true;
            this.f6297d = true;
            this.f6299f = b(f());
            m();
            this.f6295b.mViewFlinger.d();
            this.f6301h = true;
        }

        protected final void r() {
            if (this.f6298e) {
                this.f6298e = false;
                n();
                this.f6295b.mState.f6309a = -1;
                this.f6299f = null;
                this.f6294a = -1;
                this.f6297d = false;
                this.f6296c.h1(this);
                this.f6296c = null;
                this.f6295b = null;
            }
        }
    }

    public static class B {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray f6310b;

        /* renamed from: m, reason: collision with root package name */
        int f6321m;

        /* renamed from: n, reason: collision with root package name */
        long f6322n;

        /* renamed from: o, reason: collision with root package name */
        int f6323o;

        /* renamed from: p, reason: collision with root package name */
        int f6324p;

        /* renamed from: q, reason: collision with root package name */
        int f6325q;

        /* renamed from: a, reason: collision with root package name */
        int f6309a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f6311c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f6312d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f6313e = 1;

        /* renamed from: f, reason: collision with root package name */
        int f6314f = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f6315g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f6316h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f6317i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f6318j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f6319k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f6320l = false;

        void a(int i3) {
            if ((this.f6313e & i3) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.f6313e));
        }

        public int b() {
            return this.f6316h ? this.f6311c - this.f6312d : this.f6314f;
        }

        public int c() {
            return this.f6309a;
        }

        public boolean d() {
            return this.f6309a != -1;
        }

        public boolean e() {
            return this.f6316h;
        }

        void f(h hVar) {
            this.f6313e = 1;
            this.f6314f = hVar.getItemCount();
            this.f6316h = false;
            this.f6317i = false;
            this.f6318j = false;
        }

        public boolean g() {
            return this.f6320l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f6309a + ", mData=" + this.f6310b + ", mItemCount=" + this.f6314f + ", mIsMeasuring=" + this.f6318j + ", mPreviousLayoutItemCount=" + this.f6311c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f6312d + ", mStructureChanged=" + this.f6315g + ", mInPreLayout=" + this.f6316h + ", mRunSimpleAnimations=" + this.f6319k + ", mRunPredictiveAnimations=" + this.f6320l + '}';
        }
    }

    public static abstract class C {
    }

    class D implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private int f6326e;

        /* renamed from: f, reason: collision with root package name */
        private int f6327f;

        /* renamed from: g, reason: collision with root package name */
        OverScroller f6328g;

        /* renamed from: h, reason: collision with root package name */
        Interpolator f6329h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6330i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f6331j;

        D() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f6329h = interpolator;
            this.f6330i = false;
            this.f6331j = false;
            this.f6328g = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i3, int i4) {
            int abs = Math.abs(i3);
            int abs2 = Math.abs(i4);
            boolean z3 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z3 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z3) {
                abs = abs2;
            }
            return Math.min((int) (((abs / width) + 1.0f) * 300.0f), RecyclerView.MAX_SCROLL_DURATION);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            androidx.core.view.y.a0(RecyclerView.this, this);
        }

        public void b(int i3, int i4) {
            RecyclerView.this.setScrollState(2);
            this.f6327f = 0;
            this.f6326e = 0;
            Interpolator interpolator = this.f6329h;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f6329h = interpolator2;
                this.f6328g = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f6328g.fling(0, 0, i3, i4, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, Integer.MIN_VALUE, Preference.DEFAULT_ORDER);
            d();
        }

        void d() {
            if (this.f6330i) {
                this.f6331j = true;
            } else {
                c();
            }
        }

        public void e(int i3, int i4, int i5, Interpolator interpolator) {
            if (i5 == Integer.MIN_VALUE) {
                i5 = a(i3, i4);
            }
            int i6 = i5;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f6329h != interpolator) {
                this.f6329h = interpolator;
                this.f6328g = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f6327f = 0;
            this.f6326e = 0;
            RecyclerView.this.setScrollState(2);
            this.f6328g.startScroll(0, 0, i3, i4, i6);
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f6328g.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                f();
                return;
            }
            this.f6331j = false;
            this.f6330i = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f6328g;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i5 = currX - this.f6326e;
                int i6 = currY - this.f6327f;
                this.f6326e = currX;
                this.f6327f = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i5, i6, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i5 -= iArr2[0];
                    i6 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i5, i6);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i5, i6, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i4 = iArr4[0];
                    i3 = iArr4[1];
                    i5 -= i4;
                    i6 -= i3;
                    A a3 = recyclerView4.mLayout.f6360g;
                    if (a3 != null && !a3.g() && a3.h()) {
                        int b3 = RecyclerView.this.mState.b();
                        if (b3 == 0) {
                            a3.r();
                        } else if (a3.f() >= b3) {
                            a3.p(b3 - 1);
                            a3.j(i4, i3);
                        } else {
                            a3.j(i4, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i4, i3, i5, i6, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i7 = i5 - iArr6[0];
                int i8 = i6 - iArr6[1];
                if (i4 != 0 || i3 != 0) {
                    recyclerView6.dispatchOnScrolled(i4, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z3 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i7 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i8 != 0));
                A a4 = RecyclerView.this.mLayout.f6360g;
                if ((a4 == null || !a4.g()) && z3) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i9 = i7 < 0 ? -currVelocity : i7 > 0 ? currVelocity : 0;
                        if (i8 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i8 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i9, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.g gVar = recyclerView7.mGapWorker;
                    if (gVar != null) {
                        gVar.f(recyclerView7, i4, i3);
                    }
                }
            }
            A a5 = RecyclerView.this.mLayout.f6360g;
            if (a5 != null && a5.g()) {
                a5.j(0, 0);
            }
            this.f6330i = false;
            if (this.f6331j) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    public static abstract class E {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        h mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        E mShadowedHolder = null;
        E mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        w mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public E(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void a() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                a();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i3) {
            this.mFlags = i3 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.view.y.L(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i3, int i4, boolean z3) {
            addFlags(8);
            offsetPosition(i4, z3);
            this.mPosition = i3;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final h getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            h adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i3 = this.mPreLayoutPosition;
            return i3 == -1 ? this.mPosition : i3;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i3 = this.mPreLayoutPosition;
            return i3 == -1 ? this.mPosition : i3;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        boolean hasAnyOfTheFlags(int i3) {
            return (this.mFlags & i3) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.view.y.L(this.itemView);
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i3, boolean z3) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z3) {
                this.mPreLayoutPosition += i3;
            }
            this.mPosition += i3;
            if (this.itemView.getLayoutParams() != null) {
                ((q) this.itemView.getLayoutParams()).f6380c = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i3 = this.mPendingAccessibilityState;
            if (i3 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i3;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.view.y.v(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i3, int i4) {
            this.mFlags = (i3 & i4) | (this.mFlags & (~i4));
        }

        public final void setIsRecyclable(boolean z3) {
            int i3 = this.mIsRecyclableCount;
            int i4 = z3 ? i3 - 1 : i3 + 1;
            this.mIsRecyclableCount = i4;
            if (i4 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z3 && i4 == 1) {
                this.mFlags |= 16;
            } else if (z3 && i4 == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(w wVar, boolean z3) {
            this.mScrapContainer = wVar;
            this.mInChangeScrap = z3;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void unScrap() {
            this.mScrapContainer.J(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    class RunnableC0276a implements Runnable {
        RunnableC0276a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b, reason: case insensitive filesystem */
    class RunnableC0277b implements Runnable {
        RunnableC0277b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = RecyclerView.this.mItemAnimator;
            if (mVar != null) {
                mVar.u();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c, reason: case insensitive filesystem */
    class InterpolatorC0278c implements Interpolator {
        InterpolatorC0278c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d, reason: case insensitive filesystem */
    class C0279d implements r.b {
        C0279d() {
        }

        @Override // androidx.recyclerview.widget.r.b
        public void a(E e3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.p1(e3.itemView, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.r.b
        public void b(E e3, m.b bVar, m.b bVar2) {
            RecyclerView.this.animateAppearance(e3, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.r.b
        public void c(E e3, m.b bVar, m.b bVar2) {
            RecyclerView.this.mRecycler.J(e3);
            RecyclerView.this.animateDisappearance(e3, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.r.b
        public void d(E e3, m.b bVar, m.b bVar2) {
            e3.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.b(e3, e3, bVar, bVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.d(e3, bVar, bVar2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e, reason: case insensitive filesystem */
    class C0280e implements d.b {
        C0280e() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public View a(int i3) {
            return RecyclerView.this.getChildAt(i3);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void b(View view) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.d.b
        public void c(int i3) {
            View childAt = RecyclerView.this.getChildAt(i3);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i3);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void d() {
            int k3 = k();
            for (int i3 = 0; i3 < k3; i3++) {
                View a3 = a(i3);
                RecyclerView.this.dispatchChildDetached(a3);
                a3.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.d.b
        public E e(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void f(int i3) {
            E childViewHolderInt;
            View a3 = a(i3);
            if (a3 != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(a3)) != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.addFlags(256);
            }
            RecyclerView.this.detachViewFromParent(i3);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void g(View view) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.d.b
        public void h(View view, int i3, ViewGroup.LayoutParams layoutParams) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i3, layoutParams);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void i(View view, int i3) {
            RecyclerView.this.addView(view, i3);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public int j(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public int k() {
            return RecyclerView.this.getChildCount();
        }
    }

    class f implements a.InterfaceC0093a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void a(int i3, int i4) {
            RecyclerView.this.offsetPositionRecordsForMove(i3, i4);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public E c(int i3) {
            E findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i3, true);
            if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.n(findViewHolderForPosition.itemView)) {
                return null;
            }
            return findViewHolderForPosition;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void d(int i3, int i4) {
            RecyclerView.this.offsetPositionRecordsForRemove(i3, i4, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f6312d += i4;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void e(int i3, int i4) {
            RecyclerView.this.offsetPositionRecordsForRemove(i3, i4, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void f(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void g(int i3, int i4) {
            RecyclerView.this.offsetPositionRecordsForInsert(i3, i4);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0093a
        public void h(int i3, int i4, Object obj) {
            RecyclerView.this.viewRangeUpdate(i3, i4, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        void i(a.b bVar) {
            int i3 = bVar.f6462a;
            if (i3 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.T0(recyclerView, bVar.f6463b, bVar.f6465d);
                return;
            }
            if (i3 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.W0(recyclerView2, bVar.f6463b, bVar.f6465d);
            } else if (i3 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.Y0(recyclerView3, bVar.f6463b, bVar.f6465d, bVar.f6464c);
            } else {
                if (i3 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.V0(recyclerView4, bVar.f6463b, bVar.f6465d, 1);
            }
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6338a;

        static {
            int[] iArr = new int[h.a.values().length];
            f6338a = iArr;
            try {
                iArr[h.a.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6338a[h.a.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class h {
        private final i mObservable = new i();
        private boolean mHasStableIds = false;
        private a mStateRestorationPolicy = a.ALLOW;

        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(E e3, int i3) {
            boolean z3 = e3.mBindingAdapter == null;
            if (z3) {
                e3.mPosition = i3;
                if (hasStableIds()) {
                    e3.mItemId = getItemId(i3);
                }
                e3.setFlags(1, 519);
                androidx.core.os.i.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            e3.mBindingAdapter = this;
            onBindViewHolder(e3, i3, e3.getUnmodifiedPayloads());
            if (z3) {
                e3.clearPayload();
                ViewGroup.LayoutParams layoutParams = e3.itemView.getLayoutParams();
                if (layoutParams instanceof q) {
                    ((q) layoutParams).f6380c = true;
                }
                androidx.core.os.i.b();
            }
        }

        boolean canRestoreState() {
            int i3 = g.f6338a[this.mStateRestorationPolicy.ordinal()];
            if (i3 != 1) {
                return i3 != 2 || getItemCount() > 0;
            }
            return false;
        }

        public final E createViewHolder(ViewGroup viewGroup, int i3) {
            try {
                androidx.core.os.i.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                E onCreateViewHolder = onCreateViewHolder(viewGroup, i3);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.mItemViewType = i3;
                return onCreateViewHolder;
            } finally {
                androidx.core.os.i.b();
            }
        }

        public int findRelativeAdapterPositionIn(h hVar, E e3, int i3) {
            if (hVar == this) {
                return i3;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i3) {
            return -1L;
        }

        public int getItemViewType(int i3) {
            return 0;
        }

        public final a getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i3) {
            this.mObservable.d(i3, 1);
        }

        public final void notifyItemInserted(int i3) {
            this.mObservable.f(i3, 1);
        }

        public final void notifyItemMoved(int i3, int i4) {
            this.mObservable.c(i3, i4);
        }

        public final void notifyItemRangeChanged(int i3, int i4) {
            this.mObservable.d(i3, i4);
        }

        public final void notifyItemRangeInserted(int i3, int i4) {
            this.mObservable.f(i3, i4);
        }

        public final void notifyItemRangeRemoved(int i3, int i4) {
            this.mObservable.g(i3, i4);
        }

        public final void notifyItemRemoved(int i3) {
            this.mObservable.g(i3, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(E e3, int i3);

        public void onBindViewHolder(E e3, int i3, List<Object> list) {
            onBindViewHolder(e3, i3);
        }

        public abstract E onCreateViewHolder(ViewGroup viewGroup, int i3);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(E e3) {
            return false;
        }

        public void onViewAttachedToWindow(E e3) {
        }

        public void onViewDetachedFromWindow(E e3) {
        }

        public void onViewRecycled(E e3) {
        }

        public void registerAdapterDataObserver(j jVar) {
            this.mObservable.registerObserver(jVar);
        }

        public void setHasStableIds(boolean z3) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z3;
        }

        public void setStateRestorationPolicy(a aVar) {
            this.mStateRestorationPolicy = aVar;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(j jVar) {
            this.mObservable.unregisterObserver(jVar);
        }

        public final void notifyItemChanged(int i3, Object obj) {
            this.mObservable.e(i3, 1, obj);
        }

        public final void notifyItemRangeChanged(int i3, int i4, Object obj) {
            this.mObservable.e(i3, i4, obj);
        }
    }

    static class i extends Observable {
        i() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i3, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).d(i3, i4, 1);
            }
        }

        public void d(int i3, int i4) {
            e(i3, i4, null);
        }

        public void e(int i3, int i4, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).b(i3, i4, obj);
            }
        }

        public void f(int i3, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).c(i3, i4);
            }
        }

        public void g(int i3, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).e(i3, i4);
            }
        }

        public void h() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).f();
            }
        }
    }

    public static abstract class j {
        public abstract void a();

        public abstract void b(int i3, int i4, Object obj);

        public abstract void c(int i3, int i4);

        public abstract void d(int i3, int i4, int i5);

        public abstract void e(int i3, int i4);

        public void f() {
        }
    }

    public interface k {
    }

    public static class l {
        protected EdgeEffect a(RecyclerView recyclerView, int i3) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class m {

        /* renamed from: a, reason: collision with root package name */
        private a f6343a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList f6344b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private long f6345c = 120;

        /* renamed from: d, reason: collision with root package name */
        private long f6346d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f6347e = 250;

        /* renamed from: f, reason: collision with root package name */
        private long f6348f = 250;

        interface a {
            void a(E e3);
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f6349a;

            /* renamed from: b, reason: collision with root package name */
            public int f6350b;

            /* renamed from: c, reason: collision with root package name */
            public int f6351c;

            /* renamed from: d, reason: collision with root package name */
            public int f6352d;

            public b a(E e3) {
                return b(e3, 0);
            }

            public b b(E e3, int i3) {
                View view = e3.itemView;
                this.f6349a = view.getLeft();
                this.f6350b = view.getTop();
                this.f6351c = view.getRight();
                this.f6352d = view.getBottom();
                return this;
            }
        }

        static int e(E e3) {
            int i3 = e3.mFlags;
            int i4 = i3 & 14;
            if (e3.isInvalid()) {
                return 4;
            }
            if ((i3 & 4) != 0) {
                return i4;
            }
            int oldPosition = e3.getOldPosition();
            int absoluteAdapterPosition = e3.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i4 : i4 | 2048;
        }

        public abstract boolean a(E e3, b bVar, b bVar2);

        public abstract boolean b(E e3, E e4, b bVar, b bVar2);

        public abstract boolean c(E e3, b bVar, b bVar2);

        public abstract boolean d(E e3, b bVar, b bVar2);

        public abstract boolean f(E e3);

        public boolean g(E e3, List list) {
            return f(e3);
        }

        public final void h(E e3) {
            r(e3);
            a aVar = this.f6343a;
            if (aVar != null) {
                aVar.a(e3);
            }
        }

        public final void i() {
            if (this.f6344b.size() <= 0) {
                this.f6344b.clear();
            } else {
                androidx.appcompat.app.p.a(this.f6344b.get(0));
                throw null;
            }
        }

        public abstract void j(E e3);

        public abstract void k();

        public long l() {
            return this.f6345c;
        }

        public long m() {
            return this.f6348f;
        }

        public long n() {
            return this.f6347e;
        }

        public long o() {
            return this.f6346d;
        }

        public abstract boolean p();

        public b q() {
            return new b();
        }

        public void r(E e3) {
        }

        public b s(B b3, E e3) {
            return q().a(e3);
        }

        public b t(B b3, E e3, int i3, List list) {
            return q().a(e3);
        }

        public abstract void u();

        void v(a aVar) {
            this.f6343a = aVar;
        }
    }

    private class n implements m.a {
        n() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m.a
        public void a(E e3) {
            e3.setIsRecyclable(true);
            if (e3.mShadowedHolder != null && e3.mShadowingHolder == null) {
                e3.mShadowedHolder = null;
            }
            e3.mShadowingHolder = null;
            if (e3.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(e3.itemView) || !e3.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(e3.itemView, false);
        }
    }

    public static abstract class o {
        public void d(Rect rect, int i3, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, B b3) {
            d(rect, ((q) view.getLayoutParams()).a(), recyclerView);
        }

        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, B b3) {
            f(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, B b3) {
            h(canvas, recyclerView);
        }
    }

    public static abstract class p {

        /* renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.d f6354a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f6355b;

        /* renamed from: c, reason: collision with root package name */
        private final q.b f6356c;

        /* renamed from: d, reason: collision with root package name */
        private final q.b f6357d;

        /* renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.q f6358e;

        /* renamed from: f, reason: collision with root package name */
        androidx.recyclerview.widget.q f6359f;

        /* renamed from: g, reason: collision with root package name */
        A f6360g;

        /* renamed from: h, reason: collision with root package name */
        boolean f6361h;

        /* renamed from: i, reason: collision with root package name */
        boolean f6362i;

        /* renamed from: j, reason: collision with root package name */
        boolean f6363j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f6364k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f6365l;

        /* renamed from: m, reason: collision with root package name */
        int f6366m;

        /* renamed from: n, reason: collision with root package name */
        boolean f6367n;

        /* renamed from: o, reason: collision with root package name */
        private int f6368o;

        /* renamed from: p, reason: collision with root package name */
        private int f6369p;

        /* renamed from: q, reason: collision with root package name */
        private int f6370q;

        /* renamed from: r, reason: collision with root package name */
        private int f6371r;

        class a implements q.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.q.b
            public View a(int i3) {
                return p.this.I(i3);
            }

            @Override // androidx.recyclerview.widget.q.b
            public int b() {
                return p.this.q0() - p.this.g0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int c() {
                return p.this.f0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int d(View view) {
                return p.this.T(view) + ((ViewGroup.MarginLayoutParams) ((q) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.q.b
            public int e(View view) {
                return p.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((q) view.getLayoutParams())).leftMargin;
            }
        }

        class b implements q.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.q.b
            public View a(int i3) {
                return p.this.I(i3);
            }

            @Override // androidx.recyclerview.widget.q.b
            public int b() {
                return p.this.W() - p.this.d0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int c() {
                return p.this.i0();
            }

            @Override // androidx.recyclerview.widget.q.b
            public int d(View view) {
                return p.this.O(view) + ((ViewGroup.MarginLayoutParams) ((q) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.q.b
            public int e(View view) {
                return p.this.U(view) - ((ViewGroup.MarginLayoutParams) ((q) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
            void a(int i3, int i4);
        }

        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f6374a;

            /* renamed from: b, reason: collision with root package name */
            public int f6375b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f6376c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f6377d;
        }

        public p() {
            a aVar = new a();
            this.f6356c = aVar;
            b bVar = new b();
            this.f6357d = bVar;
            this.f6358e = new androidx.recyclerview.widget.q(aVar);
            this.f6359f = new androidx.recyclerview.widget.q(bVar);
            this.f6361h = false;
            this.f6362i = false;
            this.f6363j = false;
            this.f6364k = true;
            this.f6365l = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int K(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.K(int, int, int, int, boolean):int");
        }

        private int[] L(View view, Rect rect) {
            int f02 = f0();
            int i02 = i0();
            int q02 = q0() - g0();
            int W3 = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i3 = left - f02;
            int min = Math.min(0, i3);
            int i4 = top - i02;
            int min2 = Math.min(0, i4);
            int i5 = width - q02;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, height - W3);
            if (Z() != 1) {
                if (min == 0) {
                    min = Math.min(i3, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i5);
            }
            if (min2 == 0) {
                min2 = Math.min(i4, max2);
            }
            return new int[]{max, min2};
        }

        private void f(View view, int i3, boolean z3) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z3 || childViewHolderInt.isRemoved()) {
                this.f6355b.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.f6355b.mViewInfoStore.p(childViewHolderInt);
            }
            q qVar = (q) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.f6354a.c(view, i3, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f6355b) {
                int m3 = this.f6354a.m(view);
                if (i3 == -1) {
                    i3 = this.f6354a.g();
                }
                if (m3 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f6355b.indexOfChild(view) + this.f6355b.exceptionLabel());
                }
                if (m3 != i3) {
                    this.f6355b.mLayout.D0(m3, i3);
                }
            } else {
                this.f6354a.a(view, i3, false);
                qVar.f6380c = true;
                A a3 = this.f6360g;
                if (a3 != null && a3.h()) {
                    this.f6360g.k(view);
                }
            }
            if (qVar.f6381d) {
                childViewHolderInt.itemView.invalidate();
                qVar.f6381d = false;
            }
        }

        public static d k0(Context context, AttributeSet attributeSet, int i3, int i4) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I.c.f901f, i3, i4);
            dVar.f6374a = obtainStyledAttributes.getInt(I.c.f902g, 1);
            dVar.f6375b = obtainStyledAttributes.getInt(I.c.f912q, 1);
            dVar.f6376c = obtainStyledAttributes.getBoolean(I.c.f911p, false);
            dVar.f6377d = obtainStyledAttributes.getBoolean(I.c.f913r, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i4, i5) : size : Math.min(size, Math.max(i4, i5));
        }

        private boolean v0(RecyclerView recyclerView, int i3, int i4) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int f02 = f0();
            int i02 = i0();
            int q02 = q0() - g0();
            int W3 = W() - d0();
            Rect rect = this.f6355b.mTempRect;
            P(focusedChild, rect);
            return rect.left - i3 < q02 && rect.right - i3 > f02 && rect.top - i4 < W3 && rect.bottom - i4 > i02;
        }

        private void y(int i3, View view) {
            this.f6354a.d(i3);
        }

        private static boolean y0(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (i5 > 0 && i3 != i5) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i3;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i3;
            }
            return true;
        }

        private void y1(w wVar, int i3, View view) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.f6355b.mAdapter.hasStableIds()) {
                t1(i3);
                wVar.C(childViewHolderInt);
            } else {
                x(i3);
                wVar.D(view);
                this.f6355b.mViewInfoStore.k(childViewHolderInt);
            }
        }

        void A(RecyclerView recyclerView, w wVar) {
            this.f6362i = false;
            K0(recyclerView, wVar);
        }

        public boolean A0(View view, boolean z3, boolean z4) {
            boolean z5 = this.f6358e.b(view, 24579) && this.f6359f.b(view, 24579);
            return z3 ? z5 : !z5;
        }

        public abstract void A1(int i3);

        public View B(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f6354a.n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public void B0(View view, int i3, int i4, int i5, int i6) {
            q qVar = (q) view.getLayoutParams();
            Rect rect = qVar.f6379b;
            view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) qVar).leftMargin, i4 + rect.top + ((ViewGroup.MarginLayoutParams) qVar).topMargin, (i5 - rect.right) - ((ViewGroup.MarginLayoutParams) qVar).rightMargin, (i6 - rect.bottom) - ((ViewGroup.MarginLayoutParams) qVar).bottomMargin);
        }

        public abstract int B1(int i3, w wVar, B b3);

        public View C(int i3) {
            int J3 = J();
            for (int i4 = 0; i4 < J3; i4++) {
                View I3 = I(i4);
                E childViewHolderInt = RecyclerView.getChildViewHolderInt(I3);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i3 && !childViewHolderInt.shouldIgnore() && (this.f6355b.mState.e() || !childViewHolderInt.isRemoved())) {
                    return I3;
                }
            }
            return null;
        }

        public void C0(View view, int i3, int i4) {
            q qVar = (q) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f6355b.getItemDecorInsetsForChild(view);
            int i5 = i3 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i6 = i4 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int K3 = K(q0(), r0(), f0() + g0() + ((ViewGroup.MarginLayoutParams) qVar).leftMargin + ((ViewGroup.MarginLayoutParams) qVar).rightMargin + i5, ((ViewGroup.MarginLayoutParams) qVar).width, k());
            int K4 = K(W(), X(), i0() + d0() + ((ViewGroup.MarginLayoutParams) qVar).topMargin + ((ViewGroup.MarginLayoutParams) qVar).bottomMargin + i6, ((ViewGroup.MarginLayoutParams) qVar).height, l());
            if (I1(view, K3, K4, qVar)) {
                view.measure(K3, K4);
            }
        }

        void C1(RecyclerView recyclerView) {
            D1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public abstract q D();

        public void D0(int i3, int i4) {
            View I3 = I(i3);
            if (I3 != null) {
                x(i3);
                h(I3, i4);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i3 + this.f6355b.toString());
            }
        }

        void D1(int i3, int i4) {
            this.f6370q = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            this.f6368o = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f6370q = 0;
            }
            this.f6371r = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f6369p = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.f6371r = 0;
        }

        public q E(Context context, AttributeSet attributeSet) {
            return new q(context, attributeSet);
        }

        public void E0(int i3) {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i3);
            }
        }

        public void E1(int i3, int i4) {
            this.f6355b.setMeasuredDimension(i3, i4);
        }

        public q F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof q ? new q((q) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new q((ViewGroup.MarginLayoutParams) layoutParams) : new q(layoutParams);
        }

        public void F0(int i3) {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i3);
            }
        }

        public void F1(Rect rect, int i3, int i4) {
            E1(n(i3, rect.width() + f0() + g0(), c0()), n(i4, rect.height() + i0() + d0(), b0()));
        }

        public int G() {
            return -1;
        }

        public void G0(h hVar, h hVar2) {
        }

        void G1(int i3, int i4) {
            int J3 = J();
            if (J3 == 0) {
                this.f6355b.defaultOnMeasure(i3, i4);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = Integer.MAX_VALUE;
            for (int i9 = 0; i9 < J3; i9++) {
                View I3 = I(i9);
                Rect rect = this.f6355b.mTempRect;
                P(I3, rect);
                int i10 = rect.left;
                if (i10 < i8) {
                    i8 = i10;
                }
                int i11 = rect.right;
                if (i11 > i5) {
                    i5 = i11;
                }
                int i12 = rect.top;
                if (i12 < i6) {
                    i6 = i12;
                }
                int i13 = rect.bottom;
                if (i13 > i7) {
                    i7 = i13;
                }
            }
            this.f6355b.mTempRect.set(i8, i6, i5, i7);
            F1(this.f6355b.mTempRect, i3, i4);
        }

        public int H(View view) {
            return ((q) view.getLayoutParams()).f6379b.bottom;
        }

        public boolean H0(RecyclerView recyclerView, ArrayList arrayList, int i3, int i4) {
            return false;
        }

        void H1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f6355b = null;
                this.f6354a = null;
                this.f6370q = 0;
                this.f6371r = 0;
            } else {
                this.f6355b = recyclerView;
                this.f6354a = recyclerView.mChildHelper;
                this.f6370q = recyclerView.getWidth();
                this.f6371r = recyclerView.getHeight();
            }
            this.f6368o = 1073741824;
            this.f6369p = 1073741824;
        }

        public View I(int i3) {
            androidx.recyclerview.widget.d dVar = this.f6354a;
            if (dVar != null) {
                return dVar.f(i3);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView) {
        }

        boolean I1(View view, int i3, int i4, q qVar) {
            return (!view.isLayoutRequested() && this.f6364k && y0(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) qVar).width) && y0(view.getHeight(), i4, ((ViewGroup.MarginLayoutParams) qVar).height)) ? false : true;
        }

        public int J() {
            androidx.recyclerview.widget.d dVar = this.f6354a;
            if (dVar != null) {
                return dVar.g();
            }
            return 0;
        }

        public void J0(RecyclerView recyclerView) {
        }

        boolean J1() {
            return false;
        }

        public void K0(RecyclerView recyclerView, w wVar) {
            J0(recyclerView);
        }

        boolean K1(View view, int i3, int i4, q qVar) {
            return (this.f6364k && y0(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) qVar).width) && y0(view.getMeasuredHeight(), i4, ((ViewGroup.MarginLayoutParams) qVar).height)) ? false : true;
        }

        public abstract View L0(View view, int i3, w wVar, B b3);

        public abstract void L1(RecyclerView recyclerView, B b3, int i3);

        public boolean M() {
            RecyclerView recyclerView = this.f6355b;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void M0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f6355b;
            N0(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void M1(A a3) {
            A a4 = this.f6360g;
            if (a4 != null && a3 != a4 && a4.h()) {
                this.f6360g.r();
            }
            this.f6360g = a3;
            a3.q(this.f6355b, this);
        }

        public int N(w wVar, B b3) {
            return -1;
        }

        public void N0(w wVar, B b3, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z3 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f6355b.canScrollVertically(-1) && !this.f6355b.canScrollHorizontally(-1) && !this.f6355b.canScrollHorizontally(1)) {
                z3 = false;
            }
            accessibilityEvent.setScrollable(z3);
            h hVar = this.f6355b.mAdapter;
            if (hVar != null) {
                accessibilityEvent.setItemCount(hVar.getItemCount());
            }
        }

        void N1() {
            A a3 = this.f6360g;
            if (a3 != null) {
                a3.r();
            }
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        void O0(androidx.core.view.accessibility.d dVar) {
            RecyclerView recyclerView = this.f6355b;
            P0(recyclerView.mRecycler, recyclerView.mState, dVar);
        }

        public abstract boolean O1();

        public void P(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public void P0(w wVar, B b3, androidx.core.view.accessibility.d dVar) {
            if (this.f6355b.canScrollVertically(-1) || this.f6355b.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.j0(true);
            }
            if (this.f6355b.canScrollVertically(1) || this.f6355b.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.j0(true);
            }
            dVar.S(d.b.b(m0(wVar, b3), N(wVar, b3), x0(wVar, b3), n0(wVar, b3)));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        void Q0(View view, androidx.core.view.accessibility.d dVar) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.f6354a.n(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.f6355b;
            R0(recyclerView.mRecycler, recyclerView.mState, view, dVar);
        }

        public int R(View view) {
            Rect rect = ((q) view.getLayoutParams()).f6379b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(w wVar, B b3, View view, androidx.core.view.accessibility.d dVar) {
        }

        public int S(View view) {
            Rect rect = ((q) view.getLayoutParams()).f6379b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public View S0(View view, int i3) {
            return null;
        }

        public int T(View view) {
            return view.getRight() + l0(view);
        }

        public void T0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int U(View view) {
            return view.getTop() - o0(view);
        }

        public void U0(RecyclerView recyclerView) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f6354a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i3, int i4, int i5) {
        }

        public int W() {
            return this.f6371r;
        }

        public void W0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int X() {
            return this.f6369p;
        }

        public void X0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int Y() {
            RecyclerView recyclerView = this.f6355b;
            h adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void Y0(RecyclerView recyclerView, int i3, int i4, Object obj) {
            X0(recyclerView, i3, i4);
        }

        public int Z() {
            return androidx.core.view.y.x(this.f6355b);
        }

        public abstract void Z0(w wVar, B b3);

        public int a0(View view) {
            return ((q) view.getLayoutParams()).f6379b.left;
        }

        public void a1(B b3) {
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return androidx.core.view.y.z(this.f6355b);
        }

        public void b1(w wVar, B b3, int i3, int i4) {
            this.f6355b.defaultOnMeasure(i3, i4);
        }

        public void c(View view, int i3) {
            f(view, i3, true);
        }

        public int c0() {
            return androidx.core.view.y.A(this.f6355b);
        }

        public boolean c1(RecyclerView recyclerView, View view, View view2) {
            return z0() || recyclerView.isComputingLayout();
        }

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public boolean d1(RecyclerView recyclerView, B b3, View view, View view2) {
            return c1(recyclerView, view, view2);
        }

        public void e(View view, int i3) {
            f(view, i3, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return androidx.core.view.y.B(recyclerView);
            }
            return 0;
        }

        public abstract void e1(Parcelable parcelable);

        public int f0() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public abstract Parcelable f1();

        public void g(String str) {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void g1(int i3) {
        }

        public void h(View view, int i3) {
            i(view, i3, (q) view.getLayoutParams());
        }

        public int h0() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return androidx.core.view.y.C(recyclerView);
            }
            return 0;
        }

        void h1(A a3) {
            if (this.f6360g == a3) {
                this.f6360g = null;
            }
        }

        public void i(View view, int i3, q qVar) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.f6355b.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.f6355b.mViewInfoStore.p(childViewHolderInt);
            }
            this.f6354a.c(view, i3, qVar, childViewHolderInt.isRemoved());
        }

        public int i0() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        boolean i1(int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f6355b;
            return j1(recyclerView.mRecycler, recyclerView.mState, i3, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int j0(View view) {
            return ((q) view.getLayoutParams()).a();
        }

        public boolean j1(w wVar, B b3, int i3, Bundle bundle) {
            int W3;
            int q02;
            int i4;
            int i5;
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView == null) {
                return false;
            }
            if (i3 == 4096) {
                W3 = recyclerView.canScrollVertically(1) ? (W() - i0()) - d0() : 0;
                if (this.f6355b.canScrollHorizontally(1)) {
                    q02 = (q0() - f0()) - g0();
                    i4 = W3;
                    i5 = q02;
                }
                i4 = W3;
                i5 = 0;
            } else if (i3 != 8192) {
                i5 = 0;
                i4 = 0;
            } else {
                W3 = recyclerView.canScrollVertically(-1) ? -((W() - i0()) - d0()) : 0;
                if (this.f6355b.canScrollHorizontally(-1)) {
                    q02 = -((q0() - f0()) - g0());
                    i4 = W3;
                    i5 = q02;
                }
                i4 = W3;
                i5 = 0;
            }
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            this.f6355b.smoothScrollBy(i5, i4, null, Integer.MIN_VALUE, true);
            return true;
        }

        public abstract boolean k();

        boolean k1(View view, int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f6355b;
            return l1(recyclerView.mRecycler, recyclerView.mState, view, i3, bundle);
        }

        public abstract boolean l();

        public int l0(View view) {
            return ((q) view.getLayoutParams()).f6379b.right;
        }

        public boolean l1(w wVar, B b3, View view, int i3, Bundle bundle) {
            return false;
        }

        public boolean m(q qVar) {
            return qVar != null;
        }

        public int m0(w wVar, B b3) {
            return -1;
        }

        public void m1() {
            for (int J3 = J() - 1; J3 >= 0; J3--) {
                this.f6354a.q(J3);
            }
        }

        public int n0(w wVar, B b3) {
            return 0;
        }

        public void n1(w wVar) {
            for (int J3 = J() - 1; J3 >= 0; J3--) {
                if (!RecyclerView.getChildViewHolderInt(I(J3)).shouldIgnore()) {
                    q1(J3, wVar);
                }
            }
        }

        public abstract void o(int i3, int i4, B b3, c cVar);

        public int o0(View view) {
            return ((q) view.getLayoutParams()).f6379b.top;
        }

        void o1(w wVar) {
            int j3 = wVar.j();
            for (int i3 = j3 - 1; i3 >= 0; i3--) {
                View n3 = wVar.n(i3);
                E childViewHolderInt = RecyclerView.getChildViewHolderInt(n3);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f6355b.removeDetachedView(n3, false);
                    }
                    m mVar = this.f6355b.mItemAnimator;
                    if (mVar != null) {
                        mVar.j(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    wVar.y(n3);
                }
            }
            wVar.e();
            if (j3 > 0) {
                this.f6355b.invalidate();
            }
        }

        public void p(int i3, c cVar) {
        }

        public void p0(View view, boolean z3, Rect rect) {
            Matrix matrix;
            if (z3) {
                Rect rect2 = ((q) view.getLayoutParams()).f6379b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f6355b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f6355b.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void p1(View view, w wVar) {
            s1(view);
            wVar.B(view);
        }

        public abstract int q(B b3);

        public int q0() {
            return this.f6370q;
        }

        public void q1(int i3, w wVar) {
            View I3 = I(i3);
            t1(i3);
            wVar.B(I3);
        }

        public abstract int r(B b3);

        public int r0() {
            return this.f6368o;
        }

        public boolean r1(Runnable runnable) {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public abstract int s(B b3);

        boolean s0() {
            int J3 = J();
            for (int i3 = 0; i3 < J3; i3++) {
                ViewGroup.LayoutParams layoutParams = I(i3).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void s1(View view) {
            this.f6354a.p(view);
        }

        public abstract int t(B b3);

        public boolean t0() {
            return this.f6362i;
        }

        public void t1(int i3) {
            if (I(i3) != null) {
                this.f6354a.q(i3);
            }
        }

        public abstract int u(B b3);

        public abstract boolean u0();

        public boolean u1(RecyclerView recyclerView, View view, Rect rect, boolean z3) {
            return v1(recyclerView, view, rect, z3, false);
        }

        public abstract int v(B b3);

        public boolean v1(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
            int[] L3 = L(view, rect);
            int i3 = L3[0];
            int i4 = L3[1];
            if ((z4 && !v0(recyclerView, i3, i4)) || (i3 == 0 && i4 == 0)) {
                return false;
            }
            if (z3) {
                recyclerView.scrollBy(i3, i4);
            } else {
                recyclerView.smoothScrollBy(i3, i4);
            }
            return true;
        }

        public void w(w wVar) {
            for (int J3 = J() - 1; J3 >= 0; J3--) {
                y1(wVar, J3, I(J3));
            }
        }

        public final boolean w0() {
            return this.f6365l;
        }

        public void w1() {
            RecyclerView recyclerView = this.f6355b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void x(int i3) {
            y(i3, I(i3));
        }

        public boolean x0(w wVar, B b3) {
            return false;
        }

        public void x1() {
            this.f6361h = true;
        }

        void z(RecyclerView recyclerView) {
            this.f6362i = true;
            I0(recyclerView);
        }

        public boolean z0() {
            A a3 = this.f6360g;
            return a3 != null && a3.h();
        }

        public abstract int z1(int i3, w wVar, B b3);
    }

    public interface r {
        void a(View view);

        void b(View view);
    }

    public static abstract class s {
        public abstract boolean a(int i3, int i4);
    }

    public interface t {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z3);
    }

    public static abstract class u {
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        }

        public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
        }
    }

    public static class v {

        /* renamed from: a, reason: collision with root package name */
        SparseArray f6382a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        private int f6383b = 0;

        static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList f6384a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            int f6385b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f6386c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f6387d = 0;

            a() {
            }
        }

        private a g(int i3) {
            a aVar = (a) this.f6382a.get(i3);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f6382a.put(i3, aVar2);
            return aVar2;
        }

        void a() {
            this.f6383b++;
        }

        public void b() {
            for (int i3 = 0; i3 < this.f6382a.size(); i3++) {
                ((a) this.f6382a.valueAt(i3)).f6384a.clear();
            }
        }

        void c() {
            this.f6383b--;
        }

        void d(int i3, long j3) {
            a g3 = g(i3);
            g3.f6387d = j(g3.f6387d, j3);
        }

        void e(int i3, long j3) {
            a g3 = g(i3);
            g3.f6386c = j(g3.f6386c, j3);
        }

        public E f(int i3) {
            a aVar = (a) this.f6382a.get(i3);
            if (aVar == null || aVar.f6384a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f6384a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((E) arrayList.get(size)).isAttachedToTransitionOverlay()) {
                    return (E) arrayList.remove(size);
                }
            }
            return null;
        }

        void h(h hVar, h hVar2, boolean z3) {
            if (hVar != null) {
                c();
            }
            if (!z3 && this.f6383b == 0) {
                b();
            }
            if (hVar2 != null) {
                a();
            }
        }

        public void i(E e3) {
            int itemViewType = e3.getItemViewType();
            ArrayList arrayList = g(itemViewType).f6384a;
            if (((a) this.f6382a.get(itemViewType)).f6385b <= arrayList.size()) {
                return;
            }
            e3.resetInternal();
            arrayList.add(e3);
        }

        long j(long j3, long j4) {
            return j3 == 0 ? j4 : ((j3 / 4) * 3) + (j4 / 4);
        }

        boolean k(int i3, long j3, long j4) {
            long j5 = g(i3).f6387d;
            return j5 == 0 || j3 + j5 < j4;
        }

        boolean l(int i3, long j3, long j4) {
            long j5 = g(i3).f6386c;
            return j5 == 0 || j3 + j5 < j4;
        }
    }

    public final class w {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList f6388a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f6389b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList f6390c;

        /* renamed from: d, reason: collision with root package name */
        private final List f6391d;

        /* renamed from: e, reason: collision with root package name */
        private int f6392e;

        /* renamed from: f, reason: collision with root package name */
        int f6393f;

        /* renamed from: g, reason: collision with root package name */
        v f6394g;

        public w() {
            ArrayList arrayList = new ArrayList();
            this.f6388a = arrayList;
            this.f6389b = null;
            this.f6390c = new ArrayList();
            this.f6391d = Collections.unmodifiableList(arrayList);
            this.f6392e = 2;
            this.f6393f = 2;
        }

        private boolean H(E e3, int i3, int i4, long j3) {
            e3.mBindingAdapter = null;
            e3.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = e3.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j3 != RecyclerView.FOREVER_NS && !this.f6394g.k(itemViewType, nanoTime, j3)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(e3, i3);
            this.f6394g.d(e3.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(e3);
            if (!RecyclerView.this.mState.e()) {
                return true;
            }
            e3.mPreLayoutPosition = i4;
            return true;
        }

        private void b(E e3) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = e3.itemView;
                if (androidx.core.view.y.v(view) == 0) {
                    androidx.core.view.y.u0(view, 1);
                }
                androidx.recyclerview.widget.m mVar = RecyclerView.this.mAccessibilityDelegate;
                if (mVar == null) {
                    return;
                }
                C0252a itemDelegate = mVar.getItemDelegate();
                if (itemDelegate instanceof m.a) {
                    ((m.a) itemDelegate).d(view);
                }
                androidx.core.view.y.j0(view, itemDelegate);
            }
        }

        private void q(ViewGroup viewGroup, boolean z3) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z3) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(E e3) {
            View view = e3.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i3) {
            a((E) this.f6390c.get(i3), true);
            this.f6390c.remove(i3);
        }

        public void B(View view) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            C(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.j(childViewHolderInt);
        }

        void C(E e3) {
            boolean z3;
            boolean z4 = true;
            if (e3.isScrap() || e3.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(e3.isScrap());
                sb.append(" isAttached:");
                sb.append(e3.itemView.getParent() != null);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (e3.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + e3 + RecyclerView.this.exceptionLabel());
            }
            if (e3.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean doesTransientStatePreventRecycling = e3.doesTransientStatePreventRecycling();
            h hVar = RecyclerView.this.mAdapter;
            if ((hVar != null && doesTransientStatePreventRecycling && hVar.onFailedToRecycleView(e3)) || e3.isRecyclable()) {
                if (this.f6393f <= 0 || e3.hasAnyOfTheFlags(526)) {
                    z3 = false;
                } else {
                    int size = this.f6390c.size();
                    if (size >= this.f6393f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(e3.mPosition)) {
                        int i3 = size - 1;
                        while (i3 >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.d(((E) this.f6390c.get(i3)).mPosition)) {
                                break;
                            } else {
                                i3--;
                            }
                        }
                        size = i3 + 1;
                    }
                    this.f6390c.add(size, e3);
                    z3 = true;
                }
                if (z3) {
                    z4 = false;
                } else {
                    a(e3, true);
                }
                r1 = z3;
            } else {
                z4 = false;
            }
            RecyclerView.this.mViewInfoStore.q(e3);
            if (r1 || z4 || !doesTransientStatePreventRecycling) {
                return;
            }
            e3.mBindingAdapter = null;
            e3.mOwnerRecyclerView = null;
        }

        void D(View view) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f6389b == null) {
                    this.f6389b = new ArrayList();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f6389b.add(childViewHolderInt);
                return;
            }
            if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f6388a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        void E(v vVar) {
            v vVar2 = this.f6394g;
            if (vVar2 != null) {
                vVar2.c();
            }
            this.f6394g = vVar;
            if (vVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f6394g.a();
        }

        void F(C c3) {
        }

        public void G(int i3) {
            this.f6392e = i3;
            K();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01d4 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0180  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        androidx.recyclerview.widget.RecyclerView.E I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.w.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$E");
        }

        void J(E e3) {
            if (e3.mInChangeScrap) {
                this.f6389b.remove(e3);
            } else {
                this.f6388a.remove(e3);
            }
            e3.mScrapContainer = null;
            e3.mInChangeScrap = false;
            e3.clearReturnedFromScrapFlag();
        }

        void K() {
            p pVar = RecyclerView.this.mLayout;
            this.f6393f = this.f6392e + (pVar != null ? pVar.f6366m : 0);
            for (int size = this.f6390c.size() - 1; size >= 0 && this.f6390c.size() > this.f6393f; size--) {
                A(size);
            }
        }

        boolean L(E e3) {
            if (e3.isRemoved()) {
                return RecyclerView.this.mState.e();
            }
            int i3 = e3.mPosition;
            if (i3 >= 0 && i3 < RecyclerView.this.mAdapter.getItemCount()) {
                if (RecyclerView.this.mState.e() || RecyclerView.this.mAdapter.getItemViewType(e3.mPosition) == e3.getItemViewType()) {
                    return !RecyclerView.this.mAdapter.hasStableIds() || e3.getItemId() == RecyclerView.this.mAdapter.getItemId(e3.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + e3 + RecyclerView.this.exceptionLabel());
        }

        void M(int i3, int i4) {
            int i5;
            int i6 = i4 + i3;
            for (int size = this.f6390c.size() - 1; size >= 0; size--) {
                E e3 = (E) this.f6390c.get(size);
                if (e3 != null && (i5 = e3.mPosition) >= i3 && i5 < i6) {
                    e3.addFlags(2);
                    A(size);
                }
            }
        }

        void a(E e3, boolean z3) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(e3);
            View view = e3.itemView;
            androidx.recyclerview.widget.m mVar = RecyclerView.this.mAccessibilityDelegate;
            if (mVar != null) {
                C0252a itemDelegate = mVar.getItemDelegate();
                androidx.core.view.y.j0(view, itemDelegate instanceof m.a ? ((m.a) itemDelegate).c(view) : null);
            }
            if (z3) {
                g(e3);
            }
            e3.mBindingAdapter = null;
            e3.mOwnerRecyclerView = null;
            i().i(e3);
        }

        public void c() {
            this.f6388a.clear();
            z();
        }

        void d() {
            int size = this.f6390c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((E) this.f6390c.get(i3)).clearOldPosition();
            }
            int size2 = this.f6388a.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((E) this.f6388a.get(i4)).clearOldPosition();
            }
            ArrayList arrayList = this.f6389b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    ((E) this.f6389b.get(i5)).clearOldPosition();
                }
            }
        }

        void e() {
            this.f6388a.clear();
            ArrayList arrayList = this.f6389b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i3) {
            if (i3 >= 0 && i3 < RecyclerView.this.mState.b()) {
                return !RecyclerView.this.mState.e() ? i3 : RecyclerView.this.mAdapterHelper.m(i3);
            }
            throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
        }

        void g(E e3) {
            RecyclerView.this.getClass();
            if (RecyclerView.this.mRecyclerListeners.size() > 0) {
                androidx.appcompat.app.p.a(RecyclerView.this.mRecyclerListeners.get(0));
                throw null;
            }
            h hVar = RecyclerView.this.mAdapter;
            if (hVar != null) {
                hVar.onViewRecycled(e3);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(e3);
            }
        }

        E h(int i3) {
            int size;
            int m3;
            ArrayList arrayList = this.f6389b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    E e3 = (E) this.f6389b.get(i4);
                    if (!e3.wasReturnedFromScrap() && e3.getLayoutPosition() == i3) {
                        e3.addFlags(32);
                        return e3;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (m3 = RecyclerView.this.mAdapterHelper.m(i3)) > 0 && m3 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(m3);
                    for (int i5 = 0; i5 < size; i5++) {
                        E e4 = (E) this.f6389b.get(i5);
                        if (!e4.wasReturnedFromScrap() && e4.getItemId() == itemId) {
                            e4.addFlags(32);
                            return e4;
                        }
                    }
                }
            }
            return null;
        }

        v i() {
            if (this.f6394g == null) {
                this.f6394g = new v();
            }
            return this.f6394g;
        }

        int j() {
            return this.f6388a.size();
        }

        public List k() {
            return this.f6391d;
        }

        E l(long j3, int i3, boolean z3) {
            for (int size = this.f6388a.size() - 1; size >= 0; size--) {
                E e3 = (E) this.f6388a.get(size);
                if (e3.getItemId() == j3 && !e3.wasReturnedFromScrap()) {
                    if (i3 == e3.getItemViewType()) {
                        e3.addFlags(32);
                        if (e3.isRemoved() && !RecyclerView.this.mState.e()) {
                            e3.setFlags(2, 14);
                        }
                        return e3;
                    }
                    if (!z3) {
                        this.f6388a.remove(size);
                        RecyclerView.this.removeDetachedView(e3.itemView, false);
                        y(e3.itemView);
                    }
                }
            }
            int size2 = this.f6390c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                E e4 = (E) this.f6390c.get(size2);
                if (e4.getItemId() == j3 && !e4.isAttachedToTransitionOverlay()) {
                    if (i3 == e4.getItemViewType()) {
                        if (!z3) {
                            this.f6390c.remove(size2);
                        }
                        return e4;
                    }
                    if (!z3) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        E m(int i3, boolean z3) {
            View e3;
            int size = this.f6388a.size();
            for (int i4 = 0; i4 < size; i4++) {
                E e4 = (E) this.f6388a.get(i4);
                if (!e4.wasReturnedFromScrap() && e4.getLayoutPosition() == i3 && !e4.isInvalid() && (RecyclerView.this.mState.f6316h || !e4.isRemoved())) {
                    e4.addFlags(32);
                    return e4;
                }
            }
            if (z3 || (e3 = RecyclerView.this.mChildHelper.e(i3)) == null) {
                int size2 = this.f6390c.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    E e5 = (E) this.f6390c.get(i5);
                    if (!e5.isInvalid() && e5.getLayoutPosition() == i3 && !e5.isAttachedToTransitionOverlay()) {
                        if (!z3) {
                            this.f6390c.remove(i5);
                        }
                        return e5;
                    }
                }
                return null;
            }
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(e3);
            RecyclerView.this.mChildHelper.s(e3);
            int m3 = RecyclerView.this.mChildHelper.m(e3);
            if (m3 != -1) {
                RecyclerView.this.mChildHelper.d(m3);
                D(e3);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        View n(int i3) {
            return ((E) this.f6388a.get(i3)).itemView;
        }

        public View o(int i3) {
            return p(i3, false);
        }

        View p(int i3, boolean z3) {
            return I(i3, z3, RecyclerView.FOREVER_NS).itemView;
        }

        void s() {
            int size = this.f6390c.size();
            for (int i3 = 0; i3 < size; i3++) {
                q qVar = (q) ((E) this.f6390c.get(i3)).itemView.getLayoutParams();
                if (qVar != null) {
                    qVar.f6380c = true;
                }
            }
        }

        void t() {
            int size = this.f6390c.size();
            for (int i3 = 0; i3 < size; i3++) {
                E e3 = (E) this.f6390c.get(i3);
                if (e3 != null) {
                    e3.addFlags(6);
                    e3.addChangePayload(null);
                }
            }
            h hVar = RecyclerView.this.mAdapter;
            if (hVar == null || !hVar.hasStableIds()) {
                z();
            }
        }

        void u(int i3, int i4) {
            int size = this.f6390c.size();
            for (int i5 = 0; i5 < size; i5++) {
                E e3 = (E) this.f6390c.get(i5);
                if (e3 != null && e3.mPosition >= i3) {
                    e3.offsetPosition(i4, false);
                }
            }
        }

        void v(int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            if (i3 < i4) {
                i5 = -1;
                i7 = i3;
                i6 = i4;
            } else {
                i5 = 1;
                i6 = i3;
                i7 = i4;
            }
            int size = this.f6390c.size();
            for (int i9 = 0; i9 < size; i9++) {
                E e3 = (E) this.f6390c.get(i9);
                if (e3 != null && (i8 = e3.mPosition) >= i7 && i8 <= i6) {
                    if (i8 == i3) {
                        e3.offsetPosition(i4 - i3, false);
                    } else {
                        e3.offsetPosition(i5, false);
                    }
                }
            }
        }

        void w(int i3, int i4, boolean z3) {
            int i5 = i3 + i4;
            for (int size = this.f6390c.size() - 1; size >= 0; size--) {
                E e3 = (E) this.f6390c.get(size);
                if (e3 != null) {
                    int i6 = e3.mPosition;
                    if (i6 >= i5) {
                        e3.offsetPosition(-i4, z3);
                    } else if (i6 >= i3) {
                        e3.addFlags(8);
                        A(size);
                    }
                }
            }
        }

        void x(h hVar, h hVar2, boolean z3) {
            c();
            i().h(hVar, hVar2, z3);
        }

        void y(View view) {
            E childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            C(childViewHolderInt);
        }

        void z() {
            for (int size = this.f6390c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f6390c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }
    }

    public interface x {
    }

    private class y extends j {
        y() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f6315g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void b(int i3, int i4, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.r(i3, i4, obj)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i3, int i4) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.s(i3, i4)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i3, int i4, int i5) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.t(i3, i4, i5)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i3, int i4) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.u(i3, i4)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f() {
            h hVar;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState == null || (hVar = recyclerView.mAdapter) == null || !hVar.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        void g() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    androidx.core.view.y.a0(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    static {
        Class cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new InterpolatorC0278c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void A() {
        boolean z3;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z3 = this.mLeftGlow.isFinished();
        } else {
            z3 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z3 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z3 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z3 |= this.mBottomGlow.isFinished();
        }
        if (z3) {
            androidx.core.view.y.Z(this);
        }
    }

    private void B(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof q) {
            q qVar = (q) layoutParams;
            if (!qVar.f6380c) {
                Rect rect = qVar.f6379b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.v1(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void C() {
        B b3 = this.mState;
        b3.f6322n = -1L;
        b3.f6321m = -1;
        b3.f6323o = -1;
    }

    private void D() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        A();
    }

    private void E() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        E findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            C();
            return;
        }
        this.mState.f6322n = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        this.mState.f6321m = this.mDataSetHasChangedAfterLayout ? -1 : findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAbsoluteAdapterPosition();
        this.mState.f6323o = n(findContainingViewHolder.itemView);
    }

    private void F(h hVar, boolean z3, boolean z4) {
        h hVar2 = this.mAdapter;
        if (hVar2 != null) {
            hVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z3 || z4) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        h hVar3 = this.mAdapter;
        this.mAdapter = hVar;
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.mObserver);
            hVar.onAttachedToRecyclerView(this);
        }
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.G0(hVar3, this.mAdapter);
        }
        this.mRecycler.x(hVar3, this.mAdapter, z3);
        this.mState.f6315g = true;
    }

    private void G() {
        this.mViewFlinger.f();
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.N1();
        }
    }

    private void a(E e3) {
        View view = e3.itemView;
        boolean z3 = view.getParent() == this;
        this.mRecycler.J(getChildViewHolder(view));
        if (e3.isTmpDetached()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
        } else if (z3) {
            this.mChildHelper.k(view);
        } else {
            this.mChildHelper.b(view, true);
        }
    }

    private void b(E e3, E e4, m.b bVar, m.b bVar2, boolean z3, boolean z4) {
        e3.setIsRecyclable(false);
        if (z3) {
            a(e3);
        }
        if (e3 != e4) {
            if (z4) {
                a(e4);
            }
            e3.mShadowedHolder = e4;
            a(e3);
            this.mRecycler.J(e3);
            e4.setIsRecyclable(false);
            e4.mShadowingHolder = e3;
        }
        if (this.mItemAnimator.b(e3, e4, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    private void c() {
        D();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(E e3) {
        WeakReference<RecyclerView> weakReference = e3.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == e3.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            e3.mNestedRecyclerView = null;
        }
    }

    private void d(Context context, String str, AttributeSet attributeSet, int i3, int i4) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String o3 = o(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(o3, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(p.class);
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i4)};
                } catch (NoSuchMethodException e3) {
                    objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e4) {
                        e4.initCause(e3);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + o3, e4);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((p) constructor.newInstance(objArr));
            } catch (ClassCastException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + o3, e5);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + o3, e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + o3, e7);
            } catch (InstantiationException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + o3, e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + o3, e9);
            }
        }
    }

    private boolean e(int i3, int i4) {
        l(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i3 && iArr[1] == i4) ? false : true;
    }

    private void f() {
        int i3 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i3 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        androidx.core.view.accessibility.b.b(obtain, i3);
        sendAccessibilityEventUnchecked(obtain);
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i3));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private void g() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f6318j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        x();
        E();
        B b3 = this.mState;
        b3.f6317i = b3.f6319k && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        b3.f6316h = b3.f6320l;
        b3.f6314f = this.mAdapter.getItemCount();
        l(this.mMinMaxLayoutPositions);
        if (this.mState.f6319k) {
            int g3 = this.mChildHelper.g();
            for (int i3 = 0; i3 < g3; i3++) {
                E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i3));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.t(this.mState, childViewHolderInt, m.e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f6317i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f6320l) {
            saveOldPositions();
            B b4 = this.mState;
            boolean z3 = b4.f6315g;
            b4.f6315g = false;
            this.mLayout.Z0(this.mRecycler, b4);
            this.mState.f6315g = z3;
            for (int i4 = 0; i4 < this.mChildHelper.g(); i4++) {
                E childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i4));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int e3 = m.e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e3 |= 4096;
                    }
                    m.b t3 = this.mItemAnimator.t(this.mState, childViewHolderInt2, e3, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, t3);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, t3);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f6313e = 2;
    }

    static E getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((q) view.getLayoutParams()).f6378a;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        q qVar = (q) view.getLayoutParams();
        Rect rect2 = qVar.f6379b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) qVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) qVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) qVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) qVar).bottomMargin);
    }

    private androidx.core.view.p getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.view.p(this);
        }
        return this.mScrollingChildHelper;
    }

    private void h() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f6314f = this.mAdapter.getItemCount();
        this.mState.f6312d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.f6397e;
            if (parcelable != null) {
                this.mLayout.e1(parcelable);
            }
            this.mPendingSavedState = null;
        }
        B b3 = this.mState;
        b3.f6316h = false;
        this.mLayout.Z0(this.mRecycler, b3);
        B b4 = this.mState;
        b4.f6315g = false;
        b4.f6319k = b4.f6319k && this.mItemAnimator != null;
        b4.f6313e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void i() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        B b3 = this.mState;
        b3.f6313e = 1;
        if (b3.f6319k) {
            for (int g3 = this.mChildHelper.g() - 1; g3 >= 0; g3--) {
                E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(g3));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    m.b s3 = this.mItemAnimator.s(this.mState, childViewHolderInt);
                    E g4 = this.mViewInfoStore.g(changedHolderKey);
                    if (g4 == null || g4.shouldIgnore()) {
                        this.mViewInfoStore.d(childViewHolderInt, s3);
                    } else {
                        boolean h3 = this.mViewInfoStore.h(g4);
                        boolean h4 = this.mViewInfoStore.h(childViewHolderInt);
                        if (h3 && g4 == childViewHolderInt) {
                            this.mViewInfoStore.d(childViewHolderInt, s3);
                        } else {
                            m.b n3 = this.mViewInfoStore.n(g4);
                            this.mViewInfoStore.d(childViewHolderInt, s3);
                            m.b m3 = this.mViewInfoStore.m(childViewHolderInt);
                            if (n3 == null) {
                                p(changedHolderKey, childViewHolderInt, g4);
                            } else {
                                b(g4, childViewHolderInt, n3, m3, h3, h4);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.o1(this.mRecycler);
        B b4 = this.mState;
        b4.f6311c = b4.f6314f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        b4.f6319k = false;
        b4.f6320l = false;
        this.mLayout.f6361h = false;
        ArrayList arrayList = this.mRecycler.f6389b;
        if (arrayList != null) {
            arrayList.clear();
        }
        p pVar = this.mLayout;
        if (pVar.f6367n) {
            pVar.f6366m = 0;
            pVar.f6367n = false;
            this.mRecycler.K();
        }
        this.mLayout.a1(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (e(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        z();
        C();
    }

    private boolean j(MotionEvent motionEvent) {
        t tVar = this.mInterceptingOnItemTouchListener;
        if (tVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return k(motionEvent);
        }
        tVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean k(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            t tVar = this.mOnItemTouchListeners.get(i3);
            if (tVar.a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = tVar;
                return true;
            }
        }
        return false;
    }

    private void l(int[] iArr) {
        int g3 = this.mChildHelper.g();
        if (g3 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Preference.DEFAULT_ORDER;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < g3; i5++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i5));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i3) {
                    i3 = layoutPosition;
                }
                if (layoutPosition > i4) {
                    i4 = layoutPosition;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    private View m() {
        E findViewHolderForAdapterPosition;
        B b3 = this.mState;
        int i3 = b3.f6321m;
        if (i3 == -1) {
            i3 = 0;
        }
        int b4 = b3.b();
        for (int i4 = i3; i4 < b4; i4++) {
            E findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i4);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(b4, i3);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    private int n(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String o(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void p(long j3, E e3, E e4) {
        int g3 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g3; i3++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i3));
            if (childViewHolderInt != e3 && getChangedHolderKey(childViewHolderInt) == j3) {
                h hVar = this.mAdapter;
                if (hVar == null || !hVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + e3 + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + e3 + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + e4 + " cannot be found but it is necessary for " + e3 + exceptionLabel());
    }

    private boolean q() {
        int g3 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g3; i3++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    private void r() {
        if (androidx.core.view.y.w(this) == 0) {
            androidx.core.view.y.v0(this, 8);
        }
    }

    private void s() {
        this.mChildHelper = new d(new C0280e());
    }

    private boolean t(View view, View view2, int i3) {
        int i4;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c3 = 65535;
        int i5 = this.mLayout.Z() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i6 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i7 = rect2.left;
        if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
            i4 = 1;
        } else {
            int i8 = rect.right;
            int i9 = rect2.right;
            i4 = ((i8 > i9 || i6 >= i9) && i6 > i7) ? -1 : 0;
        }
        int i10 = rect.top;
        int i11 = rect2.top;
        if ((i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom) {
            c3 = 1;
        } else {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            if ((i12 <= i13 && i10 < i13) || i10 <= i11) {
                c3 = 0;
            }
        }
        if (i3 == 1) {
            return c3 < 0 || (c3 == 0 && i4 * i5 < 0);
        }
        if (i3 == 2) {
            return c3 > 0 || (c3 == 0 && i4 * i5 > 0);
        }
        if (i3 == 17) {
            return i4 < 0;
        }
        if (i3 == 33) {
            return c3 < 0;
        }
        if (i3 == 66) {
            return i4 > 0;
        }
        if (i3 == 130) {
            return c3 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i3 + exceptionLabel());
    }

    private void u(int i3, int i4, MotionEvent motionEvent, int i5) {
        p pVar = this.mLayout;
        if (pVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean k3 = pVar.k();
        boolean l3 = this.mLayout.l();
        startNestedScroll(l3 ? (k3 ? 1 : 0) | 2 : k3 ? 1 : 0, i5);
        if (dispatchNestedPreScroll(k3 ? i3 : 0, l3 ? i4 : 0, this.mReusableIntPair, this.mScrollOffset, i5)) {
            int[] iArr2 = this.mReusableIntPair;
            i3 -= iArr2[0];
            i4 -= iArr2[1];
        }
        scrollByInternal(k3 ? i3 : 0, l3 ? i4 : 0, motionEvent, i5);
        androidx.recyclerview.widget.g gVar = this.mGapWorker;
        if (gVar != null && (i3 != 0 || i4 != 0)) {
            gVar.f(this, i3, i4);
        }
        stopNestedScroll(i5);
    }

    private void v(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i3);
            int x3 = (int) (motionEvent.getX(i3) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(i3) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        }
    }

    private boolean w() {
        return this.mItemAnimator != null && this.mLayout.O1();
    }

    private void x() {
        boolean z3;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.U0(this);
            }
        }
        if (w()) {
            this.mAdapterHelper.w();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z4 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f6319k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z3 = this.mDataSetHasChangedAfterLayout) || z4 || this.mLayout.f6361h) && (!z3 || this.mAdapter.hasStableIds());
        B b3 = this.mState;
        b3.f6320l = b3.f6319k && z4 && !this.mDataSetHasChangedAfterLayout && w();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void y(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.d.c(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.c(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.d.c(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.d.c(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.y.Z(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.y(float, float, float, float):void");
    }

    private void z() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.n(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        E findViewHolderForItemId = (this.mState.f6322n == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f6322n);
        if (findViewHolderForItemId != null && !this.mChildHelper.n(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
            view = findViewHolderForItemId.itemView;
        } else if (this.mChildHelper.g() > 0) {
            view = m();
        }
        if (view != null) {
            int i3 = this.mState.f6323o;
            if (i3 != -1 && (findViewById = view.findViewById(i3)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    void absorbGlows(int i3, int i4) {
        if (i3 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i3);
            }
        }
        if (i4 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i4);
            }
        } else if (i4 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i4);
            }
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        androidx.core.view.y.Z(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i4) {
        p pVar = this.mLayout;
        if (pVar == null || !pVar.H0(this, arrayList, i3, i4)) {
            super.addFocusables(arrayList, i3, i4);
        }
    }

    public void addItemDecoration(o oVar, int i3) {
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i3 < 0) {
            this.mItemDecorations.add(oVar);
        } else {
            this.mItemDecorations.add(i3, oVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(r rVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(rVar);
    }

    public void addOnItemTouchListener(t tVar) {
        this.mOnItemTouchListeners.add(tVar);
    }

    public void addOnScrollListener(u uVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(uVar);
    }

    public void addRecyclerListener(x xVar) {
        androidx.core.util.h.a(xVar != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(xVar);
    }

    void animateAppearance(E e3, m.b bVar, m.b bVar2) {
        e3.setIsRecyclable(false);
        if (this.mItemAnimator.a(e3, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(E e3, m.b bVar, m.b bVar2) {
        a(e3);
        e3.setIsRecyclable(false);
        if (this.mItemAnimator.c(e3, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(E e3) {
        m mVar = this.mItemAnimator;
        return mVar == null || mVar.g(e3, e3.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof q) && this.mLayout.m((q) layoutParams);
    }

    void clearOldPositions() {
        int j3 = this.mChildHelper.j();
        for (int i3 = 0; i3 < j3; i3++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<r> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<u> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        p pVar = this.mLayout;
        if (pVar != null && pVar.k()) {
            return this.mLayout.q(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        p pVar = this.mLayout;
        if (pVar != null && pVar.k()) {
            return this.mLayout.r(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        p pVar = this.mLayout;
        if (pVar != null && pVar.k()) {
            return this.mLayout.s(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        p pVar = this.mLayout;
        if (pVar != null && pVar.l()) {
            return this.mLayout.t(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        p pVar = this.mLayout;
        if (pVar != null && pVar.l()) {
            return this.mLayout.u(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        p pVar = this.mLayout;
        if (pVar != null && pVar.l()) {
            return this.mLayout.v(this.mState);
        }
        return 0;
    }

    void considerReleasingGlowsOnScroll(int i3, int i4) {
        boolean z3;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i3 <= 0) {
            z3 = false;
        } else {
            this.mLeftGlow.onRelease();
            z3 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.mRightGlow.onRelease();
            z3 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i4 > 0) {
            this.mTopGlow.onRelease();
            z3 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i4 < 0) {
            this.mBottomGlow.onRelease();
            z3 |= this.mBottomGlow.isFinished();
        }
        if (z3) {
            androidx.core.view.y.Z(this);
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.i.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.os.i.b();
            return;
        }
        if (this.mAdapterHelper.p()) {
            if (!this.mAdapterHelper.o(4) || this.mAdapterHelper.o(11)) {
                if (this.mAdapterHelper.p()) {
                    androidx.core.os.i.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    androidx.core.os.i.b();
                    return;
                }
                return;
            }
            androidx.core.os.i.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.w();
            if (!this.mLayoutWasDefered) {
                if (q()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.i();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            androidx.core.os.i.b();
        }
    }

    void defaultOnMeasure(int i3, int i4) {
        setMeasuredDimension(p.n(i3, getPaddingLeft() + getPaddingRight(), androidx.core.view.y.A(this)), p.n(i4, getPaddingTop() + getPaddingBottom(), androidx.core.view.y.z(this)));
    }

    void dispatchChildAttached(View view) {
        E childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        h hVar = this.mAdapter;
        if (hVar != null && childViewHolderInt != null) {
            hVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<r> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    void dispatchChildDetached(View view) {
        E childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        h hVar = this.mAdapter;
        if (hVar != null && childViewHolderInt != null) {
            hVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<r> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.f6318j = false;
        boolean z3 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f6313e == 1) {
            g();
            this.mLayout.C1(this);
            h();
        } else if (this.mAdapterHelper.q() || z3 || this.mLayout.q0() != getWidth() || this.mLayout.W() != getHeight()) {
            this.mLayout.C1(this);
            h();
        } else {
            this.mLayout.C1(this);
        }
        i();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z3) {
        return getScrollingChildHelper().a(f3, f4, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return getScrollingChildHelper().b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i3, i4, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return getScrollingChildHelper().f(i3, i4, i5, i6, iArr);
    }

    void dispatchOnScrollStateChanged(int i3) {
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.g1(i3);
        }
        onScrollStateChanged(i3);
        u uVar = this.mScrollListener;
        if (uVar != null) {
            uVar.onScrollStateChanged(this, i3);
        }
        List<u> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i3);
            }
        }
    }

    void dispatchOnScrolled(int i3, int i4) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i4);
        onScrolled(i3, i4);
        u uVar = this.mScrollListener;
        if (uVar != null) {
            uVar.onScrolled(this, i3, i4);
        }
        List<u> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i3, i4);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i3;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            E e3 = this.mPendingAccessibilityImportanceChange.get(size);
            if (e3.itemView.getParent() == this && !e3.shouldIgnore() && (i3 = e3.mPendingAccessibilityState) != -1) {
                androidx.core.view.y.u0(e3.itemView, i3);
                e3.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z3;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).i(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z3 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z3 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z3 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z3 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 |= z4;
            canvas.restoreToCount(save4);
        }
        if ((z3 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.p()) ? z3 : true) {
            androidx.core.view.y.Z(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect a3 = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = a3;
        if (this.mClipToPadding) {
            a3.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a3.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect a3 = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = a3;
        if (this.mClipToPadding) {
            a3.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a3.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect a3 = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = a3;
        if (this.mClipToPadding) {
            a3.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a3.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect a3 = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = a3;
        if (this.mClipToPadding) {
            a3.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a3.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(B b3) {
        if (getScrollState() != 2) {
            b3.f6324p = 0;
            b3.f6325q = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f6328g;
            b3.f6324p = overScroller.getFinalX() - overScroller.getCurrX();
            b3.f6325q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View findChildViewUnder(float f3, float f4) {
        for (int g3 = this.mChildHelper.g() - 1; g3 >= 0; g3--) {
            View f5 = this.mChildHelper.f(g3);
            float translationX = f5.getTranslationX();
            float translationY = f5.getTranslationY();
            if (f3 >= f5.getLeft() + translationX && f3 <= f5.getRight() + translationX && f4 >= f5.getTop() + translationY && f4 <= f5.getBottom() + translationY) {
                return f5;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public E findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public E findViewHolderForAdapterPosition(int i3) {
        E e3 = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int j3 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j3; i4++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i3) {
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                e3 = childViewHolderInt;
            }
        }
        return e3;
    }

    public E findViewHolderForItemId(long j3) {
        h hVar = this.mAdapter;
        E e3 = null;
        if (hVar != null && hVar.hasStableIds()) {
            int j4 = this.mChildHelper.j();
            for (int i3 = 0; i3 < j4; i3++) {
                E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j3) {
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    e3 = childViewHolderInt;
                }
            }
        }
        return e3;
    }

    public E findViewHolderForLayoutPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    @Deprecated
    public E findViewHolderForPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int i3, int i4) {
        p pVar = this.mLayout;
        if (pVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int k3 = pVar.k();
        boolean l3 = this.mLayout.l();
        if (k3 == 0 || Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (!l3 || Math.abs(i4) < this.mMinFlingVelocity) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        float f3 = i3;
        float f4 = i4;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z3 = k3 != 0 || l3;
            dispatchNestedFling(f3, f4, z3);
            s sVar = this.mOnFlingListener;
            if (sVar != null && sVar.a(i3, i4)) {
                return true;
            }
            if (z3) {
                if (l3) {
                    k3 = (k3 == true ? 1 : 0) | 2;
                }
                startNestedScroll(k3, 1);
                int i5 = this.mMaxFlingVelocity;
                int max = Math.max(-i5, Math.min(i3, i5));
                int i6 = this.mMaxFlingVelocity;
                this.mViewFlinger.b(max, Math.max(-i6, Math.min(i4, i6)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View view2;
        boolean z3;
        View S02 = this.mLayout.S0(view, i3);
        if (S02 != null) {
            return S02;
        }
        boolean z4 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z4 && (i3 == 2 || i3 == 1)) {
            if (this.mLayout.l()) {
                int i4 = i3 == 2 ? 130 : 33;
                z3 = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i3 = i4;
                }
            } else {
                z3 = false;
            }
            if (!z3 && this.mLayout.k()) {
                int i5 = (this.mLayout.Z() == 1) ^ (i3 == 2) ? 66 : 17;
                boolean z5 = focusFinder.findNextFocus(this, view, i5) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i3 = i5;
                }
                z3 = z5;
            }
            if (z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.L0(view, i3, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i3);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i3);
            if (findNextFocus == null && z4) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.L0(view, i3, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return t(view, view2, i3) ? view2 : super.focusSearch(view, i3);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i3);
        }
        B(view2, null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        p pVar = this.mLayout;
        if (pVar != null) {
            return pVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        p pVar = this.mLayout;
        if (pVar != null) {
            return pVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public h getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionInRecyclerView(E e3) {
        if (e3.hasAnyOfTheFlags(524) || !e3.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.e(e3.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        p pVar = this.mLayout;
        return pVar != null ? pVar.G() : super.getBaseline();
    }

    long getChangedHolderKey(E e3) {
        return this.mAdapter.hasStableIds() ? e3.getItemId() : e3.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        E childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        return super.getChildDrawingOrder(i3, i4);
    }

    public long getChildItemId(View view) {
        E childViewHolderInt;
        h hVar = this.mAdapter;
        if (hVar == null || !hVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        E childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public E getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public androidx.recyclerview.widget.m getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public l getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public m getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        q qVar = (q) view.getLayoutParams();
        if (!qVar.f6380c) {
            return qVar.f6379b;
        }
        if (this.mState.e() && (qVar.b() || qVar.d())) {
            return qVar.f6379b;
        }
        Rect rect = qVar.f6379b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i3).e(this.mTempRect, view, this, this.mState);
            int i4 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i4 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        qVar.f6380c = false;
        return rect;
    }

    public o getItemDecorationAt(int i3) {
        int itemDecorationCount = getItemDecorationCount();
        if (i3 >= 0 && i3 < itemDecorationCount) {
            return this.mItemDecorations.get(i3);
        }
        throw new IndexOutOfBoundsException(i3 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public p getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public s getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public v getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }

    void initAdapterManager() {
        this.mAdapterHelper = new a(new f());
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.f(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(I.b.f893a), resources.getDimensionPixelSize(I.b.f895c), resources.getDimensionPixelOffset(I.b.f894b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.g("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        m mVar = this.mItemAnimator;
        return mVar != null && mVar.p();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    void jumpToPositionForSmoothScroller(int i3) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.A1(i3);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int j3 = this.mChildHelper.j();
        for (int i3 = 0; i3 < j3; i3++) {
            ((q) this.mChildHelper.i(i3).getLayoutParams()).f6380c = true;
        }
        this.mRecycler.s();
    }

    void markKnownViewsInvalid() {
        int j3 = this.mChildHelper.j();
        for (int i3 = 0; i3 < j3; i3++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void nestedScrollBy(int i3, int i4) {
        u(i3, i4, null, 1);
    }

    public void offsetChildrenHorizontal(int i3) {
        int g3 = this.mChildHelper.g();
        for (int i4 = 0; i4 < g3; i4++) {
            this.mChildHelper.f(i4).offsetLeftAndRight(i3);
        }
    }

    public void offsetChildrenVertical(int i3) {
        int g3 = this.mChildHelper.g();
        for (int i4 = 0; i4 < g3; i4++) {
            this.mChildHelper.f(i4).offsetTopAndBottom(i3);
        }
    }

    void offsetPositionRecordsForInsert(int i3, int i4) {
        int j3 = this.mChildHelper.j();
        for (int i5 = 0; i5 < j3; i5++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i3) {
                childViewHolderInt.offsetPosition(i4, false);
                this.mState.f6315g = true;
            }
        }
        this.mRecycler.u(i3, i4);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int j3 = this.mChildHelper.j();
        if (i3 < i4) {
            i7 = -1;
            i6 = i3;
            i5 = i4;
        } else {
            i5 = i3;
            i6 = i4;
            i7 = 1;
        }
        for (int i9 = 0; i9 < j3; i9++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i9));
            if (childViewHolderInt != null && (i8 = childViewHolderInt.mPosition) >= i6 && i8 <= i5) {
                if (i8 == i3) {
                    childViewHolderInt.offsetPosition(i4 - i3, false);
                } else {
                    childViewHolderInt.offsetPosition(i7, false);
                }
                this.mState.f6315g = true;
            }
        }
        this.mRecycler.v(i3, i4);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i3, int i4, boolean z3) {
        int i5 = i3 + i4;
        int j3 = this.mChildHelper.j();
        for (int i6 = 0; i6 < j3; i6++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i6));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i7 = childViewHolderInt.mPosition;
                if (i7 >= i5) {
                    childViewHolderInt.offsetPosition(-i4, z3);
                    this.mState.f6315g = true;
                } else if (i7 >= i3) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i3 - 1, -i4, z3);
                    this.mState.f6315g = true;
                }
            }
        }
        this.mRecycler.w(i3, i4, z3);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$p r1 = r5.mLayout
            if (r1 == 0) goto L1e
            r1.z(r5)
        L1e:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.g.f6572i
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.g r1 = (androidx.recyclerview.widget.g) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.g r1 = new androidx.recyclerview.widget.g
            r1.<init>()
            r5.mGapWorker = r1
            android.view.Display r1 = androidx.core.view.y.s(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.g r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f6576g = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.g r0 = r5.mGapWorker
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.g gVar;
        super.onDetachedFromWindow();
        m mVar = this.mItemAnimator;
        if (mVar != null) {
            mVar.k();
        }
        stopScroll();
        this.mIsAttached = false;
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.A(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        if (!ALLOW_THREAD_GAP_WORK || (gVar = this.mGapWorker) == null) {
            return;
        }
        gVar.j(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).g(canvas, this, this.mState);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$p r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$p r0 = r5.mLayout
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.mLayout
            boolean r3 = r3.k()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.mLayout
            boolean r3 = r3.l()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.mLayout
            boolean r3 = r3.k()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.u(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (k(motionEvent)) {
            c();
            return true;
        }
        p pVar = this.mLayout;
        if (pVar == null) {
            return false;
        }
        boolean k3 = pVar.k();
        boolean l3 = this.mLayout.l();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i3 = k3;
            if (l3) {
                i3 = (k3 ? 1 : 0) | 2;
            }
            startNestedScroll(i3, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x4 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i4 = x4 - this.mInitialTouchX;
                int i5 = y4 - this.mInitialTouchY;
                if (k3 == 0 || Math.abs(i4) <= this.mTouchSlop) {
                    z3 = false;
                } else {
                    this.mLastTouchX = x4;
                    z3 = true;
                }
                if (l3 && Math.abs(i5) > this.mTouchSlop) {
                    this.mLastTouchY = y4;
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            c();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x5;
            this.mInitialTouchX = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y5;
            this.mInitialTouchY = y5;
        } else if (actionMasked == 6) {
            v(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        androidx.core.os.i.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.i.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        p pVar = this.mLayout;
        if (pVar == null) {
            defaultOnMeasure(i3, i4);
            return;
        }
        boolean z3 = false;
        if (pVar.u0()) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.mLayout.b1(this.mRecycler, this.mState, i3, i4);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z3 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z3;
            if (z3 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f6313e == 1) {
                g();
            }
            this.mLayout.D1(i3, i4);
            this.mState.f6318j = true;
            h();
            this.mLayout.G1(i3, i4);
            if (this.mLayout.J1()) {
                this.mLayout.D1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f6318j = true;
                h();
                this.mLayout.G1(i3, i4);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.b1(this.mRecycler, this.mState, i3, i4);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            x();
            onExitLayoutOrScroll();
            B b3 = this.mState;
            if (b3.f6320l) {
                b3.f6316h = true;
            } else {
                this.mAdapterHelper.j();
                this.mState.f6316h = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f6320l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        h hVar = this.mAdapter;
        if (hVar != null) {
            this.mState.f6314f = hVar.getItemCount();
        } else {
            this.mState.f6314f = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.b1(this.mRecycler, this.mState, i3, i4);
        stopInterceptRequestLayout(false);
        this.mState.f6316h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof z)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        z zVar = (z) parcelable;
        this.mPendingSavedState = zVar;
        super.onRestoreInstanceState(zVar.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        z zVar = new z(super.onSaveInstanceState());
        z zVar2 = this.mPendingSavedState;
        if (zVar2 != null) {
            zVar.c(zVar2);
        } else {
            p pVar = this.mLayout;
            if (pVar != null) {
                zVar.f6397e = pVar.f1();
            } else {
                zVar.f6397e = null;
            }
        }
        return zVar;
    }

    public void onScrollStateChanged(int i3) {
    }

    public void onScrolled(int i3, int i4) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 == i5 && i4 == i6) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        androidx.core.view.y.a0(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    void processDataSetCompletelyChanged(boolean z3) {
        this.mDispatchItemsChangedEvent = z3 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(E e3, m.b bVar) {
        e3.setFlags(0, 8192);
        if (this.mState.f6317i && e3.isUpdated() && !e3.isRemoved() && !e3.shouldIgnore()) {
            this.mViewInfoStore.c(getChangedHolderKey(e3), e3);
        }
        this.mViewInfoStore.e(e3, bVar);
    }

    void removeAndRecycleViews() {
        m mVar = this.mItemAnimator;
        if (mVar != null) {
            mVar.k();
        }
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.n1(this.mRecycler);
            this.mLayout.o1(this.mRecycler);
        }
        this.mRecycler.c();
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean r3 = this.mChildHelper.r(view);
        if (r3) {
            E childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.J(childViewHolderInt);
            this.mRecycler.C(childViewHolderInt);
        }
        stopInterceptRequestLayout(!r3);
        return r3;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z3) {
        E childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z3);
    }

    public void removeItemDecoration(o oVar) {
        p pVar = this.mLayout;
        if (pVar != null) {
            pVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(oVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i3) {
        int itemDecorationCount = getItemDecorationCount();
        if (i3 >= 0 && i3 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i3));
            return;
        }
        throw new IndexOutOfBoundsException(i3 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(r rVar) {
        List<r> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(rVar);
    }

    public void removeOnItemTouchListener(t tVar) {
        this.mOnItemTouchListeners.remove(tVar);
        if (this.mInterceptingOnItemTouchListener == tVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(u uVar) {
        List<u> list = this.mScrollListeners;
        if (list != null) {
            list.remove(uVar);
        }
    }

    public void removeRecyclerListener(x xVar) {
        this.mRecyclerListeners.remove(xVar);
    }

    void repositionShadowingViews() {
        E e3;
        int g3 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g3; i3++) {
            View f3 = this.mChildHelper.f(i3);
            E childViewHolder = getChildViewHolder(f3);
            if (childViewHolder != null && (e3 = childViewHolder.mShadowingHolder) != null) {
                View view = e3.itemView;
                int left = f3.getLeft();
                int top = f3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.d1(this, this.mState, view, view2) && view2 != null) {
            B(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        return this.mLayout.u1(this, view, rect, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        int size = this.mOnItemTouchListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mOnItemTouchListeners.get(i3).c(z3);
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    void saveOldPositions() {
        int j3 = this.mChildHelper.j();
        for (int i3 = 0; i3 < j3; i3++) {
            E childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i4) {
        p pVar = this.mLayout;
        if (pVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean k3 = pVar.k();
        boolean l3 = this.mLayout.l();
        if (k3 || l3) {
            if (!k3) {
                i3 = 0;
            }
            if (!l3) {
                i4 = 0;
            }
            scrollByInternal(i3, i4, null, 0);
        }
    }

    boolean scrollByInternal(int i3, int i4, MotionEvent motionEvent, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i3, i4, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            i6 = i11;
            i7 = i10;
            i8 = i3 - i10;
            i9 = i4 - i11;
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i7, i6, i8, i9, this.mScrollOffset, i5, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i12 = iArr4[0];
        int i13 = i8 - i12;
        int i14 = iArr4[1];
        int i15 = i9 - i14;
        boolean z3 = (i12 == 0 && i14 == 0) ? false : true;
        int i16 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i17 = iArr5[0];
        this.mLastTouchX = i16 - i17;
        int i18 = this.mLastTouchY;
        int i19 = iArr5[1];
        this.mLastTouchY = i18 - i19;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i17;
        iArr6[1] = iArr6[1] + i19;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.n.b(motionEvent, 8194)) {
                y(motionEvent.getX(), i13, motionEvent.getY(), i15);
            }
            considerReleasingGlowsOnScroll(i3, i4);
        }
        if (i7 != 0 || i6 != 0) {
            dispatchOnScrolled(i7, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z3 && i7 == 0 && i6 == 0) ? false : true;
    }

    void scrollStep(int i3, int i4, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.i.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int z12 = i3 != 0 ? this.mLayout.z1(i3, this.mRecycler, this.mState) : 0;
        int B12 = i4 != 0 ? this.mLayout.B1(i4, this.mRecycler, this.mState) : 0;
        androidx.core.os.i.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = z12;
            iArr[1] = B12;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i3) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        p pVar = this.mLayout;
        if (pVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            pVar.A1(i3);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.m mVar) {
        this.mAccessibilityDelegate = mVar;
        androidx.core.view.y.j0(this, mVar);
    }

    public void setAdapter(h hVar) {
        setLayoutFrozen(false);
        F(hVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(k kVar) {
        if (kVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    boolean setChildImportantForAccessibilityInternal(E e3, int i3) {
        if (!isComputingLayout()) {
            androidx.core.view.y.u0(e3.itemView, i3);
            return true;
        }
        e3.mPendingAccessibilityState = i3;
        this.mPendingAccessibilityImportanceChange.add(e3);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z3) {
        if (z3 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z3;
        super.setClipToPadding(z3);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(l lVar) {
        androidx.core.util.h.d(lVar);
        this.mEdgeEffectFactory = lVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z3) {
        this.mHasFixedSize = z3;
    }

    public void setItemAnimator(m mVar) {
        m mVar2 = this.mItemAnimator;
        if (mVar2 != null) {
            mVar2.k();
            this.mItemAnimator.v(null);
        }
        this.mItemAnimator = mVar;
        if (mVar != null) {
            mVar.v(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i3) {
        this.mRecycler.G(i3);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z3) {
        suppressLayout(z3);
    }

    public void setLayoutManager(p pVar) {
        if (pVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            m mVar = this.mItemAnimator;
            if (mVar != null) {
                mVar.k();
            }
            this.mLayout.n1(this.mRecycler);
            this.mLayout.o1(this.mRecycler);
            this.mRecycler.c();
            if (this.mIsAttached) {
                this.mLayout.A(this, this.mRecycler);
            }
            this.mLayout.H1(null);
            this.mLayout = null;
        } else {
            this.mRecycler.c();
        }
        this.mChildHelper.o();
        this.mLayout = pVar;
        if (pVar != null) {
            if (pVar.f6355b != null) {
                throw new IllegalArgumentException("LayoutManager " + pVar + " is already attached to a RecyclerView:" + pVar.f6355b.exceptionLabel());
            }
            pVar.H1(this);
            if (this.mIsAttached) {
                this.mLayout.z(this);
            }
        }
        this.mRecycler.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        getScrollingChildHelper().n(z3);
    }

    public void setOnFlingListener(s sVar) {
        this.mOnFlingListener = sVar;
    }

    @Deprecated
    public void setOnScrollListener(u uVar) {
        this.mScrollListener = uVar;
    }

    public void setPreserveFocusAfterLayout(boolean z3) {
        this.mPreserveFocusAfterLayout = z3;
    }

    public void setRecycledViewPool(v vVar) {
        this.mRecycler.E(vVar);
    }

    @Deprecated
    public void setRecyclerListener(x xVar) {
    }

    void setScrollState(int i3) {
        if (i3 == this.mScrollState) {
            return;
        }
        this.mScrollState = i3;
        if (i3 != 2) {
            G();
        }
        dispatchOnScrollStateChanged(i3);
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(C c3) {
        this.mRecycler.F(c3);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int a3 = accessibilityEvent != null ? androidx.core.view.accessibility.b.a(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= a3 != 0 ? a3 : 0;
        return true;
    }

    public void smoothScrollBy(int i3, int i4) {
        smoothScrollBy(i3, i4, null);
    }

    public void smoothScrollToPosition(int i3) {
        if (this.mLayoutSuppressed) {
            return;
        }
        p pVar = this.mLayout;
        if (pVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            pVar.L1(this, this.mState, i3);
        }
    }

    void startInterceptRequestLayout() {
        int i3 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i3;
        if (i3 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().p(i3);
    }

    void stopInterceptRequestLayout(boolean z3) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z3 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z3 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopScroll() {
        setScrollState(0);
        G();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z3) {
        if (z3 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(h hVar, boolean z3) {
        setLayoutFrozen(false);
        F(hVar, true, z3);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int i3, int i4, Object obj) {
        int i5;
        int j3 = this.mChildHelper.j();
        int i6 = i3 + i4;
        for (int i7 = 0; i7 < j3; i7++) {
            View i8 = this.mChildHelper.i(i7);
            E childViewHolderInt = getChildViewHolderInt(i8);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i5 = childViewHolderInt.mPosition) >= i3 && i5 < i6) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((q) i8.getLayoutParams()).f6380c = true;
            }
        }
        this.mRecycler.M(i3, i4);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, I.a.f892a);
    }

    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return getScrollingChildHelper().d(i3, i4, iArr, iArr2, i5);
    }

    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr, int i7) {
        return getScrollingChildHelper().g(i3, i4, i5, i6, iArr, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.E findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.d r0 = r5.mChildHelper
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.d r3 = r5.mChildHelper
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$E r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.d r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$E");
    }

    public boolean hasNestedScrollingParent(int i3) {
        return getScrollingChildHelper().l(i3);
    }

    void onExitLayoutOrScroll(boolean z3) {
        int i3 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i3;
        if (i3 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z3) {
                f();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i3, int i4, Interpolator interpolator) {
        smoothScrollBy(i3, i4, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i3, int i4) {
        return getScrollingChildHelper().q(i3, i4);
    }

    public void stopNestedScroll(int i3) {
        getScrollingChildHelper().s(i3);
    }

    public static class z extends AbstractC0645a {
        public static final Parcelable.Creator<z> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        Parcelable f6397e;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public z createFromParcel(Parcel parcel) {
                return new z(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public z createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new z(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public z[] newArray(int i3) {
                return new z[i3];
            }
        }

        z(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6397e = parcel.readParcelable(classLoader == null ? p.class.getClassLoader() : classLoader);
        }

        void c(z zVar) {
            this.f6397e = zVar.f6397e;
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.f6397e, 0);
        }

        z(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mObserver = new y();
        this.mRecycler = new w();
        this.mViewInfoStore = new androidx.recyclerview.widget.r();
        this.mUpdateChildViewsRunnable = new RunnableC0276a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new l();
        this.mItemAnimator = new e();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new D();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new g.b() : null;
        this.mState = new B();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new n();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new RunnableC0277b();
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new C0279d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.view.A.a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = androidx.core.view.A.b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.v(this.mItemAnimatorListener);
        initAdapterManager();
        s();
        r();
        if (androidx.core.view.y.v(this) == 0) {
            androidx.core.view.y.u0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.m(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I.c.f901f, i3, 0);
        androidx.core.view.y.h0(this, context, I.c.f901f, attributeSet, obtainStyledAttributes, i3, 0);
        String string = obtainStyledAttributes.getString(I.c.f910o);
        if (obtainStyledAttributes.getInt(I.c.f904i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(I.c.f903h, true);
        boolean z3 = obtainStyledAttributes.getBoolean(I.c.f905j, false);
        this.mEnableFastScroller = z3;
        if (z3) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(I.c.f908m), obtainStyledAttributes.getDrawable(I.c.f909n), (StateListDrawable) obtainStyledAttributes.getDrawable(I.c.f906k), obtainStyledAttributes.getDrawable(I.c.f907l));
        }
        obtainStyledAttributes.recycle();
        d(context, string, attributeSet, i3, 0);
        int[] iArr = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        androidx.core.view.y.h0(this, context, iArr, attributeSet, obtainStyledAttributes2, i3, 0);
        boolean z4 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z4);
    }

    public final void dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        getScrollingChildHelper().e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    public void smoothScrollBy(int i3, int i4, Interpolator interpolator, int i5) {
        smoothScrollBy(i3, i4, interpolator, i5, false);
    }

    public static class q extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        E f6378a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f6379b;

        /* renamed from: c, reason: collision with root package name */
        boolean f6380c;

        /* renamed from: d, reason: collision with root package name */
        boolean f6381d;

        public q(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6379b = new Rect();
            this.f6380c = true;
            this.f6381d = false;
        }

        public int a() {
            return this.f6378a.getLayoutPosition();
        }

        public boolean b() {
            return this.f6378a.isUpdated();
        }

        public boolean c() {
            return this.f6378a.isRemoved();
        }

        public boolean d() {
            return this.f6378a.isInvalid();
        }

        public q(int i3, int i4) {
            super(i3, i4);
            this.f6379b = new Rect();
            this.f6380c = true;
            this.f6381d = false;
        }

        public q(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6379b = new Rect();
            this.f6380c = true;
            this.f6381d = false;
        }

        public q(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6379b = new Rect();
            this.f6380c = true;
            this.f6381d = false;
        }

        public q(q qVar) {
            super((ViewGroup.LayoutParams) qVar);
            this.f6379b = new Rect();
            this.f6380c = true;
            this.f6381d = false;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        p pVar = this.mLayout;
        if (pVar != null) {
            return pVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    void smoothScrollBy(int i3, int i4, Interpolator interpolator, int i5, boolean z3) {
        p pVar = this.mLayout;
        if (pVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!pVar.k()) {
            i3 = 0;
        }
        if (!this.mLayout.l()) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        if (i5 != Integer.MIN_VALUE && i5 <= 0) {
            scrollBy(i3, i4);
            return;
        }
        if (z3) {
            int i6 = i3 != 0 ? 1 : 0;
            if (i4 != 0) {
                i6 |= 2;
            }
            startNestedScroll(i6, 1);
        }
        this.mViewFlinger.e(i3, i4, i5, interpolator);
    }

    public void addItemDecoration(o oVar) {
        addItemDecoration(oVar, -1);
    }
}
