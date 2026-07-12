package m1;

import android.graphics.Path;
import android.graphics.PointF;
import c1.k;
import f1.C0353a;
import f1.C0358f;
import h1.C0385n;
import java.util.List;

/* renamed from: m1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0464g {

    /* renamed from: a, reason: collision with root package name */
    private static final PointF f12422a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f3, float f4, float f5) {
        return Math.max(f4, Math.min(f5, f3));
    }

    public static int c(int i3, int i4, int i5) {
        return Math.max(i4, Math.min(i5, i3));
    }

    public static boolean d(float f3, float f4, float f5) {
        return f3 >= f4 && f3 <= f5;
    }

    private static int e(int i3, int i4) {
        int i5 = i3 / i4;
        return (((i3 ^ i4) >= 0) || i3 % i4 == 0) ? i5 : i5 - 1;
    }

    static int f(float f3, float f4) {
        return g((int) f3, (int) f4);
    }

    private static int g(int i3, int i4) {
        return i3 - (i4 * e(i3, i4));
    }

    public static void h(C0385n c0385n, Path path) {
        path.reset();
        PointF b3 = c0385n.b();
        path.moveTo(b3.x, b3.y);
        f12422a.set(b3.x, b3.y);
        for (int i3 = 0; i3 < c0385n.a().size(); i3++) {
            C0353a c0353a = (C0353a) c0385n.a().get(i3);
            PointF a3 = c0353a.a();
            PointF b4 = c0353a.b();
            PointF c3 = c0353a.c();
            PointF pointF = f12422a;
            if (a3.equals(pointF) && b4.equals(c3)) {
                path.lineTo(c3.x, c3.y);
            } else {
                path.cubicTo(a3.x, a3.y, b4.x, b4.y, c3.x, c3.y);
            }
            pointF.set(c3.x, c3.y);
        }
        if (c0385n.d()) {
            path.close();
        }
    }

    public static float i(float f3, float f4, float f5) {
        return f3 + (f5 * (f4 - f3));
    }

    public static int j(int i3, int i4, float f3) {
        return (int) (i3 + (f3 * (i4 - i3)));
    }

    public static void k(C0358f c0358f, int i3, List list, C0358f c0358f2, k kVar) {
        if (c0358f.c(kVar.j(), i3)) {
            list.add(c0358f2.a(kVar.j()).i(kVar));
        }
    }
}
