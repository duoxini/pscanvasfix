package com.coui.appcompat.cardlist;

import W1.c;
import W1.h;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.coui.appcompat.preference.ListSelectedItemLayout;
import com.oplus.graphics.OplusPathAdapter;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import n0.AbstractC0481a;
import r0.C0561c;

/* loaded from: classes.dex */
public class COUICardListSelectedItemLayout extends ListSelectedItemLayout {

    /* renamed from: A, reason: collision with root package name */
    private boolean f7594A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f7595B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f7596C;

    /* renamed from: D, reason: collision with root package name */
    private int f7597D;

    /* renamed from: E, reason: collision with root package name */
    private OplusPathAdapter f7598E;

    /* renamed from: F, reason: collision with root package name */
    private float[] f7599F;

    /* renamed from: G, reason: collision with root package name */
    private View f7600G;

    /* renamed from: n, reason: collision with root package name */
    private final int f7601n;

    /* renamed from: o, reason: collision with root package name */
    private final RectF f7602o;

    /* renamed from: p, reason: collision with root package name */
    private final Paint f7603p;

    /* renamed from: q, reason: collision with root package name */
    private final Drawable f7604q;

    /* renamed from: r, reason: collision with root package name */
    private final ViewOutlineProvider f7605r;

    /* renamed from: s, reason: collision with root package name */
    private float f7606s;

    /* renamed from: t, reason: collision with root package name */
    private int f7607t;

    /* renamed from: u, reason: collision with root package name */
    private Path f7608u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7609v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7610w;

    /* renamed from: x, reason: collision with root package name */
    private int f7611x;

    /* renamed from: y, reason: collision with root package name */
    private int f7612y;

    /* renamed from: z, reason: collision with root package name */
    private int f7613z;

    class a extends Drawable {
        a() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (!COUICardListSelectedItemLayout.this.f7596C) {
                canvas.drawColor(COUICardListSelectedItemLayout.this.f7597D);
            } else {
                COUICardListSelectedItemLayout.this.f7603p.setColor(COUICardListSelectedItemLayout.this.f7597D);
                canvas.drawPath(COUICardListSelectedItemLayout.this.f7608u, COUICardListSelectedItemLayout.this.f7603p);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setPath(COUICardListSelectedItemLayout.this.f7608u);
            COUICardListSelectedItemLayout.this.f7595B = true;
        }
    }

    public COUICardListSelectedItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m(Context context, boolean z3) {
        if (z3) {
            this.f7607t = context.getResources().getDimensionPixelOffset(c.f2650r);
        } else {
            this.f7607t = context.getResources().getDimensionPixelOffset(c.f2649q);
        }
        this.f7597D = AbstractC0335a.a(context, M1.c.f1358c);
        this.f7611x = getMinimumHeight();
        this.f7612y = getPaddingTop();
        this.f7613z = getPaddingBottom();
        setBackground(this.f7604q);
    }

    private void o() {
        this.f7608u.reset();
        this.f7602o.set(this.f7607t, 0.0f, getWidth() - this.f7607t, getHeight());
        if (AbstractC0481a.a() != 1) {
            Path path = this.f7608u;
            RectF rectF = this.f7602o;
            float f3 = this.f7606s;
            boolean z3 = this.f7609v;
            boolean z4 = this.f7610w;
            m0.c.b(path, rectF, f3, z3, z3, z4, z4);
            return;
        }
        if (this.f7598E == null) {
            this.f7598E = new OplusPathAdapter(this.f7608u, 1);
        }
        float[] fArr = this.f7599F;
        boolean z5 = this.f7609v;
        fArr[0] = z5 ? this.f7606s : 0.0f;
        fArr[1] = z5 ? this.f7606s : 0.0f;
        fArr[2] = z5 ? this.f7606s : 0.0f;
        fArr[3] = z5 ? this.f7606s : 0.0f;
        boolean z6 = this.f7610w;
        fArr[4] = z6 ? this.f7606s : 0.0f;
        fArr[5] = z6 ? this.f7606s : 0.0f;
        fArr[6] = z6 ? this.f7606s : 0.0f;
        fArr[7] = z6 ? this.f7606s : 0.0f;
        this.f7598E.addSmoothRoundRect(this.f7602o, fArr, Path.Direction.CCW);
    }

