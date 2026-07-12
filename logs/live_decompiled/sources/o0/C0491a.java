package o0;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.preference.Preference;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;

/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0491a {

    /* renamed from: a, reason: collision with root package name */
    private COUIRecyclerView f12611a;

    /* renamed from: c, reason: collision with root package name */
    private k f12613c;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView.p f12614d;

    /* renamed from: e, reason: collision with root package name */
    private Context f12615e;

    /* renamed from: b, reason: collision with root package name */
    private int f12612b = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12616f = true;

    /* renamed from: g, reason: collision with root package name */
    private Interpolator f12617g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f12618h = 0;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView.u f12619i = new C0139a();

    /* renamed from: o0.a$a, reason: collision with other inner class name */
    class C0139a extends RecyclerView.u {

        /* renamed from: a, reason: collision with root package name */
        boolean f12620a = false;

        C0139a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && this.f12620a) {
                this.f12620a = false;
                C0491a.this.o();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
            if (i3 == 0 && i4 == 0) {
                return;
            }
            this.f12620a = true;
        }
    }

    private float d(RecyclerView.p pVar, k kVar) {
        int J3 = pVar.J();
        if (J3 == 0) {
            return 1.0f;
        }
        View view = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < J3; i5++) {
            View I3 = pVar.I(i5);
            int j02 = pVar.j0(I3);
            if (j02 != -1 && j02 != pVar.Y() - 1 && j02 != 0) {
                if (j02 < i4) {
                    view = I3;
                    i4 = j02;
                }
                if (j02 > i3) {
                    view2 = I3;
                    i3 = j02;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(kVar.d(view), kVar.d(view2)) - Math.min(kVar.g(view), kVar.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i3 - i4) + 1);
    }

    private View e(RecyclerView.p pVar, k kVar) {
        int J3 = pVar.J();
        View view = null;
        if (J3 == 0) {
            return null;
        }
        int n3 = kVar.n() + (kVar.o() / 2);
        int i3 = Preference.DEFAULT_ORDER;
        for (int i4 = 0; i4 < J3; i4++) {
            View I3 = pVar.I(i4);
            int abs = Math.abs((pVar.Q(I3) + (pVar.S(I3) / 2)) - n3);
            if (abs < i3) {
                view = I3;
                i3 = abs;
            }
        }
        return view;
    }

    private View g(RecyclerView.p pVar, k kVar) {
        int J3 = pVar.J();
        View view = null;
        if (J3 == 0) {
            return null;
        }
        if (pVar instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) pVar;
            boolean z3 = linearLayoutManager.Y1() == pVar.Y() - 1;
            boolean z4 = linearLayoutManager.d2() == pVar.Y() - 1;
            if (z3 || z4) {
                return null;
            }
        }
        int i3 = l(this.f12615e) ? kVar.i() : kVar.n();
        int i4 = Preference.DEFAULT_ORDER;
        for (int i5 = 0; i5 < J3; i5++) {
            View I3 = pVar.I(i5);
            int abs = Math.abs((l(this.f12615e) ? kVar.d(I3) : kVar.g(I3)) - i3);
            if (abs < i4) {
                view = I3;
                i4 = abs;
            }
        }
        return view;
    }

    private k h(RecyclerView.p pVar) {
        k kVar = this.f12613c;
        if (kVar == null || kVar.k() != pVar) {
            this.f12613c = k.a(pVar);
        }
        return this.f12613c;
    }

    private RecyclerView.p j() {
        RecyclerView.p pVar = this.f12614d;
        if (pVar == null || pVar != this.f12611a.getLayoutManager()) {
            this.f12614d = this.f12611a.getLayoutManager();
        }
        return this.f12614d;
    }

    private boolean l(Context context) {
        return context != null && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    private void n(int i3, int i4) {
        int i5;
        Interpolator interpolator = this.f12617g;
        if (interpolator == null || (i5 = this.f12618h) == 0) {
            this.f12611a.smoothScrollBy(i3, i4);
        } else {
            this.f12611a.smoothScrollBy(i3, i4, interpolator, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        RecyclerView.p j3;
        View f3;
        int g3;
        int n3;
        if ((!this.f12616f && this.f12612b == 2) || (j3 = j()) == null || (f3 = f(j3)) == null) {
            return;
        }
        int i3 = this.f12612b;
        if (i3 == 2) {
            int n4 = h(j3).n() + (h(j3).o() / 2);
            int Y2 = j3.Y() - 1;
            if (j3.j0(f3) == 0) {
                n4 = l(this.f12615e) ? h(j3).i() - (h(j3).e(f3) / 2) : h(j3).n() + (h(j3).e(f3) / 2);
            }
            if (j3.j0(f3) == Y2) {
                n4 = l(this.f12615e) ? h(j3).n() + (h(j3).e(f3) / 2) : h(j3).i() - (h(j3).e(f3) / 2);
            }
            int g4 = (h(j3).g(f3) + (h(j3).e(f3) / 2)) - n4;
            if (Math.abs(g4) > 1.0f) {
                n(g4, 0);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (l(this.f12615e)) {
                g3 = h(j3).d(f3);
                n3 = h(j3).i();
            } else {
                g3 = h(j3).g(f3);
                n3 = h(j3).n();
            }
            int i4 = g3 - n3;
            if (Math.abs(i4) > 1.0f) {
                n(i4, 0);
            }
        }
    }

    public void b(COUIRecyclerView cOUIRecyclerView) {
        this.f12611a = cOUIRecyclerView;
        this.f12615e = cOUIRecyclerView.getContext();
    }

    public void c() {
        this.f12612b = 0;
        this.f12611a.removeOnScrollListener(this.f12619i);
    }

    public View f(RecyclerView.p pVar) {
        if (pVar.k()) {
            int i3 = this.f12612b;
            if (i3 == 2) {
                return e(pVar, h(pVar));
            }
            if (i3 == 1) {
                return g(pVar, h(pVar));
            }
        }
        return null;
    }

    public int i() {
        return this.f12612b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int k(int i3) {
        View f3;
        float f4;
        int i4;
        int g3;
        RecyclerView.p j3 = j();
        int Y2 = j3.Y();
        if (Y2 == 0 || (f3 = f(j3)) == null) {
            return -1;
        }
        int j02 = j3.j0(f3);
        int i5 = Y2 - 1;
        PointF a3 = ((RecyclerView.A.b) j3).a(i5);
        if (a3 == null) {
            return -1;
        }
        if (j3.k()) {
            f4 = d(j3, h(j3));
            i4 = Math.round(i3 / f4);
            if (a3.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            f4 = 1.0f;
            i4 = 0;
        }
        int i6 = i4 + j02;
        if (i6 != j02 && i6 >= 0 && i6 < Y2) {
            int i7 = this.f12612b;
            if (i7 == 2) {
                View I3 = (j3.j0(f3) != 0 || j3.J() == 0) ? null : j3.I(j3.J() - 1);
                if (j3.j0(f3) == i5 && j3.J() != 0) {
                    I3 = j3.I(0);
                }
                int n3 = h(j3).n() + (h(j3).o() / 2);
                if (I3 != null) {
                    g3 = h(j3).g(I3) + (h(j3).e(I3) / 2) + (l(this.f12615e) ? -((int) ((i6 - j3.j0(I3)) * f4)) : (int) ((i6 - j3.j0(I3)) * f4));
                } else {
                    g3 = h(j3).g(f3) + (h(j3).e(f3) / 2) + (l(this.f12615e) ? -((int) ((i6 - j3.j0(f3)) * f4)) : (int) ((i6 - j3.j0(f3)) * f4));
                }
                return g3 - n3;
            }
            if (i7 == 1) {
                int i8 = i6 - j02;
                return ((l(this.f12615e) ? h(j3).d(f3) : h(j3).g(f3)) + (l(this.f12615e) ? -((int) (i8 * f4)) : (int) (i8 * f4))) - (l(this.f12615e) ? h(j3).i() : h(j3).n());
            }
        }
        return -1;
    }

    public void m(int i3) {
        this.f12612b = i3;
        this.f12611a.addOnScrollListener(this.f12619i);
    }

    public void p() {
        if (this.f12612b != 0) {
            o();
        }
    }
}
