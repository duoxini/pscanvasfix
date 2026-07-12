package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import androidx.core.view.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: y, reason: collision with root package name */
    static boolean f6775y = true;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f6776e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f6777f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.viewpager2.widget.b f6778g;

    /* renamed from: h, reason: collision with root package name */
    int f6779h;

    /* renamed from: i, reason: collision with root package name */
    boolean f6780i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView.j f6781j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayoutManager f6782k;

    /* renamed from: l, reason: collision with root package name */
    private int f6783l;

    /* renamed from: m, reason: collision with root package name */
    private Parcelable f6784m;

    /* renamed from: n, reason: collision with root package name */
    RecyclerView f6785n;

    /* renamed from: o, reason: collision with root package name */
    private androidx.recyclerview.widget.l f6786o;

    /* renamed from: p, reason: collision with root package name */
    androidx.viewpager2.widget.e f6787p;

    /* renamed from: q, reason: collision with root package name */
    private androidx.viewpager2.widget.b f6788q;

    /* renamed from: r, reason: collision with root package name */
    private androidx.viewpager2.widget.c f6789r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.viewpager2.widget.d f6790s;

    /* renamed from: t, reason: collision with root package name */
    private RecyclerView.m f6791t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6792u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6793v;

    /* renamed from: w, reason: collision with root package name */
    private int f6794w;

    /* renamed from: x, reason: collision with root package name */
    e f6795x;

    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f6780i = true;
            viewPager2.f6787p.j();
        }
    }

    class b extends i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0) {
                ViewPager2.this.n();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i3) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f6779h != i3) {
                viewPager2.f6779h = i3;
                viewPager2.f6795x.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i3) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f6785n.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.r {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void a(View view) {
            RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) qVar).width != -1 || ((ViewGroup.MarginLayoutParams) qVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void b(View view) {
        }
    }

    private abstract class e {
        private e() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i3) {
            return false;
        }

        boolean c(int i3, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.h hVar) {
        }

        void f(RecyclerView.h hVar) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(androidx.core.view.accessibility.d dVar) {
        }

        boolean k(int i3) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i3, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i3) {
            return (i3 == 8192 || i3 == 4096) && !ViewPager2.this.e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(androidx.core.view.accessibility.d dVar) {
            if (ViewPager2.this.e()) {
                return;
            }
            dVar.K(d.a.f5094r);
            dVar.K(d.a.f5093q);
            dVar.j0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i3) {
            if (b(i3)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.j {
        private g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void b(int i3, int i4, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void c(int i3, int i4) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void d(int i3, int i4, int i5) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void e(int i3, int i4) {
            a();
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void P0(RecyclerView.w wVar, RecyclerView.B b3, androidx.core.view.accessibility.d dVar) {
            super.P0(wVar, b3, dVar);
            ViewPager2.this.f6795x.j(dVar);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void P1(RecyclerView.B b3, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.P1(b3, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public boolean j1(RecyclerView.w wVar, RecyclerView.B b3, int i3, Bundle bundle) {
            return ViewPager2.this.f6795x.b(i3) ? ViewPager2.this.f6795x.k(i3) : super.j1(wVar, b3, i3, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public boolean v1(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
            return false;
        }
    }

    public static abstract class i {
        public void onPageScrollStateChanged(int i3) {
        }

        public void onPageScrolled(int i3, float f3, int i4) {
        }

        public abstract void onPageSelected(int i3);
    }

    class j extends e {

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.view.accessibility.g f6803b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.core.view.accessibility.g f6804c;

        /* renamed from: d, reason: collision with root package name */
        private RecyclerView.j f6805d;

        class a implements androidx.core.view.accessibility.g {
            a() {
            }

            @Override // androidx.core.view.accessibility.g
            public boolean perform(View view, g.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements androidx.core.view.accessibility.g {
            b() {
            }

            @Override // androidx.core.view.accessibility.g
            public boolean perform(View view, g.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.j
            public void a() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, null);
            this.f6803b = new a();
            this.f6804c = new b();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i3;
            int i4;
            if (ViewPager2.this.getAdapter() == null) {
                i3 = 0;
                i4 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i3 = ViewPager2.this.getAdapter().getItemCount();
                i4 = 0;
            } else {
                i4 = ViewPager2.this.getAdapter().getItemCount();
                i3 = 0;
            }
            androidx.core.view.accessibility.d.r0(accessibilityNodeInfo).S(d.b.b(i3, i4, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.h adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.f6779h > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f6779h < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i3, Bundle bundle) {
            return i3 == 8192 || i3 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.h hVar) {
            w();
            if (hVar != null) {
                hVar.registerAdapterDataObserver(this.f6805d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.h hVar) {
            if (hVar != null) {
                hVar.unregisterAdapterDataObserver(this.f6805d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            y.u0(recyclerView, 2);
            this.f6805d = new c();
            if (y.v(ViewPager2.this) == 0) {
                y.u0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i3, Bundle bundle) {
            if (!c(i3, bundle)) {
                throw new IllegalStateException();
            }
            v(i3 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        void v(int i3) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i3, true);
            }
        }

        void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i3 = R.id.accessibilityActionPageLeft;
            y.c0(viewPager2, R.id.accessibilityActionPageLeft);
            y.c0(viewPager2, R.id.accessibilityActionPageRight);
            y.c0(viewPager2, R.id.accessibilityActionPageUp);
            y.c0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f6779h < itemCount - 1) {
                    y.e0(viewPager2, new d.a(R.id.accessibilityActionPageDown, null), null, this.f6803b);
                }
                if (ViewPager2.this.f6779h > 0) {
                    y.e0(viewPager2, new d.a(R.id.accessibilityActionPageUp, null), null, this.f6804c);
                    return;
                }
                return;
            }
            boolean d3 = ViewPager2.this.d();
            int i4 = d3 ? 16908360 : 16908361;
            if (d3) {
                i3 = 16908361;
            }
            if (ViewPager2.this.f6779h < itemCount - 1) {
                y.e0(viewPager2, new d.a(i4, null), null, this.f6803b);
            }
            if (ViewPager2.this.f6779h > 0) {
                y.e0(viewPager2, new d.a(i3, null), null, this.f6804c);
            }
        }
    }

    public interface k {
    }

    private class l extends androidx.recyclerview.widget.l {
        l() {
        }

        @Override // androidx.recyclerview.widget.l, androidx.recyclerview.widget.p
        public View f(RecyclerView.p pVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.f(pVar);
        }
    }

    private class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f6795x.d() ? ViewPager2.this.f6795x.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f6779h);
            accessibilityEvent.setToIndex(ViewPager2.this.f6779h);
            ViewPager2.this.f6795x.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    private static class o implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final int f6815e;

        /* renamed from: f, reason: collision with root package name */
        private final RecyclerView f6816f;

        o(int i3, RecyclerView recyclerView) {
            this.f6815e = i3;
            this.f6816f = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6816f.smoothScrollToPosition(this.f6815e);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6776e = new Rect();
        this.f6777f = new Rect();
        this.f6778g = new androidx.viewpager2.widget.b(3);
        this.f6780i = false;
        this.f6781j = new a();
        this.f6783l = -1;
        this.f6791t = null;
        this.f6792u = false;
        this.f6793v = true;
        this.f6794w = -1;
        b(context, attributeSet);
    }

    private RecyclerView.r a() {
        return new d();
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f6795x = f6775y ? new j() : new f();
        m mVar = new m(context);
        this.f6785n = mVar;
        mVar.setId(y.i());
        this.f6785n.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f6782k = hVar;
        this.f6785n.setLayoutManager(hVar);
        this.f6785n.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f6785n.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f6785n.addOnChildAttachStateChangeListener(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f6787p = eVar;
        this.f6789r = new androidx.viewpager2.widget.c(this, eVar, this.f6785n);
        l lVar = new l();
        this.f6786o = lVar;
        lVar.b(this.f6785n);
        this.f6785n.addOnScrollListener(this.f6787p);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f6788q = bVar;
        this.f6787p.m(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f6788q.a(bVar2);
        this.f6788q.a(cVar);
        this.f6795x.h(this.f6788q, this.f6785n);
        this.f6788q.a(this.f6778g);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f6782k);
        this.f6790s = dVar;
        this.f6788q.a(dVar);
        RecyclerView recyclerView = this.f6785n;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.h hVar) {
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.f6781j);
        }
    }

    private void i() {
        RecyclerView.h adapter;
        if (this.f6783l == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        if (this.f6784m != null) {
            this.f6784m = null;
        }
        int max = Math.max(0, Math.min(this.f6783l, adapter.getItemCount() - 1));
        this.f6779h = max;
        this.f6783l = -1;
        this.f6785n.scrollToPosition(max);
        this.f6795x.m();
    }

    private void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, U.a.f2235g);
        saveAttributeDataForStyleable(context, U.a.f2235g, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(U.a.f2236h, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.h hVar) {
        if (hVar != null) {
            hVar.unregisterAdapterDataObserver(this.f6781j);
        }
    }

    public boolean c() {
        return this.f6789r.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        return this.f6785n.canScrollHorizontally(i3);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return this.f6785n.canScrollVertically(i3);
    }

    boolean d() {
        return this.f6782k.Z() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof n) {
            int i3 = ((n) parcelable).f6812e;
            sparseArray.put(this.f6785n.getId(), sparseArray.get(i3));
            sparseArray.remove(i3);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f6793v;
    }

    public void g(i iVar) {
        this.f6778g.a(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.f6795x.a() ? this.f6795x.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.h getAdapter() {
        return this.f6785n.getAdapter();
    }

    public int getCurrentItem() {
        return this.f6779h;
    }

    public int getItemDecorationCount() {
        return this.f6785n.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f6794w;
    }

    public int getOrientation() {
        return this.f6782k.q2();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f6785n;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f6787p.f();
    }

    public void h() {
        this.f6790s.a();
    }

    public void j(int i3, boolean z3) {
        if (c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        k(i3, z3);
    }

    void k(int i3, boolean z3) {
        RecyclerView.h adapter = getAdapter();
        if (adapter == null) {
            if (this.f6783l != -1) {
                this.f6783l = Math.max(i3, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i3, 0), adapter.getItemCount() - 1);
        if (min == this.f6779h && this.f6787p.h()) {
            return;
        }
        int i4 = this.f6779h;
        if (min == i4 && z3) {
            return;
        }
        double d3 = i4;
        this.f6779h = min;
        this.f6795x.q();
        if (!this.f6787p.h()) {
            d3 = this.f6787p.e();
        }
        this.f6787p.k(min, z3);
        if (!z3) {
            this.f6785n.scrollToPosition(min);
            return;
        }
        double d4 = min;
        if (Math.abs(d4 - d3) <= 3.0d) {
            this.f6785n.smoothScrollToPosition(min);
            return;
        }
        this.f6785n.scrollToPosition(d4 > d3 ? min - 3 : min + 3);
        RecyclerView recyclerView = this.f6785n;
        recyclerView.post(new o(min, recyclerView));
    }

    void n() {
        androidx.recyclerview.widget.l lVar = this.f6786o;
        if (lVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View f3 = lVar.f(this.f6782k);
        if (f3 == null) {
            return;
        }
        int j02 = this.f6782k.j0(f3);
        if (j02 != this.f6779h && getScrollState() == 0) {
            this.f6788q.onPageSelected(j02);
        }
        this.f6780i = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f6795x.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int measuredWidth = this.f6785n.getMeasuredWidth();
        int measuredHeight = this.f6785n.getMeasuredHeight();
        this.f6776e.left = getPaddingLeft();
        this.f6776e.right = (i5 - i3) - getPaddingRight();
        this.f6776e.top = getPaddingTop();
        this.f6776e.bottom = (i6 - i4) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f6776e, this.f6777f);
        RecyclerView recyclerView = this.f6785n;
        Rect rect = this.f6777f;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f6780i) {
            n();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        measureChild(this.f6785n, i3, i4);
        int measuredWidth = this.f6785n.getMeasuredWidth();
        int measuredHeight = this.f6785n.getMeasuredHeight();
        int measuredState = this.f6785n.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.onRestoreInstanceState(nVar.getSuperState());
        this.f6783l = nVar.f6813f;
        this.f6784m = nVar.f6814g;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        n nVar = new n(super.onSaveInstanceState());
        nVar.f6812e = this.f6785n.getId();
        int i3 = this.f6783l;
        if (i3 == -1) {
            i3 = this.f6779h;
        }
        nVar.f6813f = i3;
        Parcelable parcelable = this.f6784m;
        if (parcelable != null) {
            nVar.f6814g = parcelable;
        } else {
            this.f6785n.getAdapter();
        }
        return nVar;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        return this.f6795x.c(i3, bundle) ? this.f6795x.l(i3, bundle) : super.performAccessibilityAction(i3, bundle);
    }

    public void setAdapter(RecyclerView.h hVar) {
        RecyclerView.h adapter = this.f6785n.getAdapter();
        this.f6795x.f(adapter);
        m(adapter);
        this.f6785n.setAdapter(hVar);
        this.f6779h = 0;
        i();
        this.f6795x.e(hVar);
        f(hVar);
    }

    public void setCurrentItem(int i3) {
        j(i3, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        super.setLayoutDirection(i3);
        this.f6795x.p();
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1 && i3 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f6794w = i3;
        this.f6785n.requestLayout();
    }

    public void setOrientation(int i3) {
        this.f6782k.E2(i3);
        this.f6795x.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f6792u) {
                this.f6791t = this.f6785n.getItemAnimator();
                this.f6792u = true;
            }
            this.f6785n.setItemAnimator(null);
        } else if (this.f6792u) {
            this.f6785n.setItemAnimator(this.f6791t);
            this.f6791t = null;
            this.f6792u = false;
        }
        this.f6790s.a();
        if (kVar == null) {
            return;
        }
        this.f6790s.b(kVar);
        h();
    }

    public void setUserInputEnabled(boolean z3) {
        this.f6793v = z3;
        this.f6795x.s();
    }

    static class n extends View.BaseSavedState {
        public static final Parcelable.Creator<n> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f6812e;

        /* renamed from: f, reason: collision with root package name */
        int f6813f;

        /* renamed from: g, reason: collision with root package name */
        Parcelable f6814g;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i3) {
                return new n[i3];
            }
        }

        n(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            c(parcel, classLoader);
        }

        private void c(Parcel parcel, ClassLoader classLoader) {
            this.f6812e = parcel.readInt();
            this.f6813f = parcel.readInt();
            this.f6814g = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f6812e);
            parcel.writeInt(this.f6813f);
            parcel.writeParcelable(this.f6814g, i3);
        }

        n(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
