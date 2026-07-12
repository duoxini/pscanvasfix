package com.customer.feedback.sdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import com.customer.feedback.sdk.FeedbackHelper;
import com.customer.feedback.sdk.log.CustomerLogCallback;
import com.customer.feedback.sdk.util.HeaderInfoHelper;
import com.customer.feedback.sdk.util.LogUtil;
import j2.AbstractC0412b;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import m2.n;

/* loaded from: classes.dex */
public final class feedbacka {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9386a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f9387b = "";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9388c = false;
    public static Context feedbackf = null;
    public static String feedbackg = "";
    public static String feedbackh = "";
    public static int feedbacki = 2;
    public static volatile feedbacka feedbackj = null;
    public static String feedbackk = "";
    public static boolean feedbackl = true;
    public static boolean feedbackm = true;
    public static boolean feedbackn = false;
    public static int feedbacko = 0;
    public static String feedbackp = "";
    public static String feedbackq = "";
    public static String feedbackr = "";
    public static Context feedbacks = null;
    public static CustomerLogCallback feedbackt = null;
    public static boolean feedbackv = false;
    public static boolean feedbackw = true;
    public static int feedbackx = -1;
    public static int feedbacky = -1;
    public static boolean feedbackz = false;

    /* renamed from: g, reason: collision with root package name */
    public static feedbacke f9392g;
    public final String feedbacka;
    public SoftReference<feedbackd> feedbackb;
    public SoftReference<feedbackc> feedbackc;
    public int feedbackd = 3;
    public int feedbacke = 2;
    public static final float[] feedbacku = {0.0f, 0.0f, 0.0f};

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f9389d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f9390e = false;

    /* renamed from: f, reason: collision with root package name */
    public static FeedbackHelper.RequestMadeCallback f9391f = null;

    /* renamed from: com.customer.feedback.sdk.feedbacka$feedbacka, reason: collision with other inner class name */
    public class RunnableC0117feedbacka implements Runnable {
        public final /* synthetic */ Context feedbacka;

        public RunnableC0117feedbacka(Context context) {
            this.feedbacka = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = feedbacka.feedbackf;
            LogUtil.d("FeedbackHelper", "set LogPath");
            File file = new File(this.feedbacka.getFilesDir(), Environment.DIRECTORY_DOCUMENTS);
            if (!file.exists()) {
                file.mkdirs();
            }
            AbstractC0412b.a(file.getPath() + "/Oplus/Feedback/FbLog/" + feedbacka.this.feedbacka);
        }
    }

    public interface feedbackb<T> {
        void onResult(boolean z3, String str, T t3);
    }

    public interface feedbackc {
        void feedbacka(boolean z3);
    }

    public interface feedbackd {
        void returnNetworkStatus(boolean z3);
    }

    public interface feedbacke {
    }

    public feedbacka(Context context) {
        this.feedbacka = "";
        Context feedbacka = feedbacka(context);
        feedbackf = feedbacka;
        this.feedbacka = HeaderInfoHelper.getAppCode(feedbacka);
        feedbackc(feedbackf);
    }

    public static Context feedbacka(Context context) {
        return context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    public static feedbacka feedbackb(Context context) {
        if (feedbackj == null) {
            synchronized (feedbacka.class) {
                try {
                    if (feedbackj == null) {
                        feedbackj = new feedbacka(context);
                    }
                } finally {
                }
            }
        }
        return feedbackj;
    }

    public final void feedbackc(Context context) {
        n.f12458a.execute(new RunnableC0117feedbacka(context));
    }

    public static void feedbacka(Context context, boolean z3, String str, String str2) {
        if (str == null) {
            str = HeaderInfoHelper.getAppCode(context.getApplicationContext());
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getApplicationContext().getPackageName(), "com.customer.feedback.sdk.activity.FeedbackActivity"));
        intent.setAction("com.customer.feedback.START");
        intent.putExtra("AppCode", str);
        intent.putExtra("redirect_to_feedback", z3);
        intent.putExtra("target_page", str2);
        intent.putExtra("intent_app_version", HeaderInfoHelper.getAppVersion(context.getApplicationContext()));
        if (context instanceof Activity) {
            intent.setFlags(536870912);
            LogUtil.d("FeedbackHelper", " setFlag ,context instanceof activity");
        } else {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static int feedbackb() {
        float[] fArr = feedbacku;
        return Color.argb(1.0f, fArr[0], fArr[1], fArr[2]);
    }

    public static String feedbacka() {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 33; i3++) {
            sb.append((char) ("osswt=((dofs)hwwh)dhj(dofs(o2(q5(".charAt(i3) ^ 7));
        }
        return sb.toString();
    }
}
