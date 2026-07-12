package d1;

import java.util.Collections;
import n1.C0483b;

/* loaded from: classes.dex */
public class q extends AbstractC0336a {

    /* renamed from: i, reason: collision with root package name */
    private final Object f11070i;

    public q(C0483b c0483b) {
        this(c0483b, null);
    }

    @Override // d1.AbstractC0336a
    float c() {
        return 1.0f;
    }

    @Override // d1.AbstractC0336a
    public Object h() {
        C0483b c0483b = this.f11012e;
        Object obj = this.f11070i;
        return c0483b.b(0.0f, 0.0f, obj, obj, f(), f(), f());
    }

    @Override // d1.AbstractC0336a
    Object i(n1.c cVar, float f3) {
        return h();
    }

    @Override // d1.AbstractC0336a
    public void k() {
        if (this.f11012e != null) {
            super.k();
        }
    }

    @Override // d1.AbstractC0336a
    public void m(float f3) {
        this.f11011d = f3;
    }

    public q(C0483b c0483b, Object obj) {
        super(Collections.emptyList());
        n(c0483b);
        this.f11070i = obj;
    }
}
