package y0;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.oplus.view.OplusView;
import h0.AbstractC0371a;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public abstract class i {
    public static boolean a() {
        return AbstractC0647b.b(34, 2);
    }

    public static void b(View view) {
        if (a()) {
            g(view, 0, 0, 0, 0, 0, -1);
        } else {
            f(view, 0, 0, 0);
        }
    }

    public static void c(View view, int i3) {
        e(view, i3, 0, 0, 0);
    }

    public static void d(View view, int i3, int i4, int i5) {
        e(view, i3, i4, view.getResources().getDimensionPixelOffset(M1.f.f1441e0), i5);
    }

    public static void e(View view, int i3, int i4, int i5, int i6) {
        if (view == null) {
            AbstractC0371a.c("ShadowUtils", "setElevationToView view is null");
            return;
        }
        if (!a()) {
            f(view, i4, i6, i5);
            return;
        }
        Resources resources = view.getContext().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(M1.f.f1409D);
        if (i3 == 0) {
            g(view, dimensionPixelSize, Color.argb(resources.getInteger(M1.i.f1484a), 0, 0, 0), resources.getDimensionPixelSize(M1.f.f1417L), resources.getDimensionPixelSize(M1.f.f1422Q), resources.getDimensionPixelSize(M1.f.f1412G), resources.getDimensionPixelSize(M1.f.f1465y));
            return;
        }
        if (i3 == 1) {
            g(view, dimensionPixelSize, Color.argb(resources.getInteger(M1.i.f1485b), 0, 0, 0), resources.getDimensionPixelSize(M1.f.f1418M), resources.getDimensionPixelSize(M1.f.f1423R), resources.getDimensionPixelSize(M1.f.f1413H), resources.getDimensionPixelSize(M1.f.f1466z));
            return;
        }
        if (i3 == 2) {
            g(view, dimensionPixelSize, Color.argb(resources.getInteger(M1.i.f1486c), 0, 0, 0), resources.getDimensionPixelSize(M1.f.f1419N), resources.getDimensionPixelSize(M1.f.f1424S), resources.getDimensionPixelSize(M1.f.f1414I), resources.getDimensionPixelSize(M1.f.f1406A));
        } else if (i3 == 3) {
            g(view, resources.getDimensionPixelSize(M1.f.f1411F), Color.argb(resources.getInteger(M1.i.f1487d), 0, 0, 0), resources.getDimensionPixelSize(M1.f.f1420O), resources.getDimensionPixelSize(M1.f.f1425T), resources.getDimensionPixelSize(M1.f.f1415J), resources.getDimensionPixelSize(M1.f.f1407B));
        } else if (i3 == 4) {
            g(view, resources.getDimensionPixelSize(M1.f.f1410E), Color.argb(resources.getInteger(M1.i.f1488e), 0, 0, 0), resources.getDimensionPixelSize(M1.f.f1421P), resources.getDimensionPixelSize(M1.f.f1426U), resources.getDimensionPixelSize(M1.f.f1416K), resources.getDimensionPixelSize(M1.f.f1408C));
        }
    }

    public static void f(View view, int i3, int i4, int i5) {
        if (view == null) {
            return;
        }
        view.setOutlineSpotShadowColor(i4);
        view.setElevation(i3);
    }

    public static void g(View view, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (view != null && a()) {
            view.setOutlineAmbientShadowColor(i4);
            view.setOutlineSpotShadowColor(i4);
            view.setElevation(i3);
            try {
                new OplusView(view).setOverrideLightSourceGeometry(-1.0f, i5, i6, i7, i8);
            } catch (Exception e3) {
                AbstractC0371a.a("ShadowUtils", "setOverrideLightSourceGeometry error:" + e3.getMessage());
            }
        }
    }
}
