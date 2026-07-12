package com.coui.appcompat.viewpager.adapter;

import android.os.Handler;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.l;
import androidx.lifecycle.o;

/* loaded from: classes.dex */
class COUIFragmentStateAdapter$5 implements l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Handler f9313e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Runnable f9314f;

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        if (bVar == AbstractC0272h.b.ON_DESTROY) {
            this.f9313e.removeCallbacks(this.f9314f);
            oVar.getLifecycle().c(this);
        }
    }
}
