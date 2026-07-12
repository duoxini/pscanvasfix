package com.customer.feedback.sdk.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.window.OnBackInvokedCallback;
import com.customer.feedback.sdk.FeedbackThirdWebManager;
import com.customer.feedback.sdk.R;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.model.RequestData;
import com.customer.feedback.sdk.util.HeaderInfoHelper;
import com.customer.feedback.sdk.util.LogUtil;
import com.customer.feedback.sdk.util.NetworkUtil;
import com.customer.feedback.sdk.widget.ContainerView;
import d.InterfaceC0334a;
import h2.AbstractC0391b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import k2.AbstractC0444a;
import m2.AbstractC0468c;
import m2.f;
import m2.l;
import m2.m;
import m2.p;
import n2.DialogC0489f;
import o2.AbstractC0493a;

@InterfaceC0334a
/* loaded from: classes.dex */
public class FeedbackActivity extends Activity {
    public static final int BACK_BY_H5 = 114;
    private static final long DELAY_MILLIS = 100;
    public static String FEEDBACK_URL = null;
    private static final int GET_DONE = 1010;
    public static String INDEX_URL = null;
    private static final String JS_ANDROID_FEEDBACK = "android_feedback";
    private static final String NATIVE_ERR_URL = "file:///android_asset/feedback_html/err.html";
    public static final int QUERY_QUE_NUM = 1011;
    private static final int REQUESTCODE_FILECHOOSER = 1;
    private static final int REQUESTCODE_SHOW_FILECHOOSER = 2;
    private static final int REQUESTCODE_SHOW_NOTICE_FILECHOOSER = 3;
    public static final int SHOW_NO_NETWORK = 112;
    private static final int SYSTEM_FOLDING_MODE_CLOSE = 0;
    private static final String SYSTEM_FOLDING_MODE_KEYS = "oplus_system_folding_mode";
    private static final int SYSTEM_FOLDING_MODE_OPEN = 1;
    public static final String TAG = "FeedbackActivity";
    public static final int TO_NOTICE_PAGE = 113;
    private static final int TYPE_REQUEST_IMAGE_BEHAVIOR = 2;
    private static final int TYPE_REQUEST_INTERNET_BEHAVIOR = 1;
    public static String sAppVersion = "1.0";
    private int darkBgColor;
    private boolean isQueryNumber;
    private Context mApplicationContext;
    private FrameLayout mContainer;
    private ContainerView mContainerView;
    private String mFailingUrl;
    private ValueCallback<Uri[]> mFilePaths;
    private feedbacka.feedbackc mImageAccessAgreeStatusListener;
    private boolean mIsNightMode;
    private int mLightColor;
    private feedbacka.feedbackd mNetworkStatusListener;
    private ContainerView mNoticeContainerView;
    private ValueCallback<Uri[]> mNoticeFilePaths;
    private String mNoticeUrl;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    private DialogC0489f mPrivacyBehaviorAgreeDialog;
    private boolean mRedirect;
    private DialogC0489f mSslErrorDialog;
    private String mTargetPage;
    private m mThirdWebJsInterface;
    private ValueCallback<Uri> mUploadMessage;
    private boolean mWebViewIsStarted;
    private WebView noticeWebView;
    private boolean openFeedbackRedirect;
    private Map<String, String> requestHeaderMap;
    private WebSettings webSettings;
    private WebView webView;
    private boolean onBackPressedAtShowWrong = false;
    private boolean whenDoWebviewGoback = false;
    private Handler handler = new feedbackq(this, 0);
    private boolean mGoneNoticePageDirect = false;
    private boolean isH5HomePage = true;
    private boolean mWaitForToken = false;
    private ContentObserver mFoldingScreenObserver = new feedbackh();
    private feedbacka.feedbacke mOnTokenChangedListener = new feedbacki();
    private WebChromeClient mWebChromeClient = new feedbackk();
    private boolean loadFailedState = false;
    private WebViewClient mWebViewClient = new feedbackl();
    private boolean[] trigBooleanTag = new boolean[2];
    private boolean loadFailForNoNetwork = false;
    private final String CUSTOMER_CENTER_JS_NAME = "HeytapTheme";

    public class feedbacka implements DialogC0489f.b {
        public feedbacka() {
        }

        @Override // n2.DialogC0489f.b
        public final void feedbacka() {
            if (FeedbackActivity.this.mContainerView != null) {
                FeedbackActivity.this.mContainerView.feedbacka(1);
            }
            if (FeedbackActivity.this.mNetworkStatusListener != null) {
                FeedbackActivity.this.mNetworkStatusListener.returnNetworkStatus(false);
            }
            if (FeedbackActivity.this.mImageAccessAgreeStatusListener != null) {
                FeedbackActivity.this.mImageAccessAgreeStatusListener.feedbacka(false);
            }
            FeedbackActivity.this.finish();
            FeedbackActivity.this.mNetworkStatusListener = null;
            FeedbackActivity.this.mImageAccessAgreeStatusListener = null;
        }
    }

    public class feedbackb implements DialogC0489f.c {
        public feedbackb() {
        }

        @Override // n2.DialogC0489f.c
        public final void feedbacka() {
            l.d(FeedbackActivity.this, "key_privacy_behavior_agree", true);
            if (FeedbackActivity.this.mNetworkStatusListener != null) {
                FeedbackActivity.this.mNetworkStatusListener.returnNetworkStatus(true);
            }
            if (FeedbackActivity.this.mImageAccessAgreeStatusListener != null) {
                FeedbackActivity.this.mImageAccessAgreeStatusListener.feedbacka(true);
            }
            FeedbackActivity.this.init();
            FeedbackActivity.this.mNetworkStatusListener = null;
            FeedbackActivity.this.mImageAccessAgreeStatusListener = null;
        }
    }

    public class feedbackc implements Runnable {
        public final /* synthetic */ Context feedbacka;
        public final /* synthetic */ Handler feedbackb;

