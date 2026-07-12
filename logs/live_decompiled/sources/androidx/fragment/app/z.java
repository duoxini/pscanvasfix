package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f5658a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f5659b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f5660c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    boolean f5661d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f5662e = false;

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f5663e;

        a(d dVar) {
            this.f5663e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (z.this.f5659b.contains(this.f5663e)) {
                this.f5663e.e().a(this.f5663e.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f5665e;

        b(d dVar) {
            this.f5665e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f5659b.remove(this.f5665e);
            z.this.f5660c.remove(this.f5665e);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5667a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5668b;

        static {
            int[] iArr = new int[e.b.values().length];
            f5668b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5668b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5668b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f5667a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5667a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5667a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5667a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        private final r f5669h;

        d(e.c cVar, e.b bVar, r rVar, androidx.core.os.e eVar) {
            super(cVar, bVar, rVar.k(), eVar);
            this.f5669h = rVar;
        }

        @Override // androidx.fragment.app.z.e
        public void c() {
            super.c();
            this.f5669h.m();
        }

        @Override // androidx.fragment.app.z.e
        void l() {
            if (g() == e.b.ADDING) {
                Fragment k3 = this.f5669h.k();
                View findFocus = k3.mView.findFocus();
                if (findFocus != null) {
                    k3.setFocusedView(findFocus);
                    if (l.E0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k3);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f5669h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k3.getPostOnViewCreatedAlpha());
            }
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private c f5670a;

        /* renamed from: b, reason: collision with root package name */
        private b f5671b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f5672c;

        /* renamed from: d, reason: collision with root package name */
        private final List f5673d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet f5674e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private boolean f5675f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5676g = false;

        class a implements e.b {
            a() {
            }

            @Override // androidx.core.os.e.b
            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i3) {
                if (i3 == 0) {
                    return VISIBLE;
                }
                if (i3 == 4) {
                    return INVISIBLE;
                }
                if (i3 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i3);
            }

            static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            void a(View view) {
                int i3 = c.f5667a[ordinal()];
                if (i3 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (l.E0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i3 == 2) {
                    if (l.E0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i3 == 3) {
                    if (l.E0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i3 != 4) {
                    return;
                }
                if (l.E0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f5670a = cVar;
            this.f5671b = bVar;
            this.f5672c = fragment;
            eVar.c(new a());
        }

        final void a(Runnable runnable) {
            this.f5673d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f5675f = true;
            if (this.f5674e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f5674e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
        }

        public void c() {
            if (this.f5676g) {
                return;
            }
            if (l.E0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f5676g = true;
            Iterator it = this.f5673d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(androidx.core.os.e eVar) {
            if (this.f5674e.remove(eVar) && this.f5674e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f5670a;
        }

        public final Fragment f() {
            return this.f5672c;
        }

        b g() {
            return this.f5671b;
        }

        final boolean h() {
            return this.f5675f;
        }

        final boolean i() {
            return this.f5676g;
        }

        public final void j(androidx.core.os.e eVar) {
            l();
            this.f5674e.add(eVar);
        }

        final void k(c cVar, b bVar) {
            int i3 = c.f5668b[bVar.ordinal()];
            if (i3 == 1) {
                if (this.f5670a == c.REMOVED) {
                    if (l.E0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f5672c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f5671b + " to ADDING.");
                    }
                    this.f5670a = c.VISIBLE;
                    this.f5671b = b.ADDING;
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (l.E0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f5672c + " mFinalState = " + this.f5670a + " -> REMOVED. mLifecycleImpact  = " + this.f5671b + " to REMOVING.");
                }
                this.f5670a = c.REMOVED;
                this.f5671b = b.REMOVING;
                return;
            }
            if (i3 == 3 && this.f5670a != c.REMOVED) {
                if (l.E0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f5672c + " mFinalState = " + this.f5670a + " -> " + cVar + ". ");
                }
                this.f5670a = cVar;
            }
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f5670a + "} {mLifecycleImpact = " + this.f5671b + "} {mFragment = " + this.f5672c + "}";
        }
    }

    z(ViewGroup viewGroup) {
        this.f5658a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, r rVar) {
        synchronized (this.f5659b) {
            try {
                androidx.core.os.e eVar = new androidx.core.os.e();
                e h3 = h(rVar.k());
                if (h3 != null) {
                    h3.k(cVar, bVar);
                    return;
                }
                d dVar = new d(cVar, bVar, rVar, eVar);
                this.f5659b.add(dVar);
                dVar.a(new a(dVar));
                dVar.a(new b(dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private e h(Fragment fragment) {
        Iterator it = this.f5659b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator it = this.f5660c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    static z n(ViewGroup viewGroup, l lVar) {
        return o(viewGroup, lVar.x0());
    }

    static z o(ViewGroup viewGroup, A a3) {
        Object tag = viewGroup.getTag(E.b.f347b);
        if (tag instanceof z) {
            return (z) tag;
        }
        z a4 = a3.a(viewGroup);
        viewGroup.setTag(E.b.f347b, a4);
        return a4;
    }

    private void q() {
        Iterator it = this.f5659b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, r rVar) {
        if (l.E0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + rVar.k());
        }
        a(cVar, e.b.ADDING, rVar);
    }

    void c(r rVar) {
        if (l.E0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + rVar.k());
        }
        a(e.c.GONE, e.b.NONE, rVar);
    }

    void d(r rVar) {
        if (l.E0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + rVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, rVar);
    }

    void e(r rVar) {
        if (l.E0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + rVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, rVar);
    }

    abstract void f(List list, boolean z3);

    void g() {
        if (this.f5662e) {
            return;
        }
        if (!androidx.core.view.y.N(this.f5658a)) {
            j();
            this.f5661d = false;
            return;
        }
        synchronized (this.f5659b) {
            try {
                if (!this.f5659b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f5660c);
                    this.f5660c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (l.E0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f5660c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f5659b);
                    this.f5659b.clear();
                    this.f5660c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f5661d);
                    this.f5661d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        String str;
        String str2;
        boolean N3 = androidx.core.view.y.N(this.f5658a);
        synchronized (this.f5659b) {
            try {
                q();
                Iterator it = this.f5659b.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).l();
                }
                Iterator it2 = new ArrayList(this.f5660c).iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (l.E0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (N3) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f5658a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(eVar);
                        Log.v("FragmentManager", sb.toString());
                    }
                    eVar.b();
                }
                Iterator it3 = new ArrayList(this.f5659b).iterator();
                while (it3.hasNext()) {
                    e eVar2 = (e) it3.next();
                    if (l.E0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (N3) {
                            str = "";
                        } else {
                            str = "Container " + this.f5658a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(eVar2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    eVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.f5662e) {
            this.f5662e = false;
            g();
        }
    }

    e.b l(r rVar) {
        e h3 = h(rVar.k());
        e.b g3 = h3 != null ? h3.g() : null;
        e i3 = i(rVar.k());
        return (i3 == null || !(g3 == null || g3 == e.b.NONE)) ? g3 : i3.g();
    }

    public ViewGroup m() {
        return this.f5658a;
    }

    void p() {
        synchronized (this.f5659b) {
            try {
                q();
                this.f5662e = false;
                int size = this.f5659b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    e eVar = (e) this.f5659b.get(size);
                    e.c c3 = e.c.c(eVar.f().mView);
                    e.c e3 = eVar.e();
                    e.c cVar = e.c.VISIBLE;
                    if (e3 == cVar && c3 != cVar) {
                        this.f5662e = eVar.f().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z3) {
        this.f5661d = z3;
    }
}
