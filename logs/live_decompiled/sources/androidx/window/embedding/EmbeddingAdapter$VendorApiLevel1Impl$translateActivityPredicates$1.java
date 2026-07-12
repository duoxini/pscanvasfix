package androidx.window.embedding;

import D2.k;
import D2.l;
import android.app.Activity;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class EmbeddingAdapter$VendorApiLevel1Impl$translateActivityPredicates$1 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Set f7009e;

    @Override // C2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean f(Activity activity) {
        k.e(activity, "activity");
        Set set = this.f7009e;
        boolean z3 = false;
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((ActivityFilter) it.next()).a(activity)) {
                    z3 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z3);
    }
}
