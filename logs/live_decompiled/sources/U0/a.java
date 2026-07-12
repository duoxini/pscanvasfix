package U0;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final float f2237a;

    public a(float f3) {
        this.f2237a = f3;
    }

    @Override // U0.c
    public float a(RectF rectF) {
        return this.f2237a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f2237a == ((a) obj).f2237a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2237a)});
    }
}
