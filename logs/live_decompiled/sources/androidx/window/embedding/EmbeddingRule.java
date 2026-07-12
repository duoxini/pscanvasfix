package androidx.window.embedding;

import D2.k;

/* loaded from: classes.dex */
public abstract class EmbeddingRule {

    /* renamed from: a, reason: collision with root package name */
    private final String f7031a;

    public final String a() {
        return this.f7031a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmbeddingRule) {
            return k.a(this.f7031a, ((EmbeddingRule) obj).f7031a);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f7031a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
