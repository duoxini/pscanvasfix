package androidx.core.os;

import D2.k;
import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f4920a = new b();

    private b() {
    }

    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        k.e(bundle, "bundle");
        k.e(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
