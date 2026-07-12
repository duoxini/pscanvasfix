package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: k, reason: collision with root package name */
    private CharSequence[] f5880k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence[] f5881l;

    /* renamed from: m, reason: collision with root package name */
    private Set f5882m;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5882m = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6180l0, i3, i4);
        this.f5880k = androidx.core.content.res.i.h(obtainStyledAttributes, s.f6189o0, s.f6183m0);
        this.f5881l = androidx.core.content.res.i.h(obtainStyledAttributes, s.f6192p0, s.f6186n0);
        obtainStyledAttributes.recycle();
    }

    public CharSequence[] o() {
        return this.f5880k;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        CharSequence[] textArray = typedArray.getTextArray(i3);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        r(aVar.f5883e);
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        a aVar = new a(onSaveInstanceState);
        aVar.f5883e = q();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        r(getPersistedStringSet((Set) obj));
    }

    public CharSequence[] p() {
        return this.f5881l;
    }

    public Set q() {
        return this.f5882m;
    }

    public void r(Set set) {
        this.f5882m.clear();
        this.f5882m.addAll(set);
        persistStringSet(set);
        notifyChanged();
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0090a();

        /* renamed from: e, reason: collision with root package name */
        Set f5883e;

        /* renamed from: androidx.preference.MultiSelectListPreference$a$a, reason: collision with other inner class name */
        static class C0090a implements Parcelable.Creator {
            C0090a() {
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
            int readInt = parcel.readInt();
            this.f5883e = new HashSet();
            String[] strArr = new String[readInt];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f5883e, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f5883e.size());
            Set set = this.f5883e;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6030b, R.attr.dialogPreferenceStyle));
    }
}
