package com.coui.appcompat.progressbar;

import X1.g;
import Z.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.y;

/* loaded from: classes.dex */
public abstract class a extends AppCompatButton {

    /* renamed from: h, reason: collision with root package name */
    private final String f8924h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f8925i;

    /* renamed from: j, reason: collision with root package name */
    private final AccessibilityManager f8926j;

    /* renamed from: k, reason: collision with root package name */
    private final B.c f8927k;

    /* renamed from: l, reason: collision with root package name */
    public int f8928l;

    /* renamed from: m, reason: collision with root package name */
    public int f8929m;

    /* renamed from: n, reason: collision with root package name */
    public int f8930n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f8931o;

    /* renamed from: p, reason: collision with root package name */
    protected float f8932p;

    /* renamed from: q, reason: collision with root package name */
    private int f8933q;

    /* renamed from: r, reason: collision with root package name */
    protected Drawable f8934r;

    /* renamed from: s, reason: collision with root package name */
    protected Drawable f8935s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8936t;

    /* renamed from: u, reason: collision with root package name */
    private e f8937u;

    /* renamed from: v, reason: collision with root package name */
    private e f8938v;

    /* renamed from: w, reason: collision with root package name */
    private c f8939w;

    /* renamed from: x, reason: collision with root package name */
    private Z.c f8940x;

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f8922y = {X1.a.f2865d};

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f8923z = {X1.a.f2868g};

    /* renamed from: A, reason: collision with root package name */
    private static final int[] f8920A = {X1.a.f2866e};

    /* renamed from: B, reason: collision with root package name */
    private static final int[] f8921B = {X1.a.f2867f};

    /* renamed from: com.coui.appcompat.progressbar.a$a, reason: collision with other inner class name */
    class C0109a extends B.c {
        C0109a(String str) {
            super(str);
        }

        @Override // B.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(Float f3) {
            return 0.0f;
        }

