package androidx.window.layout.adapter.sidecar;

import D2.k;
import D2.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
final class SidecarAdapter$translate$checkedFeature$2 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    public static final SidecarAdapter$translate$checkedFeature$2 f7230e = new SidecarAdapter$translate$checkedFeature$2();

    SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    @Override // C2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SidecarDisplayFeature sidecarDisplayFeature) {
        k.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
