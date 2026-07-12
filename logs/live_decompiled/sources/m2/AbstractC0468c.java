package m2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.util.LogUtil;
import com.customer.feedback.sdk.widget.ContainerView;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import o2.AbstractC0493a;

/* renamed from: m2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0468c {

    /* renamed from: a, reason: collision with root package name */
    public static int f12433a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f12434b = {111, 112, 112, 111};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f12435c = {67, 79, 76, 79, 82, 79, 83};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f12436d = {111, 110, 101, 112, 108, 117, 115};

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12437e = false;

    /* renamed from: f, reason: collision with root package name */
    public static int f12438f;

    public static Context a(Context context, Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    public static /* synthetic */ WindowInsets b(Activity activity, ContainerView containerView, boolean z3, View view, WindowInsets windowInsets) {
        int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        if (systemWindowInsetBottom <= j(activity)) {
            f12438f = systemWindowInsetBottom;
        }
        boolean z4 = systemWindowInsetBottom - f12438f > 0;
        if (f12437e != z4 && (activity instanceof FeedbackActivity)) {
            ((FeedbackActivity) activity).setWebEvaluateJS("javascript:setWebInputState(" + z4 + ")");
        }
        f12437e = z4;
        if (z4) {
            if (o(activity)) {
                view.setPadding(0, view.getPaddingTop(), 0, 0);
            } else {
                view.setPadding(windowInsets.getSystemWindowInsetLeft(), view.getPaddingTop(), windowInsets.getSystemWindowInsetRight(), 0);
            }
            containerView.setNavigationBarViewHeight(systemWindowInsetBottom);
        } else if (o(activity)) {
            view.setPadding(0, view.getPaddingTop(), 0, 0);
            if (!z3) {
                systemWindowInsetBottom = 0;
            }
            containerView.setNavigationBarViewHeight(systemWindowInsetBottom);
        } else {
            view.setPadding(windowInsets.getSystemWindowInsetLeft(), view.getPaddingTop(), windowInsets.getSystemWindowInsetRight(), 0);
            containerView.setNavigationBarViewHeight(systemWindowInsetBottom);
        }
        return windowInsets;
    }

    public static String c(Context context) {
        if (context == null || TextUtils.isEmpty("com.google.android.documentsui")) {
            return "com.android.documentsui";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.google.android.documentsui", 8192);
            if (applicationInfo == null) {
                return "com.android.documentsui";
            }
            LogUtil.d("FbUtils", "doc package -> " + applicationInfo.packageName);
            return "com.google.android.documentsui";
        } catch (PackageManager.NameNotFoundException e3) {
            LogUtil.e("FbUtils", "getPackageManager failed", e3);
            return "com.android.documentsui";
        }
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String e(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable th) {
            Log.e("FbUtils", "exceptionInfo:" + th);
            return str2;
        }
    }

    public static Locale f() {
        LocaleList localeList = LocaleList.getDefault();
        if (localeList != null && !localeList.isEmpty()) {
            return localeList.get(0);
        }
        LogUtil.e("FbUtils", "getNewLocal  LocaleList is null or empty");
        return Locale.getDefault();
    }

    public static void g(final Activity activity, final ContainerView containerView, final boolean z3) {
        containerView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: m2.b
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return AbstractC0468c.b(activity, containerView, z3, view, windowInsets);
            }
        });
    }

    public static void h(boolean z3, WebView webView) {
        if (webView == null || webView.getSettings() == null) {
            return;
        }
        if (z3) {
            webView.getSettings().setAlgorithmicDarkeningAllowed(true);
        } else {
            webView.getSettings().setAlgorithmicDarkeningAllowed(false);
        }
    }

    public static boolean i(Intent intent, String str) {
        try {
            return intent.getBooleanExtra(str, false);
        } catch (Exception e3) {
            LogUtil.e("FbUtils", " getBooleanFromIntent error " + e3.getMessage());
            return false;
        }
    }

    public static int j(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        float f3 = displayMetrics2.density;
        float f4 = displayMetrics.density;
        if (f3 == f4) {
            return dimensionPixelSize;
        }
        return (int) ((dimensionPixelSize * (f3 / f4)) + 0.5f);
    }

    public static boolean k() {
        String e3 = e("persist.sys.oem.region", "NOTHING");
        String e4 = e(AbstractC0466a.f12428a, "NOTHING");
        if (e4.equals("NOTHING")) {
            e4 = e("persist.sys.oplus.region", "NOTHING");
        }
        boolean equals = "NOTHING".equals(e4);
        boolean equals2 = "NOTHING".equals(e3);
        if (!(equals ^ equals2)) {
            return false;
        }
        if (equals2) {
            if ("CN".equals(e4)) {
                return false;
            }
        } else if ("CN".equals(e3)) {
            return false;
        }
        return true;
    }

    public static int l(Context context) {
        int identifier;
        if (f12433a == 0 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            f12433a = context.getResources().getDimensionPixelSize(identifier);
        }
        return f12433a;
    }

    public static boolean m() {
        int i3 = feedbacka.feedbacki;
        LogUtil.d("FbUtils", " isNightMode ,mode = " + i3);
        if (i3 == 0) {
            return true;
        }
        if (i3 != 1) {
            return AbstractC0493a.d();
        }
        return false;
    }

    public static String n() {
        byte[] bArr = f12434b;
        return new String(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]}, StandardCharsets.UTF_8);
    }

    public static boolean o(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 0) == 2;
    }

    public static String p() {
        byte[] bArr = f12435c;
        return new String(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6]}, StandardCharsets.UTF_8);
    }

    public static String q() {
        byte[] bArr = f12436d;
        return new String(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6]}, StandardCharsets.UTF_8);
    }
}
