package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    TextInputLayout f9909a;

    /* renamed from: b, reason: collision with root package name */
    Context f9910b;

    /* renamed from: c, reason: collision with root package name */
    CheckableImageButton f9911c;

    /* renamed from: d, reason: collision with root package name */
    final int f9912d;

    e(TextInputLayout textInputLayout, int i3) {
        this.f9909a = textInputLayout;
        this.f9910b = textInputLayout.getContext();
        this.f9911c = textInputLayout.getEndIconView();
        this.f9912d = i3;
    }

    abstract void a();

    boolean b(int i3) {
        return true;
    }

    void c(boolean z3) {
    }

    boolean d() {
        return false;
    }
}
