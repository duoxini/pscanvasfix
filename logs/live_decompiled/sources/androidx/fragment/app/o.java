package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.E;
import androidx.lifecycle.F;
import androidx.lifecycle.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class o extends E {

    /* renamed from: k, reason: collision with root package name */
    private static final F.b f5522k = new a();

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5526g;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f5523d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f5524e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f5525f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f5527h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5528i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5529j = false;

    class a implements F.b {
        a() {
        }

        @Override // androidx.lifecycle.F.b
        public E a(Class cls) {
            return new o(true);
        }
    }

    o(boolean z3) {
        this.f5526g = z3;
    }

    static o j(H h3) {
        return (o) new F(h3, f5522k).a(o.class);
    }

    @Override // androidx.lifecycle.E
    protected void d() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f5527h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f5523d.equals(oVar.f5523d) && this.f5524e.equals(oVar.f5524e) && this.f5525f.equals(oVar.f5525f);
    }

    void f(Fragment fragment) {
        if (this.f5529j) {
            if (l.E0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f5523d.containsKey(fragment.mWho)) {
                return;
            }
            this.f5523d.put(fragment.mWho, fragment);
            if (l.E0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void g(Fragment fragment) {
        if (l.E0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        o oVar = (o) this.f5524e.get(fragment.mWho);
        if (oVar != null) {
            oVar.d();
            this.f5524e.remove(fragment.mWho);
        }
        H h3 = (H) this.f5525f.get(fragment.mWho);
        if (h3 != null) {
            h3.a();
            this.f5525f.remove(fragment.mWho);
        }
    }

    Fragment h(String str) {
        return (Fragment) this.f5523d.get(str);
    }

    public int hashCode() {
        return (((this.f5523d.hashCode() * 31) + this.f5524e.hashCode()) * 31) + this.f5525f.hashCode();
    }

    o i(Fragment fragment) {
        o oVar = (o) this.f5524e.get(fragment.mWho);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(this.f5526g);
        this.f5524e.put(fragment.mWho, oVar2);
        return oVar2;
    }

    Collection k() {
        return new ArrayList(this.f5523d.values());
    }

    H l(Fragment fragment) {
        H h3 = (H) this.f5525f.get(fragment.mWho);
        if (h3 != null) {
            return h3;
        }
        H h4 = new H();
        this.f5525f.put(fragment.mWho, h4);
        return h4;
    }

    boolean m() {
        return this.f5527h;
    }

    void n(Fragment fragment) {
        if (this.f5529j) {
            if (l.E0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f5523d.remove(fragment.mWho) == null || !l.E0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void o(boolean z3) {
        this.f5529j = z3;
    }

    boolean p(Fragment fragment) {
        if (this.f5523d.containsKey(fragment.mWho)) {
            return this.f5526g ? this.f5527h : !this.f5528i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f5523d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f5524e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f5525f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
