package x0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
abstract class e {
    private static Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Drawable b(Context context, Drawable drawable, float f3, boolean z3) {
        Bitmap a3 = a(drawable);
        Matrix matrix = new Matrix();
        if (z3) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.postRotate(f3);
        return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(a3, 0, 0, a3.getWidth(), a3.getHeight(), matrix, true));
    }
}
