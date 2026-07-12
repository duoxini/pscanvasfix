package com.coui.appcompat.poplist;

import android.view.View;

/* renamed from: com.coui.appcompat.poplist.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0300a {

    /* renamed from: a, reason: collision with root package name */
    InterfaceC0106a f8188a = null;

    /* renamed from: b, reason: collision with root package name */
    View f8189b;

    /* renamed from: c, reason: collision with root package name */
    View f8190c;

    /* renamed from: d, reason: collision with root package name */
    View f8191d;

    /* renamed from: e, reason: collision with root package name */
    v f8192e;

    /* renamed from: com.coui.appcompat.poplist.a$a, reason: collision with other inner class name */
    interface InterfaceC0106a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();
    }

    AbstractC0300a() {
    }

    abstract void a();

    void b(v vVar) {
        this.f8192e = vVar;
    }

    void c(View view) {
        this.f8190c = view;
    }

    void d(View view) {
        this.f8189b = view;
    }

    void e(InterfaceC0106a interfaceC0106a) {
        this.f8188a = interfaceC0106a;
    }

    void f(View view) {
        this.f8191d = view;
    }

    final void g() {
        h(true);
    }

    abstract void h(boolean z3);

    final void i() {
        j(true);
    }

    abstract void j(boolean z3);

    final void k() {
        l(true);
    }

    abstract void l(boolean z3);

    final void m() {
        n(true);
    }

    abstract void n(boolean z3);

    abstract void o();
}
