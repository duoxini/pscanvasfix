package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.l;
import androidx.lifecycle.o;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Handler f6773e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Runnable f6774f;

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        if (bVar == AbstractC0272h.b.ON_DESTROY) {
            this.f6773e.removeCallbacks(this.f6774f);
            oVar.getLifecycle().c(this);
        }
    }
}
