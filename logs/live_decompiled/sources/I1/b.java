package I1;

import K1.f;
import K1.g;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Map f929a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String d(String str, String str2, NumberFormatException numberFormatException) {
        return "getLong key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    public long b(final String str, long j3) {
        final String str2 = (String) this.f929a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return j3;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e3) {
            f.f("MemoryPreference", new g() { // from class: I1.a
                @Override // K1.g
                public final Object get() {
                    String d3;
                    d3 = b.d(str, str2, e3);
                    return d3;
                }
            });
            return j3;
        }
    }

    public String c(String str, String str2) {
        String str3 = (String) this.f929a.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public void e(String str, long j3) {
        this.f929a.put(str, String.valueOf(j3));
    }

    public void f(String str, String str2) {
        this.f929a.put(str, str2);
    }
}
