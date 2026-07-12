package L2;

/* loaded from: classes.dex */
public abstract class o0 extends A {
    public abstract o0 f0();

    protected final String g0() {
        o0 o0Var;
        o0 c3 = O.c();
        if (this == c3) {
            return "Dispatchers.Main";
        }
        try {
            o0Var = c3.f0();
        } catch (UnsupportedOperationException unused) {
            o0Var = null;
        }
        if (this == o0Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
