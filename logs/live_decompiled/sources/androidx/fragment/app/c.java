package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.e;
import androidx.fragment.app.e;
import androidx.fragment.app.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.C0451a;

/* loaded from: classes.dex */
class c extends z {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5371a;

        static {
            int[] iArr = new int[z.e.c.values().length];
            f5371a = iArr;
            try {
                iArr[z.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5371a[z.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5371a[z.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5371a[z.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f5372e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ z.e f5373f;

        b(List list, z.e eVar) {
            this.f5372e = list;
            this.f5373f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5372e.contains(this.f5373f)) {
                this.f5372e.remove(this.f5373f);
                c.this.s(this.f5373f);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    class C0079c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5375a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5376b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5377c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.e f5378d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f5379e;

        C0079c(ViewGroup viewGroup, View view, boolean z3, z.e eVar, k kVar) {
            this.f5375a = viewGroup;
            this.f5376b = view;
            this.f5377c = z3;
            this.f5378d = eVar;
            this.f5379e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5375a.endViewTransition(this.f5376b);
            if (this.f5377c) {
                this.f5378d.e().a(this.f5376b);
            }
            this.f5379e.a();
        }
    }

    class d implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f5381a;

        d(Animator animator) {
            this.f5381a = animator;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            this.f5381a.end();
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5384b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f5385c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f5383a.endViewTransition(eVar.f5384b);
                e.this.f5385c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.f5383a = viewGroup;
            this.f5384b = view;
            this.f5385c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5383a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5388a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5389b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f5390c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.f5388a = view;
            this.f5389b = viewGroup;
            this.f5390c = kVar;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            this.f5388a.clearAnimation();
            this.f5389b.endViewTransition(this.f5388a);
            this.f5390c.a();
        }
    }

    class g implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.e f5392e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ z.e f5393f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f5394g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ C0451a f5395h;

        g(z.e eVar, z.e eVar2, boolean z3, C0451a c0451a) {
            this.f5392e = eVar;
            this.f5393f = eVar2;
            this.f5394g = z3;
            this.f5395h = c0451a;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.f(this.f5392e.f(), this.f5393f.f(), this.f5394g, this.f5395h, false);
        }
    }

    class h implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ w f5397e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f5398f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Rect f5399g;

        h(w wVar, View view, Rect rect) {
            this.f5397e = wVar;
            this.f5398f = view;
            this.f5399g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5397e.k(this.f5398f, this.f5399g);
        }
    }

    class i implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5401e;

        i(ArrayList arrayList) {
            this.f5401e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.A(this.f5401e, 4);
        }
    }

    class j implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f5403e;

        j(m mVar) {
            this.f5403e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5403e.a();
        }
    }

    private static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f5405c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5406d;

        /* renamed from: e, reason: collision with root package name */
        private e.d f5407e;

        k(z.e eVar, androidx.core.os.e eVar2, boolean z3) {
            super(eVar, eVar2);
            this.f5406d = false;
            this.f5405c = z3;
        }

        e.d e(Context context) {
            if (this.f5406d) {
                return this.f5407e;
            }
            e.d c3 = androidx.fragment.app.e.c(context, b().f(), b().e() == z.e.c.VISIBLE, this.f5405c);
            this.f5407e = c3;
            this.f5406d = true;
            return c3;
        }
    }

    private static class l {

        /* renamed from: a, reason: collision with root package name */
        private final z.e f5408a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.e f5409b;

        l(z.e eVar, androidx.core.os.e eVar2) {
            this.f5408a = eVar;
            this.f5409b = eVar2;
        }

        void a() {
            this.f5408a.d(this.f5409b);
        }

        z.e b() {
            return this.f5408a;
        }

        androidx.core.os.e c() {
            return this.f5409b;
        }

