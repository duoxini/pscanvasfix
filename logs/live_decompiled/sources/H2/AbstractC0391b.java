package h2;

import D2.k;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* renamed from: h2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0391b {
    public static final OnBackInvokedCallback a(final Runnable runnable) {
        k.e(runnable, "runnable");
        return new OnBackInvokedCallback() { // from class: h2.a
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                AbstractC0391b.b(runnable);
            }
        };
    }

    public static final void b(Runnable runnable) {
        k.e(runnable, "$runnable");
        runnable.run();
    }

    public static final void c(Object obj, int i3, Object obj2) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = obj instanceof OnBackInvokedDispatcher ? (OnBackInvokedDispatcher) obj : null;
        OnBackInvokedCallback onBackInvokedCallback = obj2 instanceof OnBackInvokedCallback ? (OnBackInvokedCallback) obj2 : null;
        if (onBackInvokedCallback == null || onBackInvokedDispatcher == null) {
            return;
        }
        onBackInvokedDispatcher.registerOnBackInvokedCallback(i3, onBackInvokedCallback);
    }

    public static final void d(Object obj, Object obj2) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = obj instanceof OnBackInvokedDispatcher ? (OnBackInvokedDispatcher) obj : null;
        OnBackInvokedCallback onBackInvokedCallback = obj2 instanceof OnBackInvokedCallback ? (OnBackInvokedCallback) obj2 : null;
        if (onBackInvokedCallback == null || onBackInvokedDispatcher == null) {
            return;
        }
        onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
    }
}
