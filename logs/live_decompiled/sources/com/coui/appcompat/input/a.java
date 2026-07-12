package com.coui.appcompat.input;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    List f8077a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    List f8078b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    int f8079c;

    /* renamed from: d, reason: collision with root package name */
    int f8080d;

    public a(int i3, int i4) {
        this.f8079c = i3;
        this.f8080d = i4;
    }

    public void a(float f3, float f4, float f5, int i3, int i4, float f6, Path path) {
        Paint paint = new Paint();
        paint.setColor(i4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f6);
        paint.setShadowLayer(f3, f4, f5, i3);
        this.f8077a.add(paint);
        this.f8078b.add(path);
    }

    public Bitmap b() {
        Bitmap createBitmap = Bitmap.createBitmap(this.f8079c, this.f8080d, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        for (int i3 = 0; i3 < this.f8078b.size(); i3++) {
            if (this.f8078b.get(i3) != null && this.f8077a.get(i3) != null) {
                canvas.clipPath((Path) this.f8078b.get(i3));
                canvas.drawPath((Path) this.f8078b.get(i3), (Paint) this.f8077a.get(i3));
            }
        }
        canvas.restoreToCount(saveLayer);
        return createBitmap;
    }

    public void c() {
        List list = this.f8077a;
        if (list != null) {
            list.clear();
        }
        List list2 = this.f8078b;
        if (list2 != null) {
            list2.clear();
        }
    }
}
