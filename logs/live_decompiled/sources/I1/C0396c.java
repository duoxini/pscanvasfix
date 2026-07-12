package i1;

import a1.C0221a;
import a1.InterfaceC0223c;
import a1.v;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.oplus.anim.n;
import d1.AbstractC0336a;
import d1.q;
import f1.C0358f;
import g1.C0366b;
import i1.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.C0454d;
import m1.AbstractC0465h;
import n1.C0483b;

/* renamed from: i1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0396c extends AbstractC0395b {

    /* renamed from: D, reason: collision with root package name */
    private AbstractC0336a f12039D;

    /* renamed from: E, reason: collision with root package name */
    private final List f12040E;

    /* renamed from: F, reason: collision with root package name */
    private final RectF f12041F;

    /* renamed from: G, reason: collision with root package name */
    private final RectF f12042G;

    /* renamed from: H, reason: collision with root package name */
    private final Paint f12043H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f12044I;

    /* renamed from: i1.c$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12045a;

        static {
            int[] iArr = new int[e.b.values().length];
            f12045a = iArr;
            try {
                iArr[e.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12045a[e.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C0396c(n nVar, e eVar, List list, C0221a c0221a) {
        super(nVar, eVar);
        int i3;
        AbstractC0395b abstractC0395b;
        this.f12040E = new ArrayList();
        this.f12041F = new RectF();
        this.f12042G = new RectF();
        this.f12043H = new Paint();
        this.f12044I = true;
        C0366b u3 = eVar.u();
        if (u3 != null) {
            AbstractC0336a a3 = u3.a();
            this.f12039D = a3;
            k(a3);
            this.f12039D.a(this);
        } else {
            this.f12039D = null;
        }
        C0454d c0454d = new C0454d(c0221a.k().size());
        int size = list.size() - 1;
        AbstractC0395b abstractC0395b2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            e eVar2 = (e) list.get(size);
            AbstractC0395b w3 = AbstractC0395b.w(this, eVar2, nVar, c0221a);
            if (w3 != null) {
                c0454d.i(w3.A().d(), w3);
                if (abstractC0395b2 != null) {
                    abstractC0395b2.K(w3);
                    abstractC0395b2 = null;
                } else {
                    this.f12040E.add(0, w3);
                    int i4 = a.f12045a[eVar2.h().ordinal()];
                    if (i4 == 1 || i4 == 2) {
                        abstractC0395b2 = w3;
                    }
                }
            }
            size--;
        }
        for (i3 = 0; i3 < c0454d.l(); i3++) {
            AbstractC0395b abstractC0395b3 = (AbstractC0395b) c0454d.e(c0454d.h(i3));
            if (abstractC0395b3 != null && (abstractC0395b = (AbstractC0395b) c0454d.e(abstractC0395b3.A().j())) != null) {
                abstractC0395b3.M(abstractC0395b);
            }
        }
    }

    @Override // i1.AbstractC0395b
    protected void J(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        for (int i4 = 0; i4 < this.f12040E.size(); i4++) {
            ((AbstractC0395b) this.f12040E.get(i4)).b(c0358f, i3, list, c0358f2);
        }
    }

    @Override // i1.AbstractC0395b
    public void L(boolean z3) {
        super.L(z3);
        Iterator it = this.f12040E.iterator();
        while (it.hasNext()) {
            ((AbstractC0395b) it.next()).L(z3);
        }
    }

    @Override // i1.AbstractC0395b
    public void N(float f3) {
        super.N(f3);
        if (this.f12039D != null) {
            f3 = ((((Float) this.f12039D.h()).floatValue() * this.f12027q.b().i()) - this.f12027q.b().p()) / (this.f12026p.G().e() + 0.01f);
        }
        if (this.f12039D == null) {
            f3 -= this.f12027q.r();
        }
        if (this.f12027q.v() != 0.0f && !"__container".equals(this.f12027q.i())) {
            f3 /= this.f12027q.v();
        }
        for (int size = this.f12040E.size() - 1; size >= 0; size--) {
            ((AbstractC0395b) this.f12040E.get(size)).N(f3);
        }
    }

    public void Q(boolean z3) {
        this.f12044I = z3;
    }

    @Override // i1.AbstractC0395b, c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        super.a(rectF, matrix, z3);
        for (int size = this.f12040E.size() - 1; size >= 0; size--) {
            this.f12041F.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((AbstractC0395b) this.f12040E.get(size)).a(this.f12041F, this.f12025o, true);
            rectF.union(this.f12041F);
        }
    }

    @Override // i1.AbstractC0395b, f1.g
    public void h(Object obj, C0483b c0483b) {
        super.h(obj, c0483b);
        if (obj == InterfaceC0223c.f3182E) {
            if (c0483b == null) {
                AbstractC0336a abstractC0336a = this.f12039D;
                if (abstractC0336a != null) {
                    abstractC0336a.n(null);
                    return;
                }
                return;
            }
            q qVar = new q(c0483b);
            this.f12039D = qVar;
            qVar.a(this);
            k(this.f12039D);
        }
    }

    @Override // i1.AbstractC0395b
    void v(Canvas canvas, Matrix matrix, int i3) {
        v.a("CompositionLayer#draw");
        this.f12042G.set(0.0f, 0.0f, this.f12027q.l(), this.f12027q.k());
        matrix.mapRect(this.f12042G);
        boolean z3 = this.f12026p.b0() && this.f12040E.size() > 1 && i3 != 255;
        if (z3) {
            this.f12043H.setAlpha(i3);
            AbstractC0465h.o(canvas, this.f12042G, this.f12043H);
        } else {
            canvas.save();
        }
        if (z3) {
            i3 = 255;
        }
        for (int size = this.f12040E.size() - 1; size >= 0; size--) {
            if (((this.f12044I || !"__container".equals(this.f12027q.i())) && !this.f12042G.isEmpty()) ? canvas.clipRect(this.f12042G) : true) {
                ((AbstractC0395b) this.f12040E.get(size)).i(canvas, matrix, i3);
            }
        }
        canvas.restore();
        v.b("CompositionLayer#draw");
    }
}
