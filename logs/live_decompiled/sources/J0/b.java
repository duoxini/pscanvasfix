package j0;

import M1.f;
import Y.c;
import Z.b;
import Z.d;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    private static final PathInterpolator f12139j = new c();

    /* renamed from: k, reason: collision with root package name */
    private static final B.c f12140k = new a("viewScaleTransition");

    /* renamed from: a, reason: collision with root package name */
    private boolean f12141a = true;

    /* renamed from: b, reason: collision with root package name */
    private float f12142b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f12143c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f12144d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f12145e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f12146f;

    /* renamed from: g, reason: collision with root package name */
    private View f12147g;

    /* renamed from: h, reason: collision with root package name */
    private int f12148h;

    /* renamed from: i, reason: collision with root package name */
    private Z.c f12149i;

    class a extends B.c {
        a(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(b bVar) {
            return bVar.g();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(b bVar, float f3) {
            bVar.j(f3);
        }
    }

    public b(View view, int i3) {
        this.f12148h = i3;
        k(view);
        m(view.getContext());
    }

    private void d() {
        if (this.f12149i != null) {
            return;
        }
        d dVar = new d();
        dVar.d(0.0f);
        dVar.g(0.3f);
        Z.c cVar = new Z.c(this, f12140k);
        this.f12149i = cVar;
        cVar.B(dVar);
        this.f12149i.b(new b.r() { // from class: j0.a
            @Override // Z.b.r
            public final void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                b.this.i(bVar, f3, f4);
            }
        });
    }

    private float f() {
        View view = this.f12147g;
        if (view == null) {
            return 1.0f;
        }
        int width = view.getWidth();
        int height = this.f12147g.getHeight();
        float f3 = this.f12142b * this.f12143c;
        if (f3 <= 0.0f) {
            f3 = width * height;
        }
        float f4 = this.f12144d;
        if (f3 <= f4) {
            return 0.92f;
        }
        float f5 = this.f12145e;
        if (f3 >= f5) {
            return 0.98f;
        }
        return (f12139j.getInterpolation((f3 - f4) / (f5 - f4)) * 0.060000002f) + 0.92f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g() {
        return this.f12146f;
    }

    private float h() {
        return 1.0f - ((1.0f - f()) * (this.f12146f / 10000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Z.b bVar, float f3, float f4) {
        j(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(float f3) {
        if (this.f12147g == null) {
            AbstractC0371a.g("COUIPressFeedbackHelper", "press effect target is null!");
            return;
        }
        float h3 = h();
        this.f12146f = f3;
        View view = this.f12147g;
        if (view != null) {
            view.setPivotX(view.getWidth() / 2.0f);
            this.f12147g.setPivotY(r4.getHeight() / 2.0f);
            this.f12147g.setScaleX(h3);
            this.f12147g.setScaleY(h3);
        }
    }

    private void m(Context context) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f1461u);
        this.f12144d = dimensionPixelOffset * dimensionPixelOffset;
        this.f12145e = context.getResources().getDimensionPixelOffset(f.f1460t) * context.getResources().getDimensionPixelOffset(f.f1459s);
    }

    public void e(boolean z3) {
        if (this.f12141a) {
            d();
            this.f12149i.u(z3 ? 10000.0f : 0.0f);
        }
    }

    public void k(View view) {
        this.f12147g = view;
    }

    public void l(int i3) {
        this.f12148h = i3;
    }
}
