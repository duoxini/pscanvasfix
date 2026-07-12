package E2;

import androidx.preference.Preference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c extends b {
    public static int a(double d3) {
        if (Double.isNaN(d3)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d3 > 2.147483647E9d) {
            return Preference.DEFAULT_ORDER;
        }
        if (d3 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d3);
    }
}
