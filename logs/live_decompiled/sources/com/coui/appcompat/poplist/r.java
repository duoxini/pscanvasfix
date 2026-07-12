package com.coui.appcompat.poplist;

import android.content.Context;
import r0.C0559a;

/* loaded from: classes.dex */
public class r extends C0559a {

    /* renamed from: t, reason: collision with root package name */
    public r f8332t;

    /* renamed from: u, reason: collision with root package name */
    public r f8333u;

    public r(Context context, int i3, r rVar) {
        super(context, i3);
        this.f8332t = null;
        this.f8333u = null;
        if (rVar == null) {
            this.f8332t = new r(context, i3, this);
        } else {
            this.f8333u = rVar;
        }
        B(false);
        y(false);
    }

    private void G() {
        super.f();
    }

    private void H() {
        super.e();
    }

    public r F() {
        return this.f8332t;
    }

    @Override // r0.j, r0.InterfaceC0564f
    public void e() {
        r rVar = this.f8332t;
        if (rVar != null) {
            rVar.H();
        }
        r rVar2 = this.f8333u;
        if (rVar2 != null) {
            rVar2.H();
        }
        H();
    }

    @Override // r0.j, r0.InterfaceC0564f
    public void f() {
        r rVar = this.f8332t;
        if (rVar != null) {
            rVar.G();
        }
        r rVar2 = this.f8333u;
        if (rVar2 != null) {
            rVar2.G();
        }
        G();
    }
}
