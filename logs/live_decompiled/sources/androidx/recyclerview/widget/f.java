package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.y;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;

/* loaded from: classes.dex */
class f extends RecyclerView.o implements RecyclerView.t {

    /* renamed from: D, reason: collision with root package name */
    private static final int[] f6536D = {R.attr.state_pressed};

    /* renamed from: E, reason: collision with root package name */
    private static final int[] f6537E = new int[0];

    /* renamed from: A, reason: collision with root package name */
    int f6538A;

    /* renamed from: B, reason: collision with root package name */
    private final Runnable f6539B;

    /* renamed from: C, reason: collision with root package name */
    private final RecyclerView.u f6540C;

    /* renamed from: a, reason: collision with root package name */
    private final int f6541a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6542b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f6543c;

    /* renamed from: d, reason: collision with root package name */
    final Drawable f6544d;

    /* renamed from: e, reason: collision with root package name */
    private final int f6545e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6546f;

    /* renamed from: g, reason: collision with root package name */
    private final StateListDrawable f6547g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f6548h;

    /* renamed from: i, reason: collision with root package name */
    private final int f6549i;

    /* renamed from: j, reason: collision with root package name */
    private final int f6550j;

    /* renamed from: k, reason: collision with root package name */
    int f6551k;

    /* renamed from: l, reason: collision with root package name */
    int f6552l;

    /* renamed from: m, reason: collision with root package name */
    float f6553m;

    /* renamed from: n, reason: collision with root package name */
    int f6554n;

    /* renamed from: o, reason: collision with root package name */
    int f6555o;

    /* renamed from: p, reason: collision with root package name */
    float f6556p;

    /* renamed from: s, reason: collision with root package name */
    private RecyclerView f6559s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f6566z;

