package A;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.y;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: x, reason: collision with root package name */
    private static final Interpolator f18x = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f19a;

    /* renamed from: b, reason: collision with root package name */
    private int f20b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f22d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f23e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f24f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f25g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f26h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f27i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f28j;

    /* renamed from: k, reason: collision with root package name */
    private int f29k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f30l;

    /* renamed from: m, reason: collision with root package name */
    private float f31m;

    /* renamed from: n, reason: collision with root package name */
    private float f32n;

    /* renamed from: o, reason: collision with root package name */
    private int f33o;

    /* renamed from: p, reason: collision with root package name */
    private final int f34p;

    /* renamed from: q, reason: collision with root package name */
    private int f35q;

    /* renamed from: r, reason: collision with root package name */
    private OverScroller f36r;

    /* renamed from: s, reason: collision with root package name */
    private final AbstractC0002c f37s;

    /* renamed from: t, reason: collision with root package name */
    private View f38t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f39u;

    /* renamed from: v, reason: collision with root package name */
    private final ViewGroup f40v;

    /* renamed from: c, reason: collision with root package name */
    private int f21c = -1;

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f41w = new b();

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    /* renamed from: A.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0002c {
        public abstract int clampViewPositionHorizontal(View view, int i3, int i4);

        public abstract int clampViewPositionVertical(View view, int i3, int i4);

        public int getOrderedChildIndex(int i3) {
            return i3;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i3, int i4) {
        }

        public boolean onEdgeLock(int i3) {
            return false;
        }

        public void onEdgeTouched(int i3, int i4) {
        }

        public void onViewCaptured(View view, int i3) {
        }

        public abstract void onViewDragStateChanged(int i3);

        public abstract void onViewPositionChanged(View view, int i3, int i4, int i5, int i6);

        public abstract void onViewReleased(View view, float f3, float f4);

        public abstract boolean tryCaptureView(View view, int i3);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0002c abstractC0002c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0002c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f40v = viewGroup;
        this.f37s = abstractC0002c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f34p = i3;
        this.f33o = i3;
        this.f20b = viewConfiguration.getScaledTouchSlop();
        this.f31m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f32n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f36r = new OverScroller(context, f18x);
    }

    private void A() {
        this.f30l.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, this.f31m);
        n(e(this.f30l.getXVelocity(this.f21c), this.f32n, this.f31m), e(this.f30l.getYVelocity(this.f21c), this.f32n, this.f31m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [A.c$c] */
    private void B(float f3, float f4, int i3) {
        boolean c3 = c(f3, f4, i3, 1);
        boolean z3 = c3;
        if (c(f4, f3, i3, 4)) {
            z3 = (c3 ? 1 : 0) | 4;
        }
        boolean z4 = z3;
        if (c(f3, f4, i3, 2)) {
            z4 = (z3 ? 1 : 0) | 2;
        }
        ?? r02 = z4;
        if (c(f4, f3, i3, 8)) {
            r02 = (z4 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f27i;
            iArr[i3] = iArr[i3] | r02;
            this.f37s.onEdgeDragStarted(r02, i3);
        }
    }

    private void C(float f3, float f4, int i3) {
        q(i3);
        float[] fArr = this.f22d;
        this.f24f[i3] = f3;
        fArr[i3] = f3;
        float[] fArr2 = this.f23e;
        this.f25g[i3] = f4;
        fArr2[i3] = f4;
        this.f26h[i3] = t((int) f3, (int) f4);
        this.f29k |= 1 << i3;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (x(pointerId)) {
                float x3 = motionEvent.getX(i3);
                float y3 = motionEvent.getY(i3);
                this.f24f[pointerId] = x3;
                this.f25g[pointerId] = y3;
            }
        }
    }

    private boolean c(float f3, float f4, int i3, int i4) {
        float abs = Math.abs(f3);
        float abs2 = Math.abs(f4);
        if ((this.f26h[i3] & i4) != i4 || (this.f35q & i4) == 0 || (this.f28j[i3] & i4) == i4 || (this.f27i[i3] & i4) == i4) {
            return false;
        }
        int i5 = this.f20b;
        if (abs <= i5 && abs2 <= i5) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f37s.onEdgeLock(i4)) {
            return (this.f27i[i3] & i4) == 0 && abs > ((float) this.f20b);
        }
        int[] iArr = this.f28j;
        iArr[i3] = iArr[i3] | i4;
        return false;
    }

    private boolean d(View view, float f3, float f4) {
        if (view == null) {
            return false;
        }
        boolean z3 = this.f37s.getViewHorizontalDragRange(view) > 0;
        boolean z4 = this.f37s.getViewVerticalDragRange(view) > 0;
        if (!z3 || !z4) {
            return z3 ? Math.abs(f3) > ((float) this.f20b) : z4 && Math.abs(f4) > ((float) this.f20b);
        }
        float f5 = (f3 * f3) + (f4 * f4);
        int i3 = this.f20b;
        return f5 > ((float) (i3 * i3));
    }

    private float e(float f3, float f4, float f5) {
        float abs = Math.abs(f3);
        if (abs < f4) {
            return 0.0f;
        }
        return abs > f5 ? f3 > 0.0f ? f5 : -f5 : f3;
    }

    private int f(int i3, int i4, int i5) {
        int abs = Math.abs(i3);
        if (abs < i4) {
            return 0;
        }
        return abs > i5 ? i3 > 0 ? i5 : -i5 : i3;
    }

    private void g() {
        float[] fArr = this.f22d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f23e, 0.0f);
        Arrays.fill(this.f24f, 0.0f);
        Arrays.fill(this.f25g, 0.0f);
        Arrays.fill(this.f26h, 0);
        Arrays.fill(this.f27i, 0);
        Arrays.fill(this.f28j, 0);
        this.f29k = 0;
    }

    private void h(int i3) {
        if (this.f22d == null || !w(i3)) {
            return;
        }
        this.f22d[i3] = 0.0f;
        this.f23e[i3] = 0.0f;
        this.f24f[i3] = 0.0f;
        this.f25g[i3] = 0.0f;
        this.f26h[i3] = 0;
        this.f27i[i3] = 0;
        this.f28j[i3] = 0;
        this.f29k = (~(1 << i3)) & this.f29k;
    }

    private int i(int i3, int i4, int i5) {
        if (i3 == 0) {
            return 0;
        }
        int width = this.f40v.getWidth();
        float f3 = width / 2;
        float o3 = f3 + (o(Math.min(1.0f, Math.abs(i3) / width)) * f3);
        int abs = Math.abs(i4);
        return Math.min(abs > 0 ? Math.round(Math.abs(o3 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i3) / i5) + 1.0f) * 256.0f), 600);
    }

    private int j(View view, int i3, int i4, int i5, int i6) {
        float f3;
        float f4;
        float f5;
        float f6;
        int f7 = f(i5, (int) this.f32n, (int) this.f31m);
        int f8 = f(i6, (int) this.f32n, (int) this.f31m);
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i4);
        int abs3 = Math.abs(f7);
        int abs4 = Math.abs(f8);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        if (f7 != 0) {
            f3 = abs3;
            f4 = i7;
        } else {
            f3 = abs;
            f4 = i8;
        }
        float f9 = f3 / f4;
        if (f8 != 0) {
            f5 = abs4;
            f6 = i7;
        } else {
            f5 = abs2;
            f6 = i8;
        }
        return (int) ((i(i3, f7, this.f37s.getViewHorizontalDragRange(view)) * f9) + (i(i4, f8, this.f37s.getViewVerticalDragRange(view)) * (f5 / f6)));
    }

    public static c l(ViewGroup viewGroup, float f3, AbstractC0002c abstractC0002c) {
        c m3 = m(viewGroup, abstractC0002c);
        m3.f20b = (int) (m3.f20b * (1.0f / f3));
        return m3;
    }

    public static c m(ViewGroup viewGroup, AbstractC0002c abstractC0002c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0002c);
    }

    private void n(float f3, float f4) {
        this.f39u = true;
        this.f37s.onViewReleased(this.f38t, f3, f4);
        this.f39u = false;
        if (this.f19a == 1) {
            E(0);
        }
    }

    private float o(float f3) {
        return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
    }

    private void p(int i3, int i4, int i5, int i6) {
        int left = this.f38t.getLeft();
        int top = this.f38t.getTop();
        if (i5 != 0) {
            i3 = this.f37s.clampViewPositionHorizontal(this.f38t, i3, i5);
            y.T(this.f38t, i3 - left);
        }
        int i7 = i3;
        if (i6 != 0) {
            i4 = this.f37s.clampViewPositionVertical(this.f38t, i4, i6);
            y.U(this.f38t, i4 - top);
        }
        int i8 = i4;
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.f37s.onViewPositionChanged(this.f38t, i7, i8, i7 - left, i8 - top);
    }

    private void q(int i3) {
        float[] fArr = this.f22d;
        if (fArr == null || fArr.length <= i3) {
            int i4 = i3 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f23e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f24f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f25g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f26h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f27i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f28j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f22d = fArr2;
            this.f23e = fArr3;
            this.f24f = fArr4;
            this.f25g = fArr5;
            this.f26h = iArr;
            this.f27i = iArr2;
            this.f28j = iArr3;
        }
    }

    private boolean s(int i3, int i4, int i5, int i6) {
        int left = this.f38t.getLeft();
        int top = this.f38t.getTop();
        int i7 = i3 - left;
        int i8 = i4 - top;
        if (i7 == 0 && i8 == 0) {
            this.f36r.abortAnimation();
            E(0);
            return false;
        }
        this.f36r.startScroll(left, top, i7, i8, j(this.f38t, i7, i8, i5, i6));
        E(2);
        return true;
    }

    private int t(int i3, int i4) {
        int i5 = i3 < this.f40v.getLeft() + this.f33o ? 1 : 0;
        if (i4 < this.f40v.getTop() + this.f33o) {
            i5 |= 4;
        }
        if (i3 > this.f40v.getRight() - this.f33o) {
            i5 |= 2;
        }
        return i4 > this.f40v.getBottom() - this.f33o ? i5 | 8 : i5;
    }

    private boolean x(int i3) {
        if (w(i3)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i3) {
        this.f40v.removeCallbacks(this.f41w);
        if (this.f19a != i3) {
            this.f19a = i3;
            this.f37s.onViewDragStateChanged(i3);
            if (this.f19a == 0) {
                this.f38t = null;
            }
        }
    }

    public boolean F(int i3, int i4) {
        if (this.f39u) {
            return s(i3, i4, (int) this.f30l.getXVelocity(this.f21c), (int) this.f30l.getYVelocity(this.f21c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean G(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A.c.G(android.view.MotionEvent):boolean");
    }

    public boolean H(View view, int i3, int i4) {
        this.f38t = view;
        this.f21c = -1;
        boolean s3 = s(i3, i4, 0, 0);
        if (!s3 && this.f19a == 0 && this.f38t != null) {
            this.f38t = null;
        }
        return s3;
    }

    boolean I(View view, int i3) {
        if (view == this.f38t && this.f21c == i3) {
            return true;
        }
        if (view == null || !this.f37s.tryCaptureView(view, i3)) {
            return false;
        }
        this.f21c = i3;
        b(view, i3);
        return true;
    }

    public void a() {
        this.f21c = -1;
        g();
        VelocityTracker velocityTracker = this.f30l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f30l = null;
        }
    }

    public void b(View view, int i3) {
        if (view.getParent() == this.f40v) {
            this.f38t = view;
            this.f21c = i3;
            this.f37s.onViewCaptured(view, i3);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f40v + ")");
    }

    public boolean k(boolean z3) {
        if (this.f19a == 2) {
            boolean computeScrollOffset = this.f36r.computeScrollOffset();
            int currX = this.f36r.getCurrX();
            int currY = this.f36r.getCurrY();
            int left = currX - this.f38t.getLeft();
            int top = currY - this.f38t.getTop();
            if (left != 0) {
                y.T(this.f38t, left);
            }
            if (top != 0) {
                y.U(this.f38t, top);
            }
            if (left != 0 || top != 0) {
                this.f37s.onViewPositionChanged(this.f38t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f36r.getFinalX() && currY == this.f36r.getFinalY()) {
                this.f36r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z3) {
                    this.f40v.post(this.f41w);
                } else {
                    E(0);
                }
            }
        }
        return this.f19a == 2;
    }

    public View r(int i3, int i4) {
        for (int childCount = this.f40v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f40v.getChildAt(this.f37s.getOrderedChildIndex(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f20b;
    }

    public boolean v(int i3, int i4) {
        return y(this.f38t, i3, i4);
    }

    public boolean w(int i3) {
        return (this.f29k & (1 << i3)) != 0;
    }

    public boolean y(View view, int i3, int i4) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i4 >= view.getTop() && i4 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f30l == null) {
            this.f30l = VelocityTracker.obtain();
        }
        this.f30l.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r3 = r((int) x3, (int) y3);
            C(x3, y3, pointerId);
            I(r3, pointerId);
            int i5 = this.f26h[pointerId];
            int i6 = this.f35q;
            if ((i5 & i6) != 0) {
                this.f37s.onEdgeTouched(i5 & i6, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f19a == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f19a == 1) {
                if (x(this.f21c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f21c);
                    float x4 = motionEvent.getX(findPointerIndex);
                    float y4 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f24f;
                    int i7 = this.f21c;
                    int i8 = (int) (x4 - fArr[i7]);
                    int i9 = (int) (y4 - this.f25g[i7]);
                    p(this.f38t.getLeft() + i8, this.f38t.getTop() + i9, i8, i9);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i4 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i4);
                if (x(pointerId2)) {
                    float x5 = motionEvent.getX(i4);
                    float y5 = motionEvent.getY(i4);
                    float f3 = x5 - this.f22d[pointerId2];
                    float f4 = y5 - this.f23e[pointerId2];
                    B(f3, f4, pointerId2);
                    if (this.f19a != 1) {
                        View r4 = r((int) x5, (int) y5);
                        if (d(r4, f3, f4) && I(r4, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f19a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x6 = motionEvent.getX(actionIndex);
            float y6 = motionEvent.getY(actionIndex);
            C(x6, y6, pointerId3);
            if (this.f19a != 0) {
                if (v((int) x6, (int) y6)) {
                    I(this.f38t, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x6, (int) y6), pointerId3);
                int i10 = this.f26h[pointerId3];
                int i11 = this.f35q;
                if ((i10 & i11) != 0) {
                    this.f37s.onEdgeTouched(i10 & i11, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f19a == 1 && pointerId4 == this.f21c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i4 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i4);
                if (pointerId5 != this.f21c) {
                    View r5 = r((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                    View view = this.f38t;
                    if (r5 == view && I(view, pointerId5)) {
                        i3 = this.f21c;
                        break;
                    }
                }
                i4++;
            }
            if (i3 == -1) {
                A();
            }
        }
        h(pointerId4);
    }
}
