package androidx.window.embedding;

import D2.k;
import D2.l;
import android.content.Context;
import android.view.WindowMetrics;

/* loaded from: classes.dex */
final class EmbeddingAdapter$VendorApiLevel1Impl$translateParentMetricsPredicate$1 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SplitRule f7011e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f7012f;

    @Override // C2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean f(WindowMetrics windowMetrics) {
        k.e(windowMetrics, "windowMetrics");
        return Boolean.valueOf(this.f7011e.c(this.f7012f, windowMetrics));
    }
}
