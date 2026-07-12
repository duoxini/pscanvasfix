package androidx.window.embedding;

import D2.g;
import D2.k;

/* loaded from: classes.dex */
public final class EmbeddingAspectRatio {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f7014c = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final EmbeddingAspectRatio f7015d = new EmbeddingAspectRatio("ALWAYS_ALLOW", 0.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final EmbeddingAspectRatio f7016e = new EmbeddingAspectRatio("ALWAYS_DISALLOW", -1.0f);

    /* renamed from: a, reason: collision with root package name */
    private final String f7017a;

    /* renamed from: b, reason: collision with root package name */
    private final float f7018b;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final EmbeddingAspectRatio a(float f3) {
            if (f3 <= 1.0f) {
                throw new IllegalArgumentException("Ratio must be greater than 1.");
            }
            return new EmbeddingAspectRatio("ratio:" + f3, f3, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ EmbeddingAspectRatio(String str, float f3, g gVar) {
        this(str, f3);
    }

    public final float a() {
        return this.f7018b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EmbeddingAspectRatio)) {
            return false;
        }
        EmbeddingAspectRatio embeddingAspectRatio = (EmbeddingAspectRatio) obj;
        return this.f7018b == embeddingAspectRatio.f7018b && k.a(this.f7017a, embeddingAspectRatio.f7017a);
    }

    public int hashCode() {
        return this.f7017a.hashCode() + (Float.hashCode(this.f7018b) * 31);
    }

    public String toString() {
        return "EmbeddingAspectRatio(" + this.f7017a + ')';
    }

    private EmbeddingAspectRatio(String str, float f3) {
        this.f7017a = str;
        this.f7018b = f3;
    }
}
