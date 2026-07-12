package androidx.window.embedding;

import C2.p;
import D2.l;
import N2.o;
import android.app.Activity;
import java.util.List;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;
import v2.f;
import v2.k;

@f(c = "androidx.window.embedding.SplitController$splitInfoList$1", f = "SplitController.kt", l = {64}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SplitController$splitInfoList$1 extends k implements p {

    /* renamed from: i, reason: collision with root package name */
    int f7099i;

    /* renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f7100j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ SplitController f7101k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Activity f7102l;

    /* renamed from: androidx.window.embedding.SplitController$splitInfoList$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends l implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SplitController f7103e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.core.util.a f7104f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SplitController splitController, androidx.core.util.a aVar) {
            super(0);
            this.f7103e = splitController;
            this.f7104f = aVar;
        }

        public final void a() {
            EmbeddingBackend embeddingBackend;
            embeddingBackend = this.f7103e.f7093a;
            embeddingBackend.b(this.f7104f);
        }

        @Override // C2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return q.f12810a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplitController$splitInfoList$1(SplitController splitController, Activity activity, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f7101k = splitController;
        this.f7102l = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(N2.q qVar, List list) {
        qVar.f(list);
    }

    @Override // C2.p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object invoke(N2.q qVar, InterfaceC0593d interfaceC0593d) {
        return ((SplitController$splitInfoList$1) create(qVar, interfaceC0593d)).invokeSuspend(q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        SplitController$splitInfoList$1 splitController$splitInfoList$1 = new SplitController$splitInfoList$1(this.f7101k, this.f7102l, interfaceC0593d);
        splitController$splitInfoList$1.f7100j = obj;
        return splitController$splitInfoList$1;
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        EmbeddingBackend embeddingBackend;
        Object c3 = AbstractC0603b.c();
        int i3 = this.f7099i;
        if (i3 == 0) {
            p2.l.b(obj);
            final N2.q qVar = (N2.q) this.f7100j;
            androidx.core.util.a aVar = new androidx.core.util.a() { // from class: androidx.window.embedding.d
                @Override // androidx.core.util.a
                public final void accept(Object obj2) {
                    SplitController$splitInfoList$1.d(N2.q.this, (List) obj2);
                }
            };
            embeddingBackend = this.f7101k.f7093a;
            embeddingBackend.c(this.f7102l, new e(), aVar);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f7101k, aVar);
            this.f7099i = 1;
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
