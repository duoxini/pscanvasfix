package com.coui.appcompat.poplist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.oplus.graphics.OplusOutline;
import com.oplus.graphics.OplusOutlineAdapter;
import com.oplus.graphics.OplusPath;
import com.oplus.graphics.OplusPathAdapter;
import d0.AbstractC0335a;
import h0.AbstractC0371a;
import n0.AbstractC0481a;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class RoundFrameLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private final Rect f8174e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f8175f;

    /* renamed from: g, reason: collision with root package name */
    private Path f8176g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f8177h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f8178i;

    /* renamed from: j, reason: collision with root package name */
    private float f8179j;

    /* renamed from: k, reason: collision with root package name */
    private float f8180k;

    /* renamed from: l, reason: collision with root package name */
    private float f8181l;

    /* renamed from: m, reason: collision with root package name */
    private int f8182m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8183n;

    /* renamed from: o, reason: collision with root package name */
    private float f8184o;

    /* renamed from: p, reason: collision with root package name */
    private y0.c f8185p;

    /* renamed from: q, reason: collision with root package name */
    private OplusPathAdapter f8186q;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (RoundFrameLayout.this.f8175f.isEmpty()) {
                RoundFrameLayout.this.f8174e.set((int) RoundFrameLayout.this.f8178i.left, (int) RoundFrameLayout.this.f8178i.top, (int) RoundFrameLayout.this.f8178i.right, (int) RoundFrameLayout.this.f8178i.bottom);
            } else {
                outline.setAlpha(RoundFrameLayout.this.f8181l);
                RoundFrameLayout.this.f8174e.set(RoundFrameLayout.this.f8175f);
            }
            float f3 = RoundFrameLayout.this.f8180k != 0.0f ? RoundFrameLayout.this.f8180k : RoundFrameLayout.this.f8179j;
            if (!AbstractC0481a.g(RoundFrameLayout.this.f8185p.x())) {
                outline.setRoundRect(RoundFrameLayout.this.f8174e, f3);
                return;
            }
            if (RoundFrameLayout.this.m()) {
                new OplusOutline(outline).setSmoothRoundRect(RoundFrameLayout.this.f8174e, f3, RoundFrameLayout.this.f8184o);
            } else if (RoundFrameLayout.this.n()) {
                new OplusOutlineAdapter(outline, 1).setSmoothRoundRect(RoundFrameLayout.this.f8174e, f3);
            } else {
                outline.setRoundRect(RoundFrameLayout.this.f8174e, f3);
            }
        }
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void l(Canvas canvas) {
        canvas.save();
        canvas.clipPath(o());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        return (AbstractC0481a.a() == 0 && this.f8184o > 0.0f) || this.f8185p.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return AbstractC0481a.a() == 1;
    }

    private Path o() {
        this.f8176g.reset();
        float f3 = this.f8180k;
        if (f3 == 0.0f) {
            f3 = this.f8179j;
        }
        if (!AbstractC0481a.g(this.f8185p.x())) {
            this.f8176g.addRoundRect(this.f8178i, f3, f3, Path.Direction.CW);
        } else if (m()) {
            new OplusPath(this.f8176g).addSmoothRoundRect(this.f8178i, f3, this.f8184o, Path.Direction.CW);
        } else if (n()) {
            if (this.f8186q == null) {
                this.f8186q = new OplusPathAdapter(this.f8176g, 1);
            }
            this.f8186q.addSmoothRoundRect(this.f8178i, f3, f3, Path.Direction.CCW);
        } else {
            this.f8176g.addRoundRect(this.f8178i, f3, f3, Path.Direction.CW);
        }
        return this.f8176g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.f8175f.isEmpty()) {
            getBackground().setBounds(this.f8175f);
        }
        l(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f8183n) {
            return false;
        }
        if (this.f8175f.isEmpty() || this.f8175f.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f8175f.isEmpty()) {
            getBackground().setBounds(this.f8175f);
        }
        super.draw(canvas);
    }

    boolean getUseBackgroundBlur() {
        return this.f8185p.x();
    }

    public void k() {
        this.f8175f.setEmpty();
        this.f8181l = 1.0f;
        invalidateOutline();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            AbstractC0371a.c("RoundFrameLayout", "Hardware accelerate is disabled! Set background blur failed.");
            return;
        }
        if (this.f8185p.x()) {
            this.f8185p.u(this);
            if (AbstractC0481a.e()) {
                AbstractC0371a.d("RoundFrameLayout", "current version support roundCorner when use blur");
                this.f8185p.t(AbstractC0335a.e(getContext(), M1.c.f1345C));
            }
            float f3 = this.f8180k;
            if (f3 == 0.0f) {
                f3 = this.f8179j;
            }
            this.f8185p.o(f3);
            this.f8185p.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8185p.k();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f8178i.set(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), i4 - getPaddingBottom());
    }

    void p(boolean z3, EnumC0643a enumC0643a) {
        this.f8185p.v(z3, enumC0643a);
    }

    public void q(int i3, int i4, int i5, int i6, float f3) {
        this.f8181l = f3;
        this.f8175f.set(i3, i4, i5, i6);
        if (getBackground() != null) {
            getBackground().setBounds(this.f8175f);
        }
        invalidateOutline();
    }

    public void setAllowDispatchEvent(boolean z3) {
        this.f8183n = z3;
    }

    @Override // android.view.View
    public void setAlpha(float f3) {
        super.setAlpha(f3);
        if (!this.f8185p.x() || getBackground() == null) {
            return;
        }
        getBackground().setAlpha((int) (f3 * 255.0f));
    }

    public void setClipMode(int i3) {
        this.f8182m = i3;
        if (i3 == 0) {
            setClipToOutline(false);
            setElevation(0.0f);
            setBackgroundColor(0);
        } else if (i3 == 1) {
            setClipToOutline(true);
            if (y0.i.a()) {
                y0.i.c(this, 3);
            } else {
                setElevation(getContext().getResources().getDimensionPixelSize(M1.f.f1439d0));
                setOutlineSpotShadowColor(androidx.core.content.a.c(getContext(), V1.b.f2533d));
            }
            setBackgroundColor(-1);
        }
    }

    public void setRadius(float f3) {
        this.f8179j = f3;
        postInvalidate();
    }

    public void setRoundCornerRadius(float f3) {
        this.f8180k = f3;
        postInvalidate();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8174e = new Rect();
        this.f8175f = new Rect();
        this.f8181l = 1.0f;
        this.f8183n = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V1.i.f2574b);
        this.f8180k = obtainStyledAttributes.getDimension(V1.i.f2576d, 0.0f);
        this.f8179j = obtainStyledAttributes.getDimension(V1.i.f2578f, 0.0f);
        this.f8182m = obtainStyledAttributes.getInt(V1.i.f2575c, 0);
        this.f8184o = obtainStyledAttributes.getFloat(V1.i.f2577e, 0.0f);
        obtainStyledAttributes.recycle();
        this.f8176g = new Path();
        this.f8177h = new Paint(1);
        this.f8178i = new RectF();
        this.f8177h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setOutlineProvider(new a());
        setClipMode(this.f8182m);
        setDefaultFocusHighlightEnabled(false);
        y0.c cVar = new y0.c(getContext());
        this.f8185p = cVar;
        cVar.r(y0.j.a(AbstractC0335a.h(getContext(), M1.e.f1403s)));
        this.f8185p.q(y0.j.a(AbstractC0335a.h(getContext(), M1.e.f1402r)));
        this.f8185p.m(y0.j.a(AbstractC0335a.h(getContext(), M1.e.f1401q)));
        this.f8185p.l(y0.j.a(AbstractC0335a.h(getContext(), M1.e.f1400p)));
    }
}
