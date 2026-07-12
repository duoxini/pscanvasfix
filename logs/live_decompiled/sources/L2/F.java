package L2;

import p2.C0509i;
import t2.AbstractC0595f;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public enum F {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1238a;

        static {
            int[] iArr = new int[F.values().length];
            try {
                iArr[F.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[F.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[F.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[F.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f1238a = iArr;
        }
    }

    public final void b(C2.p pVar, Object obj, InterfaceC0593d interfaceC0593d) {
        int i3 = a.f1238a[ordinal()];
        if (i3 == 1) {
            R2.a.d(pVar, obj, interfaceC0593d, null, 4, null);
            return;
        }
        if (i3 == 2) {
            AbstractC0595f.a(pVar, obj, interfaceC0593d);
        } else if (i3 == 3) {
            R2.b.a(pVar, obj, interfaceC0593d);
        } else if (i3 != 4) {
            throw new C0509i();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
