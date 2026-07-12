package androidx.window.layout;

import C2.p;
import D2.l;
import N2.o;
import android.app.Activity;
import androidx.window.embedding.e;
import androidx.window.layout.adapter.WindowBackend;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;
import v2.f;
import v2.k;

@f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2", f = "WindowInfoTrackerImpl.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$2 extends k implements p {

    /* renamed from: i, reason: collision with root package name */
    int f7185i;

    /* renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f7186j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ WindowInfoTrackerImpl f7187k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Activity f7188l;

    /* renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2$2, reason: invalid class name */
    static final class AnonymousClass2 extends l implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WindowInfoTrackerImpl f7189e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.core.util.a f7190f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WindowInfoTrackerImpl windowInfoTrackerImpl, androidx.core.util.a aVar) {
            super(0);
            this.f7189e = windowInfoTrackerImpl;
            this.f7190f = aVar;
        }

        public final void a() {
            WindowBackend windowBackend;
            windowBackend = this.f7189e.f7178c;
            windowBackend.a(this.f7190f);
        }

        @Override // C2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q.f12810a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerImpl$windowLayoutInfo$2(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f7187k = windowInfoTrackerImpl;
        this.f7188l = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(N2.q qVar, WindowLayoutInfo windowLayoutInfo) {
        qVar.f(windowLayoutInfo);
    }

    @Override // C2.p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object invoke(N2.q qVar, InterfaceC0593d interfaceC0593d) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$2) create(qVar, interfaceC0593d)).invokeSuspend(q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        WindowInfoTrackerImpl$windowLayoutInfo$2 windowInfoTrackerImpl$windowLayoutInfo$2 = new WindowInfoTrackerImpl$windowLayoutInfo$2(this.f7187k, this.f7188l, interfaceC0593d);
        windowInfoTrackerImpl$windowLayoutInfo$2.f7186j = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$2;
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        WindowBackend windowBackend;
        Object c3 = AbstractC0603b.c();
        int i3 = this.f7185i;
        if (i3 == 0) {
            p2.l.b(obj);
            final N2.q qVar = (N2.q) this.f7186j;
            androidx.core.util.a aVar = new androidx.core.util.a() { // from class: androidx.window.layout.b
                @Override // androidx.core.util.a
                public final void accept(Object obj2) {
                    WindowInfoTrackerImpl$windowLayoutInfo$2.d(N2.q.this, (WindowLayoutInfo) obj2);
                }
            };
            windowBackend = this.f7187k.f7178c;
            windowBackend.b(this.f7188l, new e(), aVar);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f7187k, aVar);
            this.f7185i = 1;
            if (o.a(qVar, anonymousClass2, this) == c3) {
                return c3;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p2.l.b(obj);
        }
        return q.f12810a;
    }
}
