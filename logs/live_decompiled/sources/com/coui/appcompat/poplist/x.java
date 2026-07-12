package com.coui.appcompat.poplist;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.window.WindowTotalSizeClass;
import h0.AbstractC0371a;
import java.util.Arrays;

/* loaded from: classes.dex */
final class x {

    /* renamed from: U, reason: collision with root package name */
    private static final boolean f8392U;

    /* renamed from: V, reason: collision with root package name */
    private static final Rect f8393V;

    /* renamed from: W, reason: collision with root package name */
    private static final Rect f8394W;

    /* renamed from: A, reason: collision with root package name */
    private u f8395A;

    /* renamed from: B, reason: collision with root package name */
    private int f8396B;

    /* renamed from: C, reason: collision with root package name */
    private int f8397C;

    /* renamed from: D, reason: collision with root package name */
    private int f8398D;

    /* renamed from: E, reason: collision with root package name */
    private int f8399E;

    /* renamed from: F, reason: collision with root package name */
    private ResponsiveUIModel f8400F;

    /* renamed from: G, reason: collision with root package name */
    private int f8401G;

    /* renamed from: H, reason: collision with root package name */
    private int f8402H;

    /* renamed from: I, reason: collision with root package name */
    private int f8403I;

    /* renamed from: J, reason: collision with root package name */
    private int f8404J;

    /* renamed from: K, reason: collision with root package name */
    private int f8405K;

    /* renamed from: L, reason: collision with root package name */
    private int f8406L;

    /* renamed from: S, reason: collision with root package name */
    private boolean f8413S;

    /* renamed from: T, reason: collision with root package name */
    private DisplayCutout f8414T;

    /* renamed from: l, reason: collision with root package name */
    private t f8426l;

    /* renamed from: m, reason: collision with root package name */
    private t f8427m;

    /* renamed from: n, reason: collision with root package name */
    private t f8428n;

    /* renamed from: o, reason: collision with root package name */
    private t f8429o;

    /* renamed from: p, reason: collision with root package name */
    private t f8430p;

    /* renamed from: q, reason: collision with root package name */
    private t f8431q;

    /* renamed from: r, reason: collision with root package name */
    private t f8432r;

    /* renamed from: s, reason: collision with root package name */
    private t f8433s;

    /* renamed from: t, reason: collision with root package name */
    private t f8434t;

    /* renamed from: u, reason: collision with root package name */
    private u f8435u;

    /* renamed from: v, reason: collision with root package name */
    private u f8436v;

    /* renamed from: w, reason: collision with root package name */
    private u f8437w;

    /* renamed from: x, reason: collision with root package name */
    private u f8438x;

    /* renamed from: y, reason: collision with root package name */
    private u f8439y;

    /* renamed from: z, reason: collision with root package name */
    private u f8440z;

    /* renamed from: a, reason: collision with root package name */
    final Rect f8415a = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f8418d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final Rect f8419e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final Rect f8420f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private final Rect f8421g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    private final Rect f8422h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    private final int[] f8423i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    private final int[] f8424j = new int[2];

    /* renamed from: k, reason: collision with root package name */
    private final int[] f8425k = new int[2];

    /* renamed from: M, reason: collision with root package name */
    private int f8407M = 0;

    /* renamed from: N, reason: collision with root package name */
    private int f8408N = 0;

    /* renamed from: O, reason: collision with root package name */
    private boolean f8409O = false;

    /* renamed from: P, reason: collision with root package name */
    private boolean f8410P = false;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f8411Q = true;

    /* renamed from: R, reason: collision with root package name */
    private boolean f8412R = false;

    /* renamed from: b, reason: collision with root package name */
    private final v f8416b = new v();

    /* renamed from: c, reason: collision with root package name */
    private final z f8417c = new z();

    class a implements u {
        a() {
        }

