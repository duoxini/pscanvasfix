package com.coui.appcompat.imageview;

import M1.e;
import M1.f;
import M1.g;
import M1.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import f.AbstractC0348a;
import m0.b;

/* loaded from: classes.dex */
public class COUIRoundImageView extends AppCompatImageView {

    /* renamed from: A, reason: collision with root package name */
    private Paint f7947A;

    /* renamed from: B, reason: collision with root package name */
    private Paint f7948B;

    /* renamed from: C, reason: collision with root package name */
    private int f7949C;

    /* renamed from: D, reason: collision with root package name */
    private int f7950D;

    /* renamed from: E, reason: collision with root package name */
    private Matrix f7951E;

    /* renamed from: F, reason: collision with root package name */
    private BitmapShader f7952F;

    /* renamed from: G, reason: collision with root package name */
    private int f7953G;

    /* renamed from: H, reason: collision with root package name */
    private float f7954H;

    /* renamed from: I, reason: collision with root package name */
    private Drawable f7955I;

    /* renamed from: J, reason: collision with root package name */
    private Bitmap f7956J;

    /* renamed from: K, reason: collision with root package name */
    private float f7957K;

    /* renamed from: L, reason: collision with root package name */
    private int f7958L;

    /* renamed from: M, reason: collision with root package name */
    private Paint f7959M;

    /* renamed from: N, reason: collision with root package name */
    private int f7960N;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f7961h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f7962i;

    /* renamed from: j, reason: collision with root package name */
    private int f7963j;

    /* renamed from: k, reason: collision with root package name */
    private Context f7964k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7965l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7966m;

    /* renamed from: n, reason: collision with root package name */
    private int f7967n;

    /* renamed from: o, reason: collision with root package name */
    private RectF f7968o;

    /* renamed from: p, reason: collision with root package name */
    private RectF f7969p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f7970q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f7971r;

    /* renamed from: s, reason: collision with root package name */
    private int f7972s;

    /* renamed from: t, reason: collision with root package name */
    private int f7973t;

    /* renamed from: u, reason: collision with root package name */
    private int f7974u;

    /* renamed from: v, reason: collision with root package name */
    private int f7975v;

    /* renamed from: w, reason: collision with root package name */
    private BitmapShader f7976w;

    /* renamed from: x, reason: collision with root package name */
    private int f7977x;

    /* renamed from: y, reason: collision with root package name */
    private int f7978y;

    /* renamed from: z, reason: collision with root package name */
    private int f7979z;