        @Override // B.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Float f3, float f4) {
            a aVar = a.this;
            aVar.f8932p = f4;
            a.a(aVar);
            a.this.invalidate();
        }
    }

    class b implements b.q {
        b() {
        }

        @Override // Z.b.q
        public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
            a.this.f8931o = false;
        }
    }

    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.sendAccessibilityEvent(4);
        }

        /* synthetic */ c(a aVar, C0109a c0109a) {
            this();
        }
    }

    public interface d {
    }

    public interface e {
        void a(a aVar, int i3);
    }

    static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new C0110a();

        /* renamed from: e, reason: collision with root package name */
        int f8944e;

        /* renamed from: f, reason: collision with root package name */
        int f8945f;

        /* renamed from: com.coui.appcompat.progressbar.a$f$a, reason: collision with other inner class name */
        class C0110a implements Parcelable.Creator {
            C0110a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i3) {
                return new f[i3];
            }
        }

        /* synthetic */ f(Parcel parcel, C0109a c0109a) {
            this(parcel);
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " mState = " + this.f8944e + " mProgress = " + this.f8945f + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Integer.valueOf(this.f8944e));
            parcel.writeValue(Integer.valueOf(this.f8945f));
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        private f(Parcel parcel) {
            super(parcel);
            this.f8944e = ((Integer) parcel.readValue(null)).intValue();
            this.f8945f = ((Integer) parcel.readValue(null)).intValue();
        }
    }

    public a(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, X1.f.f2894d);
    }

    static /* synthetic */ d a(a aVar) {
        aVar.getClass();
        return null;
    }

    private void b() {
        this.f8929m = 0;
        this.f8930n = 100;
    }

    private void d(int i3) {
        if (this.f8940x == null) {
            this.f8940x = new Z.c(Float.valueOf(this.f8932p), this.f8927k);
            Z.d dVar = new Z.d();
            dVar.d(0.0f);
            dVar.g(1.0f);
            this.f8940x.B(dVar);
            this.f8940x.a(new b());
        }
        if (this.f8940x.h()) {
            this.f8931o = true;
            this.f8940x.u(this.f8929m * 1.0f);
            return;
        }
        float f3 = i3 * 1.0f;
        this.f8932p = f3;
        if (Math.abs(f3 - this.f8929m) <= 1.0E-7f) {
            this.f8931o = false;
            invalidate();
            return;
        }
        this.f8940x.o(this.f8932p);
        this.f8940x.u(this.f8929m * 1.0f);
        this.f8940x.p(0.0f);
        this.f8940x.r();
        this.f8931o = true;
    }

    private void e() {
        c cVar = this.f8939w;
        if (cVar == null) {
            this.f8939w = new c(this, null);
        } else {
            removeCallbacks(cVar);
        }
        postDelayed(this.f8939w, 10L);
    }

    private void g() {
        Z.c cVar = this.f8940x;
        if (cVar == null || !cVar.h()) {
            return;
        }
        this.f8931o = false;
        if (this.f8940x.v()) {
            this.f8940x.C();
        } else {
            this.f8940x.c();
        }
    }

    void c(int i3) {
        AccessibilityManager accessibilityManager = this.f8926j;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && androidx.core.view.accessibility.c.a(this.f8926j)) {
            e();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8934r != null) {
            this.f8934r.setState(getDrawableState());
            invalidate();
        }
    }

    public void f(int i3, boolean z3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.f8930n;
        if (i3 > i4) {
            i3 = i4;
        }
        if (z3) {
            int i5 = this.f8929m;
            if (i3 != i5) {
                this.f8929m = i3;
            }
            d(i5);
            return;
        }
        if (i3 != this.f8929m) {
            this.f8929m = i3;
        }
        if (this.f8931o) {
            this.f8931o = false;
        }
        invalidate();
        c(i3);
    }

    public int getMax() {
        return this.f8930n;
    }

    public int getProgress() {
        return this.f8929m;
    }

    public int getState() {
        return this.f8928l;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8934r;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (getState() == 0) {
            View.mergeDrawableStates(onCreateDrawableState, f8922y);
        }
        if (getState() == 1) {
            View.mergeDrawableStates(onCreateDrawableState, f8921B);
        }
        if (getState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f8923z);
        }
        if (getState() == 3) {
            View.mergeDrawableStates(onCreateDrawableState, f8920A);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        c cVar = this.f8939w;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        g();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        setState(fVar.f8944e);
        setProgress(fVar.f8945f);
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        setFreezesText(true);
        f fVar = new f(super.onSaveInstanceState());
        fVar.f8944e = getState();
        fVar.f8945f = this.f8929m;
        return fVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (i3 == 8 || i3 == 4) {
            g();
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setButtonDrawable(int i3) {
        if (i3 == 0 || i3 != this.f8933q) {
            this.f8933q = i3;
            setButtonDrawable(i3 != 0 ? getResources().getDrawable(this.f8933q) : null);
        }
    }

    public void setMax(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 != this.f8930n) {
            this.f8930n = i3;
            if (this.f8929m > i3) {
                this.f8929m = i3;
            }
            invalidate();
        }
    }

    public void setOnStateChangeListener(e eVar) {
        this.f8937u = eVar;
    }

    void setOnStateChangeWidgetListener(e eVar) {
        this.f8938v = eVar;
    }

    public void setProgress(int i3) {
        f(i3, true);
    }

    public void setState(int i3) {
        if (this.f8928l != i3) {
            this.f8928l = i3;
            refreshDrawableState();
            if (this.f8936t) {
                return;
            }
            this.f8936t = true;
            e eVar = this.f8937u;
            if (eVar != null) {
                eVar.a(this, this.f8928l);
            }
            e eVar2 = this.f8938v;
            if (eVar2 != null) {
                eVar2.a(this, this.f8928l);
            }
            this.f8936t = false;
        }
    }

    public void setVisualProgressAnimationListener(d dVar) {
    }

    public void toggle() {
        int i3 = this.f8928l;
        if (i3 == 0) {
            setState(1);
            return;
        }
        if (i3 == 1) {
            setState(2);
        } else if (i3 == 2) {
            setState(1);
        } else if (i3 == 3) {
            setState(1);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8934r;
    }

    public a(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        this.f8924h = "COUILoadProgress";
        this.f8925i = false;
        this.f8927k = new C0109a("VisualProgressProperty");
        this.f8931o = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f2902G, i3, i4);
        int integer = obtainStyledAttributes.getInteger(g.f2905J, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(g.f2903H);
        if (drawable != null) {
            setButtonDrawable(drawable);
        }
        setProgress(obtainStyledAttributes.getInt(g.f2904I, this.f8929m));
        setState(integer);
        obtainStyledAttributes.recycle();
        b();
        if (y.v(this) == 0) {
            y.u0(this, 1);
        }
        this.f8926j = (AccessibilityManager) context.getSystemService("accessibility");
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.f8934r;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f8934r);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.f8934r = drawable;
            this.f8935s = drawable.getConstantState().newDrawable();
            this.f8934r.setState(null);
            setMinHeight(this.f8934r.getIntrinsicHeight());
            refreshDrawableState();
            return;
        }
        this.f8934r = null;
        this.f8935s = null;
        this.f8933q = 0;
    }
}
