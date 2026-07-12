package androidx.window;

import D2.k;
import androidx.window.reflection.ReflectionUtils;

/* loaded from: classes.dex */
public final class SafeWindowExtensionsProvider {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f6847a;

    public SafeWindowExtensionsProvider(ClassLoader classLoader) {
        k.e(classLoader, "loader");
        this.f6847a = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class d() {
        Class<?> loadClass = this.f6847a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        k.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return loadClass;
    }

    private final boolean e() {
        return ReflectionUtils.f7266a.a(new SafeWindowExtensionsProvider$isWindowExtensionsPresent$1(this));
    }

    public final Class c() {
        Class<?> loadClass = this.f6847a.loadClass("androidx.window.extensions.WindowExtensions");
        k.d(loadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return loadClass;
    }

    public final boolean f() {
        return e() && ReflectionUtils.e("WindowExtensionsProvider#getWindowExtensions is not valid", new SafeWindowExtensionsProvider$isWindowExtensionsValid$1(this));
    }
}
