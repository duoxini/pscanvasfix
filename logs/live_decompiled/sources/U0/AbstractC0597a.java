package u0;

import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.widget.TextView;
import h0.AbstractC0371a;
import z0.AbstractC0647b;

/* renamed from: u0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0597a {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f13765a = {0.9f, 1.0f, 1.15f, 1.35f, 1.6f};

    public static void a(Paint paint, boolean z3) {
        if (paint != null) {
            if (AbstractC0647b.c() < 12) {
                paint.setFakeBoldText(z3);
            } else {
                paint.setTypeface(z3 ? Typeface.create("sans-serif-medium", 0) : Typeface.DEFAULT);
            }
        }
    }

    public static void b(TextView textView, int i3) {
        float textSize = textView.getTextSize();
        Configuration configuration = textView.getResources().getConfiguration();
        textView.getResources().getDisplayMetrics();
        float f3 = configuration.fontScale;
        int i4 = configuration.densityDpi;
        if (i4 == 300 || i4 == 296 || configuration.smallestScreenWidthDp <= 210) {
            f3 = 1.0f;
        }
        textView.setTextSize(0, e(textSize, f3, i3));
    }

    public static int c(TextView textView, int i3, int i4, int i5, int i6) {
        if (i3 <= 0) {
            AbstractC0371a.c("COUIChangeTextUtil", "Line count should be greater than 0!");
            return 0;
        }
        if (i4 < 0 || i5 < 0) {
            AbstractC0371a.c("COUIChangeTextUtil", "Width should be greater than 0!");
            return 0;
        }
        if (i4 > i5) {
            AbstractC0371a.c("COUIChangeTextUtil", "Max width should be greater than min width!");
            return 0;
        }
        if (i6 < 0) {
            AbstractC0371a.c("COUIChangeTextUtil", "Padding should be greater than 0!");
            return 0;
        }
        int i7 = i4 - i6;
        int i8 = i5 - i6;
        if (i7 < 0) {
            AbstractC0371a.c("COUIChangeTextUtil", "Min width should be greater than horizontal padding!");
            return 0;
        }
        int i9 = (i7 + i8) / 2;
        while (i7 <= i8) {
            i9 = (i7 + i8) / 2;
            int f3 = f(textView, i9, 0);
            int i10 = i9 - 1;
            int f4 = f(textView, i10, 0);
            if (f3 <= i3 && f4 > i3) {
                break;
            }
            if (f4 <= i3) {
                i8 = i10;
            } else {
                i7 = i9 + 1;
            }
        }
        return i9 + i6;
    }

    public static float d(float f3, float f4) {
        return f4 < 1.15f ? f3 * 1.0f : f3 * 1.15f;
    }

    public static float e(float f3, float f4, int i3) {
        if (i3 < 2) {
            return f3;
        }
        float[] fArr = f13765a;
        if (i3 > fArr.length) {
            i3 = fArr.length;
        }
        float round = Math.round(f3 / f4);
        if (i3 == 2) {
            return f4 < 1.15f ? round * 1.0f : round * 1.15f;
        }
        if (i3 == 3) {
            return f4 < 1.15f ? round * 1.0f : f4 < 1.6f ? round * 1.15f : round * 1.35f;
        }
        float f5 = fArr[i3 - 1];
        return f4 > f5 ? round * f5 : round * f4;
    }

    public static int f(TextView textView, int i3, int i4) {
        if (i4 < 0 || i3 <= i4) {
            AbstractC0371a.c("COUIChangeTextUtil", "Illegal width or padding!");
            return 0;
        }
        if (textView == null) {
            return 0;
        }
        return StaticLayout.Builder.obtain(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i3 - i4).setAlignment(Layout.Alignment.ALIGN_CENTER).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).build().getLineCount();
    }
}
