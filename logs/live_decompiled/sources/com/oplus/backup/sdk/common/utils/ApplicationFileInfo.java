package com.oplus.backup.sdk.common.utils;

import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ApplicationFileInfo implements Parcelable {
    public static final Parcelable.Creator<ApplicationFileInfo> CREATOR = new Parcelable.Creator<ApplicationFileInfo>() { // from class: com.oplus.backup.sdk.common.utils.ApplicationFileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApplicationFileInfo createFromParcel(Parcel parcel) {
            return new ApplicationFileInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApplicationFileInfo[] newArray(int i3) {
            return new ApplicationFileInfo[i3];
        }
    };
    public static final String LABLE_NAME = "lable_name";
    public static final String PACKAGE_NAME = "package_name";
    public static final String TAG = "ApplicationFileInfo";
    public static final int VERSION_1 = 1;
    public String mApkFileDest;
    public String mApkFileSrc;
    public ApplicationInfo mApplicationInfo;
    public String mBackupPath;
    public String mDataFileSplit;
    public String mDataFileSrc;
    public String mDataReplace;
    public String[] mExFolder;
    public String[] mExTargetFolder;
    public String mObbFolder;
    public String mPackageName;
    public long mSize;
    public int mVersion;

    public ApplicationFileInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "version=" + this.mVersion + "mPackageName=" + BRLog.getModifiedPkg(this.mPackageName) + ", mApkFileSrc=" + BRLog.getModifiedPath(this.mApkFileSrc) + ", mApkFileDest=" + BRLog.getModifiedPath(this.mApkFileDest) + ", mDataFileSrc=" + BRLog.getModifiedPath(this.mDataFileSrc) + ", mDataFileSplit=" + BRLog.getModifiedPath(this.mDataFileSplit) + ", mDataReplace=" + BRLog.getModifiedPath(this.mDataReplace) + ", mExFolder=" + BRLog.getModifiedPath(Arrays.toString(this.mExFolder)) + ", mObbFolder=" + BRLog.getModifiedPath(this.mObbFolder) + ", mBackupPath=" + BRLog.getModifiedPath(this.mBackupPath);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(1);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mApkFileSrc);
        parcel.writeString(this.mApkFileDest);
        parcel.writeString(this.mDataFileSrc);
        parcel.writeString(this.mDataFileSplit);
        parcel.writeString(this.mDataReplace);
        parcel.writeString(this.mObbFolder);
        parcel.writeStringArray(this.mExFolder);
        parcel.writeStringArray(this.mExTargetFolder);
        parcel.writeLong(this.mSize);
        parcel.writeParcelable(this.mApplicationInfo, i3);
        parcel.writeString(this.mBackupPath);
    }

    public ApplicationFileInfo(Parcel parcel) {
        int readInt = parcel.readInt();
        this.mVersion = readInt;
        if (readInt != 1) {
            return;
        }
        this.mPackageName = parcel.readString();
        this.mApkFileSrc = parcel.readString();
        this.mApkFileDest = parcel.readString();
        this.mDataFileSrc = parcel.readString();
        this.mDataFileSplit = parcel.readString();
        this.mDataReplace = parcel.readString();
        this.mObbFolder = parcel.readString();
        this.mExFolder = parcel.createStringArray();
        this.mExTargetFolder = parcel.createStringArray();
        this.mSize = parcel.readLong();
        this.mApplicationInfo = (ApplicationInfo) parcel.readParcelable(ApplicationInfo.class.getClassLoader());
        this.mBackupPath = parcel.readString();
    }
}
