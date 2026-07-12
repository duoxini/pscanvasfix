package androidx.window.core;

import D2.g;
import D2.k;
import K2.e;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p2.AbstractC0506f;
import p2.InterfaceC0505e;

/* loaded from: classes.dex */
public final class Version implements Comparable<Version> {

    /* renamed from: j, reason: collision with root package name */
    public static final Companion f6980j = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Version f6981k = new Version(0, 0, 0, "");

    /* renamed from: l, reason: collision with root package name */
    private static final Version f6982l = new Version(0, 1, 0, "");

    /* renamed from: m, reason: collision with root package name */
    private static final Version f6983m;

    /* renamed from: n, reason: collision with root package name */
    private static final Version f6984n;

    /* renamed from: e, reason: collision with root package name */
    private final int f6985e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6986f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6987g;

    /* renamed from: h, reason: collision with root package name */
    private final String f6988h;

    /* renamed from: i, reason: collision with root package name */
    private final InterfaceC0505e f6989i;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Version a() {
            return Version.f6982l;
        }

        public final Version b(String str) {
            String group;
            if (str == null || e.m(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches() || (group = matcher.group(1)) == null) {
                return null;
            }
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            if (group2 == null) {
                return null;
            }
            int parseInt2 = Integer.parseInt(group2);
            String group3 = matcher.group(3);
            if (group3 == null) {
                return null;
            }
            int parseInt3 = Integer.parseInt(group3);
            String group4 = matcher.group(4) != null ? matcher.group(4) : "";
            k.d(group4, "description");
            return new Version(parseInt, parseInt2, parseInt3, group4, null);
        }

        private Companion() {
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f6983m = version;
        f6984n = version;
    }

    public /* synthetic */ Version(int i3, int i4, int i5, String str, g gVar) {
        this(i3, i4, i5, str);
    }

    private final BigInteger c() {
        Object value = this.f6989i.getValue();
        k.d(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Version version) {
        k.e(version, "other");
        return c().compareTo(version.c());
    }

    public final int d() {
        return this.f6985e;
    }

    public final int e() {
        return this.f6986f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f6985e == version.f6985e && this.f6986f == version.f6986f && this.f6987g == version.f6987g;
    }

    public final int f() {
        return this.f6987g;
    }

    public int hashCode() {
        return ((((527 + this.f6985e) * 31) + this.f6986f) * 31) + this.f6987g;
    }

    public String toString() {
        String str;
        if (e.m(this.f6988h)) {
            str = "";
        } else {
            str = '-' + this.f6988h;
        }
        return this.f6985e + '.' + this.f6986f + '.' + this.f6987g + str;
    }

    private Version(int i3, int i4, int i5, String str) {
        this.f6985e = i3;
        this.f6986f = i4;
        this.f6987g = i5;
        this.f6988h = str;
        this.f6989i = AbstractC0506f.a(new Version$bigInteger$2(this));
    }
}
