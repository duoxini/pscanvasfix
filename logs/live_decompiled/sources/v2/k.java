package v2;

import D2.s;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class k extends d implements D2.h {

    /* renamed from: h, reason: collision with root package name */
    private final int f13859h;

    public k(int i3, InterfaceC0593d interfaceC0593d) {
        super(interfaceC0593d);
        this.f13859h = i3;
    }

    @Override // D2.h
    public int getArity() {
        return this.f13859h;
    }

    @Override // v2.AbstractC0610a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String e3 = s.e(this);
        D2.k.d(e3, "renderLambdaToString(...)");
        return e3;
    }
}
