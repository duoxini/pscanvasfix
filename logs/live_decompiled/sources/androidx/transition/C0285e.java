package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.transition.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0285e extends androidx.fragment.app.w {

    /* renamed from: androidx.transition.e$a */
    class a extends l.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f6706a;

        a(Rect rect) {
            this.f6706a = rect;
        }

        @Override // androidx.transition.l.f
        public Rect a(l lVar) {
            return this.f6706a;
        }
    }

    /* renamed from: androidx.transition.e$b */
    class b implements l.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6708a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f6709b;

        b(View view, ArrayList arrayList) {
            this.f6708a = view;
            this.f6709b = arrayList;
        }

        @Override // androidx.transition.l.g
        public void a(l lVar) {
        }

        @Override // androidx.transition.l.g
        public void b(l lVar) {
        }

        @Override // androidx.transition.l.g
        public void c(l lVar) {
        }

        @Override // androidx.transition.l.g
        public void d(l lVar) {
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            lVar.removeListener(this);
            this.f6708a.setVisibility(8);
            int size = this.f6709b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((View) this.f6709b.get(i3)).setVisibility(0);
            }
        }
    }

    /* renamed from: androidx.transition.e$c */
    class c extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6711a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f6712b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f6713c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f6714d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f6715e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f6716f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f6711a = obj;
            this.f6712b = arrayList;
            this.f6713c = obj2;
            this.f6714d = arrayList2;
            this.f6715e = obj3;
            this.f6716f = arrayList3;
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void c(l lVar) {
            Object obj = this.f6711a;
            if (obj != null) {
                C0285e.this.q(obj, this.f6712b, null);
            }
            Object obj2 = this.f6713c;
            if (obj2 != null) {
                C0285e.this.q(obj2, this.f6714d, null);
            }
            Object obj3 = this.f6715e;
            if (obj3 != null) {
                C0285e.this.q(obj3, this.f6716f, null);
            }
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            lVar.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.e$d */
    class d extends l.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f6718a;

        d(Rect rect) {
            this.f6718a = rect;
        }

        @Override // androidx.transition.l.f
        public Rect a(l lVar) {
            Rect rect = this.f6718a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f6718a;
        }
    }

    private static boolean C(l lVar) {
        return (androidx.fragment.app.w.l(lVar.getTargetIds()) && androidx.fragment.app.w.l(lVar.getTargetNames()) && androidx.fragment.app.w.l(lVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.w
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.getTargets().clear();
            pVar.getTargets().addAll(arrayList2);
            q(pVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.w
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.w((l) obj);
        return pVar;
    }

    @Override // androidx.fragment.app.w
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.w
    public void b(Object obj, ArrayList arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i3 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int z3 = pVar.z();
            while (i3 < z3) {
                b(pVar.y(i3), arrayList);
                i3++;
            }
            return;
        }
        if (C(lVar) || !androidx.fragment.app.w.l(lVar.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i3 < size) {
            lVar.addTarget((View) arrayList.get(i3));
            i3++;
        }
    }

    @Override // androidx.fragment.app.w
    public void c(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    @Override // androidx.fragment.app.w
    public boolean e(Object obj) {
        return obj instanceof l;
    }

    @Override // androidx.fragment.app.w
    public Object g(Object obj) {
        if (obj != null) {
            return ((l) obj).mo0clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.w
    public Object m(Object obj, Object obj2, Object obj3) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        l lVar3 = (l) obj3;
        if (lVar != null && lVar2 != null) {
            lVar = new p().w(lVar).w(lVar2).H(1);
        } else if (lVar == null) {
            lVar = lVar2 != null ? lVar2 : null;
        }
        if (lVar3 == null) {
            return lVar;
        }
        p pVar = new p();
        if (lVar != null) {
            pVar.w(lVar);
        }
        pVar.w(lVar3);
        return pVar;
    }

    @Override // androidx.fragment.app.w
    public Object n(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.w((l) obj);
        }
        if (obj2 != null) {
            pVar.w((l) obj2);
        }
        if (obj3 != null) {
            pVar.w((l) obj3);
        }
        return pVar;
    }

    @Override // androidx.fragment.app.w
    public void p(Object obj, View view) {
        if (obj != null) {
            ((l) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.w
    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        l lVar = (l) obj;
        int i3 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int z3 = pVar.z();
            while (i3 < z3) {
                q(pVar.y(i3), arrayList, arrayList2);
                i3++;
            }
            return;
        }
        if (C(lVar)) {
            return;
        }
        List<View> targets = lVar.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i3 < size) {
                lVar.addTarget((View) arrayList2.get(i3));
                i3++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                lVar.removeTarget((View) arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.w
    public void r(Object obj, View view, ArrayList arrayList) {
        ((l) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.w
    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((l) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.w
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).setEpicenterCallback(new d(rect));
        }
    }

    @Override // androidx.fragment.app.w
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.w
    public void z(Object obj, View view, ArrayList arrayList) {
        p pVar = (p) obj;
        List<View> targets = pVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.fragment.app.w.d(targets, (View) arrayList.get(i3));
        }
        targets.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }
}
