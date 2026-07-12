package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.y;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import d0.AbstractC0335a;
import h0.AbstractC0371a;
import java.util.ArrayList;
import o0.C0491a;
import p0.C0495a;

/* loaded from: classes.dex */
public class COUIRecyclerView extends RecyclerView implements C0495a.c {
    public static final int CENTER_ALIGN = 2;
    private static final boolean COUI_DEBUG;
    private static final int CUSTOM_TOUCH_SLOP = 2;
    private static final int DEBUG_PAINT_TEXT_OFFSET_Y = 50;
    private static final int DEBUG_PAINT_TEXT_SIZE = 30;
    private static final float DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE = 20.0f;
    private static final int DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD = 2500;
    private static final double DEGREE_TO_ARC_CONSTANT = 0.017453292519943295d;
    private static final int FLING_SCROLL_THRESHOLD = 1000;
    private static final int FLING_SCROLL_THRESHOLD_WHILE_OVER_SCROLLING = 6000;
    private static final float HORIZONTAL_SPRING_BACK_TENSION_MULTIPLE = 3.2f;
    private static final int INVALID_POINTER = -1;
    private static final int OVER_SCROLL_TOUCH_DURATION_THRESHOLD;
    private static final int OVER_SCROLL_TOUCH_OFFSET_THRESHOLD = 10;
    private static final int SLOW_SCROLL_THRESHOLD = 2500;
    public static final int START_ALIGN = 1;
    static final String TAG = "COUIRecyclerView";
    private static final float VERTICAL_SPRING_BACK_TENSION_MULTIPLE = 2.15f;
    final int FLING;
    final int OVER_FLING;
    final int OVER_SCROLLING;
    private final int SCROLLBARS_NONE;
    private final int SCROLLBARS_VERTICAL;
    final int SCROLLING;
    private float mAbortVelocityX;
    private float mAbortVelocityY;
    private boolean mAvoidAccidentalTouch;
    private o0.c mCOUILocateOverScroller;
    private androidx.recyclerview.widget.b mCOUIRecyclerDividerManager;
    private C0495a mCOUIScrollBar;
    private float mClickVelocityX;
    private float mClickVelocityY;
    private float mDebugAbortVelocityX;
    private float mDebugAbortVelocityY;
    private Paint mDebugPaint;
    private int mDispatchEventVelocityThreshold;
    private boolean mEnableDispatchEventWhileOverScrolling;
    private boolean mEnableDispatchEventWhileScrolling;
    private boolean mEnableFlingSpeedIncrease;
    private boolean mEnableOptimizedScroll;
    private boolean mEnablePointerDown;
    private boolean mEnableVibrator;
    private float mEventFilterAngle;
    private float mFastFlingVelocity;
    private boolean mFixScrollTypeForOverScrolling;
    private float mFlingRatio;
    private float mFlingVelocityX;
    private float mFlingVelocityY;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private RecyclerView.t mInterceptingOnItemTouchListener;
    private boolean mIsOverScrollingReverseFling;
    private boolean mIsTouchDownWhileOverScrolling;
    private boolean mIsTouchDownWhileSlowScrolling;
    private boolean mIsUseNativeOverScroll;
    private boolean mItemClickableWhileOverScrolling;
    private boolean mItemClickableWhileSlowScrolling;
    private int mLastTouchX;
    private int mLastTouchY;
    private C0491a mLocateHelper;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mNestedOffsets;
    private RecyclerView.s mOnFlingListener;
    private ArrayList<RecyclerView.t> mOnItemTouchListeners;
    boolean mOverScrollEnable;
    private o0.b mOverScroller;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private int mScreenHeight;
    private int mScreenWidth;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private int mScrollType;
    private Drawable mScrollbarThumbVertical;
    private int mScrollbars;
    private int mScrollbarsSize;
    private int mSlowScrollThreshold;
    private boolean mSmoothScrollFlag;
    private o0.e mSpringOverScroller;
    private int mStyle;
    private int mTouchSlop;
    private long mTouchTime;
    private VelocityTracker mVelocityTracker;
    private float mVerticalSpringOverTension;
    private c mViewFlinger;

    public static class a extends RecyclerView.o {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f6224a;

        /* renamed from: b, reason: collision with root package name */
        private Paint f6225b;

        /* renamed from: c, reason: collision with root package name */
        private int f6226c;

        /* renamed from: d, reason: collision with root package name */
        private int f6227d;

        /* renamed from: e, reason: collision with root package name */
        private int f6228e;

        /* renamed from: f, reason: collision with root package name */
        private int f6229f;

        /* renamed from: g, reason: collision with root package name */
        private int f6230g;

        /* renamed from: h, reason: collision with root package name */
        private int f6231h;

        public a(Context context) {
            m(context);
        }

        private void m(Context context) {
            this.f6226c = AbstractC0335a.a(context, M1.c.f1363h);
            this.f6227d = context.getResources().getDimensionPixelOffset(M1.f.f1458r);
            Paint paint = new Paint(1);
            this.f6225b = paint;
            paint.setColor(this.f6226c);
            int alpha = this.f6225b.getAlpha();
            this.f6230g = alpha;
            this.f6229f = alpha;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.B b3) {
            int childCount = recyclerView.getChildCount();
            this.f6231h = -1;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = recyclerView.getChildAt(i3);
                if (p(recyclerView, i3)) {
                    j(canvas, recyclerView, childAt);
                    boolean z3 = childAt.getLayoutDirection() == 1;
                    int y3 = (int) (childAt.getY() + childAt.getHeight());
                    if (this.f6231h != y3) {
                        this.f6231h = y3;
                        int max = Math.max(1, this.f6227d) + y3;
                        int x3 = (int) (childAt.getX() + (z3 ? k(recyclerView, i3) : l(recyclerView, i3)));
                        int x4 = (int) ((childAt.getX() + childAt.getWidth()) - (z3 ? l(recyclerView, i3) : k(recyclerView, i3)));
                        int i4 = this.f6228e;
                        int i5 = (i4 == i3 || i4 + (-1) == i3) ? this.f6229f : this.f6230g;
                        Drawable drawable = this.f6224a;
                        if (drawable == null) {
                            this.f6225b.setAlpha(i5);
                            canvas.drawRect(x3, y3, x4, max, this.f6225b);
                        } else {
                            drawable.setAlpha(i5);
                            this.f6224a.setBounds(x3, y3, x4, max);
                            this.f6224a.draw(canvas);
                        }
                    }
                }
                i3++;
            }
        }

