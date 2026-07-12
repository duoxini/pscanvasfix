package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f4829c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static Set f4830d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private static final Object f4831e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f4832a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f4833b;

    private f(Context context) {
        this.f4832a = context;
        this.f4833b = (NotificationManager) context.getSystemService("notification");
    }

    public static f b(Context context) {
        return new f(context);
    }

    public boolean a() {
        return this.f4833b.areNotificationsEnabled();
    }
}