        @Override // com.coui.appcompat.poplist.u
        public void a(v vVar) {
            int centerX = vVar.f8379b.centerX() - (x.this.f8396B / 2);
            if (x.this.f8420f.right - x.this.f8420f.left >= x.this.f8396B) {
                centerX = Math.min(Math.max(centerX, x.this.f8420f.left), x.this.f8420f.right - x.this.f8396B);
            }
            Rect rect = vVar.f8380c;
            rect.set(centerX, rect.top, x.this.f8396B + centerX, vVar.f8380c.bottom);
        }
    }

    class b implements u {
        b() {
        }

        @Override // com.coui.appcompat.poplist.u
        public void a(v vVar) {
            int centerY = vVar.f8379b.centerY() - (x.this.f8397C / 2);
            if (x.this.f8420f.bottom - x.this.f8420f.top >= x.this.f8397C) {
                centerY = Math.min(Math.max(centerY, x.this.f8420f.top), x.this.f8420f.bottom - x.this.f8397C);
            }
            Rect rect = vVar.f8380c;
            rect.set(rect.left, centerY, rect.right, x.this.f8397C + centerY);
        }
    }

    class c implements u {
        c() {
        }

        private int b() {
            int centerX = x.this.f8416b.f8379b.centerX() - (x.this.f8396B / 2);
            if (centerX < x.this.f8420f.left) {
                centerX = x.this.f8420f.left;
            }
            if (x.this.f8396B + centerX > x.this.f8420f.right) {
                centerX = x.this.f8420f.right - x.this.f8396B;
            }
            if (centerX < x.this.f8420f.left) {
                centerX = x.this.f8420f.centerX() - (x.this.f8396B / 2);
            }
            if (x.f8392U) {
                Log.d("PopupMenuLocateHelper", "mMainMenuLocateXRule mAnchor [left " + x.this.f8416b.f8379b.left + " top " + x.this.f8416b.f8379b.top + " right " + x.this.f8416b.f8379b.right + " bottom " + x.this.f8416b.f8379b.bottom + "] mMainMenuWidth " + x.this.f8396B + " mAvailableBounds [left " + x.this.f8420f.left + " top " + x.this.f8420f.top + " right " + x.this.f8420f.right + " bottom " + x.this.f8420f.bottom + "] result x = " + centerX);
            }
            return centerX;
        }

        @Override // com.coui.appcompat.poplist.u
        public void a(v vVar) {
            int b3 = b();
            Rect rect = vVar.f8380c;
            rect.set(b3, rect.top, x.this.f8396B + b3, vVar.f8380c.bottom);
        }
    }

    class d implements u {

        /* renamed from: e, reason: collision with root package name */
        int f8444e = 0;

        d() {
        }

        private void b(Rect rect) {
            int max = Math.max(rect.bottom, x.this.f8420f.top);
            int min = Math.min(rect.top, x.this.f8420f.bottom);
            if (x.this.f8409O) {
                if (!c(min)) {
                    d(max);
                }
            } else if (!d(max)) {
                c(min);
            }
            if (x.f8392U) {
                Log.d("PopupMenuLocateHelper", "mMainMenuLocateYRule anchorBounds [left " + rect.left + " top " + rect.top + " right " + rect.right + " bottom " + rect.bottom + "] mMainMenuHeight " + x.this.f8397C + " mAvailableBounds [left " + x.this.f8420f.left + " top " + x.this.f8420f.top + " right " + x.this.f8420f.right + " bottom " + x.this.f8420f.bottom + "] result y = " + this.f8444e);
            }
        }

        private boolean c(int i3) {
            if (i3 - x.this.f8420f.top < x.this.f8397C) {
                return false;
            }
            this.f8444e = i3 - x.this.f8397C;
            return true;
        }

        private boolean d(int i3) {
            if (x.this.f8420f.bottom - i3 < x.this.f8397C) {
                return false;
            }
            this.f8444e = i3;
            return true;
        }

