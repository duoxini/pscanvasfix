package i1;

import a1.InterfaceC0223c;
import a1.r;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import b1.C0292a;
import com.oplus.anim.n;
import d1.AbstractC0336a;
import d1.q;
import m1.AbstractC0465h;
import n1.C0483b;

/* loaded from: classes.dex */
public class d extends AbstractC0395b {

    /* renamed from: D, reason: collision with root package name */
    private final Paint f12046D;

    /* renamed from: E, reason: collision with root package name */
    private final Rect f12047E;

    /* renamed from: F, reason: collision with root package name */
    private final Rect f12048F;

    /* renamed from: G, reason: collision with root package name */
    private final r f12049G;

    /* renamed from: H, reason: collision with root package name */
    private AbstractC0336a f12050H;

    /* renamed from: I, reason: collision with root package name */
    private AbstractC0336a f12051I;

    d(n nVar, e eVar) {
        super(nVar, eVar);
        this.f12046D = new C0292a(3);
        this.f12047E = new Rect();
        this.f12048F = new Rect();
        this.f12049G = nVar.M(eVar.m());
    }

    private Bitmap Q() {
        Bitmap bitmap;
        AbstractC0336a abstractC0336a = this.f12051I;
        if (abstractC0336a != null && (bitmap = (Bitmap) abstractC0336a.h()) != null) {
            return bitmap;
        }
        Bitmap E3 = this.f12026p.E(this.f12027q.m());
        if (E3 != null) {
            return E3;
        }
        r rVar = this.f12049G;
        if (rVar != null) {
            return rVar.a();
        }
        return null;
    }

    @Override // i1.AbstractC0395b, c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        super.a(rectF, matrix, z3);
        if (this.f12049G != null) {
            float e3 = AbstractC0465h.e();
            rectF.set(0.0f, 0.0f, this.f12049G.e() * e3, this.f12049G.c() * e3);
            this.f12025o.mapRect(rectF);
        }
    }

    @Override // i1.AbstractC0395b, f1.g
    public void h(Object obj, C0483b c0483b) {
        super.h(obj, c0483b);
        if (obj == InterfaceC0223c.f3188K) {
            if (c0483b == null) {
                this.f12050H = null;
                return;
            } else {
                this.f12050H = new q(c0483b);
                return;
            }
        }
        if (obj == InterfaceC0223c.f3191N) {
            if (c0483b == null) {
                this.f12051I = null;
            } else {
                this.f12051I = new q(c0483b);
            }
        }
    }

    @Override // i1.AbstractC0395b
    public void v(Canvas canvas, Matrix matrix, int i3) {
        Bitmap Q3 = Q();
        if (Q3 == null || Q3.isRecycled() || this.f12049G == null) {
            return;
        }
        float e3 = AbstractC0465h.e();
        this.f12046D.setAlpha(i3);
        AbstractC0336a abstractC0336a = this.f12050H;
        if (abstractC0336a != null) {
            this.f12046D.setColorFilter((ColorFilter) abstractC0336a.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f12047E.set(0, 0, Q3.getWidth(), Q3.getHeight());
        if (this.f12026p.N()) {
            this.f12048F.set(0, 0, (int) (this.f12049G.e() * e3), (int) (this.f12049G.c() * e3));
        } else {
            this.f12048F.set(0, 0, (int) (Q3.getWidth() * e3), (int) (Q3.getHeight() * e3));
        }
        canvas.drawBitmap(Q3, this.f12047E, this.f12048F, this.f12046D);
        canvas.restore();
    }
}
