package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static final f f4926b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final g f4927a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f4928a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f4928a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a3 = androidx.core.text.b.a(locale);
            if (!a3.isEmpty()) {
                return a3.equals(androidx.core.text.b.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private f(g gVar) {
        this.f4927a = gVar;
    }

    public static f a(Locale... localeArr) {
        return f(b.a(localeArr));
    }

    public static f b(String str) {
        if (str == null || str.isEmpty()) {
            return c();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i3 = 0; i3 < length; i3++) {
            localeArr[i3] = a.a(split[i3]);
        }
        return a(localeArr);
    }

    public static f c() {
        return f4926b;
    }

    public static f f(LocaleList localeList) {
        return new f(new h(localeList));
    }

    public boolean d() {
        return this.f4927a.isEmpty();
    }

    public String e() {
        return this.f4927a.b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f4927a.equals(((f) obj).f4927a);
    }

    public int hashCode() {
        return this.f4927a.hashCode();
    }

    public String toString() {
        return this.f4927a.toString();
    }
}
