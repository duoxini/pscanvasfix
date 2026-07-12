package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.t;
import androidx.lifecycle.AbstractC0272h;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0264b implements Parcelable {
    public static final Parcelable.Creator<C0264b> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    final int[] f5357e;

    /* renamed from: f, reason: collision with root package name */
    final ArrayList f5358f;

    /* renamed from: g, reason: collision with root package name */
    final int[] f5359g;

    /* renamed from: h, reason: collision with root package name */
    final int[] f5360h;

    /* renamed from: i, reason: collision with root package name */
    final int f5361i;

    /* renamed from: j, reason: collision with root package name */
    final String f5362j;

    /* renamed from: k, reason: collision with root package name */
    final int f5363k;

    /* renamed from: l, reason: collision with root package name */
    final int f5364l;

    /* renamed from: m, reason: collision with root package name */
    final CharSequence f5365m;

    /* renamed from: n, reason: collision with root package name */
    final int f5366n;

    /* renamed from: o, reason: collision with root package name */
    final CharSequence f5367o;

    /* renamed from: p, reason: collision with root package name */
    final ArrayList f5368p;

    /* renamed from: q, reason: collision with root package name */
    final ArrayList f5369q;

    /* renamed from: r, reason: collision with root package name */
    final boolean f5370r;

    /* renamed from: androidx.fragment.app.b$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0264b createFromParcel(Parcel parcel) {
            return new C0264b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0264b[] newArray(int i3) {
            return new C0264b[i3];
        }
    }

    public C0264b(C0263a c0263a) {
        int size = c0263a.f5556c.size();
        this.f5357e = new int[size * 5];
        if (!c0263a.f5562i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f5358f = new ArrayList(size);
        this.f5359g = new int[size];
        this.f5360h = new int[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            t.a aVar = (t.a) c0263a.f5556c.get(i4);
            int i5 = i3 + 1;
            this.f5357e[i3] = aVar.f5573a;
            ArrayList arrayList = this.f5358f;
            Fragment fragment = aVar.f5574b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f5357e;
            iArr[i5] = aVar.f5575c;
            iArr[i3 + 2] = aVar.f5576d;
            int i6 = i3 + 4;
            iArr[i3 + 3] = aVar.f5577e;
            i3 += 5;
            iArr[i6] = aVar.f5578f;
            this.f5359g[i4] = aVar.f5579g.ordinal();
            this.f5360h[i4] = aVar.f5580h.ordinal();
        }
        this.f5361i = c0263a.f5561h;
        this.f5362j = c0263a.f5564k;
        this.f5363k = c0263a.f5356v;
        this.f5364l = c0263a.f5565l;
        this.f5365m = c0263a.f5566m;
        this.f5366n = c0263a.f5567n;
        this.f5367o = c0263a.f5568o;
        this.f5368p = c0263a.f5569p;
        this.f5369q = c0263a.f5570q;
        this.f5370r = c0263a.f5571r;
    }

    public C0263a c(l lVar) {
        C0263a c0263a = new C0263a(lVar);
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.f5357e.length) {
            t.a aVar = new t.a();
            int i5 = i3 + 1;
            aVar.f5573a = this.f5357e[i3];
            if (l.E0(2)) {
                Log.v("FragmentManager", "Instantiate " + c0263a + " op #" + i4 + " base fragment #" + this.f5357e[i5]);
            }
            String str = (String) this.f5358f.get(i4);
            if (str != null) {
                aVar.f5574b = lVar.f0(str);
            } else {
                aVar.f5574b = null;
            }
            aVar.f5579g = AbstractC0272h.c.values()[this.f5359g[i4]];
            aVar.f5580h = AbstractC0272h.c.values()[this.f5360h[i4]];
            int[] iArr = this.f5357e;
            int i6 = iArr[i5];
            aVar.f5575c = i6;
            int i7 = iArr[i3 + 2];
            aVar.f5576d = i7;
            int i8 = i3 + 4;
            int i9 = iArr[i3 + 3];
            aVar.f5577e = i9;
            i3 += 5;
            int i10 = iArr[i8];
            aVar.f5578f = i10;
            c0263a.f5557d = i6;
            c0263a.f5558e = i7;
            c0263a.f5559f = i9;
            c0263a.f5560g = i10;
            c0263a.f(aVar);
            i4++;
        }
        c0263a.f5561h = this.f5361i;
        c0263a.f5564k = this.f5362j;
        c0263a.f5356v = this.f5363k;
        c0263a.f5562i = true;
        c0263a.f5565l = this.f5364l;
        c0263a.f5566m = this.f5365m;
        c0263a.f5567n = this.f5366n;
        c0263a.f5568o = this.f5367o;
        c0263a.f5569p = this.f5368p;
        c0263a.f5570q = this.f5369q;
        c0263a.f5571r = this.f5370r;
        c0263a.v(1);
        return c0263a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f5357e);
        parcel.writeStringList(this.f5358f);
        parcel.writeIntArray(this.f5359g);
        parcel.writeIntArray(this.f5360h);
        parcel.writeInt(this.f5361i);
        parcel.writeString(this.f5362j);
        parcel.writeInt(this.f5363k);
        parcel.writeInt(this.f5364l);
        TextUtils.writeToParcel(this.f5365m, parcel, 0);
        parcel.writeInt(this.f5366n);
        TextUtils.writeToParcel(this.f5367o, parcel, 0);
        parcel.writeStringList(this.f5368p);
        parcel.writeStringList(this.f5369q);
        parcel.writeInt(this.f5370r ? 1 : 0);
    }

    public C0264b(Parcel parcel) {
        this.f5357e = parcel.createIntArray();
        this.f5358f = parcel.createStringArrayList();
        this.f5359g = parcel.createIntArray();
        this.f5360h = parcel.createIntArray();
        this.f5361i = parcel.readInt();
        this.f5362j = parcel.readString();
        this.f5363k = parcel.readInt();
        this.f5364l = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f5365m = (CharSequence) creator.createFromParcel(parcel);
        this.f5366n = parcel.readInt();
        this.f5367o = (CharSequence) creator.createFromParcel(parcel);
        this.f5368p = parcel.createStringArrayList();
        this.f5369q = parcel.createStringArrayList();
        this.f5370r = parcel.readInt() != 0;
    }
}
