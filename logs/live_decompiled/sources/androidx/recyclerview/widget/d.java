package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    final b f6480a;

    /* renamed from: b, reason: collision with root package name */
    final a f6481b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List f6482c = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f6483a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f6484b;

        a() {
        }

        private void c() {
            if (this.f6484b == null) {
                this.f6484b = new a();
            }
        }

        void a(int i3) {
            if (i3 < 64) {
                this.f6483a &= ~(1 << i3);
                return;
            }
            a aVar = this.f6484b;
            if (aVar != null) {
                aVar.a(i3 - 64);
            }
        }

        int b(int i3) {
            a aVar = this.f6484b;
            if (aVar == null) {
                if (i3 >= 64) {
                    return Long.bitCount(this.f6483a);
                }
                return Long.bitCount(((1 << i3) - 1) & this.f6483a);
            }
            if (i3 >= 64) {
                return aVar.b(i3 - 64) + Long.bitCount(this.f6483a);
            }
            return Long.bitCount(((1 << i3) - 1) & this.f6483a);
        }

        boolean d(int i3) {
            if (i3 < 64) {
                return ((1 << i3) & this.f6483a) != 0;
            }
            c();
            return this.f6484b.d(i3 - 64);
        }

        void e(int i3, boolean z3) {
            if (i3 >= 64) {
                c();
                this.f6484b.e(i3 - 64, z3);
                return;
            }
            long j3 = this.f6483a;
            boolean z4 = (Long.MIN_VALUE & j3) != 0;
            long j4 = (1 << i3) - 1;
            this.f6483a = ((j3 & (~j4)) << 1) | (j3 & j4);
            if (z3) {
                h(i3);
            } else {
                a(i3);
            }
            if (z4 || this.f6484b != null) {
                c();
                this.f6484b.e(0, z4);
            }
        }

        boolean f(int i3) {
            if (i3 >= 64) {
                c();
                return this.f6484b.f(i3 - 64);
            }
            long j3 = 1 << i3;
            long j4 = this.f6483a;
            boolean z3 = (j4 & j3) != 0;
            long j5 = j4 & (~j3);
            this.f6483a = j5;
            long j6 = j3 - 1;
            this.f6483a = (j5 & j6) | Long.rotateRight((~j6) & j5, 1);
            a aVar = this.f6484b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f6484b.f(0);
            }
            return z3;
        }

        void g() {
            this.f6483a = 0L;
            a aVar = this.f6484b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i3) {
            if (i3 < 64) {
                this.f6483a |= 1 << i3;
            } else {
                c();
                this.f6484b.h(i3 - 64);
            }
        }

        public String toString() {
            if (this.f6484b == null) {
                return Long.toBinaryString(this.f6483a);
            }
            return this.f6484b.toString() + "xx" + Long.toBinaryString(this.f6483a);
        }
    }

    interface b {
        View a(int i3);

        void b(View view);

        void c(int i3);

        void d();

        RecyclerView.E e(View view);

        void f(int i3);

        void g(View view);

        void h(View view, int i3, ViewGroup.LayoutParams layoutParams);

        void i(View view, int i3);

        int j(View view);

        int k();
    }

    d(b bVar) {
        this.f6480a = bVar;
    }

    private int h(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int k3 = this.f6480a.k();
        int i4 = i3;
        while (i4 < k3) {
            int b3 = i3 - (i4 - this.f6481b.b(i4));
            if (b3 == 0) {
                while (this.f6481b.d(i4)) {
                    i4++;
                }
                return i4;
            }
            i4 += b3;
        }
        return -1;
    }

    private void l(View view) {
        this.f6482c.add(view);
        this.f6480a.b(view);
    }

    private boolean t(View view) {
        if (!this.f6482c.remove(view)) {
            return false;
        }
        this.f6480a.g(view);
        return true;
    }

    void a(View view, int i3, boolean z3) {
        int k3 = i3 < 0 ? this.f6480a.k() : h(i3);
        this.f6481b.e(k3, z3);
        if (z3) {
            l(view);
        }
        this.f6480a.i(view, k3);
    }

    void b(View view, boolean z3) {
        a(view, -1, z3);
    }

    void c(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        int k3 = i3 < 0 ? this.f6480a.k() : h(i3);
        this.f6481b.e(k3, z3);
        if (z3) {
            l(view);
        }
        this.f6480a.h(view, k3, layoutParams);
    }

    void d(int i3) {
        int h3 = h(i3);
        this.f6481b.f(h3);
        this.f6480a.f(h3);
    }

    View e(int i3) {
        int size = this.f6482c.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) this.f6482c.get(i4);
            RecyclerView.E e3 = this.f6480a.e(view);
            if (e3.getLayoutPosition() == i3 && !e3.isInvalid() && !e3.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View f(int i3) {
        return this.f6480a.a(h(i3));
    }

    int g() {
        return this.f6480a.k() - this.f6482c.size();
    }

    View i(int i3) {
        return this.f6480a.a(i3);
    }

    int j() {
        return this.f6480a.k();
    }

    void k(View view) {
        int j3 = this.f6480a.j(view);
        if (j3 >= 0) {
            this.f6481b.h(j3);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int j3 = this.f6480a.j(view);
        if (j3 == -1 || this.f6481b.d(j3)) {
            return -1;
        }
        return j3 - this.f6481b.b(j3);
    }

    boolean n(View view) {
        return this.f6482c.contains(view);
    }

    void o() {
        this.f6481b.g();
        for (int size = this.f6482c.size() - 1; size >= 0; size--) {
            this.f6480a.g((View) this.f6482c.get(size));
            this.f6482c.remove(size);
        }
        this.f6480a.d();
    }

    void p(View view) {
        int j3 = this.f6480a.j(view);
        if (j3 < 0) {
            return;
        }
        if (this.f6481b.f(j3)) {
            t(view);
        }
        this.f6480a.c(j3);
    }

    void q(int i3) {
        int h3 = h(i3);
        View a3 = this.f6480a.a(h3);
        if (a3 == null) {
            return;
        }
        if (this.f6481b.f(h3)) {
            t(a3);
        }
        this.f6480a.c(h3);
    }

    boolean r(View view) {
        int j3 = this.f6480a.j(view);
        if (j3 == -1) {
            t(view);
            return true;
        }
        if (!this.f6481b.d(j3)) {
            return false;
        }
        this.f6481b.f(j3);
        t(view);
        this.f6480a.c(j3);
        return true;
    }

    void s(View view) {
        int j3 = this.f6480a.j(view);
        if (j3 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f6481b.d(j3)) {
            this.f6481b.a(j3);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f6481b.toString() + ", hidden list:" + this.f6482c.size();
    }
}
