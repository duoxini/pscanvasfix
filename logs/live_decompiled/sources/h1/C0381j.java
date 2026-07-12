package h1;

import a1.C0221a;
import g1.C0366b;
import i1.AbstractC0395b;

/* renamed from: h1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0381j implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11933a;

    /* renamed from: b, reason: collision with root package name */
    private final a f11934b;

    /* renamed from: c, reason: collision with root package name */
    private final C0366b f11935c;

    /* renamed from: d, reason: collision with root package name */
    private final g1.m f11936d;

    /* renamed from: e, reason: collision with root package name */
    private final C0366b f11937e;

    /* renamed from: f, reason: collision with root package name */
    private final C0366b f11938f;

    /* renamed from: g, reason: collision with root package name */
    private final C0366b f11939g;

    /* renamed from: h, reason: collision with root package name */
    private final C0366b f11940h;

    /* renamed from: i, reason: collision with root package name */
    private final C0366b f11941i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f11942j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f11943k;

    /* renamed from: h1.j$a */
    public enum a {
        STAR(1),
        POLYGON(2);


        /* renamed from: e, reason: collision with root package name */
        private final int f11947e;

        a(int i3) {
            this.f11947e = i3;
        }

        public static a a(int i3) {
            for (a aVar : values()) {
                if (aVar.f11947e == i3) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public C0381j(String str, a aVar, C0366b c0366b, g1.m mVar, C0366b c0366b2, C0366b c0366b3, C0366b c0366b4, C0366b c0366b5, C0366b c0366b6, boolean z3, boolean z4) {
        this.f11933a = str;
        this.f11934b = aVar;
        this.f11935c = c0366b;
        this.f11936d = mVar;
        this.f11937e = c0366b2;
        this.f11938f = c0366b3;
        this.f11939g = c0366b4;
        this.f11940h = c0366b5;
        this.f11941i = c0366b6;
        this.f11942j = z3;
        this.f11943k = z4;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.n(nVar, abstractC0395b, this);
    }

    public C0366b b() {
        return this.f11938f;
    }

    public C0366b c() {
        return this.f11940h;
    }

    public String d() {
        return this.f11933a;
    }

    public C0366b e() {
        return this.f11939g;
    }

    public C0366b f() {
        return this.f11941i;
    }

    public C0366b g() {
        return this.f11935c;
    }

    public g1.m h() {
        return this.f11936d;
    }

    public C0366b i() {
        return this.f11937e;
    }

    public a j() {
        return this.f11934b;
    }

    public boolean k() {
        return this.f11942j;
    }

    public boolean l() {
        return this.f11943k;
    }
}
