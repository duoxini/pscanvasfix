package androidx.window.layout.adapter.sidecar;

import D2.k;
import D2.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
final class SidecarAdapter$translate$checkedFeature$1 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    public static final SidecarAdapter$translate$checkedFeature$1 f7229e = new SidecarAdapter$translate$checkedFeature$1();

    SidecarAdapter$translate$checkedFeature$1() {
        super(1);
    }

    @Override // C2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SidecarDisplayFeature sidecarDisplayFeature) {
        k.e(sidecarDisplayFeature, "$this$require");
        boolean z3 = true;
        if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
            z3 = false;
        }
        return Boolean.valueOf(z3);
    }
}
