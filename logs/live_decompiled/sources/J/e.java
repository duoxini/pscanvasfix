package J;

import N.h;

/* loaded from: classes.dex */
public final class e implements h.c {

    /* renamed from: a, reason: collision with root package name */
    private final h.c f975a;

    /* renamed from: b, reason: collision with root package name */
    private final C0165c f976b;

    public e(h.c cVar, C0165c c0165c) {
        D2.k.e(cVar, "delegate");
        D2.k.e(c0165c, "autoCloser");
        this.f975a = cVar;
        this.f976b = c0165c;
    }

    @Override // N.h.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d a(h.b bVar) {
        D2.k.e(bVar, "configuration");
        return new d(this.f975a.a(bVar), this.f976b);
    }
}
