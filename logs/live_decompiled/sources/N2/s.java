package N2;

import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public interface s {

    public static final class a {
        public static /* synthetic */ boolean a(s sVar, Throwable th, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i3 & 1) != 0) {
                th = null;
            }
            return sVar.e(th);
        }
    }

    void d(C2.l lVar);

    boolean e(Throwable th);

    Object f(Object obj);

    Object n(Object obj, InterfaceC0593d interfaceC0593d);

    boolean o();
}
