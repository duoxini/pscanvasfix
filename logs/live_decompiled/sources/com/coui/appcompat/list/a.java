package com.coui.appcompat.list;

import M1.l;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import p0.C0495a;

/* loaded from: classes.dex */
public abstract class a extends ListView implements C0495a.c {
    private static final float DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE = 20.0f;
    private static final double DEGREE_TO_ARC_CONSTANT = 0.017453292519943295d;
    private static final int INVALID_SCROLL_CHOICE_POSITION = -2;
    private static final int SCROLLBARS_NONE = 0;
    private static final int SCROLLBARS_VERTICAL = 512;
    private static final long SCROLL_CHOICE_SCROLL_DELAY = 50;
    private static final String TAG = "COUIListView";
    private C0495a mCOUIScrollBar;
    private int mCheckItemId;
    private Runnable mDelayedScroll;
    private boolean mEnableDispatchEventWhileScrolling;
    private float mEventFilterAngle;
    private boolean mFlag;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mLastPosition;
    private int mLastSite;
    private int mLasterPosition;
    private int mLeftOffset;
    private boolean mMultiChoice;
    private int mRightOffset;
    private b mScrollMultiChoiceListener;
    private Drawable mScrollbarThumbVertical;
    private int mScrollbars;
    private int mScrollbarsSize;
    private int mStyle;
    private boolean mUpScroll;

