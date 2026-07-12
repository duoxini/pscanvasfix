package androidx.window.area;

import C2.p;
import L2.D;
import android.app.Activity;
import java.util.concurrent.Executor;
import p2.l;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;
import v2.f;
import v2.k;

@f(c = "androidx.window.area.WindowAreaControllerImpl$presentContentOnWindowArea$2", f = "WindowAreaControllerImpl.kt", l = {252}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowAreaControllerImpl$presentContentOnWindowArea$2 extends k implements p {

    /* renamed from: i, reason: collision with root package name */
    int f6895i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ WindowAreaControllerImpl f6896j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Activity f6897k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Executor f6898l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ WindowAreaPresentationSessionCallback f6899m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowAreaControllerImpl$presentContentOnWindowArea$2(WindowAreaControllerImpl windowAreaControllerImpl, Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f6896j = windowAreaControllerImpl;
        this.f6897k = activity;
        this.f6898l = executor;
        this.f6899m = windowAreaPresentationSessionCallback;
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        return new WindowAreaControllerImpl$presentContentOnWindowArea$2(this.f6896j, this.f6897k, this.f6898l, this.f6899m, interfaceC0593d);
    }

    @Override // C2.p
    public final Object invoke(D d3, InterfaceC0593d interfaceC0593d) {
        return ((WindowAreaControllerImpl$presentContentOnWindowArea$2) create(d3, interfaceC0593d)).invokeSuspend(q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        Object c3 = AbstractC0603b.c();
        int i3 = this.f6895i;
        if (i3 == 0) {
            l.b(obj);
            O2.c i4 = this.f6896j.i();
            this.f6895i = 1;
            if (O2.e.d(i4, this) == c3) {
                return c3;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.b(obj);
        }
        this.f6896j.l(this.f6897k, this.f6898l, this.f6899m);
        return q.f12810a;
    }
}
