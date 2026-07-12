package d1;

import android.graphics.Color;
import android.graphics.Paint;
import d1.AbstractC0336a;
import i1.AbstractC0395b;
import k1.C0439j;
import n1.C0482a;
import n1.C0483b;

/* loaded from: classes.dex */
public class c implements AbstractC0336a.b {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0336a.b f11022a;

    /* renamed from: b, reason: collision with root package name */
    private final AbstractC0336a f11023b;

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC0336a f11024c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0336a f11025d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0336a f11026e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0336a f11027f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11028g = true;

    class a extends C0483b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C0483b f11029d;

        a(C0483b c0483b) {
            this.f11029d = c0483b;
        }

        @Override // n1.C0483b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(C0482a c0482a) {
            Float f3 = (Float) this.f11029d.a(c0482a);
            if (f3 == null) {
                return null;
            }
            return Float.valueOf(f3.floatValue() * 2.55f);
        }
    }

    public c(AbstractC0336a.b bVar, AbstractC0395b abstractC0395b, C0439j c0439j) {
        this.f11022a = bVar;
        AbstractC0336a a3 = c0439j.a().a();
        this.f11023b = a3;
        a3.a(this);
        abstractC0395b.k(a3);
        AbstractC0336a a4 = c0439j.d().a();
        this.f11024c = a4;
        a4.a(this);
        abstractC0395b.k(a4);
        AbstractC0336a a5 = c0439j.b().a();
        this.f11025d = a5;
        a5.a(this);
        abstractC0395b.k(a5);
        AbstractC0336a a6 = c0439j.c().a();
        this.f11026e = a6;
        a6.a(this);
        abstractC0395b.k(a6);
        AbstractC0336a a7 = c0439j.e().a();
        this.f11027f = a7;
        a7.a(this);
        abstractC0395b.k(a7);
    }

    public void a(Paint paint) {
        if (this.f11028g) {
            this.f11028g = false;
            double floatValue = ((Float) this.f11025d.h()).floatValue() * 0.017453292519943295d;
            float floatValue2 = ((Float) this.f11026e.h()).floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = ((Integer) this.f11023b.h()).intValue();
            paint.setShadowLayer(((Float) this.f11027f.h()).floatValue(), sin, cos, Color.argb(Math.round(((Float) this.f11024c.h()).floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    public void b(C0483b c0483b) {
        this.f11023b.n(c0483b);
    }

    public void c(C0483b c0483b) {
        this.f11025d.n(c0483b);
    }

    public void d(C0483b c0483b) {
        this.f11026e.n(c0483b);
    }

    @Override // d1.AbstractC0336a.b
    public void e() {
        this.f11028g = true;
        this.f11022a.e();
    }

    public void f(C0483b c0483b) {
        if (c0483b == null) {
            this.f11024c.n(null);
        } else {
            this.f11024c.n(new a(c0483b));
        }
    }

    public void g(C0483b c0483b) {
        this.f11027f.n(c0483b);
    }
}
