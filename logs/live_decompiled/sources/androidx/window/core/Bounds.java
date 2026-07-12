package androidx.window.core;

import D2.k;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class Bounds {

    /* renamed from: a, reason: collision with root package name */
    private final int f6938a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6939b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6940c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6941d;

    public Bounds(int i3, int i4, int i5, int i6) {
        this.f6938a = i3;
        this.f6939b = i4;
        this.f6940c = i5;
        this.f6941d = i6;
        if (i3 > i5) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i3 + ", right: " + i5).toString());
        }
        if (i4 <= i6) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i4 + ", bottom: " + i6).toString());
    }

    public final int a() {
        return this.f6941d - this.f6939b;
    }

    public final int b() {
        return this.f6938a;
    }

    public final int c() {
        return this.f6939b;
    }

    public final int d() {
        return this.f6940c - this.f6938a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(Bounds.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        Bounds bounds = (Bounds) obj;
        return this.f6938a == bounds.f6938a && this.f6939b == bounds.f6939b && this.f6940c == bounds.f6940c && this.f6941d == bounds.f6941d;
    }

    public final Rect f() {
        return new Rect(this.f6938a, this.f6939b, this.f6940c, this.f6941d);
    }

    public int hashCode() {
        return (((((this.f6938a * 31) + this.f6939b) * 31) + this.f6940c) * 31) + this.f6941d;
    }

    public String toString() {
        return Bounds.class.getSimpleName() + " { [" + this.f6938a + ',' + this.f6939b + ',' + this.f6940c + ',' + this.f6941d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        k.e(rect, "rect");
    }
}
