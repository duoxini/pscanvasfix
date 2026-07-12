package androidx.core.view;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

/* renamed from: androidx.core.view.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0254c {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCutout f5111a;

    /* renamed from: androidx.core.view.c$a */
    static class a {
        static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    private C0254c(DisplayCutout displayCutout) {
        this.f5111a = displayCutout;
    }

    static C0254c e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C0254c(displayCutout);
    }

    public int a() {
        return a.c(this.f5111a);
    }

    public int b() {
        return a.d(this.f5111a);
    }

    public int c() {
        return a.e(this.f5111a);
    }

    public int d() {
        return a.f(this.f5111a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0254c.class != obj.getClass()) {
            return false;
        }
        return androidx.core.util.c.a(this.f5111a, ((C0254c) obj).f5111a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f5111a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f5111a + "}";
    }
}
