package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
final class k implements Comparable, Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private final Calendar f9709e;

    /* renamed from: f, reason: collision with root package name */
    final int f9710f;

    /* renamed from: g, reason: collision with root package name */
    final int f9711g;

    /* renamed from: h, reason: collision with root package name */
    final int f9712h;

    /* renamed from: i, reason: collision with root package name */
    final int f9713i;

    /* renamed from: j, reason: collision with root package name */
    final long f9714j;

    /* renamed from: k, reason: collision with root package name */
    private String f9715k;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return k.d(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i3) {
            return new k[i3];
        }
    }

    private k(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d3 = r.d(calendar);
        this.f9709e = d3;
        this.f9710f = d3.get(2);
        this.f9711g = d3.get(1);
        this.f9712h = d3.getMaximum(7);
        this.f9713i = d3.getActualMaximum(5);
        this.f9714j = d3.getTimeInMillis();
    }

    static k d(int i3, int i4) {
        Calendar i5 = r.i();
        i5.set(1, i3);
        i5.set(2, i4);
        return new k(i5);
    }

    static k e(long j3) {
        Calendar i3 = r.i();
        i3.setTimeInMillis(j3);
        return new k(i3);
    }

    static k f() {
        return new k(r.g());
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return this.f9709e.compareTo(kVar.f9709e);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f9710f == kVar.f9710f && this.f9711g == kVar.f9711g;
    }

    int g() {
        int firstDayOfWeek = this.f9709e.get(7) - this.f9709e.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f9712h : firstDayOfWeek;
    }

    long h(int i3) {
        Calendar d3 = r.d(this.f9709e);
        d3.set(5, i3);
        return d3.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9710f), Integer.valueOf(this.f9711g)});
    }

    int i(long j3) {
        Calendar d3 = r.d(this.f9709e);
        d3.setTimeInMillis(j3);
        return d3.get(5);
    }

    String j() {
        if (this.f9715k == null) {
            this.f9715k = e.c(this.f9709e.getTimeInMillis());
        }
        return this.f9715k;
    }

    long k() {
        return this.f9709e.getTimeInMillis();
    }

    k l(int i3) {
        Calendar d3 = r.d(this.f9709e);
        d3.add(2, i3);
        return new k(d3);
    }

    int m(k kVar) {
        if (this.f9709e instanceof GregorianCalendar) {
            return ((kVar.f9711g - this.f9711g) * 12) + (kVar.f9710f - this.f9710f);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f9711g);
        parcel.writeInt(this.f9710f);
    }
}
