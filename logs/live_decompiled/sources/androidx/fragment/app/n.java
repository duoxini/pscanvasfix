package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.l;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    ArrayList f5514e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList f5515f;

    /* renamed from: g, reason: collision with root package name */
    C0264b[] f5516g;

    /* renamed from: h, reason: collision with root package name */
    int f5517h;

    /* renamed from: i, reason: collision with root package name */
    String f5518i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList f5519j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList f5520k;

    /* renamed from: l, reason: collision with root package name */
    ArrayList f5521l;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i3) {
            return new n[i3];
        }
    }

    public n() {
        this.f5518i = null;
        this.f5519j = new ArrayList();
        this.f5520k = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f5514e);
        parcel.writeStringList(this.f5515f);
        parcel.writeTypedArray(this.f5516g, i3);
        parcel.writeInt(this.f5517h);
        parcel.writeString(this.f5518i);
        parcel.writeStringList(this.f5519j);
        parcel.writeTypedList(this.f5520k);
        parcel.writeTypedList(this.f5521l);
    }

    public n(Parcel parcel) {
        this.f5518i = null;
        this.f5519j = new ArrayList();
        this.f5520k = new ArrayList();
        this.f5514e = parcel.createTypedArrayList(q.CREATOR);
        this.f5515f = parcel.createStringArrayList();
        this.f5516g = (C0264b[]) parcel.createTypedArray(C0264b.CREATOR);
        this.f5517h = parcel.readInt();
        this.f5518i = parcel.readString();
        this.f5519j = parcel.createStringArrayList();
        this.f5520k = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f5521l = parcel.createTypedArrayList(l.C0082l.CREATOR);
    }
}
