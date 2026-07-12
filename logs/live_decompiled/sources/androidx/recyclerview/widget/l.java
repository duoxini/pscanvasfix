package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class l extends p {

    /* renamed from: d, reason: collision with root package name */
    private k f6608d;

    /* renamed from: e, reason: collision with root package name */
    private k f6609e;

    class a extends i {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.i, androidx.recyclerview.widget.RecyclerView.A
        protected void o(View view, RecyclerView.B b3, RecyclerView.A.a aVar) {
            l lVar = l.this;
            int[] c3 = lVar.c(lVar.f6614a.getLayoutManager(), view);
            int i3 = c3[0];
            int i4 = c3[1];
            int w3 = w(Math.max(Math.abs(i3), Math.abs(i4)));
            if (w3 > 0) {
                aVar.d(i3, i4, w3, this.f6597j);
            }
        }

        @Override // androidx.recyclerview.widget.i
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.i
        protected int x(int i3) {
            return Math.min(100, super.x(i3));
        }
    }

    private int k(View view, k kVar) {
        return (kVar.g(view) + (kVar.e(view) / 2)) - (kVar.n() + (kVar.o() / 2));
    }

    private View l(RecyclerView.p pVar, k kVar) {
        int J3 = pVar.J();
        View view = null;
        if (J3 == 0) {
            return null;
        }
        int n3 = kVar.n() + (kVar.o() / 2);
        int i3 = Preference.DEFAULT_ORDER;
        for (int i4 = 0; i4 < J3; i4++) {
            View I3 = pVar.I(i4);
            int abs = Math.abs((kVar.g(I3) + (kVar.e(I3) / 2)) - n3);
            if (abs < i3) {
                view = I3;
                i3 = abs;
            }
        }
        return view;
    }

    private k m(RecyclerView.p pVar) {
        k kVar = this.f6609e;
        if (kVar == null || kVar.f6605a != pVar) {
            this.f6609e = k.a(pVar);
        }
        return this.f6609e;
    }

    private k n(RecyclerView.p pVar) {
        if (pVar.l()) {
            return o(pVar);
        }
        if (pVar.k()) {
            return m(pVar);
        }
        return null;
    }

    private k o(RecyclerView.p pVar) {
        k kVar = this.f6608d;
        if (kVar == null || kVar.f6605a != pVar) {
            this.f6608d = k.c(pVar);
        }
        return this.f6608d;
    }

    private boolean p(RecyclerView.p pVar, int i3, int i4) {
        return pVar.k() ? i3 > 0 : i4 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean q(RecyclerView.p pVar) {
        PointF a3;
        int Y2 = pVar.Y();
        if (!(pVar instanceof RecyclerView.A.b) || (a3 = ((RecyclerView.A.b) pVar).a(Y2 - 1)) == null) {
            return false;
        }
        return a3.x < 0.0f || a3.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.p
    public int[] c(RecyclerView.p pVar, View view) {
        int[] iArr = new int[2];
        if (pVar.k()) {
            iArr[0] = k(view, m(pVar));
        } else {
            iArr[0] = 0;
        }
        if (pVar.l()) {
            iArr[1] = k(view, o(pVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.p
    protected RecyclerView.A d(RecyclerView.p pVar) {
        if (pVar instanceof RecyclerView.A.b) {
            return new a(this.f6614a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.p
    public View f(RecyclerView.p pVar) {
        if (pVar.l()) {
            return l(pVar, o(pVar));
        }
        if (pVar.k()) {
            return l(pVar, m(pVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.p
    public int g(RecyclerView.p pVar, int i3, int i4) {
        k n3;
        int Y2 = pVar.Y();
        if (Y2 == 0 || (n3 = n(pVar)) == null) {
            return -1;
        }
        int J3 = pVar.J();
        View view = null;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i7 = 0; i7 < J3; i7++) {
            View I3 = pVar.I(i7);
            if (I3 != null) {
                int k3 = k(I3, n3);
                if (k3 <= 0 && k3 > i6) {
                    view2 = I3;
                    i6 = k3;
                }
                if (k3 >= 0 && k3 < i5) {
                    view = I3;
                    i5 = k3;
                }
            }
        }
        boolean p3 = p(pVar, i3, i4);
        if (p3 && view != null) {
            return pVar.j0(view);
        }
        if (!p3 && view2 != null) {
            return pVar.j0(view2);
        }
        if (p3) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int j02 = pVar.j0(view) + (q(pVar) == p3 ? -1 : 1);
        if (j02 < 0 || j02 >= Y2) {
            return -1;
        }
        return j02;
    }
}
