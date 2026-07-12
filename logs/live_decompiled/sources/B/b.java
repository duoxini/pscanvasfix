package B;

import B.a;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements a.b {

    /* renamed from: m, reason: collision with root package name */
    public static final s f101m = new g("translationX");

    /* renamed from: n, reason: collision with root package name */
    public static final s f102n = new h("translationY");

    /* renamed from: o, reason: collision with root package name */
    public static final s f103o = new i("translationZ");

    /* renamed from: p, reason: collision with root package name */
    public static final s f104p = new j("scaleX");

    /* renamed from: q, reason: collision with root package name */
    public static final s f105q = new k("scaleY");

    /* renamed from: r, reason: collision with root package name */
    public static final s f106r = new l("rotation");

    /* renamed from: s, reason: collision with root package name */
    public static final s f107s = new m("rotationX");

    /* renamed from: t, reason: collision with root package name */
    public static final s f108t = new n("rotationY");

    /* renamed from: u, reason: collision with root package name */
    public static final s f109u = new o("x");

    /* renamed from: v, reason: collision with root package name */
    public static final s f110v = new a("y");

    /* renamed from: w, reason: collision with root package name */
    public static final s f111w = new C0006b("z");

    /* renamed from: x, reason: collision with root package name */
    public static final s f112x = new c("alpha");

    /* renamed from: y, reason: collision with root package name */
    public static final s f113y = new d("scrollX");

    /* renamed from: z, reason: collision with root package name */
    public static final s f114z = new e("scrollY");

    /* renamed from: a, reason: collision with root package name */
    float f115a;

    /* renamed from: b, reason: collision with root package name */
    float f116b;

    /* renamed from: c, reason: collision with root package name */
    boolean f117c;

    /* renamed from: d, reason: collision with root package name */
    final Object f118d;

    /* renamed from: e, reason: collision with root package name */
    final B.c f119e;

    /* renamed from: f, reason: collision with root package name */
    boolean f120f;

    /* renamed from: g, reason: collision with root package name */
    float f121g;

    /* renamed from: h, reason: collision with root package name */
    float f122h;

    /* renamed from: i, reason: collision with root package name */
    private long f123i;

    /* renamed from: j, reason: collision with root package name */
    private float f124j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f125k;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList f126l;

    static class a extends s {
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

    /* renamed from: B.b$b, reason: collision with other inner class name */
    static class C0006b extends s {
        C0006b(String str) {
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

    static class c extends s {
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

    static class d extends s {
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

    static class e extends s {
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
        final /* synthetic */ B.d f127b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, B.d dVar) {
            super(str);
            this.f127b = dVar;
        }

        @Override // B.c
        public float a(Object obj) {
            return this.f127b.a();
        }

        @Override // B.c
        public void b(Object obj, float f3) {
            this.f127b.b(f3);
        }
    }

    static class g extends s {
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

    static class h extends s {
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

    static class i extends s {
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

    static class j extends s {
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

    static class k extends s {
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

    static class l extends s {
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

    static class m extends s {
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

    static class n extends s {
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

    static class o extends s {
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
        float f129a;

        /* renamed from: b, reason: collision with root package name */
        float f130b;

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
        this.f115a = 0.0f;
        this.f116b = Float.MAX_VALUE;
        this.f117c = false;
        this.f120f = false;
        this.f121g = Float.MAX_VALUE;
        this.f122h = -Float.MAX_VALUE;
        this.f123i = 0L;
        this.f125k = new ArrayList();
        this.f126l = new ArrayList();
        this.f118d = null;
        this.f119e = new f("FloatValueHolder", dVar);
        this.f124j = 1.0f;
    }

    private void d(boolean z3) {
        this.f120f = false;
        B.a.d().g(this);
        this.f123i = 0L;
        this.f117c = false;
        for (int i3 = 0; i3 < this.f125k.size(); i3++) {
            if (this.f125k.get(i3) != null) {
                ((q) this.f125k.get(i3)).onAnimationEnd(this, z3, this.f116b, this.f115a);
            }
        }
        h(this.f125k);
    }

    private float e() {
        return this.f119e.a(this.f118d);
    }

    private static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void n() {
        if (this.f120f) {
            return;
        }
        this.f120f = true;
        if (!this.f117c) {
            this.f116b = e();
        }
        float f3 = this.f116b;
        if (f3 > this.f121g || f3 < this.f122h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        B.a.d().a(this, 0L);
    }

    public b a(q qVar) {
        if (!this.f125k.contains(qVar)) {
            this.f125k.add(qVar);
        }
        return this;
    }

    public b b(r rVar) {
        if (g()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f126l.contains(rVar)) {
            this.f126l.add(rVar);
        }
        return this;
    }

    public void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f120f) {
            d(true);
        }
    }

    @Override // B.a.b
    public boolean doAnimationFrame(long j3) {
        long j4 = this.f123i;
        if (j4 == 0) {
            this.f123i = j3;
            j(this.f116b);
            return false;
        }
        this.f123i = j3;
        boolean o3 = o(j3 - j4);
        float min = Math.min(this.f116b, this.f121g);
        this.f116b = min;
        float max = Math.max(min, this.f122h);
        this.f116b = max;
        j(max);
        if (o3) {
            d(false);
        }
        return o3;
    }

    float f() {
        return this.f124j * 0.75f;
    }

    public boolean g() {
        return this.f120f;
    }

    public b i(float f3) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f124j = f3;
        l(f3 * 0.75f);
        return this;
    }

    void j(float f3) {
        this.f119e.b(this.f118d, f3);
        for (int i3 = 0; i3 < this.f126l.size(); i3++) {
            if (this.f126l.get(i3) != null) {
                ((r) this.f126l.get(i3)).onAnimationUpdate(this, this.f116b, this.f115a);
            }
        }
        h(this.f126l);
    }

    public b k(float f3) {
        this.f116b = f3;
        this.f117c = true;
        return this;
    }

    abstract void l(float f3);

    public void m() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f120f) {
            return;
        }
        n();
    }

    abstract boolean o(long j3);

    b(Object obj, B.c cVar) {
        this.f115a = 0.0f;
        this.f116b = Float.MAX_VALUE;
        this.f117c = false;
        this.f120f = false;
        this.f121g = Float.MAX_VALUE;
        this.f122h = -Float.MAX_VALUE;
        this.f123i = 0L;
        this.f125k = new ArrayList();
        this.f126l = new ArrayList();
        this.f118d = obj;
        this.f119e = cVar;
        if (cVar != f106r && cVar != f107s && cVar != f108t) {
            if (cVar == f112x) {
                this.f124j = 0.00390625f;
                return;
            } else if (cVar != f104p && cVar != f105q) {
                this.f124j = 1.0f;
                return;
            } else {
                this.f124j = 0.00390625f;
                return;
            }
        }
        this.f124j = 0.1f;
    }
}
