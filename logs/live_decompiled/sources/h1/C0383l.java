package h1;

import a1.C0221a;
import g1.C0366b;
import i1.AbstractC0395b;

/* renamed from: h1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0383l implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11953a;

    /* renamed from: b, reason: collision with root package name */
    private final C0366b f11954b;

    /* renamed from: c, reason: collision with root package name */
    private final C0366b f11955c;

    /* renamed from: d, reason: collision with root package name */
    private final g1.l f11956d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f11957e;

    public C0383l(String str, C0366b c0366b, C0366b c0366b2, g1.l lVar, boolean z3) {
        this.f11953a = str;
        this.f11954b = c0366b;
        this.f11955c = c0366b2;
        this.f11956d = lVar;
        this.f11957e = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.p(nVar, abstractC0395b, this);
    }

    public C0366b b() {
        return this.f11954b;
    }

    public String c() {
        return this.f11953a;
    }

    public C0366b d() {
        return this.f11955c;
    }

    public g1.l e() {
        return this.f11956d;
    }

    public boolean f() {
        return this.f11957e;
    }
}
