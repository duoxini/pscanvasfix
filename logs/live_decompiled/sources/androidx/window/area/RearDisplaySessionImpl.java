package androidx.window.area;

import D2.k;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.area.WindowAreaComponent;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class RearDisplaySessionImpl implements WindowAreaSession {

    /* renamed from: a, reason: collision with root package name */
    private final WindowAreaComponent f6858a;

    public RearDisplaySessionImpl(WindowAreaComponent windowAreaComponent) {
        k.e(windowAreaComponent, "windowAreaComponent");
        this.f6858a = windowAreaComponent;
    }
}
