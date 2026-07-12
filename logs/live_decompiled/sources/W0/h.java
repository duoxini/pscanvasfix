package W0;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: e, reason: collision with root package name */
    private final Object f2589e;

    public h(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f2589e = bool;
    }

    private static boolean l(h hVar) {
        Object obj = hVar.f2589e;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f2589e == null) {
            return hVar.f2589e == null;
        }
        if (l(this) && l(hVar)) {
            return i().longValue() == hVar.i().longValue();
        }
        Object obj2 = this.f2589e;
        if (!(obj2 instanceof Number) || !(hVar.f2589e instanceof Number)) {
            return obj2.equals(hVar.f2589e);
        }
        double doubleValue = i().doubleValue();
        double doubleValue2 = hVar.i().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public boolean h() {
        return k() ? ((Boolean) this.f2589e).booleanValue() : Boolean.parseBoolean(j());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f2589e == null) {
            return 31;
        }
        if (l(this)) {
            doubleToLongBits = i().longValue();
        } else {
            Object obj = this.f2589e;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(i().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public Number i() {
        Object obj = this.f2589e;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new X0.b((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String j() {
        Object obj = this.f2589e;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (m()) {
            return i().toString();
        }
        if (k()) {
            return ((Boolean) this.f2589e).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f2589e.getClass());
    }

    public boolean k() {
        return this.f2589e instanceof Boolean;
    }

    public boolean m() {
        return this.f2589e instanceof Number;
    }

    public boolean n() {
        return this.f2589e instanceof String;
    }

    public h(Number number) {
        Objects.requireNonNull(number);
        this.f2589e = number;
    }

    public h(String str) {
        Objects.requireNonNull(str);
        this.f2589e = str;
    }
}
