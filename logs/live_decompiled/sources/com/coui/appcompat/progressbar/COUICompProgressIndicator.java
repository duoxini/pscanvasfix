package com.coui.appcompat.progressbar;

import X1.c;
import X1.f;
import X1.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oplus.anim.EffectiveAnimationView;
import d0.AbstractC0335a;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
public class COUICompProgressIndicator extends LinearLayout {

    /* renamed from: C, reason: collision with root package name */
    private static final String f8809C = "COUICompProgressIndicator";

    /* renamed from: A, reason: collision with root package name */
    private AttributeSet f8810A;

    /* renamed from: B, reason: collision with root package name */
    private int f8811B;

    /* renamed from: e, reason: collision with root package name */
    private int f8812e;

    /* renamed from: f, reason: collision with root package name */
    private Context f8813f;

    /* renamed from: g, reason: collision with root package name */
    private EffectiveAnimationView f8814g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f8815h;

    /* renamed from: i, reason: collision with root package name */
    private int f8816i;

    /* renamed from: j, reason: collision with root package name */
    private String f8817j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8818k;

    /* renamed from: l, reason: collision with root package name */
    private String f8819l;

    /* renamed from: m, reason: collision with root package name */
    private int f8820m;

    /* renamed from: n, reason: collision with root package name */
    private int f8821n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8822o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8823p;

    /* renamed from: q, reason: collision with root package name */
    private int f8824q;

    /* renamed from: r, reason: collision with root package name */
    private int f8825r;

    /* renamed from: s, reason: collision with root package name */
    private int f8826s;

    /* renamed from: t, reason: collision with root package name */
    private int f8827t;

    /* renamed from: u, reason: collision with root package name */
    private int f8828u;

    /* renamed from: v, reason: collision with root package name */
    private int f8829v;

    /* renamed from: w, reason: collision with root package name */
    private int f8830w;

    /* renamed from: x, reason: collision with root package name */
    private int f8831x;

    /* renamed from: y, reason: collision with root package name */
    private int f8832y;

    /* renamed from: z, reason: collision with root package name */
    private int f8833z;

