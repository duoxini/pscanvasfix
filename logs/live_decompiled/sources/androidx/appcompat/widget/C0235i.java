package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.L;
import e.AbstractC0339a;
import e.AbstractC0341c;
import f.AbstractC0348a;

/* renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0235i {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f4257b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static C0235i f4258c;

    /* renamed from: a, reason: collision with root package name */
    private L f4259a;

    /* renamed from: androidx.appcompat.widget.i$a */
    class a implements L.c {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f4260a = {e.e.f11147R, e.e.f11145P, e.e.f11149a};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f4261b = {e.e.f11163o, e.e.f11131B, e.e.f11168t, e.e.f11164p, e.e.f11165q, e.e.f11167s, e.e.f11166r};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f4262c = {e.e.f11144O, e.e.f11146Q, e.e.f11159k, e.e.f11140K, e.e.f11141L, e.e.f11142M, e.e.f11143N};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f4263d = {e.e.f11171w, e.e.f11157i, e.e.f11170v};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f4264e = {e.e.f11139J, e.e.f11148S};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f4265f = {e.e.f11151c, e.e.f11155g, e.e.f11152d, e.e.f11156h};

        a() {
        }

        private boolean f(int[] iArr, int i3) {
            for (int i4 : iArr) {
                if (i4 == i3) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i3) {
            int c3 = Q.c(context, AbstractC0339a.f11105t);
            return new ColorStateList(new int[][]{Q.f4010b, Q.f4013e, Q.f4011c, Q.f4017i}, new int[]{Q.b(context, AbstractC0339a.f11103r), androidx.core.graphics.a.i(c3, i3), androidx.core.graphics.a.i(c3, i3), i3});
        }

        private ColorStateList i(Context context) {
            return h(context, Q.c(context, AbstractC0339a.f11102q));
        }

        private ColorStateList j(Context context) {
            return h(context, Q.c(context, AbstractC0339a.f11103r));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList e3 = Q.e(context, AbstractC0339a.f11107v);
            if (e3 == null || !e3.isStateful()) {
                iArr[0] = Q.f4010b;
                iArr2[0] = Q.b(context, AbstractC0339a.f11107v);
                iArr[1] = Q.f4014f;
                iArr2[1] = Q.c(context, AbstractC0339a.f11104s);
                iArr[2] = Q.f4017i;
                iArr2[2] = Q.c(context, AbstractC0339a.f11107v);
            } else {
                int[] iArr3 = Q.f4010b;
                iArr[0] = iArr3;
                iArr2[0] = e3.getColorForState(iArr3, 0);
                iArr[1] = Q.f4014f;
                iArr2[1] = Q.c(context, AbstractC0339a.f11104s);
                iArr[2] = Q.f4017i;
                iArr2[2] = e3.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(L l3, Context context, int i3) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
            Drawable i4 = l3.i(context, e.e.f11135F);
            Drawable i5 = l3.i(context, e.e.f11136G);
            if ((i4 instanceof BitmapDrawable) && i4.getIntrinsicWidth() == dimensionPixelSize && i4.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) i4;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                i4.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i4.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((i5 instanceof BitmapDrawable) && i5.getIntrinsicWidth() == dimensionPixelSize && i5.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) i5;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                i5.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i5.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i3, PorterDuff.Mode mode) {
            if (E.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C0235i.f4257b;
            }
            drawable.setColorFilter(C0235i.e(i3, mode));
        }

        @Override // androidx.appcompat.widget.L.c
        public Drawable a(L l3, Context context, int i3) {
            if (i3 == e.e.f11158j) {
                return new LayerDrawable(new Drawable[]{l3.i(context, e.e.f11157i), l3.i(context, e.e.f11159k)});
            }
            if (i3 == e.e.f11173y) {
                return l(l3, context, e.d.f11127g);
            }
            if (i3 == e.e.f11172x) {
                return l(l3, context, e.d.f11128h);
            }
            if (i3 == e.e.f11174z) {
                return l(l3, context, e.d.f11129i);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
        @Override // androidx.appcompat.widget.L.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0235i.a()
                int[] r1 = r6.f4260a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L14
                int r6 = e.AbstractC0339a.f11106u
            L11:
                r1 = r2
            L12:
                r8 = r4
                goto L49
            L14:
                int[] r1 = r6.f4262c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L1f
                int r6 = e.AbstractC0339a.f11104s
                goto L11
            L1f:
                int[] r1 = r6.f4263d
                boolean r6 = r6.f(r1, r8)
                r1 = 16842801(0x1010031, float:2.3693695E-38)
                if (r6 == 0) goto L2e
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2c:
                r6 = r1
                goto L11
            L2e:
                int r6 = e.e.f11169u
                if (r8 != r6) goto L41
                r6 = 1109603123(0x42233333, float:40.8)
                int r6 = java.lang.Math.round(r6)
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r2
                r5 = r8
                r8 = r6
                r6 = r5
                goto L49
            L41:
                int r6 = e.e.f11160l
                if (r8 != r6) goto L46
                goto L2c
            L46:
                r6 = r3
                r1 = r6
                goto L12
            L49:
                if (r1 == 0) goto L66
                boolean r1 = androidx.appcompat.widget.E.a(r9)
                if (r1 == 0) goto L55
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L55:
                int r6 = androidx.appcompat.widget.Q.c(r7, r6)
                android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.C0235i.e(r6, r0)
                r9.setColorFilter(r6)
                if (r8 == r4) goto L65
                r9.setAlpha(r8)
            L65:
                return r2
            L66:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0235i.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.L.c
        public ColorStateList c(Context context, int i3) {
            if (i3 == e.e.f11161m) {
                return AbstractC0348a.a(context, AbstractC0341c.f11117e);
            }
            if (i3 == e.e.f11138I) {
                return AbstractC0348a.a(context, AbstractC0341c.f11120h);
            }
            if (i3 == e.e.f11137H) {
                return k(context);
            }
            if (i3 == e.e.f11154f) {
                return j(context);
            }
            if (i3 == e.e.f11150b) {
                return g(context);
            }
            if (i3 == e.e.f11153e) {
                return i(context);
            }
            if (i3 == e.e.f11133D || i3 == e.e.f11134E) {
                return AbstractC0348a.a(context, AbstractC0341c.f11119g);
            }
            if (f(this.f4261b, i3)) {
                return Q.e(context, AbstractC0339a.f11106u);
            }
            if (f(this.f4264e, i3)) {
                return AbstractC0348a.a(context, AbstractC0341c.f11116d);
            }
            if (f(this.f4265f, i3)) {
                return AbstractC0348a.a(context, AbstractC0341c.f11115c);
            }
            if (i3 == e.e.f11130A) {
                return AbstractC0348a.a(context, AbstractC0341c.f11118f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.L.c
        public boolean d(Context context, int i3, Drawable drawable) {
            if (i3 == e.e.f11132C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), Q.c(context, AbstractC0339a.f11106u), C0235i.f4257b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), Q.c(context, AbstractC0339a.f11106u), C0235i.f4257b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), Q.c(context, AbstractC0339a.f11104s), C0235i.f4257b);
                return true;
            }
            if (i3 != e.e.f11173y && i3 != e.e.f11172x && i3 != e.e.f11174z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), Q.b(context, AbstractC0339a.f11106u), C0235i.f4257b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), Q.c(context, AbstractC0339a.f11104s), C0235i.f4257b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), Q.c(context, AbstractC0339a.f11104s), C0235i.f4257b);
            return true;
        }

        @Override // androidx.appcompat.widget.L.c
        public PorterDuff.Mode e(int i3) {
            if (i3 == e.e.f11137H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized C0235i b() {
        C0235i c0235i;
        synchronized (C0235i.class) {
            try {
                if (f4258c == null) {
                    h();
                }
                c0235i = f4258c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0235i;
    }

    public static synchronized PorterDuffColorFilter e(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter k3;
        synchronized (C0235i.class) {
            k3 = L.k(i3, mode);
        }
        return k3;
    }

    public static synchronized void h() {
        synchronized (C0235i.class) {
            if (f4258c == null) {
                C0235i c0235i = new C0235i();
                f4258c = c0235i;
                c0235i.f4259a = L.g();
                f4258c.f4259a.t(new a());
            }
        }
    }

    static void i(Drawable drawable, T t3, int[] iArr) {
        L.v(drawable, t3, iArr);
    }

    public synchronized Drawable c(Context context, int i3) {
        return this.f4259a.i(context, i3);
    }

    synchronized Drawable d(Context context, int i3, boolean z3) {
        return this.f4259a.j(context, i3, z3);
    }

    synchronized ColorStateList f(Context context, int i3) {
        return this.f4259a.l(context, i3);
    }

    public synchronized void g(Context context) {
        this.f4259a.r(context);
    }
}
