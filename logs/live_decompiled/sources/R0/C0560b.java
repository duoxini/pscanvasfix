package r0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import d0.AbstractC0335a;
import h0.AbstractC0371a;

/* renamed from: r0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0560b extends h {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f13162r = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f13163s = {R.attr.state_enabled};

    /* renamed from: f, reason: collision with root package name */
    private final Path f13164f;

    /* renamed from: g, reason: collision with root package name */
    private final i f13165g;

    /* renamed from: h, reason: collision with root package name */
    private final i f13166h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f13167i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f13168j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13169k;

    /* renamed from: l, reason: collision with root package name */
    private int f13170l;

    /* renamed from: m, reason: collision with root package name */
    private int f13171m;

    /* renamed from: n, reason: collision with root package name */
    private Path f13172n;

    /* renamed from: o, reason: collision with root package name */
    private RectF f13173o;

    /* renamed from: p, reason: collision with root package name */
    private float f13174p;

    /* renamed from: q, reason: collision with root package name */
    private float f13175q;

    public C0560b(Context context) {
        super("COUIMaskRippleDrawable");
        this.f13164f = new Path();
        this.f13167i = new Paint(1);
        this.f13169k = true;
        this.f13174p = 0.0f;
        this.f13175q = 0.0f;
        this.f13168j = getBounds();
        int a3 = AbstractC0335a.a(context, M1.c.f1372q);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 34) {
            a3 = AbstractC0335a.a(context, M1.c.f1373r);
        } else if (i3 < 34) {
            a3 = AbstractC0335a.a(context, M1.c.f1376u);
        }
        setColor(ColorStateList.valueOf(a3));
        v(0);
        i iVar = new i(this, "hover", 0, AbstractC0335a.a(context, M1.c.f1369n));
        this.f13165g = iVar;
        i iVar2 = new i(this, "focus", 0, AbstractC0335a.a(context, M1.c.f1366k));
        this.f13166h = iVar2;
        iVar.k(0.0f);
        iVar.l(0.3f);
        iVar2.k(0.0f);
        iVar2.l(0.3f);
    }

    private void r(Canvas canvas) {
        Path path = this.f13172n;
        if (path != null) {
            canvas.clipPath(path);
            return;
        }
        if (this.f13173o != null) {
            this.f13164f.reset();
            this.f13164f.addRoundRect(this.f13173o, this.f13174p, this.f13175q, Path.Direction.CCW);
            canvas.clipPath(this.f13164f);
        } else {
            Rect bounds = getBounds();
            float max = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
            this.f13164f.reset();
            this.f13164f.addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, Path.Direction.CCW);
            canvas.clipPath(this.f13164f);
        }
    }

    private void s(Canvas canvas) {
        int i3 = this.f13170l;
        if (i3 == 0) {
            canvas.drawCircle(this.f13168j.centerX(), this.f13168j.centerY(), this.f13171m, this.f13167i);
            return;
        }
        if (i3 == 1) {
            Path path = this.f13172n;
            if (path != null) {
                canvas.drawPath(path, this.f13167i);
                return;
            }
            RectF rectF = this.f13173o;
            if (rectF != null) {
                canvas.drawRoundRect(rectF, this.f13174p, this.f13175q, this.f13167i);
                return;
            }
            Rect bounds = getBounds();
            float max = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
            canvas.drawRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, this.f13167i);
        }
    }

    public static int t(Context context, int i3) {
        if (i3 == 0) {
            return context.getResources().getDimensionPixelOffset(M1.f.f1437c0);
        }
        if (i3 == 1) {
            return context.getResources().getDimensionPixelOffset(M1.f.f1434b);
        }
        AbstractC0371a.c("COUIMaskRippleDrawable", "wrong mask type!");
        return 0;
    }

    private void y(int i3) {
        setRadius(i3);
    }

    @Override // r0.h, r0.InterfaceC0564f
    public void a(int i3, boolean z3, boolean z4, boolean z5) {
        super.a(i3, z3, z4, z5);
        if (i3 == 16842919) {
            AbstractC0371a.g("COUIMaskRippleDrawable", "Lock state press in COUIMaskRippleDrawable is not allowed!");
        }
        if (i3 == 16843623) {
            this.f13165g.d(z4 ? 10000.0f : 0.0f, z5);
        }
        if (i3 == 16842908) {
            this.f13166h.d(z4 ? 10000.0f : 0.0f, z5);
        }
    }

    @Override // r0.InterfaceC0564f
    public void d(int i3) {
        if (l()) {
            if (i3 == 16842908 && !p(R.attr.state_focused)) {
                this.f13166h.d(m() ? 10000.0f : 0.0f, this.f13169k);
                return;
            }
            if (i3 == 16843623 && !p(R.attr.state_hovered)) {
                this.f13165g.d(n() ? 10000.0f : 0.0f, this.f13169k);
                return;
            }
            if (i3 == 16842919) {
                if (o()) {
                    int[] iArr = f13162r;
                    iArr[0] = l() ? 16842910 : -16842910;
                    super.onStateChange(iArr);
                } else {
                    int[] iArr2 = f13163s;
                    iArr2[0] = l() ? 16842910 : -16842910;
                    super.onStateChange(iArr2);
                }
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (k()) {
            if (this.f13170l == 1) {
                canvas.save();
                r(canvas);
            }
            if (this.f13165g.g() != 0) {
                this.f13167i.setColor(this.f13165g.g());
                s(canvas);
            }
            if (this.f13166h.g() != 0) {
                this.f13167i.setColor(this.f13166h.g());
                s(canvas);
            }
            super.draw(canvas);
            if (this.f13170l == 1) {
                canvas.restore();
            }
        }
    }

    @Override // r0.InterfaceC0565g
    public void i(boolean z3) {
        this.f13169k = z3;
    }

    @Override // r0.InterfaceC0565g
    public void j() {
        this.f13165g.d(0.0f, false);
        this.f13166h.d(0.0f, false);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        this.f13196e.x(iArr);
        return false;
    }

    public void u(Context context) {
        this.f13165g.i(AbstractC0335a.a(context, M1.c.f1369n));
        this.f13166h.i(AbstractC0335a.a(context, M1.c.f1366k));
        int a3 = AbstractC0335a.a(context, M1.c.f1372q);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 34) {
            a3 = AbstractC0335a.a(context, M1.c.f1373r);
        } else if (i3 < 34) {
            a3 = AbstractC0335a.a(context, M1.c.f1376u);
        }
        setColor(ColorStateList.valueOf(a3));
    }

    public void v(int i3) {
        if (i3 < 0) {
            AbstractC0371a.c("COUIMaskRippleDrawable", "radius should larger than 0!");
            return;
        }
        this.f13170l = 0;
        y(i3);
        this.f13171m = i3;
    }

    public void w() {
        this.f13170l = 1;
        y(-1);
    }

    public void x(Path path) {
        this.f13172n = path;
    }
}
