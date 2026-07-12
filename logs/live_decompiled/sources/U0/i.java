package U0;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    private final float f2291a;

    public i(float f3) {
        this.f2291a = f3;
    }

    @Override // U0.c
    public float a(RectF rectF) {
        return this.f2291a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f2291a == ((i) obj).f2291a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2291a)});
    }
}
