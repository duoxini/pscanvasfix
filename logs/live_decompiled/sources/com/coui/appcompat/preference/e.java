package com.coui.appcompat.preference;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.DialogPreference;
import com.coui.appcompat.edittext.COUIEditText;
import f0.C0350b;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class e extends androidx.preference.a {

    /* renamed from: o, reason: collision with root package name */
    private COUIEditText f8767o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8768p = false;

    /* renamed from: q, reason: collision with root package name */
    private EnumC0643a f8769q = y0.j.f14497a;

    class a implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f8770e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f8771f;

        a(androidx.appcompat.app.c cVar, boolean z3) {
            this.f8770e = cVar;
            this.f8771f = z3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Button e3 = this.f8770e.e(-1);
            if (e3 == null || this.f8771f) {
                return;
            }
            e3.setEnabled(!TextUtils.isEmpty(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    private C0350b r() {
        return new C0350b(requireContext(), P1.f.f1835d).setTitle(i().l()).setMessage(i().k()).setPositiveButton(i().n(), this).setNegativeButton(i().m(), this);
    }

    public static e s(String str) {
        e eVar = new e();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        COUIEditTextPreference cOUIEditTextPreference;
        FragmentActivity activity = getActivity();
        C0350b r3 = r();
        View l3 = l(activity);
        if (l3 == null) {
            Log.d("COUIEditTextPreferenceDialogFragment", "COUIEditTextPreferenceDialogFragment  contentView == null ");
            return r3.create();
        }
        this.f8767o = (COUIEditText) l3.findViewById(R.id.edit);
        k(l3);
        r3.setView(l3);
        if (i() != null) {
            k(l3);
        }
        n(r3);
        DialogPreference i3 = i();
        if (i3 == null || !(i3 instanceof COUIEditTextPreference)) {
            cOUIEditTextPreference = null;
        } else {
            cOUIEditTextPreference = (COUIEditTextPreference) i3;
            this.f8768p = cOUIEditTextPreference.t();
            this.f8769q = cOUIEditTextPreference.s();
        }
        androidx.appcompat.app.c create = r3.H(this.f8768p, this.f8769q).create();
        this.f8767o.addTextChangedListener(new a(create, cOUIEditTextPreference != null ? cOUIEditTextPreference.u() : false));
        return create;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        COUIEditText cOUIEditText = this.f8767o;
        if (cOUIEditText != null) {
            cOUIEditText.setFocusable(true);
            this.f8767o.requestFocus();
            if (getDialog() != null) {
                getDialog().getWindow().setSoftInputMode(5);
            }
        }
    }

    @Override // androidx.preference.a, androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        COUIEditText cOUIEditText = this.f8767o;
        if (cOUIEditText != null) {
            bundle.putCharSequence("EditTextPreferenceDialogFragment.text", cOUIEditText.getText());
            bundle.putBoolean("ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND", this.f8768p);
        }
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (i() == null) {
            dismiss();
        }
    }
}
