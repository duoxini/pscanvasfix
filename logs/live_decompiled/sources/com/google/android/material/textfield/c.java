package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* loaded from: classes.dex */
class c extends U0.g {

    /* renamed from: D, reason: collision with root package name */
    private final Paint f9877D;

    /* renamed from: E, reason: collision with root package name */
    private final RectF f9878E;

    c(U0.k kVar) {
        super(kVar == null ? new U0.k() : kVar);
        this.f9877D = new Paint(1);
        k0();
        this.f9878E = new RectF();
    }

    private void k0() {
        this.f9877D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f9877D.setColor(-1);
        this.f9877D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    boolean g0() {
        return !this.f9878E.isEmpty();
    }

    void h0() {
        i0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void i0(float f3, float f4, float f5, float f6) {
        RectF rectF = this.f9878E;
        if (f3 == rectF.left && f4 == rectF.top && f5 == rectF.right && f6 == rectF.bottom) {
            return;
        }
        rectF.set(f3, f4, f5, f6);
        invalidateSelf();
    }

    void j0(RectF rectF) {
        i0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // U0.g
    protected void q(Canvas canvas) {
        if (this.f9878E.isEmpty()) {
            super.q(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.f9878E);
        super.q(canvas);
        canvas.restore();
    }
}
