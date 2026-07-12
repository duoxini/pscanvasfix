package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class g {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f5253d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final int f5254a;

    /* renamed from: b, reason: collision with root package name */
    private final m f5255b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f5256c = 0;

    g(m mVar, int i3) {
        this.f5255b = mVar;
        this.f5254a = i3;
    }

    private C.a g() {
        ThreadLocal threadLocal = f5253d;
        C.a aVar = (C.a) threadLocal.get();
        if (aVar == null) {
            aVar = new C.a();
            threadLocal.set(aVar);
        }
        this.f5255b.d().j(aVar, this.f5254a);
        return aVar;
    }

    public void a(Canvas canvas, float f3, float f4, Paint paint) {
        Typeface g3 = this.f5255b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g3);
        canvas.drawText(this.f5255b.c(), this.f5254a * 2, 2, f3, f4, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i3) {
        return g().h(i3);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f5256c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public void k(boolean z3) {
        this.f5256c = z3 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c3 = c();
        for (int i3 = 0; i3 < c3; i3++) {
            sb.append(Integer.toHexString(b(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
