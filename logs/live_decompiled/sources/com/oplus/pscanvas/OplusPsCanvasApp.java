package com.oplus.pscanvas;

import B1.l;
import B1.q;
import android.app.Application;
import android.app.WallpaperColors;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import java.util.Set;
import w1.C0622f;
import z1.j;

/* loaded from: classes.dex */
public class OplusPsCanvasApp extends Application {

    /* renamed from: e, reason: collision with root package name */
    public static final Set f10166e = new ArraySet();

    class a implements l.i {
        a(OplusPsCanvasApp oplusPsCanvasApp) {
        }

        @Override // B1.l.i
        public void a(WallpaperColors wallpaperColors, int i3) {
            l.R1(0);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(Settings.Global.getString(OplusPsCanvasApp.this.getApplicationContext().getContentResolver(), "ps_app_use_max"))) {
                return;
            }
            Settings.Global.putString(OplusPsCanvasApp.this.getApplicationContext().getContentResolver(), "ps_app_use_max", null);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (l.u()) {
            l.R1(1);
            l.r0(this);
            l.A1(new a(this));
            l.J1();
        }
        j.a().b(getApplicationContext());
        FlexibleSettingHelper.getInstance().initContext(getApplicationContext());
        C0622f.k(getApplicationContext()).e();
        q.d(getApplicationContext());
        C0305a.a().b(new b());
    }
}
