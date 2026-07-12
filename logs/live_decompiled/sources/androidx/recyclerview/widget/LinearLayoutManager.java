package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.backup.sdk.common.utils.ModuleType;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.p implements RecyclerView.A.b {

    /* renamed from: A, reason: collision with root package name */
    int f6253A;

    /* renamed from: B, reason: collision with root package name */
    int f6254B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f6255C;

    /* renamed from: D, reason: collision with root package name */
    d f6256D;

    /* renamed from: E, reason: collision with root package name */
    final a f6257E;

    /* renamed from: F, reason: collision with root package name */
    private final b f6258F;

    /* renamed from: G, reason: collision with root package name */
    private int f6259G;

    /* renamed from: H, reason: collision with root package name */
    private int[] f6260H;

    /* renamed from: s, reason: collision with root package name */
    int f6261s;

    /* renamed from: t, reason: collision with root package name */
    private c f6262t;

    /* renamed from: u, reason: collision with root package name */
    k f6263u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6264v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f6265w;

    /* renamed from: x, reason: collision with root package name */
    boolean f6266x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f6267y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f6268z;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        k f6269a;

        /* renamed from: b, reason: collision with root package name */
        int f6270b;

        /* renamed from: c, reason: collision with root package name */
        int f6271c;

        /* renamed from: d, reason: collision with root package name */
        boolean f6272d;

        /* renamed from: e, reason: collision with root package name */
        boolean f6273e;

        a() {
            e();
        }

        void a() {
            this.f6271c = this.f6272d ? this.f6269a.i() : this.f6269a.n();
        }

        public void b(View view, int i3) {
            if (this.f6272d) {
                this.f6271c = this.f6269a.d(view) + this.f6269a.p();
            } else {
                this.f6271c = this.f6269a.g(view);
            }
            this.f6270b = i3;
        }

        public void c(View view, int i3) {
            int p3 = this.f6269a.p();
            if (p3 >= 0) {
                b(view, i3);
                return;
            }
            this.f6270b = i3;
            if (this.f6272d) {
                int i4 = (this.f6269a.i() - p3) - this.f6269a.d(view);
                this.f6271c = this.f6269a.i() - i4;
                if (i4 > 0) {
                    int e3 = this.f6271c - this.f6269a.e(view);
                    int n3 = this.f6269a.n();
                    int min = e3 - (n3 + Math.min(this.f6269a.g(view) - n3, 0));
                    if (min < 0) {
                        this.f6271c += Math.min(i4, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g3 = this.f6269a.g(view);
            int n4 = g3 - this.f6269a.n();
            this.f6271c = g3;
            if (n4 > 0) {
                int i5 = (this.f6269a.i() - Math.min(0, (this.f6269a.i() - p3) - this.f6269a.d(view))) - (g3 + this.f6269a.e(view));
                if (i5 < 0) {
                    this.f6271c -= Math.min(n4, -i5);
                }
            }
        }

        boolean d(View view, RecyclerView.B b3) {
            RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
            return !qVar.c() && qVar.a() >= 0 && qVar.a() < b3.b();
        }

        void e() {
            this.f6270b = -1;
            this.f6271c = Integer.MIN_VALUE;
            this.f6272d = false;
            this.f6273e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f6270b + ", mCoordinate=" + this.f6271c + ", mLayoutFromEnd=" + this.f6272d + ", mValid=" + this.f6273e + '}';
        }
    }

    protected static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f6274a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f6275b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6276c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6277d;

        protected b() {
        }

        void a() {
            this.f6274a = 0;
            this.f6275b = false;
            this.f6276c = false;
            this.f6277d = false;
        }
    }

    static class c {

        /* renamed from: b, reason: collision with root package name */
        int f6279b;

        /* renamed from: c, reason: collision with root package name */
        int f6280c;

        /* renamed from: d, reason: collision with root package name */
        int f6281d;

        /* renamed from: e, reason: collision with root package name */
        int f6282e;

        /* renamed from: f, reason: collision with root package name */
        int f6283f;

        /* renamed from: g, reason: collision with root package name */
        int f6284g;

        /* renamed from: k, reason: collision with root package name */
        int f6288k;

        /* renamed from: m, reason: collision with root package name */
        boolean f6290m;

        /* renamed from: a, reason: collision with root package name */
        boolean f6278a = true;

        /* renamed from: h, reason: collision with root package name */
        int f6285h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f6286i = 0;

        /* renamed from: j, reason: collision with root package name */
        boolean f6287j = false;

        /* renamed from: l, reason: collision with root package name */
        List f6289l = null;

        c() {
        }

        private View e() {
            int size = this.f6289l.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = ((RecyclerView.E) this.f6289l.get(i3)).itemView;
                RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
                if (!qVar.c() && this.f6281d == qVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f3 = f(view);
            if (f3 == null) {
                this.f6281d = -1;
            } else {
                this.f6281d = ((RecyclerView.q) f3.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.B b3) {
            int i3 = this.f6281d;
            return i3 >= 0 && i3 < b3.b();
        }

        View d(RecyclerView.w wVar) {
            if (this.f6289l != null) {
                return e();
            }
            View o3 = wVar.o(this.f6281d);
            this.f6281d += this.f6282e;
            return o3;
        }

        public View f(View view) {
            int a3;
            int size = this.f6289l.size();
            View view2 = null;
            int i3 = Preference.DEFAULT_ORDER;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = ((RecyclerView.E) this.f6289l.get(i4)).itemView;
                RecyclerView.q qVar = (RecyclerView.q) view3.getLayoutParams();
                if (view3 != view && !qVar.c() && (a3 = (qVar.a() - this.f6281d) * this.f6282e) >= 0 && a3 < i3) {
                    view2 = view3;
                    if (a3 == 0) {
                        break;
                    }
                    i3 = a3;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f6291e;

        /* renamed from: f, reason: collision with root package name */
        int f6292f;

        /* renamed from: g, reason: collision with root package name */
        boolean f6293g;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        public d() {
        }

        boolean c() {
            return this.f6291e >= 0;
        }

        void d() {
            this.f6291e = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f6291e);
            parcel.writeInt(this.f6292f);
            parcel.writeInt(this.f6293g ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f6291e = parcel.readInt();
            this.f6292f = parcel.readInt();
            this.f6293g = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f6291e = dVar.f6291e;
            this.f6292f = dVar.f6292f;
            this.f6293g = dVar.f6293g;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void B2() {
        if (this.f6261s == 1 || !r2()) {
            this.f6266x = this.f6265w;
        } else {
            this.f6266x = !this.f6265w;
        }
    }

    private boolean H2(RecyclerView.w wVar, RecyclerView.B b3, a aVar) {
        View k22;
        boolean z3 = false;
        if (J() == 0) {
            return false;
        }
        View V3 = V();
        if (V3 != null && aVar.d(V3, b3)) {
            aVar.c(V3, j0(V3));
            return true;
        }
        boolean z4 = this.f6264v;
        boolean z5 = this.f6267y;
        if (z4 != z5 || (k22 = k2(wVar, b3, aVar.f6272d, z5)) == null) {
            return false;
        }
        aVar.b(k22, j0(k22));
        if (!b3.e() && O1()) {
            int g3 = this.f6263u.g(k22);
            int d3 = this.f6263u.d(k22);
            int n3 = this.f6263u.n();
            int i3 = this.f6263u.i();
            boolean z6 = d3 <= n3 && g3 < n3;
            if (g3 >= i3 && d3 > i3) {
                z3 = true;
            }
            if (z6 || z3) {
                if (aVar.f6272d) {
                    n3 = i3;
                }
                aVar.f6271c = n3;
            }
        }
        return true;
    }

    private boolean I2(RecyclerView.B b3, a aVar) {
        int i3;
        if (!b3.e() && (i3 = this.f6253A) != -1) {
            if (i3 >= 0 && i3 < b3.b()) {
                aVar.f6270b = this.f6253A;
                d dVar = this.f6256D;
                if (dVar != null && dVar.c()) {
                    boolean z3 = this.f6256D.f6293g;
                    aVar.f6272d = z3;
                    if (z3) {
                        aVar.f6271c = this.f6263u.i() - this.f6256D.f6292f;
                    } else {
                        aVar.f6271c = this.f6263u.n() + this.f6256D.f6292f;
                    }
                    return true;
                }
                if (this.f6254B != Integer.MIN_VALUE) {
                    boolean z4 = this.f6266x;
                    aVar.f6272d = z4;
                    if (z4) {
                        aVar.f6271c = this.f6263u.i() - this.f6254B;
                    } else {
                        aVar.f6271c = this.f6263u.n() + this.f6254B;
                    }
                    return true;
                }
                View C3 = C(this.f6253A);
                if (C3 == null) {
                    if (J() > 0) {
                        aVar.f6272d = (this.f6253A < j0(I(0))) == this.f6266x;
                    }
                    aVar.a();
                } else {
                    if (this.f6263u.e(C3) > this.f6263u.o()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f6263u.g(C3) - this.f6263u.n() < 0) {
                        aVar.f6271c = this.f6263u.n();
                        aVar.f6272d = false;
                        return true;
                    }
                    if (this.f6263u.i() - this.f6263u.d(C3) < 0) {
                        aVar.f6271c = this.f6263u.i();
                        aVar.f6272d = true;
                        return true;
                    }
                    aVar.f6271c = aVar.f6272d ? this.f6263u.d(C3) + this.f6263u.p() : this.f6263u.g(C3);
                }
                return true;
            }
            this.f6253A = -1;
            this.f6254B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void J2(RecyclerView.w wVar, RecyclerView.B b3, a aVar) {
        if (I2(b3, aVar) || H2(wVar, b3, aVar)) {
            return;
        }
        aVar.a();
        aVar.f6270b = this.f6267y ? b3.b() - 1 : 0;
    }

    private void K2(int i3, int i4, boolean z3, RecyclerView.B b3) {
        int n3;
        this.f6262t.f6290m = A2();
        this.f6262t.f6283f = i3;
        int[] iArr = this.f6260H;
        iArr[0] = 0;
        iArr[1] = 0;
        P1(b3, iArr);
        int max = Math.max(0, this.f6260H[0]);
        int max2 = Math.max(0, this.f6260H[1]);
        boolean z4 = i3 == 1;
        c cVar = this.f6262t;
        int i5 = z4 ? max2 : max;
        cVar.f6285h = i5;
        if (!z4) {
            max = max2;
        }
        cVar.f6286i = max;
        if (z4) {
            cVar.f6285h = i5 + this.f6263u.j();
            View n22 = n2();
            c cVar2 = this.f6262t;
            cVar2.f6282e = this.f6266x ? -1 : 1;
            int j02 = j0(n22);
            c cVar3 = this.f6262t;
            cVar2.f6281d = j02 + cVar3.f6282e;
            cVar3.f6279b = this.f6263u.d(n22);
            n3 = this.f6263u.d(n22) - this.f6263u.i();
        } else {
            View o22 = o2();
            this.f6262t.f6285h += this.f6263u.n();
            c cVar4 = this.f6262t;
            cVar4.f6282e = this.f6266x ? 1 : -1;
            int j03 = j0(o22);
            c cVar5 = this.f6262t;
            cVar4.f6281d = j03 + cVar5.f6282e;
            cVar5.f6279b = this.f6263u.g(o22);
            n3 = (-this.f6263u.g(o22)) + this.f6263u.n();
        }
        c cVar6 = this.f6262t;
        cVar6.f6280c = i4;
        if (z3) {
            cVar6.f6280c = i4 - n3;
        }
        cVar6.f6284g = n3;
    }

    private void L2(int i3, int i4) {
        this.f6262t.f6280c = this.f6263u.i() - i4;
        c cVar = this.f6262t;
        cVar.f6282e = this.f6266x ? -1 : 1;
        cVar.f6281d = i3;
        cVar.f6283f = 1;
        cVar.f6279b = i4;
        cVar.f6284g = Integer.MIN_VALUE;
    }

    private void M2(a aVar) {
        L2(aVar.f6270b, aVar.f6271c);
    }

    private void N2(int i3, int i4) {
        this.f6262t.f6280c = i4 - this.f6263u.n();
        c cVar = this.f6262t;
        cVar.f6281d = i3;
        cVar.f6282e = this.f6266x ? 1 : -1;
        cVar.f6283f = -1;
        cVar.f6279b = i4;
        cVar.f6284g = Integer.MIN_VALUE;
    }

    private void O2(a aVar) {
        N2(aVar.f6270b, aVar.f6271c);
    }

    private int R1(RecyclerView.B b3) {
        if (J() == 0) {
            return 0;
        }
        W1();
        return n.a(b3, this.f6263u, b2(!this.f6268z, true), a2(!this.f6268z, true), this, this.f6268z);
    }

    private int S1(RecyclerView.B b3) {
        if (J() == 0) {
            return 0;
        }
        W1();
        return n.b(b3, this.f6263u, b2(!this.f6268z, true), a2(!this.f6268z, true), this, this.f6268z, this.f6266x);
    }

    private int T1(RecyclerView.B b3) {
        if (J() == 0) {
            return 0;
        }
        W1();
        return n.c(b3, this.f6263u, b2(!this.f6268z, true), a2(!this.f6268z, true), this, this.f6268z);
    }

    private View Z1() {
        return g2(0, J());
    }

    private View e2() {
        return g2(J() - 1, -1);
    }

    private View i2() {
        return this.f6266x ? Z1() : e2();
    }

    private View j2() {
        return this.f6266x ? e2() : Z1();
    }

    private int l2(int i3, RecyclerView.w wVar, RecyclerView.B b3, boolean z3) {
        int i4;
        int i5 = this.f6263u.i() - i3;
        if (i5 <= 0) {
            return 0;
        }
        int i6 = -C2(-i5, wVar, b3);
        int i7 = i3 + i6;
        if (!z3 || (i4 = this.f6263u.i() - i7) <= 0) {
            return i6;
        }
        this.f6263u.s(i4);
        return i4 + i6;
    }

    private int m2(int i3, RecyclerView.w wVar, RecyclerView.B b3, boolean z3) {
        int n3;
        int n4 = i3 - this.f6263u.n();
        if (n4 <= 0) {
            return 0;
        }
        int i4 = -C2(n4, wVar, b3);
        int i5 = i3 + i4;
        if (!z3 || (n3 = i5 - this.f6263u.n()) <= 0) {
            return i4;
        }
        this.f6263u.s(-n3);
        return i4 - n3;
    }

    private View n2() {
        return I(this.f6266x ? 0 : J() - 1);
    }

    private View o2() {
        return I(this.f6266x ? J() - 1 : 0);
    }

    private void u2(RecyclerView.w wVar, RecyclerView.B b3, int i3, int i4) {
        if (!b3.g() || J() == 0 || b3.e() || !O1()) {
            return;
        }
        List k3 = wVar.k();
        int size = k3.size();
        int j02 = j0(I(0));
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView.E e3 = (RecyclerView.E) k3.get(i7);
            if (!e3.isRemoved()) {
                if ((e3.getLayoutPosition() < j02) != this.f6266x) {
                    i5 += this.f6263u.e(e3.itemView);
                } else {
                    i6 += this.f6263u.e(e3.itemView);
                }
            }
        }
        this.f6262t.f6289l = k3;
        if (i5 > 0) {
            N2(j0(o2()), i3);
            c cVar = this.f6262t;
            cVar.f6285h = i5;
            cVar.f6280c = 0;
            cVar.a();
            X1(wVar, this.f6262t, b3, false);
        }
        if (i6 > 0) {
            L2(j0(n2()), i4);
            c cVar2 = this.f6262t;
            cVar2.f6285h = i6;
            cVar2.f6280c = 0;
            cVar2.a();
            X1(wVar, this.f6262t, b3, false);
        }
        this.f6262t.f6289l = null;
    }

    private void w2(RecyclerView.w wVar, c cVar) {
        if (!cVar.f6278a || cVar.f6290m) {
            return;
        }
        int i3 = cVar.f6284g;
        int i4 = cVar.f6286i;
        if (cVar.f6283f == -1) {
            y2(wVar, i3, i4);
        } else {
            z2(wVar, i3, i4);
        }
    }

    private void x2(RecyclerView.w wVar, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        if (i4 <= i3) {
            while (i3 > i4) {
                q1(i3, wVar);
                i3--;
            }
        } else {
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                q1(i5, wVar);
            }
        }
    }

    private void y2(RecyclerView.w wVar, int i3, int i4) {
        int J3 = J();
        if (i3 < 0) {
            return;
        }
        int h3 = (this.f6263u.h() - i3) + i4;
        if (this.f6266x) {
            for (int i5 = 0; i5 < J3; i5++) {
                View I3 = I(i5);
                if (this.f6263u.g(I3) < h3 || this.f6263u.r(I3) < h3) {
                    x2(wVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = J3 - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View I4 = I(i7);
            if (this.f6263u.g(I4) < h3 || this.f6263u.r(I4) < h3) {
                x2(wVar, i6, i7);
                return;
            }
        }
    }

    private void z2(RecyclerView.w wVar, int i3, int i4) {
        if (i3 < 0) {
            return;
        }
        int i5 = i3 - i4;
        int J3 = J();
        if (!this.f6266x) {
            for (int i6 = 0; i6 < J3; i6++) {
                View I3 = I(i6);
                if (this.f6263u.d(I3) > i5 || this.f6263u.q(I3) > i5) {
                    x2(wVar, 0, i6);
                    return;
                }
            }
            return;
        }
        int i7 = J3 - 1;
        for (int i8 = i7; i8 >= 0; i8--) {
            View I4 = I(i8);
            if (this.f6263u.d(I4) > i5 || this.f6263u.q(I4) > i5) {
                x2(wVar, i7, i8);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void A1(int i3) {
        this.f6253A = i3;
        this.f6254B = Integer.MIN_VALUE;
        d dVar = this.f6256D;
        if (dVar != null) {
            dVar.d();
        }
        w1();
    }

    boolean A2() {
        return this.f6263u.l() == 0 && this.f6263u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        if (this.f6261s == 0) {
            return 0;
        }
        return C2(i3, wVar, b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View C(int i3) {
        int J3 = J();
        if (J3 == 0) {
            return null;
        }
        int j02 = i3 - j0(I(0));
        if (j02 >= 0 && j02 < J3) {
            View I3 = I(j02);
            if (j0(I3) == i3) {
                return I3;
            }
        }
        return super.C(i3);
    }

    int C2(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        if (J() == 0 || i3 == 0) {
            return 0;
        }
        W1();
        this.f6262t.f6278a = true;
        int i4 = i3 > 0 ? 1 : -1;
        int abs = Math.abs(i3);
        K2(i4, abs, true, b3);
        c cVar = this.f6262t;
        int X12 = cVar.f6284g + X1(wVar, cVar, b3, false);
        if (X12 < 0) {
            return 0;
        }
        if (abs > X12) {
            i3 = i4 * X12;
        }
        this.f6263u.s(-i3);
        this.f6262t.f6288k = i3;
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.q D() {
        return new RecyclerView.q(-2, -2);
    }

    public void D2(int i3, int i4) {
        this.f6253A = i3;
        this.f6254B = i4;
        d dVar = this.f6256D;
        if (dVar != null) {
            dVar.d();
        }
        w1();
    }

    public void E2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        g(null);
        if (i3 != this.f6261s || this.f6263u == null) {
            k b3 = k.b(this, i3);
            this.f6263u = b3;
            this.f6257E.f6269a = b3;
            this.f6261s = i3;
            w1();
        }
    }

    public void F2(boolean z3) {
        g(null);
        if (z3 == this.f6265w) {
            return;
        }
        this.f6265w = z3;
        w1();
    }

    public void G2(boolean z3) {
        g(null);
        if (this.f6267y == z3) {
            return;
        }
        this.f6267y = z3;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    boolean J1() {
        return (X() == 1073741824 || r0() == 1073741824 || !s0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void K0(RecyclerView recyclerView, RecyclerView.w wVar) {
        super.K0(recyclerView, wVar);
        if (this.f6255C) {
            n1(wVar);
            wVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View L0(View view, int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        int U12;
        B2();
        if (J() == 0 || (U12 = U1(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        W1();
        K2(U12, (int) (this.f6263u.o() * 0.33333334f), false, b3);
        c cVar = this.f6262t;
        cVar.f6284g = Integer.MIN_VALUE;
        cVar.f6278a = false;
        X1(wVar, cVar, b3, true);
        View j22 = U12 == -1 ? j2() : i2();
        View o22 = U12 == -1 ? o2() : n2();
        if (!o22.hasFocusable()) {
            return j22;
        }
        if (j22 == null) {
            return null;
        }
        return o22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L1(RecyclerView recyclerView, RecyclerView.B b3, int i3) {
        i iVar = new i(recyclerView.getContext());
        iVar.p(i3);
        M1(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void M0(AccessibilityEvent accessibilityEvent) {
        super.M0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(c2());
            accessibilityEvent.setToIndex(f2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean O1() {
        return this.f6256D == null && this.f6264v == this.f6267y;
    }

    protected void P1(RecyclerView.B b3, int[] iArr) {
        int i3;
        int p22 = p2(b3);
        if (this.f6262t.f6283f == -1) {
            i3 = 0;
        } else {
            i3 = p22;
            p22 = 0;
        }
        iArr[0] = p22;
        iArr[1] = i3;
    }

    void Q1(RecyclerView.B b3, c cVar, RecyclerView.p.c cVar2) {
        int i3 = cVar.f6281d;
        if (i3 < 0 || i3 >= b3.b()) {
            return;
        }
        cVar2.a(i3, Math.max(0, cVar.f6284g));
    }

    int U1(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 17 ? i3 != 33 ? i3 != 66 ? (i3 == 130 && this.f6261s == 1) ? 1 : Integer.MIN_VALUE : this.f6261s == 0 ? 1 : Integer.MIN_VALUE : this.f6261s == 1 ? -1 : Integer.MIN_VALUE : this.f6261s == 0 ? -1 : Integer.MIN_VALUE : (this.f6261s != 1 && r2()) ? -1 : 1 : (this.f6261s != 1 && r2()) ? 1 : -1;
    }

    c V1() {
        return new c();
    }

    void W1() {
        if (this.f6262t == null) {
            this.f6262t = V1();
        }
    }

    int X1(RecyclerView.w wVar, c cVar, RecyclerView.B b3, boolean z3) {
        int i3 = cVar.f6280c;
        int i4 = cVar.f6284g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                cVar.f6284g = i4 + i3;
            }
            w2(wVar, cVar);
        }
        int i5 = cVar.f6280c + cVar.f6285h;
        b bVar = this.f6258F;
        while (true) {
            if ((!cVar.f6290m && i5 <= 0) || !cVar.c(b3)) {
                break;
            }
            bVar.a();
            t2(wVar, b3, cVar, bVar);
            if (!bVar.f6275b) {
                cVar.f6279b += bVar.f6274a * cVar.f6283f;
                if (!bVar.f6276c || cVar.f6289l != null || !b3.e()) {
                    int i6 = cVar.f6280c;
                    int i7 = bVar.f6274a;
                    cVar.f6280c = i6 - i7;
                    i5 -= i7;
                }
                int i8 = cVar.f6284g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + bVar.f6274a;
                    cVar.f6284g = i9;
                    int i10 = cVar.f6280c;
                    if (i10 < 0) {
                        cVar.f6284g = i9 + i10;
                    }
                    w2(wVar, cVar);
                }
                if (z3 && bVar.f6277d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - cVar.f6280c;
    }

    public int Y1() {
        View h22 = h2(0, J(), true, false);
        if (h22 == null) {
            return -1;
        }
        return j0(h22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void Z0(RecyclerView.w wVar, RecyclerView.B b3) {
        int i3;
        int i4;
        int i5;
        int i6;
        int l22;
        int i7;
        View C3;
        int g3;
        int i8;
        int i9 = -1;
        if (!(this.f6256D == null && this.f6253A == -1) && b3.b() == 0) {
            n1(wVar);
            return;
        }
        d dVar = this.f6256D;
        if (dVar != null && dVar.c()) {
            this.f6253A = this.f6256D.f6291e;
        }
        W1();
        this.f6262t.f6278a = false;
        B2();
        View V3 = V();
        a aVar = this.f6257E;
        if (!aVar.f6273e || this.f6253A != -1 || this.f6256D != null) {
            aVar.e();
            a aVar2 = this.f6257E;
            aVar2.f6272d = this.f6266x ^ this.f6267y;
            J2(wVar, b3, aVar2);
            this.f6257E.f6273e = true;
        } else if (V3 != null && (this.f6263u.g(V3) >= this.f6263u.i() || this.f6263u.d(V3) <= this.f6263u.n())) {
            this.f6257E.c(V3, j0(V3));
        }
        c cVar = this.f6262t;
        cVar.f6283f = cVar.f6288k >= 0 ? 1 : -1;
        int[] iArr = this.f6260H;
        iArr[0] = 0;
        iArr[1] = 0;
        P1(b3, iArr);
        int max = Math.max(0, this.f6260H[0]) + this.f6263u.n();
        int max2 = Math.max(0, this.f6260H[1]) + this.f6263u.j();
        if (b3.e() && (i7 = this.f6253A) != -1 && this.f6254B != Integer.MIN_VALUE && (C3 = C(i7)) != null) {
            if (this.f6266x) {
                i8 = this.f6263u.i() - this.f6263u.d(C3);
                g3 = this.f6254B;
            } else {
                g3 = this.f6263u.g(C3) - this.f6263u.n();
                i8 = this.f6254B;
            }
            int i10 = i8 - g3;
            if (i10 > 0) {
                max += i10;
            } else {
                max2 -= i10;
            }
        }
        a aVar3 = this.f6257E;
        if (!aVar3.f6272d ? !this.f6266x : this.f6266x) {
            i9 = 1;
        }
        v2(wVar, b3, aVar3, i9);
        w(wVar);
        this.f6262t.f6290m = A2();
        this.f6262t.f6287j = b3.e();
        this.f6262t.f6286i = 0;
        a aVar4 = this.f6257E;
        if (aVar4.f6272d) {
            O2(aVar4);
            c cVar2 = this.f6262t;
            cVar2.f6285h = max;
            X1(wVar, cVar2, b3, false);
            c cVar3 = this.f6262t;
            i4 = cVar3.f6279b;
            int i11 = cVar3.f6281d;
            int i12 = cVar3.f6280c;
            if (i12 > 0) {
                max2 += i12;
            }
            M2(this.f6257E);
            c cVar4 = this.f6262t;
            cVar4.f6285h = max2;
            cVar4.f6281d += cVar4.f6282e;
            X1(wVar, cVar4, b3, false);
            c cVar5 = this.f6262t;
            i3 = cVar5.f6279b;
            int i13 = cVar5.f6280c;
            if (i13 > 0) {
                N2(i11, i4);
                c cVar6 = this.f6262t;
                cVar6.f6285h = i13;
                X1(wVar, cVar6, b3, false);
                i4 = this.f6262t.f6279b;
            }
        } else {
            M2(aVar4);
            c cVar7 = this.f6262t;
            cVar7.f6285h = max2;
            X1(wVar, cVar7, b3, false);
            c cVar8 = this.f6262t;
            i3 = cVar8.f6279b;
            int i14 = cVar8.f6281d;
            int i15 = cVar8.f6280c;
            if (i15 > 0) {
                max += i15;
            }
            O2(this.f6257E);
            c cVar9 = this.f6262t;
            cVar9.f6285h = max;
            cVar9.f6281d += cVar9.f6282e;
            X1(wVar, cVar9, b3, false);
            c cVar10 = this.f6262t;
            i4 = cVar10.f6279b;
            int i16 = cVar10.f6280c;
            if (i16 > 0) {
                L2(i14, i3);
                c cVar11 = this.f6262t;
                cVar11.f6285h = i16;
                X1(wVar, cVar11, b3, false);
                i3 = this.f6262t.f6279b;
            }
        }
        if (J() > 0) {
            if (this.f6266x ^ this.f6267y) {
                int l23 = l2(i3, wVar, b3, true);
                i5 = i4 + l23;
                i6 = i3 + l23;
                l22 = m2(i5, wVar, b3, false);
            } else {
                int m22 = m2(i4, wVar, b3, true);
                i5 = i4 + m22;
                i6 = i3 + m22;
                l22 = l2(i6, wVar, b3, false);
            }
            i4 = i5 + l22;
            i3 = i6 + l22;
        }
        u2(wVar, b3, i4, i3);
        if (b3.e()) {
            this.f6257E.e();
        } else {
            this.f6263u.t();
        }
        this.f6264v = this.f6267y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A.b
    public PointF a(int i3) {
        if (J() == 0) {
            return null;
        }
        int i4 = (i3 < j0(I(0))) != this.f6266x ? -1 : 1;
        return this.f6261s == 0 ? new PointF(i4, 0.0f) : new PointF(0.0f, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.B b3) {
        super.a1(b3);
        this.f6256D = null;
        this.f6253A = -1;
        this.f6254B = Integer.MIN_VALUE;
        this.f6257E.e();
    }

    View a2(boolean z3, boolean z4) {
        return this.f6266x ? h2(0, J(), z3, z4) : h2(J() - 1, -1, z3, z4);
    }

    View b2(boolean z3, boolean z4) {
        return this.f6266x ? h2(J() - 1, -1, z3, z4) : h2(0, J(), z3, z4);
    }

    public int c2() {
        View h22 = h2(0, J(), false, true);
        if (h22 == null) {
            return -1;
        }
        return j0(h22);
    }

    public int d2() {
        View h22 = h2(J() - 1, -1, true, false);
        if (h22 == null) {
            return -1;
        }
        return j0(h22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void e1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            this.f6256D = dVar;
            if (this.f6253A != -1) {
                dVar.d();
            }
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public Parcelable f1() {
        if (this.f6256D != null) {
            return new d(this.f6256D);
        }
        d dVar = new d();
        if (J() > 0) {
            W1();
            boolean z3 = this.f6264v ^ this.f6266x;
            dVar.f6293g = z3;
            if (z3) {
                View n22 = n2();
                dVar.f6292f = this.f6263u.i() - this.f6263u.d(n22);
                dVar.f6291e = j0(n22);
            } else {
                View o22 = o2();
                dVar.f6291e = j0(o22);
                dVar.f6292f = this.f6263u.g(o22) - this.f6263u.n();
            }
        } else {
            dVar.d();
        }
        return dVar;
    }

    public int f2() {
        View h22 = h2(J() - 1, -1, false, true);
        if (h22 == null) {
            return -1;
        }
        return j0(h22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void g(String str) {
        if (this.f6256D == null) {
            super.g(str);
        }
    }

    View g2(int i3, int i4) {
        int i5;
        int i6;
        W1();
        if (i4 <= i3 && i4 >= i3) {
            return I(i3);
        }
        if (this.f6263u.g(I(i3)) < this.f6263u.n()) {
            i5 = 16644;
            i6 = 16388;
        } else {
            i5 = 4161;
            i6 = 4097;
        }
        return this.f6261s == 0 ? this.f6358e.a(i3, i4, i5, i6) : this.f6359f.a(i3, i4, i5, i6);
    }

    View h2(int i3, int i4, boolean z3, boolean z4) {
        W1();
        int i5 = ModuleType.TYPE_WEATHER;
        int i6 = z3 ? 24579 : 320;
        if (!z4) {
            i5 = 0;
        }
        return this.f6261s == 0 ? this.f6358e.a(i3, i4, i6, i5) : this.f6359f.a(i3, i4, i6, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean k() {
        return this.f6261s == 0;
    }

    View k2(RecyclerView.w wVar, RecyclerView.B b3, boolean z3, boolean z4) {
        int i3;
        int i4;
        int i5;
        W1();
        int J3 = J();
        if (z4) {
            i4 = J() - 1;
            i3 = -1;
            i5 = -1;
        } else {
            i3 = J3;
            i4 = 0;
            i5 = 1;
        }
        int b4 = b3.b();
        int n3 = this.f6263u.n();
        int i6 = this.f6263u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i4 != i3) {
            View I3 = I(i4);
            int j02 = j0(I3);
            int g3 = this.f6263u.g(I3);
            int d3 = this.f6263u.d(I3);
            if (j02 >= 0 && j02 < b4) {
                if (!((RecyclerView.q) I3.getLayoutParams()).c()) {
                    boolean z5 = d3 <= n3 && g3 < n3;
                    boolean z6 = g3 >= i6 && d3 > i6;
                    if (!z5 && !z6) {
                        return I3;
                    }
                    if (z3) {
                        if (!z6) {
                            if (view != null) {
                            }
                            view = I3;
                        }
                        view2 = I3;
                    } else {
                        if (!z5) {
                            if (view != null) {
                            }
                            view = I3;
                        }
                        view2 = I3;
                    }
                } else if (view3 == null) {
                    view3 = I3;
                }
            }
            i4 += i5;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean l() {
        return this.f6261s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void o(int i3, int i4, RecyclerView.B b3, RecyclerView.p.c cVar) {
        if (this.f6261s != 0) {
            i3 = i4;
        }
        if (J() == 0 || i3 == 0) {
            return;
        }
        W1();
        K2(i3 > 0 ? 1 : -1, Math.abs(i3), true, b3);
        Q1(b3, this.f6262t, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void p(int i3, RecyclerView.p.c cVar) {
        boolean z3;
        int i4;
        d dVar = this.f6256D;
        if (dVar == null || !dVar.c()) {
            B2();
            z3 = this.f6266x;
            i4 = this.f6253A;
            if (i4 == -1) {
                i4 = z3 ? i3 - 1 : 0;
            }
        } else {
            d dVar2 = this.f6256D;
            z3 = dVar2.f6293g;
            i4 = dVar2.f6291e;
        }
        int i5 = z3 ? -1 : 1;
        for (int i6 = 0; i6 < this.f6259G && i4 >= 0 && i4 < i3; i6++) {
            cVar.a(i4, 0);
            i4 += i5;
        }
    }

    protected int p2(RecyclerView.B b3) {
        if (b3.d()) {
            return this.f6263u.o();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int q(RecyclerView.B b3) {
        return R1(b3);
    }

    public int q2() {
        return this.f6261s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.B b3) {
        return S1(b3);
    }

    protected boolean r2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.B b3) {
        return T1(b3);
    }

    public boolean s2() {
        return this.f6268z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.B b3) {
        return R1(b3);
    }

    void t2(RecyclerView.w wVar, RecyclerView.B b3, c cVar, b bVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int f3;
        View d3 = cVar.d(wVar);
        if (d3 == null) {
            bVar.f6275b = true;
            return;
        }
        RecyclerView.q qVar = (RecyclerView.q) d3.getLayoutParams();
        if (cVar.f6289l == null) {
            if (this.f6266x == (cVar.f6283f == -1)) {
                d(d3);
            } else {
                e(d3, 0);
            }
        } else {
            if (this.f6266x == (cVar.f6283f == -1)) {
                b(d3);
            } else {
                c(d3, 0);
            }
        }
        C0(d3, 0, 0);
        bVar.f6274a = this.f6263u.e(d3);
        if (this.f6261s == 1) {
            if (r2()) {
                f3 = q0() - g0();
                i6 = f3 - this.f6263u.f(d3);
            } else {
                i6 = f0();
                f3 = this.f6263u.f(d3) + i6;
            }
            if (cVar.f6283f == -1) {
                int i7 = cVar.f6279b;
                i5 = i7;
                i4 = f3;
                i3 = i7 - bVar.f6274a;
            } else {
                int i8 = cVar.f6279b;
                i3 = i8;
                i4 = f3;
                i5 = bVar.f6274a + i8;
            }
        } else {
            int i02 = i0();
            int f4 = this.f6263u.f(d3) + i02;
            if (cVar.f6283f == -1) {
                int i9 = cVar.f6279b;
                i4 = i9;
                i3 = i02;
                i5 = f4;
                i6 = i9 - bVar.f6274a;
            } else {
                int i10 = cVar.f6279b;
                i3 = i02;
                i4 = bVar.f6274a + i10;
                i5 = f4;
                i6 = i10;
            }
        }
        B0(d3, i6, i3, i4, i5);
        if (qVar.c() || qVar.b()) {
            bVar.f6276c = true;
        }
        bVar.f6277d = d3.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.B b3) {
        return S1(b3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean u0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.B b3) {
        return T1(b3);
    }

    void v2(RecyclerView.w wVar, RecyclerView.B b3, a aVar, int i3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i3, RecyclerView.w wVar, RecyclerView.B b3) {
        if (this.f6261s == 1) {
            return 0;
        }
        return C2(i3, wVar, b3);
    }

    public LinearLayoutManager(Context context, int i3, boolean z3) {
        this.f6261s = 1;
        this.f6265w = false;
        this.f6266x = false;
        this.f6267y = false;
        this.f6268z = true;
        this.f6253A = -1;
        this.f6254B = Integer.MIN_VALUE;
        this.f6256D = null;
        this.f6257E = new a();
        this.f6258F = new b();
        this.f6259G = 2;
        this.f6260H = new int[2];
        E2(i3);
        F2(z3);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f6261s = 1;
        this.f6265w = false;
        this.f6266x = false;
        this.f6267y = false;
        this.f6268z = true;
        this.f6253A = -1;
        this.f6254B = Integer.MIN_VALUE;
        this.f6256D = null;
        this.f6257E = new a();
        this.f6258F = new b();
        this.f6259G = 2;
        this.f6260H = new int[2];
        RecyclerView.p.d k02 = RecyclerView.p.k0(context, attributeSet, i3, i4);
        E2(k02.f6374a);
        F2(k02.f6376c);
        G2(k02.f6377d);
    }
}
