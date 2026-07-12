package h1;

import a1.C0221a;
import android.graphics.Path;
import g1.C0365a;
import i1.AbstractC0395b;

/* renamed from: h1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0386o implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f11963a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f11964b;

    /* renamed from: c, reason: collision with root package name */
    private final String f11965c;

    /* renamed from: d, reason: collision with root package name */
    private final C0365a f11966d;

    /* renamed from: e, reason: collision with root package name */
    private final g1.d f11967e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f11968f;

    public C0386o(String str, boolean z3, Path.FillType fillType, C0365a c0365a, g1.d dVar, boolean z4) {
        this.f11965c = str;
        this.f11963a = z3;
        this.f11964b = fillType;
        this.f11966d = c0365a;
        this.f11967e = dVar;
        this.f11968f = z4;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.g(nVar, abstractC0395b, this);
    }

    public C0365a b() {
        return this.f11966d;
    }

    public Path.FillType c() {
        return this.f11964b;
    }

    public String d() {
        return this.f11965c;
    }

    public g1.d e() {
        return this.f11967e;
    }

    public boolean f() {
        return this.f11968f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f11963a + '}';
    }
}
