package androidx.window.layout.adapter.extensions;

import D2.g;
import D2.k;
import android.content.Context;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ExtensionWindowBackend implements WindowBackend {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f7203b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final WindowBackend f7204a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WindowBackend a(WindowLayoutComponent windowLayoutComponent, ConsumerAdapter consumerAdapter) {
            k.e(windowLayoutComponent, "component");
            k.e(consumerAdapter, "adapter");
            int a3 = ExtensionsUtil.f6956a.a();
            return a3 >= 2 ? new ExtensionWindowBackendApi2(windowLayoutComponent) : a3 == 1 ? new ExtensionWindowBackendApi1(windowLayoutComponent, consumerAdapter) : new ExtensionWindowBackendApi0();
        }

        private Companion() {
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(androidx.core.util.a aVar) {
        k.e(aVar, "callback");
        this.f7204a.a(aVar);
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, androidx.core.util.a aVar) {
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        this.f7204a.b(context, executor, aVar);
    }
}
