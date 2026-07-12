package B1;

import android.graphics.Rect;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.List;
import u1.C0600c;

/* loaded from: classes.dex */
public interface m {
    void a(List list, float f3, float f4, float f5, float f6, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Rect rect, ContainerView containerView);

    Rect b(int i3, float f3, ContainerView containerView, int i4);

    int c(C0600c c0600c, int i3, int i4, boolean z3);

    default boolean d(ContainerView containerView, E.c cVar, float f3, float f4) {
        return false;
    }

    default void e(List list, float f3, float f4, ContainerView containerView, E.c cVar) {
    }

    default void f(ContainerView containerView, int i3, int i4, E.c cVar) {
    }

    void g(List list, int i3, int i4, float f3, float f4, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, ContainerView containerView);

    void h(Rect rect, ContainerView containerView);
}
