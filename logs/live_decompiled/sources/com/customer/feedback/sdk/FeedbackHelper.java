package com.customer.feedback.sdk;

import D2.g;
import D2.k;
import W.a;
import android.app.Activity;
import android.content.Context;
import com.customer.feedback.sdk.FeedbackHelper;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.model.RequestData;
import com.customer.feedback.sdk.util.H5Callback;
import com.customer.feedback.sdk.util.LogUtil;
import com.oplus.backup.sdk.common.utils.Constants;
import i2.AbstractC0398b;
import i2.RunnableC0397a;
import j2.AbstractC0412b;
import j2.C0418h;
import java.lang.ref.SoftReference;
import java.util.List;
import k2.AbstractC0444a;
import m2.f;
import m2.l;
import m2.n;
import p2.q;

/* loaded from: classes.dex */
public final class FeedbackHelper {
    public static final int CODE_ONLINE_SERVICE = 5;
    public static final int CODE_READ_MESSAGE = 3;
    public static final int CODE_SELF_SERVICE = 4;
    public static final Companion Companion = new Companion(null);
    public static final int ONLINE_CODE_CHANNELID_ERROR = 2;
    public static final int ONLINE_CODE_SUCCESS = 0;
    public static final int ONLINE_CODE_TOKEN_ERROR = 1;
    private static final String TAG = "FeedbackHelper";
    private static FeedbackHelper instance;
    private final Context context;
    private feedbacka feedbackApi;

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void getUnreadCount$lambda$4$lambda$3(DataCallBack dataCallBack, boolean z3, String str, Integer num) {
            if (dataCallBack != null) {
                dataCallBack.onResult(z3, str, Integer.valueOf(num == null ? 0 : num.intValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setCustomerLogCallback$lambda$1(CustomerLogCallback customerLogCallback) {
            if (customerLogCallback != null) {
                customerLogCallback.startUploadCustomerLog();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setH5Callback$lambda$2(H5Callback h5Callback, int i3, String str, String str2) {
            if (h5Callback != null) {
                h5Callback.callback(i3, str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUploadListener$lambda$0(UploadListener uploadListener, boolean z3) {
            if (uploadListener != null) {
                uploadListener.onUploaded(z3);
            }
        }

        public final void clearExtraData() {
            feedbacka.f9389d.clear();
        }

        public final void clearPrivacyBehaviorAgree(Context context) {
            Context context2 = feedbacka.feedbackf;
            if (context == null) {
                return;
            }
            LogUtil.d(FeedbackHelper.TAG, "clearPrivacyBehaviorAgree: " + context.getPackageName());
            l.a(context, "key_privacy_behavior_agree");
        }

        public final int getDarkBackgroundColor() {
            return feedbacka.feedbackb();
        }

        public final String getFeedbackVersion() {
            Context context = feedbacka.feedbackf;
            k.d("16.1.4", "getFeedbackVersion()");
            return "16.1.4";
        }

        public final String getId() {
            String str = feedbacka.feedbackq;
            return str == null ? "" : str;
        }

        public final synchronized FeedbackHelper getInstance(Context context) {
            if (FeedbackHelper.instance == null) {
                return new FeedbackHelper(context);
            }
            return FeedbackHelper.instance;
        }

        public final void getUnreadCount(Context context, final DataCallBack<Integer> dataCallBack) {
            q qVar;
            if (context != null) {
                feedbacka.feedbackb feedbackbVar = new feedbacka.feedbackb() { // from class: C0.g
                    @Override // com.customer.feedback.sdk.feedbacka.feedbackb
                    public final void onResult(boolean z3, String str, Object obj) {
                        FeedbackHelper.Companion.getUnreadCount$lambda$4$lambda$3(FeedbackHelper.DataCallBack.this, z3, str, (Integer) obj);
                    }
                };
                Context context2 = feedbacka.feedbackf;
                n.f12458a.execute(new feedbackb(context, feedbackbVar));
                qVar = q.f12810a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                LogUtil.e(FeedbackHelper.TAG, "[getUnreadCount] context must not be null");
            }
        }

        public final void setAccountToken(String str) {
            feedbacka.feedbackr = str;
            feedbacka.feedbacke feedbackeVar = feedbacka.f9392g;
            if (feedbackeVar != null) {
                ((FeedbackActivity.feedbacki) feedbackeVar).feedbacka(str);
            }
        }

        public final void setAppFlag(String str) {
            k.e(str, "flag");
            feedbacka.feedbackp = str;
        }

        public final void setAppName(String str) {
            k.e(str, "appName");
            feedbacka.f9387b = str;
        }

        public final void setAppNameResId(int i3) {
            feedbacka.feedbacko = i3;
        }

        public final void setAppVersion(String str) {
            k.e(str, "appVersion");
            feedbacka.feedbackk = str;
        }

        public final void setCVersion(String str) {
            k.e(str, "cVersion");
            Context context = feedbacka.feedbackf;
            AbstractC0398b.f12127a = str;
        }

        public final void setCheckPrivacyBehaviorAgreeInExp(boolean z3) {
            feedbacka.feedbackn = z3;
        }

        public final void setCredentialProtectedStorageContext(Context context) {
            feedbacka.feedbacks = context;
        }

        public final void setCustomerLogCallback(final CustomerLogCallback customerLogCallback) {
            feedbacka.feedbackt = new com.customer.feedback.sdk.log.CustomerLogCallback() { // from class: C0.e
                @Override // com.customer.feedback.sdk.log.CustomerLogCallback
                public final void startUploadCustomerLog() {
                    FeedbackHelper.Companion.setCustomerLogCallback$lambda$1(FeedbackHelper.CustomerLogCallback.this);
                }
            };
        }

        public final void setCustomerLogPathAndUpload(String str) {
            k.e(str, Constants.MessagerConstants.PATH_KEY);
            Context context = feedbacka.feedbackf;
            if (str == null || str.equals("")) {
                return;
            }
            new Thread(new RunnableC0397a(new C0418h(feedbacka.feedbackf), str)).start();
        }

        public final void setDarkBackgroundColor(float f3, float f4, float f5) {
            float[] fArr = feedbacka.feedbacku;
            fArr[0] = f3;
            fArr[1] = f4;
            fArr[2] = f5;
        }

        public final void setDarkThemeColor(int i3) {
            feedbacka.feedbacky = i3;
        }

        public final void setDataSavedCountry(int i3) {
            Context context = feedbacka.feedbackf;
            a.d(i3);
            String str = AbstractC0444a.f12287a;
            AbstractC0444a.f12287a = a.a();
            AbstractC0444a.f12288b = a.b();
        }

        public final void setEnv(int i3) {
            a.c(i3);
            Context context = feedbacka.feedbackf;
            String str = AbstractC0444a.f12287a;
            AbstractC0444a.f12287a = a.a();
            AbstractC0444a.f12288b = a.b();
        }

        public final void setExtraData(String str, String str2) {
            if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
                return;
            }
            feedbacka.f9389d.put(str, str2);
        }

        public final void setH5Callback(final H5Callback h5Callback) {
            H5Callback h5Callback2 = new H5Callback() { // from class: C0.h
                @Override // com.customer.feedback.sdk.util.H5Callback
                public final void callback(int i3, String str, String str2) {
                    FeedbackHelper.Companion.setH5Callback$lambda$2(H5Callback.this, i3, str, str2);
                }
            };
            Context context = feedbacka.feedbackf;
            f.f12445d = h5Callback2;
        }

        public final void setIPCollection(boolean z3) {
            Context context = feedbacka.feedbackf;
        }

        public final void setId(String str) {
            feedbacka.feedbackq = str;
        }

        public final void setInterceptOnlineService(boolean z3) {
            feedbacka.f9386a = z3;
        }

        public final void setInterceptSelfService(boolean z3) {
            feedbacka.feedbackz = z3;
        }

        @Deprecated
        public final void setIsNeedJumpCenterPage(boolean z3) {
            Context context = feedbacka.feedbackf;
        }

        public final void setLogDebugging(boolean z3) {
            LogUtil.setIsDebugMode(z3);
        }

        public final void setLogReminder(boolean z3) {
            feedbacka.feedbackv = z3;
        }

        public final void setNetworkUserAgree(boolean z3) {
            feedbacka.feedbackl = z3;
        }

        public final void setRequestMadeListener(RequestMadeCallback requestMadeCallback) {
            feedbacka.f9391f = requestMadeCallback;
        }

        public final void setSupportLogKit(boolean z3) {
            Context context = feedbacka.feedbackf;
            LogUtil.d(FeedbackHelper.TAG, "setSupportLogKit = " + z3);
            feedbacka.f9388c = z3;
        }

        public final void setTestUrl(String str) {
            k.e(str, "url");
            Context context = feedbacka.feedbackf;
        }

        public final void setThemeColor(int i3) {
            feedbacka.feedbackx = i3;
        }

        public final void setThirdWebDomStorageEnabled(boolean z3) {
            feedbacka.feedbackw = z3;
        }

        public final void setUiMode(int i3) {
            feedbacka.feedbacki = i3;
        }

        public final void setUploadListener(final UploadListener uploadListener) {
            com.customer.feedback.sdk.util.UploadListener uploadListener2 = new com.customer.feedback.sdk.util.UploadListener() { // from class: C0.f
                @Override // com.customer.feedback.sdk.util.UploadListener
                public final void onUploaded(boolean z3) {
                    FeedbackHelper.Companion.setUploadListener$lambda$0(FeedbackHelper.UploadListener.this, z3);
                }
            };
            Context context = feedbacka.feedbackf;
            LogUtil.d("HeaderInterface", "setUploadListener");
            f.f12444c = uploadListener2;
        }

        public final void setUserAccountID(String str) {
            k.e(str, "id");
            feedbacka.feedbackh = str;
        }

        public final void setUserAccountName(String str) {
            k.e(str, "userAccountName");
            feedbacka.feedbackg = str;
        }

        public final void setUserPrivacyBehaviorAgree(boolean z3, boolean z4) {
            feedbacka.feedbackl = z3;
            feedbacka.feedbackm = z4;
        }

        public final void setWebViewDebugMode(boolean z3) {
            feedbacka.f9390e = z3;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public interface CustomerLogCallback {
        void startUploadCustomerLog();
    }

    public interface DataCallBack<T> {
        void onResult(boolean z3, String str, T t3);
    }

    public static final class ENV {
        public static final int DEV = 2;
        public static final ENV INSTANCE = new ENV();
        public static final int RELEASE = 0;
        public static final int TEST = 1;

        private ENV() {
        }
    }

    public static final class FBuiMode {
        public static final int AUTO = 2;
        public static final int DARK = 0;
        public static final FBuiMode INSTANCE = new FBuiMode();
        public static final int LIGHT = 1;

        private FBuiMode() {
        }
    }

    public static final class FbAreaCode {
        public static final int CN = 0;
        public static final int IN = 1;
        public static final FbAreaCode INSTANCE = new FbAreaCode();
        public static final int RU = 4;
        public static final int SG = 3;
        public static final int VN = 2;

        private FbAreaCode() {
        }
    }

    public interface ImageAccessAgreeStatusListener {
        void returnImageAccessAgreeStatus(boolean z3);
    }

    public interface NetworkStatusListener {
        void returnNetworkStatus(boolean z3);
    }

    public interface RequestMadeCallback {
        void onRequestMade(List<? extends RequestData> list);
    }

    public interface UploadListener {
        void onUploaded(boolean z3);
    }

    public static final class WebViewManager {
        public static final WebViewManager INSTANCE = new WebViewManager();

        private WebViewManager() {
        }

        public static <T> void setProxyClass(Class<T> cls) {
            k.e(cls, "clazz");
            FeedbackThirdWebManager.getInstance().setTargetClass(cls);
        }
    }

    public FeedbackHelper(Context context) {
        this.context = context;
        this.feedbackApi = feedbacka.feedbackb(context);
    }

    public static final void clearExtraData() {
        Companion.clearExtraData();
    }

    public static final void clearPrivacyBehaviorAgree(Context context) {
        Companion.clearPrivacyBehaviorAgree(context);
    }

    public static final int getDarkBackgroundColor() {
        return Companion.getDarkBackgroundColor();
    }

    public static final String getFeedbackVersion() {
        return Companion.getFeedbackVersion();
    }

    public static final String getId() {
        return Companion.getId();
    }

    public static final synchronized FeedbackHelper getInstance(Context context) {
        FeedbackHelper companion;
        synchronized (FeedbackHelper.class) {
            companion = Companion.getInstance(context);
        }
        return companion;
    }

    public static final void getUnreadCount(Context context, DataCallBack<Integer> dataCallBack) {
        Companion.getUnreadCount(context, dataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openFeedBackUpLog$lambda$5$lambda$4(UploadListener uploadListener, boolean z3) {
        if (uploadListener != null) {
            uploadListener.onUploaded(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openFeedBackUpLogWithCode$lambda$8$lambda$7(UploadListener uploadListener, boolean z3) {
        if (uploadListener != null) {
            uploadListener.onUploaded(z3);
        }
    }

    public static final void setAccountToken(String str) {
        Companion.setAccountToken(str);
    }

    public static final void setAppFlag(String str) {
        Companion.setAppFlag(str);
    }

    public static final void setAppName(String str) {
        Companion.setAppName(str);
    }

    public static final void setAppNameResId(int i3) {
        Companion.setAppNameResId(i3);
    }

    public static final void setAppVersion(String str) {
        Companion.setAppVersion(str);
    }

    public static final void setCVersion(String str) {
        Companion.setCVersion(str);
    }

    public static final void setCheckPrivacyBehaviorAgreeInExp(boolean z3) {
        Companion.setCheckPrivacyBehaviorAgreeInExp(z3);
    }

    public static final void setCredentialProtectedStorageContext(Context context) {
        Companion.setCredentialProtectedStorageContext(context);
    }

    public static final void setCustomerLogCallback(CustomerLogCallback customerLogCallback) {
        Companion.setCustomerLogCallback(customerLogCallback);
    }

    public static final void setCustomerLogPathAndUpload(String str) {
        Companion.setCustomerLogPathAndUpload(str);
    }

    public static final void setDarkBackgroundColor(float f3, float f4, float f5) {
        Companion.setDarkBackgroundColor(f3, f4, f5);
    }

    public static final void setDarkThemeColor(int i3) {
        Companion.setDarkThemeColor(i3);
    }

    public static final void setDataSavedCountry(int i3) {
        Companion.setDataSavedCountry(i3);
    }

    public static final void setEnv(int i3) {
        Companion.setEnv(i3);
    }

    public static final void setExtraData(String str, String str2) {
        Companion.setExtraData(str, str2);
    }

    public static final void setH5Callback(H5Callback h5Callback) {
        Companion.setH5Callback(h5Callback);
    }

    public static final void setIPCollection(boolean z3) {
        Companion.setIPCollection(z3);
    }

    public static final void setId(String str) {
        Companion.setId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setImageAccessAgreeStatusListener$lambda$15(ImageAccessAgreeStatusListener imageAccessAgreeStatusListener, boolean z3) {
        if (imageAccessAgreeStatusListener != null) {
            imageAccessAgreeStatusListener.returnImageAccessAgreeStatus(z3);
        }
    }

    public static final void setInterceptOnlineService(boolean z3) {
        Companion.setInterceptOnlineService(z3);
    }

    public static final void setInterceptSelfService(boolean z3) {
        Companion.setInterceptSelfService(z3);
    }

    @Deprecated
    public static final void setIsNeedJumpCenterPage(boolean z3) {
        Companion.setIsNeedJumpCenterPage(z3);
    }

    public static final void setLogDebugging(boolean z3) {
        Companion.setLogDebugging(z3);
    }

    public static final void setLogReminder(boolean z3) {
        Companion.setLogReminder(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNetworkStatusListener$lambda$14(NetworkStatusListener networkStatusListener, boolean z3) {
        if (networkStatusListener != null) {
            networkStatusListener.returnNetworkStatus(z3);
        }
    }

    public static final void setNetworkUserAgree(boolean z3) {
        Companion.setNetworkUserAgree(z3);
    }

    public static final void setRequestMadeListener(RequestMadeCallback requestMadeCallback) {
        Companion.setRequestMadeListener(requestMadeCallback);
    }

    public static final void setSupportLogKit(boolean z3) {
        Companion.setSupportLogKit(z3);
    }

    public static final void setTestUrl(String str) {
        Companion.setTestUrl(str);
    }

    public static final void setThemeColor(int i3) {
        Companion.setThemeColor(i3);
    }

    public static final void setThirdWebDomStorageEnabled(boolean z3) {
        Companion.setThirdWebDomStorageEnabled(z3);
    }

    public static final void setUiMode(int i3) {
        Companion.setUiMode(i3);
    }

    public static final void setUploadListener(UploadListener uploadListener) {
        Companion.setUploadListener(uploadListener);
    }

    public static final void setUserAccountID(String str) {
        Companion.setUserAccountID(str);
    }

    public static final void setUserAccountName(String str) {
        Companion.setUserAccountName(str);
    }

    public static final void setUserPrivacyBehaviorAgree(boolean z3, boolean z4) {
        Companion.setUserPrivacyBehaviorAgree(z3, z4);
    }

    public static final void setWebViewDebugMode(boolean z3) {
        Companion.setWebViewDebugMode(z3);
    }

    public final void fbLogD(String str) {
        AbstractC0412b.b(str, 3);
    }

    public final void fbLogE(String str) {
        AbstractC0412b.b(str, 6);
    }

    public final void fbLogI(String str) {
        AbstractC0412b.b(str, 4);
    }

    public final void fbLogV(String str) {
        AbstractC0412b.b(str, 2);
    }

    public final void fbLogW(String str) {
        AbstractC0412b.b(str, 5);
    }

    public final Integer getCommonOrientationType() {
        feedbacka feedbackaVar = this.feedbackApi;
        if (feedbackaVar != null) {
            return Integer.valueOf(feedbackaVar.feedbackd);
        }
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Integer getLargeScreenOrientation() {
        feedbacka feedbackaVar = this.feedbackApi;
        if (feedbackaVar != null) {
            return Integer.valueOf(feedbackaVar.feedbacke);
        }
        return null;
    }

    public final FeedbackHelper openFeedBackUpLog(Context context, final UploadListener uploadListener) {
        q qVar = null;
        if (context != null && this.feedbackApi != null) {
            com.customer.feedback.sdk.util.UploadListener uploadListener2 = new com.customer.feedback.sdk.util.UploadListener() { // from class: C0.b
                @Override // com.customer.feedback.sdk.util.UploadListener
                public final void onUploaded(boolean z3) {
                    FeedbackHelper.openFeedBackUpLog$lambda$5$lambda$4(FeedbackHelper.UploadListener.this, z3);
                }
            };
            Context context2 = feedbacka.feedbackf;
            String str = AbstractC0444a.f12287a;
            feedbacka.feedbacka(context, false, null, "/feedback?homeNull=true");
            LogUtil.d("HeaderInterface", "setUploadListener");
            f.f12444c = uploadListener2;
            qVar = q.f12810a;
        }
        if (qVar == null) {
            LogUtil.e(TAG, "[openFeedBackUpLog] context must not be null");
        }
        return this;
    }

    public final FeedbackHelper openFeedBackUpLogWithCode(Context context, String str, final UploadListener uploadListener) {
        q qVar;
        if (context == null || this.feedbackApi == null) {
            qVar = null;
        } else {
            com.customer.feedback.sdk.util.UploadListener uploadListener2 = new com.customer.feedback.sdk.util.UploadListener() { // from class: C0.c
                @Override // com.customer.feedback.sdk.util.UploadListener
                public final void onUploaded(boolean z3) {
                    FeedbackHelper.openFeedBackUpLogWithCode$lambda$8$lambda$7(FeedbackHelper.UploadListener.this, z3);
                }
            };
            Context context2 = feedbacka.feedbackf;
            String str2 = AbstractC0444a.f12287a;
            feedbacka.feedbacka(context, false, str, "/feedback?homeNull=true");
            LogUtil.d("HeaderInterface", "setUploadListener");
            f.f12444c = uploadListener2;
            qVar = q.f12810a;
        }
        if (qVar == null) {
            LogUtil.e(TAG, "[openFeedBackUpLogWithCode] context must not be null");
        }
        return this;
    }

    public final FeedbackHelper openFeedback(Activity activity) {
        q qVar = null;
        if (activity != null && this.feedbackApi != null) {
            Context context = feedbacka.feedbackf;
            String str = AbstractC0444a.f12287a;
            feedbacka.feedbacka(activity, false, null, "/feedback?homeNull=true");
            qVar = q.f12810a;
        }
        if (qVar == null) {
            LogUtil.e(TAG, "[openFeedback] activity must not be null");
        }
        return this;
    }

    public final FeedbackHelper openFeedbackRedirect(Activity activity, boolean z3, String str) {
        q qVar;
        if (activity == null || this.feedbackApi == null) {
            qVar = null;
        } else {
            String str2 = AbstractC0444a.f12287a;
            feedbacka.feedbacka(activity, z3, str, "/feedback?homeNull=true");
            qVar = q.f12810a;
        }
        if (qVar == null) {
            LogUtil.e(TAG, "[openFeedbackRedirect] context must not be null");
        }
        return this;
    }

    public final FeedbackHelper openFeedbackWithCode(Activity activity, String str) {
        q qVar;
        if (activity == null || this.feedbackApi == null) {
            qVar = null;
        } else {
            Context context = feedbacka.feedbackf;
            String str2 = AbstractC0444a.f12287a;
            feedbacka.feedbacka(activity, false, str, "/feedback?homeNull=true");
            qVar = q.f12810a;
        }
        if (qVar == null) {
            LogUtil.e(TAG, "[openFeedbackWithCode] activity must not be null");
        }
        return this;
    }

    public final FeedbackHelper setCommonOrientationType(int i3) {
        feedbacka feedbackaVar = this.feedbackApi;
        if (feedbackaVar != null) {
            feedbackaVar.feedbackd = i3;
        }
        return this;
    }

    public final FeedbackHelper setImageAccessAgreeStatusListener(final ImageAccessAgreeStatusListener imageAccessAgreeStatusListener) {
        feedbacka feedbackaVar = this.feedbackApi;
        if (feedbackaVar != null) {
            feedbackaVar.feedbackc = new SoftReference<>(new feedbacka.feedbackc() { // from class: C0.a
                @Override // com.customer.feedback.sdk.feedbacka.feedbackc
                public final void feedbacka(boolean z3) {
                    FeedbackHelper.setImageAccessAgreeStatusListener$lambda$15(FeedbackHelper.ImageAccessAgreeStatusListener.this, z3);
                }
            });
        }
        return this;
    }

    public final FeedbackHelper setLargeScreenOrientation(int i3) {
        feedbacka feedbackaVar = this.feedbackApi;
        if (feedbackaVar != null) {
            feedbackaVar.feedbacke = i3;
        }
        return this;
    }

    public final FeedbackHelper setNetworkStatusListener(final NetworkStatusListener networkStatusListener) {
        feedbacka feedbackaVar = this.feedbackApi;
        if (feedbackaVar != null) {
            feedbackaVar.feedbackb = new SoftReference<>(new feedbacka.feedbackd() { // from class: C0.d
                @Override // com.customer.feedback.sdk.feedbacka.feedbackd
                public final void returnNetworkStatus(boolean z3) {
                    FeedbackHelper.setNetworkStatusListener$lambda$14(FeedbackHelper.NetworkStatusListener.this, z3);
                }
            });
        }
        return this;
    }

    public final FeedbackHelper openFeedbackRedirect(Activity activity, boolean z3, String str, String str2) {
        q qVar;
        if (activity == null || this.feedbackApi == null) {
            qVar = null;
        } else {
            feedbacka.feedbacka(activity, z3, str, str2);
            qVar = q.f12810a;
        }
        if (qVar == null) {
            LogUtil.e(TAG, "[openFeedbackRedirect] context must not be null");
        }
        return this;
    }
}
