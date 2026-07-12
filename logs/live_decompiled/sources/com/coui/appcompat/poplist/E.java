package com.coui.appcompat.poplist;

import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: c, reason: collision with root package name */
    public static final b f8160c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    private static final int f8161d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f8162e = 2;

    /* renamed from: a, reason: collision with root package name */
    private final String f8163a = "WindowSpacingControlHelper";

    /* renamed from: b, reason: collision with root package name */
    private Map f8164b = new HashMap();

    public enum a {
        NORMAL,
        TOOLBAR,
        NAVIGATION,
        START,
        END,
        TOP,
        BOTTOM
    }

    public static final class b {
        public /* synthetic */ b(D2.g gVar) {
            this();
        }

        private b() {
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8173a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.TOOLBAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.NAVIGATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8173a = iArr;
        }
    }

    private final boolean b(View view, a aVar) {
        if (c.f8173a[aVar.ordinal()] != 1) {
            return false;
        }
        return view instanceof Toolbar;
    }

    private final int f(Integer num, View view, a aVar) {
        View view2 = view;
        while (view2 != null) {
            if (b(view2, aVar)) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                view2.getLocationInWindow(iArr2);
                Integer valueOf = num != null ? Integer.valueOf(num.intValue() + g(view2, view, iArr2, iArr, aVar)) : null;
                if (valueOf != null) {
                    return valueOf.intValue();
                }
                return 0;
            }
            if (!(view2.getParent() instanceof View)) {
                Log.e(E.class.getName(), "getToolbarViewSpacing  tempView " + view2.getClass().getName());
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }
            Object parent = view2.getParent();
            D2.k.c(parent, "null cannot be cast to non-null type android.view.View");
            view2 = (View) parent;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final int g(View view, View view2, int[] iArr, int[] iArr2, a aVar) {
        int height;
        int height2;
        int h3 = h(aVar);
        if (h3 == f8161d) {
            height = iArr[1];
            height2 = iArr2[1];
        } else {
            if (h3 != f8162e) {
                return 0;
            }
            height = iArr[1] + view.getHeight();
            height2 = iArr2[1] + view2.getHeight();
        }
        return height - height2;
    }

    public final void a(int i3, a aVar) {
        D2.k.e(aVar, "enumType");
        Map map = this.f8164b;
        if (map != null) {
            map.put(aVar, Integer.valueOf(i3));
        }
    }

    public final int c(View view, a aVar) {
        D2.k.e(view, "anchorView");
        D2.k.e(aVar, "enumType");
        if (this.f8164b.isEmpty() || this.f8164b.get(aVar) == null) {
            return 0;
        }
        return f((Integer) this.f8164b.get(aVar), view, aVar);
    }

    public final int d(a aVar) {
        Integer num;
        D2.k.e(aVar, "enumType");
        if (this.f8164b.isEmpty() || this.f8164b.get(aVar) == null || (num = (Integer) this.f8164b.get(aVar)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final a e(View view) {
        D2.k.e(view, "anchorView");
        while (!(view instanceof Toolbar)) {
            if (!(view.getParent() instanceof View)) {
                Log.e(E.class.getName(), "getAnchorViewTypeEnum  tempView " + view.getClass().getName());
                return a.NORMAL;
            }
            Object parent = view.getParent();
            D2.k.c(parent, "null cannot be cast to non-null type android.view.View");
            view = (View) parent;
        }
        return a.TOOLBAR;
    }

    public final int h(a aVar) {
        D2.k.e(aVar, "enumType");
        int i3 = c.f8173a[aVar.ordinal()];
        return i3 != 1 ? i3 != 2 ? f8161d : f8161d : f8162e;
    }

    public final boolean i() {
        return !this.f8164b.isEmpty();
    }

    public final void j(int[] iArr, int[] iArr2, View view) {
        D2.k.e(iArr, "anchorViewLocationInScreen");
        D2.k.e(iArr2, "resultOriginCenterPoint");
        D2.k.e(view, "anchorView");
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            Log.e(this.f8163a, "setOriginCenterPoint anchorView.width <= 0 or anchorView.height <= 0");
            iArr2[0] = (int) view.getPivotX();
            iArr2[1] = (int) view.getPivotY();
        }
        float pivotX = view.getPivotX() / view.getWidth();
        float pivotY = view.getPivotY() / view.getHeight();
        float f3 = 2;
        float scaleX = iArr[0] + ((view.getScaleX() * view.getWidth()) / f3);
        float scaleY = iArr[1] + ((view.getScaleY() * view.getHeight()) / f3);
        float f4 = 1;
        iArr2[0] = Math.round(scaleX + ((pivotX - 0.5f) * (view.getScaleX() - f4) * view.getWidth()));
        iArr2[1] = Math.round(scaleY + ((pivotY - 0.5f) * (view.getScaleY() - f4) * view.getHeight()));
    }
}
