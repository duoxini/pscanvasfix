package B1;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.graphics.OplusBlurParam;
import com.oplus.os.OplusBuild;
import com.oplus.util.OplusPlatformLevelUtils;
import com.oplus.view.OplusSmoothRoundedManager;
import com.oplus.view.ViewRootManager;
import e0.AbstractC0342a;
import t1.AbstractC0589c;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f165a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f166b;

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f167c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f168d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f169e;

    static {
        boolean z3 = false;
        int i3 = SystemProperties.getInt("persist.sys.oplus.anim_level", 0);
        f165a = i3;
        boolean z4 = SystemProperties.getBoolean("persist.wm.debug.light_os_smooth_anim", false);
        f166b = z4;
        boolean z5 = z4 || OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.adaptive_smooth_animation");
        f167c = z5;
        f168d = z5 && (i3 == 3 || i3 == 4);
        if (z5 && i3 == 4) {
            z3 = true;
        }
        f169e = z3;
    }

    private static boolean a(Context context) {
        int platformGaussianLevel = OplusPlatformLevelUtils.getInstance(context).getPlatformGaussianLevel();
        Log.d("BlurUtils", "getGaussianLevelSupport  level = " + platformGaussianLevel);
        return platformGaussianLevel != 1;
    }

    private static boolean b() {
        boolean z3 = SystemProperties.getBoolean("ro.surface_flinger.supports_background_blur", true);
        Log.d("BlurUtils", "getGaussianSupport  " + z3);
        return z3;
    }

    private static OplusBlurParam c(Context context) {
        OplusBlurParam oplusBlurParam = new OplusBlurParam();
        oplusBlurParam.setBlurType(2);
        int color = context.getColor(AbstractC0589c.f13366e);
        float[] fArr = {((color >> 16) & 255) / 255.0f, ((color >> 8) & 255) / 255.0f, (color & 255) / 255.0f, ((color >> 24) & 255) / 255.0f};
        int color2 = context.getColor(AbstractC0589c.f13367f);
        oplusBlurParam.setMaterialParams(AbstractC0342a.a(context) ? 2 : 3, fArr, new float[]{((color2 >> 16) & 255) / 255.0f, ((color2 >> 8) & 255) / 255.0f, (color2 & 255) / 255.0f, ((color2 >> 24) & 255) / 255.0f});
        if (e()) {
            oplusBlurParam.setSmoothCornerWeight(1.1f);
        }
        return oplusBlurParam;
    }

    private static boolean d() {
        return OplusBuild.VERSION.SDK_VERSION >= 34 && OplusBuild.VERSION.SDK_SUB_VERSION >= 14;
    }

    private static boolean e() {
        return d() && OplusSmoothRoundedManager.isSmoothRadiusOn();
    }

    public static boolean f(Context context) {
        return b() && a(context) && !f168d;
    }

    private static boolean g() {
        boolean a3 = y0.i.a();
        Log.d("BlurUtils", "isSupportMaterialBlur " + a3);
        return a3;
    }

    public static void h(View view, Context context) {
        if (view == null || !view.isAttachedToWindow()) {
            return;
        }
        ViewRootManager viewRootManager = new ViewRootManager(view);
        if (viewRootManager.getBackgroundBlurDrawable() == null) {
            Log.d("BlurUtils", "setBlurBackground ,viewRootManager not init, return");
            return;
        }
        if (g()) {
            viewRootManager.setBlurParams(c(context));
            viewRootManager.setBlurRadius(s.b(240.0f, context.getResources()));
        } else {
            viewRootManager.setColor(context.getColor(AbstractC0589c.f13363b));
            viewRootManager.setBlurRadius(180);
        }
        if (e()) {
            viewRootManager.setCornerRadius(s.b(24.0f, context.getResources()));
        } else {
            viewRootManager.setCornerRadius(s.b(24.0f, context.getResources()));
        }
        view.setBackground(viewRootManager.getBackgroundBlurDrawable());
        Log.d("BlurUtils", "setBlurBackground  success");
    }
}
