package W0;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes.dex */
public final class g {
    public static b b(Z0.a aVar) {
        boolean K3 = aVar.K();
        aVar.p0(true);
        try {
            try {
                return X0.d.a(aVar);
            } catch (OutOfMemoryError e3) {
                throw new f("Failed parsing JSON source: " + aVar + " to Json", e3);
            } catch (StackOverflowError e4) {
                throw new f("Failed parsing JSON source: " + aVar + " to Json", e4);
            }
        } finally {
            aVar.p0(K3);
        }
    }

    public static b c(Reader reader) {
        try {
            Z0.a aVar = new Z0.a(reader);
            b b3 = b(aVar);
            if (!b3.e() && aVar.k0() != Z0.b.END_DOCUMENT) {
                throw new i("Did not consume the entire document.");
            }
            return b3;
        } catch (Z0.d e3) {
            throw new i(e3);
        } catch (IOException e4) {
            throw new c(e4);
        } catch (NumberFormatException e5) {
            throw new i(e5);
        }
    }

    public static b d(String str) {
        return c(new StringReader(str));
    }

    public b a(String str) {
        return d(str);
    }
}
