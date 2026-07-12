package com.coui.appcompat.preference;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import f0.C0350b;
import g0.AbstractC0363a;
import h0.AbstractC0371a;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class g extends androidx.preference.d {

    /* renamed from: A, reason: collision with root package name */
    private COUIMultiSelectListPreference f8786A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f8787B = true;

    /* renamed from: C, reason: collision with root package name */
    private boolean f8788C = false;

    /* renamed from: D, reason: collision with root package name */
    private EnumC0643a f8789D = y0.j.f14497a;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f8790q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f8791r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence[] f8792s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence[] f8793t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence[] f8794u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f8795v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f8796w;

    /* renamed from: x, reason: collision with root package name */
    private C0350b f8797x;

    /* renamed from: y, reason: collision with root package name */
    private AbstractC0363a f8798y;

    /* renamed from: z, reason: collision with root package name */
    private boolean[] f8799z;

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

    private boolean[] r(Set set) {
        boolean[] zArr = new boolean[this.f8792s.length];
        int i3 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.f8792s;
            if (i3 >= charSequenceArr.length) {
                return zArr;
            }
            zArr[i3] = set.contains(charSequenceArr[i3].toString());
            i3++;
        }
    }

    private Set s() {
        HashSet hashSet = new HashSet();
        boolean[] f3 = this.f8798y.f();
        for (int i3 = 0; i3 < f3.length; i3++) {
            CharSequence[] charSequenceArr = this.f8793t;
            if (i3 >= charSequenceArr.length) {
                break;
            }
            if (f3[i3]) {
                hashSet.add(charSequenceArr[i3].toString());
            }
        }
        return hashSet;
    }

    public static g t(String str) {
        g gVar = new g();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        gVar.setArguments(bundle);
        return gVar;
    }

    @Override // androidx.preference.d, androidx.preference.f
    public void m(boolean z3) {
        COUIMultiSelectListPreference cOUIMultiSelectListPreference;
        super.m(z3);
        if (z3) {
            Set s3 = s();
            if (i() == null || (cOUIMultiSelectListPreference = (COUIMultiSelectListPreference) i()) == null || !cOUIMultiSelectListPreference.callChangeListener(s3)) {
                return;
            }
            cOUIMultiSelectListPreference.r(s3);
        }
    }

    @Override // androidx.preference.d, androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && i() == null) {
            this.f8790q = bundle.getString("COUIMultiSelectListPreferenceDialogFragment.title");
            this.f8791r = bundle.getString("COUIMultiSelectListPreferenceDialogFragment.message");
            this.f8792s = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f8793t = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            this.f8794u = bundle.getCharSequenceArray("COUIMultiSelectListPreferenceDialogFragment.summarys");
            this.f8795v = bundle.getString("COUIMultiSelectListPreferenceDialogFragment.positiveButtonText");
            this.f8796w = bundle.getString("COUIMultiSelectListPreferenceDialogFragment.negativeButtonTextitle");
            this.f8799z = bundle.getBooleanArray("COUIMultiSelectListPreferenceDialogFragment.values");
            this.f8787B = bundle.getBoolean("ListPreferenceDialogFragment.SAVE_STATE_FOLLOWHAND");
            this.f8788C = bundle.getBoolean("ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND");
            this.f8789D = EnumC0643a.b(bundle.getInt("ListPreferenceDialogFragment.SAVE_STATE_BLUR_ANIM_LAVEL", y0.j.f14497a.a()));
            AbstractC0371a.c("COUIMultiDialogFragment", "OnCreate, mPreference == null");
            return;
        }
        COUIMultiSelectListPreference cOUIMultiSelectListPreference = (COUIMultiSelectListPreference) i();
        this.f8786A = cOUIMultiSelectListPreference;
        if (cOUIMultiSelectListPreference.o() == null || this.f8786A.p() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f8790q = this.f8786A.l();
        this.f8791r = this.f8786A.k();
        this.f8792s = this.f8786A.o();
        this.f8793t = this.f8786A.p();
        this.f8794u = this.f8786A.w();
        this.f8795v = this.f8786A.n();
        this.f8796w = this.f8786A.m();
        this.f8799z = r(this.f8786A.q());
        this.f8787B = this.f8786A.y();
        this.f8788C = this.f8786A.x();
        this.f8789D = this.f8786A.t();
    }

    @Override // androidx.preference.f, androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        Point point;
        View view;
        this.f8798y = new a(getContext(), P1.e.f1830b, this.f8792s, this.f8794u, this.f8799z, true);
        Context context = getContext();
        Objects.requireNonNull(context);
        C0350b H3 = new C0350b(context, P1.f.f1835d).setTitle(this.f8790q).setMessage(this.f8791r).setAdapter(this.f8798y, this).setPositiveButton(this.f8795v, this).setNegativeButton(this.f8796w, this).H(this.f8788C, this.f8789D);
        this.f8797x = H3;
        if (!this.f8787B) {
            return H3.create();
        }
        Point point2 = new Point();
        COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.f8786A;
        if (cOUIMultiSelectListPreference != null) {
            view = cOUIMultiSelectListPreference.v();
            point = this.f8786A.u();
        } else {
            point = point2;
            view = null;
        }
        return view == null ? this.f8797x.create() : this.f8797x.h(view, point);
    }

    @Override // androidx.preference.d, androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBooleanArray("COUIMultiSelectListPreferenceDialogFragment.values", this.f8798y.f());
        CharSequence charSequence = this.f8790q;
        if (charSequence != null) {
            bundle.putString("COUIMultiSelectListPreferenceDialogFragment.title", String.valueOf(charSequence));
        }
        CharSequence charSequence2 = this.f8791r;
        if (charSequence2 != null) {
            bundle.putString("COUIMultiSelectListPreferenceDialogFragment.message", String.valueOf(charSequence2));
        }
        bundle.putString("COUIMultiSelectListPreferenceDialogFragment.positiveButtonText", String.valueOf(this.f8795v));
        bundle.putString("COUIMultiSelectListPreferenceDialogFragment.negativeButtonTextitle", String.valueOf(this.f8796w));
        bundle.putCharSequenceArray("COUIMultiSelectListPreferenceDialogFragment.summarys", this.f8794u);
        bundle.putBoolean("ListPreferenceDialogFragment.SAVE_STATE_FOLLOWHAND", this.f8787B);
        bundle.putBoolean("ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND", this.f8788C);
        bundle.putInt("ListPreferenceDialogFragment.SAVE_STATE_BLUR_ANIM_LAVEL", this.f8789D.a());
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (i() == null) {
            dismiss();
            return;
        }
        C0350b c0350b = this.f8797x;
        if (c0350b != null) {
            c0350b.b0();
        }
    }
}
