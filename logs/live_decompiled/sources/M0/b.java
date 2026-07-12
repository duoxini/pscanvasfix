package m0;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Path f12401a;

    /* renamed from: m0.b$b, reason: collision with other inner class name */
    private static final class C0138b {

        /* renamed from: a, reason: collision with root package name */
        static final b f12402a = new b();
    }

    public static b a() {
        return C0138b.f12402a;
    }

    public Path b(Rect rect, float f3) {
        return c(new RectF(rect), f3);
    }

    public Path c(RectF rectF, float f3) {
        return c.a(this.f12401a, rectF, f3);
    }

    private b() {
        this.f12401a = new Path();
    }
}
