package B1;

import android.content.Context;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import u1.C0601d;

/* loaded from: classes.dex */
public class h {

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f185f = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: g, reason: collision with root package name */
    private static h f186g;

    /* renamed from: a, reason: collision with root package name */
    private Context f187a;

    /* renamed from: b, reason: collision with root package name */
    private long f188b;

    /* renamed from: c, reason: collision with root package name */
    private long f189c;

    /* renamed from: d, reason: collision with root package name */
    private int f190d = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f191e = false;

    private h(Context context) {
        this.f187a = context;
        E1.i.e(context);
    }

    public static h a(Context context) {
        if (f186g == null) {
            f186g = new h(context);
        }
        return f186g;
    }

    public void b(String str, String str2, int i3) {
        HashMap hashMap = new HashMap();
        long elapsedRealtime = (SystemClock.elapsedRealtime() / 1000) - this.f189c;
        if (elapsedRealtime < 0) {
            return;
        }
        hashMap.put("exit_action", str);
        hashMap.put("split_count", String.valueOf(i3));
        hashMap.put("split_packages", str2);
        hashMap.put("use_duration", String.valueOf(elapsedRealtime));
        if (f185f.booleanValue()) {
            Log.d("FlexibleWindowStatisticUtil", "onPocketStudioAllAppModeExit, exitAction" + str + ",durationTime = " + elapsedRealtime + ",pkgs = " + str2);
        }
        E1.i.m(this.f187a, "20126006", "ps_allappmode", hashMap);
    }

    public void c(String str, int i3, String str2, int i4, int i5) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("control_action", str);
        hashMap.put("split_count", String.valueOf(i3));
        hashMap.put("split_packages", str2);
        hashMap.put("split_large_count", String.valueOf(i5));
        switch (i4) {
            case 1:
                str3 = "layout_vertical";
                break;
            case 2:
                str3 = "layout_horizontal";
                break;
            case 3:
                str3 = "three_line";
                break;
            case 4:
                str3 = "big_up";
                break;
            case 5:
                str3 = "big_down";
                break;
            case 6:
                str3 = "big_left";
                break;
            case 7:
                str3 = "big_right";
                break;
            default:
                str3 = "layout_default";
                break;
        }
        hashMap.put("split_layout", str3);
        if (this.f191e) {
            hashMap.put("display_orientation", "1");
        } else {
            hashMap.put("display_orientation", "0");
        }
        if (s.q()) {
            hashMap.put("fold_screen_type", String.valueOf(this.f190d));
        }
        if (f185f.booleanValue()) {
            Log.d("FlexibleWindowStatisticUtil", "onPocketStudioControl,controlAction = " + str + ",pkgs= " + str2 + ",splitLargeCount = " + i5 + ",splitLayout = " + i4 + ",mIsLandscape = " + this.f191e + ",mFoldType = " + this.f190d);
        }
        E1.i.m(this.f187a, "20126006", "ps_control", hashMap);
    }

    public void d(String str, ContainerView containerView) {
        if (containerView == null) {
            return;
        }
        int n3 = containerView.getAdapter().n();
        List l3 = containerView.getAdapter().l();
        int size = l3.size();
        Iterator it = l3.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((C0601d) it.next()).u()) {
                i3++;
            }
        }
        c(str, size, s.g(l3), n3, i3);
    }

    public void e(String str) {
        long elapsedRealtime = (SystemClock.elapsedRealtime() / 1000) - this.f188b;
        if (elapsedRealtime < 0) {
            Log.d("FlexibleWindowStatisticUtil", "onPocketStudioExit, durationTime < 0");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("exit_action", str);
        hashMap.put("split_duration", String.valueOf(elapsedRealtime));
        if (this.f191e) {
            hashMap.put("display_orientation", "1");
        } else {
            hashMap.put("display_orientation", "0");
        }
        if (s.q()) {
            hashMap.put("fold_screen_type", String.valueOf(this.f190d));
        }
        if (f185f.booleanValue()) {
            Log.d("FlexibleWindowStatisticUtil", "onPocketStudioExit,exitAction = " + str + ",mIsLandscape = " + this.f191e + ", mFoldType = " + this.f190d);
        }
        E1.i.m(this.f187a, "20126006", "split_exit", hashMap);
    }

    public void f(int i3) {
        this.f190d = i3;
    }

    public void g(boolean z3) {
        this.f191e = z3;
    }

    public void h() {
        this.f189c = SystemClock.elapsedRealtime() / 1000;
    }

    public void i() {
        this.f188b = SystemClock.elapsedRealtime() / 1000;
    }
}
