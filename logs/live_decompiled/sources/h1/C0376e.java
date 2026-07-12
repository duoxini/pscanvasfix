package h1;

import a1.C0221a;
import android.graphics.Path;
import g1.C0366b;
import g1.C0367c;
import i1.AbstractC0395b;

/* renamed from: h1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0376e implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final EnumC0378g f11889a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f11890b;

    /* renamed from: c, reason: collision with root package name */
    private final C0367c f11891c;

    /* renamed from: d, reason: collision with root package name */
    private final g1.d f11892d;

    /* renamed from: e, reason: collision with root package name */
    private final g1.f f11893e;

    /* renamed from: f, reason: collision with root package name */
    private final g1.f f11894f;

    /* renamed from: g, reason: collision with root package name */
    private final String f11895g;

    /* renamed from: h, reason: collision with root package name */
    private final C0366b f11896h;

    /* renamed from: i, reason: collision with root package name */
    private final C0366b f11897i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f11898j;

    public C0376e(String str, EnumC0378g enumC0378g, Path.FillType fillType, C0367c c0367c, g1.d dVar, g1.f fVar, g1.f fVar2, C0366b c0366b, C0366b c0366b2, boolean z3) {
        this.f11889a = enumC0378g;
        this.f11890b = fillType;
        this.f11891c = c0367c;
        this.f11892d = dVar;
        this.f11893e = fVar;
        this.f11894f = fVar2;
        this.f11895g = str;
        this.f11896h = c0366b;
        this.f11897i = c0366b2;
        this.f11898j = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.h(nVar, c0221a, abstractC0395b, this);
    }

    public g1.f b() {
        return this.f11894f;
    }

    public Path.FillType c() {
        return this.f11890b;
    }

    public C0367c d() {
        return this.f11891c;
    }

    public EnumC0378g e() {
        return this.f11889a;
    }

    public String f() {
        return this.f11895g;
    }

    public g1.d g() {
        return this.f11892d;
    }

    public g1.f h() {
        return this.f11893e;
    }

    public boolean i() {
        return this.f11898j;
    }
}
