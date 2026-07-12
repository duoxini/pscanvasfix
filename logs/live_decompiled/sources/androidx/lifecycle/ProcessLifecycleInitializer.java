package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Q.a {
    @Override // Q.a
    public List a() {
        return Collections.emptyList();
    }

    @Override // Q.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o b(Context context) {
        if (!androidx.startup.a.e(context).g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        AbstractC0275k.a(context);
        w.i(context);
        return w.h();
    }
}
