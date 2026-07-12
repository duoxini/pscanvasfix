package com.coui.appcompat.edittext;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import androidx.core.view.AbstractC0256e;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import java.util.ArrayList;
import java.util.Locale;
import u0.AbstractC0597a;

/* loaded from: classes.dex */
public class a extends GradientDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f7871a = new Paint(1);

    /* renamed from: b, reason: collision with root package name */
    private final RectF f7872b;

    /* renamed from: c, reason: collision with root package name */
    private int f7873c;

    /* renamed from: com.coui.appcompat.edittext.a$a, reason: collision with other inner class name */
    public static final class C0101a {

        /* renamed from: L, reason: collision with root package name */
        private static final boolean f7874L = false;

        /* renamed from: M, reason: collision with root package name */
        private static final Paint f7875M = null;

        /* renamed from: A, reason: collision with root package name */
        private Paint f7876A;

        /* renamed from: B, reason: collision with root package name */
        private float f7877B;

        /* renamed from: C, reason: collision with root package name */
        private float f7878C;

        /* renamed from: D, reason: collision with root package name */
        private float f7879D;

        /* renamed from: E, reason: collision with root package name */
        private float f7880E;

        /* renamed from: F, reason: collision with root package name */
        private int[] f7881F;

        /* renamed from: G, reason: collision with root package name */
        private boolean f7882G;

        /* renamed from: H, reason: collision with root package name */
        private Interpolator f7883H;

        /* renamed from: I, reason: collision with root package name */
        private Interpolator f7884I;

        /* renamed from: J, reason: collision with root package name */
        private float f7885J;

        /* renamed from: a, reason: collision with root package name */
        private final View f7887a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f7888b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f7889c;

        /* renamed from: d, reason: collision with root package name */
        private final RectF f7890d;

        /* renamed from: e, reason: collision with root package name */
        private final TextPaint f7891e;

        /* renamed from: f, reason: collision with root package name */
        private final TextPaint f7892f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f7893g;

        /* renamed from: h, reason: collision with root package name */
        private float f7894h;

        /* renamed from: m, reason: collision with root package name */
        private ColorStateList f7899m;

        /* renamed from: n, reason: collision with root package name */
        private ColorStateList f7900n;

        /* renamed from: o, reason: collision with root package name */
        private float f7901o;

        /* renamed from: p, reason: collision with root package name */
        private float f7902p;

        /* renamed from: q, reason: collision with root package name */
        private float f7903q;

        /* renamed from: r, reason: collision with root package name */
        private float f7904r;

        /* renamed from: s, reason: collision with root package name */
        private float f7905s;

        /* renamed from: t, reason: collision with root package name */
        private float f7906t;

        /* renamed from: u, reason: collision with root package name */
        private CharSequence f7907u;

        /* renamed from: v, reason: collision with root package name */
        private CharSequence f7908v;

        /* renamed from: x, reason: collision with root package name */
        private boolean f7910x;

        /* renamed from: y, reason: collision with root package name */
        private boolean f7911y;

        /* renamed from: z, reason: collision with root package name */
        private Bitmap f7912z;

        /* renamed from: i, reason: collision with root package name */
        private int f7895i = 16;

        /* renamed from: j, reason: collision with root package name */
        private int f7896j = 16;

        /* renamed from: k, reason: collision with root package name */
        private float f7897k = 30.0f;

        /* renamed from: l, reason: collision with root package name */
        private float f7898l = 30.0f;

        /* renamed from: w, reason: collision with root package name */
        private ArrayList f7909w = new ArrayList();

        /* renamed from: K, reason: collision with root package name */
        private int f7886K = 1;

        public C0101a(View view) {
            this.f7887a = view;
            TextPaint textPaint = new TextPaint(129);
            this.f7891e = textPaint;
            this.f7892f = new TextPaint(textPaint);
            this.f7889c = new Rect();
            this.f7888b = new Rect();
            this.f7890d = new RectF();
        }

        private TextDirectionHeuristic A() {
            return E() ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }

        private void B(TextPaint textPaint) {
            textPaint.setTextSize(this.f7898l);
        }

        private void C(float f3) {
            this.f7890d.left = H(this.f7888b.left, this.f7889c.left, f3, this.f7883H);
            this.f7890d.top = H(this.f7901o, this.f7902p, f3, this.f7883H);
            this.f7890d.right = H(this.f7888b.right, this.f7889c.right, f3, this.f7883H);
            this.f7890d.bottom = H(this.f7888b.bottom, this.f7889c.bottom, f3, this.f7883H);
        }

        private static boolean D(float f3, float f4) {
            return Math.abs(f3 - f4) < 0.001f;
        }

        private boolean E() {
            return this.f7887a.getLayoutDirection() == 1;
        }

        private static float G(float f3, float f4, float f5) {
            return f3 + (f5 * (f4 - f3));
        }

        private static float H(float f3, float f4, float f5, Interpolator interpolator) {
            if (interpolator != null) {
                f5 = interpolator.getInterpolation(f5);
            }
            return G(f3, f4, f5);
        }

        private void I() {
            this.f7893g = this.f7889c.width() > 0 && this.f7889c.height() > 0 && this.f7888b.width() > 0 && this.f7888b.height() > 0;
        }

        private static boolean K(Rect rect, int i3, int i4, int i5, int i6) {
            return rect.left == i3 && rect.top == i4 && rect.right == i5 && rect.bottom == i6;
        }

        private void W(float f3) {
            h(f3);
            boolean z3 = f7874L && this.f7879D != 1.0f;
            this.f7911y = z3;
            if (z3) {
                l();
            }
            this.f7887a.postInvalidate();
        }

        private static int a(int i3, int i4, float f3) {
            float f4 = 1.0f - f3;
            return Color.argb((int) ((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3)), (int) ((Color.red(i3) * f4) + (Color.red(i4) * f3)), (int) ((Color.green(i3) * f4) + (Color.green(i4) * f3)), (int) ((Color.blue(i3) * f4) + (Color.blue(i4) * f3)));
        }

        private void b() {
            float f3 = this.f7880E;
            h(this.f7898l);
            float g3 = g();
            int b3 = AbstractC0256e.b(this.f7896j, this.f7910x ? 1 : 0);
            if (this.f7886K <= 1) {
                int i3 = b3 & FeedbackActivity.SHOW_NO_NETWORK;
                if (i3 != 48) {
                    if (i3 != 80) {
                        this.f7902p = this.f7889c.centerY() + (((this.f7891e.descent() - this.f7891e.ascent()) / 2.0f) - this.f7891e.descent());
                    } else {
                        this.f7902p = this.f7889c.bottom;
                    }
                } else if (Locale.getDefault().getLanguage().equals("my")) {
                    this.f7902p = this.f7889c.top - (this.f7891e.ascent() * 1.3f);
                } else {
                    this.f7902p = this.f7889c.top - this.f7891e.ascent();
                }
            } else if (Locale.getDefault().getLanguage().equals("my")) {
                this.f7902p = this.f7889c.top - (this.f7891e.ascent() * 1.3f);
            } else {
                this.f7902p = this.f7889c.top - this.f7891e.ascent();
            }
            int i4 = b3 & 8388615;
            if (i4 == 1) {
                this.f7904r = this.f7889c.centerX() - (g3 / 2.0f);
            } else if (i4 != 5) {
                this.f7904r = this.f7889c.left;
            } else {
                this.f7904r = this.f7889c.right - g3;
            }
            h(this.f7897k);
            float g4 = g();
            int b4 = AbstractC0256e.b(this.f7895i, this.f7910x ? 1 : 0);
            if (this.f7886K > 1) {
                this.f7901o = this.f7888b.top - this.f7891e.ascent();
            } else {
                int i5 = b4 & FeedbackActivity.SHOW_NO_NETWORK;
                if (i5 == 48) {
                    this.f7901o = this.f7888b.top - this.f7891e.ascent();
                } else if (i5 != 80) {
                    this.f7901o = this.f7888b.centerY() + (((this.f7891e.getFontMetrics().bottom - this.f7891e.getFontMetrics().top) / 2.0f) - this.f7891e.getFontMetrics().bottom);
                } else {
                    this.f7901o = this.f7888b.bottom;
                }
            }
            int i6 = b4 & 8388615;
            if (i6 == 1) {
                this.f7903q = this.f7888b.centerX() - (g4 / 2.0f);
            } else if (i6 != 5) {
                this.f7903q = this.f7888b.left;
            } else {
                this.f7903q = this.f7888b.right - g4;
            }
            i();
            W(f3);
        }

        private void d() {
            f(this.f7894h);
        }

        private boolean e(CharSequence charSequence) {
            return E();
        }

        private void f(float f3) {
            C(f3);
            this.f7905s = H(this.f7903q, this.f7904r, f3, this.f7883H);
            this.f7906t = H(this.f7901o, this.f7902p, f3, this.f7883H);
            W(H(this.f7897k, this.f7898l, f3, this.f7884I));
            if (this.f7900n != this.f7899m) {
                this.f7891e.setColor(a(s(), r(), f3));
            } else {
                this.f7891e.setColor(r());
            }
            this.f7887a.postInvalidate();
        }

        private float g() {
            CharSequence charSequence = this.f7908v;
            float measureText = charSequence != null ? this.f7891e.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            return (this.f7886K <= 1 || this.f7908v == null || this.f7909w.isEmpty()) ? measureText : Math.max(this.f7891e.measureText(((CharSequence) this.f7909w.get(0)).toString()), measureText);
        }

        private void h(float f3) {
            float f4;
            boolean z3;
            if (this.f7907u == null) {
                return;
            }
            float width = this.f7889c.width();
            float width2 = this.f7888b.width();
            if (D(f3, this.f7898l)) {
                f4 = this.f7898l;
                this.f7879D = 1.0f;
            } else {
                float f5 = this.f7897k;
                if (D(f3, f5)) {
                    this.f7879D = 1.0f;
                } else {
                    this.f7879D = f3 / this.f7897k;
                }
                float f6 = this.f7898l / this.f7897k;
                width = width2 * f6 > width ? Math.min(width / f6, width2) : width2;
                f4 = f5;
            }
            if (width > 0.0f) {
                z3 = this.f7880E != f4 || this.f7882G;
                this.f7880E = f4;
                this.f7882G = false;
            } else {
                z3 = false;
            }
            if (this.f7908v == null || z3) {
                this.f7891e.setTextSize(this.f7880E);
                this.f7891e.setLinearText(this.f7879D != 1.0f);
                CharSequence ellipsize = TextUtils.ellipsize(this.f7907u, this.f7891e, width - this.f7885J, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f7908v)) {
                    this.f7908v = ellipsize;
                }
            }
            this.f7910x = E();
        }

        private void i() {
            Bitmap bitmap = this.f7912z;
            if (bitmap != null) {
                bitmap.recycle();
                this.f7912z = null;
            }
        }

        private float j(float f3, float f4, float f5) {
            return f3 < f4 ? f4 : f3 > f5 ? f5 : f3;
        }

        private void l() {
            if (this.f7912z != null || this.f7888b.isEmpty() || TextUtils.isEmpty(this.f7908v)) {
                return;
            }
            f(0.0f);
            this.f7877B = this.f7891e.ascent();
            this.f7878C = this.f7891e.descent();
            TextPaint textPaint = this.f7891e;
            CharSequence charSequence = this.f7908v;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.f7878C - this.f7877B);
            if (round <= 0 || round2 <= 0) {
                return;
            }
            this.f7912z = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f7912z);
            CharSequence charSequence2 = this.f7908v;
            canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.f7891e.descent(), this.f7891e);
            if (this.f7876A == null) {
                this.f7876A = new Paint(3);
            }
        }

        private int s() {
            int[] iArr = this.f7881F;
            return iArr != null ? this.f7899m.getColorForState(iArr, 0) : this.f7899m.getDefaultColor();
        }

        final boolean F() {
            ColorStateList colorStateList;
            ColorStateList colorStateList2 = this.f7900n;
            return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f7899m) != null && colorStateList.isStateful());
        }

        public void J() {
            if (this.f7887a.getHeight() <= 0 || this.f7887a.getWidth() <= 0) {
                return;
            }
            b();
            d();
        }

        public void L(int i3, int i4, int i5, int i6) {
            if (K(this.f7889c, i3, i4, i5, i6)) {
                return;
            }
            this.f7889c.set(i3, i4, i5, i6);
            this.f7882G = true;
            I();
            Log.d("COUICollapseTextHelper", "setCollapsedBounds: " + this.f7889c);
        }

        public void M(int i3, ColorStateList colorStateList) {
            this.f7900n = colorStateList;
            this.f7898l = i3;
            J();
        }

        public void N(ColorStateList colorStateList) {
            if (this.f7900n != colorStateList) {
                this.f7900n = colorStateList;
                J();
            }
        }

        public void O(int i3) {
            if (this.f7896j != i3) {
                this.f7896j = i3;
                J();
            }
        }

        public void P(int i3, int i4, int i5, int i6) {
            if (K(this.f7888b, i3, i4, i5, i6)) {
                return;
            }
            this.f7888b.set(i3, i4, i5, i6);
            this.f7882G = true;
            I();
            Log.d("COUICollapseTextHelper", "setExpandedBounds: " + this.f7888b);
        }

        public void Q(ColorStateList colorStateList) {
            if (this.f7899m != colorStateList) {
                this.f7899m = colorStateList;
                J();
            }
        }

        public void R(int i3) {
            if (this.f7895i != i3) {
                this.f7895i = i3;
                J();
            }
        }

        public void S(float f3) {
            if (this.f7897k != f3) {
                this.f7897k = f3;
                J();
            }
        }

        public void T(float f3) {
            float j3 = j(f3, 0.0f, 1.0f);
            if (j3 != this.f7894h) {
                this.f7894h = j3;
                d();
            }
        }

        public void U(int i3) {
            this.f7886K = Math.min(3, Math.max(1, i3));
        }

        public void V(float f3) {
            if (f3 > 0.0f) {
                this.f7885J = f3;
            }
        }

        public void X(Interpolator interpolator) {
            this.f7883H = interpolator;
            J();
        }

        public final boolean Y(int[] iArr) {
            this.f7881F = iArr;
            if (!F()) {
                return false;
            }
            J();
            return true;
        }

        public void Z(CharSequence charSequence) {
            if (charSequence == null || !charSequence.equals(this.f7907u)) {
                this.f7907u = charSequence;
                this.f7908v = null;
                this.f7909w.clear();
                i();
                J();
            }
        }

        public void a0(Interpolator interpolator) {
            this.f7884I = interpolator;
            J();
        }

        public void b0(Typeface typeface) {
            AbstractC0597a.a(this.f7891e, true);
            AbstractC0597a.a(this.f7892f, true);
            J();
        }

        public float c() {
            if (this.f7907u == null) {
                return 0.0f;
            }
            B(this.f7892f);
            TextPaint textPaint = this.f7892f;
            CharSequence charSequence = this.f7907u;
            return textPaint.measureText(charSequence, 0, charSequence.length());
        }

        public void k(Canvas canvas) {
            float ascent;
            int save = canvas.save();
            float f3 = 0.0f;
            if (this.f7908v == null || !this.f7893g) {
                canvas.drawText(" ", 0.0f, 0.0f, this.f7891e);
            } else {
                float f4 = this.f7905s;
                float f5 = this.f7906t;
                boolean z3 = this.f7911y && this.f7912z != null;
                if (z3) {
                    ascent = this.f7877B * this.f7879D;
                } else {
                    ascent = this.f7891e.ascent() * this.f7879D;
                    this.f7891e.descent();
                }
                if (z3) {
                    f5 += ascent;
                }
                float f6 = this.f7879D;
                float f7 = 1.0f;
                if (f6 != 1.0f) {
                    canvas.scale(f6, f6, f4, f5);
                }
                if (z3) {
                    canvas.drawBitmap(this.f7912z, f4, f5, this.f7876A);
                } else {
                    View view = this.f7887a;
                    if (view instanceof EditText) {
                        EditText editText = (EditText) view;
                        f3 = editText.getLineSpacingExtra();
                        f7 = editText.getLineSpacingMultiplier();
                    }
                    CharSequence charSequence = this.f7886K > 1 ? this.f7907u : this.f7908v;
                    StaticLayout build = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f7891e, (int) this.f7890d.width()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(true).setEllipsize(TextUtils.TruncateAt.END).setTextDirection(A()).setMaxLines(this.f7886K).setLineSpacing(f3, f7).build();
                    if (build != null) {
                        canvas.save();
                        canvas.translate(this.f7910x ? this.f7890d.left - this.f7885J : this.f7890d.left + this.f7885J, f5 - build.getLineBaseline(0));
                        build.draw(canvas);
                        canvas.restore();
                    }
                }
            }
            canvas.restoreToCount(save);
        }

        public Rect m() {
            return this.f7889c;
        }

        public void n(RectF rectF) {
            boolean e3 = e(this.f7907u);
            float c3 = !e3 ? this.f7889c.left : this.f7889c.right - c();
            rectF.left = c3;
            Rect rect = this.f7889c;
            rectF.top = rect.top;
            rectF.right = !e3 ? c3 + c() : rect.right;
            rectF.bottom = this.f7889c.top + q();
        }

        public ColorStateList o() {
            return this.f7900n;
        }

        public int p() {
            return this.f7896j;
        }

        public float q() {
            B(this.f7892f);
            return Locale.getDefault().getLanguage().equals("my") ? (-this.f7892f.ascent()) * 1.3f : -this.f7892f.ascent();
        }

        public int r() {
            ColorStateList colorStateList = this.f7900n;
            if (colorStateList == null) {
                return 0;
            }
            int[] iArr = this.f7881F;
            return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
        }

        public Rect t() {
            return this.f7888b;
        }

        ColorStateList u() {
            return this.f7899m;
        }

        public int v() {
            return this.f7895i;
        }

        float w() {
            return this.f7897k;
        }

        public float x() {
            return this.f7894h;
        }

        public float y() {
            B(this.f7892f);
            float descent = this.f7892f.descent() - this.f7892f.ascent();
            return Locale.getDefault().getLanguage().equals("my") ? descent * 1.3f : descent;
        }

        CharSequence z() {
            return this.f7907u;
        }
    }

    public a() {
        i();
        this.f7872b = new RectF();
    }

    private void c(Canvas canvas) {
        if (j(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f7873c);
    }

    private void d(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (j(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            f(canvas);
        }
    }

    private void f(Canvas canvas) {
        this.f7873c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void i() {
        this.f7871a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7871a.setColor(-1);
        this.f7871a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean j(Drawable.Callback callback) {
        return callback instanceof View;
    }

    public RectF a() {
        return this.f7872b;
    }

    public boolean b() {
        return !this.f7872b.isEmpty();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        d(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f7872b, this.f7871a);
        c(canvas);
    }

    public void e() {
        g(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void g(float f3, float f4, float f5, float f6) {
        RectF rectF = this.f7872b;
        if (f3 == rectF.left && f4 == rectF.top && f5 == rectF.right && f6 == rectF.bottom) {
            return;
        }
        rectF.set(f3, f4, f5, f6);
        invalidateSelf();
    }

    public void h(RectF rectF) {
        g(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
