package androidx.window.embedding;

import D2.k;
import D2.l;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import java.util.ArrayList;
import java.util.List;
import p2.q;

/* loaded from: classes.dex */
final class EmbeddingCompat$setEmbeddingCallback$1 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ EmbeddingInterfaceCompat.EmbeddingCallbackInterface f7029e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ EmbeddingCompat f7030f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmbeddingCompat$setEmbeddingCallback$1(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface, EmbeddingCompat embeddingCompat) {
        super(1);
        this.f7029e = embeddingCallbackInterface;
        this.f7030f = embeddingCompat;
    }

    public final void a(List list) {
        EmbeddingAdapter embeddingAdapter;
        k.e(list, "values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof androidx.window.extensions.embedding.SplitInfo) {
                arrayList.add(obj);
            }
        }
        EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface = this.f7029e;
        embeddingAdapter = this.f7030f.f7026b;
        embeddingCallbackInterface.a(embeddingAdapter.d(arrayList));
    }

    @Override // C2.l
    public /* bridge */ /* synthetic */ Object f(Object obj) {
        a((List) obj);
        return q.f12810a;
    }
}
