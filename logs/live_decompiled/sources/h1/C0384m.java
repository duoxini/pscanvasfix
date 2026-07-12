package h1;

import a1.C0221a;
import i1.AbstractC0395b;

/* renamed from: h1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0384m implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11958a;

    /* renamed from: b, reason: collision with root package name */
    private final g1.m f11959b;

    public C0384m(String str, g1.m mVar) {
        this.f11958a = str;
        this.f11959b = mVar;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.q(nVar, abstractC0395b, this);
    }

    public g1.m b() {
        return this.f11959b;
    }

    public String c() {
        return this.f11958a;
    }
}
