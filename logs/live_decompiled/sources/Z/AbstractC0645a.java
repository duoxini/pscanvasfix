package z;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: z.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0645a implements Parcelable {
    private final Parcelable mSuperState;
    public static final AbstractC0645a EMPTY_STATE = new C0161a();
    public static final Parcelable.Creator<AbstractC0645a> CREATOR = new b();

    /* renamed from: z.a$a, reason: collision with other inner class name */
    class C0161a extends AbstractC0645a {
        C0161a() {
            super((C0161a) null);
        }
    }

    /* renamed from: z.a$b */
    class b implements Parcelable.ClassLoaderCreator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0645a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbstractC0645a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbstractC0645a.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AbstractC0645a[] newArray(int i3) {
            return new AbstractC0645a[i3];
        }
    }

    /* synthetic */ AbstractC0645a(C0161a c0161a) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mSuperState, i3);
    }

    private AbstractC0645a() {
        this.mSuperState = null;
    }

    protected AbstractC0645a(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbstractC0645a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }
}