        @Override // com.coui.appcompat.poplist.u
        public void a(v vVar) {
            Rect rect = new Rect();
            vVar.b(rect);
            this.f8444e = x.this.f8420f.top;
            b(rect);
            Rect rect2 = vVar.f8380c;
            int i3 = rect2.left;
            int i4 = this.f8444e;
            rect2.set(i3, i4, rect2.right, x.this.f8397C + i4);
        }
    }

    class e implements u {
        e() {
        }

        private int b(v vVar) {
            int centerX = vVar.f8379b.centerX();
            int centerX2 = vVar.f8380c.centerX();
            if (centerX < centerX2 - 1) {
                return 0;
            }
            return centerX > centerX2 + 1 ? x.this.f8406L : x.this.f8406L / 2;
        }

        private int c(v vVar) {
            if (vVar.f8380c.top + x.this.f8403I + x.this.f8399E < x.this.f8420f.bottom) {
                return 0;
            }
            return ((x.this.f8420f.bottom - x.this.f8399E) - x.this.f8403I) - vVar.f8380c.top;
        }

        @Override // com.coui.appcompat.poplist.u
        public void a(v vVar) {
            if (!x.this.G()) {
                vVar.f8381d.set(vVar.f8380c);
                return;
            }
            Rect rect = vVar.f8381d;
            Rect rect2 = vVar.f8380c;
            rect.set(rect2.left, rect2.top, rect2.right - x.this.f8406L, vVar.f8380c.bottom - ((int) ((x.this.f8406L / vVar.f8380c.width()) * vVar.f8380c.height())));
            vVar.f8381d.offset(b(vVar), c(vVar));
        }
    }

    class f implements u {
        f() {
        }

        private int b(v vVar) {
            int i3;
            int i4;
            if (x.this.G()) {
                return vVar.f8380c.left;
            }
            if (x.this.f8410P) {
                if ((vVar.f8381d.right - x.this.f8404J) + x.this.f8398D < x.this.f8420f.right) {
                    i3 = vVar.f8381d.right;
                    i4 = x.this.f8404J;
                } else {
                    i3 = vVar.f8381d.left + x.this.f8404J;
                    i4 = x.this.f8398D;
                }
            } else if ((vVar.f8381d.left + x.this.f8404J) - x.this.f8398D > x.this.f8420f.left) {
                i3 = vVar.f8381d.left + x.this.f8404J;
                i4 = x.this.f8398D;
            } else {
                i3 = vVar.f8381d.right;
                i4 = x.this.f8404J;
            }
            return i3 - i4;
        }

        private int c(v vVar) {
            int i3;
            int i4;
            if (x.this.G()) {
                i3 = d(vVar);
                if ((i3 - x.this.f8405K) + x.this.f8399E < x.this.f8420f.bottom) {
                    i4 = x.this.f8405K;
                } else {
                    i3 = x.this.f8420f.bottom;
                    i4 = x.this.f8399E;
                }
            } else {
                if (x.this.f8421g.top + x.this.f8399E < x.this.f8420f.bottom) {
                    return x.this.f8421g.top;
                }
                i3 = x.this.f8420f.bottom;
                i4 = x.this.f8399E;
            }
            return i3 - i4;
        }

        private int d(v vVar) {
            int i3 = x.this.f8421g.top;
            return (int) (vVar.f8381d.top + ((vVar.f8380c.height() > 0 ? vVar.f8381d.height() / vVar.f8380c.height() : 1.0f) * (i3 - r0.top)));
        }

        @Override // com.coui.appcompat.poplist.u
        public void a(v vVar) {
            vVar.f8382e.set(0, 0, x.this.f8398D, x.this.f8399E);
            vVar.f8382e.offset(b(vVar), c(vVar));
        }
    }

    class g extends p {
        g() {
            super(null);
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return -1;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            return x.this.f8415a;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 0;
        }
    }

    class h extends p {

        /* renamed from: f, reason: collision with root package name */
        private final Rect f8449f;

