package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final String f5530e;

    /* renamed from: f, reason: collision with root package name */
    final String f5531f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f5532g;

    /* renamed from: h, reason: collision with root package name */
    final int f5533h;

    /* renamed from: i, reason: collision with root package name */
    final int f5534i;

    /* renamed from: j, reason: collision with root package name */
    final String f5535j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f5536k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f5537l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f5538m;

    /* renamed from: n, reason: collision with root package name */
    final Bundle f5539n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f5540o;

    /* renamed from: p, reason: collision with root package name */
    final int f5541p;

    /* renamed from: q, reason: collision with root package name */
    Bundle f5542q;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i3) {
            return new q[i3];
        }
    }

    q(Fragment fragment) {
        this.f5530e = fragment.getClass().getName();
        this.f5531f = fragment.mWho;
        this.f5532g = fragment.mFromLayout;
        this.f5533h = fragment.mFragmentId;
        this.f5534i = fragment.mContainerId;
        this.f5535j = fragment.mTag;
        this.f5536k = fragment.mRetainInstance;
        this.f5537l = fragment.mRemoving;
        this.f5538m = fragment.mDetached;
        this.f5539n = fragment.mArguments;
        this.f5540o = fragment.mHidden;
        this.f5541p = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f5530e);
        sb.append(" (");
        sb.append(this.f5531f);
        sb.append(")}:");
        if (this.f5532g) {
            sb.append(" fromLayout");
        }
        if (this.f5534i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f5534i));
        }
        String str = this.f5535j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f5535j);
        }
        if (this.f5536k) {
            sb.append(" retainInstance");
        }
        if (this.f5537l) {
            sb.append(" removing");
        }
        if (this.f5538m) {
            sb.append(" detached");
        }
        if (this.f5540o) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f5530e);
        parcel.writeString(this.f5531f);
        parcel.writeInt(this.f5532g ? 1 : 0);
        parcel.writeInt(this.f5533h);
        parcel.writeInt(this.f5534i);
        parcel.writeString(this.f5535j);
        parcel.writeInt(this.f5536k ? 1 : 0);
        parcel.writeInt(this.f5537l ? 1 : 0);
        parcel.writeInt(this.f5538m ? 1 : 0);
        parcel.writeBundle(this.f5539n);
        parcel.writeInt(this.f5540o ? 1 : 0);
        parcel.writeBundle(this.f5542q);
        parcel.writeInt(this.f5541p);
    }

    q(Parcel parcel) {
        this.f5530e = parcel.readString();
        this.f5531f = parcel.readString();
        this.f5532g = parcel.readInt() != 0;
        this.f5533h = parcel.readInt();
        this.f5534i = parcel.readInt();
        this.f5535j = parcel.readString();
        this.f5536k = parcel.readInt() != 0;
        this.f5537l = parcel.readInt() != 0;
        this.f5538m = parcel.readInt() != 0;
        this.f5539n = parcel.readBundle();
        this.f5540o = parcel.readInt() != 0;
        this.f5542q = parcel.readBundle();
        this.f5541p = parcel.readInt();
    }
}
