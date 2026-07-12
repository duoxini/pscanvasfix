package U0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public float f2336a;

    /* renamed from: b, reason: collision with root package name */
    public float f2337b;

    /* renamed from: c, reason: collision with root package name */
    public float f2338c;

    /* renamed from: d, reason: collision with root package name */
    public float f2339d;

    /* renamed from: e, reason: collision with root package name */
    public float f2340e;

    /* renamed from: f, reason: collision with root package name */
    public float f2341f;

    /* renamed from: g, reason: collision with root package name */
    private final List f2342g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f2343h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f2344i;

    class a extends g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f2345b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f2346c;

        a(List list, Matrix matrix) {
            this.f2345b = list;
            this.f2346c = matrix;
        }

        @Override // U0.m.g
        public void b(Matrix matrix, T0.a aVar, int i3, Canvas canvas) {
            Iterator it = this.f2345b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(this.f2346c, aVar, i3, canvas);
            }
        }
    }

    static class b extends g {

        /* renamed from: b, reason: collision with root package name */
        private final d f2348b;

        public b(d dVar) {
            this.f2348b = dVar;
        }

        @Override // U0.m.g
        public void b(Matrix matrix, T0.a aVar, int i3, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f2348b.k(), this.f2348b.o(), this.f2348b.l(), this.f2348b.j()), i3, this.f2348b.m(), this.f2348b.n());
        }
    }

    static class c extends g {

        /* renamed from: b, reason: collision with root package name */
        private final e f2349b;

        /* renamed from: c, reason: collision with root package name */
        private final float f2350c;

        /* renamed from: d, reason: collision with root package name */
        private final float f2351d;

        public c(e eVar, float f3, float f4) {
            this.f2349b = eVar;
            this.f2350c = f3;
            this.f2351d = f4;
        }

        @Override // U0.m.g
        public void b(Matrix matrix, T0.a aVar, int i3, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f2349b.f2360c - this.f2351d, this.f2349b.f2359b - this.f2350c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f2350c, this.f2351d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i3);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f2349b.f2360c - this.f2351d) / (this.f2349b.f2359b - this.f2350c)));
        }
    }

    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        private static final RectF f2352h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public float f2353b;

        /* renamed from: c, reason: collision with root package name */
        public float f2354c;

        /* renamed from: d, reason: collision with root package name */
        public float f2355d;

        /* renamed from: e, reason: collision with root package name */
        public float f2356e;

        /* renamed from: f, reason: collision with root package name */
        public float f2357f;

        /* renamed from: g, reason: collision with root package name */
        public float f2358g;

        public d(float f3, float f4, float f5, float f6) {
            q(f3);
            u(f4);
            r(f5);
            p(f6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f2356e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f2353b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f2355d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f2357f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f2358g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f2354c;
        }

        private void p(float f3) {
            this.f2356e = f3;
        }

        private void q(float f3) {
            this.f2353b = f3;
        }

        private void r(float f3) {
            this.f2355d = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f3) {
            this.f2357f = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f3) {
            this.f2358g = f3;
        }

        private void u(float f3) {
            this.f2354c = f3;
        }

        @Override // U0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2361a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f2352h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f2359b;

        /* renamed from: c, reason: collision with root package name */
        private float f2360c;

        @Override // U0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2361a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f2359b, this.f2360c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected final Matrix f2361a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        static final Matrix f2362a = new Matrix();

        g() {
        }

        public final void a(T0.a aVar, int i3, Canvas canvas) {
            b(f2362a, aVar, i3, canvas);
        }

        public abstract void b(Matrix matrix, T0.a aVar, int i3, Canvas canvas);
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f3) {
        if (g() == f3) {
            return;
        }
        float g3 = ((f3 - g()) + 360.0f) % 360.0f;
        if (g3 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g3);
        this.f2343h.add(new b(dVar));
        p(f3);
    }

    private void c(g gVar, float f3, float f4) {
        b(f3);
        this.f2343h.add(gVar);
        p(f4);
    }

    private float g() {
        return this.f2340e;
    }

    private float h() {
        return this.f2341f;
    }

    private void p(float f3) {
        this.f2340e = f3;
    }

    private void q(float f3) {
        this.f2341f = f3;
    }

    private void r(float f3) {
        this.f2338c = f3;
    }

    private void s(float f3) {
        this.f2339d = f3;
    }

    private void t(float f3) {
        this.f2336a = f3;
    }

    private void u(float f3) {
        this.f2337b = f3;
    }

    public void a(float f3, float f4, float f5, float f6, float f7, float f8) {
        d dVar = new d(f3, f4, f5, f6);
        dVar.s(f7);
        dVar.t(f8);
        this.f2342g.add(dVar);
        b bVar = new b(dVar);
        float f9 = f7 + f8;
        boolean z3 = f8 < 0.0f;
        if (z3) {
            f7 = (f7 + 180.0f) % 360.0f;
        }
        c(bVar, f7, z3 ? (180.0f + f9) % 360.0f : f9);
        double d3 = f9;
        r(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.cos(Math.toRadians(d3)))));
        s(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.sin(Math.toRadians(d3)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f2342g.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f) this.f2342g.get(i3)).a(matrix, path);
        }
    }

    boolean e() {
        return this.f2344i;
    }

    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f2343h), new Matrix(matrix));
    }

    float i() {
        return this.f2338c;
    }

    float j() {
        return this.f2339d;
    }

    float k() {
        return this.f2336a;
    }

    float l() {
        return this.f2337b;
    }

    public void m(float f3, float f4) {
        e eVar = new e();
        eVar.f2359b = f3;
        eVar.f2360c = f4;
        this.f2342g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f3);
        s(f4);
    }

    public void n(float f3, float f4) {
        o(f3, f4, 270.0f, 0.0f);
    }

    public void o(float f3, float f4, float f5, float f6) {
        t(f3);
        u(f4);
        r(f3);
        s(f4);
        p(f5);
        q((f5 + f6) % 360.0f);
        this.f2342g.clear();
        this.f2343h.clear();
        this.f2344i = false;
    }
}
