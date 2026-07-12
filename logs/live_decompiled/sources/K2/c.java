package K2;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1171a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f1172b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f1173c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f1174d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f1175e;

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f1176f;

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f1177g;

    static {
        Charset forName = Charset.forName("UTF-8");
        D2.k.d(forName, "forName(...)");
        f1172b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        D2.k.d(forName2, "forName(...)");
        f1173c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        D2.k.d(forName3, "forName(...)");
        f1174d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        D2.k.d(forName4, "forName(...)");
        f1175e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        D2.k.d(forName5, "forName(...)");
        f1176f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        D2.k.d(forName6, "forName(...)");
        f1177g = forName6;
    }

    private c() {
    }
}
