package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
class r {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f4288c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    private final ProgressBar f4289a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f4290b;

    private static class a {
        public static void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i3) {
            layerDrawable2.setLayerGravity(i3, layerDrawable.getLayerGravity(i3));
            layerDrawable2.setLayerWidth(i3, layerDrawable.getLayerWidth(i3));
            layerDrawable2.setLayerHeight(i3, layerDrawable.getLayerHeight(i3));
            layerDrawable2.setLayerInsetLeft(i3, layerDrawable.getLayerInsetLeft(i3));
            layerDrawable2.setLayerInsetRight(i3, layerDrawable.getLayerInsetRight(i3));
            layerDrawable2.setLayerInsetTop(i3, layerDrawable.getLayerInsetTop(i3));
            layerDrawable2.setLayerInsetBottom(i3, layerDrawable.getLayerInsetBottom(i3));
            layerDrawable2.setLayerInsetStart(i3, layerDrawable.getLayerInsetStart(i3));
            layerDrawable2.setLayerInsetEnd(i3, layerDrawable.getLayerInsetEnd(i3));
        }
    }

    r(ProgressBar progressBar) {
        this.f4289a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i3 = 0; i3 < numberOfFrames; i3++) {
            Drawable d3 = d(animationDrawable.getFrame(i3), true);
            d3.setLevel(10000);
            animationDrawable2.addFrame(d3, animationDrawable.getDuration(i3));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    Bitmap b() {
        return this.f4290b;
    }

    void c(AttributeSet attributeSet, int i3) {
        V w3 = V.w(this.f4289a.getContext(), attributeSet, f4288c, i3, 0);
        Drawable h3 = w3.h(0);
        if (h3 != null) {
            this.f4289a.setIndeterminateDrawable(e(h3));
        }
        Drawable h4 = w3.h(1);
        if (h4 != null) {
            this.f4289a.setProgressDrawable(d(h4, false));
        }
        w3.x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    Drawable d(Drawable drawable, boolean z3) {
        if (drawable instanceof androidx.core.graphics.drawable.b) {
            androidx.core.graphics.drawable.b bVar = (androidx.core.graphics.drawable.b) drawable;
            Drawable a3 = bVar.a();
            if (a3 != null) {
                bVar.b(d(a3, z3));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    int id = layerDrawable.getId(i3);
                    drawableArr[i3] = d(layerDrawable.getDrawable(i3), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i4 = 0; i4 < numberOfLayers; i4++) {
                    layerDrawable2.setId(i4, layerDrawable.getId(i4));
                    a.a(layerDrawable, layerDrawable2, i4);
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f4290b == null) {
                    this.f4290b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(a());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z3 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }
}
