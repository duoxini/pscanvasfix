package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() { // from class: com.google.android.material.internal.ParcelableSparseIntArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i3 = 0; i3 < readInt; i3++) {
                parcelableSparseIntArray.put(iArr[i3], iArr2[i3]);
            }
            return parcelableSparseIntArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseIntArray[] newArray(int i3) {
            return new ParcelableSparseIntArray[i3];
        }
    };

    public ParcelableSparseIntArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i4 = 0; i4 < size(); i4++) {
            iArr[i4] = keyAt(i4);
            iArr2[i4] = valueAt(i4);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }

    public ParcelableSparseIntArray(int i3) {
        super(i3);
    }

    public ParcelableSparseIntArray(SparseIntArray sparseIntArray) {
        for (int i3 = 0; i3 < sparseIntArray.size(); i3++) {
            put(sparseIntArray.keyAt(i3), sparseIntArray.valueAt(i3));
        }
    }
}
