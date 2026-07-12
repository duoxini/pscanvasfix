package j2;

import java.nio.charset.Charset;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0411a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f12158a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f12159b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f12160c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f12161d;

    static {
        Charset.forName("ISO-8859-1");
        Charset.forName("US-ASCII");
        f12158a = Charset.forName("UTF-16");
        f12159b = Charset.forName("UTF-16BE");
        f12160c = Charset.forName("UTF-16LE");
        f12161d = Charset.forName("UTF-8");
    }

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
