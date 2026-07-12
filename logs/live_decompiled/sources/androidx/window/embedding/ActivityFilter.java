package androidx.window.embedding;

import D2.k;
import android.app.Activity;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public final class ActivityFilter {

    /* renamed from: a, reason: collision with root package name */
    private final ActivityComponentInfo f6993a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6994b;

    public final boolean a(Activity activity) {
        k.e(activity, "activity");
        if (MatcherUtils.f7051a.b(activity, this.f6993a)) {
            String str = this.f6994b;
            if (str != null) {
                Intent intent = activity.getIntent();
                if (k.a(str, intent != null ? intent.getAction() : null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean b(Intent intent) {
        k.e(intent, Constants.MessagerConstants.INTENT_KEY);
        if (!MatcherUtils.f7051a.c(intent, this.f6993a)) {
            return false;
        }
        String str = this.f6994b;
        return str == null || k.a(str, intent.getAction());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return k.a(this.f6993a, activityFilter.f6993a) && k.a(this.f6994b, activityFilter.f6994b);
    }

    public int hashCode() {
        int hashCode = this.f6993a.hashCode() * 31;
        String str = this.f6994b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.f6993a + ", intentAction=" + this.f6994b + ')';
    }
}