        h() {
            super(null);
            this.f8449f = new Rect();
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return 0;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            this.f8449f.set(0, 0, Math.max(x.this.f8400F.margin(), x.this.f8418d.left), Math.abs(x.this.f8415a.height()));
            return this.f8449f;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 2;
        }
    }

    class i extends p {

        /* renamed from: f, reason: collision with root package name */
        private final Rect f8451f;

        i() {
            super(null);
            this.f8451f = new Rect();
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return 2;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            int margin = x.this.f8400F.margin();
            x xVar = x.this;
            int max = Math.max(margin, xVar.f8415a.right - xVar.f8418d.right);
            Rect rect = this.f8451f;
            Rect rect2 = x.this.f8415a;
            int i3 = rect2.right;
            rect.set(i3 - max, 0, i3, Math.abs(rect2.height()));
            return this.f8451f;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 2;
        }
    }

    class j extends p {

        /* renamed from: f, reason: collision with root package name */
        private final Rect f8453f;

        j() {
            super(null);
            this.f8453f = new Rect();
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return 1;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            this.f8453f.set(0, 0, Math.abs(x.this.f8415a.width()), x.this.f8418d.top + x.this.f8401G);
            return this.f8453f;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 2;
        }
    }

    class k extends p {

        /* renamed from: f, reason: collision with root package name */
        private final Rect f8455f;

        k() {
            super(null);
            this.f8455f = new Rect();
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            if (x.this.f8414T == null) {
                return -1;
            }
            if (!x.this.f8414T.getBoundingRectTop().isEmpty()) {
                return 1;
            }
            if (!x.this.f8414T.getBoundingRectBottom().isEmpty()) {
                return 3;
            }
            if (x.this.f8414T.getBoundingRectLeft().isEmpty()) {
                return !x.this.f8414T.getBoundingRectRight().isEmpty() ? 2 : -1;
            }
            return 0;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            if (x.this.f8414T == null) {
                return this.f8455f;
            }
            if (!x.this.f8414T.getBoundingRectTop().isEmpty()) {
                this.f8455f.set(0, 0, x.this.f8415a.width(), Math.max(x.this.f8418d.top, x.this.f8414T.getBoundingRectTop().bottom));
            } else if (!x.this.f8414T.getBoundingRectBottom().isEmpty()) {
                this.f8455f.set(0, x.this.f8414T.getBoundingRectBottom().top, Math.abs(x.this.f8415a.width()), x.this.f8415a.bottom);
            } else if (!x.this.f8414T.getBoundingRectLeft().isEmpty()) {
                this.f8455f.set(0, 0, x.this.f8414T.getBoundingRectLeft().right, Math.abs(x.this.f8415a.height()));
            } else if (!x.this.f8414T.getBoundingRectRight().isEmpty()) {
                Rect rect = this.f8455f;
                int i3 = x.this.f8414T.getBoundingRectRight().left;
                Rect rect2 = x.this.f8415a;
                rect.set(i3, 0, rect2.right, Math.abs(rect2.height()));
            }
            return this.f8455f;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 2;
        }
    }

    class l extends p {

        /* renamed from: f, reason: collision with root package name */
        private final Rect f8457f;

        /* renamed from: g, reason: collision with root package name */
        private final Rect f8458g;

        l() {
            super(null);
            this.f8457f = new Rect();
            this.f8458g = new Rect(0, x.this.f8402H, 0, 0);
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return 3;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            x xVar = x.this;
            int i3 = xVar.f8415a.bottom - xVar.f8418d.bottom;
            Rect rect = this.f8457f;
            Rect rect2 = x.this.f8415a;
            rect.set(0, rect2.bottom - i3, Math.abs(rect2.width()), x.this.f8415a.bottom);
            return this.f8457f;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return this.f8458g;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 2;
        }
    }

    class m extends p {
        m() {
            super(null);
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return -1;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            return x.this.f8419e;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 1;
        }
    }

    class n extends p {
        n() {
            super(null);
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return -1;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            return x.this.f8419e;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8394W;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 1;
        }
    }

