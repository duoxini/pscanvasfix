package B1;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.OplusWindowManager;
import android.view.WindowManagerGlobal;
import com.oplus.app.OplusWindowInfo;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.List;
import java.util.Locale;
import u1.C0601d;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f244a = SystemProperties.getBoolean("ro.oplus.lightos", false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f245b = SystemProperties.getInt("persist.sys.oplus.anim_level", 1);

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f246c = SystemProperties.getBoolean("persist.sys.pocket_studio_plus", true);

    /* renamed from: d, reason: collision with root package name */
    private static final int f247d = d();

    /* renamed from: e, reason: collision with root package name */
    private static final String f248e = s.class.getSimpleName();

    public static boolean A(C0601d c0601d, FlexibleTaskView flexibleTaskView, ContainerView containerView) {
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        if (c0601d.B()) {
            return flexibleTaskView.getWidth() < windowMetricsBounds.width() / 2 || flexibleTaskView.getHeight() < windowMetricsBounds.height() / 2 || c0601d.H();
        }
        return false;
    }

    public static boolean B() {
        return f246c;
    }

    public static boolean C() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static boolean D(Rect rect) {
        return rect.width() <= rect.height();
    }

    public static boolean E(int i3, ContainerView containerView) {
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        FlexibleTaskView flexibleTaskView = containerView.q0(i3).getFlexibleTaskView();
        return flexibleTaskView.getWidth() < windowMetricsBounds.width() / 2 || flexibleTaskView.getHeight() < windowMetricsBounds.height() / 2;
    }

    public static boolean F(Rect rect, ContainerView containerView) {
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        return rect.width() < windowMetricsBounds.width() / 2 || rect.height() < windowMetricsBounds.height() / 2;
    }

    public static boolean G(C0601d c0601d, Rect rect, Rect rect2) {
        if (c0601d == null) {
            return false;
        }
        if (c0601d.p() != 2) {
            rect = c0601d.n();
        }
        return rect.width() < rect2.width() / 2 || rect.height() < rect2.height() / 2;
    }

    public static boolean H() {
        return f247d == 2;
    }

    public static boolean I(Context context) {
        return H() && i(context.getResources().getConfiguration()) == 2;
    }

    public static boolean J(Context context) {
        return H() && i(context.getResources().getConfiguration()) == 1;
    }

    public static boolean K(Context context) {
        return o1.b.f(context.getContentResolver(), "com.android.launcher.light_animator");
    }

    public static int a(Context context, float f3) {
        return (int) TypedValue.applyDimension(1, f3, context.getResources().getDisplayMetrics());
    }

    public static int b(float f3, Resources resources) {
        return (int) TypedValue.applyDimension(1, f3, resources.getDisplayMetrics());
    }

    public static float c(float f3) {
        float f4 = 1.0f - f3;
        Log.d(f248e, "dampingRatio bounce: " + f3 + ", dampingRatio " + f4);
        if (f4 <= 0.0f) {
            return 1.0f;
        }
        return f4;
    }

    private static int d() {
        if (OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.fold_remap_display_disabled") && OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.fold")) {
            return 3;
        }
        if (OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.fold")) {
            return 1;
        }
        return OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.tablet") ? 2 : 0;
    }

    public static int e(Context context) {
        if (context == null) {
            Log.w(f248e, "getFixedSmallestWidthDp invalid context");
            return -1;
        }
        int min = Math.min((int) (j(context) / context.getResources().getDisplayMetrics().density), (int) (h(context) / context.getResources().getDisplayMetrics().density));
        int i3 = context.getResources().getConfiguration().smallestScreenWidthDp;
        if (l.f201a.booleanValue()) {
            Log.d(f248e, "getFixedSmallestWidthDp calculateSmallestWidthDp : " + min + " configWidthDp : " + i3);
        }
        return Math.max(min, i3);
    }

    public static int f(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier <= 0 || !l()) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static String g(List list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String k3 = ((C0601d) list.get(i3)).k();
            if (i3 != list.size() - 1) {
                sb.append(k3);
                sb.append("&&");
            } else {
                sb.append(k3);
            }
        }
        return sb.toString();
    }

    public static int h(Context context) {
        return context.getResources().getConfiguration().windowConfiguration.getMaxBounds().height();
    }

    public static int i(Configuration configuration) {
        return configuration.screenWidthDp > configuration.screenHeightDp ? 2 : 1;
    }

    public static int j(Context context) {
        return context.getResources().getConfiguration().windowConfiguration.getMaxBounds().width();
    }

    public static float k(float f3) {
        float pow = (float) Math.pow(6.283185307179586d / (f3 == 0.0f ? 1.0f : f3), 2.0d);
        Log.d(f248e, "stiffness response: " + f3 + ", stiffness:" + pow);
        if (pow <= 0.0f) {
            return 1500.0f;
        }
        return pow;
    }

    public static boolean l() {
        try {
            return WindowManagerGlobal.getWindowManagerService().hasNavigationBar(0);
        } catch (Exception e3) {
            AbstractC0652e.i("hasSoftNavigationBar() " + e3.toString());
            return false;
        }
    }

    public static boolean m(int i3) {
        return i3 == 1 || i3 == 18 || i3 == 31 || i3 == 38 || i3 == 41 || i3 == 45 || i3 == 51 || i3 == 56 || i3 == 61 || i3 == 68 || i3 == 6 || i3 == 7 || i3 == 13 || i3 == 14;
    }

    public static boolean n(int i3) {
        return i3 == 1 || i3 == 7 || i3 == 14 || i3 == 31 || i3 == 41 || i3 == 51 || i3 == 61;
    }

    public static boolean o() {
        List<OplusWindowInfo> list;
        try {
            list = new OplusWindowManager().getAllVisibleWindowInfo();
        } catch (RemoteException unused) {
            Log.e(f248e, "isDemonstrationPenWindowVisible, RemoteException");
            list = null;
        }
        if (list == null) {
            return false;
        }
        for (OplusWindowInfo oplusWindowInfo : list) {
            if ("com.oplus.healthservice".equals(oplusWindowInfo.packageName) && "DemonstrationPenWindow".equals(oplusWindowInfo.windowName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean p() {
        return f247d == 3;
    }

    public static boolean q() {
        return f247d == 1;
    }

    public static boolean r(Context context) {
        return f247d == 1 && t(context);
    }

    public static boolean s(Context context) {
        return f247d == 1 && !t(context);
    }

    public static boolean t(Context context) {
        return e(context) >= 600;
    }

    public static boolean u(C0601d c0601d, Rect rect, int i3) {
        if (c0601d == null || rect == null) {
            return false;
        }
        Rect n3 = c0601d.n();
        return n3.equals(rect) || new Rect(n3.left, n3.top, n3.right, n3.bottom - i3).equals(rect);
    }

    public static boolean v(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public static boolean w(Context context) {
        int e3 = e(context);
        return e3 > 300 && e3 < 600;
    }

    public static boolean x(Context context) {
        return w(context) && i(context.getResources().getConfiguration()) == 1;
    }

    public static boolean y(Context context) {
        return i(context.getResources().getConfiguration()) == 1;
    }

    public static boolean z(int i3, ContainerView containerView) {
        if (w(containerView.getContext())) {
            return false;
        }
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        C0601d taskData = containerView.q0(i3).getTaskData();
        if (!taskData.B()) {
            return false;
        }
        FlexibleTaskView flexibleTaskView = containerView.q0(i3).getFlexibleTaskView();
        return flexibleTaskView.getWidth() < windowMetricsBounds.width() / 2 || flexibleTaskView.getHeight() < windowMetricsBounds.height() / 2 || taskData.H();
    }
}
