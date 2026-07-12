package Q2;

import a.C0214a;
import p2.C0511k;
import v2.AbstractC0610a;

/* loaded from: classes.dex */
public abstract class C {

    /* renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f1962a = new C0214a().a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f1963b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1964c;

    static {
        Object b3;
        Object b4;
        try {
            C0511k.a aVar = C0511k.f12803f;
            b3 = C0511k.b(AbstractC0610a.class.getCanonicalName());
        } catch (Throwable th) {
            C0511k.a aVar2 = C0511k.f12803f;
            b3 = C0511k.b(p2.l.a(th));
        }
        if (C0511k.d(b3) != null) {
            b3 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f1963b = (String) b3;
        try {
            b4 = C0511k.b(C.class.getCanonicalName());
        } catch (Throwable th2) {
            C0511k.a aVar3 = C0511k.f12803f;
            b4 = C0511k.b(p2.l.a(th2));
        }
        if (C0511k.d(b4) != null) {
            b4 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f1964c = (String) b4;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
