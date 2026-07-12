package h1;

import a1.C0221a;
import g1.C0366b;
import g1.C0367c;
import h1.C0389r;
import i1.AbstractC0395b;
import java.util.List;

/* renamed from: h1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0377f implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11899a;

    /* renamed from: b, reason: collision with root package name */
    private final EnumC0378g f11900b;

    /* renamed from: c, reason: collision with root package name */
    private final C0367c f11901c;

    /* renamed from: d, reason: collision with root package name */
    private final g1.d f11902d;

    /* renamed from: e, reason: collision with root package name */
    private final g1.f f11903e;

    /* renamed from: f, reason: collision with root package name */
    private final g1.f f11904f;

    /* renamed from: g, reason: collision with root package name */
    private final C0366b f11905g;

    /* renamed from: h, reason: collision with root package name */
    private final C0389r.b f11906h;

    /* renamed from: i, reason: collision with root package name */
    private final C0389r.c f11907i;

    /* renamed from: j, reason: collision with root package name */
    private final float f11908j;

    /* renamed from: k, reason: collision with root package name */
    private final List f11909k;

    /* renamed from: l, reason: collision with root package name */
    private final C0366b f11910l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f11911m;

    public C0377f(String str, EnumC0378g enumC0378g, C0367c c0367c, g1.d dVar, g1.f fVar, g1.f fVar2, C0366b c0366b, C0389r.b bVar, C0389r.c cVar, float f3, List list, C0366b c0366b2, boolean z3) {
        this.f11899a = str;
        this.f11900b = enumC0378g;
        this.f11901c = c0367c;
        this.f11902d = dVar;
        this.f11903e = fVar;
        this.f11904f = fVar2;
        this.f11905g = c0366b;
        this.f11906h = bVar;
        this.f11907i = cVar;
        this.f11908j = f3;
        this.f11909k = list;
        this.f11910l = c0366b2;
        this.f11911m = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.i(nVar, abstractC0395b, this);
    }

    public C0389r.b b() {
        return this.f11906h;
    }

    public C0366b c() {
        return this.f11910l;
    }

    public g1.f d() {
        return this.f11904f;
    }

    public C0367c e() {
        return this.f11901c;
    }

    public EnumC0378g f() {
        return this.f11900b;
    }

    public C0389r.c g() {
        return this.f11907i;
    }

    public List h() {
        return this.f11909k;
    }

    public float i() {
        return this.f11908j;
    }

    public String j() {
        return this.f11899a;
    }

    public g1.d k() {
        return this.f11902d;
    }

    public g1.f l() {
        return this.f11903e;
    }

    public C0366b m() {
        return this.f11905g;
    }

    public boolean n() {
        return this.f11911m;
    }
}
