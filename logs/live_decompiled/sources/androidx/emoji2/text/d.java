package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.e;

/* loaded from: classes.dex */
class d implements e.d {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f5216b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f5217a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.f5217a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f5216b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.d
    public boolean a(CharSequence charSequence, int i3, int i4, int i5) {
        StringBuilder b3 = b();
        b3.setLength(0);
        while (i3 < i4) {
            b3.append(charSequence.charAt(i3));
            i3++;
        }
        return androidx.core.graphics.c.a(this.f5217a, b3.toString());
    }
}
