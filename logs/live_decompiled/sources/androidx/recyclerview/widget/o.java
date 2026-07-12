package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class o extends RecyclerView.m {

    /* renamed from: g, reason: collision with root package name */
    boolean f6613g = true;

    public final void A(RecyclerView.E e3) {
        I(e3);
        h(e3);
    }

    public final void B(RecyclerView.E e3) {
        J(e3);
    }

    public final void C(RecyclerView.E e3, boolean z3) {
        K(e3, z3);
        h(e3);
    }

    public final void D(RecyclerView.E e3, boolean z3) {
        L(e3, z3);
    }

    public final void E(RecyclerView.E e3) {
        M(e3);
        h(e3);
    }

    public final void F(RecyclerView.E e3) {
        N(e3);
    }

    public final void G(RecyclerView.E e3) {
        O(e3);
        h(e3);
    }

    public final void H(RecyclerView.E e3) {
        P(e3);
    }

    public void I(RecyclerView.E e3) {
    }

    public void J(RecyclerView.E e3) {
    }

    public void K(RecyclerView.E e3, boolean z3) {
    }

    public void L(RecyclerView.E e3, boolean z3) {
    }

    public void M(RecyclerView.E e3) {
    }

    public void N(RecyclerView.E e3) {
    }

    public void O(RecyclerView.E e3) {
    }

    public void P(RecyclerView.E e3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean a(RecyclerView.E e3, RecyclerView.m.b bVar, RecyclerView.m.b bVar2) {
        int i3;
        int i4;
        return (bVar == null || ((i3 = bVar.f6349a) == (i4 = bVar2.f6349a) && bVar.f6350b == bVar2.f6350b)) ? w(e3) : y(e3, i3, bVar.f6350b, i4, bVar2.f6350b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean b(RecyclerView.E e3, RecyclerView.E e4, RecyclerView.m.b bVar, RecyclerView.m.b bVar2) {
        int i3;
        int i4;
        int i5 = bVar.f6349a;
        int i6 = bVar.f6350b;
        if (e4.shouldIgnore()) {
            int i7 = bVar.f6349a;
            i4 = bVar.f6350b;
            i3 = i7;
        } else {
            i3 = bVar2.f6349a;
            i4 = bVar2.f6350b;
        }
        return x(e3, e4, i5, i6, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean c(RecyclerView.E e3, RecyclerView.m.b bVar, RecyclerView.m.b bVar2) {
        int i3 = bVar.f6349a;
        int i4 = bVar.f6350b;
        View view = e3.itemView;
        int left = bVar2 == null ? view.getLeft() : bVar2.f6349a;
        int top = bVar2 == null ? view.getTop() : bVar2.f6350b;
        if (e3.isRemoved() || (i3 == left && i4 == top)) {
            return z(e3);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(e3, i3, i4, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean d(RecyclerView.E e3, RecyclerView.m.b bVar, RecyclerView.m.b bVar2) {
        int i3 = bVar.f6349a;
        int i4 = bVar2.f6349a;
        if (i3 != i4 || bVar.f6350b != bVar2.f6350b) {
            return y(e3, i3, bVar.f6350b, i4, bVar2.f6350b);
        }
        E(e3);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean f(RecyclerView.E e3) {
        return !this.f6613g || e3.isInvalid();
    }

    public abstract boolean w(RecyclerView.E e3);

    public abstract boolean x(RecyclerView.E e3, RecyclerView.E e4, int i3, int i4, int i5, int i6);

    public abstract boolean y(RecyclerView.E e3, int i3, int i4, int i5, int i6);

    public abstract boolean z(RecyclerView.E e3);
}