    public COUIRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7961h = new RectF();
        this.f7962i = new RectF();
        this.f7950D = 2;
        if (attributeSet != null) {
            this.f7960N = attributeSet.getStyleAttribute();
        }
        this.f7951E = new Matrix();
        this.f7964k = context;
        Paint paint = new Paint();
        this.f7947A = paint;
        paint.setAntiAlias(true);
        this.f7947A.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        c();
        Paint paint2 = new Paint();
        this.f7948B = paint2;
        paint2.setAntiAlias(true);
        this.f7948B.setStrokeWidth(this.f7950D);
        this.f7948B.setStyle(Paint.Style.STROKE);
        Drawable drawable = context.getResources().getDrawable(g.f1476j);
        this.f7970q = drawable;
        this.f7972s = drawable.getIntrinsicWidth();
        this.f7973t = this.f7970q.getIntrinsicHeight();
        int dimension = (int) context.getResources().getDimension(f.f1464x);
        this.f7974u = dimension;
        this.f7975v = dimension;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1541Z);
        this.f7967n = obtainStyledAttributes.getDimensionPixelSize(m.f1543a0, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f7963j = obtainStyledAttributes.getInt(m.f1551e0, 0);
        this.f7965l = obtainStyledAttributes.getBoolean(m.f1545b0, false);
        this.f7966m = obtainStyledAttributes.getBoolean(m.f1547c0, true);
        int color = obtainStyledAttributes.getColor(m.f1549d0, getResources().getColor(e.f1404t));
        this.f7949C = color;
        this.f7948B.setColor(color);
        d();
        setupShader(getDrawable());
        obtainStyledAttributes.recycle();
    }

    private Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int max = Math.max(1, drawable.getIntrinsicHeight());
        int max2 = Math.max(1, drawable.getIntrinsicWidth());
        Bitmap createBitmap = Bitmap.createBitmap(max2, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, max2, max);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void c() {
        Paint paint = new Paint();
        this.f7959M = paint;
        paint.setStrokeWidth(this.f7950D);
        this.f7959M.setStyle(Paint.Style.STROKE);
        this.f7959M.setAntiAlias(true);
        this.f7959M.setColor(getResources().getColor(e.f1385a));
    }

    private void e() {
        this.f7951E.reset();
        float f3 = (this.f7974u * 1.0f) / this.f7977x;
        float f4 = (this.f7975v * 1.0f) / this.f7978y;
        if (f3 <= 1.0f) {
            f3 = 1.0f;
        }
        float max = Math.max(f3, f4 > 1.0f ? f4 : 1.0f);
        float f5 = (this.f7974u - (this.f7977x * max)) * 0.5f;
        float f6 = (this.f7975v - (this.f7978y * max)) * 0.5f;
        this.f7951E.setScale(max, max);
        Matrix matrix = this.f7951E;
        int i3 = this.f7979z;
        matrix.postTranslate(((int) (f5 + 0.5f)) + (i3 / 2.0f), ((int) (f6 + 0.5f)) + (i3 / 2.0f));
    }

    private void setupShader(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        this.f7955I = drawable2;
        if (drawable2 == null || drawable == null) {
            return;
        }
        if (drawable2 != drawable) {
            this.f7955I = drawable;
        }
        this.f7977x = this.f7955I.getIntrinsicWidth();
        this.f7978y = this.f7955I.getIntrinsicHeight();
        this.f7956J = b(this.f7955I);
        if (this.f7963j == 2) {
            this.f7971r = a();
            Bitmap bitmap = this.f7971r;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f7976w = new BitmapShader(bitmap, tileMode, tileMode);
        }
        Bitmap bitmap2 = this.f7956J;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        Bitmap bitmap3 = this.f7956J;
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        this.f7952F = new BitmapShader(bitmap3, tileMode2, tileMode2);
    }

    public Bitmap a() {
        e();
        Bitmap bitmap = this.f7956J;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f7976w = bitmapShader;
        bitmapShader.setLocalMatrix(this.f7951E);
        this.f7947A.setShader(this.f7976w);
        Bitmap createBitmap = Bitmap.createBitmap(this.f7972s, this.f7973t, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f7967n = this.f7974u / 2;
        canvas.drawPath(b.a().c(this.f7961h, this.f7967n), this.f7947A);
        this.f7970q.setBounds(0, 0, this.f7972s, this.f7973t);
        this.f7970q.draw(canvas);
        return createBitmap;
    }

    public void d() {
        this.f7962i.set(0.0f, 0.0f, this.f7972s, this.f7973t);
        this.f7979z = this.f7972s - this.f7974u;
        this.f7961h.set(this.f7962i);
        RectF rectF = this.f7961h;
        int i3 = this.f7979z;
        rectF.inset(i3 / 2, i3 / 2);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f7955I != null) {
            this.f7955I.setState(getDrawableState());
            setupShader(this.f7955I);
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f7957K = 1.0f;
        Bitmap bitmap = this.f7956J;
        if (bitmap != null && !bitmap.isRecycled()) {
            int i3 = this.f7963j;
            if (i3 == 0) {
                int min = Math.min(this.f7956J.getWidth(), this.f7956J.getHeight());
                this.f7958L = min;
                this.f7957K = (this.f7953G * 1.0f) / min;
            } else if (i3 == 1) {
                this.f7957K = Math.max((getWidth() * 1.0f) / this.f7956J.getWidth(), (getHeight() * 1.0f) / this.f7956J.getHeight());
            } else if (i3 == 2) {
                this.f7957K = Math.max((getWidth() * 1.0f) / this.f7972s, (getHeight() * 1.0f) / this.f7973t);
                this.f7951E.reset();
                Matrix matrix = this.f7951E;
                float f3 = this.f7957K;
                matrix.setScale(f3, f3);
                this.f7976w.setLocalMatrix(this.f7951E);
                this.f7947A.setShader(this.f7976w);
                canvas.drawRect(this.f7968o, this.f7947A);
                return;
            }
            float width = ((float) getWidth()) < ((float) this.f7956J.getWidth()) * this.f7957K ? (getWidth() - (this.f7956J.getWidth() * this.f7957K)) / 2.0f : 0.0f;
            float height = ((float) getHeight()) < ((float) this.f7956J.getHeight()) * this.f7957K ? (getHeight() - (this.f7956J.getHeight() * this.f7957K)) / 2.0f : 0.0f;
            Matrix matrix2 = this.f7951E;
            float f4 = this.f7957K;
            matrix2.setScale(f4, f4);
            this.f7951E.postTranslate(width, height);
            BitmapShader bitmapShader = this.f7952F;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.f7951E);
                this.f7947A.setShader(this.f7952F);
            }
        }
        int i4 = this.f7963j;
        if (i4 == 0) {
            if (!this.f7965l) {
                float f5 = this.f7954H;
                canvas.drawCircle(f5, f5, f5, this.f7947A);
                return;
            } else {
                float f6 = this.f7954H;
                canvas.drawCircle(f6, f6, f6, this.f7947A);
                float f7 = this.f7954H;
                canvas.drawCircle(f7, f7, f7 - 0.5f, this.f7948B);
                return;
            }
        }
        if (i4 == 1) {
            if (this.f7968o == null) {
                this.f7968o = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            }
            if (this.f7969p == null) {
                int i5 = this.f7950D;
                this.f7969p = new RectF(i5 / 2.0f, i5 / 2.0f, getWidth() - (this.f7950D / 2.0f), getHeight() - (this.f7950D / 2.0f));
            }
            if (!this.f7965l) {
                canvas.drawPath(b.a().c(this.f7968o, this.f7967n), this.f7947A);
            } else {
                canvas.drawPath(b.a().c(this.f7968o, this.f7967n), this.f7947A);
                canvas.drawPath(b.a().c(this.f7969p, this.f7967n - (this.f7950D / 2.0f)), this.f7948B);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f7963j == 0) {
            int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
            if (min == 0) {
                min = this.f7953G;
            }
            this.f7953G = min;
            this.f7954H = min / 2.0f;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        int i7 = this.f7963j;
        if (i7 == 1 || i7 == 2) {
            this.f7968o = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            int i8 = this.f7950D;
            this.f7969p = new RectF(i8 / 2.0f, i8 / 2.0f, getWidth() - (this.f7950D / 2.0f), getHeight() - (this.f7950D / 2.0f));
        }
    }

    public void setBorderRectRadius(int i3) {
        this.f7967n = i3;
        invalidate();
    }

    public void setHasBorder(boolean z3) {
        this.f7965l = z3;
    }

    public void setHasDefaultPic(boolean z3) {
        this.f7966m = z3;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setupShader(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        setupShader(AbstractC0348a.b(this.f7964k, i3));
    }

    public void setOutCircleColor(int i3) {
        this.f7949C = i3;
        this.f7948B.setColor(i3);
        invalidate();
    }

    public void setType(int i3) {
        if (this.f7963j != i3) {
            this.f7963j = i3;
            if (i3 == 0) {
                int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
                if (min == 0) {
                    min = this.f7953G;
                }
                this.f7953G = min;
                this.f7954H = min / 2.0f;
            }
            invalidate();
        }
    }
}
