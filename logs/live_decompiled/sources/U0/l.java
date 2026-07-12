package U0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final m[] f2318a = new m[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f2319b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f2320c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f2321d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f2322e = new Path();

    /* renamed from: f, reason: collision with root package name */
    private final Path f2323f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final m f2324g = new m();

    /* renamed from: h, reason: collision with root package name */
    private final float[] f2325h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private final float[] f2326i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private final Path f2327j = new Path();

    /* renamed from: k, reason: collision with root package name */
    private final Path f2328k = new Path();

    /* renamed from: l, reason: collision with root package name */
    private boolean f2329l = true;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final l f2330a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i3);

        void b(m mVar, Matrix matrix, int i3);
    }

    static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final k f2331a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f2332b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f2333c;

        /* renamed from: d, reason: collision with root package name */
        public final b f2334d;

        /* renamed from: e, reason: collision with root package name */
        public final float f2335e;

        c(k kVar, float f3, RectF rectF, b bVar, Path path) {
            this.f2334d = bVar;
            this.f2331a = kVar;
            this.f2335e = f3;
            this.f2333c = rectF;
            this.f2332b = path;
        }
    }

    public l() {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f2318a[i3] = new m();
            this.f2319b[i3] = new Matrix();
            this.f2320c[i3] = new Matrix();
        }
    }

    private float a(int i3) {
        return (i3 + 1) * 90;
    }

    private void b(c cVar, int i3) {
        this.f2325h[0] = this.f2318a[i3].k();
        this.f2325h[1] = this.f2318a[i3].l();
        this.f2319b[i3].mapPoints(this.f2325h);
        if (i3 == 0) {
            Path path = cVar.f2332b;
            float[] fArr = this.f2325h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f2332b;
            float[] fArr2 = this.f2325h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f2318a[i3].d(this.f2319b[i3], cVar.f2332b);
        b bVar = cVar.f2334d;
        if (bVar != null) {
            bVar.b(this.f2318a[i3], this.f2319b[i3], i3);
        }
    }

    private void c(c cVar, int i3) {
        int i4 = (i3 + 1) % 4;
        this.f2325h[0] = this.f2318a[i3].i();
        this.f2325h[1] = this.f2318a[i3].j();
        this.f2319b[i3].mapPoints(this.f2325h);
        this.f2326i[0] = this.f2318a[i4].k();
        this.f2326i[1] = this.f2318a[i4].l();
        this.f2319b[i4].mapPoints(this.f2326i);
        float f3 = this.f2325h[0];
        float[] fArr = this.f2326i;
        float max = Math.max(((float) Math.hypot(f3 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i5 = i(cVar.f2333c, i3);
        this.f2324g.n(0.0f, 0.0f);
        f j3 = j(i3, cVar.f2331a);
        j3.b(max, i5, cVar.f2335e, this.f2324g);
        this.f2327j.reset();
        this.f2324g.d(this.f2320c[i3], this.f2327j);
        if (this.f2329l && (j3.a() || l(this.f2327j, i3) || l(this.f2327j, i4))) {
            Path path = this.f2327j;
            path.op(path, this.f2323f, Path.Op.DIFFERENCE);
            this.f2325h[0] = this.f2324g.k();
            this.f2325h[1] = this.f2324g.l();
            this.f2320c[i3].mapPoints(this.f2325h);
            Path path2 = this.f2322e;
            float[] fArr2 = this.f2325h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f2324g.d(this.f2320c[i3], this.f2322e);
        } else {
            this.f2324g.d(this.f2320c[i3], cVar.f2332b);
        }
        b bVar = cVar.f2334d;
        if (bVar != null) {
            bVar.a(this.f2324g, this.f2320c[i3], i3);
        }
    }

    private void f(int i3, RectF rectF, PointF pointF) {
        if (i3 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i3 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i3 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private U0.c g(int i3, k kVar) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    private d h(int i3, k kVar) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    private float i(RectF rectF, int i3) {
        float[] fArr = this.f2325h;
        m mVar = this.f2318a[i3];
        fArr[0] = mVar.f2338c;
        fArr[1] = mVar.f2339d;
        this.f2319b[i3].mapPoints(fArr);
        return (i3 == 1 || i3 == 3) ? Math.abs(rectF.centerX() - this.f2325h[0]) : Math.abs(rectF.centerY() - this.f2325h[1]);
    }

    private f j(int i3, k kVar) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    public static l k() {
        return a.f2330a;
    }

    private boolean l(Path path, int i3) {
        this.f2328k.reset();
        this.f2318a[i3].d(this.f2319b[i3], this.f2328k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f2328k.computeBounds(rectF, true);
        path.op(this.f2328k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i3) {
        h(i3, cVar.f2331a).b(this.f2318a[i3], 90.0f, cVar.f2335e, cVar.f2333c, g(i3, cVar.f2331a));
        float a3 = a(i3);
        this.f2319b[i3].reset();
        f(i3, cVar.f2333c, this.f2321d);
        Matrix matrix = this.f2319b[i3];
        PointF pointF = this.f2321d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f2319b[i3].preRotate(a3);
    }

    private void n(int i3) {
        this.f2325h[0] = this.f2318a[i3].i();
        this.f2325h[1] = this.f2318a[i3].j();
        this.f2319b[i3].mapPoints(this.f2325h);
        float a3 = a(i3);
        this.f2320c[i3].reset();
        Matrix matrix = this.f2320c[i3];
        float[] fArr = this.f2325h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f2320c[i3].preRotate(a3);
    }

    public void d(k kVar, float f3, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f2322e.rewind();
        this.f2323f.rewind();
        this.f2323f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f3, rectF, bVar, path);
        for (int i3 = 0; i3 < 4; i3++) {
            m(cVar, i3);
            n(i3);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            b(cVar, i4);
            c(cVar, i4);
        }
        path.close();
        this.f2322e.close();
        if (this.f2322e.isEmpty()) {
            return;
        }
        path.op(this.f2322e, Path.Op.UNION);
    }

    public void e(k kVar, float f3, RectF rectF, Path path) {
        d(kVar, f3, rectF, null, path);
    }
}
