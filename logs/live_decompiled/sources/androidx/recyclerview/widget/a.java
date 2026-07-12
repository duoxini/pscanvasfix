package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class a implements j.a {

    /* renamed from: a, reason: collision with root package name */
    private androidx.core.util.e f6454a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f6455b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f6456c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0093a f6457d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f6458e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f6459f;

    /* renamed from: g, reason: collision with root package name */
    final j f6460g;

    /* renamed from: h, reason: collision with root package name */
    private int f6461h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0093a {
        void a(int i3, int i4);

        void b(b bVar);

        RecyclerView.E c(int i3);

        void d(int i3, int i4);

        void e(int i3, int i4);

        void f(b bVar);

        void g(int i3, int i4);

        void h(int i3, int i4, Object obj);
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        int f6462a;

        /* renamed from: b, reason: collision with root package name */
        int f6463b;

        /* renamed from: c, reason: collision with root package name */
        Object f6464c;

        /* renamed from: d, reason: collision with root package name */
        int f6465d;

        b(int i3, int i4, int i5, Object obj) {
            this.f6462a = i3;
            this.f6463b = i4;
            this.f6465d = i5;
            this.f6464c = obj;
        }

        String a() {
            int i3 = this.f6462a;
            return i3 != 1 ? i3 != 2 ? i3 != 4 ? i3 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i3 = this.f6462a;
            if (i3 != bVar.f6462a) {
                return false;
            }
            if (i3 == 8 && Math.abs(this.f6465d - this.f6463b) == 1 && this.f6465d == bVar.f6463b && this.f6463b == bVar.f6465d) {
                return true;
            }
            if (this.f6465d != bVar.f6465d || this.f6463b != bVar.f6463b) {
                return false;
            }
            Object obj2 = this.f6464c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f6464c)) {
                    return false;
                }
            } else if (bVar.f6464c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f6462a * 31) + this.f6463b) * 31) + this.f6465d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f6463b + "c:" + this.f6465d + ",p:" + this.f6464c + "]";
        }
    }

    a(InterfaceC0093a interfaceC0093a) {
        this(interfaceC0093a, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z3;
        char c3;
        int i3 = bVar.f6463b;
        int i4 = bVar.f6465d + i3;
        char c4 = 65535;
        int i5 = i3;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f6457d.c(i5) != null || h(i5)) {
                if (c4 == 0) {
                    k(b(2, i3, i6, null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                c3 = 1;
            } else {
                if (c4 == 1) {
                    v(b(2, i3, i6, null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                c3 = 0;
            }
            if (z3) {
                i5 -= i6;
                i4 -= i6;
                i6 = 1;
            } else {
                i6++;
            }
            i5++;
            c4 = c3;
        }
        if (i6 != bVar.f6465d) {
            a(bVar);
            bVar = b(2, i3, i6, null);
        }
        if (c4 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i3 = bVar.f6463b;
        int i4 = bVar.f6465d + i3;
        int i5 = 0;
        boolean z3 = -1;
        int i6 = i3;
        while (i3 < i4) {
            if (this.f6457d.c(i3) != null || h(i3)) {
                if (!z3) {
                    k(b(4, i6, i5, bVar.f6464c));
                    i6 = i3;
                    i5 = 0;
                }
                z3 = true;
            } else {
                if (z3) {
                    v(b(4, i6, i5, bVar.f6464c));
                    i6 = i3;
                    i5 = 0;
                }
                z3 = false;
            }
            i5++;
            i3++;
        }
        if (i5 != bVar.f6465d) {
            Object obj = bVar.f6464c;
            a(bVar);
            bVar = b(4, i6, i5, obj);
        }
        if (z3) {
            v(bVar);
        } else {
            k(bVar);
        }
    }

    private boolean h(int i3) {
        int size = this.f6456c.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) this.f6456c.get(i4);
            int i5 = bVar.f6462a;
            if (i5 == 8) {
                if (n(bVar.f6465d, i4 + 1) == i3) {
                    return true;
                }
            } else if (i5 == 1) {
                int i6 = bVar.f6463b;
                int i7 = bVar.f6465d + i6;
                while (i6 < i7) {
                    if (n(i6, i4 + 1) == i3) {
                        return true;
                    }
                    i6++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i3;
        int i4 = bVar.f6462a;
        if (i4 == 1 || i4 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z3 = z(bVar.f6463b, i4);
        int i5 = bVar.f6463b;
        int i6 = bVar.f6462a;
        if (i6 == 2) {
            i3 = 0;
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i3 = 1;
        }
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.f6465d; i8++) {
            int z4 = z(bVar.f6463b + (i3 * i8), bVar.f6462a);
            int i9 = bVar.f6462a;
            if (i9 == 2 ? z4 != z3 : !(i9 == 4 && z4 == z3 + 1)) {
                b b3 = b(i9, z3, i7, bVar.f6464c);
                l(b3, i5);
                a(b3);
                if (bVar.f6462a == 4) {
                    i5 += i7;
                }
                i7 = 1;
                z3 = z4;
            } else {
                i7++;
            }
        }
        Object obj = bVar.f6464c;
        a(bVar);
        if (i7 > 0) {
            b b4 = b(bVar.f6462a, z3, i7, obj);
            l(b4, i5);
            a(b4);
        }
    }

    private void v(b bVar) {
        this.f6456c.add(bVar);
        int i3 = bVar.f6462a;
        if (i3 == 1) {
            this.f6457d.g(bVar.f6463b, bVar.f6465d);
            return;
        }
        if (i3 == 2) {
            this.f6457d.e(bVar.f6463b, bVar.f6465d);
            return;
        }
        if (i3 == 4) {
            this.f6457d.h(bVar.f6463b, bVar.f6465d, bVar.f6464c);
        } else {
            if (i3 == 8) {
                this.f6457d.a(bVar.f6463b, bVar.f6465d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i3, int i4) {
        int i5;
        int i6;
        for (int size = this.f6456c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f6456c.get(size);
            int i7 = bVar.f6462a;
            if (i7 == 8) {
                int i8 = bVar.f6463b;
                int i9 = bVar.f6465d;
                if (i8 < i9) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                if (i3 < i6 || i3 > i5) {
                    if (i3 < i8) {
                        if (i4 == 1) {
                            bVar.f6463b = i8 + 1;
                            bVar.f6465d = i9 + 1;
                        } else if (i4 == 2) {
                            bVar.f6463b = i8 - 1;
                            bVar.f6465d = i9 - 1;
                        }
                    }
                } else if (i6 == i8) {
                    if (i4 == 1) {
                        bVar.f6465d = i9 + 1;
                    } else if (i4 == 2) {
                        bVar.f6465d = i9 - 1;
                    }
                    i3++;
                } else {
                    if (i4 == 1) {
                        bVar.f6463b = i8 + 1;
                    } else if (i4 == 2) {
                        bVar.f6463b = i8 - 1;
                    }
                    i3--;
                }
            } else {
                int i10 = bVar.f6463b;
                if (i10 <= i3) {
                    if (i7 == 1) {
                        i3 -= bVar.f6465d;
                    } else if (i7 == 2) {
                        i3 += bVar.f6465d;
                    }
                } else if (i4 == 1) {
                    bVar.f6463b = i10 + 1;
                } else if (i4 == 2) {
                    bVar.f6463b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f6456c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f6456c.get(size2);
            if (bVar2.f6462a == 8) {
                int i11 = bVar2.f6465d;
                if (i11 == bVar2.f6463b || i11 < 0) {
                    this.f6456c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f6465d <= 0) {
                this.f6456c.remove(size2);
                a(bVar2);
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.j.a
    public void a(b bVar) {
        if (this.f6459f) {
            return;
        }
        bVar.f6464c = null;
        this.f6454a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.j.a
    public b b(int i3, int i4, int i5, Object obj) {
        b bVar = (b) this.f6454a.b();
        if (bVar == null) {
            return new b(i3, i4, i5, obj);
        }
        bVar.f6462a = i3;
        bVar.f6463b = i4;
        bVar.f6465d = i5;
        bVar.f6464c = obj;
        return bVar;
    }

    public int e(int i3) {
        int size = this.f6455b.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) this.f6455b.get(i4);
            int i5 = bVar.f6462a;
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = bVar.f6463b;
                    if (i6 <= i3) {
                        int i7 = bVar.f6465d;
                        if (i6 + i7 > i3) {
                            return -1;
                        }
                        i3 -= i7;
                    } else {
                        continue;
                    }
                } else if (i5 == 8) {
                    int i8 = bVar.f6463b;
                    if (i8 == i3) {
                        i3 = bVar.f6465d;
                    } else {
                        if (i8 < i3) {
                            i3--;
                        }
                        if (bVar.f6465d <= i3) {
                            i3++;
                        }
                    }
                }
            } else if (bVar.f6463b <= i3) {
                i3 += bVar.f6465d;
            }
        }
        return i3;
    }

    void i() {
        int size = this.f6456c.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f6457d.b((b) this.f6456c.get(i3));
        }
        x(this.f6456c);
        this.f6461h = 0;
    }

    void j() {
        i();
        int size = this.f6455b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f6455b.get(i3);
            int i4 = bVar.f6462a;
            if (i4 == 1) {
                this.f6457d.b(bVar);
                this.f6457d.g(bVar.f6463b, bVar.f6465d);
            } else if (i4 == 2) {
                this.f6457d.b(bVar);
                this.f6457d.d(bVar.f6463b, bVar.f6465d);
            } else if (i4 == 4) {
                this.f6457d.b(bVar);
                this.f6457d.h(bVar.f6463b, bVar.f6465d, bVar.f6464c);
            } else if (i4 == 8) {
                this.f6457d.b(bVar);
                this.f6457d.a(bVar.f6463b, bVar.f6465d);
            }
            Runnable runnable = this.f6458e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f6455b);
        this.f6461h = 0;
    }

    void l(b bVar, int i3) {
        this.f6457d.f(bVar);
        int i4 = bVar.f6462a;
        if (i4 == 2) {
            this.f6457d.d(i3, bVar.f6465d);
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f6457d.h(i3, bVar.f6465d, bVar.f6464c);
        }
    }

    int m(int i3) {
        return n(i3, 0);
    }

    int n(int i3, int i4) {
        int size = this.f6456c.size();
        while (i4 < size) {
            b bVar = (b) this.f6456c.get(i4);
            int i5 = bVar.f6462a;
            if (i5 == 8) {
                int i6 = bVar.f6463b;
                if (i6 == i3) {
                    i3 = bVar.f6465d;
                } else {
                    if (i6 < i3) {
                        i3--;
                    }
                    if (bVar.f6465d <= i3) {
                        i3++;
                    }
                }
            } else {
                int i7 = bVar.f6463b;
                if (i7 > i3) {
                    continue;
                } else if (i5 == 2) {
                    int i8 = bVar.f6465d;
                    if (i3 < i7 + i8) {
                        return -1;
                    }
                    i3 -= i8;
                } else if (i5 == 1) {
                    i3 += bVar.f6465d;
                }
            }
            i4++;
        }
        return i3;
    }

    boolean o(int i3) {
        return (this.f6461h & i3) != 0;
    }

    boolean p() {
        return this.f6455b.size() > 0;
    }

    boolean q() {
        return (this.f6456c.isEmpty() || this.f6455b.isEmpty()) ? false : true;
    }

    boolean r(int i3, int i4, Object obj) {
        if (i4 < 1) {
            return false;
        }
        this.f6455b.add(b(4, i3, i4, obj));
        this.f6461h |= 4;
        return this.f6455b.size() == 1;
    }

    boolean s(int i3, int i4) {
        if (i4 < 1) {
            return false;
        }
        this.f6455b.add(b(1, i3, i4, null));
        this.f6461h |= 1;
        return this.f6455b.size() == 1;
    }

    boolean t(int i3, int i4, int i5) {
        if (i3 == i4) {
            return false;
        }
        if (i5 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f6455b.add(b(8, i3, i4, null));
        this.f6461h |= 8;
        return this.f6455b.size() == 1;
    }

    boolean u(int i3, int i4) {
        if (i4 < 1) {
            return false;
        }
        this.f6455b.add(b(2, i3, i4, null));
        this.f6461h |= 2;
        return this.f6455b.size() == 1;
    }

    void w() {
        this.f6460g.b(this.f6455b);
        int size = this.f6455b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f6455b.get(i3);
            int i4 = bVar.f6462a;
            if (i4 == 1) {
                c(bVar);
            } else if (i4 == 2) {
                f(bVar);
            } else if (i4 == 4) {
                g(bVar);
            } else if (i4 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f6458e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f6455b.clear();
    }

    void x(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a((b) list.get(i3));
        }
        list.clear();
    }

    void y() {
        x(this.f6455b);
        x(this.f6456c);
        this.f6461h = 0;
    }

    a(InterfaceC0093a interfaceC0093a, boolean z3) {
        this.f6454a = new androidx.core.util.f(30);
        this.f6455b = new ArrayList();
        this.f6456c = new ArrayList();
        this.f6461h = 0;
        this.f6457d = interfaceC0093a;
        this.f6459f = z3;
        this.f6460g = new j(this);
    }
}
