package androidx.window.embedding;

import D2.k;
import android.content.Intent;
import androidx.window.embedding.SplitRule;
import java.util.Set;

/* loaded from: classes.dex */
public final class SplitPlaceholderRule extends SplitRule {

    /* renamed from: k, reason: collision with root package name */
    private final Set f7116k;

    /* renamed from: l, reason: collision with root package name */
    private final Intent f7117l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f7118m;

    /* renamed from: n, reason: collision with root package name */
    private final SplitRule.FinishBehavior f7119n;

    public static final class Builder {
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return k.a(this.f7117l, splitPlaceholderRule.f7117l) && this.f7118m == splitPlaceholderRule.f7118m && k.a(this.f7119n, splitPlaceholderRule.f7119n) && k.a(this.f7116k, splitPlaceholderRule.f7116k);
    }

    @Override // androidx.window.embedding.SplitRule, androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f7117l.hashCode()) * 31) + Boolean.hashCode(this.f7118m)) * 31) + this.f7119n.hashCode()) * 31) + this.f7116k.hashCode();
    }

    @Override // androidx.window.embedding.SplitRule
    public String toString() {
        return "SplitPlaceholderRule{tag=" + a() + ", defaultSplitAttributes=" + e() + ", minWidthDp=" + j() + ", minHeightDp=" + h() + ", minSmallestWidthDp=" + i() + ", maxAspectRatioInPortrait=" + g() + ", maxAspectRatioInLandscape=" + f() + ", placeholderIntent=" + this.f7117l + ", isSticky=" + this.f7118m + ", finishPrimaryWithPlaceholder=" + this.f7119n + ", filters=" + this.f7116k + '}';
    }
}
