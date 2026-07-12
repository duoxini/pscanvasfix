package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public class J {

    /* renamed from: b, reason: collision with root package name */
    public static final J f5026b = j.f5045l;

    /* renamed from: a, reason: collision with root package name */
    private final k f5027a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f5028a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f5029b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f5030c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f5031d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f5028a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f5029b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f5030c = declaredField3;
                declaredField3.setAccessible(true);
                f5031d = true;
            } catch (ReflectiveOperationException e3) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e3.getMessage(), e3);
            }
        }

        public static J a(View view) {
            if (f5031d && view.isAttachedToWindow()) {
                try {
                    Object obj = f5028a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f5029b.get(obj);
                        Rect rect2 = (Rect) f5030c.get(obj);
                        if (rect != null && rect2 != null) {
                            J a3 = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            a3.t(a3);
                            a3.d(view.getRootView());
                            return a3;
                        }
                    }
                } catch (IllegalAccessException e3) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e3.getMessage(), e3);
                }
            }
            return null;
        }
    }

    private static class d extends c {
        d() {
        }

        d(J j3) {
            super(j3);
        }
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private final J f5034a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b[] f5035b;

        e() {
            this(new J((J) null));
        }

        protected final void a() {
            androidx.core.graphics.b[] bVarArr = this.f5035b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVar = bVarArr[l.d(1)];
                androidx.core.graphics.b bVar2 = this.f5035b[l.d(2)];
                if (bVar2 == null) {
                    bVar2 = this.f5034a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f5034a.f(1);
                }
                f(androidx.core.graphics.b.a(bVar, bVar2));
                androidx.core.graphics.b bVar3 = this.f5035b[l.d(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                androidx.core.graphics.b bVar4 = this.f5035b[l.d(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                androidx.core.graphics.b bVar5 = this.f5035b[l.d(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        abstract J b();

        abstract void c(androidx.core.graphics.b bVar);

        abstract void d(androidx.core.graphics.b bVar);

        abstract void e(androidx.core.graphics.b bVar);

        abstract void f(androidx.core.graphics.b bVar);

        abstract void g(androidx.core.graphics.b bVar);

        e(J j3) {
            this.f5034a = j3;
        }
    }

    private static class h extends g {
        h(J j3, WindowInsets windowInsets) {
            super(j3, windowInsets);
        }

        @Override // androidx.core.view.J.k
        J a() {
            return J.v(this.f5036c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.J.f, androidx.core.view.J.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f5036c, hVar.f5036c) && Objects.equals(this.f5040g, hVar.f5040g);
        }

        @Override // androidx.core.view.J.k
        C0254c f() {
            return C0254c.e(this.f5036c.getDisplayCutout());
        }

        @Override // androidx.core.view.J.k
        public int hashCode() {
            return this.f5036c.hashCode();
        }

        h(J j3, h hVar) {
            super(j3, hVar);
        }
    }

    private static class j extends i {

        /* renamed from: l, reason: collision with root package name */
        static final J f5045l = J.v(WindowInsets.CONSUMED);

        j(J j3, WindowInsets windowInsets) {
            super(j3, windowInsets);
        }

        @Override // androidx.core.view.J.f, androidx.core.view.J.k
        final void d(View view) {
        }

        @Override // androidx.core.view.J.f, androidx.core.view.J.k
        public androidx.core.graphics.b g(int i3) {
            return androidx.core.graphics.b.d(this.f5036c.getInsets(m.a(i3)));
        }

        @Override // androidx.core.view.J.f, androidx.core.view.J.k
        public boolean p(int i3) {
            return this.f5036c.isVisible(m.a(i3));
        }

        j(J j3, j jVar) {
            super(j3, jVar);
        }
    }

    private static class k {

        /* renamed from: b, reason: collision with root package name */
        static final J f5046b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final J f5047a;

        k(J j3) {
            this.f5047a = j3;
        }

        J a() {
            return this.f5047a;
        }

        J b() {
            return this.f5047a;
        }

        J c() {
            return this.f5047a;
        }

        void d(View view) {
        }

        void e(J j3) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return o() == kVar.o() && n() == kVar.n() && androidx.core.util.c.a(k(), kVar.k()) && androidx.core.util.c.a(i(), kVar.i()) && androidx.core.util.c.a(f(), kVar.f());
        }

        C0254c f() {
            return null;
        }

        androidx.core.graphics.b g(int i3) {
            return androidx.core.graphics.b.f4899e;
        }

        androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f4899e;
        }

        androidx.core.graphics.b j() {
            return k();
        }

        androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f4899e;
        }

        androidx.core.graphics.b l() {
            return k();
        }

        J m(int i3, int i4, int i5, int i6) {
            return f5046b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        boolean p(int i3) {
            return true;
        }

        public void q(androidx.core.graphics.b[] bVarArr) {
        }

        void r(androidx.core.graphics.b bVar) {
        }

        void s(J j3) {
        }
    }

    public static final class l {
        public static int a() {
            return 4;
        }

        public static int b() {
            return 128;
        }

        public static int c() {
            return 8;
        }

        static int d(int i3) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 4) {
                return 2;
            }
            if (i3 == 8) {
                return 3;
            }
            if (i3 == 16) {
                return 4;
            }
            if (i3 == 32) {
                return 5;
            }
            if (i3 == 64) {
                return 6;
            }
            if (i3 == 128) {
                return 7;
            }
            if (i3 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i3);
        }

        public static int e() {
            return 32;
        }

        public static int f() {
            return 2;
        }

        public static int g() {
            return 1;
        }

        public static int h() {
            return 7;
        }

        public static int i() {
            return 16;
        }

        public static int j() {
            return 64;
        }
    }

    private static final class m {
        static int a(int i3) {
            int statusBars;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i3 & i5) != 0) {
                    if (i5 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i4 |= statusBars;
                }
            }
            return i4;
        }
    }

    private J(WindowInsets windowInsets) {
        this.f5027a = new j(this, windowInsets);
    }

    static androidx.core.graphics.b n(androidx.core.graphics.b bVar, int i3, int i4, int i5, int i6) {
        int max = Math.max(0, bVar.f4900a - i3);
        int max2 = Math.max(0, bVar.f4901b - i4);
        int max3 = Math.max(0, bVar.f4902c - i5);
        int max4 = Math.max(0, bVar.f4903d - i6);
        return (max == i3 && max2 == i4 && max3 == i5 && max4 == i6) ? bVar : androidx.core.graphics.b.b(max, max2, max3, max4);
    }

    public static J v(WindowInsets windowInsets) {
        return w(windowInsets, null);
    }

    public static J w(WindowInsets windowInsets, View view) {
        J j3 = new J((WindowInsets) androidx.core.util.h.d(windowInsets));
        if (view != null && y.N(view)) {
            j3.t(y.D(view));
            j3.d(view.getRootView());
        }
        return j3;
    }

    public J a() {
        return this.f5027a.a();
    }

    public J b() {
        return this.f5027a.b();
    }

    public J c() {
        return this.f5027a.c();
    }

    void d(View view) {
        this.f5027a.d(view);
    }

    public C0254c e() {
        return this.f5027a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof J) {
            return androidx.core.util.c.a(this.f5027a, ((J) obj).f5027a);
        }
        return false;
    }

    public androidx.core.graphics.b f(int i3) {
        return this.f5027a.g(i3);
    }

    public androidx.core.graphics.b g() {
        return this.f5027a.i();
    }

    public int h() {
        return this.f5027a.k().f4903d;
    }

    public int hashCode() {
        k kVar = this.f5027a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    public int i() {
        return this.f5027a.k().f4900a;
    }

    public int j() {
        return this.f5027a.k().f4902c;
    }

    public int k() {
        return this.f5027a.k().f4901b;
    }

    public boolean l() {
        return !this.f5027a.k().equals(androidx.core.graphics.b.f4899e);
    }

    public J m(int i3, int i4, int i5, int i6) {
        return this.f5027a.m(i3, i4, i5, i6);
    }

    public boolean o() {
        return this.f5027a.n();
    }

    public boolean p(int i3) {
        return this.f5027a.p(i3);
    }

    public J q(int i3, int i4, int i5, int i6) {
        return new b(this).c(androidx.core.graphics.b.b(i3, i4, i5, i6)).a();
    }

    void r(androidx.core.graphics.b[] bVarArr) {
        this.f5027a.q(bVarArr);
    }

    void s(androidx.core.graphics.b bVar) {
        this.f5027a.r(bVar);
    }

    void t(J j3) {
        this.f5027a.s(j3);
    }

    public WindowInsets u() {
        k kVar = this.f5027a;
        if (kVar instanceof f) {
            return ((f) kVar).f5036c;
        }
        return null;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final e f5032a;

        public b() {
            this.f5032a = new d();
        }

        public J a() {
            return this.f5032a.b();
        }

        public b b(androidx.core.graphics.b bVar) {
            this.f5032a.d(bVar);
            return this;
        }

        public b c(androidx.core.graphics.b bVar) {
            this.f5032a.f(bVar);
            return this;
        }

        public b(J j3) {
            this.f5032a = new d(j3);
        }
    }

    private static class c extends e {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f5033c;

        c() {
            this.f5033c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.J.e
        J b() {
            a();
            J v3 = J.v(this.f5033c.build());
            v3.r(this.f5035b);
            return v3;
        }

        @Override // androidx.core.view.J.e
        void c(androidx.core.graphics.b bVar) {
            this.f5033c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.J.e
        void d(androidx.core.graphics.b bVar) {
            this.f5033c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.J.e
        void e(androidx.core.graphics.b bVar) {
            this.f5033c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.J.e
        void f(androidx.core.graphics.b bVar) {
            this.f5033c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.J.e
        void g(androidx.core.graphics.b bVar) {
            this.f5033c.setTappableElementInsets(bVar.e());
        }

        c(J j3) {
            super(j3);
            WindowInsets.Builder builder;
            WindowInsets u3 = j3.u();
            if (u3 != null) {
                builder = new WindowInsets.Builder(u3);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f5033c = builder;
        }
    }

    private static class g extends f {

        /* renamed from: h, reason: collision with root package name */
        private androidx.core.graphics.b f5041h;

        g(J j3, WindowInsets windowInsets) {
            super(j3, windowInsets);
            this.f5041h = null;
        }

        @Override // androidx.core.view.J.k
        J b() {
            return J.v(this.f5036c.consumeStableInsets());
        }

        @Override // androidx.core.view.J.k
        J c() {
            return J.v(this.f5036c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.J.k
        final androidx.core.graphics.b i() {
            if (this.f5041h == null) {
                this.f5041h = androidx.core.graphics.b.b(this.f5036c.getStableInsetLeft(), this.f5036c.getStableInsetTop(), this.f5036c.getStableInsetRight(), this.f5036c.getStableInsetBottom());
            }
            return this.f5041h;
        }

        @Override // androidx.core.view.J.k
        boolean n() {
            return this.f5036c.isConsumed();
        }

        g(J j3, g gVar) {
            super(j3, gVar);
            this.f5041h = null;
            this.f5041h = gVar.f5041h;
        }
    }

    private static class f extends k {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f5036c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b[] f5037d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b f5038e;

        /* renamed from: f, reason: collision with root package name */
        private J f5039f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b f5040g;

        f(J j3, WindowInsets windowInsets) {
            super(j3);
            this.f5038e = null;
            this.f5036c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.b t(int i3, boolean z3) {
            androidx.core.graphics.b bVar = androidx.core.graphics.b.f4899e;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    bVar = androidx.core.graphics.b.a(bVar, u(i4, z3));
                }
            }
            return bVar;
        }

        private androidx.core.graphics.b v() {
            J j3 = this.f5039f;
            return j3 != null ? j3.g() : androidx.core.graphics.b.f4899e;
        }

        private androidx.core.graphics.b w(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.J.k
        void d(View view) {
            androidx.core.graphics.b w3 = w(view);
            if (w3 == null) {
                w3 = androidx.core.graphics.b.f4899e;
            }
            r(w3);
        }

        @Override // androidx.core.view.J.k
        void e(J j3) {
            j3.t(this.f5039f);
            j3.s(this.f5040g);
        }

        @Override // androidx.core.view.J.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f5040g, ((f) obj).f5040g);
            }
            return false;
        }

        @Override // androidx.core.view.J.k
        public androidx.core.graphics.b g(int i3) {
            return t(i3, false);
        }

        @Override // androidx.core.view.J.k
        final androidx.core.graphics.b k() {
            if (this.f5038e == null) {
                this.f5038e = androidx.core.graphics.b.b(this.f5036c.getSystemWindowInsetLeft(), this.f5036c.getSystemWindowInsetTop(), this.f5036c.getSystemWindowInsetRight(), this.f5036c.getSystemWindowInsetBottom());
            }
            return this.f5038e;
        }

        @Override // androidx.core.view.J.k
        J m(int i3, int i4, int i5, int i6) {
            b bVar = new b(J.v(this.f5036c));
            bVar.c(J.n(k(), i3, i4, i5, i6));
            bVar.b(J.n(i(), i3, i4, i5, i6));
            return bVar.a();
        }

        @Override // androidx.core.view.J.k
        boolean o() {
            return this.f5036c.isRound();
        }

        @Override // androidx.core.view.J.k
        @SuppressLint({"WrongConstant"})
        boolean p(int i3) {
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0 && !x(i4)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.J.k
        public void q(androidx.core.graphics.b[] bVarArr) {
            this.f5037d = bVarArr;
        }

        @Override // androidx.core.view.J.k
        void r(androidx.core.graphics.b bVar) {
            this.f5040g = bVar;
        }

        @Override // androidx.core.view.J.k
        void s(J j3) {
            this.f5039f = j3;
        }

        protected androidx.core.graphics.b u(int i3, boolean z3) {
            androidx.core.graphics.b g3;
            int i4;
            if (i3 == 1) {
                return z3 ? androidx.core.graphics.b.b(0, Math.max(v().f4901b, k().f4901b), 0, 0) : androidx.core.graphics.b.b(0, k().f4901b, 0, 0);
            }
            if (i3 == 2) {
                if (z3) {
                    androidx.core.graphics.b v3 = v();
                    androidx.core.graphics.b i5 = i();
                    return androidx.core.graphics.b.b(Math.max(v3.f4900a, i5.f4900a), 0, Math.max(v3.f4902c, i5.f4902c), Math.max(v3.f4903d, i5.f4903d));
                }
                androidx.core.graphics.b k3 = k();
                J j3 = this.f5039f;
                g3 = j3 != null ? j3.g() : null;
                int i6 = k3.f4903d;
                if (g3 != null) {
                    i6 = Math.min(i6, g3.f4903d);
                }
                return androidx.core.graphics.b.b(k3.f4900a, 0, k3.f4902c, i6);
            }
            if (i3 != 8) {
                if (i3 == 16) {
                    return j();
                }
                if (i3 == 32) {
                    return h();
                }
                if (i3 == 64) {
                    return l();
                }
                if (i3 != 128) {
                    return androidx.core.graphics.b.f4899e;
                }
                J j4 = this.f5039f;
                C0254c e3 = j4 != null ? j4.e() : f();
                return e3 != null ? androidx.core.graphics.b.b(e3.b(), e3.d(), e3.c(), e3.a()) : androidx.core.graphics.b.f4899e;
            }
            androidx.core.graphics.b[] bVarArr = this.f5037d;
            g3 = bVarArr != null ? bVarArr[l.d(8)] : null;
            if (g3 != null) {
                return g3;
            }
            androidx.core.graphics.b k4 = k();
            androidx.core.graphics.b v4 = v();
            int i7 = k4.f4903d;
            if (i7 > v4.f4903d) {
                return androidx.core.graphics.b.b(0, 0, 0, i7);
            }
            androidx.core.graphics.b bVar = this.f5040g;
            return (bVar == null || bVar.equals(androidx.core.graphics.b.f4899e) || (i4 = this.f5040g.f4903d) <= v4.f4903d) ? androidx.core.graphics.b.f4899e : androidx.core.graphics.b.b(0, 0, 0, i4);
        }

        protected boolean x(int i3) {
            if (i3 != 1 && i3 != 2) {
                if (i3 == 4) {
                    return false;
                }
                if (i3 != 8 && i3 != 128) {
                    return true;
                }
            }
            return !u(i3, false).equals(androidx.core.graphics.b.f4899e);
        }

        f(J j3, f fVar) {
            this(j3, new WindowInsets(fVar.f5036c));
        }
    }

    public J(J j3) {
        if (j3 != null) {
            k kVar = j3.f5027a;
            if (kVar instanceof j) {
                this.f5027a = new j(this, (j) kVar);
            } else if (kVar instanceof i) {
                this.f5027a = new i(this, (i) kVar);
            } else if (kVar instanceof h) {
                this.f5027a = new h(this, (h) kVar);
            } else if (kVar instanceof g) {
                this.f5027a = new g(this, (g) kVar);
            } else if (kVar instanceof f) {
                this.f5027a = new f(this, (f) kVar);
            } else {
                this.f5027a = new k(this);
            }
            kVar.e(this);
            return;
        }
        this.f5027a = new k(this);
    }

    private static class i extends h {

        /* renamed from: i, reason: collision with root package name */
        private androidx.core.graphics.b f5042i;

        /* renamed from: j, reason: collision with root package name */
        private androidx.core.graphics.b f5043j;

        /* renamed from: k, reason: collision with root package name */
        private androidx.core.graphics.b f5044k;

        i(J j3, WindowInsets windowInsets) {
            super(j3, windowInsets);
            this.f5042i = null;
            this.f5043j = null;
            this.f5044k = null;
        }

        @Override // androidx.core.view.J.k
        androidx.core.graphics.b h() {
            if (this.f5043j == null) {
                this.f5043j = androidx.core.graphics.b.d(this.f5036c.getMandatorySystemGestureInsets());
            }
            return this.f5043j;
        }

        @Override // androidx.core.view.J.k
        androidx.core.graphics.b j() {
            if (this.f5042i == null) {
                this.f5042i = androidx.core.graphics.b.d(this.f5036c.getSystemGestureInsets());
            }
            return this.f5042i;
        }

        @Override // androidx.core.view.J.k
        androidx.core.graphics.b l() {
            if (this.f5044k == null) {
                this.f5044k = androidx.core.graphics.b.d(this.f5036c.getTappableElementInsets());
            }
            return this.f5044k;
        }

        @Override // androidx.core.view.J.f, androidx.core.view.J.k
        J m(int i3, int i4, int i5, int i6) {
            return J.v(this.f5036c.inset(i3, i4, i5, i6));
        }

        i(J j3, i iVar) {
            super(j3, iVar);
            this.f5042i = null;
            this.f5043j = null;
            this.f5044k = null;
        }
    }
}
