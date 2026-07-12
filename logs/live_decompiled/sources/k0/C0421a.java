package k0;

import M1.e;
import Z1.b;
import Z1.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;

/* renamed from: k0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0421a {

    /* renamed from: a, reason: collision with root package name */
    private int f12203a;

    /* renamed from: b, reason: collision with root package name */
    private int f12204b;

    /* renamed from: c, reason: collision with root package name */
    private int f12205c;

    /* renamed from: d, reason: collision with root package name */
    private int f12206d;

    /* renamed from: e, reason: collision with root package name */
    private int f12207e;

    /* renamed from: f, reason: collision with root package name */
    private int f12208f;

    /* renamed from: g, reason: collision with root package name */
    private int f12209g;

    /* renamed from: h, reason: collision with root package name */
    private int f12210h;

    /* renamed from: i, reason: collision with root package name */
    private int f12211i;

    /* renamed from: j, reason: collision with root package name */
    private int f12212j;

    /* renamed from: k, reason: collision with root package name */
    private int f12213k;

    /* renamed from: l, reason: collision with root package name */
    private int f12214l;

    /* renamed from: m, reason: collision with root package name */
    private int f12215m;

    /* renamed from: n, reason: collision with root package name */
    private int f12216n;

    /* renamed from: o, reason: collision with root package name */
    private int f12217o;

    /* renamed from: p, reason: collision with root package name */
    private TextPaint f12218p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f12219q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f12220r;

    public C0421a(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
        this.f12203a = obtainStyledAttributes.getColor(g.f3125f, 0);
        this.f12205c = obtainStyledAttributes.getColor(g.f3126g, 0);
        this.f12206d = obtainStyledAttributes.getDimensionPixelSize(g.f3130k, 0);
        this.f12207e = obtainStyledAttributes.getDimensionPixelSize(g.f3133n, 0);
        this.f12208f = obtainStyledAttributes.getDimensionPixelSize(g.f3132m, 0);
        this.f12209g = obtainStyledAttributes.getDimensionPixelSize(g.f3131l, 0);
        this.f12211i = obtainStyledAttributes.getDimensionPixelSize(g.f3124e, 0);
        this.f12212j = obtainStyledAttributes.getDimensionPixelSize(g.f3121b, 0);
        this.f12213k = obtainStyledAttributes.getDimensionPixelSize(g.f3122c, 0);
        this.f12215m = obtainStyledAttributes.getDimensionPixelSize(g.f3123d, 0);
        obtainStyledAttributes.recycle();
        this.f12214l = context.getResources().getDimensionPixelSize(b.f3112e);
        this.f12210h = context.getResources().getDimensionPixelSize(b.f3111d);
        this.f12216n = context.getResources().getDimensionPixelSize(b.f3110c);
        this.f12217o = context.getResources().getDimensionPixelSize(b.f3109b);
        this.f12204b = androidx.core.content.a.c(context, e.f1392h);
        TextPaint textPaint = new TextPaint();
        this.f12218p = textPaint;
        textPaint.setAntiAlias(true);
        this.f12218p.setColor(this.f12205c);
        this.f12218p.setTextSize(this.f12206d);
        this.f12218p.setTypeface(Typeface.create("sans-serif-medium", 0));
        Paint paint = new Paint();
        this.f12219q = paint;
        paint.setAntiAlias(true);
        this.f12219q.setColor(this.f12203a);
        Paint paint2 = this.f12219q;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f12220r = paint3;
        paint3.setAntiAlias(true);
        this.f12220r.setColor(this.f12204b);
        this.f12220r.setStyle(style);
    }

    private void a(Canvas canvas, int i3, int i4, RectF rectF, boolean z3) {
        if (i3 <= 0) {
            return;
        }
        if (z3) {
            this.f12218p.setAlpha(Math.max(0, Math.min(255, i4)));
        }
        if (i3 < 1000) {
            String valueOf = String.valueOf(i3);
            Paint.FontMetricsInt fontMetricsInt = this.f12218p.getFontMetricsInt();
            int measureText = (int) this.f12218p.measureText(valueOf);
            float f3 = rectF.left;
            canvas.drawText(valueOf, f3 + (((rectF.right - f3) - measureText) / 2.0f), (((rectF.top + rectF.bottom) - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2.0f, this.f12218p);
        } else {
            float f4 = (rectF.left + rectF.right) / 2.0f;
            float f5 = (rectF.top + rectF.bottom) / 2.0f;
            for (int i5 = -1; i5 <= 1; i5++) {
                int i6 = this.f12216n;
                canvas.drawCircle(((i6 + r1) * i5) + f4, f5, this.f12215m / 2.0f, this.f12218p);
            }
        }
        this.f12218p.setColor(this.f12205c);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f3 = rectF.bottom;
        float f4 = rectF.top;
        float f5 = (f3 - f4) / 2.0f;
        canvas.drawCircle(rectF.left + f5, f4 + f5, f5, this.f12219q);
    }

    private void c(Canvas canvas, RectF rectF) {
        float f3 = rectF.bottom;
        float f4 = rectF.top;
        float f5 = (f3 - f4) / 2.0f;
        canvas.drawCircle(rectF.left + f5, f4 + f5, f5 - this.f12217o, this.f12219q);
    }

    private void e(Canvas canvas, Object obj, RectF rectF) {
        Path c3;
        boolean z3 = obj instanceof String;
        if (z3) {
            if (TextUtils.isEmpty((CharSequence) obj)) {
                return;
            }
        } else {
            if (!(obj instanceof Integer)) {
                throw new IllegalArgumentException("params 'number' must be String or Integer!");
            }
            if (((Integer) obj).intValue() <= 0) {
                return;
            }
        }
        if (Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top) < this.f12212j * 2) {
            c3 = m0.b.a().c(rectF, ((int) Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top)) / 2);
        } else {
            c3 = m0.b.a().c(rectF, this.f12212j);
        }
        canvas.drawPath(c3, this.f12219q);
        if (z3) {
            h(canvas, (String) obj, rectF);
        } else {
            a(canvas, ((Integer) obj).intValue(), 255, rectF, false);
        }
    }

    private void f(Canvas canvas, Object obj, RectF rectF) {
        boolean z3 = obj instanceof String;
        if (z3) {
            if (TextUtils.isEmpty((CharSequence) obj)) {
                return;
            }
        } else {
            if (!(obj instanceof Integer)) {
                throw new IllegalArgumentException("params 'number' must be String or Integer!");
            }
            if (((Integer) obj).intValue() <= 0) {
                return;
            }
        }
        RectF rectF2 = new RectF();
        rectF2.left = 0.0f;
        float f3 = rectF.right;
        int i3 = this.f12217o;
        float f4 = f3 - (i3 * 2);
        rectF2.right = f4;
        rectF2.top = 0.0f;
        float f5 = rectF.bottom - (i3 * 2);
        rectF2.bottom = f5;
        int min = ((int) Math.min(f4 - 0.0f, f5 - 0.0f)) / 2;
        canvas.drawPath(m0.b.a().c(rectF, this.f12212j), this.f12220r);
        canvas.save();
        int i4 = this.f12217o;
        canvas.translate(i4, i4);
        canvas.drawPath(m0.b.a().c(rectF2, min), this.f12219q);
        canvas.restore();
        if (z3) {
            h(canvas, (String) obj, rectF);
        } else {
            a(canvas, ((Integer) obj).intValue(), 255, rectF, false);
        }
    }

    private void h(Canvas canvas, String str, RectF rectF) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        float measureText = this.f12218p.measureText(str);
        if (measureText < this.f12218p.measureText(String.valueOf(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT))) {
            Paint.FontMetricsInt fontMetricsInt = this.f12218p.getFontMetricsInt();
            float f3 = rectF.left;
            canvas.drawText(str, f3 + (((rectF.right - f3) - measureText) / 2.0f), (((rectF.top + rectF.bottom) - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2.0f, this.f12218p);
            return;
        }
        float f4 = (rectF.left + rectF.right) / 2.0f;
        float f5 = (rectF.top + rectF.bottom) / 2.0f;
        for (int i3 = -1; i3 <= 1; i3++) {
            int i4 = this.f12216n;
            canvas.drawCircle(((i4 + r3) * i3) + f4, f5, this.f12215m / 2.0f, this.f12218p);
        }
    }

    private int i() {
        return this.f12211i;
    }

    private int j(int i3) {
        if (i3 < 10) {
            return Math.max(this.f12207e, this.f12211i);
        }
        if (i3 >= 100 && i3 < 1000) {
            return Math.max(this.f12209g, this.f12211i);
        }
        return Math.max(this.f12208f, this.f12211i);
    }

    private int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.f12207e;
        }
        if (q(str)) {
            return j(Integer.parseInt(str));
        }
        float measureText = (int) this.f12218p.measureText(str);
        if (measureText < this.f12218p.measureText(String.valueOf(10))) {
            return Math.max(this.f12207e, this.f12211i);
        }
        if (measureText >= this.f12218p.measureText(String.valueOf(100)) && measureText < this.f12218p.measureText(String.valueOf(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT))) {
            return Math.max(this.f12209g, this.f12211i);
        }
        return Math.max(this.f12208f, this.f12211i);
    }

    private int l(int i3) {
        return i3 < 10 ? this.f12210h : i3 < 100 ? this.f12207e : this.f12208f;
    }

    private int m(String str) {
        float measureText = (int) this.f12218p.measureText(str);
        if (measureText < this.f12218p.measureText(String.valueOf(10))) {
            return this.f12210h;
        }
        if (measureText >= this.f12218p.measureText(String.valueOf(100)) && measureText < this.f12218p.measureText(String.valueOf(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT))) {
            return this.f12209g;
        }
        return this.f12208f;
    }

    private boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (Character.isDigit(str.charAt(length)));
        return false;
    }

    public void A(int i3) {
        this.f12211i = i3;
        s(i3 / 2);
    }

    public void d(Canvas canvas, int i3, int i4, int i5, int i6, RectF rectF) {
        canvas.drawPath(m0.b.a().c(rectF, this.f12212j), this.f12219q);
        if (i4 > i6) {
            a(canvas, i3, i4, rectF, true);
            a(canvas, i5, i6, rectF, true);
        } else {
            a(canvas, i5, i6, rectF, true);
            a(canvas, i3, i4, rectF, true);
        }
    }

    public void g(Canvas canvas, int i3, Object obj, RectF rectF) {
        if (i3 == 1) {
            b(canvas, rectF);
            return;
        }
        if (i3 == 2 || i3 == 3) {
            e(canvas, obj, rectF);
        } else if (i3 == 4) {
            c(canvas, rectF);
        } else {
            if (i3 != 5) {
                return;
            }
            f(canvas, obj, rectF);
        }
    }

    public int n(int i3) {
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return 0;
                    }
                }
            }
            return i();
        }
        return this.f12213k;
    }

    public int o(int i3, int i4) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return l(i4);
                }
                if (i3 != 4) {
                    if (i3 != 5) {
                        return 0;
                    }
                }
            }
            return j(i4);
        }
        return this.f12213k;
    }

    public int p(int i3, String str) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return m(str);
                }
                if (i3 != 4) {
                    if (i3 != 5) {
                        return 0;
                    }
                }
            }
            return k(str);
        }
        return this.f12213k;
    }

    public void r(int i3) {
        this.f12203a = i3;
        this.f12219q.setColor(i3);
    }

    public void s(int i3) {
        this.f12212j = i3;
    }

    public void t(int i3) {
        this.f12213k = i3;
    }

    public void u(int i3) {
        this.f12215m = i3;
    }

    public void v(int i3) {
        this.f12209g = i3;
    }

    public void w(int i3) {
        this.f12208f = i3;
    }

    public void x(int i3) {
        this.f12207e = i3;
    }

    public void y(int i3) {
        this.f12205c = i3;
        this.f12218p.setColor(i3);
    }

    public void z(int i3) {
        this.f12206d = i3;
    }
}
