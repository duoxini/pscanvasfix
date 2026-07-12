package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Locale f5011a = new Locale("", "");

    static class a {
        static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    public static int a(Locale locale) {
        return a.a(locale);
    }
}
