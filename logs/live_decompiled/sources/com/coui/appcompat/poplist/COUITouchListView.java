package com.coui.appcompat.poplist;

import Z.b;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import com.coui.appcompat.list.COUIForegroundListView;
import h0.AbstractC0371a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p0.C0495a;
import r0.C0559a;

/* loaded from: classes.dex */
public class COUITouchListView extends COUIForegroundListView implements C0495a.c {

    /* renamed from: E, reason: collision with root package name */
    private static final boolean f8111E;

    /* renamed from: A, reason: collision with root package name */
    private int f8112A;

    /* renamed from: B, reason: collision with root package name */
    private int f8113B;

    /* renamed from: C, reason: collision with root package name */
    private b f8114C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f8115D;

    /* renamed from: n, reason: collision with root package name */
    private int f8116n;

    /* renamed from: o, reason: collision with root package name */
    private Rect f8117o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f8118p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8119q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8120r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8121s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8122t;

    /* renamed from: u, reason: collision with root package name */
    private List f8123u;

    /* renamed from: v, reason: collision with root package name */
    private C0495a f8124v;

    /* renamed from: w, reason: collision with root package name */
    private View f8125w;

    /* renamed from: x, reason: collision with root package name */
    private int f8126x;

    /* renamed from: y, reason: collision with root package name */
    private int f8127y;

    /* renamed from: z, reason: collision with root package name */
    private int f8128z;

