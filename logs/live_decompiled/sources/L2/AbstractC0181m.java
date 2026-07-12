package L2;

import Q2.C0201h;
import t2.InterfaceC0593d;

/* renamed from: L2.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0181m {
    public static final C0179k a(InterfaceC0593d interfaceC0593d) {
        if (!(interfaceC0593d instanceof C0201h)) {
            return new C0179k(interfaceC0593d, 1);
        }
        C0179k i3 = ((C0201h) interfaceC0593d).i();
        if (i3 != null) {
            if (!i3.H()) {
                i3 = null;
            }
            if (i3 != null) {
                return i3;
            }
        }
        return new C0179k(interfaceC0593d, 2);
    }
}
