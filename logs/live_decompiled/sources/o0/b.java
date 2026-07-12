package o0;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public interface b {
    float a();

    void abortAnimation();

    int b();

    int c();

    boolean computeScrollOffset();

    void d(Interpolator interpolator);

    void e(float f3);

    float f();

    void fling(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    void fling(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    boolean g();

    int h();

    int i();

    void j(float f3);

    void notifyHorizontalEdgeReached(int i3, int i4, int i5);

    void notifyVerticalEdgeReached(int i3, int i4, int i5);

    void setFinalX(int i3);

    boolean springBack(int i3, int i4, int i5, int i6, int i7, int i8);

    void startScroll(int i3, int i4, int i5, int i6);

    void startScroll(int i3, int i4, int i5, int i6, int i7);
}
