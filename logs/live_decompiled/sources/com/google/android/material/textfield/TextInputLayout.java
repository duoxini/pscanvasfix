package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0235i;
import androidx.appcompat.widget.C0251z;
import androidx.appcompat.widget.E;
import androidx.core.view.AbstractC0259h;
import androidx.core.view.C0252a;
import androidx.core.view.y;
import androidx.transition.C0284d;
import androidx.transition.n;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import f.AbstractC0348a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: M0, reason: collision with root package name */
    private static final int f9766M0 = H0.i.f645j;

    /* renamed from: A, reason: collision with root package name */
    private C0284d f9767A;

    /* renamed from: A0, reason: collision with root package name */
    private int f9768A0;

    /* renamed from: B, reason: collision with root package name */
    private C0284d f9769B;

    /* renamed from: B0, reason: collision with root package name */
    private int f9770B0;

    /* renamed from: C, reason: collision with root package name */
    private ColorStateList f9771C;

    /* renamed from: C0, reason: collision with root package name */
    private int f9772C0;

    /* renamed from: D, reason: collision with root package name */
    private ColorStateList f9773D;

    /* renamed from: D0, reason: collision with root package name */
    private int f9774D0;

    /* renamed from: E, reason: collision with root package name */
    private CharSequence f9775E;

    /* renamed from: E0, reason: collision with root package name */
    private int f9776E0;

    /* renamed from: F, reason: collision with root package name */
    private final TextView f9777F;

    /* renamed from: F0, reason: collision with root package name */
    private boolean f9778F0;

    /* renamed from: G, reason: collision with root package name */
    private boolean f9779G;

    /* renamed from: G0, reason: collision with root package name */
    final CollapsingTextHelper f9780G0;

    /* renamed from: H, reason: collision with root package name */
    private CharSequence f9781H;

    /* renamed from: H0, reason: collision with root package name */
    private boolean f9782H0;

    /* renamed from: I, reason: collision with root package name */
    private boolean f9783I;

    /* renamed from: I0, reason: collision with root package name */
    private boolean f9784I0;

    /* renamed from: J, reason: collision with root package name */
    private U0.g f9785J;

    /* renamed from: J0, reason: collision with root package name */
    private ValueAnimator f9786J0;

    /* renamed from: K, reason: collision with root package name */
    private U0.g f9787K;

    /* renamed from: K0, reason: collision with root package name */
    private boolean f9788K0;

    /* renamed from: L, reason: collision with root package name */
    private U0.g f9789L;

    /* renamed from: L0, reason: collision with root package name */
    private boolean f9790L0;

    /* renamed from: M, reason: collision with root package name */
    private U0.k f9791M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f9792N;

    /* renamed from: O, reason: collision with root package name */
    private final int f9793O;

    /* renamed from: P, reason: collision with root package name */
    private int f9794P;

    /* renamed from: Q, reason: collision with root package name */
    private int f9795Q;

    /* renamed from: R, reason: collision with root package name */
    private int f9796R;

    /* renamed from: S, reason: collision with root package name */
    private int f9797S;

    /* renamed from: T, reason: collision with root package name */
    private int f9798T;

    /* renamed from: U, reason: collision with root package name */
    private int f9799U;

    /* renamed from: V, reason: collision with root package name */
    private int f9800V;

    /* renamed from: W, reason: collision with root package name */
    private final Rect f9801W;

    /* renamed from: a0, reason: collision with root package name */
    private final Rect f9802a0;

    /* renamed from: b0, reason: collision with root package name */
    private final RectF f9803b0;

    /* renamed from: c0, reason: collision with root package name */
    private Typeface f9804c0;

    /* renamed from: d0, reason: collision with root package name */
    private Drawable f9805d0;

    /* renamed from: e, reason: collision with root package name */
    private final FrameLayout f9806e;

    /* renamed from: e0, reason: collision with root package name */
    private int f9807e0;

    /* renamed from: f, reason: collision with root package name */
    private final k f9808f;

    /* renamed from: f0, reason: collision with root package name */
    private final LinkedHashSet f9809f0;

    /* renamed from: g, reason: collision with root package name */
    private final LinearLayout f9810g;

    /* renamed from: g0, reason: collision with root package name */
    private int f9811g0;

    /* renamed from: h, reason: collision with root package name */
    private final FrameLayout f9812h;

    /* renamed from: h0, reason: collision with root package name */
    private final SparseArray f9813h0;

    /* renamed from: i, reason: collision with root package name */
    EditText f9814i;

    /* renamed from: i0, reason: collision with root package name */
    private final CheckableImageButton f9815i0;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f9816j;

    /* renamed from: j0, reason: collision with root package name */
    private final LinkedHashSet f9817j0;

    /* renamed from: k, reason: collision with root package name */
    private int f9818k;

    /* renamed from: k0, reason: collision with root package name */
    private ColorStateList f9819k0;

    /* renamed from: l, reason: collision with root package name */
    private int f9820l;

    /* renamed from: l0, reason: collision with root package name */
    private PorterDuff.Mode f9821l0;

    /* renamed from: m, reason: collision with root package name */
    private int f9822m;

    /* renamed from: m0, reason: collision with root package name */
    private Drawable f9823m0;

    /* renamed from: n, reason: collision with root package name */
    private int f9824n;

    /* renamed from: n0, reason: collision with root package name */
    private int f9825n0;

    /* renamed from: o, reason: collision with root package name */
    private final com.google.android.material.textfield.g f9826o;

    /* renamed from: o0, reason: collision with root package name */
    private Drawable f9827o0;

    /* renamed from: p, reason: collision with root package name */
    boolean f9828p;

    /* renamed from: p0, reason: collision with root package name */
    private View.OnLongClickListener f9829p0;

    /* renamed from: q, reason: collision with root package name */
    private int f9830q;

    /* renamed from: q0, reason: collision with root package name */
    private View.OnLongClickListener f9831q0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9832r;

    /* renamed from: r0, reason: collision with root package name */
    private final CheckableImageButton f9833r0;

    /* renamed from: s, reason: collision with root package name */
    private TextView f9834s;

    /* renamed from: s0, reason: collision with root package name */
    private ColorStateList f9835s0;

    /* renamed from: t, reason: collision with root package name */
    private int f9836t;

    /* renamed from: t0, reason: collision with root package name */
    private PorterDuff.Mode f9837t0;

    /* renamed from: u, reason: collision with root package name */
    private int f9838u;

    /* renamed from: u0, reason: collision with root package name */
    private ColorStateList f9839u0;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f9840v;

    /* renamed from: v0, reason: collision with root package name */
    private ColorStateList f9841v0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f9842w;

    /* renamed from: w0, reason: collision with root package name */
    private int f9843w0;

    /* renamed from: x, reason: collision with root package name */
    private TextView f9844x;

    /* renamed from: x0, reason: collision with root package name */
    private int f9845x0;

    /* renamed from: y, reason: collision with root package name */
    private ColorStateList f9846y;

    /* renamed from: y0, reason: collision with root package name */
    private int f9847y0;

    /* renamed from: z, reason: collision with root package name */
    private int f9848z;

    /* renamed from: z0, reason: collision with root package name */
    private ColorStateList f9849z0;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.w0(!r0.f9790L0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f9828p) {
                textInputLayout.m0(editable.length());
            }
            if (TextInputLayout.this.f9842w) {
                TextInputLayout.this.A0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f9815i0.performClick();
            TextInputLayout.this.f9815i0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f9814i.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f9780G0.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends C0252a {

        /* renamed from: e, reason: collision with root package name */
        private final TextInputLayout f9854e;

        public e(TextInputLayout textInputLayout) {
            this.f9854e = textInputLayout;
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            EditText editText = this.f9854e.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f9854e.getHint();
            CharSequence error = this.f9854e.getError();
            CharSequence placeholderText = this.f9854e.getPlaceholderText();
            int counterMaxLength = this.f9854e.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f9854e.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(text);
            boolean isEmpty2 = TextUtils.isEmpty(hint);
            boolean N3 = this.f9854e.N();
            boolean isEmpty3 = TextUtils.isEmpty(error);
            boolean z3 = (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String charSequence = !isEmpty2 ? hint.toString() : "";
            this.f9854e.f9808f.v(dVar);
            if (!isEmpty) {
                dVar.n0(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                dVar.n0(charSequence);
                if (!N3 && placeholderText != null) {
                    dVar.n0(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                dVar.n0(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                dVar.b0(charSequence);
                dVar.k0(isEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            dVar.d0(counterMaxLength);
            if (z3) {
                if (isEmpty3) {
                    error = counterOverflowDescription;
                }
                dVar.X(error);
            }
            View s3 = this.f9854e.f9826o.s();
            if (s3 != null) {
                dVar.c0(s3);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i3);
    }

    static class h extends AbstractC0645a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        CharSequence f9855e;

        /* renamed from: f, reason: collision with root package name */
        boolean f9856f;

        /* renamed from: g, reason: collision with root package name */
        CharSequence f9857g;

        /* renamed from: h, reason: collision with root package name */
        CharSequence f9858h;

        /* renamed from: i, reason: collision with root package name */
        CharSequence f9859i;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f9855e) + " hint=" + ((Object) this.f9857g) + " helperText=" + ((Object) this.f9858h) + " placeholderText=" + ((Object) this.f9859i) + "}";
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            TextUtils.writeToParcel(this.f9855e, parcel, i3);
            parcel.writeInt(this.f9856f ? 1 : 0);
            TextUtils.writeToParcel(this.f9857g, parcel, i3);
            TextUtils.writeToParcel(this.f9858h, parcel, i3);
            TextUtils.writeToParcel(this.f9859i, parcel, i3);
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.f9855e = (CharSequence) creator.createFromParcel(parcel);
            this.f9856f = parcel.readInt() == 1;
            this.f9857g = (CharSequence) creator.createFromParcel(parcel);
            this.f9858h = (CharSequence) creator.createFromParcel(parcel);
            this.f9859i = (CharSequence) creator.createFromParcel(parcel);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f466G);
    }

    private boolean A() {
        return this.f9779G && !TextUtils.isEmpty(this.f9781H) && (this.f9785J instanceof com.google.android.material.textfield.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i3) {
        if (i3 != 0 || this.f9778F0) {
            J();
        } else {
            h0();
        }
    }

    private void B() {
        Iterator it = this.f9809f0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    private void B0(boolean z3, boolean z4) {
        int defaultColor = this.f9849z0.getDefaultColor();
        int colorForState = this.f9849z0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f9849z0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z3) {
            this.f9799U = colorForState2;
        } else if (z4) {
            this.f9799U = colorForState;
        } else {
            this.f9799U = defaultColor;
        }
    }

    private void C(int i3) {
        Iterator it = this.f9817j0.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this, i3);
        }
    }

    private void C0() {
        if (this.f9814i == null) {
            return;
        }
        y.y0(this.f9777F, getContext().getResources().getDimensionPixelSize(H0.c.f538u), this.f9814i.getPaddingTop(), (K() || L()) ? 0 : y.B(this.f9814i), this.f9814i.getPaddingBottom());
    }

    private void D(Canvas canvas) {
        U0.g gVar;
        if (this.f9789L == null || (gVar = this.f9787K) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f9814i.isFocused()) {
            Rect bounds = this.f9789L.getBounds();
            Rect bounds2 = this.f9787K.getBounds();
            float expansionFraction = this.f9780G0.getExpansionFraction();
            int centerX = bounds2.centerX();
            bounds.left = I0.a.c(centerX, bounds2.left, expansionFraction);
            bounds.right = I0.a.c(centerX, bounds2.right, expansionFraction);
            this.f9789L.draw(canvas);
        }
    }

    private void D0() {
        int visibility = this.f9777F.getVisibility();
        int i3 = (this.f9775E == null || N()) ? 8 : 0;
        if (visibility != i3) {
            getEndIconDelegate().c(i3 == 0);
        }
        t0();
        this.f9777F.setVisibility(i3);
        q0();
    }

    private void E(Canvas canvas) {
        if (this.f9779G) {
            this.f9780G0.draw(canvas);
        }
    }

    private void F(boolean z3) {
        ValueAnimator valueAnimator = this.f9786J0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f9786J0.cancel();
        }
        if (z3 && this.f9784I0) {
            k(0.0f);
        } else {
            this.f9780G0.setExpansionFraction(0.0f);
        }
        if (A() && ((com.google.android.material.textfield.c) this.f9785J).g0()) {
            x();
        }
        this.f9778F0 = true;
        J();
        this.f9808f.i(true);
        D0();
    }

    private int G(int i3, boolean z3) {
        int compoundPaddingLeft = i3 + this.f9814i.getCompoundPaddingLeft();
        return (getPrefixText() == null || z3) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    private int H(int i3, boolean z3) {
        int compoundPaddingRight = i3 - this.f9814i.getCompoundPaddingRight();
        return (getPrefixText() == null || !z3) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    private boolean I() {
        return this.f9811g0 != 0;
    }

    private void J() {
        TextView textView = this.f9844x;
        if (textView == null || !this.f9842w) {
            return;
        }
        textView.setText((CharSequence) null);
        n.a(this.f9806e, this.f9769B);
        this.f9844x.setVisibility(4);
    }

    private boolean L() {
        return this.f9833r0.getVisibility() == 0;
    }

    private boolean P() {
        return this.f9794P == 1 && this.f9814i.getMinLines() <= 1;
    }

    private void Q() {
        o();
        Z();
        E0();
        j0();
        j();
        if (this.f9794P != 0) {
            v0();
        }
    }

    private void R() {
        if (A()) {
            RectF rectF = this.f9803b0;
            this.f9780G0.getCollapsedTextActualBounds(rectF, this.f9814i.getWidth(), this.f9814i.getGravity());
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f9796R);
            ((com.google.android.material.textfield.c) this.f9785J).j0(rectF);
        }
    }

    private void S() {
        if (!A() || this.f9778F0) {
            return;
        }
        x();
        R();
    }

    private static void T(ViewGroup viewGroup, boolean z3) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z3);
            if (childAt instanceof ViewGroup) {
                T((ViewGroup) childAt, z3);
            }
        }
    }

    private void X() {
        TextView textView = this.f9844x;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void Z() {
        if (g0()) {
            y.n0(this.f9814i, this.f9785J);
        }
    }

    private static void a0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean J3 = y.J(checkableImageButton);
        boolean z3 = onLongClickListener != null;
        boolean z4 = J3 || z3;
        checkableImageButton.setFocusable(z4);
        checkableImageButton.setClickable(J3);
        checkableImageButton.setPressable(J3);
        checkableImageButton.setLongClickable(z3);
        y.u0(checkableImageButton, z4 ? 1 : 2);
    }

    private static void b0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        a0(checkableImageButton, onLongClickListener);
    }

    private static void c0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a0(checkableImageButton, onLongClickListener);
    }

    private boolean e0() {
        return (this.f9833r0.getVisibility() == 0 || ((I() && K()) || this.f9775E != null)) && this.f9810g.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f9808f.getMeasuredWidth() > 0;
    }

    private boolean g0() {
        EditText editText = this.f9814i;
        return (editText == null || this.f9785J == null || editText.getBackground() != null || this.f9794P == 0) ? false : true;
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = (com.google.android.material.textfield.e) this.f9813h0.get(this.f9811g0);
        return eVar != null ? eVar : (com.google.android.material.textfield.e) this.f9813h0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f9833r0.getVisibility() == 0) {
            return this.f9833r0;
        }
        if (I() && K()) {
            return this.f9815i0;
        }
        return null;
    }

    private void h0() {
        if (this.f9844x == null || !this.f9842w || TextUtils.isEmpty(this.f9840v)) {
            return;
        }
        this.f9844x.setText(this.f9840v);
        n.a(this.f9806e, this.f9767A);
        this.f9844x.setVisibility(0);
        this.f9844x.bringToFront();
        announceForAccessibility(this.f9840v);
    }

    private void i() {
        TextView textView = this.f9844x;
        if (textView != null) {
            this.f9806e.addView(textView);
            this.f9844x.setVisibility(0);
        }
    }

    private void i0(boolean z3) {
        if (!z3 || getEndIconDrawable() == null) {
            com.google.android.material.textfield.f.a(this, this.f9815i0, this.f9819k0, this.f9821l0);
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.l(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.h(mutate, this.f9826o.p());
        this.f9815i0.setImageDrawable(mutate);
    }

    private void j() {
        if (this.f9814i == null || this.f9794P != 1) {
            return;
        }
        if (R0.c.h(getContext())) {
            EditText editText = this.f9814i;
            y.y0(editText, y.C(editText), getResources().getDimensionPixelSize(H0.c.f532o), y.B(this.f9814i), getResources().getDimensionPixelSize(H0.c.f531n));
        } else if (R0.c.g(getContext())) {
            EditText editText2 = this.f9814i;
            y.y0(editText2, y.C(editText2), getResources().getDimensionPixelSize(H0.c.f530m), y.B(this.f9814i), getResources().getDimensionPixelSize(H0.c.f529l));
        }
    }

    private void j0() {
        if (this.f9794P == 1) {
            if (R0.c.h(getContext())) {
                this.f9795Q = getResources().getDimensionPixelSize(H0.c.f534q);
            } else if (R0.c.g(getContext())) {
                this.f9795Q = getResources().getDimensionPixelSize(H0.c.f533p);
            }
        }
    }

    private void k0(Rect rect) {
        U0.g gVar = this.f9787K;
        if (gVar != null) {
            int i3 = rect.bottom;
            gVar.setBounds(rect.left, i3 - this.f9797S, rect.right, i3);
        }
        U0.g gVar2 = this.f9789L;
        if (gVar2 != null) {
            int i4 = rect.bottom;
            gVar2.setBounds(rect.left, i4 - this.f9798T, rect.right, i4);
        }
    }

    private void l() {
        U0.g gVar = this.f9785J;
        if (gVar == null) {
            return;
        }
        U0.k B3 = gVar.B();
        U0.k kVar = this.f9791M;
        if (B3 != kVar) {
            this.f9785J.setShapeAppearanceModel(kVar);
            p0();
        }
        if (v()) {
            this.f9785J.Z(this.f9796R, this.f9799U);
        }
        int p3 = p();
        this.f9800V = p3;
        this.f9785J.U(ColorStateList.valueOf(p3));
        if (this.f9811g0 == 3) {
            this.f9814i.getBackground().invalidateSelf();
        }
        m();
        invalidate();
    }

    private void l0() {
        if (this.f9834s != null) {
            EditText editText = this.f9814i;
            m0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void m() {
        if (this.f9787K == null || this.f9789L == null) {
            return;
        }
        if (w()) {
            this.f9787K.U(this.f9814i.isFocused() ? ColorStateList.valueOf(this.f9843w0) : ColorStateList.valueOf(this.f9799U));
            this.f9789L.U(ColorStateList.valueOf(this.f9799U));
        }
        invalidate();
    }

    private void n(RectF rectF) {
        float f3 = rectF.left;
        int i3 = this.f9793O;
        rectF.left = f3 - i3;
        rectF.right += i3;
    }

    private static void n0(Context context, TextView textView, int i3, int i4, boolean z3) {
        textView.setContentDescription(context.getString(z3 ? H0.h.f622c : H0.h.f621b, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    private void o() {
        int i3 = this.f9794P;
        if (i3 == 0) {
            this.f9785J = null;
            this.f9787K = null;
            this.f9789L = null;
            return;
        }
        if (i3 == 1) {
            this.f9785J = new U0.g(this.f9791M);
            this.f9787K = new U0.g();
            this.f9789L = new U0.g();
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException(this.f9794P + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f9779G || (this.f9785J instanceof com.google.android.material.textfield.c)) {
                this.f9785J = new U0.g(this.f9791M);
            } else {
                this.f9785J = new com.google.android.material.textfield.c(this.f9791M);
            }
            this.f9787K = null;
            this.f9789L = null;
        }
    }

    private void o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f9834s;
        if (textView != null) {
            d0(textView, this.f9832r ? this.f9836t : this.f9838u);
            if (!this.f9832r && (colorStateList2 = this.f9771C) != null) {
                this.f9834s.setTextColor(colorStateList2);
            }
            if (!this.f9832r || (colorStateList = this.f9773D) == null) {
                return;
            }
            this.f9834s.setTextColor(colorStateList);
        }
    }

    private int p() {
        return this.f9794P == 1 ? L0.a.g(L0.a.e(this, H0.a.f482n, 0), this.f9800V) : this.f9800V;
    }

    private void p0() {
        if (this.f9811g0 == 3 && this.f9794P == 2) {
            ((com.google.android.material.textfield.d) this.f9813h0.get(3)).J((AutoCompleteTextView) this.f9814i);
        }
    }

    private Rect q(Rect rect) {
        if (this.f9814i == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f9802a0;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        rect2.bottom = rect.bottom;
        int i3 = this.f9794P;
        if (i3 == 1) {
            rect2.left = G(rect.left, isLayoutRtl);
            rect2.top = rect.top + this.f9795Q;
            rect2.right = H(rect.right, isLayoutRtl);
            return rect2;
        }
        if (i3 != 2) {
            rect2.left = G(rect.left, isLayoutRtl);
            rect2.top = getPaddingTop();
            rect2.right = H(rect.right, isLayoutRtl);
            return rect2;
        }
        rect2.left = rect.left + this.f9814i.getPaddingLeft();
        rect2.top = rect.top - u();
        rect2.right = rect.right - this.f9814i.getPaddingRight();
        return rect2;
    }

    private int r(Rect rect, Rect rect2, float f3) {
        return P() ? (int) (rect2.top + f3) : rect.bottom - this.f9814i.getCompoundPaddingBottom();
    }

    private int s(Rect rect, float f3) {
        return P() ? (int) (rect.centerY() - (f3 / 2.0f)) : rect.top + this.f9814i.getCompoundPaddingTop();
    }

    private boolean s0() {
        int max;
        if (this.f9814i == null || this.f9814i.getMeasuredHeight() >= (max = Math.max(this.f9810g.getMeasuredHeight(), this.f9808f.getMeasuredHeight()))) {
            return false;
        }
        this.f9814i.setMinimumHeight(max);
        return true;
    }

    private void setEditText(EditText editText) {
        if (this.f9814i != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f9811g0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f9814i = editText;
        int i3 = this.f9818k;
        if (i3 != -1) {
            setMinEms(i3);
        } else {
            setMinWidth(this.f9822m);
        }
        int i4 = this.f9820l;
        if (i4 != -1) {
            setMaxEms(i4);
        } else {
            setMaxWidth(this.f9824n);
        }
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.f9780G0.setTypefaces(this.f9814i.getTypeface());
        this.f9780G0.setExpandedTextSize(this.f9814i.getTextSize());
        this.f9780G0.setExpandedLetterSpacing(this.f9814i.getLetterSpacing());
        int gravity = this.f9814i.getGravity();
        this.f9780G0.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.f9780G0.setExpandedTextGravity(gravity);
        this.f9814i.addTextChangedListener(new a());
        if (this.f9839u0 == null) {
            this.f9839u0 = this.f9814i.getHintTextColors();
        }
        if (this.f9779G) {
            if (TextUtils.isEmpty(this.f9781H)) {
                CharSequence hint = this.f9814i.getHint();
                this.f9816j = hint;
                setHint(hint);
                this.f9814i.setHint((CharSequence) null);
            }
            this.f9783I = true;
        }
        if (this.f9834s != null) {
            m0(this.f9814i.getText().length());
        }
        r0();
        this.f9826o.f();
        this.f9808f.bringToFront();
        this.f9810g.bringToFront();
        this.f9812h.bringToFront();
        this.f9833r0.bringToFront();
        B();
        C0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f9781H)) {
            return;
        }
        this.f9781H = charSequence;
        this.f9780G0.setText(charSequence);
        if (this.f9778F0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z3) {
        if (this.f9842w == z3) {
            return;
        }
        if (z3) {
            i();
        } else {
            X();
            this.f9844x = null;
        }
        this.f9842w = z3;
    }

    private Rect t(Rect rect) {
        if (this.f9814i == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f9802a0;
        float expandedTextHeight = this.f9780G0.getExpandedTextHeight();
        rect2.left = rect.left + this.f9814i.getCompoundPaddingLeft();
        rect2.top = s(rect, expandedTextHeight);
        rect2.right = rect.right - this.f9814i.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, expandedTextHeight);
        return rect2;
    }

    private void t0() {
        this.f9812h.setVisibility((this.f9815i0.getVisibility() != 0 || L()) ? 8 : 0);
        this.f9810g.setVisibility(K() || L() || !((this.f9775E == null || N()) ? 8 : false) ? 0 : 8);
    }

    private int u() {
        float collapsedTextHeight;
        if (!this.f9779G) {
            return 0;
        }
        int i3 = this.f9794P;
        if (i3 == 0) {
            collapsedTextHeight = this.f9780G0.getCollapsedTextHeight();
        } else {
            if (i3 != 2) {
                return 0;
            }
            collapsedTextHeight = this.f9780G0.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private void u0() {
        this.f9833r0.setVisibility(getErrorIconDrawable() != null && this.f9826o.z() && this.f9826o.l() ? 0 : 8);
        t0();
        C0();
        if (I()) {
            return;
        }
        q0();
    }

    private boolean v() {
        return this.f9794P == 2 && w();
    }

    private void v0() {
        if (this.f9794P != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9806e.getLayoutParams();
            int u3 = u();
            if (u3 != layoutParams.topMargin) {
                layoutParams.topMargin = u3;
                this.f9806e.requestLayout();
            }
        }
    }

    private boolean w() {
        return this.f9796R > -1 && this.f9799U != 0;
    }

    private void x() {
        if (A()) {
            ((com.google.android.material.textfield.c) this.f9785J).h0();
        }
    }

    private void x0(boolean z3, boolean z4) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f9814i;
        boolean z5 = false;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f9814i;
        if (editText2 != null && editText2.hasFocus()) {
            z5 = true;
        }
        boolean l3 = this.f9826o.l();
        ColorStateList colorStateList2 = this.f9839u0;
        if (colorStateList2 != null) {
            this.f9780G0.setCollapsedTextColor(colorStateList2);
            this.f9780G0.setExpandedTextColor(this.f9839u0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f9839u0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f9776E0) : this.f9776E0;
            this.f9780G0.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.f9780G0.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (l3) {
            this.f9780G0.setCollapsedTextColor(this.f9826o.q());
        } else if (this.f9832r && (textView = this.f9834s) != null) {
            this.f9780G0.setCollapsedTextColor(textView.getTextColors());
        } else if (z5 && (colorStateList = this.f9841v0) != null) {
            this.f9780G0.setCollapsedTextColor(colorStateList);
        }
        if (z6 || !this.f9782H0 || (isEnabled() && z5)) {
            if (z4 || this.f9778F0) {
                y(z3);
                return;
            }
            return;
        }
        if (z4 || !this.f9778F0) {
            F(z3);
        }
    }

    private void y(boolean z3) {
        ValueAnimator valueAnimator = this.f9786J0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f9786J0.cancel();
        }
        if (z3 && this.f9784I0) {
            k(1.0f);
        } else {
            this.f9780G0.setExpansionFraction(1.0f);
        }
        this.f9778F0 = false;
        if (A()) {
            R();
        }
        z0();
        this.f9808f.i(false);
        D0();
    }

    private void y0() {
        EditText editText;
        if (this.f9844x == null || (editText = this.f9814i) == null) {
            return;
        }
        this.f9844x.setGravity(editText.getGravity());
        this.f9844x.setPadding(this.f9814i.getCompoundPaddingLeft(), this.f9814i.getCompoundPaddingTop(), this.f9814i.getCompoundPaddingRight(), this.f9814i.getCompoundPaddingBottom());
    }

    private C0284d z() {
        C0284d c0284d = new C0284d();
        c0284d.setDuration(87L);
        c0284d.setInterpolator(I0.a.f914a);
        return c0284d;
    }

    private void z0() {
        EditText editText = this.f9814i;
        A0(editText == null ? 0 : editText.getText().length());
    }

    void E0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f9785J == null || this.f9794P == 0) {
            return;
        }
        boolean z3 = false;
        boolean z4 = isFocused() || ((editText2 = this.f9814i) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f9814i) != null && editText.isHovered())) {
            z3 = true;
        }
        if (!isEnabled()) {
            this.f9799U = this.f9776E0;
        } else if (this.f9826o.l()) {
            if (this.f9849z0 != null) {
                B0(z4, z3);
            } else {
                this.f9799U = this.f9826o.p();
            }
        } else if (!this.f9832r || (textView = this.f9834s) == null) {
            if (z4) {
                this.f9799U = this.f9847y0;
            } else if (z3) {
                this.f9799U = this.f9845x0;
            } else {
                this.f9799U = this.f9843w0;
            }
        } else if (this.f9849z0 != null) {
            B0(z4, z3);
        } else {
            this.f9799U = textView.getCurrentTextColor();
        }
        u0();
        V();
        W();
        U();
        if (getEndIconDelegate().d()) {
            i0(this.f9826o.l());
        }
        if (this.f9794P == 2) {
            int i3 = this.f9796R;
            if (z4 && isEnabled()) {
                this.f9796R = this.f9798T;
            } else {
                this.f9796R = this.f9797S;
            }
            if (this.f9796R != i3) {
                S();
            }
        }
        if (this.f9794P == 1) {
            if (!isEnabled()) {
                this.f9800V = this.f9770B0;
            } else if (z3 && !z4) {
                this.f9800V = this.f9774D0;
            } else if (z4) {
                this.f9800V = this.f9772C0;
            } else {
                this.f9800V = this.f9768A0;
            }
        }
        l();
    }

    public boolean K() {
        return this.f9812h.getVisibility() == 0 && this.f9815i0.getVisibility() == 0;
    }

    public boolean M() {
        return this.f9826o.A();
    }

    final boolean N() {
        return this.f9778F0;
    }

    public boolean O() {
        return this.f9783I;
    }

    public void U() {
        com.google.android.material.textfield.f.c(this, this.f9815i0, this.f9819k0);
    }

    public void V() {
        com.google.android.material.textfield.f.c(this, this.f9833r0, this.f9835s0);
    }

    public void W() {
        this.f9808f.j();
    }

    public void Y(float f3, float f4, float f5, float f6) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        this.f9792N = isLayoutRtl;
        float f7 = isLayoutRtl ? f4 : f3;
        if (!isLayoutRtl) {
            f3 = f4;
        }
        float f8 = isLayoutRtl ? f6 : f5;
        if (!isLayoutRtl) {
            f5 = f6;
        }
        U0.g gVar = this.f9785J;
        if (gVar != null && gVar.D() == f7 && this.f9785J.E() == f3 && this.f9785J.r() == f8 && this.f9785J.s() == f5) {
            return;
        }
        this.f9791M = this.f9791M.v().D(f7).I(f3).t(f8).y(f5).m();
        l();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i3, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f9806e.addView(view, layoutParams2);
        this.f9806e.setLayoutParams(layoutParams);
        v0();
        setEditText((EditText) view);
    }

    void d0(TextView textView, int i3) {
        try {
            androidx.core.widget.i.m(textView, i3);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.i.m(textView, H0.i.f636a);
        textView.setTextColor(androidx.core.content.a.c(getContext(), H0.b.f495a));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        EditText editText = this.f9814i;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f9816j != null) {
            boolean z3 = this.f9783I;
            this.f9783I = false;
            CharSequence hint = editText.getHint();
            this.f9814i.setHint(this.f9816j);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i3);
                return;
            } finally {
                this.f9814i.setHint(hint);
                this.f9783I = z3;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
        onProvideAutofillVirtualStructure(viewStructure, i3);
        viewStructure.setChildCount(this.f9806e.getChildCount());
        for (int i4 = 0; i4 < this.f9806e.getChildCount(); i4++) {
            View childAt = this.f9806e.getChildAt(i4);
            ViewStructure newChild = viewStructure.newChild(i4);
            childAt.dispatchProvideAutofillStructure(newChild, i3);
            if (childAt == this.f9814i) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f9790L0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f9790L0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f9788K0) {
            return;
        }
        this.f9788K0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.f9780G0;
        boolean state = collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) : false;
        if (this.f9814i != null) {
            w0(y.O(this) && isEnabled());
        }
        r0();
        E0();
        if (state) {
            invalidate();
        }
        this.f9788K0 = false;
    }

    public void g(f fVar) {
        this.f9809f0.add(fVar);
        if (this.f9814i != null) {
            fVar.a(this);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f9814i;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    U0.g getBoxBackground() {
        int i3 = this.f9794P;
        if (i3 == 1 || i3 == 2) {
            return this.f9785J;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f9800V;
    }

    public int getBoxBackgroundMode() {
        return this.f9794P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f9795Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return ViewUtils.isLayoutRtl(this) ? this.f9791M.j().a(this.f9803b0) : this.f9791M.l().a(this.f9803b0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return ViewUtils.isLayoutRtl(this) ? this.f9791M.l().a(this.f9803b0) : this.f9791M.j().a(this.f9803b0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return ViewUtils.isLayoutRtl(this) ? this.f9791M.r().a(this.f9803b0) : this.f9791M.t().a(this.f9803b0);
    }

    public float getBoxCornerRadiusTopStart() {
        return ViewUtils.isLayoutRtl(this) ? this.f9791M.t().a(this.f9803b0) : this.f9791M.r().a(this.f9803b0);
    }

    public int getBoxStrokeColor() {
        return this.f9847y0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f9849z0;
    }

    public int getBoxStrokeWidth() {
        return this.f9797S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f9798T;
    }

    public int getCounterMaxLength() {
        return this.f9830q;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f9828p && this.f9832r && (textView = this.f9834s) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f9771C;
    }

    public ColorStateList getCounterTextColor() {
        return this.f9771C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f9839u0;
    }

    public EditText getEditText() {
        return this.f9814i;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f9815i0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f9815i0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f9811g0;
    }

    CheckableImageButton getEndIconView() {
        return this.f9815i0;
    }

    public CharSequence getError() {
        if (this.f9826o.z()) {
            return this.f9826o.o();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f9826o.n();
    }

    public int getErrorCurrentTextColors() {
        return this.f9826o.p();
    }

    public Drawable getErrorIconDrawable() {
        return this.f9833r0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.f9826o.p();
    }

    public CharSequence getHelperText() {
        if (this.f9826o.A()) {
            return this.f9826o.r();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f9826o.t();
    }

    public CharSequence getHint() {
        if (this.f9779G) {
            return this.f9781H;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f9780G0.getCollapsedTextHeight();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f9780G0.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.f9841v0;
    }

    public int getMaxEms() {
        return this.f9820l;
    }

    public int getMaxWidth() {
        return this.f9824n;
    }

    public int getMinEms() {
        return this.f9818k;
    }

    public int getMinWidth() {
        return this.f9822m;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f9815i0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f9815i0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f9842w) {
            return this.f9840v;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f9848z;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f9846y;
    }

    public CharSequence getPrefixText() {
        return this.f9808f.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f9808f.b();
    }

    public TextView getPrefixTextView() {
        return this.f9808f.c();
    }

    public CharSequence getStartIconContentDescription() {
        return this.f9808f.d();
    }

    public Drawable getStartIconDrawable() {
        return this.f9808f.e();
    }

    public CharSequence getSuffixText() {
        return this.f9775E;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f9777F.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f9777F;
    }

    public Typeface getTypeface() {
        return this.f9804c0;
    }

    public void h(g gVar) {
        this.f9817j0.add(gVar);
    }

    void k(float f3) {
        if (this.f9780G0.getExpansionFraction() == f3) {
            return;
        }
        if (this.f9786J0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f9786J0 = valueAnimator;
            valueAnimator.setInterpolator(I0.a.f915b);
            this.f9786J0.setDuration(167L);
            this.f9786J0.addUpdateListener(new d());
        }
        this.f9786J0.setFloatValues(this.f9780G0.getExpansionFraction(), f3);
        this.f9786J0.start();
    }

    void m0(int i3) {
        boolean z3 = this.f9832r;
        int i4 = this.f9830q;
        if (i4 == -1) {
            this.f9834s.setText(String.valueOf(i3));
            this.f9834s.setContentDescription(null);
            this.f9832r = false;
        } else {
            this.f9832r = i3 > i4;
            n0(getContext(), this.f9834s, i3, this.f9830q, this.f9832r);
            if (z3 != this.f9832r) {
                o0();
            }
            this.f9834s.setText(androidx.core.text.a.c().j(getContext().getString(H0.h.f623d, Integer.valueOf(i3), Integer.valueOf(this.f9830q))));
        }
        if (this.f9814i == null || z3 == this.f9832r) {
            return;
        }
        w0(false);
        E0();
        r0();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9780G0.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        EditText editText = this.f9814i;
        if (editText != null) {
            Rect rect = this.f9801W;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            k0(rect);
            if (this.f9779G) {
                this.f9780G0.setExpandedTextSize(this.f9814i.getTextSize());
                int gravity = this.f9814i.getGravity();
                this.f9780G0.setCollapsedTextGravity((gravity & (-113)) | 48);
                this.f9780G0.setExpandedTextGravity(gravity);
                this.f9780G0.setCollapsedBounds(q(rect));
                this.f9780G0.setExpandedBounds(t(rect));
                this.f9780G0.recalculate();
                if (!A() || this.f9778F0) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        boolean s02 = s0();
        boolean q02 = q0();
        if (s02 || q02) {
            this.f9814i.post(new c());
        }
        y0();
        C0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        setError(hVar.f9855e);
        if (hVar.f9856f) {
            this.f9815i0.post(new b());
        }
        setHint(hVar.f9857g);
        setHelperText(hVar.f9858h);
        setPlaceholderText(hVar.f9859i);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        boolean z3 = false;
        boolean z4 = i3 == 1;
        boolean z5 = this.f9792N;
        if (z4 != z5) {
            if (z4 && !z5) {
                z3 = true;
            }
            float a3 = this.f9791M.r().a(this.f9803b0);
            float a4 = this.f9791M.t().a(this.f9803b0);
            float a5 = this.f9791M.j().a(this.f9803b0);
            float a6 = this.f9791M.l().a(this.f9803b0);
            float f3 = z3 ? a3 : a4;
            if (z3) {
                a3 = a4;
            }
            float f4 = z3 ? a5 : a6;
            if (z3) {
                a5 = a6;
            }
            Y(f3, a3, f4, a5);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f9826o.l()) {
            hVar.f9855e = getError();
        }
        hVar.f9856f = I() && this.f9815i0.isChecked();
        hVar.f9857g = getHint();
        hVar.f9858h = getHelperText();
        hVar.f9859i = getPlaceholderText();
        return hVar;
    }

    boolean q0() {
        boolean z3;
        if (this.f9814i == null) {
            return false;
        }
        boolean z4 = true;
        if (f0()) {
            int measuredWidth = this.f9808f.getMeasuredWidth() - this.f9814i.getPaddingLeft();
            if (this.f9805d0 == null || this.f9807e0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f9805d0 = colorDrawable;
                this.f9807e0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a3 = androidx.core.widget.i.a(this.f9814i);
            Drawable drawable = a3[0];
            Drawable drawable2 = this.f9805d0;
            if (drawable != drawable2) {
                androidx.core.widget.i.h(this.f9814i, drawable2, a3[1], a3[2], a3[3]);
                z3 = true;
            }
            z3 = false;
        } else {
            if (this.f9805d0 != null) {
                Drawable[] a4 = androidx.core.widget.i.a(this.f9814i);
                androidx.core.widget.i.h(this.f9814i, null, a4[1], a4[2], a4[3]);
                this.f9805d0 = null;
                z3 = true;
            }
            z3 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.f9777F.getMeasuredWidth() - this.f9814i.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + AbstractC0259h.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a5 = androidx.core.widget.i.a(this.f9814i);
            Drawable drawable3 = this.f9823m0;
            if (drawable3 == null || this.f9825n0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f9823m0 = colorDrawable2;
                    this.f9825n0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a5[2];
                Drawable drawable5 = this.f9823m0;
                if (drawable4 != drawable5) {
                    this.f9827o0 = drawable4;
                    androidx.core.widget.i.h(this.f9814i, a5[0], a5[1], drawable5, a5[3]);
                } else {
                    z4 = z3;
                }
            } else {
                this.f9825n0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.i.h(this.f9814i, a5[0], a5[1], this.f9823m0, a5[3]);
            }
        } else {
            if (this.f9823m0 == null) {
                return z3;
            }
            Drawable[] a6 = androidx.core.widget.i.a(this.f9814i);
            if (a6[2] == this.f9823m0) {
                androidx.core.widget.i.h(this.f9814i, a6[0], a6[1], this.f9827o0, a6[3]);
            } else {
                z4 = z3;
            }
            this.f9823m0 = null;
        }
        return z4;
    }

    void r0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f9814i;
        if (editText == null || this.f9794P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (E.a(background)) {
            background = background.mutate();
        }
        if (this.f9826o.l()) {
            background.setColorFilter(C0235i.e(this.f9826o.p(), PorterDuff.Mode.SRC_IN));
        } else if (this.f9832r && (textView = this.f9834s) != null) {
            background.setColorFilter(C0235i.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.a(background);
            this.f9814i.refreshDrawableState();
        }
    }

    public void setBoxBackgroundColor(int i3) {
        if (this.f9800V != i3) {
            this.f9800V = i3;
            this.f9768A0 = i3;
            this.f9772C0 = i3;
            this.f9774D0 = i3;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i3) {
        setBoxBackgroundColor(androidx.core.content.a.c(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f9768A0 = defaultColor;
        this.f9800V = defaultColor;
        this.f9770B0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f9772C0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f9774D0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.f9794P) {
            return;
        }
        this.f9794P = i3;
        if (this.f9814i != null) {
            Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i3) {
        this.f9795Q = i3;
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f9847y0 != i3) {
            this.f9847y0 = i3;
            E0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f9843w0 = colorStateList.getDefaultColor();
            this.f9776E0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f9845x0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f9847y0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f9847y0 != colorStateList.getDefaultColor()) {
            this.f9847y0 = colorStateList.getDefaultColor();
        }
        E0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f9849z0 != colorStateList) {
            this.f9849z0 = colorStateList;
            E0();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.f9797S = i3;
        E0();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.f9798T = i3;
        E0();
    }

    public void setBoxStrokeWidthFocusedResource(int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z3) {
        if (this.f9828p != z3) {
            if (z3) {
                C0251z c0251z = new C0251z(getContext());
                this.f9834s = c0251z;
                c0251z.setId(H0.e.f560J);
                Typeface typeface = this.f9804c0;
                if (typeface != null) {
                    this.f9834s.setTypeface(typeface);
                }
                this.f9834s.setMaxLines(1);
                this.f9826o.e(this.f9834s, 2);
                AbstractC0259h.d((ViewGroup.MarginLayoutParams) this.f9834s.getLayoutParams(), getResources().getDimensionPixelOffset(H0.c.f517Q));
                o0();
                l0();
            } else {
                this.f9826o.B(this.f9834s, 2);
                this.f9834s = null;
            }
            this.f9828p = z3;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.f9830q != i3) {
            if (i3 > 0) {
                this.f9830q = i3;
            } else {
                this.f9830q = -1;
            }
            if (this.f9828p) {
                l0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.f9836t != i3) {
            this.f9836t = i3;
            o0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f9773D != colorStateList) {
            this.f9773D = colorStateList;
            o0();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.f9838u != i3) {
            this.f9838u = i3;
            o0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f9771C != colorStateList) {
            this.f9771C = colorStateList;
            o0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f9839u0 = colorStateList;
        this.f9841v0 = colorStateList;
        if (this.f9814i != null) {
            w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        T(this, z3);
        super.setEnabled(z3);
    }

    public void setEndIconActivated(boolean z3) {
        this.f9815i0.setActivated(z3);
    }

    public void setEndIconCheckable(boolean z3) {
        this.f9815i0.setCheckable(z3);
    }

    public void setEndIconContentDescription(int i3) {
        setEndIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setEndIconDrawable(int i3) {
        setEndIconDrawable(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    public void setEndIconMode(int i3) {
        int i4 = this.f9811g0;
        if (i4 == i3) {
            return;
        }
        this.f9811g0 = i3;
        C(i4);
        setEndIconVisible(i3 != 0);
        if (getEndIconDelegate().b(this.f9794P)) {
            getEndIconDelegate().a();
            com.google.android.material.textfield.f.a(this, this.f9815i0, this.f9819k0, this.f9821l0);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f9794P + " is not supported by the end icon mode " + i3);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        b0(this.f9815i0, onClickListener, this.f9829p0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9829p0 = onLongClickListener;
        c0(this.f9815i0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f9819k0 != colorStateList) {
            this.f9819k0 = colorStateList;
            com.google.android.material.textfield.f.a(this, this.f9815i0, colorStateList, this.f9821l0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f9821l0 != mode) {
            this.f9821l0 = mode;
            com.google.android.material.textfield.f.a(this, this.f9815i0, this.f9819k0, mode);
        }
    }

    public void setEndIconVisible(boolean z3) {
        if (K() != z3) {
            this.f9815i0.setVisibility(z3 ? 0 : 8);
            t0();
            C0();
            q0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f9826o.z()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f9826o.v();
        } else {
            this.f9826o.O(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f9826o.D(charSequence);
    }

    public void setErrorEnabled(boolean z3) {
        this.f9826o.E(z3);
    }

    public void setErrorIconDrawable(int i3) {
        setErrorIconDrawable(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
        V();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        b0(this.f9833r0, onClickListener, this.f9831q0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9831q0 = onLongClickListener;
        c0(this.f9833r0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.f9835s0 != colorStateList) {
            this.f9835s0 = colorStateList;
            com.google.android.material.textfield.f.a(this, this.f9833r0, colorStateList, this.f9837t0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.f9837t0 != mode) {
            this.f9837t0 = mode;
            com.google.android.material.textfield.f.a(this, this.f9833r0, this.f9835s0, mode);
        }
    }

    public void setErrorTextAppearance(int i3) {
        this.f9826o.F(i3);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f9826o.G(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z3) {
        if (this.f9782H0 != z3) {
            this.f9782H0 = z3;
            w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (M()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!M()) {
                setHelperTextEnabled(true);
            }
            this.f9826o.P(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f9826o.J(colorStateList);
    }

    public void setHelperTextEnabled(boolean z3) {
        this.f9826o.I(z3);
    }

    public void setHelperTextTextAppearance(int i3) {
        this.f9826o.H(i3);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f9779G) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z3) {
        this.f9784I0 = z3;
    }

    public void setHintEnabled(boolean z3) {
        if (z3 != this.f9779G) {
            this.f9779G = z3;
            if (z3) {
                CharSequence hint = this.f9814i.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f9781H)) {
                        setHint(hint);
                    }
                    this.f9814i.setHint((CharSequence) null);
                }
                this.f9783I = true;
            } else {
                this.f9783I = false;
                if (!TextUtils.isEmpty(this.f9781H) && TextUtils.isEmpty(this.f9814i.getHint())) {
                    this.f9814i.setHint(this.f9781H);
                }
                setHintInternal(null);
            }
            if (this.f9814i != null) {
                v0();
            }
        }
    }

    public void setHintTextAppearance(int i3) {
        this.f9780G0.setCollapsedTextAppearance(i3);
        this.f9841v0 = this.f9780G0.getCollapsedTextColor();
        if (this.f9814i != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f9841v0 != colorStateList) {
            if (this.f9839u0 == null) {
                this.f9780G0.setCollapsedTextColor(colorStateList);
            }
            this.f9841v0 = colorStateList;
            if (this.f9814i != null) {
                w0(false);
            }
        }
    }

    public void setMaxEms(int i3) {
        this.f9820l = i3;
        EditText editText = this.f9814i;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxEms(i3);
    }

    public void setMaxWidth(int i3) {
        this.f9824n = i3;
        EditText editText = this.f9814i;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxWidth(i3);
    }

    public void setMaxWidthResource(int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinEms(int i3) {
        this.f9818k = i3;
        EditText editText = this.f9814i;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinEms(i3);
    }

    public void setMinWidth(int i3) {
        this.f9822m = i3;
        EditText editText = this.f9814i;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinWidth(i3);
    }

    public void setMinWidthResource(int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i3) {
        setPasswordVisibilityToggleContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i3) {
        setPasswordVisibilityToggleDrawable(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z3) {
        if (z3 && this.f9811g0 != 1) {
            setEndIconMode(1);
        } else {
            if (z3) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f9819k0 = colorStateList;
        com.google.android.material.textfield.f.a(this, this.f9815i0, colorStateList, this.f9821l0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f9821l0 = mode;
        com.google.android.material.textfield.f.a(this, this.f9815i0, this.f9819k0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f9844x == null) {
            C0251z c0251z = new C0251z(getContext());
            this.f9844x = c0251z;
            c0251z.setId(H0.e.f563M);
            y.u0(this.f9844x, 2);
            C0284d z3 = z();
            this.f9767A = z3;
            z3.setStartDelay(67L);
            this.f9769B = z();
            setPlaceholderTextAppearance(this.f9848z);
            setPlaceholderTextColor(this.f9846y);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f9842w) {
                setPlaceholderTextEnabled(true);
            }
            this.f9840v = charSequence;
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i3) {
        this.f9848z = i3;
        TextView textView = this.f9844x;
        if (textView != null) {
            androidx.core.widget.i.m(textView, i3);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f9846y != colorStateList) {
            this.f9846y = colorStateList;
            TextView textView = this.f9844x;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f9808f.k(charSequence);
    }

    public void setPrefixTextAppearance(int i3) {
        this.f9808f.l(i3);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f9808f.m(colorStateList);
    }

    public void setStartIconCheckable(boolean z3) {
        this.f9808f.n(z3);
    }

    public void setStartIconContentDescription(int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconDrawable(int i3) {
        setStartIconDrawable(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f9808f.q(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9808f.r(onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f9808f.s(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f9808f.t(mode);
    }

    public void setStartIconVisible(boolean z3) {
        this.f9808f.u(z3);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f9775E = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f9777F.setText(charSequence);
        D0();
    }

    public void setSuffixTextAppearance(int i3) {
        androidx.core.widget.i.m(this.f9777F, i3);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f9777F.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f9814i;
        if (editText != null) {
            y.j0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f9804c0) {
            this.f9804c0 = typeface;
            this.f9780G0.setTypefaces(typeface);
            this.f9826o.L(typeface);
            TextView textView = this.f9834s;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void w0(boolean z3) {
        x0(z3, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(android.content.Context r27, android.util.AttributeSet r28, int r29) {
        /*
            Method dump skipped, instructions count: 1404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f9815i0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f9815i0.setImageDrawable(drawable);
        if (drawable != null) {
            com.google.android.material.textfield.f.a(this, this.f9815i0, this.f9819k0, this.f9821l0);
            U();
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f9808f.o(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f9808f.p(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f9833r0.setImageDrawable(drawable);
        u0();
        com.google.android.material.textfield.f.a(this, this.f9833r0, this.f9835s0, this.f9837t0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f9815i0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f9815i0.setImageDrawable(drawable);
    }

    public void setHint(int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }
}
