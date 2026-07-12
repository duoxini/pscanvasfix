package androidx.window.area.utils;

import D2.k;
import android.util.DisplayMetrics;
import com.customer.feedback.sdk.model.RequestData;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p2.q;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class DeviceUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final DeviceUtils f6933a = new DeviceUtils();

    /* renamed from: b, reason: collision with root package name */
    private static final List f6934b;

    static {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.widthPixels = 1080;
        displayMetrics.heightPixels = 2092;
        displayMetrics.density = 2.625f;
        displayMetrics.densityDpi = 420;
        q qVar = q.f12810a;
        f6934b = AbstractC0544n.d(new DeviceMetrics("google", "pixel fold", displayMetrics));
    }

    private DeviceUtils() {
    }

    public final DisplayMetrics a(String str, String str2) {
        Object obj;
        k.e(str, "manufacturer");
        k.e(str2, RequestData.TYPE_MODEL);
        Iterator it = f6934b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            DeviceMetrics deviceMetrics = (DeviceMetrics) obj;
            String a3 = deviceMetrics.a();
            Locale locale = Locale.US;
            k.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (k.a(a3, lowerCase)) {
                String b3 = deviceMetrics.b();
                k.d(locale, "US");
                String lowerCase2 = str2.toLowerCase(locale);
                k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (k.a(b3, lowerCase2)) {
                    break;
                }
            }
        }
        DeviceMetrics deviceMetrics2 = (DeviceMetrics) obj;
        if (deviceMetrics2 != null) {
            return deviceMetrics2.c();
        }
        return null;
    }
}