    class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
            if (COUITouchListView.this.f8123u != null) {
                int intValue = ((Integer) COUITouchListView.this.f8123u.get(i3)).intValue();
                View childAt = absListView.getChildAt(0);
                if (childAt != null) {
                    intValue = (intValue - childAt.getHeight()) - childAt.getTop();
                }
                COUITouchListView.this.f8127y = intValue;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            COUITouchListView.this.f8114C.i(i3);
        }
    }

    static {
        f8111E = AbstractC0371a.f11873b || AbstractC0371a.e("COUITouchListView", 3);
    }

    public COUITouchListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(View view) {
        return view != null && (view.getBackground() instanceof C0559a) && view.isEnabled();
    }

    private boolean l(MotionEvent motionEvent, int i3) {
        View childAt = getChildAt(this.f8116n - getFirstVisiblePosition());
        if (k(childAt)) {
            n(childAt, motionEvent, 3);
            ((C0559a) childAt.getBackground()).u();
            this.f8114C.f(true, i3);
        }
        this.f8116n = -1;
        return true;
    }

    private void m() {
        this.f8124v = new C0495a.b(this).d(this.f8113B).c(this.f8113B).a();
    }

    private void n(View view, MotionEvent motionEvent, int i3) {
        this.f8117o = new Rect();
        this.f8118p = new Rect();
        getChildVisibleRect(view, this.f8117o, null);
        getLocalVisibleRect(this.f8118p);
        Rect rect = this.f8117o;
        int i4 = rect.left;
        Rect rect2 = this.f8118p;
        int i5 = i4 - rect2.left;
        int i6 = rect.top - rect2.top;
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setSource(-1);
        obtain.setLocation(x3 - i5, y3 - i6);
        obtain.setAction(i3);
        view.dispatchTouchEvent(obtain);
    }

    private void o() {
        if (this.f8121s) {
            performHapticFeedback(302);
        }
    }

    @Override // android.view.View
    protected boolean awakenScrollBars() {
        C0495a c0495a = this.f8124v;
        return c0495a != null ? c0495a.d(2000L) : super.awakenScrollBars();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        C0495a c0495a = this.f8124v;
        if (c0495a != null) {
            c0495a.e(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f8119q) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View childAt;
        if (!this.f8119q) {
            return false;
        }
        if (!this.f8120r && motionEvent.getActionMasked() == 2) {
            return true;
        }
        if (canScrollVertically(1) || canScrollVertically(-1)) {
            this.f8122t = false;
        } else {
            this.f8122t = true;
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        if (f8111E) {
            Log.d("COUITouchListView", "dispatchTouchEvent actionMasked:" + MotionEvent.actionToString(actionMasked) + ",actionIndex:" + actionIndex + ",getPointerCount:" + motionEvent.getPointerCount());
        }
        if (actionMasked == 0) {
            this.f8128z = y3;
            this.f8115D = X.a.c(getContext());
            int pointToPosition = pointToPosition(x3, y3);
            this.f8116n = pointToPosition;
            View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
            this.f8125w = childAt2;
            if (k(childAt2)) {
                this.f8114C.g();
                ((C0559a) this.f8125w.getBackground()).f();
            }
        } else if (actionMasked == 1) {
            int i3 = this.f8116n;
            if ((i3 != -1 && !this.f8115D) || this.f8112A == 0) {
                View childAt3 = getChildAt(i3 - getFirstVisiblePosition());
                if (childAt3 != null) {
                    AbstractC0371a.a("COUITouchListView", "target = " + childAt3 + " lastTouchTarget = " + this.f8116n + " item id at position = " + this.f8116n);
                    int i4 = this.f8116n;
                    performItemClick(childAt3, i4, getItemIdAtPosition(i4));
                    n(childAt3, motionEvent, 1);
                }
                this.f8114C.f(true, 0);
                this.f8116n = -1;
                this.f8112A = actionMasked;
                return false;
            }
            this.f8114C.f(true, 0);
            this.f8116n = -1;
        } else if (actionMasked == 2) {
            if (this.f8116n != -1 && !this.f8122t && Math.abs(y3 - this.f8128z) > ViewConfiguration.get(getContext()).getScaledTouchSlop() && k(this.f8125w)) {
                ((C0559a) this.f8125w.getBackground()).e();
                this.f8114C.f(true, 0);
                this.f8116n = -1;
            }
            int pointToPosition2 = pointToPosition(x3, y3);
            if (pointToPosition2 == -1 || motionEvent.getPointerCount() > 1 || this.f8115D) {
                this.f8112A = actionMasked;
                return l(motionEvent, 0);
            }
            if (pointToPosition2 != this.f8116n && n.t(pointToPosition2) && this.f8122t && (childAt = getChildAt(pointToPosition2 - getFirstVisiblePosition())) != null) {
                l(motionEvent, k(childAt) ? pointToPosition2 - this.f8116n : 0);
                if (k(childAt)) {
                    n(childAt, motionEvent, 0);
                    ((C0559a) childAt.getBackground()).t();
                    o();
                    this.f8116n = pointToPosition2;
                    this.f8114C.g();
                }
            }
        } else if (actionMasked == 3) {
            l(motionEvent, 0);
        } else if (actionMasked == 5) {
            this.f8112A = actionMasked;
            return l(motionEvent, 0);
        }
        this.f8112A = actionMasked;
        return super.dispatchTouchEvent(motionEvent);
    }

    public C0495a getCOUIScrollDelegate() {
        return this.f8124v;
    }

    @Override // p0.C0495a.c
    public View getCOUIScrollableView() {
        return this;
    }

    public void i(boolean z3) {
        this.f8119q = z3;
    }

    public void j(boolean z3) {
        this.f8120r = z3;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0495a c0495a = this.f8124v;
        if (c0495a != null) {
            c0495a.h();
        } else {
            m();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0495a c0495a = this.f8124v;
        if (c0495a != null) {
            c0495a.q();
            this.f8124v = null;
        }
        this.f8114C.j();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C0495a c0495a = this.f8124v;
        if (c0495a != null && c0495a.j(motionEvent)) {
            return true;
        }
        if (this.f8122t) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0495a c0495a = this.f8124v;
        if (c0495a == null || !c0495a.l(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        C0495a c0495a = this.f8124v;
        if (c0495a != null) {
            c0495a.n(view, i3);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        C0495a c0495a = this.f8124v;
        if (c0495a != null) {
            c0495a.o(i3);
        }
    }

    protected void p(List list, int i3) {
        this.f8123u = list;
        this.f8126x = i3;
    }

    public void setForceStopDividerAnimation(boolean z3) {
        this.f8114C.f8133d = z3;
    }

    public void setIsNeedVibrate(boolean z3) {
        this.f8121s = z3;
    }

    public void setNewCOUIScrollDelegate(C0495a c0495a) {
        if (c0495a == null) {
            throw new IllegalArgumentException("setNewFastScrollDelegate must NOT be NULL.");
        }
        this.f8124v = c0495a;
        c0495a.h();
    }

    @Override // p0.C0495a.c
    public int superComputeVerticalScrollExtent() {
        return getHeight();
    }

    @Override // p0.C0495a.c
    public int superComputeVerticalScrollOffset() {
        return this.f8127y;
    }

    @Override // p0.C0495a.c
    public int superComputeVerticalScrollRange() {
        return this.f8126x;
    }

    @Override // p0.C0495a.c
    public void superOnTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    public COUITouchListView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUITouchListView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8119q = true;
        this.f8120r = true;
        this.f8121s = true;
        this.f8122t = true;
        this.f8126x = 0;
        this.f8127y = 0;
        this.f8112A = -1;
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(context.getResources().getDimensionPixelOffset(V1.c.f2541h));
        this.f8113B = context.getResources().getDimensionPixelOffset(V1.c.f2551r);
        this.f8114C = new b(this, null);
        setOnScrollListener(new a());
        m();
        setDefaultFocusHighlightEnabled(false);
    }

    private class b {

        /* renamed from: a, reason: collision with root package name */
        private int f8130a;

        /* renamed from: b, reason: collision with root package name */
        private Map f8131b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8132c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8133d;

        class a implements b.r {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f8135a;

            a(View view) {
                this.f8135a = view;
            }

            @Override // Z.b.r
            public void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                this.f8135a.setAlpha(f3);
            }
        }

        private b() {
            this.f8130a = 0;
            this.f8131b = new HashMap();
            this.f8132c = false;
            this.f8133d = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(boolean z3, int i3) {
            if (COUITouchListView.this.f8116n == -1) {
                return;
            }
            COUITouchListView cOUITouchListView = COUITouchListView.this;
            if (COUITouchListView.this.k(cOUITouchListView.getChildAt(cOUITouchListView.f8116n - COUITouchListView.this.getFirstVisiblePosition()))) {
                float f3 = z3 ? 1.0f : 0.0f;
                if (COUITouchListView.this.f8116n > 0 && (!z3 || i3 != -2)) {
                    l((COUITouchListView.this.f8116n - 1) - COUITouchListView.this.getFirstVisiblePosition(), f3);
                }
                if (COUITouchListView.this.f8116n < COUITouchListView.this.getCount() - 1) {
                    if (z3 && i3 == 2) {
                        return;
                    }
                    l((COUITouchListView.this.f8116n + 1) - COUITouchListView.this.getFirstVisiblePosition(), f3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            f(false, 0);
        }

        private Z.c h(View view) {
            Z.c cVar = (Z.c) this.f8131b.get(view);
            if (cVar != null) {
                return cVar;
            }
            Z.c cVar2 = new Z.c(new B.d());
            Z.d dVar = new Z.d();
            dVar.d(0.0f);
            dVar.g(0.25f);
            cVar2.B(dVar);
            cVar2.m(0.002f);
            cVar2.b(new a(view));
            cVar2.o(1.0f);
            this.f8131b.put(view, cVar2);
            return cVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(int i3) {
            if (this.f8130a != i3) {
                if ((i3 == 1 || i3 == 2) && !COUITouchListView.this.f8122t) {
                    k();
                    this.f8132c = true;
                } else {
                    this.f8132c = false;
                }
                this.f8130a = i3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            Iterator it = this.f8131b.entrySet().iterator();
            while (it.hasNext()) {
                ((Z.c) ((Map.Entry) it.next()).getValue()).c();
                it.remove();
            }
        }

        private void k() {
            for (Map.Entry entry : this.f8131b.entrySet()) {
                Z.c cVar = (Z.c) entry.getValue();
                if (cVar.h()) {
                    cVar.w();
                    ((View) entry.getKey()).setAlpha(1.0f);
                }
            }
        }

        private void l(int i3, float f3) {
            View childAt = COUITouchListView.this.getChildAt(i3);
            if (childAt == null || this.f8132c || this.f8133d || childAt.getAlpha() == f3) {
                return;
            }
            int firstVisiblePosition = COUITouchListView.this.getFirstVisiblePosition() + i3;
            if (firstVisiblePosition >= 0 && firstVisiblePosition < COUITouchListView.this.getAdapter().getCount()) {
                if (COUITouchListView.this.getAdapter().getItemViewType(firstVisiblePosition) == 2) {
                    return;
                }
                h(childAt).u(f3);
                return;
            }
            Log.e("COUITouchListView", "startDividerAnimation adapterPosition in error range！,getAdapter().getCount():" + COUITouchListView.this.getAdapter().getCount() + ",position:" + i3 + ",getFirstVisiblePosition():" + COUITouchListView.this.getFirstVisiblePosition());
        }

        /* synthetic */ b(COUITouchListView cOUITouchListView, a aVar) {
            this();
        }
    }
}
