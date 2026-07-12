package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class i extends RecyclerView.A {

    /* renamed from: k, reason: collision with root package name */
    protected PointF f6598k;

    /* renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f6599l;

    /* renamed from: n, reason: collision with root package name */
    private float f6601n;

    /* renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f6596i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f6597j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    private boolean f6600m = false;

    /* renamed from: o, reason: collision with root package name */
    protected int f6602o = 0;

    /* renamed from: p, reason: collision with root package name */
    protected int f6603p = 0;

    public i(Context context) {
        this.f6599l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f6600m) {
            this.f6601n = v(this.f6599l);
            this.f6600m = true;
        }
        return this.f6601n;
    }

    private int y(int i3, int i4) {
        int i5 = i3 - i4;
        if (i3 * i5 <= 0) {
            return 0;
        }
        return i5;
    }

    protected int B() {
        PointF pointF = this.f6598k;
        if (pointF != null) {
            float f3 = pointF.y;
            if (f3 != 0.0f) {
                return f3 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.A.a aVar) {
        PointF a3 = a(f());
        if (a3 == null || (a3.x == 0.0f && a3.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a3);
        this.f6598k = a3;
        this.f6602o = (int) (a3.x * 10000.0f);
        this.f6603p = (int) (a3.y * 10000.0f);
        aVar.d((int) (this.f6602o * 1.2f), (int) (this.f6603p * 1.2f), (int) (x(10000) * 1.2f), this.f6596i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A
    protected void l(int i3, int i4, RecyclerView.B b3, RecyclerView.A.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f6602o = y(this.f6602o, i3);
        int y3 = y(this.f6603p, i4);
        this.f6603p = y3;
        if (this.f6602o == 0 && y3 == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A
    protected void n() {
        this.f6603p = 0;
        this.f6602o = 0;
        this.f6598k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A
    protected void o(View view, RecyclerView.B b3, RecyclerView.A.a aVar) {
        int t3 = t(view, z());
        int u3 = u(view, B());
        int w3 = w((int) Math.sqrt((t3 * t3) + (u3 * u3)));
        if (w3 > 0) {
            aVar.d(-t3, -u3, w3, this.f6597j);
        }
    }

    public int s(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == -1) {
            return i5 - i3;
        }
        if (i7 != 0) {
            if (i7 == 1) {
                return i6 - i4;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i8 = i5 - i3;
        if (i8 > 0) {
            return i8;
        }
        int i9 = i6 - i4;
        if (i9 < 0) {
            return i9;
        }
        return 0;
    }

    public int t(View view, int i3) {
        RecyclerView.p e3 = e();
        if (e3 == null || !e3.k()) {
            return 0;
        }
        RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
        return s(e3.Q(view) - ((ViewGroup.MarginLayoutParams) qVar).leftMargin, e3.T(view) + ((ViewGroup.MarginLayoutParams) qVar).rightMargin, e3.f0(), e3.q0() - e3.g0(), i3);
    }

    public int u(View view, int i3) {
        RecyclerView.p e3 = e();
        if (e3 == null || !e3.l()) {
            return 0;
        }
        RecyclerView.q qVar = (RecyclerView.q) view.getLayoutParams();
        return s(e3.U(view) - ((ViewGroup.MarginLayoutParams) qVar).topMargin, e3.O(view) + ((ViewGroup.MarginLayoutParams) qVar).bottomMargin, e3.i0(), e3.W() - e3.d0(), i3);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int w(int i3) {
        return (int) Math.ceil(x(i3) / 0.3356d);
    }

    protected int x(int i3) {
        return (int) Math.ceil(Math.abs(i3) * A());
    }

    protected int z() {
        PointF pointF = this.f6598k;
        if (pointF != null) {
            float f3 = pointF.x;
            if (f3 != 0.0f) {
                return f3 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
