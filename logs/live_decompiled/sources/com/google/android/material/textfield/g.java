package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0251z;
import androidx.core.view.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9913a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f9914b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f9915c;

    /* renamed from: d, reason: collision with root package name */
    private int f9916d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f9917e;

    /* renamed from: f, reason: collision with root package name */
    private Animator f9918f;

    /* renamed from: g, reason: collision with root package name */
    private final float f9919g;

    /* renamed from: h, reason: collision with root package name */
    private int f9920h;

    /* renamed from: i, reason: collision with root package name */
    private int f9921i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f9922j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9923k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f9924l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f9925m;

    /* renamed from: n, reason: collision with root package name */
    private int f9926n;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f9927o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f9928p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f9929q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f9930r;

    /* renamed from: s, reason: collision with root package name */
    private int f9931s;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f9932t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f9933u;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9934a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f9935b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9936c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f9937d;

        a(int i3, TextView textView, int i4, TextView textView2) {
            this.f9934a = i3;
            this.f9935b = textView;
            this.f9936c = i4;
            this.f9937d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f9920h = this.f9934a;
            g.this.f9918f = null;
            TextView textView = this.f9935b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f9936c == 1 && g.this.f9924l != null) {
                    g.this.f9924l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f9937d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f9937d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f9937d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = g.this.f9914b.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public g(TextInputLayout textInputLayout) {
        this.f9913a = textInputLayout.getContext();
        this.f9914b = textInputLayout;
        this.f9919g = r0.getResources().getDimensionPixelSize(H0.c.f524g);
    }

    private void C(int i3, int i4) {
        TextView m3;
        TextView m4;
        if (i3 == i4) {
            return;
        }
        if (i4 != 0 && (m4 = m(i4)) != null) {
            m4.setVisibility(0);
            m4.setAlpha(1.0f);
        }
        if (i3 != 0 && (m3 = m(i3)) != null) {
            m3.setVisibility(4);
            if (i3 == 1) {
                m3.setText((CharSequence) null);
            }
        }
        this.f9920h = i4;
    }

    private void K(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void M(ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean N(TextView textView, CharSequence charSequence) {
        return y.O(this.f9914b) && this.f9914b.isEnabled() && !(this.f9921i == this.f9920h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void Q(int i3, int i4, boolean z3) {
        if (i3 == i4) {
            return;
        }
        if (z3) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f9918f = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f9929q, this.f9930r, 2, i3, i4);
            i(arrayList, this.f9923k, this.f9924l, 1, i3, i4);
            I0.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i4, m(i3), i3, m(i4)));
            animatorSet.start();
        } else {
            C(i3, i4);
        }
        this.f9914b.r0();
        this.f9914b.w0(z3);
        this.f9914b.E0();
    }

    private boolean g() {
        return (this.f9915c == null || this.f9914b.getEditText() == null) ? false : true;
    }

    private void i(List list, boolean z3, TextView textView, int i3, int i4, int i5) {
        if (textView == null || !z3) {
            return;
        }
        if (i3 == i5 || i3 == i4) {
            list.add(j(textView, i5 == i3));
            if (i5 == i3) {
                list.add(k(textView));
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z3 ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(I0.a.f914a);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f9919g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(I0.a.f917d);
        return ofFloat;
    }

    private TextView m(int i3) {
        if (i3 == 1) {
            return this.f9924l;
        }
        if (i3 != 2) {
            return null;
        }
        return this.f9930r;
    }

    private int u(boolean z3, int i3, int i4) {
        return z3 ? this.f9913a.getResources().getDimensionPixelSize(i3) : i4;
    }

    private boolean x(int i3) {
        return (i3 != 1 || this.f9924l == null || TextUtils.isEmpty(this.f9922j)) ? false : true;
    }

    boolean A() {
        return this.f9929q;
    }

    void B(TextView textView, int i3) {
        FrameLayout frameLayout;
        if (this.f9915c == null) {
            return;
        }
        if (!y(i3) || (frameLayout = this.f9917e) == null) {
            this.f9915c.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i4 = this.f9916d - 1;
        this.f9916d = i4;
        M(this.f9915c, i4);
    }

    void D(CharSequence charSequence) {
        this.f9925m = charSequence;
        TextView textView = this.f9924l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void E(boolean z3) {
        if (this.f9923k == z3) {
            return;
        }
        h();
        if (z3) {
            C0251z c0251z = new C0251z(this.f9913a);
            this.f9924l = c0251z;
            c0251z.setId(H0.e.f561K);
            this.f9924l.setTextAlignment(5);
            Typeface typeface = this.f9933u;
            if (typeface != null) {
                this.f9924l.setTypeface(typeface);
            }
            F(this.f9926n);
            G(this.f9927o);
            D(this.f9925m);
            this.f9924l.setVisibility(4);
            y.l0(this.f9924l, 1);
            e(this.f9924l, 0);
        } else {
            v();
            B(this.f9924l, 0);
            this.f9924l = null;
            this.f9914b.r0();
            this.f9914b.E0();
        }
        this.f9923k = z3;
    }

    void F(int i3) {
        this.f9926n = i3;
        TextView textView = this.f9924l;
        if (textView != null) {
            this.f9914b.d0(textView, i3);
        }
    }

    void G(ColorStateList colorStateList) {
        this.f9927o = colorStateList;
        TextView textView = this.f9924l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void H(int i3) {
        this.f9931s = i3;
        TextView textView = this.f9930r;
        if (textView != null) {
            androidx.core.widget.i.m(textView, i3);
        }
    }

    void I(boolean z3) {
        if (this.f9929q == z3) {
            return;
        }
        h();
        if (z3) {
            C0251z c0251z = new C0251z(this.f9913a);
            this.f9930r = c0251z;
            c0251z.setId(H0.e.f562L);
            this.f9930r.setTextAlignment(5);
            Typeface typeface = this.f9933u;
            if (typeface != null) {
                this.f9930r.setTypeface(typeface);
            }
            this.f9930r.setVisibility(4);
            y.l0(this.f9930r, 1);
            H(this.f9931s);
            J(this.f9932t);
            e(this.f9930r, 1);
            this.f9930r.setAccessibilityDelegate(new b());
        } else {
            w();
            B(this.f9930r, 1);
            this.f9930r = null;
            this.f9914b.r0();
            this.f9914b.E0();
        }
        this.f9929q = z3;
    }

    void J(ColorStateList colorStateList) {
        this.f9932t = colorStateList;
        TextView textView = this.f9930r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void L(Typeface typeface) {
        if (typeface != this.f9933u) {
            this.f9933u = typeface;
            K(this.f9924l, typeface);
            K(this.f9930r, typeface);
        }
    }

    void O(CharSequence charSequence) {
        h();
        this.f9922j = charSequence;
        this.f9924l.setText(charSequence);
        int i3 = this.f9920h;
        if (i3 != 1) {
            this.f9921i = 1;
        }
        Q(i3, this.f9921i, N(this.f9924l, charSequence));
    }

    void P(CharSequence charSequence) {
        h();
        this.f9928p = charSequence;
        this.f9930r.setText(charSequence);
        int i3 = this.f9920h;
        if (i3 != 2) {
            this.f9921i = 2;
        }
        Q(i3, this.f9921i, N(this.f9930r, charSequence));
    }

    void e(TextView textView, int i3) {
        if (this.f9915c == null && this.f9917e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f9913a);
            this.f9915c = linearLayout;
            linearLayout.setOrientation(0);
            this.f9914b.addView(this.f9915c, -1, -2);
            this.f9917e = new FrameLayout(this.f9913a);
            this.f9915c.addView(this.f9917e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f9914b.getEditText() != null) {
                f();
            }
        }
        if (y(i3)) {
            this.f9917e.setVisibility(0);
            this.f9917e.addView(textView);
        } else {
            this.f9915c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f9915c.setVisibility(0);
        this.f9916d++;
    }

    void f() {
        if (g()) {
            EditText editText = this.f9914b.getEditText();
            boolean g3 = R0.c.g(this.f9913a);
            y.y0(this.f9915c, u(g3, H0.c.f536s, y.C(editText)), u(g3, H0.c.f537t, this.f9913a.getResources().getDimensionPixelSize(H0.c.f535r)), u(g3, H0.c.f536s, y.B(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f9918f;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean l() {
        return x(this.f9921i);
    }

    CharSequence n() {
        return this.f9925m;
    }

    CharSequence o() {
        return this.f9922j;
    }

    int p() {
        TextView textView = this.f9924l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList q() {
        TextView textView = this.f9924l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence r() {
        return this.f9928p;
    }

    View s() {
        return this.f9930r;
    }

    int t() {
        TextView textView = this.f9930r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void v() {
        this.f9922j = null;
        h();
        if (this.f9920h == 1) {
            if (!this.f9929q || TextUtils.isEmpty(this.f9928p)) {
                this.f9921i = 0;
            } else {
                this.f9921i = 2;
            }
        }
        Q(this.f9920h, this.f9921i, N(this.f9924l, ""));
    }

    void w() {
        h();
        int i3 = this.f9920h;
        if (i3 == 2) {
            this.f9921i = 0;
        }
        Q(i3, this.f9921i, N(this.f9930r, ""));
    }

    boolean y(int i3) {
        return i3 == 0 || i3 == 1;
    }

    boolean z() {
        return this.f9923k;
    }
}