        public void j(Canvas canvas, RecyclerView recyclerView, View view) {
        }

        public int k(RecyclerView recyclerView, int i3) {
            return 0;
        }

        public int l(RecyclerView recyclerView, int i3) {
            return 0;
        }

        public void n(int i3) {
            this.f6229f = i3;
        }

        public void o(int i3) {
            this.f6228e = i3;
        }

        public abstract boolean p(RecyclerView recyclerView, int i3);
    }

    public interface b {
        boolean drawDivider();

        default View getDividerEndAlignView() {
            return null;
        }

        int getDividerEndInset();

        View getDividerStartAlignView();

        int getDividerStartInset();
    }

    public class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private int f6232e;

        /* renamed from: f, reason: collision with root package name */
        private int f6233f;

        /* renamed from: g, reason: collision with root package name */
        Interpolator f6234g = RecyclerView.sQuinticInterpolator;

        /* renamed from: h, reason: collision with root package name */
        private boolean f6235h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6236i = false;

        c() {
        }

        private int a(int i3, int i4, int i5, int i6) {
            int i7;
            int abs = Math.abs(i3);
            int abs2 = Math.abs(i4);
            boolean z3 = abs > abs2;
            int sqrt = (int) Math.sqrt((i5 * i5) + (i6 * i6));
            int sqrt2 = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            int width = z3 ? cOUIRecyclerView.getWidth() : cOUIRecyclerView.getHeight();
            int i8 = width / 2;
            float f3 = width;
            float f4 = i8;
            float b3 = f4 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f3)) * f4);
            if (sqrt > 0) {
                i7 = Math.round(Math.abs(b3 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z3) {
                    abs = abs2;
                }
                i7 = (int) (((abs / f3) + 1.0f) * 300.0f);
            }
            return Math.min(i7, 2000);
        }

        private float b(float f3) {
            return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
        }

        private void d() {
            COUIRecyclerView.this.removeCallbacks(this);
            y.a0(COUIRecyclerView.this, this);
        }

        public void c(int i3, int i4) {
            COUIRecyclerView.this.mFlingVelocityX = i3;
            COUIRecyclerView.this.mFlingVelocityY = i4;
            COUIRecyclerView.this.setScrollState(2);
            this.f6233f = 0;
            this.f6232e = 0;
            Interpolator interpolator = this.f6234g;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f6234g = interpolator2;
                if (COUIRecyclerView.this.mOverScroller != null) {
                    COUIRecyclerView.this.mOverScroller.d(interpolator2);
                }
            }
            if (COUIRecyclerView.this.mOverScroller != null) {
                COUIRecyclerView.this.mOverScroller.fling(0, 0, i3, i4, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, Integer.MIN_VALUE, Preference.DEFAULT_ORDER);
                COUIRecyclerView.this.mOverScroller.setFinalX(COUIRecyclerView.this.mLocateHelper.k(COUIRecyclerView.this.mOverScroller.h()));
            }
            e();
        }

        void e() {
            if (this.f6235h) {
                this.f6236i = true;
            } else {
                d();
            }
        }

        public void f(int i3, int i4, int i5, Interpolator interpolator) {
            if (i5 == Integer.MIN_VALUE) {
                i5 = a(i3, i4, 0, 0);
            }
            int i6 = i5;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f6234g != interpolator) {
                this.f6234g = interpolator;
                if (COUIRecyclerView.this.mOverScroller != null) {
                    COUIRecyclerView.this.mOverScroller.d(interpolator);
                }
            }
            this.f6233f = 0;
            this.f6232e = 0;
            COUIRecyclerView.this.setScrollState(2);
            if (COUIRecyclerView.this.mOverScroller != null) {
                COUIRecyclerView.this.mOverScroller.startScroll(0, 0, i3, i4, i6);
            }
            e();
        }

        public void g() {
            COUIRecyclerView.this.removeCallbacks(this);
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            cOUIRecyclerView.Q(cOUIRecyclerView.getContext());
            COUIRecyclerView cOUIRecyclerView2 = COUIRecyclerView.this;
            float f3 = 0.0f;
            cOUIRecyclerView2.mAbortVelocityX = (cOUIRecyclerView2.mOverScroller == null || COUIRecyclerView.this.mOverScroller.a() == 0.0f) ? 0.0f : COUIRecyclerView.this.mFlingVelocityX;
            COUIRecyclerView cOUIRecyclerView3 = COUIRecyclerView.this;
            if (cOUIRecyclerView3.mOverScroller != null && COUIRecyclerView.this.mOverScroller.f() != 0.0f) {
                f3 = COUIRecyclerView.this.mFlingVelocityY;
            }
            cOUIRecyclerView3.mAbortVelocityY = f3;
            if (COUIRecyclerView.this.mOverScroller != null) {
                COUIRecyclerView.this.mOverScroller.abortAnimation();
            }
            if (COUIRecyclerView.this.mSpringOverScroller != null) {
                COUIRecyclerView.this.mSpringOverScroller.abortAnimation();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i4;
            int i5;
            COUIRecyclerView cOUIRecyclerView = COUIRecyclerView.this;
            if (cOUIRecyclerView.mLayout == null) {
                g();
                return;
            }
            this.f6236i = false;
            this.f6235h = true;
            cOUIRecyclerView.consumePendingUpdateOperations();
            o0.b bVar = COUIRecyclerView.this.mOverScroller;
            if (bVar != null && bVar.computeScrollOffset()) {
                int b3 = bVar.b();
                int i6 = bVar.i();
                int i7 = b3 - this.f6232e;
                int i8 = i6 - this.f6233f;
                this.f6232e = b3;
                this.f6233f = i6;
                COUIRecyclerView cOUIRecyclerView2 = COUIRecyclerView.this;
                int[] iArr = cOUIRecyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (cOUIRecyclerView2.dispatchNestedPreScroll(i7, i8, iArr, null, 1)) {
                    int[] iArr2 = COUIRecyclerView.this.mReusableIntPair;
                    i7 -= iArr2[0];
                    i8 -= iArr2[1];
                }
                COUIRecyclerView cOUIRecyclerView3 = COUIRecyclerView.this;
                if (cOUIRecyclerView3.mAdapter != null) {
                    int[] iArr3 = cOUIRecyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    cOUIRecyclerView3.scrollStep(i7, i8, iArr3);
                    COUIRecyclerView cOUIRecyclerView4 = COUIRecyclerView.this;
                    int[] iArr4 = cOUIRecyclerView4.mReusableIntPair;
                    i4 = iArr4[0];
                    i3 = iArr4[1];
                    i7 -= i4;
                    i8 -= i3;
                    RecyclerView.A a3 = cOUIRecyclerView4.mLayout.f6360g;
                    if (a3 != null && !a3.g() && a3.h()) {
                        int b4 = COUIRecyclerView.this.mState.b();
                        if (b4 == 0) {
                            a3.r();
                        } else if (a3.f() >= b4) {
                            a3.p(b4 - 1);
                            a3.j(i4, i3);
                        } else {
                            a3.j(i4, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (!COUIRecyclerView.this.mItemDecorations.isEmpty()) {
                    COUIRecyclerView.this.invalidate();
                }
                COUIRecyclerView cOUIRecyclerView5 = COUIRecyclerView.this;
                int[] iArr5 = cOUIRecyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                cOUIRecyclerView5.dispatchNestedScroll(i4, i3, i7, i8, null, 1, iArr5);
                COUIRecyclerView cOUIRecyclerView6 = COUIRecyclerView.this;
                int[] iArr6 = cOUIRecyclerView6.mReusableIntPair;
                int i9 = i7 - iArr6[0];
                int i10 = i8 - iArr6[1];
                if (i4 != 0 || i3 != 0) {
                    cOUIRecyclerView6.dispatchOnScrolled(i4, i3);
                }
                if (!COUIRecyclerView.this.mSmoothScrollFlag || (i9 == 0 && i10 == 0)) {
                    i5 = i10;
                } else {
                    bVar.abortAnimation();
                    COUIRecyclerView.this.mSmoothScrollFlag = false;
                    i5 = 0;
                    i9 = 0;
                }
                if (i5 != 0) {
                    COUIRecyclerView cOUIRecyclerView7 = COUIRecyclerView.this;
                    if (cOUIRecyclerView7.mOverScrollEnable) {
                        cOUIRecyclerView7.mScrollType = 3;
                        COUIRecyclerView.this.b0();
                        COUIRecyclerView cOUIRecyclerView8 = COUIRecyclerView.this;
                        cOUIRecyclerView8.overScrollBy(0, i5, 0, cOUIRecyclerView8.getScrollY(), 0, 0, 0, COUIRecyclerView.this.mOverflingDistance, false);
                        if (COUIRecyclerView.this.mIsUseNativeOverScroll) {
                            if (COUIRecyclerView.this.mSpringOverScroller != null) {
                                COUIRecyclerView.this.mSpringOverScroller.j(bVar.f());
                                COUIRecyclerView.this.mSpringOverScroller.notifyVerticalEdgeReached(i5, 0, COUIRecyclerView.this.mOverflingDistance);
                            }
                        } else if (COUIRecyclerView.this.mOverScroller != null) {
                            COUIRecyclerView.this.mOverScroller.notifyVerticalEdgeReached(i5, 0, COUIRecyclerView.this.mOverflingDistance);
                        }
                    }
                }
                if (i9 != 0) {
                    COUIRecyclerView cOUIRecyclerView9 = COUIRecyclerView.this;
                    if (cOUIRecyclerView9.mOverScrollEnable) {
                        cOUIRecyclerView9.mScrollType = 3;
                        COUIRecyclerView.this.b0();
                        COUIRecyclerView cOUIRecyclerView10 = COUIRecyclerView.this;
                        cOUIRecyclerView10.overScrollBy(i9, 0, cOUIRecyclerView10.getScrollX(), 0, 0, 0, COUIRecyclerView.this.mOverflingDistance, 0, false);
                        if (COUIRecyclerView.this.mIsUseNativeOverScroll) {
                            if (COUIRecyclerView.this.mSpringOverScroller != null) {
                                COUIRecyclerView.this.mSpringOverScroller.e(bVar.a());
                                COUIRecyclerView.this.mSpringOverScroller.notifyHorizontalEdgeReached(i9, 0, COUIRecyclerView.this.mOverflingDistance);
                            }
                        } else if (COUIRecyclerView.this.mOverScroller != null) {
                            COUIRecyclerView.this.mOverScroller.notifyHorizontalEdgeReached(i9, 0, COUIRecyclerView.this.mOverflingDistance);
                        }
                    }
                }
                if (!COUIRecyclerView.this.awakenScrollBars()) {
                    COUIRecyclerView.this.invalidate();
                }
                boolean z3 = bVar.g() || (((bVar.b() == bVar.h()) || i9 != 0) && ((bVar.i() == bVar.c()) || i5 != 0));
                RecyclerView.A a4 = COUIRecyclerView.this.mLayout.f6360g;
                if ((a4 != null && a4.g()) || !z3) {
                    e();
                    COUIRecyclerView cOUIRecyclerView11 = COUIRecyclerView.this;
                    g gVar = cOUIRecyclerView11.mGapWorker;
                    if (gVar != null) {
                        gVar.f(cOUIRecyclerView11, i4, i3);
                    }
                } else if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    COUIRecyclerView.this.mPrefetchRegistry.b();
                }
            }
            RecyclerView.A a5 = COUIRecyclerView.this.mLayout.f6360g;
            if (a5 != null && a5.g()) {
                a5.j(0, 0);
            }
            this.f6235h = false;
            if (this.f6236i) {
                d();
            } else {
                if (COUIRecyclerView.this.mScrollType == 3 && COUIRecyclerView.this.mOverScrollEnable) {
                    return;
                }
                COUIRecyclerView.this.setScrollState(0);
                COUIRecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    static {
        COUI_DEBUG = AbstractC0371a.f11873b || AbstractC0371a.e(TAG, 3);
        OVER_SCROLL_TOUCH_DURATION_THRESHOLD = ViewConfiguration.getLongPressTimeout();
    }

    public COUIRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void D() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
    }

    private void G() {
        S();
        this.mViewFlinger.g();
        RecyclerView.p pVar = this.mLayout;
        if (pVar != null) {
            pVar.N1();
        }
    }

    private void I() {
        D();
        setScrollState(0);
    }

    private void J() {
        if (this.mScrollState != 0) {
            this.mScrollState = 0;
            dispatchOnScrollStateChanged(0);
        }
    }

    private void K(Context context) {
        this.mCOUIScrollBar = new C0495a.b(this).a();
    }

    private boolean L(View view, MotionEvent motionEvent) {
        boolean z3 = true;
        int[] iArr = {0, 1};
        for (int i3 = 0; i3 < 2; i3++) {
            motionEvent.setAction(iArr[i3]);
            z3 &= view.dispatchTouchEvent(motionEvent);
        }
        return z3;
    }

    private View M(MotionEvent motionEvent) {
        if (!T(motionEvent)) {
            return null;
        }
        Rect rect = new Rect();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0 || childAt.getAnimation() != null) {
                childAt.getHitRect(rect);
                boolean contains = rect.contains(((int) motionEvent.getX()) + getScrollX(), ((int) motionEvent.getY()) + getScrollY());
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(getScrollX() - childAt.getLeft(), getScrollY() - childAt.getTop());
                if (contains && L(childAt, obtain)) {
                    view = childAt;
                }
                obtain.recycle();
                if (COUI_DEBUG) {
                    childAt.setBackground(childAt == view ? new ColorDrawable(Color.parseColor("#80FF0000")) : null);
                }
            }
        }
        return view;
    }

    private boolean N(float f3, float f4) {
        return !(this.mEnableDispatchEventWhileScrolling || (this.mEnableDispatchEventWhileOverScrolling && W())) || f3 == 0.0f || ((double) Math.abs(f4 / f3)) > Math.tan(((double) this.mEventFilterAngle) * DEGREE_TO_ARC_CONSTANT);
    }

    private void O(Context context, AttributeSet attributeSet, int i3) {
        if (attributeSet == null || attributeSet.getStyleAttribute() == 0) {
            this.mStyle = i3;
        } else {
            this.mStyle = attributeSet.getStyleAttribute();
        }
        if (context != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Y1.a.f3005a, i3, 0);
            this.mScrollbars = obtainStyledAttributes.getInteger(Y1.a.f3009e, 0);
            this.mScrollbarsSize = obtainStyledAttributes.getDimensionPixelSize(Y1.a.f3007c, 0);
            this.mScrollbarThumbVertical = obtainStyledAttributes.getDrawable(Y1.a.f3008d);
            this.mEnableVibrator = obtainStyledAttributes.getBoolean(Y1.a.f3006b, true);
            obtainStyledAttributes.recycle();
        }
    }

    private void P() {
        if (this.mOnItemTouchListeners == null) {
            this.mOnItemTouchListeners = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Context context) {
        if (this.mOverScroller == null) {
            this.mVerticalSpringOverTension = VERTICAL_SPRING_BACK_TENSION_MULTIPLE;
            this.mSpringOverScroller = new o0.e(context);
            this.mCOUILocateOverScroller = new o0.c(context);
            enableFrameRate(true);
            setIsUseNativeOverScroll(false);
            setEnableFlingSpeedIncrease(this.mEnableFlingSpeedIncrease);
        }
    }

    private void R(Context context) {
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        this.mOverscrollDistance = i3;
        this.mOverflingDistance = i3;
    }

    private void S() {
        if (this.mViewFlinger == null) {
            this.mViewFlinger = new c();
        }
    }

    private boolean T(MotionEvent motionEvent) {
        int x3 = (int) (motionEvent.getX() - this.mInitialTouchX);
        int y3 = (int) (motionEvent.getY() - this.mInitialTouchY);
        int sqrt = (int) Math.sqrt((x3 * x3) + (y3 * y3));
        long currentTimeMillis = System.currentTimeMillis() - this.mTouchTime;
        if (COUI_DEBUG) {
            Log.d(TAG, "onTouchEvent: ACTION_UP. touchDuration = " + currentTimeMillis + ", offset = " + sqrt);
        }
        return currentTimeMillis < ((long) OVER_SCROLL_TOUCH_DURATION_THRESHOLD) && sqrt < 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(View view, int i3) {
        return this.mCOUIRecyclerDividerManager.i(view, i3);
    }

    private boolean V(float f3, float f4) {
        return !this.mAvoidAccidentalTouch || Math.abs(f3) > this.mFastFlingVelocity || Math.abs(f4) > this.mFastFlingVelocity;
    }

    private boolean W() {
        int i3;
        return this.mOverScrollEnable && ((i3 = this.mScrollType) == 2 || i3 == 3) && X();
    }

    private boolean X() {
        RecyclerView.p pVar = this.mLayout;
        if (pVar == null) {
            return false;
        }
        return (pVar.l() && this.mLayout.k()) ? (getScrollY() == 0 || getScrollX() == 0) ? false : true : this.mLayout.l() ? getScrollY() != 0 : this.mLayout.k() && getScrollX() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        this.mLocateHelper.p();
    }

    private boolean Z() {
        return getLayoutManager() != null && (getLayoutManager() instanceof LinearLayoutManager) && ((LinearLayoutManager) getLayoutManager()).q2() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a0(MotionEvent motionEvent) {
        boolean z3;
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null && c0495a.j(motionEvent)) {
            return true;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (k(motionEvent)) {
            c();
            return true;
        }
        RecyclerView.p pVar = this.mLayout;
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
        int e3 = y0.j.e(motionEvent, motionEvent.getActionIndex());
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            o0.b bVar = this.mOverScroller;
            float a3 = bVar != null ? bVar.a() : 0.0f;
            o0.b bVar2 = this.mOverScroller;
            float f3 = bVar2 != null ? bVar2.f() : 0.0f;
            boolean V3 = V(this.mFlingVelocityX, this.mAbortVelocityX);
            boolean V4 = V(this.mFlingVelocityY, this.mAbortVelocityY);
            this.mIsTouchDownWhileSlowScrolling = (Math.abs(a3) > 0.0f && Math.abs(a3) < ((float) this.mSlowScrollThreshold) && V3) || (Math.abs(f3) > 0.0f && Math.abs(f3) < ((float) this.mSlowScrollThreshold) && V4);
            this.mIsTouchDownWhileOverScrolling = W();
            this.mTouchTime = System.currentTimeMillis();
            if (COUI_DEBUG) {
                this.mClickVelocityX = a3;
                this.mClickVelocityY = f3;
                this.mDebugAbortVelocityX = this.mAbortVelocityX;
                this.mDebugAbortVelocityY = this.mAbortVelocityY;
                Log.d(TAG, "onInterceptTouchEvent: ACTION_DOWN, isOverScrolling=:" + this.mIsTouchDownWhileOverScrolling + ", scrollVelocityX=:" + Math.abs(a3) + ", isFastFlingX=:" + V3 + ", mFlingVelocityX=:" + this.mFlingVelocityX + ", mAbortVelocityX=:" + this.mAbortVelocityX + ", scrollVelocityY=:" + Math.abs(f3) + ", isFastFlingY=:" + V4 + ", mFlingVelocityY=:" + this.mFlingVelocityY + ", mAbortVelocityY=:" + this.mAbortVelocityY);
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
            this.mSmoothScrollFlag = false;
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
                if (k3 == 0 || Math.abs(i4) <= this.mTouchSlop || !N(i5, i4)) {
                    z3 = false;
                } else {
                    this.mLastTouchX = x4;
                    z3 = true;
                }
                if (l3 && Math.abs(i5) > this.mTouchSlop && N(i4, i5)) {
                    this.mLastTouchY = y4;
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            I();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(e3);
            int x5 = (int) (motionEvent.getX(e3) + 0.5f);
            this.mLastTouchX = x5;
            this.mInitialTouchX = x5;
            int y5 = (int) (motionEvent.getY(e3) + 0.5f);
            this.mLastTouchY = y5;
            this.mInitialTouchY = y5;
            if (!this.mEnablePointerDown) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 6) {
            v(motionEvent);
        }
        return this.mScrollState == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.mEnableVibrator) {
            performHapticFeedback(307);
        }
    }

    private void c() {
        D();
        setScrollState(0);
        A0.b.b(this, 0);
        A0.b.c(this, 0);
        this.mScrollType = 0;
    }

    private void c0(float f3, float f4) {
        this.mIsOverScrollingReverseFling = true;
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            eVar.w(getScrollX(), getScrollY(), (int) f3, (int) f4);
        }
        J();
    }

    private void d0() {
        o0.e eVar = this.mSpringOverScroller;
        if (eVar == null || !eVar.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
            return;
        }
        J();
    }

    private float getVelocityAlongScrollableDirection() {
        o0.b bVar;
        o0.b bVar2;
        RecyclerView.p layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return 0.0f;
        }
        if (layoutManager.k() && (bVar2 = this.mOverScroller) != null) {
            return bVar2.a();
        }
        if (!layoutManager.l() || (bVar = this.mOverScroller) == null) {
            return 0.0f;
        }
        return bVar.f();
    }

    private boolean j(MotionEvent motionEvent) {
        RecyclerView.t tVar = this.mInterceptingOnItemTouchListener;
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
            RecyclerView.t tVar = this.mOnItemTouchListeners.get(i3);
            if (tVar.a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = tVar;
                return true;
            }
        }
        return false;
    }

    private void v(MotionEvent motionEvent) {
        int e3 = y0.j.e(motionEvent, motionEvent.getActionIndex());
        if (motionEvent.getPointerId(e3) == this.mScrollPointerId) {
            int i3 = e3 == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i3);
            int x3 = (int) (motionEvent.getX(i3) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(i3) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnItemTouchListener(RecyclerView.t tVar) {
        P();
        this.mOnItemTouchListeners.add(tVar);
    }

    @Override // android.view.View
    protected boolean awakenScrollBars() {
        C0495a c0495a = this.mCOUIScrollBar;
        return c0495a != null ? c0495a.c() : super.awakenScrollBars();
    }

    public void cancelHorizontalItemAlign() {
        this.mLocateHelper.c();
    }

    @Override // android.view.View
    public void computeScroll() {
        o0.e eVar;
        if (this.mIsOverScrollingReverseFling) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (scrollX == 0 && scrollY == 0) {
                overScrollBy(-scrollX, -scrollY, scrollX, scrollY, 0, 0, 0, 0, false);
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                this.mIsOverScrollingReverseFling = false;
                o0.e eVar2 = this.mSpringOverScroller;
                int a3 = eVar2 != null ? (int) eVar2.a() : 0;
                o0.e eVar3 = this.mSpringOverScroller;
                int f3 = eVar3 != null ? (int) eVar3.f() : 0;
                o0.e eVar4 = this.mSpringOverScroller;
                if (eVar4 != null) {
                    eVar4.abortAnimation();
                }
                setScrollState(0);
                fling(a3, f3);
                return;
            }
        }
        if (this.mOverScrollEnable) {
            int i3 = this.mScrollType;
            if ((i3 == 2 || i3 == 3) && (eVar = this.mSpringOverScroller) != null && eVar.computeScrollOffset()) {
                int scrollX2 = getScrollX();
                int scrollY2 = getScrollY();
                int b3 = eVar.b();
                int i4 = eVar.i();
                if (scrollX2 != b3 || scrollY2 != i4) {
                    int i5 = this.mOverflingDistance;
                    overScrollBy(b3 - scrollX2, i4 - scrollY2, scrollX2, scrollY2, 0, 0, i5, i5, false);
                    onScrollChanged(getScrollX(), getScrollY(), scrollX2, scrollY2);
                }
                if (eVar.g()) {
                    setScrollState(0);
                } else {
                    setScrollState(2);
                }
                if (awakenScrollBars()) {
                    return;
                }
                postInvalidateOnAnimation();
            }
        }
    }

    protected boolean disallowInterceptWhenIsOverScrolling() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (COUI_DEBUG) {
            this.mDebugPaint.setTextSize(30.0f);
            this.mDebugPaint.setColor(-65536);
            canvas.drawText("isOverScrolling: " + W(), getWidth() / 2.0f, (getHeight() / 2.0f) - 50.0f, this.mDebugPaint);
            canvas.drawText("X: FlingVX: " + this.mFlingVelocityX + ", ClickVX: " + this.mClickVelocityX, getWidth() / 2.0f, getHeight() / 2.0f, this.mDebugPaint);
            canvas.drawText("Y: FlingVY: " + this.mFlingVelocityY + ", ClickVY: " + this.mClickVelocityY, getWidth() / 2.0f, (getHeight() / 2.0f) + 50.0f, this.mDebugPaint);
            canvas.drawText("AbortVX:" + this.mDebugAbortVelocityX + ", AbortVY:" + this.mDebugAbortVelocityY, getWidth() / 2.0f, (getHeight() / 2.0f) + 100.0f, this.mDebugPaint);
        }
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.e(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mCOUIRecyclerDividerManager.c(motionEvent);
        if (motionEvent.getActionMasked() == 1 && W() && this.mScrollType == 3) {
            this.mScrollType = 2;
        }
        if (this.mEnableDispatchEventWhileScrolling || (this.mEnableDispatchEventWhileOverScrolling && W())) {
            float velocityAlongScrollableDirection = getVelocityAlongScrollableDirection();
            if (motionEvent.getActionMasked() == 0 && this.mDispatchEventVelocityThreshold >= Math.abs(velocityAlongScrollableDirection)) {
                o0.b bVar = this.mOverScroller;
                float f3 = 0.0f;
                this.mAbortVelocityX = (bVar == null || bVar.a() == 0.0f) ? 0.0f : this.mFlingVelocityX;
                o0.b bVar2 = this.mOverScroller;
                if (bVar2 != null && bVar2.f() != 0.0f) {
                    f3 = this.mFlingVelocityY;
                }
                this.mAbortVelocityY = f3;
                o0.b bVar3 = this.mOverScroller;
                if (bVar3 != null) {
                    bVar3.abortAnimation();
                }
                stopScroll();
            }
        }
        if (W() && (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3)) {
            d0();
            if (!T(motionEvent)) {
                b0();
            }
            postInvalidateOnAnimation();
        }
        if (motionEvent.getActionMasked() != 5 || this.mEnablePointerDown) {
            return super.dispatchTouchEvent(motionEvent);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void enableFrameRate(boolean z3) {
        this.mSpringOverScroller.v(z3);
        this.mCOUILocateOverScroller.k(z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i3, int i4) {
        RecyclerView.p pVar = this.mLayout;
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
            this.mScrollType = 1;
            boolean z3 = k3 != 0 || l3;
            dispatchNestedFling(f3, f4, z3);
            RecyclerView.s sVar = this.mOnFlingListener;
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
                this.mViewFlinger.c(max, Math.max(-i6, Math.min(i4, i6)));
                return true;
            }
        }
        return false;
    }

    public C0495a getCOUIScrollDelegate() {
        return this.mCOUIScrollBar;
    }

    @Override // p0.C0495a.c
    public View getCOUIScrollableView() {
        return this;
    }

    public int getHorizontalItemAlign() {
        return this.mLocateHelper.i();
    }

    public boolean getIsUseNativeOverScroll() {
        return this.mIsUseNativeOverScroll;
    }

    public C0491a getLocateHelper() {
        return this.mLocateHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public o0.c getNativeOverScroller() {
        return this.mCOUILocateOverScroller;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.s getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getScrollState() {
        return this.mScrollState;
    }

    public c getViewFlinger() {
        return this.mViewFlinger;
    }

    protected void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isEnableFlingSpeedIncrease() {
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            return eVar.y();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.h();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            eVar.u();
        }
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.q();
            this.mCOUIScrollBar = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean a02 = a0(motionEvent);
        if (a02) {
            this.mCOUIRecyclerDividerManager.k(motionEvent);
        }
        return a02;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z3, boolean z4) {
        if (getScrollY() == i4 && getScrollX() == i3) {
            return;
        }
        if (COUI_DEBUG) {
            Log.d(TAG, "onOverScrolled: scrollX: " + i3 + " scrollY: " + i4);
        }
        if (this.mScrollType == 3) {
            i3 = (int) (Y.g.a(0, i3, this.mScreenWidth) * this.mFlingRatio);
            i4 = (int) (Y.g.a(0, i4, this.mScreenHeight) * this.mFlingRatio);
        }
        onScrollChanged(i3, i4, getScrollX(), getScrollY());
        A0.b.b(this, i3);
        A0.b.c(this, i4);
        invalidateParentIfNeeded();
        awakenScrollBars();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (this.mLocateHelper != null) {
            post(new Runnable() { // from class: androidx.recyclerview.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    COUIRecyclerView.this.Y();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0159  */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.view.View, androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.COUIRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (i3 != 0) {
            c();
            o0.e eVar = this.mSpringOverScroller;
            if (eVar != null) {
                eVar.abortAnimation();
            }
        }
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.n(view, i3);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.o(i3);
        }
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3) {
        int i11 = i3 + i5;
        int i12 = i4 + i6;
        if ((i5 < 0 && i11 > 0) || (i5 > 0 && i11 < 0)) {
            i11 = 0;
        }
        if ((i6 < 0 && i12 > 0) || (i6 > 0 && i12 < 0)) {
            i12 = 0;
        }
        onOverScrolled(i11, i12, false, false);
        return false;
    }

    public void refresh() {
        TypedArray typedArray = null;
        String resourceTypeName = this.mStyle == 0 ? null : getResources().getResourceTypeName(this.mStyle);
        if (!TextUtils.isEmpty(resourceTypeName) && "style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, Y1.a.f3005a, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mScrollbarThumbVertical = typedArray.getDrawable(Y1.a.f3008d);
            typedArray.recycle();
        }
        if (this.mScrollbars == 512) {
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.s(drawable);
            } else {
                this.mCOUIScrollBar.p();
            }
        }
        invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnItemTouchListener(RecyclerView.t tVar) {
        this.mOnItemTouchListeners.remove(tVar);
        if (this.mInterceptingOnItemTouchListener == tVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        int size = this.mOnItemTouchListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mOnItemTouchListeners.get(i3).c(z3);
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollBy(int i3, int i4) {
        RecyclerView.p pVar = this.mLayout;
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
            scrollByInternal(i3, i4, null);
        }
    }

    boolean scrollByInternal(int i3, int i4, MotionEvent motionEvent) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        consumePendingUpdateOperations();
        if (this.mAdapter == null || (i3 == 0 && i4 == 0)) {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        } else {
            if (!this.mOverScrollEnable || ((getScrollY() >= 0 || i4 <= 0) && ((getScrollY() <= 0 || i4 >= 0) && ((getScrollX() >= 0 || i3 <= 0) && (getScrollX() <= 0 || i3 >= 0))))) {
                int[] iArr = this.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                scrollStep(i3, i4, iArr);
                int[] iArr2 = this.mReusableIntPair;
                i9 = iArr2[0];
                i10 = iArr2[1];
                i11 = i3 - i9;
                i12 = i4 - i10;
            } else {
                i10 = 0;
                i9 = 0;
                i11 = 0;
                i12 = 0;
            }
            if (COUI_DEBUG) {
                Log.d(TAG, "scrollByInternal: y: " + i4 + " consumedY: " + i10 + " unconsumedY: " + i12);
            }
            i5 = i10;
            i6 = i9;
            i7 = i11;
            i8 = i12;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i6, i5, i7, i8, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i13 = i7 - iArr4[0];
        int i14 = i8 - iArr4[1];
        int i15 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i16 = iArr5[0];
        this.mLastTouchX = i15 - i16;
        int i17 = this.mLastTouchY;
        int i18 = iArr5[1];
        this.mLastTouchY = i17 - i18;
        if (motionEvent != null) {
            motionEvent.offsetLocation(i16, i18);
        }
        int[] iArr6 = this.mNestedOffsets;
        int i19 = iArr6[0];
        int[] iArr7 = this.mScrollOffset;
        iArr6[0] = i19 + iArr7[0];
        iArr6[1] = iArr6[1] + iArr7[1];
        if (getOverScrollMode() != 2 && motionEvent != null && this.mOverScrollEnable && (androidx.core.view.n.b(motionEvent, 4098) || androidx.core.view.n.b(motionEvent, 8194))) {
            if (i14 != 0 || i13 != 0) {
                this.mScrollType = 2;
            }
            if (Math.abs(i14) == 0 && Math.abs(i5) < 2 && Math.abs(i4) < 2 && Math.abs(getScrollY()) > 2) {
                this.mScrollType = 2;
            }
            if (i14 == 0 && i5 == 0 && Math.abs(i4) > 2) {
                this.mScrollType = 2;
            }
            if (Math.abs(i13) == 0 && Math.abs(i6) < 2 && Math.abs(i3) < 2 && Math.abs(getScrollX()) > 2) {
                this.mScrollType = 2;
            }
            if (i13 == 0 && i6 == 0 && Math.abs(i3) > 2) {
                this.mScrollType = 2;
            }
            if (this.mFixScrollTypeForOverScrolling && (getScrollX() != 0 || getScrollY() != 0)) {
                this.mScrollType = 2;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b3 = (int) (Y.g.b(i14, scrollY, this.mOverscrollDistance) * this.mFlingRatio);
            int b4 = (int) (Y.g.b(i13, scrollX, this.mOverscrollDistance) * this.mFlingRatio);
            if ((scrollY < 0 && i4 > 0) || (scrollY > 0 && i4 < 0)) {
                b3 = (int) (Y.g.b(i4, scrollX, this.mOverscrollDistance) * this.mFlingRatio);
            }
            int i20 = b3;
            if ((scrollX < 0 && i3 > 0) || (scrollX > 0 && i3 < 0)) {
                b4 = (int) (Y.g.b(i3, scrollX, this.mOverscrollDistance) * this.mFlingRatio);
            }
            if (i20 != 0 || b4 != 0) {
                int i21 = this.mOverscrollDistance;
                overScrollBy(b4, i20, scrollX, scrollY, 0, 0, i21, i21, true);
            }
        }
        if (i6 != 0 || i5 != 0) {
            dispatchOnScrolled(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i5 == 0) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i3) {
        c();
        super.scrollToPosition(i3);
    }

    public void setAvoidAccidentalTouch(boolean z3) {
        this.mAvoidAccidentalTouch = z3;
    }

    public void setCustomTouchSlop(int i3) {
        Log.w(TAG, "setTouchSlop: set touchSlop from " + this.mTouchSlop + " to " + i3);
        this.mTouchSlop = i3;
    }

    public void setDispatchEventWhileOverScrolling(boolean z3) {
        this.mEnableDispatchEventWhileOverScrolling = z3;
    }

    public void setDispatchEventWhileScrolling(boolean z3) {
        this.mEnableDispatchEventWhileScrolling = z3;
    }

    public void setDispatchEventWhileScrollingThreshold(int i3) {
        this.mDispatchEventVelocityThreshold = i3;
    }

    public void setEnableFlingSpeedIncrease(boolean z3) {
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            eVar.D(z3);
        }
    }

    public void setEnablePointerDownAction(boolean z3) {
        this.mEnablePointerDown = z3;
    }

    public void setEnableVibrator(boolean z3) {
        this.mEnableVibrator = z3;
    }

    public void setEventFilterTangent(float f3) {
        this.mEventFilterAngle = f3;
    }

    public void setFastFlingThreshold(float f3) {
        this.mFastFlingVelocity = Math.max(f3, 0.0f);
    }

    public void setFlingRatio(float f3) {
        this.mFlingRatio = f3;
    }

    public void setHorizontalFlingDurationRatio(float f3) {
        this.mCOUILocateOverScroller.m(f3);
    }

    public void setHorizontalFlingFriction(float f3) {
        o0.c cVar = this.mCOUILocateOverScroller;
        if (cVar != null) {
            cVar.n(f3);
        }
    }

    public void setHorizontalFlingVelocityRatio(float f3) {
        this.mCOUILocateOverScroller.o(f3);
        this.mCOUILocateOverScroller.p(f3);
    }

    public void setHorizontalItemAlign(int i3) {
        if (Z()) {
            setIsUseNativeOverScroll(true);
            this.mLocateHelper.m(i3);
        }
    }

    public void setIsUseNativeOverScroll(boolean z3) {
        this.mIsUseNativeOverScroll = z3;
        if (z3) {
            this.mOverScroller = this.mCOUILocateOverScroller;
        } else {
            this.mOverScroller = this.mSpringOverScroller;
        }
    }

    public void setIsUseOptimizedScroll(boolean z3) {
        this.mEnableOptimizedScroll = z3;
    }

    public void setItemClickableWhileOverScrolling(boolean z3) {
        this.mItemClickableWhileOverScrolling = z3;
    }

    public void setItemClickableWhileSlowScrolling(boolean z3) {
        this.mItemClickableWhileSlowScrolling = z3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.p pVar) {
        super.setLayoutManager(pVar);
        if (pVar == null || this.mSpringOverScroller == null) {
            return;
        }
        if (pVar.k()) {
            this.mSpringOverScroller.H(HORIZONTAL_SPRING_BACK_TENSION_MULTIPLE);
        } else {
            this.mSpringOverScroller.H(this.mVerticalSpringOverTension);
        }
    }

    public void setNativeOverScroller(o0.c cVar) {
        this.mCOUILocateOverScroller = cVar;
        if (this.mIsUseNativeOverScroll) {
            this.mOverScroller = cVar;
        }
    }

    public void setNewCOUIScrollDelegate(C0495a c0495a) {
        if (c0495a == null) {
            throw new IllegalArgumentException("setNewCOUIScrollDelegate must NOT be NULL.");
        }
        this.mCOUIScrollBar = c0495a;
        c0495a.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnFlingListener(RecyclerView.s sVar) {
        this.mOnFlingListener = sVar;
    }

    public void setOverScrollEnable(boolean z3) {
        this.mOverScrollEnable = z3;
    }

    public void setOverScrollingFixed(boolean z3) {
        this.mFixScrollTypeForOverScrolling = z3;
    }

    public void setPressHideDivider(boolean z3) {
        this.mCOUIRecyclerDividerManager.m(z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    void setScrollState(int i3) {
        if (i3 == this.mScrollState) {
            return;
        }
        this.mScrollState = i3;
        if (i3 != 2) {
            G();
        }
        super.setScrollState(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
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

    public void setSlowScrollThreshold(int i3) {
        Log.d(TAG, "Slow scroll threshold set to " + i3);
        this.mSlowScrollThreshold = i3;
    }

    public void setSpringBackFriction(float f3) {
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            eVar.G(f3);
        }
    }

    public void setSpringBackTension(float f3) {
        this.mVerticalSpringOverTension = f3;
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            eVar.H(f3);
        }
    }

    public void setSpringOverScrollerDebug(boolean z3) {
        o0.e eVar = this.mSpringOverScroller;
        if (eVar != null) {
            eVar.C(z3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i3, int i4) {
        smoothScrollBy(i3, i4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i3) {
        c();
        super.smoothScrollToPosition(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        super.stopScroll();
        setScrollState(0);
        G();
    }

    @Override // p0.C0495a.c
    public int superComputeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // p0.C0495a.c
    public int superComputeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override // p0.C0495a.c
    public int superComputeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override // p0.C0495a.c
    public void superOnTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    public COUIRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.SCROLLBARS_NONE = 0;
        this.SCROLLBARS_VERTICAL = 512;
        this.mFixScrollTypeForOverScrolling = true;
        this.mOverScrollEnable = true;
        this.SCROLLING = 0;
        this.FLING = 1;
        this.OVER_SCROLLING = 2;
        this.OVER_FLING = 3;
        this.mIsOverScrollingReverseFling = false;
        this.mScreenHeight = 0;
        this.mScreenWidth = 0;
        this.mItemClickableWhileSlowScrolling = true;
        this.mItemClickableWhileOverScrolling = true;
        this.mFastFlingVelocity = 1000.0f;
        this.mAvoidAccidentalTouch = true;
        this.mDebugPaint = new Paint();
        this.mEnableFlingSpeedIncrease = true;
        this.mEnableOptimizedScroll = true;
        this.mSmoothScrollFlag = false;
        this.mEnableDispatchEventWhileScrolling = false;
        this.mEnableDispatchEventWhileOverScrolling = false;
        this.mDispatchEventVelocityThreshold = 2500;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mScrollbars = 0;
        this.mSlowScrollThreshold = 2500;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mVerticalSpringOverTension = VERTICAL_SPRING_BACK_TENSION_MULTIPLE;
        this.mEnablePointerDown = true;
        this.mFlingRatio = 1.0f;
        this.mEnableVibrator = true;
        O(context, attributeSet, i3);
        S();
        P();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setSlowScrollThreshold(2500);
        R(context);
        if (COUI_DEBUG) {
            Log.d(TAG, "COUIRecyclerView: overscroll_mode: " + getOverScrollMode() + " mOverScrollEnable: " + this.mOverScrollEnable);
        }
        Q(context);
        C0491a c0491a = new C0491a();
        this.mLocateHelper = c0491a;
        c0491a.b(this);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mCOUIRecyclerDividerManager = new androidx.recyclerview.widget.b(this, this.mTouchSlop);
        if (this.mScrollbars == 512) {
            K(context);
            int i4 = this.mScrollbarsSize;
            if (i4 != 0) {
                this.mCOUIScrollBar.t(i4);
            }
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.s(drawable);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i3, int i4, Interpolator interpolator) {
        smoothScrollBy(i3, i4, interpolator, Integer.MIN_VALUE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i3, int i4, Interpolator interpolator, int i5) {
        smoothScrollBy(i3, i4, interpolator, i5, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    void smoothScrollBy(int i3, int i4, Interpolator interpolator, int i5, boolean z3) {
        if (W()) {
            c();
        }
        this.mSmoothScrollFlag = true;
        RecyclerView.p pVar = this.mLayout;
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
        this.mScrollType = 0;
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
        this.mViewFlinger.f(i3, i4, i5, interpolator);
    }
}
