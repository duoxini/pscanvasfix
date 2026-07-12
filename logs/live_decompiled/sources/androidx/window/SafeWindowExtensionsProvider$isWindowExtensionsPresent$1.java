package androidx.window;

import C2.a;
import D2.k;
import D2.l;

/* loaded from: classes.dex */
final class SafeWindowExtensionsProvider$isWindowExtensionsPresent$1 extends l implements a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeWindowExtensionsProvider f6848e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeWindowExtensionsProvider$isWindowExtensionsPresent$1(SafeWindowExtensionsProvider safeWindowExtensionsProvider) {
        super(0);
        this.f6848e = safeWindowExtensionsProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Class invoke() {
        ClassLoader classLoader;
        classLoader = this.f6848e.f6847a;
        Class<?> loadClass = classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        k.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return loadClass;
    }
}
