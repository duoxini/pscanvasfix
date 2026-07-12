package com.coui.appcompat.poplist;

import Z.b;
import android.util.Log;
import android.view.View;
import com.coui.appcompat.poplist.AbstractC0300a;

/* loaded from: classes.dex */
class q extends AbstractC0300a {

    /* renamed from: o, reason: collision with root package name */
    private static final B.c f8320o = new a("subMenuTransition");

    /* renamed from: p, reason: collision with root package name */
    private static final B.c f8321p = new b("mainMenuScaleTransition");

    /* renamed from: q, reason: collision with root package name */
    private static final B.c f8322q = new c("mainMenuAlphaTransition");

    /* renamed from: h, reason: collision with root package name */
    private Z.c f8325h;

    /* renamed from: i, reason: collision with root package name */
    private Z.c f8326i;

    /* renamed from: j, reason: collision with root package name */
    private Z.c f8327j;

    /* renamed from: f, reason: collision with root package name */
    private final b.q f8323f = new b.q() { // from class: com.coui.appcompat.poplist.o
        @Override // Z.b.q
        public final void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
            q.this.C(bVar, z3, f3, f4);
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private final b.q f8324g = new b.q() { // from class: com.coui.appcompat.poplist.p
        @Override // Z.b.q
        public final void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
            q.this.D(bVar, z3, f3, f4);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private float f8328k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    private float f8329l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f8330m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f8331n = 1.0f;

    class a extends B.c {
        a(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(q qVar) {
            return qVar.B();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(q qVar, float f3) {
            qVar.G(f3);
        }
    }

    class b extends B.c {
        b(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(q qVar) {
            return qVar.A();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(q qVar, float f3) {
            qVar.F(f3);
        }
    }

    class c extends B.c {
        c(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(q qVar) {
            return qVar.z();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(q qVar, float f3) {
            qVar.E(f3);
        }
    }

    q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float A() {
        return this.f8328k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float B() {
        return this.f8330m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Z.b bVar, boolean z3, float f3, float f4) {
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
    public /* synthetic */ void D(Z.b bVar, boolean z3, float f3, float f4) {
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
    public void E(float f3) {
        this.f8329l = f3;
        float f4 = f3 / 10000.0f;
        View view = this.f8190c;
        if (view == null) {
            Log.w("PopupMenuAnimCtrl-D", "No main menu root view! Skip animation update");
            return;
        }
        if (view.getVisibility() != 0) {
            this.f8190c.setVisibility(0);
        }
        float i3 = y0.j.i(0.0f, 1.0f, f4);
        this.f8331n = i3;
        this.f8189b.setAlpha(i3);
        View view2 = this.f8190c;
        if ((view2 instanceof RoundFrameLayout) && ((RoundFrameLayout) view2).getUseBackgroundBlur()) {
            this.f8190c.setAlpha(this.f8331n);
        }
        View view3 = this.f8191d;
        if ((view3 instanceof RoundFrameLayout) && ((RoundFrameLayout) view3).getUseBackgroundBlur()) {
            this.f8191d.setAlpha(this.f8331n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(float f3) {
        if (this.f8328k != 0.0f && this.f8329l == 0.0f && this.f8325h.v()) {
            this.f8328k = 0.0f;
        } else {
            this.f8328k = f3;
        }
        float f4 = this.f8328k / 10000.0f;
        View view = this.f8190c;
        if (view == null) {
            Log.w("PopupMenuAnimCtrl-D", "No main menu root view! Skip animation update");
            return;
        }
        if (view.getVisibility() != 0) {
            this.f8190c.setVisibility(0);
        }
        this.f8189b.setScaleX(y0.j.i(0.0f, 1.0f, f4));
        this.f8189b.setScaleY(y0.j.i(0.0f, 1.0f, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f3) {
        this.f8330m = f3;
        float f4 = f3 / 10000.0f;
        View view = this.f8191d;
        if (view != null) {
            if (view.getVisibility() != 0) {
                this.f8191d.setVisibility(0);
            }
            float i3 = y0.j.i(0.0f, 1.0f, f4);
            View view2 = this.f8191d;
            if ((view2 instanceof RoundFrameLayout) && ((RoundFrameLayout) view2).getUseBackgroundBlur()) {
                this.f8191d.setVisibility(i3 <= 0.1f ? 8 : 0);
            }
            this.f8191d.setAlpha(i3 * this.f8331n);
            this.f8191d.setScaleX(y0.j.i(0.0f, 1.0f, f4));
            this.f8191d.setScaleY(y0.j.i(0.0f, 1.0f, f4));
        }
    }

    private void x() {
        if (this.f8325h == null || this.f8326i == null) {
            Z.d dVar = new Z.d();
            dVar.d(0.2f);
            dVar.g(0.35f);
            Z.c cVar = new Z.c(this, f8321p);
            this.f8325h = cVar;
            cVar.B(dVar);
            Z.d dVar2 = new Z.d();
            dVar2.d(0.2f);
            dVar2.g(0.35f);
            Z.c cVar2 = new Z.c(this, f8322q);
            this.f8326i = cVar2;
            cVar2.B(dVar2);
            this.f8326i.a(this.f8323f);
        }
    }

    private void y() {
        if (this.f8327j != null) {
            return;
        }
        Z.d dVar = new Z.d();
        dVar.d(0.0f);
        dVar.g(0.35f);
        Z.c cVar = new Z.c(this, f8320o);
        this.f8327j = cVar;
        cVar.B(dVar);
        this.f8327j.a(this.f8324g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float z() {
        return this.f8329l;
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    void a() {
        View view = this.f8191d;
        if (view instanceof RoundFrameLayout) {
            view.setAlpha(1.0f);
            this.f8191d.setScaleX(1.0f);
            this.f8191d.setScaleY(1.0f);
        }
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void c(View view) {
        this.f8328k = 0.0f;
        this.f8329l = 0.0f;
        super.c(view);
        x();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void f(View view) {
        y();
        if (this.f8327j.h() && this.f8327j.v()) {
            this.f8327j.c();
        }
        super.f(view);
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void h(boolean z3) {
        if (this.f8190c == null) {
            Log.w("PopupMenuAnimCtrl-D", "No main menu root view! Set a main menu view before starting animation!");
            return;
        }
        this.f8189b.setPivotX(this.f8192e.e());
        this.f8189b.setPivotY(this.f8192e.f());
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.h();
        }
        this.f8325h.x().g(0.35f);
        this.f8325h.x().d(0.2f);
        this.f8325h.o(this.f8328k);
        this.f8325h.u(10000.0f);
        if (!z3 && this.f8325h.v()) {
            this.f8325h.C();
        }
        this.f8326i.x().g(0.35f);
        this.f8326i.x().d(0.2f);
        this.f8326i.o(this.f8329l);
        this.f8326i.u(10000.0f);
        if (z3 || !this.f8326i.v()) {
            return;
        }
        this.f8326i.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void j(boolean z3) {
        if (this.f8190c == null) {
            Log.w("PopupMenuAnimCtrl-D", "No main menu root view! Set a main menu view before starting animation!");
            return;
        }
        this.f8189b.setPivotX(this.f8192e.e());
        this.f8189b.setPivotY(this.f8192e.f());
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.i();
        }
        this.f8325h.x().g(0.3f);
        this.f8325h.x().d(0.0f);
        this.f8325h.o(this.f8328k);
        this.f8325h.u(0.0f);
        if (!z3 && this.f8325h.v()) {
            this.f8325h.C();
        }
        this.f8326i.x().g(0.25f);
        this.f8326i.x().d(0.0f);
        this.f8326i.o(this.f8329l);
        this.f8326i.u(0.0f);
        if (z3 || !this.f8326i.v()) {
            return;
        }
        this.f8326i.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void l(boolean z3) {
        if (this.f8190c == null) {
            Log.e("PopupMenuAnimCtrl-D", "No main menu view! Add a main menu view before showing sub menu!");
            return;
        }
        if (this.f8191d == null) {
            Log.w("PopupMenuAnimCtrl-D", "No sub menu root view! Set a sub menu view before starting animation!");
            return;
        }
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.d();
        }
        this.f8191d.setPivotX(this.f8192e.g());
        this.f8191d.setPivotY(this.f8192e.h());
        this.f8327j.o(this.f8330m);
        this.f8327j.u(10000.0f);
        if (z3 || !this.f8327j.v()) {
            return;
        }
        this.f8327j.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void n(boolean z3) {
        if (this.f8190c == null) {
            Log.e("PopupMenuAnimCtrl-D", "No main menu view! Add a main menu view before showing sub menu!");
            return;
        }
        if (this.f8191d == null) {
            Log.w("PopupMenuAnimCtrl-D", "No sub menu root view! Set a sub menu view before starting animation!");
            return;
        }
        AbstractC0300a.InterfaceC0106a interfaceC0106a = this.f8188a;
        if (interfaceC0106a != null) {
            interfaceC0106a.e();
        }
        y();
        this.f8327j.o(this.f8330m);
        this.f8327j.u(0.0f);
        if (z3 || !this.f8327j.v()) {
            return;
        }
        this.f8327j.C();
    }

    @Override // com.coui.appcompat.poplist.AbstractC0300a
    public void o() {
        Z.c cVar = this.f8325h;
        if (cVar != null) {
            cVar.c();
            F(0.0f);
            E(0.0f);
        }
        Z.c cVar2 = this.f8327j;
        if (cVar2 != null) {
            cVar2.c();
            G(0.0f);
        }
    }
}
