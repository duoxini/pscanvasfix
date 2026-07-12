package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class s {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f5551a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f5552b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private o f5553c;

    s() {
    }

    void a(Fragment fragment) {
        if (this.f5551a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f5551a) {
            this.f5551a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f5552b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f5552b.get(str) != null;
    }

    void d(int i3) {
        for (r rVar : this.f5552b.values()) {
            if (rVar != null) {
                rVar.t(i3);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f5552b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (r rVar : this.f5552b.values()) {
                printWriter.print(str);
                if (rVar != null) {
                    Fragment k3 = rVar.k();
                    printWriter.println(k3);
                    k3.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f5551a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = (Fragment) this.f5551a.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        r rVar = (r) this.f5552b.get(str);
        if (rVar != null) {
            return rVar.k();
        }
        return null;
    }

    Fragment g(int i3) {
        for (int size = this.f5551a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f5551a.get(size);
            if (fragment != null && fragment.mFragmentId == i3) {
                return fragment;
            }
        }
        for (r rVar : this.f5552b.values()) {
            if (rVar != null) {
                Fragment k3 = rVar.k();
                if (k3.mFragmentId == i3) {
                    return k3;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.f5551a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f5551a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (r rVar : this.f5552b.values()) {
            if (rVar != null) {
                Fragment k3 = rVar.k();
                if (str.equals(k3.mTag)) {
                    return k3;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment findFragmentByWho;
        for (r rVar : this.f5552b.values()) {
            if (rVar != null && (findFragmentByWho = rVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f5551a.indexOf(fragment);
        for (int i3 = indexOf - 1; i3 >= 0; i3--) {
            Fragment fragment2 = (Fragment) this.f5551a.get(i3);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f5551a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f5551a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List k() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f5552b.values()) {
            if (rVar != null) {
                arrayList.add(rVar);
            }
        }
        return arrayList;
    }

    List l() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f5552b.values()) {
            if (rVar != null) {
                arrayList.add(rVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    r m(String str) {
        return (r) this.f5552b.get(str);
    }

    List n() {
        ArrayList arrayList;
        if (this.f5551a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f5551a) {
            arrayList = new ArrayList(this.f5551a);
        }
        return arrayList;
    }

    o o() {
        return this.f5553c;
    }

    void p(r rVar) {
        Fragment k3 = rVar.k();
        if (c(k3.mWho)) {
            return;
        }
        this.f5552b.put(k3.mWho, rVar);
        if (k3.mRetainInstanceChangedWhileDetached) {
            if (k3.mRetainInstance) {
                this.f5553c.f(k3);
            } else {
                this.f5553c.n(k3);
            }
            k3.mRetainInstanceChangedWhileDetached = false;
        }
        if (l.E0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k3);
        }
    }

    void q(r rVar) {
        Fragment k3 = rVar.k();
        if (k3.mRetainInstance) {
            this.f5553c.n(k3);
        }
        if (((r) this.f5552b.put(k3.mWho, null)) != null && l.E0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k3);
        }
    }

    void r() {
        Iterator it = this.f5551a.iterator();
        while (it.hasNext()) {
            r rVar = (r) this.f5552b.get(((Fragment) it.next()).mWho);
            if (rVar != null) {
                rVar.m();
            }
        }
        for (r rVar2 : this.f5552b.values()) {
            if (rVar2 != null) {
                rVar2.m();
                Fragment k3 = rVar2.k();
                if (k3.mRemoving && !k3.isInBackStack()) {
                    q(rVar2);
                }
            }
        }
    }

    void s(Fragment fragment) {
        synchronized (this.f5551a) {
            this.f5551a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void t() {
        this.f5552b.clear();
    }

    void u(List list) {
        this.f5551a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment f3 = f(str);
                if (f3 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (l.E0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f3);
                }
                a(f3);
            }
        }
    }

    ArrayList v() {
        ArrayList arrayList = new ArrayList(this.f5552b.size());
        for (r rVar : this.f5552b.values()) {
            if (rVar != null) {
                Fragment k3 = rVar.k();
                q r3 = rVar.r();
                arrayList.add(r3);
                if (l.E0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k3 + ": " + r3.f5542q);
                }
            }
        }
        return arrayList;
    }

    ArrayList w() {
        synchronized (this.f5551a) {
            try {
                if (this.f5551a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f5551a.size());
                Iterator it = this.f5551a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.mWho);
                    if (l.E0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void x(o oVar) {
        this.f5553c = oVar;
    }
}
