package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.material.timepicker.a f10018e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.timepicker.a f10019f;

    /* renamed from: g, reason: collision with root package name */
    final int f10020g;

    /* renamed from: h, reason: collision with root package name */
    int f10021h;

    /* renamed from: i, reason: collision with root package name */
    int f10022i;

    /* renamed from: j, reason: collision with root package name */
    int f10023j;

    /* renamed from: k, reason: collision with root package name */
    int f10024k;

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

    public c(int i3, int i4, int i5, int i6) {
        this.f10021h = i3;
        this.f10022i = i4;
        this.f10023j = i5;
        this.f10020g = i6;
        this.f10024k = e(i3);
        this.f10018e = new com.google.android.material.timepicker.a(59);
        this.f10019f = new com.google.android.material.timepicker.a(i6 == 1 ? 24 : 12);
    }

    public static String c(Resources resources, CharSequence charSequence) {
        return d(resources, charSequence, "%02d");
    }

    public static String d(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int e(int i3) {
        return i3 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f10021h == cVar.f10021h && this.f10022i == cVar.f10022i && this.f10020g == cVar.f10020g && this.f10023j == cVar.f10023j;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10020g), Integer.valueOf(this.f10021h), Integer.valueOf(this.f10022i), Integer.valueOf(this.f10023j)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f10021h);
        parcel.writeInt(this.f10022i);
        parcel.writeInt(this.f10023j);
        parcel.writeInt(this.f10020g);
    }

    protected c(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
