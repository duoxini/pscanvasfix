package r0;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import d0.AbstractC0335a;

/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0559a extends j {

    /* renamed from: f, reason: collision with root package name */
    private final Paint f13148f;

    /* renamed from: g, reason: collision with root package name */
    private final i f13149g;

    /* renamed from: h, reason: collision with root package name */
    private final i f13150h;

    /* renamed from: i, reason: collision with root package name */
    private final i f13151i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13152j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13153k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13154l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13155m;

    /* renamed from: n, reason: collision with root package name */
    private int f13156n;

    /* renamed from: o, reason: collision with root package name */
    private float f13157o;

    /* renamed from: p, reason: collision with root package name */
    private float f13158p;

    /* renamed from: q, reason: collision with root package name */
    private float f13159q;

    /* renamed from: r, reason: collision with root package name */
    private Path f13160r;

    /* renamed from: s, reason: collision with root package name */
    private RectF f13161s;

    public C0559a(Context context, int i3) {
        super("COUIMaskEffectDrawable");
        this.f13148f = new Paint(1);
        this.f13152j = true;
        this.f13153k = true;
        this.f13154l = true;
        this.f13155m = true;
        this.f13157o = 0.0f;
        this.f13158p = 0.0f;
        this.f13159q = 0.7f;
        this.f13156n = i3;
        i iVar = new i(this, "hover", 0, AbstractC0335a.a(context, M1.c.f1369n));
        this.f13149g = iVar;
        i iVar2 = new i(this, "focus", 0, AbstractC0335a.a(context, M1.c.f1366k));
        this.f13150h = iVar2;
        i iVar3 = new i(this, "press", 0, AbstractC0335a.a(context, M1.c.f1372q));
        this.f13151i = iVar3;
        iVar.l(0.3f);
        iVar.k(0.0f);
        iVar2.l(0.3f);
        iVar2.k(0.0f);
        iVar3.l(0.3f);
        iVar3.k(0.0f);
    }

    private void v(Canvas canvas) {
        if (this.f13149g.g() != 0) {
            this.f13148f.setColor(this.f13149g.g());
            w(canvas);
        }
        if (this.f13150h.g() != 0) {
            this.f13148f.setColor(this.f13150h.g());
            w(canvas);
        }
        if (this.f13151i.g() != 0) {
            this.f13148f.setColor(this.f13151i.g());
            w(canvas);
        }
    }

    private void w(Canvas canvas) {
        Path path = this.f13160r;
        if (path != null) {
            canvas.drawPath(path, this.f13148f);
            return;
        }
        RectF rectF = this.f13161s;
        if (rectF != null) {
            canvas.drawRoundRect(rectF, this.f13157o, this.f13158p, this.f13148f);
            return;
        }
        Rect bounds = getBounds();
        float max = this.f13155m ? Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f : 0.0f;
        canvas.drawRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, this.f13148f);
    }

    private void x(Canvas canvas) {
        if (this.f13149g.g() != 0) {
            this.f13148f.setColor(this.f13149g.g());
            w(canvas);
        }
        if (this.f13151i.g() != 0) {
            this.f13148f.setColor(this.f13151i.g());
            w(canvas);
        }
    }

    public void A(boolean z3, boolean z4, boolean z5) {
        a(R.attr.state_hovered, z3, z4, z5);
    }

    public void B(boolean z3) {
        this.f13155m = z3;
    }

    public void C(Path path) {
        this.f13160r = path;
    }

    public void D(RectF rectF, float f3, float f4) {
        this.f13161s = rectF;
        this.f13157o = f3;
        this.f13158p = f4;
    }

    public void E(int i3) {
        this.f13156n = i3;
    }

    @Override // r0.j, r0.InterfaceC0564f
    public void a(int i3, boolean z3, boolean z4, boolean z5) {
        super.a(i3, z3, z4, z5);
        if (i3 == 1) {
            this.f13151i.d(z4 ? 10000.0f : 0.0f, z5);
        }
        if (i3 == 16843623) {
            this.f13149g.d(z4 ? 10000.0f : 0.0f, z5);
        }
        if (i3 == 16842908) {
            this.f13150h.d(z4 ? 10000.0f : 0.0f, z5);
        }
    }

    @Override // r0.InterfaceC0564f
    public void d(int i3) {
        if (i3 == 16842910 && !m()) {
            this.f13151i.d(0.0f, false);
            this.f13149g.d(0.0f, false);
            this.f13150h.d(0.0f, false);
            return;
        }
        if (m()) {
            if (i3 == 1 && !q(1)) {
                int k3 = k();
                if (k3 != 0) {
                    if (k3 != 1) {
                        return;
                    }
                    this.f13151i.d(r() ? 10000.0f : 0.0f, false);
                    return;
                } else if (r()) {
                    this.f13151i.d(10000.0f, true);
                    return;
                } else {
                    this.f13151i.e(0.0f, this.f13159q * 10000.0f);
                    return;
                }
            }
            if (i3 == 16843623 && !q(R.attr.state_hovered)) {
                this.f13149g.d(o() ? 10000.0f : 0.0f, this.f13152j);
                return;
            }
            if (this.f13154l && i3 == 16842908 && !q(R.attr.state_focused)) {
                if (this.f13156n == 1) {
                    this.f13150h.d(n() ? 10000.0f : 0.0f, this.f13152j);
                }
            } else if (this.f13153k && i3 == 16842913 && !q(R.attr.state_selected) && this.f13156n == 1) {
                this.f13150h.d(p() ? 10000.0f : 0.0f, this.f13152j);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (l()) {
            int i3 = this.f13156n;
            if (i3 == 0) {
                x(canvas);
            } else {
                if (i3 != 1) {
                    return;
                }
                v(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // r0.InterfaceC0565g
    public void i(boolean z3) {
        this.f13152j = z3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override // r0.InterfaceC0565g
    public void j() {
        this.f13149g.d(0.0f, false);
        this.f13150h.d(0.0f, false);
        this.f13151i.d(0.0f, false);
    }

    @Override // r0.j
    public void s(boolean z3) {
        super.s(z3);
        if (z3) {
            return;
        }
        this.f13151i.d(0.0f, false);
        this.f13149g.d(0.0f, false);
        this.f13150h.d(0.0f, false);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void y(boolean z3) {
        this.f13154l = z3;
    }

    public int z() {
        return androidx.core.graphics.a.i(this.f13151i.g(), androidx.core.graphics.a.i(this.f13150h.g(), this.f13149g.g()));
    }
}
