package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.preference.l;
import androidx.preference.s;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.edittext.COUIInputView;

/* loaded from: classes.dex */
public class COUIInputPreference extends COUIPreference {

    /* renamed from: e, reason: collision with root package name */
    private COUIEditText f8532e;

    /* renamed from: f, reason: collision with root package name */
    private a f8533f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f8534g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f8535h;

    /* renamed from: i, reason: collision with root package name */
    private View f8536i;

    public static class a extends COUIInputView {

        /* renamed from: H, reason: collision with root package name */
        boolean f8537H;

        public a(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        protected COUIEditText H(Context context, AttributeSet attributeSet) {
            context.getTheme().applyStyle(W1.g.f2715a, true);
            com.coui.appcompat.edittext.d dVar = new com.coui.appcompat.edittext.d(context, attributeSet, S1.a.f2084c);
            dVar.setTextDirection(5);
            dVar.setShowDeleteIcon(false);
            dVar.setVerticalScrollBarEnabled(false);
            return dVar;
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        protected boolean J() {
            return true;
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        protected int getEdittextPaddingBottom() {
            return !TextUtils.isEmpty(this.f7846l) ? getResources().getDimensionPixelSize(S1.b.f2086b) : (int) getResources().getDimension(S1.b.f2088d);
        }

        @Override // com.coui.appcompat.edittext.COUIInputView
        protected int getEdittextPaddingTop() {
            return !TextUtils.isEmpty(this.f7846l) ? getResources().getDimensionPixelSize(S1.b.f2087c) : (int) getResources().getDimension(S1.b.f2089e);
        }

        public void setJustShowFocusLine(boolean z3) {
            if (this.f8537H != z3) {
                this.f8537H = z3;
                COUIEditText cOUIEditText = this.f7844j;
                if (cOUIEditText != null) {
                    cOUIEditText.setJustShowFocusLine(z3);
                }
            }
        }

        public a(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f8537H = false;
        }
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2595e);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (this.f8532e.z()) {
            return false;
        }
        return super.drawDivider();
    }

    public void j(CharSequence charSequence) {
        COUIEditText cOUIEditText = this.f8532e;
        if (cOUIEditText != null) {
            cOUIEditText.setCouiEditTexttNoEllipsisText((String) charSequence);
            this.f8534g = charSequence;
            return;
        }
        if (!TextUtils.equals(this.f8534g, charSequence)) {
            notifyChanged();
        }
        boolean shouldDisableDependents = shouldDisableDependents();
        this.f8534g = charSequence;
        if (charSequence != null) {
            persistString(charSequence.toString());
        }
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        View view = lVar.itemView;
        this.f8536i = view;
        if (view instanceof COUICardListSelectedItemLayout) {
            ((COUICardListSelectedItemLayout) view).a(true);
        }
        ViewGroup viewGroup = (ViewGroup) this.f8536i.findViewById(W1.d.f2693u);
        if (viewGroup != null) {
            if (!this.f8533f.equals((a) viewGroup.findViewById(R.id.input))) {
                this.f8533f.getEditText().I();
                ViewParent parent = this.f8533f.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.f8533f);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.f8533f, -1, -2);
                int b3 = com.coui.appcompat.cardlist.a.b(this);
                if (b3 == 3 || b3 == 4) {
                    this.f8533f.getEditText().setBoxBackgroundMode(3);
                }
            }
        }
        this.f8533f.setEnabled(isEnabled());
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
        j(bVar.f8538e);
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        b bVar = new b(onSaveInstanceState);
        CharSequence charSequence = this.f8534g;
        if (charSequence != null) {
            bVar.f8538e = charSequence.toString();
        }
        return bVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(boolean z3, Object obj) {
        if (TextUtils.isEmpty(this.f8534g)) {
            return;
        }
        j(z3 ? getPersistedString(this.f8534g.toString()) : (String) obj);
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.f8534g) || super.shouldDisableDependents();
    }

    private static class b extends Preference.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f8538e;

        class a implements Parcelable.Creator {
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

        public b(Parcel parcel) {
            super(parcel);
            this.f8538e = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f8538e);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2720f);
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2831z, i3, i4);
        this.f8534g = obtainStyledAttributes.getText(W1.h.f2731A);
        boolean z3 = obtainStyledAttributes.getBoolean(W1.h.f2733B, true);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.f6201s0, i3, i4);
        this.f8535h = obtainStyledAttributes2.getText(s.f6216x0);
        obtainStyledAttributes2.recycle();
        a aVar = new a(context, attributeSet);
        this.f8533f = aVar;
        aVar.setId(R.id.input);
        this.f8533f.setTitle(this.f8535h);
        this.f8532e = this.f8533f.getEditText();
        this.f8533f.setJustShowFocusLine(z3);
    }
}
