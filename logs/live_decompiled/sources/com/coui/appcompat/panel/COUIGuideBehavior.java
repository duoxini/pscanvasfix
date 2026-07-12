package com.coui.appcompat.panel;

import A.c;
import H0.i;
import H0.j;
import U0.g;
import U0.k;
import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import androidx.core.view.y;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import x.AbstractC0626a;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class COUIGuideBehavior<V extends View> extends BottomSheetBehavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = i.f641f;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    private static final int VERTICAL_SLIDING_PARAMETER_THRESHOLD = 2;
    int activePointerId;
    private final ArrayList<COUIBottomSheetCallback> callbacks;
    int collapsedOffset;
    private final c.AbstractC0002c dragCallback;
    private boolean draggable;
    float elevation;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialX;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    COUIPanelDragListener mCOUIPanelDragListener;
    private boolean mCanHideKeyboard;
    private boolean mIsIgnoreExpandedOffsetChange;
    private COUIPanelPullUpListener mPullUpListener;
    private g materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private COUIGuideBehavior<V>.SettleRunnable settleRunnable;
    private k shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    A.c viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class COUIBottomSheetCallback {
        public abstract void onSlide(View view, float f3);

        public abstract void onStateChanged(View view, int i3);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    protected static class SavedState extends AbstractC0645a {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.SavedState.1
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
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, COUIGuideBehavior<?> cOUIGuideBehavior) {
            super(parcelable);
            this.state = cOUIGuideBehavior.state;
            this.peekHeight = ((COUIGuideBehavior) cOUIGuideBehavior).peekHeight;
            this.fitToContents = ((COUIGuideBehavior) cOUIGuideBehavior).fitToContents;
            this.hideable = cOUIGuideBehavior.hideable;
            this.skipCollapsed = ((COUIGuideBehavior) cOUIGuideBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i3) {
            super(parcelable);
            this.state = i3;
        }
    }

    private class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        private final View view;

        SettleRunnable(View view, int i3) {
            this.view = view;
            this.targetState = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            A.c cVar = COUIGuideBehavior.this.viewDragHelper;
            if (cVar == null || !cVar.k(true)) {
                COUIGuideBehavior.this.setStateInternal(this.targetState);
            } else {
                y.a0(this.view, this);
            }
            this.isPosted = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public COUIGuideBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new c.AbstractC0002c() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.3
            private boolean releasedLow(View view) {
                int top = view.getTop();
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                return top > (cOUIGuideBehavior.parentHeight + cOUIGuideBehavior.getExpandedOffset()) / 2;
            }

            @Override // A.c.AbstractC0002c
            public int clampViewPositionHorizontal(View view, int i3, int i4) {
                return view.getLeft();
            }

            @Override // A.c.AbstractC0002c
            public int clampViewPositionVertical(View view, int i3, int i4) {
                int i5;
                int i6;
                if (COUIGuideBehavior.this.mPullUpListener == null || ((i6 = COUIGuideBehavior.this.state) != 3 && (i6 != 1 || view.getTop() > COUIGuideBehavior.this.getExpandedOffset()))) {
                    i5 = 0;
                } else {
                    COUIGuideBehavior.this.mIsIgnoreExpandedOffsetChange = true;
                    i5 = COUIGuideBehavior.this.mPullUpListener.onDragging(i4, COUIGuideBehavior.this.getExpandedOffset());
                }
                int expandedOffset = COUIGuideBehavior.this.getExpandedOffset() - i5;
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                return AbstractC0626a.b(i3, expandedOffset, cOUIGuideBehavior.hideable ? cOUIGuideBehavior.parentHeight : cOUIGuideBehavior.collapsedOffset);
            }

            @Override // A.c.AbstractC0002c
            public int getViewVerticalDragRange(View view) {
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                return cOUIGuideBehavior.hideable ? cOUIGuideBehavior.parentHeight : cOUIGuideBehavior.collapsedOffset;
            }

            @Override // A.c.AbstractC0002c
            public void onViewDragStateChanged(int i3) {
                if (i3 == 1 && COUIGuideBehavior.this.draggable) {
                    COUIGuideBehavior.this.setStateInternal(1);
                }
            }

            @Override // A.c.AbstractC0002c
            public void onViewPositionChanged(View view, int i3, int i4, int i5, int i6) {
                COUIGuideBehavior.this.dispatchOnSlide(i4);
            }

            @Override // A.c.AbstractC0002c
            public void onViewReleased(View view, float f3, float f4) {
                int i3;
                if (COUIGuideBehavior.this.mPullUpListener != null && COUIGuideBehavior.this.parentHeight - view.getHeight() < COUIGuideBehavior.this.getExpandedOffset() && view.getTop() < COUIGuideBehavior.this.getExpandedOffset()) {
                    COUIGuideBehavior.this.mPullUpListener.onReleased(COUIGuideBehavior.this.getExpandedOffset());
                    return;
                }
                int i4 = 6;
                if (f4 < 0.0f) {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i3 = COUIGuideBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                        int i5 = cOUIGuideBehavior.halfExpandedOffset;
                        if (top > i5) {
                            i3 = i5;
                            COUIGuideBehavior.this.startSettlingAnimation(view, i4, i3, true);
                        }
                        i3 = cOUIGuideBehavior.expandedOffset;
                    }
                    i4 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i4, i3, true);
                }
                COUIGuideBehavior cOUIGuideBehavior2 = COUIGuideBehavior.this;
                if (cOUIGuideBehavior2.hideable && cOUIGuideBehavior2.shouldHide(view, f4)) {
                    COUIPanelDragListener cOUIPanelDragListener = COUIGuideBehavior.this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener == null || !cOUIPanelDragListener.onDragWhileEditing()) {
                        if ((Math.abs(f3) < Math.abs(f4) && f4 > 500.0f) || releasedLow(view)) {
                            COUIGuideBehavior cOUIGuideBehavior3 = COUIGuideBehavior.this;
                            int i6 = cOUIGuideBehavior3.parentHeight;
                            cOUIGuideBehavior3.mCanHideKeyboard = true;
                            i4 = 5;
                            i3 = i6;
                        } else if (COUIGuideBehavior.this.fitToContents) {
                            i3 = COUIGuideBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - COUIGuideBehavior.this.expandedOffset) < Math.abs(view.getTop() - COUIGuideBehavior.this.halfExpandedOffset)) {
                            i3 = COUIGuideBehavior.this.expandedOffset;
                        } else {
                            i3 = COUIGuideBehavior.this.halfExpandedOffset;
                        }
                        COUIGuideBehavior.this.startSettlingAnimation(view, i4, i3, true);
                    }
                    COUIGuideBehavior cOUIGuideBehavior4 = COUIGuideBehavior.this;
                    int i7 = cOUIGuideBehavior4.fitToContentsOffset;
                    cOUIGuideBehavior4.mCanHideKeyboard = false;
                    i3 = i7;
                    i4 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i4, i3, true);
                }
                if (f4 == 0.0f || Math.abs(f3) > Math.abs(f4)) {
                    int top2 = view.getTop();
                    if (!COUIGuideBehavior.this.fitToContents) {
                        COUIGuideBehavior cOUIGuideBehavior5 = COUIGuideBehavior.this;
                        int i8 = cOUIGuideBehavior5.halfExpandedOffset;
                        if (top2 < i8) {
                            if (top2 < Math.abs(top2 - cOUIGuideBehavior5.collapsedOffset)) {
                                i3 = COUIGuideBehavior.this.expandedOffset;
                                i4 = 3;
                            } else {
                                i3 = COUIGuideBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - i8) < Math.abs(top2 - COUIGuideBehavior.this.collapsedOffset)) {
                            i3 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i3 = COUIGuideBehavior.this.collapsedOffset;
                            i4 = 4;
                        }
                    } else if (Math.abs(top2 - COUIGuideBehavior.this.fitToContentsOffset) < Math.abs(top2 - COUIGuideBehavior.this.collapsedOffset)) {
                        i3 = COUIGuideBehavior.this.fitToContentsOffset;
                        i4 = 3;
                    } else {
                        i3 = COUIGuideBehavior.this.collapsedOffset;
                        i4 = 4;
                    }
                } else {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i3 = COUIGuideBehavior.this.collapsedOffset;
                    } else {
                        int top3 = view.getTop();
                        if (Math.abs(top3 - COUIGuideBehavior.this.halfExpandedOffset) < Math.abs(top3 - COUIGuideBehavior.this.collapsedOffset)) {
                            i3 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i3 = COUIGuideBehavior.this.collapsedOffset;
                        }
                    }
                    i4 = 4;
                }
                COUIGuideBehavior.this.startSettlingAnimation(view, i4, i3, true);
            }

            @Override // A.c.AbstractC0002c
            public boolean tryCaptureView(View view, int i3) {
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                int i4 = cOUIGuideBehavior.state;
                if (i4 == 1 || cOUIGuideBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i4 == 3 && cOUIGuideBehavior.activePointerId == i3) {
                    WeakReference<View> weakReference = cOUIGuideBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = COUIGuideBehavior.this.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
    }

    private void addAccessibilityActionForState(V v3, d.a aVar, final int i3) {
        y.e0(v3, aVar, null, new androidx.core.view.accessibility.g() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.4
            @Override // androidx.core.view.accessibility.g
            public boolean perform(View view, g.a aVar2) {
                COUIGuideBehavior.this.setState(i3);
                return true;
            }
        });
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        return this.peekHeightAuto ? Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)) : this.peekHeight;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z3) {
        createMaterialShapeDrawable(context, attributeSet, z3, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIGuideBehavior.this.materialShapeDrawable != null) {
                    COUIGuideBehavior.this.materialShapeDrawable.V(floatValue);
                }
            }
        });
    }

    public static <V extends View> COUIGuideBehavior<V> from(V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c e3 = ((CoordinatorLayout.f) layoutParams).e();
        if (e3 instanceof BottomSheetBehavior) {
            return (COUIGuideBehavior) e3;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i3 = this.saveFlags;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setPanelPeekHeight(int i3, boolean z3) {
        V v3;
        if (i3 == -1) {
            if (this.peekHeightAuto) {
                return;
            } else {
                this.peekHeightAuto = true;
            }
        } else {
            if (!this.peekHeightAuto && this.peekHeight == i3) {
                return;
            }
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i3);
        }
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (v3 = this.viewRef.get()) == null) {
                return;
            }
            if (z3) {
                settleToStatePendingLayout(this.state);
            } else {
                v3.requestLayout();
            }
        }
    }

    private void setSystemGestureInsets(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (isGestureInsetBottomIgnored() || (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) == null) {
            return;
        }
        this.peekHeight += rootWindowInsets.getSystemGestureInsets().bottom;
    }

    private void settleToStatePendingLayout(final int i3) {
        final V v3 = this.viewRef.get();
        if (v3 == null) {
            return;
        }
        ViewParent parent = v3.getParent();
        if (parent != null && parent.isLayoutRequested() && y.N(v3)) {
            v3.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    COUIGuideBehavior.this.settleToState(v3, i3);
                }
            });
        } else {
            settleToState(v3, i3);
        }
    }

    private void updateAccessibilityActions() {
        V v3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        y.c0(v3, 524288);
        y.c0(v3, 262144);
        y.c0(v3, 1048576);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState(v3, d.a.f5101y, 5);
        }
        int i3 = this.state;
        if (i3 == 3) {
            addAccessibilityActionForState(v3, d.a.f5100x, this.fitToContents ? 4 : 6);
            return;
        }
        if (i3 == 4) {
            addAccessibilityActionForState(v3, d.a.f5099w, this.fitToContents ? 3 : 6);
        } else {
            if (i3 != 6) {
                return;
            }
            addAccessibilityActionForState(v3, d.a.f5100x, 4);
            addAccessibilityActionForState(v3, d.a.f5099w, 3);
        }
    }

    private void updateDrawableForTargetState(int i3) {
        ValueAnimator valueAnimator;
        if (i3 == 2) {
            return;
        }
        boolean z3 = i3 == 3;
        if (this.isShapeExpanded != z3) {
            this.isShapeExpanded = z3;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            }
            float f3 = z3 ? 0.0f : 1.0f;
            this.interpolatorAnimator.setFloatValues(1.0f - f3, f3);
            this.interpolatorAnimator.start();
        }
    }

    private void updateImportantForAccessibility(boolean z3) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z3) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.viewRef.get()) {
                    if (z3) {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            y.u0(childAt, 4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        y.u0(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (z3) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    public void addBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        if (this.callbacks.contains(cOUIBottomSheetCallback)) {
            return;
        }
        this.callbacks.add(cOUIBottomSheetCallback);
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int i3) {
        float f3;
        float f4;
        V v3 = this.viewRef.get();
        if (v3 == null || this.callbacks.isEmpty()) {
            return;
        }
        int i4 = this.collapsedOffset;
        if (i3 > i4 || i4 == getExpandedOffset()) {
            int i5 = this.collapsedOffset;
            f3 = i5 - i3;
            f4 = this.parentHeight - i5;
        } else {
            int i6 = this.collapsedOffset;
            f3 = i6 - i3;
            f4 = i6 - getExpandedOffset();
        }
        float f5 = f3 / f4;
        for (int i7 = 0; i7 < this.callbacks.size(); i7++) {
            this.callbacks.get(i7).onSlide(v3, f5);
        }
    }

    View findScrollingChild(View view) {
        if (y.P(view) && view.getVisibility() == 0) {
            return view;
        }
        if (!(view instanceof ViewGroup) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i3));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public COUIPanelDragListener getCOUIPanelDragListener() {
        return this.mCOUIPanelDragListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public int getState() {
        return this.state;
    }

    public boolean isCanHideKeyboard() {
        return this.mCanHideKeyboard;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isHideable() {
        return this.hideable;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        A.c cVar;
        if (!v3.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.initialX = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, this.initialX, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.B(v3, this.initialX, this.initialY);
        } else if (actionMasked == 1) {
            COUIPanelPullUpListener cOUIPanelPullUpListener = this.mPullUpListener;
            if (cOUIPanelPullUpListener != null) {
                cOUIPanelPullUpListener.onCancel();
            }
        } else if (actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (cVar = this.viewDragHelper) != null && cVar.G(motionEvent)) {
            return true;
        }
        if (Math.abs(this.initialY - motionEvent.getY()) > Math.abs(this.initialX - motionEvent.getX()) * 2.0f && this.viewDragHelper != null && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.u()) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.u())) ? false : true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        U0.g gVar;
        if (y.u(coordinatorLayout) && !y.u(v3)) {
            v3.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(H0.c.f519b);
            setSystemGestureInsets(coordinatorLayout);
            this.viewRef = new WeakReference<>(v3);
            if (this.shapeThemingEnabled && (gVar = this.materialShapeDrawable) != null) {
                y.n0(v3, gVar);
            }
            U0.g gVar2 = this.materialShapeDrawable;
            if (gVar2 != null) {
                float f3 = this.elevation;
                if (f3 == -1.0f) {
                    f3 = y.t(v3);
                }
                gVar2.T(f3);
                boolean z3 = this.state == 3;
                this.isShapeExpanded = z3;
                this.materialShapeDrawable.V(z3 ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (y.v(v3) == 0) {
                y.u0(v3, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = A.c.m(coordinatorLayout, this.dragCallback);
        }
        int top = v3.getTop();
        coordinatorLayout.I(v3, i3);
        this.parentWidth = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.parentHeight = height;
        if (!this.mIsIgnoreExpandedOffsetChange) {
            this.fitToContentsOffset = Math.max(0, height - v3.getHeight());
        }
        this.mIsIgnoreExpandedOffsetChange = false;
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i4 = this.state;
        if (i4 == 3) {
            y.U(v3, getExpandedOffset());
        } else if (i4 == 6) {
            y.U(v3, this.halfExpandedOffset);
        } else if (this.hideable && i4 == 5) {
            y.U(v3, this.parentHeight);
        } else if (i4 == 4) {
            y.U(v3, this.collapsedOffset);
        } else if (i4 == 1 || i4 == 2) {
            y.U(v3, top - v3.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v3));
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v3, View view, float f3, float f4) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v3, view, f3, f4);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v3.getTop();
        int i6 = top - i4;
        if (i4 > 0) {
            if (i6 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                y.U(v3, -expandedOffset);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i4;
                y.U(v3, -i4);
                setStateInternal(1);
            }
        } else if (i4 < 0 && !view.canScrollVertically(-1)) {
            int i7 = this.collapsedOffset;
            if (i6 > i7 && !this.hideable) {
                int i8 = top - i7;
                iArr[1] = i8;
                y.U(v3, -i8);
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i4;
                y.U(v3, -i4);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v3.getTop());
        this.lastNestedScrollDy = i4;
        this.nestedScrolled = true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v3, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v3, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i3 = savedState.state;
        if (i3 == 1 || i3 == 2) {
            this.state = 4;
        } else {
            this.state = i3;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v3) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (COUIGuideBehavior<?>) this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3, int i4) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i3 & 2) != 0;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i3) {
        int i4;
        int i5 = 3;
        if (v3.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i4 = this.fitToContentsOffset;
                } else {
                    int top = v3.getTop();
                    int i6 = this.halfExpandedOffset;
                    if (top > i6) {
                        i5 = 6;
                        i4 = i6;
                    } else {
                        i4 = this.expandedOffset;
                    }
                }
            } else if (this.hideable && shouldHide(v3, getYVelocity())) {
                COUIPanelDragListener cOUIPanelDragListener = this.mCOUIPanelDragListener;
                if (cOUIPanelDragListener == null || !cOUIPanelDragListener.onDragWhileEditing()) {
                    i4 = this.parentHeight;
                    this.mCanHideKeyboard = true;
                    i5 = 5;
                } else {
                    i4 = this.fitToContentsOffset;
                    this.mCanHideKeyboard = false;
                }
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v3.getTop();
                if (!this.fitToContents) {
                    int i7 = this.halfExpandedOffset;
                    if (top2 < i7) {
                        if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                            i4 = this.expandedOffset;
                        } else {
                            i4 = this.halfExpandedOffset;
                        }
                    } else if (Math.abs(top2 - i7) < Math.abs(top2 - this.collapsedOffset)) {
                        i4 = this.halfExpandedOffset;
                    } else {
                        i4 = this.collapsedOffset;
                        i5 = 4;
                    }
                    i5 = 6;
                } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                    i4 = this.fitToContentsOffset;
                } else {
                    i4 = this.collapsedOffset;
                    i5 = 4;
                }
            } else {
                if (this.fitToContents) {
                    i4 = this.collapsedOffset;
                } else {
                    int top3 = v3.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i4 = this.halfExpandedOffset;
                        i5 = 6;
                    } else {
                        i4 = this.collapsedOffset;
                    }
                }
                i5 = 4;
            }
            startSettlingAnimation(v3, i5, i4, false);
            this.nestedScrolled = false;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        if (!v3.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        A.c cVar = this.viewDragHelper;
        if (cVar != null) {
            cVar.z(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && this.viewDragHelper != null && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.u()) {
            this.viewDragHelper.b(v3, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        this.callbacks.remove(cOUIBottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (cOUIBottomSheetCallback != null) {
            this.callbacks.add(cOUIBottomSheetCallback);
        }
    }

    public void setCanHideKeyboard(boolean z3) {
        this.mCanHideKeyboard = z3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setDraggable(boolean z3) {
        this.draggable = z3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setExpandedOffset(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = i3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setFitToContents(boolean z3) {
        if (this.fitToContents == z3) {
            return;
        }
        this.fitToContents = z3;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateAccessibilityActions();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setGestureInsetBottomIgnored(boolean z3) {
        this.gestureInsetBottomIgnored = z3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHalfExpandedRatio(float f3) {
        if (f3 <= 0.0f || f3 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f3;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public void setHideable(boolean z3) {
        if (this.hideable != z3) {
            this.hideable = z3;
            if (!z3 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        this.mCOUIPanelDragListener = cOUIPanelDragListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setPeekHeight(int i3) {
        setPanelPeekHeight(i3, false);
    }

    public void setPullUpListener(COUIPanelPullUpListener cOUIPanelPullUpListener) {
        this.mPullUpListener = cOUIPanelPullUpListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSaveFlags(int i3) {
        this.saveFlags = i3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSkipCollapsed(boolean z3) {
        this.skipCollapsed = z3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setState(int i3) {
        if (i3 == this.state) {
            return;
        }
        if (this.viewRef != null) {
            settleToStatePendingLayout(i3);
            return;
        }
        if (i3 == 4 || i3 == 3 || i3 == 6 || (this.hideable && i3 == 5)) {
            this.state = i3;
        }
    }

    void setStateInternal(int i3) {
        V v3;
        if (this.state == i3) {
            return;
        }
        this.state = i3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            updateImportantForAccessibility(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i3);
        for (int i4 = 0; i4 < this.callbacks.size(); i4++) {
            this.callbacks.get(i4).onStateChanged(v3, i3);
        }
        updateAccessibilityActions();
    }

    public void setStateWithoutAnim(int i3, boolean z3) {
        V v3;
        if (this.state == i3) {
            return;
        }
        this.state = i3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || !z3 || (v3 = weakReference.get()) == null) {
            return;
        }
        for (int i4 = 0; i4 < this.callbacks.size(); i4++) {
            this.callbacks.get(i4).onStateChanged(v3, i3);
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z3) {
        this.updateImportantForAccessibilityOnSiblings = z3;
    }

    void settleToState(View view, int i3) {
        int i4;
        int i5;
        if (i3 == 4) {
            i4 = this.collapsedOffset;
        } else if (i3 == 6) {
            i4 = this.halfExpandedOffset;
            if (this.fitToContents && i4 <= (i5 = this.fitToContentsOffset)) {
                i3 = 3;
                i4 = i5;
            }
        } else if (i3 == 3) {
            i4 = getExpandedOffset();
        } else {
            if (!this.hideable || i3 != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i3);
            }
            i4 = this.parentHeight;
        }
        startSettlingAnimation(view, i3, i4, false);
    }

    boolean shouldHide(View view, float f3) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f3 * HIDE_FRICTION)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > HIDE_THRESHOLD;
    }

    void startSettlingAnimation(View view, int i3, int i4, boolean z3) {
        if (!(z3 ? this.viewDragHelper.F(view.getLeft(), i4) : this.viewDragHelper.H(view, view.getLeft(), i4))) {
            setStateInternal(i3);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i3);
        if (this.settleRunnable == null) {
            this.settleRunnable = new SettleRunnable(view, i3);
        }
        if (((SettleRunnable) this.settleRunnable).isPosted) {
            this.settleRunnable.targetState = i3;
            return;
        }
        COUIGuideBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
        settleRunnable.targetState = i3;
        y.a0(view, settleRunnable);
        ((SettleRunnable) this.settleRunnable).isPosted = true;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z3, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = k.e(context, attributeSet, H0.a.f472d, DEF_STYLE_RES).m();
            U0.g gVar = new U0.g(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = gVar;
            gVar.K(context);
            if (z3 && colorStateList != null) {
                this.materialShapeDrawable.U(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    public COUIGuideBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new c.AbstractC0002c() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.3
            private boolean releasedLow(View view) {
                int top = view.getTop();
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                return top > (cOUIGuideBehavior.parentHeight + cOUIGuideBehavior.getExpandedOffset()) / 2;
            }

            @Override // A.c.AbstractC0002c
            public int clampViewPositionHorizontal(View view, int i32, int i4) {
                return view.getLeft();
            }

            @Override // A.c.AbstractC0002c
            public int clampViewPositionVertical(View view, int i32, int i4) {
                int i5;
                int i6;
                if (COUIGuideBehavior.this.mPullUpListener == null || ((i6 = COUIGuideBehavior.this.state) != 3 && (i6 != 1 || view.getTop() > COUIGuideBehavior.this.getExpandedOffset()))) {
                    i5 = 0;
                } else {
                    COUIGuideBehavior.this.mIsIgnoreExpandedOffsetChange = true;
                    i5 = COUIGuideBehavior.this.mPullUpListener.onDragging(i4, COUIGuideBehavior.this.getExpandedOffset());
                }
                int expandedOffset = COUIGuideBehavior.this.getExpandedOffset() - i5;
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                return AbstractC0626a.b(i32, expandedOffset, cOUIGuideBehavior.hideable ? cOUIGuideBehavior.parentHeight : cOUIGuideBehavior.collapsedOffset);
            }

            @Override // A.c.AbstractC0002c
            public int getViewVerticalDragRange(View view) {
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                return cOUIGuideBehavior.hideable ? cOUIGuideBehavior.parentHeight : cOUIGuideBehavior.collapsedOffset;
            }

            @Override // A.c.AbstractC0002c
            public void onViewDragStateChanged(int i32) {
                if (i32 == 1 && COUIGuideBehavior.this.draggable) {
                    COUIGuideBehavior.this.setStateInternal(1);
                }
            }

            @Override // A.c.AbstractC0002c
            public void onViewPositionChanged(View view, int i32, int i4, int i5, int i6) {
                COUIGuideBehavior.this.dispatchOnSlide(i4);
            }

            @Override // A.c.AbstractC0002c
            public void onViewReleased(View view, float f3, float f4) {
                int i32;
                if (COUIGuideBehavior.this.mPullUpListener != null && COUIGuideBehavior.this.parentHeight - view.getHeight() < COUIGuideBehavior.this.getExpandedOffset() && view.getTop() < COUIGuideBehavior.this.getExpandedOffset()) {
                    COUIGuideBehavior.this.mPullUpListener.onReleased(COUIGuideBehavior.this.getExpandedOffset());
                    return;
                }
                int i4 = 6;
                if (f4 < 0.0f) {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i32 = COUIGuideBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                        int i5 = cOUIGuideBehavior.halfExpandedOffset;
                        if (top > i5) {
                            i32 = i5;
                            COUIGuideBehavior.this.startSettlingAnimation(view, i4, i32, true);
                        }
                        i32 = cOUIGuideBehavior.expandedOffset;
                    }
                    i4 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i4, i32, true);
                }
                COUIGuideBehavior cOUIGuideBehavior2 = COUIGuideBehavior.this;
                if (cOUIGuideBehavior2.hideable && cOUIGuideBehavior2.shouldHide(view, f4)) {
                    COUIPanelDragListener cOUIPanelDragListener = COUIGuideBehavior.this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener == null || !cOUIPanelDragListener.onDragWhileEditing()) {
                        if ((Math.abs(f3) < Math.abs(f4) && f4 > 500.0f) || releasedLow(view)) {
                            COUIGuideBehavior cOUIGuideBehavior3 = COUIGuideBehavior.this;
                            int i6 = cOUIGuideBehavior3.parentHeight;
                            cOUIGuideBehavior3.mCanHideKeyboard = true;
                            i4 = 5;
                            i32 = i6;
                        } else if (COUIGuideBehavior.this.fitToContents) {
                            i32 = COUIGuideBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - COUIGuideBehavior.this.expandedOffset) < Math.abs(view.getTop() - COUIGuideBehavior.this.halfExpandedOffset)) {
                            i32 = COUIGuideBehavior.this.expandedOffset;
                        } else {
                            i32 = COUIGuideBehavior.this.halfExpandedOffset;
                        }
                        COUIGuideBehavior.this.startSettlingAnimation(view, i4, i32, true);
                    }
                    COUIGuideBehavior cOUIGuideBehavior4 = COUIGuideBehavior.this;
                    int i7 = cOUIGuideBehavior4.fitToContentsOffset;
                    cOUIGuideBehavior4.mCanHideKeyboard = false;
                    i32 = i7;
                    i4 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i4, i32, true);
                }
                if (f4 == 0.0f || Math.abs(f3) > Math.abs(f4)) {
                    int top2 = view.getTop();
                    if (!COUIGuideBehavior.this.fitToContents) {
                        COUIGuideBehavior cOUIGuideBehavior5 = COUIGuideBehavior.this;
                        int i8 = cOUIGuideBehavior5.halfExpandedOffset;
                        if (top2 < i8) {
                            if (top2 < Math.abs(top2 - cOUIGuideBehavior5.collapsedOffset)) {
                                i32 = COUIGuideBehavior.this.expandedOffset;
                                i4 = 3;
                            } else {
                                i32 = COUIGuideBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - i8) < Math.abs(top2 - COUIGuideBehavior.this.collapsedOffset)) {
                            i32 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i32 = COUIGuideBehavior.this.collapsedOffset;
                            i4 = 4;
                        }
                    } else if (Math.abs(top2 - COUIGuideBehavior.this.fitToContentsOffset) < Math.abs(top2 - COUIGuideBehavior.this.collapsedOffset)) {
                        i32 = COUIGuideBehavior.this.fitToContentsOffset;
                        i4 = 3;
                    } else {
                        i32 = COUIGuideBehavior.this.collapsedOffset;
                        i4 = 4;
                    }
                } else {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i32 = COUIGuideBehavior.this.collapsedOffset;
                    } else {
                        int top3 = view.getTop();
                        if (Math.abs(top3 - COUIGuideBehavior.this.halfExpandedOffset) < Math.abs(top3 - COUIGuideBehavior.this.collapsedOffset)) {
                            i32 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i32 = COUIGuideBehavior.this.collapsedOffset;
                        }
                    }
                    i4 = 4;
                }
                COUIGuideBehavior.this.startSettlingAnimation(view, i4, i32, true);
            }

            @Override // A.c.AbstractC0002c
            public boolean tryCaptureView(View view, int i32) {
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                int i4 = cOUIGuideBehavior.state;
                if (i4 == 1 || cOUIGuideBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i4 == 3 && cOUIGuideBehavior.activePointerId == i32) {
                    WeakReference<View> weakReference = cOUIGuideBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = COUIGuideBehavior.this.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f685H);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(j.f768c0);
        boolean hasValue = obtainStyledAttributes.hasValue(j.f701L);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, A0.a.a(context, obtainStyledAttributes, j.f701L));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(j.f697K, -1.0f);
        TypedValue peekValue = obtainStyledAttributes.peekValue(j.f725R);
        if (peekValue != null && (i3 = peekValue.data) == -1) {
            setPeekHeight(i3);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(j.f725R, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(j.f721Q, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(j.f737U, false));
        setFitToContents(obtainStyledAttributes.getBoolean(j.f713O, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(j.f733T, false));
        setDraggable(obtainStyledAttributes.getBoolean(j.f705M, true));
        setSaveFlags(obtainStyledAttributes.getInt(j.f729S, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(j.f717P, HIDE_THRESHOLD));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(j.f709N);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(j.f709N, 0));
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mCanHideKeyboard = false;
    }
}
