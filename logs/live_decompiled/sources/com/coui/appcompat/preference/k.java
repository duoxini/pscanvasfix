package com.coui.appcompat.preference;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* loaded from: classes.dex */
public class k extends U0.g {

    /* renamed from: D, reason: collision with root package name */
    private float f8805D;

    /* renamed from: E, reason: collision with root package name */
    private int f8806E;

    /* renamed from: F, reason: collision with root package name */
    private Paint f8807F = new Paint(1);

    /* renamed from: G, reason: collision with root package name */
    private Path f8808G = new Path();

    public k(float f3, int i3) {
        this.f8805D = f3;
        this.f8806E = i3;
        this.f8807F.setColor(this.f8806E);
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f8808G.reset();
        Path b3 = m0.b.a().b(getBounds(), this.f8805D);
        this.f8808G = b3;
        canvas.drawPath(b3, this.f8807F);
    }
}
