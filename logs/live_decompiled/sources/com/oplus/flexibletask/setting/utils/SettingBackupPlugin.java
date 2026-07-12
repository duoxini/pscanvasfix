package com.oplus.flexibletask.setting.utils;

import android.content.Context;
import android.os.Bundle;
import android.util.Xml;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.backup.sdk.component.BRPluginHandler;
import com.oplus.backup.sdk.component.plugin.BackupPlugin;
import com.oplus.backup.sdk.host.listener.ProgressHelper;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SettingBackupPlugin extends BackupPlugin {
    private static final String BACKUP_FILE = "zoomsetting.xml";
    private static final String FOLDER_INFO = "exserviceui";
    private static final String TAG = "SettingBackupPlugin";
    private BREngineConfig mBackupConfig;
    private int mCompleteCount;
    private Context mContext;
    private boolean mIsCancel;
    private boolean mIsPause;
    private int mMaxCount;
    private static final String PARENT_FOLDER = "Setting";
    private static final String BACKUP_FOLDER = PARENT_FOLDER + File.separator + "exserviceui";
    private Object mPauseLock = new Object();
    private HashMap<String, Integer> mMap = new HashMap<>();

    private void backUpFile(Map<String, Integer> map, FileDescriptor fileDescriptor) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(fileDescriptor);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writeConfig(fileOutputStream, map);
                fileOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                AbstractC0652e.d(TAG, e.toString());
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        AbstractC0652e.d(TAG, e5.toString());
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            AbstractC0652e.d(TAG, e6.toString());
        }
    }

    private String getBackupFilePath(Bundle bundle) {
        return this.mBackupConfig.getBackupRootPath() + File.separator + BACKUP_FOLDER;
    }

    private int getMaxCount() {
        return 1;
    }

    private void initData() {
        this.mMap.put(FlexibleSettingHelper.ZOOM_GAME_BEHAVIOR, Integer.valueOf(FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_GAME_BEHAVIOR)));
        this.mMap.put(FlexibleSettingHelper.ZOOM_SIMPLE_MODE, Integer.valueOf(FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_SIMPLE_MODE)));
        this.mMap.put(FlexibleSettingHelper.ZOOM_SHARE_BEHAVIOR, Integer.valueOf(FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_SHARE_BEHAVIOR)));
        this.mMap.put(FlexibleSettingHelper.ZOOM_GAME_REDIRECT_BEHAVIOR, Integer.valueOf(FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_GAME_REDIRECT_BEHAVIOR)));
        this.mMap.put(FlexibleSettingHelper.ZOOM_EXCHANGE_APPLICATION, Integer.valueOf(FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_EXCHANGE_APPLICATION)));
        this.mMap.put(FlexibleSettingHelper.ZOOM_ALPHA_ADJUST, Integer.valueOf(FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_ALPHA_ADJUST)));
        AbstractC0652e.h(TAG, "initData: " + this.mMap.toString());
    }

    private static boolean writeConfig(FileOutputStream fileOutputStream, Map<String, Integer> map) {
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            newSerializer.setOutput(fileOutputStream, "utf-8");
            newSerializer.startDocument(null, Boolean.TRUE);
            newSerializer.text("\r\n");
            newSerializer.startTag(null, Constants.MessagerConstants.CONFIG_KEY);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                String valueOf = String.valueOf(entry.getValue());
                newSerializer.text("\r\n");
                newSerializer.text("\t");
                newSerializer.startTag(null, "switch");
                newSerializer.attribute(null, "name", key);
                newSerializer.text(valueOf);
                newSerializer.endTag(null, "switch");
            }
            newSerializer.text("\r\n");
            newSerializer.endTag(null, Constants.MessagerConstants.CONFIG_KEY);
            newSerializer.text("\r\n");
            newSerializer.endDocument();
            return true;
        } catch (Exception e3) {
            AbstractC0652e.d(TAG, e3.toString());
            return false;
        }
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public void onBackup(Bundle bundle) {
        try {
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
                    backUpFile(this.mMap, getFileDescriptor(getBackupFilePath(bundle) + File.separator + BACKUP_FILE));
                    this.mCompleteCount = this.mCompleteCount + 1;
                    Bundle bundle2 = new Bundle();
                    ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
                    ProgressHelper.putCompletedCount(bundle2, this.mCompleteCount);
                    getPluginHandler().updateProgress(bundle2);
                }
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        AbstractC0652e.b(TAG, "onBackup");
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
        this.mBackupConfig = bREngineConfig;
        AbstractC0652e.b(TAG, "onCreate");
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
        initData();
        return null;
    }

    @Override // com.oplus.backup.sdk.component.plugin.IBRPlugin
    public Bundle onPreview(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        ProgressHelper.putMaxCount(bundle2, this.mMaxCount);
        ProgressHelper.putPreviewDataSize(bundle2, 100L);
        AbstractC0652e.b(TAG, "onPreview:" + bundle2);
        return bundle2;
    }
}
