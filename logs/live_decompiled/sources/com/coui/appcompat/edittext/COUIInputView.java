package com.coui.appcompat.edittext;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.edittext.COUIEditText;
import d0.AbstractC0335a;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIInputView extends ConstraintLayout {

    /* renamed from: A, reason: collision with root package name */
    private View.OnFocusChangeListener f7832A;

    /* renamed from: B, reason: collision with root package name */
    private int f7833B;

    /* renamed from: C, reason: collision with root package name */
    CheckBox f7834C;

    /* renamed from: D, reason: collision with root package name */
    private int f7835D;

    /* renamed from: E, reason: collision with root package name */
    private String f7836E;

    /* renamed from: F, reason: collision with root package name */
    private String f7837F;

    /* renamed from: G, reason: collision with root package name */
    private Runnable f7838G;

    /* renamed from: e, reason: collision with root package name */
    protected View f7839e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f7840f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f7841g;

    /* renamed from: h, reason: collision with root package name */
    protected int f7842h;

    /* renamed from: i, reason: collision with root package name */
    protected int f7843i;

    /* renamed from: j, reason: collision with root package name */
    protected COUIEditText f7844j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f7845k;

    /* renamed from: l, reason: collision with root package name */
    protected CharSequence f7846l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7847m;

    /* renamed from: n, reason: collision with root package name */
    private int f7848n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7849o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f7850p;

    /* renamed from: q, reason: collision with root package name */
    protected TextView f7851q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f7852r;

    /* renamed from: s, reason: collision with root package name */
    private ValueAnimator f7853s;

    /* renamed from: t, reason: collision with root package name */
    private PathInterpolator f7854t;

    /* renamed from: u, reason: collision with root package name */
    private LinearLayout f7855u;

    /* renamed from: v, reason: collision with root package name */
    private Paint f7856v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7857w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7858x;

    /* renamed from: y, reason: collision with root package name */
    private ImageButton f7859y;

    /* renamed from: z, reason: collision with root package name */
    private TextWatcher f7860z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            COUIInputView.this.f7850p.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            COUIInputView.this.f7850p.setVisibility(8);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIInputView cOUIInputView = COUIInputView.this;
            cOUIInputView.f7844j.setPaddingRelative(0, cOUIInputView.getEdittextPaddingTop(), COUIInputView.this.getEdittextPaddingEnd(), COUIInputView.this.getEdittextPaddingBottom());
            TextView textView = COUIInputView.this.f7851q;
            textView.setPaddingRelative(textView.getPaddingStart(), COUIInputView.this.getTitlePaddingTop(), COUIInputView.this.f7851q.getPaddingEnd(), COUIInputView.this.f7851q.getPaddingBottom());
            y0.j.r(COUIInputView.this.f7839e, 1, (COUIInputView.this.getEdittextPaddingTop() - COUIInputView.this.getEdittextPaddingBottom()) / 2);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUIInputView.this.f7844j.getTextDeleteListener();
            COUIInputView.this.f7844j.G();
        }
    }

    class d implements COUIEditText.j {
        d() {
        }

        @Override // com.coui.appcompat.edittext.COUIEditText.j
        public void a(boolean z3) {
            COUIInputView.this.f7844j.setSelectAllOnFocus(z3);
            if (z3) {
                COUIInputView.this.Q();
            } else {
                COUIInputView.this.D();
            }
            COUIInputView.q(COUIInputView.this);
        }

        @Override // com.coui.appcompat.edittext.COUIEditText.j
        public void b(boolean z3) {
        }
    }

    class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            COUIInputView cOUIInputView = COUIInputView.this;
            if (cOUIInputView.f7841g && cOUIInputView.f7842h > 0) {
                cOUIInputView.getClass();
                int length = editable.length();
                COUIInputView cOUIInputView2 = COUIInputView.this;
                if (length < cOUIInputView2.f7842h) {
                    cOUIInputView2.f7840f.setText(length + "/" + COUIInputView.this.f7842h);
                    COUIInputView cOUIInputView3 = COUIInputView.this;
                    cOUIInputView3.f7840f.setTextColor(AbstractC0335a.a(cOUIInputView3.getContext(), M1.c.f1368m));
                } else {
                    cOUIInputView2.f7840f.setText(COUIInputView.this.f7842h + "/" + COUIInputView.this.f7842h);
                    COUIInputView cOUIInputView4 = COUIInputView.this;
                    cOUIInputView4.f7840f.setTextColor(AbstractC0335a.a(cOUIInputView4.getContext(), M1.c.f1364i));
                    COUIInputView cOUIInputView5 = COUIInputView.this;
                    int i3 = cOUIInputView5.f7842h;
                    if (length > i3) {
                        cOUIInputView5.f7844j.setText(editable.subSequence(0, i3));
                    }
                }
            }
            COUIInputView cOUIInputView6 = COUIInputView.this;
            cOUIInputView6.R(cOUIInputView6.hasFocus());
            COUIInputView.this.S(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            if (COUIInputView.this.J() && COUIInputView.this.f7858x) {
                COUIInputView.this.x(charSequence);
            }
        }
    }

    class f implements View.OnFocusChangeListener {
        f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            COUIInputView.this.R(z3);
            COUIInputView.this.S(true);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIInputView.this.f7859y.setVisibility(0);
        }
    }

    class h implements CompoundButton.OnCheckedChangeListener {
        h() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (z3) {
                COUIInputView cOUIInputView = COUIInputView.this;
                int i3 = cOUIInputView.f7843i;
                if (i3 == 1 || i3 == 2) {
                    cOUIInputView.f7844j.setInputType(2);
                    return;
                } else {
                    cOUIInputView.f7844j.setInputType(145);
                    return;
                }
            }
            COUIInputView cOUIInputView2 = COUIInputView.this;
            int i4 = cOUIInputView2.f7843i;
            if (i4 == 1 || i4 == 2) {
                cOUIInputView2.f7844j.setInputType(18);
            } else {
                cOUIInputView2.f7844j.setInputType(129);
            }
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIInputView.this.f7850p.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class j implements ValueAnimator.AnimatorUpdateListener {
        j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIInputView.this.f7850p.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface k {
    }

    public interface l {
    }

    public COUIInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        if (!this.f7849o) {
            this.f7850p.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(this.f7850p.getText())) {
            this.f7850p.setVisibility(0);
        }
        this.f7844j.j(new d());
    }

    private void C() {
        if (TextUtils.isEmpty(this.f7846l)) {
            return;
        }
        this.f7851q.setText(this.f7846l);
        this.f7851q.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ValueAnimator valueAnimator = this.f7852r;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7852r.cancel();
        }
        if (this.f7853s == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f7853s = ofFloat;
            ofFloat.setDuration(283L).setInterpolator(this.f7854t);
            this.f7853s.addUpdateListener(new j());
            this.f7853s.addListener(new a());
        }
        if (this.f7853s.isStarted()) {
            this.f7853s.cancel();
        }
        this.f7853s.start();
    }

    private void E() {
        C();
        this.f7844j.setTopHint(this.f7845k);
        if (this.f7857w) {
            this.f7844j.setDefaultStrokeColor(AbstractC0335a.a(getContext(), M1.c.f1374s));
        }
        y();
        B();
        A();
        F();
        S(false);
    }

    private void F() {
        if (this.f7859y == null || this.f7844j.E()) {
            return;
        }
        this.f7859y.setOnClickListener(new c());
    }

    private void G() {
        View view = this.f7839e;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.edittext.c
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    COUIInputView.this.L(view2, i3, i4, i5, i6, i7, i8, i9, i10);
                }
            });
        }
    }

    private boolean I() {
        return this.f7834C.getVisibility() == 0 ? this.f7847m : this.f7847m && getCustomButtonShowNum() < 2;
    }

    private boolean K() {
        return this.f7859y.getVisibility() == 0 ? this.f7844j.A() : this.f7844j.A() && getCustomButtonShowNum() < 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i9 - i7 != i5 - i3) {
            S(true);
        }
    }

    private void O(CharSequence charSequence) {
        if (this.f7836E != null) {
            String valueOf = String.valueOf(charSequence);
            int selectionStart = this.f7844j.getSelectionStart();
            this.f7844j.setText(valueOf);
            COUIEditText cOUIEditText = this.f7844j;
            cOUIEditText.setSelection(Math.min(selectionStart, cOUIEditText.getText().length()));
            this.f7836E = null;
        }
    }

    private void P() {
        int i3 = this.f7843i;
        if (i3 == -1) {
            return;
        }
        if (i3 == 0) {
            this.f7844j.setInputType(1);
            return;
        }
        if (i3 == 1) {
            this.f7844j.setInputType(2);
        } else if (i3 != 2) {
            this.f7844j.setInputType(0);
        } else {
            this.f7844j.setInputType(18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        ValueAnimator valueAnimator = this.f7853s;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7853s.cancel();
        }
        this.f7850p.setVisibility(0);
        if (this.f7852r == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f7852r = ofFloat;
            ofFloat.setDuration(217L).setInterpolator(this.f7854t);
            this.f7852r.addUpdateListener(new i());
        }
        if (this.f7852r.isStarted()) {
            this.f7852r.cancel();
        }
        this.f7852r.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(boolean z3) {
        if (this.f7859y != null) {
            if (!K() || !z3 || TextUtils.isEmpty(this.f7844j.getText().toString())) {
                this.f7859y.setVisibility(8);
            } else {
                if (y0.j.o(this.f7859y)) {
                    return;
                }
                this.f7859y.setVisibility(4);
                post(new g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z3) {
        if (!z3) {
            this.f7838G.run();
        } else {
            this.f7844j.removeCallbacks(this.f7838G);
            this.f7844j.post(this.f7838G);
        }
    }

    private int getCountTextWidth() {
        if (!this.f7841g) {
            return 0;
        }
        if (this.f7856v == null) {
            Paint paint = new Paint();
            this.f7856v = paint;
            paint.setTextSize(this.f7840f.getTextSize());
        }
        return ((int) this.f7856v.measureText((String) this.f7840f.getText())) + 8;
    }

    private int getCustomButtonShowNum() {
        TextView textView;
        View view = this.f7839e;
        if (!(view instanceof ViewGroup)) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i3 = 0;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt.getVisibility() == 0 && (textView = this.f7840f) != null && textView.getId() != childAt.getId()) {
                i3++;
            }
        }
        return i3;
    }

    static /* synthetic */ k q(COUIInputView cOUIInputView) {
        cOUIInputView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(CharSequence charSequence) {
        if (Locale.getDefault().getLanguage().equals("zh")) {
            String str = this.f7837F;
            if (str == null || !str.equals(charSequence.toString())) {
                this.f7837F = charSequence.toString();
                boolean b3 = com.coui.appcompat.edittext.f.b(charSequence);
                boolean a3 = com.coui.appcompat.edittext.f.a(charSequence);
                if (!b3 && !a3) {
                    O(charSequence);
                    return;
                }
                this.f7836E = charSequence.toString();
                SpannableString spannableString = new SpannableString(charSequence);
                int length = spannableString.length() / 4;
                for (int i3 = 0; i3 < length; i3++) {
                    if (b3) {
                        int i4 = (i3 + 1) * 4;
                        spannableString.setSpan(new com.coui.appcompat.edittext.e(), i4 - 2, i4 - 1, 17);
                    } else {
                        int i5 = (i3 + 1) * 4;
                        spannableString.setSpan(new com.coui.appcompat.edittext.e(), i5 - 1, i5, 17);
                    }
                }
                int selectionStart = this.f7844j.getSelectionStart();
                this.f7844j.setText(spannableString);
                COUIEditText cOUIEditText = this.f7844j;
                cOUIEditText.setSelection(Math.min(selectionStart, cOUIEditText.getText().length()));
            }
        }
    }

    protected void B() {
        if (!I()) {
            this.f7834C.setVisibility(8);
            P();
            return;
        }
        this.f7834C.setVisibility(0);
        if (this.f7848n == 1) {
            this.f7834C.setChecked(false);
            int i3 = this.f7843i;
            if (i3 == 1 || i3 == 2) {
                this.f7844j.setInputType(18);
            } else {
                this.f7844j.setInputType(129);
            }
        } else {
            this.f7834C.setChecked(true);
            int i4 = this.f7843i;
            if (i4 == 1 || i4 == 2) {
                this.f7844j.setInputType(2);
            } else {
                this.f7844j.setInputType(145);
            }
        }
        this.f7834C.setOnCheckedChangeListener(new h());
    }

    protected COUIEditText H(Context context, AttributeSet attributeSet) {
        context.getTheme().applyStyle(S1.f.f2108a, true);
        COUIEditText cOUIEditText = new COUIEditText(context, attributeSet, S1.a.f2084c);
        cOUIEditText.setShowDeleteIcon(false);
        cOUIEditText.setVerticalScrollBarEnabled(false);
        cOUIEditText.setMinHeight(this.f7835D);
        return cOUIEditText;
    }

    protected boolean J() {
        return false;
    }

    protected void M(Context context, AttributeSet attributeSet) {
        COUIEditText H3 = H(context, attributeSet);
        this.f7844j = H3;
        H3.setMaxLines(5);
        this.f7855u.addView(this.f7844j, -1, -2);
        E();
    }

    protected void N(Context context, AttributeSet attributeSet) {
        M(context, attributeSet);
    }

    public TextView getCountTextView() {
        return this.f7840f;
    }

    public COUIEditText getEditText() {
        return this.f7844j;
    }

    protected int getEdittextPaddingBottom() {
        return !TextUtils.isEmpty(this.f7846l) ? getResources().getDimensionPixelSize(S1.b.f2086b) : (int) getResources().getDimension(M1.f.f1455o);
    }

    protected int getEdittextPaddingEnd() {
        return this.f7839e.getWidth();
    }

    protected int getEdittextPaddingTop() {
        return !TextUtils.isEmpty(this.f7846l) ? getResources().getDimensionPixelSize(S1.b.f2087c) : (int) getResources().getDimension(M1.f.f1456p);
    }

    public CharSequence getHint() {
        return this.f7845k;
    }

    protected int getLayoutResId() {
        return S1.d.f2106b;
    }

    public int getMaxCount() {
        return this.f7842h;
    }

    public CharSequence getTitle() {
        return this.f7846l;
    }

    protected int getTitlePaddingTop() {
        return getResources().getDimensionPixelSize(S1.b.f2093i);
    }

    public void setCustomFormat(Boolean bool) {
        this.f7858x = bool.booleanValue();
        if (this.f7844j.getText() == null) {
            return;
        }
        if (J() && this.f7858x) {
            x(this.f7844j.getText());
        } else {
            O(this.f7844j.getText());
        }
    }

    public void setEnableError(boolean z3) {
        if (this.f7849o != z3) {
            this.f7849o = z3;
            A();
            S(false);
        }
    }

    public void setEnableInputCount(boolean z3) {
        this.f7841g = z3;
        y();
        S(true);
    }

    public void setEnablePassword(boolean z3) {
        if (this.f7847m != z3) {
            this.f7847m = z3;
            B();
            S(true);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        this.f7844j.setEnabled(z3);
        this.f7851q.setEnabled(z3);
        this.f7839e.setEnabled(z3);
        this.f7834C.setEnabled(z3);
        this.f7840f.setEnabled(z3);
    }

    public void setErrorStateChangeCallBack(k kVar) {
    }

    public void setHint(CharSequence charSequence) {
        this.f7845k = charSequence;
        this.f7844j.setTopHint(charSequence);
    }

    public void setMaxCount(int i3) {
        this.f7842h = i3;
        y();
    }

    public void setOnEditTextChangeListener(l lVar) {
    }

    public void setPasswordType(int i3) {
        if (this.f7848n != i3) {
            this.f7848n = i3;
            B();
            S(true);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null || charSequence.equals(this.f7846l)) {
            return;
        }
        this.f7846l = charSequence;
        C();
        S(false);
    }

    protected void y() {
        z();
        if (this.f7860z == null) {
            e eVar = new e();
            this.f7860z = eVar;
            this.f7844j.addTextChangedListener(eVar);
        }
        if (this.f7832A == null) {
            f fVar = new f();
            this.f7832A = fVar;
            this.f7844j.setOnFocusChangeListener(fVar);
        }
    }

    protected void z() {
        if (!this.f7841g || this.f7842h <= 0) {
            this.f7840f.setVisibility(8);
            return;
        }
        this.f7840f.setVisibility(0);
        this.f7840f.setText(this.f7844j.getText().length() + "/" + this.f7842h);
    }

    public COUIInputView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f7854t = new Y.b();
        this.f7856v = null;
        this.f7857w = false;
        this.f7858x = true;
        this.f7838G = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S1.g.f2114f, i3, 0);
        this.f7846l = obtainStyledAttributes.getText(S1.g.f2124p);
        this.f7845k = obtainStyledAttributes.getText(S1.g.f2119k);
        this.f7847m = obtainStyledAttributes.getBoolean(S1.g.f2118j, false);
        this.f7848n = obtainStyledAttributes.getInt(S1.g.f2123o, 0);
        this.f7849o = obtainStyledAttributes.getBoolean(S1.g.f2116h, false);
        this.f7842h = obtainStyledAttributes.getInt(S1.g.f2121m, 0);
        this.f7841g = obtainStyledAttributes.getBoolean(S1.g.f2117i, false);
        this.f7843i = obtainStyledAttributes.getInt(S1.g.f2122n, -1);
        this.f7858x = obtainStyledAttributes.getBoolean(S1.g.f2120l, true);
        this.f7857w = obtainStyledAttributes.getBoolean(S1.g.f2115g, false);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), (ViewGroup) this, true);
        this.f7851q = (TextView) findViewById(S1.c.f2104g);
        this.f7840f = (TextView) findViewById(S1.c.f2102e);
        this.f7850p = (TextView) findViewById(S1.c.f2103f);
        this.f7839e = findViewById(S1.c.f2098a);
        this.f7855u = (LinearLayout) findViewById(S1.c.f2101d);
        this.f7859y = (ImageButton) findViewById(S1.c.f2100c);
        this.f7834C = (CheckBox) findViewById(S1.c.f2099b);
        this.f7833B = getResources().getDimensionPixelSize(S1.b.f2094j);
        this.f7835D = getResources().getDimensionPixelOffset(S1.b.f2085a);
        N(context, attributeSet);
        G();
    }
}
