package com.coui.appcompat.input;

import M1.c;
import S1.g;
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
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import r0.C0561c;

/* loaded from: classes.dex */
public class COUIInputListSelectedItemLayout extends ListSelectedItemLayout {

    /* renamed from: A, reason: collision with root package name */
    private boolean f8038A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f8039B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f8040C;

    /* renamed from: D, reason: collision with root package name */
    private int f8041D;

    /* renamed from: n, reason: collision with root package name */
    private final int f8042n;

    /* renamed from: o, reason: collision with root package name */
    private final RectF f8043o;

    /* renamed from: p, reason: collision with root package name */
    private final Paint f8044p;

    /* renamed from: q, reason: collision with root package name */
    private final Drawable f8045q;

    /* renamed from: r, reason: collision with root package name */
    private final ViewOutlineProvider f8046r;

    /* renamed from: s, reason: collision with root package name */
    private float f8047s;

    /* renamed from: t, reason: collision with root package name */
    private int f8048t;

    /* renamed from: u, reason: collision with root package name */
    private Path f8049u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f8050v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f8051w;

    /* renamed from: x, reason: collision with root package name */
    private int f8052x;

    /* renamed from: y, reason: collision with root package name */
    private int f8053y;

    /* renamed from: z, reason: collision with root package name */
    private int f8054z;

    class a extends Drawable {
        a() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (!COUIInputListSelectedItemLayout.this.f8040C) {
                canvas.drawColor(COUIInputListSelectedItemLayout.this.f8041D);
            } else {
                COUIInputListSelectedItemLayout.this.f8044p.setColor(COUIInputListSelectedItemLayout.this.f8041D);
                canvas.drawPath(COUIInputListSelectedItemLayout.this.f8049u, COUIInputListSelectedItemLayout.this.f8044p);
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
            outline.setPath(COUIInputListSelectedItemLayout.this.f8049u);
            COUIInputListSelectedItemLayout.this.f8039B = true;
        }
    }

    public COUIInputListSelectedItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m(Context context, boolean z3) {
        if (z3) {
            this.f8048t = context.getResources().getDimensionPixelOffset(S1.b.f2097m);
        } else {
            this.f8048t = context.getResources().getDimensionPixelOffset(S1.b.f2096l);
        }
        this.f8041D = AbstractC0335a.a(context, c.f1358c);
        this.f8052x = getMinimumHeight();
        this.f8053y = getPaddingTop();
        this.f8054z = getPaddingBottom();
        setBackground(this.f8045q);
    }

    private void o() {
        this.f8049u.reset();
        this.f8043o.set(this.f8048t, 0.0f, getWidth() - this.f8048t, getHeight());
        Path path = this.f8049u;
        RectF rectF = this.f8043o;
        float f3 = this.f8047s;
        boolean z3 = this.f8050v;
        boolean z4 = this.f8051w;
        m0.c.b(path, rectF, f3, z3, z3, z4, z4);
    }

    private void setCardRadiusStyle(int i3) {
        if (i3 == 4) {
            this.f8050v = true;
            this.f8051w = true;
        } else if (i3 == 1) {
            this.f8050v = true;
            this.f8051w = false;
        } else if (i3 == 3) {
            this.f8050v = false;
            this.f8051w = true;
        } else {
            this.f8050v = false;
            this.f8051w = false;
        }
    }

    private void setPadding(int i3) {
        int i4;
        if (i3 == 1) {
            r1 = this.f8042n;
            i4 = 0;
        } else if (i3 == 3) {
            i4 = this.f8042n;
        } else {
            r1 = i3 == 4 ? this.f8042n : 0;
            i4 = r1;
        }
        setMinimumHeight(this.f8052x + r1 + i4);
        setPaddingRelative(getPaddingStart(), this.f8053y + r1, getPaddingEnd(), this.f8054z + i4);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f8040C || this.f8039B) {
            o();
            super.draw(canvas);
        } else {
            canvas.save();
            canvas.clipPath(this.f8049u);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public boolean getIsSelected() {
        return this.f8038A;
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout
    protected Path getLayoutPath() {
        if (this.f8049u == null) {
            this.f8049u = new Path();
        }
        return this.f8049u;
    }

    public int getMarginHorizontal() {
        return this.f8048t;
    }

    public void n(boolean z3, boolean z4) {
        if (this.f8038A != z3) {
            this.f8038A = z3;
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
        if (this.f8040C) {
            this.f8039B = false;
            setClipToOutline(false);
        } else {
            setOutlineProvider(this.f8046r);
            setClipToOutline(true);
        }
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout
    public void setConfigurationChangeListener(com.coui.appcompat.list.b bVar) {
    }

    public void setIsSelected(boolean z3) {
        n(z3, false);
    }

    public void setMarginHorizontal(int i3) {
        this.f8048t = i3;
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
        this.f8047s = f3;
        o();
        invalidate();
    }

    public COUIInputListSelectedItemLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUIInputListSelectedItemLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8042n = getResources().getDimensionPixelOffset(S1.b.f2095k);
        this.f8043o = new RectF();
        this.f8044p = new Paint();
        this.f8045q = new a();
        this.f8046r = new b();
        this.f8050v = true;
        this.f8051w = true;
        this.f8039B = false;
        AbstractC0342a.b(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f2110b, i3, i4);
        boolean z3 = obtainStyledAttributes.getBoolean(g.f2113e, false);
        this.f8047s = obtainStyledAttributes.getDimensionPixelOffset(g.f2112d, AbstractC0335a.c(context, c.f1343A));
        m(getContext(), z3);
        this.f8048t = obtainStyledAttributes.getDimensionPixelOffset(g.f2111c, this.f8048t);
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
