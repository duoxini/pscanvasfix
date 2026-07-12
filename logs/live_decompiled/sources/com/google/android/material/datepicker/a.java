package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0121a();

    /* renamed from: e, reason: collision with root package name */
    private final k f9611e;

    /* renamed from: f, reason: collision with root package name */
    private final k f9612f;

    /* renamed from: g, reason: collision with root package name */
    private final c f9613g;

    /* renamed from: h, reason: collision with root package name */
    private k f9614h;

    /* renamed from: i, reason: collision with root package name */
    private final int f9615i;

    /* renamed from: j, reason: collision with root package name */
    private final int f9616j;

    /* renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    class C0121a implements Parcelable.Creator {
        C0121a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((k) parcel.readParcelable(k.class.getClassLoader()), (k) parcel.readParcelable(k.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (k) parcel.readParcelable(k.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        static final long f9617e = r.a(k.d(1900, 0).f9714j);

        /* renamed from: f, reason: collision with root package name */
        static final long f9618f = r.a(k.d(2100, 11).f9714j);

        /* renamed from: a, reason: collision with root package name */
        private long f9619a;

        /* renamed from: b, reason: collision with root package name */
        private long f9620b;

        /* renamed from: c, reason: collision with root package name */
        private Long f9621c;

        /* renamed from: d, reason: collision with root package name */
        private c f9622d;

        b(a aVar) {
            this.f9619a = f9617e;
            this.f9620b = f9618f;
            this.f9622d = f.c(Long.MIN_VALUE);
            this.f9619a = aVar.f9611e.f9714j;
            this.f9620b = aVar.f9612f.f9714j;
            this.f9621c = Long.valueOf(aVar.f9614h.f9714j);
            this.f9622d = aVar.f9613g;
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f9622d);
            k e3 = k.e(this.f9619a);
            k e4 = k.e(this.f9620b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.f9621c;
            return new a(e3, e4, cVar, l3 == null ? null : k.e(l3.longValue()), null);
        }

        public b b(long j3) {
            this.f9621c = Long.valueOf(j3);
            return this;
        }
    }

    public interface c extends Parcelable {
        boolean a(long j3);
    }

    /* synthetic */ a(k kVar, k kVar2, c cVar, k kVar3, C0121a c0121a) {
        this(kVar, kVar2, cVar, kVar3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9611e.equals(aVar.f9611e) && this.f9612f.equals(aVar.f9612f) && androidx.core.util.c.a(this.f9614h, aVar.f9614h) && this.f9613g.equals(aVar.f9613g);
    }

    public c g() {
        return this.f9613g;
    }

    k h() {
        return this.f9612f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9611e, this.f9612f, this.f9614h, this.f9613g});
    }

    int i() {
        return this.f9616j;
    }

    k j() {
        return this.f9614h;
    }

    k k() {
        return this.f9611e;
    }

    int l() {
        return this.f9615i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f9611e, 0);
        parcel.writeParcelable(this.f9612f, 0);
        parcel.writeParcelable(this.f9614h, 0);
        parcel.writeParcelable(this.f9613g, 0);
    }

    private a(k kVar, k kVar2, c cVar, k kVar3) {
        this.f9611e = kVar;
        this.f9612f = kVar2;
        this.f9614h = kVar3;
        this.f9613g = cVar;
        if (kVar3 != null && kVar.compareTo(kVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (kVar3 != null && kVar3.compareTo(kVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f9616j = kVar.m(kVar2) + 1;
        this.f9615i = (kVar2.f9711g - kVar.f9711g) + 1;
    }
}
