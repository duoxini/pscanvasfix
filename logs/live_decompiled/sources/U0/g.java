package U0;

import U0.k;
import U0.l;
import U0.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* loaded from: classes.dex */
public class g extends Drawable implements n {

    /* renamed from: B, reason: collision with root package name */
    private static final String f2241B = "g";

    /* renamed from: C, reason: collision with root package name */
    private static final Paint f2242C;

    /* renamed from: A, reason: collision with root package name */
    private boolean f2243A;

    /* renamed from: e, reason: collision with root package name */
    private c f2244e;

    /* renamed from: f, reason: collision with root package name */
    private final m.g[] f2245f;

    /* renamed from: g, reason: collision with root package name */
    private final m.g[] f2246g;

    /* renamed from: h, reason: collision with root package name */
    private final BitSet f2247h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2248i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f2249j;

    /* renamed from: k, reason: collision with root package name */
    private final Path f2250k;

    /* renamed from: l, reason: collision with root package name */
    private final Path f2251l;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f2252m;

    /* renamed from: n, reason: collision with root package name */
    private final RectF f2253n;

    /* renamed from: o, reason: collision with root package name */
    private final Region f2254o;

    /* renamed from: p, reason: collision with root package name */
    private final Region f2255p;

    /* renamed from: q, reason: collision with root package name */
    private k f2256q;

    /* renamed from: r, reason: collision with root package name */
    private final Paint f2257r;

    /* renamed from: s, reason: collision with root package name */
    private final Paint f2258s;

    /* renamed from: t, reason: collision with root package name */
    private final T0.a f2259t;

    /* renamed from: u, reason: collision with root package name */
    private final l.b f2260u;

    /* renamed from: v, reason: collision with root package name */
    private final l f2261v;

    /* renamed from: w, reason: collision with root package name */
    private PorterDuffColorFilter f2262w;

    /* renamed from: x, reason: collision with root package name */
    private PorterDuffColorFilter f2263x;

    /* renamed from: y, reason: collision with root package name */
    private int f2264y;

    /* renamed from: z, reason: collision with root package name */
    private final RectF f2265z;

    class a implements l.b {
        a() {
        }

        @Override // U0.l.b
        public void a(m mVar, Matrix matrix, int i3) {
            g.this.f2247h.set(i3 + 4, mVar.e());
            g.this.f2246g[i3] = mVar.f(matrix);
        }

        @Override // U0.l.b
        public void b(m mVar, Matrix matrix, int i3) {
            g.this.f2247h.set(i3, mVar.e());
            g.this.f2245f[i3] = mVar.f(matrix);
        }
    }

    class b implements k.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f2267a;

        b(float f3) {
            this.f2267a = f3;
        }

