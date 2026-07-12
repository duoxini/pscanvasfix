package z1;

import android.content.Context;
import android.provider.Settings;
import com.oplus.content.OplusFeatureConfigManager;

/* loaded from: classes.dex */
public class j {

    /* renamed from: f, reason: collision with root package name */
    private static volatile j f14704f;

    /* renamed from: a, reason: collision with root package name */
    private Context f14705a;

    /* renamed from: b, reason: collision with root package name */
    private int f14706b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14707c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14708d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14709e = false;

    public static j a() {
        if (f14704f == null) {
            synchronized (j.class) {
                try {
                    if (f14704f == null) {
                        f14704f = new j();
                    }
                } finally {
                }
            }
        }
        return f14704f;
    }

    public void b(Context context) {
        this.f14705a = context;
    }

    public boolean c() {
        this.f14709e = OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.fold_remap_display_disabled");
        AbstractC0652e.b("ZoomSettingHelper", "isFlip: " + this.f14709e);
        return this.f14709e;
    }

    public boolean d() {
        this.f14707c = Settings.Global.getInt(this.f14705a.getContentResolver(), "oplus_system_folding_mode", 0) == 1;
        AbstractC0652e.b("ZoomSettingHelper", "isFoldScreen: " + this.f14707c);
        return this.f14707c;
    }
}
