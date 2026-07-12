package A1;

import B1.l;
import B1.s;
import android.app.Activity;
import android.app.WindowConfiguration;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.preference.j;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: x, reason: collision with root package name */
    private static int f51x;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f52a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f53b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f54c;

    /* renamed from: d, reason: collision with root package name */
    private Context f55d;

    /* renamed from: e, reason: collision with root package name */
    private A1.a f56e;

    /* renamed from: f, reason: collision with root package name */
    private A1.a f57f;

    /* renamed from: g, reason: collision with root package name */
    private A1.a f58g;

    /* renamed from: m, reason: collision with root package name */
    private int f64m;

    /* renamed from: n, reason: collision with root package name */
    private int f65n;

    /* renamed from: o, reason: collision with root package name */
    private float f66o;

    /* renamed from: s, reason: collision with root package name */
    private ContainerView f70s;

    /* renamed from: u, reason: collision with root package name */
    private Rect f72u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f73v;

    /* renamed from: h, reason: collision with root package name */
    private float[] f59h = new float[3];

    /* renamed from: i, reason: collision with root package name */
    private float[] f60i = new float[3];

    /* renamed from: j, reason: collision with root package name */
    private float[] f61j = new float[3];

    /* renamed from: k, reason: collision with root package name */
    private float[] f62k = new float[3];

    /* renamed from: l, reason: collision with root package name */
    private int[] f63l = {0, 1, 2};

    /* renamed from: p, reason: collision with root package name */
    private int f67p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f68q = 0;

    /* renamed from: r, reason: collision with root package name */
    private Rect[] f69r = new Rect[3];

    /* renamed from: t, reason: collision with root package name */
    private int f71t = 0;

    /* renamed from: w, reason: collision with root package name */
    Handler f74w = new a(Looper.getMainLooper());

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message == null) {
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof C0003b) {
                    C0003b c0003b = (C0003b) obj;
                    b.this.N(c0003b.f79d, c0003b.f78c);
                    return;
                }
                return;
            }
            Object obj2 = message.obj;
            if (obj2 instanceof C0003b) {
                C0003b c0003b2 = (C0003b) obj2;
                b bVar = b.this;
                if (!bVar.U(bVar.f68q, c0003b2.f76a, c0003b2.f77b) && !b.this.f52a) {
                    b.this.T(true, c0003b2.f76a, c0003b2.f77b);
                }
                b.this.f52a = true;
            }
        }
    }

    /* renamed from: A1.b$b, reason: collision with other inner class name */
    private static class C0003b {

        /* renamed from: a, reason: collision with root package name */
        private ContainerView f76a;

        /* renamed from: b, reason: collision with root package name */
        private int f77b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f78c;

        /* renamed from: d, reason: collision with root package name */
        private Rect f79d;

        private C0003b() {
        }
    }

    public b(Context context) {
        this.f55d = context;
        this.f66o = context.getResources().getDisplayMetrics().density;
        this.f64m = this.f55d.getDisplay().getMode().getPhysicalHeight();
        this.f65n = this.f55d.getDisplay().getMode().getPhysicalWidth();
    }

    private boolean A(Rect rect, Rect rect2) {
        if (rect == null || rect2 == null) {
            Log.e("FlexibleUiManager", "isSame null, now:" + rect2);
            return false;
        }
        Log.d("FlexibleUiManager", "isSame source:" + rect + ",now:" + rect2);
        return Math.abs(rect.left - rect2.left) <= 15 && Math.abs(rect.top - rect2.top) <= 15 && Math.abs(rect.right - rect2.right) <= 15 && Math.abs(rect.bottom - rect2.bottom) <= 15;
    }

    private void B(int i3, int i4, int[] iArr) {
        if (F(i3) <= 1) {
            return;
        }
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] == -1) {
                iArr[i5] = i5;
            }
        }
        if (i4 == 2) {
            D();
        } else if (i4 == 3) {
            C(iArr);
        }
    }

    private void C(int[] iArr) {
        float[] fArr = this.f59h;
        boolean z3 = true;
        float abs = Math.abs(fArr[iArr[0]] - fArr[iArr[1]]);
        float[] fArr2 = this.f60i;
        float abs2 = Math.abs(fArr2[iArr[0]] - fArr2[iArr[1]]);
        float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        float[] fArr3 = this.f61j;
        float abs3 = Math.abs(fArr3[iArr[0]] - fArr3[iArr[1]]);
        float[] fArr4 = this.f62k;
        float abs4 = Math.abs(fArr4[iArr[0]] - fArr4[iArr[1]]);
        float sqrt2 = (float) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        StringBuilder sb = new StringBuilder();
        sb.append("judgeToShowTipsWithThree ");
        sb.append(sqrt);
        sb.append("--");
        sb.append(sqrt2);
        sb.append("--");
        float f3 = sqrt - sqrt2;
        sb.append(f3);
        Log.d("FlexibleUiManager", sb.toString());
        int rotation = ((WindowManager) this.f55d.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0 && rotation != 2) {
            z3 = false;
        }
        float f4 = sqrt2 - sqrt;
        float f5 = this.f66o;
        if (f4 > f5 * 100.0f) {
            if (z3 && this.f62k[2] - this.f60i[0] > this.f64m / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithThree showExitFullTips isPort return");
                return;
            }
            if (!z3 && this.f62k[2] - this.f60i[0] > this.f65n / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithThree showExitFullTips not isPort return");
                return;
            } else {
                if (z()) {
                    n();
                    return;
                }
                return;
            }
        }
        if (f3 > f5 * 100.0f) {
            if (z3 && this.f62k[2] - this.f60i[0] > this.f64m / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithThree showEnterFullTips isPort return");
                return;
            }
            if (!z3 && this.f62k[2] - this.f60i[0] > this.f65n / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithThree showEnterFullTips not isPort return");
            } else if (y()) {
                n();
                J();
            }
        }
    }

    private void D() {
        float[] fArr = this.f59h;
        float abs = Math.abs(fArr[0] - fArr[1]);
        float[] fArr2 = this.f60i;
        float abs2 = Math.abs(fArr2[0] - fArr2[1]);
        float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        float[] fArr3 = this.f61j;
        float abs3 = Math.abs(fArr3[0] - fArr3[1]);
        float[] fArr4 = this.f62k;
        float abs4 = Math.abs(fArr4[0] - fArr4[1]);
        float sqrt2 = (float) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        int rotation = ((WindowManager) this.f55d.getSystemService("window")).getDefaultDisplay().getRotation();
        boolean z3 = rotation == 0 || rotation == 2;
        StringBuilder sb = new StringBuilder();
        sb.append("judgeToShowTipsWithTwo ");
        sb.append(sqrt);
        sb.append("--");
        sb.append(sqrt2);
        sb.append("--");
        float f3 = sqrt - sqrt2;
        sb.append(f3);
        sb.append(",");
        sb.append(z3);
        Log.d("FlexibleUiManager", sb.toString());
        float f4 = sqrt2 - sqrt;
        float f5 = this.f66o;
        if (f4 > f5 * 100.0f) {
            if (z3 && this.f62k[1] - this.f60i[0] > this.f64m / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithTwo showExitFullTips isPort return");
                return;
            }
            if (!z3 && this.f62k[1] - this.f60i[0] > this.f65n / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithTwo showExitFullTips not isPort return");
                return;
            } else if (z()) {
                n();
                return;
            } else {
                Log.d("FlexibleUiManager", "is not panorama mode");
                return;
            }
        }
        if (f3 > f5 * 100.0f) {
            if (z3 && this.f62k[1] - this.f60i[0] > this.f64m / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithTwo showEnterFullTips isPort return");
                return;
            }
            if (!z3 && this.f62k[1] - this.f60i[0] > this.f65n / 2.0f) {
                Log.i("FlexibleUiManager", "judgeToShowTipsWithTwo showEnterFullTips not isPort return");
            } else if (!y()) {
                Log.d("FlexibleUiManager", "not panorama modeManager:");
            } else {
                n();
                J();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r4.f70s.A0(1) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        if (r4.f70s.A0(0) == 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean E(boolean r5) {
        /*
            r4 = this;
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r0 = r4.f70s
            if (r0 == 0) goto L48
            u1.c r0 = r0.getAdapter()
            if (r0 == 0) goto L48
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r0 = r4.f70s
            u1.c r0 = r0.getAdapter()
            int r0 = r0.getCount()
            r1 = 3
            if (r0 == r1) goto L18
            goto L48
        L18:
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r0 = r4.f70s
            u1.c r0 = r0.getAdapter()
            int r0 = r0.n()
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L3f
            r1 = 4
            if (r0 == r1) goto L3f
            r1 = 5
            if (r0 == r1) goto L33
            r1 = 6
            if (r0 == r1) goto L3f
            r1 = 7
            if (r0 == r1) goto L33
            goto L48
        L33:
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r4 = r4.f70s
            int r4 = r4.A0(r3)
            if (r4 != 0) goto L3d
        L3b:
            r5 = r3
            goto L48
        L3d:
            r5 = r2
            goto L48
        L3f:
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r4 = r4.f70s
            int r4 = r4.A0(r2)
            if (r4 != 0) goto L3d
            goto L3b
        L48:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: A1.b.E(boolean):boolean");
    }

    private int F(int i3) {
        int i4 = 0;
        while (i3 > 0) {
            i4++;
            i3 &= i3 - 1;
        }
        return i4;
    }

    public static void H(int i3) {
        f51x = i3;
    }

    private void J() {
        Log.d("FlexibleUiManager", "showEnterFullTips");
        if (this.f57f == null || s.w(this.f55d) || l.F0(this.f55d) || l.N0(this.f70s)) {
            return;
        }
        SharedPreferences b3 = j.b(this.f55d);
        if (b3.getBoolean("enter_full_times", false)) {
            return;
        }
        if (this.f57f.n() && this.f57f.s()) {
            return;
        }
        SharedPreferences.Editor edit = b3.edit();
        edit.putBoolean("enter_full_times", true);
        edit.apply();
        this.f57f.o();
        A1.a aVar = new A1.a(this.f55d);
        this.f57f = aVar;
        aVar.v(true);
        this.f57f.y(true);
        this.f57f.w(true);
    }

    private void L(Rect rect, boolean z3) {
        this.f74w.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        C0003b c0003b = new C0003b();
        c0003b.f78c = z3;
        c0003b.f79d = rect;
        obtain.obj = c0003b;
        this.f74w.sendMessageDelayed(obtain, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Rect rect, boolean z3) {
        if (this.f56e == null || rect == null) {
            Log.e("FlexibleUiManager", "showTips null " + rect);
            return;
        }
        boolean E3 = E(z3);
        Log.d("FlexibleUiManager", "showFocusTips:" + rect + ",vertical:" + E3);
        if (this.f56e.n() && this.f56e.s()) {
            return;
        }
        this.f56e.o();
        A1.a aVar = new A1.a(this.f55d);
        this.f56e = aVar;
        aVar.x(rect, E3);
        this.f56e.w(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(boolean z3, ContainerView containerView, int i3) {
        Log.d("FlexibleUiManager", "showTipsIfNeed " + z3 + ",ori:" + i3);
        this.f74w.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        C0003b c0003b = new C0003b();
        c0003b.f77b = i3;
        c0003b.f76a = containerView;
        obtain.obj = c0003b;
        this.f74w.sendMessageDelayed(obtain, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(int i3, ContainerView containerView, int i4) {
        E e3;
        if (containerView == null || !containerView.isAttachedToWindow()) {
            Log.e("FlexibleUiManager", "showTipsNow " + containerView);
            return true;
        }
        containerView.o2();
        boolean z3 = true;
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            Rect rect = this.f69r[i6];
            if (rect != null) {
                boolean Z02 = containerView.Z0(rect);
                z3 = z3 && Z02;
                if (!Z02) {
                    i5 = i6;
                }
            }
        }
        Rect rect2 = this.f69r[i5];
        if (rect2 == null) {
            Log.d("FlexibleUiManager", "showTipsNow mThreeBoundsRect[index] is null , index=" + i5);
            return false;
        }
        if (!v(rect2)) {
            Log.i("FlexibleUiManager", "showTipsNow isOutOfScreen " + this.f69r[i5]);
            return false;
        }
        if (l.B0() || ((e3 = this.f70s.f10732G) != null && e3.Z())) {
            this.f53b = true;
            Log.i("FlexibleUiManager", "showTipsNow isInFourFingerToCanvasAnimation");
            return false;
        }
        this.f53b = false;
        Rect rect3 = this.f54c;
        if (rect3 != null && !A(rect3, this.f69r[i5])) {
            Log.d("FlexibleUiManager", "showTipsNow mOutRect:" + this.f54c);
            o(203);
            this.f54c = null;
            return true;
        }
        if (z3) {
            Log.i("FlexibleUiManager", "showTipsNow return " + this.f69r[i5]);
            return true;
        }
        ContainerView containerView2 = this.f70s;
        if ((containerView2 != null && containerView2.getAdapter() != null && this.f70s.getAdapter().getCount() < 2) || l.N0(this.f70s)) {
            return false;
        }
        if (V()) {
            this.f71t = 1;
            this.f72u = this.f69r[i5];
            this.f73v = i4 == 0;
            Log.i("FlexibleUiManager", "showTipsNow startFullDialogFromSettingsIfNeed");
            return true;
        }
        this.f52a = true;
        SharedPreferences b3 = j.b(this.f55d);
        if (!b3.getBoolean("enter_focus_scroll", true) || u()) {
            Log.d("FlexibleUiManager", "showTipsNow has shown:" + this.f54c);
        } else {
            SharedPreferences.Editor edit = b3.edit();
            edit.putBoolean("enter_focus_scroll", false);
            edit.apply();
            this.f54c = this.f69r[i5];
            Log.d("FlexibleUiManager", "showTipsNow first:" + this.f54c);
            N(this.f69r[i5], i4 == 0);
        }
        return true;
    }

    private boolean V() {
        if (s.w(this.f55d)) {
            return false;
        }
        SharedPreferences b3 = j.b(this.f55d);
        if (b3.getBoolean("settings_tips", true)) {
            Log.d("FlexibleUiManager", "startFullDialogFromSettingsIfNeed has shown");
            return false;
        }
        try {
            Log.d("FlexibleUiManager", "startFullDialogFromSettingsIfNeed begin");
            Intent intent = new Intent();
            intent.setPackage(this.f55d.getPackageName());
            intent.setClassName("com.android.settings", "com.oplus.settings.feature.stackdivider.FlexibleGuideActivity");
            intent.addFlags(268435456);
            this.f55d.startActivity(intent);
            SharedPreferences.Editor edit = b3.edit();
            edit.putBoolean("settings_tips", true);
            edit.apply();
            return true;
        } catch (Exception e3) {
            Log.d("FlexibleUiManager", "startFullDialogFromSettingsIfNeed error:" + e3.getMessage());
            return false;
        }
    }

    private void g(float[] fArr) {
        Arrays.fill(fArr, 0.0f);
    }

    private int j(int i3, int i4) {
        return i3 == 0 ? i4 | 1 : i3 == 1 ? i4 | 2 : i3 == 2 ? i4 | 4 : i4;
    }

    public static int k() {
        return f51x;
    }

    private void q(MotionEvent motionEvent) {
        this.f59h[0] = (int) motionEvent.getRawX();
        this.f60i[0] = (int) motionEvent.getRawY();
        this.f63l[0] = motionEvent.getPointerId(0);
    }

    private void r(MotionEvent motionEvent, int i3) {
        int findPointerIndex;
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 < 3 && (findPointerIndex = motionEvent.findPointerIndex(this.f63l[i4])) >= 0) {
                this.f61j[i4] = motionEvent.getRawX(findPointerIndex);
                this.f62k[i4] = motionEvent.getRawY(findPointerIndex);
            }
        }
    }

    private void s(MotionEvent motionEvent, int i3) {
        Log.d("FlexibleUiManager", "inputPointDown " + this.f67p + "--" + i3);
        int i4 = this.f67p;
        if (i4 == 2) {
            this.f63l[0] = motionEvent.getPointerId(0);
            this.f63l[1] = motionEvent.getPointerId(1);
            this.f59h[0] = (int) motionEvent.getRawX();
            this.f60i[0] = (int) motionEvent.getRawY();
            this.f59h[1] = motionEvent.getRawX(1);
            this.f60i[1] = motionEvent.getRawY(1);
            return;
        }
        if (i4 == 3) {
            this.f63l[0] = motionEvent.getPointerId(0);
            this.f63l[1] = motionEvent.getPointerId(1);
            this.f63l[2] = motionEvent.getPointerId(2);
            this.f59h[0] = (int) motionEvent.getRawX();
            this.f60i[0] = (int) motionEvent.getRawY();
            this.f59h[1] = motionEvent.getRawX(1);
            this.f60i[1] = motionEvent.getRawY(1);
            this.f59h[2] = motionEvent.getRawX(2);
            this.f60i[2] = motionEvent.getRawY(2);
        }
    }

    private void t() {
        Rect[] i3 = i();
        if (i3 == null) {
            this.f67p = 0;
            return;
        }
        if (i3.length <= 1) {
            this.f67p = 0;
            return;
        }
        int[] iArr = {-1, -1};
        int i4 = 0;
        for (int i5 = 0; i5 < i3.length; i5++) {
            if (i3[i5] != null) {
                for (int i6 = 0; i6 < this.f67p; i6++) {
                    if (i3[i5].contains((int) this.f59h[i6], (int) this.f60i[i6])) {
                        if (iArr[0] == -1) {
                            iArr[0] = i6;
                        } else {
                            iArr[1] = i6;
                        }
                        i4 = j(i5, i4);
                    }
                }
            }
        }
        Log.d("FlexibleUiManager", "handleMultiPointerEventTips inputUp:" + this.f67p + "|" + i4);
        B(i4, this.f67p, iArr);
        this.f67p = 0;
        g(this.f59h);
        g(this.f60i);
        g(this.f61j);
        g(this.f62k);
    }

    private boolean u() {
        Context context = this.f55d;
        return context == null || l.O1(context).isFinishing() || l.O1(this.f55d).isDestroyed() || (s.w(this.f55d) && s.i(this.f55d.getResources().getConfiguration()) == 2 && l.N0(this.f70s));
    }

    private boolean v(Rect rect) {
        int rotation = ((WindowManager) this.f55d.getSystemService("window")).getDefaultDisplay().getRotation();
        boolean z3 = rotation == 0 || rotation == 2;
        return new Rect(0, 0, z3 ? this.f65n : this.f64m, z3 ? this.f64m : this.f65n).intersect(rect);
    }

    public void G() {
        this.f74w.removeCallbacksAndMessages(null);
    }

    public void I(int i3) {
        this.f68q = i3;
    }

    public void K() {
        SharedPreferences b3 = j.b(this.f55d);
        if (b3.getBoolean("enter_full_from_focus", true)) {
            SharedPreferences.Editor edit = b3.edit();
            edit.putBoolean("enter_full_from_focus", false);
            edit.apply();
            n();
            J();
        }
    }

    public void M(MotionEvent motionEvent, int i3, int i4, boolean z3) {
        Rect[] i5 = i();
        if (motionEvent == null || i5 == null || i5.length < 2) {
            Log.e("FlexibleUiManager", "showFocusFromSplitScroll null" + this.f68q);
            return;
        }
        SharedPreferences b3 = j.b(this.f55d);
        if (!b3.getBoolean("enter_focus_scroll", true)) {
            Log.i("FlexibleUiManager", "showFocusFromSplitScroll return has shown");
            return;
        }
        int rotation = ((WindowManager) this.f55d.getSystemService("window")).getDefaultDisplay().getRotation();
        boolean z4 = rotation == 0 || rotation == 2;
        int i6 = z4 ? this.f65n : this.f64m;
        int i7 = z4 ? this.f64m : this.f65n;
        if (i5[0] == null) {
            Log.e("FlexibleUiManager", "showFocusFromSplitScroll error1");
            return;
        }
        if ((z3 && i3 < motionEvent.getRawX() && i5[0].left < 0) || (!z3 && i4 < motionEvent.getRawY() && i5[0].top < 0)) {
            Log.e("FlexibleUiManager", "showFocusFromSplitScroll enter1");
            if (!V()) {
                b3.edit().putBoolean("enter_focus_scroll", false).apply();
                L(i5[0], z3);
                return;
            } else {
                this.f71t = 2;
                this.f72u = i5[0];
                this.f73v = z3;
                return;
            }
        }
        if (i5[1] == null) {
            Log.e("FlexibleUiManager", "showFocusFromSplitScroll error2");
            return;
        }
        if ((!z3 || i3 <= motionEvent.getRawX() || i5[1].right <= i6) && (z3 || i4 <= motionEvent.getRawY() || i5[1].bottom <= i7)) {
            return;
        }
        Log.e("FlexibleUiManager", "showFocusFromSplitScroll enter2");
        if (!V()) {
            b3.edit().putBoolean("enter_focus_scroll", false).apply();
            L(i5[1], z3);
        } else {
            this.f71t = 2;
            this.f72u = i5[1];
            this.f73v = z3;
        }
    }

    public void O() {
        E e3;
        if (s.w(this.f55d) && s.B()) {
            SharedPreferences b3 = j.b(this.f55d);
            if (!b3.getBoolean("enter_focus_scroll", true)) {
                Log.d("FlexibleUiManager", "showFocusTipsFromPsPlus return has shown");
                return;
            }
            if (l.N0(this.f70s) || this.f68q != 2) {
                Log.d("FlexibleUiManager", "showFocusTipsFromPsPlus return  in screen or not two split");
                return;
            }
            ContainerView containerView = this.f70s;
            if (containerView == null || (e3 = containerView.f10732G) == null) {
                return;
            }
            boolean z3 = e3.J() == 0;
            List<Rect> childrenPositionOnScreen = this.f70s.getChildrenPositionOnScreen();
            for (int i3 = 0; i3 < childrenPositionOnScreen.size(); i3++) {
                Rect rect = childrenPositionOnScreen.get(i3);
                if (!this.f70s.Z0(rect)) {
                    Log.d("FlexibleUiManager", " showFocusTipsFromPsPlus:isSplitVertical =" + z3 + " rect = " + rect);
                    b3.edit().putBoolean("enter_focus_scroll", false).apply();
                    this.f74w.removeMessages(2);
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    C0003b c0003b = new C0003b();
                    c0003b.f78c = z3;
                    c0003b.f79d = rect;
                    obtain.obj = c0003b;
                    this.f74w.sendMessage(obtain);
                    this.f52a = true;
                    return;
                }
            }
        }
    }

    public void P() {
        if (this.f72u == null || u()) {
            Log.d("FlexibleUiManager", "showFocusTipsIfNeedBySettings interceptPhoneLandScapeFocusTips !");
            return;
        }
        SharedPreferences b3 = j.b(this.f55d);
        if (this.f71t == 1) {
            L(this.f72u, this.f73v);
            SharedPreferences.Editor edit = b3.edit();
            edit.putBoolean("enter_focus_scroll", false);
            edit.apply();
        }
        if (this.f71t == 2) {
            L(this.f72u, this.f73v);
            SharedPreferences.Editor edit2 = b3.edit();
            edit2.putBoolean("enter_focus_scroll", false);
            edit2.apply();
        }
        this.f71t = 0;
        this.f72u = null;
    }

    public void Q() {
        Log.d("FlexibleUiManager", "showTipsAfterGuideDismiss mInterceptByMultiGesture=" + this.f53b);
        if (this.f70s.f10732G == null || !w()) {
            return;
        }
        int count = this.f70s.getAdapter().getCount();
        ContainerView containerView = this.f70s;
        S(count, containerView, containerView.f10732G.J());
    }

    public void R(Configuration configuration, boolean z3, int i3, ContainerView containerView, int i4) {
        WindowConfiguration windowConfiguration;
        if (containerView == null) {
            Log.e("FlexibleUiManager", "showTipsFromAnimation containerView null");
            return;
        }
        if (i3 != 2 && i3 != 3) {
            Log.e("FlexibleUiManager", "showTipsFromAnimation " + i3);
            return;
        }
        this.f68q = i3;
        if (configuration == null || (windowConfiguration = configuration.windowConfiguration) == null) {
            Log.e("FlexibleUiManager", "showTipsFromAnimation newConfig null");
            return;
        }
        Rect bounds = windowConfiguration.getBounds();
        if (!z3 && (bounds.left < 0 || bounds.top < 0 || bounds.right < 0 || bounds.bottom < 0)) {
            Log.i("FlexibleUiManager", "showTipsFromAnimation now rect:" + bounds);
            return;
        }
        if (i3 != 2 || bounds.right >= 0 || bounds.left >= 0) {
            this.f70s = containerView;
            this.f52a = false;
            T(z3, containerView, i4);
        } else {
            Log.i("FlexibleUiManager", "showTipsFromAnimation wrong rect:" + bounds);
        }
    }

    public void S(int i3, ContainerView containerView, int i4) {
        if (containerView == null) {
            Log.e("FlexibleUiManager", "showTipsFromConfig null");
            return;
        }
        if (i3 == 2 || i3 == 3) {
            this.f70s = containerView;
            this.f68q = i3;
            this.f52a = false;
            T(true, containerView, i4);
            return;
        }
        Log.d("FlexibleUiManager", "showTipsFromConfig " + i3);
    }

    public void W() {
        Log.d("FlexibleUiManager", "stopShow");
        this.f74w.removeMessages(1);
    }

    public void h(boolean z3, ContainerView containerView, int i3, int i4) {
        if (containerView == null) {
            return;
        }
        this.f70s = containerView;
        if (f51x >= 3) {
            f51x = 0;
            K();
        }
        if (!z3) {
            R(this.f55d.getResources().getConfiguration(), true, i3, containerView, i4);
        } else {
            W();
            o(203);
        }
    }

    public Rect[] i() {
        Log.d("FlexibleUiManager", "getAllRectList " + this.f68q);
        int i3 = this.f68q;
        return (i3 == 2 || i3 == 3) ? this.f69r : new Rect[0];
    }

    public Rect[] l() {
        return this.f69r;
    }

    public void m(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            q(motionEvent);
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                r(motionEvent, pointerCount);
                return;
            } else if (actionMasked != 3) {
                if (actionMasked != 5) {
                    return;
                }
                this.f67p = pointerCount;
                s(motionEvent, pointerCount);
                return;
            }
        }
        int i3 = this.f67p;
        if (i3 == 2 || i3 == 3) {
            t();
        } else {
            this.f67p = 0;
        }
    }

    public void n() {
        Log.d("FlexibleUiManager", "hideAllTips ");
        A1.a aVar = this.f56e;
        if (aVar != null && (aVar.n() || this.f56e.s())) {
            this.f56e.o();
        }
        A1.a aVar2 = this.f57f;
        if (aVar2 != null && (aVar2.n() || this.f57f.s())) {
            this.f57f.o();
        }
        A1.a aVar3 = this.f58g;
        if (aVar3 != null) {
            if (aVar3.n() || this.f58g.s()) {
                this.f58g.o();
            }
        }
    }

    public void o(int i3) {
        Log.d("FlexibleUiManager", "hideTips " + i3);
        if (i3 == 203) {
            A1.a aVar = this.f56e;
            if (aVar != null) {
                if (aVar.n() || this.f56e.s()) {
                    this.f56e.o();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 204) {
            A1.a aVar2 = this.f57f;
            if (aVar2 != null) {
                if (aVar2.n() || this.f57f.s()) {
                    this.f57f.o();
                    return;
                }
                return;
            }
            return;
        }
        A1.a aVar3 = this.f58g;
        if (aVar3 != null) {
            if (aVar3.n() || this.f58g.s()) {
                this.f58g.o();
            }
        }
    }

    public void p() {
        this.f66o = this.f55d.getResources().getDisplayMetrics().density;
        this.f64m = this.f55d.getDisplay().getMode().getPhysicalHeight();
        this.f65n = this.f55d.getDisplay().getMode().getPhysicalWidth();
        A1.a aVar = this.f56e;
        if (aVar == null) {
            this.f56e = new A1.a(this.f55d);
        } else {
            aVar.r(this.f55d);
        }
        f51x = 0;
        A1.a aVar2 = this.f57f;
        if (aVar2 == null) {
            A1.a aVar3 = new A1.a(this.f55d);
            this.f57f = aVar3;
            aVar3.v(true);
        } else {
            aVar2.r(this.f55d);
        }
        A1.a aVar4 = this.f58g;
        if (aVar4 == null) {
            this.f58g = new A1.a(this.f55d);
        } else {
            aVar4.r(this.f55d);
        }
    }

    public boolean w() {
        return this.f53b;
    }

    public boolean x(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public boolean y() {
        return (l.O1(this.f55d).E0() == null || l.O1(this.f55d).E0().M()) ? false : true;
    }

    public boolean z() {
        return l.O1(this.f55d).E0() != null && l.O1(this.f55d).E0().M();
    }
}
