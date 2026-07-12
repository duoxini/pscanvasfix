package i1;

import a1.C0221a;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.oplus.anim.n;
import f1.C0358f;
import h1.C0372a;
import h1.C0387p;
import java.util.Collections;
import java.util.List;
import k1.C0439j;

/* loaded from: classes.dex */
public class g extends AbstractC0395b {

    /* renamed from: D, reason: collision with root package name */
    private final c1.d f12091D;

    /* renamed from: E, reason: collision with root package name */
    private final C0396c f12092E;

    g(n nVar, e eVar, C0396c c0396c, C0221a c0221a) {
        super(nVar, eVar);
        this.f12092E = c0396c;
        c1.d dVar = new c1.d(nVar, this, new C0387p("__container", eVar.n(), false), c0221a);
        this.f12091D = dVar;
        dVar.f(Collections.emptyList(), Collections.emptyList());
    }

    @Override // i1.AbstractC0395b
    protected void J(C0358f c0358f, int i3, List list, C0358f c0358f2) {
        this.f12091D.b(c0358f, i3, list, c0358f2);
    }

    @Override // i1.AbstractC0395b, c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        super.a(rectF, matrix, z3);
        this.f12091D.a(rectF, this.f12025o, z3);
    }

    @Override // i1.AbstractC0395b
    void v(Canvas canvas, Matrix matrix, int i3) {
        this.f12091D.i(canvas, matrix, i3);
    }

    @Override // i1.AbstractC0395b
    public C0372a x() {
        C0372a x3 = super.x();
        return x3 != null ? x3 : this.f12092E.x();
    }

    @Override // i1.AbstractC0395b
    public C0439j z() {
        C0439j z3 = super.z();
        return z3 != null ? z3 : this.f12092E.z();
    }
}
