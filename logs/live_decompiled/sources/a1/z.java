package a1;

/* loaded from: classes.dex */
public enum z {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3339a;

        static {
            int[] iArr = new int[z.values().length];
            f3339a = iArr;
            try {
                iArr[z.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3339a[z.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3339a[z.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean a(int i3, boolean z3, int i4) {
        int i5 = a.f3339a[ordinal()];
        if (i5 == 1) {
            return false;
        }
        if (i5 != 2) {
            return (z3 && i3 < 28) || i4 > 4 || i3 <= 25;
        }
        return true;
    }
}