        boolean d() {
            z.e.c cVar;
            z.e.c c3 = z.e.c.c(this.f5408a.f().mView);
            z.e.c e3 = this.f5408a.e();
            return c3 == e3 || !(c3 == (cVar = z.e.c.VISIBLE) || e3 == cVar);
        }
    }

    private static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final Object f5410c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f5411d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f5412e;

        m(z.e eVar, androidx.core.os.e eVar2, boolean z3, boolean z4) {
            super(eVar, eVar2);
            if (eVar.e() == z.e.c.VISIBLE) {
                this.f5410c = z3 ? eVar.f().getReenterTransition() : eVar.f().getEnterTransition();
                this.f5411d = z3 ? eVar.f().getAllowReturnTransitionOverlap() : eVar.f().getAllowEnterTransitionOverlap();
            } else {
                this.f5410c = z3 ? eVar.f().getReturnTransition() : eVar.f().getExitTransition();
                this.f5411d = true;
            }
            if (!z4) {
                this.f5412e = null;
            } else if (z3) {
                this.f5412e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f5412e = eVar.f().getSharedElementEnterTransition();
            }
        }

        private w f(Object obj) {
            if (obj == null) {
                return null;
            }
            w wVar = u.f5582b;
            if (wVar != null && wVar.e(obj)) {
                return wVar;
            }
            w wVar2 = u.f5583c;
            if (wVar2 != null && wVar2.e(obj)) {
                return wVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        w e() {
            w f3 = f(this.f5410c);
            w f4 = f(this.f5412e);
            if (f3 == null || f4 == null || f3 == f4) {
                return f3 != null ? f3 : f4;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f5410c + " which uses a different Transition  type than its shared element transition " + this.f5412e);
        }

        public Object g() {
            return this.f5412e;
        }

        Object h() {
            return this.f5410c;
        }

        public boolean i() {
            return this.f5412e != null;
        }

        boolean j() {
            return this.f5411d;
        }
    }

    c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z3, Map map) {
        ViewGroup m3 = m();
        Context context = m3.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                e.d e3 = kVar.e(context);
                if (e3 == null) {
                    kVar.a();
                } else {
                    Animator animator = e3.f5431b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        z.e b3 = kVar.b();
                        Fragment f3 = b3.f();
                        if (Boolean.TRUE.equals(map.get(b3))) {
                            if (androidx.fragment.app.l.E0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f3 + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z5 = b3.e() == z.e.c.GONE;
                            if (z5) {
                                list2.remove(b3);
                            }
                            View view = f3.mView;
                            m3.startViewTransition(view);
                            animator.addListener(new C0079c(m3, view, z5, b3, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z4 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar2 = (k) it2.next();
            z.e b4 = kVar2.b();
            Fragment f4 = b4.f();
            if (z3) {
                if (androidx.fragment.app.l.E0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f4 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z4) {
                if (androidx.fragment.app.l.E0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f4 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = f4.mView;
                Animation animation = (Animation) androidx.core.util.h.d(((e.d) androidx.core.util.h.d(kVar2.e(context))).f5430a);
                if (b4.e() != z.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    m3.startViewTransition(view2);
                    e.RunnableC0081e runnableC0081e = new e.RunnableC0081e(animation, m3, view2);
                    runnableC0081e.setAnimationListener(new e(m3, view2, kVar2));
                    view2.startAnimation(runnableC0081e);
                }
                kVar2.c().c(new f(view2, m3, kVar2));
            }
        }
    }

    private Map x(List list, List list2, boolean z3, z.e eVar, z.e eVar2) {
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        z.e eVar3;
        z.e eVar4;
        View view2;
        Object n3;
        C0451a c0451a;
        ArrayList arrayList3;
        z.e eVar5;
        ArrayList arrayList4;
        Rect rect;
        View view3;
        w wVar;
        z.e eVar6;
        View view4;
        boolean z4 = z3;
        z.e eVar7 = eVar;
        z.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        w wVar2 = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                w e3 = mVar.e();
                if (wVar2 == null) {
                    wVar2 = e3;
                } else if (e3 != null && wVar2 != e3) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (wVar2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                hashMap.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        C0451a c0451a2 = new C0451a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z5 = false;
        while (it3.hasNext()) {
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                c0451a = c0451a2;
                arrayList3 = arrayList6;
                eVar5 = eVar7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                wVar = wVar2;
                eVar6 = eVar8;
                view6 = view6;
            } else {
                Object B3 = wVar2.B(wVar2.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view7 = view6;
                int i3 = 0;
                while (i3 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (z4) {
                    eVar.f().getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                } else {
                    eVar.f().getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                }
                int i4 = 0;
                for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                    c0451a2.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i4++;
                }
                C0451a c0451a3 = new C0451a();
                u(c0451a3, eVar.f().mView);
                c0451a3.o(sharedElementSourceNames);
                c0451a2.o(c0451a3.keySet());
                C0451a c0451a4 = new C0451a();
                u(c0451a4, eVar2.f().mView);
                c0451a4.o(sharedElementTargetNames2);
                c0451a4.o(c0451a2.values());
                u.x(c0451a2, c0451a4);
                v(c0451a3, c0451a2.keySet());
                v(c0451a4, c0451a2.values());
                if (c0451a2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    c0451a = c0451a2;
                    arrayList3 = arrayList6;
                    eVar5 = eVar7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    wVar = wVar2;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar8;
                } else {
                    u.f(eVar2.f(), eVar.f(), z4, c0451a3, true);
                    c0451a = c0451a2;
                    ArrayList arrayList8 = arrayList6;
                    androidx.core.view.v.a(m(), new g(eVar2, eVar, z3, c0451a4));
                    arrayList5.addAll(c0451a3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view7;
                    } else {
                        view6 = (View) c0451a3.get((String) sharedElementSourceNames.get(0));
                        wVar2.v(B3, view6);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(c0451a4.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = (View) c0451a4.get((String) sharedElementTargetNames2.get(0))) != null) {
                        androidx.core.view.v.a(m(), new h(wVar2, view4, rect2));
                        z5 = true;
                    }
                    wVar2.z(B3, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    wVar = wVar2;
                    wVar2.t(B3, null, null, null, null, B3, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    hashMap.put(eVar5, bool);
                    eVar6 = eVar2;
                    hashMap.put(eVar6, bool);
                    obj3 = B3;
                }
            }
            eVar7 = eVar5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            eVar8 = eVar6;
            c0451a2 = c0451a;
            z4 = z3;
            arrayList6 = arrayList3;
            wVar2 = wVar;
        }
        View view8 = view6;
        C0451a c0451a5 = c0451a2;
        ArrayList arrayList9 = arrayList6;
        z.e eVar9 = eVar7;
        ArrayList arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view9 = view5;
        w wVar3 = wVar2;
        boolean z6 = false;
        z.e eVar10 = eVar8;
        ArrayList arrayList11 = new ArrayList();
        Iterator it4 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it4.hasNext()) {
            m mVar4 = (m) it4.next();
            if (mVar4.d()) {
                hashMap.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object g3 = wVar3.g(mVar4.h());
                z.e b3 = mVar4.b();
                boolean z7 = (obj3 == null || !(b3 == eVar9 || b3 == eVar10)) ? z6 : true;
                if (g3 == null) {
                    if (!z7) {
                        hashMap.put(b3, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view9;
                    n3 = obj4;
                    eVar3 = eVar10;
                    view2 = view8;
                } else {
                    ArrayList arrayList12 = new ArrayList();
                    Object obj6 = obj4;
                    t(arrayList12, b3.f().mView);
                    if (z7) {
                        if (b3 == eVar9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        wVar3.a(g3, view9);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view9;
                        eVar4 = b3;
                        obj2 = obj5;
                        eVar3 = eVar10;
                        obj = obj6;
                    } else {
                        wVar3.b(g3, arrayList12);
                        view = view9;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        eVar3 = eVar10;
                        wVar3.t(g3, g3, arrayList12, null, null, null, null);
                        if (b3.e() == z.e.c.GONE) {
                            eVar4 = b3;
                            list2.remove(eVar4);
                            ArrayList arrayList13 = new ArrayList(arrayList12);
                            arrayList13.remove(eVar4.f().mView);
                            wVar3.r(g3, eVar4.f().mView, arrayList13);
                            androidx.core.view.v.a(m(), new i(arrayList12));
                        } else {
                            eVar4 = b3;
                        }
                    }
                    if (eVar4.e() == z.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z5) {
                            wVar3.u(g3, rect3);
                        }
                        view2 = view8;
                    } else {
                        view2 = view8;
                        wVar3.v(g3, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        obj5 = wVar3.n(obj2, g3, null);
                        n3 = obj;
                    } else {
                        n3 = wVar3.n(obj, g3, null);
                        obj5 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = n3;
                view8 = view2;
                view9 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
                z6 = false;
            }
        }
        ArrayList arrayList14 = arrayList9;
        ArrayList arrayList15 = arrayList10;
        z.e eVar11 = eVar10;
        Object m3 = wVar3.m(obj5, obj4, obj3);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            m mVar5 = (m) it5.next();
            if (!mVar5.d()) {
                Object h3 = mVar5.h();
                z.e b4 = mVar5.b();
                boolean z8 = obj3 != null && (b4 == eVar9 || b4 == eVar11);
                if (h3 != null || z8) {
                    if (androidx.core.view.y.O(m())) {
                        wVar3.w(mVar5.b().f(), m3, mVar5.c(), new j(mVar5));
                    } else {
                        if (androidx.fragment.app.l.E0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b4);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!androidx.core.view.y.O(m())) {
            return hashMap;
        }
        u.A(arrayList11, 4);
        ArrayList o3 = wVar3.o(arrayList14);
        wVar3.c(m(), m3);
        wVar3.y(m(), arrayList15, arrayList14, o3, c0451a5);
        u.A(arrayList11, 0);
        wVar3.A(obj3, arrayList15, arrayList14);
        return hashMap;
    }

    @Override // androidx.fragment.app.z
    void f(List list, boolean z3) {
        Iterator it = list.iterator();
        z.e eVar = null;
        z.e eVar2 = null;
        while (it.hasNext()) {
            z.e eVar3 = (z.e) it.next();
            z.e.c c3 = z.e.c.c(eVar3.f().mView);
            int i3 = a.f5371a[eVar3.e().ordinal()];
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                if (c3 == z.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i3 == 4 && c3 != z.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            z.e eVar4 = (z.e) it2.next();
            androidx.core.os.e eVar5 = new androidx.core.os.e();
            eVar4.j(eVar5);
            arrayList.add(new k(eVar4, eVar5, z3));
            androidx.core.os.e eVar6 = new androidx.core.os.e();
            eVar4.j(eVar6);
            boolean z4 = false;
            if (z3) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, eVar6, z3, z4));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z4 = true;
                arrayList2.add(new m(eVar4, eVar6, z3, z4));
                eVar4.a(new b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, eVar6, z3, z4));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z4 = true;
                arrayList2.add(new m(eVar4, eVar6, z3, z4));
                eVar4.a(new b(arrayList3, eVar4));
            }
        }
        Map x3 = x(arrayList2, arrayList3, z3, eVar, eVar2);
        w(arrayList, arrayList3, x3.containsValue(Boolean.TRUE), x3);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            s((z.e) it3.next());
        }
        arrayList3.clear();
    }

    void s(z.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (androidx.core.view.B.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String F3 = androidx.core.view.y.F(view);
        if (F3 != null) {
            map.put(F3, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(C0451a c0451a, Collection collection) {
        Iterator it = c0451a.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.y.F((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }
}
