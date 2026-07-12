package m2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import androidx.window.embedding.ActivityEmbeddingController;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.log.CustomerLogCallback;
import com.customer.feedback.sdk.util.H5Callback;
import com.customer.feedback.sdk.util.HeaderInfoHelper;
import com.customer.feedback.sdk.util.LogUtil;
import com.customer.feedback.sdk.util.UploadListener;
import com.customer.feedback.sdk.widget.ContainerView;
import j2.C0418h;
import j2.RunnableC0417g;
import java.util.ArrayList;
import java.util.Map;
import o2.AbstractC0493a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static UploadListener f12444c;

    /* renamed from: d, reason: collision with root package name */
    public static H5Callback f12445d;

    /* renamed from: e, reason: collision with root package name */
    public static String f12446e;

    /* renamed from: a, reason: collision with root package name */
    public final Activity f12447a;

    /* renamed from: b, reason: collision with root package name */
    public final ContainerView f12448b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.f12447a.onBackPressed();
        }
    }

    public class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f12450e;

        public b(boolean z3) {
            this.f12450e = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((FeedbackActivity) f.this.f12447a).onHomePage(this.f12450e);
        }
    }

    public f(Activity activity, ContainerView containerView) {
        this.f12447a = activity;
        this.f12448b = containerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(FeedbackActivity feedbackActivity, ArrayList arrayList) {
        feedbackActivity.setStatusBarAndNav(AbstractC0468c.m(), arrayList, this.f12448b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str) {
        try {
            Uri parse = Uri.parse("tel:" + str);
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.addFlags(268435456);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(parse);
            this.f12447a.startActivity(intent);
        } catch (Exception e3) {
            LogUtil.e("HeaderInterface", "callDialer error: " + e3.getMessage());
        }
    }

    @JavascriptInterface
    public void callDialer(final String str) {
        if (this.f12447a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f12447a.runOnUiThread(new Runnable() { // from class: m2.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.d(str);
            }
        });
    }

    @JavascriptInterface
    public void dismissLoading() {
        if (this.f12447a != null) {
            LogUtil.d("HeaderInterface", "dismissLoading");
            FeedbackActivity feedbackActivity = (FeedbackActivity) this.f12447a;
            if (feedbackActivity.isLoadFailedState()) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            feedbackActivity.getHandler().sendMessage(obtain);
        }
    }

    @JavascriptInterface
    public void enableStatusBarPadding(boolean z3) {
        LogUtil.d("HeaderInterface", "enableStatusBarPadding: " + z3);
        Activity activity = this.f12447a;
        if (activity instanceof FeedbackActivity) {
            ((FeedbackActivity) activity).enableStatusBarPadding(z3);
        }
    }

    @JavascriptInterface
    public void fbLog(String str) {
        LogUtil.d("HeaderInterface", str);
    }

    @JavascriptInterface
    public void finishActivity() {
        LogUtil.d("HeaderInterface", "finishActivity");
        Activity activity = this.f12447a;
        if (activity != null) {
            activity.finish();
        }
    }

    @JavascriptInterface
    public String getH5NightBg() {
        LogUtil.d("HeaderInterface", "getH5NightBg");
        Context context = feedbacka.feedbackf;
        StringBuilder sb = new StringBuilder();
        float[] fArr = feedbacka.feedbacku;
        sb.append(fArr[0] * 255.0f);
        sb.append(",");
        sb.append(fArr[1] * 255.0f);
        sb.append(",");
        sb.append(fArr[2] * 255.0f);
        return sb.toString();
    }

    @JavascriptInterface
    public String getHeader() {
        LogUtil.d("HeaderInterface", "getHeader");
        Map<String, String> header = HeaderInfoHelper.getHeader(this.f12447a.getApplicationContext());
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (String str : header.keySet()) {
            String str2 = header.get(str);
            if (z3) {
                sb.append(str + "=" + str2);
                z3 = false;
            } else if (str2 != null) {
                sb.append("&" + str + "=" + str2);
            } else {
                sb.append("&" + str + "=");
            }
        }
        return sb.toString();
    }

    @JavascriptInterface
    public boolean getLogReminder() {
        LogUtil.d("HeaderInterface", "getLogReminder");
        return feedbacka.feedbackv;
    }

    @JavascriptInterface
    public int getNavigationBarHeight() {
        LogUtil.d("HeaderInterface", "getNavigationBarHeight");
        return AbstractC0468c.j(this.f12447a);
    }

    @JavascriptInterface
    public int getNavigationBarHeightDp() {
        LogUtil.d("HeaderInterface", "getNavigationBarHeightDp");
        return AbstractC0493a.f(this.f12447a, AbstractC0468c.j(r2));
    }

    @JavascriptInterface
    public String getNetType() {
        LogUtil.d("HeaderInterface", "getNetType");
        return HeaderInfoHelper.getNetType(this.f12447a);
    }

    @JavascriptInterface
    public boolean getNightMode() {
        LogUtil.d("HeaderInterface", "getNightMode");
        return AbstractC0468c.m();
    }

    @JavascriptInterface
    public int getStatusBarHeightDp() {
        int f3 = AbstractC0493a.f(this.f12447a, AbstractC0468c.l(r2));
        LogUtil.d("HeaderInterface", "getStatusBarHeightDp: " + f3);
        return f3;
    }

    @JavascriptInterface
    public String getThemeColor() {
        int i3;
        LogUtil.d("HeaderInterface", "getThemeColor");
        Context context = feedbacka.feedbackf;
        if (!AbstractC0468c.m() || feedbacka.feedbacky == -1) {
            LogUtil.d("FeedbackHelper", "in LightMode, use themeColor: " + feedbacka.feedbackx);
            i3 = feedbacka.feedbackx;
        } else {
            LogUtil.d("FeedbackHelper", "in NightMode, use DarkThemeColor: " + feedbacka.feedbacky);
            i3 = feedbacka.feedbacky;
        }
        int i4 = (16711680 & i3) >> 16;
        int i5 = (65280 & i3) >> 8;
        int i6 = i3 & 255;
        if (i3 == -1) {
            return "0";
        }
        return i4 + "," + i5 + "," + i6;
    }

    @JavascriptInterface
    public String getToken() {
        LogUtil.d("HeaderInterface", "getToken");
        return feedbacka.feedbackr;
    }

    @JavascriptInterface
    public void goNoticePageDirect(boolean z3) {
        LogUtil.d("HeaderInterface", "goNoticePageDirect");
        ((FeedbackActivity) this.f12447a).setGoNoticePageDirect(z3);
    }

    @JavascriptInterface
    public void h5Callback(int i3, String str, String str2) {
        Activity activity;
        LogUtil.d("HeaderInterface", "h5Callback: " + i3);
        if (i3 == 1) {
            LogUtil.d("HeaderInterface", "performH5CallbackForOnlineCodeTokenError, code=" + i3 + ", msg=" + str + ", data=" + str2);
            if (TextUtils.isEmpty(str2) && (activity = this.f12447a) != null) {
                ((FeedbackActivity) activity).waitForToken();
            }
            H5Callback h5Callback = f12445d;
            if (h5Callback != null) {
                h5Callback.callback(i3, str, str2);
                return;
            }
            return;
        }
        if (i3 == 2 || i3 == 3) {
            LogUtil.d("HeaderInterface", "performH5Callback, code=" + i3 + ", msg=" + str + ", data=" + str2);
            H5Callback h5Callback2 = f12445d;
            if (h5Callback2 != null) {
                h5Callback2.callback(i3, str, str2);
                return;
            }
            return;
        }
        if (i3 == 4) {
            LogUtil.d("HeaderInterface", "performH5CallbackForSelfService, code=" + i3 + ", msg=" + str + ", data=" + str2);
            if (feedbacka.feedbackz) {
                H5Callback h5Callback3 = f12445d;
                if (h5Callback3 != null) {
                    h5Callback3.callback(i3, str, str2);
                    return;
                }
                return;
            }
            try {
                toNoticePage((String) new JSONObject(str2).get("link"));
                return;
            } catch (JSONException e3) {
                LogUtil.e("HeaderInterface", "performH5CallbackForSelfService", e3);
                return;
            }
        }
        if (i3 != 5) {
            H5Callback h5Callback4 = f12445d;
            if (h5Callback4 != null) {
                h5Callback4.callback(i3, str, str2);
                return;
            }
            return;
        }
        LogUtil.d("HeaderInterface", "performH5CallbackForOnlineService, code=" + i3 + ", msg=" + str + ", data=" + str2);
        if (feedbacka.f9386a) {
            H5Callback h5Callback5 = f12445d;
            if (h5Callback5 != null) {
                h5Callback5.callback(i3, str, str2);
                return;
            }
            return;
        }
        try {
            toNoticePage((String) new JSONObject(str2).get("link"));
        } catch (JSONException e4) {
            LogUtil.e("HeaderInterface", "performH5CallbackForOnlineService", e4);
        }
    }

    @JavascriptInterface
    public void hideInputMethod() {
        LogUtil.d("HeaderInterface", "hideInputMethod");
        InputMethodManager inputMethodManager = (InputMethodManager) this.f12447a.getSystemService("input_method");
        View currentFocus = this.f12447a.getCurrentFocus();
        if (currentFocus == null || inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    @JavascriptInterface
    public boolean isActivityEmbedded() {
        Activity activity;
        boolean b3 = (!p.a() || (activity = this.f12447a) == null) ? false : ActivityEmbeddingController.a(activity).b(this.f12447a);
        LogUtil.d("HeaderInterface", "isActivityEmbedded: " + b3);
        return b3;
    }

    @JavascriptInterface
    public boolean isGestureNavMode() {
        LogUtil.d("HeaderInterface", "isGestureNavMode");
        return AbstractC0468c.o(this.f12447a);
    }

    @JavascriptInterface
    public boolean isNeedMinusGestureBarHeight() {
        LogUtil.d("HeaderInterface", "isNeedMinusGestureBarHeight");
        return true;
    }

    @JavascriptInterface
    public boolean isTaskBarShowInApp() {
        LogUtil.d("HeaderInterface", "isTaskBarShowInApp");
        return Settings.System.getInt(this.f12447a.getContentResolver(), "enable_launcher_taskbar", 0) == 1;
    }

    @JavascriptInterface
    public void notifyRequestServer(String str) {
        LogUtil.d("HeaderInterface", "notifyRequestServer");
        if (TextUtils.isEmpty(str)) {
            LogUtil.w("HeaderInterface", "json is null");
            return;
        }
        try {
            h.a(new JSONObject(str));
        } catch (JSONException unused) {
            LogUtil.e("HeaderInterface", "json is invalid: " + str);
        }
    }

    @JavascriptInterface
    public void onHomePage(boolean z3) {
        LogUtil.d("HeaderInterface", "onHomePage->" + z3);
        try {
            Activity activity = this.f12447a;
            if (activity instanceof FeedbackActivity) {
                activity.runOnUiThread(new b(z3));
            }
        } catch (Exception e3) {
            LogUtil.e("HeaderInterface", "exceptionInfo：" + e3);
        }
    }

    @JavascriptInterface
    public void onKeyBackPress() {
        LogUtil.d("HeaderInterface", "onKeyBackPress");
        try {
            this.f12447a.runOnUiThread(new a());
        } catch (Exception e3) {
            LogUtil.e("HeaderInterface", "exceptionInfo：" + e3);
        }
    }

    @JavascriptInterface
    public void sendLog(String str) {
        LogUtil.d("HeaderInterface", "sendLog");
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).getString("fid");
            } catch (Exception e3) {
                LogUtil.e("JsonParser", "exceptionInfo：" + e3);
            }
        }
        f12446e = str2;
        if (!TextUtils.isEmpty(str2)) {
            CustomerLogCallback customerLogCallback = feedbacka.feedbackt;
            if (customerLogCallback != null) {
                LogUtil.d("HeaderInterface", "customerLogCallback.startUploadCustomerLog()");
                customerLogCallback.startUploadCustomerLog();
            } else {
                new Thread(new RunnableC0417g(new C0418h(this.f12447a.getApplicationContext()), f12446e)).start();
            }
        }
        if (f12444c != null) {
            LogUtil.d("HeaderInterface", "sendLog , sUploadListener.onUploaded");
            f12444c.onUploaded(true);
        }
        g.c(str);
    }

    @JavascriptInterface
    public void setStatusAndNavColor(String str, String str2, String str3, String str4) {
        LogUtil.d("HeaderInterface", "h5 setStatusAndNavColor: " + str + ", " + str2 + ", " + str3 + ", " + str4);
        int parseColor = Color.parseColor(str);
        int parseColor2 = Color.parseColor(str2);
        int parseColor3 = Color.parseColor(str3);
        int parseColor4 = Color.parseColor(str4);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(parseColor));
        arrayList.add(Integer.valueOf(parseColor2));
        arrayList.add(Integer.valueOf(parseColor3));
        arrayList.add(Integer.valueOf(parseColor4));
        Activity activity = this.f12447a;
        if (activity == null) {
            LogUtil.e("HeaderInterface", "setStatusAndNavColor mActivity is null");
        } else {
            final FeedbackActivity feedbackActivity = (FeedbackActivity) activity;
            feedbackActivity.runOnUiThread(new Runnable() { // from class: m2.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.c(feedbackActivity, arrayList);
                }
            });
        }
    }

    @JavascriptInterface
    public void showInputMethod() {
        LogUtil.d("HeaderInterface", "showInputMethod");
        InputMethodManager inputMethodManager = (InputMethodManager) this.f12447a.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f12447a.getCurrentFocus(), 0);
        }
    }

    @JavascriptInterface
    public void showLoading() {
        if (this.f12447a != null) {
            LogUtil.d("HeaderInterface", "showLoading");
            FeedbackActivity feedbackActivity = (FeedbackActivity) this.f12447a;
            Message obtain = Message.obtain();
            obtain.what = 0;
            feedbackActivity.getHandler().sendMessage(obtain);
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        LogUtil.d("HeaderInterface", " showToast " + str);
        o.a(this.f12447a.getApplicationContext(), str);
    }

    @JavascriptInterface
    @SuppressLint({"UnsafeImplicitIntentLaunch"})
    public void toNoticePage(String str) {
        LogUtil.d("HeaderInterface", "toNoticePage -> " + str);
        Activity activity = this.f12447a;
        if (activity != null) {
            FeedbackActivity feedbackActivity = (FeedbackActivity) activity;
            if (!TextUtils.isEmpty(str) && (str.startsWith("https") || str.startsWith("http") || str.startsWith("file://"))) {
                feedbackActivity.jumpToNoticePage(str);
                return;
            }
            try {
                feedbackActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e3) {
                LogUtil.e("HeaderInterface", "toNoticePage :" + e3);
            }
        }
    }
}
