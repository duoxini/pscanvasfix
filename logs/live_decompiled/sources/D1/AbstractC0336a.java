package d1;

import a1.v;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import n1.C0483b;

/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0336a {

    /* renamed from: c, reason: collision with root package name */
    private final d f11010c;

    /* renamed from: e, reason: collision with root package name */
    protected C0483b f11012e;

    /* renamed from: a, reason: collision with root package name */
    final List f11008a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private boolean f11009b = false;

    /* renamed from: d, reason: collision with root package name */
    protected float f11011d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private Object f11013f = null;

    /* renamed from: g, reason: collision with root package name */
    private float f11014g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f11015h = -1.0f;

    /* renamed from: d1.a$b */
    public interface b {
        void e();
    }

    /* renamed from: d1.a$c */
    private static final class c implements d {
        private c() {
        }

        @Override // d1.AbstractC0336a.d
        public float a() {
            return 1.0f;
        }

        @Override // d1.AbstractC0336a.d
        public boolean b(float f3) {
            throw new IllegalStateException("not implemented");
        }

        @Override // d1.AbstractC0336a.d
        public float c() {
            return 0.0f;
        }

        @Override // d1.AbstractC0336a.d
        public n1.c d() {
            throw new IllegalStateException("not implemented");
        }

        @Override // d1.AbstractC0336a.d
        public boolean e(float f3) {
            return false;
        }

        @Override // d1.AbstractC0336a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* renamed from: d1.a$d */
    private interface d {
        float a();

        boolean b(float f3);

        float c();

        n1.c d();

        boolean e(float f3);

        boolean isEmpty();
    }

    /* renamed from: d1.a$e */
    private static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private final List f11016a;

        /* renamed from: c, reason: collision with root package name */
        private n1.c f11018c = null;

        /* renamed from: d, reason: collision with root package name */
        private float f11019d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        private n1.c f11017b = f(0.0f);

        e(List list) {
            this.f11016a = list;
        }

        private n1.c f(float f3) {
            List list = this.f11016a;
            n1.c cVar = (n1.c) list.get(list.size() - 1);
            if (f3 >= cVar.f()) {
                return cVar;
            }
            for (int size = this.f11016a.size() - 2; size >= 1; size--) {
                n1.c cVar2 = (n1.c) this.f11016a.get(size);
                if (this.f11017b != cVar2 && cVar2.a(f3)) {
                    return cVar2;
                }
            }
            return (n1.c) this.f11016a.get(0);
        }

        @Override // d1.AbstractC0336a.d
        public float a() {
            return ((n1.c) this.f11016a.get(r1.size() - 1)).c();
        }

        @Override // d1.AbstractC0336a.d
        public boolean b(float f3) {
            n1.c cVar = this.f11018c;
            n1.c cVar2 = this.f11017b;
            if (cVar == cVar2 && this.f11019d == f3) {
                return true;
            }
            this.f11018c = cVar2;
            this.f11019d = f3;
            return false;
        }

        @Override // d1.AbstractC0336a.d
        public float c() {
            return ((n1.c) this.f11016a.get(0)).f();
        }

        @Override // d1.AbstractC0336a.d
        public n1.c d() {
            return this.f11017b;
        }

        @Override // d1.AbstractC0336a.d
        public boolean e(float f3) {
            if (this.f11017b.a(f3)) {
                return !this.f11017b.i();
            }
            this.f11017b = f(f3);
            return true;
        }

        @Override // d1.AbstractC0336a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* renamed from: d1.a$f */
    private static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        private final n1.c f11020a;

        /* renamed from: b, reason: collision with root package name */
        private float f11021b = -1.0f;

        f(List list) {
            this.f11020a = (n1.c) list.get(0);
        }

        @Override // d1.AbstractC0336a.d
        public float a() {
            return this.f11020a.c();
        }

        @Override // d1.AbstractC0336a.d
        public boolean b(float f3) {
            if (this.f11021b == f3) {
                return true;
            }
            this.f11021b = f3;
            return false;
        }

        @Override // d1.AbstractC0336a.d
        public float c() {
            return this.f11020a.f();
        }

        @Override // d1.AbstractC0336a.d
        public n1.c d() {
            return this.f11020a;
        }

        @Override // d1.AbstractC0336a.d
        public boolean e(float f3) {
            return !this.f11020a.i();
        }

        @Override // d1.AbstractC0336a.d
        public boolean isEmpty() {
            return false;
        }
    }

    AbstractC0336a(List list) {
        this.f11010c = o(list);
    }

    private float g() {
        if (this.f11014g == -1.0f) {
            this.f11014g = this.f11010c.c();
        }
        return this.f11014g;
    }

    private static d o(List list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f11008a.add(bVar);
    }

    protected n1.c b() {
        v.a("BaseKeyframeAnimation#getCurrentKeyframe");
        n1.c d3 = this.f11010c.d();
        v.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return d3;
    }

    float c() {
        if (this.f11015h == -1.0f) {
            this.f11015h = this.f11010c.a();
        }
        return this.f11015h;
    }

    protected float d() {
        n1.c b3 = b();
        if (b3 == null || b3.i()) {
            return 0.0f;
        }
        return b3.f12576d.getInterpolation(e());
    }

    float e() {
        if (this.f11009b) {
            return 0.0f;
        }
        n1.c b3 = b();
        if (b3.i()) {
            return 0.0f;
        }
        return (this.f11011d - b3.f()) / (b3.c() - b3.f());
    }

    public float f() {
        return this.f11011d;
    }

    public Object h() {
        float e3 = e();
        if (this.f11012e == null && this.f11010c.b(e3)) {
            return this.f11013f;
        }
        n1.c b3 = b();
        Interpolator interpolator = b3.f12577e;
        Object i3 = (interpolator == null || b3.f12578f == null) ? i(b3, d()) : j(b3, e3, interpolator.getInterpolation(e3), b3.f12578f.getInterpolation(e3));
        this.f11013f = i3;
        return i3;
    }

    abstract Object i(n1.c cVar, float f3);

    protected Object j(n1.c cVar, float f3, float f4, float f5) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i3 = 0; i3 < this.f11008a.size(); i3++) {
            ((b) this.f11008a.get(i3)).e();
        }
    }

    public void l() {
        this.f11009b = true;
    }

    public void m(float f3) {
        if (this.f11010c.isEmpty()) {
            return;
        }
        if (f3 < g()) {
            f3 = g();
        } else if (f3 > c()) {
            f3 = c();
        }
        if (f3 == this.f11011d) {
            return;
        }
        this.f11011d = f3;
        if (this.f11010c.e(f3)) {
            k();
        }
    }

    public void n(C0483b c0483b) {
        C0483b c0483b2 = this.f11012e;
        if (c0483b2 != null) {
            c0483b2.c(null);
        }
        this.f11012e = c0483b;
        if (c0483b != null) {
            c0483b.c(this);
        }
    }
}
