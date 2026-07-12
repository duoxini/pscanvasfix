package com.oplus.flexibletask.setting.utils;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.RestorePlugin;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import java.io.File;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SettingRestorePlugin extends RestorePlugin {
    private static final String RESTORE_FILE = "zoomsetting.xml";
    private static final String TAG = "SettingRestorePlugin";
    private BRPluginHandler mBRPluginHandler;
    private int mCompleteCount;
    private Context mContext;
    private boolean mIsCancel;
    private boolean mIsPause;
    private int mMaxCount;
    private BREngineConfig mRestoreConfig;
    private static final String PARENT_FOLDER = "Setting";
    public static final String FOLDER_INFO = "exserviceui";
    private static final String RESTORE_FOLDER = PARENT_FOLDER + File.separator + FOLDER_INFO;
    private Object mPauseLock = new Object();
    private HashMap<String, Integer> mMap = new HashMap<>();

    private String getBackupFilePath(Bundle bundle) {
        return this.mRestoreConfig.getRestoreRootPath() + File.separator + RESTORE_FOLDER;
    }

    private int getMaxCount() {
        return 1;
    }

    private void overWritePreference(String str, int i3) {
        Context context = this.mContext;
        if (context == null) {
            AbstractC0652e.j(TAG, "changeGameBehavior fail for context is null");
            return;
        }
        Settings.System.putInt(context.getContentResolver(), str, i3);
        AbstractC0652e.b(TAG, "Change game behavior to " + i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap<java.lang.String, java.lang.Integer> readFile(java.io.FileDescriptor r3) {
        /*
            java.lang.String r0 = "SettingRestorePlugin"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.util.HashMap r1 = readSystemAlertCfg(r2)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            r2.close()     // Catch: java.io.IOException -> L10
            goto L2e
        L10:
            r3 = move-exception
            java.lang.String r3 = r3.toString()
            z1.AbstractC0652e.d(r0, r3)
            goto L2e
        L19:
            r3 = move-exception
            r1 = r2
            goto L2f
        L1c:
            r3 = move-exception
            goto L22
        L1e:
            r3 = move-exception
            goto L2f
        L20:
            r3 = move-exception
            r2 = r1
        L22:
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L19
            z1.AbstractC0652e.d(r0, r3)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.io.IOException -> L10
        L2e:
            return r1
        L2f:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.io.IOException -> L35
            goto L3d
        L35:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
            z1.AbstractC0652e.d(r0, r1)
        L3d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.flexibletask.setting.utils.SettingRestorePlugin.readFile(java.io.FileDescriptor):java.util.HashMap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0076, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        z1.AbstractC0652e.d(com.oplus.flexibletask.setting.utils.SettingRestorePlugin.TAG, r2.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.HashMap<java.lang.String, java.lang.Integer> readSystemAlertCfg(java.io.FileInputStream r10) {
        /*
            java.lang.String r0 = "SettingRestorePlugin"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = 0
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3.setInput(r10, r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
        Lf:
            int r4 = r3.next()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            r5 = 2
            if (r4 != r5) goto L6d
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            java.lang.String r6 = "switch"
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            if (r5 == 0) goto L6d
            java.lang.String r5 = "name"
            java.lang.String r5 = r3.getAttributeValue(r2, r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L54
            java.lang.String r6 = r3.nextText()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L51
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            r7.<init>()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            java.lang.String r8 = "readSystemAlertCfg() name "
            r7.append(r8)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            r7.append(r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            java.lang.String r8 = " text "
            r7.append(r8)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            r7.append(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            z1.AbstractC0652e.j(r0, r7)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d java.io.IOException -> L4f
            goto L5e
        L49:
            r1 = move-exception
            r2 = r3
            goto Lb3
        L4d:
            r2 = move-exception
            goto L93
        L4f:
            r7 = move-exception
            goto L57
        L51:
            r7 = move-exception
            r6 = r2
            goto L57
        L54:
            r7 = move-exception
            r5 = r2
            r6 = r5
        L57:
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            z1.AbstractC0652e.j(r0, r7)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
        L5e:
            if (r5 == 0) goto L6d
            if (r6 == 0) goto L6d
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            r1.put(r5, r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
        L6d:
            r5 = 1
            if (r4 != r5) goto Lf
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch: java.lang.Exception -> L76
            r3.close()     // Catch: java.lang.Exception -> L76
            goto L7e
        L76:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            z1.AbstractC0652e.d(r0, r2)
        L7e:
            if (r10 == 0) goto Lb2
            r10.close()     // Catch: java.io.IOException -> L84
            goto Lb2
        L84:
            r10 = move-exception
            java.lang.String r10 = r10.toString()
            z1.AbstractC0652e.d(r0, r10)
            goto Lb2
        L8d:
            r1 = move-exception
            goto Lb3
        L8f:
            r3 = move-exception
            r9 = r3
            r3 = r2
            r2 = r9
        L93:
            java.lang.String r4 = "readFloatWindowCfg() error"
            z1.AbstractC0652e.d(r0, r4)     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L49
            z1.AbstractC0652e.d(r0, r2)     // Catch: java.lang.Throwable -> L49
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch: java.lang.Exception -> La5
            r3.close()     // Catch: java.lang.Exception -> La5
            goto Lad
        La5:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            z1.AbstractC0652e.d(r0, r2)
        Lad:
            if (r10 == 0) goto Lb2
            r10.close()     // Catch: java.io.IOException -> L84
        Lb2:
            return r1
        Lb3:
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch: java.lang.Exception -> Lb9
            r2.close()     // Catch: java.lang.Exception -> Lb9
            goto Lc1
        Lb9:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            z1.AbstractC0652e.d(r0, r2)
        Lc1:
            if (r10 == 0) goto Lcf
            r10.close()     // Catch: java.io.IOException -> Lc7
            goto Lcf
        Lc7:
            r10 = move-exception
            java.lang.String r10 = r10.toString()
            z1.AbstractC0652e.d(r0, r10)
        Lcf:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.flexibletask.setting.utils.SettingRestorePlugin.readSystemAlertCfg(java.io.FileInputStream):java.util.HashMap");
    }

    private void restoreConfig() {
        for (Map.Entry<String, Integer> entry : this.mMap.entrySet()) {
            overWritePreference(entry.getKey(), entry.getValue().intValue());
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onCancel(Bundle bundle) {
        this.mIsCancel = true;
        this.mIsPause = false;
        synchronized (this.mPauseLock) {
            this.mPauseLock.notifyAll();
            AbstractC0652e.b(TAG, "onCancel mLock.notifyAll()");
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onContinue(Bundle bundle) {
        this.mIsPause = false;
        synchronized (this.mPauseLock) {
            this.mPauseLock.notifyAll();
            AbstractC0652e.b(TAG, "onContinue mPauseLock.notifyAll()");
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.AbstractPlugin
    public void onCreate(Context context, BRPluginHandler bRPluginHandler, BREngineConfig bREngineConfig) {
        super.onCreate(context, bRPluginHandler, bREngineConfig);
        this.mContext = context;
        this.mMaxCount = getMaxCount();
        this.mBRPluginHandler = bRPluginHandler;
        this.mRestoreConfig = bREngineConfig;
        AbstractC0652e.b(TAG, "onCreate:" + bREngineConfig);
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onDestroy(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        ProgressHelper.putBRResult(bundle2, this.mIsCancel ? 3 : 1);
        ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
        ProgressHelper.putCompletedCount(bundle2, this.mCompleteCount);
        AbstractC0652e.b(TAG, "onDestroy:" + bundle2);
        return bundle2;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onPause(Bundle bundle) {
        this.mIsPause = true;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPrepare(Bundle bundle) {
        String str = getBackupFilePath(bundle) + File.separator + RESTORE_FILE;
        FileDescriptor fileDescriptor = getFileDescriptor(str);
        if (fileDescriptor != null) {
            this.mMap = readFile(fileDescriptor);
            AbstractC0652e.b(TAG, "onPrepare: " + str);
            AbstractC0652e.b(TAG, "onPrepare: restore data, " + this.mMap.toString());
        } else {
            AbstractC0652e.b(TAG, str + " does not exist");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(ProgressHelper.MAX_COUNT, this.mMaxCount);
        AbstractC0652e.b(TAG, "onPrepare:" + bundle2);
        return bundle2;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        return null;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onRestore(Bundle bundle) {
        if (this.mMaxCount > 0) {
            while (!this.mIsCancel && this.mCompleteCount < this.mMaxCount) {
                synchronized (this.mPauseLock) {
                    while (this.mIsPause) {
                        try {
                            AbstractC0652e.b(TAG, "on pause wait lock here");
                            this.mPauseLock.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                restoreConfig();
                this.mCompleteCount++;
                Bundle bundle2 = new Bundle();
                ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
                ProgressHelper.putCompletedCount(bundle2, this.mCompleteCount);
                this.mBRPluginHandler.updateProgress(bundle2);
            }
        }
        AbstractC0652e.b(TAG, "onRestore");
    }
}
