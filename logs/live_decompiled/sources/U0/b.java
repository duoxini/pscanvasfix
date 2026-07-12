package U0;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final c f2238a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2239b;

    public b(float f3, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f2238a;
            f3 += ((b) cVar).f2239b;
        }
        this.f2238a = cVar;
        this.f2239b = f3;
    }

    @Override // U0.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f2238a.a(rectF) + this.f2239b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2238a.equals(bVar.f2238a) && this.f2239b == bVar.f2239b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2238a, Float.valueOf(this.f2239b)});
    }
}
