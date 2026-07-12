package androidx.window.embedding;

import D2.k;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public final class MatcherUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final MatcherUtils f7051a = new MatcherUtils();

    private MatcherUtils() {
    }

    private final boolean d(String str, String str2) {
        if (!K2.e.w(str2, "*", false, 2, null)) {
            return false;
        }
        if (k.a(str2, "*")) {
            return true;
        }
        if (K2.e.F(str2, "*", 0, false, 6, null) != K2.e.K(str2, "*", 0, false, 6, null) || !K2.e.k(str2, "*", false, 2, null)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String substring = str2.substring(0, str2.length() - 1);
        k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return K2.e.t(str, substring, false, 2, null);
    }

    public final boolean a(ActivityComponentInfo activityComponentInfo, ActivityComponentInfo activityComponentInfo2) {
        k.e(activityComponentInfo2, "ruleComponent");
        if (activityComponentInfo == null) {
            return k.a(activityComponentInfo2.b(), "*") && k.a(activityComponentInfo2.a(), "*");
        }
        if (K2.e.w(activityComponentInfo.toString(), "*", false, 2, null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        return (k.a(activityComponentInfo.b(), activityComponentInfo2.b()) || d(activityComponentInfo.b(), activityComponentInfo2.b())) && (k.a(activityComponentInfo.a(), activityComponentInfo2.a()) || d(activityComponentInfo.a(), activityComponentInfo2.a()));
    }

    public final boolean b(Activity activity, ActivityComponentInfo activityComponentInfo) {
        k.e(activity, "activity");
        k.e(activityComponentInfo, "ruleComponent");
        ComponentName componentName = activity.getComponentName();
        k.d(componentName, "activity.componentName");
        if (a(new ActivityComponentInfo(componentName), activityComponentInfo)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            return f7051a.c(intent, activityComponentInfo);
        }
        return false;
    }

    public final boolean c(Intent intent, ActivityComponentInfo activityComponentInfo) {
        String str;
        k.e(intent, Constants.MessagerConstants.INTENT_KEY);
        k.e(activityComponentInfo, "ruleComponent");
        ComponentName component = intent.getComponent();
        if (a(component != null ? new ActivityComponentInfo(component) : null, activityComponentInfo)) {
            return true;
        }
        if (intent.getComponent() == null && (str = intent.getPackage()) != null) {
            return (k.a(str, activityComponentInfo.b()) || d(str, activityComponentInfo.b())) && k.a(activityComponentInfo.a(), "*");
        }
        return false;
    }
}
