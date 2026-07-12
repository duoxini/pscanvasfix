package com.coui.appcompat.tagview;

import U0.g;
import U0.k;
import U0.l;
import Z1.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.coui.appcompat.theme.b;

/* loaded from: classes.dex */
public class COUITagBackgroundView extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private int f9254e;

    /* renamed from: f, reason: collision with root package name */
    private int f9255f;

    /* renamed from: g, reason: collision with root package name */
    private int f9256g;

    /* renamed from: h, reason: collision with root package name */
    private int f9257h;

    /* renamed from: i, reason: collision with root package name */
    private int f9258i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f9259j;

    /* renamed from: k, reason: collision with root package name */
    private float f9260k;

    /* renamed from: l, reason: collision with root package name */
    private int f9261l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f9262m;

    /* renamed from: n, reason: collision with root package name */
    private k f9263n;

    /* renamed from: o, reason: collision with root package name */
    private final Path f9264o;

    /* renamed from: p, reason: collision with root package name */
    private final RectF f9265p;

    /* renamed from: q, reason: collision with root package name */
    private g f9266q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f9267r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9268s;

    public COUITagBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.f9264o);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void b() {
        this.f9263n = new k.b().F(0, this.f9256g).v(0, this.f9258i).A(0, this.f9255f).q(0, this.f9257h).m();
        this.f9268s = true;
    }

    private void c() {
        g gVar = this.f9266q;
        if (gVar == null) {
            this.f9266q = new g(this.f9263n);
        } else {
            gVar.setShapeAppearanceModel(this.f9263n);
        }
        this.f9266q.Y(2);
        this.f9266q.K(getContext());
        this.f9266q.U(this.f9259j);
        this.f9266q.a0(this.f9260k, this.f9262m);
    }

    private void d() {
        setBackground(this.f9266q);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f9268s) {
            this.f9265p.set(getBackground().getBounds());
            l.k().e(this.f9263n, 1.0f, this.f9265p, this.f9264o);
            this.f9268s = false;
        }
        a(canvas);
    }

    public int getCardBLCornerRadius() {
        return this.f9257h;
    }

    public int getCardBRCornerRadius() {
        return this.f9258i;
    }

    public int getCardCornerRadius() {
        return this.f9254e;
    }

    public int getCardTLCornerRadius() {
        return this.f9255f;
    }

    public int getCardTRCornerRadius() {
        return this.f9256g;
    }

    public ColorStateList getColorStateList() {
        return this.f9259j;
    }

    public g getMaterialShapeDrawable() {
        return this.f9266q;
    }

    public int getStrokeColor() {
        return this.f9261l;
    }

    public ColorStateList getStrokeStateColor() {
        return this.f9262m;
    }

    public float getStrokeWidth() {
        return this.f9260k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).setClipChildren(false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f9268s = true;
    }

    public void setCardBLCornerRadius(int i3) {
        this.f9257h = i3;
        b();
        c();
        d();
    }

    public void setCardBRCornerRadius(int i3) {
        this.f9258i = i3;
        b();
        c();
        d();
    }

    public void setCardCornerRadius(int i3) {
        this.f9254e = i3;
        this.f9257h = i3;
        this.f9258i = i3;
        this.f9255f = i3;
        this.f9256g = i3;
        b();
        c();
        d();
    }

    public void setCardTLCornerRadius(int i3) {
        this.f9255f = i3;
        b();
        c();
        d();
    }

    public void setCardTRCornerRadius(int i3) {
        this.f9256g = i3;
        b();
        c();
        d();
    }

    public void setColorStateList(ColorStateList colorStateList) {
        this.f9259j = colorStateList;
        b();
        c();
        d();
    }

    public void setStrokeColor(int i3) {
        this.f9261l = i3;
        setStrokeStateColor(ColorStateList.valueOf(i3));
    }

    public void setStrokeStateColor(ColorStateList colorStateList) {
        this.f9262m = colorStateList;
        b();
        c();
        d();
    }

    public void setStrokeWidth(float f3) {
        this.f9260k = f3;
        b();
        c();
        d();
    }

    public COUITagBackgroundView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9260k = 0.0f;
        this.f9261l = 0;
        this.f9262m = ColorStateList.valueOf(0);
        this.f9264o = new Path();
        this.f9265p = new RectF();
        this.f9268s = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z1.g.f3135p);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(Z1.g.f3139t, 0);
        this.f9254e = dimensionPixelSize;
        this.f9255f = obtainStyledAttributes.getDimensionPixelSize(Z1.g.f3142w, dimensionPixelSize);
        this.f9256g = obtainStyledAttributes.getDimensionPixelSize(Z1.g.f3143x, this.f9254e);
        this.f9257h = obtainStyledAttributes.getDimensionPixelSize(Z1.g.f3136q, this.f9254e);
        this.f9258i = obtainStyledAttributes.getDimensionPixelSize(Z1.g.f3137r, this.f9254e);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(Z1.g.f3138s);
        this.f9259j = colorStateList;
        if (colorStateList == null) {
            this.f9259j = ColorStateList.valueOf(b.a(context, a.f3106a));
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(Z1.g.f3140u);
        this.f9262m = colorStateList2;
        if (colorStateList2 == null) {
            this.f9262m = ColorStateList.valueOf(0);
        }
        Paint paint = new Paint(1);
        this.f9267r = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f9260k = obtainStyledAttributes.getDimensionPixelSize(Z1.g.f3141v, 0);
        b();
        c();
        d();
        obtainStyledAttributes.recycle();
    }
}
