package com.coui.appcompat.poplist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.poplist.AbstractC0300a;
import com.coui.appcompat.poplist.j;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
public class j extends FrameLayout {

    /* renamed from: w, reason: collision with root package name */
    private static final boolean f8256w;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8257e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f8258f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f8259g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f8260h;

    /* renamed from: i, reason: collision with root package name */
    private final AbstractC0300a.InterfaceC0106a f8261i;

    /* renamed from: j, reason: collision with root package name */
    private ViewGroup f8262j;

    /* renamed from: k, reason: collision with root package name */
    private ViewGroup f8263k;

    /* renamed from: l, reason: collision with root package name */
    private int f8264l;

    /* renamed from: m, reason: collision with root package name */
    private int f8265m;

    /* renamed from: n, reason: collision with root package name */
    private int f8266n;

    /* renamed from: o, reason: collision with root package name */
    private int f8267o;

    /* renamed from: p, reason: collision with root package name */
    private AbstractC0300a f8268p;

    /* renamed from: q, reason: collision with root package name */
    private AbstractC0300a f8269q;

    /* renamed from: r, reason: collision with root package name */
    private AbstractC0300a f8270r;

    /* renamed from: s, reason: collision with root package name */
    private b f8271s;

    /* renamed from: t, reason: collision with root package name */
    private final Paint f8272t;

    /* renamed from: u, reason: collision with root package name */
    private v f8273u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f8274v;

    class a implements AbstractC0300a.InterfaceC0106a {

        /* renamed from: a, reason: collision with root package name */
        private final View.OnClickListener f8275a = new View.OnClickListener() { // from class: com.coui.appcompat.poplist.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.a.this.m(view);
            }
        };

