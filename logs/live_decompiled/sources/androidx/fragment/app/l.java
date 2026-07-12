package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.t;
import androidx.fragment.app.u;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.H;
import androidx.lifecycle.I;
import c.AbstractC0294a;
import c.C0295b;
import c.C0296c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import m.C0452b;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: O, reason: collision with root package name */
    private static boolean f5449O = false;

    /* renamed from: P, reason: collision with root package name */
    static boolean f5450P = true;

    /* renamed from: A, reason: collision with root package name */
    private androidx.activity.result.c f5451A;

    /* renamed from: B, reason: collision with root package name */
    private androidx.activity.result.c f5452B;

    /* renamed from: D, reason: collision with root package name */
    private boolean f5454D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f5455E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f5456F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f5457G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f5458H;

    /* renamed from: I, reason: collision with root package name */
    private ArrayList f5459I;

    /* renamed from: J, reason: collision with root package name */
    private ArrayList f5460J;

    /* renamed from: K, reason: collision with root package name */
    private ArrayList f5461K;

    /* renamed from: L, reason: collision with root package name */
    private ArrayList f5462L;

    /* renamed from: M, reason: collision with root package name */
    private androidx.fragment.app.o f5463M;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5466b;

    /* renamed from: d, reason: collision with root package name */
    ArrayList f5468d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f5469e;

    /* renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f5471g;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f5476l;

    /* renamed from: r, reason: collision with root package name */
    private androidx.fragment.app.i f5482r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.fragment.app.f f5483s;

    /* renamed from: t, reason: collision with root package name */
    private Fragment f5484t;

    /* renamed from: u, reason: collision with root package name */
    Fragment f5485u;

    /* renamed from: z, reason: collision with root package name */
    private androidx.activity.result.c f5490z;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f5465a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final s f5467c = new s();

    /* renamed from: f, reason: collision with root package name */
    private final androidx.fragment.app.j f5470f = new androidx.fragment.app.j(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.g f5472h = new c(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f5473i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map f5474j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map f5475k = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    private Map f5477m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final u.g f5478n = new d();

    /* renamed from: o, reason: collision with root package name */
    private final androidx.fragment.app.k f5479o = new androidx.fragment.app.k(this);

    /* renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList f5480p = new CopyOnWriteArrayList();

    /* renamed from: q, reason: collision with root package name */
    int f5481q = -1;

    /* renamed from: v, reason: collision with root package name */
    private androidx.fragment.app.h f5486v = null;

    /* renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.h f5487w = new e();

    /* renamed from: x, reason: collision with root package name */
    private A f5488x = null;

    /* renamed from: y, reason: collision with root package name */
    private A f5489y = new f();

    /* renamed from: C, reason: collision with root package name */
    ArrayDeque f5453C = new ArrayDeque();

    /* renamed from: N, reason: collision with root package name */
    private Runnable f5464N = new g();

    class a implements androidx.activity.result.b {
        a() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            C0082l c0082l = (C0082l) l.this.f5453C.pollFirst();
            if (c0082l == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = c0082l.f5505e;
            int i3 = c0082l.f5506f;
            Fragment i4 = l.this.f5467c.i(str);
            if (i4 != null) {
                i4.onActivityResult(i3, aVar.d(), aVar.c());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    class b implements androidx.activity.result.b {
        b() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
            }
            C0082l c0082l = (C0082l) l.this.f5453C.pollFirst();
            if (c0082l == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = c0082l.f5505e;
            int i4 = c0082l.f5506f;
            Fragment i5 = l.this.f5467c.i(str);
            if (i5 != null) {
                i5.onRequestPermissionsResult(i4, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class c extends androidx.activity.g {
        c(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.g
        public void b() {
            l.this.A0();
        }
    }

    class d implements u.g {
        d() {
        }

        @Override // androidx.fragment.app.u.g
        public void a(Fragment fragment, androidx.core.os.e eVar) {
            if (eVar.b()) {
                return;
            }
            l.this.a1(fragment, eVar);
        }

        @Override // androidx.fragment.app.u.g
        public void b(Fragment fragment, androidx.core.os.e eVar) {
            l.this.f(fragment, eVar);
        }
    }

    class e extends androidx.fragment.app.h {
        e() {
        }

        @Override // androidx.fragment.app.h
        public Fragment a(ClassLoader classLoader, String str) {
            return l.this.s0().b(l.this.s0().f(), str, null);
        }
    }

    class f implements A {
        f() {
        }

        @Override // androidx.fragment.app.A
        public z a(ViewGroup viewGroup) {
            return new androidx.fragment.app.c(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.a0(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5498a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5499b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f5500c;

        h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f5498a = viewGroup;
            this.f5499b = view;
            this.f5500c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5498a.endViewTransition(this.f5499b);
            animator.removeListener(this);
            Fragment fragment = this.f5500c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class i implements p {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f5502e;

        i(Fragment fragment) {
            this.f5502e = fragment;
        }

        @Override // androidx.fragment.app.p
        public void a(l lVar, Fragment fragment) {
            this.f5502e.onAttachFragment(fragment);
        }
    }

    class j implements androidx.activity.result.b {
        j() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            C0082l c0082l = (C0082l) l.this.f5453C.pollFirst();
            if (c0082l == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = c0082l.f5505e;
            int i3 = c0082l.f5506f;
            Fragment i4 = l.this.f5467c.i(str);
            if (i4 != null) {
                i4.onActivityResult(i3, aVar.d(), aVar.c());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    static class k extends AbstractC0294a {
        k() {
        }

        @Override // c.AbstractC0294a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, androidx.activity.result.e eVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent c3 = eVar.c();
            if (c3 != null && (bundleExtra = c3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                c3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (c3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.b(eVar.f()).b(null).c(eVar.e(), eVar.d()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (l.E0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // c.AbstractC0294a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.activity.result.a c(int i3, Intent intent) {
            return new androidx.activity.result.a(i3, intent);
        }
    }

    interface m {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    private class n implements m {

        /* renamed from: a, reason: collision with root package name */
        final String f5507a;

        /* renamed from: b, reason: collision with root package name */
        final int f5508b;

        /* renamed from: c, reason: collision with root package name */
        final int f5509c;

        n(String str, int i3, int i4) {
            this.f5507a = str;
            this.f5508b = i3;
            this.f5509c = i4;
        }

        @Override // androidx.fragment.app.l.m
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = l.this.f5485u;
            if (fragment == null || this.f5508b >= 0 || this.f5507a != null || !fragment.getChildFragmentManager().W0()) {
                return l.this.Y0(arrayList, arrayList2, this.f5507a, this.f5508b, this.f5509c);
            }
            return false;
        }
    }

    static class o implements Fragment.l {

        /* renamed from: a, reason: collision with root package name */
        final boolean f5511a;

        /* renamed from: b, reason: collision with root package name */
        final C0263a f5512b;

        /* renamed from: c, reason: collision with root package name */
        private int f5513c;

        o(C0263a c0263a, boolean z3) {
            this.f5511a = z3;
            this.f5512b = c0263a;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void a() {
            int i3 = this.f5513c - 1;
            this.f5513c = i3;
            if (i3 != 0) {
                return;
            }
            this.f5512b.f5354t.i1();
        }

        @Override // androidx.fragment.app.Fragment.l
        public void b() {
            this.f5513c++;
        }

        void c() {
            C0263a c0263a = this.f5512b;
            c0263a.f5354t.t(c0263a, this.f5511a, false, false);
        }

        void d() {
            boolean z3 = this.f5513c > 0;
            for (Fragment fragment : this.f5512b.f5354t.r0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z3 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            C0263a c0263a = this.f5512b;
            c0263a.f5354t.t(c0263a, this.f5511a, !z3, true);
        }

        public boolean e() {
            return this.f5513c == 0;
        }
    }

    static boolean E0(int i3) {
        return f5449O || Log.isLoggable("FragmentManager", i3);
    }

    private boolean F0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    private void L(Fragment fragment) {
        if (fragment == null || !fragment.equals(f0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void N0(C0452b c0452b) {
        int size = c0452b.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = (Fragment) c0452b.h(i3);
            if (!fragment.mAdded) {
                View requireView = fragment.requireView();
                fragment.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private void S(int i3) {
        try {
            this.f5466b = true;
            this.f5467c.d(i3);
            P0(i3, false);
            if (f5450P) {
                Iterator it = r().iterator();
                while (it.hasNext()) {
                    ((z) it.next()).j();
                }
            }
            this.f5466b = false;
            a0(true);
        } catch (Throwable th) {
            this.f5466b = false;
            throw th;
        }
    }

    private void V() {
        if (this.f5458H) {
            this.f5458H = false;
            o1();
        }
    }

    private void X() {
        if (f5450P) {
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((z) it.next()).j();
            }
        } else {
            if (this.f5477m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.f5477m.keySet()) {
                n(fragment);
                Q0(fragment);
            }
        }
    }

    private boolean X0(String str, int i3, int i4) {
        a0(false);
        Z(true);
        Fragment fragment = this.f5485u;
        if (fragment != null && i3 < 0 && str == null && fragment.getChildFragmentManager().W0()) {
            return true;
        }
        boolean Y02 = Y0(this.f5459I, this.f5460J, str, i3, i4);
        if (Y02) {
            this.f5466b = true;
            try {
                c1(this.f5459I, this.f5460J);
            } finally {
                q();
            }
        }
        p1();
        V();
        this.f5467c.b();
        return Y02;
    }

    private void Z(boolean z3) {
        if (this.f5466b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f5482r == null) {
            if (!this.f5457G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f5482r.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z3) {
            p();
        }
        if (this.f5459I == null) {
            this.f5459I = new ArrayList();
            this.f5460J = new ArrayList();
        }
        this.f5466b = true;
        try {
            e0(null, null);
        } finally {
            this.f5466b = false;
        }
    }

    private int Z0(ArrayList arrayList, ArrayList arrayList2, int i3, int i4, C0452b c0452b) {
        int i5 = i4;
        for (int i6 = i4 - 1; i6 >= i3; i6--) {
            C0263a c0263a = (C0263a) arrayList.get(i6);
            boolean booleanValue = ((Boolean) arrayList2.get(i6)).booleanValue();
            if (c0263a.G() && !c0263a.E(arrayList, i6 + 1, i4)) {
                if (this.f5462L == null) {
                    this.f5462L = new ArrayList();
                }
                o oVar = new o(c0263a, booleanValue);
                this.f5462L.add(oVar);
                c0263a.I(oVar);
                if (booleanValue) {
                    c0263a.z();
                } else {
                    c0263a.A(false);
                }
                i5--;
                if (i6 != i5) {
                    arrayList.remove(i6);
                    arrayList.add(i5, c0263a);
                }
                d(c0452b);
            }
        }
        return i5;
    }

    private static void c0(ArrayList arrayList, ArrayList arrayList2, int i3, int i4) {
        while (i3 < i4) {
            C0263a c0263a = (C0263a) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                c0263a.v(-1);
                c0263a.A(i3 == i4 + (-1));
            } else {
                c0263a.v(1);
                c0263a.z();
            }
            i3++;
        }
    }

    private void c1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        e0(arrayList, arrayList2);
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!((C0263a) arrayList.get(i3)).f5571r) {
                if (i4 != i3) {
                    d0(arrayList, arrayList2, i4, i3);
                }
                i4 = i3 + 1;
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    while (i4 < size && ((Boolean) arrayList2.get(i4)).booleanValue() && !((C0263a) arrayList.get(i4)).f5571r) {
                        i4++;
                    }
                }
                d0(arrayList, arrayList2, i3, i4);
                i3 = i4 - 1;
            }
            i3++;
        }
        if (i4 != size) {
            d0(arrayList, arrayList2, i4, size);
        }
    }

    private void d(C0452b c0452b) {
        int i3 = this.f5481q;
        if (i3 < 1) {
            return;
        }
        int min = Math.min(i3, 5);
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment.mState < min) {
                R0(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    c0452b.add(fragment);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0143  */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d0(java.util.ArrayList r18, java.util.ArrayList r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l.d0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void e0(ArrayList arrayList, ArrayList arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList arrayList3 = this.f5462L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i3 = 0;
        while (i3 < size) {
            o oVar = (o) this.f5462L.get(i3);
            if (arrayList != null && !oVar.f5511a && (indexOf2 = arrayList.indexOf(oVar.f5512b)) != -1 && arrayList2 != null && ((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                this.f5462L.remove(i3);
                i3--;
                size--;
                oVar.c();
            } else if (oVar.e() || (arrayList != null && oVar.f5512b.E(arrayList, 0, arrayList.size()))) {
                this.f5462L.remove(i3);
                i3--;
                size--;
                if (arrayList == null || oVar.f5511a || (indexOf = arrayList.indexOf(oVar.f5512b)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    oVar.d();
                } else {
                    oVar.c();
                }
            }
            i3++;
        }
    }

    private void e1() {
        ArrayList arrayList = this.f5476l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.app.p.a(this.f5476l.get(0));
        throw null;
    }

    static int g1(int i3) {
        if (i3 == 4097) {
            return 8194;
        }
        if (i3 != 4099) {
            return i3 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void j0() {
        if (f5450P) {
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((z) it.next()).k();
            }
        } else if (this.f5462L != null) {
            while (!this.f5462L.isEmpty()) {
                ((o) this.f5462L.remove(0)).d();
            }
        }
    }

    private boolean k0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f5465a) {
            try {
                if (this.f5465a.isEmpty()) {
                    return false;
                }
                int size = this.f5465a.size();
                boolean z3 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    z3 |= ((m) this.f5465a.get(i3)).a(arrayList, arrayList2);
                }
                this.f5465a.clear();
                this.f5482r.g().removeCallbacks(this.f5464N);
                return z3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private androidx.fragment.app.o m0(Fragment fragment) {
        return this.f5463M.i(fragment);
    }

    private void m1(Fragment fragment) {
        ViewGroup o02 = o0(fragment);
        if (o02 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (o02.getTag(E.b.f348c) == null) {
            o02.setTag(E.b.f348c, fragment);
        }
        ((Fragment) o02.getTag(E.b.f348c)).setPopDirection(fragment.getPopDirection());
    }

    private void n(Fragment fragment) {
        HashSet hashSet = (HashSet) this.f5477m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
            hashSet.clear();
            w(fragment);
            this.f5477m.remove(fragment);
        }
    }

    private ViewGroup o0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f5483s.d()) {
            View c3 = this.f5483s.c(fragment.mContainerId);
            if (c3 instanceof ViewGroup) {
                return (ViewGroup) c3;
            }
        }
        return null;
    }

    private void o1() {
        Iterator it = this.f5467c.k().iterator();
        while (it.hasNext()) {
            U0((r) it.next());
        }
    }

    private void p() {
        if (J0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void p1() {
        synchronized (this.f5465a) {
            try {
                if (this.f5465a.isEmpty()) {
                    this.f5472h.f(l0() > 0 && H0(this.f5484t));
                } else {
                    this.f5472h.f(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void q() {
        this.f5466b = false;
        this.f5460J.clear();
        this.f5459I.clear();
    }

    private Set r() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f5467c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((r) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(z.o(viewGroup, x0()));
            }
        }
        return hashSet;
    }

    private Set s(ArrayList arrayList, int i3, int i4) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i3 < i4) {
            Iterator it = ((C0263a) arrayList.get(i3)).f5556c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((t.a) it.next()).f5574b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(z.n(viewGroup, this));
                }
            }
            i3++;
        }
        return hashSet;
    }

    private void u(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            e.d c3 = androidx.fragment.app.e.c(this.f5482r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c3 == null || (animator = c3.f5431b) == null) {
                if (c3 != null) {
                    fragment.mView.startAnimation(c3.f5430a);
                    c3.f5430a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c3.f5431b.addListener(new h(viewGroup, view, fragment));
                }
                c3.f5431b.start();
            }
        }
        C0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void w(Fragment fragment) {
        fragment.performDestroyView();
        this.f5479o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.j(null);
        fragment.mInLayout = false;
    }

    static Fragment y0(View view) {
        Object tag = view.getTag(E.b.f346a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    void A(Configuration configuration) {
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    void A0() {
        a0(true);
        if (this.f5472h.c()) {
            W0();
        } else {
            this.f5471g.f();
        }
    }

    boolean B(MenuItem menuItem) {
        if (this.f5481q < 1) {
            return false;
        }
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void B0(Fragment fragment) {
        if (E0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        m1(fragment);
    }

    void C() {
        this.f5455E = false;
        this.f5456F = false;
        this.f5463M.o(false);
        S(1);
    }

    void C0(Fragment fragment) {
        if (fragment.mAdded && F0(fragment)) {
            this.f5454D = true;
        }
    }

    boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f5481q < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z3 = false;
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null && G0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z3 = true;
            }
        }
        if (this.f5469e != null) {
            for (int i3 = 0; i3 < this.f5469e.size(); i3++) {
                Fragment fragment2 = (Fragment) this.f5469e.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f5469e = arrayList;
        return z3;
    }

    public boolean D0() {
        return this.f5457G;
    }

    void E() {
        this.f5457G = true;
        a0(true);
        X();
        S(-1);
        this.f5482r = null;
        this.f5483s = null;
        this.f5484t = null;
        if (this.f5471g != null) {
            this.f5472h.d();
            this.f5471g = null;
        }
        androidx.activity.result.c cVar = this.f5490z;
        if (cVar != null) {
            cVar.c();
            this.f5451A.c();
            this.f5452B.c();
        }
    }

    void F() {
        S(1);
    }

    void G() {
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    boolean G0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    void H(boolean z3) {
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z3);
            }
        }
    }

    boolean H0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        l lVar = fragment.mFragmentManager;
        return fragment.equals(lVar.w0()) && H0(lVar.f5484t);
    }

    void I(Fragment fragment) {
        Iterator it = this.f5480p.iterator();
        while (it.hasNext()) {
            ((p) it.next()).a(this, fragment);
        }
    }

    boolean I0(int i3) {
        return this.f5481q >= i3;
    }

    boolean J(MenuItem menuItem) {
        if (this.f5481q < 1) {
            return false;
        }
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean J0() {
        return this.f5455E || this.f5456F;
    }

    void K(Menu menu) {
        if (this.f5481q < 1) {
            return;
        }
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    void K0(Fragment fragment, String[] strArr, int i3) {
        if (this.f5452B == null) {
            this.f5482r.j(fragment, strArr, i3);
            return;
        }
        this.f5453C.addLast(new C0082l(fragment.mWho, i3));
        this.f5452B.a(strArr);
    }

    void L0(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (this.f5490z == null) {
            this.f5482r.m(fragment, intent, i3, bundle);
            return;
        }
        this.f5453C.addLast(new C0082l(fragment.mWho, i3));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f5490z.a(intent);
    }

    void M() {
        S(5);
    }

    void M0(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        Intent intent2;
        if (this.f5451A == null) {
            this.f5482r.n(fragment, intentSender, i3, intent, i4, i5, i6, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (E0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        androidx.activity.result.e a3 = new e.b(intentSender).b(intent2).c(i5, i4).a();
        this.f5453C.addLast(new C0082l(fragment.mWho, i3));
        if (E0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.f5451A.a(a3);
    }

    void N(boolean z3) {
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z3);
            }
        }
    }

    boolean O(Menu menu) {
        boolean z3 = false;
        if (this.f5481q < 1) {
            return false;
        }
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null && G0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z3 = true;
            }
        }
        return z3;
    }

    void O0(Fragment fragment) {
        if (!this.f5467c.c(fragment.mWho)) {
            if (E0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f5481q + "since it is not added to " + this);
                return;
            }
            return;
        }
        Q0(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f3 = fragment.mPostponedAlpha;
            if (f3 > 0.0f) {
                view.setAlpha(f3);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            e.d c3 = androidx.fragment.app.e.c(this.f5482r.f(), fragment, true, fragment.getPopDirection());
            if (c3 != null) {
                Animation animation = c3.f5430a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    c3.f5431b.setTarget(fragment.mView);
                    c3.f5431b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            u(fragment);
        }
    }

    void P() {
        p1();
        L(this.f5485u);
    }

    void P0(int i3, boolean z3) {
        androidx.fragment.app.i iVar;
        if (this.f5482r == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z3 || i3 != this.f5481q) {
            this.f5481q = i3;
            if (f5450P) {
                this.f5467c.r();
            } else {
                Iterator it = this.f5467c.n().iterator();
                while (it.hasNext()) {
                    O0((Fragment) it.next());
                }
                for (r rVar : this.f5467c.k()) {
                    Fragment k3 = rVar.k();
                    if (!k3.mIsNewlyAdded) {
                        O0(k3);
                    }
                    if (k3.mRemoving && !k3.isInBackStack()) {
                        this.f5467c.q(rVar);
                    }
                }
            }
            o1();
            if (this.f5454D && (iVar = this.f5482r) != null && this.f5481q == 7) {
                iVar.o();
                this.f5454D = false;
            }
        }
    }

    void Q() {
        this.f5455E = false;
        this.f5456F = false;
        this.f5463M.o(false);
        S(7);
    }

    void Q0(Fragment fragment) {
        R0(fragment, this.f5481q);
    }

    void R() {
        this.f5455E = false;
        this.f5456F = false;
        this.f5463M.o(false);
        S(5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r10 != 5) goto L102;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void R0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l.R0(androidx.fragment.app.Fragment, int):void");
    }

    void S0() {
        if (this.f5482r == null) {
            return;
        }
        this.f5455E = false;
        this.f5456F = false;
        this.f5463M.o(false);
        for (Fragment fragment : this.f5467c.n()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void T() {
        this.f5456F = true;
        this.f5463M.o(true);
        S(4);
    }

    void T0(FragmentContainerView fragmentContainerView) {
        View view;
        for (r rVar : this.f5467c.k()) {
            Fragment k3 = rVar.k();
            if (k3.mContainerId == fragmentContainerView.getId() && (view = k3.mView) != null && view.getParent() == null) {
                k3.mContainer = fragmentContainerView;
                rVar.b();
            }
        }
    }

    void U() {
        S(2);
    }

    void U0(r rVar) {
        Fragment k3 = rVar.k();
        if (k3.mDeferStart) {
            if (this.f5466b) {
                this.f5458H = true;
                return;
            }
            k3.mDeferStart = false;
            if (f5450P) {
                rVar.m();
            } else {
                Q0(k3);
            }
        }
    }

    public void V0(int i3, int i4) {
        if (i3 >= 0) {
            Y(new n(null, i3, i4), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f5467c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f5469e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                Fragment fragment = (Fragment) this.f5469e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.f5468d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                C0263a c0263a = (C0263a) this.f5468d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(c0263a.toString());
                c0263a.x(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f5473i.get());
        synchronized (this.f5465a) {
            try {
                int size3 = this.f5465a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size3; i5++) {
                        m mVar = (m) this.f5465a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(mVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f5482r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f5483s);
        if (this.f5484t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f5484t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f5481q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f5455E);
        printWriter.print(" mStopped=");
        printWriter.print(this.f5456F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f5457G);
        if (this.f5454D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f5454D);
        }
    }

    public boolean W0() {
        return X0(null, -1, 0);
    }

    void Y(m mVar, boolean z3) {
        if (!z3) {
            if (this.f5482r == null) {
                if (!this.f5457G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            p();
        }
        synchronized (this.f5465a) {
            try {
                if (this.f5482r == null) {
                    if (!z3) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f5465a.add(mVar);
                    i1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean Y0(ArrayList arrayList, ArrayList arrayList2, String str, int i3, int i4) {
        int i5;
        ArrayList arrayList3 = this.f5468d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i3 < 0 && (i4 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f5468d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i3 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    C0263a c0263a = (C0263a) this.f5468d.get(size2);
                    if ((str != null && str.equals(c0263a.C())) || (i3 >= 0 && i3 == c0263a.f5356v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i4 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C0263a c0263a2 = (C0263a) this.f5468d.get(size2);
                        if (str == null || !str.equals(c0263a2.C())) {
                            if (i3 < 0 || i3 != c0263a2.f5356v) {
                                break;
                            }
                        }
                    }
                }
                i5 = size2;
            } else {
                i5 = -1;
            }
            if (i5 == this.f5468d.size() - 1) {
                return false;
            }
            for (int size3 = this.f5468d.size() - 1; size3 > i5; size3--) {
                arrayList.add(this.f5468d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    boolean a0(boolean z3) {
        Z(z3);
        boolean z4 = false;
        while (k0(this.f5459I, this.f5460J)) {
            z4 = true;
            this.f5466b = true;
            try {
                c1(this.f5459I, this.f5460J);
            } finally {
                q();
            }
        }
        p1();
        V();
        this.f5467c.b();
        return z4;
    }

    void a1(Fragment fragment, androidx.core.os.e eVar) {
        HashSet hashSet = (HashSet) this.f5477m.get(fragment);
        if (hashSet != null && hashSet.remove(eVar) && hashSet.isEmpty()) {
            this.f5477m.remove(fragment);
            if (fragment.mState < 5) {
                w(fragment);
                Q0(fragment);
            }
        }
    }

    void b0(m mVar, boolean z3) {
        if (z3 && (this.f5482r == null || this.f5457G)) {
            return;
        }
        Z(z3);
        if (mVar.a(this.f5459I, this.f5460J)) {
            this.f5466b = true;
            try {
                c1(this.f5459I, this.f5460J);
            } finally {
                q();
            }
        }
        p1();
        V();
        this.f5467c.b();
    }

    void b1(Fragment fragment) {
        if (E0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && isInBackStack) {
            return;
        }
        this.f5467c.s(fragment);
        if (F0(fragment)) {
            this.f5454D = true;
        }
        fragment.mRemoving = true;
        m1(fragment);
    }

    void d1(Fragment fragment) {
        this.f5463M.n(fragment);
    }

    void e(C0263a c0263a) {
        if (this.f5468d == null) {
            this.f5468d = new ArrayList();
        }
        this.f5468d.add(c0263a);
    }

    void f(Fragment fragment, androidx.core.os.e eVar) {
        if (this.f5477m.get(fragment) == null) {
            this.f5477m.put(fragment, new HashSet());
        }
        ((HashSet) this.f5477m.get(fragment)).add(eVar);
    }

    Fragment f0(String str) {
        return this.f5467c.f(str);
    }

    void f1(Parcelable parcelable) {
        r rVar;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.n nVar = (androidx.fragment.app.n) parcelable;
        if (nVar.f5514e == null) {
            return;
        }
        this.f5467c.t();
        Iterator it = nVar.f5514e.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (qVar != null) {
                Fragment h3 = this.f5463M.h(qVar.f5531f);
                if (h3 != null) {
                    if (E0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + h3);
                    }
                    rVar = new r(this.f5479o, this.f5467c, h3, qVar);
                } else {
                    rVar = new r(this.f5479o, this.f5467c, this.f5482r.f().getClassLoader(), p0(), qVar);
                }
                Fragment k3 = rVar.k();
                k3.mFragmentManager = this;
                if (E0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k3.mWho + "): " + k3);
                }
                rVar.o(this.f5482r.f().getClassLoader());
                this.f5467c.p(rVar);
                rVar.t(this.f5481q);
            }
        }
        for (Fragment fragment : this.f5463M.k()) {
            if (!this.f5467c.c(fragment.mWho)) {
                if (E0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + nVar.f5514e);
                }
                this.f5463M.n(fragment);
                fragment.mFragmentManager = this;
                r rVar2 = new r(this.f5479o, this.f5467c, fragment);
                rVar2.t(1);
                rVar2.m();
                fragment.mRemoving = true;
                rVar2.m();
            }
        }
        this.f5467c.u(nVar.f5515f);
        if (nVar.f5516g != null) {
            this.f5468d = new ArrayList(nVar.f5516g.length);
            int i3 = 0;
            while (true) {
                C0264b[] c0264bArr = nVar.f5516g;
                if (i3 >= c0264bArr.length) {
                    break;
                }
                C0263a c3 = c0264bArr[i3].c(this);
                if (E0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + c3.f5356v + "): " + c3);
                    PrintWriter printWriter = new PrintWriter(new y("FragmentManager"));
                    c3.y("  ", printWriter, false);
                    printWriter.close();
                }
                this.f5468d.add(c3);
                i3++;
            }
        } else {
            this.f5468d = null;
        }
        this.f5473i.set(nVar.f5517h);
        String str = nVar.f5518i;
        if (str != null) {
            Fragment f02 = f0(str);
            this.f5485u = f02;
            L(f02);
        }
        ArrayList arrayList = nVar.f5519j;
        if (arrayList != null) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Bundle bundle = (Bundle) nVar.f5520k.get(i4);
                bundle.setClassLoader(this.f5482r.f().getClassLoader());
                this.f5474j.put(arrayList.get(i4), bundle);
            }
        }
        this.f5453C = new ArrayDeque(nVar.f5521l);
    }

    r g(Fragment fragment) {
        if (E0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        r v3 = v(fragment);
        fragment.mFragmentManager = this;
        this.f5467c.p(v3);
        if (!fragment.mDetached) {
            this.f5467c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (F0(fragment)) {
                this.f5454D = true;
            }
        }
        return v3;
    }

    public Fragment g0(int i3) {
        return this.f5467c.g(i3);
    }

    public void h(p pVar) {
        this.f5480p.add(pVar);
    }

    public Fragment h0(String str) {
        return this.f5467c.h(str);
    }

    Parcelable h1() {
        int size;
        j0();
        X();
        a0(true);
        this.f5455E = true;
        this.f5463M.o(true);
        ArrayList v3 = this.f5467c.v();
        C0264b[] c0264bArr = null;
        if (v3.isEmpty()) {
            if (E0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList w3 = this.f5467c.w();
        ArrayList arrayList = this.f5468d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            c0264bArr = new C0264b[size];
            for (int i3 = 0; i3 < size; i3++) {
                c0264bArr[i3] = new C0264b((C0263a) this.f5468d.get(i3));
                if (E0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f5468d.get(i3));
                }
            }
        }
        androidx.fragment.app.n nVar = new androidx.fragment.app.n();
        nVar.f5514e = v3;
        nVar.f5515f = w3;
        nVar.f5516g = c0264bArr;
        nVar.f5517h = this.f5473i.get();
        Fragment fragment = this.f5485u;
        if (fragment != null) {
            nVar.f5518i = fragment.mWho;
        }
        nVar.f5519j.addAll(this.f5474j.keySet());
        nVar.f5520k.addAll(this.f5474j.values());
        nVar.f5521l = new ArrayList(this.f5453C);
        return nVar;
    }

    void i(Fragment fragment) {
        this.f5463M.f(fragment);
    }

    Fragment i0(String str) {
        return this.f5467c.i(str);
    }

    void i1() {
        synchronized (this.f5465a) {
            try {
                ArrayList arrayList = this.f5462L;
                boolean z3 = (arrayList == null || arrayList.isEmpty()) ? false : true;
                boolean z4 = this.f5465a.size() == 1;
                if (z3 || z4) {
                    this.f5482r.g().removeCallbacks(this.f5464N);
                    this.f5482r.g().post(this.f5464N);
                    p1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    int j() {
        return this.f5473i.getAndIncrement();
    }

    void j1(Fragment fragment, boolean z3) {
        ViewGroup o02 = o0(fragment);
        if (o02 == null || !(o02 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) o02).setDrawDisappearingViewsLast(!z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void k(androidx.fragment.app.i iVar, androidx.fragment.app.f fVar, Fragment fragment) {
        String str;
        if (this.f5482r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f5482r = iVar;
        this.f5483s = fVar;
        this.f5484t = fragment;
        if (fragment != null) {
            h(new i(fragment));
        } else if (iVar instanceof p) {
            h((p) iVar);
        }
        if (this.f5484t != null) {
            p1();
        }
        if (iVar instanceof androidx.activity.k) {
            androidx.activity.k kVar = (androidx.activity.k) iVar;
            OnBackPressedDispatcher onBackPressedDispatcher = kVar.getOnBackPressedDispatcher();
            this.f5471g = onBackPressedDispatcher;
            androidx.lifecycle.o oVar = kVar;
            if (fragment != null) {
                oVar = fragment;
            }
            onBackPressedDispatcher.b(oVar, this.f5472h);
        }
        if (fragment != null) {
            this.f5463M = fragment.mFragmentManager.m0(fragment);
        } else if (iVar instanceof I) {
            this.f5463M = androidx.fragment.app.o.j(((I) iVar).getViewModelStore());
        } else {
            this.f5463M = new androidx.fragment.app.o(false);
        }
        this.f5463M.o(J0());
        this.f5467c.x(this.f5463M);
        Object obj = this.f5482r;
        if (obj instanceof androidx.activity.result.d) {
            ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.d) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f5490z = activityResultRegistry.j(str2 + "StartActivityForResult", new C0296c(), new j());
            this.f5451A = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new k(), new a());
            this.f5452B = activityResultRegistry.j(str2 + "RequestPermissions", new C0295b(), new b());
        }
    }

    void k1(Fragment fragment, AbstractC0272h.c cVar) {
        if (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void l(Fragment fragment) {
        if (E0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f5467c.a(fragment);
            if (E0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (F0(fragment)) {
                this.f5454D = true;
            }
        }
    }

    public int l0() {
        ArrayList arrayList = this.f5468d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void l1(Fragment fragment) {
        if (fragment == null || (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f5485u;
            this.f5485u = fragment;
            L(fragment2);
            L(this.f5485u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public t m() {
        return new C0263a(this);
    }

    androidx.fragment.app.f n0() {
        return this.f5483s;
    }

    void n1(Fragment fragment) {
        if (E0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    boolean o() {
        boolean z3 = false;
        for (Fragment fragment : this.f5467c.l()) {
            if (fragment != null) {
                z3 = F0(fragment);
            }
            if (z3) {
                return true;
            }
        }
        return false;
    }

    public androidx.fragment.app.h p0() {
        androidx.fragment.app.h hVar = this.f5486v;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.f5484t;
        return fragment != null ? fragment.mFragmentManager.p0() : this.f5487w;
    }

    s q0() {
        return this.f5467c;
    }

    public List r0() {
        return this.f5467c.n();
    }

    androidx.fragment.app.i s0() {
        return this.f5482r;
    }

    void t(C0263a c0263a, boolean z3, boolean z4, boolean z5) {
        if (z3) {
            c0263a.A(z5);
        } else {
            c0263a.z();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0263a);
        arrayList2.add(Boolean.valueOf(z3));
        if (z4 && this.f5481q >= 1) {
            u.B(this.f5482r.f(), this.f5483s, arrayList, arrayList2, 0, 1, true, this.f5478n);
        }
        if (z5) {
            P0(this.f5481q, true);
        }
        for (Fragment fragment : this.f5467c.l()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && c0263a.D(fragment.mContainerId)) {
                float f3 = fragment.mPostponedAlpha;
                if (f3 > 0.0f) {
                    fragment.mView.setAlpha(f3);
                }
                if (z5) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    LayoutInflater.Factory2 t0() {
        return this.f5470f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f5484t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f5484t)));
            sb.append("}");
        } else {
            androidx.fragment.app.i iVar = this.f5482r;
            if (iVar != null) {
                sb.append(iVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f5482r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    androidx.fragment.app.k u0() {
        return this.f5479o;
    }

    r v(Fragment fragment) {
        r m3 = this.f5467c.m(fragment.mWho);
        if (m3 != null) {
            return m3;
        }
        r rVar = new r(this.f5479o, this.f5467c, fragment);
        rVar.o(this.f5482r.f().getClassLoader());
        rVar.t(this.f5481q);
        return rVar;
    }

    Fragment v0() {
        return this.f5484t;
    }

    public Fragment w0() {
        return this.f5485u;
    }

    void x(Fragment fragment) {
        if (E0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (E0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f5467c.s(fragment);
            if (F0(fragment)) {
                this.f5454D = true;
            }
            m1(fragment);
        }
    }

    A x0() {
        A a3 = this.f5488x;
        if (a3 != null) {
            return a3;
        }
        Fragment fragment = this.f5484t;
        return fragment != null ? fragment.mFragmentManager.x0() : this.f5489y;
    }

    void y() {
        this.f5455E = false;
        this.f5456F = false;
        this.f5463M.o(false);
        S(4);
    }

    void z() {
        this.f5455E = false;
        this.f5456F = false;
        this.f5463M.o(false);
        S(0);
    }

    H z0(Fragment fragment) {
        return this.f5463M.l(fragment);
    }

    /* renamed from: androidx.fragment.app.l$l, reason: collision with other inner class name */
    static class C0082l implements Parcelable {
        public static final Parcelable.Creator<C0082l> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f5505e;

        /* renamed from: f, reason: collision with root package name */
        int f5506f;

        /* renamed from: androidx.fragment.app.l$l$a */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0082l createFromParcel(Parcel parcel) {
                return new C0082l(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C0082l[] newArray(int i3) {
                return new C0082l[i3];
            }
        }

        C0082l(String str, int i3) {
            this.f5505e = str;
            this.f5506f = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f5505e);
            parcel.writeInt(this.f5506f);
        }

        C0082l(Parcel parcel) {
            this.f5505e = parcel.readString();
            this.f5506f = parcel.readInt();
        }
    }
}
