package androidx.window.embedding;

import C2.p;
import D2.k;
import D2.l;
import android.app.Activity;
import android.content.Intent;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class EmbeddingAdapter$VendorApiLevel1Impl$translateActivityIntentPredicates$1 extends l implements p {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Set f7007e;

    @Override // C2.p
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Activity activity, Intent intent) {
        k.e(activity, "first");
        k.e(intent, "second");
        Set set = this.f7007e;
        boolean z3 = false;
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((SplitPairFilter) it.next()).c(activity, intent)) {
                    z3 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z3);
    }
}
