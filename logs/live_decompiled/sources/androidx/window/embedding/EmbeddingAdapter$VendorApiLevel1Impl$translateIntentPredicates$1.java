package androidx.window.embedding;

import D2.k;
import D2.l;
import android.content.Intent;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class EmbeddingAdapter$VendorApiLevel1Impl$translateIntentPredicates$1 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Set f7010e;

    @Override // C2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean f(Intent intent) {
        k.e(intent, Constants.MessagerConstants.INTENT_KEY);
        Set set = this.f7010e;
        boolean z3 = false;
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((ActivityFilter) it.next()).b(intent)) {
                    z3 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z3);
    }
}
