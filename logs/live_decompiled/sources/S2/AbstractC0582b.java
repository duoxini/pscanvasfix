package s2;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: s2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0582b {
    public static int a(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }
}
