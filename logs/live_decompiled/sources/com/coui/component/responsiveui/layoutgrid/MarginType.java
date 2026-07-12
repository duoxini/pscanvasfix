package com.coui.component.responsiveui.layoutgrid;

import a2.AbstractC0226a;

/* loaded from: classes.dex */
public enum MarginType {
    MARGIN_SMALL(AbstractC0226a.f3345f, AbstractC0226a.f3349j, AbstractC0226a.f3347h),
    MARGIN_LARGE(AbstractC0226a.f3344e, AbstractC0226a.f3348i, AbstractC0226a.f3346g);


    /* renamed from: e, reason: collision with root package name */
    private final int[] f9345e;

    MarginType(int i3, int i4, int i5) {
        this.f9345e = new int[]{i3, i4, i5};
    }

    public final int[] resId() {
        return this.f9345e;
    }
}
