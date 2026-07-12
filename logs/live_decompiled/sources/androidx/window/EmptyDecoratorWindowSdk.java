package androidx.window;

import D2.k;

/* loaded from: classes.dex */
final class EmptyDecoratorWindowSdk implements WindowSdkExtensionsDecorator {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyDecoratorWindowSdk f6841a = new EmptyDecoratorWindowSdk();

    private EmptyDecoratorWindowSdk() {
    }

    @Override // androidx.window.WindowSdkExtensionsDecorator
    public WindowSdkExtensions a(WindowSdkExtensions windowSdkExtensions) {
        k.e(windowSdkExtensions, "windowSdkExtensions");
        return windowSdkExtensions;
    }
}
