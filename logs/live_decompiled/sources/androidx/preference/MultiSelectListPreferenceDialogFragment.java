package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {

    /* renamed from: m, reason: collision with root package name */
    Set f5884m = new HashSet();

    /* renamed from: n, reason: collision with root package name */
    boolean f5885n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence[] f5886o;

    /* renamed from: p, reason: collision with root package name */
    CharSequence[] f5887p;

    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i3, boolean z3) {
            if (z3) {
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment.f5885n |= multiSelectListPreferenceDialogFragment.f5884m.add(multiSelectListPreferenceDialogFragment.f5887p[i3].toString());
            } else {
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment2.f5885n |= multiSelectListPreferenceDialogFragment2.f5884m.remove(multiSelectListPreferenceDialogFragment2.f5887p[i3].toString());
            }
        }
    }

    @Deprecated
    public MultiSelectListPreferenceDialogFragment() {
    }

    private MultiSelectListPreference h() {
        return (MultiSelectListPreference) a();
    }

    public static MultiSelectListPreferenceDialogFragment i(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z3) {
        MultiSelectListPreference h3 = h();
        if (z3 && this.f5885n) {
            Set set = this.f5884m;
            if (h3.callChangeListener(set)) {
                h3.r(set);
            }
        }
        this.f5885n = false;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void f(AlertDialog.Builder builder) {
        super.f(builder);
        int length = this.f5887p.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.f5884m.contains(this.f5887p[i3].toString());
        }
        builder.setMultiChoiceItems(this.f5886o, zArr, new a());
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5884m.clear();
            this.f5884m.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
            this.f5885n = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
            this.f5886o = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
            this.f5887p = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
            return;
        }
        MultiSelectListPreference h3 = h();
        if (h3.o() == null || h3.p() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f5884m.clear();
        this.f5884m.addAll(h3.q());
        this.f5885n = false;
        this.f5886o = h3.o();
        this.f5887p = h3.p();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList<>(this.f5884m));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.f5885n);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.f5886o);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.f5887p);
    }
}
