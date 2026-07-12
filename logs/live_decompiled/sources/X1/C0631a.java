package x1;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;

/* renamed from: x1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0631a {

    /* renamed from: q, reason: collision with root package name */
    private static final String f13991q = "a";

    /* renamed from: a, reason: collision with root package name */
    private final ViewConfiguration f13992a;

    /* renamed from: i, reason: collision with root package name */
    private int f14000i;

    /* renamed from: j, reason: collision with root package name */
    private int f14001j;

    /* renamed from: o, reason: collision with root package name */
    private C0633c f14006o;

    /* renamed from: p, reason: collision with root package name */
    private WindowManager f14007p;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f13993b = new PointF();

    /* renamed from: c, reason: collision with root package name */
    private final PointF f13994c = new PointF();

    /* renamed from: d, reason: collision with root package name */
    private final PointF f13995d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final PointF f13996e = new PointF();

    /* renamed from: f, reason: collision with root package name */
    private boolean f13997f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13998g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13999h = true;

    /* renamed from: k, reason: collision with root package name */
    private Point f14002k = new Point();

    /* renamed from: l, reason: collision with root package name */
    private Rect f14003l = new Rect();

    /* renamed from: m, reason: collision with root package name */
    private Rect f14004m = new Rect();

    /* renamed from: n, reason: collision with root package name */
    private Rect f14005n = new Rect();

    public C0631a(ViewConfiguration viewConfiguration, WindowManager windowManager) {
        this.f13992a = viewConfiguration;
        this.f14007p = windowManager;
        windowManager.getDefaultDisplay().getRealSize(this.f14002k);
        Point point = this.f14002k;
        this.f14006o = new C0633c(point.x, point.y);
    }

    private void a(int i3, int i4) {
        if (this.f14003l.contains(i3, i4)) {
            this.f14001j = 2;
        } else if (!this.f14005n.contains(i3, i4) || this.f14003l.contains(i3, i4)) {
            this.f14001j = 0;
        } else {
            this.f14001j = 1;
        }
    }

    private void b() {
        this.f14007p.getDefaultDisplay().getRealSize(this.f14002k);
        Point point = this.f14002k;
        this.f14006o = new C0633c(point.x, point.y);
        Point point2 = this.f14002k;
        if (point2.x < point2.y) {
            this.f13998g = true;
        } else {
            this.f13998g = false;
        }
    }

    public void c() {
        this.f14007p.getDefaultDisplay().getRealSize(this.f14002k);
        Point point = this.f14002k;
        int i3 = point.x;
        float f3 = i3;
        this.f14003l.set((int) (0.08f * f3), (int) ((point.y * 1.0f) / 3.0f), (int) (f3 * 0.92f), (int) (((r0 * 2) * 1.0f) / 3.0f));
    }

    public int d() {
        return this.f14002k.y;
    }

    public int e() {
        return this.f14002k.x;
    }

    public PointF f() {
        return this.f13993b;
    }

    public PointF g() {
        return this.f13995d;
    }

    public int h() {
        return this.f14001j;
    }

    public void i(Rect rect, Rect rect2, Rect rect3) {
        this.f14004m = rect;
        this.f14005n = rect2;
        this.f14003l = rect3;
    }

    public boolean j() {
        return this.f13997f;
    }

    public void k(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f14000i = motionEvent.getPointerId(0);
            b();
            c();
            this.f13995d.set(motionEvent.getRawX(), motionEvent.getRawY());
            this.f13993b.set(this.f13995d);
            this.f13997f = false;
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f14000i);
                if (findPointerIndex == -1) {
                    Log.e(f13991q, "Invalid active pointer id on MOVE: " + this.f14000i);
                    return;
                }
                float rawX = motionEvent.getRawX(findPointerIndex);
                float rawY = motionEvent.getRawY(findPointerIndex);
                PointF pointF = this.f13996e;
                PointF pointF2 = this.f13995d;
                pointF.set(rawX - pointF2.x, rawY - pointF2.y);
                PointF pointF3 = this.f13994c;
                PointF pointF4 = this.f13993b;
                pointF3.set(rawX - pointF4.x, rawY - pointF4.y);
                if (!this.f13997f && this.f13994c.length() > this.f13992a.getScaledTouchSlop()) {
                    this.f13997f = true;
                }
                if (this.f13997f) {
                    a((int) rawX, (int) rawY);
                }
                this.f13995d.set(rawX, rawY);
                return;
            }
            if (actionMasked == 3) {
                Log.d(f13991q, "ACTION_CANCEL");
                this.f14001j = 3;
                return;
            } else if (actionMasked != 6) {
                return;
            }
        }
        int findPointerIndex2 = motionEvent.findPointerIndex(this.f14000i);
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (pointerId == this.f14000i) {
            this.f13995d.set(motionEvent.getRawX(findPointerIndex2), motionEvent.getRawY(findPointerIndex2));
            this.f14001j = 3;
            return;
        }
        Log.e(f13991q, "Invalid active pointer id on UP: " + pointerId + " mActivePointerId:" + this.f14000i);
    }

    public void l(Rect rect, Rect rect2, boolean z3) {
        this.f13999h = z3;
        this.f14004m.set(rect);
        this.f14005n.set(rect2);
        c();
    }
}
