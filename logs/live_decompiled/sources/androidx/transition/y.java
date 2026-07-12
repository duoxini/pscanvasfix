package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* loaded from: classes.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final E f6758a = new D();

    /* renamed from: b, reason: collision with root package name */
    static final Property f6759b = new a(Float.class, "translationAlpha");

    /* renamed from: c, reason: collision with root package name */
    static final Property f6760c = new b(Rect.class, "clipBounds");

    static class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            y.g(view, f3.floatValue());
        }
    }

    static class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return androidx.core.view.y.r(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            androidx.core.view.y.q0(view, rect);
        }
    }

    static void a(View view) {
        f6758a.a(view);
    }

    static x b(View view) {
        return new w(view);
    }

    static float c(View view) {
        return f6758a.b(view);
    }

    static H d(View view) {
        return new G(view);
    }

    static void e(View view) {
        f6758a.c(view);
    }

    static void f(View view, int i3, int i4, int i5, int i6) {
        f6758a.d(view, i3, i4, i5, i6);
    }

    static void g(View view, float f3) {
        f6758a.e(view, f3);
    }

    static void h(View view, int i3) {
        f6758a.f(view, i3);
    }

    static void i(View view, Matrix matrix) {
        f6758a.g(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        f6758a.h(view, matrix);
    }
}
