package androidx.window.embedding;

import D2.g;
import D2.k;
import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
public final class ActivityEmbeddingController {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f6991b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final EmbeddingBackend f6992a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ActivityEmbeddingController a(Context context) {
            k.e(context, "context");
            return new ActivityEmbeddingController(EmbeddingBackend.f7019a.a(context));
        }

        private Companion() {
        }
    }

    public ActivityEmbeddingController(EmbeddingBackend embeddingBackend) {
        k.e(embeddingBackend, "backend");
        this.f6992a = embeddingBackend;
    }

    public static final ActivityEmbeddingController a(Context context) {
        return f6991b.a(context);
    }

    public final boolean b(Activity activity) {
        k.e(activity, "activity");
        return this.f6992a.a(activity);
    }
}
