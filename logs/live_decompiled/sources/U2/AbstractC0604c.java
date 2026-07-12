package u2;

import C2.p;
import D2.k;
import D2.u;
import p2.l;
import t2.InterfaceC0593d;
import t2.g;
import v2.AbstractC0610a;
import v2.h;
import v2.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: u2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0604c {

    /* renamed from: u2.c$a */
    public static final class a extends j {

        /* renamed from: f, reason: collision with root package name */
        private int f13841f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f13842g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f13843h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0593d interfaceC0593d, p pVar, Object obj) {
            super(interfaceC0593d);
            this.f13842g = pVar;
            this.f13843h = obj;
            k.c(interfaceC0593d, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // v2.AbstractC0610a
        protected Object invokeSuspend(Object obj) {
            int i3 = this.f13841f;
            if (i3 == 0) {
                this.f13841f = 1;
                l.b(obj);
                k.c(this.f13842g, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u.a(this.f13842g, 2)).invoke(this.f13843h, this);
            }
            if (i3 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f13841f = 2;
            l.b(obj);
            return obj;
        }
    }

    /* renamed from: u2.c$b */
    public static final class b extends v2.d {

        /* renamed from: h, reason: collision with root package name */
        private int f13844h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f13845i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object f13846j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC0593d interfaceC0593d, g gVar, p pVar, Object obj) {
            super(interfaceC0593d, gVar);
            this.f13845i = pVar;
            this.f13846j = obj;
            k.c(interfaceC0593d, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // v2.AbstractC0610a
        protected Object invokeSuspend(Object obj) {
            int i3 = this.f13844h;
            if (i3 == 0) {
                this.f13844h = 1;
                l.b(obj);
                k.c(this.f13845i, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u.a(this.f13845i, 2)).invoke(this.f13846j, this);
            }
            if (i3 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f13844h = 2;
            l.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC0593d a(p pVar, Object obj, InterfaceC0593d interfaceC0593d) {
        k.e(pVar, "<this>");
        k.e(interfaceC0593d, "completion");
        InterfaceC0593d a3 = h.a(interfaceC0593d);
        if (pVar instanceof AbstractC0610a) {
            return ((AbstractC0610a) pVar).create(obj, a3);
        }
        g context = a3.getContext();
        return context == t2.h.f13692e ? new a(a3, pVar, obj) : new b(a3, context, pVar, obj);
    }

    public static InterfaceC0593d b(InterfaceC0593d interfaceC0593d) {
        InterfaceC0593d intercepted;
        k.e(interfaceC0593d, "<this>");
        v2.d dVar = interfaceC0593d instanceof v2.d ? (v2.d) interfaceC0593d : null;
        return (dVar == null || (intercepted = dVar.intercepted()) == null) ? interfaceC0593d : intercepted;
    }
}