        @Override // U0.k.c
        public U0.c a(U0.c cVar) {
            return cVar instanceof i ? cVar : new U0.b(this.f2267a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f2242C = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    private float C() {
        if (J()) {
            return this.f2258s.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean H() {
        c cVar = this.f2244e;
        int i3 = cVar.f2285q;
        return i3 != 1 && cVar.f2286r > 0 && (i3 == 2 || R());
    }

    private boolean I() {
        Paint.Style style = this.f2244e.f2290v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean J() {
        Paint.Style style = this.f2244e.f2290v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f2258s.getStrokeWidth() > 0.0f;
    }

    private void L() {
        super.invalidateSelf();
    }

    private void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (!this.f2243A) {
                m(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.f2265z.width() - getBounds().width());
            int height = (int) (this.f2265z.height() - getBounds().height());
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.f2265z.width()) + (this.f2244e.f2286r * 2) + width, ((int) this.f2265z.height()) + (this.f2244e.f2286r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f3 = (getBounds().left - this.f2244e.f2286r) - width;
            float f4 = (getBounds().top - this.f2244e.f2286r) - height;
            canvas2.translate(-f3, -f4);
            m(canvas2);
            canvas.drawBitmap(createBitmap, f3, f4, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int P(int i3, int i4) {
        return (i3 * (i4 + (i4 >>> 7))) >>> 8;
    }

    private void Q(Canvas canvas) {
        canvas.translate(z(), A());
    }

    private boolean d0(int[] iArr) {
        boolean z3;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f2244e.f2272d == null || color2 == (colorForState2 = this.f2244e.f2272d.getColorForState(iArr, (color2 = this.f2257r.getColor())))) {
            z3 = false;
        } else {
            this.f2257r.setColor(colorForState2);
            z3 = true;
        }
        if (this.f2244e.f2273e == null || color == (colorForState = this.f2244e.f2273e.getColorForState(iArr, (color = this.f2258s.getColor())))) {
            return z3;
        }
        this.f2258s.setColor(colorForState);
        return true;
    }

    private PorterDuffColorFilter e(Paint paint, boolean z3) {
        if (!z3) {
            return null;
        }
        int color = paint.getColor();
        int k3 = k(color);
        this.f2264y = k3;
        if (k3 != color) {
            return new PorterDuffColorFilter(k3, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private boolean e0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f2262w;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f2263x;
        c cVar = this.f2244e;
        this.f2262w = j(cVar.f2275g, cVar.f2276h, this.f2257r, true);
        c cVar2 = this.f2244e;
        this.f2263x = j(cVar2.f2274f, cVar2.f2276h, this.f2258s, false);
        c cVar3 = this.f2244e;
        if (cVar3.f2289u) {
            this.f2259t.d(cVar3.f2275g.getColorForState(getState(), 0));
        }
        return (androidx.core.util.c.a(porterDuffColorFilter, this.f2262w) && androidx.core.util.c.a(porterDuffColorFilter2, this.f2263x)) ? false : true;
    }

    private void f(RectF rectF, Path path) {
        g(rectF, path);
        if (this.f2244e.f2278j != 1.0f) {
            this.f2249j.reset();
            Matrix matrix = this.f2249j;
            float f3 = this.f2244e.f2278j;
            matrix.setScale(f3, f3, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f2249j);
        }
        path.computeBounds(this.f2265z, true);
    }

    private void f0() {
        float G3 = G();
        this.f2244e.f2286r = (int) Math.ceil(0.75f * G3);
        this.f2244e.f2287s = (int) Math.ceil(G3 * 0.25f);
        e0();
        L();
    }

    private void h() {
        k y3 = B().y(new b(-C()));
        this.f2256q = y3;
        this.f2261v.e(y3, this.f2244e.f2279k, u(), this.f2251l);
    }

    private PorterDuffColorFilter i(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z3) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z3) {
            colorForState = k(colorForState);
        }
        this.f2264y = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z3) {
        return (colorStateList == null || mode == null) ? e(paint, z3) : i(colorStateList, mode, z3);
    }

    public static g l(Context context, float f3) {
        int c3 = L0.a.c(context, H0.a.f482n, g.class.getSimpleName());
        g gVar = new g();
        gVar.K(context);
        gVar.U(ColorStateList.valueOf(c3));
        gVar.T(f3);
        return gVar;
    }

    private void m(Canvas canvas) {
        if (this.f2247h.cardinality() > 0) {
            Log.w(f2241B, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f2244e.f2287s != 0) {
            canvas.drawPath(this.f2250k, this.f2259t.c());
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.f2245f[i3].a(this.f2259t, this.f2244e.f2286r, canvas);
            this.f2246g[i3].a(this.f2259t, this.f2244e.f2286r, canvas);
        }
        if (this.f2243A) {
            int z3 = z();
            int A3 = A();
            canvas.translate(-z3, -A3);
            canvas.drawPath(this.f2250k, f2242C);
            canvas.translate(z3, A3);
        }
    }

    private void n(Canvas canvas) {
        o(canvas, this.f2257r, this.f2250k, this.f2244e.f2269a, t());
    }

    private void o(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a3 = kVar.t().a(rectF) * this.f2244e.f2279k;
            canvas.drawRoundRect(rectF, a3, a3, paint);
        }
    }

    private RectF u() {
        this.f2253n.set(t());
        float C3 = C();
        this.f2253n.inset(C3, C3);
        return this.f2253n;
    }

    public int A() {
        c cVar = this.f2244e;
        return (int) (cVar.f2287s * Math.cos(Math.toRadians(cVar.f2288t)));
    }

    public k B() {
        return this.f2244e.f2269a;
    }

    public float D() {
        return this.f2244e.f2269a.r().a(t());
    }

    public float E() {
        return this.f2244e.f2269a.t().a(t());
    }

    public float F() {
        return this.f2244e.f2284p;
    }

    public float G() {
        return v() + F();
    }

    public void K(Context context) {
        this.f2244e.f2270b = new O0.a(context);
        f0();
    }

    public boolean M() {
        O0.a aVar = this.f2244e.f2270b;
        return aVar != null && aVar.e();
    }

    public boolean N() {
        return this.f2244e.f2269a.u(t());
    }

    public boolean R() {
        if (N()) {
            return false;
        }
        this.f2250k.isConvex();
        return false;
    }

    public void S(U0.c cVar) {
        setShapeAppearanceModel(this.f2244e.f2269a.x(cVar));
    }

    public void T(float f3) {
        c cVar = this.f2244e;
        if (cVar.f2283o != f3) {
            cVar.f2283o = f3;
            f0();
        }
    }

    public void U(ColorStateList colorStateList) {
        c cVar = this.f2244e;
        if (cVar.f2272d != colorStateList) {
            cVar.f2272d = colorStateList;
            onStateChange(getState());
        }
    }

    public void V(float f3) {
        c cVar = this.f2244e;
        if (cVar.f2279k != f3) {
            cVar.f2279k = f3;
            this.f2248i = true;
            invalidateSelf();
        }
    }

    public void W(int i3, int i4, int i5, int i6) {
        c cVar = this.f2244e;
        if (cVar.f2277i == null) {
            cVar.f2277i = new Rect();
        }
        this.f2244e.f2277i.set(i3, i4, i5, i6);
        invalidateSelf();
    }

    public void X(float f3) {
        c cVar = this.f2244e;
        if (cVar.f2282n != f3) {
            cVar.f2282n = f3;
            f0();
        }
    }

    public void Y(int i3) {
        c cVar = this.f2244e;
        if (cVar.f2285q != i3) {
            cVar.f2285q = i3;
            L();
        }
    }

    public void Z(float f3, int i3) {
        c0(f3);
        b0(ColorStateList.valueOf(i3));
    }

    public void a0(float f3, ColorStateList colorStateList) {
        c0(f3);
        b0(colorStateList);
    }

    public void b0(ColorStateList colorStateList) {
        c cVar = this.f2244e;
        if (cVar.f2273e != colorStateList) {
            cVar.f2273e = colorStateList;
            onStateChange(getState());
        }
    }

    public void c0(float f3) {
        this.f2244e.f2280l = f3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2257r.setColorFilter(this.f2262w);
        int alpha = this.f2257r.getAlpha();
        this.f2257r.setAlpha(P(alpha, this.f2244e.f2281m));
        this.f2258s.setColorFilter(this.f2263x);
        this.f2258s.setStrokeWidth(this.f2244e.f2280l);
        int alpha2 = this.f2258s.getAlpha();
        this.f2258s.setAlpha(P(alpha2, this.f2244e.f2281m));
        if (this.f2248i) {
            h();
            f(t(), this.f2250k);
            this.f2248i = false;
        }
        O(canvas);
        if (I()) {
            n(canvas);
        }
        if (J()) {
            q(canvas);
        }
        this.f2257r.setAlpha(alpha);
        this.f2258s.setAlpha(alpha2);
    }

    protected final void g(RectF rectF, Path path) {
        l lVar = this.f2261v;
        c cVar = this.f2244e;
        lVar.d(cVar.f2269a, cVar.f2279k, rectF, this.f2260u, path);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2244e.f2281m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2244e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f2244e.f2285q == 2) {
            return;
        }
        if (N()) {
            outline.setRoundRect(getBounds(), D() * this.f2244e.f2279k);
        } else {
            f(t(), this.f2250k);
            this.f2250k.isConvex();
            try {
                outline.setConvexPath(this.f2250k);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f2244e.f2277i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f2254o.set(getBounds());
        f(t(), this.f2250k);
        this.f2255p.setPath(this.f2250k, this.f2254o);
        this.f2254o.op(this.f2255p, Region.Op.DIFFERENCE);
        return this.f2254o;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f2248i = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f2244e.f2275g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f2244e.f2274f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f2244e.f2273e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f2244e.f2272d) != null && colorStateList4.isStateful())));
    }

    protected int k(int i3) {
        float G3 = G() + x();
        O0.a aVar = this.f2244e.f2270b;
        return aVar != null ? aVar.c(i3, G3) : i3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f2244e = new c(this.f2244e);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f2248i = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z3 = d0(iArr) || e0();
        if (z3) {
            invalidateSelf();
        }
        return z3;
    }

    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        o(canvas, paint, path, this.f2244e.f2269a, rectF);
    }

    protected void q(Canvas canvas) {
        o(canvas, this.f2258s, this.f2251l, this.f2256q, u());
    }

    public float r() {
        return this.f2244e.f2269a.j().a(t());
    }

    public float s() {
        return this.f2244e.f2269a.l().a(t());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        c cVar = this.f2244e;
        if (cVar.f2281m != i3) {
            cVar.f2281m = i3;
            L();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2244e.f2271c = colorFilter;
        L();
    }

    @Override // U0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f2244e.f2269a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2244e.f2275g = colorStateList;
        e0();
        L();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f2244e;
        if (cVar.f2276h != mode) {
            cVar.f2276h = mode;
            e0();
            L();
        }
    }

    protected RectF t() {
        this.f2252m.set(getBounds());
        return this.f2252m;
    }

    public float v() {
        return this.f2244e.f2283o;
    }

    public ColorStateList w() {
        return this.f2244e.f2272d;
    }

    public float x() {
        return this.f2244e.f2282n;
    }

    public int y() {
        return this.f2264y;
    }

    public int z() {
        c cVar = this.f2244e;
        return (int) (cVar.f2287s * Math.sin(Math.toRadians(cVar.f2288t)));
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(k.e(context, attributeSet, i3, i4).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private g(c cVar) {
        l lVar;
        this.f2245f = new m.g[4];
        this.f2246g = new m.g[4];
        this.f2247h = new BitSet(8);
        this.f2249j = new Matrix();
        this.f2250k = new Path();
        this.f2251l = new Path();
        this.f2252m = new RectF();
        this.f2253n = new RectF();
        this.f2254o = new Region();
        this.f2255p = new Region();
        Paint paint = new Paint(1);
        this.f2257r = paint;
        Paint paint2 = new Paint(1);
        this.f2258s = paint2;
        this.f2259t = new T0.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f2261v = lVar;
        this.f2265z = new RectF();
        this.f2243A = true;
        this.f2244e = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        e0();
        d0(getState());
        this.f2260u = new a();
    }

    static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public k f2269a;

        /* renamed from: b, reason: collision with root package name */
        public O0.a f2270b;

        /* renamed from: c, reason: collision with root package name */
        public ColorFilter f2271c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f2272d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f2273e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f2274f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f2275g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f2276h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f2277i;

        /* renamed from: j, reason: collision with root package name */
        public float f2278j;

        /* renamed from: k, reason: collision with root package name */
        public float f2279k;

        /* renamed from: l, reason: collision with root package name */
        public float f2280l;

        /* renamed from: m, reason: collision with root package name */
        public int f2281m;

        /* renamed from: n, reason: collision with root package name */
        public float f2282n;

        /* renamed from: o, reason: collision with root package name */
        public float f2283o;

        /* renamed from: p, reason: collision with root package name */
        public float f2284p;

        /* renamed from: q, reason: collision with root package name */
        public int f2285q;

        /* renamed from: r, reason: collision with root package name */
        public int f2286r;

        /* renamed from: s, reason: collision with root package name */
        public int f2287s;

        /* renamed from: t, reason: collision with root package name */
        public int f2288t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f2289u;

        /* renamed from: v, reason: collision with root package name */
        public Paint.Style f2290v;

        public c(k kVar, O0.a aVar) {
            this.f2272d = null;
            this.f2273e = null;
            this.f2274f = null;
            this.f2275g = null;
            this.f2276h = PorterDuff.Mode.SRC_IN;
            this.f2277i = null;
            this.f2278j = 1.0f;
            this.f2279k = 1.0f;
            this.f2281m = 255;
            this.f2282n = 0.0f;
            this.f2283o = 0.0f;
            this.f2284p = 0.0f;
            this.f2285q = 0;
            this.f2286r = 0;
            this.f2287s = 0;
            this.f2288t = 0;
            this.f2289u = false;
            this.f2290v = Paint.Style.FILL_AND_STROKE;
            this.f2269a = kVar;
            this.f2270b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f2248i = true;
            return gVar;
        }

        public c(c cVar) {
            this.f2272d = null;
            this.f2273e = null;
            this.f2274f = null;
            this.f2275g = null;
            this.f2276h = PorterDuff.Mode.SRC_IN;
            this.f2277i = null;
            this.f2278j = 1.0f;
            this.f2279k = 1.0f;
            this.f2281m = 255;
            this.f2282n = 0.0f;
            this.f2283o = 0.0f;
            this.f2284p = 0.0f;
            this.f2285q = 0;
            this.f2286r = 0;
            this.f2287s = 0;
            this.f2288t = 0;
            this.f2289u = false;
            this.f2290v = Paint.Style.FILL_AND_STROKE;
            this.f2269a = cVar.f2269a;
            this.f2270b = cVar.f2270b;
            this.f2280l = cVar.f2280l;
            this.f2271c = cVar.f2271c;
            this.f2272d = cVar.f2272d;
            this.f2273e = cVar.f2273e;
            this.f2276h = cVar.f2276h;
            this.f2275g = cVar.f2275g;
            this.f2281m = cVar.f2281m;
            this.f2278j = cVar.f2278j;
            this.f2287s = cVar.f2287s;
            this.f2285q = cVar.f2285q;
            this.f2289u = cVar.f2289u;
            this.f2279k = cVar.f2279k;
            this.f2282n = cVar.f2282n;
            this.f2283o = cVar.f2283o;
            this.f2284p = cVar.f2284p;
            this.f2286r = cVar.f2286r;
            this.f2288t = cVar.f2288t;
            this.f2274f = cVar.f2274f;
            this.f2290v = cVar.f2290v;
            if (cVar.f2277i != null) {
                this.f2277i = new Rect(cVar.f2277i);
            }
        }
    }
}
