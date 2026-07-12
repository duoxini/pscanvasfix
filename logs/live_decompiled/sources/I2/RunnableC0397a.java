package i2;

import android.content.Context;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.util.LogUtil;
import j2.AbstractC0419i;
import j2.C0418h;
import java.io.File;
import m2.f;

/* renamed from: i2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0397a implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12125e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0418h f12126f;

    public RunnableC0397a(C0418h c0418h, String str) {
        this.f12125e = str;
        this.f12126f = c0418h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (new File(this.f12125e).length() <= 5242880) {
                Context context = feedbacka.feedbackf;
                LogUtil.d("FeedbackHelper", "start upload customerLog.");
                this.f12126f.a(AbstractC0419i.a(this.f12125e, false), f.f12446e);
            } else {
                Context context2 = feedbacka.feedbackf;
                LogUtil.d("FeedbackHelper", String.format("customerLog %.2fM is oversize 5M,can't upload.", Float.valueOf((r1 / 1024) / 1024.0f)));
            }
        } catch (Exception e3) {
            Context context3 = feedbacka.feedbackf;
            LogUtil.e("FeedbackHelper", "exceptionInfo:" + e3);
        }
    }
}
