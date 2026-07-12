package androidx.window.layout;

import D2.k;
import android.graphics.Rect;
import androidx.core.view.J;
import androidx.window.core.Bounds;

/* loaded from: classes.dex */
public final class WindowMetrics {

    /* renamed from: a, reason: collision with root package name */
    private final Bounds f7192a;

    /* renamed from: b, reason: collision with root package name */
    private final J f7193b;

    public WindowMetrics(Bounds bounds, J j3) {
        k.e(bounds, "_bounds");
        k.e(j3, "_windowInsetsCompat");
        this.f7192a = bounds;
        this.f7193b = j3;
    }

    public final Rect a() {
        return this.f7192a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(WindowMetrics.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        WindowMetrics windowMetrics = (WindowMetrics) obj;
        return k.a(this.f7192a, windowMetrics.f7192a) && k.a(this.f7193b, windowMetrics.f7193b);
    }

    public int hashCode() {
        return (this.f7192a.hashCode() * 31) + this.f7193b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f7192a + ", windowInsetsCompat=" + this.f7193b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect rect, J j3) {
        this(new Bounds(rect), j3);
        k.e(rect, "bounds");
        k.e(j3, "insets");
    }
}
