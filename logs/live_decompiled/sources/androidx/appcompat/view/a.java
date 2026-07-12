package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import e.AbstractC0340b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3718a;

    private a(Context context) {
        this.f3718a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f3718a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f3718a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f3718a.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600) {
            return 5;
        }
        if (i3 > 960 && i4 > 720) {
            return 5;
        }
        if (i3 > 720 && i4 > 960) {
            return 5;
        }
        if (i3 >= 500) {
            return 4;
        }
        if (i3 > 640 && i4 > 480) {
            return 4;
        }
        if (i3 <= 480 || i4 <= 640) {
            return i3 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean e() {
        return this.f3718a.getResources().getBoolean(AbstractC0340b.f11112a);
    }

    public boolean f() {
        return true;
    }
}
