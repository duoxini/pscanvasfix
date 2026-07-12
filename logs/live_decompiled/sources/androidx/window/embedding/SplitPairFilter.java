package androidx.window.embedding;

import D2.k;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;

/* loaded from: classes.dex */
public final class SplitPairFilter {

    /* renamed from: a, reason: collision with root package name */
    private final ActivityComponentInfo f7109a;

    /* renamed from: b, reason: collision with root package name */
    private final ActivityComponentInfo f7110b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7111c;

    public final ComponentName a() {
        return new ComponentName(this.f7109a.b(), this.f7109a.a());
    }

    public final ComponentName b() {
        return new ComponentName(this.f7110b.b(), this.f7110b.a());
    }

    public final boolean c(Activity activity, Intent intent) {
        k.e(activity, "primaryActivity");
        k.e(intent, "secondaryActivityIntent");
        MatcherUtils matcherUtils = MatcherUtils.f7051a;
        if (!matcherUtils.b(activity, this.f7109a) || !matcherUtils.c(intent, this.f7110b)) {
            return false;
        }
        String str = this.f7111c;
        return str == null || k.a(str, intent.getAction());
    }

    public final boolean d(Activity activity, Activity activity2) {
        k.e(activity, "primaryActivity");
        k.e(activity2, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.f7051a;
        if (!matcherUtils.b(activity, this.f7109a) || !matcherUtils.b(activity2, this.f7110b)) {
            return false;
        }
        String str = this.f7111c;
        if (str != null) {
            Intent intent = activity2.getIntent();
            if (!k.a(str, intent != null ? intent.getAction() : null)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(SplitPairFilter.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type androidx.window.embedding.SplitPairFilter");
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return k.a(this.f7109a, splitPairFilter.f7109a) && k.a(this.f7110b, splitPairFilter.f7110b) && k.a(this.f7111c, splitPairFilter.f7111c);
    }

    public int hashCode() {
        int hashCode = ((this.f7109a.hashCode() * 31) + this.f7110b.hashCode()) * 31;
        String str = this.f7111c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + a() + ", secondaryActivityName=" + b() + ", secondaryActivityAction=" + this.f7111c + '}';
    }
}
