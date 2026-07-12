package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.p implements RecyclerView.A.b {

    /* renamed from: B, reason: collision with root package name */
    private BitSet f6399B;

    /* renamed from: G, reason: collision with root package name */
    private boolean f6404G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f6405H;

    /* renamed from: I, reason: collision with root package name */
    private e f6406I;

    /* renamed from: J, reason: collision with root package name */
    private int f6407J;

    /* renamed from: O, reason: collision with root package name */
    private int[] f6412O;

    /* renamed from: t, reason: collision with root package name */
    f[] f6415t;

    /* renamed from: u, reason: collision with root package name */
    k f6416u;

    /* renamed from: v, reason: collision with root package name */
    k f6417v;

    /* renamed from: w, reason: collision with root package name */
    private int f6418w;

    /* renamed from: x, reason: collision with root package name */
    private int f6419x;

    /* renamed from: y, reason: collision with root package name */
    private final h f6420y;

    /* renamed from: s, reason: collision with root package name */
    private int f6414s = -1;

    /* renamed from: z, reason: collision with root package name */
    boolean f6421z = false;

    /* renamed from: A, reason: collision with root package name */
    boolean f6398A = false;

    /* renamed from: C, reason: collision with root package name */
    int f6400C = -1;

    /* renamed from: D, reason: collision with root package name */
    int f6401D = Integer.MIN_VALUE;

    /* renamed from: E, reason: collision with root package name */
    d f6402E = new d();

    /* renamed from: F, reason: collision with root package name */
    private int f6403F = 2;

    /* renamed from: K, reason: collision with root package name */
    private final Rect f6408K = new Rect();

    /* renamed from: L, reason: collision with root package name */
    private final b f6409L = new b();

    /* renamed from: M, reason: collision with root package name */
    private boolean f6410M = false;

    /* renamed from: N, reason: collision with root package name */
    private boolean f6411N = true;

    /* renamed from: P, reason: collision with root package name */
    private final Runnable f6413P = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.V1();
        }
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        int f6423a;

        /* renamed from: b, reason: collision with root package name */
        int f6424b;

        /* renamed from: c, reason: collision with root package name */
        boolean f6425c;

        /* renamed from: d, reason: collision with root package name */
        boolean f6426d;

        /* renamed from: e, reason: collision with root package name */
        boolean f6427e;

        /* renamed from: f, reason: collision with root package name */
        int[] f6428f;

        b() {
            c();
        }

        void a() {
            this.f6424b = this.f6425c ? StaggeredGridLayoutManager.this.f6416u.i() : StaggeredGridLayoutManager.this.f6416u.n();
        }

        void b(int i3) {
            if (this.f6425c) {
                this.f6424b = StaggeredGridLayoutManager.this.f6416u.i() - i3;
            } else {
                this.f6424b = StaggeredGridLayoutManager.this.f6416u.n() + i3;
            }
        }

        void c() {
            this.f6423a = -1;
            this.f6424b = Integer.MIN_VALUE;
            this.f6425c = false;
            this.f6426d = false;
            this.f6427e = false;
            int[] iArr = this.f6428f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f6428f;
            if (iArr == null || iArr.length < length) {
                this.f6428f = new int[StaggeredGridLayoutManager.this.f6415t.length];
            }
            for (int i3 = 0; i3 < length; i3++) {
                this.f6428f[i3] = fVarArr[i3].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.q {

        /* renamed from: e, reason: collision with root package name */
        f f6430e;

        /* renamed from: f, reason: collision with root package name */
        boolean f6431f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f6431f;
        }

        public c(int i3, int i4) {
            super(i3, i4);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f6438e;

        /* renamed from: f, reason: collision with root package name */
        int f6439f;

        /* renamed from: g, reason: collision with root package name */
        int f6440g;

        /* renamed from: h, reason: collision with root package name */
        int[] f6441h;

        /* renamed from: i, reason: collision with root package name */
        int f6442i;

        /* renamed from: j, reason: collision with root package name */
        int[] f6443j;

        /* renamed from: k, reason: collision with root package name */
        List f6444k;

        /* renamed from: l, reason: collision with root package name */
        boolean f6445l;

        /* renamed from: m, reason: collision with root package name */
        boolean f6446m;

        /* renamed from: n, reason: collision with root package name */
        boolean f6447n;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e() {
        }

        void c() {
            this.f6441h = null;
            this.f6440g = 0;
            this.f6438e = -1;
            this.f6439f = -1;
        }

        void d() {
            this.f6441h = null;
            this.f6440g = 0;
            this.f6442i = 0;
            this.f6443j = null;
            this.f6444k = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f6438e);
            parcel.writeInt(this.f6439f);
            parcel.writeInt(this.f6440g);
            if (this.f6440g > 0) {
                parcel.writeIntArray(this.f6441h);
            }
            parcel.writeInt(this.f6442i);
            if (this.f6442i > 0) {
                parcel.writeIntArray(this.f6443j);
            }
            parcel.writeInt(this.f6445l ? 1 : 0);
            parcel.writeInt(this.f6446m ? 1 : 0);
            parcel.writeInt(this.f6447n ? 1 : 0);
            parcel.writeList(this.f6444k);
        }

        e(Parcel parcel) {
            this.f6438e = parcel.readInt();
            this.f6439f = parcel.readInt();
            int readInt = parcel.readInt();
            this.f6440g = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f6441h = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f6442i = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f6443j = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f6445l = parcel.readInt() == 1;
            this.f6446m = parcel.readInt() == 1;
            this.f6447n = parcel.readInt() == 1;
            this.f6444k = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f6440g = eVar.f6440g;
            this.f6438e = eVar.f6438e;
            this.f6439f = eVar.f6439f;
            this.f6441h = eVar.f6441h;
            this.f6442i = eVar.f6442i;
            this.f6443j = eVar.f6443j;
            this.f6445l = eVar.f6445l;
            this.f6446m = eVar.f6446m;
            this.f6447n = eVar.f6447n;
            this.f6444k = eVar.f6444k;
        }
    }

    class f {

        /* renamed from: a, reason: collision with root package name */
        ArrayList f6448a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        int f6449b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        int f6450c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        int f6451d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f6452e;

        f(int i3) {
            this.f6452e = i3;
        }

        void a(View view) {
            c n3 = n(view);
            n3.f6430e = this;
            this.f6448a.add(view);
            this.f6450c = Integer.MIN_VALUE;
            if (this.f6448a.size() == 1) {
                this.f6449b = Integer.MIN_VALUE;
            }
            if (n3.c() || n3.b()) {
                this.f6451d += StaggeredGridLayoutManager.this.f6416u.e(view);
            }
        }

        void b(boolean z3, int i3) {
            int l3 = z3 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (l3 == Integer.MIN_VALUE) {
                return;
            }
            if (!z3 || l3 >= StaggeredGridLayoutManager.this.f6416u.i()) {
                if (z3 || l3 <= StaggeredGridLayoutManager.this.f6416u.n()) {
                    if (i3 != Integer.MIN_VALUE) {
                        l3 += i3;
                    }
                    this.f6450c = l3;
                    this.f6449b = l3;
                }
            }
        }

        void c() {
            d.a f3;
            ArrayList arrayList = this.f6448a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c n3 = n(view);
            this.f6450c = StaggeredGridLayoutManager.this.f6416u.d(view);
            if (n3.f6431f && (f3 = StaggeredGridLayoutManager.this.f6402E.f(n3.a())) != null && f3.f6435f == 1) {
                this.f6450c += f3.c(this.f6452e);
            }
        }

        void d() {
            d.a f3;
            View view = (View) this.f6448a.get(0);
            c n3 = n(view);
            this.f6449b = StaggeredGridLayoutManager.this.f6416u.g(view);
            if (n3.f6431f && (f3 = StaggeredGridLayoutManager.this.f6402E.f(n3.a())) != null && f3.f6435f == -1) {
                this.f6449b -= f3.c(this.f6452e);
            }
        }

        void e() {
            this.f6448a.clear();
            q();
            this.f6451d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f6421z ? i(this.f6448a.size() - 1, -1, true) : i(0, this.f6448a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f6421z ? i(0, this.f6448a.size(), true) : i(this.f6448a.size() - 1, -1, true);
        }

        int h(int i3, int i4, boolean z3, boolean z4, boolean z5) {
            int n3 = StaggeredGridLayoutManager.this.f6416u.n();
            int i5 = StaggeredGridLayoutManager.this.f6416u.i();
            int i6 = i4 > i3 ? 1 : -1;
            while (i3 != i4) {
                View view = (View) this.f6448a.get(i3);
                int g3 = StaggeredGridLayoutManager.this.f6416u.g(view);
                int d3 = StaggeredGridLayoutManager.this.f6416u.d(view);
                boolean z6 = false;
                boolean z7 = !z5 ? g3 >= i5 : g3 > i5;
                if (!z5 ? d3 > n3 : d3 >= n3) {
                    z6 = true;
                }
                if (z7 && z6) {
                    if (z3 && z4) {
                        if (g3 >= n3 && d3 <= i5) {
                            return StaggeredGridLayoutManager.this.j0(view);
                        }
                    } else {
                        if (z4) {
                            return StaggeredGridLayoutManager.this.j0(view);
                        }
                        if (g3 < n3 || d3 > i5) {
                            return StaggeredGridLayoutManager.this.j0(view);
                        }
                    }
                }
                i3 += i6;
            }
            return -1;
        }

        int i(int i3, int i4, boolean z3) {
            return h(i3, i4, false, false, z3);
        }

        public int j() {
            return this.f6451d;
        }

        int k() {
            int i3 = this.f6450c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            c();
            return this.f6450c;
        }

        int l(int i3) {
            int i4 = this.f6450c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f6448a.size() == 0) {
                return i3;
            }
            c();
            return this.f6450c;
        }

        public View m(int i3, int i4) {
            View view = null;
            if (i4 != -1) {
                int size = this.f6448a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f6448a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f6421z && staggeredGridLayoutManager.j0(view2) >= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f6421z && staggeredGridLayoutManager2.j0(view2) <= i3) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f6448a.size();
                int i5 = 0;
                while (i5 < size2) {
                    View view3 = (View) this.f6448a.get(i5);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f6421z && staggeredGridLayoutManager3.j0(view3) <= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f6421z && staggeredGridLayoutManager4.j0(view3) >= i3) || !view3.hasFocusable()) {
                        break;
                    }
                    i5++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i3 = this.f6449b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            d();
            return this.f6449b;
        }

        int p(int i3) {
            int i4 = this.f6449b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f6448a.size() == 0) {
                return i3;
            }
            d();
            return this.f6449b;
        }

        void q() {
            this.f6449b = Integer.MIN_VALUE;
            this.f6450c = Integer.MIN_VALUE;
        }

        void r(int i3) {
            int i4 = this.f6449b;
            if (i4 != Integer.MIN_VALUE) {
                this.f6449b = i4 + i3;
            }
            int i5 = this.f6450c;
            if (i5 != Integer.MIN_VALUE) {
                this.f6450c = i5 + i3;
            }
        }

        void s() {
            int size = this.f6448a.size();
            View view = (View) this.f6448a.remove(size - 1);
            c n3 = n(view);
            n3.f6430e = null;
            if (n3.c() || n3.b()) {
                this.f6451d -= StaggeredGridLayoutManager.this.f6416u.e(view);
            }
            if (size == 1) {
                this.f6449b = Integer.MIN_VALUE;
            }
            this.f6450c = Integer.MIN_VALUE;
        }

        void t() {
            View view = (View) this.f6448a.remove(0);
            c n3 = n(view);
            n3.f6430e = null;
            if (this.f6448a.size() == 0) {
                this.f6450c = Integer.MIN_VALUE;
            }
            if (n3.c() || n3.b()) {
                this.f6451d -= StaggeredGridLayoutManager.this.f6416u.e(view);
            }
            this.f6449b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c n3 = n(view);
            n3.f6430e = this;
            this.f6448a.add(0, view);
            this.f6449b = Integer.MIN_VALUE;
            if (this.f6448a.size() == 1) {
                this.f6450c = Integer.MIN_VALUE;
            }
            if (n3.c() || n3.b()) {
                this.f6451d += StaggeredGridLayoutManager.this.f6416u.e(view);
            }
        }

        void v(int i3) {
            this.f6449b = i3;
            this.f6450c = i3;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        RecyclerView.p.d k02 = RecyclerView.p.k0(context, attributeSet, i3, i4);
        K2(k02.f6374a);
        M2(k02.f6375b);
        L2(k02.f6376c);
        this.f6420y = new h();
        d2();
    }

    private boolean A2(int i3) {
        if (this.f6418w == 0) {
            return (i3 == -1) != this.f6398A;
        }
        return ((i3 == -1) == this.f6398A) == w2();
    }

    private void C2(View view) {
        for (int i3 = this.f6414s - 1; i3 >= 0; i3--) {
            this.f6415t[i3].u(view);
        }
    }

    private void D2(RecyclerView.w wVar, h hVar) {
        if (!hVar.f6587a || hVar.f6595i) {
            return;
        }
        if (hVar.f6588b == 0) {
            if (hVar.f6591e == -1) {
                E2(wVar, hVar.f6593g);
                return;
            } else {
                F2(wVar, hVar.f6592f);
                return;
            }
        }
        if (hVar.f6591e != -1) {
            int q22 = q2(hVar.f6593g) - hVar.f6593g;
            F2(wVar, q22 < 0 ? hVar.f6592f : Math.min(q22, hVar.f6588b) + hVar.f6592f);
        } else {
            int i3 = hVar.f6592f;
            int p22 = i3 - p2(i3);
            E2(wVar, p22 < 0 ? hVar.f6593g : hVar.f6593g - Math.min(p22, hVar.f6588b));
        }
    }

    private void E2(RecyclerView.w wVar, int i3) {
        for (int J3 = J() - 1; J3 >= 0; J3--) {
            View I3 = I(J3);
            if (this.f6416u.g(I3) < i3 || this.f6416u.r(I3) < i3) {
                return;
            }
            c cVar = (c) I3.getLayoutParams();
            if (cVar.f6431f) {
                for (int i4 = 0; i4 < this.f6414s; i4++) {
                    if (this.f6415t[i4].f6448a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f6414s; i5++) {
                    this.f6415t[i5].s();
                }
            } else if (cVar.f6430e.f6448a.size() == 1) {
                return;
            } else {
                cVar.f6430e.s();
            }
            p1(I3, wVar);
        }
    }

    private void F2(RecyclerView.w wVar, int i3) {
        while (J() > 0) {
            View I3 = I(0);
            if (this.f6416u.d(I3) > i3 || this.f6416u.q(I3) > i3) {
                return;
            }
            c cVar = (c) I3.getLayoutParams();
            if (cVar.f6431f) {
                for (int i4 = 0; i4 < this.f6414s; i4++) {
                    if (this.f6415t[i4].f6448a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f6414s; i5++) {
                    this.f6415t[i5].t();
                }
            } else if (cVar.f6430e.f6448a.size() == 1) {
                return;
            } else {
                cVar.f6430e.t();
            }
            p1(I3, wVar);
        }
    }

    private void G2() {
        if (this.f6417v.l() == 1073741824) {
            return;
        }
        int J3 = J();
        float f3 = 0.0f;
        for (int i3 = 0; i3 < J3; i3++) {
            View I3 = I(i3);
            float e3 = this.f6417v.e(I3);
            if (e3 >= f3) {
                if (((c) I3.getLayoutParams()).e()) {
                    e3 = (e3 * 1.0f) / this.f6414s;
                }
                f3 = Math.max(f3, e3);
            }
        }
        int i4 = this.f6419x;
        int round = Math.round(f3 * this.f6414s);
        if (this.f6417v.l() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f6417v.o());
        }
        S2(round);
        if (this.f6419x == i4) {
            return;
        }
        for (int i5 = 0; i5 < J3; i5++) {
            View I4 = I(i5);
            c cVar = (c) I4.getLayoutParams();
            if (!cVar.f6431f) {
                if (w2() && this.f6418w == 1) {
                    int i6 = this.f6414s;
                    int i7 = cVar.f6430e.f6452e;
                    I4.offsetLeftAndRight(((-((i6 - 1) - i7)) * this.f6419x) - ((-((i6 - 1) - i7)) * i4));
                } else {
                    int i8 = cVar.f6430e.f6452e;
                    int i9 = this.f6419x * i8;
                    int i10 = i8 * i4;
                    if (this.f6418w == 1) {
                        I4.offsetLeftAndRight(i9 - i10);
                    } else {
                        I4.offsetTopAndBottom(i9 - i10);
                    }
                }
            }
        }
    }

    private void H2() {
        if (this.f6418w == 1 || !w2()) {
            this.f6398A = this.f6421z;
        } else {
            this.f6398A = !this.f6421z;
        }
    }

    private void J2(int i3) {
        h hVar = this.f6420y;
        hVar.f6591e = i3;
        hVar.f6590d = this.f6398A != (i3 == -1) ? -1 : 1;
    }

    private void N2(int i3, int i4) {
        for (int i5 = 0; i5 < this.f6414s; i5++) {
            if (!this.f6415t[i5].f6448a.isEmpty()) {
                T2(this.f6415t[i5], i3, i4);
            }
        }
    }

    private boolean O2(RecyclerView.B b3, b bVar) {
        bVar.f6423a = this.f6404G ? j2(b3.b()) : f2(b3.b());
        bVar.f6424b = Integer.MIN_VALUE;
        return true;
    }

    private void P1(View view) {
        for (int i3 = this.f6414s - 1; i3 >= 0; i3--) {
            this.f6415t[i3].a(view);
        }
    }

    private void Q1(b bVar) {
        e eVar = this.f6406I;
        int i3 = eVar.f6440g;
        if (i3 > 0) {
            if (i3 == this.f6414s) {
                for (int i4 = 0; i4 < this.f6414s; i4++) {
                    this.f6415t[i4].e();
                    e eVar2 = this.f6406I;
                    int i5 = eVar2.f6441h[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        i5 += eVar2.f6446m ? this.f6416u.i() : this.f6416u.n();
                    }
                    this.f6415t[i4].v(i5);
                }
            } else {
                eVar.d();
                e eVar3 = this.f6406I;
                eVar3.f6438e = eVar3.f6439f;
            }
        }
        e eVar4 = this.f6406I;
        this.f6405H = eVar4.f6447n;
        L2(eVar4.f6445l);
        H2();
        e eVar5 = this.f6406I;
        int i6 = eVar5.f6438e;
        if (i6 != -1) {
            this.f6400C = i6;
            bVar.f6425c = eVar5.f6446m;
        } else {
            bVar.f6425c = this.f6398A;
        }
        if (eVar5.f6442i > 1) {
            d dVar = this.f6402E;
            dVar.f6432a = eVar5.f6443j;
            dVar.f6433b = eVar5.f6444k;
        }
    }

    private void R2(int i3, RecyclerView.B b3) {
        int i4;
        int i5;
        int c3;
        h hVar = this.f6420y;
        boolean z3 = false;
        hVar.f6588b = 0;
        hVar.f6589c = i3;
        if (!z0() || (c3 = b3.c()) == -1) {
            i4 = 0;
            i5 = 0;
        } else {
            if (this.f6398A == (c3 < i3)) {
                i4 = this.f6416u.o();
                i5 = 0;
            } else {
                i5 = this.f6416u.o();
                i4 = 0;
            }
        }
        if (M()) {
            this.f6420y.f6592f = this.f6416u.n() - i5;
            this.f6420y.f6593g = this.f6416u.i() + i4;
        } else {
            this.f6420y.f6593g = this.f6416u.h() + i4;
            this.f6420y.f6592f = -i5;
        }
        h hVar2 = this.f6420y;
        hVar2.f6594h = false;
        hVar2.f6587a = true;
        if (this.f6416u.l() == 0 && this.f6416u.h() == 0) {
            z3 = true;
        }
        hVar2.f6595i = z3;
    }

    private void T1(View view, c cVar, h hVar) {
        if (hVar.f6591e == 1) {
            if (cVar.f6431f) {
                P1(view);
                return;
            } else {
                cVar.f6430e.a(view);
                return;
            }
        }
        if (cVar.f6431f) {
            C2(view);
        } else {
            cVar.f6430e.u(view);
        }
    }

    private void T2(f fVar, int i3, int i4) {
        int j3 = fVar.j();
        if (i3 == -1) {
            if (fVar.o() + j3 <= i4) {
                this.f6399B.set(fVar.f6452e, false);
            }
        } else if (fVar.k() - j3 >= i4) {
            this.f6399B.set(fVar.f6452e, false);
        }
    }

    private int U1(int i3) {
        if (J() == 0) {
            return this.f6398A ? 1 : -1;
        }
        return (i3 < m2()) != this.f6398A ? -1 : 1;
    }

    private int U2(int i3, int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return i3;
        }
        int mode = View.MeasureSpec.getMode(i3);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i4) - i5), mode) : i3;
    }

    private boolean W1(f fVar) {
        if (this.f6398A) {
            if (fVar.k() < this.f6416u.i()) {
                ArrayList arrayList = fVar.f6448a;
                return !fVar.n((View) arrayList.get(arrayList.size() - 1)).f6431f;
            }
        } else if (fVar.o() > this.f6416u.n()) {
            return !fVar.n((View) fVar.f6448a.get(0)).f6431f;
        }
        return false;
    }

    private int X1(RecyclerView.B b3) {
        if (J() == 0) {
            return 0;
        }
        return n.a(b3, this.f6416u, h2(!this.f6411N), g2(!this.f6411N), this, this.f6411N);
    }

    private int Y1(RecyclerView.B b3) {
        if (J() == 0) {
            return 0;
        }
        return n.b(b3, this.f6416u, h2(!this.f6411N), g2(!this.f6411N), this, this.f6411N, this.f6398A);
    }

    private int Z1(RecyclerView.B b3) {
        if (J() == 0) {
            return 0;
        }
        return n.c(b3, this.f6416u, h2(!this.f6411N), g2(!this.f6411N), this, this.f6411N);
    }

    private int a2(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 17 ? i3 != 33 ? i3 != 66 ? (i3 == 130 && this.f6418w == 1) ? 1 : Integer.MIN_VALUE : this.f6418w == 0 ? 1 : Integer.MIN_VALUE : this.f6418w == 1 ? -1 : Integer.MIN_VALUE : this.f6418w == 0 ? -1 : Integer.MIN_VALUE : (this.f6418w != 1 && w2()) ? -1 : 1 : (this.f6418w != 1 && w2()) ? 1 : -1;
    }

    private d.a b2(int i3) {
        d.a aVar = new d.a();
        aVar.f6436g = new int[this.f6414s];
        for (int i4 = 0; i4 < this.f6414s; i4++) {
            aVar.f6436g[i4] = i3 - this.f6415t[i4].l(i3);
        }
        return aVar;
    }

    private d.a c2(int i3) {
        d.a aVar = new d.a();
        aVar.f6436g = new int[this.f6414s];
        for (int i4 = 0; i4 < this.f6414s; i4++) {
            aVar.f6436g[i4] = this.f6415t[i4].p(i3) - i3;
        }
        return aVar;
    }

    private void d2() {
        this.f6416u = k.b(this, this.f6418w);
        this.f6417v = k.b(this, 1 - this.f6418w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int e2(RecyclerView.w wVar, h hVar, RecyclerView.B b3) {
        f fVar;
        int e3;
        int i3;
        int i4;
        int e4;
        boolean z3;
        ?? r9 = 0;
        this.f6399B.set(0, this.f6414s, true);
        int i5 = this.f6420y.f6595i ? hVar.f6591e == 1 ? Preference.DEFAULT_ORDER : Integer.MIN_VALUE : hVar.f6591e == 1 ? hVar.f6593g + hVar.f6588b : hVar.f6592f - hVar.f6588b;
        N2(hVar.f6591e, i5);
        int i6 = this.f6398A ? this.f6416u.i() : this.f6416u.n();
        boolean z4 = false;
        while (hVar.a(b3) && (this.f6420y.f6595i || !this.f6399B.isEmpty())) {
            View b4 = hVar.b(wVar);
            c cVar = (c) b4.getLayoutParams();
            int a3 = cVar.a();
            int g3 = this.f6402E.g(a3);
            boolean z5 = g3 == -1 ? true : r9;
            if (z5) {
                fVar = cVar.f6431f ? this.f6415t[r9] : s2(hVar);
                this.f6402E.n(a3, fVar);
            } else {
                fVar = this.f6415t[g3];
            }
            f fVar2 = fVar;
            cVar.f6430e = fVar2;
            if (hVar.f6591e == 1) {
                d(b4);
            } else {
                e(b4, r9);
            }
            y2(b4, cVar, r9);
            if (hVar.f6591e == 1) {
                int o22 = cVar.f6431f ? o2(i6) : fVar2.l(i6);
                int e5 = this.f6416u.e(b4) + o22;
                if (z5 && cVar.f6431f) {
                    d.a b22 = b2(o22);
                    b22.f6435f = -1;
                    b22.f6434e = a3;
                    this.f6402E.a(b22);
                }
                i3 = e5;
                e3 = o22;
            } else {
                int r22 = cVar.f6431f ? r2(i6) : fVar2.p(i6);
                e3 = r22 - this.f6416u.e(b4);
                if (z5 && cVar.f6431f) {
                    d.a c22 = c2(r22);
                    c22.f6435f = 1;
                    c22.f6434e = a3;
                    this.f6402E.a(c22);
                }
                i3 = r22;
            }
            if (cVar.f6431f && hVar.f6590d == -1) {
                if (z5) {
                    this.f6410M = true;
                } else {
                    if (!(hVar.f6591e == 1 ? R1() : S1())) {
                        d.a f3 = this.f6402E.f(a3);
                        if (f3 != null) {
                            f3.f6437h = true;
                        }
                        this.f6410M = true;
                    }
                }
            }
            T1(b4, cVar, hVar);
            if (w2() && this.f6418w == 1) {
                int i7 = cVar.f6431f ? this.f6417v.i() : this.f6417v.i() - (((this.f6414s - 1) - fVar2.f6452e) * this.f6419x);
                e4 = i7;
                i4 = i7 - this.f6417v.e(b4);
            } else {
                int n3 = cVar.f6431f ? this.f6417v.n() : (fVar2.f6452e * this.f6419x) + this.f6417v.n();
                i4 = n3;
                e4 = this.f6417v.e(b4) + n3;
            }
            if (this.f6418w == 1) {
                B0(b4, i4, e3, e4, i3);
            } else {
                B0(b4, e3, i4, i3, e4);
            }
            if (cVar.f6431f) {
                N2(this.f6420y.f6591e, i5);
            } else {
                T2(fVar2, this.f6420y.f6591e, i5);
            }
            D2(wVar, this.f6420y);
            if (this.f6420y.f6594h && b4.hasFocusable()) {
                if (cVar.f6431f) {
                    this.f6399B.clear();
                } else {
                    z3 = false;
                    this.f6399B.set(fVar2.f6452e, false);
                    r9 = z3;
                    z4 = true;
                }
            }
            z3 = false;
            r9 = z3;
            z4 = true;
        }
        int i8 = r9;
        if (!z4) {
            D2(wVar, this.f6420y);
        }
        int n4 = this.f6420y.f6591e == -1 ? this.f6416u.n() - r2(this.f6416u.n()) : o2(this.f6416u.i()) - this.f6416u.i();
        return n4 > 0 ? Math.min(hVar.f6588b, n4) : i8;
    }

    private int f2(int i3) {
        int J3 = J();
        for (int i4 = 0; i4 < J3; i4++) {
            int j02 = j0(I(i4));
            if (j02 >= 0 && j02 < i3) {
                return j02;
            }
        }
        return 0;
    }

    private int j2(int i3) {
        for (int J3 = J() - 1; J3 >= 0; J3--) {
            int j02 = j0(I(J3));
            if (j02 >= 0 && j02 < i3) {
                return j02;
            }
        }
        return 0;
    }

    private void k2(RecyclerView.w wVar, RecyclerView.B b3, boolean z3) {
        int i3;
        int o22 = o2(Integer.MIN_VALUE);
        if (o22 != Integer.MIN_VALUE && (i3 = this.f6416u.i() - o22) > 0) {
            int i4 = i3 - (-I2(-i3, wVar, b3));
            if (!z3 || i4 <= 0) {
                return;
            }
            this.f6416u.s(i4);
        }
    }

    private void l2(RecyclerView.w wVar, RecyclerView.B b3, boolean z3) {
        int n3;
        int r22 = r2(Preference.DEFAULT_ORDER);
        if (r22 != Integer.MAX_VALUE && (n3 = r22 - this.f6416u.n()) > 0) {
            int I22 = n3 - I2(n3, wVar, b3);
            if (!z3 || I22 <= 0) {
                return;
            }
            this.f6416u.s(-I22);
        }
    }

    private int o2(int i3) {
        int l3 = this.f6415t[0].l(i3);
        for (int i4 = 1; i4 < this.f6414s; i4++) {
            int l4 = this.f6415t[i4].l(i3);
            if (l4 > l3) {
                l3 = l4;
            }
        }
        return l3;
    }

    private int p2(int i3) {
        int p3 = this.f6415t[0].p(i3);
        for (int i4 = 1; i4 < this.f6414s; i4++) {
            int p4 = this.f6415t[i4].p(i3);
            if (p4 > p3) {
                p3 = p4;
            }
        }
        return p3;
    }

    private int q2(int i3) {
        int l3 = this.f6415t[0].l(i3);
        for (int i4 = 1; i4 < this.f6414s; i4++) {
            int l4 = this.f6415t[i4].l(i3);
            if (l4 < l3) {
                l3 = l4;
            }
        }
        return l3;
    }

    private int r2(int i3) {
        int p3 = this.f6415t[0].p(i3);
        for (int i4 = 1; i4 < this.f6414s; i4++) {
            int p4 = this.f6415t[i4].p(i3);
            if (p4 < p3) {
                p3 = p4;
            }
        }
        return p3;
    }

    private f s2(h hVar) {
        int i3;
        int i4;
        int i5;
        if (A2(hVar.f6591e)) {
            i4 = this.f6414s - 1;
            i3 = -1;
            i5 = -1;
        } else {
            i3 = this.f6414s;
            i4 = 0;
            i5 = 1;
        }
        f fVar = null;
        if (hVar.f6591e == 1) {
            int n3 = this.f6416u.n();
            int i6 = Preference.DEFAULT_ORDER;
            while (i4 != i3) {
                f fVar2 = this.f6415t[i4];
                int l3 = fVar2.l(n3);
                if (l3 < i6) {
                    fVar = fVar2;
                    i6 = l3;
                }
                i4 += i5;
            }
            return fVar;
        }
        int i7 = this.f6416u.i();
        int i8 = Integer.MIN_VALUE;
        while (i4 != i3) {
            f fVar3 = this.f6415t[i4];
            int p3 = fVar3.p(i7);
            if (p3 > i8) {
                fVar = fVar3;
                i8 = p3;
            }
            i4 += i5;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f6398A
            if (r0 == 0) goto L9
            int r0 = r6.n2()
            goto Ld
        L9:
            int r0 = r6.m2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.f6402E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f6402E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.f6402E
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f6402E
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f6402E
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f6398A
            if (r7 == 0) goto L4e
            int r7 = r6.m2()
            goto L52
        L4e:
            int r7 = r6.n2()
        L52:
            if (r3 > r7) goto L57
            r6.w1()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.t2(int, int, int):void");
    }

    private void x2(View view, int i3, int i4, boolean z3) {
        j(view, this.f6408K);
        c cVar = (c) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.f6408K;
        int U22 = U2(i3, i5 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i6 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.f6408K;
        int U23 = U2(i4, i6 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z3 ? K1(view, U22, U23, cVar) : I1(view, U22, U23, cVar)) {
            view.measure(U22, U23);
        }
    }

    private void y2(View view, c cVar, boolean z3) {
        if (cVar.f6431f) {
            if (this.f6418w == 1) {
                x2(view, this.f6407J, RecyclerView.p.K(W(), X(), i0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z3);
                return;
            } else {
                x2(view, RecyclerView.p.K(q0(), r0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.f6407J, z3);
                return;
            }
        }
        if (this.f6418w == 1) {
            x2(view, RecyclerView.p.K(this.f6419x, r0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.p.K(W(), X(), i0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z3);
        } else {
            x2(view, RecyclerView.p.K(q0(), r0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.p.K(this.f6419x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:
    
        if (V1() != false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z2(androidx.recyclerview.widget.RecyclerView.w r9, androidx.recyclerview.widget.RecyclerView.B r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.z2(androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.RecyclerView$B, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void A1(int i3) {
        e eVar = this.f6406I;
        if (eVar != null && eVar.f6438e != i3) {
            eVar.c();
        }
        this.f6400C = i3;
        this.f6401D = Integer.MIN_VALUE;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        return I2(i3, wVar, b3);
    }

    void B2(int i3, RecyclerView.B b3) {
        int m22;
        int i4;
        if (i3 > 0) {
            m22 = n2();
            i4 = 1;
        } else {
            m22 = m2();
            i4 = -1;
        }
        this.f6420y.f6587a = true;
        R2(m22, b3);
        J2(i4);
        h hVar = this.f6420y;
        hVar.f6589c = m22 + hVar.f6590d;
        hVar.f6588b = Math.abs(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q D() {
        return this.f6418w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void E0(int i3) {
        super.E0(i3);
        for (int i4 = 0; i4 < this.f6414s; i4++) {
            this.f6415t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void F0(int i3) {
        super.F0(i3);
        for (int i4 = 0; i4 < this.f6414s; i4++) {
            this.f6415t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void F1(Rect rect, int i3, int i4) {
        int n3;
        int n4;
        int f02 = f0() + g0();
        int i02 = i0() + d0();
        if (this.f6418w == 1) {
            n4 = RecyclerView.p.n(i4, rect.height() + i02, b0());
            n3 = RecyclerView.p.n(i3, (this.f6419x * this.f6414s) + f02, c0());
        } else {
            n3 = RecyclerView.p.n(i3, rect.width() + f02, c0());
            n4 = RecyclerView.p.n(i4, (this.f6419x * this.f6414s) + i02, b0());
        }
        E1(n3, n4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void G0(RecyclerView.h hVar, RecyclerView.h hVar2) {
        this.f6402E.b();
        for (int i3 = 0; i3 < this.f6414s; i3++) {
            this.f6415t[i3].e();
        }
    }

    int I2(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        if (J() == 0 || i3 == 0) {
            return 0;
        }
        B2(i3, b3);
        int e22 = e2(wVar, this.f6420y, b3);
        if (this.f6420y.f6588b >= e22) {
            i3 = i3 < 0 ? -e22 : e22;
        }
        this.f6416u.s(-i3);
        this.f6404G = this.f6398A;
        h hVar = this.f6420y;
        hVar.f6588b = 0;
        D2(wVar, hVar);
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void K0(RecyclerView recyclerView, RecyclerView.w wVar) {
        super.K0(recyclerView, wVar);
        r1(this.f6413P);
        for (int i3 = 0; i3 < this.f6414s; i3++) {
            this.f6415t[i3].e();
        }
        recyclerView.requestLayout();
    }

    public void K2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i3 == this.f6418w) {
            return;
        }
        this.f6418w = i3;
        k kVar = this.f6416u;
        this.f6416u = this.f6417v;
        this.f6417v = kVar;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View L0(View view, int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        View B3;
        View m3;
        if (J() == 0 || (B3 = B(view)) == null) {
            return null;
        }
        H2();
        int a22 = a2(i3);
        if (a22 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) B3.getLayoutParams();
        boolean z3 = cVar.f6431f;
        f fVar = cVar.f6430e;
        int n22 = a22 == 1 ? n2() : m2();
        R2(n22, b3);
        J2(a22);
        h hVar = this.f6420y;
        hVar.f6589c = hVar.f6590d + n22;
        hVar.f6588b = (int) (this.f6416u.o() * 0.33333334f);
        h hVar2 = this.f6420y;
        hVar2.f6594h = true;
        hVar2.f6587a = false;
        e2(wVar, hVar2, b3);
        this.f6404G = this.f6398A;
        if (!z3 && (m3 = fVar.m(n22, a22)) != null && m3 != B3) {
            return m3;
        }
        if (A2(a22)) {
            for (int i4 = this.f6414s - 1; i4 >= 0; i4--) {
                View m4 = this.f6415t[i4].m(n22, a22);
                if (m4 != null && m4 != B3) {
                    return m4;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f6414s; i5++) {
                View m5 = this.f6415t[i5].m(n22, a22);
                if (m5 != null && m5 != B3) {
                    return m5;
                }
            }
        }
        boolean z4 = (this.f6421z ^ true) == (a22 == -1);
        if (!z3) {
            View C3 = C(z4 ? fVar.f() : fVar.g());
            if (C3 != null && C3 != B3) {
                return C3;
            }
        }
        if (A2(a22)) {
            for (int i6 = this.f6414s - 1; i6 >= 0; i6--) {
                if (i6 != fVar.f6452e) {
                    View C4 = C(z4 ? this.f6415t[i6].f() : this.f6415t[i6].g());
                    if (C4 != null && C4 != B3) {
                        return C4;
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f6414s; i7++) {
                View C5 = C(z4 ? this.f6415t[i7].f() : this.f6415t[i7].g());
                if (C5 != null && C5 != B3) {
                    return C5;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L1(RecyclerView recyclerView, RecyclerView.B b3, int i3) {
        i iVar = new i(recyclerView.getContext());
        iVar.p(i3);
        M1(iVar);
    }

    public void L2(boolean z3) {
        g(null);
        e eVar = this.f6406I;
        if (eVar != null && eVar.f6445l != z3) {
            eVar.f6445l = z3;
        }
        this.f6421z = z3;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void M0(AccessibilityEvent accessibilityEvent) {
        super.M0(accessibilityEvent);
        if (J() > 0) {
            View h22 = h2(false);
            View g22 = g2(false);
            if (h22 == null || g22 == null) {
                return;
            }
            int j02 = j0(h22);
            int j03 = j0(g22);
            if (j02 < j03) {
                accessibilityEvent.setFromIndex(j02);
                accessibilityEvent.setToIndex(j03);
            } else {
                accessibilityEvent.setFromIndex(j03);
                accessibilityEvent.setToIndex(j02);
            }
        }
    }

    public void M2(int i3) {
        g(null);
        if (i3 != this.f6414s) {
            v2();
            this.f6414s = i3;
            this.f6399B = new BitSet(this.f6414s);
            this.f6415t = new f[this.f6414s];
            for (int i4 = 0; i4 < this.f6414s; i4++) {
                this.f6415t[i4] = new f(i4);
            }
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean O1() {
        return this.f6406I == null;
    }

    boolean P2(RecyclerView.B b3, b bVar) {
        int i3;
        if (!b3.e() && (i3 = this.f6400C) != -1) {
            if (i3 >= 0 && i3 < b3.b()) {
                e eVar = this.f6406I;
                if (eVar == null || eVar.f6438e == -1 || eVar.f6440g < 1) {
                    View C3 = C(this.f6400C);
                    if (C3 != null) {
                        bVar.f6423a = this.f6398A ? n2() : m2();
                        if (this.f6401D != Integer.MIN_VALUE) {
                            if (bVar.f6425c) {
                                bVar.f6424b = (this.f6416u.i() - this.f6401D) - this.f6416u.d(C3);
                            } else {
                                bVar.f6424b = (this.f6416u.n() + this.f6401D) - this.f6416u.g(C3);
                            }
                            return true;
                        }
                        if (this.f6416u.e(C3) > this.f6416u.o()) {
                            bVar.f6424b = bVar.f6425c ? this.f6416u.i() : this.f6416u.n();
                            return true;
                        }
                        int g3 = this.f6416u.g(C3) - this.f6416u.n();
                        if (g3 < 0) {
                            bVar.f6424b = -g3;
                            return true;
                        }
                        int i4 = this.f6416u.i() - this.f6416u.d(C3);
                        if (i4 < 0) {
                            bVar.f6424b = i4;
                            return true;
                        }
                        bVar.f6424b = Integer.MIN_VALUE;
                    } else {
                        int i5 = this.f6400C;
                        bVar.f6423a = i5;
                        int i6 = this.f6401D;
                        if (i6 == Integer.MIN_VALUE) {
                            bVar.f6425c = U1(i5) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i6);
                        }
                        bVar.f6426d = true;
                    }
                } else {
                    bVar.f6424b = Integer.MIN_VALUE;
                    bVar.f6423a = this.f6400C;
                }
                return true;
            }
            this.f6400C = -1;
            this.f6401D = Integer.MIN_VALUE;
        }
        return false;
    }

    void Q2(RecyclerView.B b3, b bVar) {
        if (P2(b3, bVar) || O2(b3, bVar)) {
            return;
        }
        bVar.a();
        bVar.f6423a = 0;
    }

    boolean R1() {
        int l3 = this.f6415t[0].l(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f6414s; i3++) {
            if (this.f6415t[i3].l(Integer.MIN_VALUE) != l3) {
                return false;
            }
        }
        return true;
    }

    boolean S1() {
        int p3 = this.f6415t[0].p(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f6414s; i3++) {
            if (this.f6415t[i3].p(Integer.MIN_VALUE) != p3) {
                return false;
            }
        }
        return true;
    }

    void S2(int i3) {
        this.f6419x = i3 / this.f6414s;
        this.f6407J = View.MeasureSpec.makeMeasureSpec(i3, this.f6417v.l());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void T0(RecyclerView recyclerView, int i3, int i4) {
        t2(i3, i4, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void U0(RecyclerView recyclerView) {
        this.f6402E.b();
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void V0(RecyclerView recyclerView, int i3, int i4, int i5) {
        t2(i3, i4, 8);
    }

    boolean V1() {
        int m22;
        int n22;
        if (J() == 0 || this.f6403F == 0 || !t0()) {
            return false;
        }
        if (this.f6398A) {
            m22 = n2();
            n22 = m2();
        } else {
            m22 = m2();
            n22 = n2();
        }
        if (m22 == 0 && u2() != null) {
            this.f6402E.b();
            x1();
            w1();
            return true;
        }
        if (!this.f6410M) {
            return false;
        }
        int i3 = this.f6398A ? -1 : 1;
        int i4 = n22 + 1;
        d.a e3 = this.f6402E.e(m22, i4, i3, true);
        if (e3 == null) {
            this.f6410M = false;
            this.f6402E.d(i4);
            return false;
        }
        d.a e4 = this.f6402E.e(m22, e3.f6434e, i3 * (-1), true);
        if (e4 == null) {
            this.f6402E.d(e3.f6434e);
        } else {
            this.f6402E.d(e4.f6434e + 1);
        }
        x1();
        w1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void W0(RecyclerView recyclerView, int i3, int i4) {
        t2(i3, i4, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void Y0(RecyclerView recyclerView, int i3, int i4, Object obj) {
        t2(i3, i4, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void Z0(RecyclerView.w wVar, RecyclerView.B b3) {
        z2(wVar, b3, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A.b
    public PointF a(int i3) {
        int U12 = U1(i3);
        PointF pointF = new PointF();
        if (U12 == 0) {
            return null;
        }
        if (this.f6418w == 0) {
            pointF.x = U12;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = U12;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.B b3) {
        super.a1(b3);
        this.f6400C = -1;
        this.f6401D = Integer.MIN_VALUE;
        this.f6406I = null;
        this.f6409L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void e1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            this.f6406I = eVar;
            if (this.f6400C != -1) {
                eVar.c();
                this.f6406I.d();
            }
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public Parcelable f1() {
        int p3;
        int n3;
        int[] iArr;
        if (this.f6406I != null) {
            return new e(this.f6406I);
        }
        e eVar = new e();
        eVar.f6445l = this.f6421z;
        eVar.f6446m = this.f6404G;
        eVar.f6447n = this.f6405H;
        d dVar = this.f6402E;
        if (dVar == null || (iArr = dVar.f6432a) == null) {
            eVar.f6442i = 0;
        } else {
            eVar.f6443j = iArr;
            eVar.f6442i = iArr.length;
            eVar.f6444k = dVar.f6433b;
        }
        if (J() > 0) {
            eVar.f6438e = this.f6404G ? n2() : m2();
            eVar.f6439f = i2();
            int i3 = this.f6414s;
            eVar.f6440g = i3;
            eVar.f6441h = new int[i3];
            for (int i4 = 0; i4 < this.f6414s; i4++) {
                if (this.f6404G) {
                    p3 = this.f6415t[i4].l(Integer.MIN_VALUE);
                    if (p3 != Integer.MIN_VALUE) {
                        n3 = this.f6416u.i();
                        p3 -= n3;
                        eVar.f6441h[i4] = p3;
                    } else {
                        eVar.f6441h[i4] = p3;
                    }
                } else {
                    p3 = this.f6415t[i4].p(Integer.MIN_VALUE);
                    if (p3 != Integer.MIN_VALUE) {
                        n3 = this.f6416u.n();
                        p3 -= n3;
                        eVar.f6441h[i4] = p3;
                    } else {
                        eVar.f6441h[i4] = p3;
                    }
                }
            }
        } else {
            eVar.f6438e = -1;
            eVar.f6439f = -1;
            eVar.f6440g = 0;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void g(String str) {
        if (this.f6406I == null) {
            super.g(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void g1(int i3) {
        if (i3 == 0) {
            V1();
        }
    }

    View g2(boolean z3) {
        int n3 = this.f6416u.n();
        int i3 = this.f6416u.i();
        View view = null;
        for (int J3 = J() - 1; J3 >= 0; J3--) {
            View I3 = I(J3);
            int g3 = this.f6416u.g(I3);
            int d3 = this.f6416u.d(I3);
            if (d3 > n3 && g3 < i3) {
                if (d3 <= i3 || !z3) {
                    return I3;
                }
                if (view == null) {
                    view = I3;
                }
            }
        }
        return view;
    }

    View h2(boolean z3) {
        int n3 = this.f6416u.n();
        int i3 = this.f6416u.i();
        int J3 = J();
        View view = null;
        for (int i4 = 0; i4 < J3; i4++) {
            View I3 = I(i4);
            int g3 = this.f6416u.g(I3);
            if (this.f6416u.d(I3) > n3 && g3 < i3) {
                if (g3 >= n3 || !z3) {
                    return I3;
                }
                if (view == null) {
                    view = I3;
                }
            }
        }
        return view;
    }

    int i2() {
        View g22 = this.f6398A ? g2(true) : h2(true);
        if (g22 == null) {
            return -1;
        }
        return j0(g22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean k() {
        return this.f6418w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean l() {
        return this.f6418w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean m(RecyclerView.q qVar) {
        return qVar instanceof c;
    }

    int m2() {
        if (J() == 0) {
            return 0;
        }
        return j0(I(0));
    }

    int n2() {
        int J3 = J();
        if (J3 == 0) {
            return 0;
        }
        return j0(I(J3 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void o(int i3, int i4, RecyclerView.B b3, RecyclerView.p.c cVar) {
        int l3;
        int i5;
        if (this.f6418w != 0) {
            i3 = i4;
        }
        if (J() == 0 || i3 == 0) {
            return;
        }
        B2(i3, b3);
        int[] iArr = this.f6412O;
        if (iArr == null || iArr.length < this.f6414s) {
            this.f6412O = new int[this.f6414s];
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f6414s; i7++) {
            h hVar = this.f6420y;
            if (hVar.f6590d == -1) {
                l3 = hVar.f6592f;
                i5 = this.f6415t[i7].p(l3);
            } else {
                l3 = this.f6415t[i7].l(hVar.f6593g);
                i5 = this.f6420y.f6593g;
            }
            int i8 = l3 - i5;
            if (i8 >= 0) {
                this.f6412O[i6] = i8;
                i6++;
            }
        }
        Arrays.sort(this.f6412O, 0, i6);
        for (int i9 = 0; i9 < i6 && this.f6420y.a(b3); i9++) {
            cVar.a(this.f6420y.f6589c, this.f6412O[i9]);
            h hVar2 = this.f6420y;
            hVar2.f6589c += hVar2.f6590d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int q(RecyclerView.B b3) {
        return X1(b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.B b3) {
        return Y1(b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.B b3) {
        return Z1(b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.B b3) {
        return X1(b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.B b3) {
        return Y1(b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean u0() {
        return this.f6403F != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View u2() {
        /*
            r12 = this;
            int r0 = r12.J()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f6414s
            r2.<init>(r3)
            int r3 = r12.f6414s
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f6418w
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.w2()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f6398A
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.I(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f6430e
            int r9 = r9.f6452e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f6430e
            boolean r9 = r12.W1(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f6430e
            int r9 = r9.f6452e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f6431f
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.I(r9)
            boolean r10 = r12.f6398A
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.k r10 = r12.f6416u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.k r11 = r12.f6416u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.k r10 = r12.f6416u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.k r11 = r12.f6416u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f6430e
            int r8 = r8.f6452e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f6430e
            int r9 = r9.f6452e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.u2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.B b3) {
        return Z1(b3);
    }

    public void v2() {
        this.f6402E.b();
        w1();
    }

    boolean w2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        return I2(i3, wVar, b3);
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f6432a;

        /* renamed from: b, reason: collision with root package name */
        List f6433b;

        d() {
        }

        private int i(int i3) {
            if (this.f6433b == null) {
                return -1;
            }
            a f3 = f(i3);
            if (f3 != null) {
                this.f6433b.remove(f3);
            }
            int size = this.f6433b.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = -1;
                    break;
                }
                if (((a) this.f6433b.get(i4)).f6434e >= i3) {
                    break;
                }
                i4++;
            }
            if (i4 == -1) {
                return -1;
            }
            a aVar = (a) this.f6433b.get(i4);
            this.f6433b.remove(i4);
            return aVar.f6434e;
        }

        private void l(int i3, int i4) {
            List list = this.f6433b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f6433b.get(size);
                int i5 = aVar.f6434e;
                if (i5 >= i3) {
                    aVar.f6434e = i5 + i4;
                }
            }
        }

        private void m(int i3, int i4) {
            List list = this.f6433b;
            if (list == null) {
                return;
            }
            int i5 = i3 + i4;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f6433b.get(size);
                int i6 = aVar.f6434e;
                if (i6 >= i3) {
                    if (i6 < i5) {
                        this.f6433b.remove(size);
                    } else {
                        aVar.f6434e = i6 - i4;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f6433b == null) {
                this.f6433b = new ArrayList();
            }
            int size = this.f6433b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar2 = (a) this.f6433b.get(i3);
                if (aVar2.f6434e == aVar.f6434e) {
                    this.f6433b.remove(i3);
                }
                if (aVar2.f6434e >= aVar.f6434e) {
                    this.f6433b.add(i3, aVar);
                    return;
                }
            }
            this.f6433b.add(aVar);
        }

        void b() {
            int[] iArr = this.f6432a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6433b = null;
        }

        void c(int i3) {
            int[] iArr = this.f6432a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i3, 10) + 1];
                this.f6432a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[o(i3)];
                this.f6432a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f6432a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i3) {
            List list = this.f6433b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f6433b.get(size)).f6434e >= i3) {
                        this.f6433b.remove(size);
                    }
                }
            }
            return h(i3);
        }

        public a e(int i3, int i4, int i5, boolean z3) {
            List list = this.f6433b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = (a) this.f6433b.get(i6);
                int i7 = aVar.f6434e;
                if (i7 >= i4) {
                    return null;
                }
                if (i7 >= i3 && (i5 == 0 || aVar.f6435f == i5 || (z3 && aVar.f6437h))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i3) {
            List list = this.f6433b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f6433b.get(size);
                if (aVar.f6434e == i3) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i3) {
            int[] iArr = this.f6432a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            return iArr[i3];
        }

        int h(int i3) {
            int[] iArr = this.f6432a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            int i4 = i(i3);
            if (i4 == -1) {
                int[] iArr2 = this.f6432a;
                Arrays.fill(iArr2, i3, iArr2.length, -1);
                return this.f6432a.length;
            }
            int min = Math.min(i4 + 1, this.f6432a.length);
            Arrays.fill(this.f6432a, i3, min, -1);
            return min;
        }

        void j(int i3, int i4) {
            int[] iArr = this.f6432a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f6432a;
            System.arraycopy(iArr2, i3, iArr2, i5, (iArr2.length - i3) - i4);
            Arrays.fill(this.f6432a, i3, i5, -1);
            l(i3, i4);
        }

        void k(int i3, int i4) {
            int[] iArr = this.f6432a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f6432a;
            System.arraycopy(iArr2, i5, iArr2, i3, (iArr2.length - i3) - i4);
            int[] iArr3 = this.f6432a;
            Arrays.fill(iArr3, iArr3.length - i4, iArr3.length, -1);
            m(i3, i4);
        }

        void n(int i3, f fVar) {
            c(i3);
            this.f6432a[i3] = fVar.f6452e;
        }

        int o(int i3) {
            int length = this.f6432a.length;
            while (length <= i3) {
                length *= 2;
            }
            return length;
        }

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0092a();

            /* renamed from: e, reason: collision with root package name */
            int f6434e;

            /* renamed from: f, reason: collision with root package name */
            int f6435f;

            /* renamed from: g, reason: collision with root package name */
            int[] f6436g;

            /* renamed from: h, reason: collision with root package name */
            boolean f6437h;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            class C0092a implements Parcelable.Creator {
                C0092a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i3) {
                    return new a[i3];
                }
            }

            a(Parcel parcel) {
                this.f6434e = parcel.readInt();
                this.f6435f = parcel.readInt();
                this.f6437h = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f6436g = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int c(int i3) {
                int[] iArr = this.f6436g;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i3];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f6434e + ", mGapDir=" + this.f6435f + ", mHasUnwantedGapAfter=" + this.f6437h + ", mGapPerSpan=" + Arrays.toString(this.f6436g) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.f6434e);
                parcel.writeInt(this.f6435f);
                parcel.writeInt(this.f6437h ? 1 : 0);
                int[] iArr = this.f6436g;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f6436g);
                }
            }

            a() {
            }
        }
    }
}
