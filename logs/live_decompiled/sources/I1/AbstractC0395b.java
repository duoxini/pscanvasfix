package i1;

import a1.C0221a;
import a1.v;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import b1.C0292a;
import com.oplus.anim.n;
import d1.AbstractC0336a;
import d1.p;
import f1.C0358f;
import h1.C0372a;
import h1.C0379h;
import i1.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k1.C0439j;
import m1.AbstractC0462e;
import m1.AbstractC0465h;
import n1.C0483b;

/* renamed from: i1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0395b implements c1.e, AbstractC0336a.b, f1.g {

    /* renamed from: A, reason: collision with root package name */
    private Paint f12008A;

    /* renamed from: B, reason: collision with root package name */
    float f12009B;

    /* renamed from: C, reason: collision with root package name */
    BlurMaskFilter f12010C;

    /* renamed from: a, reason: collision with root package name */
    private final Path f12011a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f12012b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f12013c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    private final Paint f12014d = new C0292a(1);

    /* renamed from: e, reason: collision with root package name */
    private final Paint f12015e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f12016f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f12017g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f12018h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f12019i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f12020j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f12021k;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f12022l;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f12023m;

    /* renamed from: n, reason: collision with root package name */
    private final String f12024n;

    /* renamed from: o, reason: collision with root package name */
    final Matrix f12025o;

    /* renamed from: p, reason: collision with root package name */
    final n f12026p;

    /* renamed from: q, reason: collision with root package name */
    final e f12027q;

    /* renamed from: r, reason: collision with root package name */
    private d1.h f12028r;

    /* renamed from: s, reason: collision with root package name */
    private d1.d f12029s;

    /* renamed from: t, reason: collision with root package name */
    private AbstractC0395b f12030t;

    /* renamed from: u, reason: collision with root package name */
    private AbstractC0395b f12031u;

    /* renamed from: v, reason: collision with root package name */
    private List f12032v;

    /* renamed from: w, reason: collision with root package name */
    private final List f12033w;

    /* renamed from: x, reason: collision with root package name */
    final p f12034x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f12035y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f12036z;

    /* renamed from: i1.b$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12037a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12038b;

        static {
            int[] iArr = new int[C0379h.a.values().length];
            f12038b = iArr;
            try {
                iArr[C0379h.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12038b[C0379h.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12038b[C0379h.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12038b[C0379h.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[e.a.values().length];
            f12037a = iArr2;
            try {
                iArr2[e.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12037a[e.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12037a[e.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12037a[e.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12037a[e.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12037a[e.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12037a[e.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    AbstractC0395b(n nVar, e eVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f12015e = new C0292a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f12016f = new C0292a(1, mode2);
        C0292a c0292a = new C0292a(1);
        this.f12017g = c0292a;
        this.f12018h = new C0292a(PorterDuff.Mode.CLEAR);
        this.f12019i = new RectF();
        this.f12020j = new RectF();
        this.f12021k = new RectF();
        this.f12022l = new RectF();
        this.f12023m = new RectF();
        this.f12025o = new Matrix();
        this.f12033w = new ArrayList();
        this.f12035y = true;
        this.f12009B = 0.0f;
        this.f12026p = nVar;
        this.f12027q = eVar;
        this.f12024n = eVar.i() + "#draw";
        if (eVar.h() == e.b.INVERT) {
            c0292a.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            c0292a.setXfermode(new PorterDuffXfermode(mode));
        }
        p b3 = eVar.w().b();
        this.f12034x = b3;
        b3.b(this);
        if (eVar.g() != null && !eVar.g().isEmpty()) {
            d1.h hVar = new d1.h(eVar.g());
            this.f12028r = hVar;
            Iterator it = hVar.a().iterator();
            while (it.hasNext()) {
                ((AbstractC0336a) it.next()).a(this);
            }
            for (AbstractC0336a abstractC0336a : this.f12028r.c()) {
                k(abstractC0336a);
                abstractC0336a.a(this);
            }
        }
        P();
    }

    private void D(RectF rectF, Matrix matrix) {
        this.f12021k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (B()) {
            int size = this.f12028r.b().size();
            for (int i3 = 0; i3 < size; i3++) {
                C0379h c0379h = (C0379h) this.f12028r.b().get(i3);
                Path path = (Path) ((AbstractC0336a) this.f12028r.a().get(i3)).h();
                if (path != null) {
                    this.f12011a.set(path);
                    this.f12011a.transform(matrix);
                    int i4 = a.f12038b[c0379h.a().ordinal()];
                    if (i4 == 1 || i4 == 2) {
                        return;
                    }
                    if ((i4 == 3 || i4 == 4) && c0379h.d()) {
                        return;
                    }
                    this.f12011a.computeBounds(this.f12023m, false);
                    if (i3 == 0) {
                        this.f12021k.set(this.f12023m);
                    } else {
                        RectF rectF2 = this.f12021k;
                        rectF2.set(Math.min(rectF2.left, this.f12023m.left), Math.min(this.f12021k.top, this.f12023m.top), Math.max(this.f12021k.right, this.f12023m.right), Math.max(this.f12021k.bottom, this.f12023m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f12021k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void E(RectF rectF, Matrix matrix) {
        if (C() && this.f12027q.h() != e.b.INVERT) {
            this.f12022l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f12030t.a(this.f12022l, matrix, true);
            if (rectF.intersect(this.f12022l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void F() {
        this.f12026p.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        O(this.f12029s.p() == 1.0f);
    }

    private void H(float f3) {
        this.f12026p.G().n().a(this.f12027q.i(), f3);
    }

    private void O(boolean z3) {
        if (z3 != this.f12035y) {
            this.f12035y = z3;
            F();
        }
    }

    private void P() {
        if (this.f12027q.e().isEmpty()) {
            O(true);
            return;
        }
        d1.d dVar = new d1.d(this.f12027q.e());
        this.f12029s = dVar;
        dVar.l();
        this.f12029s.a(new AbstractC0336a.b() { // from class: i1.a
            @Override // d1.AbstractC0336a.b
            public final void e() {
                AbstractC0395b.this.G();
            }
        });
        O(((Float) this.f12029s.h()).floatValue() == 1.0f);
        k(this.f12029s);
    }

    private void l(Canvas canvas, Matrix matrix, AbstractC0336a abstractC0336a, AbstractC0336a abstractC0336a2) {
        this.f12011a.set((Path) abstractC0336a.h());
        this.f12011a.transform(matrix);
        this.f12014d.setAlpha((int) (((Integer) abstractC0336a2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f12011a, this.f12014d);
    }

    private void m(Canvas canvas, Matrix matrix, AbstractC0336a abstractC0336a, AbstractC0336a abstractC0336a2) {
        AbstractC0465h.o(canvas, this.f12019i, this.f12015e);
        this.f12011a.set((Path) abstractC0336a.h());
        this.f12011a.transform(matrix);
        this.f12014d.setAlpha((int) (((Integer) abstractC0336a2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f12011a, this.f12014d);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, AbstractC0336a abstractC0336a, AbstractC0336a abstractC0336a2) {
        AbstractC0465h.o(canvas, this.f12019i, this.f12014d);
        canvas.drawRect(this.f12019i, this.f12014d);
        this.f12011a.set((Path) abstractC0336a.h());
        this.f12011a.transform(matrix);
        this.f12014d.setAlpha((int) (((Integer) abstractC0336a2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f12011a, this.f12016f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix, AbstractC0336a abstractC0336a, AbstractC0336a abstractC0336a2) {
        AbstractC0465h.o(canvas, this.f12019i, this.f12015e);
        canvas.drawRect(this.f12019i, this.f12014d);
        this.f12016f.setAlpha((int) (((Integer) abstractC0336a2.h()).intValue() * 2.55f));
        this.f12011a.set((Path) abstractC0336a.h());
        this.f12011a.transform(matrix);
        canvas.drawPath(this.f12011a, this.f12016f);
        canvas.restore();
    }

    private void p(Canvas canvas, Matrix matrix, AbstractC0336a abstractC0336a, AbstractC0336a abstractC0336a2) {
        AbstractC0465h.o(canvas, this.f12019i, this.f12016f);
        canvas.drawRect(this.f12019i, this.f12014d);
        this.f12016f.setAlpha((int) (((Integer) abstractC0336a2.h()).intValue() * 2.55f));
        this.f12011a.set((Path) abstractC0336a.h());
        this.f12011a.transform(matrix);
        canvas.drawPath(this.f12011a, this.f12016f);
        canvas.restore();
    }

    private void q(Canvas canvas, Matrix matrix) {
        v.a("Layer#saveLayer");
        AbstractC0465h.p(canvas, this.f12019i, this.f12015e, 19);
        v.b("Layer#saveLayer");
        for (int i3 = 0; i3 < this.f12028r.b().size(); i3++) {
            C0379h c0379h = (C0379h) this.f12028r.b().get(i3);
            AbstractC0336a abstractC0336a = (AbstractC0336a) this.f12028r.a().get(i3);
            AbstractC0336a abstractC0336a2 = (AbstractC0336a) this.f12028r.c().get(i3);
            int i4 = a.f12038b[c0379h.a().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    if (i3 == 0) {
                        this.f12014d.setColor(-16777216);
                        this.f12014d.setAlpha(255);
                        canvas.drawRect(this.f12019i, this.f12014d);
                    }
                    if (c0379h.d()) {
                        p(canvas, matrix, abstractC0336a, abstractC0336a2);
                    } else {
                        r(canvas, matrix, abstractC0336a);
                    }
                } else if (i4 != 3) {
                    if (i4 == 4) {
                        if (c0379h.d()) {
                            n(canvas, matrix, abstractC0336a, abstractC0336a2);
                        } else {
                            l(canvas, matrix, abstractC0336a, abstractC0336a2);
                        }
                    }
                } else if (c0379h.d()) {
                    o(canvas, matrix, abstractC0336a, abstractC0336a2);
                } else {
                    m(canvas, matrix, abstractC0336a, abstractC0336a2);
                }
            } else if (s()) {
                this.f12014d.setAlpha(255);
                canvas.drawRect(this.f12019i, this.f12014d);
            }
        }
        v.a("Layer#restoreLayer");
        canvas.restore();
        v.b("Layer#restoreLayer");
    }

    private void r(Canvas canvas, Matrix matrix, AbstractC0336a abstractC0336a) {
        this.f12011a.set((Path) abstractC0336a.h());
        this.f12011a.transform(matrix);
        canvas.drawPath(this.f12011a, this.f12016f);
    }

    private boolean s() {
        if (this.f12028r.a().isEmpty()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f12028r.b().size(); i3++) {
            if (((C0379h) this.f12028r.b().get(i3)).a() != C0379h.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void t() {
        if (this.f12032v != null) {
            return;
        }
        if (this.f12031u == null) {
            this.f12032v = Collections.emptyList();
            return;
        }
        this.f12032v = new ArrayList();
        for (AbstractC0395b abstractC0395b = this.f12031u; abstractC0395b != null; abstractC0395b = abstractC0395b.f12031u) {
            this.f12032v.add(abstractC0395b);
        }
    }

    private void u(Canvas canvas) {
        v.a("Layer#clearLayer");
        RectF rectF = this.f12019i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f12018h);
        v.b("Layer#clearLayer");
    }

    static AbstractC0395b w(C0396c c0396c, e eVar, n nVar, C0221a c0221a) {
        switch (a.f12037a[eVar.f().ordinal()]) {
            case 1:
                return new g(nVar, eVar, c0396c, c0221a);
            case 2:
                return new C0396c(nVar, eVar, c0221a.o(eVar.m()), c0221a);
            case 3:
                return new h(nVar, eVar);
            case 4:
                return new d(nVar, eVar);
            case 5:
                return new f(nVar, eVar);
            case 6:
                return new i(nVar, eVar);
            default:
                AbstractC0462e.c("Unknown layer type " + eVar.f());
                return null;
        }
    }

    e A() {
        return this.f12027q;
    }

    boolean B() {
        d1.h hVar = this.f12028r;
        return (hVar == null || hVar.a().isEmpty()) ? false : true;
    }

    boolean C() {
        return this.f12030t != null;
    }

    public void I(AbstractC0336a abstractC0336a) {
        this.f12033w.remove(abstractC0336a);
    }

    void J(C0358f c0358f, int i3, List list, C0358f c0358f2) {
    }

    void K(AbstractC0395b abstractC0395b) {
        this.f12030t = abstractC0395b;
    }

    void L(boolean z3) {
        if (z3 && this.f12008A == null) {
            this.f12008A = new C0292a();
        }
        this.f12036z = z3;
    }

    void M(AbstractC0395b abstractC0395b) {
        this.f12031u = abstractC0395b;
    }

    void N(float f3) {
        this.f12034x.j(f3);
        if (this.f12028r != null) {
            for (int i3 = 0; i3 < this.f12028r.a().size(); i3++) {
                ((AbstractC0336a) this.f12028r.a().get(i3)).m(f3);
            }
        }
        d1.d dVar = this.f12029s;
        if (dVar != null) {
            dVar.m(f3);
        }
        AbstractC0395b abstractC0395b = this.f12030t;
        if (abstractC0395b != null) {
            abstractC0395b.N(f3);
        }
        for (int i4 = 0; i4 < this.f12033w.size(); i4++) {
            ((AbstractC0336a) this.f12033w.get(i4)).m(f3);
        }
    }

    @Override // c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        this.f12019i.set(0.0f, 0.0f, 0.0f, 0.0f);
        t();
        this.f12025o.set(matrix);
        if (z3) {
            List list = this.f12032v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f12025o.preConcat(((AbstractC0395b) this.f12032v.get(size)).f12034x.f());
                }
            } else {
                AbstractC0395b abstractC0395b = this.f12031u;
                if (abstractC0395b != null) {
                    this.f12025o.preConcat(abstractC0395b.f12034x.f());
                }
            }
        }
        this.f12025o.preConcat(this.f12034x.f());
    }

    @Override // f1.g
    public void b(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        AbstractC0395b abstractC0395b = this.f12030t;
        if (abstractC0395b != null) {
            C0358f a3 = c0358f2.a(abstractC0395b.j());
            if (c0358f.c(this.f12030t.j(), i3)) {
                list.add(a3.i(this.f12030t));
            }
            if (c0358f.h(j(), i3)) {
                this.f12030t.J(c0358f, c0358f.e(this.f12030t.j(), i3) + i3, list, a3);
            }
        }
        if (c0358f.g(j(), i3)) {
            if (!"__container".equals(j())) {
                c0358f2 = c0358f2.a(j());
                if (c0358f.c(j(), i3)) {
                    list.add(c0358f2.i(this));
                }
            }
            if (c0358f.h(j(), i3)) {
                J(c0358f, i3 + c0358f.e(j(), i3), list, c0358f2);
            }
        }
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        F();
    }

    @Override // c1.c
    public void f(List list, List list2) {
    }

    @Override // f1.g
    public void h(Object obj, C0483b c0483b) {
        this.f12034x.c(obj, c0483b);
    }

    @Override // c1.e
    public void i(Canvas canvas, Matrix matrix, int i3) {
        Paint paint;
        Integer num;
        v.a(this.f12024n);
        if (!this.f12035y || this.f12027q.x()) {
            v.b(this.f12024n);
            return;
        }
        t();
        v.a("Layer#parentMatrix");
        this.f12012b.reset();
        this.f12012b.set(matrix);
        for (int size = this.f12032v.size() - 1; size >= 0; size--) {
            this.f12012b.preConcat(((AbstractC0395b) this.f12032v.get(size)).f12034x.f());
        }
        v.b("Layer#parentMatrix");
        AbstractC0336a h3 = this.f12034x.h();
        int intValue = (int) ((((i3 / 255.0f) * ((h3 == null || (num = (Integer) h3.h()) == null) ? 100 : num.intValue())) / 100.0f) * 255.0f);
        if (!C() && !B()) {
            this.f12012b.preConcat(this.f12034x.f());
            v.a("Layer#drawLayer");
            v(canvas, this.f12012b, intValue);
            v.b("Layer#drawLayer");
            H(v.b(this.f12024n));
            return;
        }
        v.a("Layer#computeBounds");
        a(this.f12019i, this.f12012b, false);
        E(this.f12019i, matrix);
        this.f12012b.preConcat(this.f12034x.f());
        D(this.f12019i, this.f12012b);
        this.f12020j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.f12013c);
        if (!this.f12013c.isIdentity()) {
            Matrix matrix2 = this.f12013c;
            matrix2.invert(matrix2);
            this.f12013c.mapRect(this.f12020j);
        }
        if (!this.f12019i.intersect(this.f12020j)) {
            this.f12019i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        v.b("Layer#computeBounds");
        if (this.f12019i.width() >= 1.0f && this.f12019i.height() >= 1.0f) {
            v.a("Layer#saveLayer");
            this.f12014d.setAlpha(255);
            AbstractC0465h.o(canvas, this.f12019i, this.f12014d);
            v.b("Layer#saveLayer");
            u(canvas);
            v.a("Layer#drawLayer");
            v(canvas, this.f12012b, intValue);
            v.b("Layer#drawLayer");
            if (B()) {
                q(canvas, this.f12012b);
            }
            if (C()) {
                v.a("Layer#drawMatte");
                v.a("Layer#saveLayer");
                AbstractC0465h.p(canvas, this.f12019i, this.f12017g, 19);
                v.b("Layer#saveLayer");
                u(canvas);
                this.f12030t.i(canvas, matrix, intValue);
                v.a("Layer#restoreLayer");
                canvas.restore();
                v.b("Layer#restoreLayer");
                v.b("Layer#drawMatte");
            }
            v.a("Layer#restoreLayer");
            canvas.restore();
            v.b("Layer#restoreLayer");
        }
        if (this.f12036z && (paint = this.f12008A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.f12008A.setColor(-251901);
            this.f12008A.setStrokeWidth(4.0f);
            canvas.drawRect(this.f12019i, this.f12008A);
            this.f12008A.setStyle(Paint.Style.FILL);
            this.f12008A.setColor(1357638635);
            canvas.drawRect(this.f12019i, this.f12008A);
        }
        H(v.b(this.f12024n));
    }

    @Override // c1.c
    public String j() {
        return this.f12027q.i();
    }

    public void k(AbstractC0336a abstractC0336a) {
        if (abstractC0336a == null) {
            return;
        }
        this.f12033w.add(abstractC0336a);
    }

    abstract void v(Canvas canvas, Matrix matrix, int i3);

    public C0372a x() {
        return this.f12027q.a();
    }

    public BlurMaskFilter y(float f3) {
        if (this.f12009B == f3) {
            return this.f12010C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f3 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.f12010C = blurMaskFilter;
        this.f12009B = f3;
        return blurMaskFilter;
    }

    public C0439j z() {
        return this.f12027q.c();
    }
}
