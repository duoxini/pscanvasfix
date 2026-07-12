package com.coui.appcompat.tips;

import D2.g;
import D2.k;
import Y.d;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.display.DisplayManager;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.Display;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.widget.C0251z;
import androidx.preference.Preference;
import f2.AbstractC0361c;
import h0.AbstractC0371a;
import java.util.List;

/* loaded from: classes.dex */
public final class COUIMarqueeTextView extends C0251z {

    /* renamed from: v, reason: collision with root package name */
    public static final a f9291v = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private String f9292e;

    /* renamed from: f, reason: collision with root package name */
    private String f9293f;

    /* renamed from: g, reason: collision with root package name */
    private int f9294g;

    /* renamed from: h, reason: collision with root package name */
    private float f9295h;

    /* renamed from: i, reason: collision with root package name */
    private float f9296i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9297j;

    /* renamed from: k, reason: collision with root package name */
    private int f9298k;

    /* renamed from: l, reason: collision with root package name */
    private String f9299l;

    /* renamed from: m, reason: collision with root package name */
    private int f9300m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f9301n;

    /* renamed from: o, reason: collision with root package name */
    private b f9302o;

    /* renamed from: p, reason: collision with root package name */
    private final int f9303p;

    /* renamed from: q, reason: collision with root package name */
    private float f9304q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9305r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9306s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f9307t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f9308u;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    private final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIMarqueeTextView.this.d();
        }
    }

    public COUIMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void c() {
        String str = this.f9292e;
        StaticLayout build = StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), getWidth()).build();
        k.d(build, "if (Build.VERSION.SDK_IN… 1f, 0f, false)\n        }");
        this.f9307t = true;
        int length = this.f9292e.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (build.isRtlCharAt(i3)) {
                this.f9307t = false;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(COUIMarqueeTextView cOUIMarqueeTextView, ValueAnimator valueAnimator) {
        k.e(cOUIMarqueeTextView, "this$0");
        k.e(valueAnimator, "it");
        cOUIMarqueeTextView.f9296i -= cOUIMarqueeTextView.f9295h;
        cOUIMarqueeTextView.invalidate();
    }

    private final String f() {
        int ceil = (int) Math.ceil(this.f9303p / getPaint().measureText(" "));
        String str = this.f9303p != 0 ? "" : " ";
        if (ceil >= 0) {
            int i3 = 0;
            while (true) {
                str = str + ' ';
                if (i3 == ceil) {
                    break;
                }
                i3++;
            }
        }
        return str;
    }

    private final void g() {
        Display display = ((DisplayManager) getContext().getSystemService(DisplayManager.class)).getDisplay(0);
        getResources().getDisplayMetrics();
        this.f9295h = getResources().getDimensionPixelOffset(AbstractC0361c.f11603j) / display.getRefreshRate();
        this.f9302o = new b();
    }

    private final float getMContentHeight() {
        return Math.abs(getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top) / 2;
    }

    private final void h() {
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(getResources().getDimensionPixelSize(AbstractC0361c.f11602i));
        this.f9296i = getResources().getDimensionPixelOffset(AbstractC0361c.f11605l);
        getPaint().setColor(getCurrentTextColor());
        setImportantForAccessibility(1);
    }

    private final void i() {
        this.f9299l = this.f9292e;
        this.f9299l += f();
        int i3 = 0;
        this.f9298k = 0;
        this.f9300m = (int) getPaint().measureText(this.f9299l);
        int ceil = (int) Math.ceil((getMeasuredWidth() / this.f9300m) + 1.0d);
        this.f9293f = this.f9299l;
        if (ceil >= 0) {
            while (true) {
                this.f9293f += this.f9299l;
                if (i3 == ceil) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.f9294g = (int) getPaint().measureText(this.f9293f);
        c();
        super.setText(this.f9293f, TextView.BufferType.NORMAL);
    }

    private final void setActualMarqueeByMeasured(boolean z3) {
        setFadingEdgeStrength((z3 && this.f9305r) ? 1.0f : 0.0f);
        this.f9306s = z3;
    }

    private final void setFadingEdgeStrength(float f3) {
        this.f9304q = Math.signum(f3);
    }

    public final void d() {
        setMarqueeEnable(true);
        if (getPaint().measureText(getText().toString()) <= getMeasuredWidth() || this.f9297j) {
            return;
        }
        ValueAnimator valueAnimator = this.f9301n;
        if (valueAnimator != null) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.f9301n = null;
        }
        this.f9297j = true;
        ValueAnimator ofInt = ValueAnimator.ofInt(Preference.DEFAULT_ORDER);
        this.f9301n = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(2147483647L);
            ofInt.setInterpolator(new d());
            ofInt.setRepeatCount(-1);
            ofInt.setRepeatMode(1);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.tips.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIMarqueeTextView.e(COUIMarqueeTextView.this, valueAnimator2);
                }
            });
            ofInt.start();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        return this.f9304q;
    }

    @Override // android.widget.TextView, android.view.View
    protected float getRightFadingEdgeStrength() {
        return this.f9304q;
    }

    public final void j() {
        this.f9297j = false;
        this.f9296i = getResources().getDimensionPixelOffset(AbstractC0361c.f11605l);
        ValueAnimator valueAnimator = this.f9301n;
        if (valueAnimator != null && valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f9301n = null;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f9305r) {
            j();
            removeCallbacks(this.f9302o);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        k.e(canvas, "canvas");
        if (!this.f9305r || !this.f9306s) {
            AbstractC0371a.a("MarqueeView", "onDraw: isMarqueeEnable=" + this.f9305r + ", isActualMarqueeByMeasured=" + this.f9306s);
            super.onDraw(canvas);
            return;
        }
        float f3 = this.f9296i;
        if (f3 < 0.0f) {
            int abs = (int) Math.abs(f3 / this.f9300m);
            int i3 = this.f9298k;
            if (abs >= i3) {
                this.f9298k = i3 + 1;
                if (this.f9296i <= (-this.f9294g)) {
                    String substring = this.f9293f.substring(this.f9299l.length());
                    k.d(substring, "this as java.lang.String).substring(startIndex)");
                    this.f9293f = substring;
                    this.f9296i += this.f9300m;
                    this.f9298k--;
                }
                String str = this.f9293f + this.f9299l;
                this.f9293f = str;
                this.f9308u = true;
                super.setText(str, TextView.BufferType.NORMAL);
            }
        }
        if (getLayout() == null) {
            super.onDraw(canvas);
        }
        canvas.save();
        float f4 = this.f9296i;
        if (!this.f9307t) {
            f4 = -f4;
        }
        canvas.translate(f4, 0.0f);
        getLayout().draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        List<CharSequence> text;
        if (!this.f9308u) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        if (accessibilityEvent != null && (text = accessibilityEvent.getText()) != null) {
            text.clear();
        }
        if (accessibilityEvent != null) {
            accessibilityEvent.setContentDescription(null);
        }
        this.f9308u = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        k.e(accessibilityNodeInfo, "info");
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.f9292e);
        accessibilityNodeInfo.setContentDescription(this.f9292e);
    }

    @Override // androidx.appcompat.widget.C0251z, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (getPaint().measureText(getText().toString()) <= getMeasuredWidth()) {
            setActualMarqueeByMeasured(false);
            return;
        }
        setActualMarqueeByMeasured(true);
        if (this.f9305r) {
            i();
        }
    }

    public final void setMarqueeEnable(boolean z3) {
        float f3;
        if (z3) {
            setSingleLine(true);
            setMaxLines(1);
            f3 = 1.0f;
        } else {
            setSingleLine(false);
            setMaxLines(Preference.DEFAULT_ORDER);
            f3 = 0.0f;
        }
        setFadingEdgeStrength(f3);
        this.f9305r = z3;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f9292e = String.valueOf(charSequence);
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        getPaint().setColor(getCurrentTextColor());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIMarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        k.b(context);
        this.f9292e = "";
        this.f9293f = "";
        this.f9295h = getResources().getDimensionPixelOffset(AbstractC0361c.f11603j);
        this.f9296i = getResources().getDimensionPixelOffset(AbstractC0361c.f11605l);
        this.f9299l = "";
        this.f9303p = getResources().getDimensionPixelOffset(AbstractC0361c.f11604k);
        this.f9307t = true;
        g();
        h();
        if (this.f9305r) {
            postDelayed(this.f9302o, 1000L);
        }
    }

    public /* synthetic */ COUIMarqueeTextView(Context context, AttributeSet attributeSet, int i3, int i4, g gVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }
}
