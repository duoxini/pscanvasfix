package q1;

import p1.AbstractC0497b;
import p1.C0500e;
import r1.C0566a;
import r1.C0567b;
import r1.C0568c;

/* renamed from: q1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0517b {

    /* renamed from: a, reason: collision with root package name */
    private C0516a f13027a;

    /* renamed from: b, reason: collision with root package name */
    private C0567b f13028b;

    /* renamed from: c, reason: collision with root package name */
    private int f13029c;

    /* renamed from: d, reason: collision with root package name */
    private int f13030d;

    /* renamed from: e, reason: collision with root package name */
    private final C0500e f13031e;

    public C0517b() {
        this(new C0500e());
    }

    private void e() {
        for (C0516a c0516a = this.f13027a; c0516a != null; c0516a = c0516a.f13012k) {
            AbstractC0497b.c("world has body ====>>> " + c0516a);
        }
    }

    private void g(float f3) {
        for (C0516a c0516a = this.f13027a; c0516a != null; c0516a = c0516a.f13012k) {
            c0516a.f13025x = false;
        }
        for (C0567b c0567b = this.f13028b; c0567b != null; c0567b = c0567b.f13217b) {
            c0567b.f13220e = false;
        }
        for (C0516a c0516a2 = this.f13027a; c0516a2 != null; c0516a2 = c0516a2.f13012k) {
            if (!c0516a2.f13025x && c0516a2.f13014m && c0516a2.g() != 0) {
                h(c0516a2, f3);
                c0516a2.f13025x = true;
                c0516a2.f13007f.f();
            }
        }
    }

    private void h(C0516a c0516a, float f3) {
        c0516a.v();
        c0516a.f13006e.a(c0516a.f13007f.b(c0516a.f13020s).b(f3));
        c0516a.f13006e.b(1.0f / ((c0516a.f13021t * f3) + 1.0f));
        for (C0566a c0566a = c0516a.f13013l; c0566a != null; c0566a = c0566a.f13215d) {
            C0567b c0567b = c0566a.f13213b;
            if (!c0567b.f13220e) {
                c0567b.f13220e = true;
                C0516a c0516a2 = c0566a.f13212a;
                if (!c0516a2.f13025x && c0516a2.f13014m) {
                    c0567b.d(c0516a, f3);
                    for (int i3 = 0; i3 < 4; i3++) {
                        c0566a.f13213b.h(c0516a);
                    }
                }
            }
        }
        C0500e c0500e = c0516a.f13004c;
        float f4 = c0500e.f12799a;
        C0500e c0500e2 = c0516a.f13006e;
        c0500e.f12799a = f4 + (c0500e2.f12799a * f3);
        c0500e.f12800b += f3 * c0500e2.f12800b;
        c0516a.u();
    }

    public C0516a a(C0500e c0500e, int i3, int i4, float f3, float f4, String str) {
        C0516a c0516a = new C0516a(c0500e, i3, i4, f3, f4);
        c0516a.s(str);
        c0516a.f13011j = null;
        C0516a c0516a2 = this.f13027a;
        c0516a.f13012k = c0516a2;
        if (c0516a2 != null) {
            c0516a2.f13011j = c0516a;
        }
        this.f13027a = c0516a;
        this.f13029c++;
        if (AbstractC0497b.b()) {
            e();
        }
        return c0516a;
    }

    public C0567b b(C0568c c0568c) {
        C0567b a3 = C0567b.a(this, c0568c);
        if (a3 == null) {
            return null;
        }
        a3.f13216a = null;
        C0567b c0567b = this.f13028b;
        a3.f13217b = c0567b;
        if (c0567b != null) {
            c0567b.f13216a = a3;
        }
        this.f13028b = a3;
        this.f13030d++;
        C0566a c0566a = a3.f13218c;
        c0566a.f13213b = a3;
        c0566a.f13212a = a3.c();
        C0566a c0566a2 = a3.f13218c;
        c0566a2.f13214c = null;
        c0566a2.f13215d = a3.b().f13013l;
        if (a3.b().f13013l != null) {
            a3.b().f13013l.f13214c = a3.f13218c;
        }
        a3.b().f13013l = a3.f13218c;
        C0566a c0566a3 = a3.f13219d;
        c0566a3.f13213b = a3;
        c0566a3.f13212a = a3.b();
        C0566a c0566a4 = a3.f13219d;
        c0566a4.f13214c = null;
        c0566a4.f13215d = a3.c().f13013l;
        if (a3.c().f13013l != null) {
            a3.c().f13013l.f13214c = a3.f13219d;
        }
        a3.c().f13013l = a3.f13219d;
        return a3;
    }

    public void c(C0516a c0516a) {
        if (this.f13029c <= 0) {
            return;
        }
        C0566a c0566a = c0516a.f13013l;
        while (c0566a != null) {
            C0566a c0566a2 = c0566a.f13215d;
            C0567b c0567b = c0566a.f13213b;
            if (c0567b != null) {
                d(c0567b);
            }
            c0516a.f13013l = c0566a2;
            c0566a = c0566a2;
        }
        c0516a.f13013l = null;
        C0516a c0516a2 = c0516a.f13011j;
        if (c0516a2 != null) {
            c0516a2.f13012k = c0516a.f13012k;
        }
        C0516a c0516a3 = c0516a.f13012k;
        if (c0516a3 != null) {
            c0516a3.f13011j = c0516a2;
        }
        if (c0516a == this.f13027a) {
            this.f13027a = c0516a3;
        }
        this.f13029c--;
    }

    public void d(C0567b c0567b) {
        if (this.f13030d <= 0) {
            return;
        }
        C0567b c0567b2 = c0567b.f13216a;
        if (c0567b2 != null) {
            c0567b2.f13217b = c0567b.f13217b;
        }
        C0567b c0567b3 = c0567b.f13217b;
        if (c0567b3 != null) {
            c0567b3.f13216a = c0567b2;
        }
        if (c0567b == this.f13028b) {
            this.f13028b = c0567b3;
        }
        C0516a b3 = c0567b.b();
        C0516a c3 = c0567b.c();
        C0566a c0566a = c0567b.f13218c;
        C0566a c0566a2 = c0566a.f13214c;
        if (c0566a2 != null) {
            c0566a2.f13215d = c0566a.f13215d;
        }
        C0566a c0566a3 = c0566a.f13215d;
        if (c0566a3 != null) {
            c0566a3.f13214c = c0566a2;
        }
        if (c0566a == b3.f13013l) {
            b3.f13013l = c0566a3;
        }
        c0566a.f13214c = null;
        c0566a.f13215d = null;
        C0566a c0566a4 = c0567b.f13219d;
        C0566a c0566a5 = c0566a4.f13214c;
        if (c0566a5 != null) {
            c0566a5.f13215d = c0566a4.f13215d;
        }
        C0566a c0566a6 = c0566a4.f13215d;
        if (c0566a6 != null) {
            c0566a6.f13214c = c0566a5;
        }
        if (c0566a4 == c3.f13013l) {
            c3.f13013l = c0566a6;
        }
        c0566a4.f13214c = null;
        c0566a4.f13215d = null;
        this.f13030d--;
    }

    public C0500e f() {
        return this.f13031e;
    }

    public void i(float f3) {
        g(f3);
    }

    public C0517b(C0500e c0500e) {
        this.f13031e = c0500e;
        this.f13027a = null;
        this.f13028b = null;
        this.f13029c = 0;
        this.f13030d = 0;
    }
}
