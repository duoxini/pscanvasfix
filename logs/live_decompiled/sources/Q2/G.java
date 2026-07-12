package Q2;

import androidx.preference.Preference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract /* synthetic */ class G {
    public static final int a(String str, int i3, int i4, int i5) {
        return (int) E.c(str, i3, i4, i5);
    }

    public static final long b(String str, long j3, long j4, long j5) {
        String d3 = E.d(str);
        if (d3 == null) {
            return j3;
        }
        Long f3 = K2.e.f(d3);
        if (f3 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d3 + '\'').toString());
        }
        long longValue = f3.longValue();
        if (j4 <= longValue && longValue <= j5) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j4 + ".." + j5 + ", but is '" + longValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String d3 = E.d(str);
        return d3 == null ? str2 : d3;
    }

    public static final boolean d(String str, boolean z3) {
        String d3 = E.d(str);
        return d3 != null ? Boolean.parseBoolean(d3) : z3;
    }

    public static /* synthetic */ int e(String str, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i4 = 1;
        }
        if ((i6 & 8) != 0) {
            i5 = Preference.DEFAULT_ORDER;
        }
        return E.b(str, i3, i4, i5);
    }

    public static /* synthetic */ long f(String str, long j3, long j4, long j5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j4 = 1;
        }
        long j6 = j4;
        if ((i3 & 8) != 0) {
            j5 = Long.MAX_VALUE;
        }
        return E.c(str, j3, j6, j5);
    }
}
