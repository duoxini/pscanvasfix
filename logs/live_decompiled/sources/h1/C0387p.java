package h1;

import a1.C0221a;
import i1.AbstractC0395b;
import java.util.Arrays;
import java.util.List;

/* renamed from: h1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0387p implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11969a;

    /* renamed from: b, reason: collision with root package name */
    private final List f11970b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f11971c;

    public C0387p(String str, List list, boolean z3) {
        this.f11969a = str;
        this.f11970b = list;
        this.f11971c = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new c1.d(nVar, abstractC0395b, this, c0221a);
    }

    public List b() {
        return this.f11970b;
    }

    public String c() {
        return this.f11969a;
    }

    public boolean d() {
        return this.f11971c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f11969a + "' Shapes: " + Arrays.toString(this.f11970b.toArray()) + '}';
    }
}
