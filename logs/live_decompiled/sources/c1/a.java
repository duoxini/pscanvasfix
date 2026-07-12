package C1;

import B1.l;
import B1.s;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.multiapp.OplusMultiAppManager;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.Iterator;
import java.util.List;
import u1.C0601d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f263a;

    public a(Context context) {
        this.f263a = context;
    }

    private boolean b(String[] strArr, int[] iArr, int i3, int i4, boolean[] zArr, boolean[] zArr2, List list) {
        int length = strArr.length;
        String[] g3 = g(strArr, iArr);
        Intent[] j3 = j(strArr, iArr, list);
        Drawable[] e3 = e(j3, iArr);
        try {
            Class<?> cls = Class.forName("com.oplus.util.PairTaskIconBuilder");
            Bitmap bitmap = (Bitmap) cls.getMethod("makeIcon", Drawable[].class, String[].class).invoke(cls.getConstructor(Context.class).newInstance(this.f263a), e3, strArr);
            if (bitmap == null || !d(g3, j3)) {
                Log.w("SplitScreenShortCutManager", " addSplitScreenCombination; Some parameters are null, return!");
                return false;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i5 = 0; i5 < length; i5++) {
                sb.append(g3[i5]);
                sb2.append(strArr[i5]);
                if (iArr[i5] != 0) {
                    sb2.append(":");
                    sb2.append(iArr[i5]);
                }
                if (i5 != length - 1) {
                    sb.append("|");
                    sb2.append("|");
                }
            }
            Log.d("SplitScreenShortCutManager", " addSplitScreenCombination, app size = " + length);
            Icon createWithBitmap = Icon.createWithBitmap(bitmap);
            ShortcutInfo.Builder builder = new ShortcutInfo.Builder(this.f263a, sb2.toString());
            builder.setIcon(createWithBitmap);
            builder.setShortLabel(sb.toString());
            builder.setIntents(j3);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putBoolean("SKIP_CONFIRM", true);
            persistableBundle.putBoolean("isPsSplitScreenCombination", true);
            persistableBundle.putInt("focusIndex", i3);
            persistableBundle.putStringArray("pkgNames", strArr);
            persistableBundle.putIntArray("userIds", iArr);
            if (!s.w(this.f263a)) {
                persistableBundle.putInt("androidx.flexible.layoutOrientation", i4);
            }
            persistableBundle.putBooleanArray("androidx.flexible.useMaxLayoutArray", zArr);
            persistableBundle.putBooleanArray("androidx.flexible.orientationArray", zArr2);
            if (s.H()) {
                persistableBundle.putInt("androidx.flexible.screenOrientationForShortCut", l.O1(this.f263a).v0().getAdapter().t());
            }
            builder.setExtras(persistableBundle);
            return ((ShortcutManager) this.f263a.getSystemService("shortcut")).requestPinShortcut(builder.build(), null);
        } catch (Exception unused) {
            Log.e("SplitScreenShortCutManager", "An exception occurred at make split screen combination icon.");
            return false;
        }
    }

    private boolean c(String[] strArr, int[] iArr) {
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length - 1) {
            int i4 = i3 + 1;
            for (int i5 = i4; i5 < length; i5++) {
                if (!TextUtils.isEmpty(strArr[i3]) && strArr[i3].equals(strArr[i5]) && iArr[i3] == iArr[i5]) {
                    return false;
                }
            }
            i3 = i4;
        }
        return true;
    }

    private boolean d(String[] strArr, Intent[] intentArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (TextUtils.isEmpty(strArr[i3]) || intentArr[i3] == null) {
                return false;
            }
        }
        return true;
    }

    private Drawable[] e(Intent[] intentArr, int[] iArr) {
        int length = intentArr.length;
        Drawable[] drawableArr = new Drawable[length];
        for (int i3 = 0; i3 < length; i3++) {
            drawableArr[i3] = l.X(this.f263a, intentArr[i3], iArr[i3]);
        }
        return drawableArr;
    }

    private String f(String str, int i3) {
        try {
            return OplusMultiAppManager.getInstance().isMultiAppUserId(i3) ? OplusMultiAppManager.getInstance().getMultiAppAlias(str, i3) : this.f263a.getPackageManager().getApplicationLabel(this.f263a.getPackageManager().getApplicationInfoAsUser(str, 4202496, i3)).toString();
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("SplitScreenShortCutManager", "getApplicationName has error = " + e3.getMessage());
            return null;
        }
    }

    private String[] g(String[] strArr, int[] iArr) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            strArr2[i3] = f(strArr[i3], iArr[i3]);
        }
        return strArr2;
    }

    private void h(String[] strArr, int[] iArr, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((C0601d) list.get(i3)).v();
            Intent f3 = ((C0601d) list.get(i3)).f();
            ComponentName component = f3.getComponent();
            if (component != null) {
                strArr[i3] = component.getPackageName();
            } else {
                strArr[i3] = f3.getPackage();
            }
        }
    }

    private void i(String[] strArr, int[] iArr, List list, boolean[] zArr, boolean[] zArr2, ContainerView containerView) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((C0601d) list.get(i3)).v();
            Intent f3 = ((C0601d) list.get(i3)).f();
            ComponentName component = f3.getComponent();
            if (component != null) {
                strArr[i3] = component.getPackageName();
            } else {
                strArr[i3] = f3.getPackage();
            }
            zArr[i3] = ((C0601d) list.get(i3)).u();
            zArr2[i3] = ((C0601d) list.get(i3)).I();
            if (((C0601d) list.get(i3)).B()) {
                zArr[i3] = !s.z(i3, containerView);
            }
        }
    }

    private Intent[] j(String[] strArr, int[] iArr, List list) {
        Intent[] intentArr = new Intent[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            Intent Y2 = l.Y(this.f263a, strArr[i3], iArr[i3]);
            intentArr[i3] = Y2;
            if (Y2 == null) {
                Intent f3 = ((C0601d) list.get(i3)).f();
                intentArr[i3] = f3;
                f3.removeExtra("ps_config_display_bound");
            }
            if (intentArr[i3].getAction() == null) {
                intentArr[i3].setAction("android.intent.action.MAIN");
            }
        }
        return intentArr;
    }

    public boolean a(List list, int i3, int i4, ContainerView containerView) {
        try {
            if (list.size() <= 1) {
                return false;
            }
            int size = list.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            boolean[] zArr = new boolean[size];
            boolean[] zArr2 = new boolean[size];
            i(strArr, iArr, list, zArr, zArr2, containerView);
            if (c(strArr, iArr)) {
                return b(strArr, iArr, i3, i4, zArr, zArr2, list);
            }
            Log.w("SplitScreenShortCutManager", " can't add same app as split pair");
            return false;
        } catch (Exception e3) {
            Log.e("SplitScreenShortCutManager", " addSplitScreenCombination has exception = " + e3.getMessage());
            return false;
        }
    }

    public boolean k(List list) {
        List<ShortcutInfo> pinnedShortcuts;
        try {
        } catch (Exception e3) {
            Log.e("SplitScreenShortCutManager", " isSplitPairExists has exception = " + e3.getMessage());
        }
        if (list.size() > 1 && (pinnedShortcuts = ((ShortcutManager) this.f263a.getSystemService("shortcut")).getPinnedShortcuts()) != null && !pinnedShortcuts.isEmpty()) {
            int size = list.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            h(strArr, iArr, list);
            if (!c(strArr, iArr)) {
                Log.w("SplitScreenShortCutManager", "isSplitPairExists checkDataValid pkgs:" + strArr + ",users:" + iArr);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(strArr[i3]);
                if (iArr[i3] != 0) {
                    sb.append(":");
                    sb.append(iArr[i3]);
                }
                if (i3 != size - 1) {
                    sb.append("|");
                }
            }
            Log.d("SplitScreenShortCutManager", "isSplitPairExists id:" + ((Object) sb) + ",shortcutInfoList:" + pinnedShortcuts);
            Iterator<ShortcutInfo> it = pinnedShortcuts.iterator();
            while (it.hasNext()) {
                if (sb.toString().equals(it.next().getId())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
