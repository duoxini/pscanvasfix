package androidx.window.embedding;

import D2.g;
import D2.k;
import D2.s;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import p2.q;

/* loaded from: classes.dex */
public final class EmbeddingCompat implements EmbeddingInterfaceCompat {

    /* renamed from: e, reason: collision with root package name */
    public static final Companion f7024e = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final ActivityEmbeddingComponent f7025a;

    /* renamed from: b, reason: collision with root package name */
    private final EmbeddingAdapter f7026b;

    /* renamed from: c, reason: collision with root package name */
    private final ConsumerAdapter f7027c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f7028d;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final ActivityEmbeddingComponent c() {
            Object newProxyInstance = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new InvocationHandler() { // from class: androidx.window.embedding.b
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    q d3;
                    d3 = EmbeddingCompat.Companion.d(obj, method, objArr);
                    return d3;
                }
            });
            k.c(newProxyInstance, "null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
            return (ActivityEmbeddingComponent) newProxyInstance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final q d(Object obj, Method method, Object[] objArr) {
            return q.f12810a;
        }

        public final ActivityEmbeddingComponent b() {
            if (!e()) {
                return c();
            }
            ClassLoader classLoader = EmbeddingCompat.class.getClassLoader();
            if (classLoader != null) {
                ConsumerAdapter consumerAdapter = new ConsumerAdapter(classLoader);
                WindowExtensions windowExtensions = WindowExtensionsProvider.getWindowExtensions();
                k.d(windowExtensions, "getWindowExtensions()");
                ActivityEmbeddingComponent e3 = new SafeActivityEmbeddingComponentProvider(classLoader, consumerAdapter, windowExtensions).e();
                if (e3 != null) {
                    return e3;
                }
            }
            return c();
        }

        public final boolean e() {
            try {
                ClassLoader classLoader = EmbeddingCompat.class.getClassLoader();
                if (classLoader == null) {
                    return false;
                }
                ConsumerAdapter consumerAdapter = new ConsumerAdapter(classLoader);
                WindowExtensions windowExtensions = WindowExtensionsProvider.getWindowExtensions();
                k.d(windowExtensions, "getWindowExtensions()");
                return new SafeActivityEmbeddingComponentProvider(classLoader, consumerAdapter, windowExtensions).e() != null;
            } catch (NoClassDefFoundError unused) {
                Log.d("EmbeddingCompat", "Embedding extension version not found");
                return false;
            } catch (UnsupportedOperationException unused2) {
                Log.d("EmbeddingCompat", "Stub Extension");
                return false;
            }
        }

        private Companion() {
        }
    }

    public EmbeddingCompat(ActivityEmbeddingComponent activityEmbeddingComponent, EmbeddingAdapter embeddingAdapter, ConsumerAdapter consumerAdapter, Context context) {
        k.e(activityEmbeddingComponent, "embeddingExtension");
        k.e(embeddingAdapter, "adapter");
        k.e(consumerAdapter, "consumerAdapter");
        k.e(context, "applicationContext");
        this.f7025a = activityEmbeddingComponent;
        this.f7026b = embeddingAdapter;
        this.f7027c = consumerAdapter;
        this.f7028d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface, EmbeddingCompat embeddingCompat, List list) {
        k.e(embeddingCallbackInterface, "$embeddingCallback");
        k.e(embeddingCompat, "this$0");
        EmbeddingAdapter embeddingAdapter = embeddingCompat.f7026b;
        k.d(list, "splitInfoList");
        embeddingCallbackInterface.a(embeddingAdapter.d(list));
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public boolean a(Activity activity) {
        k.e(activity, "activity");
        return this.f7025a.isActivityEmbedded(activity);
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void b(final EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface) {
        k.e(embeddingCallbackInterface, "embeddingCallback");
        if (ExtensionsUtil.f6956a.a() < 2) {
            this.f7027c.a(this.f7025a, s.b(List.class), "setSplitInfoCallback", new EmbeddingCompat$setEmbeddingCallback$1(embeddingCallbackInterface, this));
        } else {
            this.f7025a.setSplitInfoCallback(new Consumer() { // from class: androidx.window.embedding.a
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj) {
                    EmbeddingCompat.e(EmbeddingInterfaceCompat.EmbeddingCallbackInterface.this, this, (List) obj);
                }
            });
        }
    }
}
