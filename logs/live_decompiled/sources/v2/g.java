package v2;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class g {
    private static final void a(int i3, int i4) {
        if (i4 <= i3) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i3 + ", got " + i4 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(AbstractC0610a abstractC0610a) {
        return (f) abstractC0610a.getClass().getAnnotation(f.class);
    }

    private static final int c(AbstractC0610a abstractC0610a) {
        try {
            Field declaredField = abstractC0610a.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC0610a);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(AbstractC0610a abstractC0610a) {
        String str;
        D2.k.e(abstractC0610a, "<this>");
        f b3 = b(abstractC0610a);
        if (b3 == null) {
            return null;
        }
        a(1, b3.v());
        int c3 = c(abstractC0610a);
        int i3 = c3 < 0 ? -1 : b3.l()[c3];
        String b4 = i.f13853a.b(abstractC0610a);
        if (b4 == null) {
            str = b3.c();
        } else {
            str = b4 + '/' + b3.c();
        }
        return new StackTraceElement(str, b3.m(), b3.f(), i3);
    }
}
