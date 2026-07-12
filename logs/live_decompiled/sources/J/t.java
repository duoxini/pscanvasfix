package J;

import J.u;
import android.content.Context;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f1052a = new t();

    private t() {
    }

    public static final u.a a(Context context, Class cls, String str) {
        D2.k.e(context, "context");
        D2.k.e(cls, "klass");
        if (str == null || K2.e.m(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new u.a(context, cls, str);
    }

    public static final Object b(Class cls, String str) {
        String str2;
        D2.k.e(cls, "klass");
        D2.k.e(str, "suffix");
        Package r12 = cls.getPackage();
        D2.k.b(r12);
        String name = r12.getName();
        String canonicalName = cls.getCanonicalName();
        D2.k.b(canonicalName);
        D2.k.d(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            D2.k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str3 = K2.e.q(canonicalName, '.', '_', false, 4, null) + str;
        try {
            if (name.length() == 0) {
                str2 = str3;
            } else {
                str2 = name + '.' + str3;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            D2.k.c(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return cls2.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls + ".canonicalName");
        }
    }
}
