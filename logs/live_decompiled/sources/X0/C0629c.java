package x0;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.coui.appcompat.poplist.E;
import com.coui.appcompat.poplist.k;
import com.oplus.graphics.OplusOutline;
import com.oplus.graphics.OplusOutlineAdapter;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import f2.AbstractC0360b;
import f2.AbstractC0361c;
import h0.AbstractC0371a;
import n0.AbstractC0481a;
import x0.C0627a;
import x0.C0629c;
import y0.i;
import y0.j;

/* renamed from: x0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0629c extends k {

    /* renamed from: A, reason: collision with root package name */
    private Drawable f13927A;

    /* renamed from: B, reason: collision with root package name */
    private Drawable f13928B;

    /* renamed from: C, reason: collision with root package name */
    private Drawable f13929C;

    /* renamed from: D, reason: collision with root package name */
    private Drawable f13930D;

    /* renamed from: E, reason: collision with root package name */
    private int f13931E;

    /* renamed from: F, reason: collision with root package name */
    private int f13932F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f13933G;

    /* renamed from: H, reason: collision with root package name */
    private int f13934H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f13935I;

    /* renamed from: J, reason: collision with root package name */
    private int f13936J;

    /* renamed from: K, reason: collision with root package name */
    private int f13937K;

    /* renamed from: L, reason: collision with root package name */
    private int[] f13938L;

    /* renamed from: M, reason: collision with root package name */
    private float f13939M;

    /* renamed from: N, reason: collision with root package name */
    private float f13940N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f13941O;

    /* renamed from: P, reason: collision with root package name */
    private int f13942P;

    /* renamed from: Q, reason: collision with root package name */
    private float f13943Q;

    /* renamed from: R, reason: collision with root package name */
    private float f13944R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f13945S;

    /* renamed from: T, reason: collision with root package name */
    private int f13946T;

    /* renamed from: U, reason: collision with root package name */
    private View.OnLayoutChangeListener f13947U;

    /* renamed from: V, reason: collision with root package name */
    private PopupWindow.OnDismissListener f13948V;

    /* renamed from: W, reason: collision with root package name */
    private x0.f f13949W;

    /* renamed from: X, reason: collision with root package name */
    private Runnable f13950X;

    /* renamed from: Y, reason: collision with root package name */
    private Rect f13951Y;

    /* renamed from: Z, reason: collision with root package name */
    private Rect f13952Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f13953a0;

    /* renamed from: b0, reason: collision with root package name */
    private InterfaceC0628b f13954b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f13955c0;

    /* renamed from: e, reason: collision with root package name */
    private final Context f13956e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f13957f;

    /* renamed from: g, reason: collision with root package name */
    private final Point f13958g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13959h;

    /* renamed from: i, reason: collision with root package name */
    private final B.c f13960i;

    /* renamed from: j, reason: collision with root package name */
    private final B.c f13961j;

    /* renamed from: k, reason: collision with root package name */
    private int f13962k;

    /* renamed from: l, reason: collision with root package name */
    private View f13963l;

    /* renamed from: m, reason: collision with root package name */
    private Rect f13964m;

    /* renamed from: n, reason: collision with root package name */
    private Rect f13965n;

    /* renamed from: o, reason: collision with root package name */
    private ViewGroup f13966o;

    /* renamed from: p, reason: collision with root package name */
    private ViewGroup f13967p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f13968q;

    /* renamed from: r, reason: collision with root package name */
    private View f13969r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f13970s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f13971t;

    /* renamed from: u, reason: collision with root package name */
    private Drawable f13972u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f13973v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f13974w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f13975x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f13976y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f13977z;

    /* renamed from: x0.c$a */
    class a extends B.c {
        a(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(Float f3) {
            return C0629c.this.f13943Q;
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Float f3, float f4) {
            C0629c.this.W(f4);
        }
    }

    /* renamed from: x0.c$b */
    class b extends B.c {
        b(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(Float f3) {
            return C0629c.this.f13944R;
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Float f3, float f4) {
            C0629c.this.V(f4);
        }
    }

    /* renamed from: x0.c$c, reason: collision with other inner class name */
    class ViewOnLayoutChangeListenerC0155c implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC0155c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            try {
                if (C0629c.this.f13963l != null) {
                    C0629c.this.Q();
                } else {
                    AbstractC0371a.c("COUIToolTips", "onLayoutChange post mParent == null!");
                }
            } catch (Exception e3) {
                Log.e("COUIToolTips", "refreshWhileLayoutChange fail,e:" + e3.getMessage());
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            Rect rect = new Rect(i3, i4, i5, i6);
            Rect rect2 = new Rect(i7, i8, i9, i10);
            if (!C0629c.this.isShowing() || rect.equals(rect2) || C0629c.this.f13969r == null) {
                return;
            }
            view.post(new Runnable() { // from class: x0.d
                @Override // java.lang.Runnable
                public final void run() {
                    C0629c.ViewOnLayoutChangeListenerC0155c.this.b();
                }
            });
        }
    }

    /* renamed from: x0.c$d */
    class d implements PopupWindow.OnDismissListener {
        d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            C0629c.this.f13966o.removeAllViews();
        }
    }

    /* renamed from: x0.c$e */
    class e implements x0.f {
        e() {
        }

        @Override // x0.f
        public void a() {
            C0629c.this.dismiss();
            C0629c.r(C0629c.this);
        }
    }

    /* renamed from: x0.c$f */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0629c.this.f13941O) {
                C0629c.this.E();
                C0629c.this.f13941O = false;
            }
        }
    }

    /* renamed from: x0.c$g */
    class g extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13984a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13985b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f13986c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f13987d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f13988e;

        g(int i3, int i4, int i5, int i6, float f3) {
            this.f13984a = i3;
            this.f13985b = i4;
            this.f13986c = i5;
            this.f13987d = i6;
            this.f13988e = f3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect(this.f13984a, this.f13985b, view.getWidth() - this.f13986c, view.getHeight() - this.f13987d);
            if (AbstractC0481a.a() == 1) {
                new OplusOutlineAdapter(outline, 1).setSmoothRoundRect(rect, this.f13988e);
            } else if (AbstractC0481a.a() == 0) {
                new OplusOutline(outline).setSmoothRoundRect(rect, this.f13988e, AbstractC0335a.i(C0629c.this.f13956e, M1.f.f1462v));
            } else {
                outline.setRoundRect(rect, this.f13988e);
            }
        }
    }

    /* renamed from: x0.c$h */
    public interface h {
    }

    public C0629c(Context context) {
        this(context, 0);
    }

    private void A() {
        this.f13963l.getWindowVisibleDisplayFrame(this.f13964m);
        R();
        Rect rect = new Rect();
        this.f13951Y = rect;
        this.f13969r.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        this.f13952Z = rect2;
        this.f13963l.getGlobalVisibleRect(rect2);
        int[] iArr = new int[2];
        this.f13963l.getLocationOnScreen(iArr);
        this.f13951Y.offset(iArr[0], iArr[1]);
        this.f13952Z.offset(iArr[0], iArr[1]);
        int[] iArr2 = new int[2];
        Rect rect3 = this.f13951Y;
        this.f8281d.j(new int[]{rect3.left, rect3.top}, iArr2, this.f13969r);
        int width = this.f13969r.getWidth();
        int height = this.f13969r.getHeight();
        Rect rect4 = this.f13951Y;
        int i3 = iArr2[0];
        int i4 = width / 2;
        rect4.left = i3 - i4;
        int i5 = iArr2[1];
        int i6 = height / 2;
        rect4.top = i5 - i6;
        rect4.right = i3 + i4;
        rect4.bottom = i5 + i6;
        Rect rect5 = this.f13964m;
        rect5.left = Math.max(rect5.left, this.f13952Z.left);
        Rect rect6 = this.f13964m;
        rect6.top = Math.max(rect6.top, this.f13952Z.top);
        Rect rect7 = this.f13964m;
        rect7.right = Math.min(rect7.right, this.f13952Z.right);
        Rect rect8 = this.f13964m;
        rect8.bottom = Math.min(rect8.bottom, this.f13952Z.bottom);
        b0();
        P(this.f13951Y);
        if (this.f13935I) {
            O(this.f13951Y, this.f13933G, 0, 0);
        } else {
            O(this.f13951Y, this.f13933G, -this.f13937K, -this.f13936J);
        }
        setContentView(this.f13966o);
        z();
        w();
        if (N(this.f13969r)) {
            this.f13958g.x -= this.f13937K;
        } else {
            this.f13958g.x += this.f13937K;
        }
        this.f13958g.y += this.f13936J;
    }

    private void B(E.a aVar) {
        E.a e3 = this.f8281d.e(this.f13969r);
        if (e3 == E.a.TOOLBAR || e3 == E.a.NAVIGATION) {
            return;
        }
        this.f13953a0 = c(aVar);
    }

    private ViewGroup C(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.f13954b0.a();
        c0();
        this.f13963l = null;
        super.dismiss();
        this.f13966o.removeAllViews();
        this.f13966o.removeCallbacks(this.f13950X);
    }

    private int F() {
        int height = getHeight();
        Rect rect = this.f13965n;
        return (height - rect.top) + rect.bottom;
    }

    private int G() {
        int width = getWidth();
        Rect rect = this.f13965n;
        return (width - rect.left) + rect.right;
    }

    private void H(FrameLayout.LayoutParams layoutParams, float f3, float f4, float f5, int i3) {
        float f6 = layoutParams.leftMargin;
        int i4 = this.f13955c0;
        if (f6 < f4 + f3 + i4) {
            if (this.f13927A == null) {
                this.f13927A = x0.e.b(this.f13956e, this.f13974w, 0.0f, true);
            }
            this.f13931E = 1;
            this.f13968q.setBackground(this.f13927A);
            layoutParams.leftMargin = Math.max((int) (f3 + f5 + this.f13955c0), this.f13951Y.centerX());
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.f13927A.getIntrinsicWidth();
            layoutParams.topMargin = (this.f13967p.getPaddingTop() - this.f13927A.getIntrinsicHeight()) + this.f13946T;
        } else {
            float f7 = f3 + f5;
            if (layoutParams.rightMargin < i4 + f7) {
                this.f13931E = 3;
                this.f13968q.setBackground(this.f13974w);
                layoutParams.rightMargin = Math.max((int) (f7 + this.f13955c0), j.m(this.f13956e) - this.f13951Y.centerX());
                layoutParams.leftMargin = (getWidth() - layoutParams.rightMargin) - this.f13974w.getIntrinsicWidth();
                layoutParams.topMargin = (this.f13967p.getPaddingTop() - this.f13974w.getIntrinsicHeight()) + this.f13946T;
            } else {
                this.f13931E = 2;
                this.f13968q.setBackground(this.f13970s);
                layoutParams.topMargin = (this.f13967p.getPaddingTop() - this.f13970s.getIntrinsicHeight()) + this.f13946T;
            }
        }
        layoutParams.topMargin += i3;
    }

    private void I(Rect rect, FrameLayout.LayoutParams layoutParams, int i3, int i4) {
        if (this.f13973v == null) {
            this.f13973v = x0.e.b(this.f13956e, this.f13970s, 90.0f, false);
        }
        layoutParams.rightMargin = ((this.f13967p.getPaddingRight() - this.f13973v.getIntrinsicWidth()) - i3) + this.f13946T;
        layoutParams.leftMargin = ((getWidth() - layoutParams.rightMargin) - this.f13973v.getIntrinsicWidth()) - this.f13946T;
        layoutParams.topMargin = ((rect.centerY() - this.f13958g.y) - this.f13938L[1]) - (this.f13973v.getIntrinsicHeight() / 2);
        layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.f13973v.getIntrinsicHeight();
        float d3 = AbstractC0335a.d(this.f13956e, AbstractC0481a.f() ? M1.c.f1344B : M1.c.f1343A);
        float paddingTop = this.f13967p.getPaddingTop();
        float paddingBottom = this.f13967p.getPaddingBottom();
        float f3 = paddingTop + d3;
        if (layoutParams.topMargin < f3) {
            if (this.f13928B == null) {
                this.f13928B = x0.e.b(this.f13956e, this.f13974w, 90.0f, true);
            }
            this.f13931E = 4;
            this.f13968q.setBackground(this.f13928B);
            layoutParams.topMargin = (int) f3;
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.f13928B.getIntrinsicHeight();
        } else {
            float f4 = d3 + paddingBottom;
            if (layoutParams.bottomMargin < f4) {
                if (this.f13975x == null) {
                    this.f13975x = x0.e.b(this.f13956e, this.f13974w, 90.0f, false);
                }
                this.f13931E = 6;
                this.f13968q.setBackground(this.f13975x);
                layoutParams.bottomMargin = (int) f4;
                layoutParams.topMargin = (getHeight() - layoutParams.bottomMargin) - this.f13975x.getIntrinsicHeight();
            } else {
                this.f13931E = 5;
                this.f13968q.setBackground(this.f13973v);
            }
        }
        layoutParams.topMargin += i4;
    }

    private void J(Rect rect, FrameLayout.LayoutParams layoutParams, int i3, int i4) {
        if (this.f13972u == null) {
            this.f13972u = x0.e.b(this.f13956e, this.f13970s, 270.0f, false);
        }
        layoutParams.leftMargin = (this.f13967p.getPaddingLeft() - this.f13972u.getIntrinsicWidth()) + i3 + this.f13946T;
        layoutParams.rightMargin = ((getWidth() - layoutParams.leftMargin) - this.f13972u.getIntrinsicWidth()) - this.f13946T;
        layoutParams.topMargin = ((rect.centerY() - this.f13958g.y) - this.f13938L[1]) - (this.f13972u.getIntrinsicHeight() / 2);
        layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.f13972u.getIntrinsicHeight();
        float d3 = AbstractC0335a.d(this.f13956e, AbstractC0481a.f() ? M1.c.f1344B : M1.c.f1343A);
        float paddingTop = this.f13967p.getPaddingTop();
        float paddingBottom = this.f13967p.getPaddingBottom();
        float f3 = paddingTop + d3;
        if (layoutParams.topMargin < f3) {
            if (this.f13977z == null) {
                this.f13977z = x0.e.b(this.f13956e, this.f13974w, 270.0f, false);
            }
            this.f13931E = 12;
            this.f13968q.setBackground(this.f13977z);
            layoutParams.topMargin = (int) f3;
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.f13977z.getIntrinsicHeight();
        } else if (layoutParams.bottomMargin < d3 + paddingBottom) {
            if (this.f13930D == null) {
                this.f13930D = x0.e.b(this.f13956e, this.f13974w, 270.0f, true);
            }
            this.f13931E = 10;
            this.f13968q.setBackground(this.f13930D);
            layoutParams.bottomMargin = (int) f3;
            layoutParams.topMargin = (getHeight() - layoutParams.bottomMargin) - this.f13930D.getIntrinsicHeight();
        } else {
            this.f13931E = 11;
            this.f13968q.setBackground(this.f13972u);
        }
        layoutParams.topMargin += i4;
    }

    private void K(FrameLayout.LayoutParams layoutParams, float f3, float f4, float f5, int i3) {
        layoutParams.gravity = 80;
        if (layoutParams.leftMargin < f4 + f3 + this.f13955c0) {
            if (this.f13976y == null) {
                this.f13976y = x0.e.b(this.f13956e, this.f13974w, 180.0f, false);
            }
            this.f13931E = 9;
            this.f13968q.setBackground(this.f13976y);
            layoutParams.leftMargin = Math.max((int) (f3 + f5 + this.f13955c0), this.f13951Y.centerX());
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.f13976y.getIntrinsicWidth();
            layoutParams.bottomMargin = (this.f13967p.getPaddingBottom() - this.f13976y.getIntrinsicHeight()) + this.f13946T;
        } else {
            float f6 = f3 + f5;
            if (layoutParams.rightMargin < f6) {
                if (this.f13929C == null) {
                    this.f13929C = x0.e.b(this.f13956e, this.f13974w, 180.0f, true);
                }
                this.f13931E = 7;
                this.f13968q.setBackground(this.f13929C);
                layoutParams.rightMargin = Math.max((int) (f6 + this.f13955c0), j.m(this.f13956e) - this.f13951Y.centerX());
                layoutParams.leftMargin = (getWidth() - layoutParams.rightMargin) - this.f13929C.getIntrinsicWidth();
                layoutParams.bottomMargin = (this.f13967p.getPaddingBottom() - this.f13929C.getIntrinsicHeight()) + this.f13946T;
            } else {
                if (this.f13971t == null) {
                    this.f13971t = x0.e.b(this.f13956e, this.f13970s, 180.0f, false);
                }
                this.f13931E = 8;
                this.f13968q.setBackground(this.f13971t);
                layoutParams.bottomMargin = (this.f13967p.getPaddingBottom() - this.f13971t.getIntrinsicHeight()) + this.f13946T;
            }
        }
        layoutParams.bottomMargin -= i3;
    }

    private void L(Rect rect, FrameLayout.LayoutParams layoutParams, int i3, int i4) {
        this.f13963l.getRootView().getLocationOnScreen(this.f13957f);
        int i5 = this.f13957f[0];
        this.f13963l.getRootView().getLocationInWindow(this.f13957f);
        layoutParams.leftMargin = (((rect.centerX() - this.f13958g.x) - (i5 - this.f13957f[0])) - (this.f13970s.getIntrinsicWidth() / 2)) + i3;
        layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.f13970s.getIntrinsicWidth();
        int i6 = rect.top - this.f13938L[1];
        float d3 = AbstractC0335a.d(this.f13956e, AbstractC0481a.f() ? M1.c.f1344B : M1.c.f1343A);
        float paddingLeft = this.f13967p.getPaddingLeft();
        float paddingRight = this.f13967p.getPaddingRight();
        if (this.f13958g.y >= i6) {
            H(layoutParams, d3, paddingLeft, paddingRight, i4);
        } else {
            K(layoutParams, d3, paddingLeft, paddingRight, i4);
        }
    }

    private void O(Rect rect, boolean z3, int i3, int i4) {
        this.f13966o.removeAllViews();
        this.f13966o.addView(this.f13967p);
        if (z3) {
            v(rect, i3, i4);
        }
    }

    private void P(Rect rect) {
        int G3;
        int max;
        int F3;
        int i3;
        this.f13942P = -1;
        int c3 = c(this.f8281d.e(this.f13969r));
        int i4 = this.f13932F;
        if (i4 == 4) {
            G3 = Math.min(rect.centerX() - (G() / 2), this.f13964m.right - ((G() - this.f13967p.getPaddingRight()) + this.f13934H));
            int i5 = rect.top;
            Rect rect2 = this.f13964m;
            int i6 = i5 - rect2.top;
            int i7 = (rect2.bottom - rect.bottom) - c3;
            F3 = F();
            if (i6 >= F3) {
                this.f13942P = 4;
                i3 = rect.top;
                max = i3 - F3;
            } else if (i7 >= F3) {
                this.f13942P = 128;
                max = rect.bottom;
            } else if (i6 > i7) {
                this.f13942P = 4;
                max = this.f13964m.top;
                setHeight(i6);
            } else {
                this.f13942P = 128;
                max = rect.bottom;
                setHeight(i7);
            }
        } else if (i4 == 128) {
            G3 = Math.min(rect.centerX() - (G() / 2), this.f13964m.right - ((G() - this.f13967p.getPaddingRight()) + this.f13934H));
            int i8 = rect.top;
            Rect rect3 = this.f13964m;
            int i9 = i8 - rect3.top;
            int i10 = (rect3.bottom - rect.bottom) - c3;
            F3 = F();
            if (i10 >= F3) {
                this.f13942P = 128;
                max = rect.bottom;
            } else if (i9 >= F3) {
                this.f13942P = 4;
                i3 = rect.top;
                max = i3 - F3;
            } else if (i9 > i10) {
                this.f13942P = 4;
                max = this.f13964m.top;
                setHeight(i9);
            } else {
                this.f13942P = 128;
                max = rect.bottom;
                setHeight(i10);
            }
        } else {
            G3 = i4 == 16 ? rect.left - G() : rect.right;
            max = Math.max(rect.centerY() - (((F() + this.f13967p.getPaddingTop()) - this.f13967p.getPaddingBottom()) / 2), (this.f13964m.top + this.f13965n.top) - this.f13967p.getPaddingTop());
        }
        this.f13963l.getRootView().getLocationOnScreen(this.f13957f);
        int[] iArr = this.f13957f;
        int i11 = iArr[0];
        int i12 = iArr[1];
        this.f13963l.getRootView().getLocationInWindow(this.f13957f);
        int[] iArr2 = this.f13957f;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        int[] iArr3 = this.f13938L;
        int i15 = i11 - i13;
        iArr3[0] = i15;
        int i16 = i12 - i14;
        iArr3[1] = i16;
        int i17 = G3 - i15;
        Rect rect4 = this.f13965n;
        int i18 = i17 - rect4.left;
        int i19 = (max - i16) - rect4.top;
        int i20 = this.f13932F;
        if (i20 == 8) {
            B(E.a.END);
            i18 += this.f13953a0;
        } else if (i20 == 16) {
            B(E.a.START);
            i18 -= this.f13953a0;
        } else {
            int i21 = this.f13942P;
            if (i21 == 4) {
                B(E.a.TOP);
                i19 -= this.f13953a0;
            } else if (i21 == 128) {
                B(E.a.BOTTOM);
                i19 += this.f13953a0;
            }
        }
        this.f13958g.set(Math.max(this.f13934H - this.f13967p.getPaddingLeft(), i18), Math.max(0, i19));
    }

    private void R() {
        c0();
        this.f13963l.addOnLayoutChangeListener(this.f13947U);
    }

    private void S(int i3, int i4, int i5, int i6, int i7) {
        float d3 = AbstractC0335a.d(this.f13956e, AbstractC0481a.a() == 0 ? M1.c.f1344B : M1.c.f1343A);
        this.f13967p.setBackgroundColor(i3);
        this.f13967p.setPaddingRelative(i4, i5, i6, i7);
        this.f13967p.setOutlineProvider(new g(i4, i5, i6, i7, d3));
        this.f13967p.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f3) {
        float f4 = f3 / 10000.0f;
        this.f13944R = f4;
        float f5 = 1.0f;
        float f6 = 0.0f;
        if (this.f13945S) {
            f6 = 1.0f;
            f5 = 0.0f;
        }
        this.f13966o.setAlpha(j.i(f5, f6, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(float f3) {
        float f4 = f3 / 10000.0f;
        this.f13943Q = f4;
        float f5 = 1.0f;
        float f6 = 0.0f;
        if (this.f13945S) {
            f6 = 1.0f;
            f5 = 0.0f;
        }
        this.f13966o.setScaleX(j.i(f5, f6, f4));
        this.f13966o.setScaleY(j.i(f5, f6, this.f13943Q));
    }

    private void X() {
        Activity c3 = j.c(this.f13956e);
        if (c3 == null || !(c3.isFinishing() || c3.isDestroyed())) {
            A();
            View view = this.f13963l;
            Point point = this.f13958g;
            showAtLocation(view, 0, point.x, point.y);
            j.q(this.f13966o, false);
            for (ViewParent parent = this.f13966o.getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipToOutline(false);
                viewGroup.setClipChildren(false);
                j.q((View) parent, false);
            }
        }
    }

    private void b0() {
        int i3 = this.f13954b0.i() + this.f13967p.getPaddingLeft() + this.f13967p.getPaddingRight();
        int i4 = this.f13932F;
        if (i4 == 8) {
            i3 = Math.min((((this.f13964m.right - this.f13951Y.right) - this.f13953a0) + this.f13967p.getPaddingRight()) - this.f13934H, i3);
        } else if (i4 == 16) {
            i3 = Math.min(((this.f13951Y.left - this.f13964m.left) - this.f13953a0) - (this.f13934H - this.f13967p.getPaddingLeft()), i3);
        }
        Rect rect = this.f13964m;
        int max = Math.max(Math.min(rect.right - rect.left, i3), 0);
        this.f13954b0.h(this.f13967p, max);
        this.f13967p.measure(0, 0);
        setWidth(this.f13954b0.c(max, this.f13967p));
        int measuredHeight = this.f13967p.getMeasuredHeight();
        Rect rect2 = this.f13964m;
        setHeight(Math.min(measuredHeight, rect2.bottom - rect2.top));
        if (((this.f13951Y.centerY() - (((F() + this.f13967p.getPaddingTop()) - this.f13967p.getPaddingBottom()) / 2)) + F()) - this.f13967p.getPaddingBottom() >= this.f13964m.bottom) {
            this.f13932F = 4;
            int i5 = this.f13954b0.i() + this.f13967p.getPaddingLeft() + this.f13967p.getPaddingRight();
            Rect rect3 = this.f13964m;
            int max2 = Math.max(Math.min(rect3.right - rect3.left, i5), 0);
            this.f13954b0.h(this.f13967p, max2);
            this.f13967p.measure(0, 0);
            setWidth(this.f13954b0.c(max2, this.f13967p));
            setHeight(this.f13967p.getMeasuredHeight());
        }
    }

    private void c0() {
        View view = this.f13963l;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.f13947U);
        }
    }

    static /* synthetic */ h r(C0629c c0629c) {
        c0629c.getClass();
        return null;
    }

    private void v(Rect rect, int i3, int i4) {
        if (N(this.f13969r)) {
            i3 = -i3;
        }
        int i5 = this.f13932F;
        if (i5 == 128 || i5 == 4) {
            i4 = 0;
        } else {
            i3 = 0;
        }
        this.f13968q = new ImageView(this.f13956e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i6 = this.f13932F;
        if (i6 == 4 || i6 == 128) {
            L(rect, layoutParams, i3, i4);
        } else if (i6 == 16) {
            I(rect, layoutParams, i3, i4);
        } else {
            J(rect, layoutParams, i3, i4);
        }
        this.f13966o.addView(this.f13968q, layoutParams);
        j.q(this.f13968q, false);
    }

    private void w() {
        i.e(this.f13967p, 3, this.f13956e.getResources().getDimensionPixelOffset(M1.f.f1443f0), this.f13956e.getResources().getDimensionPixelOffset(M1.f.f1445g0), androidx.core.content.a.c(this.f13956e, AbstractC0360b.f11593a));
        i.e(this.f13968q, 3, this.f13956e.getResources().getDimensionPixelOffset(M1.f.f1443f0), this.f13956e.getResources().getDimensionPixelOffset(M1.f.f1445g0), androidx.core.content.a.c(this.f13956e, AbstractC0360b.f11593a));
        y(true);
    }

    private void x() {
        i.b(this.f13967p);
        i.b(this.f13968q);
        y(false);
        this.f13941O = true;
        if (isTouchable()) {
            setTouchable(false);
            update();
            this.f13959h = true;
        }
        this.f13966o.removeCallbacks(this.f13950X);
        this.f13966o.postDelayed(this.f13950X, 320L);
    }

    private void y(boolean z3) {
        this.f13945S = z3;
        this.f13966o.setPivotX(this.f13939M * getWidth());
        this.f13966o.setPivotY(this.f13940N * getHeight());
        Z.c cVar = new Z.c(Float.valueOf(this.f13943Q), this.f13960i);
        Z.d dVar = new Z.d();
        dVar.d(0.2f);
        dVar.g(0.4f);
        cVar.B(dVar);
        cVar.o(0.0f);
        cVar.u(10000.0f);
        Z.c cVar2 = new Z.c(Float.valueOf(this.f13944R), this.f13961j);
        Z.d dVar2 = new Z.d();
        dVar2.d(0.2f);
        dVar2.g(0.3f);
        cVar2.B(dVar2);
        cVar2.o(0.0f);
        cVar2.u(10000.0f);
    }

    private void z() {
        int i3 = this.f13932F;
        if (i3 != 4 && i3 != 128) {
            this.f13939M = i3 == 16 ? 1.0f : 0.0f;
            this.f13940N = ((this.f13951Y.centerY() - this.f13958g.y) - this.f13938L[1]) / F();
            return;
        }
        if ((this.f13951Y.centerX() - this.f13938L[0]) - this.f13958g.x >= G()) {
            this.f13939M = 1.0f;
        } else if (G() != 0) {
            int centerX = (this.f13951Y.centerX() - this.f13938L[0]) - this.f13958g.x;
            if (centerX <= 0) {
                centerX = -centerX;
            }
            this.f13939M = centerX / G();
        } else {
            this.f13939M = 0.5f;
        }
        if (this.f13958g.y >= this.f13951Y.top - this.f13938L[1]) {
            this.f13940N = 0.0f;
        } else {
            this.f13940N = 1.0f;
        }
    }

    public void D() {
        E();
        this.f13941O = false;
    }

    public void M(int i3) {
        int i4 = this.f13954b0.g()[0];
        int i5 = this.f13954b0.g()[1];
        this.f13962k = i3;
        if (this.f13954b0 instanceof C0627a) {
            this.f13970s = androidx.core.content.a.e(this.f13956e, i3 == 0 ? f2.d.f11610b : f2.d.f11612d);
            this.f13974w = androidx.core.content.a.e(this.f13956e, i3 == 0 ? f2.d.f11609a : f2.d.f11611c);
        } else {
            this.f13970s = androidx.core.content.a.e(this.f13956e, f2.d.f11612d);
            this.f13974w = androidx.core.content.a.e(this.f13956e, f2.d.f11611c);
        }
        TypedArray obtainStyledAttributes = this.f13956e.obtainStyledAttributes(null, f2.h.f11621a, i4, i5);
        int color = obtainStyledAttributes.getColor(f2.h.f11623c, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11633m, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11634n, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11632l, -1);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11631k, -1);
        this.f13953a0 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11622b, 0);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11622b, 0);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11630j, 0);
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11637q, 0);
        int dimensionPixelSize8 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11638r, 0);
        int dimensionPixelSize9 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11636p, 0);
        int dimensionPixelSize10 = obtainStyledAttributes.getDimensionPixelSize(f2.h.f11635o, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f13956e).inflate(this.f13954b0.e(), (ViewGroup) null);
        this.f13967p = viewGroup;
        viewGroup.setMinimumWidth(dimensionPixelSize6);
        S(color, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        ViewGroup C3 = C(this.f13956e);
        this.f13966o = C3;
        AbstractC0342a.b(C3, false);
        this.f13954b0.d(this.f13967p);
        if (N(this.f13967p)) {
            this.f13965n = new Rect(dimensionPixelSize9, dimensionPixelSize8, dimensionPixelSize7, dimensionPixelSize10);
        } else {
            this.f13965n = new Rect(dimensionPixelSize7, dimensionPixelSize8, dimensionPixelSize9, dimensionPixelSize10);
        }
        setClippingEnabled(false);
        setAnimationStyle(0);
        setElevation(this.f13956e.getResources().getDimensionPixelOffset(M1.f.f1443f0));
        setOnDismissListener(this.f13948V);
        ImageView imageView = this.f13968q;
        if (imageView != null) {
            imageView.setBackground(this.f13970s);
        }
        this.f8280c = false;
        i(false);
        int dimensionPixelSize11 = this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11601h) + dimensionPixelSize5;
        int dimensionPixelSize12 = this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11600g) + dimensionPixelSize5;
        a(dimensionPixelSize11, E.a.TOP);
        a(dimensionPixelSize12, E.a.BOTTOM);
        a(dimensionPixelSize5, E.a.START);
        a(dimensionPixelSize5, E.a.END);
        a(this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11598e), E.a.NAVIGATION);
        a(this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11599f), E.a.TOOLBAR);
        this.f13946T = this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11597d);
        this.f13934H = this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11595b);
        this.f13955c0 = this.f13956e.getResources().getDimensionPixelSize(AbstractC0361c.f11596c);
    }

    public boolean N(View view) {
        return view.getLayoutDirection() == 1;
    }

    public void Q() {
        Activity c3 = j.c(this.f13956e);
        if (c3 != null && (c3.isFinishing() || c3.isDestroyed())) {
            AbstractC0371a.c("COUIToolTips", "activity is not active when refreshWhileLayoutChange");
            return;
        }
        View view = this.f13969r;
        if (view == null || !j.o(view)) {
            D();
            AbstractC0371a.c("COUIToolTips", "mAnchor is now visible, so dismiss it.");
        } else {
            A();
            Point point = this.f13958g;
            update(point.x, point.y, getWidth(), getHeight());
        }
    }

    public void T(CharSequence charSequence) {
        this.f13954b0.f(charSequence);
    }

    public void U(boolean z3) {
        if (z3) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    public void Y(View view, int i3, boolean z3) {
        Z(view, i3, z3, 0, 0);
    }

    public void Z(View view, int i3, boolean z3, int i4, int i5) {
        a0(view, i3, z3, i4, i5, false);
    }

    public void a0(View view, int i3, boolean z3, int i4, int i5, boolean z4) {
        if (isShowing()) {
            return;
        }
        if (this.f13959h) {
            setTouchable(true);
            update();
            this.f13959h = false;
        }
        E.a e3 = this.f8281d.e(view);
        if (e3 == E.a.TOOLBAR) {
            this.f13953a0 = c(e3);
        } else if (e3 == E.a.NAVIGATION) {
            this.f13953a0 = b(view, e3);
        }
        this.f13963l = view.getRootView();
        this.f13933G = z3;
        this.f13935I = z4;
        this.f13936J = i5;
        this.f13937K = i4;
        this.f13932F = i3;
        if (i3 == 32 || i3 == 64) {
            if (N(view)) {
                this.f13932F = this.f13932F == 32 ? 8 : 16;
            } else {
                this.f13932F = this.f13932F != 32 ? 8 : 16;
            }
        } else if (i3 == 256) {
            this.f13932F = 4;
        }
        this.f13969r = view;
        try {
            X();
        } catch (Exception e4) {
            Log.e("COUIToolTips", "showToolTips fail,e:" + e4.getMessage());
        }
        this.f13966o.removeCallbacks(this.f13950X);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        c0();
        if (!this.f13941O) {
            x();
        } else {
            E();
            this.f13941O = false;
        }
    }

    @Override // com.coui.appcompat.poplist.k
    protected void g(Context context, TypedArray typedArray) {
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public C0629c(Context context, int i3) {
        this(context, i3, new C0627a.c().b());
    }

    public C0629c(Context context, int i3, InterfaceC0628b interfaceC0628b) {
        super(context);
        this.f13957f = new int[2];
        this.f13958g = new Point();
        this.f13959h = false;
        this.f13960i = new a("toolTipsScaleProperty");
        this.f13961j = new b("toolTipsAlphaProperty");
        this.f13964m = new Rect();
        this.f13931E = 2;
        this.f13932F = 4;
        this.f13938L = new int[2];
        this.f13942P = -1;
        this.f13943Q = 0.0f;
        this.f13944R = 0.0f;
        this.f13947U = new ViewOnLayoutChangeListenerC0155c();
        this.f13948V = new d();
        this.f13949W = new e();
        this.f13950X = new f();
        this.f13956e = context;
        this.f13954b0 = interfaceC0628b;
        interfaceC0628b.b(this.f13949W, context, i3);
        M(i3);
    }
}
