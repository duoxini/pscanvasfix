package androidx.recyclerview.widget;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import androidx.preference.Preference;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import d0.AbstractC0335a;

/* loaded from: classes.dex */
class b {

    /* renamed from: k, reason: collision with root package name */
    public static float f6466k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public static float f6467l = 0.15f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6468a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f6469b;

    /* renamed from: c, reason: collision with root package name */
    private int f6470c;

    /* renamed from: d, reason: collision with root package name */
    private int f6471d;

    /* renamed from: e, reason: collision with root package name */
    private int f6472e;

    /* renamed from: f, reason: collision with root package name */
    private int f6473f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6474g;

    /* renamed from: h, reason: collision with root package name */
    private Z.c f6475h;

    /* renamed from: i, reason: collision with root package name */
    private B.c f6476i;

    /* renamed from: j, reason: collision with root package name */
    private View f6477j;

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
            bVar.l(f3);
        }
    }

    public b(RecyclerView recyclerView, int i3) {
        this.f6469b = recyclerView;
        this.f6471d = i3;
        h();
    }

    private void d() {
        if (this.f6475h != null) {
            return;
        }
        this.f6475h = new Z.c(this, this.f6476i);
        Z.d dVar = new Z.d();
        dVar.d(f6466k);
        dVar.g(f6467l);
        this.f6475h.B(dVar);
    }

    private void e(MotionEvent motionEvent) {
        if (j(motionEvent.getX(), motionEvent.getY())) {
            d();
            this.f6475h.o(this.f6472e);
            this.f6475h.u(0.0f);
        }
    }

    private void f(MotionEvent motionEvent) {
        this.f6474g = false;
        if (this.f6477j != null) {
            d();
            this.f6475h.o(this.f6472e);
            this.f6475h.u(this.f6473f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        return this.f6472e;
    }

    private void h() {
        m(true);
    }

    private boolean j(float f3, float f4) {
        View findChildViewUnder = this.f6469b.findChildViewUnder(f3, f4);
        this.f6477j = findChildViewUnder;
        if (findChildViewUnder == null || !(this.f6469b.getAdapter() instanceof androidx.preference.h)) {
            return true;
        }
        Preference i3 = ((androidx.preference.h) this.f6469b.getAdapter()).i(this.f6469b.getChildAdapterPosition(this.f6477j));
        if (i3 != null) {
            return i3.isEnabled();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(float f3) {
        this.f6472e = (int) f3;
        n();
    }

    private void n() {
        if (this.f6477j != null) {
            for (int i3 = 0; i3 < this.f6469b.getItemDecorationCount(); i3++) {
                RecyclerView.o itemDecorationAt = this.f6469b.getItemDecorationAt(i3);
                if (itemDecorationAt instanceof COUIRecyclerView.a) {
                    COUIRecyclerView.a aVar = (COUIRecyclerView.a) itemDecorationAt;
                    aVar.o(this.f6469b.indexOfChild(this.f6477j));
                    aVar.n(this.f6472e);
                    this.f6469b.invalidate();
                }
            }
        }
    }

    protected void c(MotionEvent motionEvent) {
        if (this.f6468a) {
            if (motionEvent.getAction() == 0) {
                this.f6474g = true;
                this.f6470c = (int) (motionEvent.getY() + 0.5f);
                e(motionEvent);
            } else {
                if (motionEvent.getAction() == 1) {
                    f(motionEvent);
                    return;
                }
                if (motionEvent.getAction() == 3) {
                    f(motionEvent);
                } else if (motionEvent.getAction() == 2 && Math.abs(((int) (motionEvent.getY() + 0.5f)) - this.f6470c) > this.f6471d && this.f6474g) {
                    f(motionEvent);
                }
            }
        }
    }

    protected boolean i(View view, int i3) {
        if (this.f6468a) {
            this.f6469b.getChildAt(i3 + 1);
        }
        return true;
    }

    protected void k(MotionEvent motionEvent) {
        if (this.f6474g) {
            f(motionEvent);
        }
    }

    protected void m(boolean z3) {
        this.f6468a = z3;
        if (z3) {
            int alpha = Color.alpha(AbstractC0335a.a(this.f6469b.getContext(), M1.c.f1363h));
            this.f6473f = alpha;
            this.f6472e = alpha;
            if (this.f6476i == null) {
                this.f6476i = new a("dividerAlpha");
            }
            d();
        }
    }
}
