package androidx.window.core;

import D2.s;
import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;

/* loaded from: classes.dex */
public final class ExtensionsUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ExtensionsUtil f6956a = new ExtensionsUtil();

    /* renamed from: b, reason: collision with root package name */
    private static final String f6957b = s.b(ExtensionsUtil.class).b();

    private ExtensionsUtil() {
    }

    public final int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (BuildConfig.f6942a.a() != VerificationMode.LOG) {
                return 0;
            }
            Log.d(f6957b, "Embedding extension version not found");
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (BuildConfig.f6942a.a() != VerificationMode.LOG) {
                return 0;
            }
            Log.d(f6957b, "Stub Extension");
            return 0;
        }
    }
}
