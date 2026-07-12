package com.google.android.material.bottomsheet;

import A.c;
import H0.i;
import H0.j;
import U0.k;
import android.R;
import android.animation.ValueAnimator;
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import androidx.core.view.y;
import com.google.android.material.internal.ViewUtils;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import x.AbstractC0626a;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = i.f641f;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
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
    int activePointerId;
    private ColorStateList backgroundTint;
    private final ArrayList<f> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final c.AbstractC0002c dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private U0.g materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private k shapeAppearanceModelDefault;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.h stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    A.c viewDragHelper;
    WeakReference<V> viewRef;

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f9421e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f9422f;

        a(View view, int i3) {
            this.f9421e = view;
            this.f9422f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.l(this.f9421e, this.f9422f, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                BottomSheetBehavior.this.materialShapeDrawable.V(floatValue);
            }
        }
    }

    class c implements ViewUtils.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9425a;

        c(boolean z3) {
            this.f9425a = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.J onApplyWindowInsets(android.view.View r11, androidx.core.view.J r12, com.google.android.material.internal.ViewUtils.RelativePadding r13) {
            /*
                r10 = this;
                int r0 = androidx.core.view.J.l.h()
                androidx.core.graphics.b r0 = r12.f(r0)
                int r1 = androidx.core.view.J.l.e()
                androidx.core.graphics.b r1 = r12.f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.f4901b
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$302(r2, r3)
                boolean r2 = com.google.android.material.internal.ViewUtils.isLayoutRtl(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$400(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.h()
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$502(r3, r6)
                int r3 = r13.bottom
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$500(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$600(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.end
                goto L50
            L4e:
                int r4 = r13.start
            L50:
                int r6 = r0.f4900a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$700(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.start
                goto L62
            L60:
                int r13 = r13.end
            L62:
                int r2 = r0.f4902c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$800(r2)
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.f4900a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r7
                goto L81
            L80:
                r2 = r6
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$900(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.f4902c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                r2 = r7
            L92:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$1000(r8)
                if (r8 == 0) goto La3
                int r8 = r13.topMargin
                int r0 = r0.f4901b
                if (r8 == r0) goto La3
                r13.topMargin = r0
                goto La4
            La3:
                r7 = r2
            La4:
                if (r7 == 0) goto La9
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.f9425a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.f4903d
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$1102(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.access$400(r11)
                if (r11 != 0) goto Lc7
                boolean r11 = r10.f9425a
                if (r11 == 0) goto Lcc
            Lc7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.access$1200(r10, r6)
            Lcc:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.onApplyWindowInsets(android.view.View, androidx.core.view.J, com.google.android.material.internal.ViewUtils$RelativePadding):androidx.core.view.J");
        }
    }

    class d extends c.AbstractC0002c {

        /* renamed from: a, reason: collision with root package name */
        private long f9427a;

        d() {
        }

        private boolean releasedLow(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
        }

        @Override // A.c.AbstractC0002c
        public int clampViewPositionHorizontal(View view, int i3, int i4) {
            return view.getLeft();
        }

        @Override // A.c.AbstractC0002c
        public int clampViewPositionVertical(View view, int i3, int i4) {
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return AbstractC0626a.b(i3, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
        }

        @Override // A.c.AbstractC0002c
        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset;
        }

        @Override // A.c.AbstractC0002c
        public void onViewDragStateChanged(int i3) {
            if (i3 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // A.c.AbstractC0002c
        public void onViewPositionChanged(View view, int i3, int i4, int i5, int i6) {
            BottomSheetBehavior.this.dispatchOnSlide(i4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        
            if (r7.f9428b.shouldExpandOnUpwardDrag(r0, (r9 * 100.0f) / r10.parentHeight) != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        
            if (r9 > r7.f9428b.halfExpandedOffset) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
        
            if (java.lang.Math.abs(r8.getTop() - r7.f9428b.getExpandedOffset()) < java.lang.Math.abs(r8.getTop() - r7.f9428b.halfExpandedOffset)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c9, code lost:
        
            if (r7.f9428b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
        
            if (java.lang.Math.abs(r9 - r7.f9428b.fitToContentsOffset) < java.lang.Math.abs(r9 - r7.f9428b.collapsedOffset)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0107, code lost:
        
            if (r7.f9428b.shouldSkipHalfExpandedStateWhenDragging() != false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0121, code lost:
        
            if (r7.f9428b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L63;
         */
        @Override // A.c.AbstractC0002c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.onViewReleased(android.view.View, float, float):void");
        }

        @Override // A.c.AbstractC0002c
        public boolean tryCaptureView(View view, int i3) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i4 = bottomSheetBehavior.state;
            if (i4 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i4 == 3 && bottomSheetBehavior.activePointerId == i3) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f9427a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class e implements androidx.core.view.accessibility.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9429a;

        e(int i3) {
            this.f9429a = i3;
        }

        @Override // androidx.core.view.accessibility.g
        public boolean perform(View view, g.a aVar) {
            BottomSheetBehavior.this.setState(this.f9429a);
            return true;
        }
    }

    public static abstract class f {
        void onLayout(View view) {
        }

        public abstract void onSlide(View view, float f3);

        public abstract void onStateChanged(View view, int i3);
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new h(this, null);
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new d();
    }

    private int a(View view, int i3, int i4) {
        return y.b(view, view.getResources().getString(i3), b(i4));
    }

    private androidx.core.view.accessibility.g b(int i3) {
        return new e(i3);
    }

    private void c(Context context) {
        if (this.shapeAppearanceModelDefault == null) {
            return;
        }
        U0.g gVar = new U0.g(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = gVar;
        gVar.K(context);
        ColorStateList colorStateList = this.backgroundTint;
        if (colorStateList != null) {
            this.materialShapeDrawable.U(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
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
        int i3;
        int i4;
        int i5;
        if (this.peekHeightAuto) {
            i3 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
            i4 = this.insetBottom;
        } else {
            if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (i5 = this.gestureInsetBottom) > 0) {
                return Math.max(this.peekHeight, i5 + this.peekHeightGestureInsetBuffer);
            }
            i3 = this.peekHeight;
            i4 = this.insetBottom;
        }
        return i3 + i4;
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new b());
    }

    private int d(int i3, int i4, int i5, int i6) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, i4, i6);
        if (i5 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i5), 1073741824);
        }
        if (size != 0) {
            i5 = Math.min(size, i5);
        }
        return View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
    }

    private int e(int i3) {
        if (i3 == 3) {
            return getExpandedOffset();
        }
        if (i3 == 4) {
            return this.collapsedOffset;
        }
        if (i3 == 5) {
            return this.parentHeight;
        }
        if (i3 == 6) {
            return this.halfExpandedOffset;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i3);
    }

    private boolean f(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && y.N(view);
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c e3 = ((CoordinatorLayout.f) layoutParams).e();
        if (e3 instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) e3;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private void g(View view, d.a aVar, int i3) {
        y.e0(view, aVar, null, b(i3));
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void h(g gVar) {
        int i3 = this.saveFlags;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.peekHeight = gVar.f9432f;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.fitToContents = gVar.f9433g;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.hideable = gVar.f9434h;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.skipCollapsed = gVar.f9435i;
        }
    }

    private void i(View view, Runnable runnable) {
        if (f(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void j(View view) {
        boolean z3 = (isGestureInsetBottomIgnored() || this.peekHeightAuto) ? false : true;
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z3) {
            ViewUtils.doOnApplyWindowInsets(view, new c(z3));
        }
    }

    private boolean k() {
        return this.viewDragHelper != null && (this.draggable || this.state == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view, int i3, boolean z3) {
        int e3 = e(i3);
        A.c cVar = this.viewDragHelper;
        if (cVar == null || (!z3 ? cVar.H(view, view.getLeft(), e3) : cVar.F(view.getLeft(), e3))) {
            setStateInternal(i3);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i3);
        this.stateSettlingTracker.c(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z3) {
        V v3;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (v3 = this.viewRef.get()) == null) {
                return;
            }
            if (z3) {
                setState(4);
            } else {
                v3.requestLayout();
            }
        }
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
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
        int i3 = this.expandHalfwayActionId;
        if (i3 != -1) {
            y.c0(v3, i3);
        }
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionId = a(v3, H0.h.f620a, 6);
        }
        if (this.hideable && this.state != 5) {
            g(v3, d.a.f5101y, 5);
        }
        int i4 = this.state;
        if (i4 == 3) {
            g(v3, d.a.f5100x, this.fitToContents ? 4 : 6);
            return;
        }
        if (i4 == 4) {
            g(v3, d.a.f5099w, this.fitToContents ? 3 : 6);
        } else {
            if (i4 != 6) {
                return;
            }
            g(v3, d.a.f5100x, 4);
            g(v3, d.a.f5099w, 3);
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
            if (!z3) {
                this.importantForAccessibilityMap = null;
            } else if (this.updateImportantForAccessibilityOnSiblings) {
                this.viewRef.get().sendAccessibilityEvent(8);
            }
        }
    }

    public void addBottomSheetCallback(f fVar) {
        if (this.callbacks.contains(fVar)) {
            return;
        }
        this.callbacks.add(fVar);
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
        if (y.P(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
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

    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    U0.g getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getState() {
        return this.state;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        A.c cVar;
        if (!view.isShown() || !this.draggable) {
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
            int x3 = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.B(view2, x3, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.B(view, x3, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
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
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        View view3 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.B(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.u())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (y.u(coordinatorLayout) && !y.u(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(H0.c.f519b);
            j(view);
            this.viewRef = new WeakReference<>(view);
            U0.g gVar = this.materialShapeDrawable;
            if (gVar != null) {
                y.n0(view, gVar);
                U0.g gVar2 = this.materialShapeDrawable;
                float f3 = this.elevation;
                if (f3 == -1.0f) {
                    f3 = y.t(view);
                }
                gVar2.T(f3);
                boolean z3 = this.state == 3;
                this.isShapeExpanded = z3;
                this.materialShapeDrawable.V(z3 ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    y.o0(view, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (y.v(view) == 0) {
                y.u0(view, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = A.c.m(coordinatorLayout, this.dragCallback);
        }
        int top = view.getTop();
        coordinatorLayout.I(view, i3);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.childHeight = height;
        int i4 = this.parentHeight;
        int i5 = i4 - height;
        int i6 = this.insetTop;
        if (i5 < i6) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i4;
            } else {
                this.childHeight = i4 - i6;
            }
        }
        this.fitToContentsOffset = Math.max(0, i4 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i7 = this.state;
        if (i7 == 3) {
            y.U(view, getExpandedOffset());
        } else if (i7 == 6) {
            y.U(view, this.halfExpandedOffset);
        } else if (this.hideable && i7 == 5) {
            y.U(view, this.parentHeight);
        } else if (i7 == 4) {
            y.U(view, this.collapsedOffset);
        } else if (i7 == 1 || i7 == 2) {
            y.U(view, top - view.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(view));
        for (int i8 = 0; i8 < this.callbacks.size(); i8++) {
            this.callbacks.get(i8).onLayout(view);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        v3.measure(d(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, this.maxWidth, marginLayoutParams.width), d(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4) {
        WeakReference<View> weakReference;
        if (isNestedScrollingCheckEnabled() && (weakReference = this.nestedScrollingChildRef) != null && view2 == weakReference.get()) {
            return this.state != 3 || super.onNestedPreFling(coordinatorLayout, view, view2, f3, f4);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        View view3 = weakReference != null ? weakReference.get() : null;
        if (!isNestedScrollingCheckEnabled() || view2 == view3) {
            int top = view.getTop();
            int i6 = top - i4;
            if (i4 > 0) {
                if (i6 < getExpandedOffset()) {
                    int expandedOffset = top - getExpandedOffset();
                    iArr[1] = expandedOffset;
                    y.U(view, -expandedOffset);
                    setStateInternal(3);
                } else {
                    if (!this.draggable) {
                        return;
                    }
                    iArr[1] = i4;
                    y.U(view, -i4);
                    setStateInternal(1);
                }
            } else if (i4 < 0 && !view2.canScrollVertically(-1)) {
                int i7 = this.collapsedOffset;
                if (i6 > i7 && !this.hideable) {
                    int i8 = top - i7;
                    iArr[1] = i8;
                    y.U(view, -i8);
                    setStateInternal(4);
                } else {
                    if (!this.draggable) {
                        return;
                    }
                    iArr[1] = i4;
                    y.U(view, -i4);
                    setStateInternal(1);
                }
            }
            dispatchOnSlide(view.getTop());
            this.lastNestedScrollDy = i4;
            this.nestedScrolled = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, view, gVar.getSuperState());
        h(gVar);
        int i3 = gVar.f9431e;
        if (i3 == 1 || i3 == 2) {
            this.state = 4;
            this.lastStableState = 4;
        } else {
            this.state = i3;
            this.lastStableState = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new g(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i3 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r4.getTop() <= r2.halfExpandedOffset) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        r0 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
    
        if (java.lang.Math.abs(r3 - r2.fitToContentsOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (shouldSkipHalfExpandedStateWhenDragging() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        if (java.lang.Math.abs(r3 - r2.halfExpandedOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L51;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.getExpandedOffset()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.setStateInternal(r0)
            return
        Lf:
            boolean r3 = r2.isNestedScrollingCheckEnabled()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.nestedScrollingChildRef
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.nestedScrolled
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.lastNestedScrollDy
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.halfExpandedOffset
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.hideable
            if (r3 == 0) goto L49
            float r3 = r2.getYVelocity()
            boolean r3 = r2.shouldHide(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.lastNestedScrollDy
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.fitToContents
            if (r1 == 0) goto L68
            int r5 = r2.fitToContentsOffset
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.halfExpandedOffset
            if (r3 >= r1) goto L7e
            int r1 = r2.collapsedOffset
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.shouldSkipHalfExpandedStateWhenDragging()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.halfExpandedOffset
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.l(r4, r0, r3)
            r2.nestedScrolled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (k()) {
            this.viewDragHelper.z(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (k() && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.u()) {
            this.viewDragHelper.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(f fVar) {
        this.callbacks.remove(fVar);
    }

    @Deprecated
    public void setBottomSheetCallback(f fVar) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (fVar != null) {
            this.callbacks.add(fVar);
        }
    }

    public void setDraggable(boolean z3) {
        this.draggable = z3;
    }

    public void setExpandedOffset(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = i3;
    }

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

    public void setGestureInsetBottomIgnored(boolean z3) {
        this.gestureInsetBottomIgnored = z3;
    }

    public void setHalfExpandedRatio(float f3) {
        if (f3 <= 0.0f || f3 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f3;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideable(boolean z3) {
        if (this.hideable != z3) {
            this.hideable = z3;
            if (!z3 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setHideableInternal(boolean z3) {
        this.hideable = z3;
    }

    public void setMaxHeight(int i3) {
        this.maxHeight = i3;
    }

    public void setMaxWidth(int i3) {
        this.maxWidth = i3;
    }

    public void setPeekHeight(int i3) {
        setPeekHeight(i3, false);
    }

    public void setSaveFlags(int i3) {
        this.saveFlags = i3;
    }

    public void setSkipCollapsed(boolean z3) {
        this.skipCollapsed = z3;
    }

    public void setState(int i3) {
        if (i3 == 1 || i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i3 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.hideable && i3 == 5) {
            Log.w(TAG, "Cannot set state: " + i3);
            return;
        }
        int i4 = (i3 == 6 && this.fitToContents && e(i3) <= this.fitToContentsOffset) ? 3 : i3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            setStateInternal(i3);
        } else {
            V v3 = this.viewRef.get();
            i(v3, new a(v3, i4));
        }
    }

    void setStateInternal(int i3) {
        V v3;
        if (this.state == i3) {
            return;
        }
        this.state = i3;
        if (i3 == 4 || i3 == 3 || i3 == 6 || (this.hideable && i3 == 5)) {
            this.lastStableState = i3;
        }
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

    public boolean shouldExpandOnUpwardDrag(long j3, float f3) {
        return false;
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

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    private class h {

        /* renamed from: a, reason: collision with root package name */
        private int f9436a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f9437b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f9438c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f9437b = false;
                A.c cVar = BottomSheetBehavior.this.viewDragHelper;
                if (cVar != null && cVar.k(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.f9436a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.state == 2) {
                    bottomSheetBehavior.setStateInternal(hVar2.f9436a);
                }
            }
        }

        private h() {
            this.f9438c = new a();
        }

        void c(int i3) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f9436a = i3;
            if (this.f9437b) {
                return;
            }
            y.a0(BottomSheetBehavior.this.viewRef.get(), this.f9438c);
            this.f9437b = true;
        }

        /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public final void setPeekHeight(int i3, boolean z3) {
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
        m(z3);
    }

    protected static class g extends AbstractC0645a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        final int f9431e;

        /* renamed from: f, reason: collision with root package name */
        int f9432f;

        /* renamed from: g, reason: collision with root package name */
        boolean f9433g;

        /* renamed from: h, reason: collision with root package name */
        boolean f9434h;

        /* renamed from: i, reason: collision with root package name */
        boolean f9435i;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9431e = parcel.readInt();
            this.f9432f = parcel.readInt();
            this.f9433g = parcel.readInt() == 1;
            this.f9434h = parcel.readInt() == 1;
            this.f9435i = parcel.readInt() == 1;
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f9431e);
            parcel.writeInt(this.f9432f);
            parcel.writeInt(this.f9433g ? 1 : 0);
            parcel.writeInt(this.f9434h ? 1 : 0);
            parcel.writeInt(this.f9435i ? 1 : 0);
        }

        public g(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f9431e = bottomSheetBehavior.state;
            this.f9432f = bottomSheetBehavior.peekHeight;
            this.f9433g = bottomSheetBehavior.fitToContents;
            this.f9434h = bottomSheetBehavior.hideable;
            this.f9435i = bottomSheetBehavior.skipCollapsed;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new h(this, null);
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new d();
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(H0.c.f511K);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f685H);
        if (obtainStyledAttributes.hasValue(j.f701L)) {
            this.backgroundTint = R0.c.a(context, obtainStyledAttributes, j.f701L);
        }
        if (obtainStyledAttributes.hasValue(j.f768c0)) {
            this.shapeAppearanceModelDefault = k.e(context, attributeSet, H0.a.f472d, DEF_STYLE_RES).m();
        }
        c(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(j.f697K, -1.0f);
        if (obtainStyledAttributes.hasValue(j.f689I)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(j.f689I, -1));
        }
        if (obtainStyledAttributes.hasValue(j.f693J)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(j.f693J, -1));
        }
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
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f753Y, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f756Z, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f760a0, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f764b0, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f741V, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f745W, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(j.f749X, false);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
