package X0;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class b extends Number {

    /* renamed from: e, reason: collision with root package name */
    private final String f2835e;

    public b(String str) {
        this.f2835e = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f2835e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        String str = this.f2835e;
        String str2 = ((b) obj).f2835e;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f2835e);
    }

    public int hashCode() {
        return this.f2835e.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f2835e);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f2835e);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f2835e).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f2835e);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f2835e).longValue();
        }
    }

    public String toString() {
        return this.f2835e;
    }
}
