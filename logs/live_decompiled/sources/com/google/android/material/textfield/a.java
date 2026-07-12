package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class a extends com.google.android.material.textfield.e {

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f9860e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f9861f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.f f9862g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout.g f9863h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f9864i;

    /* renamed from: j, reason: collision with root package name */
    private ValueAnimator f9865j;

    /* renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    class C0124a implements TextWatcher {
        C0124a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f9909a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.m());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            a aVar = a.this;
            aVar.i(aVar.m());
        }
    }

    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.this.m());
            editText.setOnFocusChangeListener(a.this.f9861f);
            a aVar = a.this;
            aVar.f9911c.setOnFocusChangeListener(aVar.f9861f);
            editText.removeTextChangedListener(a.this.f9860e);
            editText.addTextChangedListener(a.this.f9860e);
        }
    }

    class d implements TextInputLayout.g {

        /* renamed from: com.google.android.material.textfield.a$d$a, reason: collision with other inner class name */
        class RunnableC0125a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ EditText f9870e;

            RunnableC0125a(EditText editText) {
                this.f9870e = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f9870e.removeTextChangedListener(a.this.f9860e);
                a.this.i(true);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i3) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i3 != 2) {
                return;
            }
            editText.post(new RunnableC0125a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f9861f) {
                editText.setOnFocusChangeListener(null);
            }
            if (a.this.f9911c.getOnFocusChangeListener() == a.this.f9861f) {
                a.this.f9911c.setOnFocusChangeListener(null);
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f9909a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f9909a.U();
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f9909a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f9909a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f9911c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f9911c.setScaleX(floatValue);
            a.this.f9911c.setScaleY(floatValue);
        }
    }

    a(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout, i3);
        this.f9860e = new C0124a();
        this.f9861f = new b();
        this.f9862g = new c();
        this.f9863h = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z3) {
        boolean z4 = this.f9909a.K() == z3;
        if (z3 && !this.f9864i.isRunning()) {
            this.f9865j.cancel();
            this.f9864i.start();
            if (z4) {
                this.f9864i.end();
                return;
            }
            return;
        }
        if (z3) {
            return;
        }
        this.f9864i.cancel();
        this.f9865j.start();
        if (z4) {
            this.f9865j.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(I0.a.f914a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(I0.a.f917d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    private void l() {
        ValueAnimator k3 = k();
        ValueAnimator j3 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f9864i = animatorSet;
        animatorSet.playTogether(k3, j3);
        this.f9864i.addListener(new f());
        ValueAnimator j4 = j(1.0f, 0.0f);
        this.f9865j = j4;
        j4.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        EditText editText = this.f9909a.getEditText();
        return editText != null && (editText.hasFocus() || this.f9911c.hasFocus()) && editText.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        TextInputLayout textInputLayout = this.f9909a;
        int i3 = this.f9912d;
        if (i3 == 0) {
            i3 = H0.d.f549f;
        }
        textInputLayout.setEndIconDrawable(i3);
        TextInputLayout textInputLayout2 = this.f9909a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(H0.h.f624e));
        this.f9909a.setEndIconCheckable(false);
        this.f9909a.setEndIconOnClickListener(new e());
        this.f9909a.g(this.f9862g);
        this.f9909a.h(this.f9863h);
        l();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z3) {
        if (this.f9909a.getSuffixText() == null) {
            return;
        }
        i(z3);
    }
}
