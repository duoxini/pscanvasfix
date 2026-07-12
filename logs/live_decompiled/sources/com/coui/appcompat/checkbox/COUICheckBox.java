package com.coui.appcompat.checkbox;

import M1.g;
import M1.k;
import M1.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.b0;
import androidx.core.content.res.f;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import r0.C0560b;
import r0.C0561c;

/* loaded from: classes.dex */
public class COUICheckBox extends AppCompatButton implements Checkable {

    /* renamed from: s, reason: collision with root package name */
    private static final boolean f7616s;

    /* renamed from: t, reason: collision with root package name */
    private static final int[] f7617t;

    /* renamed from: u, reason: collision with root package name */
    private static final int[] f7618u;

    /* renamed from: v, reason: collision with root package name */
    private static final Rect f7619v;

    /* renamed from: h, reason: collision with root package name */
    private int f7620h;

    /* renamed from: i, reason: collision with root package name */
    private int f7621i;

    /* renamed from: j, reason: collision with root package name */
    private int f7622j;

    /* renamed from: k, reason: collision with root package name */
    private C0561c f7623k;

    /* renamed from: l, reason: collision with root package name */
    private C0560b f7624l;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f7625m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7626n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f7627o;

    /* renamed from: p, reason: collision with root package name */
    private int f7628p;

    /* renamed from: q, reason: collision with root package name */
    private AccessibilityManager f7629q;

    /* renamed from: r, reason: collision with root package name */
    private int f7630r;

    static class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference f7631e;

        /* renamed from: f, reason: collision with root package name */
        private final AttributeSet f7632f;

        /* renamed from: g, reason: collision with root package name */
        private final int f7633g;

        public b(COUICheckBox cOUICheckBox, AttributeSet attributeSet, int i3) {
            this.f7631e = new WeakReference(cOUICheckBox);
            this.f7632f = attributeSet;
            this.f7633g = i3;
        }

