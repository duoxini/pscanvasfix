package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class n {
    static int a(RecyclerView.B b3, k kVar, View view, View view2, RecyclerView.p pVar, boolean z3) {
        if (pVar.J() == 0 || b3.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return Math.abs(pVar.j0(view) - pVar.j0(view2)) + 1;
        }
        return Math.min(kVar.o(), kVar.d(view2) - kVar.g(view));
    }

    static int b(RecyclerView.B b3, k kVar, View view, View view2, RecyclerView.p pVar, boolean z3, boolean z4) {
        if (pVar.J() == 0 || b3.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z4 ? Math.max(0, (b3.b() - Math.max(pVar.j0(view), pVar.j0(view2))) - 1) : Math.max(0, Math.min(pVar.j0(view), pVar.j0(view2)));
        if (z3) {
            return Math.round((max * (Math.abs(kVar.d(view2) - kVar.g(view)) / (Math.abs(pVar.j0(view) - pVar.j0(view2)) + 1))) + (kVar.n() - kVar.g(view)));
        }
        return max;
    }

    static int c(RecyclerView.B b3, k kVar, View view, View view2, RecyclerView.p pVar, boolean z3) {
        if (pVar.J() == 0 || b3.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return b3.b();
        }
        return (int) (((kVar.d(view2) - kVar.g(view)) / (Math.abs(pVar.j0(view) - pVar.j0(view2)) + 1)) * b3.b());
    }
}
