package androidx.window;

import D2.g;
import androidx.window.core.ExtensionsUtil;

/* loaded from: classes.dex */
public abstract class WindowSdkExtensions {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f6851b = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static WindowSdkExtensionsDecorator f6852c = EmptyDecoratorWindowSdk.f6841a;

    /* renamed from: a, reason: collision with root package name */
    private final int f6853a = ExtensionsUtil.f6956a.a();

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WindowSdkExtensions a() {
            return WindowSdkExtensions.f6852c.a(new WindowSdkExtensions() { // from class: androidx.window.WindowSdkExtensions$Companion$getInstance$1
            });
        }

        private Companion() {
        }
    }

    public int b() {
        return this.f6853a;
    }
}
