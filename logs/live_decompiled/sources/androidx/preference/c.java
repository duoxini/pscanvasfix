package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;

/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: m, reason: collision with root package name */
    int f5960m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence[] f5961n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence[] f5962o;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            c cVar = c.this;
            cVar.f5960m = i3;
            cVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference p() {
        return (ListPreference) i();
    }

    public static c q(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.preference.f
    public void m(boolean z3) {
        int i3;
        if (!z3 || (i3 = this.f5960m) < 0) {
            return;
        }
        String charSequence = this.f5962o[i3].toString();
        ListPreference p3 = p();
        if (p3.callChangeListener(charSequence)) {
            p3.u(charSequence);
        }
    }

    @Override // androidx.preference.f
    protected void n(c.a aVar) {
        super.n(aVar);
        aVar.setSingleChoiceItems(this.f5961n, this.f5960m, new a());
        aVar.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5960m = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f5961n = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f5962o = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference p3 = p();
        if (p3.p() == null || p3.r() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f5960m = p3.o(p3.s());
        this.f5961n = p3.p();
        this.f5962o = p3.r();
    }

    @Override // androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f5960m);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f5961n);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f5962o);
    }
}
