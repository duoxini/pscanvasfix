package i1;

import a1.InterfaceC0223c;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import b1.C0292a;
import com.oplus.anim.n;
import d1.AbstractC0336a;
import d1.q;
import n1.C0483b;

/* loaded from: classes.dex */
public class h extends AbstractC0395b {

    /* renamed from: D, reason: collision with root package name */
    private final RectF f12093D;

    /* renamed from: E, reason: collision with root package name */
    private final Paint f12094E;

    /* renamed from: F, reason: collision with root package name */
    private final float[] f12095F;

    /* renamed from: G, reason: collision with root package name */
    private final Path f12096G;

    /* renamed from: H, reason: collision with root package name */
    private final e f12097H;

    /* renamed from: I, reason: collision with root package name */
    private AbstractC0336a f12098I;

    h(n nVar, e eVar) {
        super(nVar, eVar);
        this.f12093D = new RectF();
        C0292a c0292a = new C0292a();
        this.f12094E = c0292a;
        this.f12095F = new float[8];
        this.f12096G = new Path();
        this.f12097H = eVar;
        c0292a.setAlpha(0);
        c0292a.setStyle(Paint.Style.FILL);
        c0292a.setColor(eVar.o());
    }

    @Override // i1.AbstractC0395b, c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        super.a(rectF, matrix, z3);
        this.f12093D.set(0.0f, 0.0f, this.f12097H.q(), this.f12097H.p());
        this.f12025o.mapRect(this.f12093D);
        rectF.set(this.f12093D);
    }

    @Override // i1.AbstractC0395b, f1.g
    public void h(Object obj, C0483b c0483b) {
        super.h(obj, c0483b);
        if (obj == InterfaceC0223c.f3188K) {
            if (c0483b == null) {
                this.f12098I = null;
            } else {
                this.f12098I = new q(c0483b);
            }
        }
    }

    @Override // i1.AbstractC0395b
    public void v(Canvas canvas, Matrix matrix, int i3) {
        int alpha = Color.alpha(this.f12097H.o());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i3 / 255.0f) * (((alpha / 255.0f) * (this.f12034x.h() == null ? 100 : ((Integer) this.f12034x.h().h()).intValue())) / 100.0f) * 255.0f);
        this.f12094E.setAlpha(intValue);
        AbstractC0336a abstractC0336a = this.f12098I;
        if (abstractC0336a != null) {
            this.f12094E.setColorFilter((ColorFilter) abstractC0336a.h());
        }
        if (intValue > 0) {
            float[] fArr = this.f12095F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f12097H.q();
            float[] fArr2 = this.f12095F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f12097H.q();
            this.f12095F[5] = this.f12097H.p();
            float[] fArr3 = this.f12095F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f12097H.p();
            matrix.mapPoints(this.f12095F);
            this.f12096G.reset();
            Path path = this.f12096G;
            float[] fArr4 = this.f12095F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f12096G;
            float[] fArr5 = this.f12095F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f12096G;
            float[] fArr6 = this.f12095F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f12096G;
            float[] fArr7 = this.f12095F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f12096G;
            float[] fArr8 = this.f12095F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f12096G.close();
            canvas.drawPath(this.f12096G, this.f12094E);
        }
    }
}
