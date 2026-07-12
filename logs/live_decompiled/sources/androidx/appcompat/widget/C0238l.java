package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0238l {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f4275a;

    /* renamed from: b, reason: collision with root package name */
    private final D.f f4276b;

    C0238l(TextView textView) {
        this.f4275a = textView;
        this.f4276b = new D.f(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f4276b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f4276b.b();
    }

    void c(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = this.f4275a.getContext().obtainStyledAttributes(attributeSet, e.j.f11381g0, i3, 0);
        try {
            boolean z3 = obtainStyledAttributes.hasValue(e.j.f11437u0) ? obtainStyledAttributes.getBoolean(e.j.f11437u0, true) : true;
            obtainStyledAttributes.recycle();
            e(z3);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z3) {
        this.f4276b.c(z3);
    }

    void e(boolean z3) {
        this.f4276b.d(z3);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f4276b.e(transformationMethod);
    }
}
