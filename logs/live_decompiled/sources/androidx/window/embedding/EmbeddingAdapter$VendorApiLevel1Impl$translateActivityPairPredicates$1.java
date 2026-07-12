package androidx.window.embedding;

import C2.p;
import D2.k;
import D2.l;
import android.app.Activity;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class EmbeddingAdapter$VendorApiLevel1Impl$translateActivityPairPredicates$1 extends l implements p {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Set f7008e;

    @Override // C2.p
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Activity activity, Activity activity2) {
        k.e(activity, "first");
        k.e(activity2, "second");
        Set set = this.f7008e;
        boolean z3 = false;
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((SplitPairFilter) it.next()).d(activity, activity2)) {
                    z3 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z3);
    }
}
