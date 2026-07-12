package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: k, reason: collision with root package name */
    private CharSequence[] f5869k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence[] f5870l;

    /* renamed from: m, reason: collision with root package name */
    private String f5871m;

    /* renamed from: n, reason: collision with root package name */
    private String f5872n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5873o;

    public static final class b implements Preference.g {

        /* renamed from: a, reason: collision with root package name */
        private static b f5875a;

        private b() {
        }

        public static b b() {
            if (f5875a == null) {
                f5875a = new b();
            }
            return f5875a;
        }

        @Override // androidx.preference.Preference.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.q()) ? listPreference.getContext().getString(q.f6055c) : listPreference.q();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6146c0, i3, i4);
        this.f5869k = androidx.core.content.res.i.h(obtainStyledAttributes, s.f6158f0, s.f6150d0);
        this.f5870l = androidx.core.content.res.i.h(obtainStyledAttributes, s.f6162g0, s.f6154e0);
        int i5 = s.f6166h0;
        if (androidx.core.content.res.i.b(obtainStyledAttributes, i5, i5, false)) {
            setSummaryProvider(b.b());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.f6201s0, i3, i4);
        this.f5872n = androidx.core.content.res.i.f(obtainStyledAttributes2, s.f6139a1, s.f6060A0);
        obtainStyledAttributes2.recycle();
    }

    private int t() {
        return o(this.f5871m);
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().a(this);
        }
        CharSequence q3 = q();
        CharSequence summary = super.getSummary();
        String str = this.f5872n;
        if (str == null) {
            return summary;
        }
        if (q3 == null) {
            q3 = "";
        }
        String format = String.format(str, q3);
        if (TextUtils.equals(format, summary)) {
            return summary;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public int o(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f5870l) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.f5870l[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return typedArray.getString(i3);
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        u(aVar.f5874e);
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        a aVar = new a(onSaveInstanceState);
        aVar.f5874e = s();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        u(getPersistedString((String) obj));
    }

    public CharSequence[] p() {
        return this.f5869k;
    }

    public CharSequence q() {
        CharSequence[] charSequenceArr;
        int t3 = t();
        if (t3 < 0 || (charSequenceArr = this.f5869k) == null) {
            return null;
        }
        return charSequenceArr[t3];
    }

    public CharSequence[] r() {
        return this.f5870l;
    }

    public String s() {
        return this.f5871m;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.f5872n != null) {
            this.f5872n = null;
        } else {
            if (charSequence == null || charSequence.equals(this.f5872n)) {
                return;
            }
            this.f5872n = charSequence.toString();
        }
    }

    public void u(String str) {
        boolean equals = TextUtils.equals(this.f5871m, str);
        if (equals && this.f5873o) {
            return;
        }
        this.f5871m = str;
        this.f5873o = true;
        persistString(str);
        if (equals) {
            return;
        }
        notifyChanged();
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0089a();

        /* renamed from: e, reason: collision with root package name */
        String f5874e;

        /* renamed from: androidx.preference.ListPreference$a$a, reason: collision with other inner class name */
        static class C0089a implements Parcelable.Creator {
            C0089a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        a(Parcel parcel) {
            super(parcel);
            this.f5874e = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f5874e);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6030b, R.attr.dialogPreferenceStyle));
    }
}
