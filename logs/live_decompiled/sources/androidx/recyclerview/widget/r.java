package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import m.C0454d;

/* loaded from: classes.dex */
class r {

    /* renamed from: a, reason: collision with root package name */
    final m.g f6626a = new m.g();

    /* renamed from: b, reason: collision with root package name */
    final C0454d f6627b = new C0454d();

    static class a {

        /* renamed from: d, reason: collision with root package name */
        static androidx.core.util.e f6628d = new androidx.core.util.f(20);

        /* renamed from: a, reason: collision with root package name */
        int f6629a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.m.b f6630b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.m.b f6631c;

        private a() {
        }

        static void a() {
            while (f6628d.b() != null) {
            }
        }

        static a b() {
            a aVar = (a) f6628d.b();
            return aVar == null ? new a() : aVar;
        }

        static void c(a aVar) {
            aVar.f6629a = 0;
            aVar.f6630b = null;
            aVar.f6631c = null;
            f6628d.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.E e3);

        void b(RecyclerView.E e3, RecyclerView.m.b bVar, RecyclerView.m.b bVar2);

        void c(RecyclerView.E e3, RecyclerView.m.b bVar, RecyclerView.m.b bVar2);

        void d(RecyclerView.E e3, RecyclerView.m.b bVar, RecyclerView.m.b bVar2);
    }

    r() {
    }

    private RecyclerView.m.b l(RecyclerView.E e3, int i3) {
        a aVar;
        RecyclerView.m.b bVar;
        int f3 = this.f6626a.f(e3);
        if (f3 >= 0 && (aVar = (a) this.f6626a.m(f3)) != null) {
            int i4 = aVar.f6629a;
            if ((i4 & i3) != 0) {
                int i5 = (~i3) & i4;
                aVar.f6629a = i5;
                if (i3 == 4) {
                    bVar = aVar.f6630b;
                } else {
                    if (i3 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    bVar = aVar.f6631c;
                }
                if ((i5 & 12) == 0) {
                    this.f6626a.k(f3);
                    a.c(aVar);
                }
                return bVar;
            }
        }
        return null;
    }

    void a(RecyclerView.E e3, RecyclerView.m.b bVar) {
        a aVar = (a) this.f6626a.get(e3);
        if (aVar == null) {
            aVar = a.b();
            this.f6626a.put(e3, aVar);
        }
        aVar.f6629a |= 2;
        aVar.f6630b = bVar;
    }

    void b(RecyclerView.E e3) {
        a aVar = (a) this.f6626a.get(e3);
        if (aVar == null) {
            aVar = a.b();
            this.f6626a.put(e3, aVar);
        }
        aVar.f6629a |= 1;
    }

    void c(long j3, RecyclerView.E e3) {
        this.f6627b.i(j3, e3);
    }

    void d(RecyclerView.E e3, RecyclerView.m.b bVar) {
        a aVar = (a) this.f6626a.get(e3);
        if (aVar == null) {
            aVar = a.b();
            this.f6626a.put(e3, aVar);
        }
        aVar.f6631c = bVar;
        aVar.f6629a |= 8;
    }

    void e(RecyclerView.E e3, RecyclerView.m.b bVar) {
        a aVar = (a) this.f6626a.get(e3);
        if (aVar == null) {
            aVar = a.b();
            this.f6626a.put(e3, aVar);
        }
        aVar.f6630b = bVar;
        aVar.f6629a |= 4;
    }

    void f() {
        this.f6626a.clear();
        this.f6627b.a();
    }

    RecyclerView.E g(long j3) {
        return (RecyclerView.E) this.f6627b.e(j3);
    }

    boolean h(RecyclerView.E e3) {
        a aVar = (a) this.f6626a.get(e3);
        return (aVar == null || (aVar.f6629a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.E e3) {
        a aVar = (a) this.f6626a.get(e3);
        return (aVar == null || (aVar.f6629a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.E e3) {
        p(e3);
    }

    RecyclerView.m.b m(RecyclerView.E e3) {
        return l(e3, 8);
    }

    RecyclerView.m.b n(RecyclerView.E e3) {
        return l(e3, 4);
    }

    void o(b bVar) {
        for (int size = this.f6626a.size() - 1; size >= 0; size--) {
            RecyclerView.E e3 = (RecyclerView.E) this.f6626a.i(size);
            a aVar = (a) this.f6626a.k(size);
            int i3 = aVar.f6629a;
            if ((i3 & 3) == 3) {
                bVar.a(e3);
            } else if ((i3 & 1) != 0) {
                RecyclerView.m.b bVar2 = aVar.f6630b;
                if (bVar2 == null) {
                    bVar.a(e3);
                } else {
                    bVar.c(e3, bVar2, aVar.f6631c);
                }
            } else if ((i3 & 14) == 14) {
                bVar.b(e3, aVar.f6630b, aVar.f6631c);
            } else if ((i3 & 12) == 12) {
                bVar.d(e3, aVar.f6630b, aVar.f6631c);
            } else if ((i3 & 4) != 0) {
                bVar.c(e3, aVar.f6630b, null);
            } else if ((i3 & 8) != 0) {
                bVar.b(e3, aVar.f6630b, aVar.f6631c);
            }
            a.c(aVar);
        }
    }

    void p(RecyclerView.E e3) {
        a aVar = (a) this.f6626a.get(e3);
        if (aVar == null) {
            return;
        }
        aVar.f6629a &= -2;
    }

    void q(RecyclerView.E e3) {
        int l3 = this.f6627b.l() - 1;
        while (true) {
            if (l3 < 0) {
                break;
            }
            if (e3 == this.f6627b.m(l3)) {
                this.f6627b.k(l3);
                break;
            }
            l3--;
        }
        a aVar = (a) this.f6626a.remove(e3);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
