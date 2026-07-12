package h1;

import a1.C0221a;
import i1.AbstractC0395b;
import m1.AbstractC0462e;

/* renamed from: h1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0380i implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11924a;

    /* renamed from: b, reason: collision with root package name */
    private final a f11925b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f11926c;

    /* renamed from: h1.i$a */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a a(int i3) {
            return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public C0380i(String str, a aVar, boolean z3) {
        this.f11924a = str;
        this.f11925b = aVar;
        this.f11926c = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        if (nVar.A()) {
            return new c1.l(this);
        }
        AbstractC0462e.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.f11925b;
    }

    public String c() {
        return this.f11924a;
    }

    public boolean d() {
        return this.f11926c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f11925b + '}';
    }
}
