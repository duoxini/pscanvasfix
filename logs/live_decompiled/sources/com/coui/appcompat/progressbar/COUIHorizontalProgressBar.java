package com.coui.appcompat.progressbar;

import X1.f;
import X1.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class COUIHorizontalProgressBar extends ProgressBar {

    /* renamed from: p, reason: collision with root package name */
    private static final int f8834p = Color.argb(12, 0, 0, 0);

    /* renamed from: q, reason: collision with root package name */
    private static final int f8835q = Color.parseColor("#FF2AD181");

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f8836r = {X1.a.f2864c};

    /* renamed from: e, reason: collision with root package name */
    private Paint f8837e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f8838f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f8839g;

    /* renamed from: h, reason: collision with root package name */
    private RectF f8840h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f8841i;

    /* renamed from: j, reason: collision with root package name */
    private int f8842j;

    /* renamed from: k, reason: collision with root package name */
    private Path f8843k;

    /* renamed from: l, reason: collision with root package name */
    private Path f8844l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8845m;

    /* renamed from: n, reason: collision with root package name */
    private int f8846n;

    /* renamed from: o, reason: collision with root package name */
    private Context f8847o;

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X1.a.f2862a);
    }

    private int a(ColorStateList colorStateList, int i3) {
        return colorStateList == null ? i3 : colorStateList.getColorForState(getDrawableState(), i3);
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f8844l.reset();
        this.f8843k.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.f8837e.setColor(a(this.f8838f, f8834p));
        this.f8840h.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Path path = this.f8843k;
        RectF rectF = this.f8840h;
        int i3 = this.f8842j;
        Path.Direction direction = Path.Direction.CCW;
        path.addRoundRect(rectF, i3, i3, direction);
        canvas.clipPath(this.f8843k);
        RectF rectF2 = this.f8840h;
        int i4 = this.f8842j;
        canvas.drawRoundRect(rectF2, i4, i4, this.f8837e);
        float progress = getProgress() / getMax();
        if (isLayoutRtl()) {
            this.f8841i.set(Math.round((getWidth() - getPaddingRight()) - (progress * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
        } else {
            this.f8841i.set(Math.round(getPaddingLeft() - ((1.0f - progress) * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
        }
        this.f8837e.setColor(a(this.f8839g, f8835q));
        this.f8844l.addRoundRect(this.f8841i, this.f8842j, 0.0f, direction);
        this.f8844l.op(this.f8843k, Path.Op.INTERSECT);
        canvas.drawPath(this.f8844l, this.f8837e);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        int paddingRight = (i3 - getPaddingRight()) - getPaddingLeft();
        int paddingTop = (i4 - getPaddingTop()) - getPaddingBottom();
        if (this.f8845m) {
            this.f8842j = paddingRight >= paddingTop ? paddingTop / 2 : paddingRight / 2;
        } else {
            this.f8842j = 0;
        }
    }

    public void setBackgroundColor(ColorStateList colorStateList) {
        this.f8838f = colorStateList;
    }

    public void setProgressColor(ColorStateList colorStateList) {
        this.f8839g = colorStateList;
    }

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, f.f2891a);
    }

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8837e = new Paint();
        this.f8840h = new RectF();
        this.f8841i = new RectF();
        this.f8842j = Preference.DEFAULT_ORDER;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f8846n = attributeSet.getStyleAttribute();
        } else {
            this.f8846n = i3;
        }
        this.f8847o = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(f8836r);
        obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.f2923o, i3, i4);
        this.f8838f = obtainStyledAttributes2.getColorStateList(g.f2924p);
        this.f8839g = obtainStyledAttributes2.getColorStateList(g.f2925q);
        this.f8845m = obtainStyledAttributes2.getBoolean(g.f2926r, true);
        obtainStyledAttributes2.recycle();
        this.f8837e.setDither(true);
        this.f8837e.setAntiAlias(true);
        setLayerType(1, this.f8837e);
        this.f8843k = new Path();
        this.f8844l = new Path();
    }
}
