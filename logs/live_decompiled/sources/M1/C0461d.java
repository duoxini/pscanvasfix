package m1;

import a1.s;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* renamed from: m1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0461d implements s {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f12418a = new HashSet();

    @Override // a1.s
    public void a(String str) {
        e(str, null);
    }

    @Override // a1.s
    public void b(String str, Throwable th) {
        Set set = f12418a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOG_Effective", str, th);
        set.add(str);
    }

    @Override // a1.s
    public void c(String str) {
        b(str, null);
    }

    @Override // a1.s
    public void d(String str, Throwable th) {
    }

    public void e(String str, Throwable th) {
    }
}
