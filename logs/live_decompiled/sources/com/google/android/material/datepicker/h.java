package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.C0252a;
import androidx.core.view.y;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class h<S> extends o {

    /* renamed from: o, reason: collision with root package name */
    static final Object f9642o = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: p, reason: collision with root package name */
    static final Object f9643p = "NAVIGATION_PREV_TAG";

    /* renamed from: q, reason: collision with root package name */
    static final Object f9644q = "NAVIGATION_NEXT_TAG";

    /* renamed from: r, reason: collision with root package name */
    static final Object f9645r = "SELECTOR_TOGGLE_TAG";

    /* renamed from: f, reason: collision with root package name */
    private int f9646f;

    /* renamed from: g, reason: collision with root package name */
    private com.google.android.material.datepicker.a f9647g;

    /* renamed from: h, reason: collision with root package name */
    private com.google.android.material.datepicker.k f9648h;

    /* renamed from: i, reason: collision with root package name */
    private k f9649i;

    /* renamed from: j, reason: collision with root package name */
    private com.google.android.material.datepicker.c f9650j;

    /* renamed from: k, reason: collision with root package name */
    private RecyclerView f9651k;

    /* renamed from: l, reason: collision with root package name */
    private RecyclerView f9652l;

    /* renamed from: m, reason: collision with root package name */
    private View f9653m;

    /* renamed from: n, reason: collision with root package name */
    private View f9654n;

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f9655e;

        a(int i3) {
            this.f9655e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f9652l.smoothScrollToPosition(this.f9655e);
        }
    }

    class b extends C0252a {
        b() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.S(null);
        }
    }

    class c extends p {

        /* renamed from: I, reason: collision with root package name */
        final /* synthetic */ int f9658I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i3, boolean z3, int i4) {
            super(context, i3, z3);
            this.f9658I = i4;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void P1(RecyclerView.B b3, int[] iArr) {
            if (this.f9658I == 0) {
                iArr[0] = h.this.f9652l.getWidth();
                iArr[1] = h.this.f9652l.getWidth();
            } else {
                iArr[0] = h.this.f9652l.getHeight();
                iArr[1] = h.this.f9652l.getHeight();
            }
        }
    }

    class d implements l {
        d() {
        }

        @Override // com.google.android.material.datepicker.h.l
        public void a(long j3) {
            if (h.this.f9647g.g().a(j3)) {
                h.k(h.this);
                throw null;
            }
        }
    }

    class e extends RecyclerView.o {

        /* renamed from: a, reason: collision with root package name */
        private final Calendar f9661a = r.i();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f9662b = r.i();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.B b3) {
            if ((recyclerView.getAdapter() instanceof s) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                h.k(h.this);
                throw null;
            }
        }
    }

    class f extends C0252a {
        f() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.b0(h.this.f9654n.getVisibility() == 0 ? h.this.getString(H0.h.f634o) : h.this.getString(H0.h.f632m));
        }
    }

    class g extends RecyclerView.u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f9665a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f9666b;

        g(m mVar, MaterialButton materialButton) {
            this.f9665a = mVar;
            this.f9666b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                recyclerView.announceForAccessibility(this.f9666b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
            int c22 = i3 < 0 ? h.this.v().c2() : h.this.v().f2();
            h.this.f9648h = this.f9665a.g(c22);
            this.f9666b.setText(this.f9665a.h(c22));
        }
    }

    /* renamed from: com.google.android.material.datepicker.h$h, reason: collision with other inner class name */
    class ViewOnClickListenerC0122h implements View.OnClickListener {
        ViewOnClickListenerC0122h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.A();
        }
    }

    class i implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f9669e;

        i(m mVar) {
            this.f9669e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c22 = h.this.v().c2() + 1;
            if (c22 < h.this.f9652l.getAdapter().getItemCount()) {
                h.this.y(this.f9669e.g(c22));
            }
        }
    }

    class j implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f9671e;

        j(m mVar) {
            this.f9671e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int f22 = h.this.v().f2() - 1;
            if (f22 >= 0) {
                h.this.y(this.f9671e.g(f22));
            }
        }
    }

    enum k {
        DAY,
        YEAR
    }

    interface l {
        void a(long j3);
    }

    static /* synthetic */ com.google.android.material.datepicker.d k(h hVar) {
        hVar.getClass();
        return null;
    }

    private void n(View view, m mVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(H0.e.f585r);
        materialButton.setTag(f9645r);
        y.j0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(H0.e.f587t);
        materialButton2.setTag(f9643p);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(H0.e.f586s);
        materialButton3.setTag(f9644q);
        this.f9653m = view.findViewById(H0.e.f551A);
        this.f9654n = view.findViewById(H0.e.f589v);
        z(k.DAY);
        materialButton.setText(this.f9648h.j());
        this.f9652l.addOnScrollListener(new g(mVar, materialButton));
        materialButton.setOnClickListener(new ViewOnClickListenerC0122h());
        materialButton3.setOnClickListener(new i(mVar));
        materialButton2.setOnClickListener(new j(mVar));
    }

    private RecyclerView.o o() {
        return new e();
    }

    static int t(Context context) {
        return context.getResources().getDimensionPixelSize(H0.c.f543z);
    }

    private static int u(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(H0.c.f507G) + resources.getDimensionPixelOffset(H0.c.f508H) + resources.getDimensionPixelOffset(H0.c.f506F);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(H0.c.f502B);
        int i3 = com.google.android.material.datepicker.l.f9716i;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(H0.c.f543z) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(H0.c.f505E)) + resources.getDimensionPixelOffset(H0.c.f541x);
    }

    public static h w(com.google.android.material.datepicker.d dVar, int i3, com.google.android.material.datepicker.a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.j());
        hVar.setArguments(bundle);
        return hVar;
    }

    private void x(int i3) {
        this.f9652l.post(new a(i3));
    }

    void A() {
        k kVar = this.f9649i;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            z(k.DAY);
        } else if (kVar == k.DAY) {
            z(kVar2);
        }
    }

    @Override // com.google.android.material.datepicker.o
    public boolean g(n nVar) {
        return super.g(nVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9646f = bundle.getInt("THEME_RES_ID_KEY");
        androidx.appcompat.app.p.a(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f9647g = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f9648h = (com.google.android.material.datepicker.k) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i4;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f9646f);
        this.f9650j = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.k k3 = this.f9647g.k();
        if (com.google.android.material.datepicker.i.r(contextThemeWrapper)) {
            i3 = H0.g.f616u;
            i4 = 1;
        } else {
            i3 = H0.g.f614s;
            i4 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        inflate.setMinimumHeight(u(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(H0.e.f590w);
        y.j0(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.g());
        gridView.setNumColumns(k3.f9712h);
        gridView.setEnabled(false);
        this.f9652l = (RecyclerView) inflate.findViewById(H0.e.f593z);
        this.f9652l.setLayoutManager(new c(getContext(), i4, false, i4));
        this.f9652l.setTag(f9642o);
        m mVar = new m(contextThemeWrapper, null, this.f9647g, new d());
        this.f9652l.setAdapter(mVar);
        int integer = contextThemeWrapper.getResources().getInteger(H0.f.f595b);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(H0.e.f551A);
        this.f9651k = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f9651k.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f9651k.setAdapter(new s(this));
            this.f9651k.addItemDecoration(o());
        }
        if (inflate.findViewById(H0.e.f585r) != null) {
            n(inflate, mVar);
        }
        if (!com.google.android.material.datepicker.i.r(contextThemeWrapper)) {
            new androidx.recyclerview.widget.l().b(this.f9652l);
        }
        this.f9652l.scrollToPosition(mVar.i(this.f9648h));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f9646f);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f9647g);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f9648h);
    }

    com.google.android.material.datepicker.a p() {
        return this.f9647g;
    }

    com.google.android.material.datepicker.c q() {
        return this.f9650j;
    }

    com.google.android.material.datepicker.k r() {
        return this.f9648h;
    }

    public com.google.android.material.datepicker.d s() {
        return null;
    }

    LinearLayoutManager v() {
        return (LinearLayoutManager) this.f9652l.getLayoutManager();
    }

    void y(com.google.android.material.datepicker.k kVar) {
        m mVar = (m) this.f9652l.getAdapter();
        int i3 = mVar.i(kVar);
        int i4 = i3 - mVar.i(this.f9648h);
        boolean z3 = Math.abs(i4) > 3;
        boolean z4 = i4 > 0;
        this.f9648h = kVar;
        if (z3 && z4) {
            this.f9652l.scrollToPosition(i3 - 3);
            x(i3);
        } else if (!z3) {
            x(i3);
        } else {
            this.f9652l.scrollToPosition(i3 + 3);
            x(i3);
        }
    }

    void z(k kVar) {
        this.f9649i = kVar;
        if (kVar == k.YEAR) {
            this.f9651k.getLayoutManager().A1(((s) this.f9651k.getAdapter()).f(this.f9648h.f9711g));
            this.f9653m.setVisibility(0);
            this.f9654n.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f9653m.setVisibility(8);
            this.f9654n.setVisibility(0);
            y(this.f9648h);
        }
    }
}
