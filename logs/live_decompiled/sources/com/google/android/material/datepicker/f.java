package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f implements a.c {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private final long f9637e;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    /* synthetic */ f(long j3, a aVar) {
        this(j3);
    }

    public static f c(long j3) {
        return new f(j3);
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean a(long j3) {
        return j3 >= this.f9637e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f9637e == ((f) obj).f9637e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f9637e)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f9637e);
    }

    private f(long j3) {
        this.f9637e = j3;
    }
}
