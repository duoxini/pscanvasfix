package androidx.window.embedding;

import D2.l;
import android.content.Context;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.embedding.SplitController;

/* loaded from: classes.dex */
final class ExtensionEmbeddingBackend$splitSupportStatus$2 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ExtensionEmbeddingBackend f7050e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExtensionEmbeddingBackend$splitSupportStatus$2(ExtensionEmbeddingBackend extensionEmbeddingBackend) {
        super(0);
        this.f7050e = extensionEmbeddingBackend;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SplitController.SplitSupportStatus invoke() {
        boolean i3;
        Context context;
        i3 = this.f7050e.i();
        if (!i3) {
            return SplitController.SplitSupportStatus.f7096d;
        }
        ExtensionEmbeddingBackend.Api31Impl api31Impl = ExtensionEmbeddingBackend.Api31Impl.f7041a;
        context = this.f7050e.f7035b;
        return api31Impl.a(context);
    }
}
