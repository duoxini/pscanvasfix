package androidx.window.layout;

import D2.k;
import D2.l;
import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackend;

/* loaded from: classes.dex */
final class WindowInfoTracker$Companion$extensionBackend$2 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    public static final WindowInfoTracker$Companion$extensionBackend$2 f7176e = new WindowInfoTracker$Companion$extensionBackend$2();

    WindowInfoTracker$Companion$extensionBackend$2() {
        super(0);
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final WindowBackend invoke() {
        boolean z3;
        String str;
        WindowLayoutComponent g3;
        try {
            ClassLoader classLoader = WindowInfoTracker.class.getClassLoader();
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = classLoader != null ? new SafeWindowLayoutComponentProvider(classLoader, new ConsumerAdapter(classLoader)) : null;
            if (safeWindowLayoutComponentProvider == null || (g3 = safeWindowLayoutComponentProvider.g()) == null) {
                return null;
            }
            ExtensionWindowBackend.Companion companion = ExtensionWindowBackend.f7203b;
            k.d(classLoader, "loader");
            return companion.a(g3, new ConsumerAdapter(classLoader));
        } catch (Throwable unused) {
            z3 = WindowInfoTracker.Companion.f7172b;
            if (!z3) {
                return null;
            }
            str = WindowInfoTracker.Companion.f7173c;
            Log.d(str, "Failed to load WindowExtensions");
            return null;
        }
    }
}
