package j2;

import com.customer.feedback.sdk.util.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: j2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0415e implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0416f f12168e;

    public RunnableC0415e(C0416f c0416f) {
        this.f12168e = c0416f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                C0413c c0413c = (C0413c) this.f12168e.f12172c.take();
                synchronized (C0416f.f12169d) {
                    String str = c0413c.a() + "\n";
                    String str2 = this.f12168e.f12170a;
                    long j3 = c0413c.f12162a;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    AbstractC0414d.c(str, str2, simpleDateFormat.format(new Date(j3)));
                }
            } catch (InterruptedException e3) {
                LogUtil.e("FbLogUpdater", "exceptionInfo：" + e3);
            }
        }
    }
}
