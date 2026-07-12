package androidx.window.layout.adapter.extensions;

import C2.l;
import D2.j;
import D2.k;
import androidx.window.extensions.layout.WindowLayoutInfo;
import p2.q;

/* loaded from: classes.dex */
/* synthetic */ class ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1 extends j implements l {
    ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(Object obj) {
        super(1, obj, MulticastConsumer.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
    }

    @Override // C2.l
    public /* bridge */ /* synthetic */ Object f(Object obj) {
        i((WindowLayoutInfo) obj);
        return q.f12810a;
    }

    public final void i(WindowLayoutInfo windowLayoutInfo) {
        k.e(windowLayoutInfo, "p0");
        ((MulticastConsumer) this.f317f).accept(windowLayoutInfo);
    }
}
