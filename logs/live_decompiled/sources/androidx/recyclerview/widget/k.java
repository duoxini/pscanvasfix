package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.p f6605a;

    /* renamed from: b, reason: collision with root package name */
    private int f6606b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f6607c;

    class a extends k {
        a(RecyclerView.p pVar) {
            super(pVar, null);
        }

        @Override // androidx.recyclerview.widget.k
        public int d(View view) {
            return this.f6605a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int e(View view) {
            RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
            return this.f6605a.S(view) + ((ViewGroup.MarginLayoutParams) qVar).leftMargin + ((ViewGroup.MarginLayoutParams) qVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int f(View view) {
            RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
            return this.f6605a.R(view) + ((ViewGroup.MarginLayoutParams) qVar).topMargin + ((ViewGroup.MarginLayoutParams) qVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int g(View view) {
            return this.f6605a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int h() {
            return this.f6605a.q0();
        }

        @Override // androidx.recyclerview.widget.k
        public int i() {
            return this.f6605a.q0() - this.f6605a.g0();
        }

        @Override // androidx.recyclerview.widget.k
        public int j() {
            return this.f6605a.g0();
        }

        @Override // androidx.recyclerview.widget.k
        public int l() {
            return this.f6605a.r0();
        }

        @Override // androidx.recyclerview.widget.k
        public int m() {
            return this.f6605a.X();
        }

        @Override // androidx.recyclerview.widget.k
        public int n() {
            return this.f6605a.f0();
        }

        @Override // androidx.recyclerview.widget.k
        public int o() {
            return (this.f6605a.q0() - this.f6605a.f0()) - this.f6605a.g0();
        }

        @Override // androidx.recyclerview.widget.k
        public int q(View view) {
            this.f6605a.p0(view, true, this.f6607c);
            return this.f6607c.right;
        }

        @Override // androidx.recyclerview.widget.k
        public int r(View view) {
            this.f6605a.p0(view, true, this.f6607c);
            return this.f6607c.left;
        }

        @Override // androidx.recyclerview.widget.k
        public void s(int i3) {
            this.f6605a.E0(i3);
        }
    }

    class b extends k {
        b(RecyclerView.p pVar) {
            super(pVar, null);
        }

        @Override // androidx.recyclerview.widget.k
        public int d(View view) {
            return this.f6605a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int e(View view) {
            RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
            return this.f6605a.R(view) + ((ViewGroup.MarginLayoutParams) qVar).topMargin + ((ViewGroup.MarginLayoutParams) qVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int f(View view) {
            RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
            return this.f6605a.S(view) + ((ViewGroup.MarginLayoutParams) qVar).leftMargin + ((ViewGroup.MarginLayoutParams) qVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int g(View view) {
            return this.f6605a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int h() {
            return this.f6605a.W();
        }

        @Override // androidx.recyclerview.widget.k
        public int i() {
            return this.f6605a.W() - this.f6605a.d0();
        }

        @Override // androidx.recyclerview.widget.k
        public int j() {
            return this.f6605a.d0();
        }

        @Override // androidx.recyclerview.widget.k
        public int l() {
            return this.f6605a.X();
        }

        @Override // androidx.recyclerview.widget.k
        public int m() {
            return this.f6605a.r0();
        }

        @Override // androidx.recyclerview.widget.k
        public int n() {
            return this.f6605a.i0();
        }

        @Override // androidx.recyclerview.widget.k
        public int o() {
            return (this.f6605a.W() - this.f6605a.i0()) - this.f6605a.d0();
        }

        @Override // androidx.recyclerview.widget.k
        public int q(View view) {
            this.f6605a.p0(view, true, this.f6607c);
            return this.f6607c.bottom;
        }

        @Override // androidx.recyclerview.widget.k
        public int r(View view) {
            this.f6605a.p0(view, true, this.f6607c);
            return this.f6607c.top;
        }

        @Override // androidx.recyclerview.widget.k
        public void s(int i3) {
            this.f6605a.F0(i3);
        }
    }

    /* synthetic */ k(RecyclerView.p pVar, a aVar) {
        this(pVar);
    }

    public static k a(RecyclerView.p pVar) {
        return new a(pVar);
    }

    public static k b(RecyclerView.p pVar, int i3) {
        if (i3 == 0) {
            return a(pVar);
        }
        if (i3 == 1) {
            return c(pVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static k c(RecyclerView.p pVar) {
        return new b(pVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.p k() {
        return this.f6605a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE == this.f6606b) {
            return 0;
        }
        return o() - this.f6606b;
    }

    public abstract int q(View view);

    public abstract int r(View view);

    public abstract void s(int i3);

    public void t() {
        this.f6606b = o();
    }

    private k(RecyclerView.p pVar) {
        this.f6606b = Integer.MIN_VALUE;
        this.f6607c = new Rect();
        this.f6605a = pVar;
    }
}
