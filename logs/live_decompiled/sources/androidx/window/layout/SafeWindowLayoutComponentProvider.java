package androidx.window.layout;

import D2.k;
import android.app.Activity;
import android.content.Context;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.reflection.ReflectionUtils;

/* loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f7163a;

    /* renamed from: b, reason: collision with root package name */
    private final ConsumerAdapter f7164b;

    /* renamed from: c, reason: collision with root package name */
    private final SafeWindowExtensionsProvider f7165c;

    public SafeWindowLayoutComponentProvider(ClassLoader classLoader, ConsumerAdapter consumerAdapter) {
        k.e(classLoader, "loader");
        k.e(consumerAdapter, "consumerAdapter");
        this.f7163a = classLoader;
        this.f7164b = consumerAdapter;
        this.f7165c = new SafeWindowExtensionsProvider(classLoader);
    }

    private final boolean e() {
        if (!n()) {
            return false;
        }
        int a3 = ExtensionsUtil.f6956a.a();
        if (a3 == 1) {
            return i();
        }
        if (2 > a3 || a3 > Integer.MAX_VALUE) {
            return false;
        }
        return j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class f() {
        Class<?> loadClass = this.f7163a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        k.d(loadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
        return loadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class h() {
        Class<?> loadClass = this.f7163a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        k.d(loadClass, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
        return loadClass;
    }

    private final boolean k() {
        return ReflectionUtils.e("FoldingFeature class is not valid", new SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(this));
    }

    private final boolean l() {
        return ReflectionUtils.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerJavaConsumerValid$1(this));
    }

    private final boolean m() {
        return ReflectionUtils.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerWindowConsumerValid$1(this));
    }

    private final boolean o() {
        return ReflectionUtils.e("WindowExtensions#getWindowLayoutComponent is not valid", new SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(this));
    }

    public final WindowLayoutComponent g() {
        if (!e()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final boolean i() {
        return l();
    }

    public final boolean j() {
        return i() && m();
    }

    public final boolean n() {
        return this.f7165c.f() && o() && k();
    }
}
