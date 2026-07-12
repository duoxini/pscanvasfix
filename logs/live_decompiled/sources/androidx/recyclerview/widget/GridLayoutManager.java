package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: I, reason: collision with root package name */
    boolean f6238I;

    /* renamed from: J, reason: collision with root package name */
    int f6239J;

    /* renamed from: K, reason: collision with root package name */
    int[] f6240K;

    /* renamed from: L, reason: collision with root package name */
    View[] f6241L;

    /* renamed from: M, reason: collision with root package name */
    final SparseIntArray f6242M;

    /* renamed from: N, reason: collision with root package name */
    final SparseIntArray f6243N;

    /* renamed from: O, reason: collision with root package name */
    c f6244O;

    /* renamed from: P, reason: collision with root package name */
    final Rect f6245P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f6246Q;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i3, int i4) {
            return i3 % i4;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i3) {
            return 1;
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f6249a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        final SparseIntArray f6250b = new SparseIntArray();

        /* renamed from: c, reason: collision with root package name */
        private boolean f6251c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6252d = false;

        static int a(SparseIntArray sparseIntArray, int i3) {
            int size = sparseIntArray.size() - 1;
            int i4 = 0;
            while (i4 <= size) {
                int i5 = (i4 + size) >>> 1;
                if (sparseIntArray.keyAt(i5) < i3) {
                    i4 = i5 + 1;
                } else {
                    size = i5 - 1;
                }
            }
            int i6 = i4 - 1;
            if (i6 < 0 || i6 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i6);
        }

        int b(int i3, int i4) {
            if (!this.f6252d) {
                return d(i3, i4);
            }
            int i5 = this.f6250b.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int d3 = d(i3, i4);
            this.f6250b.put(i3, d3);
            return d3;
        }

        int c(int i3, int i4) {
            if (!this.f6251c) {
                return e(i3, i4);
            }
            int i5 = this.f6249a.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int e3 = e(i3, i4);
            this.f6249a.put(i3, e3);
            return e3;
        }

        public int d(int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int a3;
            if (!this.f6252d || (a3 = a(this.f6250b, i3)) == -1) {
                i5 = 0;
                i6 = 0;
                i7 = 0;
            } else {
                i5 = this.f6250b.get(a3);
                i6 = a3 + 1;
                i7 = c(a3, i4) + f(a3);
                if (i7 == i4) {
                    i5++;
                    i7 = 0;
                }
            }
            int f3 = f(i3);
            while (i6 < i3) {
                int f4 = f(i6);
                i7 += f4;
                if (i7 == i4) {
                    i5++;
                    i7 = 0;
                } else if (i7 > i4) {
                    i5++;
                    i7 = f4;
                }
                i6++;
            }
            return i7 + f3 > i4 ? i5 + 1 : i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f6251c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f6249a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f6249a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.e(int, int):int");
        }

        public abstract int f(int i3);

        public void g() {
            this.f6250b.clear();
        }

        public void h() {
            this.f6249a.clear();
        }

        public void i(boolean z3) {
            if (!z3) {
                this.f6250b.clear();
            }
            this.f6252d = z3;
        }

        public void j(boolean z3) {
            if (!z3) {
                this.f6250b.clear();
            }
            this.f6251c = z3;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f6238I = false;
        this.f6239J = -1;
        this.f6242M = new SparseIntArray();
        this.f6243N = new SparseIntArray();
        this.f6244O = new a();
        this.f6245P = new Rect();
        g3(RecyclerView.p.k0(context, attributeSet, i3, i4).f6375b);
    }

    private void P2(RecyclerView.w wVar, RecyclerView.B b3, int i3, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (z3) {
            i6 = 1;
            i5 = i3;
            i4 = 0;
        } else {
            i4 = i3 - 1;
            i5 = -1;
            i6 = -1;
        }
        while (i4 != i5) {
            View view = this.f6241L[i4];
            b bVar = (b) view.getLayoutParams();
            int c3 = c3(wVar, b3, j0(view));
            bVar.f6248f = c3;
            bVar.f6247e = i7;
            i7 += c3;
            i4 += i6;
        }
    }

    private void Q2() {
        int J3 = J();
        for (int i3 = 0; i3 < J3; i3++) {
            b bVar = (b) I(i3).getLayoutParams();
            int a3 = bVar.a();
            this.f6242M.put(a3, bVar.f());
            this.f6243N.put(a3, bVar.e());
        }
    }

    private void R2(int i3) {
        this.f6240K = S2(this.f6240K, this.f6239J, i3);
    }

    static int[] S2(int[] iArr, int i3, int i4) {
        int i5;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i4) {
            iArr = new int[i3 + 1];
        }
        int i6 = 0;
        iArr[0] = 0;
        int i7 = i4 / i3;
        int i8 = i4 % i3;
        int i9 = 0;
        for (int i10 = 1; i10 <= i3; i10++) {
            i6 += i8;
            if (i6 <= 0 || i3 - i6 >= i8) {
                i5 = i7;
            } else {
                i5 = i7 + 1;
                i6 -= i3;
            }
            i9 += i5;
            iArr[i10] = i9;
        }
        return iArr;
    }

    private void T2() {
        this.f6242M.clear();
        this.f6243N.clear();
    }

    private int U2(RecyclerView.B b3) {
        if (J() != 0 && b3.b() != 0) {
            W1();
            boolean s22 = s2();
            View b22 = b2(!s22, true);
            View a22 = a2(!s22, true);
            if (b22 != null && a22 != null) {
                int b4 = this.f6244O.b(j0(b22), this.f6239J);
                int b5 = this.f6244O.b(j0(a22), this.f6239J);
                int max = this.f6266x ? Math.max(0, ((this.f6244O.b(b3.b() - 1, this.f6239J) + 1) - Math.max(b4, b5)) - 1) : Math.max(0, Math.min(b4, b5));
                if (s22) {
                    return Math.round((max * (Math.abs(this.f6263u.d(a22) - this.f6263u.g(b22)) / ((this.f6244O.b(j0(a22), this.f6239J) - this.f6244O.b(j0(b22), this.f6239J)) + 1))) + (this.f6263u.n() - this.f6263u.g(b22)));
                }
                return max;
            }
        }
        return 0;
    }

    private int V2(RecyclerView.B b3) {
        if (J() != 0 && b3.b() != 0) {
            W1();
            View b22 = b2(!s2(), true);
            View a22 = a2(!s2(), true);
            if (b22 != null && a22 != null) {
                if (!s2()) {
                    return this.f6244O.b(b3.b() - 1, this.f6239J) + 1;
                }
                int d3 = this.f6263u.d(a22) - this.f6263u.g(b22);
                int b4 = this.f6244O.b(j0(b22), this.f6239J);
                return (int) ((d3 / ((this.f6244O.b(j0(a22), this.f6239J) - b4) + 1)) * (this.f6244O.b(b3.b() - 1, this.f6239J) + 1));
            }
        }
        return 0;
    }

    private void W2(RecyclerView.w wVar, RecyclerView.B b3, LinearLayoutManager.a aVar, int i3) {
        boolean z3 = i3 == 1;
        int b32 = b3(wVar, b3, aVar.f6270b);
        if (z3) {
            while (b32 > 0) {
                int i4 = aVar.f6270b;
                if (i4 <= 0) {
                    return;
                }
                int i5 = i4 - 1;
                aVar.f6270b = i5;
                b32 = b3(wVar, b3, i5);
            }
            return;
        }
        int b4 = b3.b() - 1;
        int i6 = aVar.f6270b;
        while (i6 < b4) {
            int i7 = i6 + 1;
            int b33 = b3(wVar, b3, i7);
            if (b33 <= b32) {
                break;
            }
            i6 = i7;
            b32 = b33;
        }
        aVar.f6270b = i6;
    }

    private void X2() {
        View[] viewArr = this.f6241L;
        if (viewArr == null || viewArr.length != this.f6239J) {
            this.f6241L = new View[this.f6239J];
        }
    }

    private int a3(RecyclerView.w wVar, RecyclerView.B b3, int i3) {
        if (!b3.e()) {
            return this.f6244O.b(i3, this.f6239J);
        }
        int f3 = wVar.f(i3);
        if (f3 != -1) {
            return this.f6244O.b(f3, this.f6239J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i3);
        return 0;
    }

    private int b3(RecyclerView.w wVar, RecyclerView.B b3, int i3) {
        if (!b3.e()) {
            return this.f6244O.c(i3, this.f6239J);
        }
        int i4 = this.f6243N.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int f3 = wVar.f(i3);
        if (f3 != -1) {
            return this.f6244O.c(f3, this.f6239J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 0;
    }

    private int c3(RecyclerView.w wVar, RecyclerView.B b3, int i3) {
        if (!b3.e()) {
            return this.f6244O.f(i3);
        }
        int i4 = this.f6242M.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int f3 = wVar.f(i3);
        if (f3 != -1) {
            return this.f6244O.f(f3);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 1;
    }

    private void d3(float f3, int i3) {
        R2(Math.max(Math.round(f3 * this.f6239J), i3));
    }

    private void e3(View view, int i3, boolean z3) {
        int i4;
        int i5;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f6379b;
        int i6 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i7 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int Y2 = Y2(bVar.f6247e, bVar.f6248f);
        if (this.f6261s == 1) {
            i5 = RecyclerView.p.K(Y2, i3, i7, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i4 = RecyclerView.p.K(this.f6263u.o(), X(), i6, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int K3 = RecyclerView.p.K(Y2, i3, i6, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int K4 = RecyclerView.p.K(this.f6263u.o(), r0(), i7, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i4 = K3;
            i5 = K4;
        }
        f3(view, i5, i4, z3);
    }

    private void f3(View view, int i3, int i4, boolean z3) {
        RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
        if (z3 ? K1(view, i3, i4, qVar) : I1(view, i3, i4, qVar)) {
            view.measure(i3, i4);
        }
    }

    private void i3() {
        int W3;
        int i02;
        if (q2() == 1) {
            W3 = q0() - g0();
            i02 = f0();
        } else {
            W3 = W() - d0();
            i02 = i0();
        }
        R2(W3 - i02);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        i3();
        X2();
        return super.B1(i3, wVar, b3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q D() {
        return this.f6261s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void F1(Rect rect, int i3, int i4) {
        int n3;
        int n4;
        if (this.f6240K == null) {
            super.F1(rect, i3, i4);
        }
        int f02 = f0() + g0();
        int i02 = i0() + d0();
        if (this.f6261s == 1) {
            n4 = RecyclerView.p.n(i4, rect.height() + i02, b0());
            int[] iArr = this.f6240K;
            n3 = RecyclerView.p.n(i3, iArr[iArr.length - 1] + f02, c0());
        } else {
            n3 = RecyclerView.p.n(i3, rect.width() + f02, c0());
            int[] iArr2 = this.f6240K;
            n4 = RecyclerView.p.n(i4, iArr2[iArr2.length - 1] + i02, b0());
        }
        E1(n3, n4);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void G2(boolean z3) {
        if (z3) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.G2(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f1, code lost:
    
        if (r13 == (r2 > r7)) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View L0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.w r26, androidx.recyclerview.widget.RecyclerView.B r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.L0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.RecyclerView$B):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int N(RecyclerView.w wVar, RecyclerView.B b3) {
        if (this.f6261s == 1) {
            return this.f6239J;
        }
        if (b3.b() < 1) {
            return 0;
        }
        return a3(wVar, b3, b3.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean O1() {
        return this.f6256D == null && !this.f6238I;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void Q1(RecyclerView.B b3, LinearLayoutManager.c cVar, RecyclerView.p.c cVar2) {
        int i3 = this.f6239J;
        for (int i4 = 0; i4 < this.f6239J && cVar.c(b3) && i3 > 0; i4++) {
            int i5 = cVar.f6281d;
            cVar2.a(i5, Math.max(0, cVar.f6284g));
            i3 -= this.f6244O.f(i5);
            cVar.f6281d += cVar.f6282e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void R0(RecyclerView.w wVar, RecyclerView.B b3, View view, androidx.core.view.accessibility.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.Q0(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a3 = a3(wVar, b3, bVar.a());
        if (this.f6261s == 0) {
            dVar.T(d.c.a(bVar.e(), bVar.f(), a3, 1, false, false));
        } else {
            dVar.T(d.c.a(a3, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void T0(RecyclerView recyclerView, int i3, int i4) {
        this.f6244O.h();
        this.f6244O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void U0(RecyclerView recyclerView) {
        this.f6244O.h();
        this.f6244O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void V0(RecyclerView recyclerView, int i3, int i4, int i5) {
        this.f6244O.h();
        this.f6244O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void W0(RecyclerView recyclerView, int i3, int i4) {
        this.f6244O.h();
        this.f6244O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void Y0(RecyclerView recyclerView, int i3, int i4, Object obj) {
        this.f6244O.h();
        this.f6244O.g();
    }

    int Y2(int i3, int i4) {
        if (this.f6261s != 1 || !r2()) {
            int[] iArr = this.f6240K;
            return iArr[i4 + i3] - iArr[i3];
        }
        int[] iArr2 = this.f6240K;
        int i5 = this.f6239J;
        return iArr2[i5 - i3] - iArr2[(i5 - i3) - i4];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void Z0(RecyclerView.w wVar, RecyclerView.B b3) {
        if (b3.e()) {
            Q2();
        }
        super.Z0(wVar, b3);
        T2();
    }

    public int Z2() {
        return this.f6239J;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.B b3) {
        super.a1(b3);
        this.f6238I = false;
    }

    public void g3(int i3) {
        if (i3 == this.f6239J) {
            return;
        }
        this.f6238I = true;
        if (i3 >= 1) {
            this.f6239J = i3;
            this.f6244O.h();
            w1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i3);
        }
    }

    public void h3(c cVar) {
        this.f6244O = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View k2(RecyclerView.w wVar, RecyclerView.B b3, boolean z3, boolean z4) {
        int i3;
        int i4;
        int J3 = J();
        int i5 = 1;
        if (z4) {
            i4 = J() - 1;
            i3 = -1;
            i5 = -1;
        } else {
            i3 = J3;
            i4 = 0;
        }
        int b4 = b3.b();
        W1();
        int n3 = this.f6263u.n();
        int i6 = this.f6263u.i();
        View view = null;
        View view2 = null;
        while (i4 != i3) {
            View I3 = I(i4);
            int j02 = j0(I3);
            if (j02 >= 0 && j02 < b4 && b3(wVar, b3, j02) == 0) {
                if (((RecyclerView.q) I3.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I3;
                    }
                } else {
                    if (this.f6263u.g(I3) < i6 && this.f6263u.d(I3) >= n3) {
                        return I3;
                    }
                    if (view == null) {
                        view = I3;
                    }
                }
            }
            i4 += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean m(RecyclerView.q qVar) {
        return qVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int m0(RecyclerView.w wVar, RecyclerView.B b3) {
        if (this.f6261s == 0) {
            return this.f6239J;
        }
        if (b3.b() < 1) {
            return 0;
        }
        return a3(wVar, b3, b3.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.B b3) {
        return this.f6246Q ? U2(b3) : super.r(b3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.B b3) {
        return this.f6246Q ? V2(b3) : super.s(b3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.f6275b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void t2(androidx.recyclerview.widget.RecyclerView.w r18, androidx.recyclerview.widget.RecyclerView.B r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.t2(androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.RecyclerView$B, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.B b3) {
        return this.f6246Q ? U2(b3) : super.u(b3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.B b3) {
        return this.f6246Q ? V2(b3) : super.v(b3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void v2(RecyclerView.w wVar, RecyclerView.B b3, LinearLayoutManager.a aVar, int i3) {
        super.v2(wVar, b3, aVar, i3);
        i3();
        if (b3.b() > 0 && !b3.e()) {
            W2(wVar, b3, aVar, i3);
        }
        X2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        i3();
        X2();
        return super.z1(i3, wVar, b3);
    }

    public static class b extends RecyclerView.q {

        /* renamed from: e, reason: collision with root package name */
        int f6247e;

        /* renamed from: f, reason: collision with root package name */
        int f6248f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6247e = -1;
            this.f6248f = 0;
        }

        public int e() {
            return this.f6247e;
        }

        public int f() {
            return this.f6248f;
        }

        public b(int i3, int i4) {
            super(i3, i4);
            this.f6247e = -1;
            this.f6248f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6247e = -1;
            this.f6248f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6247e = -1;
            this.f6248f = 0;
        }
    }

    public GridLayoutManager(Context context, int i3, int i4, boolean z3) {
        super(context, i4, z3);
        this.f6238I = false;
        this.f6239J = -1;
        this.f6242M = new SparseIntArray();
        this.f6243N = new SparseIntArray();
        this.f6244O = new a();
        this.f6245P = new Rect();
        g3(i3);
    }
}
