package k1;

import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import l1.c;

/* loaded from: classes.dex */
abstract class t {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12275a = c.a.a("x", "y");

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12276a;

        static {
            int[] iArr = new int[c.b.values().length];
            f12276a = iArr;
            try {
                iArr[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12276a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12276a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(l1.c cVar, float f3) {
        cVar.b();
        float p3 = (float) cVar.p();
        float p4 = (float) cVar.p();
        while (cVar.N() != c.b.END_ARRAY) {
            cVar.c0();
        }
        cVar.g();
        return new PointF(p3 * f3, p4 * f3);
    }

    private static PointF b(l1.c cVar, float f3) {
        float p3 = (float) cVar.p();
        float p4 = (float) cVar.p();
        while (cVar.j()) {
            cVar.c0();
        }
        return new PointF(p3 * f3, p4 * f3);
    }

    private static PointF c(l1.c cVar, float f3) {
        cVar.c();
        float f4 = 0.0f;
        float f5 = 0.0f;
        while (cVar.j()) {
            int a02 = cVar.a0(f12275a);
            if (a02 == 0) {
                f4 = g(cVar);
            } else if (a02 != 1) {
                cVar.b0();
                cVar.c0();
            } else {
                f5 = g(cVar);
            }
        }
        cVar.i();
        return new PointF(f4 * f3, f5 * f3);
    }

    static int d(l1.c cVar) {
        cVar.b();
        int p3 = (int) (cVar.p() * 255.0d);
        int p4 = (int) (cVar.p() * 255.0d);
        int p5 = (int) (cVar.p() * 255.0d);
        while (cVar.j()) {
            cVar.c0();
        }
        cVar.g();
        return Color.argb(255, p3, p4, p5);
    }

    static PointF e(l1.c cVar, float f3) {
        int i3 = a.f12276a[cVar.N().ordinal()];
        if (i3 == 1) {
            return b(cVar, f3);
        }
        if (i3 == 2) {
            return a(cVar, f3);
        }
        if (i3 == 3) {
            return c(cVar, f3);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.N());
    }

    static List f(l1.c cVar, float f3) {
        ArrayList arrayList = new ArrayList();
        cVar.b();
        while (cVar.N() == c.b.BEGIN_ARRAY) {
            cVar.b();
            arrayList.add(e(cVar, f3));
            cVar.g();
        }
        cVar.g();
        return arrayList;
    }

    static float g(l1.c cVar) {
        c.b N3 = cVar.N();
        int i3 = a.f12276a[N3.ordinal()];
        if (i3 == 1) {
            return (float) cVar.p();
        }
        if (i3 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + N3);
        }
        cVar.b();
        float p3 = (float) cVar.p();
        while (cVar.j()) {
            cVar.c0();
        }
        cVar.g();
        return p3;
    }
}
