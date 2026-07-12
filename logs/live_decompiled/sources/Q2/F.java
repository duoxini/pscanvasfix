package Q2;

/* loaded from: classes.dex */
abstract /* synthetic */ class F {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1966a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f1966a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
