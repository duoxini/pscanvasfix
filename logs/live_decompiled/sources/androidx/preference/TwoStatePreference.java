package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: e, reason: collision with root package name */
    protected boolean f5951e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f5952f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f5953g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5954h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5955i;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public boolean i() {
        return this.f5951e;
    }

    public void j(boolean z3) {
        boolean z4 = this.f5951e != z3;
        if (z4 || !this.f5954h) {
            this.f5951e = z3;
            this.f5954h = true;
            persistBoolean(z3);
            if (z4) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

    public void k(boolean z3) {
        this.f5955i = z3;
    }

    public void l(CharSequence charSequence) {
        this.f5953g = charSequence;
        if (i()) {
            return;
        }
        notifyChanged();
    }

    public void m(CharSequence charSequence) {
        this.f5952f = charSequence;
        if (i()) {
            notifyChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void n(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            boolean r0 = r3.f5951e
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r3.f5952f
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r3.f5952f
            r4.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r3.f5951e
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.f5953g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.f5953g
            r4.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.getSummary()
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L3e
            r4.setText(r3)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r3 = r4.getVisibility()
            if (r1 == r3) goto L4c
            r4.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.n(android.view.View):void");
    }

    protected void o(l lVar) {
        n(lVar.b(R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        super.onClick();
        boolean z3 = !i();
        if (callChangeListener(Boolean.valueOf(z3))) {
            j(z3);
        }
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return Boolean.valueOf(typedArray.getBoolean(i3, false));
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        j(aVar.f5956e);
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        a aVar = new a(onSaveInstanceState);
        aVar.f5956e = i();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        j(getPersistedBoolean(((Boolean) obj).booleanValue()));
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return (this.f5955i ? this.f5951e : !this.f5951e) || super.shouldDisableDependents();
    }

    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0091a();

        /* renamed from: e, reason: collision with root package name */
        boolean f5956e;

        /* renamed from: androidx.preference.TwoStatePreference$a$a, reason: collision with other inner class name */
        static class C0091a implements Parcelable.Creator {
            C0091a() {
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
            this.f5956e = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f5956e ? 1 : 0);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
