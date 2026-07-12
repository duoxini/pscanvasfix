package R0;

import H0.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.f;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f2028a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f2029b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f2030c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2031d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2032e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2033f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2034g;

    /* renamed from: h, reason: collision with root package name */
    public final float f2035h;

    /* renamed from: i, reason: collision with root package name */
    public final float f2036i;

    /* renamed from: j, reason: collision with root package name */
    public final float f2037j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f2038k;

    /* renamed from: l, reason: collision with root package name */
    public final float f2039l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f2040m;

    /* renamed from: n, reason: collision with root package name */
    private float f2041n;

    /* renamed from: o, reason: collision with root package name */
    private final int f2042o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2043p = false;

    /* renamed from: q, reason: collision with root package name */
    private Typeface f2044q;

    class a extends f.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f2045a;

        a(f fVar) {
            this.f2045a = fVar;
        }

        @Override // androidx.core.content.res.f.e
        /* renamed from: h */
        public void f(int i3) {
            d.this.f2043p = true;
            this.f2045a.onFontRetrievalFailed(i3);
        }

        @Override // androidx.core.content.res.f.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            d dVar = d.this;
            dVar.f2044q = Typeface.create(typeface, dVar.f2032e);
            d.this.f2043p = true;
            this.f2045a.onFontRetrieved(d.this.f2044q, false);
        }
    }

    class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2047a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f2048b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f2049c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f2047a = context;
            this.f2048b = textPaint;
            this.f2049c = fVar;
        }

        @Override // R0.f
        public void onFontRetrievalFailed(int i3) {
            this.f2049c.onFontRetrievalFailed(i3);
        }

        @Override // R0.f
        public void onFontRetrieved(Typeface typeface, boolean z3) {
            d.this.p(this.f2047a, this.f2048b, typeface);
            this.f2049c.onFontRetrieved(typeface, z3);
        }
    }

    public d(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, j.m5);
        l(obtainStyledAttributes.getDimension(j.n5, 0.0f));
        k(c.a(context, obtainStyledAttributes, j.q5));
        this.f2028a = c.a(context, obtainStyledAttributes, j.r5);
        this.f2029b = c.a(context, obtainStyledAttributes, j.s5);
        this.f2032e = obtainStyledAttributes.getInt(j.p5, 0);
        this.f2033f = obtainStyledAttributes.getInt(j.o5, 1);
        int e3 = c.e(obtainStyledAttributes, j.y5, j.x5);
        this.f2042o = obtainStyledAttributes.getResourceId(e3, 0);
        this.f2031d = obtainStyledAttributes.getString(e3);
        this.f2034g = obtainStyledAttributes.getBoolean(j.z5, false);
        this.f2030c = c.a(context, obtainStyledAttributes, j.t5);
        this.f2035h = obtainStyledAttributes.getFloat(j.u5, 0.0f);
        this.f2036i = obtainStyledAttributes.getFloat(j.v5, 0.0f);
        this.f2037j = obtainStyledAttributes.getFloat(j.w5, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i3, j.P3);
        this.f2038k = obtainStyledAttributes2.hasValue(j.Q3);
        this.f2039l = obtainStyledAttributes2.getFloat(j.Q3, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f2044q == null && (str = this.f2031d) != null) {
            this.f2044q = Typeface.create(str, this.f2032e);
        }
        if (this.f2044q == null) {
            int i3 = this.f2033f;
            if (i3 == 1) {
                this.f2044q = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                this.f2044q = Typeface.SERIF;
            } else if (i3 != 3) {
                this.f2044q = Typeface.DEFAULT;
            } else {
                this.f2044q = Typeface.MONOSPACE;
            }
            this.f2044q = Typeface.create(this.f2044q, this.f2032e);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i3 = this.f2042o;
        return (i3 != 0 ? androidx.core.content.res.f.c(context, i3) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f2044q;
    }

    public Typeface f(Context context) {
        if (this.f2043p) {
            return this.f2044q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h3 = androidx.core.content.res.f.h(context, this.f2042o);
                this.f2044q = h3;
                if (h3 != null) {
                    this.f2044q = Typeface.create(h3, this.f2032e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.f2031d, e3);
            }
        }
        d();
        this.f2043p = true;
        return this.f2044q;
    }

    public void g(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i3 = this.f2042o;
        if (i3 == 0) {
            this.f2043p = true;
        }
        if (this.f2043p) {
            fVar.onFontRetrieved(this.f2044q, true);
            return;
        }
        try {
            androidx.core.content.res.f.j(context, i3, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f2043p = true;
            fVar.onFontRetrievalFailed(1);
        } catch (Exception e3) {
            Log.d("TextAppearance", "Error loading font " + this.f2031d, e3);
            this.f2043p = true;
            fVar.onFontRetrievalFailed(-3);
        }
    }

    public void h(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        g(context, new b(context, textPaint, fVar));
    }

    public ColorStateList i() {
        return this.f2040m;
    }

    public float j() {
        return this.f2041n;
    }

    public void k(ColorStateList colorStateList) {
        this.f2040m = colorStateList;
    }

    public void l(float f3) {
        this.f2041n = f3;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f2040m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f3 = this.f2037j;
        float f4 = this.f2035h;
        float f5 = this.f2036i;
        ColorStateList colorStateList2 = this.f2030c;
        textPaint.setShadowLayer(f3, f4, f5, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            h(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface a3 = g.a(context, typeface);
        if (a3 != null) {
            typeface = a3;
        }
        textPaint.setTypeface(typeface);
        int i3 = this.f2032e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i3 & 1) != 0);
        textPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f2041n);
        if (this.f2038k) {
            textPaint.setLetterSpacing(this.f2039l);
        }
    }
}
