package androidx.window.area.utils;

import D2.k;
import android.util.DisplayMetrics;
import com.customer.feedback.sdk.model.RequestData;

/* loaded from: classes.dex */
public final class DeviceMetrics {

    /* renamed from: a, reason: collision with root package name */
    private final String f6930a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6931b;

    /* renamed from: c, reason: collision with root package name */
    private final DisplayMetrics f6932c;

    public DeviceMetrics(String str, String str2, DisplayMetrics displayMetrics) {
        k.e(str, "manufacturer");
        k.e(str2, RequestData.TYPE_MODEL);
        k.e(displayMetrics, "rearDisplayMetrics");
        this.f6930a = str;
        this.f6931b = str2;
        this.f6932c = displayMetrics;
    }

    public final String a() {
        return this.f6930a;
    }

    public final String b() {
        return this.f6931b;
    }

    public final DisplayMetrics c() {
        return this.f6932c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DeviceMetrics) {
            DeviceMetrics deviceMetrics = (DeviceMetrics) obj;
            if (k.a(this.f6930a, deviceMetrics.f6930a) && k.a(this.f6931b, deviceMetrics.f6931b) && this.f6932c.equals(deviceMetrics.f6932c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f6930a.hashCode() * 31) + this.f6931b.hashCode()) * 31) + this.f6932c.hashCode();
    }

    public String toString() {
        return "DeviceMetrics{ Manufacturer: " + this.f6930a + ", model: " + this.f6931b + ", Rear display metrics: " + this.f6932c + " }";
    }
}
