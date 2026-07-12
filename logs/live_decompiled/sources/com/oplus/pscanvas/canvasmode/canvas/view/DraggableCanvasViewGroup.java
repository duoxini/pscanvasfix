package com.oplus.pscanvas.canvasmode.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class DraggableCanvasViewGroup extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private final float f10854e;

    /* renamed from: f, reason: collision with root package name */
    private float f10855f;

    /* renamed from: g, reason: collision with root package name */
    private final float f10856g;

    /* renamed from: h, reason: collision with root package name */
    private final float f10857h;

    public DraggableCanvasViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(float f3, float f4, float f5, float f6, float f7) {
        float min = Math.min(f3 * 0.5f, f4 * 0.5f);
        this.f10855f = min;
        if (f5 < min) {
            f6 = getTranslationX();
            f7 = getTranslationY();
            f5 = min;
        }
        setTranslationX(f6);
        setTranslationY(f7);
        setScaleX(f5);
        setScaleY(f5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        setPivotX(0.0f);
        if (B1.s.J(((FrameLayout) this).mContext) && B1.l.u0()) {
            setPivotY(B1.l.O1(((FrameLayout) this).mContext).G0());
        } else {
            setPivotY(0.0f);
        }
    }

    @Override // android.view.View
    public String toString() {
        return super.toString() + ",getTranslationX():" + getTranslationX() + ",getTranslationY():" + getTranslationY() + ",getScaleX():" + getScaleX() + ",getScaleY():" + getScaleY();
    }

    public DraggableCanvasViewGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10856g = 0.01f;
        this.f10857h = 0.5f;
        this.f10854e = context.getResources().getDimension(t1.d.f13376e);
        setClipChildren(false);
    }
}
