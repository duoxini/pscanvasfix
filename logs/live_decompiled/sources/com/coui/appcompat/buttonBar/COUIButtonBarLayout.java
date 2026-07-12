package com.coui.appcompat.buttonBar;

import M1.c;
import M1.e;
import P1.b;
import P1.d;
import P1.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.content.a;
import com.coui.appcompat.button.COUIButton;
import d0.AbstractC0335a;

/* loaded from: classes.dex */
public class COUIButtonBarLayout extends LinearLayout {

    /* renamed from: A, reason: collision with root package name */
    private int f7550A;

    /* renamed from: B, reason: collision with root package name */
    private int f7551B;

    /* renamed from: C, reason: collision with root package name */
    private int f7552C;

    /* renamed from: D, reason: collision with root package name */
    private int f7553D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f7554E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f7555F;

    /* renamed from: G, reason: collision with root package name */
    private int f7556G;

    /* renamed from: H, reason: collision with root package name */
    private int f7557H;

    /* renamed from: I, reason: collision with root package name */
    private int f7558I;

    /* renamed from: J, reason: collision with root package name */
    private int f7559J;

    /* renamed from: K, reason: collision with root package name */
    private int f7560K;

    /* renamed from: L, reason: collision with root package name */
    private int f7561L;

    /* renamed from: M, reason: collision with root package name */
    private int f7562M;

    /* renamed from: N, reason: collision with root package name */
    private int f7563N;

    /* renamed from: O, reason: collision with root package name */
    private int f7564O;

    /* renamed from: P, reason: collision with root package name */
    private int f7565P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f7566Q;

    /* renamed from: R, reason: collision with root package name */
    private int f7567R;

    /* renamed from: S, reason: collision with root package name */
    private int f7568S;

    /* renamed from: T, reason: collision with root package name */
    private int f7569T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f7570U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f7571V;

    /* renamed from: e, reason: collision with root package name */
    private Context f7572e;

    /* renamed from: f, reason: collision with root package name */
    private COUIButton f7573f;

    /* renamed from: g, reason: collision with root package name */
    private COUIButton f7574g;

    /* renamed from: h, reason: collision with root package name */
    private COUIButton f7575h;

    /* renamed from: i, reason: collision with root package name */
    private View f7576i;

    /* renamed from: j, reason: collision with root package name */
    private View f7577j;

    /* renamed from: k, reason: collision with root package name */
    private View f7578k;

    /* renamed from: l, reason: collision with root package name */
    private View f7579l;

    /* renamed from: m, reason: collision with root package name */
    private View f7580m;

    /* renamed from: n, reason: collision with root package name */
    private View f7581n;

    /* renamed from: o, reason: collision with root package name */
    private int f7582o;

    /* renamed from: p, reason: collision with root package name */
    private int f7583p;

    /* renamed from: q, reason: collision with root package name */
    private int f7584q;

    /* renamed from: r, reason: collision with root package name */
    private int f7585r;

    /* renamed from: s, reason: collision with root package name */
    private int f7586s;

    /* renamed from: t, reason: collision with root package name */
    private int f7587t;

    /* renamed from: u, reason: collision with root package name */
    private int f7588u;

    /* renamed from: v, reason: collision with root package name */
    private int f7589v;

    /* renamed from: w, reason: collision with root package name */
    private int f7590w;

    /* renamed from: x, reason: collision with root package name */
    private int f7591x;

    /* renamed from: y, reason: collision with root package name */
    private int f7592y;

    /* renamed from: z, reason: collision with root package name */
    private int f7593z;

