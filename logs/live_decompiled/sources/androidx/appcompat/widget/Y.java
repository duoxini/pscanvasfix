package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import e.AbstractC0339a;
import f.AbstractC0348a;

/* loaded from: classes.dex */
public class Y implements D {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f4163a;

    /* renamed from: b, reason: collision with root package name */
    private int f4164b;

    /* renamed from: c, reason: collision with root package name */
    private View f4165c;

    /* renamed from: d, reason: collision with root package name */
    private View f4166d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f4167e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f4168f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f4169g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4170h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f4171i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f4172j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f4173k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f4174l;

    /* renamed from: m, reason: collision with root package name */
    boolean f4175m;

    /* renamed from: n, reason: collision with root package name */
    private C0229c f4176n;

    /* renamed from: o, reason: collision with root package name */
    private int f4177o;

    /* renamed from: p, reason: collision with root package name */
    private int f4178p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f4179q;

    class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final ActionMenuItem f4180e;

        a() {
            this.f4180e = new ActionMenuItem(Y.this.f4163a.getContext(), 0, R.id.home, 0, 0, Y.this.f4171i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Y y3 = Y.this;
            Window.Callback callback = y3.f4174l;
            if (callback == null || !y3.f4175m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f4180e);
        }
    }

    class b extends androidx.core.view.G {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4182a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4183b;

        b(int i3) {
            this.f4183b = i3;
        }

        @Override // androidx.core.view.F
        public void a(View view) {
            if (this.f4182a) {
                return;
            }
            Y.this.f4163a.setVisibility(this.f4183b);
        }

        @Override // androidx.core.view.G, androidx.core.view.F
        public void b(View view) {
            Y.this.f4163a.setVisibility(0);
        }

        @Override // androidx.core.view.G, androidx.core.view.F
        public void c(View view) {
            this.f4182a = true;
        }
    }

    public Y(Toolbar toolbar, boolean z3) {
        this(toolbar, z3, e.h.f11235a, e.e.f11162n);
    }

    private void G(CharSequence charSequence) {
        this.f4171i = charSequence;
        if ((this.f4164b & 8) != 0) {
            this.f4163a.setTitle(charSequence);
            if (this.f4170h) {
                androidx.core.view.y.m0(this.f4163a.getRootView(), charSequence);
            }
        }
    }

    private void H() {
        if ((this.f4164b & 4) != 0) {
            if (TextUtils.isEmpty(this.f4173k)) {
                this.f4163a.setNavigationContentDescription(this.f4178p);
            } else {
                this.f4163a.setNavigationContentDescription(this.f4173k);
            }
        }
    }

