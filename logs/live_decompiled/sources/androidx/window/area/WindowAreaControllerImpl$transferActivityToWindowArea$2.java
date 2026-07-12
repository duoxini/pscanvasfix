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

@f(c = "androidx.window.area.WindowAreaControllerImpl$transferActivityToWindowArea$2", f = "WindowAreaControllerImpl.kt", l = {224}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowAreaControllerImpl$transferActivityToWindowArea$2 extends k implements p {

    /* renamed from: i, reason: collision with root package name */
    int f6900i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ WindowAreaControllerImpl f6901j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Activity f6902k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Executor f6903l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ WindowAreaSessionCallback f6904m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowAreaControllerImpl$transferActivityToWindowArea$2(WindowAreaControllerImpl windowAreaControllerImpl, Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f6901j = windowAreaControllerImpl;
        this.f6902k = activity;
        this.f6903l = executor;
        this.f6904m = windowAreaSessionCallback;
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        return new WindowAreaControllerImpl$transferActivityToWindowArea$2(this.f6901j, this.f6902k, this.f6903l, this.f6904m, interfaceC0593d);
    }

    @Override // C2.p
    public final Object invoke(D d3, InterfaceC0593d interfaceC0593d) {
        return ((WindowAreaControllerImpl$transferActivityToWindowArea$2) create(d3, interfaceC0593d)).invokeSuspend(q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        Object c3 = AbstractC0603b.c();
        int i3 = this.f6900i;
        if (i3 == 0) {
            l.b(obj);
            O2.c i4 = this.f6901j.i();
            this.f6900i = 1;
            if (O2.e.d(i4, this) == c3) {
                return c3;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.b(obj);
        }
        this.f6901j.k(this.f6902k, this.f6903l, this.f6904m);
        return q.f12810a;
    }
}