    public COUIButtonBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        B(this.f7573f);
        B(this.f7575h);
        B(this.f7574g);
        if (this.f7562M != -1) {
            b(this.f7573f);
            b(this.f7574g);
            b(this.f7575h);
        }
    }

    private void B(COUIButton cOUIButton) {
        if (d(cOUIButton)) {
            ((ViewGroup) cOUIButton.getParent()).setVisibility(0);
        }
    }

    private void C(View... viewArr) {
        e();
        if (!this.f7554E || viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            view.setVisibility(0);
        }
    }

    private void a(COUIButton cOUIButton) {
        ViewGroup.LayoutParams layoutParams = cOUIButton.getLayoutParams();
        layoutParams.height = -1;
        cOUIButton.setMaxLines(2);
        cOUIButton.setEllipsize(TextUtils.TruncateAt.END);
        String charSequence = cOUIButton.getText().toString();
        int measuredWidth = (cOUIButton.getMeasuredWidth() - cOUIButton.getPaddingLeft()) - cOUIButton.getPaddingRight();
        float measureText = cOUIButton.getPaint().measureText(charSequence);
        int i3 = this.f7567R;
        if (measureText > measuredWidth) {
            i3 = this.f7568S;
        }
        int i4 = this.f7583p;
        cOUIButton.setPadding(i4, i3, i4, i3);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (this.f7566Q) {
                int i5 = this.f7565P;
                COUIButton cOUIButton2 = this.f7574g;
                int i6 = (cOUIButton == cOUIButton2 || (cOUIButton == this.f7573f && !d(cOUIButton2)) || !(cOUIButton != this.f7575h || d(this.f7573f) || d(this.f7574g))) ? this.f7558I + i5 : i5;
                cOUIButton.setMinimumHeight(this.f7588u);
                int i7 = this.f7563N;
                marginLayoutParams.setMargins(i7, i5, i7, i6);
            }
        }
        cOUIButton.setLayoutParams(layoutParams);
    }

    private void b(COUIButton cOUIButton) {
        if (d(cOUIButton)) {
            if (cOUIButton.getId() == this.f7562M) {
                if (cOUIButton.getDrawableColor() == getResources().getColor(e.f1405u)) {
                    cOUIButton.setDrawableColor(AbstractC0335a.b(getContext(), c.f1360e, 0));
                }
                cOUIButton.setTextColor(a.d(this.f7572e, e.f1386b));
                cOUIButton.setAnimType(1);
                cOUIButton.setScaleEnable(true);
                cOUIButton.setAnimEnable(true);
                cOUIButton.setDisabledColor(AbstractC0335a.a(getContext(), c.f1362g));
            } else {
                cOUIButton.setAnimType(0);
            }
            cOUIButton.setDrawableRadius(-1);
        }
    }

    private int c(Button button) {
        if (button == null || button.getVisibility() != 0) {
            return 0;
        }
        return (int) (button.isAllCaps() ? button.getPaint().measureText(button.getText().toString().toUpperCase()) : button.getPaint().measureText(button.getText().toString()));
    }

    private boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    private void e() {
        this.f7576i.setVisibility(8);
        this.f7577j.setVisibility(8);
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.f7572e = context;
        this.f7582o = context.getResources().getDimensionPixelSize(b.f1785j);
        this.f7583p = this.f7572e.getResources().getDimensionPixelSize(b.f1786k);
        this.f7584q = this.f7572e.getResources().getDimensionPixelSize(b.f1789n);
        this.f7585r = this.f7572e.getResources().getDimensionPixelSize(b.f1788m);
        this.f7586s = this.f7572e.getResources().getDimensionPixelSize(b.f1787l);
        this.f7591x = this.f7572e.getResources().getDimensionPixelSize(b.f1797v);
        int dimensionPixelSize = this.f7572e.getResources().getDimensionPixelSize(b.f1765N);
        this.f7587t = dimensionPixelSize;
        this.f7592y = this.f7591x + dimensionPixelSize;
        this.f7593z = this.f7572e.getResources().getDimensionPixelSize(b.f1801z);
        this.f7550A = this.f7572e.getResources().getDimensionPixelSize(b.f1754C);
        this.f7551B = this.f7572e.getResources().getDimensionPixelSize(b.f1752A);
        this.f7552C = this.f7572e.getResources().getDimensionPixelSize(b.f1784i);
        this.f7561L = this.f7572e.getResources().getDimensionPixelSize(b.f1772U);
        this.f7590w = this.f7572e.getResources().getDimensionPixelSize(b.f1766O);
        TypedArray obtainStyledAttributes = this.f7572e.obtainStyledAttributes(attributeSet, g.f1856s);
        this.f7554E = obtainStyledAttributes.getBoolean(g.f1858u, true);
        this.f7589v = obtainStyledAttributes.getDimensionPixelOffset(g.f1857t, this.f7572e.getResources().getDimensionPixelSize(b.f1767P));
        this.f7557H = this.f7572e.getResources().getDimensionPixelSize(b.f1760I);
        this.f7558I = this.f7572e.getResources().getDimensionPixelSize(b.f1759H);
        this.f7556G = this.f7572e.getResources().getDimensionPixelSize(b.f1761J);
        this.f7559J = this.f7572e.getResources().getDimensionPixelSize(b.f1755D);
        this.f7560K = this.f7572e.getResources().getDimensionPixelSize(b.f1753B);
        this.f7564O = this.f7572e.getResources().getDimensionPixelSize(b.f1800y);
        this.f7563N = this.f7572e.getResources().getDimensionPixelSize(b.f1801z);
        this.f7567R = this.f7572e.getResources().getDimensionPixelSize(b.f1756E);
        this.f7568S = this.f7572e.getResources().getDimensionPixelSize(b.f1757F);
        this.f7565P = this.f7572e.getResources().getDimensionPixelSize(b.f1758G);
        this.f7569T = this.f7572e.getResources().getDimensionPixelSize(b.f1799x);
        this.f7588u = this.f7572e.getResources().getDimensionPixelSize(b.f1798w);
        obtainStyledAttributes.recycle();
    }

    private void g() {
        if (this.f7573f == null || this.f7574g == null || this.f7575h == null || this.f7576i == null || this.f7577j == null) {
            this.f7573f = (COUIButton) findViewById(R.id.button1);
            this.f7574g = (COUIButton) findViewById(R.id.button2);
            this.f7575h = (COUIButton) findViewById(R.id.button3);
            this.f7576i = findViewById(d.f1810g);
            this.f7577j = findViewById(d.f1811h);
        }
    }

    private void h() {
        if (this.f7578k == null || this.f7579l == null || this.f7580m == null || this.f7581n == null) {
            View view = (View) getParent().getParent();
            this.f7578k = view;
            this.f7579l = view.findViewById(d.f1828y);
            this.f7580m = this.f7578k.findViewById(d.f1809f);
            this.f7581n = this.f7578k.findViewById(d.f1815l);
        }
    }

    private boolean i(int i3) {
        int buttonCount = getButtonCount();
        if (buttonCount == 0) {
            return false;
        }
        int i4 = ((i3 - ((buttonCount - 1) * this.f7589v)) / buttonCount) - (this.f7582o * 2);
        return c(this.f7573f) > i4 || c(this.f7574g) > i4 || c(this.f7575h) > i4;
    }

    private void j() {
        w(this.f7574g, this.f7559J);
        v(this.f7574g, this.f7560K);
        w(this.f7573f, this.f7559J);
        v(this.f7573f, this.f7560K);
        w(this.f7575h, this.f7559J);
        v(this.f7575h, this.f7560K);
    }

    private void k() {
        if (getButtonCount() != 2) {
            if (getButtonCount() == 3) {
                C(this.f7576i, this.f7577j);
                return;
            } else {
                e();
                return;
            }
        }
        if (!d(this.f7574g)) {
            C(this.f7577j);
        } else if (d(this.f7575h) || d(this.f7573f)) {
            C(this.f7576i);
        } else {
            e();
        }
    }

    private void l() {
        int i3;
        int i4;
        if (d(this.f7574g)) {
            if (getButtonCount() > 1) {
                i3 = this.f7556G;
                if (!d(this.f7573f) && !d(this.f7575h) && !d(this.f7579l) && !d(this.f7580m) && !d(this.f7581n)) {
                    i3 += this.f7557H;
                }
                i4 = this.f7556G + this.f7558I;
            } else {
                i3 = this.f7559J;
                i4 = this.f7560K;
                this.f7574g.setMinimumHeight(this.f7552C);
            }
            COUIButton cOUIButton = this.f7574g;
            cOUIButton.setPaddingRelative(cOUIButton.getPaddingStart(), i3, this.f7574g.getPaddingEnd(), i4);
        }
        if (d(this.f7573f)) {
            int i5 = this.f7556G;
            int i6 = (d(this.f7575h) || d(this.f7579l) || d(this.f7580m) || d(this.f7581n)) ? i5 : this.f7557H + i5;
            if (!d(this.f7574g)) {
                i5 += this.f7558I;
            }
            COUIButton cOUIButton2 = this.f7573f;
            cOUIButton2.setPaddingRelative(cOUIButton2.getPaddingStart(), i6, this.f7573f.getPaddingEnd(), i5);
        }
        if (d(this.f7575h)) {
            int i7 = this.f7556G;
            int i8 = (d(this.f7579l) || d(this.f7580m) || d(this.f7581n)) ? i7 : this.f7557H + i7;
            if (!d(this.f7574g) && !d(this.f7573f)) {
                i7 += this.f7558I;
            }
            COUIButton cOUIButton3 = this.f7575h;
            cOUIButton3.setPaddingRelative(cOUIButton3.getPaddingStart(), i8, this.f7575h.getPaddingEnd(), i7);
        }
    }

    private void m() {
        if (this.f7562M != -1) {
            e();
            return;
        }
        if (getButtonCount() == 0) {
            e();
            return;
        }
        if (!d(this.f7574g)) {
            if (d(this.f7575h) && d(this.f7573f)) {
                C(this.f7576i);
                return;
            } else {
                e();
                return;
            }
        }
        if (d(this.f7575h) && d(this.f7573f)) {
            C(this.f7576i, this.f7577j);
            return;
        }
        if (d(this.f7575h)) {
            C(this.f7576i);
            return;
        }
        if (d(this.f7573f)) {
            C(this.f7577j);
        } else if (this.f7571V) {
            C(this.f7577j);
        } else {
            e();
        }
    }

    private void n() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.f7553D);
    }

    private void o() {
        if (d(this.f7573f) || d(this.f7574g) || d(this.f7575h)) {
            if (getOrientation() == 1) {
                bringChildToFront((View) this.f7575h.getParent());
                bringChildToFront(this.f7576i);
                bringChildToFront((View) this.f7573f.getParent());
                bringChildToFront(this.f7577j);
                bringChildToFront((View) this.f7574g.getParent());
                return;
            }
            bringChildToFront((View) this.f7574g.getParent());
            bringChildToFront(this.f7576i);
            bringChildToFront((View) this.f7575h.getParent());
            bringChildToFront(this.f7577j);
            bringChildToFront((View) this.f7573f.getParent());
        }
    }

    private void p() {
        setOrientation(0);
        setGravity(16);
        r();
        setButHorizontal(this.f7575h);
        s();
        setButHorizontal(this.f7573f);
        setButHorizontal(this.f7574g);
    }

    private void q() {
        setOrientation(1);
        setMinimumHeight(0);
        u();
        y();
        x();
        z();
        t();
    }

    private void r() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7576i.getLayoutParams();
        layoutParams.width = this.f7590w;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        layoutParams.topMargin = this.f7550A;
        layoutParams.bottomMargin = this.f7551B;
        this.f7576i.setLayoutParams(layoutParams);
    }

    private void s() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7577j.getLayoutParams();
        layoutParams.width = this.f7590w;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        layoutParams.topMargin = this.f7550A;
        layoutParams.bottomMargin = this.f7551B;
        this.f7577j.setLayoutParams(layoutParams);
    }

    private void setButHorizontal(COUIButton cOUIButton) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((LinearLayout) cOUIButton.getParent()).getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        if (this.f7562M != -1) {
            layoutParams.height = -2;
        } else {
            layoutParams.height = -1;
        }
        layoutParams.gravity = 16;
        ((LinearLayout) cOUIButton.getParent()).setLayoutParams(layoutParams);
        int i3 = this.f7582o;
        int i4 = this.f7585r;
        int i5 = this.f7586s;
        if (this.f7562M != -1) {
            i3 = this.f7583p;
            i4 = this.f7584q;
            i5 = i4;
        }
        cOUIButton.setMinimumHeight(this.f7552C);
        cOUIButton.setPaddingRelative(i3, i4, i3, i5);
    }

    private void t() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((View) this.f7574g.getParent()).getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f7574g.setMinimumHeight(this.f7592y);
        ((View) this.f7574g.getParent()).setLayoutParams(layoutParams);
    }

    private void u() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((View) this.f7575h.getParent()).getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        if (d(this.f7574g) || d(this.f7573f)) {
            this.f7575h.setMinimumHeight(this.f7591x);
        } else {
            this.f7575h.setMinimumHeight(this.f7592y);
        }
        ((View) this.f7575h.getParent()).setLayoutParams(layoutParams);
    }

    private void v(View view, int i3) {
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), i3);
    }

    private void w(View view, int i3) {
        view.setPaddingRelative(view.getPaddingStart(), i3, view.getPaddingEnd(), view.getPaddingBottom());
    }

    private void x() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((View) this.f7573f.getParent()).getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        if (d(this.f7574g)) {
            this.f7573f.setMinimumHeight(this.f7591x);
        } else {
            this.f7573f.setMinimumHeight(this.f7592y);
        }
        ((View) this.f7573f.getParent()).setLayoutParams(layoutParams);
    }

    private void y() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7576i.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.f7589v;
        if (this.f7562M != -1) {
            layoutParams.setMarginStart(this.f7593z);
            layoutParams.setMarginEnd(this.f7593z);
        } else {
            layoutParams.setMarginStart(this.f7564O);
            layoutParams.setMarginEnd(this.f7564O);
        }
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        this.f7576i.setLayoutParams(layoutParams);
    }

    private void z() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7577j.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.f7589v;
        if (this.f7562M != -1) {
            layoutParams.setMarginStart(this.f7593z);
            layoutParams.setMarginEnd(this.f7593z);
        } else {
            layoutParams.setMarginStart(this.f7564O);
            layoutParams.setMarginEnd(this.f7564O);
        }
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        this.f7577j.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public int getButtonCount() {
        ?? d3 = d(this.f7573f);
        int i3 = d3;
        if (d(this.f7574g)) {
            i3 = d3 + 1;
        }
        return d(this.f7575h) ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        A();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        g();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        boolean z3 = this.f7555F && !(!i(Math.min(this.f7561L, getMeasuredWidth())) && getButtonCount() == 2 && this.f7562M == -1);
        this.f7566Q = z3;
        if (!z3) {
            p();
            j();
            k();
            super.onMeasure(i3, i4);
            return;
        }
        q();
        l();
        m();
        n();
        if (this.f7570U && (getButtonCount() > 1 || (getButtonCount() == 1 && this.f7562M != -1))) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = this.f7569T;
        }
        if (this.f7562M != -1) {
            a(this.f7573f);
            a(this.f7574g);
            a(this.f7575h);
        }
        super.onMeasure(i3, i4);
    }

    public void setDynamicLayout(boolean z3) {
        this.f7555F = z3;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (getOrientation() != i3) {
            super.setOrientation(i3);
            o();
        }
    }

    public void setRecommendButtonId(int i3) {
        this.f7562M = i3;
    }

    public void setShowDividerWhenHasItems(boolean z3) {
        this.f7571V = z3;
    }

    public void setTopMarginFlag(boolean z3) {
        this.f7570U = z3;
    }

    @Deprecated
    public void setVerButDividerVerMargin(int i3) {
    }

    @Deprecated
    public void setVerButPaddingOffset(int i3) {
    }

    @Deprecated
    public void setVerButVerPadding(int i3) {
    }

    @Deprecated
    public void setVerNegButVerPaddingOffset(int i3) {
    }

    public void setVerPaddingBottom(int i3) {
        this.f7553D = i3;
    }

    public COUIButtonBarLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f7554E = true;
        this.f7555F = true;
        this.f7562M = -1;
        this.f7570U = true;
        this.f7571V = false;
        f(context, attributeSet);
    }
}
