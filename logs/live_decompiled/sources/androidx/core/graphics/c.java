package androidx.core.graphics;

import android.graphics.Paint;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4904a = new ThreadLocal();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        return a.a(paint, str);
    }
}
