package com.oplus.backup.sdk.component.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.text.TextUtils;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.LockManager;
import java.io.File;
import java.io.FileDescriptor;

/* loaded from: classes.dex */
public abstract class AbstractPlugin implements IBRPlugin {
    private static final String DATA_PATH = "/data/data/";
    private static final String TAG = "AbstractPlugin";
    private BREngineConfig mBREngineConfig;
    private BRPluginHandler mBRPluginHandler;
    private String mCacheAppDataFolder;
    private Context mContext;
    private LockManager mLockManager;

    public int backupAppData(String str, String str2) {
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_BACKUP_APP_DATA);
        intent.putExtra(Constants.MessagerConstants.INTENT_BACKUP_SRC_FOLDER, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_BACKUP_DST_FOLDER, str2);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_BACKUP_APP_DATA, str, str2);
        getPluginHandler().sendMsg(intent, true);
        return ((Integer) this.mLockManager.waitResult(applyLock)).intValue();
    }

    protected BREngineConfig getBREngineConfig() {
        return this.mBREngineConfig;
    }

    protected final String getCacheAppDataFolder(String str) {
        return this.mCacheAppDataFolder + File.separator + str + DATA_PATH + str;
    }

    protected Context getContext() {
        return this.mContext;
    }

    public FileDescriptor getFileDescriptor(String str) {
        if (!TextUtils.isEmpty(str)) {
            return getFileDescriptor(str, 939524096);
        }
        BRLog.w(TAG, "getFileDescriptor, path is null");
        return null;
    }

    public BRPluginHandler getPluginHandler() {
        return this.mBRPluginHandler;
    }

    public int installPackage(String str, int i3, String str2) {
        BRLog.d(TAG, "installPackage, " + BRLog.getModifiedPath(str) + ", " + BRLog.getModifiedPkg(str2) + ", flag:" + i3);
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_INSTALL_APP);
        intent.putExtra(Constants.MessagerConstants.INTENT_INSTALL_APP_FILE_PATH, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_INSTALL_APP_FLAG, i3);
        intent.putExtra(Constants.MessagerConstants.INTENT_INSTALL_APP_PACKAGENAME, str2);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_INSTALL_APP, str, str2);
        getPluginHandler().sendMsg(intent, true);
        BRLog.d(TAG, "installPackage waitResult " + BRLog.getModifiedPkg(str2) + ", " + BRLog.getModifiedPath(str));
        return ((Integer) this.mLockManager.waitResult(applyLock)).intValue();
    }

    public Bundle invokeOtherPluginMethod(String str, String str2, Bundle bundle) {
        BRLog.d(TAG, "invokePluginMethod, " + str + ", " + str2);
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD);
        intent.putExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD, str2);
        intent.putExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD_PLUGIN_ID, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD_NAME, str2);
        intent.putExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD_ARGS, bundle);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD, str, str2);
        getPluginHandler().sendMsg(intent, true);
        BRLog.d(TAG, "invokePluginMethod waitResult " + str + ", " + str2);
        return (Bundle) this.mLockManager.waitResult(applyLock);
    }

    public void onCreate(Context context, BRPluginHandler bRPluginHandler, BREngineConfig bREngineConfig) {
        this.mContext = context;
        this.mBRPluginHandler = bRPluginHandler;
        this.mLockManager = LockManager.getInstance();
        this.mCacheAppDataFolder = bREngineConfig.getCacheAppDataFolder();
        this.mBREngineConfig = bREngineConfig;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onReveiveMsg(Intent intent, boolean z3) {
        if (intent == null) {
            BRLog.e(TAG, "onReceiveMsg intent == null");
            return;
        }
        String action = intent.getAction();
        LockManager.BooleanLock booleanLock = null;
        if (Constants.MessagerConstants.INTENT_GET_FD.equals(action)) {
            String stringExtra = intent.getStringExtra(Constants.MessagerConstants.INTENT_GET_FD_FILE_PATH);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) intent.getParcelableExtra(Constants.MessagerConstants.INTENT_FD_KEY);
            LockManager.BooleanLock lock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_GET_FD, stringExtra);
            BRLog.d(TAG, "onReceiveMsg INTENT_GET_FD, path:" + BRLog.getModifiedPath(stringExtra) + ", getLock: " + lock);
            if (lock == null) {
                BRLog.e(TAG, "getFileDescriptor failed: lock is null, it's a bug!");
            } else if (parcelFileDescriptor != null) {
                lock.setResult(parcelFileDescriptor.getFileDescriptor());
            } else {
                lock.setResult(null);
                BRLog.e(TAG, "getFileDescriptor failed:" + BRLog.getModifiedPath(stringExtra));
            }
            booleanLock = lock;
        } else if (Constants.MessagerConstants.INTENT_BACKUP_APP_DATA.equals(action)) {
            String stringExtra2 = intent.getStringExtra(Constants.MessagerConstants.INTENT_BACKUP_SRC_FOLDER);
            booleanLock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_BACKUP_APP_DATA, stringExtra2, intent.getStringExtra(Constants.MessagerConstants.INTENT_BACKUP_DST_FOLDER));
            BRLog.d(TAG, "onReceiveMsg INTENT_BACKUP_APP_DATA, srcFolder:" + BRLog.getModifiedPath(stringExtra2) + ", getLock: " + booleanLock);
            if (booleanLock != null) {
                int intExtra = intent.getIntExtra(Constants.MessagerConstants.INTENT_BACKUP_RESTORE_APP_DATA_RESULT, -1);
                BRLog.d(TAG, "onReceiveMsg INTENT_BACKUP_APP_DATA, result:" + intExtra);
                booleanLock.setResult(Integer.valueOf(intExtra));
            } else {
                BRLog.e(TAG, "backup app data failed: lock is null, it's a bug!");
            }
        } else if (Constants.MessagerConstants.INTENT_RESTORE_APP_DATA.equals(action)) {
            String stringExtra3 = intent.getStringExtra(Constants.MessagerConstants.INTENT_RESTORE_SRC_FOLDER);
            booleanLock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_RESTORE_APP_DATA, stringExtra3, intent.getStringExtra(Constants.MessagerConstants.INTENT_RESTORE_DST_FOLDER));
            BRLog.d(TAG, "onReceiveMsg INTENT_RESTORE_APP_DATA, srcFolder:" + BRLog.getModifiedPath(stringExtra3) + ", getLock: " + booleanLock);
            if (booleanLock != null) {
                int intExtra2 = intent.getIntExtra(Constants.MessagerConstants.INTENT_BACKUP_RESTORE_APP_DATA_RESULT, -1);
                BRLog.d(TAG, "onReceiveMsg INTENT_BACKUP_APP_DATA, result:" + intExtra2);
                booleanLock.setResult(Integer.valueOf(intExtra2));
            } else {
                BRLog.e(TAG, "restore app data failed: lock is null, it's a bug!");
            }
        } else if (Constants.MessagerConstants.INTENT_TAR.equals(action)) {
            String stringExtra4 = intent.getStringExtra(Constants.MessagerConstants.INTENT_TAR_FILE);
            booleanLock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_TAR, stringExtra4, intent.getStringExtra(Constants.MessagerConstants.INTENT_TAR_SOURCE_FOLDER));
            BRLog.d(TAG, "onReceiveMsg INTENT_TAR, tarFile:" + BRLog.getModifiedPath(stringExtra4) + ", getLock: " + booleanLock);
            if (booleanLock != null) {
                int intExtra3 = intent.getIntExtra(Constants.MessagerConstants.INTENT_TAR_RESULT, -1);
                BRLog.d(TAG, "onReceiveMsg INTENT_TAR, result:" + intExtra3);
                booleanLock.setResult(Integer.valueOf(intExtra3));
            } else {
                BRLog.e(TAG, "tar failed: lock is null, it's a bug!");
            }
        } else if (Constants.MessagerConstants.INTENT_RESTORE_TAR.equals(action)) {
            String stringExtra5 = intent.getStringExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_FILE);
            booleanLock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_TAR, stringExtra5, intent.getStringExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_PACKAGE), intent.getStringExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_APP_DATA_DST_FOLDER));
            BRLog.d(TAG, "onReceiveMsg INTENT_RESTORE_TAR, tarFile:" + BRLog.getModifiedPath(stringExtra5) + ", getLock: " + booleanLock);
            if (booleanLock != null) {
                int intExtra4 = intent.getIntExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_RESULT, -1);
                BRLog.d(TAG, "onReceiveMsg INTENT_RESTORE_TAR, result:" + intExtra4);
                booleanLock.setResult(Integer.valueOf(intExtra4));
            } else {
                BRLog.e(TAG, "restore tar failed: lock is null, it's a bug!");
            }
        } else if (Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD.equals(action)) {
            String stringExtra6 = intent.getStringExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD_PLUGIN_ID);
            String stringExtra7 = intent.getStringExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD_NAME);
            booleanLock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD, stringExtra6, stringExtra7);
            BRLog.d(TAG, "onReceiveMsg INTENT_INVOKE_PLUGIN_METHOD, methodName:" + stringExtra7);
            if (booleanLock != null) {
                Bundle bundleExtra = intent.getBundleExtra(Constants.MessagerConstants.INTENT_INVOKE_PLUGIN_METHOD_RESULT);
                BRLog.d(TAG, "onReceiveMsg INTENT_INVOKE_PLUGIN_METHOD, result:" + bundleExtra);
                booleanLock.setResult(bundleExtra);
            } else {
                BRLog.e(TAG, "invoke method failed: lock is null, it's a bug!");
            }
        } else if (Constants.MessagerConstants.INTENT_INSTALL_APP.equals(action)) {
            String stringExtra8 = intent.getStringExtra(Constants.MessagerConstants.INTENT_INSTALL_APP_PACKAGENAME);
            String stringExtra9 = intent.getStringExtra(Constants.MessagerConstants.INTENT_INSTALL_APP_FILE_PATH);
            booleanLock = this.mLockManager.getLock(Constants.MessagerConstants.INTENT_INSTALL_APP, stringExtra9, stringExtra8);
            BRLog.d(TAG, "onReceiveMsg INTENT_INSTALL_APP, apkFilePath:" + BRLog.getModifiedPath(stringExtra9) + ", packageName:" + BRLog.getModifiedPkg(stringExtra8));
            if (booleanLock != null) {
                Integer valueOf = Integer.valueOf(intent.getIntExtra(Constants.MessagerConstants.INTENT_INSTALL_APP_RESULT, 1));
                BRLog.d(TAG, "onReceiveMsg INTENT_INSTALL_APP, result:" + valueOf);
                booleanLock.setResult(valueOf);
            } else {
                BRLog.e(TAG, "install app: lock is null, it's a bug!");
            }
        } else {
            BRLog.d(TAG, "onReceiveMsg" + intent + ", " + z3);
        }
        this.mLockManager.notifyLock(booleanLock);
    }

    public int restoreAppData(String str, String str2) {
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_RESTORE_APP_DATA);
        intent.putExtra(Constants.MessagerConstants.INTENT_RESTORE_SRC_FOLDER, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_RESTORE_DST_FOLDER, str2);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_RESTORE_APP_DATA, str, str2);
        getPluginHandler().sendMsg(intent, true);
        return ((Integer) this.mLockManager.waitResult(applyLock)).intValue();
    }

    public int restoreTar(String str, String str2, String str3) {
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_RESTORE_TAR);
        intent.putExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_FILE, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_PACKAGE, str2);
        intent.putExtra(Constants.MessagerConstants.INTENT_RESTORE_TAR_APP_DATA_DST_FOLDER, str3);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_TAR, str, str2, str3);
        getPluginHandler().sendMsg(intent, true);
        return ((Integer) this.mLockManager.waitResult(applyLock)).intValue();
    }

    public int tar(String str, String str2, String str3) {
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_TAR);
        intent.putExtra(Constants.MessagerConstants.INTENT_TAR_FILE, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_TAR_SOURCE_FOLDER, str2);
        intent.putExtra(Constants.MessagerConstants.INTENT_TAR_EXCLUDE_ARGS, str3);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_TAR, str, str2);
        getPluginHandler().sendMsg(intent, true);
        return ((Integer) this.mLockManager.waitResult(applyLock)).intValue();
    }

    public FileDescriptor getFileDescriptor(String str, int i3) {
        Intent intent = new Intent(Constants.MessagerConstants.INTENT_GET_FD);
        intent.putExtra(Constants.MessagerConstants.INTENT_GET_FD_FILE_PATH, str);
        intent.putExtra(Constants.MessagerConstants.INTENT_GET_FD_FILE_FLAG, i3);
        LockManager.BooleanLock applyLock = this.mLockManager.applyLock(Constants.MessagerConstants.INTENT_GET_FD, str);
        getPluginHandler().sendMsg(intent, true);
        FileDescriptor fileDescriptor = (FileDescriptor) this.mLockManager.waitResult(applyLock);
        try {
            return Os.dup(fileDescriptor);
        } catch (Exception e3) {
            BRLog.e(TAG, "getFileDescriptor, e =" + e3.getMessage());
            return fileDescriptor;
        } catch (NoClassDefFoundError unused) {
            BRLog.e(TAG, "getFileDescriptor, can't find the Class");
            return fileDescriptor;
        }
    }
}
