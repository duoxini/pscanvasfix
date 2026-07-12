package com.coui.component.responsiveui.window;

import D2.k;
import android.content.Context;
import com.coui.component.responsiveui.unit.Dp;

/* loaded from: classes.dex */
public final class LayoutGridWindowSize {

    /* renamed from: a, reason: collision with root package name */
    private int f9375a;

    /* renamed from: b, reason: collision with root package name */
    private int f9376b;

    public LayoutGridWindowSize(int i3, int i4) {
        this.f9375a = i3;
        this.f9376b = i4;
    }

    public static /* synthetic */ LayoutGridWindowSize copy$default(LayoutGridWindowSize layoutGridWindowSize, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = layoutGridWindowSize.f9375a;
        }
        if ((i5 & 2) != 0) {
            i4 = layoutGridWindowSize.f9376b;
        }
        return layoutGridWindowSize.copy(i3, i4);
    }

    public final int component1() {
        return this.f9375a;
    }

    public final int component2() {
        return this.f9376b;
    }

    public final LayoutGridWindowSize copy(int i3, int i4) {
        return new LayoutGridWindowSize(i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LayoutGridWindowSize.class == obj.getClass()) {
            LayoutGridWindowSize layoutGridWindowSize = (LayoutGridWindowSize) obj;
            if (this.f9375a == layoutGridWindowSize.f9375a && this.f9376b == layoutGridWindowSize.f9376b) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.f9376b;
    }

    public final int getWidth() {
        return this.f9375a;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f9375a) * 31) + Integer.hashCode(this.f9376b);
    }

    public final void setHeight(int i3) {
        this.f9376b = i3;
    }

    public final void setWidth(int i3) {
        this.f9375a = i3;
    }

    public String toString() {
        return "(width = " + this.f9375a + ", height = " + this.f9376b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LayoutGridWindowSize(LayoutGridWindowSize layoutGridWindowSize) {
        this(layoutGridWindowSize.f9375a, layoutGridWindowSize.f9376b);
        k.e(layoutGridWindowSize, "windowSize");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LayoutGridWindowSize(Context context, Dp dp, Dp dp2) {
        this((int) dp.toPixel(context), (int) dp2.toPixel(context));
        k.e(context, "context");
        k.e(dp, "width");
        k.e(dp2, "height");
    }
}
