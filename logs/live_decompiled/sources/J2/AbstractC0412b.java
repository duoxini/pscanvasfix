package j2;

import android.text.TextUtils;
import com.customer.feedback.sdk.util.LogUtil;

/* renamed from: j2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0412b {
    public static void a(String str) {
        C0416f c0416f = C0416f.f12169d;
        synchronized (c0416f) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (str.endsWith("/")) {
                        c0416f.f12170a = str;
                    } else {
                        c0416f.f12170a = str.concat("/");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str, int i3) {
        int lastIndexOf;
        int i4;
        String str2 = "";
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace != null && stackTrace.length > 1 && (str2 = stackTrace[1].getClassName()) != null && (lastIndexOf = str2.lastIndexOf(46)) > -1 && (i4 = lastIndexOf + 1) < str2.length()) {
            str2 = str2.substring(i4);
        }
        C0413c c0413c = new C0413c(System.currentTimeMillis(), i3, str2, str);
        C0416f c0416f = C0416f.f12169d;
        if (c0416f.f12170a == null) {
            LogUtil.e("FbLogUpdater", "log saved path is null.");
            return;
        }
        if (c0416f.f12171b == null) {
            synchronized (c0416f) {
                try {
                    if (c0416f.f12171b == null) {
                        Thread thread = new Thread(new RunnableC0415e(c0416f));
                        c0416f.f12171b = thread;
                        thread.setDaemon(true);
                        c0416f.f12171b.start();
                    }
                } finally {
                }
            }
        }
        try {
            c0416f.f12172c.put(c0413c);
        } catch (InterruptedException e3) {
            LogUtil.e("FbLogUpdater", "exceptionInfo：" + e3);
        }
    }
}
