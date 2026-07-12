package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.text.c;
import f.AbstractC0348a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0251z extends TextView {
    private final C0231e mBackgroundTintHelper;
    private C0238l mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<androidx.core.text.c> mPrecomputedTextFuture;
    private a mSuperCaller;
    private final C0249x mTextClassifierHelper;
    private final C0250y mTextHelper;

    /* renamed from: androidx.appcompat.widget.z$a */
    private interface a {
        void a(int[] iArr, int i3);

        void b(TextClassifier textClassifier);

        int c();

        int[] d();

        void e(int i3);

        void f(int i3);

        TextClassifier g();

        int h();

        int i();

        void j(int i3);

        void k(int i3, int i4, int i5, int i6);

        int l();
    }

    /* renamed from: androidx.appcompat.widget.z$b */
    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public void a(int[] iArr, int i3) {
            C0251z.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public void b(TextClassifier textClassifier) {
            C0251z.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public int c() {
            return C0251z.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public int[] d() {
            return C0251z.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public TextClassifier g() {
            return C0251z.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public int h() {
            return C0251z.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public int i() {
            return C0251z.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public void j(int i3) {
            C0251z.super.setAutoSizeTextTypeWithDefaults(i3);
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public void k(int i3, int i4, int i5, int i6) {
            C0251z.super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public int l() {
            return C0251z.super.getAutoSizeTextType();
        }
    }

    /* renamed from: androidx.appcompat.widget.z$c */
    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public void e(int i3) {
            C0251z.super.setLastBaselineToBottomHeight(i3);
        }

        @Override // androidx.appcompat.widget.C0251z.a
        public void f(int i3) {
            C0251z.super.setFirstBaselineToTopHeight(i3);
        }
    }

    public C0251z(Context context) {
        this(context, null);
    }

    private void a() {
        Future<androidx.core.text.c> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                androidx.appcompat.app.p.a(future.get());
                androidx.core.widget.i.l(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    private C0238l getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new C0238l(this);
        }
        return this.mEmojiTextViewHelper;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            c0231e.b();
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b0.f4200b) {
            return getSuperCaller().i();
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            return c0250y.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b0.f4200b) {
            return getSuperCaller().c();
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            return c0250y.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b0.f4200b) {
            return getSuperCaller().h();
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            return c0250y.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b0.f4200b) {
            return getSuperCaller().d();
        }
        C0250y c0250y = this.mTextHelper;
        return c0250y != null ? c0250y.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b0.f4200b) {
            return getSuperCaller().l() == 1 ? 1 : 0;
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            return c0250y.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.c(this);
    }

    a getSuperCaller() {
        if (this.mSuperCaller == null) {
            this.mSuperCaller = new c();
        }
        return this.mSuperCaller;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().g();
    }

    public c.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.e(this);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r(this, onCreateInputConnection, editorInfo);
        return AbstractC0239m.a(onCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.o(z3, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        a();
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        C0250y c0250y = this.mTextHelper;
        if (c0250y == null || b0.f4200b || !c0250y.l()) {
            return;
        }
        this.mTextHelper.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) {
        if (b0.f4200b) {
            getSuperCaller().k(i3, i4, i5, i6);
            return;
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.t(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        if (b0.f4200b) {
            getSuperCaller().a(iArr, i3);
            return;
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.u(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (b0.f4200b) {
            getSuperCaller().j(i3);
            return;
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.v(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i3) {
        getSuperCaller().f(i3);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i3) {
        getSuperCaller().e(i3);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i3) {
        androidx.core.widget.i.k(this, i3);
    }

    public void setPrecomputedText(androidx.core.text.c cVar) {
        androidx.core.widget.i.l(this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.mBackgroundTintHelper;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.w(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.x(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().b(textClassifier);
    }

    public void setTextFuture(Future<androidx.core.text.c> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        androidx.core.widget.i.n(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (b0.f4200b) {
            super.setTextSize(i3, f3);
            return;
        }
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.A(i3, f3);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i3) {
        if (this.mIsSetTypefaceProcessing) {
            return;
        }
        Typeface a3 = (typeface == null || i3 <= 0) ? null : androidx.core.graphics.d.a(getContext(), typeface, i3);
        this.mIsSetTypefaceProcessing = true;
        if (a3 != null) {
            typeface = a3;
        }
        try {
            super.setTypeface(typeface, i3);
        } finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }

    public C0251z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public C0251z(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        Q.a(this, getContext());
        C0231e c0231e = new C0231e(this);
        this.mBackgroundTintHelper = c0231e;
        c0231e.e(attributeSet, i3);
        C0250y c0250y = new C0250y(this);
        this.mTextHelper = c0250y;
        c0250y.m(attributeSet, i3);
        c0250y.b();
        this.mTextClassifierHelper = new C0249x(this);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i3 != 0 ? AbstractC0348a.b(context, i3) : null, i4 != 0 ? AbstractC0348a.b(context, i4) : null, i5 != 0 ? AbstractC0348a.b(context, i5) : null, i6 != 0 ? AbstractC0348a.b(context, i6) : null);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i3 != 0 ? AbstractC0348a.b(context, i3) : null, i4 != 0 ? AbstractC0348a.b(context, i4) : null, i5 != 0 ? AbstractC0348a.b(context, i5) : null, i6 != 0 ? AbstractC0348a.b(context, i6) : null);
        C0250y c0250y = this.mTextHelper;
        if (c0250y != null) {
            c0250y.p();
        }
    }
}
