package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class w {

    class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f5640e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f5641f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f5642g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f5643h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f5644i;

        a(int i3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f5640e = i3;
            this.f5641f = arrayList;
            this.f5642g = arrayList2;
            this.f5643h = arrayList3;
            this.f5644i = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i3 = 0; i3 < this.f5640e; i3++) {
                androidx.core.view.y.B0((View) this.f5641f.get(i3), (String) this.f5642g.get(i3));
                androidx.core.view.y.B0((View) this.f5643h.get(i3), (String) this.f5644i.get(i3));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5646e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f5647f;

        b(ArrayList arrayList, Map map) {
            this.f5646e = arrayList;
            this.f5647f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f5646e.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) this.f5646e.get(i3);
                String F3 = androidx.core.view.y.F(view);
                if (F3 != null) {
                    androidx.core.view.y.B0(view, w.i(this.f5647f, F3));
                }
            }
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5649e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f5650f;

        c(ArrayList arrayList, Map map) {
            this.f5649e = arrayList;
            this.f5650f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f5649e.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) this.f5649e.get(i3);
                androidx.core.view.y.B0(view, (String) this.f5650f.get(androidx.core.view.y.F(view)));
            }
        }
    }

    protected static void d(List list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (androidx.core.view.y.F(view) != null) {
            list.add(view);
        }
        for (int i3 = size; i3 < list.size(); i3++) {
            View view2 = (View) list.get(i3);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (!h(list, childAt, size) && androidx.core.view.y.F(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List list, View view, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (list.get(i4) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (androidx.core.view.B.a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                f(arrayList, viewGroup.getChildAt(i3));
            }
        }
    }

    public abstract Object g(Object obj);

    void j(Map map, View view) {
        if (view.getVisibility() == 0) {
            String F3 = androidx.core.view.y.F(view);
            if (F3 != null) {
                map.put(F3, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    j(map, viewGroup.getChildAt(i3));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        if (androidx.core.view.y.N(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r0[0], r0[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList o(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            arrayList2.add(androidx.core.view.y.F(view));
            androidx.core.view.y.B0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract void r(Object obj, View view, ArrayList arrayList);

    void s(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        androidx.core.view.v.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, androidx.core.os.e eVar, Runnable runnable) {
        runnable.run();
    }

    void x(View view, ArrayList arrayList, Map map) {
        androidx.core.view.v.a(view, new b(arrayList, map));
    }

    void y(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) arrayList.get(i3);
            String F3 = androidx.core.view.y.F(view2);
            arrayList4.add(F3);
            if (F3 != null) {
                androidx.core.view.y.B0(view2, null);
                String str = (String) map.get(F3);
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i4))) {
                        androidx.core.view.y.B0((View) arrayList2.get(i4), F3);
                        break;
                    }
                    i4++;
                }
            }
        }
        androidx.core.view.v.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList arrayList);
}