        /* renamed from: b, reason: collision with root package name */
        private final View.OnClickListener f8276b = new View.OnClickListener() { // from class: com.coui.appcompat.poplist.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.a.this.n(view);
            }
        };

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            j.this.p(true);
            j.this.f8262j.setOnClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(View view) {
            j.this.y();
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void a() {
            if (j.this.f8271s != null) {
                j.this.f8271s.a();
            }
            if (j.this.f8263k instanceof RoundFrameLayout) {
                ((RoundFrameLayout) j.this.f8263k).k();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void b() {
            if (j.this.f8271s != null) {
                j.this.f8271s.b();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void c() {
            if (j.this.f8271s != null) {
                j.this.f8271s.c();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void d() {
            j.this.f8257e = false;
            if (j.this.f8263k instanceof RoundFrameLayout) {
                ((RoundFrameLayout) j.this.f8263k).setAllowDispatchEvent(true);
            }
            if (j.this.f8271s != null) {
                j.this.f8271s.d();
            }
            if (j.this.f8262j != null) {
                j jVar = j.this;
                jVar.l(jVar.f8262j, false);
                j jVar2 = j.this;
                jVar2.m(jVar2.f8262j, false);
                j jVar3 = j.this;
                jVar3.m(jVar3.f8263k, true);
                j.this.n(this.f8275a);
                j.this.f8262j.setOnClickListener(this.f8275a);
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void e() {
            j.this.f8257e = true;
            if (j.this.f8263k instanceof RoundFrameLayout) {
                ((RoundFrameLayout) j.this.f8263k).setAllowDispatchEvent(false);
            }
            if (j.this.f8271s != null) {
                j.this.f8271s.e();
            }
            if (j.this.f8262j != null) {
                j.this.f8262j.setFocusable(false);
                j.this.f8262j.setClickable(false);
                j.this.f8262j.setOnClickListener(null);
                j jVar = j.this;
                jVar.l(jVar.f8262j, true);
                j jVar2 = j.this;
                jVar2.m(jVar2.f8263k, false);
                j.this.n(this.f8276b);
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void f() {
            j.this.f8257e = false;
            if (j.this.f8263k instanceof RoundFrameLayout) {
                ((RoundFrameLayout) j.this.f8263k).setAllowDispatchEvent(true);
            }
            if (j.this.f8271s != null) {
                j.this.f8271s.f();
            }
            j jVar = j.this;
            jVar.m(jVar.f8262j, true);
            j.this.n(null);
            j.this.u();
            if (j.this.f8258f != null) {
                Runnable runnable = j.this.f8258f;
                j.this.f8258f = null;
                runnable.run();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void g() {
            if (j.this.f8271s != null) {
                j.this.f8271s.g();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void h() {
            if (j.this.f8271s != null) {
                j.this.f8271s.h();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void i() {
            if (j.this.f8271s != null) {
                j.this.f8271s.i();
            }
        }

        @Override // com.coui.appcompat.poplist.AbstractC0300a.InterfaceC0106a
        public void j() {
            if (j.this.f8271s != null) {
                j.this.f8271s.j();
            }
        }
    }

    interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();
    }

    static {
        f8256w = AbstractC0371a.f11873b || AbstractC0371a.e("COUIPopupMenuRootView", 3);
    }

    j(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ViewGroup viewGroup, boolean z3) {
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof COUITouchListView) {
                ((COUITouchListView) childAt).i(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ViewGroup viewGroup, boolean z3) {
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof COUITouchListView) {
                ((COUITouchListView) childAt).j(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View.OnClickListener onClickListener) {
        this.f8260h = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f8257e) {
            this.f8257e = false;
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            super.dispatchTouchEvent(obtain);
            obtain.recycle();
            if (motionEvent.getActionMasked() == 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
            obtain2.setAction(0);
            super.dispatchTouchEvent(obtain2);
            obtain2.recycle();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    void j(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.f8262j;
        if (viewGroup2 != null) {
            removeView(viewGroup2);
        }
        if (this.f8263k != null) {
            p(false);
        }
        this.f8262j = viewGroup;
        addView(viewGroup, new ViewGroup.LayoutParams(-2, -2));
        m(this.f8262j, true);
        this.f8268p.c(this.f8262j);
        this.f8268p.d(this);
        this.f8268p.e(this.f8261i);
    }

    void k(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.f8263k;
        if (viewGroup2 != null) {
            removeView(viewGroup2);
        }
        this.f8263k = viewGroup;
        viewGroup.setTranslationZ(1.0f);
        addView(this.f8263k, new ViewGroup.LayoutParams(-2, -2));
        m(this.f8263k, true);
        this.f8268p.f(this.f8263k);
        y();
    }

    void o(boolean z3) {
        AbstractC0300a abstractC0300a = this.f8268p;
        if (abstractC0300a == null) {
            return;
        }
        if (z3) {
            abstractC0300a.i();
        } else {
            abstractC0300a.j(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setVisibility(0);
        ViewGroup viewGroup = this.f8262j;
        if (viewGroup == null || this.f8273u == null) {
            return;
        }
        viewGroup.setVisibility(8);
        this.f8268p.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t();
        this.f8268p.o();
        this.f8262j.setFocusable(false);
        this.f8262j.setClickable(false);
        this.f8262j.setOnClickListener(null);
        l(this.f8262j, true);
        m(this.f8263k, false);
        n(null);
        u();
        this.f8258f = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (f8256w) {
            ViewGroup viewGroup = this.f8262j;
            if (viewGroup != null) {
                viewGroup.setAlpha(0.5f);
            }
            ViewGroup viewGroup2 = this.f8263k;
            if (viewGroup2 != null) {
                viewGroup2.setAlpha(0.5f);
            }
            this.f8272t.setColor(Color.parseColor("#33FF0000"));
            canvas.save();
            this.f8273u.c(this.f8274v);
            canvas.clipOutRect(this.f8274v);
            canvas.drawRect(this.f8273u.f8378a, this.f8272t);
            canvas.restore();
            this.f8272t.setColor(Color.parseColor("#330000FF"));
            canvas.save();
            this.f8274v.set(this.f8273u.f8379b);
            canvas.clipOutRect(this.f8274v);
            this.f8273u.b(this.f8274v);
            canvas.drawRect(this.f8274v, this.f8272t);
            canvas.restore();
            this.f8272t.setColor(Color.parseColor("#3300FF00"));
            this.f8274v.set(this.f8273u.f8379b);
            canvas.drawRect(this.f8274v, this.f8272t);
            this.f8272t.setColor(Color.parseColor("#33FF00FF"));
            this.f8274v.set(this.f8273u.f8380c);
            canvas.drawRect(this.f8274v, this.f8272t);
            this.f8272t.setColor(Color.parseColor("#33FFFF00"));
            this.f8274v.set(this.f8273u.f8384g);
            canvas.drawRect(this.f8274v, this.f8272t);
            this.f8272t.setColor(Color.parseColor("#3300FFFF"));
            this.f8274v.set(this.f8273u.f8381d);
            canvas.drawRect(this.f8274v, this.f8272t);
            this.f8272t.setColor(Color.parseColor("#33000000"));
            this.f8274v.set(this.f8273u.f8382e);
            canvas.drawRect(this.f8274v, this.f8272t);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        ViewGroup viewGroup = this.f8262j;
        if (viewGroup != null) {
            Rect rect = this.f8273u.f8380c;
            viewGroup.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
        ViewGroup viewGroup2 = this.f8263k;
        if (viewGroup2 != null) {
            Rect rect2 = this.f8273u.f8382e;
            viewGroup2.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        ViewGroup viewGroup = this.f8262j;
        if (viewGroup != null) {
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(this.f8264l, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f8265m, 1073741824));
        }
        ViewGroup viewGroup2 = this.f8263k;
        if (viewGroup2 != null) {
            viewGroup2.measure(View.MeasureSpec.makeMeasureSpec(this.f8266n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f8267o, 1073741824));
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i4));
    }

    void p(boolean z3) {
        ViewGroup viewGroup = this.f8263k;
        if (viewGroup != null) {
            if (!z3) {
                this.f8268p.n(false);
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof COUITouchListView) {
                ((COUITouchListView) childAt).smoothScrollToPosition(0);
            }
            this.f8268p.m();
        }
    }

    void q(View view) {
        View.OnClickListener onClickListener = this.f8260h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    void r(Runnable runnable, long j3) {
        t();
        this.f8259g = runnable;
        if (runnable != null) {
            postDelayed(runnable, j3);
        }
    }

    void s(Runnable runnable) {
        this.f8258f = runnable;
    }

    void setDomain(v vVar) {
        this.f8273u = vVar;
        if (COUIResponsiveUtils.isSmallScreen(getContext(), this.f8273u.f8378a.width())) {
            if (this.f8269q == null) {
                this.f8269q = new D(getContext());
            }
            this.f8268p = this.f8269q;
        } else {
            if (this.f8270r == null) {
                this.f8270r = new q();
            }
            this.f8268p = this.f8270r;
        }
        this.f8268p.b(this.f8273u);
        invalidate();
    }

    void setOnSubMenuStateChangedListener(b bVar) {
        this.f8271s = bVar;
    }

    void t() {
        Runnable runnable = this.f8259g;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f8259g = null;
        }
    }

    void u() {
        ViewGroup viewGroup = this.f8263k;
        if (viewGroup != null) {
            removeView(viewGroup);
            this.f8263k = null;
            this.f8268p.a();
            this.f8268p.f(null);
            this.f8257e = true;
        }
    }

    void v(int i3, int i4) {
        this.f8264l = i3;
        this.f8265m = i4;
    }

    void w(int i3, int i4) {
        this.f8266n = i3;
        this.f8267o = i4;
    }

    void x() {
        AbstractC0300a abstractC0300a = this.f8268p;
        if (abstractC0300a == null) {
            return;
        }
        abstractC0300a.g();
        if (this.f8263k != null) {
            p(true);
        }
    }

    void y() {
        this.f8268p.k();
    }

    j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    j(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    j(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8257e = false;
        this.f8258f = null;
        this.f8259g = null;
        this.f8260h = null;
        this.f8261i = new a();
        this.f8262j = null;
        this.f8263k = null;
        this.f8264l = 0;
        this.f8265m = 0;
        this.f8266n = 0;
        this.f8267o = 0;
        this.f8272t = new Paint(1);
        this.f8274v = new Rect();
        if (f8256w) {
            setWillNotDraw(false);
        }
        setFocusable(false);
        setLayerType(2, null);
    }
}
