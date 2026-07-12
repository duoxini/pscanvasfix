package u1;

import B1.l;
import B1.s;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import java.util.Objects;

/* renamed from: u1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0601d {

    /* renamed from: A, reason: collision with root package name */
    private boolean f13802A;

    /* renamed from: B, reason: collision with root package name */
    private Drawable f13803B;

    /* renamed from: C, reason: collision with root package name */
    public Rect f13804C;

    /* renamed from: D, reason: collision with root package name */
    public Rect f13805D;

    /* renamed from: E, reason: collision with root package name */
    public Rect f13806E;

    /* renamed from: F, reason: collision with root package name */
    public Rect f13807F;

    /* renamed from: G, reason: collision with root package name */
    public Rect f13808G;

    /* renamed from: H, reason: collision with root package name */
    public Rect f13809H;

    /* renamed from: a, reason: collision with root package name */
    public Rect f13810a;

    /* renamed from: b, reason: collision with root package name */
    private int f13811b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f13812c;

    /* renamed from: d, reason: collision with root package name */
    private ComponentName f13813d;

    /* renamed from: e, reason: collision with root package name */
    private int f13814e;

    /* renamed from: f, reason: collision with root package name */
    private int f13815f;

    /* renamed from: g, reason: collision with root package name */
    private float f13816g;

    /* renamed from: h, reason: collision with root package name */
    private int f13817h;

    /* renamed from: i, reason: collision with root package name */
    public Rect f13818i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f13819j;

    /* renamed from: k, reason: collision with root package name */
    private int f13820k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f13821l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13822m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13823n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f13824o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f13825p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13826q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13827r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13828s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13829t;

    /* renamed from: u, reason: collision with root package name */
    private Rect f13830u;

    /* renamed from: v, reason: collision with root package name */
    private int f13831v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f13832w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f13833x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f13834y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f13835z;

    public C0601d(Rect rect, int i3, Intent intent) {
        this.f13810a = new Rect();
        this.f13811b = -1;
        this.f13816g = 1.0f;
        this.f13818i = new Rect();
        this.f13819j = new Rect();
        this.f13821l = new Rect();
        this.f13822m = false;
        this.f13823n = false;
        this.f13824o = false;
        this.f13825p = new Rect();
        this.f13826q = false;
        this.f13827r = false;
        this.f13828s = false;
        this.f13829t = false;
        this.f13830u = new Rect();
        this.f13831v = 0;
        this.f13832w = false;
        this.f13833x = false;
        this.f13834y = false;
        this.f13835z = false;
        this.f13802A = false;
        this.f13804C = new Rect();
        this.f13805D = new Rect();
        this.f13806E = new Rect();
        this.f13807F = new Rect();
        this.f13808G = new Rect();
        this.f13809H = new Rect();
        if (rect != null) {
            this.f13810a.set(rect);
        }
        this.f13811b = i3;
        this.f13812c = intent;
    }

    private String J(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? String.valueOf(i3) : "FLEXIBLE_RESIZE_MODE_COMPAT_FULLSCREEN" : "FLEXIBLE_RESIZE_MODE_COMPAT" : "FLEXIBLE_RESIZE_MODE_SPLITSCREEN" : "FLEXIBLE_POCKET_STUDIO_UNSUPPORTED";
    }

    public boolean A() {
        return this.f13824o;
    }

    public boolean B() {
        return this.f13833x;
    }

    public boolean C() {
        return this.f13802A;
    }

    public boolean D() {
        return this.f13814e == 1;
    }

    public boolean E() {
        return this.f13835z;
    }

    public boolean F() {
        return this.f13834y;
    }

    public boolean G() {
        return this.f13827r;
    }

    public boolean H() {
        return this.f13826q;
    }

    public boolean I() {
        if (s.H()) {
            return this.f13826q ? this.f13810a.width() < this.f13810a.height() : n().width() <= n().height();
        }
        int j3 = j();
        if (ActivityInfo.isFixedOrientationLandscape(j3)) {
            return false;
        }
        return ActivityInfo.isFixedOrientationPortrait(j3) || this.f13810a.width() <= this.f13810a.height();
    }

    public void K(Rect rect) {
        if (rect != null) {
            this.f13819j.set(rect);
        }
    }

    public void L(Rect rect) {
        if (rect != null) {
            this.f13804C.set(rect);
        }
    }

    public void M(Drawable drawable) {
        this.f13803B = drawable;
    }

    public void N(boolean z3) {
        n0(z3);
    }

    public void O(Intent intent) {
        this.f13812c = intent;
    }

    public void P(boolean z3) {
        this.f13823n = z3;
    }

    public void Q(boolean z3) {
        this.f13829t = z3;
    }

    public void R(boolean z3) {
        this.f13824o = z3;
    }

    public void S(boolean z3) {
        this.f13802A = z3;
    }

    public void T(boolean z3) {
        this.f13835z = z3;
    }

    public void U(Rect rect) {
        if (rect != null) {
            this.f13808G.set(rect);
        }
    }

    public void V(Rect rect) {
        if (rect != null) {
            this.f13809H.set(rect);
        }
    }

    public void W(Rect rect) {
        if (rect != null) {
            this.f13818i.set(rect);
        }
    }

    public void X(int i3) {
        this.f13817h = i3;
    }

    public void Y(boolean z3) {
        this.f13832w = z3;
    }

    public void Z(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            int i3 = rect2.right;
            rect2.right = rect2.bottom;
            rect2.bottom = i3;
            this.f13807F.set(rect2);
        }
    }

    public boolean a(int i3, boolean z3) {
        if (D()) {
            return true;
        }
        return i3 == 2 && ActivityInfo.isFixedOrientationLandscape(this.f13817h) && z3 && !this.f13804C.equals(this.f13818i);
    }

    public void a0(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            int i3 = rect2.right;
            rect2.right = rect2.bottom;
            rect2.bottom = i3;
            this.f13806E.set(rect2);
        }
    }

    public C0601d b(C0601d c0601d, boolean z3) {
        this.f13810a = c0601d.f13810a;
        this.f13811b = c0601d.f13811b;
        this.f13831v = c0601d.f13831v;
        this.f13832w = c0601d.f13832w;
        this.f13812c = c0601d.f13812c.cloneFilter();
        this.f13813d = c0601d.f13813d;
        this.f13814e = c0601d.f13814e;
        this.f13816g = c0601d.f13816g;
        this.f13817h = c0601d.f13817h;
        this.f13818i = c0601d.f13818i;
        this.f13819j = c0601d.f13819j;
        this.f13820k = c0601d.f13820k;
        this.f13821l = c0601d.f13821l;
        this.f13823n = c0601d.f13823n;
        this.f13824o = c0601d.f13824o;
        this.f13825p = c0601d.f13825p;
        this.f13804C = c0601d.f13804C;
        this.f13829t = c0601d.f13829t;
        this.f13805D = c0601d.f13805D;
        this.f13806E = c0601d.f13806E;
        this.f13807F = c0601d.f13807F;
        this.f13815f = c0601d.f13815f;
        this.f13808G = c0601d.f13808G;
        this.f13809H = c0601d.f13809H;
        if (!z3) {
            this.f13826q = c0601d.f13826q;
            this.f13830u = c0601d.f13830u;
        }
        return this;
    }

    public void b0(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            int i3 = rect2.right;
            rect2.right = rect2.bottom;
            rect2.bottom = i3;
            this.f13805D.set(rect2);
        }
    }

    public Rect c() {
        return this.f13819j;
    }

    public void c0(int i3) {
        this.f13815f = i3;
    }

    public Rect d() {
        return this.f13804C;
    }

    public void d0(boolean z3) {
        this.f13833x = z3;
    }

    public Drawable e() {
        return this.f13803B;
    }

    public void e0(float f3) {
        this.f13816g = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0601d c0601d = (C0601d) obj;
        return this.f13811b == c0601d.f13811b && Objects.equals(this.f13810a, c0601d.f13810a) && Objects.equals(c0601d.f().getComponent(), f().getComponent()) && this.f13814e == c0601d.f13814e && this.f13816g == c0601d.f13816g && this.f13820k == c0601d.f13820k;
    }

    public Intent f() {
        return this.f13812c;
    }

    public void f0(Rect rect) {
        if (rect != null) {
            this.f13810a.set(rect);
        }
    }

    public Rect g() {
        return this.f13808G;
    }

    public void g0(int i3) {
        this.f13814e = i3;
        Log.d("TaskData", "setResizeMode " + i3 + " this:" + this + " " + Debug.getCallers(5));
    }

    public Rect h() {
        return this.f13809H;
    }

    public void h0(int i3) {
        this.f13831v = i3;
    }

    public int hashCode() {
        return Objects.hash(this.f13810a, this.f13812c);
    }

    public Rect i() {
        return this.f13818i;
    }

    public void i0(Rect rect) {
        if (rect != null) {
            this.f13821l.set(rect);
        }
    }

    public int j() {
        return this.f13817h;
    }

    public void j0(Rect rect) {
        if (rect != null) {
            this.f13830u.set(rect);
        }
    }

    public String k() {
        ComponentName componentName = this.f13813d;
        if (componentName != null) {
            String packageName = componentName.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                return packageName;
            }
        }
        return l.d0(this.f13812c);
    }

    public void k0(int i3) {
        this.f13811b = i3;
    }

    public int l() {
        return this.f13815f;
    }

    public void l0(boolean z3) {
        this.f13834y = z3;
    }

    public float m() {
        return this.f13816g;
    }

    public void m0(ComponentName componentName) {
        this.f13813d = componentName;
    }

    public Rect n() {
        return s.B() ? o() : this.f13826q ? new Rect(this.f13830u) : (this.f13822m && p() == 1) ? new Rect(this.f13818i) : new Rect(this.f13810a);
    }

    public void n0(boolean z3) {
        this.f13827r = z3;
    }

    public Rect o() {
        return this.f13826q ? new Rect(this.f13830u) : (!this.f13822m || (p() != 1 && (y() || !this.f13827r))) ? this.f13827r ? this.f13828s ? this.f13807F : new Rect(this.f13804C) : this.f13828s ? this.f13805D : new Rect(this.f13810a) : this.f13828s ? this.f13806E : new Rect(this.f13818i);
    }

    public void o0(boolean z3) {
        this.f13822m = z3;
    }

    public int p() {
        return this.f13828s ? this.f13815f : this.f13814e;
    }

    public void p0(boolean z3) {
        this.f13828s = z3;
    }

    public int q() {
        return this.f13831v;
    }

    public void q0(boolean z3) {
        this.f13826q = z3;
        if (z3) {
            return;
        }
        this.f13830u.setEmpty();
        this.f13835z = false;
    }

    public Rect r() {
        return this.f13830u;
    }

    public void r0(int i3) {
        this.f13820k = i3;
    }

    public int s() {
        return this.f13811b;
    }

    public void s0(Rect rect) {
        if (rect == null || rect.isEmpty() || rect.equals(this.f13825p)) {
            return;
        }
        this.f13825p.set(rect);
    }

    public ComponentName t() {
        return this.f13813d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskData{");
        sb.append("mTopComponent:" + this.f13813d);
        Intent intent = this.f13812c;
        if (intent != null) {
            sb.append(intent.getComponent());
        }
        sb.append(" taskId:" + this.f13811b);
        sb.append(" userId:" + this.f13820k);
        sb.append(" mIsRemoved:" + this.f13802A);
        sb.append(" resizeMode:" + J(this.f13814e));
        sb.append(" isOriginalResizable:" + this.f13829t);
        sb.append(" useMaxRect:" + this.f13822m);
        sb.append(" useFillInRect: " + this.f13827r);
        sb.append(" usePredictRect:" + this.f13828s);
        sb.append(" useSteplessAdjustRect:" + this.f13826q);
        sb.append(" getRect:" + n());
        sb.append(" rect:" + this.f13810a);
        sb.append(" maxRect:" + this.f13818i);
        sb.append(" fillInRect: " + this.f13804C);
        sb.append(" predictRect:" + this.f13805D);
        sb.append(" predictMaxRect:" + this.f13806E);
        sb.append(" predictFillInRect:" + this.f13807F);
        sb.append(" steplessAdjustRect:" + this.f13830u);
        sb.append(" predictResizeMode:" + J(this.f13815f));
        sb.append(" ratio:" + this.f13816g);
        sb.append(" orientation:" + ActivityInfo.screenOrientationToString(this.f13817h));
        sb.append(" isGame:" + this.f13823n);
        sb.append(" icon:" + this.f13803B);
        sb.append(" singleAppDisableResizeConfigType:" + this.f13831v);
        sb.append(" mIsPkgHasInnerTask:" + this.f13832w);
        sb.append(" mLaunchHorizontalBounds:" + this.f13808G);
        sb.append(" mLaunchVerticalBounds:" + this.f13809H);
        sb.append(" isProportionalScale:" + this.f13833x);
        sb.append(" isTaskRectChanged:" + this.f13834y);
        sb.append(" mIsScaleByUser:" + this.f13835z);
        sb.append("}");
        return sb.toString();
    }

    public boolean u() {
        return this.f13822m;
    }

    public int v() {
        return this.f13820k;
    }

    public Rect w() {
        return this.f13825p;
    }

    public boolean x() {
        return this.f13823n;
    }

    public boolean y() {
        return this.f13829t;
    }

    public boolean z() {
        return this.f13832w;
    }

    public C0601d() {
        this.f13810a = new Rect();
        this.f13811b = -1;
        this.f13816g = 1.0f;
        this.f13818i = new Rect();
        this.f13819j = new Rect();
        this.f13821l = new Rect();
        this.f13822m = false;
        this.f13823n = false;
        this.f13824o = false;
        this.f13825p = new Rect();
        this.f13826q = false;
        this.f13827r = false;
        this.f13828s = false;
        this.f13829t = false;
        this.f13830u = new Rect();
        this.f13831v = 0;
        this.f13832w = false;
        this.f13833x = false;
        this.f13834y = false;
        this.f13835z = false;
        this.f13802A = false;
        this.f13804C = new Rect();
        this.f13805D = new Rect();
        this.f13806E = new Rect();
        this.f13807F = new Rect();
        this.f13808G = new Rect();
        this.f13809H = new Rect();
    }
}
