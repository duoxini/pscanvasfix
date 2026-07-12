package c1;

import android.graphics.PointF;
import d1.AbstractC0336a;
import f1.C0353a;
import h1.C0384m;
import h1.C0385n;
import i1.AbstractC0395b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class q implements s, AbstractC0336a.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.oplus.anim.n f7413a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7414b;

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC0336a f7415c;

    /* renamed from: d, reason: collision with root package name */
    private C0385n f7416d;

    public q(com.oplus.anim.n nVar, AbstractC0395b abstractC0395b, C0384m c0384m) {
        this.f7413a = nVar;
        this.f7414b = c0384m.c();
        AbstractC0336a a3 = c0384m.b().a();
        this.f7415c = a3;
        abstractC0395b.k(a3);
        a3.a(this);
    }

    private static int b(int i3, int i4) {
        int i5 = i3 / i4;
        return ((i3 ^ i4) >= 0 || i4 * i5 == i3) ? i5 : i5 - 1;
    }

    private static int g(int i3, int i4) {
        return i3 - (b(i3, i4) * i4);
    }

    private C0385n k(C0385n c0385n) {
        List a3 = c0385n.a();
        boolean d3 = c0385n.d();
        int size = a3.size() - 1;
        int i3 = 0;
        while (size >= 0) {
            C0353a c0353a = (C0353a) a3.get(size);
            C0353a c0353a2 = (C0353a) a3.get(g(size - 1, a3.size()));
            PointF c3 = (size != 0 || d3) ? c0353a2.c() : c0385n.b();
            i3 = (((size != 0 || d3) ? c0353a2.b() : c3).equals(c3) && c0353a.a().equals(c3) && !(!c0385n.d() && size == 0 && size == a3.size() - 1)) ? i3 + 2 : i3 + 1;
            size--;
        }
        C0385n c0385n2 = this.f7416d;
        if (c0385n2 == null || c0385n2.a().size() != i3) {
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(new C0353a());
            }
            this.f7416d = new C0385n(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f7416d.e(d3);
        return this.f7416d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (r6 == (r0.size() - 1)) goto L27;
     */
    @Override // c1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h1.C0385n c(h1.C0385n r19) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.q.c(h1.n):h1.n");
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f7413a.invalidateSelf();
    }

    @Override // c1.c
    public void f(List list, List list2) {
    }

    public AbstractC0336a h() {
        return this.f7415c;
    }
}
