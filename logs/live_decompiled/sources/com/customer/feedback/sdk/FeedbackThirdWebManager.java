package com.customer.feedback.sdk;

import com.customer.feedback.sdk.util.LogUtil;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class FeedbackThirdWebManager {
    private static final String TAG = "FeedbackThirdWebManager";
    private static volatile FeedbackThirdWebManager sInstance;
    private Class mTargetClass;

    public static FeedbackThirdWebManager getInstance() {
        if (sInstance == null) {
            synchronized (FeedbackThirdWebManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new FeedbackThirdWebManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public String getThirdWebInterfaceName() {
        Class cls = this.mTargetClass;
        if (cls != null) {
            try {
                Object invoke = cls.getMethod("getInterfaceName", null).invoke(null, null);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (IllegalAccessException e3) {
                LogUtil.e(TAG, "IllegalAccessException in getThirdWebInterfaceName:" + e3.getMessage());
            } catch (NoSuchMethodException e4) {
                LogUtil.e(TAG, "NoSuchMethodException in getThirdWebInterfaceName:" + e4.getMessage());
            } catch (InvocationTargetException e5) {
                LogUtil.e(TAG, "InvocationTargetException in getThirdWebInterfaceName:" + e5.getMessage());
            }
        }
        return "feedbackInterface";
    }

    public String invoke(String str) {
        Class cls = this.mTargetClass;
        if (cls != null) {
            try {
                Object invoke = cls.getMethod(str, null).invoke(null, null);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (IllegalAccessException e3) {
                LogUtil.e(TAG, "IllegalAccessException in invoke:" + e3.getMessage());
            } catch (NoSuchMethodException e4) {
                LogUtil.e(TAG, "NoSuchMethodException in invoke:" + e4.getMessage());
            } catch (InvocationTargetException e5) {
                LogUtil.e(TAG, "InvocationTargetException in invoke:" + e5.getMessage());
            }
        }
        return "";
    }

    public String invokeWithParams(String str, String str2) {
        Class cls = this.mTargetClass;
        if (cls != null) {
            try {
                Object invoke = cls.getMethod(str, String.class).invoke(null, str2);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (IllegalAccessException e3) {
                LogUtil.e(TAG, "IllegalAccessException in invokeWithParams:" + e3.getMessage());
            } catch (NoSuchMethodException e4) {
                LogUtil.e(TAG, "NoSuchMethodException in invokeWithParams:" + e4.getMessage());
            } catch (InvocationTargetException e5) {
                LogUtil.e(TAG, "InvocationTargetException in invokeWithParams:" + e5.getMessage());
            }
        }
        return "";
    }

    public <T> void setTargetClass(Class<T> cls) {
        this.mTargetClass = cls;
    }
}
