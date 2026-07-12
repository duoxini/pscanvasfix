package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.y;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class d extends com.google.android.material.textfield.e {

    /* renamed from: r, reason: collision with root package name */
    private static final boolean f9879r = true;

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f9880e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f9881f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.e f9882g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout.f f9883h;

    /* renamed from: i, reason: collision with root package name */
    private final TextInputLayout.g f9884i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9885j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9886k;

    /* renamed from: l, reason: collision with root package name */
    private long f9887l;

    /* renamed from: m, reason: collision with root package name */
    private StateListDrawable f9888m;

    /* renamed from: n, reason: collision with root package name */
    private U0.g f9889n;

    /* renamed from: o, reason: collision with root package name */
    private AccessibilityManager f9890o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f9891p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f9892q;

    class a extends TextWatcherAdapter {

        /* renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        class RunnableC0126a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f9894e;

            RunnableC0126a(AutoCompleteTextView autoCompleteTextView) {
                this.f9894e = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f9894e.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.f9885j = isPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView y3 = d.y(d.this.f9909a.getEditText());
            if (d.this.f9890o.isTouchExplorationEnabled() && d.D(y3) && !d.this.f9911c.hasFocus()) {
                y3.dismissDropDown();
            }
            y3.post(new RunnableC0126a(y3));
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f9911c.setChecked(dVar.f9886k);
            d.this.f9892q.start();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f9911c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    class ViewOnFocusChangeListenerC0127d implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC0127d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            d.this.f9909a.setEndIconActivated(z3);
            if (z3) {
                return;
            }
            d.this.E(false);
            d.this.f9885j = false;
        }
    }

    class e extends TextInputLayout.e {
        e(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (!d.D(d.this.f9909a.getEditText())) {
                dVar.Q(Spinner.class.getName());
            }
            if (dVar.E()) {
                dVar.b0(null);
            }
        }

        @Override // androidx.core.view.C0252a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView y3 = d.y(d.this.f9909a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f9890o.isEnabled() && !d.D(d.this.f9909a.getEditText())) {
                d.this.H(y3);
                d.this.I();
            }
        }
    }

    class f implements TextInputLayout.f {
        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView y3 = d.y(textInputLayout.getEditText());
            d.this.F(y3);
            d.this.v(y3);
            d.this.G(y3);
            y3.setThreshold(0);
            y3.removeTextChangedListener(d.this.f9880e);
            y3.addTextChangedListener(d.this.f9880e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(y3) && d.this.f9890o.isTouchExplorationEnabled()) {
                y.u0(d.this.f9911c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f9882g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    class g implements TextInputLayout.g {

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f9902e;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f9902e = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f9902e.removeTextChangedListener(d.this.f9880e);
            }
        }

        g() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i3) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i3 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f9881f) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.f9879r) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.H((AutoCompleteTextView) d.this.f9909a.getEditText());
        }
    }

    class i implements AccessibilityManager.TouchExplorationStateChangeListener {
        i() {
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z3) {
            if (d.this.f9909a.getEditText() == null || d.D(d.this.f9909a.getEditText())) {
                return;
            }
            y.u0(d.this.f9911c, z3 ? 2 : 1);
        }
    }

    class j implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f9906e;

        j(AutoCompleteTextView autoCompleteTextView) {
            this.f9906e = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f9885j = false;
                }
                d.this.H(this.f9906e);
                d.this.I();
            }
            return false;
        }
    }

    class k implements AutoCompleteTextView.OnDismissListener {
        k() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.I();
            d.this.E(false);
        }
    }

    d(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout, i3);
        this.f9880e = new a();
        this.f9881f = new ViewOnFocusChangeListenerC0127d();
        this.f9882g = new e(this.f9909a);
        this.f9883h = new f();
        this.f9884i = new g();
        this.f9885j = false;
        this.f9886k = false;
        this.f9887l = Long.MAX_VALUE;
    }

    private U0.g A(float f3, float f4, float f5, int i3) {
        U0.k m3 = U0.k.a().D(f3).I(f3).t(f4).y(f4).m();
        U0.g l3 = U0.g.l(this.f9910b, f5);
        l3.setShapeAppearanceModel(m3);
        l3.W(0, i3, 0, i3);
        return l3;
    }

    private void B() {
        this.f9892q = z(67, 0.0f, 1.0f);
        ValueAnimator z3 = z(50, 1.0f, 0.0f);
        this.f9891p = z3;
        z3.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f9887l;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z3) {
        if (this.f9886k != z3) {
            this.f9886k = z3;
            this.f9892q.cancel();
            this.f9891p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(AutoCompleteTextView autoCompleteTextView) {
        if (f9879r) {
            int boxBackgroundMode = this.f9909a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f9889n);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f9888m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new j(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f9881f);
        if (f9879r) {
            autoCompleteTextView.setOnDismissListener(new k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f9885j = false;
        }
        if (this.f9885j) {
            this.f9885j = false;
            return;
        }
        if (f9879r) {
            E(!this.f9886k);
        } else {
            this.f9886k = !this.f9886k;
            this.f9911c.toggle();
        }
        if (!this.f9886k) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.f9885j = true;
        this.f9887l = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.f9909a.getBoxBackgroundMode();
        U0.g boxBackground = this.f9909a.getBoxBackground();
        int d3 = L0.a.d(autoCompleteTextView, H0.a.f478j);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            x(autoCompleteTextView, d3, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            w(autoCompleteTextView, d3, iArr, boxBackground);
        }
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i3, int[][] iArr, U0.g gVar) {
        int boxBackgroundColor = this.f9909a.getBoxBackgroundColor();
        int[] iArr2 = {L0.a.h(i3, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f9879r) {
            y.n0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        U0.g gVar2 = new U0.g(gVar.B());
        gVar2.U(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int C3 = y.C(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int B3 = y.B(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        y.n0(autoCompleteTextView, layerDrawable);
        y.y0(autoCompleteTextView, C3, paddingTop, B3, paddingBottom);
    }

    private void x(AutoCompleteTextView autoCompleteTextView, int i3, int[][] iArr, U0.g gVar) {
        LayerDrawable layerDrawable;
        int d3 = L0.a.d(autoCompleteTextView, H0.a.f482n);
        U0.g gVar2 = new U0.g(gVar.B());
        int h3 = L0.a.h(i3, d3, 0.1f);
        gVar2.U(new ColorStateList(iArr, new int[]{h3, 0}));
        if (f9879r) {
            gVar2.setTint(d3);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{h3, d3});
            U0.g gVar3 = new U0.g(gVar.B());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        y.n0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i3, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(I0.a.f914a);
        ofFloat.setDuration(i3);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    void J(AutoCompleteTextView autoCompleteTextView) {
        if (!D(autoCompleteTextView) && this.f9909a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            v(autoCompleteTextView);
        }
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        float dimensionPixelOffset = this.f9910b.getResources().getDimensionPixelOffset(H0.c.f512L);
        float dimensionPixelOffset2 = this.f9910b.getResources().getDimensionPixelOffset(H0.c.f509I);
        int dimensionPixelOffset3 = this.f9910b.getResources().getDimensionPixelOffset(H0.c.f510J);
        U0.g A3 = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        U0.g A4 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f9889n = A3;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f9888m = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, A3);
        this.f9888m.addState(new int[0], A4);
        int i3 = this.f9912d;
        if (i3 == 0) {
            i3 = f9879r ? H0.d.f547d : H0.d.f548e;
        }
        this.f9909a.setEndIconDrawable(i3);
        TextInputLayout textInputLayout = this.f9909a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(H0.h.f626g));
        this.f9909a.setEndIconOnClickListener(new h());
        this.f9909a.g(this.f9883h);
        this.f9909a.h(this.f9884i);
        B();
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f9910b.getSystemService("accessibility");
        this.f9890o = accessibilityManager;
        accessibilityManager.addTouchExplorationStateChangeListener(new i());
    }

    @Override // com.google.android.material.textfield.e
    boolean b(int i3) {
        return i3 != 0;
    }

    @Override // com.google.android.material.textfield.e
    boolean d() {
        return true;
    }
}
