package com.google.android.material.timepicker;

import H0.e;
import H0.g;
import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: e, reason: collision with root package name */
    private final Chip f9962e;

    /* renamed from: f, reason: collision with root package name */
    private final TextInputLayout f9963f;

    /* renamed from: g, reason: collision with root package name */
    private final EditText f9964g;

    /* renamed from: h, reason: collision with root package name */
    private TextWatcher f9965h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f9966i;

    private class b extends TextWatcherAdapter {
        private b() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f9962e.setText(ChipTextInputComboView.this.c("00"));
            } else {
                ChipTextInputComboView.this.f9962e.setText(ChipTextInputComboView.this.c(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return c.c(getResources(), charSequence);
    }

    private void d() {
        this.f9964g.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9962e.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        this.f9962e.setChecked(z3);
        this.f9964g.setVisibility(z3 ? 0 : 4);
        this.f9962e.setVisibility(z3 ? 8 : 0);
        if (isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.f9964g);
            if (TextUtils.isEmpty(this.f9964g.getText())) {
                return;
            }
            EditText editText = this.f9964g;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f9962e.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        this.f9962e.setTag(i3, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f9962e.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(g.f608m, (ViewGroup) this, false);
        this.f9962e = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(g.f609n, (ViewGroup) this, false);
        this.f9963f = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f9964g = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f9965h = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f9966i = (TextView) findViewById(e.f581n);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
