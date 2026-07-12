package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: m, reason: collision with root package name */
    Set f5964m = new HashSet();

    /* renamed from: n, reason: collision with root package name */
    boolean f5965n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence[] f5966o;

    /* renamed from: p, reason: collision with root package name */
    CharSequence[] f5967p;

    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i3, boolean z3) {
            if (z3) {
                d dVar = d.this;
                dVar.f5965n |= dVar.f5964m.add(dVar.f5967p[i3].toString());
            } else {
                d dVar2 = d.this;
                dVar2.f5965n |= dVar2.f5964m.remove(dVar2.f5967p[i3].toString());
            }
        }
    }

    private MultiSelectListPreference p() {
        return (MultiSelectListPreference) i();
    }

    public static d q(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.f
    public void m(boolean z3) {
        if (z3 && this.f5965n) {
            MultiSelectListPreference p3 = p();
            if (p3.callChangeListener(this.f5964m)) {
                p3.r(this.f5964m);
            }
        }
        this.f5965n = false;
    }

    @Override // androidx.preference.f
    protected void n(c.a aVar) {
        super.n(aVar);
        int length = this.f5967p.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.f5964m.contains(this.f5967p[i3].toString());
        }
        aVar.setMultiChoiceItems(this.f5966o, zArr, new a());
    }

    @Override // androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5964m.clear();
            this.f5964m.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f5965n = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f5966o = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f5967p = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference p3 = p();
        if (p3.o() == null || p3.p() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f5964m.clear();
        this.f5964m.addAll(p3.q());
        this.f5965n = false;
        this.f5966o = p3.o();
        this.f5967p = p3.p();
    }

    @Override // androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f5964m));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f5965n);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f5966o);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f5967p);
    }
}
