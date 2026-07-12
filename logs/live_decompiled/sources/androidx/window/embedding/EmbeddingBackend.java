package androidx.window.embedding;

import C2.l;
import D2.k;
import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface EmbeddingBackend {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f7019a = Companion.f7020a;

    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f7020a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        private static l f7021b = EmbeddingBackend$Companion$decorator$1.f7022e;

        private Companion() {
        }

        public final EmbeddingBackend a(Context context) {
            k.e(context, "context");
            return (EmbeddingBackend) f7021b.f(ExtensionEmbeddingBackend.f7032h.a(context));
        }
    }

    boolean a(Activity activity);

    void b(androidx.core.util.a aVar);

    void c(Activity activity, Executor executor, androidx.core.util.a aVar);
}
