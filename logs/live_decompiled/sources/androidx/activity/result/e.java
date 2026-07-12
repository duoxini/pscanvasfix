package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private final IntentSender f3415e;

    /* renamed from: f, reason: collision with root package name */
    private final Intent f3416f;

    /* renamed from: g, reason: collision with root package name */
    private final int f3417g;

    /* renamed from: h, reason: collision with root package name */
    private final int f3418h;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private IntentSender f3419a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f3420b;

        /* renamed from: c, reason: collision with root package name */
        private int f3421c;

        /* renamed from: d, reason: collision with root package name */
        private int f3422d;

        public b(IntentSender intentSender) {
            this.f3419a = intentSender;
        }

        public e a() {
            return new e(this.f3419a, this.f3420b, this.f3421c, this.f3422d);
        }

        public b b(Intent intent) {
            this.f3420b = intent;
            return this;
        }

        public b c(int i3, int i4) {
            this.f3422d = i3;
            this.f3421c = i4;
            return this;
        }
    }

    e(IntentSender intentSender, Intent intent, int i3, int i4) {
        this.f3415e = intentSender;
        this.f3416f = intent;
        this.f3417g = i3;
        this.f3418h = i4;
    }

    public Intent c() {
        return this.f3416f;
    }

    public int d() {
        return this.f3417g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f3418h;
    }

    public IntentSender f() {
        return this.f3415e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f3415e, i3);
        parcel.writeParcelable(this.f3416f, i3);
        parcel.writeInt(this.f3417g);
        parcel.writeInt(this.f3418h);
    }

    e(Parcel parcel) {
        this.f3415e = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f3416f = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f3417g = parcel.readInt();
        this.f3418h = parcel.readInt();
    }
}
