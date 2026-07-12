package y1;

import Z.b;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import t1.AbstractC0589c;

/* loaded from: classes.dex */
public class t extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private Context f14629e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f14630f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f14631g;

    /* renamed from: h, reason: collision with root package name */
    private int f14632h;

    /* renamed from: i, reason: collision with root package name */
    private float f14633i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14634j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f14635k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f14636l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f14637m;

    /* renamed from: n, reason: collision with root package name */
    private int f14638n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f14639o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f14640p;

    /* renamed from: q, reason: collision with root package name */
    private BitmapDrawable f14641q;

    /* renamed from: r, reason: collision with root package name */
    private Z.c f14642r;

    /* renamed from: s, reason: collision with root package name */
    private ObjectAnimator f14643s;

    /* renamed from: t, reason: collision with root package name */
    private b.q f14644t;

    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f14645a;

        a(t tVar, float f3) {
            this.f14645a = f3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f14645a);
        }
    }

    public t(Context context) {
        this(context, null);
    }

    private void c() {
        setMaskBackground(this.f14629e.getColor(AbstractC0589c.f13368g));
    }

    private void d() {
        View inflate = ((LayoutInflater) this.f14629e.getSystemService("layout_inflater")).inflate(t1.h.f13475h, this);
        this.f14630f = (ImageView) inflate.findViewById(t1.f.f13452l);
        this.f14631g = (FrameLayout) inflate.findViewById(t1.f.f13453m);
        this.f14636l = (TextView) inflate.findViewById(t1.f.f13455o);
        this.f14637m = (ImageView) inflate.findViewById(t1.f.f13458r);
        this.f14632h = getResources().getDimensionPixelSize(t1.d.f13387p);
        this.f14638n = getResources().getDimensionPixelSize(t1.d.f13388q);
        setPivotX(0.0f);
        setPivotY(0.0f);
        setVisibility(8);
        setAlpha(0.0f);
        bringToFront();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str, Z.b bVar, boolean z3, float f3, float f4) {
        this.f14636l.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, Z.b bVar, boolean z3, float f3, float f4) {
        this.f14636l.setText(str);
    }

    public void g() {
        FrameLayout frameLayout = this.f14631g;
        if (frameLayout != null) {
            frameLayout.setOutlineProvider(null);
            this.f14631g.setClipToOutline(false);
        }
        ImageView imageView = this.f14630f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f14635k = null;
        }
        this.f14641q = null;
        this.f14640p = false;
    }

    public ImageView getCloseOverlayView() {
        return this.f14637m;
    }

    public ObjectAnimator getCustomAlphaAnim() {
        return this.f14643s;
    }

    public ImageView getIconView() {
        return this.f14630f;
    }

    public TextView getTextView() {
        return this.f14636l;
    }

    public void h(Bitmap bitmap) {
        if (bitmap == null || this.f14634j) {
            this.f14631g.setBackgroundColor(this.f14629e.getColor(AbstractC0589c.f13368g));
            return;
        }
        if (this.f14641q == null || this.f14640p) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            this.f14641q = bitmapDrawable;
            this.f14631g.setBackground(bitmapDrawable);
            this.f14640p = false;
        }
    }

    public void i(Drawable drawable) {
        this.f14631g.setBackground(drawable);
    }

    public void j(u uVar, float f3, boolean z3) {
        this.f14634j = z3;
        if (uVar.a() != Integer.MIN_VALUE) {
            setMaskBackground(uVar.a());
        }
        if (uVar.g() != -2.14748365E9f) {
            setMaskAlpha(uVar.g());
        }
        this.f14633i = f3;
        if (uVar.d() != null) {
            setIconDrawable(uVar.d());
        } else {
            this.f14630f.setVisibility(8);
        }
        setMaskColor(uVar.f() == 0);
        setMaskText(uVar.i());
        if (f3 > 0.0f) {
            setCornerRadius(f3);
        }
        if (uVar.j() && uVar.c() == null) {
            h(uVar.b());
            if (this.f14637m.getVisibility() == 0) {
                this.f14637m.setVisibility(8);
                this.f14636l.setAlpha(1.0f);
                this.f14630f.setAlpha(1.0f);
                return;
            }
            return;
        }
        if (uVar.c() != null) {
            this.f14640p = true;
            i(uVar.c());
            BitmapDrawable bitmapDrawable = this.f14641q;
            if (bitmapDrawable == null) {
                this.f14637m.setBackgroundColor(this.f14629e.getColor(AbstractC0589c.f13368g));
            } else {
                this.f14637m.setBackground(bitmapDrawable);
            }
            this.f14637m.setVisibility(0);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14639o = (configuration.uiMode & 32) != 0;
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        this.f14631g.layout(0, 0, i7, i8);
        this.f14637m.layout(0, 0, i7, i8);
        if (getVisibility() == 8) {
            this.f14630f.setImageDrawable(null);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f14636l.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f14632h + (this.f14638n / 2) + (this.f14636l.getMeasuredHeight() / 2);
        if (!B1.s.w(this.f14629e)) {
            ImageView imageView = this.f14630f;
            int i9 = i7 / 2;
            int i10 = this.f14632h;
            int i11 = i8 / 2;
            int i12 = i11 - measuredHeight;
            imageView.layout(i9 - i10, i12, i9 + i10, (i10 * 2) + i12);
            TextPaint paint = this.f14636l.getPaint();
            double d3 = i7 / 2.0d;
            int i13 = i11 + measuredHeight;
            this.f14636l.layout((int) Math.floor(d3 - Math.max(0.0f, Layout.getDesiredWidth(r4.getText().toString(), paint) / 2.0f)), i13 - Math.max(0, this.f14636l.getMeasuredHeight()), (int) Math.ceil(d3 + Math.max(0.0f, Layout.getDesiredWidth(this.f14636l.getText().toString(), paint) / 2.0f)), i13);
            return;
        }
        ImageView imageView2 = this.f14630f;
        int i14 = i7 / 2;
        int i15 = this.f14632h;
        int i16 = i8 / 2;
        imageView2.layout(i14 - i15, i16 - i15, i14 + i15, i15 + i16);
        TextPaint paint2 = this.f14636l.getPaint();
        int b3 = B1.s.b(16.0f, this.f14629e.getResources());
        double d4 = i7 / 2.0d;
        int max = Math.max((int) Math.floor(d4 - Math.max(0.0f, Layout.getDesiredWidth(this.f14636l.getText().toString(), paint2) / 2.0f)), b3);
        int min = Math.min((int) Math.ceil(d4 + Math.max(0.0f, Layout.getDesiredWidth(this.f14636l.getText().toString(), paint2) / 2.0f)), i7 - b3);
        int i17 = this.f14632h;
        int i18 = this.f14638n;
        this.f14636l.layout(max, i16 + i17 + i18, min, i16 + i17 + i18 + Math.max(0, this.f14636l.getMeasuredHeight() * 2));
    }

    public void setCornerRadius(float f3) {
        FrameLayout frameLayout = this.f14631g;
        if (frameLayout != null) {
            frameLayout.setOutlineProvider(null);
            this.f14631g.setOutlineProvider(new a(this, f3));
            this.f14631g.setClipToOutline(true);
            this.f14633i = f3;
        }
    }

    public void setCustomAlphaAnim(ObjectAnimator objectAnimator) {
        this.f14643s = objectAnimator;
    }

    public void setIconDrawable(Drawable drawable) {
        ImageView imageView = this.f14630f;
        if (imageView == null || imageView.getDrawable() == drawable) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new Y.e());
        this.f14630f.setImageDrawable(drawable);
        this.f14630f.setAnimation(alphaAnimation);
    }

    public void setIconView(ImageView imageView) {
        this.f14630f = imageView;
    }

    public void setIsSystemAnimating(boolean z3) {
        this.f14634j = z3;
    }

    public void setMaskAlpha(float f3) {
        if (f3 == 1.0f) {
            this.f14630f.setVisibility(0);
            this.f14636l.setVisibility(0);
        }
        this.f14631g.setAlpha(f3);
    }

    public void setMaskBackground(int i3) {
        if (i3 != this.f14629e.getColor(AbstractC0589c.f13368g)) {
            this.f14630f.setVisibility(8);
            this.f14636l.setVisibility(8);
            this.f14631g.setBackgroundColor(i3);
        } else {
            this.f14630f.setVisibility(0);
            this.f14636l.setVisibility(0);
            BitmapDrawable bitmapDrawable = this.f14641q;
            if (bitmapDrawable != null) {
                this.f14631g.setBackground(bitmapDrawable);
            }
        }
    }

    public void setMaskColor(boolean z3) {
        TextView textView = this.f14636l;
        if (textView != null) {
            if (z3) {
                if (this.f14639o) {
                    textView.setTextColor(androidx.core.content.a.c(this.f14629e, AbstractC0589c.f13370i));
                    return;
                } else {
                    textView.setTextColor(androidx.core.content.a.c(this.f14629e, AbstractC0589c.f13371j));
                    return;
                }
            }
            if (this.f14639o) {
                textView.setTextColor(androidx.core.content.a.c(this.f14629e, AbstractC0589c.f13371j));
            } else {
                textView.setTextColor(androidx.core.content.a.c(this.f14629e, AbstractC0589c.f13370i));
            }
        }
    }

    public void setMaskText(final String str) {
        float f3;
        if (this.f14636l == null) {
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.f14636l.getText())) {
            return;
        }
        float f4 = 1.0f;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f14636l.getText())) {
            if (this.f14636l.getAlpha() != 1.0f) {
                this.f14642r.i(this.f14644t);
            }
            this.f14636l.setText(str);
            return;
        }
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f14636l.getText())) {
            f3 = 1.0f;
            f4 = 0.0f;
        } else {
            f3 = 0.0f;
        }
        Z.c cVar = this.f14642r;
        if (cVar != null && cVar.h()) {
            this.f14642r.i(this.f14644t);
            b.q qVar = new b.q() { // from class: y1.r
                @Override // Z.b.q
                public final void onAnimationEnd(Z.b bVar, boolean z3, float f5, float f6) {
                    t.this.e(str, bVar, z3, f5, f6);
                }
            };
            this.f14644t = qVar;
            this.f14642r.a(qVar);
            if (!TextUtils.isEmpty(str)) {
                this.f14636l.setText(str);
                this.f14636l.setAlpha(f4);
            }
            this.f14642r.u(f3);
            return;
        }
        Z.c cVar2 = new Z.c(this.f14636l, Z.b.f3022A, f3);
        this.f14642r = cVar2;
        cVar2.o(f4);
        this.f14642r.x().d(0.0f).g(0.2f);
        b.q qVar2 = new b.q() { // from class: y1.s
            @Override // Z.b.q
            public final void onAnimationEnd(Z.b bVar, boolean z3, float f5, float f6) {
                t.this.f(str, bVar, z3, f5, f6);
            }
        };
        this.f14644t = qVar2;
        this.f14642r.a(qVar2);
        if (!TextUtils.isEmpty(str)) {
            this.f14636l.setText(str);
            this.f14636l.setAlpha(f4);
        }
        this.f14642r.r();
    }

    @Override // android.view.View
    public void setScaleX(float f3) {
        if (Float.isNaN(f3) || Float.isInfinite(f3)) {
            return;
        }
        super.setScaleX(f3);
        ImageView imageView = this.f14630f;
        if (imageView != null && f3 != 0.0f) {
            imageView.setScaleX(1.0f / f3);
        }
        TextView textView = this.f14636l;
        if (textView != null && f3 != 0.0f) {
            textView.setScaleX(1.0f / f3);
        }
        setCornerRadius(this.f14633i + (f3 * 0.001f));
    }

    @Override // android.view.View
    public void setScaleY(float f3) {
        if (Float.isNaN(f3) || Float.isInfinite(f3)) {
            return;
        }
        super.setScaleY(f3);
        ImageView imageView = this.f14630f;
        if (imageView != null && f3 != 0.0f) {
            imageView.setScaleY(1.0f / f3);
        }
        TextView textView = this.f14636l;
        if (textView == null || f3 == 0.0f) {
            return;
        }
        textView.setScaleY(1.0f / f3);
    }

    public void setTextView(TextView textView) {
        this.f14636l = textView;
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f14640p = false;
        this.f14642r = null;
        this.f14643s = null;
        this.f14629e = context;
        this.f14639o = (context.getResources().getConfiguration().uiMode & 32) != 0;
        d();
    }
}
