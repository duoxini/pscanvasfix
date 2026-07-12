package B1;

import android.content.ComponentName;
import android.content.Intent;
import com.oplus.pscanvas.canvasmode.canvas.r0;
import u1.C0601d;

/* loaded from: classes.dex */
public abstract class f {
    public static final String a(r0 r0Var) {
        Intent f3;
        ComponentName component;
        D2.k.e(r0Var, "<this>");
        C0601d o3 = r0Var.o();
        String flattenToString = (o3 == null || (f3 = o3.f()) == null || (component = f3.getComponent()) == null) ? null : component.flattenToString();
        return flattenToString == null ? "" : flattenToString;
    }
}
