package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0251z;
import androidx.appcompat.widget.V;
import androidx.core.view.AbstractC0259h;
import androidx.core.view.y;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
class k extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private final TextInputLayout f9954e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f9955f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f9956g;

    /* renamed from: h, reason: collision with root package name */
    private final CheckableImageButton f9957h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f9958i;

    /* renamed from: j, reason: collision with root package name */
    private PorterDuff.Mode f9959j;

    /* renamed from: k, reason: collision with root package name */
    private View.OnLongClickListener f9960k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9961l;

    k(TextInputLayout textInputLayout, V v3) {
        super(textInputLayout.getContext());
        this.f9954e = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(H0.g.f604i, (ViewGroup) this, false);
        this.f9957h = checkableImageButton;
        C0251z c0251z = new C0251z(getContext());
        this.f9955f = c0251z;
        g(v3);
        f(v3);
        addView(checkableImageButton);
        addView(c0251z);
    }

    private void f(V v3) {
        this.f9955f.setVisibility(8);
        this.f9955f.setId(H0.e.f564N);
        this.f9955f.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        y.l0(this.f9955f, 1);
        l(v3.n(H0.j.G6, 0));
        if (v3.s(H0.j.H6)) {
            m(v3.c(H0.j.H6));
        }
        k(v3.p(H0.j.F6));
    }

    private void g(V v3) {
        if (R0.c.g(getContext())) {
            AbstractC0259h.c((ViewGroup.MarginLayoutParams) this.f9957h.getLayoutParams(), 0);
        }
        q(null);
        r(null);
        if (v3.s(H0.j.L6)) {
            this.f9958i = R0.c.b(getContext(), v3, H0.j.L6);
        }
        if (v3.s(H0.j.M6)) {
            this.f9959j = ViewUtils.parseTintMode(v3.k(H0.j.M6, -1), null);
        }
        if (v3.s(H0.j.K6)) {
            p(v3.g(H0.j.K6));
            if (v3.s(H0.j.J6)) {
                o(v3.p(H0.j.J6));
            }
            n(v3.a(H0.j.I6, true));
        }
    }

    private void x() {
        int i3 = (this.f9956g == null || this.f9961l) ? 8 : 0;
        setVisibility((this.f9957h.getVisibility() == 0 || i3 == 0) ? 0 : 8);
        this.f9955f.setVisibility(i3);
        this.f9954e.q0();
    }

    CharSequence a() {
        return this.f9956g;
    }

    ColorStateList b() {
        return this.f9955f.getTextColors();
    }

    TextView c() {
        return this.f9955f;
    }

    CharSequence d() {
        return this.f9957h.getContentDescription();
    }

    Drawable e() {
        return this.f9957h.getDrawable();
    }

    boolean h() {
        return this.f9957h.getVisibility() == 0;
    }

    void i(boolean z3) {
        this.f9961l = z3;
        x();
    }

    void j() {
        f.c(this.f9954e, this.f9957h, this.f9958i);
    }

    void k(CharSequence charSequence) {
        this.f9956g = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f9955f.setText(charSequence);
        x();
    }

    void l(int i3) {
        androidx.core.widget.i.m(this.f9955f, i3);
    }

    void m(ColorStateList colorStateList) {
        this.f9955f.setTextColor(colorStateList);
    }

    void n(boolean z3) {
        this.f9957h.setCheckable(z3);
    }

    void o(CharSequence charSequence) {
        if (d() != charSequence) {
            this.f9957h.setContentDescription(charSequence);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        w();
    }

    void p(Drawable drawable) {
        this.f9957h.setImageDrawable(drawable);
        if (drawable != null) {
            f.a(this.f9954e, this.f9957h, this.f9958i, this.f9959j);
            u(true);
            j();
        } else {
            u(false);
            q(null);
            r(null);
            o(null);
        }
    }

    void q(View.OnClickListener onClickListener) {
        f.e(this.f9957h, onClickListener, this.f9960k);
    }

    void r(View.OnLongClickListener onLongClickListener) {
        this.f9960k = onLongClickListener;
        f.f(this.f9957h, onLongClickListener);
    }

    void s(ColorStateList colorStateList) {
        if (this.f9958i != colorStateList) {
            this.f9958i = colorStateList;
            f.a(this.f9954e, this.f9957h, colorStateList, this.f9959j);
        }
    }

    void t(PorterDuff.Mode mode) {
        if (this.f9959j != mode) {
            this.f9959j = mode;
            f.a(this.f9954e, this.f9957h, this.f9958i, mode);
        }
    }

    void u(boolean z3) {
        if (h() != z3) {
            this.f9957h.setVisibility(z3 ? 0 : 8);
            w();
            x();
        }
    }

    void v(androidx.core.view.accessibility.d dVar) {
        if (this.f9955f.getVisibility() != 0) {
            dVar.o0(this.f9957h);
        } else {
            dVar.c0(this.f9955f);
            dVar.o0(this.f9955f);
        }
    }

    void w() {
        EditText editText = this.f9954e.f9814i;
        if (editText == null) {
            return;
        }
        y.y0(this.f9955f, h() ? 0 : y.C(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(H0.c.f538u), editText.getCompoundPaddingBottom());
    }
}
