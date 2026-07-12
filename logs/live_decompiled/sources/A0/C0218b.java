package a0;

import M1.f;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import u0.AbstractC0597a;

/* renamed from: a0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0218b extends ReplacementSpan {

    /* renamed from: a, reason: collision with root package name */
    private Context f3150a;

    /* renamed from: b, reason: collision with root package name */
    private String f3151b;

    /* renamed from: c, reason: collision with root package name */
    private String f3152c;

    /* renamed from: d, reason: collision with root package name */
    private TextPaint f3153d;

    /* renamed from: e, reason: collision with root package name */
    private TextPaint f3154e;

    /* renamed from: f, reason: collision with root package name */
    private int f3155f;

    /* renamed from: g, reason: collision with root package name */
    private int f3156g;

    /* renamed from: h, reason: collision with root package name */
    private int f3157h;

    /* renamed from: i, reason: collision with root package name */
    private int f3158i;

    /* renamed from: j, reason: collision with root package name */
    private int f3159j;

    /* renamed from: k, reason: collision with root package name */
    private int f3160k;

    /* renamed from: l, reason: collision with root package name */
    private int f3161l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3162m;

    public C0218b(Context context, String str, String str2, int i3, int i4, int i5, int i6, Paint paint, boolean z3) {
        this.f3151b = str;
        this.f3152c = str2;
        this.f3155f = i3;
        this.f3156g = i4 < 0 ? 0 : i4;
        this.f3150a = context;
        this.f3159j = i5;
        this.f3160k = i6;
        this.f3162m = z3;
        this.f3153d = new TextPaint(paint);
        f();
        e();
    }

    private int a() {
        return ((int) this.f3153d.measureText(" ")) / 2;
    }

    private int b() {
        return Math.abs(this.f3157h - this.f3158i) / 2;
    }

    private String c(String str, int i3, TextPaint textPaint) {
        return (TextUtils.isEmpty(str) || i3 < 0) ? "" : StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, i3).setMaxLines(1).setEllipsize(TextUtils.TruncateAt.END).build().getText().toString();
    }

    private int d() {
        if (TextUtils.isEmpty(this.f3152c) || TextUtils.isEmpty(this.f3151b)) {
            return 0;
        }
        return Math.max(this.f3158i, this.f3157h);
    }

    private void e() {
        int i3 = this.f3158i;
        int i4 = this.f3155f;
        if (i3 > i4) {
            String c3 = c(this.f3152c, i4, this.f3154e);
            this.f3152c = c3;
            this.f3158i = (int) this.f3154e.measureText(c3);
        }
        int i5 = this.f3157h;
        int i6 = this.f3155f;
        if (i5 > i6) {
            String c4 = c(this.f3151b, i6, this.f3153d);
            this.f3151b = c4;
            this.f3157h = (int) this.f3153d.measureText(c4);
        }
    }

    private void f() {
        float f3 = this.f3150a.getResources().getConfiguration().fontScale;
        int dimensionPixelSize = this.f3150a.getResources().getDimensionPixelSize(f.f1446h);
        int dimensionPixelSize2 = this.f3150a.getResources().getDimensionPixelSize(f.f1444g);
        int e3 = (int) AbstractC0597a.e(dimensionPixelSize, f3, 2);
        int e4 = (int) AbstractC0597a.e(dimensionPixelSize2, f3, 2);
        this.f3153d.setTextSize(e3);
        this.f3153d.setColor(this.f3160k);
        TextPaint textPaint = new TextPaint(this.f3153d);
        this.f3154e = textPaint;
        textPaint.setTextSize(e4);
        this.f3154e.setColor(this.f3160k);
        this.f3158i = (int) this.f3154e.measureText(this.f3152c);
        this.f3157h = (int) this.f3153d.measureText(this.f3151b);
        this.f3161l = this.f3150a.getResources().getDimensionPixelSize(f.f1448i);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = this.f3154e.getFontMetricsInt();
        Paint.FontMetricsInt fontMetricsInt2 = this.f3153d.getFontMetricsInt();
        int i8 = fontMetricsInt.descent;
        int i9 = fontMetricsInt.ascent;
        int i10 = fontMetricsInt.leading;
        int i11 = i6 - ((((i8 - i9) + i10) + this.f3161l) / 2);
        int abs = fontMetricsInt2.bottom + i11 + i10 + Math.abs(i9) + this.f3161l;
        int a3 = a();
        int b3 = b();
        if (this.f3162m) {
            a3 = -a3;
        }
        float f4 = f3 - a3;
        if (this.f3157h > this.f3158i) {
            canvas.drawText(this.f3151b, f4, i11, this.f3153d);
            canvas.drawText(this.f3152c, f4 + b3, abs, this.f3154e);
        } else {
            canvas.drawText(this.f3151b, b3 + f4, i11, this.f3153d);
            canvas.drawText(this.f3152c, f4, abs, this.f3154e);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        return d();
    }
}