    public COUICompProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(boolean z3) {
        EffectiveAnimationView effectiveAnimationView = new EffectiveAnimationView(this.f8813f);
        this.f8814g = effectiveAnimationView;
        effectiveAnimationView.setRepeatCount(this.f8821n);
        LinearLayout.LayoutParams layoutParams = z3 ? new LinearLayout.LayoutParams(this.f8824q, this.f8826s) : new LinearLayout.LayoutParams(this.f8825r, this.f8827t);
        layoutParams.gravity = 17;
        this.f8814g.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(this.f8819l)) {
            this.f8814g.setAnimation(this.f8819l);
        }
        int i3 = this.f8820m;
        if (i3 != -1) {
            this.f8814g.setAnimation(i3);
        }
        addView(this.f8814g);
        if (this.f8822o) {
            this.f8814g.v();
        }
    }

    private void b() {
        int i3 = this.f8816i;
        if (i3 == 0) {
            a(true);
            return;
        }
        if (i3 == 1) {
            a(false);
            return;
        }
        if (i3 == 2) {
            setOrientation(0);
            a(false);
            c(false);
        } else if (i3 == 3) {
            a(true);
            c(true);
        } else {
            if (i3 != 4) {
                return;
            }
            a(false);
            c(true);
        }
    }

    private void c(boolean z3) {
        TextView textView = new TextView(new ContextThemeWrapper(this.f8813f, z3 ? f.f2893c : f.f2892b));
        this.f8815h = textView;
        textView.setText(this.f8817j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = this.f8816i;
        if (i3 == 2) {
            layoutParams.setMarginStart(this.f8828u);
        } else if (i3 == 3) {
            layoutParams.setMargins(0, this.f8829v, 0, this.f8831x);
        } else if (i3 == 4) {
            layoutParams.setMargins(0, this.f8830w, 0, this.f8831x);
        }
        if (this.f8818k) {
            this.f8815h.setTextSize(1, 12.0f);
        }
        addView(this.f8815h, layoutParams);
    }

    public EffectiveAnimationView getAnimationView() {
        return this.f8814g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8814g == null) {
            b();
        }
        EffectiveAnimationView effectiveAnimationView = this.f8814g;
        if (effectiveAnimationView == null || !this.f8823p) {
            return;
        }
        effectiveAnimationView.x();
        this.f8823p = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EffectiveAnimationView effectiveAnimationView = this.f8814g;
        if (effectiveAnimationView == null || !effectiveAnimationView.p()) {
            return;
        }
        this.f8823p = true;
        this.f8814g.u();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        EffectiveAnimationView effectiveAnimationView = this.f8814g;
        if (effectiveAnimationView != null) {
            if (i3 != 0) {
                if (effectiveAnimationView.p()) {
                    this.f8823p = true;
                    this.f8814g.u();
                    return;
                }
                return;
            }
            if (this.f8823p) {
                effectiveAnimationView.x();
                this.f8823p = false;
            }
        }
    }

    public void setLoadingTips(String str) {
        this.f8817j = str;
        TextView textView = this.f8815h;
        if (textView != null) {
            textView.setText(str);
        } else {
            Log.e(f8809C, "This method only takes effect when mCouiLoadingType is SMALL_ANIMATION_WITH_TEXT_HORIZONTAL 、LARGE_ANIMATION_WITH_TEXT_VERTICAL、SMALL_ANIMATION_WITH_TEXT_VERTICAL");
        }
    }

    public void setLoadingType(int i3) {
        this.f8816i = i3;
    }

    public COUICompProgressIndicator(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUICompProgressIndicator(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8812e = 0;
        this.f8818k = false;
        this.f8820m = -1;
        this.f8821n = -1;
        this.f8822o = true;
        this.f8823p = false;
        this.f8810A = attributeSet;
        this.f8811B = i3;
        this.f8813f = context;
        this.f8832y = getResources().getDimensionPixelSize(c.f2880k);
        this.f8833z = getResources().getDimensionPixelSize(c.f2879j);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f2911c, i3, 0);
        this.f8816i = obtainStyledAttributes.getInt(g.f2913e, this.f8812e);
        this.f8817j = obtainStyledAttributes.getString(g.f2922n);
        this.f8819l = obtainStyledAttributes.getString(g.f2914f);
        this.f8820m = obtainStyledAttributes.getResourceId(g.f2915g, -1);
        this.f8821n = obtainStyledAttributes.getInt(g.f2918j, this.f8821n);
        this.f8822o = obtainStyledAttributes.getBoolean(g.f2912d, this.f8822o);
        this.f8824q = obtainStyledAttributes.getDimensionPixelSize(g.f2917i, getResources().getDimensionPixelOffset(c.f2878i));
        this.f8826s = obtainStyledAttributes.getDimensionPixelSize(g.f2916h, getResources().getDimensionPixelOffset(c.f2877h));
        this.f8825r = obtainStyledAttributes.getDimensionPixelSize(g.f2920l, getResources().getDimensionPixelOffset(c.f2882m));
        this.f8827t = obtainStyledAttributes.getDimensionPixelSize(g.f2919k, getResources().getDimensionPixelOffset(c.f2881l));
        int i5 = this.f8824q;
        int i6 = this.f8832y;
        if (i5 > i6) {
            this.f8824q = i6;
            AbstractC0371a.f(f8809C, "couiLottieLoadingViewWidth Cannot be larger than 40 dp");
        }
        int i7 = this.f8826s;
        int i8 = this.f8833z;
        if (i7 > i8) {
            this.f8826s = i8;
            AbstractC0371a.f(f8809C, "couiLottieLoadingViewHeight Cannot be larger than 40 dp");
        }
        int i9 = this.f8825r;
        int i10 = this.f8832y;
        if (i9 > i10) {
            this.f8825r = i10;
            AbstractC0371a.f(f8809C, "couiSmallLottieLoadingViewWidth Cannot be larger than 40 dp");
        }
        int i11 = this.f8827t;
        int i12 = this.f8833z;
        if (i11 > i12) {
            this.f8827t = i12;
            AbstractC0371a.f(f8809C, "couiSmallLottieLoadingViewHeight Cannot be larger than 40 dp");
        }
        if (TextUtils.isEmpty(this.f8819l)) {
            this.f8819l = AbstractC0335a.g(this.f8813f, M1.c.f1381z);
        }
        this.f8818k = obtainStyledAttributes.getBoolean(g.f2921m, this.f8818k);
        obtainStyledAttributes.recycle();
        this.f8828u = context.getResources().getDimensionPixelSize(c.f2884o);
        this.f8829v = context.getResources().getDimensionPixelSize(c.f2885p);
        this.f8830w = context.getResources().getDimensionPixelSize(c.f2886q);
        this.f8831x = context.getResources().getDimensionPixelSize(c.f2883n);
        setGravity(17);
        setOrientation(1);
    }

    public void setLoadingTips(int i3) {
        setLoadingTips(this.f8813f.getString(i3));
    }
}
