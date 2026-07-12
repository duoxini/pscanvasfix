package f1;

import a1.C0221a;
import m.C0455e;

/* renamed from: f1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0355c {

    /* renamed from: b, reason: collision with root package name */
    private static final C0355c f11570b = new C0355c();

    /* renamed from: a, reason: collision with root package name */
    private final C0455e f11571a = new C0455e(20);

    C0355c() {
    }

    public static C0355c b() {
        return f11570b;
    }

    public C0221a a(String str) {
        if (str == null) {
            return null;
        }
        return (C0221a) this.f11571a.c(str);
    }

    public void c(String str, C0221a c0221a) {
        if (str == null) {
            return;
        }
        this.f11571a.d(str, c0221a);
    }
}
