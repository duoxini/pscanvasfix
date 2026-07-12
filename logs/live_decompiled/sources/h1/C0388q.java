package h1;

import a1.C0221a;
import i1.AbstractC0395b;

/* renamed from: h1.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0388q implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11972a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11973b;

    /* renamed from: c, reason: collision with root package name */
    private final g1.h f11974c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f11975d;

    public C0388q(String str, int i3, g1.h hVar, boolean z3) {
        this.f11972a = str;
        this.f11973b = i3;
        this.f11974c = hVar;
        this.f11975d = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.r(nVar, abstractC0395b, this);
    }

    public String b() {
        return this.f11972a;
    }

    public g1.h c() {
        return this.f11974c;
    }

    public boolean d() {
        return this.f11975d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f11972a + ", index=" + this.f11973b + '}';
    }
}
