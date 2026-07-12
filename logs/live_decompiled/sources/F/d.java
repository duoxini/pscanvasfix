package F;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f388a;

    /* renamed from: b, reason: collision with root package name */
    private final float f389b;

    protected d(float[] fArr) {
        this.f388a = fArr;
        this.f389b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f388a;
        int min = Math.min((int) ((fArr.length - 1) * f3), fArr.length - 2);
        float f4 = this.f389b;
        float f5 = (f3 - (min * f4)) / f4;
        float[] fArr2 = this.f388a;
        float f6 = fArr2[min];
        return f6 + (f5 * (fArr2[min + 1] - f6));
    }
}
