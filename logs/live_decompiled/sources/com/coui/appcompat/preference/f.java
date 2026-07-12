package com.coui.appcompat.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import f0.C0350b;
import g0.AbstractC0363a;
import h0.AbstractC0371a;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class f extends androidx.preference.c {

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f8773p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f8774q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence[] f8775r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence[] f8776s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence[] f8777t;

    /* renamed from: u, reason: collision with root package name */
    private C0350b f8778u;

    /* renamed from: w, reason: collision with root package name */
    private COUIListPreference f8780w;

    /* renamed from: v, reason: collision with root package name */
    private int f8779v = -1;

    /* renamed from: x, reason: collision with root package name */
    private boolean f8781x = true;

    /* renamed from: y, reason: collision with root package name */
    private boolean f8782y = false;

    /* renamed from: z, reason: collision with root package name */
    private EnumC0643a f8783z = y0.j.f14497a;

    class a extends AbstractC0363a {
        a(Context context, int i3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean z3) {
            super(context, i3, charSequenceArr, charSequenceArr2, zArr, z3);
        }

        @Override // g0.AbstractC0363a, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i3, view, viewGroup);
            View findViewById = view2.findViewById(P1.d.f1817n);
            int count = getCount();
            if (findViewById != null) {
                if (count == 1 || i3 == count - 1) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
            return view2;
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            f.this.f8779v = i3;
            f.this.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    public static f s(String str) {
        f fVar = new f();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        fVar.setArguments(bundle);
        return fVar;
    }

    private void t() {
        int i3 = this.f8779v;
        if (i3 >= 0) {
            CharSequence[] charSequenceArr = this.f8776s;
            if (i3 < charSequenceArr.length) {
                String charSequence = charSequenceArr[i3].toString();
                if (i() != null) {
                    COUIListPreference cOUIListPreference = (COUIListPreference) i();
                    if (cOUIListPreference.callChangeListener(charSequence)) {
                        cOUIListPreference.u(charSequence);
                    }
                }
            }
        }
    }

    @Override // androidx.preference.c, androidx.preference.f
    public void m(boolean z3) {
        if (!z3 || this.f8775r == null) {
            return;
        }
        t();
    }

    @Override // androidx.preference.c, androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && i() == null) {
            this.f8779v = bundle.getInt("COUIListPreferenceDialogFragment.index", -1);
            this.f8773p = bundle.getString("COUIListPreferenceDialogFragment.title");
            this.f8774q = bundle.getString("COUIListPreferenceDialogFragment.message");
            this.f8775r = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f8776s = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            this.f8777t = bundle.getCharSequenceArray("COUListPreferenceDialogFragment.summarys");
            this.f8781x = bundle.getBoolean("ListPreferenceDialogFragment.SAVE_STATE_FOLLOWHAND");
            this.f8782y = bundle.getBoolean("ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND");
            this.f8783z = EnumC0643a.b(bundle.getInt("ListPreferenceDialogFragment.SAVE_STATE_BLUR_ANIM_LAVEL", y0.j.f14497a.a()));
            AbstractC0371a.c("COUIListDialogFragment", "OnCreate, mPreference == null");
            return;
        }
        COUIListPreference cOUIListPreference = (COUIListPreference) i();
        this.f8780w = cOUIListPreference;
        if (cOUIListPreference.p() == null || this.f8780w.r() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f8773p = this.f8780w.l();
        this.f8774q = this.f8780w.k();
        this.f8777t = this.f8780w.z();
        COUIListPreference cOUIListPreference2 = this.f8780w;
        this.f8779v = cOUIListPreference2.o(cOUIListPreference2.s());
        this.f8775r = this.f8780w.p();
        this.f8776s = this.f8780w.r();
        this.f8781x = this.f8780w.B();
        this.f8782y = this.f8780w.A();
        this.f8783z = this.f8780w.w();
    }

    @Override // androidx.preference.f, androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        boolean[] zArr;
        int i3;
        CharSequence[] charSequenceArr = this.f8775r;
        View view = null;
        if (charSequenceArr == null || (i3 = this.f8779v) < 0 || i3 >= charSequenceArr.length) {
            zArr = null;
        } else {
            boolean[] zArr2 = new boolean[charSequenceArr.length];
            zArr2[i3] = true;
            zArr = zArr2;
        }
        C0350b adapter = new C0350b(requireContext(), P1.f.f1835d).setTitle(this.f8773p).setMessage(this.f8774q).setNegativeButton(W1.f.f2714b, null).H(this.f8782y, this.f8783z).setAdapter(new a(getContext(), P1.e.f1831c, this.f8775r, this.f8777t, zArr, false), new b());
        this.f8778u = adapter;
        if (!this.f8781x) {
            return adapter.create();
        }
        Point point = new Point();
        COUIListPreference cOUIListPreference = this.f8780w;
        if (cOUIListPreference != null) {
            view = cOUIListPreference.y();
            point = this.f8780w.x();
        }
        return view == null ? this.f8778u.create() : this.f8778u.h(view, point);
    }

    @Override // androidx.preference.c, androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("COUIListPreferenceDialogFragment.index", this.f8779v);
        CharSequence charSequence = this.f8773p;
        if (charSequence != null) {
            bundle.putString("COUIListPreferenceDialogFragment.title", String.valueOf(charSequence));
        }
        CharSequence charSequence2 = this.f8774q;
        if (charSequence2 != null) {
            bundle.putString("COUIListPreferenceDialogFragment.message", String.valueOf(charSequence2));
        }
        bundle.putCharSequenceArray("COUListPreferenceDialogFragment.summarys", this.f8777t);
        bundle.putBoolean("ListPreferenceDialogFragment.SAVE_STATE_FOLLOWHAND", this.f8781x);
        bundle.putBoolean("ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND", this.f8782y);
        bundle.putInt("ListPreferenceDialogFragment.SAVE_STATE_BLUR_ANIM_LAVEL", this.f8783z.a());
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (i() == null) {
            dismiss();
            return;
        }
        C0350b c0350b = this.f8778u;
        if (c0350b != null) {
            c0350b.b0();
        }
    }
}
