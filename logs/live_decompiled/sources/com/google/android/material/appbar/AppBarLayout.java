package com.google.android.material.appbar;

import H0.c;
import H0.f;
import H0.i;
import H0.j;
import U0.h;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.J;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import androidx.core.view.o;
import androidx.core.view.y;
import f.AbstractC0348a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x.AbstractC0626a;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    private static final int DEF_STYLE_RES = i.f640e;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;
    private J lastInsets;
    private boolean liftOnScroll;
    private final List<LiftOnScrollListener> liftOnScrollListeners;
    private WeakReference<View> liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(T t3);
        }

        public BaseBehavior() {
        }

        private void addAccessibilityScrollActions(final CoordinatorLayout coordinatorLayout, final T t3, final View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t3.getTotalScrollRange()) && view.canScrollVertically(1)) {
                addActionToExpand(coordinatorLayout, t3, d.a.f5093q, false);
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (!view.canScrollVertically(-1)) {
                    addActionToExpand(coordinatorLayout, t3, d.a.f5094r, true);
                    return;
                }
                final int i3 = -t3.getDownNestedPreScrollRange();
                if (i3 != 0) {
                    y.e0(coordinatorLayout, d.a.f5094r, null, new g() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.core.view.accessibility.g
                        public boolean perform(View view2, g.a aVar) {
                            BaseBehavior.this.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) t3, view, 0, i3, new int[]{0, 0}, 1);
                            return true;
                        }
                    });
                }
            }
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, final T t3, d.a aVar, final boolean z3) {
            y.e0(coordinatorLayout, aVar, null, new g() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                @Override // androidx.core.view.accessibility.g
                public boolean perform(View view, g.a aVar2) {
                    t3.setExpanded(z3);
                    return true;
                }
            });
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, T t3, int i3, float f3) {
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i3);
            float abs2 = Math.abs(f3);
            animateOffsetWithDuration(coordinatorLayout, t3, i3, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / t3.getHeight()) + 1.0f) * 150.0f));
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t3, int i3, int i4) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i3) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.offsetAnimator.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(I0.a.f918e);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t3, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration(Math.min(i4, MAX_OFFSET_ANIMATION_DURATION));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i3);
            this.offsetAnimator.start();
        }

        private int calculateSnapOffset(int i3, int i4, int i5) {
            return i3 < (i4 + i5) / 2 ? i4 : i5;
        }

        private boolean canScrollChildren(CoordinatorLayout coordinatorLayout, T t3, View view) {
            return t3.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t3.getHeight();
        }

        private static boolean checkFlag(int i3, int i4) {
            return (i3 & i4) == i4;
        }

        private View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof o) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i3) {
            int abs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int getChildIndexOnOffset(T t3, int i3) {
            int childCount = t3.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t3.getChildAt(i4);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i5 = -i3;
                if (top <= i5 && bottom >= i5) {
                    return i4;
                }
            }
            return -1;
        }

        private int interpolateOffset(T t3, int i3) {
            int abs = Math.abs(i3);
            int childCount = t3.getChildCount();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    break;
                }
                View childAt = t3.getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i5++;
                } else if (scrollInterpolator != null) {
                    int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 1) != 0) {
                        i4 = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((scrollFlags & 2) != 0) {
                            i4 -= y.z(childAt);
                        }
                    }
                    if (y.u(childAt)) {
                        i4 -= t3.getTopInset();
                    }
                    if (i4 > 0) {
                        float f3 = i4;
                        return Integer.signum(i3) * (childAt.getTop() + Math.round(f3 * scrollInterpolator.getInterpolation((abs - childAt.getTop()) / f3)));
                    }
                }
            }
            return i3;
        }

        private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, T t3) {
            List s3 = coordinatorLayout.s(t3);
            int size = s3.size();
            for (int i3 = 0; i3 < size; i3++) {
                CoordinatorLayout.c e3 = ((CoordinatorLayout.f) ((View) s3.get(i3)).getLayoutParams()).e();
                if (e3 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) e3).getOverlayTop() != 0;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, T t3) {
            int topInset = t3.getTopInset() + t3.getPaddingTop();
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling() - topInset;
            int childIndexOnOffset = getChildIndexOnOffset(t3, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = t3.getChildAt(childIndexOnOffset);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i3 = -childAt.getTop();
                    int i4 = -childAt.getBottom();
                    if (childIndexOnOffset == 0 && y.u(t3) && y.u(childAt)) {
                        i3 -= t3.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i4 += y.z(childAt);
                    } else if (checkFlag(scrollFlags, 5)) {
                        int z3 = y.z(childAt) + i4;
                        if (topBottomOffsetForScrollingSibling < z3) {
                            i3 = z3;
                        } else {
                            i4 = z3;
                        }
                    }
                    if (checkFlag(scrollFlags, 32)) {
                        i3 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i4 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    animateOffsetTo(coordinatorLayout, t3, AbstractC0626a.b(calculateSnapOffset(topBottomOffsetForScrollingSibling, i4, i3) + topInset, -t3.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, T t3) {
            y.c0(coordinatorLayout, d.a.f5093q.b());
            y.c0(coordinatorLayout, d.a.f5094r.b());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild == null || t3.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) findFirstScrollingChild.getLayoutParams()).e() instanceof ScrollingViewBehavior)) {
                return;
            }
            addAccessibilityScrollActions(coordinatorLayout, t3, findFirstScrollingChild);
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4, boolean z3) {
            View appBarChildOnOffset = getAppBarChildOnOffset(t3, i3);
            boolean z4 = false;
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int z5 = y.z(appBarChildOnOffset);
                    if (i4 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i3) < (appBarChildOnOffset.getBottom() - z5) - t3.getTopInset()) : (-i3) >= (appBarChildOnOffset.getBottom() - z5) - t3.getTopInset()) {
                        z4 = true;
                    }
                }
            }
            if (t3.isLiftOnScroll()) {
                z4 = t3.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t3.setLiftedState(z4);
            if (z3 || (liftedState && shouldJumpElevationState(coordinatorLayout, t3))) {
                t3.jumpDrawablesToCurrentState();
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        void restoreScrollState(SavedState savedState, boolean z3) {
            if (this.savedState == null || z3) {
                this.savedState = savedState;
            }
        }

        SavedState saveScrollState(Parcelable parcelable, T t3) {
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t3.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t3.getChildAt(i3);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbstractC0645a.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z3 = topAndBottomOffset == 0;
                    savedState.fullyExpanded = z3;
                    savedState.fullyScrolled = !z3 && (-topAndBottomOffset) >= t3.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i3;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == y.z(childAt) + t3.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public void setDragCallback(BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(T t3) {
            BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t3);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getMaxDragOffset(T t3) {
            return -t3.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getScrollRangeForDragFling(T t3) {
            return t3.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public void onFlingFinished(CoordinatorLayout coordinatorLayout, T t3) {
            snapToChildIfNeeded(coordinatorLayout, t3);
            if (t3.isLiftOnScroll()) {
                t3.setLiftedState(t3.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t3, int i3) {
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) t3, i3);
            int pendingAction = t3.getPendingAction();
            SavedState savedState = this.savedState;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z3 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i4 = -t3.getUpNestedPreScrollRange();
                        if (z3) {
                            animateOffsetTo(coordinatorLayout, t3, i4, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t3, i4);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z3) {
                            animateOffsetTo(coordinatorLayout, t3, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t3, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                setHeaderTopBottomOffset(coordinatorLayout, t3, -t3.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                setHeaderTopBottomOffset(coordinatorLayout, t3, 0);
            } else {
                View childAt = t3.getChildAt(savedState.firstVisibleChildIndex);
                setHeaderTopBottomOffset(coordinatorLayout, t3, (-childAt.getBottom()) + (this.savedState.firstVisibleChildAtMinimumHeight ? y.z(childAt) + t3.getTopInset() : Math.round(childAt.getHeight() * this.savedState.firstVisibleChildPercentageShown)));
            }
            t3.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(AbstractC0626a.b(getTopAndBottomOffset(), -t3.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, t3, getTopAndBottomOffset(), 0, true);
            t3.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout, t3);
            return onLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4, int i5, int i6) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t3.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, (View) t3, i3, i4, i5, i6);
            }
            coordinatorLayout.J(t3, i3, i4, View.MeasureSpec.makeMeasureSpec(0, 0), i6);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t3, View view, int i3, int i4, int[] iArr, int i5) {
            int i6;
            int i7;
            if (i4 != 0) {
                if (i4 < 0) {
                    i6 = -t3.getTotalScrollRange();
                    i7 = t3.getDownNestedPreScrollRange() + i6;
                } else {
                    i6 = -t3.getUpNestedPreScrollRange();
                    i7 = 0;
                }
                int i8 = i6;
                int i9 = i7;
                if (i8 != i9) {
                    iArr[1] = scroll(coordinatorLayout, t3, i4, i8, i9);
                }
            }
            if (t3.isLiftOnScroll()) {
                t3.setLiftedState(t3.shouldLift(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t3, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            if (i6 < 0) {
                iArr[1] = scroll(coordinatorLayout, t3, i6, -t3.getDownNestedScrollRange(), 0);
            }
            if (i6 == 0) {
                updateAccessibilityActions(coordinatorLayout, t3);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t3, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                restoreScrollState((SavedState) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, (View) t3, this.savedState.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, (View) t3, parcelable);
                this.savedState = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t3) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (View) t3);
            SavedState saveScrollState = saveScrollState(onSaveInstanceState, t3);
            return saveScrollState == null ? onSaveInstanceState : saveScrollState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t3, View view, View view2, int i3, int i4) {
            ValueAnimator valueAnimator;
            boolean z3 = (i3 & 2) != 0 && (t3.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t3, view));
            if (z3 && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i4;
            return z3;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t3, View view, int i3) {
            if (this.lastStartedType == 0 || i3 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t3);
                if (t3.isLiftOnScroll()) {
                    t3.setLiftedState(t3.shouldLift(view));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4, int i5) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i6 = 0;
            if (i4 == 0 || topBottomOffsetForScrollingSibling < i4 || topBottomOffsetForScrollingSibling > i5) {
                this.offsetDelta = 0;
            } else {
                int b3 = AbstractC0626a.b(i3, i4, i5);
                if (topBottomOffsetForScrollingSibling != b3) {
                    int interpolateOffset = t3.hasChildWithInterpolator() ? interpolateOffset(t3, b3) : b3;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    int i7 = topBottomOffsetForScrollingSibling - b3;
                    this.offsetDelta = b3 - interpolateOffset;
                    if (topAndBottomOffset) {
                        while (i6 < t3.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t3.getChildAt(i6).getLayoutParams();
                            ChildScrollEffect scrollEffect = layoutParams.getScrollEffect();
                            if (scrollEffect != null && (layoutParams.getScrollFlags() & 1) != 0) {
                                scrollEffect.onOffsetChanged(t3, t3.getChildAt(i6), getTopAndBottomOffset());
                            }
                            i6++;
                        }
                    }
                    if (!topAndBottomOffset && t3.hasChildWithInterpolator()) {
                        coordinatorLayout.f(t3);
                    }
                    t3.onOffsetChanged(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, t3, b3, b3 < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    i6 = i7;
                }
            }
            updateAccessibilityActions(coordinatorLayout, t3);
            return i6;
        }

        protected static class SavedState extends AbstractC0645a {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i3) {
                    return new SavedState[i3];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // z.AbstractC0645a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t3, int i3);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5, int i6) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int[] iArr, int i5) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i3, i4, iArr, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i3, i4, i5, i6, i7, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z3) {
            super.setHorizontalOffsetEnabled(z3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i3) {
            return super.setLeftAndRightOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z3) {
            super.setVerticalOffsetEnabled(z3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(AppBarLayout appBarLayout, View view, float f3);
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect relativeRect = new Rect();
        private final Rect ghostRect = new Rect();

        private static void updateRelativeRect(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(AppBarLayout appBarLayout, View view, float f3) {
            updateRelativeRect(this.relativeRect, appBarLayout, view);
            float abs = this.relativeRect.top - Math.abs(f3);
            if (abs > 0.0f) {
                y.q0(view, null);
                view.setTranslationY(0.0f);
                return;
            }
            float a3 = 1.0f - AbstractC0626a.a(Math.abs(abs / this.relativeRect.height()), 0.0f, 1.0f);
            float height = (-abs) - ((this.relativeRect.height() * COMPRESS_DISTANCE_FACTOR) * (1.0f - (a3 * a3)));
            view.setTranslationY(height);
            view.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-height));
            y.q0(view, this.ghostRect);
        }
    }

    public interface LiftOnScrollListener {
        void onUpdate(float f3, int i3);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout appBarLayout, int i3);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            CoordinatorLayout.c e3 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).e();
            if (e3 instanceof BaseBehavior) {
                return ((BaseBehavior) e3).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.c e3 = ((CoordinatorLayout.f) view2.getLayoutParams()).e();
            if (e3 instanceof BaseBehavior) {
                y.U(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) e3).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            int i3;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i3 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i3) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                y.c0(coordinatorLayout, d.a.f5093q.b());
                y.c0(coordinatorLayout, d.a.f5094r.b());
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return super.onMeasureChild(coordinatorLayout, view, i3, i4, i5, i6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z3) {
            AppBarLayout findFirstDependency = findFirstDependency((List<View>) coordinatorLayout.r(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z3);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z3) {
            super.setHorizontalOffsetEnabled(z3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i3) {
            return super.setLeftAndRightOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z3) {
            super.setVerticalOffsetEnabled(z3);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.D4);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(j.E4, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    private View findLiftOnScrollTargetView(View view) {
        int i3;
        if (this.liftOnScrollTargetView == null && (i3 = this.liftOnScrollTargetViewId) != -1) {
            View findViewById = view != null ? view.findViewById(i3) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (findViewById != null) {
                this.liftOnScrollTargetView = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((LayoutParams) getChildAt(i3).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void invalidateScrollRanges() {
        Behavior behavior = this.behavior;
        BaseBehavior.SavedState saveScrollState = (behavior == null || this.totalScrollRange == -1 || this.pendingAction != 0) ? null : behavior.saveScrollState(AbstractC0645a.EMPTY_STATE, this);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (saveScrollState != null) {
            this.behavior.restoreScrollState(saveScrollState, false);
        }
    }

    private boolean setLiftableState(boolean z3) {
        if (this.liftable == z3) {
            return false;
        }
        this.liftable = z3;
        refreshDrawableState();
        return true;
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || y.u(childAt)) ? false : true;
    }

    private void startLiftOnScrollElevationOverlayAnimation(final U0.g gVar, boolean z3) {
        float dimension = getResources().getDimension(c.f518a);
        float f3 = z3 ? 0.0f : dimension;
        if (!z3) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.elevationOverlayAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, dimension);
        this.elevationOverlayAnimator = ofFloat;
        ofFloat.setDuration(getResources().getInteger(f.f594a));
        this.elevationOverlayAnimator.setInterpolator(I0.a.f914a);
        this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                gVar.T(floatValue);
                if (AppBarLayout.this.statusBarForeground instanceof U0.g) {
                    ((U0.g) AppBarLayout.this.statusBarForeground).T(floatValue);
                }
                Iterator it = AppBarLayout.this.liftOnScrollListeners.iterator();
                while (it.hasNext()) {
                    ((LiftOnScrollListener) it.next()).onUpdate(floatValue, gVar.y());
                }
            }
        });
        this.elevationOverlayAnimator.start();
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(LiftOnScrollListener liftOnScrollListener) {
        this.liftOnScrollListeners.add(liftOnScrollListener);
    }

    public void addOnOffsetChangedListener(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (baseOnOffsetChangedListener == null || this.listeners.contains(baseOnOffsetChangedListener)) {
            return;
        }
        this.listeners.add(baseOnOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.currentOffset);
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.behavior = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int i3;
        int z3;
        int i4 = this.downPreScrollRange;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i6 = layoutParams.scrollFlags;
            if ((i6 & 5) != 5) {
                if (i5 > 0) {
                    break;
                }
            } else {
                int i7 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i6 & 8) != 0) {
                    z3 = y.z(childAt);
                } else if ((i6 & 2) != 0) {
                    z3 = measuredHeight - y.z(childAt);
                } else {
                    i3 = i7 + measuredHeight;
                    if (childCount == 0 && y.u(childAt)) {
                        i3 = Math.min(i3, measuredHeight - getTopInset());
                    }
                    i5 += i3;
                }
                i3 = i7 + z3;
                if (childCount == 0) {
                    i3 = Math.min(i3, measuredHeight - getTopInset());
                }
                i5 += i3;
            }
        }
        int max = Math.max(0, i5);
        this.downPreScrollRange = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i3 = this.downScrollRange;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i6 = layoutParams.scrollFlags;
            if ((i6 & 1) == 0) {
                break;
            }
            i5 += measuredHeight;
            if ((i6 & 2) != 0) {
                i5 -= y.z(childAt);
                break;
            }
            i4++;
        }
        int max = Math.max(0, i5);
        this.downScrollRange = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int z3 = y.z(this);
        if (z3 == 0) {
            int childCount = getChildCount();
            z3 = childCount >= 1 ? y.z(getChildAt(childCount - 1)) : 0;
            if (z3 == 0) {
                return getHeight() / 3;
            }
        }
        return (z3 * 2) + topInset;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        J j3 = this.lastInsets;
        if (j3 != null) {
            return j3.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i3 = this.totalScrollRange;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i6 = layoutParams.scrollFlags;
            if ((i6 & 1) == 0) {
                break;
            }
            i5 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i4 == 0 && y.u(childAt)) {
                i5 -= getTopInset();
            }
            if ((i6 & 2) != 0) {
                i5 -= y.z(childAt);
                break;
            }
            i4++;
        }
        int max = Math.max(0, i5);
        this.totalScrollRange = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        boolean z3 = this.liftable;
        int i4 = H0.a.f463D;
        if (!z3) {
            i4 = -i4;
        }
        iArr[0] = i4;
        iArr[1] = (z3 && this.lifted) ? H0.a.f464E : -H0.a.f464E;
        int i5 = H0.a.f462C;
        if (!z3) {
            i5 = -i5;
        }
        iArr[2] = i5;
        iArr[3] = (z3 && this.lifted) ? H0.a.f461B : -H0.a.f461B;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        boolean z4 = true;
        if (y.u(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                y.U(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i7 = 0;
        while (true) {
            if (i7 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i7).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
            i7++;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.liftableOverride) {
            return;
        }
        if (!this.liftOnScroll && !hasCollapsibleChild()) {
            z4 = false;
        }
        setLiftableState(z4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != 1073741824 && y.u(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = AbstractC0626a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i4));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    void onOffsetChanged(int i3) {
        this.currentOffset = i3;
        if (!willNotDraw()) {
            y.Z(this);
        }
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i4);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i3);
                }
            }
        }
    }

    J onWindowInsetChanged(J j3) {
        J j4 = y.u(this) ? j3 : null;
        if (!androidx.core.util.c.a(this.lastInsets, j4)) {
            this.lastInsets = j4;
            updateWillNotDraw();
            requestLayout();
        }
        return j3;
    }

    public boolean removeLiftOnScrollListener(LiftOnScrollListener liftOnScrollListener) {
        return this.liftOnScrollListeners.remove(liftOnScrollListener);
    }

    public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        h.d(this, f3);
    }

    public void setExpanded(boolean z3) {
        setExpanded(z3, y.O(this));
    }

    public void setLiftOnScroll(boolean z3) {
        this.liftOnScroll = z3;
    }

    public void setLiftOnScrollTargetViewId(int i3) {
        this.liftOnScrollTargetViewId = i3;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean z3) {
        this.liftableOverride = true;
        return setLiftableState(z3);
    }

    public void setLiftableOverrideEnabled(boolean z3) {
        this.liftableOverride = z3;
    }

    public boolean setLifted(boolean z3) {
        return setLiftedState(z3, true);
    }

    boolean setLiftedState(boolean z3) {
        return setLiftedState(z3, !this.liftableOverride);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i3);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.statusBarForeground = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.g(this.statusBarForeground, y.x(this));
                this.statusBarForeground.setVisible(getVisibility() == 0, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            y.Z(this);
        }
    }

    public void setStatusBarForegroundColor(int i3) {
        setStatusBarForeground(new ColorDrawable(i3));
    }

    public void setStatusBarForegroundResource(int i3) {
        setStatusBarForeground(AbstractC0348a.b(getContext(), i3));
    }

    @Deprecated
    public void setTargetElevation(float f3) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f3);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
    }

    boolean shouldLift(View view) {
        View findLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (findLiftOnScrollTargetView != null) {
            view = findLiftOnScrollTargetView;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f469a);
    }

    public void setExpanded(boolean z3, boolean z4) {
        setExpanded(z3, z4, true);
    }

    boolean setLiftedState(boolean z3, boolean z4) {
        if (!z4 || this.lifted == z3) {
            return false;
        }
        this.lifted = z3;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof U0.g)) {
            return true;
        }
        startLiftOnScrollElevationOverlayAnimation((U0.g) getBackground(), z3);
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppBarLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.DEF_STYLE_RES
            android.content.Context r9 = V0.a.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            r9 = -1
            r8.totalScrollRange = r9
            r8.downPreScrollRange = r9
            r8.downScrollRange = r9
            r6 = 0
            r8.pendingAction = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8.liftOnScrollListeners = r0
            android.content.Context r7 = r8.getContext()
            r0 = 1
            r8.setOrientation(r0)
            android.view.ViewOutlineProvider r0 = r8.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L2d
            com.google.android.material.appbar.ViewUtilsLollipop.setBoundsViewOutlineProvider(r8)
        L2d:
            com.google.android.material.appbar.ViewUtilsLollipop.setStateListAnimatorFromAttrs(r8, r10, r11, r4)
            int[] r2 = H0.j.f799k
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r11 = H0.j.f803l
            android.graphics.drawable.Drawable r11 = r10.getDrawable(r11)
            androidx.core.view.y.n0(r8, r11)
            android.graphics.drawable.Drawable r11 = r8.getBackground()
            boolean r11 = r11 instanceof android.graphics.drawable.ColorDrawable
            if (r11 == 0) goto L68
            android.graphics.drawable.Drawable r11 = r8.getBackground()
            android.graphics.drawable.ColorDrawable r11 = (android.graphics.drawable.ColorDrawable) r11
            U0.g r0 = new U0.g
            r0.<init>()
            int r11 = r11.getColor()
            android.content.res.ColorStateList r11 = android.content.res.ColorStateList.valueOf(r11)
            r0.U(r11)
            r0.K(r7)
            androidx.core.view.y.n0(r8, r0)
        L68:
            int r11 = H0.j.f819p
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto L79
            int r11 = H0.j.f819p
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setExpanded(r11, r6, r6)
        L79:
            int r11 = H0.j.f815o
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto L8b
            int r11 = H0.j.f815o
            int r11 = r10.getDimensionPixelSize(r11, r6)
            float r11 = (float) r11
            com.google.android.material.appbar.ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(r8, r11)
        L8b:
            int r11 = H0.j.f811n
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto L9c
            int r11 = H0.j.f811n
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setKeyboardNavigationCluster(r11)
        L9c:
            int r11 = H0.j.f807m
            boolean r11 = r10.hasValue(r11)
            if (r11 == 0) goto Lad
            int r11 = H0.j.f807m
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setTouchscreenBlocksFocus(r11)
        Lad:
            int r11 = H0.j.f823q
            boolean r11 = r10.getBoolean(r11, r6)
            r8.liftOnScroll = r11
            int r11 = H0.j.f827r
            int r9 = r10.getResourceId(r11, r9)
            r8.liftOnScrollTargetViewId = r9
            int r9 = H0.j.f831s
            android.graphics.drawable.Drawable r9 = r10.getDrawable(r9)
            r8.setStatusBarForeground(r9)
            r10.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r9 = new com.google.android.material.appbar.AppBarLayout$1
            r9.<init>()
            androidx.core.view.y.x0(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setExpanded(boolean z3, boolean z4, boolean z5) {
        this.pendingAction = (z3 ? 1 : 2) | (z4 ? 4 : 0) | (z5 ? 8 : 0);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        private static final int SCROLL_EFFECT_COMPRESS = 1;
        private static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f839u);
            this.scrollFlags = obtainStyledAttributes.getInt(j.f847w, 0);
            setScrollEffect(createScrollEffectFromInt(obtainStyledAttributes.getInt(j.f843v, 0)));
            if (obtainStyledAttributes.hasValue(j.f851x)) {
                this.scrollInterpolator = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(j.f851x, 0));
            }
            obtainStyledAttributes.recycle();
        }

        private ChildScrollEffect createScrollEffectFromInt(int i3) {
            if (i3 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int i3 = this.scrollFlags;
            return (i3 & 1) == 1 && (i3 & 10) != 0;
        }

        public void setScrollEffect(ChildScrollEffect childScrollEffect) {
            this.scrollEffect = childScrollEffect;
        }

        public void setScrollFlags(int i3) {
            this.scrollFlags = i3;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.scrollFlags = 1;
        }

        public LayoutParams(int i3, int i4, float f3) {
            super(i3, i4, f3);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.scrollFlags = 1;
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }
}
