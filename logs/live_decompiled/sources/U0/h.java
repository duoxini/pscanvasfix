package U0;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
public abstract class h {
    static d a(int i3) {
        return i3 != 0 ? i3 != 1 ? b() : new e() : new j();
    }

    static d b() {
        return new j();
    }

    static f c() {
        return new f();
    }

    public static void d(View view, float f3) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).T(f3);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.M()) {
            gVar.X(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
