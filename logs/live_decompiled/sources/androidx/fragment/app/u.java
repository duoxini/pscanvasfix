package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.t;
import androidx.transition.C0285e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import m.C0451a;

/* loaded from: classes.dex */
abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5581a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    static final w f5582b = new v();

    /* renamed from: c, reason: collision with root package name */
    static final w f5583c = w();

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f5584e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f5585f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f5586g;

        a(g gVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f5584e = gVar;
            this.f5585f = fragment;
            this.f5586g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5584e.a(this.f5585f, this.f5586g);
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5587e;

        b(ArrayList arrayList) {
            this.f5587e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.A(this.f5587e, 4);
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f5588e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f5589f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f5590g;

        c(g gVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f5588e = gVar;
            this.f5589f = fragment;
            this.f5590g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5588e.a(this.f5589f, this.f5590g);
        }
    }

    class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f5591e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f5592f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f5593g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Fragment f5594h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f5595i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f5596j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f5597k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f5598l;

        d(Object obj, w wVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f5591e = obj;
            this.f5592f = wVar;
            this.f5593g = view;
            this.f5594h = fragment;
            this.f5595i = arrayList;
            this.f5596j = arrayList2;
            this.f5597k = arrayList3;
            this.f5598l = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f5591e;
            if (obj != null) {
                this.f5592f.p(obj, this.f5593g);
                this.f5596j.addAll(u.k(this.f5592f, this.f5591e, this.f5594h, this.f5595i, this.f5593g));
            }
            if (this.f5597k != null) {
                if (this.f5598l != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f5593g);
                    this.f5592f.q(this.f5598l, this.f5597k, arrayList);
                }
                this.f5597k.clear();
                this.f5597k.add(this.f5593g);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f5599e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f5600f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f5601g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ C0451a f5602h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f5603i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ w f5604j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Rect f5605k;

        e(Fragment fragment, Fragment fragment2, boolean z3, C0451a c0451a, View view, w wVar, Rect rect) {
            this.f5599e = fragment;
            this.f5600f = fragment2;
            this.f5601g = z3;
            this.f5602h = c0451a;
            this.f5603i = view;
            this.f5604j = wVar;
            this.f5605k = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.f(this.f5599e, this.f5600f, this.f5601g, this.f5602h, false);
            View view = this.f5603i;
            if (view != null) {
                this.f5604j.k(view, this.f5605k);
            }
        }
    }

    class f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ w f5606e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ C0451a f5607f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f5608g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ h f5609h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f5610i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f5611j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Fragment f5612k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Fragment f5613l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f5614m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ ArrayList f5615n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ Object f5616o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ Rect f5617p;

        f(w wVar, C0451a c0451a, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z3, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f5606e = wVar;
            this.f5607f = c0451a;
            this.f5608g = obj;
            this.f5609h = hVar;
            this.f5610i = arrayList;
            this.f5611j = view;
            this.f5612k = fragment;
            this.f5613l = fragment2;
            this.f5614m = z3;
            this.f5615n = arrayList2;
            this.f5616o = obj2;
            this.f5617p = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0451a h3 = u.h(this.f5606e, this.f5607f, this.f5608g, this.f5609h);
            if (h3 != null) {
                this.f5610i.addAll(h3.values());
                this.f5610i.add(this.f5611j);
            }
            u.f(this.f5612k, this.f5613l, this.f5614m, h3, false);
            Object obj = this.f5608g;
            if (obj != null) {
                this.f5606e.A(obj, this.f5615n, this.f5610i);
                View s3 = u.s(h3, this.f5609h, this.f5616o, this.f5614m);
                if (s3 != null) {
                    this.f5606e.k(s3, this.f5617p);
                }
            }
        }
    }

    interface g {
        void a(Fragment fragment, androidx.core.os.e eVar);

        void b(Fragment fragment, androidx.core.os.e eVar);
    }

    static class h {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f5618a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5619b;

        /* renamed from: c, reason: collision with root package name */
        public C0263a f5620c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f5621d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f5622e;

        /* renamed from: f, reason: collision with root package name */
        public C0263a f5623f;

        h() {
        }
    }

    static void A(ArrayList arrayList, int i3) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i3);
        }
    }

    static void B(Context context, androidx.fragment.app.f fVar, ArrayList arrayList, ArrayList arrayList2, int i3, int i4, boolean z3, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i5 = i3; i5 < i4; i5++) {
            C0263a c0263a = (C0263a) arrayList.get(i5);
            if (((Boolean) arrayList2.get(i5)).booleanValue()) {
                e(c0263a, sparseArray, z3);
            } else {
                c(c0263a, sparseArray, z3);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = sparseArray.keyAt(i6);
                C0451a d3 = d(keyAt, arrayList, arrayList2, i3, i4);
                h hVar = (h) sparseArray.valueAt(i6);
                if (fVar.d() && (viewGroup = (ViewGroup) fVar.c(keyAt)) != null) {
                    if (z3) {
                        o(viewGroup, hVar, view, d3, gVar);
                    } else {
                        n(viewGroup, hVar, view, d3, gVar);
                    }
                }
            }
        }
    }

    private static void a(ArrayList arrayList, C0451a c0451a, Collection collection) {
        for (int size = c0451a.size() - 1; size >= 0; size--) {
            View view = (View) c0451a.m(size);
            if (collection.contains(androidx.core.view.y.F(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0039, code lost:
    
        if (r0.mAdded != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003b, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0053, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0090, code lost:
    
        if (r0.mHidden == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(androidx.fragment.app.C0263a r8, androidx.fragment.app.t.a r9, android.util.SparseArray r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u.b(androidx.fragment.app.a, androidx.fragment.app.t$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(C0263a c0263a, SparseArray sparseArray, boolean z3) {
        int size = c0263a.f5556c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b(c0263a, (t.a) c0263a.f5556c.get(i3), sparseArray, false, z3);
        }
    }

    private static C0451a d(int i3, ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        C0451a c0451a = new C0451a();
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            C0263a c0263a = (C0263a) arrayList.get(i6);
            if (c0263a.D(i3)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i6)).booleanValue();
                ArrayList arrayList5 = c0263a.f5569p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = c0263a.f5569p;
                        arrayList4 = c0263a.f5570q;
                    } else {
                        ArrayList arrayList6 = c0263a.f5569p;
                        arrayList3 = c0263a.f5570q;
                        arrayList4 = arrayList6;
                    }
                    for (int i7 = 0; i7 < size; i7++) {
                        String str = (String) arrayList4.get(i7);
                        String str2 = (String) arrayList3.get(i7);
                        String str3 = (String) c0451a.remove(str2);
                        if (str3 != null) {
                            c0451a.put(str, str3);
                        } else {
                            c0451a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c0451a;
    }

    public static void e(C0263a c0263a, SparseArray sparseArray, boolean z3) {
        if (c0263a.f5354t.n0().d()) {
            for (int size = c0263a.f5556c.size() - 1; size >= 0; size--) {
                b(c0263a, (t.a) c0263a.f5556c.get(size), sparseArray, true, z3);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z3, C0451a c0451a, boolean z4) {
        if (z3) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static boolean g(w wVar, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!wVar.e(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    static C0451a h(w wVar, C0451a c0451a, Object obj, h hVar) {
        ArrayList arrayList;
        Fragment fragment = hVar.f5618a;
        View view = fragment.getView();
        if (c0451a.isEmpty() || obj == null || view == null) {
            c0451a.clear();
            return null;
        }
        C0451a c0451a2 = new C0451a();
        wVar.j(c0451a2, view);
        C0263a c0263a = hVar.f5620c;
        if (hVar.f5619b) {
            fragment.getExitTransitionCallback();
            arrayList = c0263a.f5569p;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = c0263a.f5570q;
        }
        if (arrayList != null) {
            c0451a2.o(arrayList);
            c0451a2.o(c0451a.values());
        }
        x(c0451a, c0451a2);
        return c0451a2;
    }

    private static C0451a i(w wVar, C0451a c0451a, Object obj, h hVar) {
        ArrayList arrayList;
        if (c0451a.isEmpty() || obj == null) {
            c0451a.clear();
            return null;
        }
        Fragment fragment = hVar.f5621d;
        C0451a c0451a2 = new C0451a();
        wVar.j(c0451a2, fragment.requireView());
        C0263a c0263a = hVar.f5623f;
        if (hVar.f5622e) {
            fragment.getEnterTransitionCallback();
            arrayList = c0263a.f5570q;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = c0263a.f5569p;
        }
        if (arrayList != null) {
            c0451a2.o(arrayList);
        }
        c0451a.o(c0451a2.keySet());
        return c0451a2;
    }

    private static w j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        w wVar = f5582b;
        if (wVar != null && g(wVar, arrayList)) {
            return wVar;
        }
        w wVar2 = f5583c;
        if (wVar2 != null && g(wVar2, arrayList)) {
            return wVar2;
        }
        if (wVar == null && wVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList k(w wVar, Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            wVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        wVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(w wVar, ViewGroup viewGroup, View view, C0451a c0451a, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object t3;
        C0451a c0451a2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f5618a;
        Fragment fragment2 = hVar.f5621d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z3 = hVar.f5619b;
        if (c0451a.isEmpty()) {
            c0451a2 = c0451a;
            t3 = null;
        } else {
            t3 = t(wVar, fragment, fragment2, z3);
            c0451a2 = c0451a;
        }
        C0451a i3 = i(wVar, c0451a2, t3, hVar);
        if (c0451a.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i3.values());
            obj3 = t3;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z3, i3, true);
        if (obj3 != null) {
            rect = new Rect();
            wVar.z(obj3, view, arrayList);
            z(wVar, obj3, obj2, i3, hVar.f5622e, hVar.f5623f);
            if (obj != null) {
                wVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.view.v.a(viewGroup, new f(wVar, c0451a, obj3, hVar, arrayList2, view, fragment, fragment2, z3, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(w wVar, ViewGroup viewGroup, View view, C0451a c0451a, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f5618a;
        Fragment fragment2 = hVar.f5621d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z3 = hVar.f5619b;
        Object t3 = c0451a.isEmpty() ? null : t(wVar, fragment, fragment2, z3);
        C0451a i3 = i(wVar, c0451a, t3, hVar);
        C0451a h3 = h(wVar, c0451a, t3, hVar);
        if (c0451a.isEmpty()) {
            if (i3 != null) {
                i3.clear();
            }
            if (h3 != null) {
                h3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i3, c0451a.keySet());
            a(arrayList2, h3, c0451a.values());
            obj3 = t3;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z3, i3, true);
        if (obj3 != null) {
            arrayList2.add(view);
            wVar.z(obj3, view, arrayList);
            z(wVar, obj3, obj2, i3, hVar.f5622e, hVar.f5623f);
            Rect rect2 = new Rect();
            View s3 = s(h3, hVar, obj, z3);
            if (s3 != null) {
                wVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s3;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.view.v.a(viewGroup, new e(fragment, fragment2, z3, h3, view2, wVar, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, C0451a c0451a, g gVar) {
        Object obj;
        Fragment fragment = hVar.f5618a;
        Fragment fragment2 = hVar.f5621d;
        w j3 = j(fragment2, fragment);
        if (j3 == null) {
            return;
        }
        boolean z3 = hVar.f5619b;
        boolean z4 = hVar.f5622e;
        Object q3 = q(j3, fragment, z3);
        Object r3 = r(j3, fragment2, z4);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object l3 = l(j3, viewGroup, view, c0451a, hVar, arrayList, arrayList2, q3, r3);
        if (q3 == null && l3 == null) {
            obj = r3;
            if (obj == null) {
                return;
            }
        } else {
            obj = r3;
        }
        ArrayList k3 = k(j3, obj, fragment2, arrayList, view);
        if (k3 == null || k3.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        j3.a(q3, view);
        Object u3 = u(j3, q3, obj2, l3, fragment, hVar.f5619b);
        if (fragment2 != null && k3 != null && (k3.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            gVar.b(fragment2, eVar);
            j3.w(fragment2, u3, eVar, new c(gVar, fragment2, eVar));
        }
        if (u3 != null) {
            ArrayList arrayList3 = new ArrayList();
            j3.t(u3, q3, arrayList3, obj2, k3, l3, arrayList2);
            y(j3, viewGroup, fragment, view, arrayList2, q3, arrayList3, obj2, k3);
            j3.x(viewGroup, arrayList2, c0451a);
            j3.c(viewGroup, u3);
            j3.s(viewGroup, arrayList2, c0451a);
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, C0451a c0451a, g gVar) {
        Object obj;
        Fragment fragment = hVar.f5618a;
        Fragment fragment2 = hVar.f5621d;
        w j3 = j(fragment2, fragment);
        if (j3 == null) {
            return;
        }
        boolean z3 = hVar.f5619b;
        boolean z4 = hVar.f5622e;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object q3 = q(j3, fragment, z3);
        Object r3 = r(j3, fragment2, z4);
        Object m3 = m(j3, viewGroup, view, c0451a, hVar, arrayList2, arrayList, q3, r3);
        if (q3 == null && m3 == null) {
            obj = r3;
            if (obj == null) {
                return;
            }
        } else {
            obj = r3;
        }
        ArrayList k3 = k(j3, obj, fragment2, arrayList2, view);
        ArrayList k4 = k(j3, q3, fragment, arrayList, view);
        A(k4, 4);
        Object u3 = u(j3, q3, obj, m3, fragment, z3);
        if (fragment2 != null && k3 != null && (k3.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            gVar.b(fragment2, eVar);
            j3.w(fragment2, u3, eVar, new a(gVar, fragment2, eVar));
        }
        if (u3 != null) {
            v(j3, obj, fragment2, k3);
            ArrayList o3 = j3.o(arrayList);
            j3.t(u3, q3, k4, obj, k3, m3, arrayList);
            j3.c(viewGroup, u3);
            j3.y(viewGroup, arrayList2, arrayList, o3, c0451a);
            A(k4, 0);
            j3.A(m3, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray sparseArray, int i3) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i3, hVar2);
        return hVar2;
    }

    private static Object q(w wVar, Fragment fragment, boolean z3) {
        if (fragment == null) {
            return null;
        }
        return wVar.g(z3 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object r(w wVar, Fragment fragment, boolean z3) {
        if (fragment == null) {
            return null;
        }
        return wVar.g(z3 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View s(C0451a c0451a, h hVar, Object obj, boolean z3) {
        ArrayList arrayList;
        C0263a c0263a = hVar.f5620c;
        if (obj == null || c0451a == null || (arrayList = c0263a.f5569p) == null || arrayList.isEmpty()) {
            return null;
        }
        return (View) c0451a.get(z3 ? (String) c0263a.f5569p.get(0) : (String) c0263a.f5570q.get(0));
    }

    private static Object t(w wVar, Fragment fragment, Fragment fragment2, boolean z3) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return wVar.B(wVar.g(z3 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object u(w wVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z3) {
        return (obj == null || obj2 == null || fragment == null) ? true : z3 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? wVar.n(obj2, obj, obj3) : wVar.m(obj2, obj, obj3);
    }

    private static void v(w wVar, Object obj, Fragment fragment, ArrayList arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            wVar.r(obj, fragment.getView(), arrayList);
            androidx.core.view.v.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static w w() {
        try {
            return (w) C0285e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void x(C0451a c0451a, C0451a c0451a2) {
        for (int size = c0451a.size() - 1; size >= 0; size--) {
            if (!c0451a2.containsKey((String) c0451a.m(size))) {
                c0451a.k(size);
            }
        }
    }

    private static void y(w wVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        androidx.core.view.v.a(viewGroup, new d(obj, wVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(w wVar, Object obj, Object obj2, C0451a c0451a, boolean z3, C0263a c0263a) {
        ArrayList arrayList = c0263a.f5569p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = (View) c0451a.get(z3 ? (String) c0263a.f5570q.get(0) : (String) c0263a.f5569p.get(0));
        wVar.v(obj, view);
        if (obj2 != null) {
            wVar.v(obj2, view);
        }
    }
}
