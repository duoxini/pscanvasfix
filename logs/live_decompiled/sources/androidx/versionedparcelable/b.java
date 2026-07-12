package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import m.C0451a;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f6765d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f6766e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6767f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6768g;

    /* renamed from: h, reason: collision with root package name */
    private final String f6769h;

    /* renamed from: i, reason: collision with root package name */
    private int f6770i;

    /* renamed from: j, reason: collision with root package name */
    private int f6771j;

    /* renamed from: k, reason: collision with root package name */
    private int f6772k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0451a(), new C0451a(), new C0451a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f6766e.writeInt(-1);
        } else {
            this.f6766e.writeInt(bArr.length);
            this.f6766e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f6766e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i3) {
        this.f6766e.writeInt(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f6766e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f6766e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i3 = this.f6770i;
        if (i3 >= 0) {
            int i4 = this.f6765d.get(i3);
            int dataPosition = this.f6766e.dataPosition();
            this.f6766e.setDataPosition(i4);
            this.f6766e.writeInt(dataPosition - i4);
            this.f6766e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f6766e;
        int dataPosition = parcel.dataPosition();
        int i3 = this.f6771j;
        if (i3 == this.f6767f) {
            i3 = this.f6768g;
        }
        return new b(parcel, dataPosition, i3, this.f6769h + "  ", this.f6762a, this.f6763b, this.f6764c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f6766e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f6766e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f6766e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f6766e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i3) {
        while (this.f6771j < this.f6768g) {
            int i4 = this.f6772k;
            if (i4 == i3) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            this.f6766e.setDataPosition(this.f6771j);
            int readInt = this.f6766e.readInt();
            this.f6772k = this.f6766e.readInt();
            this.f6771j += readInt;
        }
        return this.f6772k == i3;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f6766e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.f6766e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f6766e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i3) {
        a();
        this.f6770i = i3;
        this.f6765d.put(i3, this.f6766e.dataPosition());
        E(0);
        E(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z3) {
        this.f6766e.writeInt(z3 ? 1 : 0);
    }

    private b(Parcel parcel, int i3, int i4, String str, C0451a c0451a, C0451a c0451a2, C0451a c0451a3) {
        super(c0451a, c0451a2, c0451a3);
        this.f6765d = new SparseIntArray();
        this.f6770i = -1;
        this.f6772k = -1;
        this.f6766e = parcel;
        this.f6767f = i3;
        this.f6768g = i4;
        this.f6771j = i3;
        this.f6769h = str;
    }
}
