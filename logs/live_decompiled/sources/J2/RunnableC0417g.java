package j2;

import android.text.TextUtils;
import com.customer.feedback.sdk.util.LogUtil;
import java.io.File;

/* renamed from: j2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0417g implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12173e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0418h f12174f;

    public RunnableC0417g(C0418h c0418h, String str) {
        this.f12174f = c0418h;
        this.f12173e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b3;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            C0416f c0416f = C0416f.f12169d;
            c0416f.getClass();
            synchronized (c0416f) {
                try {
                    String str = c0416f.f12170a;
                    b3 = str != null ? AbstractC0414d.b(str, currentTimeMillis) : "";
                } finally {
                }
            }
            if (TextUtils.isEmpty(b3)) {
                LogUtil.d("feedbackc.feedbackh", "file is not exists");
                return;
            }
            File file = new File(b3);
            float length = file.length() / 1024.0f;
            if (file.exists() && length != 0.0f) {
                LogUtil.d("feedbackc.feedbackh", "file upload size is " + length);
                byte[] a3 = this.f12174f.a(b3, this.f12173e);
                file.delete();
                if (a3 == null) {
                    LogUtil.d("feedbackc.feedbackh", "buf after return  = null");
                    return;
                } else {
                    LogUtil.d("feedbackc.feedbackh", "upload log return json = ".concat(new String(a3, "UTF-8")));
                    return;
                }
            }
            LogUtil.d("feedbackc.feedbackh", "file is not exists or file hasn't content!");
        } catch (Exception unused) {
            LogUtil.e("feedbackc.feedbackh", "startUpload Exception");
        }
    }
}
