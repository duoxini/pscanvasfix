package androidx.window.embedding;

import D2.k;
import androidx.window.embedding.SplitRule;
import java.util.Set;

/* loaded from: classes.dex */
public final class SplitPairRule extends SplitRule {

    /* renamed from: k, reason: collision with root package name */
    private final Set f7112k;

    /* renamed from: l, reason: collision with root package name */
    private final SplitRule.FinishBehavior f7113l;

    /* renamed from: m, reason: collision with root package name */
    private final SplitRule.FinishBehavior f7114m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f7115n;

    public static final class Builder {
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return k.a(this.f7112k, splitPairRule.f7112k) && k.a(this.f7113l, splitPairRule.f7113l) && k.a(this.f7114m, splitPairRule.f7114m) && this.f7115n == splitPairRule.f7115n;
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f7112k.hashCode()) * 31) + this.f7113l.hashCode()) * 31) + this.f7114m.hashCode()) * 31) + Boolean.hashCode(this.f7115n);
    }

    @Override // androidx.window.embedding.SplitRule
    public String toString() {
        return SplitPairRule.class.getSimpleName() + "{tag=" + a() + ", defaultSplitAttributes=" + e() + ", minWidthDp=" + j() + ", minHeightDp=" + h() + ", minSmallestWidthDp=" + i() + ", maxAspectRatioInPortrait=" + g() + ", maxAspectRatioInLandscape=" + f() + ", clearTop=" + this.f7115n + ", finishPrimaryWithSecondary=" + this.f7113l + ", finishSecondaryWithPrimary=" + this.f7114m + ", filters=" + this.f7112k + '}';
    }
}
