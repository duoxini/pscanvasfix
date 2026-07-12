package L2;

/* renamed from: L2.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0187t {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1303a;

    /* renamed from: b, reason: collision with root package name */
    public final C2.l f1304b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1305c;

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f1306d;

    public C0187t(Object obj, AbstractC0176h abstractC0176h, C2.l lVar, Object obj2, Throwable th) {
        this.f1303a = obj;
        this.f1304b = lVar;
        this.f1305c = obj2;
        this.f1306d = th;
    }

    public static /* synthetic */ C0187t b(C0187t c0187t, Object obj, AbstractC0176h abstractC0176h, C2.l lVar, Object obj2, Throwable th, int i3, Object obj3) {
        if ((i3 & 1) != 0) {
            obj = c0187t.f1303a;
        }
        if ((i3 & 2) != 0) {
            c0187t.getClass();
            abstractC0176h = null;
        }
        AbstractC0176h abstractC0176h2 = abstractC0176h;
        if ((i3 & 4) != 0) {
            lVar = c0187t.f1304b;
        }
        C2.l lVar2 = lVar;
        if ((i3 & 8) != 0) {
            obj2 = c0187t.f1305c;
        }
        Object obj4 = obj2;
        if ((i3 & 16) != 0) {
            th = c0187t.f1306d;
        }
        return c0187t.a(obj, abstractC0176h2, lVar2, obj4, th);
    }

    public final C0187t a(Object obj, AbstractC0176h abstractC0176h, C2.l lVar, Object obj2, Throwable th) {
        return new C0187t(obj, abstractC0176h, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f1306d != null;
    }

    public final void d(C0179k c0179k, Throwable th) {
        C2.l lVar = this.f1304b;
        if (lVar != null) {
            c0179k.j(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0187t)) {
            return false;
        }
        C0187t c0187t = (C0187t) obj;
        return D2.k.a(this.f1303a, c0187t.f1303a) && D2.k.a(null, null) && D2.k.a(this.f1304b, c0187t.f1304b) && D2.k.a(this.f1305c, c0187t.f1305c) && D2.k.a(this.f1306d, c0187t.f1306d);
    }

    public int hashCode() {
        Object obj = this.f1303a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 961;
        C2.l lVar = this.f1304b;
        int hashCode2 = (hashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f1305c;
        int hashCode3 = (hashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f1306d;
        return hashCode3 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f1303a + ", cancelHandler=" + ((Object) null) + ", onCancellation=" + this.f1304b + ", idempotentResume=" + this.f1305c + ", cancelCause=" + this.f1306d + ')';
    }

    public /* synthetic */ C0187t(Object obj, AbstractC0176h abstractC0176h, C2.l lVar, Object obj2, Throwable th, int i3, D2.g gVar) {
        this(obj, (i3 & 2) != 0 ? null : abstractC0176h, (i3 & 4) != 0 ? null : lVar, (i3 & 8) != 0 ? null : obj2, (i3 & 16) != 0 ? null : th);
    }
}
