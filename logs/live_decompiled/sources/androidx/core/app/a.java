package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class a extends androidx.core.content.a {

    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    static class C0061a {
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        static void b(Activity activity, Intent intent, int i3, Bundle bundle) {
            activity.startActivityForResult(intent, i3, bundle);
        }

        static void c(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
            activity.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
        }
    }

    static class b {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class c {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i3) {
            activity.requestPermissions(strArr, i3);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface d {
        void validateRequestPermissionsRequestCode(int i3);
    }

    public static void j(Activity activity) {
        C0061a.a(activity);
    }

    public static void k(Activity activity) {
        b.a(activity);
    }

    public static void l(Activity activity) {
        b.b(activity);
    }

    public static void m(Activity activity) {
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n(Activity activity, String[] strArr, int i3) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (TextUtils.isEmpty(strArr[i4])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (!androidx.core.os.a.b() && TextUtils.equals(strArr[i4], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i4));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (!hashSet.contains(Integer.valueOf(i6))) {
                    strArr2[i5] = strArr[i6];
                    i5++;
                }
            }
        }
        if (activity instanceof d) {
            ((d) activity).validateRequestPermissionsRequestCode(i3);
        }
        c.b(activity, strArr, i3);
    }

    public static void o(Activity activity, h hVar) {
        b.c(activity, null);
    }

    public static void p(Activity activity, h hVar) {
        b.d(activity, null);
    }

    public static boolean q(Activity activity, String str) {
        if (androidx.core.os.a.b() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return c.c(activity, str);
        }
        return false;
    }

    public static void r(Activity activity, Intent intent, int i3, Bundle bundle) {
        C0061a.b(activity, intent, i3, bundle);
    }

    public static void s(Activity activity, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        C0061a.c(activity, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public static void t(Activity activity) {
        b.e(activity);
    }
}
