package h1;

import a1.C0221a;
import c1.u;
import g1.C0366b;
import i1.AbstractC0395b;

/* loaded from: classes.dex */
public class s implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11996a;

    /* renamed from: b, reason: collision with root package name */
    private final a f11997b;

    /* renamed from: c, reason: collision with root package name */
    private final C0366b f11998c;

    /* renamed from: d, reason: collision with root package name */
    private final C0366b f11999d;

    /* renamed from: e, reason: collision with root package name */
    private final C0366b f12000e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f12001f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a a(int i3) {
            if (i3 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i3 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i3);
        }
    }

    public s(String str, a aVar, C0366b c0366b, C0366b c0366b2, C0366b c0366b3, boolean z3) {
        this.f11996a = str;
        this.f11997b = aVar;
        this.f11998c = c0366b;
        this.f11999d = c0366b2;
        this.f12000e = c0366b3;
        this.f12001f = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new u(abstractC0395b, this);
    }

    public C0366b b() {
        return this.f11999d;
    }

    public String c() {
        return this.f11996a;
    }

    public C0366b d() {
        return this.f12000e;
    }

    public C0366b e() {
        return this.f11998c;
    }

    public a f() {
        return this.f11997b;
    }

    public boolean g() {
        return this.f12001f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f11998c + ", end: " + this.f11999d + ", offset: " + this.f12000e + "}";
    }
}
