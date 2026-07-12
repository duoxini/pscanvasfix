package L2;

import Q2.C0201h;
import p2.C0511k;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class H {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(InterfaceC0593d interfaceC0593d) {
        Object b3;
        if (interfaceC0593d instanceof C0201h) {
            return interfaceC0593d.toString();
        }
        try {
            C0511k.a aVar = C0511k.f12803f;
            b3 = C0511k.b(interfaceC0593d + '@' + b(interfaceC0593d));
        } catch (Throwable th) {
            C0511k.a aVar2 = C0511k.f12803f;
            b3 = C0511k.b(p2.l.a(th));
        }
        if (C0511k.d(b3) != null) {
            b3 = interfaceC0593d.getClass().getName() + '@' + b(interfaceC0593d);
        }
        return (String) b3;
    }
}
