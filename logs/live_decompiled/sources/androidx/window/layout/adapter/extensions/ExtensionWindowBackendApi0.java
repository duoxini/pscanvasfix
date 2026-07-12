package androidx.window.layout.adapter.extensions;

import D2.k;
import android.content.Context;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.concurrent.Executor;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class ExtensionWindowBackendApi0 implements WindowBackend {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(androidx.core.util.a aVar) {
        k.e(aVar, "$callback");
        aVar.accept(new WindowLayoutInfo(AbstractC0544n.j()));
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(androidx.core.util.a aVar) {
        k.e(aVar, "callback");
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, final androidx.core.util.a aVar) {
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        executor.execute(new Runnable() { // from class: androidx.window.layout.adapter.extensions.a
            @Override // java.lang.Runnable
            public final void run() {
                ExtensionWindowBackendApi0.d(androidx.core.util.a.this);
            }
        });
    }
}
