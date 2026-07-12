package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class s {

    /* renamed from: d, reason: collision with root package name */
    private static s f3673d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f3674a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f3675b;

    /* renamed from: c, reason: collision with root package name */
    private final a f3676c = new a();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f3677a;

        /* renamed from: b, reason: collision with root package name */
        long f3678b;

        a() {
        }
    }

    s(Context context, LocationManager locationManager) {
        this.f3674a = context;
        this.f3675b = locationManager;
    }

    static s a(Context context) {
        if (f3673d == null) {
            Context applicationContext = context.getApplicationContext();
            f3673d = new s(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f3673d;
    }

    private Location b() {
        Location c3 = androidx.core.content.c.b(this.f3674a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c4 = androidx.core.content.c.b(this.f3674a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c4 == null || c3 == null) ? c4 != null ? c4 : c3 : c4.getTime() > c3.getTime() ? c4 : c3;
    }

    private Location c(String str) {
        try {
            if (this.f3675b.isProviderEnabled(str)) {
                return this.f3675b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e3) {
            Log.d("TwilightManager", "Failed to get last known location", e3);
            return null;
        }
    }

    private boolean e() {
        return this.f3676c.f3678b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j3;
        a aVar = this.f3676c;
        long currentTimeMillis = System.currentTimeMillis();
        r b3 = r.b();
        b3.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b3.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z3 = b3.f3672c == 1;
        long j4 = b3.f3671b;
        long j5 = b3.f3670a;
        b3.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j6 = b3.f3671b;
        if (j4 == -1 || j5 == -1) {
            j3 = currentTimeMillis + 43200000;
        } else {
            if (currentTimeMillis > j5) {
                j4 = j6;
            } else if (currentTimeMillis > j4) {
                j4 = j5;
            }
            j3 = j4 + 60000;
        }
        aVar.f3677a = z3;
        aVar.f3678b = j3;
    }

    boolean d() {
        a aVar = this.f3676c;
        if (e()) {
            return aVar.f3677a;
        }
        Location b3 = b();
        if (b3 != null) {
            f(b3);
            return aVar.f3677a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i3 = Calendar.getInstance().get(11);
        return i3 < 6 || i3 >= 22;
    }
}
