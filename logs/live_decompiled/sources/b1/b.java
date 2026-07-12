package B1;

import B1.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.Log;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class b {

    /* renamed from: l, reason: collision with root package name */
    private static Boolean f148l = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: c, reason: collision with root package name */
    private Context f151c;

    /* renamed from: d, reason: collision with root package name */
    private UserManager f152d;

    /* renamed from: g, reason: collision with root package name */
    private Future f155g;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap f149a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final Object f150b = new Object();

    /* renamed from: e, reason: collision with root package name */
    private Runnable f153e = new Runnable() { // from class: B1.a
        @Override // java.lang.Runnable
        public final void run() {
            b.this.j();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList f156h = new ArrayList(Arrays.asList("com.android.documentsui"));

    /* renamed from: i, reason: collision with root package name */
    private BroadcastReceiver f157i = new a();

    /* renamed from: j, reason: collision with root package name */
    private BroadcastReceiver f158j = new C0007b();

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f159k = new c();

    /* renamed from: f, reason: collision with root package name */
    private Future f154f = C0305a.a().c(this.f153e);

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.LOCALE_CHANGED")) {
                if (b.f148l.booleanValue()) {
                    Log.d("AppListContainer", "local changed, reload");
                }
                if (b.this.f154f == null || b.this.f154f.isDone()) {
                    b.this.f154f = C0305a.a().c(b.this.f153e);
                }
            }
        }
    }

    /* renamed from: B1.b$b, reason: collision with other inner class name */
    class C0007b extends BroadcastReceiver {
        C0007b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Intent intent) {
            b.this.p(intent);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (b.this.f155g == null || b.this.f155g.isDone()) {
                b.this.f155g = C0305a.a().c(new Runnable() { // from class: B1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.C0007b.this.b(intent);
                    }
                });
            }
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d("AppListContainer", "profileChangeBroadcastReceiver, onReceive, intent = " + intent);
            b.this.n();
        }
    }

    public b(Context context) {
        this.f151c = context;
        this.f152d = (UserManager) context.getSystemService(UserManager.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void j() {
        synchronized (this.f150b) {
            try {
                this.f149a.clear();
                PackageManager packageManager = this.f151c.getPackageManager();
                List<UserHandle> userProfiles = this.f152d.getUserProfiles();
                if (userProfiles != null) {
                    Iterator<UserHandle> it = userProfiles.iterator();
                    while (it.hasNext()) {
                        l.n1(packageManager, it.next().getIdentifier(), i(), this.f149a);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            q(intent.getDataString(), true);
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            q(intent.getDataString(), false);
        }
    }

    private void q(String str, boolean z3) {
        if (str == null) {
            Log.d("AppListContainer", "onReceive pkg = null, return");
            return;
        }
        try {
            synchronized (this.f150b) {
                try {
                    if (f148l.booleanValue()) {
                        Log.d("AppListContainer", "update app list, isAdd " + z3 + ", " + str);
                    }
                    String replace = str.replace("package:", "");
                    if (z3) {
                        PackageManager packageManager = this.f151c.getPackageManager();
                        if (packageManager.getPackageInfo(replace, 1).activities.length == 0) {
                            Log.d("AppListContainer", "application " + replace + " has no activities, return");
                            return;
                        }
                        this.f149a.put(replace, String.valueOf(packageManager.getApplicationLabel(packageManager.getApplicationInfo(replace, 0))));
                    } else {
                        this.f149a.remove(replace);
                    }
                } finally {
                }
            }
        } catch (Exception e3) {
            Log.e("AppListContainer", "update app list failed, " + e3);
            e3.printStackTrace();
        }
    }

    public ArrayList i() {
        return this.f156h;
    }

    public ArrayMap l() {
        ArrayMap arrayMap = new ArrayMap();
        synchronized (this.f150b) {
            arrayMap.putAll(this.f149a);
        }
        return arrayMap;
    }

    public void m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.f151c.registerReceiver(this.f158j, intentFilter, 4);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.LOCALE_CHANGED");
        this.f151c.registerReceiver(this.f157i, intentFilter2, 4);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        intentFilter3.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        this.f151c.registerReceiver(this.f159k, intentFilter3, 4);
    }

    public void n() {
        this.f154f = C0305a.a().c(this.f153e);
    }

    public void o() {
        this.f151c.unregisterReceiver(this.f158j);
        this.f151c.unregisterReceiver(this.f157i);
        this.f151c.unregisterReceiver(this.f159k);
    }
}
