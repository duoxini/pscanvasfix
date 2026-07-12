package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class g implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    static final ThreadLocal f6572i = new ThreadLocal();

    /* renamed from: j, reason: collision with root package name */
    static Comparator f6573j = new a();

    /* renamed from: f, reason: collision with root package name */
    long f6575f;

    /* renamed from: g, reason: collision with root package name */
    long f6576g;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f6574e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f6577h = new ArrayList();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f6585d;
            if ((recyclerView == null) != (cVar2.f6585d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z3 = cVar.f6582a;
            if (z3 != cVar2.f6582a) {
                return z3 ? -1 : 1;
            }
            int i3 = cVar2.f6583b - cVar.f6583b;
            if (i3 != 0) {
                return i3;
            }
            int i4 = cVar.f6584c - cVar2.f6584c;
            if (i4 != 0) {
                return i4;
            }
            return 0;
        }
    }

    static class b implements RecyclerView.p.c {

        /* renamed from: a, reason: collision with root package name */
        int f6578a;

        /* renamed from: b, reason: collision with root package name */
        int f6579b;

        /* renamed from: c, reason: collision with root package name */
        int[] f6580c;

        /* renamed from: d, reason: collision with root package name */
        int f6581d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p.c
        public void a(int i3, int i4) {
            if (i3 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i5 = this.f6581d;
            int i6 = i5 * 2;
            int[] iArr = this.f6580c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f6580c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i6 >= iArr.length) {
                int[] iArr3 = new int[i5 * 4];
                this.f6580c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f6580c;
            iArr4[i6] = i3;
            iArr4[i6 + 1] = i4;
            this.f6581d++;
        }

        void b() {
            int[] iArr = this.f6580c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6581d = 0;
        }

        void c(RecyclerView recyclerView, boolean z3) {
            this.f6581d = 0;
            int[] iArr = this.f6580c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.p pVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || pVar == null || !pVar.w0()) {
                return;
            }
            if (z3) {
                if (!recyclerView.mAdapterHelper.p()) {
                    pVar.p(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                pVar.o(this.f6578a, this.f6579b, recyclerView.mState, this);
            }
            int i3 = this.f6581d;
            if (i3 > pVar.f6366m) {
                pVar.f6366m = i3;
                pVar.f6367n = z3;
                recyclerView.mRecycler.K();
            }
        }

        boolean d(int i3) {
            if (this.f6580c != null) {
                int i4 = this.f6581d * 2;
                for (int i5 = 0; i5 < i4; i5 += 2) {
                    if (this.f6580c[i5] == i3) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i3, int i4) {
            this.f6578a = i3;
            this.f6579b = i4;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6582a;

        /* renamed from: b, reason: collision with root package name */
        public int f6583b;

        /* renamed from: c, reason: collision with root package name */
        public int f6584c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f6585d;

        /* renamed from: e, reason: collision with root package name */
        public int f6586e;

        c() {
        }

        public void a() {
            this.f6582a = false;
            this.f6583b = 0;
            this.f6584c = 0;
            this.f6585d = null;
            this.f6586e = 0;
        }
    }

    g() {
    }

    private void b() {
        c cVar;
        int size = this.f6574e.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView = (RecyclerView) this.f6574e.get(i4);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i3 += recyclerView.mPrefetchRegistry.f6581d;
            }
        }
        this.f6577h.ensureCapacity(i3);
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f6574e.get(i6);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f6578a) + Math.abs(bVar.f6579b);
                for (int i7 = 0; i7 < bVar.f6581d * 2; i7 += 2) {
                    if (i5 >= this.f6577h.size()) {
                        cVar = new c();
                        this.f6577h.add(cVar);
                    } else {
                        cVar = (c) this.f6577h.get(i5);
                    }
                    int[] iArr = bVar.f6580c;
                    int i8 = iArr[i7 + 1];
                    cVar.f6582a = i8 <= abs;
                    cVar.f6583b = abs;
                    cVar.f6584c = i8;
                    cVar.f6585d = recyclerView2;
                    cVar.f6586e = iArr[i7];
                    i5++;
                }
            }
        }
        Collections.sort(this.f6577h, f6573j);
    }

    private void c(c cVar, long j3) {
        RecyclerView.E i3 = i(cVar.f6585d, cVar.f6586e, cVar.f6582a ? Long.MAX_VALUE : j3);
        if (i3 == null || i3.mNestedRecyclerView == null || !i3.isBound() || i3.isInvalid()) {
            return;
        }
        h(i3.mNestedRecyclerView.get(), j3);
    }

    private void d(long j3) {
        for (int i3 = 0; i3 < this.f6577h.size(); i3++) {
            c cVar = (c) this.f6577h.get(i3);
            if (cVar.f6585d == null) {
                return;
            }
            c(cVar, j3);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i3) {
        int j3 = recyclerView.mChildHelper.j();
        for (int i4 = 0; i4 < j3; i4++) {
            RecyclerView.E childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i4));
            if (childViewHolderInt.mPosition == i3 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j3) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f6581d != 0) {
            try {
                androidx.core.os.i.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i3 = 0; i3 < bVar.f6581d * 2; i3 += 2) {
                    i(recyclerView, bVar.f6580c[i3], j3);
                }
            } finally {
                androidx.core.os.i.b();
            }
        }
    }

    private RecyclerView.E i(RecyclerView recyclerView, int i3, long j3) {
        if (e(recyclerView, i3)) {
            return null;
        }
        RecyclerView.w wVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.E I3 = wVar.I(i3, false, j3);
            if (I3 != null) {
                if (!I3.isBound() || I3.isInvalid()) {
                    wVar.a(I3, false);
                } else {
                    wVar.B(I3.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return I3;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f6574e.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i3, int i4) {
        if (recyclerView.isAttachedToWindow() && this.f6575f == 0) {
            this.f6575f = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i3, i4);
    }

    void g(long j3) {
        b();
        d(j3);
    }

    public void j(RecyclerView recyclerView) {
        this.f6574e.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.i.a("RV Prefetch");
            if (!this.f6574e.isEmpty()) {
                int size = this.f6574e.size();
                long j3 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = (RecyclerView) this.f6574e.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j3 = Math.max(recyclerView.getDrawingTime(), j3);
                    }
                }
                if (j3 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j3) + this.f6576g);
                    this.f6575f = 0L;
                    androidx.core.os.i.b();
                }
            }
        } finally {
            this.f6575f = 0L;
            androidx.core.os.i.b();
        }
    }
}
