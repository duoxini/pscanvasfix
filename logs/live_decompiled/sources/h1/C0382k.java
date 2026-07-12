package h1;

import a1.C0221a;
import g1.C0366b;
import i1.AbstractC0395b;

/* renamed from: h1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0382k implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11948a;

    /* renamed from: b, reason: collision with root package name */
    private final g1.m f11949b;

    /* renamed from: c, reason: collision with root package name */
    private final g1.m f11950c;

    /* renamed from: d, reason: collision with root package name */
    private final C0366b f11951d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f11952e;

    public C0382k(String str, g1.m mVar, g1.m mVar2, C0366b c0366b, boolean z3) {
        this.f11948a = str;
        this.f11949b = mVar;
        this.f11950c = mVar2;
        this.f11951d = c0366b;
        this.f11952e = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.o(nVar, abstractC0395b, this);
    }

    public C0366b b() {
        return this.f11951d;
    }

    public String c() {
        return this.f11948a;
    }

    public g1.m d() {
        return this.f11949b;
    }

    public g1.m e() {
        return this.f11950c;
    }

    public boolean f() {
        return this.f11952e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f11949b + ", size=" + this.f11950c + '}';
    }
}
