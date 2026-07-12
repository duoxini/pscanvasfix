package androidx.window.embedding;

import D2.k;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.reflection.ReflectionUtils;

/* loaded from: classes.dex */
public final class SafeActivityEmbeddingComponentProvider {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f7054a;

    /* renamed from: b, reason: collision with root package name */
    private final ConsumerAdapter f7055b;

    /* renamed from: c, reason: collision with root package name */
    private final WindowExtensions f7056c;

    /* renamed from: d, reason: collision with root package name */
    private final SafeWindowExtensionsProvider f7057d;

    public SafeActivityEmbeddingComponentProvider(ClassLoader classLoader, ConsumerAdapter consumerAdapter, WindowExtensions windowExtensions) {
        k.e(classLoader, "loader");
        k.e(consumerAdapter, "consumerAdapter");
        k.e(windowExtensions, "windowExtensions");
        this.f7054a = classLoader;
        this.f7055b = consumerAdapter;
        this.f7056c = windowExtensions;
        this.f7057d = new SafeWindowExtensionsProvider(classLoader);
    }

    private final boolean d() {
        if (!i()) {
            return false;
        }
        int a3 = ExtensionsUtil.f6956a.a();
        if (a3 == 1) {
            return g();
        }
        if (2 > a3 || a3 > Integer.MAX_VALUE) {
            return false;
        }
        return h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class f() {
        Class<?> loadClass = this.f7054a.loadClass("androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        k.d(loadClass, "loader.loadClass(ACTIVIT…MBEDDING_COMPONENT_CLASS)");
        return loadClass;
    }

    private final boolean j() {
        return ReflectionUtils.e("WindowExtensions#getActivityEmbeddingComponent is not valid", new SafeActivityEmbeddingComponentProvider$isActivityEmbeddingComponentValid$1(this));
    }

    private final boolean k() {
        return ReflectionUtils.e("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$isMethodClearSplitInfoCallbackValid$1(this));
    }

    private final boolean l() {
        return ReflectionUtils.e("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new SafeActivityEmbeddingComponentProvider$isMethodIsActivityEmbeddedValid$1(this));
    }

    private final boolean m() {
        return ReflectionUtils.e("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new SafeActivityEmbeddingComponentProvider$isMethodSetEmbeddingRulesValid$1(this));
    }

    private final boolean n() {
        return ReflectionUtils.e("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackJavaConsumerValid$1(this));
    }

    private final boolean o() {
        return ReflectionUtils.e("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackWindowConsumerValid$1(this));
    }

    private final boolean p() {
        return ReflectionUtils.e("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid", new SafeActivityEmbeddingComponentProvider$isMethodSplitAttributesCalculatorValid$1(this));
    }

    public final ActivityEmbeddingComponent e() {
        if (!d()) {
            return null;
        }
        try {
            return this.f7056c.getActivityEmbeddingComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final boolean g() {
        return m() && l() && n();
    }

    public final boolean h() {
        return g() && o() && k() && p();
    }

    public final boolean i() {
        return this.f7057d.f() && j();
    }
}
