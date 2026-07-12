package T0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: classes.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f2181i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f2182j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f2183k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f2184l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f2185a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f2186b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f2187c;

    /* renamed from: d, reason: collision with root package name */
    private int f2188d;

    /* renamed from: e, reason: collision with root package name */
    private int f2189e;

    /* renamed from: f, reason: collision with root package name */
    private int f2190f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f2191g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f2192h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i3, float f3, float f4) {
        boolean z3 = f4 < 0.0f;
        Path path = this.f2191g;
        if (z3) {
            int[] iArr = f2183k;
            iArr[0] = 0;
            iArr[1] = this.f2190f;
            iArr[2] = this.f2189e;
            iArr[3] = this.f2188d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f3, f4);
            path.close();
            float f5 = -i3;
            rectF.inset(f5, f5);
            int[] iArr2 = f2183k;
            iArr2[0] = 0;
            iArr2[1] = this.f2188d;
            iArr2[2] = this.f2189e;
            iArr2[3] = this.f2190f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f6 = 1.0f - (i3 / width);
        float[] fArr = f2184l;
        fArr[1] = f6;
        fArr[2] = ((1.0f - f6) / 2.0f) + f6;
        this.f2186b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f2183k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z3) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f2192h);
        }
        canvas.drawArc(rectF, f3, f4, true, this.f2186b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i3) {
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = f2181i;
        iArr[0] = this.f2190f;
        iArr[1] = this.f2189e;
        iArr[2] = this.f2188d;
        Paint paint = this.f2187c;
        float f3 = rectF.left;
        paint.setShader(new LinearGradient(f3, rectF.top, f3, rectF.bottom, iArr, f2182j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f2187c);
        canvas.restore();
    }

    public Paint c() {
        return this.f2185a;
    }

    public void d(int i3) {
        this.f2188d = androidx.core.graphics.a.n(i3, 68);
        this.f2189e = androidx.core.graphics.a.n(i3, 20);
        this.f2190f = androidx.core.graphics.a.n(i3, 0);
        this.f2185a.setColor(this.f2188d);
    }

    public a(int i3) {
        this.f2191g = new Path();
        this.f2192h = new Paint();
        this.f2185a = new Paint();
        d(i3);
        this.f2192h.setColor(0);
        Paint paint = new Paint(4);
        this.f2186b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2187c = new Paint(paint);
    }
}