        public feedbackc(Context context, Handler handler) {
            this.feedbacka = context;
            this.feedbackb = handler;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0189  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 398
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customer.feedback.sdk.activity.FeedbackActivity.feedbackc.run():void");
        }
    }

    public class feedbackd {
        public feedbackd() {
        }

        @JavascriptInterface
        public String isNight() {
            return FeedbackActivity.this.mIsNightMode + "";
        }
    }

    public class feedbacke implements View.OnClickListener {
        public feedbacke() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FeedbackActivity.this.mNoticeContainerView.feedbacka(0);
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.setNavigationColor(feedbackActivity.mNoticeContainerView);
            String url = FeedbackActivity.this.noticeWebView.getUrl();
            if (TextUtils.isEmpty(url)) {
                return;
            }
            FeedbackActivity.this.noticeWebView.loadUrl(url);
        }
    }

    public class feedbackf extends WebViewClient {
        public feedbackf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void feedbacka() {
            if (FeedbackActivity.this.mNoticeContainerView != null) {
                FeedbackActivity.this.mNoticeContainerView.feedbacka(1);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z3) {
            super.doUpdateVisitedHistory(webView, str, z3);
            FeedbackActivity.this.updateOnBackInvoked();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            FeedbackActivity.LogUtil("Notice onPageFinished,loadFailForNoNetwork=" + FeedbackActivity.this.loadFailForNoNetwork + ",progress=" + webView.getProgress());
            super.onPageFinished(webView, str);
            if (FeedbackActivity.this.loadFailForNoNetwork) {
                LogUtil.e(FeedbackActivity.TAG, "Notice onPageFinished, loadFailForNoNetwork is true");
                FeedbackActivity.this.mNoticeContainerView.feedbacka(2);
                FeedbackActivity feedbackActivity = FeedbackActivity.this;
                feedbackActivity.setNavigationColor(feedbackActivity.mNoticeContainerView);
                return;
            }
            if (webView.getProgress() == 100) {
                if (FeedbackActivity.this.mNoticeContainerView == null) {
                    LogUtil.e(FeedbackActivity.TAG, "Notice onPageFinished, mNoticeContainerView is null");
                } else {
                    FeedbackActivity.this.mNoticeContainerView.postDelayed(new Runnable() { // from class: D0.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedbackActivity.feedbackf.this.feedbacka();
                        }
                    }, FeedbackActivity.DELAY_MILLIS);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            FeedbackActivity.LogUtil("Notice onPageStarted=" + str);
            super.onPageStarted(webView, str, bitmap);
            FeedbackActivity.this.loadFailForNoNetwork = false;
            Arrays.fill(FeedbackActivity.this.trigBooleanTag, false);
            FeedbackActivity.this.trigBooleanTag[0] = true;
            FeedbackActivity.this.mNoticeContainerView.feedbacka(0);
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.setNavigationColor(feedbackActivity.mNoticeContainerView);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i3, String str, String str2) {
            FeedbackActivity.LogUtil("Notice onReceivedError,errorCode:" + i3 + " ;description:" + str + ";failingData=" + str2);
            FeedbackActivity.this.showErrorPage();
        }

        @Override // android.webkit.WebViewClient
        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (FeedbackActivity.this.noticeWebView == null) {
                return false;
            }
            ((ViewGroup) FeedbackActivity.this.noticeWebView.getParent()).removeView(FeedbackActivity.this.noticeWebView);
            FeedbackActivity.this.noticeWebView.destroy();
            FeedbackActivity.this.noticeWebView = null;
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            FeedbackActivity.LogUtil("Notice shouldOverrideUrlLoading=" + str);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                return false;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (str.startsWith("fat://fb/main")) {
                    intent.setPackage(FeedbackActivity.this.getPackageName());
                } else {
                    intent.addFlags(268435456);
                }
                FeedbackActivity.this.startActivity(intent);
                return true;
            } catch (Exception e3) {
                LogUtil.e(FeedbackActivity.TAG, "shouldOverrideUrlLoading: " + e3.getMessage());
                return true;
            }
        }
    }

    public class feedbackg extends WebChromeClient {
        public feedbackg() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i3) {
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            LogUtil.d(FeedbackActivity.TAG, "Notice onReceivedTitle: " + str);
            if (FeedbackActivity.this.loadFailForNoNetwork || !FeedbackActivity.this.isOnlineCustomer() || str.startsWith("http://") || str.startsWith("https://")) {
                return;
            }
            FeedbackActivity.this.mNoticeContainerView.feedbackb(true);
            FeedbackActivity.this.mNoticeContainerView.setTitle(str);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LogUtil.d(FeedbackActivity.TAG, "Notice onShowFileChooser");
            FeedbackActivity.this.mNoticeFilePaths = valueCallback;
            String c3 = AbstractC0468c.c(FeedbackActivity.this.mApplicationContext);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setPackage(c3);
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent createChooser = Intent.createChooser(intent, "");
            try {
                LogUtil.d(FeedbackActivity.TAG, "onShowFileChooser ->noticeWebView DocPackageName:".concat(c3));
                FeedbackActivity.this.startActivityForResult(createChooser, 3);
                return true;
            } catch (SecurityException e3) {
                LogUtil.e(FeedbackActivity.TAG, "onShowFileChooser ->noticeWebView startActivity error:" + e3);
                return true;
            }
        }
    }

    public class feedbackh extends ContentObserver {
        public feedbackh() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z3) {
            FeedbackActivity.this.setScreenOrientationByConfig();
        }
    }

    public class feedbacki implements feedbacka.feedbacke {
        public feedbacki() {
        }

        public final void feedbacka(String str) {
            if (FeedbackActivity.this.mWaitForToken) {
                if (!TextUtils.isEmpty(str)) {
                    LogUtil.i(FeedbackActivity.TAG, "onTokenChanged goAhead");
                    FeedbackActivity.this.webView.evaluateJavascript("javascript:goAhead()", null);
                    FeedbackActivity.this.mWaitForToken = false;
                } else {
                    LogUtil.w(FeedbackActivity.TAG, "direct -> " + FeedbackActivity.this.mGoneNoticePageDirect);
                    if (FeedbackActivity.this.mGoneNoticePageDirect) {
                        FeedbackActivity.this.finish();
                    }
                }
            }
        }
    }

    public class feedbackj implements View.OnLongClickListener {
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return true;
        }
    }

    public class feedbackk extends WebChromeClient {
        public feedbackk() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            FeedbackActivity.LogUtil(consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i3) {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LogUtil.d(FeedbackActivity.TAG, " onShowFileChooser");
            FeedbackActivity.this.mFilePaths = valueCallback;
            String c3 = AbstractC0468c.c(FeedbackActivity.this.mApplicationContext);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setPackage(c3);
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            Intent createChooser = Intent.createChooser(intent, "");
            try {
                LogUtil.d(FeedbackActivity.TAG, "onShowFileChooser -> DocPackageName:".concat(c3));
                FeedbackActivity.this.startActivityForResult(createChooser, 2);
                return true;
            } catch (SecurityException e3) {
                LogUtil.e(FeedbackActivity.TAG, "onShowFileChooser -> startActivity error:" + e3);
                return true;
            }
        }
    }

    public class feedbackl extends WebViewClient {
        public feedbackl() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            FeedbackActivity.LogUtil("onPageFinished");
            super.onPageFinished(webView, str);
            if (!FeedbackActivity.this.loadFailedState && !FeedbackActivity.this.onBackPressedAtShowWrong) {
                if (FeedbackActivity.this.mWebViewIsStarted) {
                    FeedbackActivity.this.mWebViewIsStarted = false;
                }
            } else {
                FeedbackActivity.this.loadFailedState = false;
                if (FeedbackActivity.this.onBackPressedAtShowWrong) {
                    FeedbackActivity.this.mContainerView.feedbacka(1);
                    FeedbackActivity.this.onBackPressedAtShowWrong = false;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            FeedbackActivity.LogUtil("onPageStarted url=" + str);
            webView.resumeTimers();
            FeedbackActivity.this.mWebViewIsStarted = true;
            if (!FeedbackActivity.this.whenDoWebviewGoback) {
                FeedbackActivity.this.mContainerView.feedbacka(0);
                FeedbackActivity feedbackActivity = FeedbackActivity.this;
                feedbackActivity.setNavigationColor(feedbackActivity.mContainerView);
            } else {
                FeedbackActivity.this.whenDoWebviewGoback = false;
                if (FeedbackActivity.this.onBackPressedAtShowWrong) {
                    FeedbackActivity.this.mContainerView.feedbacka(0);
                    FeedbackActivity feedbackActivity2 = FeedbackActivity.this;
                    feedbackActivity2.setNavigationColor(feedbackActivity2.mContainerView);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i3, String str, String str2) {
            FeedbackActivity.LogUtil("onReceivedError,errcode=" + i3 + " description=" + str);
            FeedbackActivity.this.mFailingUrl = str2;
            FeedbackActivity.this.loadFailedState = true;
            FeedbackActivity.this.handler.sendEmptyMessage(FeedbackActivity.SHOW_NO_NETWORK);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            FeedbackActivity.this.mContainerView.feedbacka(2);
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.setNavigationColor(feedbackActivity.mContainerView);
            FeedbackActivity.LogUtil("onReceivedSslError:" + sslError.toString());
            FeedbackActivity.this.loadFailedState = true;
            FeedbackActivity.this.sslReceivedErrorProcess(sslErrorHandler, false);
        }

        @Override // android.webkit.WebViewClient
        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (FeedbackActivity.this.webView == null) {
                return false;
            }
            ((ViewGroup) FeedbackActivity.this.webView.getParent()).removeView(FeedbackActivity.this.webView);
            FeedbackActivity.this.webView.destroy();
            FeedbackActivity.this.webView = null;
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            FeedbackActivity.LogUtil("shouldOverrideUrlLoading url=" + str);
            return false;
        }
    }

    public class feedbackm implements DialogC0489f.a {
        public feedbackm() {
        }

        @Override // n2.DialogC0489f.a
        public final void feedbacka() {
            FeedbackActivity.this.finish();
        }
    }

    public class feedbackn implements DialogC0489f.b {
        public feedbackn() {
        }

        @Override // n2.DialogC0489f.b
        public final void feedbacka() {
            FeedbackActivity.this.finish();
        }
    }

    public class feedbacko implements DialogC0489f.c {
        public feedbacko() {
        }

        @Override // n2.DialogC0489f.c
        public final void feedbacka() {
            FeedbackActivity.this.mContainerView.feedbacka(0);
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.setNavigationColor(feedbackActivity.mContainerView);
            FeedbackActivity.this.getHandler().sendEmptyMessageDelayed(FeedbackActivity.SHOW_NO_NETWORK, 1000L);
        }
    }

    public class feedbackp implements DialogC0489f.a {
        public feedbackp() {
        }

        @Override // n2.DialogC0489f.a
        public final void feedbacka() {
            FeedbackActivity.this.finish();
        }
    }

    public static class feedbackq extends Handler {
        public final WeakReference<FeedbackActivity> feedbacka;

        public /* synthetic */ feedbackq(FeedbackActivity feedbackActivity, int i3) {
            this(feedbackActivity);
        }

        public static /* synthetic */ void feedbacka(FeedbackActivity feedbackActivity, String str) {
            if (!"FALSE".equalsIgnoreCase(str)) {
                feedbackActivity.finish();
                return;
            }
            if (!feedbackActivity.mRedirect) {
                feedbackActivity.whenDoWebviewGoback = true;
            }
            if (feedbackActivity.getWebView() != null) {
                feedbackActivity.getWebView().evaluateJavascript("javascript:h5Route()", null);
            } else {
                LogUtil.e(FeedbackActivity.TAG, "onReceiveValue: webView is null!");
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            WeakReference<FeedbackActivity> weakReference = this.feedbacka;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            final FeedbackActivity feedbackActivity = this.feedbacka.get();
            if (i3 == 0) {
                if (feedbackActivity == null || feedbackActivity.getContainerView() == null) {
                    return;
                }
                feedbackActivity.getContainerView().feedbacka(0);
                feedbackActivity.setNavigationColor(feedbackActivity.getContainerView());
            }
            if (i3 == 1) {
                if (feedbackActivity == null || feedbackActivity.getContainerView() == null) {
                    return;
                }
                feedbackActivity.getContainerView().feedbacka(1);
                return;
            }
            if (i3 == FeedbackActivity.GET_DONE) {
                feedbackActivity.findView();
                feedbackActivity.setWebView();
                feedbackActivity.setBrightness();
                feedbackActivity.loadUrl();
                return;
            }
            if (i3 == 1011) {
                feedbackActivity.openFeedbackRedirect = !((Boolean) message.obj).booleanValue();
                feedbackActivity.isQueryNumber = true;
                feedbackActivity.sendMessage();
                FeedbackActivity.LogUtil("openFeedbackRedirect=" + feedbackActivity.openFeedbackRedirect);
                feedbackActivity.updateOnBackInvoked();
                return;
            }
            switch (i3) {
                case FeedbackActivity.SHOW_NO_NETWORK /* 112 */:
                    feedbackActivity.showNoNetworkView(feedbackActivity.getString(R.string.no_network_connect_str));
                    break;
                case FeedbackActivity.TO_NOTICE_PAGE /* 113 */:
                    String str = (String) message.obj;
                    if (feedbackActivity.mNoticeContainerView == null) {
                        feedbackActivity.createNoticeWebView(str);
                        if (!TextUtils.isEmpty(str)) {
                            feedbackActivity.noticeWebView.loadUrl(str);
                            if (!TextUtils.isEmpty(com.customer.feedback.sdk.feedbacka.feedbacka()) && !str.startsWith(com.customer.feedback.sdk.feedbacka.feedbacka())) {
                                AbstractC0468c.h(AbstractC0468c.m(), feedbackActivity.noticeWebView);
                            }
                        }
                        if (feedbackActivity.isGoNoticePageDirect()) {
                            feedbackActivity.dismissContainerView();
                            break;
                        }
                    }
                    break;
                case FeedbackActivity.BACK_BY_H5 /* 114 */:
                    if (feedbackActivity.getWebView() != null) {
                        feedbackActivity.getWebView().evaluateJavascript("javascript:isHome()", new ValueCallback() { // from class: D0.f
                            @Override // android.webkit.ValueCallback
                            public final void onReceiveValue(Object obj) {
                                FeedbackActivity.feedbackq.feedbacka(FeedbackActivity.this, (String) obj);
                            }
                        });
                        break;
                    }
                    break;
            }
        }

        public feedbackq(FeedbackActivity feedbackActivity) {
            this.feedbacka = new WeakReference<>(feedbackActivity);
        }
    }

    public static void LogUtil(String str) {
        LogUtil.d(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backEvent() {
        LogUtil.d(TAG, "backEvent");
        if (this.mGoneNoticePageDirect) {
            finish();
        }
        if (noticeWebViewGoBack()) {
            return;
        }
        try {
            WebView webView = this.webView;
            String url = webView == null ? "" : webView.getUrl();
            if (!TextUtils.isEmpty(url) && !NATIVE_ERR_URL.equalsIgnoreCase(url) && url.startsWith(INDEX_URL)) {
                if (this.mContainerView.getCurrentShowViewType() == 2) {
                    this.onBackPressedAtShowWrong = true;
                }
                this.handler.sendEmptyMessage(BACK_BY_H5);
                return;
            }
            if (hasWindowFocus()) {
                super.onBackPressed();
            } else {
                finish();
            }
        } catch (Exception e3) {
            LogUtil.e(TAG, "exceptionInfo：" + e3);
            finish();
        }
    }

    private void cancelDialogs() {
        DialogC0489f dialogC0489f = this.mPrivacyBehaviorAgreeDialog;
        if (dialogC0489f != null) {
            dialogC0489f.cancel();
        }
        DialogC0489f dialogC0489f2 = this.mSslErrorDialog;
        if (dialogC0489f2 != null) {
            dialogC0489f2.cancel();
        }
    }

    private void changeDarkModel() {
        if (isOnlineCustomer()) {
            if (this.mIsNightMode) {
                this.noticeWebView.addJavascriptInterface(new feedbackd(), "HeytapTheme");
            } else {
                this.noticeWebView.removeJavascriptInterface("HeytapTheme");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createNoticeWebView(String str) {
        this.mNoticeUrl = str;
        if (this.noticeWebView != null) {
            destroyNoticeView();
        }
        ContainerView containerView = new ContainerView(this);
        this.mNoticeContainerView = containerView;
        AbstractC0468c.g(this, containerView, true);
        WebView contentView = this.mNoticeContainerView.getContentView();
        this.noticeWebView = contentView;
        setWebSetting(contentView.getSettings());
        this.mThirdWebJsInterface = new m();
        this.noticeWebView.getSettings().setDomStorageEnabled(com.customer.feedback.sdk.feedbacka.feedbackw);
        this.noticeWebView.setOverScrollMode(2);
        changeDarkModel();
        this.noticeWebView.addJavascriptInterface(new f(this, this.mNoticeContainerView), JS_ANDROID_FEEDBACK);
        this.noticeWebView.addJavascriptInterface(this.mThirdWebJsInterface, FeedbackThirdWebManager.getInstance().getThirdWebInterfaceName());
        this.mNoticeContainerView.feedbackc(this.mIsNightMode);
        this.mNoticeContainerView.setBackClick(new View.OnClickListener() { // from class: D0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.lambda$createNoticeWebView$2(view);
            }
        });
        this.mNoticeContainerView.setReloadListener(new feedbacke());
        this.noticeWebView.setWebViewClient(new feedbackf());
        this.noticeWebView.setWebChromeClient(new feedbackg());
        this.mContainer.addView(this.mNoticeContainerView, new FrameLayout.LayoutParams(-1, -1));
        updateOnBackInvoked();
    }

    private void destroyLeakReference() {
        this.webView = null;
        this.webSettings = null;
        this.mThirdWebJsInterface = null;
        this.mContainerView = null;
        this.mNetworkStatusListener = null;
    }

    private void destroyNoticeView() {
        WebView webView = this.noticeWebView;
        if (webView != null) {
            webView.clearFormData();
            this.noticeWebView.clearHistory();
            this.noticeWebView.clearFocus();
            this.noticeWebView.destroy();
            ContainerView containerView = this.mNoticeContainerView;
            if (containerView != null) {
                containerView.removeView(containerView.feedbackh);
                this.mContainer.removeView(this.mNoticeContainerView);
            }
            this.noticeWebView = null;
            this.mNoticeContainerView = null;
            this.mNoticeUrl = null;
        }
        updateOnBackInvoked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findView() {
        WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        this.webSettings = webView.getSettings();
        this.requestHeaderMap = HeaderInfoHelper.getHeader(this.mApplicationContext);
    }

    private void getFAQNum() {
        INDEX_URL = AbstractC0444a.f12287a;
        FEEDBACK_URL = AbstractC0444a.f12287a + "/feedback?homeNull=true";
        newThreadExec(getApplicationContext(), getHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.mContainerView.setVisibility(0);
        this.mContainerView.feedbacka(0);
        setNavigationColor(this.mContainerView);
        if (!NetworkUtil.hasNetworkConnect(this.mApplicationContext)) {
            this.handler.sendEmptyMessageDelayed(SHOW_NO_NETWORK, 1000L);
        } else {
            initParam();
            getFAQNum();
        }
    }

    private void initParam() {
        String str;
        String str2;
        Intent intent = getIntent();
        String str3 = "";
        try {
            str = intent.getStringExtra("AppCode");
        } catch (Exception e3) {
            try {
                LogUtil.e("FbUtils", " getStringFromIntent error " + e3.getMessage());
                str = "";
            } catch (Exception e4) {
                e = e4;
                LogUtil.e(TAG, "exceptionInfo：" + e);
                str = str3;
                HeaderInfoHelper.setAppCode(str);
                LogUtil("initParam AppCode = " + str);
            }
        }
        try {
            this.mRedirect = AbstractC0468c.i(intent, "redirect_to_feedback");
            try {
                str2 = intent.getStringExtra("target_page");
            } catch (Exception e5) {
                LogUtil.e("FbUtils", " getStringFromIntent error " + e5.getMessage());
                str2 = "";
            }
            this.mTargetPage = str2;
            try {
                str3 = intent.getStringExtra("intent_app_version");
            } catch (Exception e6) {
                LogUtil.e("FbUtils", " getStringFromIntent error " + e6.getMessage());
            }
            sAppVersion = str3;
            if (getIntent().getData() != null) {
                String queryParameter = getIntent().getData().getQueryParameter("target");
                LogUtil.d(TAG, "targetPage -> " + queryParameter);
                if (RequestData.TYPE_FEEDBACK.equals(queryParameter)) {
                    this.mRedirect = true;
                    String str4 = AbstractC0444a.f12287a;
                    this.mTargetPage = "/feedback?homeNull=true&ignoreOnlineService=true";
                }
            }
        } catch (Exception e7) {
            e = e7;
            str3 = str;
            LogUtil.e(TAG, "exceptionInfo：" + e);
            str = str3;
            HeaderInfoHelper.setAppCode(str);
            LogUtil("initParam AppCode = " + str);
        }
        HeaderInfoHelper.setAppCode(str);
        LogUtil("initParam AppCode = " + str);
    }

    private boolean isKeyboardIsShowing() {
        int height = getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return (height * 2) / 3 > rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOnlineCustomer() {
        return (TextUtils.isEmpty(this.mNoticeUrl) || TextUtils.isEmpty(com.customer.feedback.sdk.feedbacka.feedbacka()) || !this.mNoticeUrl.startsWith(com.customer.feedback.sdk.feedbacka.feedbacka())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createNoticeWebView$2(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (NetworkUtil.isMobileDataConnected(this.mApplicationContext) || NetworkUtil.isWifiConnected(this.mApplicationContext)) {
            this.loadFailedState = false;
            this.onBackPressedAtShowWrong = false;
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl() {
        LogUtil("mRedirect=" + this.mRedirect);
        if (AbstractC0468c.i(getIntent(), "fromNotification")) {
            String str = AbstractC0444a.f12287a;
            String str2 = AbstractC0444a.f12287a + AbstractC0444a.f12290d;
            WebView webView = this.webView;
            if (webView != null) {
                webView.loadUrl(str2, this.requestHeaderMap);
                return;
            }
            return;
        }
        if (!this.mRedirect) {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.loadUrl(INDEX_URL, this.requestHeaderMap);
                return;
            }
            return;
        }
        if (this.webView != null) {
            String str3 = this.mTargetPage;
            String str4 = AbstractC0444a.f12287a;
            if (TextUtils.isEmpty(str3)) {
                str3 = "/feedback?homeNull=true";
            }
            String str5 = AbstractC0444a.f12287a + str3;
            LogUtil.d(TAG, "redirect url -> " + str5);
            this.webView.loadUrl(str5, this.requestHeaderMap);
        }
    }

    private static void newThreadExec(Context context, Handler handler) {
        new Thread(new feedbackc(context, handler)).start();
    }

    private boolean noticeWebViewGoBack() {
        WebView webView = this.noticeWebView;
        if (webView == null) {
            return false;
        }
        if (webView.canGoBack()) {
            this.noticeWebView.goBack();
            return true;
        }
        destroyNoticeView();
        WebView webView2 = this.webView;
        if (webView2 == null) {
            return true;
        }
        webView2.evaluateJavascript("javascript:setGlobalLife('onResume')", null);
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:9|(13:36|37|14|(1:16)(2:30|(1:32))|17|(1:19)|20|(1:22)|23|(1:25)|26|(1:28)|29)|11|12|13|14|(0)(0)|17|(0)|20|(0)|23|(0)|26|(0)|29) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        com.customer.feedback.sdk.util.LogUtil.e("FbUtils", "exceptionInfo：" + r0);
        r0 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void requestPrivacyBehaviorAgreeDialog(int r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customer.feedback.sdk.activity.FeedbackActivity.requestPrivacyBehaviorAgreeDialog(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage() {
        if (this.isQueryNumber) {
            this.isQueryNumber = false;
            if (!this.mRedirect && this.openFeedbackRedirect) {
                this.mRedirect = true;
            }
            this.handler.sendEmptyMessage(GET_DONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness() {
        if (AbstractC0468c.i(getIntent(), "isOpen")) {
            int i3 = 100;
            try {
                i3 = getIntent().getIntExtra("bright", 100);
            } catch (Exception e3) {
                LogUtil.e("FbUtils", " getIntFromIntent error " + e3.getMessage());
            }
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = i3 / 255.0f;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationColor(ContainerView containerView) {
        int color;
        if (AbstractC0468c.o(this) && Settings.System.getInt(getContentResolver(), "enable_launcher_taskbar", 0) != 1) {
            getWindow().setNavigationBarColor(0);
            return;
        }
        int currentShowViewType = containerView.getCurrentShowViewType();
        if (currentShowViewType == 0) {
            color = AbstractC0468c.m() ? -16777216 : getResources().getColor(R.color.feedback_background_color);
            getWindow().setNavigationBarColor(color);
            containerView.setNavigationBarBackground(color);
        } else {
            if (currentShowViewType != 2) {
                LogUtil.i(TAG, "ignore");
                return;
            }
            color = AbstractC0468c.m() ? -16777216 : -1;
            getWindow().setNavigationBarColor(color);
            containerView.setNavigationBarBackground(color);
        }
    }

    private void setWebSetting(WebSettings webSettings) {
        if (webSettings != null) {
            String version = HeaderInfoHelper.getVersion();
            Context context = com.customer.feedback.sdk.feedbacka.feedbackf;
            String str = "/FB-OS " + version + "/FB-SDK-VERSION 16.1.4";
            LogUtil("ua -> " + str);
            webSettings.setUserAgentString(webSettings.getUserAgentString() + str);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setSaveFormData(true);
            webSettings.setCacheMode(-1);
            webSettings.setAllowContentAccess(false);
            webSettings.setAllowFileAccess(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setTextSize(WebSettings.TextSize.NORMAL);
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebView() {
        setWebSetting(this.webSettings);
        WebView webView = this.webView;
        if (webView != null) {
            webView.setFocusableInTouchMode(true);
            this.webView.setFocusable(true);
            this.webView.requestFocus();
            this.webView.addJavascriptInterface(new f(this, this.mContainerView), JS_ANDROID_FEEDBACK);
            this.webView.setWebChromeClient(this.mWebChromeClient);
            this.webView.setWebViewClient(this.mWebViewClient);
            this.webView.setScrollBarStyle(0);
            this.webView.setForceDarkAllowed(false);
            this.webView.setOverScrollMode(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void showErrorPage() {
        if (!this.loadFailForNoNetwork) {
            this.loadFailForNoNetwork = true;
            this.mNoticeContainerView.feedbacka(2);
            setNavigationColor(this.mNoticeContainerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoNetworkView(String str) {
        LogUtil("showNoNetworkView");
        ContainerView containerView = this.mContainerView;
        if (containerView != null) {
            containerView.feedbacka(2);
            setNavigationColor(this.mContainerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sslReceivedErrorProcess(SslErrorHandler sslErrorHandler, boolean z3) {
        if (this.mSslErrorDialog == null) {
            String string = getString(R.string.color_runtime_sslverify_title);
            String string2 = getString(R.string.color_runtime_sslverify_msg);
            String string3 = getString(R.string.color_runtime_sslverify_continue);
            String string4 = getString(R.string.color_runtime_sslverify_cancel);
            feedbacko feedbackoVar = new feedbacko();
            feedbackn feedbacknVar = new feedbackn();
            feedbackm feedbackmVar = new feedbackm();
            DialogC0489f dialogC0489f = new DialogC0489f(this);
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(string)) {
                bundle.putString("TITLE", string);
            }
            if (!TextUtils.isEmpty(string2)) {
                bundle.putString("MESSAGE", string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                bundle.putString("POSITIVE", string3);
            }
            if (!TextUtils.isEmpty(string4)) {
                bundle.putString("NEGATIVE", string4);
            }
            dialogC0489f.f12596e = bundle;
            dialogC0489f.f12598g = feedbacknVar;
            dialogC0489f.f12597f = feedbackoVar;
            dialogC0489f.f12599h = feedbackmVar;
            this.mSslErrorDialog = dialogC0489f;
        }
        this.mSslErrorDialog.show();
        this.mSslErrorDialog.i(this.mIsNightMode);
        this.mSslErrorDialog.f(this);
    }

    private void switchDialogsDarkMode(boolean z3) {
        DialogC0489f dialogC0489f = this.mPrivacyBehaviorAgreeDialog;
        if (dialogC0489f != null) {
            dialogC0489f.i(z3);
        }
        DialogC0489f dialogC0489f2 = this.mSslErrorDialog;
        if (dialogC0489f2 != null) {
            dialogC0489f2.i(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void updateOnBackInvoked() {
        if (p.a()) {
            LogUtil.d(TAG, "updateOnBackInvoked mGoneNoticePageDirect: " + this.mGoneNoticePageDirect + "  noticeWebView: " + this.noticeWebView + "  isH5HomePage: " + this.isH5HomePage);
            if (this.mOnBackInvokedCallback == null) {
                this.mOnBackInvokedCallback = AbstractC0391b.a(new Runnable() { // from class: D0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedbackActivity.this.backEvent();
                    }
                });
            }
            if (this.mGoneNoticePageDirect) {
                AbstractC0391b.d(getOnBackInvokedDispatcher(), this.mOnBackInvokedCallback);
                return;
            }
            if (this.noticeWebView != null) {
                AbstractC0391b.c(getOnBackInvokedDispatcher(), 0, this.mOnBackInvokedCallback);
                return;
            }
            WebView webView = this.webView;
            String url = webView == null ? "" : webView.getUrl();
            if (TextUtils.isEmpty(url) || NATIVE_ERR_URL.equalsIgnoreCase(url) || !url.startsWith(INDEX_URL)) {
                AbstractC0391b.d(getOnBackInvokedDispatcher(), this.mOnBackInvokedCallback);
            } else if (this.isH5HomePage) {
                AbstractC0391b.d(getOnBackInvokedDispatcher(), this.mOnBackInvokedCallback);
            } else {
                AbstractC0391b.c(getOnBackInvokedDispatcher(), 0, this.mOnBackInvokedCallback);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(AbstractC0468c.a(context, AbstractC0468c.f()));
    }

    public void checkPermissions() {
        if (AbstractC0468c.k() && !com.customer.feedback.sdk.feedbacka.feedbackn) {
            LogUtil.d(TAG, "isExpVersion");
            init();
            return;
        }
        boolean z3 = com.customer.feedback.sdk.feedbacka.feedbackl;
        boolean z4 = com.customer.feedback.sdk.feedbacka.feedbackm;
        int i3 = 0;
        boolean b3 = l.b(this, "key_privacy_behavior_agree", false);
        LogUtil.d(TAG, "hasInternetPermission: " + z3 + ", hasImageAccessPermission: " + z4 + ", hasInnerAccess: " + b3);
        if ((z3 && z4) || b3) {
            init();
            return;
        }
        if (z3) {
            i3 = 2;
        } else if (z4) {
            i3 = 1;
        }
        requestPrivacyBehaviorAgreeDialog(i3);
    }

    public void dismissContainerView() {
        this.mContainerView.setVisibility(8);
    }

    public void enableStatusBarPadding(boolean z3) {
        ContainerView containerView = this.mNoticeContainerView;
        if (containerView != null && containerView.isShown()) {
            LogUtil.d(TAG, "NoticeContainerView enableStatusBarPadding");
            ContainerView containerView2 = this.mNoticeContainerView;
            if (z3 == containerView2.feedbackq || containerView2.feedbackj.getVisibility() == 0) {
                return;
            }
            containerView2.feedbackq = z3;
            containerView2.setPadding(containerView2.getPaddingStart(), containerView2.feedbackq ? AbstractC0468c.l(containerView2.getContext()) : 0, containerView2.getPaddingEnd(), containerView2.getPaddingBottom());
            return;
        }
        ContainerView containerView3 = this.mContainerView;
        if (containerView3 == null || !containerView3.isShown()) {
            return;
        }
        LogUtil.d(TAG, "ContainerView enableStatusBarPadding");
        ContainerView containerView4 = this.mContainerView;
        if (z3 == containerView4.feedbackq || containerView4.feedbackj.getVisibility() == 0) {
            return;
        }
        containerView4.feedbackq = z3;
        containerView4.setPadding(containerView4.getPaddingStart(), containerView4.feedbackq ? AbstractC0468c.l(containerView4.getContext()) : 0, containerView4.getPaddingEnd(), containerView4.getPaddingBottom());
    }

    public ContainerView getContainerView() {
        return this.mContainerView;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public WebView getNoticeWebView() {
        return this.noticeWebView;
    }

    public WebView getWebView() {
        return this.webView;
    }

    public boolean isGoNoticePageDirect() {
        return this.mGoneNoticePageDirect;
    }

    public boolean isLoadFailedState() {
        return this.loadFailedState;
    }

    public void jumpToNoticePage(String str) {
        Message obtain = Message.obtain();
        obtain.what = TO_NOTICE_PAGE;
        obtain.obj = str;
        this.handler.sendMessage(obtain);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i3 == 1) {
            if (this.mUploadMessage == null) {
                return;
            }
            this.mUploadMessage.onReceiveValue((intent == null || i4 != -1) ? null : intent.getData());
            this.mUploadMessage = null;
            return;
        }
        if (i3 == 2) {
            if (this.mFilePaths == null) {
                return;
            }
            this.mFilePaths.onReceiveValue((intent == null || i4 != -1 || intent.getData() == null) ? null : new Uri[]{intent.getData()});
            this.mFilePaths = null;
            return;
        }
        if (i3 != 3 || this.mNoticeFilePaths == null) {
            return;
        }
        this.mNoticeFilePaths.onReceiveValue((intent == null || i4 != -1 || intent.getData() == null) ? null : new Uri[]{intent.getData()});
        this.mNoticeFilePaths = null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        LogUtil.d(TAG, "onBackPressed");
        backEvent();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LogUtil("onConfigurationChanged");
        int i3 = com.customer.feedback.sdk.feedbacka.feedbacki;
        LogUtil.d("FbUtils", " isNightMode ,mode = " + i3);
        boolean e3 = i3 != 0 ? i3 != 1 ? AbstractC0493a.e(configuration) : false : true;
        if (this.mIsNightMode ^ e3) {
            DialogC0489f dialogC0489f = this.mPrivacyBehaviorAgreeDialog;
            if (dialogC0489f != null) {
                dialogC0489f.i(e3);
            }
            DialogC0489f dialogC0489f2 = this.mSslErrorDialog;
            if (dialogC0489f2 != null) {
                dialogC0489f2.i(e3);
            }
        }
        if (this.webView != null && e3 != this.mIsNightMode) {
            LogUtil.d(TAG, "javascript:setWebNightMode()");
            this.webView.evaluateJavascript("javascript:setWebNightMode()", null);
            setStatusBarAndNav(e3, null, this.mContainerView);
            this.mContainerView.feedbackc(e3);
            ContainerView containerView = this.mNoticeContainerView;
            if (containerView != null) {
                containerView.feedbackc(e3);
                setNavigationColor(this.mNoticeContainerView);
            } else {
                setNavigationColor(this.mContainerView);
            }
            this.mIsNightMode = e3;
            this.mContainer.setBackgroundColor(e3 ? this.darkBgColor : this.mLightColor);
            if (!isOnlineCustomer() || this.noticeWebView == null) {
                AbstractC0468c.h(this.mIsNightMode, this.noticeWebView);
            } else {
                changeDarkModel();
                this.noticeWebView.reload();
            }
        }
        DialogC0489f dialogC0489f3 = this.mPrivacyBehaviorAgreeDialog;
        if (dialogC0489f3 != null) {
            dialogC0489f3.f(this);
        }
        DialogC0489f dialogC0489f4 = this.mSslErrorDialog;
        if (dialogC0489f4 != null) {
            dialogC0489f4.f(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mApplicationContext = getApplicationContext();
        setScreenOrientationByConfig();
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(SYSTEM_FOLDING_MODE_KEYS), false, this.mFoldingScreenObserver);
        LogUtil("onCreate");
        this.mIsNightMode = AbstractC0468c.m();
        setContentView(R.layout.feedback_activity);
        this.mContainer = (FrameLayout) findViewById(R.id.container);
        this.mContainerView = (ContainerView) findViewById(R.id.containerview);
        this.mLightColor = getResources().getColor(R.color.feedback_background_color);
        setStatusBarAndNav(this.mIsNightMode, null, this.mContainerView);
        WebView.setWebContentsDebuggingEnabled(com.customer.feedback.sdk.feedbacka.f9390e);
        this.webView = this.mContainerView.getContentView();
        this.mContainerView.feedbackc(this.mIsNightMode);
        getWindow().getDecorView().setForceDarkAllowed(false);
        this.mContainer.setBackgroundColor(this.mIsNightMode ? -16777216 : this.mLightColor);
        this.mContainerView.setReloadListener(new View.OnClickListener() { // from class: D0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.lambda$onCreate$0(view);
            }
        });
        this.mContainerView.setBackClick(new View.OnClickListener() { // from class: D0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.lambda$onCreate$1(view);
            }
        });
        checkPermissions();
        AbstractC0468c.g(this, this.mContainerView, false);
        com.customer.feedback.sdk.feedbacka.f9392g = this.mOnTokenChangedListener;
        updateOnBackInvoked();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        LogUtil("onDestroy");
        super.onDestroy();
        cancelDialogs();
        HeaderInfoHelper.setAppCode(null);
        try {
            WebView webView = this.webView;
            if (webView != null) {
                webView.stopLoading();
                this.webView.setWebChromeClient(null);
                this.webView.setWebViewClient(null);
                this.webView.clearFormData();
                this.webView.clearHistory();
                this.webView.clearFocus();
                ContainerView containerView = this.mContainerView;
                containerView.removeView(containerView.feedbackh);
                this.webView.destroy();
                this.webView = null;
            }
            destroyNoticeView();
            destroyLeakReference();
        } catch (Exception e3) {
            LogUtil.e(TAG, "exceptionInfo：" + e3);
        }
        getContentResolver().unregisterContentObserver(this.mFoldingScreenObserver);
        com.customer.feedback.sdk.feedbacka.f9392g = null;
    }

    public void onHomePage(boolean z3) {
        this.isH5HomePage = z3;
        updateOnBackInvoked();
    }

    @Override // android.app.Activity
    public void onResume() {
        LogUtil.d(TAG, "onResume");
        super.onResume();
        boolean m3 = AbstractC0468c.m();
        this.mIsNightMode = m3;
        switchDialogsDarkMode(m3);
        boolean z3 = this.mIsNightMode;
        ContainerView containerView = this.mContainerView;
        if (containerView.feedbackp ^ z3) {
            containerView.feedbackc(z3);
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onSaveInstanceState(Bundle bundle) {
    }

    public void setGoNoticePageDirect(boolean z3) {
        this.mGoneNoticePageDirect = z3;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        super.setRequestedOrientation(i3);
    }

    public void setScreenOrientationByConfig() {
        com.customer.feedback.sdk.feedbacka feedbackb2 = com.customer.feedback.sdk.feedbacka.feedbackb(this.mApplicationContext);
        if (Settings.Global.getInt(getContentResolver(), SYSTEM_FOLDING_MODE_KEYS, 0) == 1) {
            setRequestedOrientation(feedbackb2.feedbacke);
        } else {
            setRequestedOrientation(feedbackb2.feedbackd);
        }
    }

    public void setStatusBarAndNav(boolean z3, ArrayList<Integer> arrayList, ContainerView containerView) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        this.darkBgColor = com.customer.feedback.sdk.feedbacka.feedbackb();
        if (arrayList == null || arrayList.size() != 4) {
            i3 = this.mLightColor;
            i4 = this.darkBgColor;
            i5 = i3;
            i6 = i4;
        } else {
            i3 = arrayList.get(0).intValue();
            i4 = arrayList.get(1).intValue();
            i5 = arrayList.get(2).intValue();
            i6 = arrayList.get(3).intValue();
        }
        LogUtil("setStatusBar");
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        if (z3) {
            i3 = i4;
        }
        if (!z3) {
            i6 = i5;
        }
        if (!AbstractC0468c.o(this) || Settings.System.getInt(getContentResolver(), "enable_launcher_taskbar", 0) == 1) {
            window.setNavigationBarColor(i6);
            i7 = 1280;
        } else {
            window.setNavigationBarColor(0);
            i7 = 5888;
        }
        window.setStatusBarColor(0);
        containerView.setBackgroundColor(i3);
        containerView.setNavigationBarBackground(i6);
        window.getDecorView().setSystemUiVisibility(z3 ? i7 & (-8193) : i7 | 8192);
    }

    public void setWebEvaluateJS(String str) {
        if (this.webView != null) {
            LogUtil("setWebEvaluateJS," + str);
            this.webView.evaluateJavascript(str, null);
        }
    }

    public void waitForToken() {
        LogUtil.e(TAG, "waiteForToken");
        this.mWaitForToken = true;
    }
}
