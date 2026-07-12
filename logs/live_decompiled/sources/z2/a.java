package z2;

import F2.c;

/* loaded from: classes.dex */
public class a extends y2.a {

    /* renamed from: z2.a$a, reason: collision with other inner class name */
    private static final class C0162a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0162a f14710a = new C0162a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f14711b;

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
                f14711b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f14711b = num2;
        }

        private C0162a() {
        }
    }

    private final boolean c(int i3) {
        Integer num = C0162a.f14711b;
        return num == null || num.intValue() >= i3;
    }

    @Override // x2.AbstractC0638a
    public c b() {
        return c(34) ? new G2.a() : super.b();
    }
}
