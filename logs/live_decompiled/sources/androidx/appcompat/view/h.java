package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.E;
import androidx.core.view.F;
import androidx.core.view.G;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f3783c;

    /* renamed from: d, reason: collision with root package name */
    F f3784d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3785e;

    /* renamed from: b, reason: collision with root package name */
    private long f3782b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final G f3786f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f3781a = new ArrayList();

    class a extends G {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3787a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f3788b = 0;

        a() {
        }

        @Override // androidx.core.view.F
        public void a(View view) {
            int i3 = this.f3788b + 1;
            this.f3788b = i3;
            if (i3 == h.this.f3781a.size()) {
                F f3 = h.this.f3784d;
                if (f3 != null) {
                    f3.a(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.G, androidx.core.view.F
        public void b(View view) {
            if (this.f3787a) {
                return;
            }
            this.f3787a = true;
            F f3 = h.this.f3784d;
            if (f3 != null) {
                f3.b(null);
            }
        }

        void d() {
            this.f3788b = 0;
            this.f3787a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f3785e) {
            Iterator it = this.f3781a.iterator();
            while (it.hasNext()) {
                ((E) it.next()).c();
            }
            this.f3785e = false;
        }
    }

    void b() {
        this.f3785e = false;
    }

    public h c(E e3) {
        if (!this.f3785e) {
            this.f3781a.add(e3);
        }
        return this;
    }

    public h d(E e3, E e4) {
        this.f3781a.add(e3);
        e4.j(e3.d());
        this.f3781a.add(e4);
        return this;
    }

    public h e(long j3) {
        if (!this.f3785e) {
            this.f3782b = j3;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f3785e) {
            this.f3783c = interpolator;
        }
        return this;
    }

    public h g(F f3) {
        if (!this.f3785e) {
            this.f3784d = f3;
        }
        return this;
    }

    public void h() {
        if (this.f3785e) {
            return;
        }
        Iterator it = this.f3781a.iterator();
        while (it.hasNext()) {
            E e3 = (E) it.next();
            long j3 = this.f3782b;
            if (j3 >= 0) {
                e3.f(j3);
            }
            Interpolator interpolator = this.f3783c;
            if (interpolator != null) {
                e3.g(interpolator);
            }
            if (this.f3784d != null) {
                e3.h(this.f3786f);
            }
            e3.l();
        }
        this.f3785e = true;
    }
}
