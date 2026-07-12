package androidx.window.embedding;

import D2.k;
import java.util.Set;

/* loaded from: classes.dex */
public final class ActivityRule extends EmbeddingRule {

    /* renamed from: b, reason: collision with root package name */
    private final Set f6995b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6996c;

    public static final class Builder {
    }

    @Override // androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule) || !super.equals(obj)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return k.a(this.f6995b, activityRule.f6995b) && this.f6996c == activityRule.f6996c;
    }

    @Override // androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((super.hashCode() * 31) + this.f6995b.hashCode()) * 31) + Boolean.hashCode(this.f6996c);
    }

    public String toString() {
        return "ActivityRule:{tag={" + a() + "},filters={" + this.f6995b + "}, alwaysExpand={" + this.f6996c + "}}";
    }
}
