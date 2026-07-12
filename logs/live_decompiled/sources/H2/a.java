package H2;

import D2.g;
import q2.AbstractC0520C;

/* loaded from: classes.dex */
public class a implements Iterable {

    /* renamed from: h, reason: collision with root package name */
    public static final C0015a f882h = new C0015a(null);

    /* renamed from: e, reason: collision with root package name */
    private final int f883e;

    /* renamed from: f, reason: collision with root package name */
    private final int f884f;

    /* renamed from: g, reason: collision with root package name */
    private final int f885g;

    /* renamed from: H2.a$a, reason: collision with other inner class name */
    public static final class C0015a {
        public /* synthetic */ C0015a(g gVar) {
            this();
        }

        public final a a(int i3, int i4, int i5) {
            return new a(i3, i4, i5);
        }

        private C0015a() {
        }
    }

    public a(int i3, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f883e = i3;
        this.f884f = x2.c.b(i3, i4, i5);
        this.f885g = i5;
    }

    public final int a() {
        return this.f883e;
    }

    public final int b() {
        return this.f884f;
    }

    public final int c() {
        return this.f885g;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC0520C iterator() {
        return new b(this.f883e, this.f884f, this.f885g);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f883e != aVar.f883e || this.f884f != aVar.f884f || this.f885g != aVar.f885g) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f885g + (((this.f883e * 31) + this.f884f) * 31);
    }

    public boolean isEmpty() {
        if (this.f885g > 0) {
            if (this.f883e <= this.f884f) {
                return false;
            }
        } else if (this.f883e >= this.f884f) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i3;
        if (this.f885g > 0) {
            sb = new StringBuilder();
            sb.append(this.f883e);
            sb.append("..");
            sb.append(this.f884f);
            sb.append(" step ");
            i3 = this.f885g;
        } else {
            sb = new StringBuilder();
            sb.append(this.f883e);
            sb.append(" downTo ");
            sb.append(this.f884f);
            sb.append(" step ");
            i3 = -this.f885g;
        }
        sb.append(i3);
        return sb.toString();
    }
}
