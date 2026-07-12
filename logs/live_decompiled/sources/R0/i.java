package r0;

import Z.b;
import android.animation.ArgbEvaluator;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public class i {

    /* renamed from: l, reason: collision with root package name */
    private static final ArgbEvaluator f13197l = new ArgbEvaluator();

    /* renamed from: a, reason: collision with root package name */
    private final String f13198a;

    /* renamed from: b, reason: collision with root package name */
    private final B.c f13199b;

    /* renamed from: c, reason: collision with root package name */
    private final b.q f13200c;

    /* renamed from: d, reason: collision with root package name */
    private int f13201d;

    /* renamed from: e, reason: collision with root package name */
    private int f13202e;

    /* renamed from: f, reason: collision with root package name */
    private int f13203f;

    /* renamed from: g, reason: collision with root package name */
    private float f13204g;

    /* renamed from: h, reason: collision with root package name */
    private float f13205h;

    /* renamed from: i, reason: collision with root package name */
    private Z.c f13206i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f13207j;

    /* renamed from: k, reason: collision with root package name */
    private View f13208k;

    class a implements b.q {
        a() {
        }

        @Override // Z.b.q
        public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
            i.this.d(0.0f, true);
            bVar.i(i.this.f13200c);
        }
    }

    class b extends B.c {
        b(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(i iVar) {
            return iVar.h();
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(i iVar, float f3) {
            iVar.j(f3);
        }
    }

    public i(Drawable drawable, String str, int i3, int i4) {
        this(drawable, null, str, i3, i4);
    }

    private void f() {
        if (this.f13206i != null) {
            return;
        }
        Z.c cVar = new Z.c(this, this.f13199b);
        this.f13206i = cVar;
        cVar.B(new Z.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h() {
        return this.f13204g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(float f3) {
        this.f13204g = f3;
        this.f13201d = ((Integer) f13197l.evaluate(f3 / 10000.0f, Integer.valueOf(this.f13203f), Integer.valueOf(this.f13202e))).intValue();
        Drawable drawable = this.f13207j;
        if (drawable != null) {
            drawable.invalidateSelf();
        }
        View view = this.f13208k;
        if (view != null) {
            view.invalidate();
        }
        float f4 = this.f13204g;
        if (f4 > this.f13205h) {
            this.f13205h = Float.MAX_VALUE;
            if (f4 >= 10000.0f) {
                this.f13206i.a(this.f13200c);
            } else {
                d(0.0f, true);
            }
        }
    }

    public void d(float f3, boolean z3) {
        f();
        this.f13206i.i(this.f13200c);
        if (z3) {
            this.f13206i.o(this.f13204g);
            this.f13206i.u(f3);
        } else {
            if (this.f13206i.h()) {
                this.f13206i.u(f3);
                this.f13206i.z();
            }
            j(f3);
        }
        this.f13205h = Float.MAX_VALUE;
    }

    public void e(float f3, float f4) {
        f();
        this.f13206i.i(this.f13200c);
        if (!this.f13206i.h()) {
            this.f13206i.o(this.f13204g);
            this.f13206i.u(f3);
            this.f13205h = f4;
        } else {
            float f5 = this.f13204g;
            if (f5 <= f4) {
                this.f13205h = f4;
            } else {
                this.f13206i.o(f5);
                this.f13206i.u(f3);
            }
        }
    }

    public int g() {
        return this.f13201d;
    }

    public void i(int i3) {
        this.f13202e = i3;
    }

    public void k(float f3) {
        f();
        this.f13206i.x().d(f3);
    }

    public void l(float f3) {
        f();
        this.f13206i.x().g(f3);
    }

    public i(View view, String str, int i3, int i4) {
        this(null, view, str, i3, i4);
    }

    public i(Drawable drawable, View view, String str, int i3, int i4) {
        this.f13200c = new a();
        this.f13204g = 0.0f;
        this.f13205h = Float.MAX_VALUE;
        this.f13207j = drawable;
        this.f13208k = view;
        this.f13198a = str;
        this.f13199b = new b(str);
        f();
        this.f13203f = i3;
        this.f13202e = i4;
    }
}
