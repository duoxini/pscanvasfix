package Z;

import Z.a;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final Y.a f3036a;

    /* renamed from: b, reason: collision with root package name */
    float f3037b;

    /* renamed from: c, reason: collision with root package name */
    float f3038c;

    /* renamed from: d, reason: collision with root package name */
    boolean f3039d;

    /* renamed from: e, reason: collision with root package name */
    final Object f3040e;

    /* renamed from: f, reason: collision with root package name */
    final B.c f3041f;

    /* renamed from: g, reason: collision with root package name */
    boolean f3042g;

    /* renamed from: h, reason: collision with root package name */
    private Z.a f3043h;

    /* renamed from: i, reason: collision with root package name */
    boolean f3044i;

    /* renamed from: j, reason: collision with root package name */
    float f3045j;

    /* renamed from: k, reason: collision with root package name */
    float f3046k;

    /* renamed from: l, reason: collision with root package name */
    private long f3047l;

    /* renamed from: m, reason: collision with root package name */
    private float f3048m;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayList f3049n;

    /* renamed from: o, reason: collision with root package name */
    private final ArrayList f3050o;

    /* renamed from: p, reason: collision with root package name */
    public static final s f3025p = new g("translationX");

    /* renamed from: q, reason: collision with root package name */
    public static final s f3026q = new h("translationY");

    /* renamed from: r, reason: collision with root package name */
    public static final s f3027r = new i("translationZ");

    /* renamed from: s, reason: collision with root package name */
    public static final s f3028s = new j("scaleX");

    /* renamed from: t, reason: collision with root package name */
    public static final s f3029t = new k("scaleY");

    /* renamed from: u, reason: collision with root package name */
    public static final s f3030u = new l("rotation");

    /* renamed from: v, reason: collision with root package name */
    public static final s f3031v = new m("rotationX");

    /* renamed from: w, reason: collision with root package name */
    public static final s f3032w = new n("rotationY");

    /* renamed from: x, reason: collision with root package name */
    public static final s f3033x = new o("x");

    /* renamed from: y, reason: collision with root package name */
    public static final s f3034y = new a("y");

    /* renamed from: z, reason: collision with root package name */
    public static final s f3035z = new C0049b("z");

    /* renamed from: A, reason: collision with root package name */
    public static final s f3022A = new c("alpha");

    /* renamed from: B, reason: collision with root package name */
    public static final s f3023B = new d("scrollX");

    /* renamed from: C, reason: collision with root package name */
    public static final s f3024C = new e("scrollY");

    class a extends s {
        a(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setY(f3);
        }
    }

    /* renamed from: Z.b$b, reason: collision with other inner class name */
    class C0049b extends s {
        C0049b(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return y.I(view);
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            y.E0(view, f3);
        }
    }

    class c extends s {
        c(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setAlpha(f3);
        }
    }

    class d extends s {
        d(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScrollX((int) f3);
        }
    }

    class e extends s {
        e(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScrollY((int) f3);
        }
    }

    class f extends B.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ B.d f3051b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, B.d dVar) {
            super(str);
            this.f3051b = dVar;
        }

        @Override // B.c
        public float a(Object obj) {
            return this.f3051b.a();
        }

        @Override // B.c
        public void b(Object obj, float f3) {
            this.f3051b.b(f3);
        }
    }

    class g extends s {
        g(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setTranslationX(f3);
        }
    }

    class h extends s {
        h(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setTranslationY(f3);
        }
    }

    class i extends s {
        i(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return y.G(view);
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            y.C0(view, f3);
        }
    }

    class j extends s {
        j(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScaleX(f3);
        }
    }

    class k extends s {
        k(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setScaleY(f3);
        }
    }

    class l extends s {
        l(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setRotation(f3);
        }
    }

    class m extends s {
        m(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setRotationX(f3);
        }
    }

    class n extends s {
        n(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setRotationY(f3);
        }
    }

    class o extends s {
        o(String str) {
            super(str, null);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f3) {
            view.setX(f3);
        }
    }

    static class p {

        /* renamed from: a, reason: collision with root package name */
        float f3053a;

        /* renamed from: b, reason: collision with root package name */
        float f3054b;

        p() {
        }
    }

    public interface q {
        void onAnimationEnd(b bVar, boolean z3, float f3, float f4);
    }

    public interface r {
        void onAnimationUpdate(b bVar, float f3, float f4);
    }

    public static abstract class s extends B.c {
        /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        private s(String str) {
            super(str);
        }
    }

    b(B.d dVar) {
        Y.a aVar = new Y.a(null);
        this.f3036a = aVar;
        this.f3037b = 0.0f;
        this.f3038c = Float.MAX_VALUE;
        this.f3039d = false;
        this.f3042g = false;
        this.f3043h = null;
        this.f3044i = false;
        this.f3045j = Float.MAX_VALUE;
        this.f3046k = -Float.MAX_VALUE;
        this.f3047l = 0L;
        this.f3049n = new ArrayList();
        this.f3050o = new ArrayList();
        this.f3040e = null;
        this.f3041f = new f("FloatValueHolder", dVar);
        this.f3048m = 1.0f;
        aVar.d();
    }

    private void d(boolean z3) {
        this.f3044i = false;
        e().g(this);
        this.f3036a.e(hashCode());
        this.f3047l = 0L;
        this.f3039d = false;
        for (int i3 = 0; i3 < this.f3049n.size(); i3++) {
            if (this.f3049n.get(i3) != null) {
                ((q) this.f3049n.get(i3)).onAnimationEnd(this, z3, this.f3038c, this.f3037b);
            }
        }
        k(this.f3049n);
    }

    private Z.a e() {
        Z.a aVar = this.f3043h;
        return aVar == null ? Z.a.d() : aVar;
    }

    private float f() {
        return this.f3041f.a(this.f3040e);
    }

    private static void j(ArrayList arrayList, Object obj) {
        int indexOf = arrayList.indexOf(obj);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    private static void k(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void s() {
        if (this.f3044i) {
            return;
        }
        this.f3044i = true;
        if (!this.f3039d) {
            this.f3038c = f();
        }
        float f3 = this.f3038c;
        if (f3 > this.f3045j || f3 < this.f3046k) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        e().a(this, 0L);
        this.f3036a.f(hashCode());
    }

    public b a(q qVar) {
        if (!this.f3049n.contains(qVar)) {
            this.f3049n.add(qVar);
        }
        return this;
    }

    public b b(r rVar) {
        if (h()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f3050o.contains(rVar)) {
            this.f3050o.add(rVar);
        }
        return this;
    }

    public void c() {
        if (!this.f3042g && Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f3044i) {
            d(true);
        }
    }

    @Override // Z.a.b
    public boolean doAnimationFrame(long j3) {
        long j4 = this.f3047l;
        if (j4 == 0) {
            this.f3047l = j3;
            n(this.f3038c);
            return false;
        }
        this.f3047l = j3;
        boolean t3 = t(j3 - j4);
        float min = Math.min(this.f3038c, this.f3045j);
        this.f3038c = min;
        float max = Math.max(min, this.f3046k);
        this.f3038c = max;
        n(max);
        this.f3036a.a(j3);
        if (t3) {
            d(false);
        }
        return t3;
    }

    float g() {
        return this.f3048m * 0.75f;
    }

    public boolean h() {
        return this.f3044i;
    }

    public void i(q qVar) {
        j(this.f3049n, qVar);
    }

    public void l(r rVar) {
        j(this.f3050o, rVar);
    }

    public b m(float f3) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f3048m = f3;
        q(f3 * 0.75f);
        return this;
    }

    void n(float f3) {
        this.f3041f.b(this.f3040e, f3);
        for (int i3 = 0; i3 < this.f3050o.size(); i3++) {
            if (this.f3050o.get(i3) != null) {
                ((r) this.f3050o.get(i3)).onAnimationUpdate(this, this.f3038c, this.f3037b);
            }
        }
        k(this.f3050o);
    }

    public b o(float f3) {
        this.f3038c = f3;
        this.f3039d = true;
        return this;
    }

    public b p(float f3) {
        this.f3037b = f3;
        return this;
    }

    abstract void q(float f3);

    public void r() {
        if (!this.f3042g && Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f3044i) {
            return;
        }
        s();
    }

    abstract boolean t(long j3);

    b(Object obj, B.c cVar) {
        Y.a aVar = new Y.a(null);
        this.f3036a = aVar;
        this.f3037b = 0.0f;
        this.f3038c = Float.MAX_VALUE;
        this.f3039d = false;
        this.f3042g = false;
        this.f3043h = null;
        this.f3044i = false;
        this.f3045j = Float.MAX_VALUE;
        this.f3046k = -Float.MAX_VALUE;
        this.f3047l = 0L;
        this.f3049n = new ArrayList();
        this.f3050o = new ArrayList();
        this.f3040e = obj;
        this.f3041f = cVar;
        if (cVar != f3030u && cVar != f3031v && cVar != f3032w) {
            if (cVar == f3022A) {
                this.f3048m = 0.00390625f;
            } else if (cVar != f3028s && cVar != f3029t) {
                this.f3048m = 1.0f;
            } else {
                this.f3048m = 0.00390625f;
            }
        } else {
            this.f3048m = 0.1f;
        }
        aVar.d();
    }
}
