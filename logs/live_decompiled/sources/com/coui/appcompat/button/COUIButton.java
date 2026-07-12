package com.coui.appcompat.button;

import M1.c;
import M1.f;
import M1.m;
import a0.C0218b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.y;
import b0.InterfaceC0291a;
import com.coui.appcompat.button.COUIButton;
import com.oplus.graphics.OplusOutlineAdapter;
import d0.AbstractC0335a;
import e.AbstractC0339a;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import m0.b;
import n0.AbstractC0481a;
import r0.C0559a;
import r0.C0560b;
import r0.C0561c;
import r0.C0562d;
import u0.AbstractC0597a;
import y0.i;

/* loaded from: classes.dex */
public class COUIButton extends AppCompatButton {

    /* renamed from: W, reason: collision with root package name */
    private static String f7486W = "COUIButton";

    /* renamed from: A, reason: collision with root package name */
    private float f7487A;

    /* renamed from: B, reason: collision with root package name */
    private int f7488B;

    /* renamed from: C, reason: collision with root package name */
    private int f7489C;

    /* renamed from: D, reason: collision with root package name */
    private int f7490D;

    /* renamed from: E, reason: collision with root package name */
    private int f7491E;

    /* renamed from: F, reason: collision with root package name */
    private int f7492F;

    /* renamed from: G, reason: collision with root package name */
    private int f7493G;

    /* renamed from: H, reason: collision with root package name */
    private int f7494H;

    /* renamed from: I, reason: collision with root package name */
    private Rect f7495I;

    /* renamed from: J, reason: collision with root package name */
    private RectF f7496J;

    /* renamed from: K, reason: collision with root package name */
    private RectF f7497K;

    /* renamed from: L, reason: collision with root package name */
    private float[] f7498L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f7499M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f7500N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f7501O;

    /* renamed from: P, reason: collision with root package name */
    private String f7502P;

    /* renamed from: Q, reason: collision with root package name */
    private String f7503Q;

    /* renamed from: R, reason: collision with root package name */
    private int f7504R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f7505S;

    /* renamed from: T, reason: collision with root package name */
    private OplusOutlineAdapter f7506T;

    /* renamed from: U, reason: collision with root package name */
    private Rect f7507U;

    /* renamed from: V, reason: collision with root package name */
    private float f7508V;

    /* renamed from: h, reason: collision with root package name */
    private final Path f7509h;

    /* renamed from: i, reason: collision with root package name */
    private Path f7510i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f7511j;

    /* renamed from: k, reason: collision with root package name */
    private C0561c f7512k;

    /* renamed from: l, reason: collision with root package name */
    private C0559a f7513l;

    /* renamed from: m, reason: collision with root package name */
    private C0562d f7514m;

    /* renamed from: n, reason: collision with root package name */
    private C0560b f7515n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7516o;

    /* renamed from: p, reason: collision with root package name */
    private int f7517p;

    /* renamed from: q, reason: collision with root package name */
    private int f7518q;

    /* renamed from: r, reason: collision with root package name */
    private final Paint f7519r;

    /* renamed from: s, reason: collision with root package name */
    private int f7520s;

    /* renamed from: t, reason: collision with root package name */
    private int f7521t;

    /* renamed from: u, reason: collision with root package name */
    private float f7522u;

    /* renamed from: v, reason: collision with root package name */
    private float f7523v;

    /* renamed from: w, reason: collision with root package name */
    private float f7524w;

    /* renamed from: x, reason: collision with root package name */
    private float f7525x;

    /* renamed from: y, reason: collision with root package name */
    private float f7526y;

