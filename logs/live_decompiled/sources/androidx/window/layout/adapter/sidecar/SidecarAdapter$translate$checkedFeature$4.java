package androidx.window.layout.adapter.sidecar;

import D2.k;
import D2.l;
import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
final class SidecarAdapter$translate$checkedFeature$4 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    public static final SidecarAdapter$translate$checkedFeature$4 f7232e = new SidecarAdapter$translate$checkedFeature$4();

    SidecarAdapter$translate$checkedFeature$4() {
        super(1);
    }

    @Override // C2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SidecarDisplayFeature sidecarDisplayFeature) {
        k.e(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
    }
}
