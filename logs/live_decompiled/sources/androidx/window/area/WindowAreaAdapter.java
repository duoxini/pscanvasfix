package androidx.window.area;

import androidx.window.area.WindowAreaCapability;
import androidx.window.core.ExperimentalWindowApi;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class WindowAreaAdapter {

    /* renamed from: a, reason: collision with root package name */
    public static final WindowAreaAdapter f6862a = new WindowAreaAdapter();

    private WindowAreaAdapter() {
    }

    public final WindowAreaCapability.Status a(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? WindowAreaCapability.Status.f6871d : WindowAreaCapability.Status.f6874g : WindowAreaCapability.Status.f6873f : WindowAreaCapability.Status.f6872e : WindowAreaCapability.Status.f6871d;
    }
}
