package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f4899e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f4900a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4901b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4902c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4903d;

    static class a {
        static Insets a(int i3, int i4, int i5, int i6) {
            return Insets.of(i3, i4, i5, i6);
        }
    }

    private b(int i3, int i4, int i5, int i6) {
        this.f4900a = i3;
        this.f4901b = i4;
        this.f4902c = i5;
        this.f4903d = i6;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f4900a, bVar2.f4900a), Math.max(bVar.f4901b, bVar2.f4901b), Math.max(bVar.f4902c, bVar2.f4902c), Math.max(bVar.f4903d, bVar2.f4903d));
    }

    public static b b(int i3, int i4, int i5, int i6) {
        return (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f4899e : new b(i3, i4, i5, i6);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f4900a, this.f4901b, this.f4902c, this.f4903d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4903d == bVar.f4903d && this.f4900a == bVar.f4900a && this.f4902c == bVar.f4902c && this.f4901b == bVar.f4901b;
    }

    public int hashCode() {
        return (((((this.f4900a * 31) + this.f4901b) * 31) + this.f4902c) * 31) + this.f4903d;
    }

    public String toString() {
        return "Insets{left=" + this.f4900a + ", top=" + this.f4901b + ", right=" + this.f4902c + ", bottom=" + this.f4903d + '}';
    }
}
