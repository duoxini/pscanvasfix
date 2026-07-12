package androidx.window.area;

import C2.p;
import D2.l;
import N2.o;
import N2.s;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.extensions.core.util.function.Consumer;
import java.util.Collection;
import java.util.HashMap;
import p2.q;
import q2.AbstractC0544n;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;
import v2.f;
import v2.k;

@f(c = "androidx.window.area.WindowAreaControllerImpl$windowAreaInfos$1", f = "WindowAreaControllerImpl.kt", l = {94}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowAreaControllerImpl$windowAreaInfos$1 extends k implements p {

    /* renamed from: i, reason: collision with root package name */
    int f6905i;

    /* renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f6906j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ WindowAreaControllerImpl f6907k;

    /* renamed from: androidx.window.area.WindowAreaControllerImpl$windowAreaInfos$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends l implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WindowAreaControllerImpl f6908e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Consumer f6909f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Consumer f6910g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WindowAreaControllerImpl windowAreaControllerImpl, Consumer consumer, Consumer consumer2) {
            super(0);
            this.f6908e = windowAreaControllerImpl;
            this.f6909f = consumer;
            this.f6910g = consumer2;
        }

        public final void a() {
            WindowAreaComponent windowAreaComponent;
            int i3;
            WindowAreaComponent windowAreaComponent2;
            windowAreaComponent = this.f6908e.f6881a;
            windowAreaComponent.removeRearDisplayStatusListener(this.f6909f);
            i3 = this.f6908e.f6882b;
            if (i3 > 2) {
                windowAreaComponent2 = this.f6908e.f6881a;
                windowAreaComponent2.removeRearDisplayPresentationStatusListener(this.f6910g);
            }
        }

        @Override // C2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q.f12810a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowAreaControllerImpl$windowAreaInfos$1(WindowAreaControllerImpl windowAreaControllerImpl, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f6907k = windowAreaControllerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WindowAreaControllerImpl windowAreaControllerImpl, N2.q qVar, Integer num) {
        HashMap hashMap;
        D2.k.d(num, "status");
        windowAreaControllerImpl.m(num.intValue());
        s r3 = qVar.r();
        hashMap = windowAreaControllerImpl.f6886f;
        Collection values = hashMap.values();
        D2.k.d(values, "currentWindowAreaInfoMap.values");
        r3.f(AbstractC0544n.C(values));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WindowAreaControllerImpl windowAreaControllerImpl, N2.q qVar, ExtensionWindowAreaStatus extensionWindowAreaStatus) {
        HashMap hashMap;
        D2.k.d(extensionWindowAreaStatus, "extensionWindowAreaStatus");
        windowAreaControllerImpl.n(extensionWindowAreaStatus);
        s r3 = qVar.r();
        hashMap = windowAreaControllerImpl.f6886f;
        Collection values = hashMap.values();
        D2.k.d(values, "currentWindowAreaInfoMap.values");
        r3.f(AbstractC0544n.C(values));
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        WindowAreaControllerImpl$windowAreaInfos$1 windowAreaControllerImpl$windowAreaInfos$1 = new WindowAreaControllerImpl$windowAreaInfos$1(this.f6907k, interfaceC0593d);
        windowAreaControllerImpl$windowAreaInfos$1.f6906j = obj;
        return windowAreaControllerImpl$windowAreaInfos$1;
    }

    @Override // C2.p
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Object invoke(N2.q qVar, InterfaceC0593d interfaceC0593d) {
        return ((WindowAreaControllerImpl$windowAreaInfos$1) create(qVar, interfaceC0593d)).invokeSuspend(q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        WindowAreaComponent windowAreaComponent;
        int i3;
        WindowAreaComponent windowAreaComponent2;
        Object c3 = AbstractC0603b.c();
        int i4 = this.f6905i;
        if (i4 == 0) {
            p2.l.b(obj);
            final N2.q qVar = (N2.q) this.f6906j;
            final WindowAreaControllerImpl windowAreaControllerImpl = this.f6907k;
            Consumer consumer = new Consumer() { // from class: androidx.window.area.d
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj2) {
                    WindowAreaControllerImpl$windowAreaInfos$1.g(WindowAreaControllerImpl.this, qVar, (Integer) obj2);
                }
            };
            final WindowAreaControllerImpl windowAreaControllerImpl2 = this.f6907k;
            Consumer consumer2 = new Consumer() { // from class: androidx.window.area.e
                @Override // androidx.window.extensions.core.util.function.Consumer
                public final void accept(Object obj2) {
                    WindowAreaControllerImpl$windowAreaInfos$1.h(WindowAreaControllerImpl.this, qVar, (ExtensionWindowAreaStatus) obj2);
                }
            };
            windowAreaComponent = this.f6907k.f6881a;
            windowAreaComponent.addRearDisplayStatusListener(consumer);
            i3 = this.f6907k.f6882b;
            if (i3 > 2) {
                windowAreaComponent2 = this.f6907k.f6881a;
                windowAreaComponent2.addRearDisplayPresentationStatusListener(consumer2);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6907k, consumer, consumer2);
            this.f6905i = 1;
            if (o.a(qVar, anonymousClass1, this) == c3) {
                return c3;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p2.l.b(obj);
        }
        return q.f12810a;
    }
}
