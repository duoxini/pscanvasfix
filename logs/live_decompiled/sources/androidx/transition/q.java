package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: classes.dex */
abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f6746a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f6747b = true;

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f6748c = true;

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        y.i(view, matrix);
        y.j(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b3 = b(view, matrix, rectF, viewGroup);
        if (b3 != null) {
            imageView.setImageBitmap(b3);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z3;
        boolean z4;
        int i3;
        ViewGroup viewGroup2;
        if (f6746a) {
            z3 = !view.isAttachedToWindow();
            z4 = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z3 = false;
            z4 = false;
        }
        boolean z5 = f6747b;
        Bitmap bitmap = null;
        if (!z5 || !z3) {
            i3 = 0;
            viewGroup2 = null;
        } else {
            if (!z4) {
                return null;
            }
            viewGroup2 = (ViewGroup) view.getParent();
            i3 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / (round * round2));
            int round3 = Math.round(round * min);
            int round4 = Math.round(round2 * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (f6748c) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z5 && z3) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i3);
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
