package com.oplus.flexibletask.setting.bean;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class GameListInfo implements Parcelable {
    public static final Parcelable.Creator<GameListInfo> CREATOR = new Parcelable.Creator<GameListInfo>() { // from class: com.oplus.flexibletask.setting.bean.GameListInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameListInfo createFromParcel(Parcel parcel) {
            return new GameListInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameListInfo[] newArray(int i3) {
            return new GameListInfo[i3];
        }
    };
    private Drawable mAppIcon;
    private String mAppName;
    private String mPkgName;

    public GameListInfo(String str, String str2, Drawable drawable) {
        this.mAppName = str;
        this.mPkgName = str2;
        this.mAppIcon = drawable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Drawable getAppIcon() {
        return this.mAppIcon;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getPkgName() {
        return this.mPkgName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mPkgName);
    }

    public GameListInfo(Parcel parcel) {
        this.mAppName = parcel.readString();
        this.mPkgName = parcel.readString();
    }
}
