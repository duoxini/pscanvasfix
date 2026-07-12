package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import androidx.window.layout.WindowLayoutInfo;

/* loaded from: classes.dex */
public interface ExtensionInterfaceCompat {

    public interface ExtensionCallbackInterface {
        void a(Activity activity, WindowLayoutInfo windowLayoutInfo);
    }

    void a(ExtensionCallbackInterface extensionCallbackInterface);

    void b(Activity activity);

    void c(Activity activity);
}
