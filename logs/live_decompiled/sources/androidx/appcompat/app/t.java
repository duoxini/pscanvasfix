package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.E;
import androidx.core.view.F;
import androidx.core.view.G;
import androidx.core.view.H;
import androidx.core.view.y;
import e.AbstractC0339a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class t extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {

    /* renamed from: D, reason: collision with root package name */
    private static final Interpolator f3679D = new AccelerateInterpolator();

    /* renamed from: E, reason: collision with root package name */
    private static final Interpolator f3680E = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Context f3684a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3685b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f3686c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f3687d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f3688e;

    /* renamed from: f, reason: collision with root package name */
    D f3689f;

    /* renamed from: g, reason: collision with root package name */
    ActionBarContextView f3690g;

    /* renamed from: h, reason: collision with root package name */
    View f3691h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3694k;

    /* renamed from: l, reason: collision with root package name */
    d f3695l;

    /* renamed from: m, reason: collision with root package name */
    androidx.appcompat.view.b f3696m;

    /* renamed from: n, reason: collision with root package name */
    b.a f3697n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3698o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3700q;

    /* renamed from: t, reason: collision with root package name */
    boolean f3703t;

    /* renamed from: u, reason: collision with root package name */
    boolean f3704u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3705v;

    /* renamed from: x, reason: collision with root package name */
    androidx.appcompat.view.h f3707x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3708y;

    /* renamed from: z, reason: collision with root package name */
    boolean f3709z;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f3692i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private int f3693j = -1;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList f3699p = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    private int f3701r = 0;

    /* renamed from: s, reason: collision with root package name */
    boolean f3702s = true;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3706w = true;

    /* renamed from: A, reason: collision with root package name */
    final F f3681A = new a();

    /* renamed from: B, reason: collision with root package name */
    final F f3682B = new b();

    /* renamed from: C, reason: collision with root package name */
    final H f3683C = new c();

    class a extends G {
        a() {
        }

        @Override // androidx.core.view.F
        public void a(View view) {
            View view2;
            t tVar = t.this;
            if (tVar.f3702s && (view2 = tVar.f3691h) != null) {
                view2.setTranslationY(0.0f);
                t.this.f3688e.setTranslationY(0.0f);
            }
            t.this.f3688e.setVisibility(8);
            t.this.f3688e.setTransitioning(false);
            t tVar2 = t.this;
            tVar2.f3707x = null;
            tVar2.y();
            ActionBarOverlayLayout actionBarOverlayLayout = t.this.f3687d;
            if (actionBarOverlayLayout != null) {
                y.f0(actionBarOverlayLayout);
            }
        }
    }

    class b extends G {
        b() {
        }

        @Override // androidx.core.view.F
        public void a(View view) {
            t tVar = t.this;
            tVar.f3707x = null;
            tVar.f3688e.requestLayout();
        }
    }

    class c implements H {
        c() {
        }

        @Override // androidx.core.view.H
        public void a(View view) {
            ((View) t.this.f3688e.getParent()).invalidate();
        }
    }

    public class d extends androidx.appcompat.view.b implements MenuBuilder.Callback {

        /* renamed from: g, reason: collision with root package name */
        private final Context f3713g;

        /* renamed from: h, reason: collision with root package name */
        private final MenuBuilder f3714h;

        /* renamed from: i, reason: collision with root package name */
        private b.a f3715i;

        /* renamed from: j, reason: collision with root package name */
        private WeakReference f3716j;

        public d(Context context, b.a aVar) {
            this.f3713g = context;
            this.f3715i = aVar;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f3714h = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // androidx.appcompat.view.b
        public void a() {
            t tVar = t.this;
            if (tVar.f3695l != this) {
                return;
            }
            if (t.x(tVar.f3703t, tVar.f3704u, false)) {
                this.f3715i.d(this);
            } else {
                t tVar2 = t.this;
                tVar2.f3696m = this;
                tVar2.f3697n = this.f3715i;
            }
            this.f3715i = null;
            t.this.w(false);
            t.this.f3690g.g();
            t tVar3 = t.this;
            tVar3.f3687d.setHideOnContentScrollEnabled(tVar3.f3709z);
            t.this.f3695l = null;
        }

        @Override // androidx.appcompat.view.b
        public View b() {
            WeakReference weakReference = this.f3716j;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu c() {
            return this.f3714h;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater d() {
            return new androidx.appcompat.view.g(this.f3713g);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence e() {
            return t.this.f3690g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return t.this.f3690g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void i() {
            if (t.this.f3695l != this) {
                return;
            }
            this.f3714h.stopDispatchingItemsChanged();
            try {
                this.f3715i.a(this, this.f3714h);
            } finally {
                this.f3714h.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean j() {
            return t.this.f3690g.j();
        }

        @Override // androidx.appcompat.view.b
        public void k(View view) {
            t.this.f3690g.setCustomView(view);
            this.f3716j = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.b
        public void l(int i3) {
            m(t.this.f3684a.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.b
        public void m(CharSequence charSequence) {
            t.this.f3690g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void o(int i3) {
            p(t.this.f3684a.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            b.a aVar = this.f3715i;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f3715i == null) {
                return;
            }
            i();
            t.this.f3690g.l();
        }

        @Override // androidx.appcompat.view.b
        public void p(CharSequence charSequence) {
            t.this.f3690g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(boolean z3) {
            super.q(z3);
            t.this.f3690g.setTitleOptional(z3);
        }

        public boolean r() {
            this.f3714h.stopDispatchingItemsChanged();
            try {
                return this.f3715i.c(this, this.f3714h);
            } finally {
                this.f3714h.startDispatchingItemsChanged();
            }
        }
    }

    public t(Activity activity, boolean z3) {
        this.f3686c = activity;
        View decorView = activity.getWindow().getDecorView();
        E(decorView);
        if (z3) {
            return;
        }
        this.f3691h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private D B(View view) {
        if (view instanceof D) {
            return (D) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void D() {
        if (this.f3705v) {
            this.f3705v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f3687d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void E(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(e.f.f11205p);
        this.f3687d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f3689f = B(view.findViewById(e.f.f11190a));
        this.f3690g = (ActionBarContextView) view.findViewById(e.f.f11195f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(e.f.f11192c);
        this.f3688e = actionBarContainer;
        D d3 = this.f3689f;
        if (d3 == null || this.f3690g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f3684a = d3.getContext();
        boolean z3 = (this.f3689f.j() & 4) != 0;
        if (z3) {
            this.f3694k = true;
        }
        androidx.appcompat.view.a b3 = androidx.appcompat.view.a.b(this.f3684a);
        J(b3.a() || z3);
        H(b3.e());
        TypedArray obtainStyledAttributes = this.f3684a.obtainStyledAttributes(null, e.j.f11356a, AbstractC0339a.f11088c, 0);
        if (obtainStyledAttributes.getBoolean(e.j.f11396k, false)) {
            I(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.j.f11388i, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void H(boolean z3) {
        this.f3700q = z3;
        if (z3) {
            this.f3688e.setTabContainer(null);
            this.f3689f.n(null);
        } else {
            this.f3689f.n(null);
            this.f3688e.setTabContainer(null);
        }
        boolean z4 = false;
        boolean z5 = C() == 2;
        this.f3689f.v(!this.f3700q && z5);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3687d;
        if (!this.f3700q && z5) {
            z4 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    private boolean K() {
        return y.O(this.f3688e);
    }

    private void L() {
        if (this.f3705v) {
            return;
        }
        this.f3705v = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3687d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z3) {
        if (x(this.f3703t, this.f3704u, this.f3705v)) {
            if (this.f3706w) {
                return;
            }
            this.f3706w = true;
            A(z3);
            return;
        }
        if (this.f3706w) {
            this.f3706w = false;
            z(z3);
        }
    }

    static boolean x(boolean z3, boolean z4, boolean z5) {
        if (z5) {
            return true;
        }
        return (z3 || z4) ? false : true;
    }

    public void A(boolean z3) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f3707x;
        if (hVar != null) {
            hVar.a();
        }
        this.f3688e.setVisibility(0);
        if (this.f3701r == 0 && (this.f3708y || z3)) {
            this.f3688e.setTranslationY(0.0f);
            float f3 = -this.f3688e.getHeight();
            if (z3) {
                this.f3688e.getLocationInWindow(new int[]{0, 0});
                f3 -= r5[1];
            }
            this.f3688e.setTranslationY(f3);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            E m3 = y.d(this.f3688e).m(0.0f);
            m3.k(this.f3683C);
            hVar2.c(m3);
            if (this.f3702s && (view2 = this.f3691h) != null) {
                view2.setTranslationY(f3);
                hVar2.c(y.d(this.f3691h).m(0.0f));
            }
            hVar2.f(f3680E);
            hVar2.e(250L);
            hVar2.g(this.f3682B);
            this.f3707x = hVar2;
            hVar2.h();
        } else {
            this.f3688e.setAlpha(1.0f);
            this.f3688e.setTranslationY(0.0f);
            if (this.f3702s && (view = this.f3691h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f3682B.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3687d;
        if (actionBarOverlayLayout != null) {
            y.f0(actionBarOverlayLayout);
        }
    }

    public int C() {
        return this.f3689f.q();
    }

    public void F(int i3, int i4) {
        int j3 = this.f3689f.j();
        if ((i4 & 4) != 0) {
            this.f3694k = true;
        }
        this.f3689f.w((i3 & i4) | ((~i4) & j3));
    }

    public void G(float f3) {
        y.r0(this.f3688e, f3);
    }

    public void I(boolean z3) {
        if (z3 && !this.f3687d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f3709z = z3;
        this.f3687d.setHideOnContentScrollEnabled(z3);
    }

    public void J(boolean z3) {
        this.f3689f.p(z3);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z3) {
        this.f3702s = z3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f3704u) {
            this.f3704u = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        androidx.appcompat.view.h hVar = this.f3707x;
        if (hVar != null) {
            hVar.a();
            this.f3707x = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i3) {
        this.f3701r = i3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f3704u) {
            return;
        }
        this.f3704u = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        D d3 = this.f3689f;
        if (d3 == null || !d3.t()) {
            return false;
        }
        this.f3689f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z3) {
        if (z3 == this.f3698o) {
            return;
        }
        this.f3698o = z3;
        if (this.f3699p.size() <= 0) {
            return;
        }
        p.a(this.f3699p.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f3689f.j();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f3685b == null) {
            TypedValue typedValue = new TypedValue();
            this.f3684a.getTheme().resolveAttribute(AbstractC0339a.f11090e, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f3685b = new ContextThemeWrapper(this.f3684a, i3);
            } else {
                this.f3685b = this.f3684a;
            }
        }
        return this.f3685b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        H(androidx.appcompat.view.a.b(this.f3684a).e());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu c3;
        d dVar = this.f3695l;
        if (dVar == null || (c3 = dVar.c()) == null) {
            return false;
        }
        c3.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c3.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z3) {
        if (this.f3694k) {
            return;
        }
        s(z3);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z3) {
        F(z3 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z3) {
        androidx.appcompat.view.h hVar;
        this.f3708y = z3;
        if (z3 || (hVar = this.f3707x) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void u(CharSequence charSequence) {
        this.f3689f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b v(b.a aVar) {
        d dVar = this.f3695l;
        if (dVar != null) {
            dVar.a();
        }
        this.f3687d.setHideOnContentScrollEnabled(false);
        this.f3690g.k();
        d dVar2 = new d(this.f3690g.getContext(), aVar);
        if (!dVar2.r()) {
            return null;
        }
        this.f3695l = dVar2;
        dVar2.i();
        this.f3690g.h(dVar2);
        w(true);
        return dVar2;
    }

    public void w(boolean z3) {
        E f3;
        E e3;
        if (z3) {
            L();
        } else {
            D();
        }
        if (!K()) {
            if (z3) {
                this.f3689f.k(4);
                this.f3690g.setVisibility(0);
                return;
            } else {
                this.f3689f.k(0);
                this.f3690g.setVisibility(8);
                return;
            }
        }
        if (z3) {
            f3 = this.f3689f.r(4, 100L);
            e3 = this.f3690g.f(0, 200L);
        } else {
            E r3 = this.f3689f.r(0, 200L);
            f3 = this.f3690g.f(8, 100L);
            e3 = r3;
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(f3, e3);
        hVar.h();
    }

    void y() {
        b.a aVar = this.f3697n;
        if (aVar != null) {
            aVar.d(this.f3696m);
            this.f3696m = null;
            this.f3697n = null;
        }
    }

    public void z(boolean z3) {
        View view;
        androidx.appcompat.view.h hVar = this.f3707x;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f3701r != 0 || (!this.f3708y && !z3)) {
            this.f3681A.a(null);
            return;
        }
        this.f3688e.setAlpha(1.0f);
        this.f3688e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f3 = -this.f3688e.getHeight();
        if (z3) {
            this.f3688e.getLocationInWindow(new int[]{0, 0});
            f3 -= r5[1];
        }
        E m3 = y.d(this.f3688e).m(f3);
        m3.k(this.f3683C);
        hVar2.c(m3);
        if (this.f3702s && (view = this.f3691h) != null) {
            hVar2.c(y.d(view).m(f3));
        }
        hVar2.f(f3679D);
        hVar2.e(250L);
        hVar2.g(this.f3681A);
        this.f3707x = hVar2;
        hVar2.h();
    }

    public t(Dialog dialog) {
        E(dialog.getWindow().getDecorView());
    }
}
