package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0052a();

    /* renamed from: e, reason: collision with root package name */
    private final int f3413e;

    /* renamed from: f, reason: collision with root package name */
    private final Intent f3414f;

    /* renamed from: androidx.activity.result.a$a, reason: collision with other inner class name */
    class C0052a implements Parcelable.Creator {
        C0052a() {
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

    public a(int i3, Intent intent) {
        this.f3413e = i3;
        this.f3414f = intent;
    }

    public static String e(int i3) {
        return i3 != -1 ? i3 != 0 ? String.valueOf(i3) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent c() {
        return this.f3414f;
    }

    public int d() {
        return this.f3413e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + e(this.f3413e) + ", data=" + this.f3414f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f3413e);
        parcel.writeInt(this.f3414f == null ? 0 : 1);
        Intent intent = this.f3414f;
        if (intent != null) {
            intent.writeToParcel(parcel, i3);
        }
    }

    a(Parcel parcel) {
        this.f3413e = parcel.readInt();
        this.f3414f = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