    private void I() {
        if ((this.f4164b & 4) == 0) {
            this.f4163a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f4163a;
        Drawable drawable = this.f4169g;
        if (drawable == null) {
            drawable = this.f4179q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void J() {
        Drawable drawable;
        int i3 = this.f4164b;
        if ((i3 & 2) == 0) {
            drawable = null;
        } else if ((i3 & 1) != 0) {
            drawable = this.f4168f;
            if (drawable == null) {
                drawable = this.f4167e;
            }
        } else {
            drawable = this.f4167e;
        }
        this.f4163a.setLogo(drawable);
    }

    private int x() {
        if (this.f4163a.getNavigationIcon() == null) {
            return 11;
        }
        this.f4179q = this.f4163a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f4168f = drawable;
        J();
    }

    public void B(int i3) {
        C(i3 == 0 ? null : getContext().getString(i3));
    }

    public void C(CharSequence charSequence) {
        this.f4173k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.f4169g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.f4172j = charSequence;
        if ((this.f4164b & 8) != 0) {
            this.f4163a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.f4170h = true;
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.D
    public void a(Menu menu, MenuPresenter.Callback callback) {
        if (this.f4176n == null) {
            C0229c c0229c = new C0229c(this.f4163a.getContext());
            this.f4176n = c0229c;
            c0229c.setId(e.f.f11196g);
        }
        this.f4176n.setCallback(callback);
        this.f4163a.setMenu((MenuBuilder) menu, this.f4176n);
    }

    @Override // androidx.appcompat.widget.D
    public boolean b() {
        return this.f4163a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.D
    public boolean c() {
        return this.f4163a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.D
    public void collapseActionView() {
        this.f4163a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.D
    public boolean d() {
        return this.f4163a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.D
    public boolean e() {
        return this.f4163a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.D
    public void f() {
        this.f4175m = true;
    }

    @Override // androidx.appcompat.widget.D
    public boolean g() {
        return this.f4163a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.D
    public Context getContext() {
        return this.f4163a.getContext();
    }

    @Override // androidx.appcompat.widget.D
    public CharSequence getTitle() {
        return this.f4163a.getTitle();
    }

    @Override // androidx.appcompat.widget.D
    public void h() {
        this.f4163a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.D
    public void i(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f4163a.setMenuCallbacks(callback, callback2);
    }

    @Override // androidx.appcompat.widget.D
    public int j() {
        return this.f4164b;
    }

    @Override // androidx.appcompat.widget.D
    public void k(int i3) {
        this.f4163a.setVisibility(i3);
    }

    @Override // androidx.appcompat.widget.D
    public Menu l() {
        return this.f4163a.getMenu();
    }

    @Override // androidx.appcompat.widget.D
    public void m(int i3) {
        A(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.D
    public void n(O o3) {
        View view = this.f4165c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f4163a;
            if (parent == toolbar) {
                toolbar.removeView(this.f4165c);
            }
        }
        this.f4165c = o3;
    }

    @Override // androidx.appcompat.widget.D
    public ViewGroup o() {
        return this.f4163a;
    }

    @Override // androidx.appcompat.widget.D
    public void p(boolean z3) {
    }

    @Override // androidx.appcompat.widget.D
    public int q() {
        return this.f4177o;
    }

    @Override // androidx.appcompat.widget.D
    public androidx.core.view.E r(int i3, long j3) {
        return androidx.core.view.y.d(this.f4163a).b(i3 == 0 ? 1.0f : 0.0f).f(j3).h(new b(i3));
    }

    @Override // androidx.appcompat.widget.D
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.D
    public void setIcon(int i3) {
        setIcon(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.D
    public void setWindowCallback(Window.Callback callback) {
        this.f4174l = callback;
    }

    @Override // androidx.appcompat.widget.D
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f4170h) {
            return;
        }
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.D
    public boolean t() {
        return this.f4163a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.D
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.D
    public void v(boolean z3) {
        this.f4163a.setCollapsible(z3);
    }

    @Override // androidx.appcompat.widget.D
    public void w(int i3) {
        View view;
        int i4 = this.f4164b ^ i3;
        this.f4164b = i3;
        if (i4 != 0) {
            if ((i4 & 4) != 0) {
                if ((i3 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i4 & 3) != 0) {
                J();
            }
            if ((i4 & 8) != 0) {
                if ((i3 & 8) != 0) {
                    this.f4163a.setTitle(this.f4171i);
                    this.f4163a.setSubtitle(this.f4172j);
                } else {
                    this.f4163a.setTitle((CharSequence) null);
                    this.f4163a.setSubtitle((CharSequence) null);
                }
            }
            if ((i4 & 16) == 0 || (view = this.f4166d) == null) {
                return;
            }
            if ((i3 & 16) != 0) {
                this.f4163a.addView(view);
            } else {
                this.f4163a.removeView(view);
            }
        }
    }

    public void y(View view) {
        View view2 = this.f4166d;
        if (view2 != null && (this.f4164b & 16) != 0) {
            this.f4163a.removeView(view2);
        }
        this.f4166d = view;
        if (view == null || (this.f4164b & 16) == 0) {
            return;
        }
        this.f4163a.addView(view);
    }

    public void z(int i3) {
        if (i3 == this.f4178p) {
            return;
        }
        this.f4178p = i3;
        if (TextUtils.isEmpty(this.f4163a.getNavigationContentDescription())) {
            B(this.f4178p);
        }
    }

    public Y(Toolbar toolbar, boolean z3, int i3, int i4) {
        Drawable drawable;
        this.f4177o = 0;
        this.f4178p = 0;
        this.f4163a = toolbar;
        this.f4171i = toolbar.getTitle();
        this.f4172j = toolbar.getSubtitle();
        this.f4170h = this.f4171i != null;
        this.f4169g = toolbar.getNavigationIcon();
        V w3 = V.w(toolbar.getContext(), null, e.j.f11356a, AbstractC0339a.f11088c, 0);
        this.f4179q = w3.g(e.j.f11400l);
        if (z3) {
            CharSequence p3 = w3.p(e.j.f11424r);
            if (!TextUtils.isEmpty(p3)) {
                F(p3);
            }
            CharSequence p4 = w3.p(e.j.f11416p);
            if (!TextUtils.isEmpty(p4)) {
                E(p4);
            }
            Drawable g3 = w3.g(e.j.f11408n);
            if (g3 != null) {
                A(g3);
            }
            Drawable g4 = w3.g(e.j.f11404m);
            if (g4 != null) {
                setIcon(g4);
            }
            if (this.f4169g == null && (drawable = this.f4179q) != null) {
                D(drawable);
            }
            w(w3.k(e.j.f11384h, 0));
            int n3 = w3.n(e.j.f11380g, 0);
            if (n3 != 0) {
                y(LayoutInflater.from(this.f4163a.getContext()).inflate(n3, (ViewGroup) this.f4163a, false));
                w(this.f4164b | 16);
            }
            int m3 = w3.m(e.j.f11392j, 0);
            if (m3 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f4163a.getLayoutParams();
                layoutParams.height = m3;
                this.f4163a.setLayoutParams(layoutParams);
            }
            int e3 = w3.e(e.j.f11376f, -1);
            int e4 = w3.e(e.j.f11372e, -1);
            if (e3 >= 0 || e4 >= 0) {
                this.f4163a.setContentInsetsRelative(Math.max(e3, 0), Math.max(e4, 0));
            }
            int n4 = w3.n(e.j.f11428s, 0);
            if (n4 != 0) {
                Toolbar toolbar2 = this.f4163a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n4);
            }
            int n5 = w3.n(e.j.f11420q, 0);
            if (n5 != 0) {
                Toolbar toolbar3 = this.f4163a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n5);
            }
            int n6 = w3.n(e.j.f11412o, 0);
            if (n6 != 0) {
                this.f4163a.setPopupTheme(n6);
            }
        } else {
            this.f4164b = x();
        }
        w3.x();
        z(i3);
        this.f4173k = this.f4163a.getNavigationContentDescription();
        this.f4163a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.D
    public void setIcon(Drawable drawable) {
        this.f4167e = drawable;
        J();
    }
}
