package com.coui.appcompat.poplist;

import Z.b;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.coui.appcompat.poplist.AbstractC0300a;

/* loaded from: classes.dex */
class D extends AbstractC0300a {

    /* renamed from: f, reason: collision with root package name */
    private final int f8140f;

    /* renamed from: g, reason: collision with root package name */
    private final int f8141g;

    /* renamed from: j, reason: collision with root package name */
    private Z.c f8144j;

    /* renamed from: k, reason: collision with root package name */
    private Z.c f8145k;

    /* renamed from: l, reason: collision with root package name */
    private Z.c f8146l;

    /* renamed from: m, reason: collision with root package name */
    private int f8147m;

    /* renamed from: n, reason: collision with root package name */
    private int f8148n;

    /* renamed from: o, reason: collision with root package name */
    private int f8149o;

    /* renamed from: p, reason: collision with root package name */
    private int f8150p;

    /* renamed from: q, reason: collision with root package name */
    private int f8151q;

    /* renamed from: r, reason: collision with root package name */
    private int f8152r;

    /* renamed from: w, reason: collision with root package name */
    private float f8157w;

    /* renamed from: x, reason: collision with root package name */
    private float f8158x;

    /* renamed from: y, reason: collision with root package name */
    private float f8159y;

    /* renamed from: z, reason: collision with root package name */
    private static final B.c f8139z = new a("subMenuTransition");

    /* renamed from: A, reason: collision with root package name */
    private static final B.c f8137A = new b("mainMenuTScaletransition");

    /* renamed from: B, reason: collision with root package name */
    private static final B.c f8138B = new c("mainMenuAlphaTransition");

