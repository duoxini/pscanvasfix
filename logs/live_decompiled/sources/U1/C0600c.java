package u1;

import B1.l;
import B1.n;
import B1.s;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Debug;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.oplus.pscanvas.canvasmode.canvas.r0;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: u1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0600c extends ArrayAdapter {

    /* renamed from: t, reason: collision with root package name */
    private static final String f13786t = "c";

    /* renamed from: e, reason: collision with root package name */
    private boolean f13787e;

    /* renamed from: f, reason: collision with root package name */
    private int f13788f;

    /* renamed from: g, reason: collision with root package name */
    private int f13789g;

    /* renamed from: h, reason: collision with root package name */
    private int f13790h;

    /* renamed from: i, reason: collision with root package name */
    private int f13791i;

    /* renamed from: j, reason: collision with root package name */
    private int f13792j;

    /* renamed from: k, reason: collision with root package name */
    private int f13793k;

    /* renamed from: l, reason: collision with root package name */
    private int f13794l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13795m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13796n;

    /* renamed from: o, reason: collision with root package name */
    private a f13797o;

    /* renamed from: p, reason: collision with root package name */
    private C0601d f13798p;

    /* renamed from: q, reason: collision with root package name */
    private int f13799q;

    /* renamed from: r, reason: collision with root package name */
    private List f13800r;

    /* renamed from: s, reason: collision with root package name */
    r0.b f13801s;

    /* renamed from: u1.c$a */
    public interface a {
        void a(int i3, C0601d c0601d);

        void b(int i3);
    }

    public C0600c(Context context, int i3, List list, r0.b bVar) {
        super(context, i3, list);
        this.f13787e = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        this.f13788f = 0;
        this.f13789g = 0;
        this.f13790h = 0;
        this.f13791i = 0;
        this.f13792j = 0;
        this.f13793k = 0;
        this.f13794l = 0;
        this.f13795m = false;
        this.f13796n = false;
        this.f13799q = 0;
        this.f13800r = null;
        this.f13801s = bVar;
    }

    private void I(int i3, C0601d c0601d) {
        a aVar;
        if (i3 < 0 || i3 >= getCount()) {
            if (i3 != -1 || (aVar = this.f13797o) == null) {
                return;
            }
            aVar.b(this.f13794l);
            this.f13796n = true;
            return;
        }
        this.f13794l = i3;
        a aVar2 = this.f13797o;
        if (aVar2 != null) {
            aVar2.a(i3, c0601d);
            this.f13796n = false;
        }
    }

    public boolean A() {
        if (v() != 3 && i() != 3) {
            return false;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < getCount(); i5++) {
            C0601d item = getItem(i5);
            if (item.p() == 1 && !item.u()) {
                i3++;
            }
            if (item.p() == 2 && Math.abs(item.m() - 1.77f) <= 0.01d) {
                i4++;
            }
        }
        return i3 + i4 == 3;
    }

    public void B(a aVar) {
        this.f13797o = aVar;
    }

    @Override // android.widget.ArrayAdapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void remove(C0601d c0601d) {
        super.remove(c0601d);
        Log.d(f13786t, "remove " + c0601d + ",count:" + getCount());
        this.f13800r.remove(c0601d);
        this.f13798p = null;
        this.f13788f = 0;
        R();
    }

    public void D() {
        this.f13789g = 0;
        this.f13790h = 0;
    }

    public void E() {
        if (this.f13799q == 2) {
            this.f13789g = this.f13788f;
        } else {
            this.f13790h = this.f13788f;
        }
    }

    public void F() {
        int i3 = this.f13788f;
        if (i3 >= 3) {
            this.f13789g = i3;
        } else {
            this.f13789g = 0;
        }
    }

    public void G() {
        int i3 = this.f13788f;
        if (i3 >= 3) {
            this.f13790h = i3;
        } else {
            this.f13790h = 0;
        }
    }

    public void H(int i3) {
        I(i3, null);
    }

    public void J(C0601d c0601d) {
        int i3 = -1;
        for (int i4 = 0; i4 < getCount(); i4++) {
            if (c0601d == getItem(i4)) {
                i3 = i4;
            }
        }
        if (i3 == -1) {
            Log.d(f13786t, "focus data not exist");
        } else {
            I(i3, c0601d);
        }
    }

    public void K(boolean z3) {
        this.f13795m = z3;
    }

    public void L(int i3) {
        if (i3 >= 3) {
            this.f13789g = i3;
        } else {
            this.f13789g = 0;
        }
    }

    public void M(int i3) {
        this.f13788f = i3;
    }

    public void N(List list) {
        this.f13800r.clear();
        this.f13800r.addAll(list);
    }

    public void O(int i3) {
        if (i3 >= 3) {
            this.f13790h = i3;
        } else {
            this.f13790h = 0;
        }
    }

    public void P(int i3) {
        this.f13799q = i3;
    }

    public int Q(int i3) {
        this.f13791i = i3;
        return i3;
    }

    public void R() {
        T(false, false, false);
    }

    public void S(boolean z3) {
        T(z3, false, false);
    }

    public void T(boolean z3, boolean z4, boolean z5) {
        int i3 = this.f13788f;
        if (z3 && !s.r(getContext())) {
            this.f13788f = 0;
        }
        if (z4) {
            D();
        }
        f(z3);
        if (s.H() || (getCount() >= 3 && this.f13788f != 3)) {
            List q3 = (s.H() && z3) ? q() : l();
            if (q3 != null && q3.size() == 3 && this.f13798p == null) {
                this.f13798p = (C0601d) q3.get(q3.size() - 1);
            }
            if (this.f13787e) {
                Log.d(f13786t, "sortFlexibleRect called with screenOrientationChanged= " + z3 + ", updateOriginalTaskList= " + z4 + ", sortFlexibleRect: taskDataList before sort: " + q3 + ", mUpdateTaskData: " + this.f13798p + ", oldOrientationLayout is: " + i3 + ", mOrientationLayout is: " + this.f13788f + ", call stack: " + Debug.getCallers(5));
            }
            l.E1(getContext(), q3, this.f13798p, i3, this.f13788f, z5);
            setNotifyOnChange(false);
            clear();
            addAll(q3);
            if (z4) {
                N(q3);
            }
            setNotifyOnChange(true);
            Log.i(f13786t, "canvas package list order:" + r());
        }
    }

    public void U(C0601d c0601d) {
        super.add(c0601d);
    }

    public void V(C0601d c0601d) {
        super.remove(c0601d);
    }

    public void W() {
        this.f13797o = null;
    }

    public void X(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        super.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            super.add((C0601d) it.next());
        }
    }

    public void Y(C0601d c0601d, int i3) {
        Z(c0601d, i3, false);
    }

    public void Z(C0601d c0601d, int i3, boolean z3) {
        this.f13798p = c0601d;
        if (getPosition(c0601d) == -1 && i3 >= 0 && i3 < getCount()) {
            C0601d item = getItem(i3);
            a0(item, c0601d);
            super.remove(item);
            insert(c0601d, i3);
        }
        T(false, z3, false);
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(C0601d c0601d) {
        super.add(c0601d);
        Log.d(f13786t, "add " + c0601d + ",count:" + getCount());
        this.f13798p = c0601d;
        R();
    }

    public void a0(C0601d c0601d, C0601d c0601d2) {
        List list = this.f13800r;
        if (list == null) {
            Log.e(f13786t, "updateOriginalTaskDataList is null, oldData is: " + c0601d + "; newData is: " + c0601d2);
            return;
        }
        int indexOf = list.indexOf(c0601d);
        if (indexOf >= 0) {
            this.f13800r.remove(indexOf);
            this.f13800r.add(indexOf, c0601d2);
            return;
        }
        Log.e(f13786t, "updateOriginalTaskDataList wrong, can not find oldTada. oldData is: " + c0601d + "; newData is: " + c0601d2);
    }

    public void b(List list) {
        if (this.f13800r == null) {
            this.f13800r = new ArrayList();
        }
        this.f13800r.addAll(list);
    }

    public void c(C0601d c0601d) {
        if (this.f13800r == null) {
            this.f13800r = new ArrayList();
        }
        this.f13800r.add(c0601d);
    }

    public int[] d() {
        this.f13792j = 0;
        this.f13793k = 0;
        for (int i3 = 0; i3 < getCount(); i3++) {
            if (getItem(i3).I()) {
                this.f13792j++;
            } else {
                this.f13793k++;
            }
        }
        return new int[]{this.f13792j, this.f13793k};
    }

    public void e() {
        f(false);
    }

    public void f(boolean z3) {
        int c3 = n.a().b(getContext()).c(this, this.f13788f, this.f13799q, z3);
        if (c3 != this.f13788f && s.H()) {
            if (c3 == 3) {
                this.f13801s.a(l());
            } else if (this.f13788f == 3) {
                this.f13801s.b(l());
            }
        }
        this.f13788f = c3;
    }

    public void g(int i3) {
        if (i3 < 0 || i3 >= getCount()) {
            return;
        }
        this.f13794l = i3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        return view == null ? new EmbeddedViewDecor(getContext()) : view;
    }

    public int h() {
        int i3 = this.f13794l;
        if (i3 < 0 || i3 >= getCount()) {
            return -1;
        }
        return this.f13794l;
    }

    public int i() {
        return this.f13793k;
    }

    public boolean j() {
        return this.f13795m;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0601d getItem(int i3) {
        return (C0601d) super.getItem(i3);
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getCount(); i3++) {
            arrayList.add(getItem(i3));
        }
        return arrayList;
    }

    public int m() {
        return this.f13789g;
    }

    public int n() {
        return this.f13788f;
    }

    public C0601d o(int i3) {
        if (i3 < 0 || i3 >= this.f13800r.size()) {
            return null;
        }
        return (C0601d) this.f13800r.get(i3);
    }

    public int p(C0601d c0601d) {
        return this.f13800r.indexOf(c0601d);
    }

    public List q() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f13800r.iterator();
        while (it.hasNext()) {
            arrayList.add((C0601d) it.next());
        }
        return arrayList;
    }

    public String r() {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < getCount()) {
            sb.append(getItem(i3).f().getPackage() != null ? getItem(i3).f().getPackage() : getItem(i3).f().getComponent() == null ? "null" : getItem(i3).f().getComponent().getPackageName());
            sb.append(":");
            i3++;
            sb.append(i3);
            sb.append(" ");
        }
        return sb.toString();
    }

    public int s() {
        return this.f13790h;
    }

    public int t() {
        return this.f13799q;
    }

    public int u() {
        return this.f13791i;
    }

    public int v() {
        return this.f13792j;
    }

    public boolean w() {
        if (!s.w(getContext()) || !s.B()) {
            return false;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < getCount(); i5++) {
            C0601d item = getItem(i5);
            if (ActivityInfo.isFixedOrientationLandscape(item.j()) && !item.y()) {
                i3++;
            } else if (!ActivityInfo.isFixedOrientationLandscape(item.j()) && item.y()) {
                i4++;
            }
        }
        return i3 == 1 && i4 == i3;
    }

    public boolean x() {
        return this.f13796n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean y() {
        int i3 = 0;
        int i4 = s.D(l.O1(getContext()).K0());
        while (i3 < getCount()) {
            if (s.D(getItem(i3).w())) {
                i4++;
            }
            i3++;
            i4 = i4;
        }
        return i4 == getCount() + 1 || i4 == 0;
    }

    public boolean z() {
        List l3 = l();
        if (l3.size() != 2) {
            return false;
        }
        Iterator it = l3.iterator();
        while (it.hasNext()) {
            if (!((C0601d) it.next()).H()) {
                return false;
            }
        }
        return true;
    }
}
