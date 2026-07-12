package T2;

import Q2.A;
import Q2.D;
import java.util.concurrent.atomic.AtomicReferenceArray;
import t2.g;

/* loaded from: classes.dex */
final class f extends A {

    /* renamed from: i, reason: collision with root package name */
    private final AtomicReferenceArray f2228i;

    public f(long j3, f fVar, int i3) {
        super(j3, fVar, i3);
        int i4;
        i4 = e.f2227f;
        this.f2228i = new AtomicReferenceArray(i4);
    }

    @Override // Q2.A
    public int n() {
        int i3;
        i3 = e.f2227f;
        return i3;
    }

    @Override // Q2.A
    public void o(int i3, Throwable th, g gVar) {
        D d3;
        d3 = e.f2226e;
        r().set(i3, d3);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f2228i;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f1961g + ", hashCode=" + hashCode() + ']';
    }
}
