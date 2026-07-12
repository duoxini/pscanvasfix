package k1;

import a1.C0221a;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import l1.c;
import m1.AbstractC0464g;
import m1.AbstractC0465h;

/* loaded from: classes.dex */
abstract class u {

    /* renamed from: b, reason: collision with root package name */
    private static m.h f12278b;

    /* renamed from: a, reason: collision with root package name */
    private static final Interpolator f12277a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    static c.a f12279c = c.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: d, reason: collision with root package name */
    static c.a f12280d = c.a.a("x", "y");

    private static WeakReference a(int i3) {
        WeakReference weakReference;
        synchronized (u.class) {
            weakReference = (WeakReference) g().e(i3);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator a3;
        pointF.x = AbstractC0464g.b(pointF.x, -1.0f, 1.0f);
        pointF.y = AbstractC0464g.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = AbstractC0464g.b(pointF2.x, -1.0f, 1.0f);
        float b3 = AbstractC0464g.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b3;
        int j3 = AbstractC0465h.j(pointF.x, pointF.y, pointF2.x, b3);
        WeakReference a4 = a(j3);
        Interpolator interpolator = a4 != null ? (Interpolator) a4.get() : null;
        if (a4 == null || interpolator == null) {
            try {
                a3 = androidx.core.view.animation.a.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e3) {
                a3 = "The Path cannot loop back on itself.".equals(e3.getMessage()) ? androidx.core.view.animation.a.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = a3;
            try {
                h(j3, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    static n1.c c(l1.c cVar, C0221a c0221a, float f3, N n3, boolean z3, boolean z4) {
        return (z3 && z4) ? e(c0221a, cVar, f3, n3) : z3 ? d(c0221a, cVar, f3, n3) : f(cVar, f3, n3);
    }

    private static n1.c d(C0221a c0221a, l1.c cVar, float f3, N n3) {
        Interpolator b3;
        Object obj;
        cVar.c();
        PointF pointF = null;
        Object obj2 = null;
        Object obj3 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f4 = 0.0f;
        boolean z3 = false;
        PointF pointF4 = null;
        while (cVar.j()) {
            switch (cVar.a0(f12279c)) {
                case 0:
                    f4 = (float) cVar.p();
                    break;
                case 1:
                    obj3 = n3.a(cVar, f3);
                    break;
                case 2:
                    obj2 = n3.a(cVar, f3);
                    break;
                case 3:
                    pointF = t.e(cVar, 1.0f);
                    break;
                case 4:
                    pointF4 = t.e(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.q() != 1) {
                        z3 = false;
                        break;
                    } else {
                        z3 = true;
                        break;
                    }
                case 6:
                    pointF2 = t.e(cVar, f3);
                    break;
                case 7:
                    pointF3 = t.e(cVar, f3);
                    break;
                default:
                    cVar.c0();
                    break;
            }
        }
        cVar.i();
        if (z3) {
            b3 = f12277a;
            obj = obj3;
        } else {
            b3 = (pointF == null || pointF4 == null) ? f12277a : b(pointF, pointF4);
            obj = obj2;
        }
        n1.c cVar2 = new n1.c(c0221a, obj3, obj, b3, f4, null);
        cVar2.f12587o = pointF2;
        cVar2.f12588p = pointF3;
        return cVar2;
    }

    private static n1.c e(C0221a c0221a, l1.c cVar, float f3, N n3) {
        Interpolator interpolator;
        Interpolator b3;
        Interpolator b4;
        Object obj;
        PointF pointF;
        n1.c cVar2;
        PointF pointF2;
        float f4;
        PointF pointF3;
        cVar.c();
        PointF pointF4 = null;
        boolean z3 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        Object obj2 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f5 = 0.0f;
        PointF pointF11 = null;
        Object obj3 = null;
        while (cVar.j()) {
            switch (cVar.a0(f12279c)) {
                case 0:
                    pointF2 = pointF4;
                    f5 = (float) cVar.p();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    obj2 = n3.a(cVar, f3);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    obj3 = n3.a(cVar, f3);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f4 = f5;
                    PointF pointF12 = pointF11;
                    if (cVar.N() == c.b.BEGIN_OBJECT) {
                        cVar.c();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        while (cVar.j()) {
                            int a02 = cVar.a0(f12280d);
                            if (a02 == 0) {
                                c.b N3 = cVar.N();
                                c.b bVar = c.b.NUMBER;
                                if (N3 == bVar) {
                                    f8 = (float) cVar.p();
                                    f6 = f8;
                                } else {
                                    cVar.b();
                                    f6 = (float) cVar.p();
                                    f8 = cVar.N() == bVar ? (float) cVar.p() : f6;
                                    cVar.g();
                                }
                            } else if (a02 != 1) {
                                cVar.c0();
                            } else {
                                c.b N4 = cVar.N();
                                c.b bVar2 = c.b.NUMBER;
                                if (N4 == bVar2) {
                                    f9 = (float) cVar.p();
                                    f7 = f9;
                                } else {
                                    cVar.b();
                                    f7 = (float) cVar.p();
                                    f9 = cVar.N() == bVar2 ? (float) cVar.p() : f7;
                                    cVar.g();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f6, f7);
                        PointF pointF14 = new PointF(f8, f9);
                        cVar.i();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f5 = f4;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = t.e(cVar, f3);
                        f5 = f4;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (cVar.N() == c.b.BEGIN_OBJECT) {
                        cVar.c();
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        while (cVar.j()) {
                            PointF pointF15 = pointF11;
                            int a03 = cVar.a0(f12280d);
                            if (a03 != 0) {
                                pointF3 = pointF4;
                                if (a03 != 1) {
                                    cVar.c0();
                                } else {
                                    c.b N5 = cVar.N();
                                    c.b bVar3 = c.b.NUMBER;
                                    if (N5 == bVar3) {
                                        f13 = (float) cVar.p();
                                        f5 = f5;
                                        f11 = f13;
                                    } else {
                                        float f14 = f5;
                                        cVar.b();
                                        float p3 = (float) cVar.p();
                                        float p4 = cVar.N() == bVar3 ? (float) cVar.p() : p3;
                                        cVar.g();
                                        f5 = f14;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f13 = p4;
                                        f11 = p3;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f15 = f5;
                                c.b N6 = cVar.N();
                                c.b bVar4 = c.b.NUMBER;
                                if (N6 == bVar4) {
                                    f12 = (float) cVar.p();
                                    f5 = f15;
                                    f10 = f12;
                                } else {
                                    cVar.b();
                                    f10 = (float) cVar.p();
                                    f12 = cVar.N() == bVar4 ? (float) cVar.p() : f10;
                                    cVar.g();
                                    f5 = f15;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f4 = f5;
                        PointF pointF16 = new PointF(f10, f11);
                        PointF pointF17 = new PointF(f12, f13);
                        cVar.i();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f5 = f4;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = t.e(cVar, f3);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (cVar.q() != 1) {
                        z3 = false;
                        break;
                    } else {
                        z3 = true;
                        break;
                    }
                case 6:
                    pointF11 = t.e(cVar, f3);
                    break;
                case 7:
                    pointF4 = t.e(cVar, f3);
                    break;
                default:
                    cVar.c0();
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f16 = f5;
        PointF pointF19 = pointF11;
        cVar.i();
        if (z3) {
            interpolator = f12277a;
            obj = obj2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b3 = b(pointF7, pointF9);
                    b4 = b(pointF8, pointF10);
                    obj = obj3;
                    interpolator = null;
                    if (b3 != null || b4 == null) {
                        pointF = pointF19;
                        cVar2 = new n1.c(c0221a, obj2, obj, interpolator, f16, null);
                    } else {
                        pointF = pointF19;
                        cVar2 = new n1.c(c0221a, obj2, obj, b3, b4, f16, null);
                    }
                    cVar2.f12587o = pointF;
                    cVar2.f12588p = pointF18;
                    return cVar2;
                }
                interpolator = f12277a;
            }
            obj = obj3;
        }
        b3 = null;
        b4 = null;
        if (b3 != null) {
        }
        pointF = pointF19;
        cVar2 = new n1.c(c0221a, obj2, obj, interpolator, f16, null);
        cVar2.f12587o = pointF;
        cVar2.f12588p = pointF18;
        return cVar2;
    }

    private static n1.c f(l1.c cVar, float f3, N n3) {
        return new n1.c(n3.a(cVar, f3));
    }

    private static m.h g() {
        if (f12278b == null) {
            f12278b = new m.h();
        }
        return f12278b;
    }

    private static void h(int i3, WeakReference weakReference) {
        synchronized (u.class) {
            f12278b.i(i3, weakReference);
        }
    }
}