    class o extends p {
        o() {
            super(null);
        }

        @Override // com.coui.appcompat.poplist.t
        public int getBarrierDirection() {
            return -1;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getDisplayFrame() {
            return x.this.f8421g;
        }

        @Override // com.coui.appcompat.poplist.t
        public Rect getOutsets() {
            return x.f8393V;
        }

        @Override // com.coui.appcompat.poplist.t
        public int getType() {
            return 3;
        }
    }

    static {
        f8392U = AbstractC0371a.f11873b || AbstractC0371a.e("PopupMenuLocateHelper", 3);
        f8393V = new Rect();
        f8394W = new Rect();
    }

    public x(Context context) {
        this.f8401G = 0;
        this.f8402H = 0;
        this.f8403I = 0;
        this.f8404J = 0;
        this.f8405K = 0;
        this.f8406L = 0;
        this.f8401G = context.getResources().getDimensionPixelOffset(V1.c.f2552s);
        this.f8402H = context.getResources().getDimensionPixelOffset(V1.c.f2539f);
        this.f8403I = context.getResources().getDimensionPixelOffset(V1.c.f2548o);
        this.f8406L = context.getResources().getDimensionPixelOffset(V1.c.f2546m);
        this.f8404J = context.getResources().getDimensionPixelOffset(V1.c.f2543j);
        this.f8405K = context.getResources().getDimensionPixelOffset(V1.c.f2553t);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(V1.c.f2540g);
        f8394W.set(0, dimensionPixelOffset, 0, dimensionPixelOffset);
        X();
    }

    private void A() {
        this.f8417c.a(this.f8434t, this.f8416b).a(this.f8440z, this.f8416b).a(this.f8395A, this.f8416b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof t) {
            t tVar = (t) view;
            if (tVar.getType() == 2) {
                this.f8417c.a(tVar, this.f8416b);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                B(viewGroup.getChildAt(i3));
            }
        }
    }