    private void setCardRadiusStyle(int i3) {
        if (i3 == 4) {
            this.f7609v = true;
            this.f7610w = true;
        } else if (i3 == 1) {
            this.f7609v = true;
            this.f7610w = false;
        } else if (i3 == 3) {
            this.f7609v = false;
            this.f7610w = true;
        } else {
            this.f7609v = false;
            this.f7610w = false;
        }
    }

    private void setPadding(int i3) {
        int i4;
        if (i3 == 1) {
            r1 = this.f7601n;
            i4 = 0;
        } else if (i3 == 3) {
            i4 = this.f7601n;
        } else {
            r1 = i3 == 4 ? this.f7601n : 0;
            i4 = r1;
        }
        setMinimumHeight(this.f7611x + r1 + i4);
        View view = this.f7600G;
        if (view != null) {
            view.setPaddingRelative(view.getPaddingStart(), getPaddingTop() + r1, this.f7600G.getPaddingEnd(), getPaddingBottom() + i4);
        } else {
            setPaddingRelative(getPaddingStart(), this.f7612y + r1, getPaddingEnd(), this.f7613z + i4);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f7596C || this.f7595B) {
            o();
            super.draw(canvas);
        } else {
            canvas.save();
            canvas.clipPath(this.f7608u);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public boolean getIsSelected() {
        return this.f7594A;
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout
    protected Path getLayoutPath() {
        if (this.f7608u == null) {
            this.f7608u = new Path();
        }
        return this.f7608u;
    }

    public int getMarginHorizontal() {
        return this.f7607t;
    }

    public float getRadius() {
        return this.f7606s;
    }

    public void n(boolean z3, boolean z4) {
        if (this.f7594A != z3) {
            this.f7594A = z3;
            Drawable background = getBackground();
            if (background instanceof C0561c) {
                ((C0561c) background).f(1, z3, z3, z4);
            }
        }
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        o();
        if (this.f7596C) {
            this.f7595B = false;
            setClipToOutline(false);
        } else {
            setOutlineProvider(this.f7605r);
            setClipToOutline(true);
        }
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout
    public void setConfigurationChangeListener(com.coui.appcompat.list.b bVar) {
    }

    public void setIsSelected(boolean z3) {
        n(z3, false);
    }

    public void setMainLayoutToSetExtraPadding(View view) {
        this.f7600G = view;
    }

    public void setMarginHorizontal(int i3) {
        this.f7607t = i3;
        requestLayout();
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout
    public void setPositionInGroup(int i3) {
        if (i3 > 0) {
            setPadding(i3);
            setCardRadiusStyle(i3);
            o();
        }
    }

    public void setRadius(float f3) {
        this.f7606s = f3;
        o();
        invalidate();
    }

    public COUICardListSelectedItemLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUICardListSelectedItemLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f7601n = getResources().getDimensionPixelOffset(c.f2641i);
        this.f7602o = new RectF();
        this.f7603p = new Paint();
        this.f7604q = new a();
        this.f7605r = new b();
        this.f7609v = true;
        this.f7610w = true;
        this.f7595B = false;
        this.f7599F = new float[8];
        AbstractC0342a.b(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.f2797i, i3, i4);
        boolean z3 = obtainStyledAttributes.getBoolean(h.f2803l, false);
        this.f7606s = obtainStyledAttributes.getDimensionPixelOffset(h.f2801k, AbstractC0335a.c(context, M1.c.f1343A));
        m(getContext(), z3);
        this.f7607t = obtainStyledAttributes.getDimensionPixelOffset(h.f2799j, this.f7607t);
        obtainStyledAttributes.recycle();
        if (getId() != -1) {
            try {
                if ("single_card".equals(getContext().getResources().getResourceEntryName(getId()))) {
                    a(true);
                }
            } catch (Resources.NotFoundException e3) {
                AbstractC0371a.c("COUICardListSelectedItemLayout", e3.getMessage());
            }
        }
    }
}
