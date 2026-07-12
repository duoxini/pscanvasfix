package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class D extends C {
    D() {
    }

    @Override // androidx.transition.E
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.E
    public void d(View view, int i3, int i4, int i5, int i6) {
        view.setLeftTopRightBottom(i3, i4, i5, i6);
    }

    @Override // androidx.transition.E
    public void e(View view, float f3) {
        view.setTransitionAlpha(f3);
    }

    @Override // androidx.transition.E
    public void f(View view, int i3) {
        view.setTransitionVisibility(i3);
    }

    @Override // androidx.transition.E
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.E
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
