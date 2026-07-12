package P2;

import C2.p;
import L2.D;
import L2.E;
import L2.F;
import L2.H;
import N2.o;
import N2.r;
import androidx.preference.Preference;
import java.util.ArrayList;
import p2.l;
import p2.q;
import q2.AbstractC0544n;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public abstract class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final t2.g f1860a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1861b;

    /* renamed from: c, reason: collision with root package name */
    public final N2.a f1862c;

    static final class a extends v2.k implements p {

        /* renamed from: i, reason: collision with root package name */
        int f1863i;

        /* renamed from: j, reason: collision with root package name */
        private /* synthetic */ Object f1864j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ O2.d f1865k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ b f1866l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(O2.d dVar, b bVar, InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
            this.f1865k = dVar;
            this.f1866l = bVar;
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            a aVar = new a(this.f1865k, this.f1866l, interfaceC0593d);
            aVar.f1864j = obj;
            return aVar;
        }

        @Override // C2.p
        public final Object invoke(D d3, InterfaceC0593d interfaceC0593d) {
            return ((a) create(d3, interfaceC0593d)).invokeSuspend(q.f12810a);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            Object c3 = AbstractC0603b.c();
            int i3 = this.f1863i;
            if (i3 == 0) {
                l.b(obj);
                D d3 = (D) this.f1864j;
                O2.d dVar = this.f1865k;
                r h3 = this.f1866l.h(d3);
                this.f1863i = 1;
                if (O2.e.b(dVar, h3, this) == c3) {
                    return c3;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.b(obj);
            }
            return q.f12810a;
        }
    }

    /* renamed from: P2.b$b, reason: collision with other inner class name */
    static final class C0036b extends v2.k implements p {

        /* renamed from: i, reason: collision with root package name */
        int f1867i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f1868j;

        C0036b(InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
        }

        @Override // C2.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(N2.q qVar, InterfaceC0593d interfaceC0593d) {
            return ((C0036b) create(qVar, interfaceC0593d)).invokeSuspend(q.f12810a);
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            C0036b c0036b = b.this.new C0036b(interfaceC0593d);
            c0036b.f1868j = obj;
            return c0036b;
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            Object c3 = AbstractC0603b.c();
            int i3 = this.f1867i;
            if (i3 == 0) {
                l.b(obj);
                N2.q qVar = (N2.q) this.f1868j;
                b bVar = b.this;
                this.f1867i = 1;
                if (bVar.d(qVar, this) == c3) {
                    return c3;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.b(obj);
            }
            return q.f12810a;
        }
    }

    public b(t2.g gVar, int i3, N2.a aVar) {
        this.f1860a = gVar;
        this.f1861b = i3;
        this.f1862c = aVar;
    }

    static /* synthetic */ Object c(b bVar, O2.d dVar, InterfaceC0593d interfaceC0593d) {
        Object a3 = E.a(new a(dVar, bVar, null), interfaceC0593d);
        return a3 == AbstractC0603b.c() ? a3 : q.f12810a;
    }

    @Override // P2.g
    public O2.c a(t2.g gVar, int i3, N2.a aVar) {
        t2.g p3 = gVar.p(this.f1860a);
        if (aVar == N2.a.SUSPEND) {
            int i4 = this.f1861b;
            if (i4 != -3) {
                if (i3 != -3) {
                    if (i4 != -2) {
                        if (i3 != -2) {
                            i3 += i4;
                            if (i3 < 0) {
                                i3 = Preference.DEFAULT_ORDER;
                            }
                        }
                    }
                }
                i3 = i4;
            }
            aVar = this.f1862c;
        }
        return (D2.k.a(p3, this.f1860a) && i3 == this.f1861b && aVar == this.f1862c) ? this : e(p3, i3, aVar);
    }

    protected String b() {
        return null;
    }

    @Override // O2.c
    public Object collect(O2.d dVar, InterfaceC0593d interfaceC0593d) {
        return c(this, dVar, interfaceC0593d);
    }

    protected abstract Object d(N2.q qVar, InterfaceC0593d interfaceC0593d);

    protected abstract b e(t2.g gVar, int i3, N2.a aVar);

    public final p f() {
        return new C0036b(null);
    }

    public final int g() {
        int i3 = this.f1861b;
        if (i3 == -3) {
            return -2;
        }
        return i3;
    }

    public r h(D d3) {
        return o.c(d3, this.f1860a, g(), this.f1862c, F.ATOMIC, null, f(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String b3 = b();
        if (b3 != null) {
            arrayList.add(b3);
        }
        if (this.f1860a != t2.h.f13692e) {
            arrayList.add("context=" + this.f1860a);
        }
        if (this.f1861b != -3) {
            arrayList.add("capacity=" + this.f1861b);
        }
        if (this.f1862c != N2.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f1862c);
        }
        return H.a(this) + '[' + AbstractC0544n.v(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