    /* renamed from: h, reason: collision with root package name */
    private final b.q f8142h = new b.q() { // from class: com.coui.appcompat.poplist.B
        @Override // Z.b.q
        public final void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
            D.this.E(bVar, z3, f3, f4);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final b.q f8143i = new b.q() { // from class: com.coui.appcompat.poplist.C
        @Override // Z.b.q
        public final void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
            D.this.F(bVar, z3, f3, f4);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private float f8153s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f8154t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    private float f8155u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f8156v = 1.0f;

    class a extends B.c {
        a(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(D d3) {
            return d3.D();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(D d3, float f3) {
            d3.I(f3);
        }
    }

    class b extends B.c {
        b(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(D d3) {
            return d3.C();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(D d3, float f3) {
            d3.H(f3);
        }
    }

    class c extends B.c {
        c(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(D d3) {
            return d3.B();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(D d3, float f3) {
            d3.G(f3);
        }
    }

    D(Context context) {
        this.f8140f = context.getResources().getDimensionPixelOffset(V1.c.f2548o);
        this.f8141g = context.getResources().getDimensionPixelOffset(V1.c.f2538e);
    }

    private void A() {
        if (this.f8146l != null) {
            return;
        }
        Z.d dVar = new Z.d();
        dVar.d(0.0f);
        dVar.g(0.35f);
        Z.c cVar = new Z.c(this, f8139z);
        this.f8146l = cVar;
        cVar.B(dVar);
        this.f8146l.a(this.f8143i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float B() {
        return this.f8154t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float C() {
        return this.f8153s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float D() {
        return this.f8155u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(Z.b bVar, boolean z3, float f3, float f4) {
        if (z3) {
            AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
            if (interfaceC0106a != null) {
                interfaceC0106a.j();
                return;
            }
            return;
        }
        if (f3 == 0.0f) {
            AbstractC0300a.InterfaceC0106a interfaceC0106a2 = this.f8188a;
            if (interfaceC0106a2 != null) {
                interfaceC0106a2.g();
                return;
            }
            return;
        }
        AbstractC0300a.InterfaceC0106a interfaceC0106a3 = this.f8188a;
        if (interfaceC0106a3 != null) {
            interfaceC0106a3.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Z.b bVar, boolean z3, float f3, float f4) {
        if (z3) {
            AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
            if (interfaceC0106a != null) {
                interfaceC0106a.c();
                return;
            }
            return;
        }
        if (f3 == 0.0f) {
            AbstractC0300a.InterfaceC0106a interfaceC0106a2 = this.f8188a;
            if (interfaceC0106a2 != null) {
                interfaceC0106a2.f();
                return;
            }
            return;
        }
        AbstractC0300a.InterfaceC0106a interfaceC0106a3 = this.f8188a;
        if (interfaceC0106a3 != null) {
            interfaceC0106a3.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f3) {
        this.f8154t = f3;
        float f4 = f3 / 10000.0f;
        View view = this.f8190c;
        if (view == null) {
            Log.w("PopupMenuAnimCtrl-S", "No main menu root view! Skip animation update");
            return;
        }
        if (view.getVisibility() != 0) {
            this.f8190c.setVisibility(0);
        }
        float i3 = y0.j.i(0.0f, 1.0f, f4);
        this.f8156v = i3;
        this.f8189b.setAlpha(i3);
        View view2 = this.f8190c;
        if ((view2 instanceof RoundFrameLayout) && ((RoundFrameLayout) view2).getUseBackgroundBlur()) {
            this.f8190c.setAlpha(this.f8156v);
        }
        View view3 = this.f8191d;
        if ((view3 instanceof RoundFrameLayout) && ((RoundFrameLayout) view3).getUseBackgroundBlur()) {
            this.f8191d.setAlpha(this.f8156v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(float f3) {
        if (this.f8153s != 0.0f && this.f8154t == 0.0f && this.f8144j.v()) {
            this.f8153s = 0.0f;
        } else {
            this.f8153s = f3;
        }
        float f4 = this.f8153s / 10000.0f;
        View view = this.f8190c;
        if (view == null) {
            Log.w("PopupMenuAnimCtrl-S", "No main menu root view! Skip animation update");
            return;
        }
        if (view.getVisibility() != 0) {
            this.f8190c.setVisibility(0);
        }
        this.f8189b.setScaleX(y0.j.i(0.0f, 1.0f, f4));
        this.f8189b.setScaleY(y0.j.i(0.0f, 1.0f, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(float f3) {
        this.f8155u = f3;
        float f4 = f3 / 10000.0f;
        int round = Math.round(y0.j.i(this.f8147m, this.f8148n, f4));
        View view = this.f8191d;
        if (view instanceof RoundFrameLayout) {
            if (view.getVisibility() != 0) {
                this.f8191d.setVisibility(0);
            }
            this.f8191d.setTranslationY(round);
            int i3 = (int) y0.j.i(this.f8149o, this.f8150p, f4);
            ((RoundFrameLayout) this.f8191d).q(0, i3, this.f8192e.f8382e.width(), i3 + ((int) y0.j.i(this.f8151q, this.f8152r, f4)), f4);
            View childAt = ((RoundFrameLayout) this.f8191d).getChildAt(0);
            if (childAt instanceof ListView) {
                int i4 = 1;
                while (true) {
                    ListView listView = (ListView) childAt;
                    if (i4 > listView.getChildCount()) {
                        break;
                    }
                    View childAt2 = listView.getChildAt(i4);
                    if (childAt2 != null) {
                        childAt2.setAlpha(f4);
                    }
                    i4++;
                }
            }
        }
        View view2 = this.f8190c;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).getChildAt(0).setAlpha(y0.j.i(1.0f, this.f8157w, f4));
        }
        this.f8190c.setScaleX(y0.j.i(1.0f, this.f8158x, f4));
        this.f8190c.setScaleY(y0.j.i(1.0f, this.f8159y, f4));
        J(f4, round);
    }

    private void J(float f3, int i3) {
        if (this.f8192e.f8382e.isEmpty()) {
            this.f8190c.setTranslationY(0.0f);
            return;
        }
        v vVar = this.f8192e;
        int i4 = vVar.f8380c.top;
        int i5 = this.f8140f;
        int i6 = i4 + i5;
        int i7 = vVar.f8382e.top;
        if (i6 > i7) {
            this.f8190c.setTranslationY((int) y0.j.i(0.0f, (i7 - i5) - i4, f3));
        } else if (i4 + i5 > i7 + i3) {
            this.f8190c.setTranslationY((i7 + i3) - (i4 + i5));
        } else {
            this.f8190c.setTranslationY(0.0f);
        }
    }

    private void x() {
        this.f8157w = 0.3f;
        float width = this.f8192e.f8381d.width() / this.f8192e.f8380c.width();
        this.f8158x = width;
        this.f8159y = width;
        v vVar = this.f8192e;
        Rect rect = vVar.f8380c;
        int i3 = rect.left;
        Rect rect2 = vVar.f8381d;
        if (i3 == rect2.left) {
            this.f8190c.setPivotX(0.0f);
        } else if (rect.right == rect2.right) {
            this.f8190c.setPivotX(r0.getWidth());
        } else {
            this.f8190c.setPivotX(r0.getWidth() / 2.0f);
        }
        this.f8190c.setPivotY(0.0f);
    }

    private void y() {
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.d();
        }
        this.f8149o = this.f8141g * 2;
        this.f8150p = 0;
        this.f8151q = this.f8192e.f8384g.height() - this.f8149o;
        this.f8152r = this.f8192e.f8382e.height();
        View view = this.f8191d;
        if (view instanceof RoundFrameLayout) {
            ((RoundFrameLayout) view).q(0, this.f8149o, this.f8192e.f8382e.width(), this.f8151q, 1.0f);
        }
    }

    private void z() {
        if (this.f8144j == null || this.f8145k == null) {
            Z.d dVar = new Z.d();
            dVar.d(0.2f);
            dVar.g(0.35f);
            Z.c cVar = new Z.c(this, f8137A);
            this.f8144j = cVar;
            cVar.B(dVar);
            Z.d dVar2 = new Z.d();
            dVar2.d(0.2f);
            dVar2.g(0.35f);
            Z.c cVar2 = new Z.c(this, f8138B);
            this.f8145k = cVar2;
            cVar2.B(dVar2);
            this.f8145k.a(this.f8142h);
        }
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    void a() {
        View view = this.f8191d;
        if (view instanceof RoundFrameLayout) {
            view.setTranslationY(0.0f);
            ((RoundFrameLayout) this.f8191d).k();
        }
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void c(View view) {
        z();
        this.f8153s = 0.0f;
        this.f8154t = 0.0f;
        super.c(view);
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void f(View view) {
        A();
        if (this.f8146l.h() && this.f8146l.v()) {
            if (view == this.f8191d) {
                this.f8146l.c();
            } else {
                this.f8146l.C();
            }
        }
        v vVar = this.f8192e;
        int i3 = vVar.f8384g.top - vVar.f8382e.top;
        this.f8147m = i3;
        if (!vVar.f8389l) {
            this.f8147m = i3 - this.f8141g;
        }
        this.f8148n = 0;
        super.f(view);
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void h(boolean z3) {
        if (this.f8190c == null) {
            Log.w("PopupMenuAnimCtrl-S", "No main menu root view! Set a main menu view before starting animation!");
            return;
        }
        this.f8189b.setTranslationY(0.0f);
        this.f8189b.setPivotX(this.f8192e.e());
        this.f8189b.setPivotY(this.f8192e.f());
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.h();
        }
        this.f8144j.x().g(0.35f);
        this.f8144j.x().d(0.2f);
        this.f8144j.o(this.f8153s);
        this.f8144j.u(10000.0f);
        if (!z3 && this.f8144j.v()) {
            this.f8144j.C();
        }
        this.f8145k.x().g(0.35f);
        this.f8145k.x().d(0.2f);
        this.f8145k.o(this.f8154t);
        this.f8145k.u(10000.0f);
        if (z3 || !this.f8145k.v()) {
            return;
        }
        this.f8145k.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void j(boolean z3) {
        if (this.f8190c == null) {
            Log.w("PopupMenuAnimCtrl-S", "No main menu root view! Set a main menu view before starting animation!");
            return;
        }
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.i();
        }
        this.f8144j.x().g(0.3f);
        this.f8144j.x().d(0.0f);
        this.f8144j.o(this.f8153s);
        this.f8144j.u(0.0f);
        if (!z3 && this.f8144j.v()) {
            this.f8144j.C();
        }
        this.f8145k.x().g(0.25f);
        this.f8145k.x().d(0.0f);
        this.f8145k.o(this.f8154t);
        this.f8145k.u(0.0f);
        if (z3 || !this.f8145k.v()) {
            return;
        }
        this.f8145k.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void l(boolean z3) {
        if (this.f8190c == null) {
            Log.e("PopupMenuAnimCtrl-S", "No main menu view! Add a main menu view before showing sub menu!");
            return;
        }
        if (this.f8191d == null) {
            Log.w("PopupMenuAnimCtrl-S", "No sub menu root view! Set a sub menu view before starting animation!");
            return;
        }
        x();
        y();
        this.f8191d.setAlpha(this.f8156v);
        this.f8146l.o(this.f8155u);
        this.f8146l.u(10000.0f);
        if (z3 || !this.f8146l.v()) {
            return;
        }
        this.f8146l.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void n(boolean z3) {
        A();
        if (this.f8146l.h()) {
            Log.w("PopupMenuAnimCtrl-S", "Sub menu is exiting!");
        }
        if (this.f8191d == null) {
            Log.w("PopupMenuAnimCtrl-S", "No sub menu root view! Set a sub menu view before starting animation!");
            return;
        }
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.e();
        }
        this.f8146l.o(this.f8155u);
        this.f8146l.u(0.0f);
        if (z3 || !this.f8146l.v()) {
            return;
        }
        this.f8146l.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void o() {
        Z.c cVar = this.f8144j;
        if (cVar != null) {
            cVar.c();
            H(0.0f);
            G(0.0f);
        }
        Z.c cVar2 = this.f8146l;
        if (cVar2 != null) {
            cVar2.c();
            I(0.0f);
        }
    }
}
