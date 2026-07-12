package H2;

import D2.g;

/* loaded from: classes.dex */
public final class c extends H2.a {

    /* renamed from: i, reason: collision with root package name */
    public static final a f890i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final c f891j = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f891j;
        }

        private a() {
        }
    }

    public c(int i3, int i4) {
        super(i3, i4, 1);
    }

    @Override // H2.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i3) {
        return a() <= i3 && i3 <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // H2.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return b() + (a() * 31);
    }

    @Override // H2.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // H2.a
    public String toString() {
        return a() + ".." + b();
    }
}
