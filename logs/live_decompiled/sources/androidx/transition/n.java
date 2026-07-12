package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import m.C0451a;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static l f6731a = new C0282b();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal f6732b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList f6733c = new ArrayList();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        l f6734e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f6735f;

        /* renamed from: androidx.transition.n$a$a, reason: collision with other inner class name */
        class C0096a extends m {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0451a f6736a;

            C0096a(C0451a c0451a) {
                this.f6736a = c0451a;
            }

            @Override // androidx.transition.l.g
            public void e(l lVar) {
                ((ArrayList) this.f6736a.get(a.this.f6735f)).remove(lVar);
                lVar.removeListener(this);
            }
        }

        a(l lVar, ViewGroup viewGroup) {
            this.f6734e = lVar;
            this.f6735f = viewGroup;
        }

        private void a() {
            this.f6735f.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f6735f.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!n.f6733c.remove(this.f6735f)) {
                return true;
            }
            C0451a b3 = n.b();
            ArrayList arrayList = (ArrayList) b3.get(this.f6735f);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b3.put(this.f6735f, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f6734e);
            this.f6734e.addListener(new C0096a(b3));
            this.f6734e.captureValues(this.f6735f, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).resume(this.f6735f);
                }
            }
            this.f6734e.playTransition(this.f6735f);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n.f6733c.remove(this.f6735f);
            ArrayList arrayList = (ArrayList) n.b().get(this.f6735f);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).resume(this.f6735f);
                }
            }
            this.f6734e.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup, l lVar) {
        if (f6733c.contains(viewGroup) || !androidx.core.view.y.O(viewGroup)) {
            return;
        }
        f6733c.add(viewGroup);
        if (lVar == null) {
            lVar = f6731a;
        }
        l mo0clone = lVar.mo0clone();
        d(viewGroup, mo0clone);
        k.b(viewGroup, null);
        c(viewGroup, mo0clone);
    }

    static C0451a b() {
        C0451a c0451a;
        WeakReference weakReference = (WeakReference) f6732b.get();
        if (weakReference != null && (c0451a = (C0451a) weakReference.get()) != null) {
            return c0451a;
        }
        C0451a c0451a2 = new C0451a();
        f6732b.set(new WeakReference(c0451a2));
        return c0451a2;
    }

    private static void c(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, l lVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((l) it.next()).pause(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.captureValues(viewGroup, true);
        }
        k.a(viewGroup);
    }
}
