package com.coui.appcompat.panel;

import H0.j;
import U0.g;
import U0.k;
import U1.f;
import Z.b;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
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
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AbstractC0256e;
import androidx.core.view.J;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import androidx.core.view.y;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import h0.AbstractC0371a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import s1.AbstractC0576c;
import s1.C0579f;
import s1.InterfaceC0574a;
import s1.InterfaceC0575b;
import s1.h;
import s1.i;
import x.AbstractC0626a;
import z.AbstractC0645a;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public class COUIBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> implements InterfaceC0574a, InterfaceC0575b {
    private static final int BOTTOM_DISPLAY_VIEW_HEIGHT_LONG_TO_SHORT = 1;
    private static final int BOTTOM_DISPLAY_VIEW_HEIGHT_SHORT_TO_LONG = 2;
    private static final int CENTER_DISPLAY_VIEW_HEIGHT_LONG_TO_SHORT = 3;
    private static final int CENTER_DISPLAY_VIEW_HEIGHT_SHORT_TO_LONG = 4;
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static boolean DEBUG = false;
    private static final int DEFAULT_DISPLAY = 0;
    private static final float DEFAULT_PHYSICS_DAMPING_RATIO = 0.6f;
    private static final float DEFAULT_PHYSICS_FREQUENCY = 16.0f;
    private static final float DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION = 333.0f;
    private static final int DEF_STYLE_RES;
    private static final int DRAG_TO_HIDDEN_SPEED_THRESHOLD = 5000;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    private static final float PHYSICS_UNSET = Float.MIN_VALUE;
    private static final String PROPERTY_OFFSET_TOP_AND_BOTTOM = "offsetTopAndBottom";
    private static final int PULL_UP_DY_THRESHOLD = -100;
    private static final float PULL_UP_FRICTION = 0.5f;
    private static final int PULL_UP_SPEED_THRESHOLD = 10000;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SDK_SUB_VERSION_FOR_FLEXIBLE = 12;
    private static final int SDK_VERSION_FOR_FLEXIBLE = 34;
    private static final float SETTLE_ANIM_SPRING_BOUNCE = 0.0f;
    private static final float SETTLE_ANIM_SPRING_RESPONSE = 0.4f;
    private static final int SHAKE_HAND_MOVING_BASE_DOWN_VELOCITY = 100;
    private static final int SHAKE_HAND_MOVING_BASE_UP_VELOCITY = -100;
    private static final int SHAKE_HAND_MOVING_DIRECTION_DEFAULT = 0;
    private static final int SHAKE_HAND_MOVING_DIRECTION_DOWN = 2;
    private static final int SHAKE_HAND_MOVING_DIRECTION_UP = 1;
    private static final float SHAKE_HAND_MOVING_FACTOR = 0.4f;
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
    private float alphaRadio;
    private final ArrayList<COUIBottomSheetCallback> callbacks;
    int collapsedOffset;
    private final COUIViewDragHelper.Callback dragCallback;
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
    private Rect mBarRect;
    COUIPanelDragListener mCOUIPanelDragListener;
    private boolean mCanHideKeyboard;
    private Context mContext;
    private int mCurTop;
    private int mDialogMaxHeight;
    private C0579f mDragBehavior;
    private View mDragChild;
    private float mDragCurrentValue;
    private float mDragDampingRatio;
    private float mDragFrequency;
    private h mDragValueHolder;
    private boolean mGlobalDrag;
    boolean mHalfExpandOffsetUseParentRootViewHeight;
    private boolean mIsHandlePanel;
    private boolean mIsIgnoreExpandedOffsetChange;
    private boolean mIsInTinyScreen;
    private boolean mIsNestedScrollingCheckEnabled;
    private int mLastMeasureHeight;
    private int mLastOffsetInFling;
    private boolean mLayoutAtMaxHeight;
    private int mLayoutBottom;
    private Rect mLayoutRect;
    private OnNestedScrollingChild mOnNestedScrollingChild;
    private Z.c mPanelHeightChangeAnim;
    private OnPanelHeightChangeAnimListener mPanelHeightChangeAnimListener;
    private Z.d mPanelHeightSpringForce;
    private int mPanelPaddingBottom;
    private Rect mParentRect;
    private i mPhysicalAnimator;
    private boolean mPhysicsEnable;
    int mPressDownState;
    private COUIPanelPullUpListener mPullUpListener;
    private PullUpToDismissPanelListener mPullUpToDismissPanelListener;
    private int mSettleTargetState;
    private int mShakeHandMovingDirection;
    private boolean mStartHeightChangeAnim;
    private int mStartTopValue;
    private int mViewHeightType;
    private int mWantTop;
    private float mYVelocity;
    private g materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentMarginTop;
    int parentRootViewHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private k shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    COUIViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class COUIBottomSheetCallback {
        public abstract void onSlide(View view, float f3);

        public abstract void onStateChanged(View view, int i3);
    }

    public interface OnNestedScrollingChild {
        View getNestedScrollingChild();
    }

    public interface OnPanelHeightChangeAnimListener {
        default void onAnimationEnd(Z.b bVar, boolean z3, float f3) {
        }

        default void onAnimationUpdate(Z.b bVar, float f3, float f4) {
        }
    }

    interface PullUpToDismissPanelListener {
        void onPullUpDismiss();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    protected static class SavedState extends AbstractC0645a {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.SavedState.1
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

        public SavedState(Parcelable parcelable, COUIBottomSheetBehavior<?> cOUIBottomSheetBehavior) {
            super(parcelable);
            this.state = cOUIBottomSheetBehavior.state;
            this.peekHeight = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).peekHeight;
            this.fitToContents = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).fitToContents;
            this.hideable = cOUIBottomSheetBehavior.hideable;
            this.skipCollapsed = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i3) {
            super(parcelable);
            this.state = i3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    static {
        DEBUG = AbstractC0371a.f11873b || AbstractC0371a.e(TAG, 3);
        DEF_STYLE_RES = H0.i.f641f;
    }

    public COUIBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.mPressDownState = 4;
        this.mYVelocity = SETTLE_ANIM_SPRING_BOUNCE;
        this.mLayoutAtMaxHeight = true;
        this.mShakeHandMovingDirection = 0;
        this.mViewHeightType = 0;
        this.mParentRect = new Rect();
        this.mLayoutRect = new Rect();
        this.mHalfExpandOffsetUseParentRootViewHeight = true;
        this.callbacks = new ArrayList<>();
        this.mLastOffsetInFling = 0;
        this.alphaRadio = SETTLE_ANIM_SPRING_BOUNCE;
        this.mDragFrequency = DEFAULT_PHYSICS_FREQUENCY;
        this.mDragDampingRatio = DEFAULT_PHYSICS_DAMPING_RATIO;
        this.mPhysicsEnable = false;
        this.mDragChild = null;
        this.mIsInTinyScreen = false;
        this.mIsHandlePanel = false;
        this.mBarRect = new Rect();
        this.mGlobalDrag = true;
        this.mIsNestedScrollingCheckEnabled = false;
        this.dragCallback = new COUIViewDragHelper.Callback() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.7
            private boolean releasedLow(View view) {
                int top = view.getTop();
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                return top > (cOUIBottomSheetBehavior.parentHeight + cOUIBottomSheetBehavior.getExpandedOffset()) / 2;
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i4, int i5) {
                return view.getLeft();
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i4, int i5) {
                if (COUIBottomSheetBehavior.this.mPullUpListener != null) {
                    COUIBottomSheetBehavior.this.mPullUpListener.onDraggingPanel();
                }
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                int i6 = 0;
                if (cOUIBottomSheetBehavior.state == 1) {
                    if (cOUIBottomSheetBehavior.isPanelHeightChangeAnimRunning()) {
                        COUIBottomSheetBehavior.this.mPanelHeightChangeAnim.c();
                    }
                    if (view.getTop() <= COUIBottomSheetBehavior.this.getExpandedOffset()) {
                        if (COUIBottomSheetBehavior.this.mPhysicsEnable && COUIBottomSheetBehavior.this.mDragBehavior.Q()) {
                            COUIBottomSheetBehavior.this.mDragBehavior.M(COUIBottomSheetBehavior.SETTLE_ANIM_SPRING_BOUNCE);
                            COUIBottomSheetBehavior.this.mDragChild = null;
                        }
                        if (COUIBottomSheetBehavior.this.mPullUpListener != null && COUIBottomSheetBehavior.this.getExpandedOffset() > 0) {
                            COUIBottomSheetBehavior.this.mIsIgnoreExpandedOffsetChange = true;
                            if (i5 < 0) {
                                i5 = Math.max(i5, (view.getMeasuredHeight() - COUIBottomSheetBehavior.this.mPanelPaddingBottom) - COUIBottomSheetBehavior.this.mDialogMaxHeight);
                            }
                            if (i5 != 0) {
                                i6 = COUIBottomSheetBehavior.this.mPullUpListener.onDragging(i5, COUIBottomSheetBehavior.this.getExpandedOffset());
                            }
                        }
                    } else {
                        int top = view.getTop();
                        if (COUIBottomSheetBehavior.this.mPhysicsEnable) {
                            COUIBottomSheetBehavior.this.dragToNewTop(view, top + i5);
                        } else if (COUIBottomSheetBehavior.this.getYVelocity() > 10000.0f) {
                            i4 = ((int) ((i5 * 0.5f) + 0.5f)) + top;
                        }
                    }
                }
                COUIBottomSheetBehavior.this.calculatePanelOutsideAlpha(view);
                int expandedOffset = COUIBottomSheetBehavior.this.getExpandedOffset() - i6;
                COUIBottomSheetBehavior cOUIBottomSheetBehavior2 = COUIBottomSheetBehavior.this;
                return AbstractC0626a.b(i4, expandedOffset, cOUIBottomSheetBehavior2.hideable ? cOUIBottomSheetBehavior2.parentHeight : cOUIBottomSheetBehavior2.collapsedOffset);
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                return cOUIBottomSheetBehavior.hideable ? cOUIBottomSheetBehavior.parentHeight : cOUIBottomSheetBehavior.collapsedOffset;
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public void onViewDragStateChanged(int i4) {
                if (i4 == 1 && COUIBottomSheetBehavior.this.draggable) {
                    COUIBottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i4, int i5, int i6, int i7) {
                COUIBottomSheetBehavior.this.dispatchOnSlide(i5);
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public void onViewReleased(View view, float f3, float f4) {
                int i4;
                if (COUIBottomSheetBehavior.this.mPhysicsEnable && COUIBottomSheetBehavior.this.mDragBehavior.Q()) {
                    COUIBottomSheetBehavior.this.mDragBehavior.M(COUIBottomSheetBehavior.SETTLE_ANIM_SPRING_BOUNCE);
                    COUIBottomSheetBehavior.this.mDragChild = null;
                }
                boolean z3 = false;
                COUIBottomSheetBehavior.this.mIsIgnoreExpandedOffsetChange = false;
                if (COUIBottomSheetBehavior.this.mPullUpListener != null) {
                    COUIBottomSheetBehavior.this.mPullUpListener.onReleasedDrag();
                    float ratio = view instanceof COUIPanelPercentFrameLayout ? ((COUIPanelPercentFrameLayout) view).getRatio() : 1.0f;
                    COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                    if (((int) (((cOUIBottomSheetBehavior.parentHeight - cOUIBottomSheetBehavior.getMarginBottom(view)) / ratio) - ((view.getHeight() - COUIBottomSheetBehavior.this.mPanelPaddingBottom) / ratio))) <= COUIBottomSheetBehavior.this.getExpandedOffset() && view.getTop() < COUIBottomSheetBehavior.this.getExpandedOffset()) {
                        COUIBottomSheetBehavior.this.mPullUpListener.onReleased(COUIBottomSheetBehavior.this.getExpandedOffset());
                        return;
                    }
                }
                int i5 = 6;
                if (f4 < COUIBottomSheetBehavior.SETTLE_ANIM_SPRING_BOUNCE) {
                    if (COUIBottomSheetBehavior.this.fitToContents) {
                        i4 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior2 = COUIBottomSheetBehavior.this;
                        int i6 = cOUIBottomSheetBehavior2.halfExpandedOffset;
                        if (top > i6) {
                            i4 = i6;
                            COUIBottomSheetBehavior.this.startSettlingAnimation(view, i5, i4, true);
                        }
                        i4 = cOUIBottomSheetBehavior2.expandedOffset;
                    }
                    i5 = 3;
                    COUIBottomSheetBehavior.this.startSettlingAnimation(view, i5, i4, true);
                }
                COUIBottomSheetBehavior cOUIBottomSheetBehavior3 = COUIBottomSheetBehavior.this;
                if (cOUIBottomSheetBehavior3.hideable && cOUIBottomSheetBehavior3.shouldHide(view, f4)) {
                    COUIPanelDragListener cOUIPanelDragListener = COUIBottomSheetBehavior.this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener != null && cOUIPanelDragListener.onDragWhileEditing()) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior4 = COUIBottomSheetBehavior.this;
                        int i7 = cOUIBottomSheetBehavior4.fitToContentsOffset;
                        cOUIBottomSheetBehavior4.mCanHideKeyboard = false;
                        i4 = i7;
                    } else if ((Math.abs(f3) < Math.abs(f4) && f4 > 500.0f) || releasedLow(view)) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior5 = COUIBottomSheetBehavior.this;
                        int i8 = cOUIBottomSheetBehavior5.parentRootViewHeight;
                        cOUIBottomSheetBehavior5.mCanHideKeyboard = true;
                        i4 = i8;
                        i5 = 5;
                    } else if (COUIBottomSheetBehavior.this.fitToContents) {
                        i4 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                    } else if (Math.abs(view.getTop() - COUIBottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - COUIBottomSheetBehavior.this.halfExpandedOffset)) {
                        i4 = COUIBottomSheetBehavior.this.expandedOffset;
                    } else {
                        i4 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                    }
                    i5 = 3;
                } else if (f4 == COUIBottomSheetBehavior.SETTLE_ANIM_SPRING_BOUNCE || Math.abs(f3) > Math.abs(f4)) {
                    int top2 = view.getTop();
                    if (!COUIBottomSheetBehavior.this.fitToContents) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior6 = COUIBottomSheetBehavior.this;
                        int i9 = cOUIBottomSheetBehavior6.halfExpandedOffset;
                        if (top2 < i9) {
                            if (top2 < Math.abs(top2 - cOUIBottomSheetBehavior6.collapsedOffset)) {
                                i4 = COUIBottomSheetBehavior.this.expandedOffset;
                                i5 = 3;
                            } else {
                                i4 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - i9) < Math.abs(top2 - COUIBottomSheetBehavior.this.collapsedOffset)) {
                            i4 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i4 = COUIBottomSheetBehavior.this.collapsedOffset;
                            i5 = 4;
                        }
                    } else if (Math.abs(top2 - COUIBottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top2 - COUIBottomSheetBehavior.this.collapsedOffset)) {
                        i4 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                        i5 = 3;
                    } else {
                        i4 = COUIBottomSheetBehavior.this.collapsedOffset;
                        i5 = 4;
                    }
                } else {
                    if (COUIBottomSheetBehavior.this.fitToContents) {
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior7 = COUIBottomSheetBehavior.this;
                        COUIPanelDragListener cOUIPanelDragListener2 = cOUIBottomSheetBehavior7.mCOUIPanelDragListener;
                        if (cOUIPanelDragListener2 == null) {
                            i4 = cOUIBottomSheetBehavior7.collapsedOffset;
                        } else if (cOUIPanelDragListener2.onDragWhileEditing()) {
                            i4 = COUIBottomSheetBehavior.this.fitToContentsOffset;
                            i5 = 3;
                        } else {
                            i4 = COUIBottomSheetBehavior.this.parentRootViewHeight;
                            i5 = 5;
                        }
                    } else {
                        int top3 = view.getTop();
                        COUIBottomSheetBehavior cOUIBottomSheetBehavior8 = COUIBottomSheetBehavior.this;
                        int i10 = cOUIBottomSheetBehavior8.halfExpandedOffset;
                        if (top3 > i10 && top3 < cOUIBottomSheetBehavior8.collapsedOffset) {
                            z3 = true;
                        }
                        if (cOUIBottomSheetBehavior8.mPressDownState == 6 && z3) {
                            i4 = cOUIBottomSheetBehavior8.collapsedOffset;
                        } else if (Math.abs(top3 - i10) < Math.abs(top3 - COUIBottomSheetBehavior.this.collapsedOffset)) {
                            i4 = COUIBottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i4 = COUIBottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                    i5 = 4;
                }
                COUIBottomSheetBehavior.this.startSettlingAnimation(view, i5, i4, true);
            }

            @Override // com.coui.appcompat.panel.COUIViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i4) {
                COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                int i5 = cOUIBottomSheetBehavior.state;
                if (i5 == 1 || cOUIBottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i5 == 3 && cOUIBottomSheetBehavior.activePointerId == i4) {
                    WeakReference<View> weakReference = cOUIBottomSheetBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = COUIBottomSheetBehavior.this.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
        this.mContext = context;
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
        if (peekValue == null || (i3 = peekValue.data) != -1) {
            setPanelPeekHeight(obtainStyledAttributes.getDimensionPixelSize(j.f725R, -1));
        } else {
            setPanelPeekHeight(i3);
        }
        setHideable(obtainStyledAttributes.getBoolean(j.f721Q, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(j.f737U, false));
        setFitToContents(obtainStyledAttributes.getBoolean(j.f713O, true));
        setPanelSkipCollapsed(obtainStyledAttributes.getBoolean(j.f733T, false));
        setDraggable(obtainStyledAttributes.getBoolean(j.f705M, true));
        setSaveFlags(obtainStyledAttributes.getInt(j.f729S, -1));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(j.f717P, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(j.f709N);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(j.f709N, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mCanHideKeyboard = false;
    }

    private void addAccessibilityActionForState(V v3, d.a aVar, final int i3) {
        y.e0(v3, aVar, null, new androidx.core.view.accessibility.g() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.8
            @Override // androidx.core.view.accessibility.g
            public boolean perform(View view, g.a aVar2) {
                COUIBottomSheetBehavior.this.setPanelState(i3);
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
        if (DEBUG) {
            Log.d(TAG, "calculateHalfExpandedOffset: halfExpandedRatio=" + this.halfExpandedRatio + " halfExpandedOffset=" + this.halfExpandedOffset);
        }
        if (this.mHalfExpandOffsetUseParentRootViewHeight && this.mIsHandlePanel && this.halfExpandedRatio == 0.5f) {
            this.halfExpandedOffset = (this.parentRootViewHeight / 2) - this.parentMarginTop;
            if (DEBUG) {
                Log.d(TAG, "calculateHalfExpandedOffset: modified halfExpandedOffset=" + this.halfExpandedOffset);
            }
        }
        if (this.mIsHandlePanel) {
            this.halfExpandedOffset = Math.max(this.halfExpandedOffset, getExpandedOffset());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculatePanelOutsideAlpha(View view) {
        float top = 1.0f - ((view.getTop() - getExpandedOffset()) / this.parentHeight);
        this.alphaRadio = top;
        COUIPanelPullUpListener cOUIPanelPullUpListener = this.mPullUpListener;
        if (cOUIPanelPullUpListener != null) {
            cOUIPanelPullUpListener.onOffsetChanged(top);
        }
    }

    private int calculatePeekHeight() {
        return this.peekHeightAuto ? Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)) : this.peekHeight;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z3) {
        createMaterialShapeDrawable(context, attributeSet, z3, null);
    }

    private void createPanelHeightChangeAnim() {
        B.d dVar = new B.d(SETTLE_ANIM_SPRING_BOUNCE);
        Z.d dVar2 = new Z.d();
        this.mPanelHeightSpringForce = dVar2;
        dVar2.d(SETTLE_ANIM_SPRING_BOUNCE);
        Z.c B3 = new Z.c(dVar).B(this.mPanelHeightSpringForce);
        this.mPanelHeightChangeAnim = B3;
        B3.b(new b.r() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.1
            @Override // Z.b.r
            public void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                if (COUIBottomSheetBehavior.this.mViewHeightType == 0) {
                    COUIBottomSheetBehavior.this.panelHeightVerticalMoving(f3);
                } else {
                    COUIBottomSheetBehavior.this.panelHeightAdaptive(bVar, f3, f4);
                }
            }
        });
        this.mPanelHeightChangeAnim.a(new b.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.2
            @Override // Z.b.q
            public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
                if (COUIBottomSheetBehavior.this.mViewHeightType == 0) {
                    COUIBottomSheetBehavior cOUIBottomSheetBehavior = COUIBottomSheetBehavior.this;
                    cOUIBottomSheetBehavior.setStateInternal(cOUIBottomSheetBehavior.mSettleTargetState);
                    COUIBottomSheetBehavior.this.viewDragHelper.setDragState(0);
                    return;
                }
                if (COUIBottomSheetBehavior.this.mPanelHeightChangeAnimListener != null) {
                    COUIBottomSheetBehavior.this.mPanelHeightChangeAnimListener.onAnimationEnd(bVar, z3, f4);
                }
                COUIBottomSheetBehavior.this.mViewHeightType = 0;
                COUIBottomSheetBehavior.this.mStartHeightChangeAnim = false;
                WeakReference<V> weakReference = COUIBottomSheetBehavior.this.viewRef;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                COUIBottomSheetBehavior.this.setOutlineBottomOffset(0);
                COUIBottomSheetBehavior.this.viewRef.get().requestLayout();
            }
        });
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(SETTLE_ANIM_SPRING_BOUNCE, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIBottomSheetBehavior.this.materialShapeDrawable != null) {
                    COUIBottomSheetBehavior.this.materialShapeDrawable.V(floatValue);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dragToNewTop(View view, float f3) {
        if (this.mDragBehavior.Q()) {
            this.mDragBehavior.R(f3);
            return;
        }
        this.mDragChild = view;
        float top = view.getTop();
        this.mDragValueHolder.c(top);
        this.mDragBehavior.H(top, top);
        this.mDragCurrentValue = top;
    }

    public static <V extends View> COUIBottomSheetBehavior<V> from(V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c e3 = ((CoordinatorLayout.f) layoutParams).e();
        if (e3 instanceof COUIBottomSheetBehavior) {
            return (COUIBottomSheetBehavior) e3;
        }
        throw new IllegalArgumentException("The view is not associated with COUIBottomSheetBehavior");
    }

    private Rect getLayoutRect(CoordinatorLayout coordinatorLayout, View view, int i3) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        this.mParentRect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, coordinatorLayout.getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (coordinatorLayout.getHeight() - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        J lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && y.u(coordinatorLayout) && !y.u(view)) {
            this.mParentRect.left += lastWindowInsets.i();
            this.mParentRect.top += lastWindowInsets.k();
            this.mParentRect.right -= lastWindowInsets.j();
            this.mParentRect.bottom -= lastWindowInsets.h();
        }
        AbstractC0256e.a(resolveGravity(fVar.f4779c), view.getMeasuredWidth(), view.getMeasuredHeight(), this.mParentRect, this.mLayoutRect, i3);
        return this.mLayoutRect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMarginBottom(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
        return 0;
    }

    private int getWantTop(V v3, int i3) {
        float f3;
        boolean z3;
        if (v3 instanceof COUIPanelPercentFrameLayout) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = (COUIPanelPercentFrameLayout) v3;
            f3 = cOUIPanelPercentFrameLayout.getRatio();
            z3 = cOUIPanelPercentFrameLayout.getHasAnchor();
        } else {
            f3 = 1.0f;
            z3 = false;
        }
        if (!this.mIsIgnoreExpandedOffsetChange) {
            int marginBottom = getMarginBottom(v3);
            if (z3) {
                this.fitToContentsOffset = 0;
            } else {
                this.fitToContentsOffset = (int) Math.max(SETTLE_ANIM_SPRING_BOUNCE, ((this.parentHeight - marginBottom) / f3) - ((i3 - this.mPanelPaddingBottom) / f3));
            }
            if (this.mIsHandlePanel) {
                this.expandedOffset = this.fitToContentsOffset;
            }
        }
        return getExpandedOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return SETTLE_ANIM_SPRING_BOUNCE;
        }
        velocityTracker.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isClickedOnBar(View view, int i3, int i4) {
        View findViewById;
        if (!(view instanceof COUIPanelPercentFrameLayout) || (findViewById = view.findViewById(f.f2415m)) == null) {
            return false;
        }
        findViewById.getHitRect(this.mBarRect);
        return this.mBarRect.contains(i3, i4);
    }

    private boolean isImeVisible(View view) {
        try {
            J D3 = y.D(view);
            if (D3 != null) {
                return D3.p(J.l.c());
            }
            return false;
        } catch (Exception e3) {
            Log.e(TAG, "isImeVisible exception: " + e3.getMessage());
            return false;
        }
    }

    private boolean isInFreeFormModeWindowMode() {
        Activity c3 = y0.j.c(this.mContext);
        return c3 != null && AbstractC0647b.b(SDK_VERSION_FOR_FLEXIBLE, 12) && FlexibleWindowManager.getInstance().getFlexibleWindowState(c3) == 1;
    }

    private boolean isPanelCenterDisplay() {
        return (COUIPanelMultiWindowUtils.isSmallScreen(this.mContext, null) || this.mIsHandlePanel) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void panelHeightAdaptive(Z.b bVar, float f3, float f4) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        float abs = Math.abs((f3 - this.mCurTop) / (this.mCurTop - this.mWantTop == 0 ? 1 : Math.abs(r0 - r1)));
        OnPanelHeightChangeAnimListener onPanelHeightChangeAnimListener = this.mPanelHeightChangeAnimListener;
        if (onPanelHeightChangeAnimListener != null) {
            onPanelHeightChangeAnimListener.onAnimationUpdate(bVar, abs, f4);
        }
        int i3 = (int) f3;
        int top = i3 - this.viewRef.get().getTop();
        if (top != 0) {
            y.U(this.viewRef.get(), top);
            if (isPanelCenterDisplay()) {
                int i4 = this.mViewHeightType;
                if (i4 == 3) {
                    setOutlineBottomOffset(Math.abs(this.mCurTop - i3) * (-2));
                    this.viewRef.get().invalidateOutline();
                } else if (i4 == 4) {
                    setOutlineBottomOffset((Math.abs(this.mCurTop - i3) * 2) - (Math.abs(this.mWantTop - this.mCurTop) * 2));
                    this.viewRef.get().invalidateOutline();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        if (r6.mStartTopValue < r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        r7 = (int) (r0 + ((r7 - r0) * 0.4f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004b, code lost:
    
        if (r6.mStartTopValue < r0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void panelHeightVerticalMoving(float r7) {
        /*
            r6 = this;
            com.coui.appcompat.panel.COUIViewDragHelper r0 = r6.viewDragHelper
            if (r0 == 0) goto L97
            android.view.View r0 = r0.getCapturedView()
            if (r0 == 0) goto L97
            int r7 = (int) r7
            int r0 = r6.mSettleTargetState
            r1 = 3
            r2 = 1
            r3 = 1053609165(0x3ecccccd, float:0.4)
            if (r0 == r1) goto L4e
            r1 = 4
            r4 = 2
            if (r0 == r1) goto L41
            r1 = 6
            if (r0 == r1) goto L1c
            goto L2e
        L1c:
            int r0 = r6.mShakeHandMovingDirection
            if (r0 != r2) goto L30
            int r1 = r6.halfExpandedOffset
            if (r7 >= r1) goto L30
            int r2 = r6.mStartTopValue
            if (r2 <= r1) goto L30
            float r0 = (float) r1
        L29:
            int r1 = r1 - r7
            float r7 = (float) r1
            float r7 = r7 * r3
            float r0 = r0 - r7
            int r7 = (int) r0
        L2e:
            r3 = r7
            goto L6a
        L30:
            if (r0 != r4) goto L2e
            int r0 = r6.halfExpandedOffset
            if (r7 <= r0) goto L2e
            int r1 = r6.mStartTopValue
            if (r1 >= r0) goto L2e
        L3a:
            float r1 = (float) r0
            int r7 = r7 - r0
            float r7 = (float) r7
            float r7 = r7 * r3
            float r1 = r1 + r7
            int r7 = (int) r1
            goto L2e
        L41:
            int r0 = r6.mShakeHandMovingDirection
            if (r0 != r4) goto L2e
            int r0 = r6.collapsedOffset
            if (r7 <= r0) goto L2e
            int r1 = r6.mStartTopValue
            if (r1 >= r0) goto L2e
            goto L3a
        L4e:
            int r0 = r6.mShakeHandMovingDirection
            if (r0 != r2) goto L2e
            int r0 = r6.getExpandedOffset()
            if (r7 >= r0) goto L2e
            int r0 = r6.mStartTopValue
            int r1 = r6.getExpandedOffset()
            if (r0 <= r1) goto L2e
            int r0 = r6.getExpandedOffset()
            float r0 = (float) r0
            int r1 = r6.getExpandedOffset()
            goto L29
        L6a:
            com.coui.appcompat.panel.COUIViewDragHelper r7 = r6.viewDragHelper
            android.view.View r7 = r7.getCapturedView()
            r6.calculatePanelOutsideAlpha(r7)
            com.coui.appcompat.panel.COUIViewDragHelper r7 = r6.viewDragHelper
            android.view.View r7 = r7.getCapturedView()
            int r7 = r7.getTop()
            int r5 = r3 - r7
            if (r5 == 0) goto L97
            com.coui.appcompat.panel.COUIViewDragHelper r7 = r6.viewDragHelper
            android.view.View r7 = r7.getCapturedView()
            androidx.core.view.y.U(r7, r5)
            com.coui.appcompat.panel.COUIViewDragHelper$Callback r0 = r6.dragCallback
            com.coui.appcompat.panel.COUIViewDragHelper r6 = r6.viewDragHelper
            android.view.View r1 = r6.getCapturedView()
            r2 = 0
            r4 = 0
            r0.onViewPositionChanged(r1, r2, r3, r4, r5)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIBottomSheetBehavior.panelHeightVerticalMoving(float):void");
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private int resolveGravity(int i3) {
        if ((i3 & 7) == 0) {
            i3 |= 8388611;
        }
        return (i3 & FeedbackActivity.SHOW_NO_NETWORK) == 0 ? i3 | 48 : i3;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutlineBottomOffset(int i3) {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || !(weakReference.get() instanceof COUIPanelPercentFrameLayout)) {
            return;
        }
        ((COUIPanelPercentFrameLayout) this.viewRef.get()).setOutlineBottomOffset(i3);
    }

    private void setShakeHandMovingDirection(float f3) {
        if (f3 > 100.0f) {
            this.mShakeHandMovingDirection = 2;
        } else if (f3 < -100.0f) {
            this.mShakeHandMovingDirection = 1;
        } else {
            this.mShakeHandMovingDirection = 0;
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
            v3.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.3
                @Override // java.lang.Runnable
                public void run() {
                    COUIBottomSheetBehavior.this.settleToState(v3, i3);
                }
            });
        } else {
            settleToState(v3, i3);
        }
    }

    private void startPanelTranslateAnimation(final View view, int i3, int i4, float f3, PathInterpolator pathInterpolator) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
        ofFloat.setDuration((long) f3);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.offsetTopAndBottom(floatValue - COUIBottomSheetBehavior.this.mLastOffsetInFling);
                COUIBottomSheetBehavior.this.dispatchOnSlide(view.getTop());
                COUIBottomSheetBehavior.this.mLastOffsetInFling = floatValue;
                if (COUIBottomSheetBehavior.this.mPullUpListener != null) {
                    COUIBottomSheetBehavior.this.calculatePanelOutsideAlpha(view);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetBehavior.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                COUIBottomSheetBehavior.this.setStateInternal(5);
            }
        });
        this.mLastOffsetInFling = view.getTop();
        view.offsetTopAndBottom(view.getTop());
        ofFloat.start();
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
            float f3 = z3 ? SETTLE_ANIM_SPRING_BOUNCE : 1.0f;
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

    public void applyPhysics(float f3, float f4) {
        if (f3 == PHYSICS_UNSET || f4 == PHYSICS_UNSET) {
            this.mPhysicsEnable = false;
            return;
        }
        this.mPhysicsEnable = true;
        this.mDragFrequency = f3;
        this.mDragDampingRatio = f4;
        this.mPhysicalAnimator = i.e(this.mContext);
        this.mDragValueHolder = new h(SETTLE_ANIM_SPRING_BOUNCE);
        C0579f c0579f = (C0579f) ((C0579f) new C0579f().G(this.mDragValueHolder)).x(this.mDragFrequency, this.mDragDampingRatio).b(null);
        this.mDragBehavior = c0579f;
        this.mPhysicalAnimator.c(c0579f);
        this.mPhysicalAnimator.a(this.mDragBehavior, this);
        this.mPhysicalAnimator.b(this.mDragBehavior, this);
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

    public int getPeekHeightMin() {
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

    public boolean isPanelHeightChangeAnimRunning() {
        Z.c cVar = this.mPanelHeightChangeAnim;
        if (cVar != null) {
            return cVar.h();
        }
        return false;
    }

    public void onAnimationCancel(AbstractC0576c abstractC0576c) {
    }

    @Override // s1.InterfaceC0574a
    public void onAnimationEnd(AbstractC0576c abstractC0576c) {
    }

    @Override // s1.InterfaceC0574a
    public void onAnimationStart(AbstractC0576c abstractC0576c) {
    }

    @Override // s1.InterfaceC0575b
    public void onAnimationUpdate(AbstractC0576c abstractC0576c) {
        if (abstractC0576c.n() != null) {
            this.mDragCurrentValue = ((Float) abstractC0576c.n()).floatValue();
        }
        if (this.mDragChild != null) {
            y.U(this.mDragChild, -((int) (r2.getTop() - this.mDragCurrentValue)));
            dispatchOnSlide(this.mDragChild.getTop());
        }
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
        COUIViewDragHelper cOUIViewDragHelper;
        if (!v3.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Z.c cVar = this.mPanelHeightChangeAnim;
            this.mPressDownState = (cVar == null || !cVar.h()) ? getState() : this.mSettleTargetState;
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.initialX = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            this.initialY = y3;
            if (!this.mGlobalDrag && !isClickedOnBar(v3, this.initialX, y3)) {
                this.ignoreEvents = true;
                return false;
            }
            this.ignoreEvents = false;
            if (this.state != 2) {
                OnNestedScrollingChild onNestedScrollingChild = this.mOnNestedScrollingChild;
                if (onNestedScrollingChild != null && (this.nestedScrollingChildRef == null || onNestedScrollingChild.getNestedScrollingChild() != this.nestedScrollingChildRef.get())) {
                    this.nestedScrollingChildRef = new WeakReference<>(this.mOnNestedScrollingChild.getNestedScrollingChild());
                }
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, this.initialX, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(y0.j.e(motionEvent, motionEvent.getActionIndex()));
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
        if (!this.ignoreEvents && (cOUIViewDragHelper = this.viewDragHelper) != null && cOUIViewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return view2 != null ? (actionMasked != 2 || this.ignoreEvents || this.state == 1 || coordinatorLayout.B(view2, this.initialX, this.initialY) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true : (actionMasked != 2 || this.ignoreEvents || this.state == 1 || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        boolean z3;
        U0.g gVar;
        if (y.u(coordinatorLayout) && !y.u(v3)) {
            v3.setFitsSystemWindows(true);
        }
        float f3 = 1.0f;
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(H0.c.f519b);
            this.mDialogMaxHeight = this.mContext.getResources().getDimensionPixelOffset(U1.d.f2395w);
            setSystemGestureInsets(coordinatorLayout);
            this.viewRef = new WeakReference<>(v3);
            if (this.shapeThemingEnabled && (gVar = this.materialShapeDrawable) != null) {
                y.n0(v3, gVar);
            }
            U0.g gVar2 = this.materialShapeDrawable;
            if (gVar2 != null) {
                float f4 = this.elevation;
                if (f4 == -1.0f) {
                    f4 = y.t(v3);
                }
                gVar2.T(f4);
                boolean z4 = this.state == 3;
                this.isShapeExpanded = z4;
                this.materialShapeDrawable.V(z4 ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (y.v(v3) == 0) {
                y.u0(v3, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = COUIViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v3.getTop();
        int i4 = this.mViewHeightType;
        if (i4 == 1 || i4 == 3) {
            getLayoutRect(coordinatorLayout, v3, i3);
            Rect rect = this.mLayoutRect;
            v3.layout(rect.left, rect.top, rect.right, this.mLayoutBottom);
        } else {
            coordinatorLayout.I(v3, i3);
        }
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        this.parentRootViewHeight = coordinatorLayout.getRootView().getHeight();
        this.parentMarginTop = COUIViewMarginUtil.getMargin(coordinatorLayout, 1);
        if (DEBUG) {
            Log.d(TAG, "onLayoutChild: parentHeight=" + this.parentHeight + " parentRootViewHeight=" + this.parentRootViewHeight + " marginTop=" + this.parentMarginTop);
        }
        if (v3 instanceof COUIPanelPercentFrameLayout) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = (COUIPanelPercentFrameLayout) v3;
            f3 = cOUIPanelPercentFrameLayout.getRatio();
            z3 = cOUIPanelPercentFrameLayout.getHasAnchor();
        } else {
            z3 = false;
        }
        if (!this.mIsIgnoreExpandedOffsetChange) {
            int marginBottom = getMarginBottom(v3);
            if (z3) {
                this.fitToContentsOffset = 0;
            } else {
                this.fitToContentsOffset = (int) Math.max(SETTLE_ANIM_SPRING_BOUNCE, ((this.parentHeight - marginBottom) / f3) - ((v3.getHeight() - this.mPanelPaddingBottom) / f3));
            }
            if (this.mIsHandlePanel) {
                this.expandedOffset = this.fitToContentsOffset;
            }
        }
        if (DEBUG) {
            Log.d(TAG, "updateFollowHandPanelLocation fitToContentsOffset:" + this.fitToContentsOffset + " expandOffset=" + this.expandedOffset + " mIsHandlePanel=" + this.mIsHandlePanel);
        }
        this.mIsIgnoreExpandedOffsetChange = false;
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i5 = this.state;
        if (i5 == 3) {
            int i6 = this.mViewHeightType;
            if (i6 == 2) {
                y.U(v3, this.mCurTop);
            } else if (i6 != 4) {
                y.U(v3, getExpandedOffset());
            } else {
                y.U(v3, this.mCurTop);
                setOutlineBottomOffset(Math.abs(this.mWantTop - this.mCurTop) * (-2));
                v3.invalidateOutline();
            }
        } else if (i5 == 6) {
            y.U(v3, this.halfExpandedOffset);
        } else if (this.hideable && i5 == 5) {
            y.U(v3, this.parentHeight);
        } else if (i5 == 4) {
            y.U(v3, this.collapsedOffset);
        } else if (i5 == 1 || i5 == 2) {
            y.U(v3, top - v3.getTop());
        }
        if (DEBUG) {
            Log.e(TAG, "behavior parentHeight: " + this.parentHeight + " marginBottom: " + getMarginBottom(v3) + "\n mDesignBottomSheetFrameLayout.getRatio()" + f3 + " fitToContentsOffset: " + this.fitToContentsOffset + " H: " + v3.getMeasuredHeight() + "\n Y: " + v3.getY() + " getExpandedOffset" + getExpandedOffset());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v3));
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, int i5, int i6) {
        boolean onMeasureChild = super.onMeasureChild(coordinatorLayout, v3, i3, i4, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) + v3.getPaddingBottom(), View.MeasureSpec.getMode(i5)), i6);
        int measuredHeight = v3.getMeasuredHeight();
        if (!this.mStartHeightChangeAnim || getState() != 3 || this.mLayoutAtMaxHeight || measuredHeight == this.mLastMeasureHeight) {
            this.mViewHeightType = 0;
            this.mStartHeightChangeAnim = false;
        } else {
            if (this.mPanelHeightChangeAnim == null) {
                createPanelHeightChangeAnim();
            }
            this.mPanelHeightSpringForce.g(0.4f);
            setOutlineBottomOffset(0);
            this.mCurTop = v3.getTop();
            this.mWantTop = getWantTop(v3, measuredHeight);
            int i7 = this.mLastMeasureHeight;
            if (measuredHeight < i7) {
                this.mLayoutBottom = i7;
                if (isPanelCenterDisplay()) {
                    this.mViewHeightType = 3;
                } else {
                    this.mViewHeightType = 1;
                }
                this.mPanelHeightChangeAnim.o(this.mCurTop);
                this.mPanelHeightChangeAnim.u(this.mWantTop);
            } else if (measuredHeight > i7) {
                if (isPanelCenterDisplay()) {
                    this.mViewHeightType = 4;
                } else {
                    this.mViewHeightType = 2;
                }
                this.mPanelHeightChangeAnim.o(this.mCurTop);
                this.mPanelHeightChangeAnim.u(this.mWantTop);
            }
        }
        this.mLastMeasureHeight = measuredHeight;
        return onMeasureChild;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v3, View view, float f3, float f4) {
        WeakReference<View> weakReference;
        this.mYVelocity = -f4;
        if (this.mIsNestedScrollingCheckEnabled || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get()) {
            return false;
        }
        return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v3, view, f3, f4);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 1 || this.mIsNestedScrollingCheckEnabled) {
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
                iArr[1] = top - getExpandedOffset();
                calculatePanelOutsideAlpha(v3);
                if (this.mPhysicsEnable) {
                    dragToNewTop(v3, getExpandedOffset());
                } else {
                    y.U(v3, -iArr[1]);
                }
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                calculatePanelOutsideAlpha(v3);
                iArr[1] = i4;
                if (this.mPhysicsEnable) {
                    dragToNewTop(v3, i6);
                } else {
                    y.U(v3, -i4);
                }
                setStateInternal(1);
            }
        } else if (i4 < 0 && !view.canScrollVertically(-1)) {
            if (i6 > this.collapsedOffset && !this.hideable) {
                calculatePanelOutsideAlpha(v3);
                int i7 = this.collapsedOffset;
                int i8 = top - i7;
                iArr[1] = i8;
                if (this.mPhysicsEnable) {
                    dragToNewTop(v3, i7);
                } else {
                    y.U(v3, -i8);
                }
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i4;
                if (i4 < -100) {
                    i4 = (int) (i4 * 0.5f);
                }
                calculatePanelOutsideAlpha(v3);
                if (this.mPhysicsEnable) {
                    dragToNewTop(v3, i6);
                } else {
                    y.U(v3, -i4);
                }
                setStateInternal(1);
            }
        }
        if (!this.mPhysicsEnable) {
            dispatchOnSlide(v3.getTop());
        }
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
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (COUIBottomSheetBehavior<?>) this);
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
        if (this.mPhysicsEnable && this.mDragBehavior.Q()) {
            this.mDragBehavior.M(SETTLE_ANIM_SPRING_BOUNCE);
            this.mDragChild = null;
        }
        int i5 = 3;
        if (v3.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy <= 0) {
                if (this.hideable && shouldHide(v3, getYVelocity())) {
                    COUIPanelDragListener cOUIPanelDragListener = this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener == null || !cOUIPanelDragListener.onDragWhileEditing()) {
                        i4 = this.parentRootViewHeight;
                        this.mCanHideKeyboard = true;
                        i5 = 5;
                    } else {
                        i4 = this.fitToContentsOffset;
                        this.mCanHideKeyboard = false;
                    }
                } else if (this.lastNestedScrollDy == 0) {
                    int top = v3.getTop();
                    if (!this.fitToContents) {
                        int i6 = this.halfExpandedOffset;
                        if (top < i6) {
                            if (top < Math.abs(top - this.collapsedOffset)) {
                                i4 = this.expandedOffset;
                            } else {
                                i4 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top - i6) < Math.abs(top - this.collapsedOffset)) {
                            i4 = this.halfExpandedOffset;
                        } else {
                            i4 = this.collapsedOffset;
                            i5 = 4;
                        }
                        i5 = 6;
                    } else if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                        i4 = this.fitToContentsOffset;
                    } else {
                        i4 = this.collapsedOffset;
                        i5 = 4;
                    }
                } else {
                    if (this.fitToContents) {
                        COUIPanelDragListener cOUIPanelDragListener2 = this.mCOUIPanelDragListener;
                        if (cOUIPanelDragListener2 == null) {
                            i4 = this.collapsedOffset;
                        } else if (cOUIPanelDragListener2.onDragWhileEditing()) {
                            i4 = this.fitToContentsOffset;
                        } else {
                            i4 = this.parentRootViewHeight;
                            i5 = 5;
                        }
                    } else {
                        int top2 = v3.getTop();
                        int i7 = this.halfExpandedOffset;
                        boolean z3 = top2 > i7 && top2 < this.collapsedOffset;
                        if (this.mPressDownState == 6 && z3) {
                            i4 = this.collapsedOffset;
                        } else if (Math.abs(top2 - i7) < Math.abs(top2 - this.collapsedOffset)) {
                            i4 = this.halfExpandedOffset;
                            i5 = 6;
                        } else {
                            i4 = this.collapsedOffset;
                        }
                    }
                    i5 = 4;
                }
            } else if (this.fitToContents) {
                i4 = this.fitToContentsOffset;
            } else {
                int top3 = v3.getTop();
                int i8 = this.halfExpandedOffset;
                if (top3 > i8) {
                    i5 = 6;
                    i4 = i8;
                } else {
                    i4 = this.expandedOffset;
                }
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
        COUIViewDragHelper cOUIViewDragHelper = this.viewDragHelper;
        if (cOUIViewDragHelper != null) {
            try {
                cOUIViewDragHelper.processTouchEvent(motionEvent);
            } catch (Exception e3) {
                e3.printStackTrace();
                return true;
            }
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        this.mYVelocity = getYVelocity();
        if (actionMasked == 2 && !this.ignoreEvents && this.viewDragHelper != null && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
            this.viewDragHelper.captureChildView(v3, motionEvent.getPointerId(y0.j.e(motionEvent, motionEvent.getActionIndex())));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        this.callbacks.remove(cOUIBottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        if (DEBUG) {
            Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        }
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

    public void setGlobalDrag(boolean z3) {
        this.mGlobalDrag = z3;
    }

    public void setHalfExpandOffsetUseParentRootViewHeight(boolean z3) {
        this.mHalfExpandOffsetUseParentRootViewHeight = z3;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHalfExpandedRatio(float f3) {
        if (f3 <= SETTLE_ANIM_SPRING_BOUNCE || f3 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f3;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHeightChangeAnim(boolean z3) {
        WeakReference<V> weakReference;
        this.mStartHeightChangeAnim = z3;
        if (z3 && isPanelCenterDisplay() && (weakReference = this.viewRef) != null && (weakReference.get() instanceof COUIPanelPercentFrameLayout)) {
            ((COUIPanelPercentFrameLayout) this.viewRef.get()).prepareForOutlineProvider();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public void setHideable(boolean z3) {
        if (this.hideable != z3) {
            this.hideable = z3;
            if (!z3 && this.state == 5) {
                setPanelState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setIsHandlePanel(boolean z3) {
        this.mIsHandlePanel = z3;
    }

    public void setIsInTinyScreen(boolean z3) {
        this.mIsInTinyScreen = z3;
    }

    public void setIsNestedScrollingCheckEnabled(boolean z3) {
        this.mIsNestedScrollingCheckEnabled = z3;
    }

    void setLayoutAtMaxHeight(boolean z3) {
        this.mLayoutAtMaxHeight = z3;
    }

    public void setOnNestedScrollingChild(OnNestedScrollingChild onNestedScrollingChild) {
        this.mOnNestedScrollingChild = onNestedScrollingChild;
    }

    public void setOnPanelHeightChangeAnimListener(OnPanelHeightChangeAnimListener onPanelHeightChangeAnimListener) {
        this.mPanelHeightChangeAnimListener = onPanelHeightChangeAnimListener;
    }

    public void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        this.mCOUIPanelDragListener = cOUIPanelDragListener;
    }

    void setPanelPaddingBottom(int i3) {
        this.mPanelPaddingBottom = i3;
    }

    public void setPanelPeekHeight(int i3) {
        setPanelPeekHeight(i3, false);
    }

    public void setPanelSkipCollapsed(boolean z3) {
        this.skipCollapsed = z3;
    }

    public void setPanelState(int i3) {
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

    public void setPullUpListener(COUIPanelPullUpListener cOUIPanelPullUpListener) {
        this.mPullUpListener = cOUIPanelPullUpListener;
    }

    void setPullUpToDismissPanelListener(PullUpToDismissPanelListener pullUpToDismissPanelListener) {
        this.mPullUpToDismissPanelListener = pullUpToDismissPanelListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSaveFlags(int i3) {
        this.saveFlags = i3;
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
            i4 = this.parentRootViewHeight;
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
        return Math.abs((((float) view.getTop()) + (f3 * HIDE_FRICTION)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
    }

    public void startSettleRunnable(View view, int i3, int i4) {
        if (this.mPanelHeightChangeAnim == null) {
            createPanelHeightChangeAnim();
        }
        if (i3 == 5) {
            float top = this.parentHeight - view.getTop();
            float f3 = this.parentHeight;
            float f4 = SETTLE_ANIM_SPRING_BOUNCE;
            if (top > SETTLE_ANIM_SPRING_BOUNCE && f3 != SETTLE_ANIM_SPRING_BOUNCE) {
                f4 = top / f3;
            }
            this.mPanelHeightSpringForce.g(0.18f + (0.19f * f4));
        } else {
            this.mPanelHeightSpringForce.g(0.4f);
        }
        if (this.mPanelHeightChangeAnim.h()) {
            this.mSettleTargetState = i3;
            return;
        }
        this.mSettleTargetState = i3;
        COUIViewDragHelper cOUIViewDragHelper = this.viewDragHelper;
        if (cOUIViewDragHelper == null || cOUIViewDragHelper.getCapturedView() == null || this.viewDragHelper.getViewDragState() != 2) {
            setStateInternal(this.mSettleTargetState);
            return;
        }
        setShakeHandMovingDirection(this.mYVelocity);
        int top2 = this.viewDragHelper.getCapturedView().getTop();
        this.mStartTopValue = top2;
        this.mPanelHeightChangeAnim.o(top2);
        this.mPanelHeightChangeAnim.p(this.mYVelocity);
        this.mPanelHeightChangeAnim.u(i4);
    }

    void startSettlingAnimation(View view, int i3, int i4, boolean z3) {
        if ((z3 && getState() == 1) ? this.viewDragHelper.settleCapturedViewAt(view.getLeft(), i4) : this.viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i4)) {
            setStateInternal(2);
            updateDrawableForTargetState(i3);
            getYVelocity();
            if (!this.mIsInTinyScreen) {
                if (i3 == 5 && isImeVisible(view) && isInFreeFormModeWindowMode()) {
                    i4 += y0.j.j(this.mContext);
                }
                startSettleRunnable(view, i3, i4);
            } else if (i3 == 5) {
                startPanelTranslateAnimation(view, 0, this.mContext.getResources().getDimensionPixelOffset(U1.d.f2396x), DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION, new Y.f());
            } else {
                startSettleRunnable(view, i3, i4);
            }
        } else {
            setStateInternal(i3);
        }
        PullUpToDismissPanelListener pullUpToDismissPanelListener = this.mPullUpToDismissPanelListener;
        if (pullUpToDismissPanelListener == null || i3 != 5) {
            return;
        }
        pullUpToDismissPanelListener.onPullUpDismiss();
    }

    void stopSettlingAnimationIfRunning() {
        Z.c cVar = this.mPanelHeightChangeAnim;
        if (cVar == null || !cVar.h()) {
            return;
        }
        this.mPanelHeightChangeAnim.c();
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
}
