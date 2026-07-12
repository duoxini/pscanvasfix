package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: k, reason: collision with root package name */
    private String f5864k;

    public interface a {
    }

    public static final class c implements Preference.g {

        /* renamed from: a, reason: collision with root package name */
        private static c f5866a;

        private c() {
        }

        public static c b() {
            if (f5866a == null) {
                f5866a = new c();
            }
            return f5866a;
        }

        @Override // androidx.preference.Preference.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.p()) ? editTextPreference.getContext().getString(q.f6055c) : editTextPreference.p();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6110R, i3, i4);
        int i5 = s.f6113S;
        if (androidx.core.content.res.i.b(obtainStyledAttributes, i5, i5, false)) {
            setSummaryProvider(c.b());
        }
        obtainStyledAttributes.recycle();
    }

    a o() {
        return null;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return typedArray.getString(i3);
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(b.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        q(bVar.f5865e);
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        b bVar = new b(onSaveInstanceState);
        bVar.f5865e = p();
        return bVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        q(getPersistedString((String) obj));
    }

    public String p() {
        return this.f5864k;
    }

    public void q(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.f5864k = str;
        persistString(str);
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.f5864k) || super.shouldDisableDependents();
    }

    private static class b extends Preference.b {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f5865e;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        b(Parcel parcel) {
            super(parcel);
            this.f5865e = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f5865e);
        }

        b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6032d, R.attr.editTextPreferenceStyle));
    }
}
