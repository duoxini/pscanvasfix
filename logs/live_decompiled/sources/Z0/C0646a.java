package z0;

/* renamed from: z0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0646a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile C0646a f14658a;

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f14659b = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.'};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f14660c = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 21, 8, 4, 22, 52, 47, 8, 4, 22, 48, 17, 0, 15, 15, 4, 17};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f14661d = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 14, 18, 52, 28, 14, 11, 14, 17, 27, 20, 8, 11, 3};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f14662e = {6, 4, 19, 28, 14, 11, 14, 17, 40, 44, 47, 30, 43, 44, 34, 40, 39};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f14663f = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 2, 14, 13, 19, 4, 13, 19, 52, 17, 4, 18, 52, 28, 14, 13, 5, 8, 6, 20, 17, 0, 19, 8, 14, 13, 48, 17, 0, 15, 15, 4, 17};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f14664g = {0, 13, 3, 17, 14, 8, 3, 52, 21, 8, 4, 22, 52, 40, 15, 15, 14, 27, 0, 18, 4, 47, 8, 4, 22};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f14665h = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 2, 11, 8, 2, 10, 19, 14, 15};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f14666i = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 22, 8, 3, 6, 4, 19, 52, 26, 1, 18, 37, 8, 18, 19, 47, 8, 4, 22, 48, 17, 0, 15, 15, 4, 17};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f14667j = {17, 14, 52, 14, 15, 15, 14, 52, 19, 7, 4, 12, 4, 52, 21, 4, 17, 18, 8, 14, 13};

    private C0646a() {
    }

    public static C0646a b() {
        if (f14658a == null) {
            synchronized (C0646a.class) {
                try {
                    if (f14658a == null) {
                        f14658a = new C0646a();
                    }
                } finally {
                }
            }
        }
        return f14658a;
    }

    public String a() {
        int length = f14663f.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = f14659b[f14663f[i3]];
        }
        return String.valueOf(cArr);
    }

    public String c() {
        int length = f14661d.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = f14659b[f14661d[i3]];
        }
        return String.valueOf(cArr);
    }

    public String d() {
        int length = f14662e.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = f14659b[f14662e[i3]];
        }
        return String.valueOf(cArr);
    }

    public String e() {
        int length = f14667j.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = f14659b[f14667j[i3]];
        }
        return String.valueOf(cArr);
    }

    public String f() {
        int length = f14660c.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = f14659b[f14660c[i3]];
        }
        return String.valueOf(cArr);
    }
}
