package com.coui.appcompat.searchview;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.oplus.graphics.OplusPathAdapter;
import n0.AbstractC0481a;

/* loaded from: classes.dex */
class o extends Drawable {

    /* renamed from: j, reason: collision with root package name */
    private static final ArgbEvaluator f9203j = new ArgbEvaluator();

    /* renamed from: a, reason: collision with root package name */
    private final Rect f9204a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Path f9205b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f9206c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f9207d;

    /* renamed from: e, reason: collision with root package name */
    private int f9208e;

    /* renamed from: f, reason: collision with root package name */
    private int f9209f;

    /* renamed from: g, reason: collision with root package name */
    private float f9210g;

    /* renamed from: h, reason: collision with root package name */
    private OplusPathAdapter f9211h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f9212i;

    public o() {
        Path path = new Path();
        this.f9205b = path;
        this.f9206c = new Paint(1);
        this.f9207d = new Paint(1);
        this.f9210g = 0.0f;
        if (c()) {
            this.f9211h = new OplusPathAdapter(path, 1);
            this.f9212i = new RectF();
        }
    }

    private boolean c() {
        return AbstractC0481a.a() == 1;
    }

    int a() {
        return this.f9208e;
    }

    Path b() {
        return this.f9205b;
    }

    void d(Rect rect) {
        if (c()) {
            this.f9212i.set(rect);
            this.f9205b.reset();
            OplusPathAdapter oplusPathAdapter = this.f9211h;
            RectF rectF = this.f9212i;
            oplusPathAdapter.addSmoothRoundRect(rectF, rectF.height() / 2.0f, this.f9212i.height() / 2.0f, Path.Direction.CCW);
        } else {
            m0.c.b(this.f9205b, new RectF(rect), (rect.bottom - rect.top) / 2.0f, true, true, true, true);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (c()) {
            canvas.save();
            canvas.clipPath(this.f9205b);
            this.f9206c.setStyle(Paint.Style.FILL);
            this.f9206c.setColor(this.f9208e);
            canvas.drawColor(this.f9206c.getColor());
            canvas.restore();
        } else {
            this.f9206c.setStyle(Paint.Style.FILL);
            this.f9206c.setColor(this.f9208e);
            canvas.drawPath(this.f9205b, this.f9206c);
        }
        this.f9207d.setColor(((Integer) f9203j.evaluate(this.f9210g, 0, Integer.valueOf(this.f9209f))).intValue());
        canvas.drawRect(this.f9204a, this.f9207d);
    }

    void e(int i3) {
        this.f9209f = i3;
        invalidateSelf();
    }

    void f(int i3) {
        this.f9208e = i3;
        invalidateSelf();
    }

    void g(float f3) {
        this.f9210g = f3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    void h(Rect rect) {
        this.f9204a.set(rect);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }
}
