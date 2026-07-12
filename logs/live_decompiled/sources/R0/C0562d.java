package r0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import d0.AbstractC0335a;

/* renamed from: r0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0562d extends j {

    /* renamed from: f, reason: collision with root package name */
    private final Paint f13179f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f13180g;

    /* renamed from: h, reason: collision with root package name */
    private final i f13181h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f13182i;

    /* renamed from: j, reason: collision with root package name */
    private Path f13183j;

    /* renamed from: k, reason: collision with root package name */
    private float f13184k;

    /* renamed from: l, reason: collision with root package name */
    private float f13185l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13186m;

    /* renamed from: n, reason: collision with root package name */
    private int f13187n;

    public C0562d(Context context) {
        super("COUIStrokeDrawable");
        Paint paint = new Paint(1);
        this.f13179f = paint;
        this.f13180g = new Path();
        this.f13186m = true;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimensionPixelOffset(M1.f.f1435b0) * 2);
        i iVar = new i(this, "focus", 0, AbstractC0335a.a(context, M1.c.f1367l));
        this.f13181h = iVar;
        iVar.k(0.0f);
        iVar.l(0.3f);
        this.f13187n = 0;
    }

    @Override // r0.j, r0.InterfaceC0564f
    public void a(int i3, boolean z3, boolean z4, boolean z5) {
        super.a(i3, z3, z4, z5);
        if (i3 == 16842908) {
            this.f13181h.d(z4 ? 10000.0f : 0.0f, z5);
        }
    }

    @Override // r0.InterfaceC0564f
    public void d(int i3) {
        if (i3 == 16842910 && !m()) {
            this.f13181h.d(0.0f, false);
        } else if (m() && i3 == 16842908) {
            this.f13181h.d(n() ? 10000.0f : 0.0f, this.f13186m);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!l() || this.f13181h.g() == 0) {
            return;
        }
        this.f13179f.setColor(this.f13181h.g());
        canvas.save();
        Path path = this.f13183j;
        if (path != null) {
            if (this.f13187n == 1) {
                canvas.clipPath(path);
            } else {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
            }
            canvas.drawPath(this.f13183j, this.f13179f);
        } else if (this.f13182i != null) {
            this.f13180g.reset();
            this.f13180g.addRoundRect(this.f13182i, this.f13184k, this.f13185l, Path.Direction.CCW);
            if (this.f13187n == 1) {
                canvas.clipPath(this.f13180g);
            } else {
                canvas.clipPath(this.f13180g, Region.Op.DIFFERENCE);
            }
            canvas.drawPath(this.f13180g, this.f13179f);
        } else {
            Rect bounds = getBounds();
            float max = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
            this.f13180g.reset();
            this.f13180g.addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, Path.Direction.CCW);
            if (this.f13187n == 1) {
                canvas.clipPath(this.f13180g);
            } else {
                canvas.clipPath(this.f13180g, Region.Op.DIFFERENCE);
            }
            canvas.drawPath(this.f13180g, this.f13179f);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // r0.InterfaceC0565g
    public void i(boolean z3) {
        this.f13186m = z3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override // r0.InterfaceC0565g
    public void j() {
        this.f13181h.d(0.0f, false);
    }

    @Override // r0.j
    public void s(boolean z3) {
        super.s(z3);
        if (z3) {
            return;
        }
        this.f13181h.d(0.0f, false);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void v(Path path) {
        this.f13183j = path;
    }

    public void w(RectF rectF, float f3, float f4) {
        this.f13182i = rectF;
        this.f13184k = f3;
        this.f13185l = f4;
    }
}