    /* renamed from: q, reason: collision with root package name */
    private int f6557q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f6558r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f6560t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6561u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f6562v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f6563w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f6564x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f6565y = new int[2];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.q(OplusSearchHighlightUtils.WAIT_TIME_DEFAULT);
        }
    }

    class b extends RecyclerView.u {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
            f.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6569a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6569a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f6569a) {
                this.f6569a = false;
                return;
            }
            if (((Float) f.this.f6566z.getAnimatedValue()).floatValue() == 0.0f) {
                f fVar = f.this;
                fVar.f6538A = 0;
                fVar.y(0);
            } else {
                f fVar2 = f.this;
                fVar2.f6538A = 2;
                fVar2.v();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            f.this.f6543c.setAlpha(floatValue);
            f.this.f6544d.setAlpha(floatValue);
            f.this.v();
        }
    }

    f(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i3, int i4, int i5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6566z = ofFloat;
        this.f6538A = 0;
        this.f6539B = new a();
        this.f6540C = new b();
        this.f6543c = stateListDrawable;
        this.f6544d = drawable;
        this.f6547g = stateListDrawable2;
        this.f6548h = drawable2;
        this.f6545e = Math.max(i3, stateListDrawable.getIntrinsicWidth());
        this.f6546f = Math.max(i3, drawable.getIntrinsicWidth());
        this.f6549i = Math.max(i3, stateListDrawable2.getIntrinsicWidth());
        this.f6550j = Math.max(i3, drawable2.getIntrinsicWidth());
        this.f6541a = i4;
        this.f6542b = i5;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        j(recyclerView);
    }

    private void C(float f3) {
        int[] p3 = p();
        float max = Math.max(p3[0], Math.min(p3[1], f3));
        if (Math.abs(this.f6552l - max) < 2.0f) {
            return;
        }
        int x3 = x(this.f6553m, max, p3, this.f6559s.computeVerticalScrollRange(), this.f6559s.computeVerticalScrollOffset(), this.f6558r);
        if (x3 != 0) {
            this.f6559s.scrollBy(0, x3);
        }
        this.f6553m = max;
    }

    private void k() {
        this.f6559s.removeCallbacks(this.f6539B);
    }

    private void l() {
        this.f6559s.removeItemDecoration(this);
        this.f6559s.removeOnItemTouchListener(this);
        this.f6559s.removeOnScrollListener(this.f6540C);
        k();
    }

    private void m(Canvas canvas) {
        int i3 = this.f6558r;
        int i4 = this.f6549i;
        int i5 = this.f6555o;
        int i6 = this.f6554n;
        this.f6547g.setBounds(0, 0, i6, i4);
        this.f6548h.setBounds(0, 0, this.f6557q, this.f6550j);
        canvas.translate(0.0f, i3 - i4);
        this.f6548h.draw(canvas);
        canvas.translate(i5 - (i6 / 2), 0.0f);
        this.f6547g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void n(Canvas canvas) {
        int i3 = this.f6557q;
        int i4 = this.f6545e;
        int i5 = i3 - i4;
        int i6 = this.f6552l;
        int i7 = this.f6551k;
        int i8 = i6 - (i7 / 2);
        this.f6543c.setBounds(0, 0, i4, i7);
        this.f6544d.setBounds(0, 0, this.f6546f, this.f6558r);
        if (!s()) {
            canvas.translate(i5, 0.0f);
            this.f6544d.draw(canvas);
            canvas.translate(0.0f, i8);
            this.f6543c.draw(canvas);
            canvas.translate(-i5, -i8);
            return;
        }
        this.f6544d.draw(canvas);
        canvas.translate(this.f6545e, i8);
        canvas.scale(-1.0f, 1.0f);
        this.f6543c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f6545e, -i8);
    }

    private int[] o() {
        int[] iArr = this.f6565y;
        int i3 = this.f6542b;
        iArr[0] = i3;
        iArr[1] = this.f6557q - i3;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f6564x;
        int i3 = this.f6542b;
        iArr[0] = i3;
        iArr[1] = this.f6558r - i3;
        return iArr;
    }

    private void r(float f3) {
        int[] o3 = o();
        float max = Math.max(o3[0], Math.min(o3[1], f3));
        if (Math.abs(this.f6555o - max) < 2.0f) {
            return;
        }
        int x3 = x(this.f6556p, max, o3, this.f6559s.computeHorizontalScrollRange(), this.f6559s.computeHorizontalScrollOffset(), this.f6557q);
        if (x3 != 0) {
            this.f6559s.scrollBy(x3, 0);
        }
        this.f6556p = max;
    }

    private boolean s() {
        return y.x(this.f6559s) == 1;
    }

    private void w(int i3) {
        k();
        this.f6559s.postDelayed(this.f6539B, i3);
    }

    private int x(float f3, float f4, int[] iArr, int i3, int i4, int i5) {
        int i6 = iArr[1] - iArr[0];
        if (i6 == 0) {
            return 0;
        }
        int i7 = i3 - i5;
        int i8 = (int) (((f4 - f3) / i6) * i7);
        int i9 = i4 + i8;
        if (i9 >= i7 || i9 < 0) {
            return 0;
        }
        return i8;
    }

    private void z() {
        this.f6559s.addItemDecoration(this);
        this.f6559s.addOnItemTouchListener(this);
        this.f6559s.addOnScrollListener(this.f6540C);
    }

    public void A() {
        int i3 = this.f6538A;
        if (i3 != 0) {
            if (i3 != 3) {
                return;
            } else {
                this.f6566z.cancel();
            }
        }
        this.f6538A = 1;
        ValueAnimator valueAnimator = this.f6566z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f6566z.setDuration(500L);
        this.f6566z.setStartDelay(0L);
        this.f6566z.start();
    }

    void B(int i3, int i4) {
        int computeVerticalScrollRange = this.f6559s.computeVerticalScrollRange();
        int i5 = this.f6558r;
        this.f6560t = computeVerticalScrollRange - i5 > 0 && i5 >= this.f6541a;
        int computeHorizontalScrollRange = this.f6559s.computeHorizontalScrollRange();
        int i6 = this.f6557q;
        boolean z3 = computeHorizontalScrollRange - i6 > 0 && i6 >= this.f6541a;
        this.f6561u = z3;
        boolean z4 = this.f6560t;
        if (!z4 && !z3) {
            if (this.f6562v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z4) {
            float f3 = i5;
            this.f6552l = (int) ((f3 * (i4 + (f3 / 2.0f))) / computeVerticalScrollRange);
            this.f6551k = Math.min(i5, (i5 * i5) / computeVerticalScrollRange);
        }
        if (this.f6561u) {
            float f4 = i6;
            this.f6555o = (int) ((f4 * (i3 + (f4 / 2.0f))) / computeHorizontalScrollRange);
            this.f6554n = Math.min(i6, (i6 * i6) / computeHorizontalScrollRange);
        }
        int i7 = this.f6562v;
        if (i7 == 0 || i7 == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i3 = this.f6562v;
        if (i3 == 1) {
            boolean u3 = u(motionEvent.getX(), motionEvent.getY());
            boolean t3 = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!u3 && !t3) {
                return false;
            }
            if (t3) {
                this.f6563w = 1;
                this.f6556p = (int) motionEvent.getX();
            } else if (u3) {
                this.f6563w = 2;
                this.f6553m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i3 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f6562v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean u3 = u(motionEvent.getX(), motionEvent.getY());
            boolean t3 = t(motionEvent.getX(), motionEvent.getY());
            if (u3 || t3) {
                if (t3) {
                    this.f6563w = 1;
                    this.f6556p = (int) motionEvent.getX();
                } else if (u3) {
                    this.f6563w = 2;
                    this.f6553m = (int) motionEvent.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f6562v == 2) {
            this.f6553m = 0.0f;
            this.f6556p = 0.0f;
            y(1);
            this.f6563w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f6562v == 2) {
            A();
            if (this.f6563w == 1) {
                r(motionEvent.getX());
            }
            if (this.f6563w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void c(boolean z3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.B b3) {
        if (this.f6557q != this.f6559s.getWidth() || this.f6558r != this.f6559s.getHeight()) {
            this.f6557q = this.f6559s.getWidth();
            this.f6558r = this.f6559s.getHeight();
            y(0);
        } else if (this.f6538A != 0) {
            if (this.f6560t) {
                n(canvas);
            }
            if (this.f6561u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6559s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f6559s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    void q(int i3) {
        int i4 = this.f6538A;
        if (i4 == 1) {
            this.f6566z.cancel();
        } else if (i4 != 2) {
            return;
        }
        this.f6538A = 3;
        ValueAnimator valueAnimator = this.f6566z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f6566z.setDuration(i3);
        this.f6566z.start();
    }

    boolean t(float f3, float f4) {
        if (f4 >= this.f6558r - this.f6549i) {
            int i3 = this.f6555o;
            int i4 = this.f6554n;
            if (f3 >= i3 - (i4 / 2) && f3 <= i3 + (i4 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean u(float f3, float f4) {
        if (!s() ? f3 >= this.f6557q - this.f6545e : f3 <= this.f6545e) {
            int i3 = this.f6552l;
            int i4 = this.f6551k;
            if (f4 >= i3 - (i4 / 2) && f4 <= i3 + (i4 / 2)) {
                return true;
            }
        }
        return false;
    }

    void v() {
        this.f6559s.invalidate();
    }

    void y(int i3) {
        if (i3 == 2 && this.f6562v != 2) {
            this.f6543c.setState(f6536D);
            k();
        }
        if (i3 == 0) {
            v();
        } else {
            A();
        }
        if (this.f6562v == 2 && i3 != 2) {
            this.f6543c.setState(f6537E);
            w(1200);
        } else if (i3 == 1) {
            w(1500);
        }
        this.f6562v = i3;
    }
}
