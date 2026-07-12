package com.google.android.material.button;

import H0.j;
import R0.c;
import S0.b;
import U0.g;
import U0.k;
import U0.n;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.view.y;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
class a {

    /* renamed from: t, reason: collision with root package name */
    private static final boolean f9487t = true;

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f9488u = false;

    /* renamed from: a, reason: collision with root package name */
    private final MaterialButton f9489a;

    /* renamed from: b, reason: collision with root package name */
    private k f9490b;

    /* renamed from: c, reason: collision with root package name */
    private int f9491c;

    /* renamed from: d, reason: collision with root package name */
    private int f9492d;

    /* renamed from: e, reason: collision with root package name */
    private int f9493e;

    /* renamed from: f, reason: collision with root package name */
    private int f9494f;

    /* renamed from: g, reason: collision with root package name */
    private int f9495g;

    /* renamed from: h, reason: collision with root package name */
    private int f9496h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f9497i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f9498j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f9499k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f9500l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f9501m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9502n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9503o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f9504p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f9505q;

    /* renamed from: r, reason: collision with root package name */
    private LayerDrawable f9506r;

    /* renamed from: s, reason: collision with root package name */
    private int f9507s;

    a(MaterialButton materialButton, k kVar) {
        this.f9489a = materialButton;
        this.f9490b = kVar;
    }

    private void E(int i3, int i4) {
        int C3 = y.C(this.f9489a);
        int paddingTop = this.f9489a.getPaddingTop();
        int B3 = y.B(this.f9489a);
        int paddingBottom = this.f9489a.getPaddingBottom();
        int i5 = this.f9493e;
        int i6 = this.f9494f;
        this.f9494f = i4;
        this.f9493e = i3;
        if (!this.f9503o) {
            F();
        }
        y.y0(this.f9489a, C3, (paddingTop + i3) - i5, B3, (paddingBottom + i4) - i6);
    }

    private void F() {
        this.f9489a.setInternalBackground(a());
        g f3 = f();
        if (f3 != null) {
            f3.T(this.f9507s);
        }
    }

