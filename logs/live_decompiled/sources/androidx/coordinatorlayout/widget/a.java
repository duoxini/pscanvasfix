package androidx.coordinatorlayout.widget;

import androidx.core.util.e;
import androidx.core.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import m.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final e f4797a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    private final g f4798b = new g();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f4799c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f4800d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f4798b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                e(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f4797a.b();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void k(ArrayList arrayList) {
        arrayList.clear();
        this.f4797a.a(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (!this.f4798b.containsKey(obj) || !this.f4798b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f4798b.get(obj);
        if (arrayList == null) {
            arrayList = f();
            this.f4798b.put(obj, arrayList);
        }
        arrayList.add(obj2);
    }

    public void b(Object obj) {
        if (this.f4798b.containsKey(obj)) {
            return;
        }
        this.f4798b.put(obj, null);
    }

    public void c() {
        int size = this.f4798b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList = (ArrayList) this.f4798b.m(i3);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.f4798b.clear();
    }

    public boolean d(Object obj) {
        return this.f4798b.containsKey(obj);
    }

    public List g(Object obj) {
        return (List) this.f4798b.get(obj);
    }

    public List h(Object obj) {
        int size = this.f4798b.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList2 = (ArrayList) this.f4798b.m(i3);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f4798b.i(i3));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.f4799c.clear();
        this.f4800d.clear();
        int size = this.f4798b.size();
        for (int i3 = 0; i3 < size; i3++) {
            e(this.f4798b.i(i3), this.f4799c, this.f4800d);
        }
        return this.f4799c;
    }

    public boolean j(Object obj) {
        int size = this.f4798b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList = (ArrayList) this.f4798b.m(i3);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
