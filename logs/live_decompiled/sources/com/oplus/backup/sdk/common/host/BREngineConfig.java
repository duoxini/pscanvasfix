package com.oplus.backup.sdk.common.host;

import android.os.Bundle;
import com.oplus.backup.sdk.common.utils.BRLog;

/* loaded from: classes.dex */
public class BREngineConfig {
    private static final String BACKUP_ROOT_PATH = "backup_root_path";
    public static final int BACKUP_TYPE = 0;
    private static final String BR_TYPE = "br_type";
    public static final String CACHE_APP_DATA_FOLDER = "cache_app_data_folder";
    private static final String LOG_LEVEL = "log_level";
    private static final String PAIRED_PHONE_ANDROID_VERSION = "paired_phone_android_version";
    private static final String PAIRED_PHONE_OS_VERSION = "paired_phone_os_version";
    private static final String RESTORE_ROOT_PATH = "restore_root_path";
    public static final int RESTORE_TYPE = 1;
    private static final String SOURCE = "source";
    public static final String SUPPORT_DIR_MIGRATION = "support_dir_migration";
    private Bundle mBundle;

    public BREngineConfig() {
        this.mBundle = new Bundle();
    }

    public static BREngineConfig parse(Bundle bundle) {
        return new BREngineConfig(bundle);
    }

    public int getBRType() {
        return this.mBundle.getInt("br_type");
    }

    public String getBackupRootPath() {
        return this.mBundle.getString(BACKUP_ROOT_PATH);
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public String getCacheAppDataFolder() {
        return this.mBundle.getString(CACHE_APP_DATA_FOLDER);
    }

    public int getLogLevel() {
        return this.mBundle.getInt(LOG_LEVEL, 5);
    }

    public String getOldPhoneAndroidVersion() {
        return this.mBundle.getString(PAIRED_PHONE_ANDROID_VERSION);
    }

    public int getOldPhoneOSVersion() {
        return this.mBundle.getInt(PAIRED_PHONE_OS_VERSION);
    }

    public String getRestoreRootPath() {
        return this.mBundle.getString(RESTORE_ROOT_PATH);
    }

    public String getSource() {
        return this.mBundle.getString(SOURCE);
    }

    public boolean getSupportMigration() {
        return this.mBundle.getBoolean(SUPPORT_DIR_MIGRATION, false);
    }

    public void putValue(String str, String str2) {
        this.mBundle.putString(str, str2);
    }

    public void setBRType(int i3) {
        this.mBundle.putInt("br_type", i3);
    }

    public void setBackupRootPath(String str) {
        this.mBundle.putString(BACKUP_ROOT_PATH, str);
    }

    public void setLogLevel(int i3) {
        this.mBundle.putInt(LOG_LEVEL, i3);
    }

    public void setRestoreRootPath(String str) {
        this.mBundle.putString(RESTORE_ROOT_PATH, str);
    }

    public void setSource(String str) {
        this.mBundle.putString(SOURCE, str);
    }

    public void setSupportMigration(boolean z3) {
        this.mBundle.putBoolean(SUPPORT_DIR_MIGRATION, z3);
    }

    public String toString() {
        return "BREngineConfig:[" + getBRType() + ", " + BRLog.getModifiedPath(getBackupRootPath()) + ", " + BRLog.getModifiedPath(getRestoreRootPath()) + ", " + getSource() + ", " + getLogLevel() + ",OSVersion " + getOldPhoneOSVersion() + ", androidVersion " + getOldPhoneAndroidVersion() + "]";
    }

    public void putValue(String str, String[] strArr) {
        this.mBundle.putStringArray(str, strArr);
    }

    public BREngineConfig(Bundle bundle) {
        this.mBundle = bundle;
    }
}
