package com.oplus.backup.sdk.common.plugin;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BRPluginConfig implements Parcelable {
    public static final String BACKUP_FOLDER = "backupFolder";
    public static final Parcelable.Creator<BRPluginConfig> CREATOR = new Parcelable.Creator<BRPluginConfig>() { // from class: com.oplus.backup.sdk.common.plugin.BRPluginConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BRPluginConfig createFromParcel(Parcel parcel) {
            BRPluginConfig bRPluginConfig = new BRPluginConfig();
            bRPluginConfig.mKey = parcel.readString();
            bRPluginConfig.mBundle = parcel.readBundle();
            return bRPluginConfig;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BRPluginConfig[] newArray(int i3) {
            return new BRPluginConfig[i3];
        }
    };
    public static final String DATA_PATTERN = "dataPattern";
    public static final int DATA_PATTERN_NORMAL = 0;
    public static final int DATA_PATTERN_NO_FILE = 2;
    public static final int DATA_PATTERN_SUPPORT_ONE_BY_ONE = 1;
    public static final String OPT_DIR = "loadTmpFolder";
    public static final String PLUGIN_CLASS = "pluginClass";
    public static final String PREFER_LOCAL_CLASS = "preferLocalClass";
    public static final String TARGET_PACKAGE = "targetPackage";
    public static final String UNIQUE_ID = "uniqueID";
    public static final String USE_PARENT_CLASS = "useParentClass";
    public static final String VERSION = "version";
    private Bundle mBundle;
    private String mKey;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BRPluginConfig) {
            return getKey().equals(((BRPluginConfig) obj).getKey());
        }
        return false;
    }

    public String getBackupFolder() {
        return this.mBundle.getString(BACKUP_FOLDER);
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public int getDataPattern() {
        return this.mBundle.getInt(DATA_PATTERN, 0);
    }

    public Intent getIntent() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.oplus.backup.sdk", "com.oplus.backup.sdk.demo.ClockBRPluginService"));
        return intent;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getOptimizedDirectory() {
        return this.mBundle.getString(OPT_DIR);
    }

    public String[] getPluginClass() {
        return this.mBundle.getStringArray(PLUGIN_CLASS);
    }

    public String[] getTargetPackage() {
        return this.mBundle.getStringArray(TARGET_PACKAGE);
    }

    public String getUniqueID() {
        return this.mBundle.getString(UNIQUE_ID);
    }

    public int getVersion() {
        return (int) this.mBundle.getDouble(VERSION);
    }

    public int hashCode() {
        return getKey().hashCode();
    }

    public boolean isPreferLocalClass() {
        return this.mBundle.getBoolean(PREFER_LOCAL_CLASS, false);
    }

    public void putValue(String str, String str2) {
        this.mBundle.putString(str, str2);
        if (UNIQUE_ID.equals(str) || VERSION.equals(str)) {
            this.mKey = new String(getUniqueID() + "_" + getVersion());
        }
    }

    public String toString() {
        return "BRPluginConfig:" + this.mKey;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mKey);
        parcel.writeBundle(this.mBundle);
    }

    private BRPluginConfig() {
    }

    public BRPluginConfig(Bundle bundle) {
        this.mBundle = bundle;
        this.mKey = new String(getUniqueID() + "_" + getVersion());
    }

    public void putValue(String str, String[] strArr) {
        this.mBundle.putStringArray(str, strArr);
    }
}
