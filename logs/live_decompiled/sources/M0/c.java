package m0;

import android.graphics.Path;
import android.graphics.RectF;
import com.oplus.graphics.OplusPath;
import com.oplus.graphics.OplusPathAdapter;
import n0.AbstractC0481a;

/* loaded from: classes.dex */
public abstract class c {
    public static Path a(Path path, RectF rectF, float f3) {
        return b(path, rectF, f3, true, true, true, true);
    }

    public static Path b(Path path, RectF rectF, float f3, boolean z3, boolean z4, boolean z5, boolean z6) {
        float f4;
        float f5;
        float f6 = f3 < 0.0f ? 0.0f : f3;
        path.reset();
        float f7 = rectF.left;
        float f8 = rectF.right;
        float f9 = rectF.bottom;
        float f10 = rectF.top;
        float f11 = f8 - f7;
        float f12 = f9 - f10;
        float f13 = f11 / 2.0f;
        float f14 = f12 / 2.0f;
        float min = ((double) (f6 / Math.min(f13, f14))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f6 / Math.min(f13, f14)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float min2 = f6 / Math.min(f13, f14) > 0.6f ? 1.0f + (Math.min(1.0f, ((f6 / Math.min(f13, f14)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f7 + f13, f10);
        if (z4) {
            float f15 = f6 / 100.0f;
            float f16 = f15 * 128.19f * min;
            path.lineTo(Math.max(f13, f11 - f16) + f7, f10);
            float f17 = f7 + f11;
            float f18 = f15 * 83.62f * min2;
            float f19 = f15 * 67.45f;
            float f20 = f15 * 4.64f;
            float f21 = f15 * 51.16f;
            float f22 = f15 * 13.36f;
            f4 = f13;
            path.cubicTo(f17 - f18, f10, f17 - f19, f10 + f20, f17 - f21, f10 + f22);
            float f23 = f15 * 34.86f;
            float f24 = f15 * 22.07f;
            path.cubicTo(f17 - f23, f10 + f24, f17 - f24, f10 + f23, f17 - f22, f10 + f21);
            path.cubicTo(f17 - f20, f10 + f19, f17, f10 + f18, f17, f10 + Math.min(f14, f16));
        } else {
            path.lineTo(f7 + f11, f10);
            f4 = f13;
        }
        if (z6) {
            float f25 = f7 + f11;
            float f26 = f6 / 100.0f;
            float f27 = f26 * 128.19f * min;
            path.lineTo(f25, Math.max(f14, f12 - f27) + f10);
            float f28 = f10 + f12;
            float f29 = f26 * 83.62f * min2;
            float f30 = f26 * 4.64f;
            float f31 = f26 * 67.45f;
            float f32 = f26 * 13.36f;
            float f33 = f26 * 51.16f;
            path.cubicTo(f25, f28 - f29, f25 - f30, f28 - f31, f25 - f32, f28 - f33);
            float f34 = f26 * 22.07f;
            float f35 = f26 * 34.86f;
            path.cubicTo(f25 - f34, f28 - f35, f25 - f35, f28 - f34, f25 - f33, f28 - f32);
            float f36 = f25 - f29;
            f5 = f4;
            path.cubicTo(f25 - f31, f28 - f30, f36, f28, f7 + Math.max(f5, f11 - f27), f28);
        } else {
            path.lineTo(f11 + f7, f10 + f12);
            f5 = f4;
        }
        if (z5) {
            float f37 = f6 / 100.0f;
            float f38 = f37 * 128.19f * min;
            float f39 = f10 + f12;
            path.lineTo(Math.min(f5, f38) + f7, f39);
            float f40 = f37 * 83.62f * min2;
            float f41 = f37 * 67.45f;
            float f42 = f37 * 4.64f;
            float f43 = f37 * 51.16f;
            float f44 = f37 * 13.36f;
            path.cubicTo(f7 + f40, f39, f7 + f41, f39 - f42, f7 + f43, f39 - f44);
            float f45 = f37 * 34.86f;
            float f46 = f37 * 22.07f;
            path.cubicTo(f7 + f45, f39 - f46, f7 + f46, f39 - f45, f7 + f44, f39 - f43);
            path.cubicTo(f7 + f42, f39 - f41, f7, f39 - f40, f7, f10 + Math.max(f14, f12 - f38));
        } else {
            path.lineTo(f7, f12 + f10);
        }
        if (z3) {
            float f47 = f6 / 100.0f;
            float f48 = 128.19f * f47 * min;
            path.lineTo(f7, Math.min(f14, f48) + f10);
            float f49 = 83.62f * f47 * min2;
            float f50 = 4.64f * f47;
            float f51 = 67.45f * f47;
            float f52 = 13.36f * f47;
            float f53 = 51.16f * f47;
            path.cubicTo(f7, f10 + f49, f7 + f50, f10 + f51, f7 + f52, f10 + f53);
            float f54 = 22.07f * f47;
            float f55 = f47 * 34.86f;
            path.cubicTo(f7 + f54, f10 + f55, f7 + f55, f10 + f54, f7 + f53, f10 + f52);
            path.cubicTo(f7 + f51, f10 + f50, f7 + f49, f10, f7 + Math.min(f5, f48), f10);
        } else {
            path.lineTo(f7, f10);
        }
        path.close();
        return path;
    }

    public static Path c(Path path, RectF rectF, float f3, float f4) {
        return d(path, rectF, f3, f4, true, true, true, true);
    }

    public static Path d(Path path, RectF rectF, float f3, float f4, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (path != null && rectF != null) {
            float[] fArr = new float[8];
            path.reset();
            float f5 = z3 ? f3 : 0.0f;
            float f6 = z4 ? f3 : 0.0f;
            float f7 = z5 ? f3 : 0.0f;
            if (!z6) {
                f3 = 0.0f;
            }
            fArr[1] = f5;
            fArr[0] = f5;
            fArr[3] = f6;
            fArr[2] = f6;
            fArr[5] = f7;
            fArr[4] = f7;
            fArr[7] = f3;
            fArr[6] = f3;
            if (!e(f4)) {
                path.addRoundRect(rectF, fArr, Path.Direction.CW);
            } else if (AbstractC0481a.a() == 1) {
                new OplusPathAdapter(path, 1).addSmoothRoundRect(rectF, fArr, Path.Direction.CW);
            } else {
                new OplusPath(path).addSmoothRoundRect(rectF, fArr, Path.Direction.CW, f4);
            }
        }
        return path;
    }

    private static boolean e(float f3) {
        return f3 != 0.0f;
    }
}
