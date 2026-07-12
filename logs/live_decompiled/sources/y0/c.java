package y0;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.oplus.graphics.OplusBlurParam;
import com.oplus.view.ViewRootManager;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import java.util.function.Consumer;
import n0.AbstractC0481a;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private View f14462b;

    /* renamed from: c, reason: collision with root package name */
    private View f14463c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14464d;

    /* renamed from: e, reason: collision with root package name */
    private Context f14465e;

    /* renamed from: f, reason: collision with root package name */
    private ViewRootManager f14466f;

    /* renamed from: g, reason: collision with root package name */
    private WindowManager f14467g;

    /* renamed from: h, reason: collision with root package name */
    private Consumer f14468h;

    /* renamed from: i, reason: collision with root package name */
    private float f14469i;

    /* renamed from: j, reason: collision with root package name */
    private float f14470j;

    /* renamed from: k, reason: collision with root package name */
    private float f14471k;

    /* renamed from: l, reason: collision with root package name */
    private float f14472l;

    /* renamed from: m, reason: collision with root package name */
    private int f14473m;

    /* renamed from: n, reason: collision with root package name */
    private float f14474n;

    /* renamed from: s, reason: collision with root package name */
    private boolean f14479s;

    /* renamed from: a, reason: collision with root package name */
    private final ContentObserver f14461a = new a(new Handler(Looper.getMainLooper()));

    /* renamed from: o, reason: collision with root package name */
    private float[] f14475o = null;

    /* renamed from: p, reason: collision with root package name */
    private float[] f14476p = null;

    /* renamed from: q, reason: collision with root package name */
    private float[] f14477q = null;

    /* renamed from: r, reason: collision with root package name */
    private float[] f14478r = null;

    /* renamed from: t, reason: collision with root package name */
    private boolean f14480t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f14481u = false;

    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            boolean h3 = c.this.h();
            if (c.this.f14480t != h3) {
                c.this.f14480t = h3;
                c.this.n("BlurSettingObserver");
            }
        }
    }

    public c(Context context) {
        this.f14465e = context;
        g();
    }

    private OplusBlurParam f() {
        float[] fArr;
        float[] fArr2;
        OplusBlurParam oplusBlurParam = new OplusBlurParam();
        oplusBlurParam.setBlurType(2);
        boolean z3 = this.f14479s;
        int i3 = z3 ? 2 : 3;
        if (z3) {
            fArr = this.f14476p;
            fArr2 = this.f14478r;
        } else {
            fArr = this.f14475o;
            fArr2 = this.f14477q;
        }
        oplusBlurParam.setMaterialParams(i3, fArr, fArr2);
        if (AbstractC0481a.e()) {
            oplusBlurParam.setSmoothCornerWeight(this.f14474n);
            AbstractC0371a.d("BackgroundBlurBuilder", "Current version supports roundCorner when using blur");
        }
        return oplusBlurParam;
    }

    private void g() {
        this.f14479s = AbstractC0335a.j(this.f14465e) || AbstractC0342a.a(this.f14465e);
        this.f14473m = this.f14465e.getResources().getDimensionPixelSize(M1.f.f1457q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Boolean bool) {
        if (this.f14481u != bool.booleanValue()) {
            this.f14481u = bool.booleanValue();
            n("CrossWindowBlurEnabledListener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        int h3 = AbstractC0335a.h(this.f14465e, M1.e.f1397m);
        int h4 = this.f14479s ? AbstractC0335a.h(this.f14465e, M1.e.f1399o) : AbstractC0335a.h(this.f14465e, M1.e.f1398n);
        ViewRootManager viewRootManager = this.f14466f;
        if (!this.f14480t || !this.f14481u) {
            h3 = h4;
        }
        viewRootManager.setColor(h3);
        this.f14463c.invalidate();
        AbstractC0371a.d("BackgroundBlurBuilder", "setBlurEnable mLastBlurState = " + this.f14480t + ",mWindowBlurEnable = " + this.f14481u + ",tag:" + str);
    }

    public void e() {
        if (x()) {
            AbstractC0371a.d("BackgroundBlurBuilder", "applyBlurBackground");
            this.f14480t = h();
            this.f14465e.getContentResolver().registerContentObserver(Settings.System.getUriFor("system_material_blur_enable"), false, this.f14461a);
            this.f14467g = (WindowManager) this.f14465e.getSystemService("window");
            if (this.f14463c == null) {
                throw new IllegalStateException("Must setTargetView before applyBlurBackground");
            }
            if (this.f14462b != null) {
                this.f14466f = new ViewRootManager(this.f14462b);
            } else {
                this.f14466f = new ViewRootManager(this.f14463c);
            }
            Drawable backgroundBlurDrawable = this.f14466f.getBackgroundBlurDrawable();
            if (this.f14468h == null) {
                this.f14468h = new Consumer() { // from class: y0.b
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        c.this.i((Boolean) obj);
                    }
                };
            }
            this.f14467g.addCrossWindowBlurEnabledListener(this.f14468h);
            this.f14481u = this.f14467g.isCrossWindowBlurEnabled();
            this.f14466f.setBlurParams(f());
            this.f14466f.setBlurRadius(this.f14473m);
            j();
            if (backgroundBlurDrawable != null) {
                backgroundBlurDrawable.setAlpha((int) (this.f14463c.getAlpha() * 255.0f));
                this.f14463c.setBackground(backgroundBlurDrawable);
            }
            n("ApplyBlurBackground");
        }
    }

    public boolean h() {
        return Settings.System.getInt(this.f14465e.getContentResolver(), "system_material_blur_enable", 0) == 1;
    }

    public void j() {
        this.f14466f.setCornerRadius(this.f14469i, this.f14470j, this.f14471k, this.f14472l);
    }

    public void k() {
        Consumer<Boolean> consumer;
        if (this.f14464d && (consumer = this.f14468h) != null) {
            this.f14467g.removeCrossWindowBlurEnabledListener(consumer);
        }
        this.f14465e.getContentResolver().unregisterContentObserver(this.f14461a);
        AbstractC0371a.d("BackgroundBlurBuilder", "release");
    }

    public void l(float[] fArr) {
        this.f14476p = fArr;
    }

    public void m(float[] fArr) {
        this.f14475o = fArr;
    }

    public c o(float f3) {
        this.f14469i = f3;
        this.f14470j = f3;
        this.f14471k = f3;
        this.f14472l = f3;
        return this;
    }

    public c p(float f3, float f4, float f5, float f6) {
        this.f14469i = f3;
        this.f14470j = f4;
        this.f14471k = f5;
        this.f14472l = f6;
        return this;
    }

    public void q(float[] fArr) {
        this.f14478r = fArr;
    }

    public void r(float[] fArr) {
        this.f14477q = fArr;
    }

    public c s(View view) {
        this.f14462b = view;
        return this;
    }

    public c t(float f3) {
        this.f14474n = f3;
        return this;
    }

    public c u(View view) {
        this.f14463c = view;
        return this;
    }

    public c v(boolean z3, EnumC0643a enumC0643a) {
        return w(z3, enumC0643a, this.f14465e.getResources().getBoolean(M1.d.f1382a));
    }

    public c w(boolean z3, EnumC0643a enumC0643a, boolean z4) {
        if (i.a() && j.b(enumC0643a) && z4) {
            this.f14464d = z3;
        } else {
            Log.e("BackgroundBlurBuilder", "Machines below V do not support setting blurred backgrounds or current animLevel is too low or is in third party theme");
            this.f14464d = false;
        }
        return this;
    }

    public boolean x() {
        return this.f14464d;
    }
}
