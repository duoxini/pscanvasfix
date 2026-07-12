package com.coui.appcompat.panel;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.y;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class COUIViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "COUIViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.coui.appcompat.panel.COUIViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: com.coui.appcompat.panel.COUIViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            COUIViewDragHelper.this.setDragState(0);
        }
    };

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i3, int i4) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i3, int i4) {
            return 0;
        }

        public int getOrderedChildIndex(int i3) {
            return i3;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i3, int i4) {
        }

        public boolean onEdgeLock(int i3) {
            return false;
        }

        public void onEdgeTouched(int i3, int i4) {
        }

        public void onViewCaptured(View view, int i3) {
        }

        public void onViewDragStateChanged(int i3) {
        }

        public void onViewPositionChanged(View view, int i3, int i4, int i5, int i6) {
        }

        public void onViewReleased(View view, float f3, float f4) {
        }

        public abstract boolean tryCaptureView(View view, int i3);
    }

    private COUIViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.mParentView = viewGroup;
        this.mCallback = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = i3;
        this.mEdgeSize = i3;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    private boolean checkNewEdgeDrag(float f3, float f4, int i3, int i4) {
        float abs = Math.abs(f3);
        float abs2 = Math.abs(f4);
        if ((this.mInitialEdgesTouched[i3] & i4) != i4 || (this.mTrackingEdges & i4) == 0 || (this.mEdgeDragsLocked[i3] & i4) == i4 || (this.mEdgeDragsInProgress[i3] & i4) == i4) {
            return false;
        }
        int i5 = this.mTouchSlop;
        if (abs <= i5 && abs2 <= i5) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.mCallback.onEdgeLock(i4)) {
            return (this.mEdgeDragsInProgress[i3] & i4) == 0 && abs > ((float) this.mTouchSlop);
        }
        int[] iArr = this.mEdgeDragsLocked;
        iArr[i3] = iArr[i3] | i4;
        return false;
    }

    private boolean checkTouchSlop(View view, float f3, float f4) {
        if (view == null) {
            return false;
        }
        boolean z3 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z4 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z3 || !z4) {
            return z3 ? Math.abs(f3) > ((float) this.mTouchSlop) : z4 && Math.abs(f4) > ((float) this.mTouchSlop);
        }
        float f5 = (f3 * f3) + (f4 * f4);
        int i3 = this.mTouchSlop;
        return f5 > ((float) (i3 * i3));
    }

    private int clampMag(int i3, int i4, int i5) {
        int abs = Math.abs(i3);
        if (abs < i4) {
            return 0;
        }
        return abs > i5 ? i3 > 0 ? i5 : -i5 : i3;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i3, int i4, int i5) {
        int abs;
        if (i3 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f3 = width / 2;
        float distanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i3) / width)) * f3);
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i3) / (i5 == 0 ? 1 : Math.abs(i5))) + 1.0f) * 256.0f);
        }
        return Math.min(abs, MAX_SETTLE_DURATION);
    }

    private int computeSettleDuration(View view, int i3, int i4, int i5, int i6) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int clampMag = clampMag(i5, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i6, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i4);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        if (i7 > 0) {
            if (clampMag != 0) {
                f7 = abs3;
                f8 = i7;
            } else {
                f7 = abs;
                f8 = i8;
            }
            f3 = f7 / f8;
            if (clampMag2 != 0) {
                f6 = abs4;
                f5 = i7;
            } else {
                f6 = abs2;
                f5 = i8;
            }
        } else {
            if (i8 <= 0) {
                f3 = 0.5f;
                f4 = 0.5f;
                return (int) ((computeAxisDuration(i3, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f3) + (computeAxisDuration(i4, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * f4));
            }
            f5 = i8;
            f3 = abs / f5;
            f6 = abs2;
        }
        f4 = f6 / f5;
        return (int) ((computeAxisDuration(i3, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f3) + (computeAxisDuration(i4, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * f4));
    }

    public static COUIViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new COUIViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f3, float f4) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f3, f4);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f3) {
        return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i3, int i4, int i5, int i6) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i5 != 0) {
            i3 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i3, i5);
            y.T(this.mCapturedView, i3 - left);
        }
        int i7 = i3;
        if (i6 != 0) {
            i4 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i4, i6);
            y.U(this.mCapturedView, i4 - top);
        }
        int i8 = i4;
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, i7, i8, i7 - left, i8 - top);
    }

    private void ensureMotionHistorySizeForId(int i3) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i3) {
            int i4 = i3 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i3, int i4, int i5, int i6) {
        int left = i3 - this.mCapturedView.getLeft();
        int top = i4 - this.mCapturedView.getTop();
        if (left == 0 && top == 0) {
            setDragState(0);
            return false;
        }
        computeSettleDuration(this.mCapturedView, left, top, i5, i6);
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i3, int i4) {
        int i5 = i3 < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i4 < this.mParentView.getTop() + this.mEdgeSize) {
            i5 |= 4;
        }
        if (i3 > this.mParentView.getRight() - this.mEdgeSize) {
            i5 |= 2;
        }
        return i4 > this.mParentView.getBottom() - this.mEdgeSize ? i5 | 8 : i5;
    }

    private boolean isValidPointerForActionMove(int i3) {
        if (isPointerDown(i3)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  COUIViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.coui.appcompat.panel.COUIViewDragHelper$Callback] */
    private void reportNewEdgeDrags(float f3, float f4, int i3) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f3, f4, i3, 1);
        boolean z3 = checkNewEdgeDrag;
        if (checkNewEdgeDrag(f4, f3, i3, 4)) {
            z3 = (checkNewEdgeDrag ? 1 : 0) | 4;
        }
        boolean z4 = z3;
        if (checkNewEdgeDrag(f3, f4, i3, 2)) {
            z4 = (z3 ? 1 : 0) | 2;
        }
        ?? r02 = z4;
        if (checkNewEdgeDrag(f4, f3, i3, 8)) {
            r02 = (z4 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i3] = iArr[i3] | r02;
            this.mCallback.onEdgeDragStarted(r02, i3);
        }
    }

    private void saveInitialMotion(float f3, float f4, int i3) {
        ensureMotionHistorySizeForId(i3);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i3] = f3;
        fArr[i3] = f3;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i3] = f4;
        fArr2[i3] = f4;
        this.mInitialEdgesTouched[i3] = getEdgesTouched((int) f3, (int) f4);
        this.mPointersDown |= 1 << i3;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (isValidPointerForActionMove(pointerId)) {
                float x3 = motionEvent.getX(i3);
                float y3 = motionEvent.getY(i3);
                this.mLastMotionX[pointerId] = x3;
                this.mLastMotionY[pointerId] = y3;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    protected boolean canScroll(View view, boolean z3, int i3, int i4, int i5, int i6) {
        int i7;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i5 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i7 = i6 + scrollY) >= childAt.getTop() && i7 < childAt.getBottom() && canScroll(childAt, true, i3, i4, i8 - childAt.getLeft(), i7 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z3 && (view.canScrollHorizontally(-i3) || view.canScrollVertically(-i4));
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int i3) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i3;
            this.mCallback.onViewCaptured(view, i3);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the COUIViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean z3) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                y.T(this.mCapturedView, left);
            }
            if (top != 0) {
                y.U(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z3) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    public View findTopChildUnder(int i3, int i4) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i3, int i4, int i5, int i6) {
        if (!this.mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i3, i5, i4, i6);
        setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i3, int i4) {
        return isViewUnder(this.mCapturedView, i3, i4);
    }

    public boolean isEdgeTouched(int i3) {
        int length = this.mInitialEdgesTouched.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (isEdgeTouched(i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i3) {
        return (this.mPointersDown & (1 << i3)) != 0;
    }

    public boolean isViewUnder(View view, int i3, int i4) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i4 >= view.getTop() && i4 < view.getBottom();
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x3, (int) y3);
            saveInitialMotion(x3, y3, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i5 = this.mInitialEdgesTouched[pointerId];
            int i6 = this.mTrackingEdges;
            if ((i5 & i6) != 0) {
                this.mCallback.onEdgeTouched(i5 & i6, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.mDragState == 1) {
                if (isValidPointerForActionMove(this.mActivePointerId)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x4 = motionEvent.getX(findPointerIndex);
                    float y4 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.mLastMotionX;
                    int i7 = this.mActivePointerId;
                    int i8 = (int) (x4 - fArr[i7]);
                    int i9 = (int) (y4 - this.mLastMotionY[i7]);
                    dragTo(this.mCapturedView.getLeft() + i8, this.mCapturedView.getTop() + i9, i8, i9);
                    saveLastMotion(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i4 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i4);
                if (isValidPointerForActionMove(pointerId2)) {
                    float x5 = motionEvent.getX(i4);
                    float y5 = motionEvent.getY(i4);
                    float f3 = x5 - this.mInitialMotionX[pointerId2];
                    float f4 = y5 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f3, f4, pointerId2);
                    if (this.mDragState != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x5, (int) y5);
                        if (checkTouchSlop(findTopChildUnder2, f3, f4) && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            saveLastMotion(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x6 = motionEvent.getX(actionIndex);
            float y6 = motionEvent.getY(actionIndex);
            saveInitialMotion(x6, y6, pointerId3);
            if (this.mDragState != 0) {
                if (isCapturedViewUnder((int) x6, (int) y6)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                }
                return;
            } else {
                tryCaptureViewForDrag(findTopChildUnder((int) x6, (int) y6), pointerId3);
                int i10 = this.mInitialEdgesTouched[pointerId3];
                int i11 = this.mTrackingEdges;
                if ((i10 & i11) != 0) {
                    this.mCallback.onEdgeTouched(i10 & i11, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i4 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i4);
                if (pointerId5 != this.mActivePointerId) {
                    View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                    View view = this.mCapturedView;
                    if (findTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                        i3 = this.mActivePointerId;
                        break;
                    }
                }
                i4++;
            }
            if (i3 == -1) {
                releaseViewForPointerUp();
            }
        }
        clearMotionHistory(pointerId4);
    }

    public void setCapturedView(View view) {
        this.mCapturedView = view;
    }

    void setDragState(int i3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i3) {
            this.mDragState = i3;
            this.mCallback.onViewDragStateChanged(i3);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(int i3) {
        this.mEdgeSize = i3;
    }

    public void setEdgeTrackingEnabled(int i3) {
        this.mTrackingEdges = i3;
    }

    public void setMinVelocity(float f3) {
        this.mMinVelocity = f3;
    }

    public boolean settleCapturedViewAt(int i3, int i4) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i3, i4, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i3, int i4) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i3, i4, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    boolean tryCaptureViewForDrag(View view, int i3) {
        if (view == this.mCapturedView && this.mActivePointerId == i3) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i3)) {
            return false;
        }
        this.mActivePointerId = i3;
        captureChildView(view, i3);
        return true;
    }

    private float clampMag(float f3, float f4, float f5) {
        float abs = Math.abs(f3);
        if (abs < f4) {
            return 0.0f;
        }
        return abs > f5 ? f3 > 0.0f ? f5 : -f5 : f3;
    }

    public static COUIViewDragHelper create(ViewGroup viewGroup, float f3, Callback callback) {
        COUIViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (create.mTouchSlop * (1.0f / f3));
        return create;
    }

    public boolean isEdgeTouched(int i3, int i4) {
        return isPointerDown(i4) && (this.mInitialEdgesTouched[i4] & i3) != 0;
    }

    public boolean checkTouchSlop(int i3) {
        int length = this.mInitialMotionX.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (checkTouchSlop(i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i3, int i4) {
        if (!isPointerDown(i4)) {
            return false;
        }
        boolean z3 = (i3 & 1) == 1;
        boolean z4 = (i3 & 2) == 2;
        float f3 = this.mLastMotionX[i4] - this.mInitialMotionX[i4];
        float f4 = this.mLastMotionY[i4] - this.mInitialMotionY[i4];
        if (!z3 || !z4) {
            return z3 ? Math.abs(f3) > ((float) this.mTouchSlop) : z4 && Math.abs(f4) > ((float) this.mTouchSlop);
        }
        float f5 = (f3 * f3) + (f4 * f4);
        int i5 = this.mTouchSlop;
        return f5 > ((float) (i5 * i5));
    }

    private void clearMotionHistory(int i3) {
        if (this.mInitialMotionX == null || !isPointerDown(i3)) {
            return;
        }
        this.mInitialMotionX[i3] = 0.0f;
        this.mInitialMotionY[i3] = 0.0f;
        this.mLastMotionX[i3] = 0.0f;
        this.mLastMotionY[i3] = 0.0f;
        this.mInitialEdgesTouched[i3] = 0;
        this.mEdgeDragsInProgress[i3] = 0;
        this.mEdgeDragsLocked[i3] = 0;
        this.mPointersDown = (~(1 << i3)) & this.mPointersDown;
    }
}
