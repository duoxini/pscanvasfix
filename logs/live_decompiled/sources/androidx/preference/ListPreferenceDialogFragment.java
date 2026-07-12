package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

@Deprecated
/* loaded from: classes.dex */
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {

    /* renamed from: m, reason: collision with root package name */
    int f5876m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence[] f5877n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence[] f5878o;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ListPreferenceDialogFragment listPreferenceDialogFragment = ListPreferenceDialogFragment.this;
            listPreferenceDialogFragment.f5876m = i3;
            listPreferenceDialogFragment.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    @Deprecated
    public ListPreferenceDialogFragment() {
    }

    private ListPreference h() {
        return (ListPreference) a();
    }

    public static ListPreferenceDialogFragment i(String str) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = new ListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragment.setArguments(bundle);
        return listPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z3) {
        int i3;
        ListPreference h3 = h();
        if (!z3 || (i3 = this.f5876m) < 0) {
            return;
        }
        String charSequence = this.f5878o[i3].toString();
        if (h3.callChangeListener(charSequence)) {
            h3.u(charSequence);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void f(AlertDialog.Builder builder) {
        super.f(builder);
        builder.setSingleChoiceItems(this.f5877n, this.f5876m, new a());
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5876m = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f5877n = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f5878o = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference h3 = h();
        if (h3.p() == null || h3.r() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f5876m = h3.o(h3.s());
        this.f5877n = h3.p();
        this.f5878o = h3.r();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f5876m);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f5877n);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f5878o);
    }
}
