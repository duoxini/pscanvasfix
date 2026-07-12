package p0;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import androidx.core.view.y;
import b2.AbstractC0293a;
import e0.AbstractC0342a;
import java.util.Locale;

/* renamed from: p0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0495a {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f12757m = {R.attr.state_pressed};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f12758n = new int[0];

    /* renamed from: a, reason: collision with root package name */
    private View f12759a;

    /* renamed from: b, reason: collision with root package name */
    private final float f12760b;

    /* renamed from: c, reason: collision with root package name */
    private float f12761c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f12762d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f12763e;

    /* renamed from: f, reason: collision with root package name */
    private final c f12764f;

    /* renamed from: g, reason: collision with root package name */
    private int f12765g;

    /* renamed from: h, reason: collision with root package name */
    private final d f12766h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12767i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12768j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12769k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f12770l;

    /* renamed from: p0.a$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final c f12771a;

        /* renamed from: b, reason: collision with root package name */
        private int f12772b;

        /* renamed from: c, reason: collision with root package name */
        private int f12773c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12774d = true;

        /* renamed from: e, reason: collision with root package name */
        private Drawable f12775e;

        /* renamed from: f, reason: collision with root package name */
        private int f12776f;

        /* renamed from: g, reason: collision with root package name */
        private int f12777g;

        /* renamed from: h, reason: collision with root package name */
        public int f12778h;

        /* renamed from: i, reason: collision with root package name */
        public int f12779i;

        /* renamed from: j, reason: collision with root package name */
        public int f12780j;

        /* renamed from: k, reason: collision with root package name */
        public int f12781k;

        public b(c cVar) {
            this.f12771a = cVar;
            this.f12772b = cVar.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(b2.b.f7278f);
            this.f12773c = cVar.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(b2.b.f7277e);
            this.f12778h = cVar.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(b2.b.f7276d);
            this.f12779i = cVar.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(b2.b.f7275c);
            this.f12780j = cVar.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(b2.b.f7273a);
            this.f12781k = cVar.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(b2.b.f7274b);
            this.f12776f = androidx.core.content.a.c(cVar.getCOUIScrollableView().getContext(), AbstractC0293a.f7272a);
            this.f12777g = androidx.core.content.a.c(cVar.getCOUIScrollableView().getContext(), AbstractC0293a.f7272a);
        }

        private Drawable b() {
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.f12777g);
            float f3 = this.f12772b / 2.0f;
            gradientDrawable.setCornerRadius(f3);
            int[] iArr = C0495a.f12757m;
            int i3 = this.f12781k;
            stateListDrawable.addState(iArr, new InsetDrawable((Drawable) gradientDrawable, i3, this.f12778h, i3, this.f12779i));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(this.f12776f);
            gradientDrawable2.setCornerRadius(f3);
            int[] iArr2 = C0495a.f12758n;
            int i4 = this.f12780j;
            stateListDrawable.addState(iArr2, new InsetDrawable((Drawable) gradientDrawable2, i4, this.f12778h, i4, this.f12779i));
            return stateListDrawable;
        }

        public C0495a a() {
            if (this.f12775e == null) {
                this.f12775e = b();
            }
            return new C0495a(this.f12771a, this.f12772b, this.f12773c, this.f12775e, this.f12774d);
        }

        public b c(int i3) {
            this.f12779i = i3;
            return this;
        }

        public b d(int i3) {
            this.f12778h = i3;
            return this;
        }
    }

    /* renamed from: p0.a$c */
    public interface c {
        View getCOUIScrollableView();

        int superComputeVerticalScrollExtent();

        int superComputeVerticalScrollOffset();

        int superComputeVerticalScrollRange();

        void superOnTouchEvent(MotionEvent motionEvent);
    }

    /* renamed from: p0.a$d */
    private static class d implements Runnable {

        /* renamed from: m, reason: collision with root package name */
        private static final float[] f12782m = {255.0f};

        /* renamed from: n, reason: collision with root package name */
        private static final float[] f12783n = {0.0f};

        /* renamed from: h, reason: collision with root package name */
        public float[] f12787h;

        /* renamed from: i, reason: collision with root package name */
        public View f12788i;

        /* renamed from: k, reason: collision with root package name */
        public long f12790k;

        /* renamed from: g, reason: collision with root package name */
        public final int f12786g = 50;

        /* renamed from: j, reason: collision with root package name */
        public final Interpolator f12789j = new Interpolator(1, 2);

        /* renamed from: l, reason: collision with root package name */
        public int f12791l = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f12784e = ViewConfiguration.getScrollDefaultDelay();

        /* renamed from: f, reason: collision with root package name */
        public final int f12785f = ViewConfiguration.getScrollBarFadeDuration();

        public d(ViewConfiguration viewConfiguration, View view) {
            this.f12788i = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j3 = this.f12790k;
            if (currentAnimationTimeMillis < j3) {
                if (Math.abs(currentAnimationTimeMillis - j3) >= 50 || (view = this.f12788i) == null) {
                    return;
                }
                view.post(this);
                return;
            }
            int i3 = (int) currentAnimationTimeMillis;
            Interpolator interpolator = this.f12789j;
            interpolator.setKeyFrame(0, i3, f12782m);
            interpolator.setKeyFrame(1, i3 + this.f12785f, f12783n);
            this.f12791l = 2;
            this.f12788i.invalidate();
        }
    }

    private void f(StateListDrawable stateListDrawable, int i3, int i4) {
        Drawable stateDrawable = stateListDrawable.getStateDrawable(i3);
        if (stateDrawable instanceof InsetDrawable) {
            Drawable drawable = ((InsetDrawable) stateDrawable).getDrawable();
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(i4);
            }
        }
    }

    private boolean g() {
        return d(this.f12766h.f12784e * 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(android.graphics.Canvas r9) {
        /*
            r8 = this;
            boolean r0 = r8.f12768j
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            if (r0 == 0) goto Ld
            android.graphics.drawable.Drawable r0 = r8.f12763e
            r0.setAlpha(r1)
            goto L40
        Ld:
            p0.a$d r0 = r8.f12766h
            int r3 = r0.f12791l
            if (r3 != 0) goto L14
            return
        L14:
            r4 = 2
            if (r3 != r4) goto L3b
            float[] r1 = r0.f12787h
            r3 = 1
            if (r1 != 0) goto L20
            float[] r1 = new float[r3]
            r0.f12787h = r1
        L20:
            float[] r1 = r0.f12787h
            android.graphics.Interpolator r4 = r0.f12789j
            android.graphics.Interpolator$Result r4 = r4.timeToValues(r1)
            android.graphics.Interpolator$Result r5 = android.graphics.Interpolator.Result.FREEZE_END
            if (r4 != r5) goto L2f
            r0.f12791l = r2
            goto L41
        L2f:
            android.graphics.drawable.Drawable r0 = r8.f12763e
            r1 = r1[r2]
            int r1 = java.lang.Math.round(r1)
            r0.setAlpha(r1)
            goto L41
        L3b:
            android.graphics.drawable.Drawable r0 = r8.f12763e
            r0.setAlpha(r1)
        L40:
            r3 = r2
        L41:
            boolean r0 = r8.u(r2)
            if (r0 == 0) goto L6b
            android.view.View r0 = r8.f12759a
            int r0 = r0.getScrollY()
            android.view.View r1 = r8.f12759a
            int r1 = r1.getScrollX()
            android.graphics.drawable.Drawable r2 = r8.f12763e
            android.graphics.Rect r4 = r8.f12762d
            int r5 = r4.left
            int r5 = r5 + r1
            int r6 = r4.top
            int r6 = r6 + r0
            int r7 = r4.right
            int r7 = r7 + r1
            int r1 = r4.bottom
            int r1 = r1 + r0
            r2.setBounds(r5, r6, r7, r1)
            android.graphics.drawable.Drawable r0 = r8.f12763e
            r0.draw(r9)
        L6b:
            if (r3 == 0) goto L72
            android.view.View r8 = r8.f12759a
            r8.invalidate()
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C0495a.i(android.graphics.Canvas):void");
    }

    private boolean k(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return m(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r0 != 3) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            float r1 = r8.getY()
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L37
            if (r0 == r3) goto L2a
            r8 = 2
            if (r0 == r8) goto L16
            if (r0 == r2) goto L2a
            goto L8e
        L16:
            boolean r8 = r7.f12768j
            if (r8 == 0) goto L8e
            float r8 = r7.f12761c
            float r8 = r1 - r8
            int r8 = java.lang.Math.round(r8)
            if (r8 == 0) goto L8e
            r7.u(r8)
            r7.f12761c = r1
            goto L8e
        L2a:
            boolean r8 = r7.f12768j
            if (r8 == 0) goto L8e
            r7.r(r4)
            r7.f12768j = r4
            r7.c()
            goto L8e
        L37:
            p0.a$d r0 = r7.f12766h
            int r0 = r0.f12791l
            if (r0 != 0) goto L40
            r7.f12768j = r4
            return r4
        L40:
            boolean r0 = r7.f12768j
            if (r0 != 0) goto L8e
            r7.u(r4)
            float r0 = r8.getX()
            android.graphics.Rect r5 = r7.f12762d
            int r6 = r5.top
            float r6 = (float) r6
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 < 0) goto L8e
            int r6 = r5.bottom
            float r6 = (float) r6
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 > 0) goto L8e
            int r6 = r5.left
            float r6 = (float) r6
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L8e
            int r5 = r5.right
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L8e
            r7.f12768j = r3
            r7.f12761c = r1
            p0.a$c r0 = r7.f12764f
            r0.superOnTouchEvent(r8)
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r8)
            r8.setAction(r2)
            p0.a$c r0 = r7.f12764f
            r0.superOnTouchEvent(r8)
            r8.recycle()
            r7.r(r3)
            r7.v(r4, r3)
            android.view.View r8 = r7.f12759a
            p0.a$d r0 = r7.f12766h
            r8.removeCallbacks(r0)
        L8e:
            boolean r8 = r7.f12768j
            if (r8 == 0) goto La1
            android.view.View r8 = r7.f12759a
            r8.invalidate()
            android.view.View r7 = r7.f12759a
            android.view.ViewParent r7 = r7.getParent()
            r7.requestDisallowInterceptTouchEvent(r3)
            return r3
        La1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C0495a.m(android.view.MotionEvent):boolean");
    }

    private void r(boolean z3) {
        this.f12763e.setState(z3 ? f12757m : f12758n);
        this.f12759a.invalidate();
    }

    private boolean u(int i3) {
        return v(i3, false);
    }

    private boolean v(int i3, boolean z3) {
        int width = this.f12762d.width();
        this.f12762d.right = this.f12769k ? width : this.f12759a.getWidth();
        Rect rect = this.f12762d;
        rect.left = this.f12769k ? 0 : rect.right - width;
        int superComputeVerticalScrollRange = this.f12764f.superComputeVerticalScrollRange();
        if (superComputeVerticalScrollRange <= 0) {
            return false;
        }
        int superComputeVerticalScrollOffset = this.f12764f.superComputeVerticalScrollOffset();
        int superComputeVerticalScrollExtent = this.f12764f.superComputeVerticalScrollExtent();
        int i4 = superComputeVerticalScrollRange - superComputeVerticalScrollExtent;
        if (i4 <= 0) {
            return false;
        }
        float f3 = i4;
        float f4 = (superComputeVerticalScrollOffset * 1.0f) / f3;
        float f5 = (superComputeVerticalScrollExtent * 1.0f) / superComputeVerticalScrollRange;
        int height = this.f12759a.getHeight();
        int max = this.f12767i ? Math.max(this.f12765g, Math.round(f5 * height)) : this.f12765g;
        Rect rect2 = this.f12762d;
        rect2.bottom = rect2.top + max;
        int i5 = height - max;
        float f6 = i5;
        int round = Math.round(f4 * f6);
        Rect rect3 = this.f12762d;
        rect3.offsetTo(rect3.left, round);
        if (i3 == 0) {
            return true;
        }
        int i6 = round + i3;
        if (i6 <= i5) {
            i5 = i6 < 0 ? 0 : i6;
        }
        int round2 = Math.round(f3 * ((i5 * 1.0f) / f6)) - superComputeVerticalScrollOffset;
        View view = this.f12759a;
        if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(round2, 0);
            return true;
        }
        view.scrollBy(0, round2);
        return true;
    }

    public boolean c() {
        return d(2000L);
    }

    public boolean d(long j3) {
        y.Z(this.f12759a);
        if (this.f12768j) {
            return false;
        }
        if (this.f12766h.f12791l == 0) {
            j3 = Math.max(750L, j3);
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + j3;
        d dVar = this.f12766h;
        dVar.f12790k = currentAnimationTimeMillis;
        dVar.f12791l = 1;
        this.f12759a.removeCallbacks(dVar);
        this.f12759a.postDelayed(this.f12766h, currentAnimationTimeMillis - AnimationUtils.currentAnimationTimeMillis());
        return false;
    }

    public void e(Canvas canvas) {
        i(canvas);
    }

    public void h() {
        if (this.f12770l) {
            g();
        }
    }

    public boolean j(MotionEvent motionEvent) {
        return k(motionEvent);
    }

    public boolean l(MotionEvent motionEvent) {
        return m(motionEvent);
    }

    public void n(View view, int i3) {
        if (this.f12770l && i3 == 0 && y.N(this.f12759a)) {
            g();
        }
    }

    public void o(int i3) {
        if (this.f12770l && i3 == 0) {
            g();
        }
    }

    public void p() {
        Drawable drawable = this.f12763e;
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            if (stateListDrawable.getStateCount() < 1) {
                return;
            }
            f(stateListDrawable, 0, androidx.core.content.a.c(this.f12759a.getContext(), AbstractC0293a.f7272a));
            f(stateListDrawable, 1, androidx.core.content.a.c(this.f12759a.getContext(), AbstractC0293a.f7272a));
        }
    }

    public void q() {
        this.f12759a = null;
    }

    public void s(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("setThumbDrawable must NOT be NULL");
        }
        this.f12763e = drawable;
        u(0);
    }

    public void t(int i3) {
        Rect rect = this.f12762d;
        rect.left = rect.right - i3;
        u(0);
    }

    private C0495a(c cVar, int i3, int i4, Drawable drawable, boolean z3) {
        this.f12768j = false;
        this.f12769k = false;
        this.f12770l = true;
        View cOUIScrollableView = cVar.getCOUIScrollableView();
        this.f12759a = cOUIScrollableView;
        cOUIScrollableView.setVerticalScrollBarEnabled(false);
        AbstractC0342a.b(this.f12759a, false);
        Context context = this.f12759a.getContext();
        this.f12769k = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.f12760b = context.getResources().getDisplayMetrics().density;
        this.f12765g = this.f12759a.getContext().getResources().getDimensionPixelSize(b2.b.f7277e);
        this.f12762d = new Rect(0, 0, i3, i4);
        this.f12763e = drawable;
        this.f12764f = cVar;
        this.f12766h = new d(ViewConfiguration.get(context), this.f12759a);
        this.f12767i = z3;
    }
}
