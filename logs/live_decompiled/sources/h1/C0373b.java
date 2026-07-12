package h1;

import a1.C0221a;
import i1.AbstractC0395b;

/* renamed from: h1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0373b implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11882a;

    /* renamed from: b, reason: collision with root package name */
    private final g1.m f11883b;

    /* renamed from: c, reason: collision with root package name */
    private final g1.f f11884c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f11885d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f11886e;

    public C0373b(String str, g1.m mVar, g1.f fVar, boolean z3, boolean z4) {
        this.f11882a = str;
        this.f11883b = mVar;
        this.f11884c = fVar;
        this.f11885d = z3;
        this.f11886e = z4;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.f(nVar, abstractC0395b, this);
    }

    public String b() {
        return this.f11882a;
    }

    public g1.m c() {
        return this.f11883b;
    }

    public g1.f d() {
        return this.f11884c;
    }

    public boolean e() {
        return this.f11886e;
    }

    public boolean f() {
        return this.f11885d;
    }
}
