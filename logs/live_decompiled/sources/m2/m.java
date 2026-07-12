package m2;

import android.webkit.JavascriptInterface;
import com.customer.feedback.sdk.FeedbackThirdWebManager;
import com.customer.feedback.sdk.util.LogUtil;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public final class m {
    @JavascriptInterface
    public final String invoke(String str) {
        D2.k.e(str, Constants.MessagerConstants.METHOD_KEY);
        LogUtil.d("ThirdWebJsInterface", "invoke ->method:" + str);
        String invoke = FeedbackThirdWebManager.getInstance().invoke(str);
        D2.k.d(invoke, "getInstance().invoke(method)");
        return invoke;
    }

    @JavascriptInterface
    public final String invokeWithParams(String str, String str2) {
        D2.k.e(str, Constants.MessagerConstants.METHOD_KEY);
        D2.k.e(str2, "params");
        LogUtil.d("ThirdWebJsInterface", "invokeWithParams ->method:" + str + ";params:" + str2);
        String invokeWithParams = FeedbackThirdWebManager.getInstance().invokeWithParams(str, str2);
        D2.k.d(invokeWithParams, "getInstance().invokeWithParams(method, params)");
        return invokeWithParams;
    }
}
