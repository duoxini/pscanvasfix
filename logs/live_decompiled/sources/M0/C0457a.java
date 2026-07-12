package m0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0457a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Paint f12383a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f12384b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12385c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f12386d;

    /* renamed from: e, reason: collision with root package name */
    private Path f12387e;

    /* renamed from: f, reason: collision with root package name */
    private Path f12388f;

    /* renamed from: g, reason: collision with root package name */
    private C0137a f12389g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuffColorFilter f12390h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f12391i;

    public C0457a() {
        this(new C0137a());
    }

    private void b() {
        this.f12387e = c.a(this.f12387e, e(), this.f12389g.f12400i);
    }

    private void c() {
        this.f12388f = c.a(this.f12388f, e(), this.f12389g.f12400i);
    }

    private PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private boolean f() {
        Paint paint = this.f12383a;
        return ((paint == null || paint.getColor() == 0) && this.f12390h == null) ? false : true;
    }

    private boolean g() {
        Paint paint = this.f12384b;
        return ((paint == null || paint.getStrokeWidth() <= 0.0f || this.f12384b.getColor() == 0) && this.f12391i == null) ? false : true;
    }

    private static int i(int i3, int i4) {
        return (i3 * (i4 + (i4 >>> 7))) >>> 8;
    }

    private boolean k(int[] iArr) {
        boolean z3;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f12389g.f12393b == null || color2 == (colorForState2 = this.f12389g.f12393b.getColorForState(iArr, (color2 = this.f12383a.getColor())))) {
            z3 = false;
        } else {
            this.f12383a.setColor(colorForState2);
            z3 = true;
        }
        if (this.f12389g.f12394c == null || color == (colorForState = this.f12389g.f12394c.getColorForState(iArr, (color = this.f12384b.getColor())))) {
            return z3;
        }
        this.f12384b.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f12383a.setColorFilter(this.f12390h);
        int alpha = this.f12383a.getAlpha();
        this.f12383a.setAlpha(i(alpha, this.f12389g.f12399h));
        this.f12384b.setStrokeWidth(this.f12389g.f12398g);
        this.f12384b.setColorFilter(this.f12391i);
        int alpha2 = this.f12384b.getAlpha();
        this.f12384b.setAlpha(i(alpha2, this.f12389g.f12399h));
        if (this.f12385c) {
            c();
            b();
            this.f12385c = false;
        }
        if (f()) {
            canvas.drawPath(this.f12387e, this.f12383a);
        }
        if (g()) {
            canvas.drawPath(this.f12388f, this.f12384b);
        }
        this.f12383a.setAlpha(alpha);
        this.f12384b.setAlpha(alpha2);
    }

    protected RectF e() {
        this.f12386d.set(getBounds());
        return this.f12386d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f12389g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h() {
        this.f12385c = false;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f12385c = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f12389g.f12396e) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f12389g.f12395d) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f12389g.f12394c) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f12389g.f12393b) != null && colorStateList4.isStateful())));
    }

    public void j(float f3) {
        this.f12389g.f12400i = f3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f12389g = new C0137a(this.f12389g);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f12385c = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean k3 = k(iArr);
        if (k3) {
            invalidateSelf();
        }
        return k3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        C0137a c0137a = this.f12389g;
        if (c0137a.f12399h != i3) {
            c0137a.f12399h = i3;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        C0137a c0137a = this.f12389g;
        if (c0137a.f12392a != colorFilter) {
            c0137a.f12392a = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        C0137a c0137a = this.f12389g;
        c0137a.f12396e = colorStateList;
        PorterDuffColorFilter d3 = d(colorStateList, c0137a.f12397f);
        this.f12391i = d3;
        this.f12390h = d3;
        h();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        C0137a c0137a = this.f12389g;
        c0137a.f12397f = mode;
        PorterDuffColorFilter d3 = d(c0137a.f12396e, mode);
        this.f12391i = d3;
        this.f12390h = d3;
        h();
    }

    public C0457a(C0137a c0137a) {
        this.f12383a = new Paint(1);
        this.f12384b = new Paint(1);
        this.f12386d = new RectF();
        this.f12387e = new Path();
        this.f12388f = new Path();
        this.f12389g = c0137a;
        this.f12383a.setStyle(Paint.Style.FILL);
        this.f12384b.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: m0.a$a, reason: collision with other inner class name */
    static final class C0137a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public ColorFilter f12392a;

        /* renamed from: b, reason: collision with root package name */
        public ColorStateList f12393b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f12394c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f12395d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f12396e;

        /* renamed from: f, reason: collision with root package name */
        public PorterDuff.Mode f12397f;

        /* renamed from: g, reason: collision with root package name */
        public float f12398g;

        /* renamed from: h, reason: collision with root package name */
        public int f12399h;

        /* renamed from: i, reason: collision with root package name */
        public float f12400i;

        public C0137a() {
            this.f12392a = null;
            this.f12393b = null;
            this.f12394c = null;
            this.f12395d = null;
            this.f12396e = null;
            this.f12397f = PorterDuff.Mode.SRC_IN;
            this.f12399h = 255;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C0457a c0457a = new C0457a(this);
            c0457a.f12385c = true;
            return c0457a;
        }

        public C0137a(C0137a c0137a) {
            this.f12392a = null;
            this.f12393b = null;
            this.f12394c = null;
            this.f12395d = null;
            this.f12396e = null;
            this.f12397f = PorterDuff.Mode.SRC_IN;
            this.f12399h = 255;
            this.f12392a = c0137a.f12392a;
            this.f12393b = c0137a.f12393b;
            this.f12394c = c0137a.f12394c;
            this.f12395d = c0137a.f12395d;
            this.f12396e = c0137a.f12396e;
            this.f12398g = c0137a.f12398g;
            this.f12400i = c0137a.f12400i;
        }
    }
}