    private void D(View view, Rect rect) {
        view.getGlobalVisibleRect(rect);
        view.getLocationInWindow(this.f8425k);
        int[] iArr = this.f8425k;
        rect.offset(iArr[0] - rect.left, iArr[1] - rect.top);
        int i3 = rect.left;
        int i4 = rect.top;
        if (view.getWidth() != 0 && view.getScaleX() != 0.0f) {
            float pivotX = view.getPivotX() / view.getWidth();
            i3 = (int) ((rect.left + (rect.width() * pivotX)) - ((rect.width() * pivotX) / view.getScaleX()));
        }
        if (view.getHeight() != 0 && view.getScaleY() != 0.0f) {
            float pivotY = view.getPivotY() / view.getHeight();
            i4 = (int) ((rect.top + (rect.height() * pivotY)) - ((rect.height() * pivotY) / view.getScaleY()));
        }
        rect.set(i3, i4, view.getWidth() + i3, view.getHeight() + i4);
        if (f8392U) {
            Log.d("PopupMenuLocateHelper", "bounds with scale transform = " + rect + ",mAnchorLocationInWindow:" + Arrays.toString(this.f8425k) + " origin width = " + view.getWidth() + " origin height = " + view.getHeight() + " offset x = " + i3 + " offset y = " + i4 + " bounds = " + rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(v vVar) {
        int i3 = this.f8407M;
        vVar.f8387j = i3;
        vVar.f8388k = this.f8408N;
        int min = Math.min(Math.max(this.f8420f.left, vVar.f8380c.left + i3), this.f8420f.right - vVar.f8380c.width());
        int min2 = Math.min(Math.max(this.f8420f.top, vVar.f8380c.top + this.f8408N), this.f8420f.bottom - vVar.f8380c.height());
        Rect rect = vVar.f8380c;
        rect.set(min, min2, rect.width() + min, vVar.f8380c.height() + min2);
    }

    private void L(View view, int i3, int i4, View view2) {
        D(view, this.f8419e);
        if (i3 != Integer.MIN_VALUE && i4 != Integer.MIN_VALUE) {
            Rect rect = this.f8419e;
            int i5 = rect.left;
            int i6 = rect.top;
            rect.set(i5 + i3, i6 + i4, i5 + i3, i6 + i4);
        }
        Rect rect2 = this.f8418d;
        int[] iArr = this.f8423i;
        rect2.offset(-iArr[0], -iArr[1]);
        Rect rect3 = this.f8418d;
        rect3.bottom = Math.min(rect3.bottom, this.f8415a.bottom);
        ResponsiveUIModel responsiveUIModel = this.f8400F;
        if (responsiveUIModel == null) {
            ResponsiveUIModel responsiveUIModel2 = new ResponsiveUIModel(view.getContext(), Math.abs(this.f8415a.width()), Math.abs(this.f8415a.height()));
            this.f8400F = responsiveUIModel2;
            responsiveUIModel2.chooseMargin(MarginType.MARGIN_SMALL);
        } else {
            responsiveUIModel.rebuild(Math.abs(this.f8415a.width()), Math.abs(this.f8415a.height()));
        }
        if (view.getRootView().isAttachedToWindow()) {
            return;
        }
        Log.d("PopupMenuLocateHelper", "Detected an unattached anchor, could be a dummy anchor");
        this.f8413S = true;
    }

    private void O(View view) {
        view.getGlobalVisibleRect(this.f8421g);
    }

    private void P() {
        this.f8432r = new m();
    }

    private void Q() {
        this.f8433s = new n();
    }

    private void R() {
        this.f8437w = new a();
    }

    private void S() {
        this.f8438x = new b();
    }

    private void T() {
        this.f8439y = new u() { // from class: com.coui.appcompat.poplist.w
            @Override // com.coui.appcompat.poplist.u
            public final void a(v vVar) {
                x.this.H(vVar);
            }
        };
    }

    private void U() {
        this.f8435u = new c();
    }

    private void V() {
        this.f8436v = new d();
    }

    private void W() {
        this.f8440z = new e();
    }

    private void X() {
        b0();
        d0();
        e0();
        f0();
        a0();
        c0();
        P();
        Q();
        Z();
        U();
        V();
        T();
        W();
        Y();
        R();
        S();
    }

    private void Y() {
        this.f8395A = new f();
    }

    private void Z() {
        this.f8434t = new o();
    }

    private void a0() {
        this.f8430p = new l();
    }

    private void b0() {
        this.f8426l = new g();
    }

    private void c0() {
        this.f8431q = new k();
    }

    private void d0() {
        this.f8427m = new h();
    }

    private void e0() {
        this.f8428n = new i();
    }

    private void f0() {
        this.f8429o = new j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y(View view, int i3, int i4) {
        this.f8416b.i();
        this.f8417c.a(this.f8426l, this.f8416b);
        if (!this.f8413S && this.f8411Q) {
            this.f8417c.a(this.f8427m, this.f8416b).a(this.f8429o, this.f8416b).a(this.f8428n, this.f8416b).a(this.f8430p, this.f8416b).a(this.f8431q, this.f8416b);
        }
        if (view instanceof t) {
            t tVar = (t) view;
            if (tVar.getType() == 1) {
                this.f8417c.a(tVar, this.f8416b);
                return;
            }
        }
        if (i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE) {
            this.f8417c.a(this.f8433s, this.f8416b);
        } else {
            this.f8417c.a(this.f8432r, this.f8416b);
        }
    }

    private void z() {
        if (this.f8412R) {
            this.f8417c.a(this.f8437w, this.f8416b).a(this.f8438x, this.f8416b);
        } else {
            this.f8417c.a(this.f8435u, this.f8416b).a(this.f8436v, this.f8416b);
        }
        this.f8417c.a(this.f8439y, this.f8416b);
    }

    public v C() {
        return this.f8416b;
    }

    public int E() {
        return this.f8416b.d();
    }

    public int F() {
        return G() ? this.f8416b.d() : this.f8416b.d() - this.f8403I;
    }

    boolean G() {
        ResponsiveUIModel responsiveUIModel = this.f8400F;
        return responsiveUIModel != null && responsiveUIModel.windowSizeClass().getWindowTotalSizeClass() == WindowTotalSizeClass.Compact;
    }

    public void I(int i3, int i4, boolean z3, int i5, int i6) {
        this.f8409O = z3;
        this.f8407M = i5;
        this.f8408N = i6;
        this.f8416b.c(this.f8420f);
        this.f8396B = Math.min(i3, Math.abs(this.f8420f.width()));
        this.f8397C = Math.min(i4, Math.abs(this.f8420f.height()));
        z();
        this.f8416b.a();
        this.f8417c.f();
    }

    public void J(View view, int i3, int i4, boolean z3) {
        this.f8410P = z3;
        boolean G3 = G();
        O(view);
        this.f8398D = Math.min(i3, Math.abs(this.f8420f.width()));
        this.f8399E = Math.min(i4, Math.abs(this.f8420f.height()) - (G3 ? this.f8403I : 0));
        A();
        this.f8416b.a();
    }

    public void K(View view, int i3, int i4, View view2) {
        View rootView = view2 != null ? view2 : view.getRootView();
        rootView.getLocationOnScreen(this.f8423i);
        rootView.getGlobalVisibleRect(this.f8415a);
        rootView.getWindowVisibleDisplayFrame(this.f8418d);
        if (f8392U) {
            Log.d("PopupMenuLocateHelper", "limited window = " + rootView + " anchor = " + view + " window location = (" + this.f8423i[0] + ", " + this.f8423i[1] + ") anchor location = (" + this.f8424j[0] + ", " + this.f8424j[1] + ") final offset = (" + i3 + ", " + i4 + ") use window barrier = " + this.f8411Q + " center align = " + this.f8412R + " mApplicationWindow [left " + this.f8415a.left + " top " + this.f8415a.top + " right " + this.f8415a.right + " bottom " + this.f8415a.bottom + "]");
        }
        L(view, i3, i4, view2);
        if (view.getRootWindowInsets() != null) {
            this.f8414T = view.getRootWindowInsets().getDisplayCutout();
        }
        this.f8417c.e();
        y(view, i3, i4);
        B(view.getRootView());
    }

    public void M(boolean z3) {
        this.f8412R = z3;
        this.f8416b.f8390m = z3;
    }

    void N(boolean z3) {
        this.f8416b.f8389l = z3;
    }

    public void g0(boolean z3) {
        this.f8411Q = z3;
    }

    public boolean x(View view, int i3, int i4, View view2) {
        boolean z3 = true;
        if (view == null) {
            AbstractC0371a.c("PopupMenuLocateHelper", "Anchor is null!");
            return true;
        }
        if (view2 == null) {
            view2 = view.getRootView();
        }
        view2.getWindowVisibleDisplayFrame(this.f8422h);
        if (this.f8422h.width() == this.f8418d.width() && this.f8422h.height() == this.f8418d.height()) {
            z3 = false;
        } else {
            AbstractC0371a.g("PopupMenuLocateHelper", "Visible bounds changed!");
        }
        AbstractC0371a.a("PopupMenuLocateHelper", " old content visible bounds = " + this.f8418d + " new content visible bounds = " + this.f8422h);
        this.f8418d.set(this.f8422h);
        return z3;
    }

    private static class p implements t {

        /* renamed from: e, reason: collision with root package name */
        private boolean f8463e;

        private p() {
            this.f8463e = true;
        }

        @Override // com.coui.appcompat.poplist.t
        public boolean getPopupMenuRuleEnabled() {
            return this.f8463e;
        }

        /* synthetic */ p(g gVar) {
            this();
        }
    }
}
