package L2;

import p2.C0511k;
import t2.InterfaceC0593d;

/* renamed from: L2.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0192y {
    public static final Object a(Object obj, InterfaceC0593d interfaceC0593d) {
        if (!(obj instanceof C0188u)) {
            return C0511k.b(obj);
        }
        C0511k.a aVar = C0511k.f12803f;
        return C0511k.b(p2.l.a(((C0188u) obj).f1308a));
    }

    public static final Object b(Object obj, C2.l lVar) {
        Throwable d3 = C0511k.d(obj);
        return d3 == null ? lVar != null ? new C0189v(obj, lVar) : obj : new C0188u(d3, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC0178j interfaceC0178j) {
        Throwable d3 = C0511k.d(obj);
        return d3 == null ? obj : new C0188u(d3, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, C2.l lVar, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
