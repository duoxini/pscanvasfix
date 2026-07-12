package B1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.OplusActivityTaskManager;
import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.GraphicBuffer;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.TypedValue;
import android.view.ScaleGestureDetector;
import android.view.SurfaceControl;
import android.view.SurfaceSession;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewRootImpl;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.dynamicframerate.DynamicFrameRateManager;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.launcher.graphic.GaussianBlur;
import com.oplus.multiapp.OplusMultiAppManager;
import com.oplus.os.OplusBuild;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.r0;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.view.OplusSmoothRoundedManager;
import com.oplus.wrapper.view.SurfaceControl;
import com.oplus.zoomwindow.OplusZoomWindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;
import u1.C0600c;
import u1.C0601d;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: A, reason: collision with root package name */
    private static Object f198A;

    /* renamed from: h, reason: collision with root package name */
    private static WallpaperManager f208h;

    /* renamed from: i, reason: collision with root package name */
    private static i f209i;

    /* renamed from: k, reason: collision with root package name */
    private static WallpaperManager.OnColorsChangedListener f211k;

    /* renamed from: u, reason: collision with root package name */
    private static ArrayMap f221u;

    /* renamed from: y, reason: collision with root package name */
    private static Object f225y;

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f201a = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f202b = SystemProperties.getBoolean("persist.debug.flexiblewindow", false);

    /* renamed from: c, reason: collision with root package name */
    public static final int f203c = SystemProperties.getInt("persist.debug.flexiblewindow.corner_type", OplusSmoothRoundedManager.getG2CornerType());

    /* renamed from: d, reason: collision with root package name */
    public static final String f204d = SystemProperties.get("persist.debug.flexiblewindow.corner_weight", "2.5");

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f205e = OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.wms.panorama_work_station");

    /* renamed from: f, reason: collision with root package name */
    public static int f206f = SystemProperties.getInt("persist.sys.blurradius", 25);

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReference f207g = new AtomicReference();

    /* renamed from: j, reason: collision with root package name */
    private static boolean f210j = false;

    /* renamed from: l, reason: collision with root package name */
    public static final Set f212l = new a();

    /* renamed from: m, reason: collision with root package name */
    public static final Set f213m = new b();

    /* renamed from: n, reason: collision with root package name */
    public static final Set f214n = new c();

    /* renamed from: o, reason: collision with root package name */
    public static final Set f215o = new d();

    /* renamed from: p, reason: collision with root package name */
    public static Set f216p = new e();

    /* renamed from: q, reason: collision with root package name */
    public static LinkedHashMap f217q = new f(24, 0.75f, true);

    /* renamed from: r, reason: collision with root package name */
    private static final Executor f218r = Executors.newFixedThreadPool(1);

    /* renamed from: s, reason: collision with root package name */
    private static final Executor f219s = Executors.newFixedThreadPool(1);

    /* renamed from: t, reason: collision with root package name */
    private static final Executor f220t = Executors.newFixedThreadPool(1);

    /* renamed from: v, reason: collision with root package name */
    private static Rect f222v = new Rect();

    /* renamed from: w, reason: collision with root package name */
    private static float f223w = 0.0f;

    /* renamed from: B, reason: collision with root package name */
    private static SurfaceControl.Transaction f199B = null;

    /* renamed from: C, reason: collision with root package name */
    private static int f200C = -1;

    /* renamed from: z, reason: collision with root package name */
    private static Class f226z = D("com.oplus.flexiblewindow.FlexibleWindowManager");

    /* renamed from: x, reason: collision with root package name */
    private static final Class f224x = D("com.oplus.splitscreen.OplusSplitScreenManagerInternal");

    class a extends HashSet {
        a() {
            add("com.dts.freefiremax");
            add("com.tencent.tmgp.sgame");
            add("com.tencent.ig");
            add("com.tencent.tmgp.pubgmhd");
            add("com.tencent.jkchess");
            add("com.tencent.lolm");
            add("com.tencent.tmgp.cf");
            add("com.tencent.mf.uam");
            add("com.activision.callofduty.shooter");
            add("com.ludo.king");
            add("com.tencent.tmgp.sskgame");
            add("com.tencent.KiHan");
            add("com.qqgame.hlddz");
        }
    }

    class b extends HashSet {
        b() {
            add("com.heytap.tas/com.nearme.basewallet.SysSettingWarrantyActivity");
            add("com.finshell.wallet/com.nearme.common.router.RouterActivity");
            add("com.android.settings/com.oplus.settings.feature.homepage.OplusSettingsHomepageActivity");
        }
    }

    class c extends HashSet {
        c() {
        }
    }

    class d extends HashSet {
        d() {
            add("com.coloros.ocrscanner");
            add("com.oplus.pantanal.ums");
            add("com.coloros.shortcuts");
        }
    }

    class e extends HashSet {
        e() {
            add("com.oplus.aimemory/com.oplus.aimemory.business.bill.edit.BillEditDialogActivity");
            add("com.mosheng/com.mosheng.live.activity.LivePlayActivity");
        }
    }

    class f extends LinkedHashMap {
        f(int i3, float f3, boolean z3) {
            super(i3, f3, z3);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > 30;
        }
    }

    class g implements WallpaperManager.OnColorsChangedListener {
        g() {
        }

        @Override // android.app.WallpaperManager.OnColorsChangedListener
        public void onColorsChanged(WallpaperColors wallpaperColors, int i3) {
            Log.d("FlexibleWindowUtil", "Wallpaper colors changed - which: " + l.S1(i3));
            if (l.f209i == null || i3 != 1) {
                return;
            }
            l.f209i.a(wallpaperColors, i3);
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.Q1();
        }
    }

    public interface i {
        void a(WallpaperColors wallpaperColors, int i3);
    }

    private static Bitmap A(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static boolean A0(float f3, Rect rect) {
        return ((float) Math.max(Math.abs(rect.width()), Math.abs(rect.height()))) < f3 * 30.0f;
    }

    public static void A1(i iVar) {
        f209i = iVar;
    }

    public static List B(List list, Rect rect) {
        boolean z3 = rect.width() < rect.height();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Rect rect2 = (Rect) list.get(i3);
            if (z3) {
                if (rect2.right == rect.left) {
                    hashSet.add(Integer.valueOf(i3));
                } else if (rect2.left == rect.right) {
                    hashSet2.add(Integer.valueOf(i3));
                }
            } else if (rect2.bottom == rect.top) {
                hashSet.add(Integer.valueOf(i3));
            } else if (rect2.top == rect.bottom) {
                hashSet2.add(Integer.valueOf(i3));
            }
        }
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            rect3.union((Rect) list.get(((Integer) it.next()).intValue()));
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            rect4.union((Rect) list.get(((Integer) it2.next()).intValue()));
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            Rect rect5 = (Rect) list.get(i4);
            if (hashSet.contains(Integer.valueOf(i4))) {
                if (z3) {
                    arrayList.add(new Rect(rect4.right - rect5.width(), rect5.top, rect4.right, rect5.bottom));
                } else {
                    arrayList.add(new Rect(rect5.left, rect4.bottom - rect5.height(), rect5.right, rect4.bottom));
                }
            } else if (!hashSet2.contains(Integer.valueOf(i4))) {
                arrayList.add(new Rect(rect5));
            } else if (z3) {
                int i5 = rect3.left;
                arrayList.add(new Rect(i5, rect5.top, rect5.width() + i5, rect5.bottom));
            } else {
                int i6 = rect5.left;
                int i7 = rect3.top;
                arrayList.add(new Rect(i6, i7, rect5.right, rect5.height() + i7));
            }
        }
        return arrayList;
    }

    public static boolean B0() {
        try {
            Bundle splitScreenStatus = OplusActivityTaskManager.getInstance().getSplitScreenStatus("splitScreenAnimationStateChanged");
            if (splitScreenStatus != null) {
                return splitScreenStatus.getBoolean("isInFourFingerAni", false);
            }
        } catch (RemoteException unused) {
            Log.e("FlexibleWindowUtil", "isInFourFingureToCanvasAnimation getSplitScreenStatus failed");
        }
        return false;
    }

    private static boolean B1(C0601d c0601d, boolean z3) {
        return z3 && c0601d.F();
    }

    public static void C(List list, List list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Rect rect = (Rect) list.get(i3);
            Rect rect2 = (Rect) list2.get(i3);
            if (rect != null && rect2 != null) {
                int i4 = rect.top;
                int i5 = rect2.top;
                if (i4 > i5 && i4 - i5 == 1) {
                    rect.top = i4 - 1;
                }
                int i6 = rect.left;
                int i7 = rect2.left;
                if (i6 > i7 && i6 - i7 == 1) {
                    rect.left = i6 - 1;
                }
                int i8 = rect.right;
                int i9 = rect2.right;
                if (i8 < i9 && i8 - i9 == -1) {
                    rect.right = i8 + 1;
                }
                int i10 = rect.bottom;
                int i11 = rect2.bottom;
                if (i10 < i11 && i10 - i11 == -1) {
                    rect.bottom = i10 + 1;
                }
            }
        }
    }

    public static boolean C0(Context context, C0601d c0601d, int i3) {
        return (c0601d.D() || D0(context, c0601d, i3)) ? false : true;
    }

    private static boolean C1(C0601d c0601d) {
        return c0601d.u() || c0601d.H();
    }

    private static Class D(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean D0(Context context, C0601d c0601d, int i3) {
        if ((i3 != 1 && i3 != 2) || s.w(context) || !ActivityInfo.isFixedOrientationLandscape(c0601d.j())) {
            return false;
        }
        if (s.H()) {
            if (i3 != 2) {
                return false;
            }
        } else if (c0601d.D() && (!c0601d.D() || i3 != 2)) {
            return false;
        }
        return true;
    }

    private static boolean D1(C0601d c0601d) {
        return c0601d.E() && c0601d.B();
    }

    public static ActivityManager.RunningTaskInfo E(int i3) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ActivityTaskManager.getInstance().getTasks(5, true)) {
            if (runningTaskInfo.taskId == i3) {
                return runningTaskInfo;
            }
        }
        return null;
    }

    public static boolean[] E0(Context context, List list, int i3) {
        if (!U0(list)) {
            return new boolean[]{false, false};
        }
        boolean[] zArr = {true, true};
        zArr[0] = D0(context, (C0601d) list.get(0), i3);
        zArr[1] = D0(context, (C0601d) list.get(1), i3);
        return zArr;
    }

    public static void E1(Context context, List list, C0601d c0601d, int i3, final int i4, boolean z3) {
        if (list.size() < 3 || i4 == 3) {
            return;
        }
        int indexOf = list.indexOf(c0601d);
        final boolean i02 = i0(i4, list);
        Collections.sort(list, new Comparator() { // from class: B1.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int X02;
                X02 = l.X0(i4, i02, (C0601d) obj, (C0601d) obj2);
                return X02;
            }
        });
        if (!s.r(context) || z3 || c0601d == null || list.indexOf(c0601d) != 0) {
            return;
        }
        if (indexOf == 0 && i3 == i4) {
            return;
        }
        if (i4 == 5 || i4 == 7) {
            Slog.d("FlexibleWindowUtil", "sortTaskDataList adjust taskDataList order for 2->3, focusTaskData: " + c0601d);
            list.remove(c0601d);
            list.add(1, c0601d);
        }
    }

    private static Rect F(List list, int i3, float f3) {
        C0601d c0601d = (C0601d) list.get(1);
        C0601d c0601d2 = (C0601d) list.get(2);
        Rect n3 = ((C0601d) list.get(0)).n();
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = n3.width();
        rect.bottom = n3.height();
        if (i3 == 4) {
            if (c0601d.n().height() == c0601d2.n().height()) {
                rect.right = c0601d.n().width() + c0601d2.n().width() + ((int) (f3 * 10.0f));
            } else {
                float max = Math.max(c0601d.n().height(), c0601d2.n().height()) * 1.0f;
                rect.right = (int) ((c0601d.n().width() * (max / c0601d.n().height())) + (c0601d2.n().width() * (max / c0601d2.n().height())) + ((int) (f3 * 10.0f)));
            }
            rect.bottom = (int) (((rect.width() * 1.0f) / n3.width()) * n3.height());
        } else if (i3 == 6) {
            if (c0601d.n().width() == c0601d2.n().width()) {
                rect.bottom = c0601d.n().height() + ((int) (f3 * 10.0f)) + c0601d2.n().height();
            } else {
                float max2 = Math.max(c0601d.n().width(), c0601d2.n().width()) * 1.0f;
                rect.bottom = (int) ((c0601d.n().height() * (max2 / c0601d.n().width())) + (c0601d2.n().height() * (max2 / c0601d2.n().width())) + ((int) (f3 * 10.0f)));
            }
            rect.right = (int) (((rect.height() * 1.0f) / n3.height()) * n3.width());
        } else if (i3 == 7) {
            if (n3.width() != c0601d.n().width()) {
                int max3 = Math.max(n3.width(), c0601d.n().width());
                rect.bottom = (int) ((((max3 * 1.0f) / n3.width()) * n3.height()) + rect.top);
                rect.right = rect.left + max3;
            }
        } else if (i3 == 5) {
            if (n3.height() != c0601d.n().height()) {
                int max4 = Math.max(n3.height(), c0601d.n().height());
                rect.right = (int) ((((max4 * 1.0f) / n3.height()) * n3.width()) + rect.left);
                rect.bottom = rect.top + max4;
            }
        } else if (i3 == 3) {
            if (n3.height() > n3.width()) {
                int max5 = Math.max(n3.height(), Math.max(c0601d.n().height(), c0601d2.n().height()));
                rect.right = (int) ((((max5 * 1.0f) / n3.height()) * n3.width()) + rect.left);
                rect.bottom = rect.top + max5;
            } else {
                int max6 = Math.max(n3.width(), Math.max(c0601d.n().width(), c0601d2.n().width()));
                rect.bottom = (int) ((((max6 * 1.0f) / n3.width()) * n3.height()) + rect.top);
                rect.right = rect.left + max6;
            }
        }
        return rect;
    }

    public static boolean F0(Context context) {
        boolean z3 = Settings.Secure.getInt(context.getContentResolver(), "panoramic_forced_disable_state", 0) != 0;
        if (SystemProperties.getBoolean("persist.oplus.panorama.branch.enable", false) || f205e || SystemProperties.getBoolean("persist.oplus.panorama.branch.foldable.enable", false)) {
            return ((!s.H() && !s.q()) || s.p() || z3) ? false : true;
        }
        return false;
    }

    private static int F1(C0601d c0601d, C0601d c0601d2, boolean z3, int i3) {
        boolean I3 = c0601d.I();
        boolean I4 = c0601d2.I();
        Rect Z2 = Z(c0601d);
        Rect Z3 = Z(c0601d2);
        if (I3 && I4) {
            if (!z3 || Z2.width() == Z3.width()) {
                return 0;
            }
            return Z2.width() > Z3.width() ? i3 : -i3;
        }
        if (I3) {
            return -i3;
        }
        if (I4) {
            return i3;
        }
        return 0;
    }

    private static int G(List list, Rect rect) {
        if (rect.isEmpty()) {
            return -1;
        }
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Rect rect2 = (Rect) it.next();
            if (rect2.bottom <= rect.top) {
                i3 |= 8;
            }
            if (rect2.left >= rect.right) {
                i3 |= 4;
            }
            if (rect2.top >= rect.bottom) {
                i3 |= 2;
            }
            if (rect2.right <= rect.left) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public static boolean G0(List list, List list2, Context context) {
        boolean z3 = true;
        if (list != null && list2 != null && context != null && list.size() == list2.size()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                z3 &= o1((Rect) list.get(i3), (Rect) list2.get(i3), context);
            }
        }
        return z3;
    }

    private static int G1(C0601d c0601d, C0601d c0601d2, boolean z3, int i3) {
        boolean I3 = c0601d.I();
        boolean I4 = c0601d2.I();
        Rect Z2 = Z(c0601d);
        Rect Z3 = Z(c0601d2);
        if (!I3 && !I4) {
            if (!z3 || Z2.height() == Z3.height()) {
                return 0;
            }
            return Z2.height() > Z3.height() ? i3 : -i3;
        }
        if (!I3) {
            return -i3;
        }
        if (I4) {
            return 0;
        }
        return i3;
    }

    public static String H(PackageManager packageManager, ResolveInfo resolveInfo, String str, boolean z3, int i3) {
        String charSequence;
        String str2;
        if (z3) {
            str2 = OplusMultiAppManager.getInstance().getMultiAppAlias(str, i3);
            if (TextUtils.isEmpty(str2)) {
                return H(packageManager, resolveInfo, str, false, i3);
            }
        } else {
            if (packageManager != null) {
                try {
                    if (resolveInfo != null) {
                        charSequence = String.valueOf(resolveInfo.loadLabel(packageManager));
                    } else {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                        if (applicationInfo != null) {
                            charSequence = applicationInfo.loadLabel(packageManager).toString();
                        }
                    }
                    str2 = charSequence;
                } catch (Exception e3) {
                    Slog.d("FlexibleWindowUtil", "getAppName failed" + e3.getMessage());
                }
            }
            str2 = "";
        }
        return (String) Optional.ofNullable(str2).orElse("");
    }

    public static boolean H0(C0601d c0601d, ContainerView containerView) {
        int q3 = containerView.getContainerController().q();
        if (containerView.k1()) {
            if (q3 == 2) {
                if (!c0601d.I() && c0601d.p() == 1) {
                    return true;
                }
            } else if (c0601d.I() && c0601d.p() == 1) {
                return true;
            }
        }
        return false;
    }

    public static Pair H1(String str) {
        String str2;
        int myUserId = UserHandle.myUserId();
        String str3 = "";
        if (str == null) {
            return new Pair("", Integer.valueOf(myUserId));
        }
        String[] split = str.split(":");
        if (split.length > 0 && (str2 = split[0]) != null) {
            str3 = str2;
        }
        if (split.length > 1) {
            myUserId = Integer.parseInt(split[1]);
        }
        return new Pair(str3, Integer.valueOf(myUserId));
    }

    public static int I(int i3) {
        return (i3 & 32) != 0 ? Color.parseColor("#FF191919") : Color.parseColor("#FFF0F8F5");
    }

    public static boolean[] I0(List list, int i3) {
        boolean[] zArr = new boolean[2];
        if (U0(list)) {
            if (i3 == 2) {
                if (!((C0601d) list.get(0)).I() && ((C0601d) list.get(0)).p() == 1) {
                    zArr[0] = true;
                }
                if (!((C0601d) list.get(1)).I() && ((C0601d) list.get(1)).p() == 1) {
                    zArr[1] = true;
                }
            } else {
                if (((C0601d) list.get(0)).I() && ((C0601d) list.get(0)).p() == 1) {
                    zArr[0] = true;
                }
                if (((C0601d) list.get(1)).I() && ((C0601d) list.get(1)).p() == 1) {
                    zArr[1] = true;
                }
            }
        }
        return zArr;
    }

    public static void I1(Intent intent, Bundle bundle) {
        Class cls = f226z;
        if (cls == null) {
            return;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("startAnyActivity", Intent.class, Bundle.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(T(), intent, bundle);
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", "startAnyActivity: " + e3.getMessage());
        }
    }

    public static SurfaceControl J(FlexibleTaskView flexibleTaskView) {
        if (flexibleTaskView == null) {
            return null;
        }
        try {
            Field declaredField = SurfaceView.class.getDeclaredField("mBackgroundControl");
            declaredField.setAccessible(true);
            return (SurfaceControl) declaredField.get(flexibleTaskView);
        } catch (IllegalAccessException | NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static boolean J0(int i3, int i4) {
        if (i3 == i4) {
            return true;
        }
        if (ActivityInfo.isFixedOrientationLandscape(i3) && ActivityInfo.isFixedOrientationLandscape(i4)) {
            return true;
        }
        return ActivityInfo.isFixedOrientationPortrait(i3) && ActivityInfo.isFixedOrientationPortrait(i4);
    }

    public static void J1() {
        if (f210j) {
            Log.w("FlexibleWindowUtil", "Wallpaper listening already started");
            return;
        }
        WallpaperManager wallpaperManager = f208h;
        if (wallpaperManager == null) {
            Log.e("FlexibleWindowUtil", "WallpaperManager not initialized, call FlexibleWindowUtil.init() first");
            return;
        }
        try {
            wallpaperManager.addOnColorsChangedListener(f211k, null);
            f210j = true;
            Log.i("FlexibleWindowUtil", "Wallpaper listening started");
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", "Failed to start wallpaper listening", e3);
        }
    }

    private static BitmapShader K(Bitmap bitmap, Bitmap bitmap2) {
        Matrix matrix = new Matrix();
        matrix.postScale(bitmap2.getWidth() / bitmap.getWidth(), bitmap2.getHeight() / bitmap.getHeight());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        return bitmapShader;
    }

    public static boolean K0(boolean z3, ContainerView containerView, r0 r0Var, Context context) {
        C0601d l3;
        if (!z3 || context == null || containerView == null || r0Var == null || containerView.getRectList().size() != 2 || (l3 = r0Var.l(0)) == null) {
            return false;
        }
        return z3 && (g0(containerView, l3, context) & 16) != 0;
    }

    public static void K1(Intent intent, Bundle bundle, int i3, String str) {
        OplusZoomWindowManager.getInstance().startZoomWindow(intent, bundle, i3, str);
    }

    public static SurfaceControl L(SurfaceControl.Transaction transaction, FlexibleTaskView flexibleTaskView) {
        if (OplusBuild.getOplusOSVERSION() >= 34) {
            return flexibleTaskView.getViewRootImpl().updateAndGetBoundsLayer(transaction);
        }
        try {
            Object invoke = ViewRootImpl.class.getDeclaredMethod("getBoundsLayer", null).invoke(flexibleTaskView.getViewRootImpl(), null);
            if (invoke instanceof SurfaceControl) {
                return (SurfaceControl) invoke;
            }
            return null;
        } catch (IllegalAccessException e3) {
            Log.w("FlexibleWindowUtil", "getBoundsLayer illegal access " + e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w("FlexibleWindowUtil", "getBoundsLayer no such method " + e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w("FlexibleWindowUtil", "getBoundsLayer invocation target " + e5);
            return null;
        }
    }

    public static boolean L0(r0 r0Var) {
        if (r0Var.k() == 2) {
            C0601d l3 = r0Var.l(0);
            C0601d l4 = r0Var.l(1);
            if (l3 == null || l4 == null) {
                return false;
            }
            return l3.v() == l4.v() && Objects.equals(l3.k(), l4.k());
        }
        if (r0Var.k() == 3) {
            C0601d l5 = r0Var.l(0);
            C0601d l6 = r0Var.l(1);
            C0601d l7 = r0Var.l(2);
            if (l5 != null && l6 != null && l7 != null) {
                if (l5.v() == l6.v() && Objects.equals(l5.k(), l6.k())) {
                    return true;
                }
                if (l5.v() == l7.v() && Objects.equals(l5.k(), l7.k())) {
                    return true;
                }
                if (l6.v() == l7.v() && Objects.equals(l6.k(), l7.k())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void L1(int i3) {
        try {
            ActivityTaskManager.getService().takeTaskSnapshot(i3, true);
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", "takeTaskSnapshot failed:" + e3);
        }
    }

    private static List M(Context context, List list, int i3, int i4, int i5, boolean z3, Bundle bundle) {
        float f3 = context.getResources().getDisplayMetrics().density;
        ArrayList arrayList = new ArrayList();
        if (list.size() == 2) {
            if (s.w(context)) {
                m1(list, i3, context, bundle);
            }
            arrayList.addAll(N1(context, list, i3, f3));
        } else if (list.size() == 3) {
            arrayList.addAll(M1(list, i3, f3));
        } else if (list.size() == 1) {
            arrayList.add(((C0601d) list.get(0)).n());
        }
        Log.d("FlexibleWindowUtil", "layoutRectCalculate rectList:" + arrayList + "layoutOrientation: " + i3);
        Rect rect = new Rect(O1(context).v0().getWindowMetricsBounds());
        Rect rect2 = new Rect(f222v);
        if (rect2.isEmpty()) {
            rect2.set(rect);
        }
        if (z3) {
            p0(arrayList, rect2, f3);
            return arrayList;
        }
        List a02 = a0(context, arrayList, i3, i4, i5);
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList2.add(new Rect((int) ((RectF) a02.get(i6)).left, (int) ((RectF) a02.get(i6)).top, (int) ((RectF) a02.get(i6)).right, (int) ((RectF) a02.get(i6)).bottom));
        }
        return arrayList2;
    }

    public static boolean M0(int i3, int i4, boolean z3, boolean z4) {
        return (i3 != 1 || i4 == 1 || z3 || z4) ? false : true;
    }

    public static List M1(List list, int i3, float f3) {
        ArrayList arrayList = new ArrayList();
        if (list.size() != 3) {
            return arrayList;
        }
        f223w = f3;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((C0601d) list.get(i4)).q0(false);
            ((C0601d) list.get(i4)).d0(false);
            Rect n3 = ((C0601d) list.get(i4)).n();
            Rect rect = new Rect();
            Log.d("FlexibleWindowUtil", "layoutFlexibleTask i=" + i4 + " " + n3 + " layoutOrientation:" + i3);
            if (i4 == 0) {
                rect.set(F(list, i3, f3));
            } else if (i4 == 1) {
                rect.set(s1(list, i3, arrayList));
            } else if (i4 == 2) {
                if (i3 == 3) {
                    if (((C0601d) list.get(i4)).I()) {
                        rect.set(e1((Rect) arrayList.get(1), n3, true));
                    } else {
                        rect.set(Y0((Rect) arrayList.get(1), n3, true));
                    }
                } else if (i3 == 7) {
                    Rect rect2 = new Rect((Rect) arrayList.get(0));
                    rect2.union((Rect) arrayList.get(1));
                    rect.set(e1(rect2, n3, true));
                } else if (i3 == 5) {
                    Rect rect3 = new Rect((Rect) arrayList.get(0));
                    rect3.union((Rect) arrayList.get(1));
                    rect.set(Y0(rect3, n3, true));
                } else if (i3 == 6) {
                    rect.set(Y0((Rect) arrayList.get(1), n3, true));
                } else if (i3 == 4) {
                    rect.set(e1((Rect) arrayList.get(1), n3, true));
                }
            }
            arrayList.add(rect);
        }
        Log.d("FlexibleWindowUtil", "threeSplitLayout rectList:" + arrayList + ", taskDataList: " + list + ", layoutOrientation: " + i3);
        return arrayList;
    }

    public static ComponentName N(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        ActivityInfo activityInfo;
        if (intent == null || context == null) {
            return null;
        }
        ComponentName component = intent.getComponent();
        return (component != null || (resolveActivity = context.getPackageManager().resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L))) == null || (activityInfo = resolveActivity.activityInfo) == null) ? component : activityInfo.getComponentName();
    }

    public static boolean N0(ContainerView containerView) {
        if (containerView == null) {
            return false;
        }
        Rect rect = new Rect(containerView.getContainerGroupRect());
        rect.set(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1);
        Rect rectListUnion = containerView.getRectListUnion();
        if (rectListUnion == null || !rect.contains(rectListUnion)) {
            return false;
        }
        Log.d("FlexibleWindowUtil", "isStandardPocketStudio whole:" + rectListUnion);
        return true;
    }

    public static List N1(Context context, List list, int i3, float f3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean w02 = w0(context, list);
        ArrayList arrayList = new ArrayList();
        int i8 = 2;
        boolean[] zArr = {false, false};
        boolean[] zArr2 = {false, false};
        if (s.r(context) || s.H()) {
            zArr = I0(list, i3);
            zArr2 = E0(context, list, i3);
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((C0601d) list.get(i9)).N(w02);
            ((C0601d) list.get(i9)).d0(zArr2[i9]);
        }
        int i10 = 0;
        while (i10 < list.size()) {
            C0601d c0601d = (C0601d) list.get(i10);
            Rect rect = new Rect(c0601d.n());
            Rect rect2 = new Rect();
            i(rect, zArr[i10], c0601d, i3);
            float f4 = 1.0f;
            if (i10 == 0) {
                Rect rect3 = new Rect();
                i(rect3, zArr[1], (C0601d) list.get(1), i3);
                if (i3 == i8) {
                    i6 = Math.min(rect.height(), rect3.height());
                    i7 = (((C0601d) list.get(i10)).p() != i8 || ((C0601d) list.get(i10)).I()) ? (int) (((i6 * 1.0f) / rect.height()) * rect.width()) : rect.width();
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                if (i3 == 1) {
                    i7 = Math.min(rect.width(), rect3.width());
                    i6 = (((C0601d) list.get(i10)).p() == i8 && ((C0601d) list.get(i10)).I()) ? rect.height() : (int) (((i7 * 1.0f) / rect.width()) * rect.height());
                }
                i4 = 0;
                i5 = 0;
            } else if (i10 == 1) {
                C0601d c0601d2 = (C0601d) list.get(1);
                boolean z3 = c0601d2.p() != i8;
                int k02 = k0(f3);
                if (i3 == i8) {
                    if (((Rect) arrayList.get(0)).height() != rect.height() && (z3 || c0601d2.I())) {
                        f4 = ((Rect) arrayList.get(0)).height() / rect.height();
                    }
                    i4 = ((Rect) arrayList.get(0)).right + k02;
                    i5 = ((Rect) arrayList.get(0)).top;
                    i7 = i4 + ((int) (rect.width() * f4));
                    i6 = ((Rect) arrayList.get(0)).bottom;
                } else {
                    if (((Rect) arrayList.get(0)).width() != rect.width() && (z3 || !c0601d2.I())) {
                        f4 = ((Rect) arrayList.get(0)).width() / rect.width();
                    }
                    i4 = ((Rect) arrayList.get(0)).left;
                    i5 = ((Rect) arrayList.get(0)).bottom + k02;
                    i7 = ((Rect) arrayList.get(0)).right;
                    i6 = i5 + ((int) (rect.height() * f4));
                }
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
            }
            rect2.set(i4, i5, i7, i6);
            arrayList.add(rect2);
            ((C0601d) list.get(i10)).p0(false);
            i10++;
            i8 = 2;
        }
        Log.d("FlexibleWindowUtil", "twoSplitLayout rectList:" + arrayList + ", taskDataList: " + list + ", layoutOrientation: " + i3 + ", useMax: " + Arrays.toString(zArr) + ", canBeProportionalScale: " + Arrays.toString(zArr2));
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((C0601d) list.get(i11)).l0(false);
        }
        return arrayList;
    }

    public static Bitmap O(Context context, String str) {
        return j0(context, str, 64, 64);
    }

    public static void O0(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            boolean isSupportMultiInstance = OplusActivityTaskManager.getInstance().isSupportMultiInstance(str);
            synchronized (f217q) {
                f217q.put(str, Boolean.valueOf(isSupportMultiInstance));
            }
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", "getAllTopAppInfos error", e3);
        }
    }

    public static ContainerActivity O1(Context context) {
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ContainerActivity) context;
    }

    public static float P() {
        if (f203c != OplusSmoothRoundedManager.getG2CornerType()) {
            return OplusSmoothRoundedManager.getDefaultWeight();
        }
        try {
            return Float.parseFloat(f204d);
        } catch (NumberFormatException unused) {
            return 2.5f;
        }
    }

    public static boolean P0(ContainerView containerView) {
        C0601d item;
        int indexToMax = containerView.getIndexToMax();
        int indexToEnlarge = containerView.getIndexToEnlarge();
        if (indexToMax < 0 || indexToMax > 2) {
            indexToMax = -1;
        }
        if (indexToEnlarge < 0 || indexToEnlarge > 2) {
            indexToEnlarge = indexToMax;
        }
        if (indexToEnlarge == -1 || (item = containerView.getAdapter().getItem(indexToEnlarge)) == null) {
            return false;
        }
        return item.B();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
    
        if ((r3.height() * r4) < (r17.height() - 0.01d)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c0, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e6, code lost:
    
        if ((r3.height() * r4) < (r17.height() - 0.01d)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e8, code lost:
    
        r0 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0109, code lost:
    
        if ((r3.height() * r4) < (r17.height() - 0.01d)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012b, code lost:
    
        if ((r3.height() * r4) < (r17.height() - 0.01d)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013c, code lost:
    
        if ((r3.height() * r4) < (r17.height() - 0.01d)) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double[] P1(java.util.List r16, android.graphics.Rect r17, int r18, double r19, float r21) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.l.P1(java.util.List, android.graphics.Rect, int, double, float):double[]");
    }

    public static Executor Q() {
        int i3 = (f200C + 1) % 3;
        f200C = i3;
        return i3 != 1 ? i3 != 2 ? f218r : f220t : f219s;
    }

    public static boolean Q0(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "enable_launcher_taskbar", 0) == 1) {
            return !(Settings.System.getInt(context.getContentResolver(), "enable_launcher_tools_transient_entry", 0) == 1);
        }
        return false;
    }

    public static void Q1() {
        Log.d("FlexibleWindowUtil", "call updateCurrentBlurWallpaper");
        Bitmap bitmap = (Bitmap) f207g.getAndSet(s0());
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static float R(FlexibleTaskView flexibleTaskView) {
        try {
            Field declaredField = flexibleTaskView.getClass().getDeclaredField("mTaskAlpha");
            declaredField.setAccessible(true);
            return ((Float) declaredField.get(flexibleTaskView)).floatValue();
        } catch (Exception e3) {
            e3.printStackTrace();
            return 1.0f;
        }
    }

    private static boolean R0(List list) {
        if (list.size() != 3) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (((C0601d) list.get(i3)).I()) {
                return false;
            }
        }
        return true;
    }

    public static void R1(int i3) {
        if (i3 == 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new h(), 500L);
        } else {
            Q1();
        }
    }

    public static ActivityManager.RunningTaskInfo S(FlexibleTaskView flexibleTaskView) {
        if (flexibleTaskView == null) {
            return null;
        }
        try {
            Field declaredField = flexibleTaskView.getClass().getDeclaredField("mTaskInfo");
            declaredField.setAccessible(true);
            return (ActivityManager.RunningTaskInfo) declaredField.get(flexibleTaskView);
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", "getFlexibleTaskInfo error: " + e3.getMessage());
            return null;
        }
    }

    private static boolean S0(List list) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            C0601d c0601d = (C0601d) list.get(i5);
            if (c0601d.p() == 1 && !c0601d.u()) {
                i3++;
            }
            if (c0601d.p() == 2 && Math.abs(c0601d.m() - 1.78f) <= 0.01d) {
                i4++;
            }
        }
        return i3 + i4 == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String S1(int i3) {
        if (i3 == 1) {
            return "SYSTEM";
        }
        if (i3 == 2) {
            return "LOCK_SCREEN";
        }
        return "UNKNOWN(" + i3 + ")";
    }

    private static Object T() {
        if (f198A == null) {
            try {
                Method declaredMethod = f226z.getDeclaredMethod("getInstance", null);
                declaredMethod.setAccessible(true);
                f198A = declaredMethod.invoke(null, null);
            } catch (Exception e3) {
                Log.e("FlexibleWindowUtil", "getFlexibleWindowManager: " + e3.getMessage());
            }
        }
        return f198A;
    }

    private static boolean T0(List list) {
        if (list.size() != 3) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!((C0601d) list.get(i3)).I()) {
                return false;
            }
        }
        return true;
    }

    private static Drawable T1(Context context, Drawable drawable, int i3, int i4) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap A3 = A(drawable);
            Matrix matrix = new Matrix();
            matrix.postScale(i3 / intrinsicWidth, i4 / intrinsicHeight);
            return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(A3, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true));
        } catch (Exception e3) {
            Log.w("FlexibleWindowUtil", "zoomDrawable failed, reason=" + e3.getMessage());
            return drawable;
        }
    }

    private static int U(List list, C0601d c0601d) {
        if (c0601d == null) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) == c0601d) {
                i3 = i4;
            }
        }
        return i3;
    }

    private static boolean U0(List list) {
        return list != null && list.size() == 2;
    }

    public static Bitmap V(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(GaussianBlur.getInstance().generateGaussianBitmap(r1(bitmap), f206f, 1.0f, true), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean V0(ArrayList arrayList, ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        String str;
        return (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || activityInfo.applicationInfo == null || (str = activityInfo.packageName) == null || (arrayList != null && arrayList.contains(str)) || q.d(null).j(resolveInfo.activityInfo.applicationInfo.packageName)) ? false : true;
    }

    public static Bitmap W(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return null;
        }
        return GaussianBlur.getInstance().generateGaussianBitmap(bitmap, i3, 1.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W0(ArrayMap arrayMap, int i3, PackageManager packageManager, ResolveInfo resolveInfo) {
        arrayMap.put(q0(resolveInfo.activityInfo.packageName, i3), H(packageManager, resolveInfo, resolveInfo.activityInfo.packageName, OplusMultiAppManager.getInstance().isMultiAppUserId(i3), i3));
    }

    public static Drawable X(Context context, Intent intent, int i3) {
        Drawable drawable = null;
        if (intent == null) {
            return null;
        }
        try {
            String str = !TextUtils.isEmpty(intent.getPackage()) ? intent.getPackage() : (intent.getComponent() == null || TextUtils.isEmpty(intent.getComponent().getPackageName())) ? null : intent.getComponent().getPackageName();
            drawable = str != null ? context.getPackageManager().getApplicationIcon(context.getPackageManager().getApplicationInfoAsUser(str, 4202496, i3)) : context.getPackageManager().getActivityIcon(intent);
        } catch (PackageManager.NameNotFoundException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("getIconFromIntent error ");
            sb.append(e3.getMessage());
            sb.append("\nintent = ");
            sb.append(intent);
            sb.append("\nintent.getPackage = ");
            sb.append(intent.getPackage());
            sb.append("\nintent.getComponent =");
            sb.append(intent.getComponent() == null ? null : intent.getComponent().flattenToShortString());
            Log.e("FlexibleWindowUtil", sb.toString());
        }
        if (drawable != null) {
            drawable = T1(context, drawable, 240, 240);
        }
        if (i3 == 0) {
            return drawable;
        }
        try {
            drawable = context.getPackageManager().getUserBadgedIcon(drawable, UserHandle.of(i3));
        } catch (Exception unused) {
            Log.w("FlexibleWindowUtil", "getUserBadgedIcon failed");
        }
        return drawable != null ? T1(context, drawable, 240, 240) : drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int X0(int i3, boolean z3, C0601d c0601d, C0601d c0601d2) {
        if (i3 == 4) {
            return F1(c0601d, c0601d2, z3, -1);
        }
        if (i3 == 5) {
            return F1(c0601d, c0601d2, z3, 1);
        }
        if (i3 == 6) {
            return G1(c0601d, c0601d2, z3, -1);
        }
        if (i3 != 7) {
            return 0;
        }
        return G1(c0601d, c0601d2, z3, 1);
    }

    public static Intent Y(Context context, String str, int i3) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.INFO");
        intent.setPackage(str);
        List queryIntentActivitiesAsUser = packageManager.queryIntentActivitiesAsUser(intent, 0, i3);
        if (queryIntentActivitiesAsUser == null || queryIntentActivitiesAsUser.size() <= 0) {
            intent.removeCategory("android.intent.category.INFO");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            queryIntentActivitiesAsUser = packageManager.queryIntentActivitiesAsUser(intent, 0, i3);
        }
        if (queryIntentActivitiesAsUser == null || queryIntentActivitiesAsUser.size() <= 0) {
            return null;
        }
        Intent intent2 = new Intent(intent);
        intent2.setFlags(268435456);
        intent2.setClassName(((ResolveInfo) queryIntentActivitiesAsUser.get(0)).activityInfo.packageName, ((ResolveInfo) queryIntentActivitiesAsUser.get(0)).activityInfo.name);
        return intent2;
    }

    private static Rect Y0(Rect rect, Rect rect2, boolean z3) {
        Rect rect3 = new Rect();
        int i3 = rect.left;
        rect3.left = i3;
        rect3.top = rect.bottom + ((int) (f223w * 10.0f));
        if (z3) {
            rect3.right = rect.right;
            rect3.bottom = rect3.top + ((int) (rect2.height() * ((rect.width() == rect2.width() || rect2.isEmpty()) ? 1.0f : rect.width() / rect2.width())));
        } else {
            rect3.right = i3 + rect2.width();
            rect3.bottom = rect3.top + rect2.height();
        }
        return rect3;
    }

    public static Rect Z(C0601d c0601d) {
        if (c0601d != null) {
            return c0601d.B() ? c0601d.i() : c0601d.n();
        }
        return new Rect();
    }

    public static String Z0(int i3) {
        return i3 != 3 ? i3 != 4 ? i3 != 5 ? i3 != 6 ? i3 != 7 ? String.valueOf(i3) : "THREE_LAYOUT_BIG_RIGHT" : "THREE_LAYOUT_BIG_LEFT" : "THREE_LAYOUT_BIG_DOWN" : "THREE_LAYOUT_BIG_UP" : "THREE_LINE_LAYOUT";
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        if (r21 != 2) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List a0(android.content.Context r17, java.util.List r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.l.a0(android.content.Context, java.util.List, int, int, int):java.util.List");
    }

    public static List a1(Context context, List list, int i3, int i4, int i5, boolean z3, Bundle bundle) {
        if (list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        ArrayList<C0601d> arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        C0601d c0601d = (C0601d) arrayList.get(i3);
        int t3 = (i4 == 0 || arrayList.size() == 3) ? s.H() ? t(arrayList, O1(context).v0().getAdapter().t(), i4) : s(arrayList, i4) : i4;
        if (arrayList.size() == 3) {
            E1(context, arrayList, c0601d, i4, t3, false);
        }
        List M3 = M(context, arrayList, t3, i5, U(arrayList, c0601d), z3, bundle);
        ArrayList arrayList3 = new ArrayList();
        for (C0601d c0601d2 : arrayList2) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (c0601d2.f().equals(((C0601d) arrayList.get(i6)).f()) && c0601d2.f().getIntExtra("androidx.flexible.userId", 0) == ((C0601d) arrayList.get(i6)).f().getIntExtra("androidx.flexible.userId", 0)) {
                    arrayList3.add((Rect) M3.get(i6));
                }
            }
        }
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0 A[LOOP:1: B:24:0x00ba->B:26:0x00c0, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List b0(int r18, double r19, android.graphics.Rect r21, java.util.List r22, android.graphics.Rect r23) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.l.b0(int, double, android.graphics.Rect, java.util.List, android.graphics.Rect):java.util.List");
    }

    public static List b1(Context context, List list, int i3, int i4, boolean z3) {
        return a1(context, list, i3, i4, 0, z3, null);
    }

    public static Bundle c0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        Bundle bundle = new Bundle();
        if (runningTaskInfo == null) {
            return bundle;
        }
        try {
            Field field = runningTaskInfo.getClass().getSuperclass().getField("mOplusExtraBundle");
            if (field != null) {
                field.setAccessible(true);
                return (Bundle) field.get(runningTaskInfo);
            }
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", " getOplusExtraBundle has exception = " + e3);
        }
        return bundle;
    }

    public static List c1(Context context, List list, int i3, boolean z3) {
        return b1(context, list, i3, 0, z3);
    }

    public static String d0(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (intent.getComponent() != null) {
            return intent.getComponent().getPackageName();
        }
        if (TextUtils.isEmpty(intent.getPackage())) {
            return null;
        }
        return intent.getPackage();
    }

    public static List d1(Context context, List list, int i3, int i4, boolean z3) {
        List<Rect> a12 = a1(context, list, i3, i4, 0, z3, null);
        if (s.B()) {
            for (Rect rect : a12) {
                rect.offset(0, O1(context).G0());
                if (O1(context).D0().left > 0) {
                    rect.offset(O1(context).D0().left, 0);
                }
            }
        }
        return a12;
    }

    private static Rect e0(C0601d c0601d, int i3) {
        Rect g3 = i3 == 2 ? c0601d.g() : c0601d.h();
        return g3.isEmpty() ? c0601d.n() : g3;
    }

    private static Rect e1(Rect rect, Rect rect2, boolean z3) {
        Rect rect3 = new Rect();
        int i3 = rect.right + ((int) (f223w * 10.0f));
        rect3.left = i3;
        rect3.top = rect.top;
        if (z3) {
            rect3.right = rect3.left + ((int) (rect2.width() * ((rect.height() == rect2.height() || rect2.isEmpty()) ? 1.0f : rect.height() / rect2.height())));
            rect3.bottom = rect.bottom;
        } else {
            rect3.right = i3 + rect2.width();
            rect3.bottom = rect3.top + rect2.height();
        }
        return rect3;
    }

    public static void f(Bundle bundle) {
        Class cls = f224x;
        if (cls == null) {
            return;
        }
        try {
            Log.d("FlexibleWindowUtil", "notifyAnimationStateChange start " + bundle);
            Method declaredMethod = cls.getDeclaredMethod("notifyAnimationStateChange", Bundle.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(m0(), bundle);
        } catch (Exception e3) {
            Log.e("FlexibleWindowUtil", "notifyAnimationStateChange failed " + bundle);
            e3.printStackTrace();
        }
    }

    public static Rect f0(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static boolean f1(Context context) {
        return !z0(context) || Q0(context);
    }

    public static void g(int i3, Rect rect, float f3) {
        Class cls = f224x;
        if (cls == null) {
            return;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("startZoomWindowFromSplit", Integer.TYPE, Rect.class, Float.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(m0(), Integer.valueOf(i3), rect, Float.valueOf(f3));
        } catch (Throwable unused) {
        }
    }

    public static int g0(ContainerView containerView, C0601d c0601d, Context context) {
        if (c0601d != null && context != null && containerView != null) {
            int q3 = c0601d.q();
            boolean z3 = c0601d.z();
            String k3 = c0601d.k();
            r0 containerController = containerView.getContainerController();
            if (containerController != null && !TextUtils.isEmpty(k3)) {
                boolean r3 = s.r(context);
                boolean H3 = s.H();
                String h02 = h0(containerController);
                boolean z4 = (r3 || H3) && (k3.equals(h02) || (!TextUtils.isEmpty(h02) && z3));
                r0 = z4 ? q3 : 0;
                if (f201a.booleanValue()) {
                    Log.d("FlexibleWindowUtil", "getSingleAppSplitDisableResizeType  disableType=" + r0 + ",allow=" + z4 + ",appInnerPkg=" + h02 + ",isFold=" + r3 + ",isTab=" + H3 + "," + k3 + ",configType=" + q3 + ",hasTask=" + z3);
                }
            }
        }
        return r0;
    }

    public static int g1(List list) {
        if (list.isEmpty() || list.size() < 2) {
            return -1;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            C0601d c0601d = (C0601d) list.get(i5);
            if ((ActivityInfo.isFixedOrientationPortrait(c0601d.j()) || c0601d.j() == 5) && !c0601d.y()) {
                return c0601d.j();
            }
            if (ActivityInfo.isFixedOrientationLandscape(c0601d.j())) {
                if (c0601d.y()) {
                    i4++;
                } else {
                    i3++;
                }
            }
        }
        if (i3 != 2) {
            return (i3 == 1 && i4 == i3) ? 11 : -1;
        }
        return 11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0091, code lost:
    
        if (r20 != 8) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d7, code lost:
    
        if (r20 != 8) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a8, code lost:
    
        if (r18.contains(r5) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00aa, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:
    
        if (r18.contains(r5) == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double h(java.util.List r16, android.graphics.Rect r17, android.graphics.Rect r18, android.graphics.Rect r19, int r20, double r21, float r23) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.l.h(java.util.List, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect, int, double, float):double");
    }

    public static String h0(r0 r0Var) {
        if (r0Var.k() == 2) {
            C0601d l3 = r0Var.l(0);
            C0601d l4 = r0Var.l(1);
            if (l3 == null || l4 == null) {
                return null;
            }
            if (l3.v() == l4.v() && Objects.equals(l3.k(), l4.k())) {
                return l3.k();
            }
        }
        if (r0Var.k() == 3) {
            C0601d l5 = r0Var.l(0);
            C0601d l6 = r0Var.l(1);
            C0601d l7 = r0Var.l(2);
            if (l5 != null && l6 != null && l7 != null) {
                if (l5.v() == l6.v() && Objects.equals(l5.k(), l6.k())) {
                    return l5.k();
                }
                if (l5.v() == l7.v() && Objects.equals(l5.k(), l7.k())) {
                    return l5.k();
                }
                if (l6.v() == l7.v() && Objects.equals(l6.k(), l7.k())) {
                    return l6.k();
                }
            }
        }
        return null;
    }

    public static void h1(int i3, int i4, Bundle bundle) {
        Class cls = f226z;
        if (cls == null) {
            return;
        }
        try {
            Class cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("notifyFlexibleTaskEvent", cls2, cls2, Bundle.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(T(), Integer.valueOf(i3), Integer.valueOf(i4), bundle);
        } catch (Throwable th) {
            Log.e("FlexibleWindowUtil", "notifyFlexibleTaskEvent: " + th.getMessage());
        }
    }

    private static void i(Rect rect, boolean z3, C0601d c0601d, int i3) {
        if (C1(c0601d)) {
            rect.set(c0601d.n());
            return;
        }
        if (B1(c0601d, z3)) {
            rect.set(c0601d.i());
            return;
        }
        if (D1(c0601d)) {
            rect.set(e0(c0601d, i3));
        } else if (z3) {
            rect.set(c0601d.i());
        } else {
            rect.set(c0601d.n());
        }
    }

    private static boolean i0(int i3, List list) {
        boolean z3 = false;
        Rect Z2 = Z((C0601d) list.get(0));
        Rect Z3 = Z((C0601d) list.get(1));
        Rect Z4 = Z((C0601d) list.get(2));
        if (i3 == 5 && T0(list) && ((Z2.width() + Z3.width()) * 1.0f) / Z4.width() > 2.1f) {
            z3 = true;
        }
        if (i3 == 7 && R0(list) && ((Z2.height() + Z3.height()) * 1.0f) / Z4.height() > 2.1f) {
            z3 = true;
        }
        if (i3 == 6 && R0(list) && ((Z3.height() + Z4.height()) * 1.0f) / Z2.height() > 2.1f) {
            z3 = true;
        }
        if (i3 == 4 && T0(list) && ((Z3.width() + Z4.width()) * 1.0f) / Z2.width() > 2.1f) {
            return true;
        }
        return z3;
    }

    public static List i1(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        while (!arrayList2.isEmpty()) {
            int i3 = -1;
            for (int i4 = 0; i4 < arrayList2.size() && !arrayList.isEmpty(); i4++) {
                Rect rect = (Rect) arrayList2.get(i4);
                Rect rect2 = (Rect) arrayList.get(arrayList.size() - 1);
                if (rect.centerX() == rect2.centerX() || rect.centerY() == rect2.centerY()) {
                    if (i3 != -1) {
                        Rect rect3 = (Rect) arrayList2.get(i3);
                        if (rect.top + rect.left >= rect3.top + rect3.left) {
                        }
                    }
                    i3 = i4;
                }
            }
            if (i3 == -1) {
                int i5 = 0;
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    Rect rect4 = (Rect) arrayList2.get(i6);
                    Rect rect5 = (Rect) arrayList2.get(i5);
                    if (rect4.top + rect4.left < rect5.top + rect5.left) {
                        i5 = i6;
                    }
                }
                i3 = i5;
            }
            arrayList.add((Rect) arrayList2.remove(i3));
        }
        return arrayList;
    }

    public static List j(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            List tasks = ActivityTaskManager.getInstance().getTasks(5, true);
            if (f221u == null) {
                f221u = new ArrayMap();
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0601d c0601d = (C0601d) it.next();
                int v3 = c0601d.v();
                String k3 = c0601d.k();
                ArrayMap arrayMap = f221u;
                if (arrayMap == null || !arrayMap.containsKey(k3) || ((Boolean) f221u.get(k3)).booleanValue()) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("androidx.activity.ShowUnSupportToast", false);
                    int s3 = c0601d.s();
                    if (s3 > 0) {
                        bundle.putInt("taskId", s3);
                    }
                    boolean isSupportZoomMode = OplusZoomWindowManager.getInstance().isSupportZoomMode(k3, v3, "IOplusZoomWindowManager", bundle);
                    ArrayMap arrayMap2 = f221u;
                    if (arrayMap2 != null) {
                        arrayMap2.put(k3, Boolean.valueOf(isSupportZoomMode));
                    }
                    if (!isSupportZoomMode) {
                        arrayList.add(c0601d);
                    } else if (s3 > 0) {
                        Iterator it2 = tasks.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) it2.next();
                                if (runningTaskInfo.taskId == c0601d.s()) {
                                    ComponentName componentName = runningTaskInfo.topActivity;
                                    String flattenToString = componentName != null ? componentName.flattenToString() : null;
                                    ArrayMap arrayMap3 = f221u;
                                    if (arrayMap3 != null && arrayMap3.containsKey(flattenToString) && !((Boolean) f221u.get(k3)).booleanValue()) {
                                        arrayList.add(c0601d);
                                        break;
                                    }
                                    boolean isSupportZoomMode2 = OplusZoomWindowManager.getInstance().isSupportZoomMode(flattenToString, v3, "IOplusZoomWindowManager", bundle);
                                    ArrayMap arrayMap4 = f221u;
                                    if (arrayMap4 != null) {
                                        arrayMap4.put(flattenToString, Boolean.valueOf(isSupportZoomMode2));
                                    }
                                    if (!isSupportZoomMode2) {
                                        arrayList.add(c0601d);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    arrayList.add(c0601d);
                }
            }
        }
        return arrayList;
    }

    public static Bitmap j0(Context context, String str, int i3, int i4) {
        String str2;
        PackageManager packageManager = context.getPackageManager();
        int i5 = (int) (i3 * context.getResources().getDisplayMetrics().density);
        int i6 = (int) (i4 * context.getResources().getDisplayMetrics().density);
        Log.i("FlexibleWindowUtil", "### iconDrawable w:" + i5 + " h:" + i6);
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        if (str == null) {
            return createBitmap;
        }
        try {
            String[] split = str.split(":");
            Drawable applicationIcon = (split.length <= 0 || (str2 = split[0]) == null) ? null : packageManager.getApplicationIcon(str2);
            if (split.length > 1) {
                applicationIcon = packageManager.getUserBadgedIcon(applicationIcon, UserHandle.of(Integer.parseInt(split[1])));
            }
            if (applicationIcon != null) {
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
            }
            return createBitmap;
        } catch (Exception e3) {
            e3.printStackTrace();
            return createBitmap;
        }
    }

    public static Rect j1(String str) {
        if (str == null) {
            return new Rect();
        }
        String[] split = str.split(" ");
        if (split.length != 4) {
            return new Rect();
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : split) {
                arrayList.add(Integer.valueOf(str2));
            }
            return new Rect(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Integer) arrayList.get(2)).intValue(), ((Integer) arrayList.get(3)).intValue());
        } catch (NumberFormatException unused) {
            Log.e("FlexibleWindowUtil", "parseRect number format error");
            return new Rect();
        }
    }

    public static boolean k(C0601d c0601d, Bundle bundle) {
        if (c0601d == null) {
            return false;
        }
        if (f221u == null) {
            f221u = new ArrayMap();
        }
        int v3 = c0601d.v();
        String k3 = c0601d.k();
        boolean q3 = q(k3, v3, bundle);
        ActivityManager.RunningTaskInfo E3 = E(c0601d.s());
        if (E3 == null) {
            return false;
        }
        ComponentName componentName = E3.topActivity;
        String flattenToString = componentName != null ? componentName.flattenToString() : null;
        boolean q4 = q(flattenToString, v3, bundle);
        if (q3) {
            Log.d("FlexibleWindowUtil", "isPkgSupportZoomMode:" + q4 + " componentName:" + flattenToString + " mUserId:" + v3);
            return q4;
        }
        if (q4) {
            Log.d("FlexibleWindowUtil", "isPkgSupportZoomMode: supportComponent");
            return true;
        }
        Log.d("FlexibleWindowUtil", "isPkgSupportZoomMode:" + q3 + " pkg:" + k3 + " mUserId:" + v3);
        return false;
    }

    public static int k0(float f3) {
        return s.H() ? (((int) (f3 * 8.0f)) / 2) * 2 : (int) (f3 * 8.0f);
    }

    private static float k1(Point point, Point point2) {
        int i3 = point.x;
        int i4 = point2.x;
        int i5 = point.y;
        int i6 = point2.y;
        return (float) Math.sqrt(((i3 - i4) * (i3 - i4)) + ((i5 - i6) * (i5 - i6)));
    }

    public static SurfaceControl l(SurfaceControl surfaceControl, String str, String str2, boolean z3, int i3, int i4, SurfaceSession surfaceSession) {
        return new SurfaceControl.Builder(surfaceSession).setParent(surfaceControl).setBufferSize(i3, i4).setFormat(2).setName(str).setCallsite(str2).setHidden(z3).build();
    }

    public static int l0(Context context) {
        return s.H() ? (((int) TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics())) / 2) * 2 : (int) TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics());
    }

    public static int l1(Rect rect, Rect rect2) {
        if (rect2.bottom < rect.top) {
            return 0;
        }
        if (rect2.top > rect.bottom) {
            return 1;
        }
        if (rect2.right < rect.left) {
            return 2;
        }
        return rect2.left > rect.right ? 3 : -1;
    }

    public static SurfaceControl m(SurfaceControl surfaceControl, String str, String str2, boolean z3, SurfaceSession surfaceSession) {
        return new SurfaceControl.Builder(surfaceSession).setContainerLayer().setParent(surfaceControl).setName(str).setCallsite(str2).setHidden(z3).build();
    }

    private static Object m0() {
        if (f225y == null) {
            try {
                Method declaredMethod = f224x.getDeclaredMethod("getInstance", null);
                declaredMethod.setAccessible(true);
                f225y = declaredMethod.invoke(null, null);
            } catch (Throwable unused) {
            }
        }
        return f225y;
    }

    private static void m1(List list, int i3, Context context, Bundle bundle) {
        if (bundle != null && s.w(context) && i3 == 1 && g1(list) == 11 && bundle.getBoolean("KEY_REPLACE_ANIMATION")) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((C0601d) it.next()).p0(true);
            }
            Log.d("FlexibleWindowUtil", "predict orientation will change to land");
        }
    }

    public static Bundle n(List list, int i3, Bundle bundle) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Intent intent = (Intent) it.next();
                if (intent != null) {
                    intent.putExtra("key_flexible_top_activity_enable", true);
                }
            }
        }
        Log.d("FlexibleWindowUtil", "calculateFlexibleWindowBoundList " + list + " " + Debug.getCallers(3));
        return FlexibleWindowManager.getInstance().calculateFlexibleWindowBounds(list, i3, bundle);
    }

    public static C0601d n0(Context context, Intent intent, int i3) {
        Rect rect;
        Rect D02;
        if (f201a.booleanValue()) {
            Log.d("FlexibleWindowUtil", "getTaskDataFromIntent for pkg: " + d0(intent) + ", appOrientation is: " + i3);
        }
        if (intent == null) {
            return null;
        }
        if (f1(context) && context.isUiContext() && (D02 = O1(context).D0()) != null && (D02.height() != 0 || D02.width() != 0)) {
            intent.putExtra("canvas_nav_bar_rect", D02);
        }
        if (O1(context).v0().getAdapter().n() == 3) {
            intent.putExtra("isThreeSplitTogether", true);
        }
        intent.putExtra("androidx.activity.LaunchScenario", 2);
        Bundle o3 = o(intent, i3, 0);
        intent.removeExtra("isThreeSplitTogether");
        int i4 = o3.getInt("androidx.flexible.ResizeMode", 0);
        intent.putExtra("ps_config_display_bound", new Rect());
        if (i4 == 0) {
            Log.e("FlexibleWindowUtil", "not support pocket studio");
            try {
                intent.addFlags(268435456);
                I1(intent, new Bundle());
            } catch (Exception e3) {
                Log.e("FlexibleWindowUtil", "exception when startActivity" + e3.getMessage());
            }
            return null;
        }
        Rect rect2 = (Rect) o3.get("androidx.flexible.LaunchBounds");
        int i5 = o3.getInt("key_single_app_split_disable_resize", 0);
        boolean z3 = o3.getBoolean("key_single_app_split_is_package_has_inner_task", false);
        Log.d("FlexibleWindowUtil", "startFlexibleTaskView:" + intent + " rect:" + rect2 + " resizeMode:" + i4 + ",isPkgHasInnerTask:" + z3 + ",singleAppDisableResizeConfigType:" + i5);
        C0601d c0601d = new C0601d(rect2, 0, intent);
        c0601d.h0(i5);
        c0601d.Y(z3);
        c0601d.L((Rect) o3.get("androidx.flexible.LaunchFillInBounds"));
        c0601d.Q(o3.getBoolean("androidx.flexible.IsOriginalResizable", false));
        c0601d.b0((Rect) o3.get("androidx.flexible.LaunchPredictBounds"));
        c0601d.a0((Rect) o3.get("androidx.flexible.LaunchPredictMaxBounds"));
        c0601d.Z((Rect) o3.get("androidx.flexible.LaunchPredictFillInBounds"));
        c0601d.U((Rect) o3.get("androidx.flexible.LaunchHorizontalBounds"));
        c0601d.V((Rect) o3.get("androidx.flexible.LaunchVerticalBounds"));
        if (o3.get("androidx.flexible.LaunchPredictResizeableMode") != null) {
            c0601d.c0(o3.getInt("androidx.flexible.LaunchPredictResizeableMode"));
        }
        if (rect2.isEmpty()) {
            Log.e("FlexibleWindowUtil", "rect is empty");
            return c0601d;
        }
        c0601d.g0(i4);
        if (i4 == 2) {
            c0601d.e0(((Float) o3.get("androidx.flexible.CompatRatio")).floatValue());
            c0601d.K((Rect) o3.get("androidx.flexible.LaunchMaxBounds"));
        }
        c0601d.W((Rect) o3.get("androidx.flexible.LaunchMaxBounds"));
        if ((i4 == 1 || i4 == 3) && (rect = (Rect) o3.get("androidx.flexible.LaunchPreferredBounds")) != null && !rect.isEmpty()) {
            c0601d.P(true);
        }
        c0601d.X(o3.getInt("androidx.flexible.ScreenOrientation", -2));
        c0601d.i0((Rect) o3.get("androidx.flexible.StableRect"));
        c0601d.s0((Rect) o3.get("androidx.flexible.WindowMetricsBounds"));
        c0601d.R(o3.getBoolean("androidx.activity.ParallelWindowMode", false));
        return c0601d;
    }

    public static void n1(final PackageManager packageManager, final int i3, final ArrayList arrayList, final ArrayMap arrayMap) {
        if (packageManager == null || arrayMap == null) {
            return;
        }
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        List queryIntentActivitiesAsUser = packageManager.queryIntentActivitiesAsUser(intent, 0, i3);
        if (queryIntentActivitiesAsUser == null || queryIntentActivitiesAsUser.isEmpty()) {
            return;
        }
        queryIntentActivitiesAsUser.stream().filter(new Predicate() { // from class: B1.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean V02;
                V02 = l.V0(arrayList, (ResolveInfo) obj);
                return V02;
            }
        }).distinct().forEach(new Consumer() { // from class: B1.k
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                l.W0(arrayMap, i3, packageManager, (ResolveInfo) obj);
            }
        });
    }

    public static Bundle o(Intent intent, int i3, int i4) {
        if (intent != null) {
            intent.putExtra("key_flexible_top_activity_enable", true);
        }
        Log.d("FlexibleWindowUtil", "calculateFlexibleWindowBounds " + intent + " " + Debug.getCallers(3));
        return FlexibleWindowManager.getInstance().calculateFlexibleWindowBounds(intent, i3, i4);
    }

    public static List o0(Context context, List list, int i3) {
        Bundle bundle;
        ArrayList parcelableArrayList;
        char c3;
        Rect rect;
        Rect D02;
        if (f201a.booleanValue()) {
            Log.d("FlexibleWindowUtil", "getTaskDataListForMultiIntent for pkg: " + list + ", layoutOrientation is: " + i3);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Intent intent = (Intent) it.next();
            if (intent != null) {
                if (f1(context) && context.isUiContext() && (D02 = O1(context).D0()) != null && (D02.height() != 0 || D02.width() != 0)) {
                    intent.putExtra("canvas_nav_bar_rect", D02);
                }
                intent.putExtra("ps_config_display_bound", context.getResources().getConfiguration().windowConfiguration.getBounds());
            }
        }
        List list2 = null;
        if (i3 == 3 && s.I(context) && context.getResources().getDisplayMetrics().widthPixels >= 2176) {
            bundle = new Bundle();
            bundle.putBoolean("isThreeSplitTogether", true);
        } else {
            bundle = null;
        }
        Bundle n3 = n(list, i3, bundle);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Intent intent2 = (Intent) it2.next();
            if (intent2 != null) {
                intent2.putExtra("ps_config_display_bound", new Rect());
            }
        }
        if (n3 == null || (parcelableArrayList = n3.getParcelableArrayList("androidx.flexible.layout.info.list", Bundle.class)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < parcelableArrayList.size()) {
            Bundle bundle2 = (Bundle) parcelableArrayList.get(i4);
            Intent intent3 = (Intent) list.get(i4);
            int i5 = bundle2.getInt("androidx.flexible.ResizeMode", 0);
            if (i5 == 0) {
                Log.e("FlexibleWindowUtil", "not support pocket studio");
                try {
                    intent3.addFlags(268435456);
                    Bundle bundle3 = new Bundle();
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("androidx.activity.LaunchScenario", 0);
                    bundle3.putBundle("androidx.activity.extra", bundle4);
                    I1(intent3, bundle3);
                } catch (Exception e3) {
                    Log.e("FlexibleWindowUtil", "exception when startActivity" + e3.getMessage());
                }
                return list2;
            }
            Rect rect2 = (Rect) bundle2.get("androidx.flexible.LaunchBounds");
            int i6 = bundle2.getInt("key_single_app_split_disable_resize", 0);
            boolean z3 = bundle2.getBoolean("key_single_app_split_is_package_has_inner_task", false);
            Log.d("FlexibleWindowUtil", "getTaskDataListForMultiIntent:" + intent3 + " rect:" + rect2 + " resizeMode:" + i5 + ",isPkgHasInnerTask:" + z3 + " multiBundle:" + n3 + ",singleAppDisableResizeConfigType:" + i6);
            C0601d c0601d = new C0601d(rect2, 0, intent3);
            c0601d.h0(i6);
            c0601d.Y(z3);
            c0601d.L((Rect) bundle2.get("androidx.flexible.LaunchFillInBounds"));
            c0601d.Q(bundle2.getBoolean("androidx.flexible.IsOriginalResizable", false));
            c0601d.b0((Rect) bundle2.get("androidx.flexible.LaunchPredictBounds"));
            c0601d.a0((Rect) bundle2.get("androidx.flexible.LaunchPredictMaxBounds"));
            c0601d.Z((Rect) bundle2.get("androidx.flexible.LaunchPredictFillInBounds"));
            c0601d.U((Rect) bundle2.get("androidx.flexible.LaunchHorizontalBounds"));
            c0601d.V((Rect) bundle2.get("androidx.flexible.LaunchVerticalBounds"));
            if (bundle2.get("androidx.flexible.LaunchPredictResizeableMode") != null) {
                c0601d.c0(bundle2.getInt("androidx.flexible.LaunchPredictResizeableMode"));
            }
            arrayList.add(c0601d);
            if (rect2.isEmpty()) {
                Log.e("FlexibleWindowUtil", "rect is empty");
                c3 = 3;
            } else {
                c0601d.g0(i5);
                if (i5 == 2) {
                    c0601d.e0(((Float) bundle2.get("androidx.flexible.CompatRatio")).floatValue());
                    c0601d.K((Rect) bundle2.get("androidx.flexible.LaunchMaxBounds"));
                }
                c0601d.W((Rect) bundle2.get("androidx.flexible.LaunchMaxBounds"));
                c3 = 3;
                if ((i5 == 1 || i5 == 3) && (rect = (Rect) bundle2.get("androidx.flexible.LaunchPreferredBounds")) != null && !rect.isEmpty()) {
                    c0601d.P(true);
                }
                c0601d.X(bundle2.getInt("androidx.flexible.ScreenOrientation", -2));
                c0601d.i0((Rect) bundle2.get("androidx.flexible.StableRect"));
                c0601d.s0((Rect) bundle2.get("androidx.flexible.WindowMetricsBounds"));
                c0601d.R(bundle2.getBoolean("androidx.activity.ParallelWindowMode", false));
            }
            i4++;
            list2 = null;
        }
        return arrayList;
    }

    private static boolean o1(Rect rect, Rect rect2, Context context) {
        float f3 = context.getResources().getDisplayMetrics().density * 2.0f;
        return ((float) Math.abs(rect.left - rect2.left)) <= f3 && ((float) Math.abs(rect.top - rect2.top)) <= f3 && ((float) Math.abs(rect.right - rect2.right)) <= f3 && ((float) Math.abs(rect.bottom - rect2.bottom)) <= f3;
    }

    public static float p(float f3, float f4, float f5) {
        return ((f4 - f5) * f3) + f5;
    }

    private static List p0(List list, Rect rect, float f3) {
        int i3;
        char c3 = 0;
        Rect rect2 = new Rect(0, 0, 0, 0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rect2.union((Rect) it.next());
        }
        if (rect.contains(rect2)) {
            return list;
        }
        float width = ((rect.width() - 16) * 1.0f) / rect2.width();
        float height = ((rect.height() - 16) * 1.0f) / rect2.height();
        if (width > height) {
            width = height;
            c3 = 1;
        } else if (width < height) {
            c3 = 2;
        }
        int i4 = 8;
        if (c3 == 1) {
            rect2.scale(width);
            i4 = (rect.width() - rect2.width()) / 2;
            i3 = 8;
        } else if (c3 == 2) {
            rect2.scale(width);
            i3 = (rect.height() - rect2.height()) / 2;
        } else {
            i3 = 8;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Rect rect3 = (Rect) it2.next();
            rect3.scale(width);
            rect3.offset(i4, i3);
        }
        return list;
    }

    public static void p1(int i3) {
        try {
            Class<?> cls = FlexibleWindowManager.getInstance().getClass();
            Class cls2 = Integer.TYPE;
            Class cls3 = Boolean.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("resetFlexibleTask", cls2, cls3, cls3, cls3);
            declaredMethod.setAccessible(true);
            FlexibleWindowManager flexibleWindowManager = FlexibleWindowManager.getInstance();
            Integer valueOf = Integer.valueOf(i3);
            Boolean bool = Boolean.FALSE;
            declaredMethod.invoke(flexibleWindowManager, valueOf, bool, bool, Boolean.TRUE);
        } catch (Exception e3) {
            Log.w("FlexibleWindowUtil", "removeEmbeddedList exception:" + e3);
        }
    }

    private static boolean q(String str, int i3, Bundle bundle) {
        if (str == null) {
            return false;
        }
        ArrayMap arrayMap = f221u;
        if (arrayMap != null && arrayMap.containsKey(str)) {
            return ((Boolean) f221u.get(str)).booleanValue();
        }
        boolean isSupportZoomMode = OplusZoomWindowManager.getInstance().isSupportZoomMode(str, i3, "FlexibleWindowUtil", bundle);
        ArrayMap arrayMap2 = f221u;
        if (arrayMap2 != null) {
            arrayMap2.put(str, Boolean.valueOf(isSupportZoomMode));
        }
        return isSupportZoomMode;
    }

    public static String q0(String str, int i3) {
        if (i3 == 0) {
            return str;
        }
        return str + ":" + i3;
    }

    public static void q1() {
        ArrayMap arrayMap = f221u;
        if (arrayMap != null) {
            arrayMap.clear();
            f221u = null;
        }
    }

    public static int r(List list, Point point) {
        float f3 = Float.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Rect rect = (Rect) list.get(i4);
            if (rect.contains(point.x, point.y)) {
                return i4;
            }
            float x3 = x(point, rect);
            if (x3 < f3) {
                i3 = i4;
                f3 = x3;
            }
        }
        return i3;
    }

    public static void r0(Context context) {
        f208h = WallpaperManager.getInstance(context.getApplicationContext());
        f211k = new g();
    }

    private static Bitmap r1(Bitmap bitmap) {
        int ceil = (int) Math.ceil(bitmap.getWidth() * 0.2f);
        int ceil2 = (int) Math.ceil(bitmap.getHeight() * 0.2f);
        Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, ceil, ceil2);
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Paint paint = new Paint();
        paint.setShader(K(copy, createBitmap));
        canvas.drawRect(rectF, paint);
        return createBitmap;
    }

    private static int s(List list, int i3) {
        int i4;
        if (list.size() == 2) {
            return ((C0601d) list.get(0)).I() ? 2 : 1;
        }
        if (list.size() != 3) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (((C0601d) list.get(i7)).I()) {
                i6++;
            } else {
                i5++;
            }
        }
        if ((i5 == 3 || i6 == 3) ? S0(list) : false) {
            return 3;
        }
        if (i6 >= 2) {
            i4 = 5;
            if (i3 == 5 || i3 == 4) {
                return i3;
            }
        } else {
            i4 = 7;
            if (i3 == 7 || i3 == 6) {
                return i3;
            }
        }
        return i4;
    }

    public static Bitmap s0() {
        try {
            return (Bitmap) FlexibleWindowManager.class.getMethod("getCurrentBlurWallpaper", null).invoke(FlexibleWindowManager.getInstance(), null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static Rect s1(List list, int i3, List list2) {
        Rect rect = new Rect();
        Rect n3 = ((C0601d) list.get(1)).n();
        C0601d c0601d = (C0601d) list.get(2);
        if (i3 == 5) {
            rect.set(e1((Rect) list2.get(0), n3, true));
        } else if (i3 == 7) {
            rect.set(Y0((Rect) list2.get(0), n3, true));
        } else if (i3 == 3) {
            if (((C0601d) list.get(1)).I()) {
                rect.set(e1((Rect) list2.get(0), n3, true));
            } else {
                rect.set(Y0((Rect) list2.get(0), n3, true));
            }
        } else if (i3 == 6) {
            Rect rect2 = new Rect(n3);
            if (n3.width() != c0601d.n().width()) {
                int max = Math.max(n3.width(), c0601d.n().width());
                rect2.bottom = (int) ((((max * 1.0f) / n3.width()) * n3.height()) + rect2.top);
                rect2.right = rect2.left + max;
            }
            rect.set(e1((Rect) list2.get(0), rect2, false));
        } else if (i3 == 4) {
            Rect rect3 = new Rect(n3);
            if (n3.height() != c0601d.n().height()) {
                int max2 = Math.max(n3.height(), c0601d.n().height());
                rect3.right = (int) ((((max2 * 1.0f) / n3.height()) * n3.width()) + rect3.left);
                rect3.bottom = rect3.top + max2;
            }
            rect.set(Y0((Rect) list2.get(0), rect3, false));
        }
        return rect;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (((u1.C0601d) r10.get(0)).I() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        if (((u1.C0601d) r10.get(0)).I() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ba, code lost:
    
        if (((u1.C0601d) r10.get(0)).I() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a7, code lost:
    
        if (((u1.C0601d) r10.get(0)).I() != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int t(java.util.List r10, int r11, int r12) {
        /*
            int r0 = r10.size()
            r1 = 1
            r2 = 2
            if (r0 != r2) goto L10
            if (r11 != r1) goto Ld
            r12 = r1
            goto Lbd
        Ld:
            r12 = r2
            goto Lbd
        L10:
            int r0 = r10.size()
            r3 = 3
            if (r0 != r3) goto Lbd
            r0 = 0
            r4 = r0
            r5 = r4
            r6 = r5
        L1b:
            int r7 = r10.size()
            if (r4 >= r7) goto L35
            java.lang.Object r7 = r10.get(r4)
            u1.d r7 = (u1.C0601d) r7
            boolean r7 = r7.I()
            if (r7 == 0) goto L30
            int r6 = r6 + 1
            goto L32
        L30:
            int r5 = r5 + 1
        L32:
            int r4 = r4 + 1
            goto L1b
        L35:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "horizontalCount is: "
            r4.append(r7)
            r4.append(r5)
            java.lang.String r7 = "; verticalCount is: "
            r4.append(r7)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "FlexibleWindowUtil"
            android.util.Log.d(r7, r4)
            r4 = 7
            r7 = 6
            r8 = 5
            r9 = 4
            if (r11 != r2) goto L8e
            if (r6 != r3) goto L5e
        L5b:
            r12 = r3
            goto Lbd
        L5e:
            if (r6 == 0) goto L62
            if (r6 != r2) goto L78
        L62:
            if (r12 == r9) goto L78
            if (r12 == r8) goto L78
            if (r6 != r2) goto L76
            java.lang.Object r10 = r10.get(r0)
            u1.d r10 = (u1.C0601d) r10
            boolean r10 = r10.I()
            if (r10 != 0) goto L76
        L74:
            r12 = r9
            goto Lbd
        L76:
            r12 = r8
            goto Lbd
        L78:
            if (r6 != r1) goto Lbd
            if (r12 == r7) goto Lbd
            if (r12 == r4) goto Lbd
            java.lang.Object r10 = r10.get(r0)
            u1.d r10 = (u1.C0601d) r10
            boolean r10 = r10.I()
            if (r10 == 0) goto L8c
        L8a:
            r12 = r7
            goto Lbd
        L8c:
            r12 = r4
            goto Lbd
        L8e:
            if (r11 != r1) goto Lbd
            if (r5 != r3) goto L93
            goto L5b
        L93:
            if (r5 == 0) goto L97
            if (r5 != r2) goto Laa
        L97:
            if (r12 == r7) goto Laa
            if (r12 == r4) goto Laa
            if (r5 != r2) goto L8c
            java.lang.Object r10 = r10.get(r0)
            u1.d r10 = (u1.C0601d) r10
            boolean r10 = r10.I()
            if (r10 == 0) goto L8c
            goto L8a
        Laa:
            if (r5 != r1) goto Lbd
            if (r12 == r9) goto Lbd
            if (r12 == r8) goto Lbd
            java.lang.Object r10 = r10.get(r0)
            u1.d r10 = (u1.C0601d) r10
            boolean r10 = r10.I()
            if (r10 != 0) goto L76
            goto L74
        Lbd:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.l.t(java.util.List, int, int):int");
    }

    public static boolean t0(int[] iArr, List list, float[] fArr, Bundle bundle) {
        try {
            return ((Boolean) FlexibleWindowManager.class.getMethod("toggleMultiFlexibleWindowFromCanvas", int[].class, List.class, float[].class, Bundle.class).invoke(FlexibleWindowManager.getInstance(), iArr, list, fArr, bundle)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static void t1(SurfaceControl surfaceControl, int i3, boolean z3) {
        if (DynamicFrameRateManager.getDynamicFrameRateType() == 0) {
            return;
        }
        if (!DynamicFrameRateManager.isTypeEnable(i3)) {
            Slog.d("FlexibleWindowUtil", "setFrameRateIfNeed invalid typeId return!");
            return;
        }
        if (surfaceControl == null || !surfaceControl.isValid()) {
            return;
        }
        if (f199B == null) {
            f199B = new SurfaceControl.Transaction();
        }
        boolean frameRate = DynamicFrameRateManager.setFrameRate(surfaceControl, f199B, i3, z3 ? -1 : -2, (Bundle) null);
        if (f201a.booleanValue()) {
            Log.d("FlexibleWindowUtil", "setFrameRate for ps animation, type: " + DynamicFrameRateManager.getDynamicFrameRateType() + ", animationTypeId: " + i3 + ", animStart: " + z3 + ", result: " + frameRate);
        }
        f199B.apply();
    }

    public static boolean u() {
        return OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.fold") || OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.tablet");
    }

    public static boolean u0() {
        return OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.canvas.avoid_display_cutout_in_split");
    }

    public static void u1(View view, int i3, boolean z3) {
        if (DynamicFrameRateManager.getDynamicFrameRateType() == 0) {
            return;
        }
        if (!DynamicFrameRateManager.isTypeEnable(i3)) {
            Log.d("FlexibleWindowUtil", "setFrameRateIfNeed invalid typeId return!");
            return;
        }
        if (view == null) {
            return;
        }
        boolean frameRate = DynamicFrameRateManager.setFrameRate(view, i3, z3 ? -1 : -2, (Bundle) null);
        if (f201a.booleanValue()) {
            Log.d("FlexibleWindowUtil", "setFrameRate for ps animation, type: " + DynamicFrameRateManager.getDynamicFrameRateType() + ", animationTypeId: " + i3 + ", animStart: " + z3 + ", result: " + frameRate);
        }
    }

    public static Bitmap v(Bitmap bitmap, int i3, int i4, float f3) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        matrix.reset();
        matrix.postScale(i3 / createBitmap.getWidth(), i4 / createBitmap.getHeight());
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
    }

    public static boolean v0(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        Resources resources = applicationContext != null ? applicationContext.getResources() : null;
        Configuration configuration = resources != null ? resources.getConfiguration() : null;
        boolean z3 = ((configuration != null ? configuration.uiMode : 0) & 48) == 32;
        Log.d("FlexibleWindowUtil", "isDarkMode() isDark=" + z3 + "," + configuration);
        return z3;
    }

    public static void v1(ScaleGestureDetector scaleGestureDetector, boolean z3, int i3) {
        if (scaleGestureDetector == null) {
            Log.e("FlexibleWindowUtil", "setOptimizeMultiFingerScaling: detector is null");
            return;
        }
        try {
            Method method = scaleGestureDetector.getClass().getMethod("setOptimizeMultiFingerScaling", Boolean.TYPE, Integer.TYPE);
            method.setAccessible(true);
            method.invoke(scaleGestureDetector, Boolean.valueOf(z3), Integer.valueOf(i3));
            Log.d("FlexibleWindowUtil", "setOptimizeMultiFingerScaling called successfully: optimize=" + z3 + ", minPointerCount=" + i3);
        } catch (IllegalAccessException e3) {
            Log.e("FlexibleWindowUtil", "setOptimizeMultiFingerScaling illegal access", e3);
        } catch (NoSuchMethodException e4) {
            Log.e("FlexibleWindowUtil", "setOptimizeMultiFingerScaling method not found", e4);
        } catch (InvocationTargetException e5) {
            Log.e("FlexibleWindowUtil", "setOptimizeMultiFingerScaling invocation failed", e5);
        } catch (Exception e6) {
            Log.e("FlexibleWindowUtil", "setOptimizeMultiFingerScaling unexpected error", e6);
        }
    }

    public static SurfaceControl w(Context context, String str, SurfaceControl.Transaction transaction, String str2, int[] iArr, int i3, int i4) {
        if (context == null || iArr.length != 2) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        float f3 = context.getResources().getDisplayMetrics().density;
        textPaint.setTextSize(16.0f * f3);
        textPaint.setColor(i3);
        textPaint.setTypeface(Typeface.create("sans-en-medium", 0));
        Rect rect = new Rect();
        textPaint.getTextBounds(str2, 0, str2.length(), rect);
        float width = rect.width();
        float height = rect.height();
        if (width > i4 - ((int) ((12.0f * f3) * 2.0f))) {
            textPaint.getTextBounds("...", 0, 3, new Rect());
            str2 = str2.substring(0, (int) (str2.length() * (((r13 - r3.width()) * 1.0f) / width))) + "...";
            textPaint.getTextBounds(str2, 0, str2.length(), rect);
            width = rect.width();
            height = rect.height();
        }
        float f4 = 6.0f * f3;
        int i5 = (int) (width + f4);
        int i6 = (int) (height + (f3 * 4.0f));
        iArr[0] = i5;
        iArr[1] = i6;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f5 = fontMetrics.bottom;
        float f6 = (i6 / 2) + (((f5 - fontMetrics.top) / 2.0f) - f5);
        SurfaceControl build = new SurfaceControl.Builder().setName(str).setBufferSize(i5, i6).build();
        Picture picture = new Picture();
        picture.beginRecording(i5, i6).drawText(str2, f4 / 2.0f, f6, textPaint);
        picture.endRecording();
        Bitmap createBitmap = Bitmap.createBitmap(picture);
        if (createBitmap != null) {
            transaction.setBuffer(build, createBitmap.getHardwareBuffer()).setColorSpace(build, ColorSpace.get(ColorSpace.Named.SRGB));
            Slog.d("FlexibleWindowUtil", "createTextSurfaceControl:" + build + " over, width=" + i5 + ", height=" + i6);
        }
        return build;
    }

    public static boolean w0(Context context, List list) {
        if (!s.w(context) || !s.B() || list == null || list.size() != 2) {
            return false;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            C0601d c0601d = (C0601d) list.get(i5);
            if (ActivityInfo.isFixedOrientationLandscape(c0601d.j()) && !c0601d.y()) {
                i3++;
            } else if (!ActivityInfo.isFixedOrientationLandscape(c0601d.j()) && c0601d.y()) {
                i4++;
            }
        }
        return i3 == 1 && i4 == i3;
    }

    public static void w1(ContainerActivity containerActivity) {
        if (s.B() && s.w(containerActivity)) {
            ArrayList arrayList = new ArrayList();
            C0600c adapter = containerActivity.v0().getAdapter();
            for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                arrayList.add(adapter.getItem(i3));
            }
            int g12 = g1(arrayList);
            containerActivity.setRequestedOrientation(g12);
            if (f201a.booleanValue()) {
                Log.d("FlexibleWindowUtil", "setOrientation: " + g12);
            }
        }
    }

    private static float x(Point point, Rect rect) {
        int i3 = point.y;
        if (i3 > rect.top && i3 < rect.bottom) {
            return Math.min(Math.abs(rect.left - point.x), Math.abs(rect.right - point.x));
        }
        int i4 = point.x;
        return (i4 <= rect.left || i4 >= rect.right) ? Math.min(Math.min(k1(point, new Point(rect.left, rect.top)), k1(point, new Point(rect.right, rect.top))), Math.min(k1(point, new Point(rect.left, rect.bottom)), k1(point, new Point(rect.right, rect.bottom)))) : Math.min(Math.abs(r1 - i3), Math.abs(rect.bottom - point.y));
    }

    public static boolean x0(C0601d c0601d) {
        ActivityManager.RunningTaskInfo E3 = E(c0601d.s());
        if (E3 == null) {
            return false;
        }
        ComponentName componentName = E3.topActivity;
        return f216p.contains(componentName != null ? componentName.flattenToString() : null);
    }

    public static SurfaceControl.Transaction x1(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f3) {
        y1(transaction, surfaceControl, f3, P());
        return transaction;
    }

    public static void y(Bitmap bitmap, Canvas canvas, int i3, int i4, int i5, int i6, int i7) {
        if (bitmap != null) {
            if (i7 == 0) {
                canvas.drawBitmap(bitmap, (i5 - i3) * 0.5f, (i6 - i4) * 0.5f, (Paint) null);
                return;
            }
            if (i7 == 1) {
                canvas.drawBitmap(bitmap, 0.0f, (i6 - i4) * 0.5f, (Paint) null);
                return;
            }
            if (i7 == 2) {
                canvas.drawBitmap(bitmap, i5 - i3, (i6 - i4) * 0.5f, (Paint) null);
            } else if (i7 == 3) {
                canvas.drawBitmap(bitmap, (i5 - i3) * 0.5f, 0.0f, (Paint) null);
            } else {
                if (i7 != 4) {
                    return;
                }
                canvas.drawBitmap(bitmap, i5 - i3, i6 - i4, (Paint) null);
            }
        }
    }

    public static boolean y0(r0 r0Var) {
        for (int i3 = 0; i3 < r0Var.k(); i3++) {
            C0601d l3 = r0Var.l(i3);
            if (l3 != null && f215o.contains(l3.k())) {
                return true;
            }
        }
        return false;
    }

    public static SurfaceControl.Transaction y1(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, float f3, float f4) {
        SurfaceControl.Transaction.setSmoothCornerRadius(transaction, surfaceControl, f3, f4, f203c);
        return transaction;
    }

    public static void z(android.view.SurfaceControl surfaceControl, SurfaceControl.Transaction transaction, Bitmap bitmap, int i3, int i4, int i5, int i6) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i3, i4);
        if (i5 == 16777215) {
            Bitmap bitmap2 = (Bitmap) f207g.get();
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                try {
                    beginRecording.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(0, 0, i3, i4), (Paint) null);
                } catch (Exception e3) {
                    Log.e("FlexibleWindowUtil", "Bitmap background failed, fallback to previous operation", e3);
                    if (i5 != -1) {
                        beginRecording.drawColor(-16777216);
                    }
                }
            }
        } else if (i5 != -1) {
            Log.w("FlexibleWindowUtil", "Bitmap invalid, using previous operation");
            beginRecording.drawColor(i5);
        }
        if (bitmap != null) {
            y(bitmap, beginRecording, bitmap.getWidth(), bitmap.getHeight(), i3, i4, i6);
        }
        picture.endRecording();
        transaction.setBuffer(surfaceControl, GraphicBuffer.createFromHardwareBuffer(Bitmap.createBitmap(picture).getHardwareBuffer()));
        transaction.setColorSpace(surfaceControl, ColorSpace.get(ColorSpace.Named.SRGB));
    }

    public static boolean z0(Context context) {
        int i3 = Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0);
        return i3 == 2 || i3 == 3;
    }

    public static void z1(Intent intent, ComponentName componentName) {
        if (componentName == null || intent == null || f213m.contains(componentName.flattenToShortString())) {
            return;
        }
        intent.putExtra("key_flexible_top_activity", componentName);
    }
}
