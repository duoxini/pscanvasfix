package w0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0616b {
    public static Bitmap a(Bitmap bitmap, int i3) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        createBitmap.setDensity(bitmap.getDensity());
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
