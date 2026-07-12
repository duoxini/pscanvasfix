package com.coui.appcompat.poplist;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.coui.appcompat.poplist.f;
import com.coui.appcompat.poplist.j;
import h0.AbstractC0371a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import r0.C0561c;
import r0.InterfaceC0564f;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class f extends k {

    /* renamed from: T, reason: collision with root package name */
    private static final boolean f8204T;

    /* renamed from: A, reason: collision with root package name */
    private int f8205A;

    /* renamed from: B, reason: collision with root package name */
    private int f8206B;

    /* renamed from: C, reason: collision with root package name */
    private int f8207C;

    /* renamed from: D, reason: collision with root package name */
    private int f8208D;

    /* renamed from: E, reason: collision with root package name */
    private int f8209E;

    /* renamed from: F, reason: collision with root package name */
    private int f8210F;

    /* renamed from: G, reason: collision with root package name */
    private int f8211G;

    /* renamed from: H, reason: collision with root package name */
    private int f8212H;

    /* renamed from: I, reason: collision with root package name */
    private int f8213I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f8214J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f8215K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f8216L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f8217M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f8218N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f8219O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f8220P;

    /* renamed from: Q, reason: collision with root package name */
    private PopupWindow.OnDismissListener f8221Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f8222R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f8223S;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnLayoutChangeListener f8224e;

    /* renamed from: f, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f8225f;

    /* renamed from: g, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f8226g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f8227h;

    /* renamed from: i, reason: collision with root package name */
    private Context f8228i;

    /* renamed from: j, reason: collision with root package name */
    private n f8229j;

    /* renamed from: k, reason: collision with root package name */
    private n f8230k;

    /* renamed from: l, reason: collision with root package name */
    private List f8231l;

    /* renamed from: m, reason: collision with root package name */
    private View f8232m;

    /* renamed from: n, reason: collision with root package name */
    private View f8233n;

    /* renamed from: o, reason: collision with root package name */
    private View f8234o;

    /* renamed from: p, reason: collision with root package name */
    private RoundFrameLayout f8235p;

    /* renamed from: q, reason: collision with root package name */
    private RoundFrameLayout f8236q;

    /* renamed from: r, reason: collision with root package name */
    private ListView f8237r;

    /* renamed from: s, reason: collision with root package name */
    private ListView f8238s;

    /* renamed from: t, reason: collision with root package name */
    private ListView f8239t;

    /* renamed from: u, reason: collision with root package name */
    private j f8240u;

    /* renamed from: v, reason: collision with root package name */
    private x f8241v;

    /* renamed from: w, reason: collision with root package name */
    private AdapterView.OnItemClickListener f8242w;

    /* renamed from: x, reason: collision with root package name */
    private AdapterView.OnItemClickListener f8243x;

    /* renamed from: y, reason: collision with root package name */
    private int f8244y;

    /* renamed from: z, reason: collision with root package name */
    private int f8245z;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            boolean z3 = (i3 == i7 && i4 == i8 && i5 == i9 && i6 == i10) ? false : true;
            AbstractC0371a.a("COUIPopupListWindow", "PopupWindow anchor layout changed! left:" + i3 + ",top:" + i4 + ",right:" + i5 + ",bottom:" + i6 + ",oldLeft:" + i7 + ",oldTop:" + i8 + ",oldRight:" + i9 + ",oldBottom:" + i10 + ",layoutChange:" + z3);
            if (z3) {
                if (f.this.f8214J || (f.this.f8215K && f.this.f8241v.x(f.this.f8232m, f.this.f8211G, f.this.f8212H, f.this.f8233n))) {
                    f.this.dismiss();
                }
            }
        }
    }

    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view, int i3) {
            f.this.y0(view, i3);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, final View view, int i3, long j3) {
            if (n.t(i3)) {
                final int z3 = n.z(i3);
                if (f.this.f8242w != null) {
                    f.this.f8242w.onItemClick(adapterView, view, z3, j3);
                }
                if (f.this.f8236q.getParent() == null || f.this.f8213I == z3) {
                    f.this.y0(view, z3);
                } else {
                    f.this.f8240u.p(false);
                    f.this.f8240u.s(new Runnable() { // from class: com.coui.appcompat.poplist.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.b.this.b(view, z3);
                        }
                    });
                }
            }
        }
    }

    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            int z3 = n.z(i3);
            if (f.this.f8241v.G()) {
                z3--;
            }
            int i4 = z3;
            if (i4 < 0) {
                f.this.f8240u.q(view);
            } else if (f.this.f8243x != null) {
                f.this.f8243x.onItemClick(adapterView, view, i4, j3);
            }
        }
    }

    class d implements j.b {
        d() {
        }

        private void k(ViewGroup viewGroup) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null) {
                childAt.performAccessibilityAction(64, null);
            }
        }

        private void l(ListView listView, boolean z3) {
            if (listView != null) {
                listView.setFocusable(false);
                for (int i3 = 0; i3 < listView.getChildCount(); i3++) {
                    listView.getChildAt(i3).setFocusable(z3);
                }
            }
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void a() {
            k(f.this.f8238s);
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void b() {
            k(f.this.f8237r);
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void c() {
            f.this.s0(false);
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void d() {
            f.this.s0(true);
            l(f.this.f8237r, false);
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void e() {
            f.this.s0(false);
            l(f.this.f8237r, true);
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void f() {
            if (f.this.f8234o != null) {
                if (f.this.f8238s != null && f.this.f8238s.getChildAt(0) != null) {
                    f.this.f8238s.getChildAt(0).setBackground(null);
                }
                f.this.f8234o = null;
            }
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void g() {
            f.this.f8219O = false;
            f.this.f8234o = null;
            f fVar = f.this;
            fVar.f0(false, fVar.f8232m);
            f.this.f8244y = 0;
            f.this.f8245z = 0;
            f.super.dismiss();
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void h() {
            f.this.f8219O = false;
            if (f.this.f8222R) {
                f.this.setTouchable(true);
                f.this.setFocusable(true);
                f.this.update();
                f.this.f8222R = false;
            }
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void i() {
            f.this.f8219O = true;
        }

        @Override // com.coui.appcompat.poplist.j.b
        public void j() {
            f.this.f8219O = false;
            f.this.f8234o = null;
            f.super.dismiss();
        }
    }

    private final class e implements Runnable {
        private e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.R();
        }

        /* synthetic */ e(f fVar, a aVar) {
            this();
        }
    }

    static {
        f8204T = AbstractC0371a.f11873b || AbstractC0371a.e("COUIPopupListWindow", 3);
    }

    public f(Context context) {
        super(context);
        this.f8224e = new a();
        this.f8225f = new b();
        this.f8226g = new c();
        this.f8227h = new e(this, null);
        this.f8233n = null;
        this.f8234o = null;
        this.f8207C = 0;
        this.f8208D = 0;
        this.f8209E = -1;
        this.f8210F = -1;
        this.f8211G = Integer.MIN_VALUE;
        this.f8212H = Integer.MIN_VALUE;
        this.f8213I = -1;
        this.f8214J = false;
        this.f8215K = true;
        this.f8216L = false;
        this.f8217M = false;
        this.f8218N = false;
        this.f8219O = false;
        this.f8220P = true;
        this.f8222R = false;
        this.f8223S = false;
        this.f8228i = context;
        setClippingEnabled(false);
        setTouchModal(false);
        setFocusable(true);
        setOutsideTouchable(true);
        i(true);
        setExitTransition(null);
        setEnterTransition(null);
        setAnimationStyle(V1.h.f2571a);
        ListView listView = new ListView(context);
        this.f8239t = listView;
        listView.setDivider(null);
        this.f8239t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f8231l = new ArrayList();
        j Q3 = Q();
        this.f8240u = Q3;
        setContentView(Q3);
        this.f8241v = new x(this.f8228i);
    }

    private void L() {
        j jVar = this.f8240u;
        if (jVar != null) {
            jVar.t();
        }
    }

    private boolean M(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return false;
            }
        }
        return true;
    }

    private boolean N(List list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    private void O() {
        this.f8213I = -1;
        this.f8237r.setAdapter((ListAdapter) this.f8229j);
        if (this.f8242w != null) {
            this.f8237r.setOnItemClickListener(this.f8225f);
        }
    }

    private void P() {
        this.f8238s.setAdapter((ListAdapter) this.f8230k);
        this.f8238s.setOnItemClickListener(this.f8226g);
    }

    private j Q() {
        j jVar = new j(this.f8228i);
        jVar.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.poplist.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.W(view);
            }
        });
        this.f8235p = (RoundFrameLayout) LayoutInflater.from(this.f8228i).inflate(V1.g.f2570c, (ViewGroup) jVar, false);
        this.f8236q = (RoundFrameLayout) LayoutInflater.from(this.f8228i).inflate(V1.g.f2570c, (ViewGroup) jVar, false);
        this.f8237r = (ListView) this.f8235p.findViewById(V1.e.f2558a);
        this.f8238s = (ListView) this.f8236q.findViewById(V1.e.f2558a);
        TypedArray obtainStyledAttributes = this.f8228i.getTheme().obtainStyledAttributes(new int[]{V1.a.f2529a});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = androidx.core.content.res.f.f(this.f8228i.getResources(), V1.d.f2557c, this.f8228i.getTheme());
        }
        if (drawable != null) {
            this.f8235p.setBackground(drawable.getConstantState().newDrawable());
            this.f8236q.setBackground(drawable.getConstantState().newDrawable());
        }
        obtainStyledAttributes.recycle();
        jVar.setOnSubMenuStateChangedListener(new d());
        return jVar;
    }

    private int T() {
        if (this.f8209E >= 0) {
            if (f8204T) {
                Log.i("COUIPopupListWindow", "Use custom menu width = " + this.f8209E);
            }
            return this.f8209E;
        }
        if (this.f8210F >= U()) {
            return this.f8210F;
        }
        Log.w("COUIPopupListWindow", "Illegal max width! Custom menu max width smaller than min width!");
        n nVar = this.f8229j;
        if (nVar == null) {
            Log.w("COUIPopupListWindow", "Get main menu max width fail! Adapter is NULL!");
            return 0;
        }
        if (nVar.s() && !this.f8229j.r()) {
            return this.f8228i.getResources().getDimensionPixelOffset(V1.c.f2554u);
        }
        return this.f8228i.getResources().getDimensionPixelOffset(V1.c.f2547n);
    }

    private int U() {
        int i3 = this.f8209E;
        if (i3 >= 0) {
            return i3;
        }
        n nVar = this.f8229j;
        if (nVar != null) {
            return nVar.s() ? this.f8229j.r() ? this.f8228i.getResources().getDimensionPixelOffset(V1.c.f2547n) : this.f8228i.getResources().getDimensionPixelOffset(V1.c.f2554u) : this.f8228i.getResources().getDimensionPixelOffset(V1.c.f2549p);
        }
        Log.w("COUIPopupListWindow", "Get main menu min width fail! Adapter is NULL!");
        return 0;
    }

    private boolean V(View view) {
        return androidx.core.view.y.x(view) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int X(s sVar, s sVar2) {
        return sVar.h() - sVar2.h();
    }

    private void c0(List list, n nVar) {
        nVar.A(this.f8216L);
        nVar.I(this.f8217M);
        nVar.J(list);
    }

    private void d0(boolean z3) {
        this.f8240u.v(this.f8244y, this.f8245z);
        this.f8241v.I(this.f8244y, this.f8245z, z3, this.f8207C, this.f8208D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(boolean z3, View view) {
        if (view != null && (view instanceof com.coui.appcompat.list.c)) {
            if (view.getBackground() instanceof InterfaceC0564f) {
                ((InterfaceC0564f) view.getBackground()).a(R.attr.state_hovered, z3, z3, true);
            }
            if (view.getBackground() instanceof C0561c) {
                ((C0561c) view.getBackground()).f(R.attr.state_hovered, z3, z3, true);
            }
        }
    }

    private void m0(List list, n nVar, boolean z3) {
        HashSet hashSet;
        if (list.size() >= 3) {
            if (z3) {
                Collections.sort(list, new Comparator() { // from class: com.coui.appcompat.poplist.d
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int X3;
                        X3 = f.X((s) obj, (s) obj2);
                        return X3;
                    }
                });
            }
            hashSet = new HashSet();
            int h3 = ((s) list.get(0)).h();
            for (int i3 = 1; i3 < list.size(); i3++) {
                int h4 = ((s) list.get(i3)).h();
                if (h4 != h3) {
                    hashSet.add(Integer.valueOf(i3));
                    h3 = h4;
                }
            }
        } else {
            hashSet = null;
        }
        if (hashSet != null) {
            nVar.D(hashSet);
        }
        c0(list, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(boolean z3) {
        if (this.f8230k == null) {
            return;
        }
        if (this.f8241v.G()) {
            int i3 = z3 ? 2 : 0;
            Object item = this.f8230k.getItem(0);
            if (item instanceof s) {
                ((s) item).C(i3);
                this.f8230k.notifyDataSetChanged();
                return;
            }
            return;
        }
        int i4 = this.f8213I;
        if (i4 != -1) {
            Object item2 = this.f8229j.getItem(n.d(i4));
            if (item2 instanceof s) {
                ((s) item2).C(z3 ? 1 : 0);
                this.f8229j.notifyDataSetChanged();
            }
        }
        View view = this.f8234o;
        if (view == null || !(view.getBackground() instanceof r)) {
            return;
        }
        ((r) this.f8234o.getBackground()).A(z3, z3, true);
    }

    private void w0(View view, int i3) {
        if (this.f8236q.getParent() != null && i3 == this.f8213I) {
            this.f8240u.y();
            return;
        }
        P();
        Z(this.f8230k);
        this.f8240u.w(this.f8205A, this.f8206B);
        this.f8241v.J(view, this.f8205A, this.f8206B, V(view));
        this.f8240u.k(this.f8236q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(View view, int i3) {
        s sVar;
        this.f8213I = i3;
        if (this.f8231l.isEmpty() || this.f8231l.size() <= i3 || (sVar = (s) this.f8231l.get(i3)) == null || !sVar.z() || !N(sVar.s()) || !M(sVar.s())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f8241v.G()) {
            arrayList.add(sVar);
        }
        this.f8241v.N(i3 == 0);
        arrayList.addAll(sVar.s());
        if (this.f8230k == null) {
            this.f8230k = new n(this.f8228i, null);
        }
        m0(arrayList, this.f8230k, false);
        if (view.getBackground() instanceof r) {
            this.f8230k.K((r) view.getBackground());
        }
        this.f8234o = view;
        w0(view, i3);
    }

    public void R() {
        if (super.isShowing()) {
            L();
            View view = this.f8232m;
            if (view != null && view.getRootView() != null) {
                this.f8232m.getRootView().removeOnLayoutChangeListener(this.f8224e);
            }
            if (this.f8213I != -1 && this.f8229j != null) {
                AbstractC0371a.a("COUIPopupListWindow", "LastClickedMainMenuItemPosition = " + this.f8213I);
                Object item = this.f8229j.getItem(n.d(this.f8213I));
                if (item instanceof s) {
                    ((s) item).C(0);
                }
            }
            this.f8234o = null;
            f0(false, this.f8232m);
            this.f8219O = false;
            this.f8244y = 0;
            this.f8245z = 0;
            super.dismiss();
            PopupWindow.OnDismissListener onDismissListener = this.f8221Q;
            if (onDismissListener != null && !this.f8223S) {
                onDismissListener.onDismiss();
            }
            this.f8223S = false;
        }
    }

    public List S() {
        return this.f8231l;
    }

    void Y() {
        Z(this.f8229j);
    }

    void Z(n nVar) {
        View view;
        int i3;
        boolean z3 = nVar == this.f8229j;
        x xVar = this.f8241v;
        int E3 = z3 ? xVar.E() : xVar.F();
        ArrayList arrayList = new ArrayList();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(T(), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = nVar.getCount();
        View view2 = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        View view3 = null;
        boolean z4 = true;
        while (i4 < count) {
            if (n.t(i4)) {
                if (nVar.getItemViewType(i4) == 3) {
                    view = nVar.getView(i4, view2, this.f8239t);
                } else {
                    view3 = nVar.getView(i4, view3, this.f8239t);
                    view = view3;
                }
                if (view != null) {
                    if ((view.getLayoutParams() instanceof AbsListView.LayoutParams) && (i3 = ((AbsListView.LayoutParams) view.getLayoutParams()).height) != -2) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    if (measuredWidth > i6) {
                        i6 = measuredWidth;
                    }
                    if (z4 && i5 + measuredHeight > E3) {
                        i5 -= i8;
                        z4 = false;
                    }
                    if (z4) {
                        i5 += measuredHeight;
                    }
                    i7 += measuredHeight;
                    if (i4 == 0 || arrayList.isEmpty()) {
                        arrayList.add(Integer.valueOf(measuredHeight));
                    } else {
                        arrayList.add(Integer.valueOf(measuredHeight + ((Integer) arrayList.get(i4 - 1)).intValue()));
                    }
                }
            } else {
                i8 = nVar.u(i4) ? nVar.j(2) : nVar.j(1);
                if (z4) {
                    i5 += i8;
                }
                i7 += i8;
                if (i4 == 0 || arrayList.isEmpty()) {
                    arrayList.add(Integer.valueOf(i8));
                } else {
                    arrayList.add(Integer.valueOf(i8 + ((Integer) arrayList.get(i4 - 1)).intValue()));
                }
            }
            i4++;
            view2 = null;
        }
        if (i5 != 0) {
            E3 = i5;
        }
        if (z3) {
            this.f8244y = Math.max(i6, U());
            this.f8245z = E3;
            ListView listView = this.f8237r;
            if (listView instanceof COUITouchListView) {
                ((COUITouchListView) listView).p(arrayList, i7);
                return;
            }
            return;
        }
        this.f8205A = this.f8244y;
        this.f8206B = E3;
        ListView listView2 = this.f8238s;
        if (listView2 instanceof COUITouchListView) {
            ((COUITouchListView) listView2).p(arrayList, i7);
        }
    }

    protected void a0(View view, int i3, int i4, boolean z3) {
        O();
        this.f8241v.K(view, i3, i4, this.f8233n);
        this.f8240u.setDomain(this.f8241v.C());
        this.f8240u.j(this.f8235p);
        if (this.f8244y == 0 || this.f8245z == 0) {
            Y();
        }
        this.f8240u.v(this.f8244y, this.f8245z);
        this.f8241v.I(this.f8244y, this.f8245z, z3, this.f8207C, this.f8208D);
    }

    public void b0() {
        TypedArray obtainStyledAttributes = this.f8228i.getTheme().obtainStyledAttributes(new int[]{V1.a.f2529a});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (drawable == null) {
            drawable = androidx.core.content.res.f.f(this.f8228i.getResources(), V1.d.f2557c, this.f8228i.getTheme());
        }
        if (drawable != null) {
            this.f8235p.setBackground(drawable.getConstantState().newDrawable());
            this.f8236q.setBackground(drawable.getConstantState().newDrawable());
        }
    }

    @Override // com.coui.appcompat.poplist.k
    protected void d() {
        setBackgroundDrawable(null);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (isTouchable()) {
            setTouchable(false);
            setFocusable(false);
            update();
            this.f8222R = true;
        }
        if (!isShowing() || this.f8219O) {
            return;
        }
        L();
        if (this.f8223S) {
            this.f8219O = true;
            j jVar = this.f8240u;
            if (jVar != null) {
                jVar.r(this.f8227h, 350L);
            }
        } else {
            View view = this.f8232m;
            if (view != null && view.getRootView() != null) {
                this.f8232m.getRootView().removeOnLayoutChangeListener(this.f8224e);
            }
            if (this.f8213I != -1 && this.f8229j != null) {
                AbstractC0371a.a("COUIPopupListWindow", "LastClickedMainMenuItemPosition = " + this.f8213I);
                Object item = this.f8229j.getItem(n.d(this.f8213I));
                if (item instanceof s) {
                    ((s) item).C(0);
                }
            }
            this.f8240u.o(true);
            f0(false, this.f8232m);
        }
        PopupWindow.OnDismissListener onDismissListener = this.f8221Q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // com.coui.appcompat.poplist.k
    protected void e() {
    }

    public void e0(boolean z3) {
        this.f8220P = z3;
    }

    public void g0(View view) {
        this.f8232m = view;
    }

    public void h0(boolean z3) {
        this.f8223S = z3;
    }

    public void i0(boolean z3) {
    }

    @Override // android.widget.PopupWindow
    public boolean isShowing() {
        return super.isShowing() && !this.f8219O;
    }

    public void j0(boolean z3) {
        this.f8217M = z3;
        n nVar = this.f8229j;
        if (nVar != null) {
            nVar.I(z3);
        }
        n nVar2 = this.f8230k;
        if (nVar2 != null) {
            nVar2.I(this.f8217M);
        }
    }

    public void k0(List list) {
        l0(list, false);
    }

    public void l0(List list, boolean z3) {
        if (!N(list) || !M(list)) {
            Log.e("COUIPopupListWindow", "Error! Item list must not be empty or null!");
            return;
        }
        this.f8231l = list;
        if (this.f8229j == null) {
            this.f8229j = new n(this.f8228i, null);
        }
        m0(this.f8231l, this.f8229j, z3);
    }

    public void n0(int i3) {
    }

    public void o0(boolean z3, boolean z4) {
        this.f8241v.g0(z3);
        this.f8241v.M(z4);
    }

    public void p0(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            AbstractC0371a.g("COUIPopupListWindow", "set main menu item click listener = null. caller = " + Log.getStackTraceString(new Throwable()));
        }
        this.f8242w = onItemClickListener;
    }

    public void q0(int i3) {
    }

    public void r0(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            AbstractC0371a.g("COUIPopupListWindow", "set sub menu item click listener = null. caller = " + Log.getStackTraceString(new Throwable()));
        }
        this.f8243x = onItemClickListener;
    }

    @Override // android.widget.PopupWindow
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f8221Q = onDismissListener;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4, int i5) {
    }

    public void t0(boolean z3, EnumC0643a enumC0643a) {
        this.f8236q.p(z3, enumC0643a);
        this.f8235p.p(z3, enumC0643a);
    }

    public void u0(View view, int i3, int i4) {
        v0(view, false, i3, i4);
    }

    public void v0(View view, boolean z3, int i3, int i4) {
        int i5;
        WindowInsets rootWindowInsets;
        Context context = this.f8228i;
        if (context == null) {
            Log.e("COUIPopupListWindow", " The context of COUIPopupListWindow is null ");
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            Log.e("COUIPopupListWindow", " The context of COUIPopupListWindow is Finish ");
            return;
        }
        if (view == null || view.getContext() == null || view.getWindowToken() == null) {
            Log.e("COUIPopupListWindow", " COUIPopupListWindow's anchor state is wrong ");
            return;
        }
        if (this.f8229j == null) {
            Log.e("COUIPopupListWindow", "The MainMenuAdapter is null");
            return;
        }
        boolean z4 = this.f8219O && this.f8232m == view;
        this.f8232m = view;
        if (this.f8218N && (rootWindowInsets = view.getRootWindowInsets()) != null) {
            getContentView().setTranslationX(-rootWindowInsets.getSystemWindowInsetLeft());
            AbstractC0371a.g("COUIPopupListWindow", "mNeedOffsetWhenSetWindowType is true , offset the root view.");
        }
        int i6 = this.f8244y;
        if (i6 != 0 && (i5 = this.f8245z) != 0) {
            Y();
            z4 &= i6 == this.f8244y && i5 == this.f8245z;
        }
        if ((z4 & (this.f8220P || (this.f8211G == i3 && this.f8212H == i4))) && (!this.f8223S)) {
            n nVar = this.f8229j;
            if (nVar != null) {
                nVar.notifyDataSetChanged();
            }
            n nVar2 = this.f8230k;
            if (nVar2 != null) {
                nVar2.notifyDataSetChanged();
            }
            d0(z3);
            setWidth(this.f8241v.f8415a.width());
            setHeight(this.f8241v.f8415a.height());
            this.f8240u.x();
        } else {
            if (super.isShowing()) {
                R();
            }
            this.f8211G = i3;
            this.f8212H = i4;
            a0(view, i3, i4, z3);
            setWidth(this.f8241v.f8415a.width());
            setHeight(this.f8241v.f8415a.height());
            super.showAtLocation(view.getRootView(), 0, 0, 0);
        }
        view.getRootView().addOnLayoutChangeListener(this.f8224e);
        f0(true, view);
    }

    public void x0() {
        super.dismiss();
    }
}
