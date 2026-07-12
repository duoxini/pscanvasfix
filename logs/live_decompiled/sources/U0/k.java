package U0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public class k {

    /* renamed from: m, reason: collision with root package name */
    public static final U0.c f2293m = new i(0.5f);

    /* renamed from: a, reason: collision with root package name */
    d f2294a;

    /* renamed from: b, reason: collision with root package name */
    d f2295b;

    /* renamed from: c, reason: collision with root package name */
    d f2296c;

    /* renamed from: d, reason: collision with root package name */
    d f2297d;

    /* renamed from: e, reason: collision with root package name */
    U0.c f2298e;

    /* renamed from: f, reason: collision with root package name */
    U0.c f2299f;

    /* renamed from: g, reason: collision with root package name */
    U0.c f2300g;

    /* renamed from: h, reason: collision with root package name */
    U0.c f2301h;

    /* renamed from: i, reason: collision with root package name */
    f f2302i;

    /* renamed from: j, reason: collision with root package name */
    f f2303j;

    /* renamed from: k, reason: collision with root package name */
    f f2304k;

    /* renamed from: l, reason: collision with root package name */
    f f2305l;

    public interface c {
        U0.c a(U0.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i3, int i4) {
        return c(context, i3, i4, 0);
    }

    private static b c(Context context, int i3, int i4, int i5) {
        return d(context, i3, i4, new U0.a(i5));
    }

    private static b d(Context context, int i3, int i4, U0.c cVar) {
        if (i4 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
            i3 = i4;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, H0.j.G4);
        try {
            int i5 = obtainStyledAttributes.getInt(H0.j.H4, 0);
            int i6 = obtainStyledAttributes.getInt(H0.j.K4, i5);
            int i7 = obtainStyledAttributes.getInt(H0.j.L4, i5);
            int i8 = obtainStyledAttributes.getInt(H0.j.J4, i5);
            int i9 = obtainStyledAttributes.getInt(H0.j.I4, i5);
            U0.c m3 = m(obtainStyledAttributes, H0.j.M4, cVar);
            U0.c m4 = m(obtainStyledAttributes, H0.j.P4, m3);
            U0.c m5 = m(obtainStyledAttributes, H0.j.Q4, m3);
            U0.c m6 = m(obtainStyledAttributes, H0.j.O4, m3);
            return new b().B(i6, m4).G(i7, m5).w(i8, m6).r(i9, m(obtainStyledAttributes, H0.j.N4, m3));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i3, int i4) {
        return f(context, attributeSet, i3, i4, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i3, int i4, int i5) {
        return g(context, attributeSet, i3, i4, new U0.a(i5));
    }

    public static b g(Context context, AttributeSet attributeSet, int i3, int i4, U0.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H0.j.M3, i3, i4);
        int resourceId = obtainStyledAttributes.getResourceId(H0.j.N3, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(H0.j.O3, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static U0.c m(TypedArray typedArray, int i3, U0.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i3);
        if (peekValue == null) {
            return cVar;
        }
        int i4 = peekValue.type;
        return i4 == 5 ? new U0.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i4 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f2304k;
    }

    public d i() {
        return this.f2297d;
    }

    public U0.c j() {
        return this.f2301h;
    }

    public d k() {
        return this.f2296c;
    }

    public U0.c l() {
        return this.f2300g;
    }

    public f n() {
        return this.f2305l;
    }

    public f o() {
        return this.f2303j;
    }

    public f p() {
        return this.f2302i;
    }

    public d q() {
        return this.f2294a;
    }

    public U0.c r() {
        return this.f2298e;
    }

    public d s() {
        return this.f2295b;
    }

    public U0.c t() {
        return this.f2299f;
    }

    public boolean u(RectF rectF) {
        boolean z3 = this.f2305l.getClass().equals(f.class) && this.f2303j.getClass().equals(f.class) && this.f2302i.getClass().equals(f.class) && this.f2304k.getClass().equals(f.class);
        float a3 = this.f2298e.a(rectF);
        return z3 && ((this.f2299f.a(rectF) > a3 ? 1 : (this.f2299f.a(rectF) == a3 ? 0 : -1)) == 0 && (this.f2301h.a(rectF) > a3 ? 1 : (this.f2301h.a(rectF) == a3 ? 0 : -1)) == 0 && (this.f2300g.a(rectF) > a3 ? 1 : (this.f2300g.a(rectF) == a3 ? 0 : -1)) == 0) && ((this.f2295b instanceof j) && (this.f2294a instanceof j) && (this.f2296c instanceof j) && (this.f2297d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f3) {
        return v().o(f3).m();
    }

    public k x(U0.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().E(cVar.a(r())).J(cVar.a(t())).u(cVar.a(j())).z(cVar.a(l())).m();
    }

    private k(b bVar) {
        this.f2294a = bVar.f2306a;
        this.f2295b = bVar.f2307b;
        this.f2296c = bVar.f2308c;
        this.f2297d = bVar.f2309d;
        this.f2298e = bVar.f2310e;
        this.f2299f = bVar.f2311f;
        this.f2300g = bVar.f2312g;
        this.f2301h = bVar.f2313h;
        this.f2302i = bVar.f2314i;
        this.f2303j = bVar.f2315j;
        this.f2304k = bVar.f2316k;
        this.f2305l = bVar.f2317l;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private d f2306a;

        /* renamed from: b, reason: collision with root package name */
        private d f2307b;

        /* renamed from: c, reason: collision with root package name */
        private d f2308c;

        /* renamed from: d, reason: collision with root package name */
        private d f2309d;

        /* renamed from: e, reason: collision with root package name */
        private U0.c f2310e;

        /* renamed from: f, reason: collision with root package name */
        private U0.c f2311f;

        /* renamed from: g, reason: collision with root package name */
        private U0.c f2312g;

        /* renamed from: h, reason: collision with root package name */
        private U0.c f2313h;

        /* renamed from: i, reason: collision with root package name */
        private f f2314i;

        /* renamed from: j, reason: collision with root package name */
        private f f2315j;

        /* renamed from: k, reason: collision with root package name */
        private f f2316k;

        /* renamed from: l, reason: collision with root package name */
        private f f2317l;

        public b() {
            this.f2306a = h.b();
            this.f2307b = h.b();
            this.f2308c = h.b();
            this.f2309d = h.b();
            this.f2310e = new U0.a(0.0f);
            this.f2311f = new U0.a(0.0f);
            this.f2312g = new U0.a(0.0f);
            this.f2313h = new U0.a(0.0f);
            this.f2314i = h.c();
            this.f2315j = h.c();
            this.f2316k = h.c();
            this.f2317l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f2292a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f2240a;
            }
            return -1.0f;
        }

        public b A(int i3, float f3) {
            return C(h.a(i3)).D(f3);
        }

        public b B(int i3, U0.c cVar) {
            return C(h.a(i3)).E(cVar);
        }

        public b C(d dVar) {
            this.f2306a = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                D(n3);
            }
            return this;
        }

        public b D(float f3) {
            this.f2310e = new U0.a(f3);
            return this;
        }

        public b E(U0.c cVar) {
            this.f2310e = cVar;
            return this;
        }

        public b F(int i3, float f3) {
            return H(h.a(i3)).I(f3);
        }

        public b G(int i3, U0.c cVar) {
            return H(h.a(i3)).J(cVar);
        }

        public b H(d dVar) {
            this.f2307b = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                I(n3);
            }
            return this;
        }

        public b I(float f3) {
            this.f2311f = new U0.a(f3);
            return this;
        }

        public b J(U0.c cVar) {
            this.f2311f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f3) {
            return D(f3).I(f3).y(f3).t(f3);
        }

        public b p(U0.c cVar) {
            return E(cVar).J(cVar).z(cVar).u(cVar);
        }

        public b q(int i3, float f3) {
            return s(h.a(i3)).t(f3);
        }

        public b r(int i3, U0.c cVar) {
            return s(h.a(i3)).u(cVar);
        }

        public b s(d dVar) {
            this.f2309d = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                t(n3);
            }
            return this;
        }

        public b t(float f3) {
            this.f2313h = new U0.a(f3);
            return this;
        }

        public b u(U0.c cVar) {
            this.f2313h = cVar;
            return this;
        }

        public b v(int i3, float f3) {
            return x(h.a(i3)).y(f3);
        }

        public b w(int i3, U0.c cVar) {
            return x(h.a(i3)).z(cVar);
        }

        public b x(d dVar) {
            this.f2308c = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                y(n3);
            }
            return this;
        }

        public b y(float f3) {
            this.f2312g = new U0.a(f3);
            return this;
        }

        public b z(U0.c cVar) {
            this.f2312g = cVar;
            return this;
        }

        public b(k kVar) {
            this.f2306a = h.b();
            this.f2307b = h.b();
            this.f2308c = h.b();
            this.f2309d = h.b();
            this.f2310e = new U0.a(0.0f);
            this.f2311f = new U0.a(0.0f);
            this.f2312g = new U0.a(0.0f);
            this.f2313h = new U0.a(0.0f);
            this.f2314i = h.c();
            this.f2315j = h.c();
            this.f2316k = h.c();
            this.f2317l = h.c();
            this.f2306a = kVar.f2294a;
            this.f2307b = kVar.f2295b;
            this.f2308c = kVar.f2296c;
            this.f2309d = kVar.f2297d;
            this.f2310e = kVar.f2298e;
            this.f2311f = kVar.f2299f;
            this.f2312g = kVar.f2300g;
            this.f2313h = kVar.f2301h;
            this.f2314i = kVar.f2302i;
            this.f2315j = kVar.f2303j;
            this.f2316k = kVar.f2304k;
            this.f2317l = kVar.f2305l;
        }
    }

    public k() {
        this.f2294a = h.b();
        this.f2295b = h.b();
        this.f2296c = h.b();
        this.f2297d = h.b();
        this.f2298e = new U0.a(0.0f);
        this.f2299f = new U0.a(0.0f);
        this.f2300g = new U0.a(0.0f);
        this.f2301h = new U0.a(0.0f);
        this.f2302i = h.c();
        this.f2303j = h.c();
        this.f2304k = h.c();
        this.f2305l = h.c();
    }
}