    private void G(k kVar) {
        if (f9488u && !this.f9503o) {
            int C3 = y.C(this.f9489a);
            int paddingTop = this.f9489a.getPaddingTop();
            int B3 = y.B(this.f9489a);
            int paddingBottom = this.f9489a.getPaddingBottom();
            F();
            y.y0(this.f9489a, C3, paddingTop, B3, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    private void H() {
        g f3 = f();
        g n3 = n();
        if (f3 != null) {
            f3.a0(this.f9496h, this.f9499k);
            if (n3 != null) {
                n3.Z(this.f9496h, this.f9502n ? L0.a.d(this.f9489a, H0.a.f482n) : 0);
            }
        }
    }

    private InsetDrawable I(Drawable drawable) {
        return new InsetDrawable(drawable, this.f9491c, this.f9493e, this.f9492d, this.f9494f);
    }

    private Drawable a() {
        g gVar = new g(this.f9490b);
        gVar.K(this.f9489a.getContext());
        androidx.core.graphics.drawable.a.i(gVar, this.f9498j);
        PorterDuff.Mode mode = this.f9497i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.j(gVar, mode);
        }
        gVar.a0(this.f9496h, this.f9499k);
        g gVar2 = new g(this.f9490b);
        gVar2.setTint(0);
        gVar2.Z(this.f9496h, this.f9502n ? L0.a.d(this.f9489a, H0.a.f482n) : 0);
        if (f9487t) {
            g gVar3 = new g(this.f9490b);
            this.f9501m = gVar3;
            androidx.core.graphics.drawable.a.h(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.a(this.f9500l), I(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f9501m);
            this.f9506r = rippleDrawable;
            return rippleDrawable;
        }
        S0.a aVar = new S0.a(this.f9490b);
        this.f9501m = aVar;
        androidx.core.graphics.drawable.a.i(aVar, b.a(this.f9500l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f9501m});
        this.f9506r = layerDrawable;
        return I(layerDrawable);
    }

    private g g(boolean z3) {
        LayerDrawable layerDrawable = this.f9506r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f9487t ? (g) ((LayerDrawable) ((InsetDrawable) this.f9506r.getDrawable(0)).getDrawable()).getDrawable(!z3 ? 1 : 0) : (g) this.f9506r.getDrawable(!z3 ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    void A(ColorStateList colorStateList) {
        if (this.f9499k != colorStateList) {
            this.f9499k = colorStateList;
            H();
        }
    }

    void B(int i3) {
        if (this.f9496h != i3) {
            this.f9496h = i3;
            H();
        }
    }

    void C(ColorStateList colorStateList) {
        if (this.f9498j != colorStateList) {
            this.f9498j = colorStateList;
            if (f() != null) {
                androidx.core.graphics.drawable.a.i(f(), this.f9498j);
            }
        }
    }

    void D(PorterDuff.Mode mode) {
        if (this.f9497i != mode) {
            this.f9497i = mode;
            if (f() == null || this.f9497i == null) {
                return;
            }
            androidx.core.graphics.drawable.a.j(f(), this.f9497i);
        }
    }

    int b() {
        return this.f9495g;
    }

    public int c() {
        return this.f9494f;
    }

    public int d() {
        return this.f9493e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f9506r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f9506r.getNumberOfLayers() > 2 ? (n) this.f9506r.getDrawable(2) : (n) this.f9506r.getDrawable(1);
    }

    g f() {
        return g(false);
    }

    ColorStateList h() {
        return this.f9500l;
    }

    k i() {
        return this.f9490b;
    }

    ColorStateList j() {
        return this.f9499k;
    }

    int k() {
        return this.f9496h;
    }

    ColorStateList l() {
        return this.f9498j;
    }

    PorterDuff.Mode m() {
        return this.f9497i;
    }

    boolean o() {
        return this.f9503o;
    }

    boolean p() {
        return this.f9505q;
    }

    void q(TypedArray typedArray) {
        this.f9491c = typedArray.getDimensionPixelOffset(j.f712N2, 0);
        this.f9492d = typedArray.getDimensionPixelOffset(j.f716O2, 0);
        this.f9493e = typedArray.getDimensionPixelOffset(j.f720P2, 0);
        this.f9494f = typedArray.getDimensionPixelOffset(j.f724Q2, 0);
        if (typedArray.hasValue(j.f740U2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(j.f740U2, -1);
            this.f9495g = dimensionPixelSize;
            y(this.f9490b.w(dimensionPixelSize));
            this.f9504p = true;
        }
        this.f9496h = typedArray.getDimensionPixelSize(j.e3, 0);
        this.f9497i = ViewUtils.parseTintMode(typedArray.getInt(j.f736T2, -1), PorterDuff.Mode.SRC_IN);
        this.f9498j = c.a(this.f9489a.getContext(), typedArray, j.f732S2);
        this.f9499k = c.a(this.f9489a.getContext(), typedArray, j.d3);
        this.f9500l = c.a(this.f9489a.getContext(), typedArray, j.c3);
        this.f9505q = typedArray.getBoolean(j.f728R2, false);
        this.f9507s = typedArray.getDimensionPixelSize(j.f744V2, 0);
        int C3 = y.C(this.f9489a);
        int paddingTop = this.f9489a.getPaddingTop();
        int B3 = y.B(this.f9489a);
        int paddingBottom = this.f9489a.getPaddingBottom();
        if (typedArray.hasValue(j.f708M2)) {
            s();
        } else {
            F();
        }
        y.y0(this.f9489a, C3 + this.f9491c, paddingTop + this.f9493e, B3 + this.f9492d, paddingBottom + this.f9494f);
    }

    void r(int i3) {
        if (f() != null) {
            f().setTint(i3);
        }
    }

    void s() {
        this.f9503o = true;
        this.f9489a.setSupportBackgroundTintList(this.f9498j);
        this.f9489a.setSupportBackgroundTintMode(this.f9497i);
    }

    void t(boolean z3) {
        this.f9505q = z3;
    }

    void u(int i3) {
        if (this.f9504p && this.f9495g == i3) {
            return;
        }
        this.f9495g = i3;
        this.f9504p = true;
        y(this.f9490b.w(i3));
    }

    public void v(int i3) {
        E(this.f9493e, i3);
    }

    public void w(int i3) {
        E(i3, this.f9494f);
    }

    void x(ColorStateList colorStateList) {
        if (this.f9500l != colorStateList) {
            this.f9500l = colorStateList;
            boolean z3 = f9487t;
            if (z3 && (this.f9489a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f9489a.getBackground()).setColor(b.a(colorStateList));
            } else {
                if (z3 || !(this.f9489a.getBackground() instanceof S0.a)) {
                    return;
                }
                ((S0.a) this.f9489a.getBackground()).setTintList(b.a(colorStateList));
            }
        }
    }

    void y(k kVar) {
        this.f9490b = kVar;
        G(kVar);
    }

    void z(boolean z3) {
        this.f9502n = z3;
        H();
    }
}
