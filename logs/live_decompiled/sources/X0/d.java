package X0;

import W0.i;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class d {
    public static W0.b a(Z0.a aVar) {
        boolean z3;
        try {
            try {
                aVar.k0();
                z3 = false;
                try {
                    return (W0.b) Y0.a.f2965V.b(aVar);
                } catch (EOFException e3) {
                    e = e3;
                    if (z3) {
                        return W0.d.f2587e;
                    }
                    throw new i(e);
                }
            } catch (EOFException e4) {
                e = e4;
                z3 = true;
            }
        } catch (Z0.d e5) {
            throw new i(e5);
        } catch (IOException e6) {
            throw new W0.c(e6);
        } catch (NumberFormatException e7) {
            throw new i(e7);
        }
    }

    public static void b(W0.b bVar, Z0.c cVar) {
        Y0.a.f2965V.c(cVar, bVar);
    }
}
