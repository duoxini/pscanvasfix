package Q2;

import p2.AbstractC0501a;

/* loaded from: classes.dex */
public abstract class v {

    static final class a extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C2.l f2018e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f2019f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ t2.g f2020g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C2.l lVar, Object obj, t2.g gVar) {
            super(1);
            this.f2018e = lVar;
            this.f2019f = obj;
            this.f2020g = gVar;
        }

        public final void a(Throwable th) {
            v.b(this.f2018e, this.f2019f, this.f2020g);
        }

        @Override // C2.l
        public /* bridge */ /* synthetic */ Object f(Object obj) {
            a((Throwable) obj);
            return p2.q.f12810a;
        }
    }

    public static final C2.l a(C2.l lVar, Object obj, t2.g gVar) {
        return new a(lVar, obj, gVar);
    }

    public static final void b(C2.l lVar, Object obj, t2.g gVar) {
        M c3 = c(lVar, obj, null);
        if (c3 != null) {
            L2.C.a(gVar, c3);
        }
    }

    public static final M c(C2.l lVar, Object obj, M m3) {
        try {
            lVar.f(obj);
        } catch (Throwable th) {
            if (m3 == null || m3.getCause() == th) {
                return new M("Exception in undelivered element handler for " + obj, th);
            }
            AbstractC0501a.a(m3, th);
        }
        return m3;
    }

    public static /* synthetic */ M d(C2.l lVar, Object obj, M m3, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            m3 = null;
        }
        return c(lVar, obj, m3);
    }
}
