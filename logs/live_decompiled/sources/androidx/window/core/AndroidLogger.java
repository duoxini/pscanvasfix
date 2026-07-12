package androidx.window.core;

import D2.k;
import android.util.Log;

/* loaded from: classes.dex */
public final class AndroidLogger implements Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidLogger f6937a = new AndroidLogger();

    private AndroidLogger() {
    }

    @Override // androidx.window.core.Logger
    public void a(String str, String str2) {
        k.e(str, "tag");
        k.e(str2, "message");
        Log.d(str, str2);
    }
}
