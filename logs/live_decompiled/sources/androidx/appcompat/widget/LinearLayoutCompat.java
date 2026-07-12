package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.customer.feedback.sdk.activity.FeedbackActivity;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i3, int i4) {
            super(i3, i4);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i3, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt.getVisibility() != 8) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i6 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i4, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i6;
                }
            }
        }
    }

    private void b(int i3, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt.getVisibility() != 8) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i6 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i4, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i6;
                }
            }
        }
    }

    private void c(View view, int i3, int i4, int i5, int i6) {
        view.layout(i3, i4, i5 + i3, i6 + i4);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        boolean b3 = b0.b(this);
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View virtualChildAt = getVirtualChildAt(i4);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i4)) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, b3 ? virtualChildAt.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                a aVar2 = (a) virtualChildAt2.getLayoutParams();
                if (b3) {
                    left = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i3 = this.mDividerWidth;
                    right = left - i3;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (b3) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i3 = this.mDividerWidth;
                right = left - i3;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i3)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((a) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i3) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i3, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i3);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i3) {
        this.mDivider.setBounds(i3, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i3, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.mBaselineAlignedChildIndex;
        if (childCount <= i4) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i4);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i5 = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i3 = this.mGravity & FeedbackActivity.SHOW_NO_NETWORK) != 48) {
            if (i3 == 16) {
                i5 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i3 == 80) {
                i5 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return i5 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i3) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i3) {
        return getChildAt(i3);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i3) {
        if (i3 == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i3 == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            if (getChildAt(i4).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutHorizontal(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutVertical(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.mGravity
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.mTotalLength
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.mTotalLength
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = r1
        L49:
            if (r12 >= r10) goto Lcb
            android.view.View r13 = r6.getVirtualChildAt(r12)
            r14 = 1
            if (r13 != 0) goto L5a
            int r1 = r6.measureNullChild(r12)
            int r0 = r0 + r1
        L57:
            r1 = r14
            goto Lc8
        L5a:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L57
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$a r5 = (androidx.appcompat.widget.LinearLayoutCompat.a) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L76
            r1 = r11
        L76:
            int r2 = androidx.core.view.y.x(r17)
            int r1 = androidx.core.view.AbstractC0256e.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L90
            r2 = 5
            if (r1 == r2) goto L8a
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L88:
            r2 = r1
            goto L9b
        L8a:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
        L8e:
            int r1 = r1 - r2
            goto L88
        L90:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
            goto L8e
        L9b:
            boolean r1 = r6.hasDividerBeforeChildAt(r12)
            if (r1 == 0) goto La4
            int r1 = r6.mDividerHeight
            int r0 = r0 + r1
        La4:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.getLocationOffset(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.c(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.getNextLocationOffset(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.getChildrenSkipCount(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
        Lc8:
            int r12 = r12 + r1
            goto L49
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.layoutVertical(int, int, int, int):void");
    }

    void measureChildBeforeLayout(View view, int i3, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void measureHorizontal(int r40, int r41) {
        /*
            Method dump skipped, instructions count: 1293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    int measureNullChild(int i3) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x031b, code lost:
    
        if (((android.widget.LinearLayout.LayoutParams) r14).width == (-1)) goto L147;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void measureVertical(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        if (this.mOrientation == 1) {
            layoutVertical(i3, i4, i5, i6);
        } else {
            layoutHorizontal(i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.mOrientation == 1) {
            measureVertical(i3, i4);
        } else {
            measureHorizontal(i3, i4);
        }
    }

    public void setBaselineAligned(boolean z3) {
        this.mBaselineAligned = z3;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.mDividerPadding = i3;
    }

    public void setGravity(int i3) {
        if (this.mGravity != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & FeedbackActivity.SHOW_NO_NETWORK) == 0) {
                i3 |= 48;
            }
            this.mGravity = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i4 = i3 & 8388615;
        int i5 = this.mGravity;
        if ((8388615 & i5) != i4) {
            this.mGravity = i4 | ((-8388616) & i5);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z3) {
        this.mUseLargestChild = z3;
    }

    public void setOrientation(int i3) {
        if (this.mOrientation != i3) {
            this.mOrientation = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i3;
    }

    public void setVerticalGravity(int i3) {
        int i4 = i3 & FeedbackActivity.SHOW_NO_NETWORK;
        int i5 = this.mGravity;
        if ((i5 & FeedbackActivity.SHOW_NO_NETWORK) != i4) {
            this.mGravity = i4 | (i5 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f3) {
        this.mWeightSum = Math.max(0.0f, f3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        V w3 = V.w(context, attributeSet, e.j.f11358a1, i3, 0);
        androidx.core.view.y.h0(this, context, e.j.f11358a1, attributeSet, w3.r(), i3, 0);
        int k3 = w3.k(e.j.f11366c1, -1);
        if (k3 >= 0) {
            setOrientation(k3);
        }
        int k4 = w3.k(e.j.f11362b1, -1);
        if (k4 >= 0) {
            setGravity(k4);
        }
        boolean a3 = w3.a(e.j.f11370d1, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.mWeightSum = w3.i(e.j.f11378f1, -1.0f);
        this.mBaselineAlignedChildIndex = w3.k(e.j.f11374e1, -1);
        this.mUseLargestChild = w3.a(e.j.f11390i1, false);
        setDividerDrawable(w3.g(e.j.f11382g1));
        this.mShowDividers = w3.k(e.j.f11394j1, 0);
        this.mDividerPadding = w3.f(e.j.f11386h1, 0);
        w3.x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        int i3 = this.mOrientation;
        if (i3 == 0) {
            return new a(-2, -2);
        }
        if (i3 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }
}
