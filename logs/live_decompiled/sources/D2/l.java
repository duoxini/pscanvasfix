package D2;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class l implements h, Serializable {
    private final int arity;

    public l(int i3) {
        this.arity = i3;
    }

    @Override // D2.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String f3 = s.f(this);
        k.d(f3, "renderLambdaToString(...)");
        return f3;
    }
}
