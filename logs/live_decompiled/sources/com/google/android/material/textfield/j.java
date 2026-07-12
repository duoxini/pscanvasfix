package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class j extends e {

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f9945e;

    /* renamed from: f, reason: collision with root package name */
    private final TextInputLayout.f f9946f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.g f9947g;

    class a extends TextWatcherAdapter {
        a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            j.this.f9911c.setChecked(!r0.g());
        }
    }

    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            j.this.f9911c.setChecked(!r0.g());
            editText.removeTextChangedListener(j.this.f9945e);
            editText.addTextChangedListener(j.this.f9945e);
        }
    }

    class c implements TextInputLayout.g {

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ EditText f9951e;

            a(EditText editText) {
                this.f9951e = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f9951e.removeTextChangedListener(j.this.f9945e);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i3) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i3 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = j.this.f9909a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (j.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            j.this.f9909a.U();
        }
    }

    j(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout, i3);
        this.f9945e = new a();
        this.f9946f = new b();
        this.f9947g = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f9909a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        TextInputLayout textInputLayout = this.f9909a;
        int i3 = this.f9912d;
        if (i3 == 0) {
            i3 = H0.d.f544a;
        }
        textInputLayout.setEndIconDrawable(i3);
        TextInputLayout textInputLayout2 = this.f9909a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(H0.h.f635p));
        this.f9909a.setEndIconVisible(true);
        this.f9909a.setEndIconCheckable(true);
        this.f9909a.setEndIconOnClickListener(new d());
        this.f9909a.g(this.f9946f);
        this.f9909a.h(this.f9947g);
        EditText editText = this.f9909a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
