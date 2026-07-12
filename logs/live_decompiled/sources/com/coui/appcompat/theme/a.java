package com.coui.appcompat.theme;

import M1.c;
import M1.h;
import M1.l;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.OplusBaseConfiguration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseIntArray;
import h0.AbstractC0371a;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import oplus.content.res.OplusExtraConfiguration;
import z0.AbstractC0647b;
import z0.C0646a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static String f9271c;

    /* renamed from: d, reason: collision with root package name */
    private static int f9272d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f9273e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f9274f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f9275g;

    /* renamed from: a, reason: collision with root package name */
    private SparseIntArray f9276a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    private HashMap f9277b = new HashMap();

    /* renamed from: com.coui.appcompat.theme.a$a, reason: collision with other inner class name */
    private static class C0116a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f9278a = new a();
    }

    static {
        f9271c = c() ? "com.oplus.inner.content.res.ConfigurationWrapper" : C0646a.b().a();
        f9273e = n();
        f9275g = p();
        f9274f = o() && AbstractC0647b.c() > 0;
        f9272d = f();
    }

    private boolean b() {
        try {
            Class.forName("android.content.res.OplusBaseConfiguration");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean c() {
        try {
            Class.forName("com.oplus.inner.content.res.ConfigurationWrapper");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String str = (String) method.invoke(null, "ro.oplus.theme.version");
            int parseInt = TextUtils.isEmpty(str) ? 0 : Integer.parseInt(str.trim());
            if (parseInt != 0) {
                return parseInt;
            }
            String str2 = (String) method.invoke(null, C0646a.b().e());
            return !TextUtils.isEmpty(str2) ? Integer.parseInt(str2.trim()) : parseInt;
        } catch (Exception e3) {
            AbstractC0371a.c("COUIThemeOverlay", "getCompatVersion e: " + e3);
            return 0;
        }
    }

    private OplusExtraConfiguration g(Configuration configuration) {
        OplusBaseConfiguration oplusBaseConfiguration = (OplusBaseConfiguration) s(OplusBaseConfiguration.class, configuration);
        if (oplusBaseConfiguration == null) {
            return null;
        }
        return oplusBaseConfiguration.mOplusExtraConfiguration;
    }

    public static a h() {
        return C0116a.f9278a;
    }

    private int i(Context context, String str, String str2) {
        if (context.getResources() == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(context.getPackageName())) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    private int j(Context context, int i3, int i4) {
        if (i3 > 0 && context.getResources() != null) {
            Resources resources = context.getResources();
            int i5 = f9272d;
            if (i5 > 12000) {
                TypedArray obtainTypedArray = resources.obtainTypedArray(M1.b.f1341b);
                r0 = obtainTypedArray.length() >= i3 ? obtainTypedArray.getResourceId(i3 - 1, 0) : 0;
                obtainTypedArray.recycle();
            } else if (i5 == 12000) {
                int i6 = i(context, f9275g ? "coui_theme_arrays_ids_patch_r" : "coui_theme_arrays_ids_patch_o", "array");
                if (f9273e && i4 == 1048576) {
                    i6 = M1.b.f1341b;
                }
                if (i6 != 0) {
                    TypedArray obtainTypedArray2 = resources.obtainTypedArray(i6);
                    r0 = obtainTypedArray2.length() >= i3 ? obtainTypedArray2.getResourceId(i3 - 1, 0) : 0;
                    obtainTypedArray2.recycle();
                }
            } else {
                int i7 = i(context, f9275g ? "coui_theme_arrays_ids_repatch_r" : "coui_theme_arrays_ids_repatch_o", "array");
                if (i7 != 0) {
                    TypedArray obtainTypedArray3 = resources.obtainTypedArray(i7);
                    r0 = obtainTypedArray3.length() >= i3 ? obtainTypedArray3.getResourceId(i3 - 1, 0) : 0;
                    obtainTypedArray3.recycle();
                }
            }
        }
        return r0;
    }

    private boolean k(Context context) {
        String packageName = context.getPackageName();
        File file = new File("my_company/media/theme/");
        if (!file.exists() || TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (new File(file, packageName).exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        String string = Settings.System.getString(context.getContentResolver(), "custom_theme_path_setting");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return new File(string, packageName).exists();
    }

    private boolean l(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        OplusExtraConfiguration g3 = g(context.getResources().getConfiguration());
        int i3 = g3 != null ? g3.mUserId : 0;
        String str = "data/theme/";
        if (i3 > 0) {
            str = "data/theme/" + i3;
        }
        return new File(str, packageName).exists();
    }

    private static boolean n() {
        String str = Build.MANUFACTURER;
        return str.equals(String.valueOf(new char[]{'O', 'P', 'P', 'O'})) || str.equals(String.valueOf(new char[]{'O', 'p', 'p', 'o'}));
    }

    private static boolean o() {
        String str = Build.MANUFACTURER;
        return str.equals(String.valueOf(new char[]{'O', 'n', 'e', 'P', 'l', 'u', 's'})) || str.equals(String.valueOf(new char[]{'O', 'N', 'E', 'P', 'L', 'U', 'S'})) || str.equals(String.valueOf(new char[]{'G', 'A', 'L', 'I', 'L', 'E', 'I'})) || str.equals(String.valueOf(new char[]{'g', 'a', 'l', 'i', 'l', 'e', 'i'})) || str.equals(String.valueOf(new char[]{'F', 'A', 'R', 'A', 'D', 'A', 'Y'})) || str.equals(String.valueOf(new char[]{'f', 'a', 'r', 'a', 'd', 'a', 'y'}));
    }

    private static boolean p() {
        String str = Build.MANUFACTURER;
        return str.equals(String.valueOf(new char[]{'R', 'E', 'A', 'L', 'M', 'E'})) || str.equals(String.valueOf(new char[]{'R', 'e', 'a', 'l', 'm', 'e'})) || str.equals(String.valueOf(new char[]{'r', 'e', 'a', 'l', 'm', 'e'}));
    }

    private void q(Context context) {
        int j3;
        int i3;
        if (context == null || m(context)) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{c.f1353K});
        int integer = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        long e3 = e(context.getResources().getConfiguration());
        int i4 = (int) (65535 & e3);
        int i5 = (int) (16711680 & e3);
        boolean z3 = f9272d < 12000;
        if (e3 != 0) {
            if (i4 == 0 && i5 == 0) {
                return;
            }
            if (i5 == 131072) {
                r(h.f1482a, l.f1501a);
                return;
            }
            if (i5 != 65536) {
                if (i5 == 262144) {
                    j3 = M1.b.f1340a;
                } else if (i5 == 0 || i5 == 1048576) {
                    j3 = j(context, i4, i5);
                } else {
                    i3 = 0;
                    i4 = -1;
                }
                int i6 = integer - 1;
                i3 = j3;
                i4 = i6;
            } else if (f9274f) {
                i3 = i(context, z3 ? "coui_theme_arrays_single_repatch_p" : "coui_theme_arrays_single_patch_p", "array");
            } else {
                i3 = M1.b.f1342c;
            }
            if (i3 == 0 || i4 == -1) {
                return;
            }
            TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i3);
            if (obtainTypedArray.length() > i4) {
                r(h.f1482a, obtainTypedArray.getResourceId(i4, 0));
            }
            obtainTypedArray.recycle();
        }
    }

    private Object s(Class cls, Object obj) {
        if (obj == null || !cls.isInstance(obj)) {
            return null;
        }
        return obj;
    }

    public void a(Context context) {
        synchronized (this.f9276a) {
            try {
                d();
                q(context);
                for (int i3 = 0; i3 < this.f9276a.size(); i3++) {
                    context.setTheme(this.f9276a.valueAt(i3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d() {
        synchronized (this.f9276a) {
            this.f9276a.clear();
        }
    }

    public long e(Configuration configuration) {
        if (!b()) {
            return 0L;
        }
        OplusExtraConfiguration g3 = g(configuration);
        if (g3 != null) {
            return g3.mMaterialColor;
        }
        try {
            Class<?> cls = Class.forName(f9271c);
            if (cls.getDeclaredConstructor(null).newInstance(null) != null) {
                return ((Long) cls.getMethod("getMaterialColor", Configuration.class).invoke(null, configuration)).longValue();
            }
            return 0L;
        } catch (Exception e3) {
            AbstractC0371a.c("COUIThemeOverlay", "getCOUITheme e: " + e3);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "COUIThemeOverlay"
            android.content.res.Resources r1 = r12.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            r2 = 0
            if (r1 == 0) goto La9
            boolean r3 = r11.b()
            if (r3 != 0) goto L15
            goto La9
        L15:
            r3 = 0
            r4 = 0
            android.content.res.Resources r6 = r12.getResources()     // Catch: java.lang.Exception -> L2b
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch: java.lang.Exception -> L2b
            oplus.content.res.OplusExtraConfiguration r6 = r11.g(r6)     // Catch: java.lang.Exception -> L2b
            if (r6 == 0) goto L45
            long r7 = r6.mThemeChangedFlags     // Catch: java.lang.Exception -> L29
            goto L46
        L29:
            r7 = move-exception
            goto L2d
        L2b:
            r7 = move-exception
            r6 = r3
        L2d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "get extra config failed : "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.d(r0, r7)
        L45:
            r7 = r4
        L46:
            if (r6 != 0) goto L84
            java.lang.String r6 = com.coui.appcompat.theme.a.f9271c     // Catch: java.lang.Exception -> L6f
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Exception -> L6f
            java.lang.Object r9 = r6.newInstance()     // Catch: java.lang.Exception -> L6f
            if (r9 == 0) goto L84
            java.lang.String r9 = "getThemeChangedFlags"
            java.lang.Class<android.content.res.Configuration> r10 = android.content.res.Configuration.class
            java.lang.Class[] r10 = new java.lang.Class[]{r10}     // Catch: java.lang.Exception -> L6f
            java.lang.reflect.Method r6 = r6.getMethod(r9, r10)     // Catch: java.lang.Exception -> L6f
            java.lang.Object[] r9 = new java.lang.Object[]{r1}     // Catch: java.lang.Exception -> L6f
            java.lang.Object r3 = r6.invoke(r3, r9)     // Catch: java.lang.Exception -> L6f
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Exception -> L6f
            long r7 = r3.longValue()     // Catch: java.lang.Exception -> L6f
            goto L84
        L6f:
            r3 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "isRejectTheme e: "
            r6.append(r9)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            h0.AbstractC0371a.c(r0, r3)
        L84:
            r9 = 1
            long r9 = r9 & r7
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L9d
            r9 = 256(0x100, double:1.265E-321)
            long r6 = r7 & r9
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L98
            boolean r11 = r11.k(r12)
            goto L9e
        L98:
            boolean r11 = r11.l(r12)
            goto L9e
        L9d:
            r11 = r2
        L9e:
            if (r11 == 0) goto La9
            int r11 = r1.uiMode
            r11 = r11 & 48
            r12 = 32
            if (r11 == r12) goto La9
            r2 = 1
        La9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.theme.a.m(android.content.Context):boolean");
    }

    public void r(int i3, int i4) {
        synchronized (this.f9276a) {
            this.f9276a.put(i3, i4);
        }
    }
}
