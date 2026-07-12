package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class i extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    private final g f5271b;

    /* renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f5270a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    private short f5272c = -1;

    /* renamed from: d, reason: collision with root package name */
    private short f5273d = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f5274e = 1.0f;

    i(g gVar) {
        androidx.core.util.h.e(gVar, "metadata cannot be null");
        this.f5271b = gVar;
    }

    public final g a() {
        return this.f5271b;
    }

    final int b() {
        return this.f5272c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f5270a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f5270a;
        this.f5274e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f5271b.e();
        this.f5273d = (short) (this.f5271b.e() * this.f5274e);
        short i5 = (short) (this.f5271b.i() * this.f5274e);
        this.f5272c = i5;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f5270a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i5;
    }
}
