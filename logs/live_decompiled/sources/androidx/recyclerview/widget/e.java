package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.y;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e extends o {

    /* renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f6485s;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f6486h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f6487i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f6488j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f6489k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    ArrayList f6490l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    ArrayList f6491m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    ArrayList f6492n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    ArrayList f6493o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    ArrayList f6494p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    ArrayList f6495q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    ArrayList f6496r = new ArrayList();

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f6497e;

        a(ArrayList arrayList) {
            this.f6497e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f6497e.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                e.this.S(jVar.f6531a, jVar.f6532b, jVar.f6533c, jVar.f6534d, jVar.f6535e);
            }
            this.f6497e.clear();
            e.this.f6491m.remove(this.f6497e);
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f6499e;

        b(ArrayList arrayList) {
            this.f6499e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f6499e.iterator();
            while (it.hasNext()) {
                e.this.R((i) it.next());
            }
            this.f6499e.clear();
            e.this.f6492n.remove(this.f6499e);
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f6501e;

        c(ArrayList arrayList) {
            this.f6501e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f6501e.iterator();
            while (it.hasNext()) {
                e.this.Q((RecyclerView.E) it.next());
            }
            this.f6501e.clear();
            e.this.f6490l.remove(this.f6501e);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.E f6503a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6504b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6505c;

        d(RecyclerView.E e3, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6503a = e3;
            this.f6504b = viewPropertyAnimator;
            this.f6505c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6504b.setListener(null);
            this.f6505c.setAlpha(1.0f);
            e.this.G(this.f6503a);
            e.this.f6495q.remove(this.f6503a);
            e.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.H(this.f6503a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$e, reason: collision with other inner class name */
    class C0094e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.E f6507a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6508b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6509c;

        C0094e(RecyclerView.E e3, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6507a = e3;
            this.f6508b = view;
            this.f6509c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6508b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6509c.setListener(null);
            e.this.A(this.f6507a);
            e.this.f6493o.remove(this.f6507a);
            e.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.B(this.f6507a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.E f6511a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6512b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6513c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f6514d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6515e;

        f(RecyclerView.E e3, int i3, View view, int i4, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6511a = e3;
            this.f6512b = i3;
            this.f6513c = view;
            this.f6514d = i4;
            this.f6515e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f6512b != 0) {
                this.f6513c.setTranslationX(0.0f);
            }
            if (this.f6514d != 0) {
                this.f6513c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6515e.setListener(null);
            e.this.E(this.f6511a);
            e.this.f6494p.remove(this.f6511a);
            e.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.F(this.f6511a);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6517a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6518b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6519c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6517a = iVar;
            this.f6518b = viewPropertyAnimator;
            this.f6519c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6518b.setListener(null);
            this.f6519c.setAlpha(1.0f);
            this.f6519c.setTranslationX(0.0f);
            this.f6519c.setTranslationY(0.0f);
            e.this.C(this.f6517a.f6525a, true);
            e.this.f6496r.remove(this.f6517a.f6525a);
            e.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.D(this.f6517a.f6525a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f6521a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f6522b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6523c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6521a = iVar;
            this.f6522b = viewPropertyAnimator;
            this.f6523c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6522b.setListener(null);
            this.f6523c.setAlpha(1.0f);
            this.f6523c.setTranslationX(0.0f);
            this.f6523c.setTranslationY(0.0f);
            e.this.C(this.f6521a.f6526b, false);
            e.this.f6496r.remove(this.f6521a.f6526b);
            e.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.D(this.f6521a.f6526b, false);
        }
    }

    private static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.E f6531a;

        /* renamed from: b, reason: collision with root package name */
        public int f6532b;

        /* renamed from: c, reason: collision with root package name */
        public int f6533c;

        /* renamed from: d, reason: collision with root package name */
        public int f6534d;

        /* renamed from: e, reason: collision with root package name */
        public int f6535e;

        j(RecyclerView.E e3, int i3, int i4, int i5, int i6) {
            this.f6531a = e3;
            this.f6532b = i3;
            this.f6533c = i4;
            this.f6534d = i5;
            this.f6535e = i6;
        }
    }

    private void T(RecyclerView.E e3) {
        View view = e3.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f6495q.add(e3);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(e3, animate, view)).start();
    }

    private void W(List list, RecyclerView.E e3) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, e3) && iVar.f6525a == null && iVar.f6526b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.E e3 = iVar.f6525a;
        if (e3 != null) {
            Y(iVar, e3);
        }
        RecyclerView.E e4 = iVar.f6526b;
        if (e4 != null) {
            Y(iVar, e4);
        }
    }

    private boolean Y(i iVar, RecyclerView.E e3) {
        boolean z3 = false;
        if (iVar.f6526b == e3) {
            iVar.f6526b = null;
        } else {
            if (iVar.f6525a != e3) {
                return false;
            }
            iVar.f6525a = null;
            z3 = true;
        }
        e3.itemView.setAlpha(1.0f);
        e3.itemView.setTranslationX(0.0f);
        e3.itemView.setTranslationY(0.0f);
        C(e3, z3);
        return true;
    }

    private void Z(RecyclerView.E e3) {
        if (f6485s == null) {
            f6485s = new ValueAnimator().getInterpolator();
        }
        e3.itemView.animate().setInterpolator(f6485s);
        j(e3);
    }

    void Q(RecyclerView.E e3) {
        View view = e3.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f6493o.add(e3);
        animate.alpha(1.0f).setDuration(l()).setListener(new C0094e(e3, view, animate)).start();
    }

    void R(i iVar) {
        RecyclerView.E e3 = iVar.f6525a;
        View view = e3 == null ? null : e3.itemView;
        RecyclerView.E e4 = iVar.f6526b;
        View view2 = e4 != null ? e4.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f6496r.add(iVar.f6525a);
            duration.translationX(iVar.f6529e - iVar.f6527c);
            duration.translationY(iVar.f6530f - iVar.f6528d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f6496r.add(iVar.f6526b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    void S(RecyclerView.E e3, int i3, int i4, int i5, int i6) {
        View view = e3.itemView;
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        if (i7 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i8 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f6494p.add(e3);
        animate.setDuration(n()).setListener(new f(e3, i7, view, i8, animate)).start();
    }

    void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.E) list.get(size)).itemView.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean g(RecyclerView.E e3, List list) {
        return !list.isEmpty() || super.g(e3, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j(RecyclerView.E e3) {
        View view = e3.itemView;
        view.animate().cancel();
        int size = this.f6488j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f6488j.get(size)).f6531a == e3) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(e3);
                this.f6488j.remove(size);
            }
        }
        W(this.f6489k, e3);
        if (this.f6486h.remove(e3)) {
            view.setAlpha(1.0f);
            G(e3);
        }
        if (this.f6487i.remove(e3)) {
            view.setAlpha(1.0f);
            A(e3);
        }
        for (int size2 = this.f6492n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f6492n.get(size2);
            W(arrayList, e3);
            if (arrayList.isEmpty()) {
                this.f6492n.remove(size2);
            }
        }
        for (int size3 = this.f6491m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f6491m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).f6531a == e3) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(e3);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f6491m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f6490l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f6490l.get(size5);
            if (arrayList3.remove(e3)) {
                view.setAlpha(1.0f);
                A(e3);
                if (arrayList3.isEmpty()) {
                    this.f6490l.remove(size5);
                }
            }
        }
        this.f6495q.remove(e3);
        this.f6493o.remove(e3);
        this.f6496r.remove(e3);
        this.f6494p.remove(e3);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void k() {
        int size = this.f6488j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f6488j.get(size);
            View view = jVar.f6531a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f6531a);
            this.f6488j.remove(size);
        }
        for (int size2 = this.f6486h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.E) this.f6486h.get(size2));
            this.f6486h.remove(size2);
        }
        int size3 = this.f6487i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.E e3 = (RecyclerView.E) this.f6487i.get(size3);
            e3.itemView.setAlpha(1.0f);
            A(e3);
            this.f6487i.remove(size3);
        }
        for (int size4 = this.f6489k.size() - 1; size4 >= 0; size4--) {
            X((i) this.f6489k.get(size4));
        }
        this.f6489k.clear();
        if (p()) {
            for (int size5 = this.f6491m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f6491m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f6531a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f6531a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f6491m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f6490l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f6490l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.E e4 = (RecyclerView.E) arrayList2.get(size8);
                    e4.itemView.setAlpha(1.0f);
                    A(e4);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f6490l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f6492n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f6492n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f6492n.remove(arrayList3);
                    }
                }
            }
            U(this.f6495q);
            U(this.f6494p);
            U(this.f6493o);
            U(this.f6496r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean p() {
        return (this.f6487i.isEmpty() && this.f6489k.isEmpty() && this.f6488j.isEmpty() && this.f6486h.isEmpty() && this.f6494p.isEmpty() && this.f6495q.isEmpty() && this.f6493o.isEmpty() && this.f6496r.isEmpty() && this.f6491m.isEmpty() && this.f6490l.isEmpty() && this.f6492n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void u() {
        boolean isEmpty = this.f6486h.isEmpty();
        boolean isEmpty2 = this.f6488j.isEmpty();
        boolean isEmpty3 = this.f6489k.isEmpty();
        boolean isEmpty4 = this.f6487i.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator it = this.f6486h.iterator();
        while (it.hasNext()) {
            T((RecyclerView.E) it.next());
        }
        this.f6486h.clear();
        if (!isEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f6488j);
            this.f6491m.add(arrayList);
            this.f6488j.clear();
            a aVar = new a(arrayList);
            if (isEmpty) {
                aVar.run();
            } else {
                y.b0(((j) arrayList.get(0)).f6531a.itemView, aVar, o());
            }
        }
        if (!isEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f6489k);
            this.f6492n.add(arrayList2);
            this.f6489k.clear();
            b bVar = new b(arrayList2);
            if (isEmpty) {
                bVar.run();
            } else {
                y.b0(((i) arrayList2.get(0)).f6525a.itemView, bVar, o());
            }
        }
        if (isEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f6487i);
        this.f6490l.add(arrayList3);
        this.f6487i.clear();
        c cVar = new c(arrayList3);
        if (isEmpty && isEmpty2 && isEmpty3) {
            cVar.run();
        } else {
            y.b0(((RecyclerView.E) arrayList3.get(0)).itemView, cVar, (!isEmpty ? o() : 0L) + Math.max(!isEmpty2 ? n() : 0L, isEmpty3 ? 0L : m()));
        }
    }

    @Override // androidx.recyclerview.widget.o
    public boolean w(RecyclerView.E e3) {
        Z(e3);
        e3.itemView.setAlpha(0.0f);
        this.f6487i.add(e3);
        return true;
    }

    @Override // androidx.recyclerview.widget.o
    public boolean x(RecyclerView.E e3, RecyclerView.E e4, int i3, int i4, int i5, int i6) {
        if (e3 == e4) {
            return y(e3, i3, i4, i5, i6);
        }
        float translationX = e3.itemView.getTranslationX();
        float translationY = e3.itemView.getTranslationY();
        float alpha = e3.itemView.getAlpha();
        Z(e3);
        int i7 = (int) ((i5 - i3) - translationX);
        int i8 = (int) ((i6 - i4) - translationY);
        e3.itemView.setTranslationX(translationX);
        e3.itemView.setTranslationY(translationY);
        e3.itemView.setAlpha(alpha);
        if (e4 != null) {
            Z(e4);
            e4.itemView.setTranslationX(-i7);
            e4.itemView.setTranslationY(-i8);
            e4.itemView.setAlpha(0.0f);
        }
        this.f6489k.add(new i(e3, e4, i3, i4, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.o
    public boolean y(RecyclerView.E e3, int i3, int i4, int i5, int i6) {
        View view = e3.itemView;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i4 + ((int) e3.itemView.getTranslationY());
        Z(e3);
        int i7 = i5 - translationX;
        int i8 = i6 - translationY;
        if (i7 == 0 && i8 == 0) {
            E(e3);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-i7);
        }
        if (i8 != 0) {
            view.setTranslationY(-i8);
        }
        this.f6488j.add(new j(e3, translationX, translationY, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.o
    public boolean z(RecyclerView.E e3) {
        Z(e3);
        this.f6486h.add(e3);
        return true;
    }

    private static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.E f6525a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.E f6526b;

        /* renamed from: c, reason: collision with root package name */
        public int f6527c;

        /* renamed from: d, reason: collision with root package name */
        public int f6528d;

        /* renamed from: e, reason: collision with root package name */
        public int f6529e;

        /* renamed from: f, reason: collision with root package name */
        public int f6530f;

        private i(RecyclerView.E e3, RecyclerView.E e4) {
            this.f6525a = e3;
            this.f6526b = e4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f6525a + ", newHolder=" + this.f6526b + ", fromX=" + this.f6527c + ", fromY=" + this.f6528d + ", toX=" + this.f6529e + ", toY=" + this.f6530f + '}';
        }

        i(RecyclerView.E e3, RecyclerView.E e4, int i3, int i4, int i5, int i6) {
            this(e3, e4);
            this.f6527c = i3;
            this.f6528d = i4;
            this.f6529e = i5;
            this.f6530f = i6;
        }
    }
}
