package m1;

import a1.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import c1.u;
import com.oplus.wrapper.os.Debug;
import com.oplus.wrapper.os.SystemProperties;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* renamed from: m1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0465h {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f12423a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f12424b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal f12425c = new c();

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f12426d = new d();

    /* renamed from: e, reason: collision with root package name */
    private static final float f12427e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: m1.h$a */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* renamed from: m1.h$b */
    class b extends ThreadLocal {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* renamed from: m1.h$c */
    class c extends ThreadLocal {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* renamed from: m1.h$d */
    class d extends ThreadLocal {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static void a(Path path, float f3, float f4, float f5) {
        v.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = (PathMeasure) f12423a.get();
        Path path2 = (Path) f12424b.get();
        Path path3 = (Path) f12425c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f3 == 1.0f && f4 == 0.0f) {
            v.b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f4 - f3) - 1.0f) < 0.01d) {
            v.b("applyTrimPathIfNeeded");
            return;
        }
        float f6 = f3 * length;
        float f7 = f4 * length;
        float f8 = f5 * length;
        float min = Math.min(f6, f7) + f8;
        float max = Math.max(f6, f7) + f8;
        if (min >= length && max >= length) {
            min = AbstractC0464g.f(min, length);
            max = AbstractC0464g.f(max, length);
        }
        if (min < 0.0f) {
            min = AbstractC0464g.f(min, length);
        }
        if (max < 0.0f) {
            max = AbstractC0464g.f(max, length);
        }
        if (min == max) {
            path.reset();
            v.b("applyTrimPathIfNeeded");
            return;
        }
        if (min >= max) {
            min -= length;
        }
        path2.reset();
        pathMeasure.getSegment(min, max, path2, true);
        if (max > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, max % length, path3, true);
            path2.addPath(path3);
        } else if (min < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(min + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        v.b("applyTrimPathIfNeeded");
    }

    public static void b(Path path, u uVar) {
        if (uVar == null || uVar.m()) {
            return;
        }
        a(path, ((d1.d) uVar.k()).p() / 100.0f, ((d1.d) uVar.g()).p() / 100.0f, ((d1.d) uVar.h()).p() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f3 = pointF3.x + pointF.x;
            float f4 = pointF.y + pointF3.y;
            float f5 = pointF2.x;
            float f6 = f5 + pointF4.x;
            float f7 = pointF2.y;
            path.cubicTo(f3, f4, f6, f7 + pointF4.y, f5, f7);
        }
        return path;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static String g() {
        try {
            return SystemProperties.getBoolean("persist.sys.assert.panic", false) ? Debug.getCallers(20) : "";
        } catch (Error | Exception unused) {
            return "";
        }
    }

    public static float h(Matrix matrix) {
        float[] fArr = (float[]) f12426d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f3 = f12427e;
        fArr[2] = f3;
        fArr[3] = f3;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean i(Matrix matrix) {
        float[] fArr = (float[]) f12426d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int j(float f3, float f4, float f5, float f6) {
        int i3 = f3 != 0.0f ? (int) (527 * f3) : 17;
        if (f4 != 0.0f) {
            i3 = (int) (i3 * 31 * f4);
        }
        if (f5 != 0.0f) {
            i3 = (int) (i3 * 31 * f5);
        }
        return f6 != 0.0f ? (int) (i3 * 31 * f6) : i3;
    }

    public static boolean k(int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 < i6) {
            return false;
        }
        if (i3 > i6) {
            return true;
        }
        if (i4 < i7) {
            return false;
        }
        return i4 > i7 || i5 >= i8;
    }

    public static boolean l(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static Bitmap m(Bitmap bitmap, int i3, int i4) {
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i4) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i4, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean n(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.endsWith(str2);
    }

    public static void o(Canvas canvas, RectF rectF, Paint paint) {
        p(canvas, rectF, paint, 31);
    }

    public static void p(Canvas canvas, RectF rectF, Paint paint, int i3) {
        v.a("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        v.b("Utils#saveLayer");
    }
}
