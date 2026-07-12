package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* loaded from: classes.dex */
public final class o extends i {

    /* renamed from: f, reason: collision with root package name */
    private static Paint f5300f;

    public o(g gVar) {
        super(gVar);
    }

    private static Paint c() {
        if (f5300f == null) {
            TextPaint textPaint = new TextPaint();
            f5300f = textPaint;
            textPaint.setColor(e.b().c());
            f5300f.setStyle(Paint.Style.FILL);
        }
        return f5300f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
        if (e.b().i()) {
            canvas.drawRect(f3, i5, f3 + b(), i7, c());
        }
        a().a(canvas, f3, i6, paint);
    }
}
