package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class p extends RecyclerView.s {

    /* renamed from: a, reason: collision with root package name */
    RecyclerView f6614a;

    /* renamed from: b, reason: collision with root package name */
    private Scroller f6615b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView.u f6616c = new a();

    class a extends RecyclerView.u {

        /* renamed from: a, reason: collision with root package name */
        boolean f6617a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && this.f6617a) {
                this.f6617a = false;
                p.this.j();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
            if (i3 == 0 && i4 == 0) {
                return;
            }
            this.f6617a = true;
        }
    }

    private void e() {
        this.f6614a.removeOnScrollListener(this.f6616c);
        this.f6614a.setOnFlingListener(null);
    }

    private void h() {
        if (this.f6614a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f6614a.addOnScrollListener(this.f6616c);
        this.f6614a.setOnFlingListener(this);
    }

    private boolean i(RecyclerView.p pVar, int i3, int i4) {
        RecyclerView.A d3;
        int g3;
        if (!(pVar instanceof RecyclerView.A.b) || (d3 = d(pVar)) == null || (g3 = g(pVar, i3, i4)) == -1) {
            return false;
        }
        d3.p(g3);
        pVar.M1(d3);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(int i3, int i4) {
        RecyclerView.p layoutManager = this.f6614a.getLayoutManager();
        if (layoutManager == null || this.f6614a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f6614a.getMinFlingVelocity();
        return (Math.abs(i4) > minFlingVelocity || Math.abs(i3) > minFlingVelocity) && i(layoutManager, i3, i4);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6614a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.f6614a = recyclerView;
        if (recyclerView != null) {
            h();
            this.f6615b = new Scroller(this.f6614a.getContext(), new DecelerateInterpolator());
            j();
        }
    }

    public abstract int[] c(RecyclerView.p pVar, View view);

    protected abstract RecyclerView.A d(RecyclerView.p pVar);

    public abstract View f(RecyclerView.p pVar);

    public abstract int g(RecyclerView.p pVar, int i3, int i4);

    void j() {
        RecyclerView.p layoutManager;
        View f3;
        RecyclerView recyclerView = this.f6614a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (f3 = f(layoutManager)) == null) {
            return;
        }
        int[] c3 = c(layoutManager, f3);
        int i3 = c3[0];
        if (i3 == 0 && c3[1] == 0) {
            return;
        }
        this.f6614a.smoothScrollBy(i3, c3[1]);
    }
}
