package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import java.util.Map;

/* loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f5351e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractC0272h f5352f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ l f5353g;

    @Override // androidx.lifecycle.l
    public void a(androidx.lifecycle.o oVar, AbstractC0272h.b bVar) {
        Map map;
        Map map2;
        if (bVar == AbstractC0272h.b.ON_START) {
            map2 = this.f5353g.f5474j;
            if (((Bundle) map2.get(this.f5351e)) != null) {
                throw null;
            }
        }
        if (bVar == AbstractC0272h.b.ON_DESTROY) {
            this.f5352f.c(this);
            map = this.f5353g.f5475k;
            map.remove(this.f5351e);
        }
    }
}
