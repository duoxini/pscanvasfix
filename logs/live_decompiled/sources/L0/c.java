package l0;

import android.graphics.drawable.Drawable;
import android.view.View;
import e0.AbstractC0342a;
import r0.C0560b;
import r0.C0561c;

/* loaded from: classes.dex */
public abstract class c {
    public static void a(View view, int i3) {
        if (view == null) {
            return;
        }
        C0560b c0560b = new C0560b(view.getContext());
        c0560b.v(i3);
        view.setBackground(new C0561c(new Drawable[]{c0560b}));
        AbstractC0342a.b(view, false);
    }

    public static void b(View view, int i3, boolean z3) {
        if (view == null) {
            return;
        }
        view.setBackground(new b(view.getContext(), i3, z3));
    }
}