    /* renamed from: z, reason: collision with root package name */
    private float f7527z;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            COUIButton.this.f7506T = new OplusOutlineAdapter(outline, 1);
            COUIButton.this.f7507U.left = (int) COUIButton.this.f7496J.left;
            COUIButton.this.f7507U.top = (int) COUIButton.this.f7496J.top;
            COUIButton.this.f7507U.right = (int) COUIButton.this.f7496J.right;
            COUIButton.this.f7507U.bottom = (int) COUIButton.this.f7496J.bottom;
            COUIButton.this.f7506T.setSmoothRoundRect(COUIButton.this.f7507U, COUIButton.this.getDrawableRadius());
        }
    }

    public COUIButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11099n);
    }

    private void f(TypedArray typedArray) {
        int f3 = AbstractC0335a.f(getContext(), c.f1362g, 0);
        int resourceId = typedArray.getResourceId(m.f1556h, 0);
        if (f3 == 0 || f3 != resourceId) {
            this.f7521t = typedArray.getColor(m.f1556h, 0);
        } else {
            this.f7521t = AbstractC0335a.a(getContext(), c.f1362g);
        }
    }

    private void g(Canvas canvas) {
        if (this.f7516o) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.f7519r.setStyle(Paint.Style.FILL);
            this.f7519r.setAntiAlias(true);
            if (this.f7517p == 1) {
                this.f7519r.setColor(isEnabled() ? this.f7520s : this.f7521t);
            } else {
                this.f7519r.setColor(l(this.f7520s));
            }
            if (this.f7518q == 1) {
                float drawableRadius = getDrawableRadius();
                canvas.drawRoundRect(this.f7496J, drawableRadius, drawableRadius, this.f7519r);
                if (this.f7517p != 1) {
                    float k3 = (k(this.f7497K) + this.f7527z) - this.f7526y;
                    this.f7519r.setColor(isEnabled() ? this.f7488B : this.f7521t);
                    this.f7519r.setStrokeWidth(this.f7526y);
                    this.f7519r.setStyle(Paint.Style.STROKE);
                    canvas.drawRoundRect(this.f7497K, k3, k3, this.f7519r);
                }
            } else if (p()) {
                canvas.drawRect(this.f7495I, this.f7519r);
                if (this.f7517p == 0) {
                    canvas.save();
                    Path path = this.f7510i;
                    RectF rectF = this.f7497K;
                    m0.c.c(path, rectF, k(rectF), this.f7508V);
                    canvas.clipOutPath(this.f7510i);
                    canvas.drawColor(isEnabled() ? this.f7488B : this.f7521t);
                    canvas.restore();
                }
            } else {
                canvas.drawPath(this.f7509h, this.f7519r);
                if (this.f7517p != 1) {
                    this.f7519r.setColor(isEnabled() ? this.f7488B : this.f7521t);
                    this.f7519r.setStrokeWidth(this.f7526y);
                    this.f7519r.setStyle(Paint.Style.STROKE);
                    b a3 = b.a();
                    RectF rectF2 = this.f7497K;
                    canvas.drawPath(a3.c(rectF2, (k(rectF2) + this.f7527z) - this.f7526y), this.f7519r);
                }
            }
            canvas.restoreToCount(save);
        }
    }

    private int getAnimatorColor() {
        return !isEnabled() ? this.f7521t : androidx.core.graphics.a.i(this.f7513l.z(), this.f7520s);
    }

    private void h(Canvas canvas) {
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        this.f7513l.draw(canvas);
        this.f7514m.draw(canvas);
        canvas.restoreToCount(save);
    }

    private SpannableString i(String str) {
        C0218b c0218b = new C0218b(getContext(), str, this.f7503Q, (this.f7491E - getPaddingStart()) - getPaddingRight(), (this.f7494H - getPaddingStart()) - getPaddingRight(), (this.f7493G - getPaddingBottom()) - getPaddingTop(), getCurrentTextColor(), getPaint(), o());
        SpannableString spannableString = new SpannableString("  ");
        spannableString.setSpan(c0218b, spannableString.length() - 1, spannableString.length(), 33);
        return spannableString;
    }

    private float j(Rect rect) {
        if (this.f7522u < 0.0f && w()) {
            return rect.height() / 2.0f;
        }
        float f3 = this.f7522u;
        return f3 < 0.0f ? (rect.height() / 2.0f) - this.f7527z : f3;
    }

    private float k(RectF rectF) {
        if (this.f7522u < 0.0f && w()) {
            return rectF.height() / 2.0f;
        }
        float f3 = this.f7522u;
        return f3 < 0.0f ? (rectF.height() / 2.0f) - this.f7527z : f3;
    }

    private int l(int i3) {
        return 0;
    }

    private void m(Context context) {
        this.f7487A = context.getResources().getDimension(f.f1435b0);
        Drawable background = getBackground();
        C0559a c0559a = new C0559a(context, 0);
        this.f7513l = c0559a;
        c0559a.C(this.f7509h);
        this.f7513l.setCallback(this);
        C0562d c0562d = new C0562d(context);
        this.f7514m = c0562d;
        c0562d.v(this.f7509h);
        this.f7514m.setCallback(this);
        C0560b c0560b = new C0560b(context);
        this.f7515n = c0560b;
        c0560b.w();
        this.f7515n.x(this.f7509h);
        if (background == null) {
            background = new ColorDrawable(0);
        }
        this.f7512k = new C0561c(new Drawable[]{background, this.f7515n});
        setScaleEnable(this.f7511j);
        super.setBackground(this.f7512k);
        setAnimType(this.f7517p);
    }

    private boolean o() {
        return y.x(this) == 1;
    }

    private boolean p() {
        return AbstractC0481a.a() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(i(charSequence.toString()), bufferType);
    }

    private int r(int i3) {
        if (!this.f7505S || i3 == 0 || getLayoutParams() == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i4 = this.f7491E;
        int i5 = this.f7504R;
        if (i4 <= i5) {
            return 0;
        }
        layoutParams.width = i5;
        return View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
    }

    private void s() {
        if (this.f7499M) {
            performHapticFeedback(302);
        }
    }

    private void u() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.f1440e);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(f.f1442f);
        setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setGravity(17);
        int d3 = (int) AbstractC0597a.d(getResources().getDimensionPixelSize(f.f1438d), getResources().getConfiguration().fontScale);
        setMinHeight(d3);
        setMinimumHeight(d3);
        setMinWidth(0);
        setMinimumWidth(0);
        requestLayout();
    }

    private void v() {
        if (this.f7517p == 1) {
            setBackgroundDrawable(null);
        }
    }

    private boolean w() {
        return p() && this.f7518q == 0;
    }

    private void x() {
        m0.c.a(this.f7509h, this.f7496J, getDrawableRadius());
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (isEnabled() && motionEvent.getActionMasked() == 9) {
            this.f7513l.h();
        }
        if (motionEvent.getActionMasked() == 10 && isHovered()) {
            this.f7513l.c();
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        x();
        super.draw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0559a c0559a = this.f7513l;
        if (c0559a != null) {
            c0559a.setState(getDrawableState());
        }
        C0562d c0562d = this.f7514m;
        if (c0562d != null) {
            c0562d.setState(getDrawableState());
        }
    }

    public String getDescText() {
        return this.f7503Q;
    }

    public int getDrawableColor() {
        return this.f7520s;
    }

    public float getDrawableRadius() {
        return j(this.f7495I);
    }

    public int getMeasureMaxHeight() {
        return this.f7492F;
    }

    public int getMeasureMaxWidth() {
        return this.f7491E;
    }

    public int getRoundType() {
        return this.f7518q;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return (this.f7516o && this.f7517p == 1) ? getAnimatorColor() : super.getSolidColor();
    }

    public float getStrokeWidth() {
        return this.f7526y;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return n() ? this.f7502P : super.getText();
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        invalidate();
    }

    public boolean n() {
        return (!this.f7500N || TextUtils.isEmpty(this.f7502P) || TextUtils.isEmpty(this.f7503Q)) ? false : true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        g(canvas);
        h(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z3, int i3, Rect rect) {
        super.onFocusChanged(z3, i3, rect);
        if (z3) {
            this.f7514m.g();
            this.f7513l.g();
        } else {
            this.f7514m.b();
            this.f7513l.b();
        }
        ViewParent parent = getParent();
        if (this.f7517p == 1 && (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren()) {
            AbstractC0371a.g(f7486W, "Button parent view should set clip children false to make drawing focused stroke effect works.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f7495I.right = getWidth();
        this.f7495I.bottom = getHeight();
        this.f7496J.set(this.f7495I);
        if (w()) {
            RectF rectF = this.f7497K;
            float f3 = this.f7495I.top;
            float f4 = this.f7526y;
            rectF.top = f3 + f4;
            rectF.left = r2.left + f4;
            rectF.right = r2.right - f4;
            rectF.bottom = r2.bottom - f4;
            return;
        }
        RectF rectF2 = this.f7497K;
        float f5 = this.f7495I.top;
        float f6 = this.f7526y;
        rectF2.top = f5 + (f6 / 2.0f);
        rectF2.left = r2.left + (f6 / 2.0f);
        rectF2.right = r2.right - (f6 / 2.0f);
        rectF2.bottom = r2.bottom - (f6 / 2.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        this.f7491E = View.MeasureSpec.getSize(i3);
        this.f7492F = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == 1073741824) {
            this.f7494H = this.f7491E;
        } else {
            this.f7494H = 0;
        }
        if (mode == 1073741824) {
            this.f7493G = this.f7492F;
        } else {
            this.f7493G = 0;
        }
        int r3 = r(mode2);
        if (r3 != 0) {
            i3 = r3;
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (n()) {
            setText(this.f7502P);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f7516o) {
            int action = motionEvent.getAction();
            if (action == 0) {
                s();
                this.f7513l.f();
                this.f7512k.g(true);
            } else if (action == 1 || action == 3) {
                s();
                this.f7513l.e();
                this.f7512k.g(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimEnable(boolean z3) {
        this.f7516o = z3;
    }

    public void setAnimType(int i3) {
        this.f7517p = i3;
        if (i3 == 1 || i3 == 0) {
            this.f7513l.s(true);
            this.f7513l.E(0);
            this.f7514m.s(true);
            this.f7515n.q(false);
        } else if (i3 == 2) {
            this.f7513l.s(true);
            this.f7513l.E(1);
            this.f7514m.s(false);
            this.f7515n.q(false);
        }
        x();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        C0561c c0561c = this.f7512k;
        if (c0561c == null) {
            super.setBackground(drawable);
        } else if (drawable == null) {
            c0561c.h(new ColorDrawable(0));
        } else {
            c0561c.h(drawable);
        }
    }

    public void setDescText(String str) {
        this.f7503Q = str;
        if (n()) {
            setText(getText());
        }
    }

    public void setDisabledColor(int i3) {
        this.f7521t = i3;
    }

    public void setDrawableColor(int i3) {
        this.f7520s = i3;
    }

    public void setDrawableRadius(int i3) {
        this.f7522u = i3;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z3) {
        if (z3 != isEnabled() && n()) {
            setText(this.f7502P);
        }
        super.setEnabled(z3);
    }

    public void setIsNeedVibrate(boolean z3) {
        this.f7499M = z3;
    }

    public void setLimitHeight(boolean z3) {
        this.f7501O = z3;
    }

    public void setMaxBrightness(int i3) {
        this.f7523v = i3;
    }

    @Override // android.widget.TextView
    public void setMinHeight(int i3) {
        int dimensionPixelSize;
        if (n() && i3 < (dimensionPixelSize = getResources().getDimensionPixelSize(f.f1450j))) {
            i3 = dimensionPixelSize;
        }
        super.setMinHeight(i3);
    }

    public void setNeedLimitMaxWidth(boolean z3) {
        this.f7505S = z3;
    }

    public void setOnSizeChangeListener(InterfaceC0291a interfaceC0291a) {
    }

    public void setOnTextChangeListener(b0.b bVar) {
    }

    public void setRoundType(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Invalid roundType" + i3);
        }
        if (this.f7518q != i3) {
            this.f7518q = i3;
            invalidate();
        }
    }

    public void setScaleEnable(boolean z3) {
        this.f7511j = z3;
        C0561c c0561c = this.f7512k;
        if (c0561c != null) {
            if (z3) {
                c0561c.c(this, 2);
            } else {
                c0561c.a();
            }
        }
    }

    public void setStrokeColor(int i3) {
        this.f7488B = i3;
    }

    public void setStrokeWidth(float f3) {
        this.f7526y = f3;
    }

    @Override // android.widget.TextView
    public void setText(final CharSequence charSequence, final TextView.BufferType bufferType) {
        if (!this.f7500N || TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(this.f7503Q)) {
            super.setText(charSequence, bufferType);
        } else {
            post(new Runnable() { // from class: a0.a
                @Override // java.lang.Runnable
                public final void run() {
                    COUIButton.this.q(charSequence, bufferType);
                }
            });
        }
        this.f7502P = charSequence == null ? null : charSequence.toString();
    }

    public void t(boolean z3, String str) {
        if (!z3 || TextUtils.isEmpty(getText()) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f7500N = true;
        this.f7503Q = str;
        u();
        setText(getText());
    }

    public COUIButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        boolean z3;
        this.f7509h = new Path();
        this.f7510i = new Path();
        this.f7511j = true;
        this.f7519r = new Paint(1);
        this.f7522u = 21.0f;
        this.f7524w = 1.0f;
        this.f7525x = 1.0f;
        this.f7490D = 0;
        this.f7495I = new Rect();
        this.f7496J = new RectF();
        this.f7497K = new RectF();
        this.f7498L = new float[3];
        this.f7501O = true;
        this.f7505S = false;
        this.f7507U = new Rect();
        if (attributeSet == null || attributeSet.getStyleAttribute() == 0) {
            this.f7489C = i3;
        } else {
            this.f7489C = attributeSet.getStyleAttribute();
        }
        AbstractC0342a.b(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1542a, i3, 0);
        this.f7516o = obtainStyledAttributes.getBoolean(m.f1544b, false);
        this.f7517p = obtainStyledAttributes.getInteger(m.f1546c, 1);
        this.f7518q = obtainStyledAttributes.getInteger(m.f1552f, 0);
        this.f7499M = obtainStyledAttributes.getBoolean(m.f1568n, true);
        this.f7511j = obtainStyledAttributes.getBoolean(m.f1572p, this.f7511j);
        if (this.f7516o) {
            this.f7523v = obtainStyledAttributes.getFloat(m.f1548d, 0.8f);
            this.f7522u = obtainStyledAttributes.getDimension(m.f1560j, -1.0f);
            f(obtainStyledAttributes);
            this.f7520s = obtainStyledAttributes.getColor(m.f1558i, 0);
            this.f7488B = obtainStyledAttributes.getColor(m.f1574q, 0);
            this.f7490D = obtainStyledAttributes.getInteger(m.f1570o, 0);
            z3 = obtainStyledAttributes.getBoolean(m.f1550e, false);
            v();
        } else {
            z3 = false;
        }
        this.f7526y = obtainStyledAttributes.getDimension(m.f1576r, context.getResources().getDimension(f.f1436c));
        this.f7504R = getResources().getDimensionPixelSize(f.f1427V);
        boolean z4 = obtainStyledAttributes.getBoolean(m.f1562k, false);
        this.f7500N = z4;
        if (z4 && !TextUtils.isEmpty(getText())) {
            this.f7503Q = obtainStyledAttributes.getString(m.f1554g);
            this.f7502P = getText().toString();
            if (n()) {
                t(this.f7500N, this.f7503Q);
            }
        }
        obtainStyledAttributes.recycle();
        this.f7527z = getResources().getDimension(f.f1451k);
        if (!z3) {
            AbstractC0597a.b(this, 4);
        }
        m(context);
        if (w()) {
            setOutlineProvider(new a());
            setClipToOutline(true);
            i.b(this);
            this.f7508V = AbstractC0335a.e(getContext(), c.f1351I);
        }
    }
}