    /* renamed from: com.coui.appcompat.list.a$a, reason: collision with other inner class name */
    class RunnableC0104a implements Runnable {
        RunnableC0104a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.mUpScroll) {
                a.this.setSelectionFromTop(r0.getFirstVisiblePosition() - 1, -a.this.getPaddingTop());
            } else {
                a aVar = a.this;
                aVar.a(aVar.getLastVisiblePosition() + 1, a.this.getPaddingBottom());
            }
        }
    }

    public interface b {
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, int i4) {
        setSelectionFromTop(i3, (((getHeight() - getPaddingTop()) - getPaddingBottom()) - getChildAt(getChildCount() - 1).getHeight()) + i4);
    }

    private void b(Context context) {
        this.mCOUIScrollBar = new C0495a.b(this).a();
    }

    private void c(Context context, AttributeSet attributeSet, int i3, int i4) {
        if (attributeSet == null || attributeSet.getStyleAttribute() == 0) {
            this.mStyle = i3;
        } else {
            this.mStyle = attributeSet.getStyleAttribute();
        }
        if (context != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, T1.c.f2196a, i3, i4);
            this.mScrollbars = obtainStyledAttributes.getInteger(T1.c.f2199d, 0);
            this.mScrollbarsSize = obtainStyledAttributes.getDimensionPixelSize(T1.c.f2197b, 0);
            this.mScrollbarThumbVertical = obtainStyledAttributes.getDrawable(T1.c.f2198c);
            obtainStyledAttributes.recycle();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        try {
            if (this.mCheckItemId <= 0) {
                this.mMultiChoice = false;
                return false;
            }
            CheckBox checkBox = (CheckBox) getChildAt(pointToPosition - getFirstVisiblePosition()).findViewById(this.mCheckItemId);
            checkBox.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = i3 - this.mLeftOffset;
            int i5 = i3 + this.mRightOffset;
            if (checkBox.getVisibility() == 0 && rawX > i4 && rawX < i5 && pointToPosition > getHeaderViewsCount() - 1 && pointToPosition < getCount() - getFooterViewsCount()) {
                this.mMultiChoice = true;
                return true;
            }
            if (motionEvent.getActionMasked() == 0) {
                this.mMultiChoice = false;
            }
            return false;
        } catch (Exception unused) {
            if (motionEvent.getActionMasked() == 0) {
                this.mMultiChoice = false;
            }
            return false;
        }
    }

    @Override // android.view.View
    protected boolean awakenScrollBars() {
        C0495a c0495a = this.mCOUIScrollBar;
        return c0495a != null ? c0495a.c() : super.awakenScrollBars();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.e(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mEnableDispatchEventWhileScrolling && (motionEvent.getAction() & 255) == 0) {
            super.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public C0495a getCOUIScrollDelegate() {
        return this.mCOUIScrollBar;
    }

    @Override // p0.C0495a.c
    public View getCOUIScrollableView() {
        return this;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.h();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null) {
            c0495a.q();
            this.mCOUIScrollBar = null;
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C0495a c0495a = this.mCOUIScrollBar;
        if (c0495a != null && c0495a.j(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mInitialTouchX = (int) motionEvent.getX();
            this.mInitialTouchY = (int) motionEvent.getY();
            if (d(motionEvent)) {
                return true;
            }
        }
        if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.mInitialTouchX);
            float abs2 = Math.abs(motionEvent.getY() - this.mInitialTouchY);
            if (abs != 0.0f && this.mEnableDispatchEventWhileScrolling && Math.abs(abs2 / abs) < Math.tan(this.mEventFilterAngle * DEGREE_TO_ARC_CONSTANT)) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r4 != 2) goto L23;
     */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            p0.a r0 = r6.mCOUIScrollBar
            r1 = 1
            if (r0 == 0) goto Lc
            boolean r0 = r0.l(r7)
            if (r0 == 0) goto Lc
            return r1
        Lc:
            boolean r0 = r6.mMultiChoice
            r2 = 0
            r3 = -2
            if (r0 == 0) goto L44
            boolean r0 = r6.d(r7)
            if (r0 == 0) goto L44
            float r0 = r7.getX()
            int r0 = (int) r0
            float r4 = r7.getY()
            int r4 = (int) r4
            int r0 = r6.pointToPosition(r0, r4)
            int r4 = r7.getActionMasked()
            if (r4 == 0) goto L37
            if (r4 == r1) goto L32
            r5 = 2
            if (r4 == r5) goto L39
            goto L44
        L32:
            r6.mLastPosition = r3
            r6.mLasterPosition = r3
            goto L44
        L37:
            r6.mFlag = r1
        L39:
            int r7 = r6.getCount()
            int r7 = r7 - r1
            if (r0 != r7) goto L43
            r6.a(r0, r2)
        L43:
            return r1
        L44:
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == r1) goto L50
            r4 = 3
            if (r0 == r4) goto L50
            goto L5d
        L50:
            r6.mUpScroll = r1
            r6.mLastPosition = r3
            r6.mLasterPosition = r3
            r6.mFlag = r2
            r6.mMultiChoice = r1
            r0 = -1
            r6.mLastSite = r0
        L5d:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.list.a.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
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

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, T1.c.f2196a, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, T1.c.f2196a, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mScrollbarThumbVertical = typedArray.getDrawable(T1.c.f2198c);
            typedArray.recycle();
        }
        if (this.mScrollbars == SCROLLBARS_VERTICAL) {
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.s(drawable);
            } else {
                this.mCOUIScrollBar.p();
            }
        }
        invalidate();
    }

    public void setCheckItemId(int i3) {
        this.mCheckItemId = i3;
    }

    public void setDispatchEventWhileScrolling(boolean z3) {
        this.mEnableDispatchEventWhileScrolling = z3;
    }

    public void setEventFilterTangent(float f3) {
        this.mEventFilterAngle = f3;
    }

    public void setNewCOUIScrollDelegate(C0495a c0495a) {
        if (c0495a == null) {
            throw new IllegalArgumentException("setNewFastScrollDelegate must NOT be NULL.");
        }
        this.mCOUIScrollBar = c0495a;
        c0495a.h();
    }

    public void setScrollMultiChoiceListener(b bVar) {
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

    public a(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, l.f1504d);
    }

    public a(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mMultiChoice = true;
        this.mLastPosition = INVALID_SCROLL_CHOICE_POSITION;
        this.mLasterPosition = INVALID_SCROLL_CHOICE_POSITION;
        this.mFlag = false;
        this.mUpScroll = true;
        this.mLastSite = -1;
        this.mCheckItemId = -1;
        this.mScrollbars = 0;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mEnableDispatchEventWhileScrolling = false;
        this.mDelayedScroll = new RunnableC0104a();
        c(context, attributeSet, i3, i4);
        if (this.mScrollbars == SCROLLBARS_VERTICAL) {
            b(context);
            int i5 = this.mScrollbarsSize;
            if (i5 != 0) {
                this.mCOUIScrollBar.t(i5);
            }
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.s(drawable);
            }
        }
        this.mLeftOffset = getResources().getDimensionPixelOffset(T1.a.f2193a);
        this.mRightOffset = getResources().getDimensionPixelOffset(T1.a.f2194b);
    }
}
