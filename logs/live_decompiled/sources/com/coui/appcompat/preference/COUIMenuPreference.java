package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.preference.Preference;
import androidx.preference.l;
import com.coui.appcompat.poplist.A;
import com.coui.appcompat.poplist.C0302c;
import com.coui.appcompat.poplist.s;
import h0.AbstractC0371a;
import java.util.ArrayList;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class COUIMenuPreference extends COUIPreference {

    /* renamed from: e, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f8602e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence[] f8603f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence[] f8604g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f8605h;

    /* renamed from: i, reason: collision with root package name */
    private String f8606i;

    /* renamed from: j, reason: collision with root package name */
    private String f8607j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8608k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f8609l;

    /* renamed from: m, reason: collision with root package name */
    private C0302c f8610m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8611n;

    /* renamed from: o, reason: collision with root package name */
    private A.c f8612o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f8613p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8614q;

    /* renamed from: r, reason: collision with root package name */
    private int f8615r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8616s;

    /* renamed from: t, reason: collision with root package name */
    private EnumC0643a f8617t;

    /* renamed from: u, reason: collision with root package name */
    private int f8618u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f8619v;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            if (COUIMenuPreference.this.f8603f != null && i3 < COUIMenuPreference.this.f8603f.length && i3 >= 0) {
                COUIMenuPreference cOUIMenuPreference = COUIMenuPreference.this;
                if (cOUIMenuPreference.callChangeListener(cOUIMenuPreference.f8603f[i3].toString())) {
                    COUIMenuPreference cOUIMenuPreference2 = COUIMenuPreference.this;
                    cOUIMenuPreference2.r(cOUIMenuPreference2.f8603f[i3].toString());
                }
            } else if (COUIMenuPreference.this.f8603f == null) {
                AbstractC0371a.c("COUIMenuPreference", "OnItemClick, mEntryValues is null");
            } else {
                AbstractC0371a.c("COUIMenuPreference", "OnItemClick, position is error:" + i3 + ",length:" + COUIMenuPreference.this.f8603f.length);
            }
            COUIMenuPreference.this.f8610m.c();
        }
    }

    class b implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f8621e;

        b(l lVar) {
            this.f8621e = lVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f8621e.itemView.removeOnAttachStateChangeListener(this);
            if (COUIMenuPreference.this.f8610m == null || !COUIMenuPreference.this.f8610m.d().isShowing()) {
                return;
            }
            COUIMenuPreference.this.f8610m.d().dismiss();
        }
    }

    public COUIMenuPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().a(this);
        }
        String m3 = m();
        CharSequence summary = super.getSummary();
        String str = this.f8607j;
        if (str == null) {
            return summary;
        }
        if (m3 == null) {
            m3 = "";
        }
        String format = String.format(str, m3);
        if (TextUtils.equals(format, summary)) {
            return summary;
        }
        Log.w("COUIMenuPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public int l(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f8603f) == null) {
            return 0;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (!TextUtils.isEmpty(this.f8603f[length]) && this.f8603f[length].equals(str)) {
                return length;
            }
        }
        return 0;
    }

    public String m() {
        return this.f8606i;
    }

    public void n(CharSequence[] charSequenceArr) {
        this.f8604g = charSequenceArr;
        this.f8608k = false;
        if (charSequenceArr == null || charSequenceArr.length <= 0) {
            return;
        }
        this.f8609l.clear();
        s.a aVar = new s.a();
        for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
            s.a I3 = aVar.y().I((String) charSequenceArr[i3]);
            int[] iArr = this.f8605h;
            I3.z(iArr != null ? iArr[i3] : -1);
            this.f8609l.add(aVar.x());
        }
    }

    public void o(CharSequence[] charSequenceArr) {
        this.f8603f = charSequenceArr;
        this.f8608k = false;
        if (this.f8604g != null || charSequenceArr == null || charSequenceArr.length <= 0) {
            return;
        }
        this.f8609l.clear();
        s.a aVar = new s.a();
        for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
            s.a I3 = aVar.y().I((String) charSequenceArr[i3]);
            int[] iArr = this.f8605h;
            I3.z(iArr != null ? iArr[i3] : -1);
            this.f8609l.add(aVar.x());
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        if (this.f8610m == null) {
            this.f8610m = new C0302c(getContext(), lVar.itemView);
        }
        q(this.f8619v);
        this.f8610m.d().t0(this.f8616s, this.f8617t);
        this.f8610m.d().setInputMethodMode(this.f8618u);
        ColorStateList colorStateList = this.f8613p;
        if (colorStateList != null) {
            this.f8610m.f(lVar.itemView, this.f8609l, colorStateList.getDefaultColor());
        } else {
            this.f8610m.e(lVar.itemView, this.f8609l);
        }
        this.f8610m.g(this.f8614q);
        this.f8610m.h(this.f8611n);
        A.c cVar = this.f8612o;
        if (cVar != null) {
            this.f8610m.k(cVar);
        }
        this.f8610m.j(this.f8602e);
        this.f8610m.i(this.f8615r);
        lVar.itemView.addOnAttachStateChangeListener(new b(lVar));
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return typedArray.getString(i3);
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(c.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        if (this.f8608k) {
            return;
        }
        r(cVar.f8623e);
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        c cVar = new c(onSaveInstanceState);
        cVar.f8623e = m();
        return cVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        r(getPersistedString((String) obj));
    }

    public void p(boolean z3) {
        this.f8611n = z3;
        C0302c c0302c = this.f8610m;
        if (c0302c != null) {
            c0302c.h(z3);
        }
    }

    public void q(boolean z3) {
        this.f8619v = z3;
        C0302c c0302c = this.f8610m;
        if (c0302c != null) {
            c0302c.d().e0(z3);
        }
    }

    public void r(String str) {
        if (TextUtils.equals(this.f8606i, str) && this.f8608k) {
            return;
        }
        this.f8606i = str;
        this.f8608k = true;
        if (this.f8609l.size() > 0 && !TextUtils.isEmpty(str)) {
            for (int i3 = 0; i3 < this.f8609l.size(); i3++) {
                s sVar = (s) this.f8609l.get(i3);
                String t3 = sVar.t();
                CharSequence[] charSequenceArr = this.f8604g;
                if (TextUtils.equals(t3, charSequenceArr != null ? charSequenceArr[l(str)] : str)) {
                    sVar.A(true);
                } else {
                    sVar.A(false);
                }
            }
        }
        persistString(str);
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        p(z3);
    }

    @Override // com.coui.appcompat.preference.COUIPreference
    public void setOnPreciseClickListener(A.c cVar) {
        this.f8612o = cVar;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.f8607j != null) {
            this.f8607j = null;
        } else {
            if (charSequence == null || charSequence.equals(this.f8607j)) {
                return;
            }
            this.f8607j = charSequence.toString();
        }
    }

    private static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f8623e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f8623e = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f8623e);
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public COUIMenuPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        this.f8602e = new a();
        this.f8609l = new ArrayList();
        this.f8611n = true;
        this.f8614q = true;
        this.f8615r = -1;
        this.f8616s = false;
        this.f8617t = y0.j.f14497a;
        this.f8619v = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2763Q, i3, 0);
        int i5 = W1.h.f2769T;
        this.f8603f = androidx.core.content.res.i.h(obtainStyledAttributes, i5, i5);
        int i6 = W1.h.f2767S;
        this.f8604g = androidx.core.content.res.i.h(obtainStyledAttributes, i6, i6);
        this.f8615r = obtainStyledAttributes.getInteger(W1.h.f2773V, -1);
        this.f8618u = obtainStyledAttributes.getInt(W1.h.f2775W, 0);
        int resourceId = obtainStyledAttributes.getResourceId(W1.h.f2771U, 0);
        if (resourceId != 0) {
            this.f8605h = context.getResources().getIntArray(resourceId);
        }
        this.f8606i = obtainStyledAttributes.getString(W1.h.f2765R);
        obtainStyledAttributes.recycle();
        o(this.f8603f);
        n(this.f8604g);
        r(this.f8606i);
    }

    public COUIMenuPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2599i);
    }
}
