package com.coui.component.responsiveui.unit;

import D2.g;
import D2.k;
import android.content.Context;

/* loaded from: classes.dex */
public final class Dp {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final float f9372a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Dp pixel2Dp(Context context, int i3) {
            k.e(context, "context");
            return DpKt.pixel2Dp(i3, context);
        }

        private Companion() {
        }
    }

    public Dp(float f3) {
        this.f9372a = f3;
    }

    public final int compareTo(Dp dp) {
        k.e(dp, "other");
        return Float.compare(this.f9372a, dp.f9372a);
    }

    public final Dp div(Dp dp) {
        k.e(dp, "other");
        return new Dp(this.f9372a / dp.f9372a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Dp.class == obj.getClass() && Float.compare(this.f9372a, ((Dp) obj).f9372a) == 0;
    }

    public final float getValue() {
        return this.f9372a;
    }

    public int hashCode() {
        return Float.hashCode(this.f9372a);
    }

    public final Dp minus(Dp dp) {
        k.e(dp, "other");
        return new Dp(this.f9372a - dp.f9372a);
    }

    public final Dp plus(Dp dp) {
        k.e(dp, "other");
        return new Dp(this.f9372a + dp.f9372a);
    }

    public final float toPixel(Context context) {
        k.e(context, "context");
        return this.f9372a * context.getResources().getDisplayMetrics().density;
    }

    public String toString() {
        return this.f9372a + " dp";
    }
}
