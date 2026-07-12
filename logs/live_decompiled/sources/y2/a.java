package y2;

import D2.k;
import x2.AbstractC0638a;

/* loaded from: classes.dex */
public abstract class a extends AbstractC0638a {

    /* renamed from: y2.a$a, reason: collision with other inner class name */
    private static final class C0160a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0160a f14656a = new C0160a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f14657b;

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                f14657b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f14657b = num2;
        }

        private C0160a() {
        }
    }

    private final boolean c(int i3) {
        Integer num = C0160a.f14657b;
        return num == null || num.intValue() >= i3;
    }

    @Override // x2.AbstractC0638a
    public void a(Throwable th, Throwable th2) {
        k.e(th, "cause");
        k.e(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
