package A2;

import java.io.Closeable;
import p2.AbstractC0501a;

/* loaded from: classes.dex */
public abstract class a {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC0501a.a(th, th2);
            }
        }
    }
}