        private void b(final COUICheckBox cOUICheckBox, final Drawable drawable) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                cOUICheckBox.f(drawable);
            } else {
                cOUICheckBox.postOnAnimation(new Runnable() { // from class: com.coui.appcompat.checkbox.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        COUICheckBox.c(COUICheckBox.this, drawable);
                    }
                });
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            COUICheckBox cOUICheckBox = (COUICheckBox) this.f7631e.get();
            if (cOUICheckBox != null && cOUICheckBox.k()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (COUICheckBox.f7616s) {
                    Log.d("COUICheckBox", "runnable run, current thread = " + Thread.currentThread() + " start time = " + currentTimeMillis);
                }
                TypedArray obtainStyledAttributes = cOUICheckBox.getContext().obtainStyledAttributes(this.f7632f, m.f1586w, this.f7633g, 0);
                Drawable drawable = obtainStyledAttributes.getDrawable(m.f1590y);
                if (drawable != null) {
                    b(cOUICheckBox, drawable);
                }
                if (COUICheckBox.f7616s) {
                    Log.d("COUICheckBox", "end time = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    public interface c {
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f7634e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " state=" + this.f7634e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Integer.valueOf(this.f7634e));
        }

        d(Parcelable parcelable) {
            super(parcelable);
            this.f7634e = 0;
        }

        private d(Parcel parcel) {
            super(parcel);
            this.f7634e = 0;
            this.f7634e = ((Integer) parcel.readValue(null)).intValue();
        }
    }

    static {
        f7616s = AbstractC0371a.f11873b || AbstractC0371a.e("COUICheckBox", 3);
        f7617t = new int[]{M1.c.f1354L};
        f7618u = new int[]{M1.c.f1355M};
        f7619v = new Rect();
    }

    public COUICheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, M1.c.f1356a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(COUICheckBox cOUICheckBox, Drawable drawable) {
        cOUICheckBox.f(drawable);
    }

    private void d(Runnable runnable) {
        y0.d.e().i(runnable);
        postDelayed(runnable, 100L);
        g(this.f7621i);
    }

    private void e() {
        if (isFocusable() || isClickable()) {
            this.f7624l.q(true);
        } else {
            this.f7624l.q(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Drawable drawable) {
        setButtonDrawable(drawable);
        j(drawable, this.f7621i);
        int i3 = this.f7621i;
        this.f7621i = -1;
        setState(i3);
    }

    private void g(int i3) {
        int i4 = i3 != 0 ? i3 != 1 ? i3 != 2 ? -1 : isEnabled() ? g.f1471e : g.f1470d : isEnabled() ? g.f1473g : g.f1472f : isEnabled() ? g.f1469c : g.f1468b;
        if (i4 != -1) {
            setButtonDrawable(i4);
        }
    }

    private CharSequence getButtonStateDescription() {
        int i3 = this.f7620h;
        return i3 == 2 ? getContext().getResources().getString(k.f1491a) : i3 == 0 ? getContext().getResources().getString(k.f1496f) : getContext().getResources().getString(k.f1492b);
    }

    private void h() {
        this.f7623k.setBounds(f7619v);
    }

    private void i() {
        C0560b c0560b = new C0560b(getContext());
        this.f7624l = c0560b;
        c0560b.v(C0560b.t(getContext(), 1));
        C0561c c0561c = new C0561c(new Drawable[]{getBackground() == null ? new ColorDrawable(0) : getBackground(), this.f7624l});
        this.f7623k = c0561c;
        super.setBackground(c0561c);
        AbstractC0342a.b(this, false);
    }

    private void j(Drawable drawable, int i3) {
        if (i3 == 1) {
            drawable.setState(f7618u);
        } else if (i3 == 2) {
            drawable.setState(f7617t);
        }
        drawable.jumpToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return this.f7625m.compareAndSet(false, true);
    }

    private void l() {
        Drawable drawable = this.f7627o;
        if (drawable != null) {
            int gravity = getGravity() & FeedbackActivity.SHOW_NO_NETWORK;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int height = gravity != 16 ? gravity != 80 ? 0 : getHeight() - intrinsicHeight : (getHeight() - intrinsicHeight) / 2;
            f7619v.set(b0.b(this) ? (getWidth() - intrinsicWidth) - getPaddingRight() : getPaddingLeft(), height, b0.b(this) ? getWidth() - getPaddingRight() : intrinsicWidth + getPaddingLeft(), intrinsicHeight + height);
        }
    }

    private void m() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (this.f7629q == null) {
            this.f7629q = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
        if (this.f7629q.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            obtain.setContentChangeTypes(64);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (isEnabled() && motionEvent.getActionMasked() == 9) {
            setHovered(true);
        }
        if (motionEvent.getActionMasked() == 10 && isHovered()) {
            setHovered(false);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        l();
        e();
        h();
        super.draw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f7627o != null) {
            this.f7627o.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "android.widget.CompoundButton";
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        Drawable drawable;
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (b0.b(this) || (drawable = this.f7627o) == null) {
            return compoundPaddingLeft;
        }
        int intrinsicWidth = compoundPaddingLeft + drawable.getIntrinsicWidth();
        return !TextUtils.isEmpty(getText()) ? intrinsicWidth + this.f7630r : intrinsicWidth;
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        Drawable drawable;
        int compoundPaddingRight = super.getCompoundPaddingRight();
        if (!b0.b(this) || (drawable = this.f7627o) == null) {
            return compoundPaddingRight;
        }
        int intrinsicWidth = compoundPaddingRight + drawable.getIntrinsicWidth();
        return !TextUtils.isEmpty(getText()) ? intrinsicWidth + this.f7630r : intrinsicWidth;
    }

    @ViewDebug.ExportedProperty
    public int getState() {
        return this.f7620h;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return getState() == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f7627o;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (getState() == 1) {
            View.mergeDrawableStates(onCreateDrawableState, f7618u);
        }
        if (getState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f7617t);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f7627o;
        if (drawable != null) {
            Rect rect = f7619v;
            drawable.setBounds(rect);
            drawable.draw(canvas);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.f7620h == 2) {
            accessibilityEvent.setChecked(true);
        } else {
            accessibilityEvent.setChecked(false);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCheckable(true);
        if (this.f7620h == 2) {
            accessibilityNodeInfo.setChecked(true);
        } else {
            accessibilityNodeInfo.setChecked(false);
        }
        accessibilityNodeInfo.setClassName("android.widget.CompoundButton");
        accessibilityNodeInfo.setStateDescription(getButtonStateDescription());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setState(dVar.f7634e);
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f7634e = getState();
        return dVar;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        C0561c c0561c = this.f7623k;
        if (c0561c == null) {
            super.setBackground(drawable);
        } else if (drawable == null) {
            c0561c.h(new ColorDrawable(0));
        } else {
            c0561c.h(drawable);
        }
    }

    public void setButtonDrawable(int i3) {
        if (i3 == 0 || i3 != this.f7622j) {
            this.f7622j = i3;
            setButtonDrawable(i3 != 0 ? f.f(getResources(), this.f7622j, getContext().getTheme()) : null);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (z3) {
            setState(2);
        } else {
            setState(0);
        }
    }

    public void setOnStateChangeListener(c cVar) {
    }

    public void setState(int i3) {
        if (this.f7621i != -1) {
            this.f7621i = i3;
            g(i3);
        } else if (this.f7620h != i3) {
            this.f7620h = i3;
            refreshDrawableState();
            if (this.f7626n) {
                return;
            }
            this.f7626n = false;
            m();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setState(this.f7620h >= 2 ? 0 : 2);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7627o;
    }

    public COUICheckBox(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f7625m = new AtomicBoolean(false);
        if (attributeSet == null || attributeSet.getStyleAttribute() == 0) {
            this.f7628p = i3;
        } else {
            this.f7628p = attributeSet.getStyleAttribute();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1586w, i3, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(m.f1588x, false);
        int resourceId = obtainStyledAttributes.getResourceId(m.f1590y, -1);
        int integer = obtainStyledAttributes.getInteger(m.f1592z, 0);
        this.f7621i = integer;
        if (f7616s) {
            StringBuilder sb = new StringBuilder();
            sb.append("asyncLoad = ");
            sb.append(z3);
            sb.append(" drawable check = ");
            sb.append(resourceId == g.f1474h);
            sb.append(" thread check = ");
            sb.append(Looper.getMainLooper() == Looper.myLooper());
            Log.d("COUICheckBox", sb.toString());
        }
        if (z3 && resourceId == g.f1474h && Looper.getMainLooper() == Looper.myLooper()) {
            d(new b(this, attributeSet, i3));
        } else {
            Drawable drawable = obtainStyledAttributes.getDrawable(m.f1590y);
            if (drawable != null) {
                setButtonDrawable(drawable);
                this.f7621i = -1;
                setState(integer);
            }
        }
        obtainStyledAttributes.recycle();
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.f7628p = styleAttribute;
            if (styleAttribute == 0) {
                this.f7628p = i3;
            }
        } else {
            this.f7628p = i3;
        }
        i();
        this.f7630r = getContext().getResources().getDimensionPixelSize(M1.f.f1452l);
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.f7627o;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f7627o);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.f7627o = drawable;
            drawable.setState(null);
            setMinHeight(this.f7627o.getIntrinsicHeight());
        }
        refreshDrawableState();
    }
}
