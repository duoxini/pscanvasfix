package com.oplus.backup.sdk.host;

import android.content.Context;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.backup.sdk.common.plugin.BRPluginConfigParser;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BRPluginSource {
    private static final String ASSETS_PLUGINS_PATH = "br_plugins";
    public static final String BR_BASE_DIR = "br_cache";
    public static final String LOCAL_PLUGINS_DIR = "local_plugins";
    private static final String TAG = "BRPluginSource";
    private static BRPluginConfig[] sBRPluginConfigs;

    public static BRPluginConfig[] getLocalBRPlugins(Context context, String str) {
        String[] strArr;
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        StringBuilder sb;
        BRPluginConfig[] bRPluginConfigArr = sBRPluginConfigs;
        if (bRPluginConfigArr != null) {
            return bRPluginConfigArr;
        }
        initBaseFolder(context);
        BRPluginConfig[] bRPluginConfigArr2 = new BRPluginConfig[0];
        ArrayList arrayList = new ArrayList();
        InputStream inputStream2 = null;
        try {
            strArr = context.getAssets().list(ASSETS_PLUGINS_PATH);
        } catch (IOException e3) {
            BRLog.e(TAG, "getLocalBRPlugins, e =" + e3.getMessage());
            strArr = null;
        }
        if (strArr == null) {
            return bRPluginConfigArr2;
        }
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            BRLog.d(TAG, strArr[i3]);
            try {
                strArr2 = context.getAssets().list("br_plugins/" + strArr[i3]);
            } catch (IOException e4) {
                BRLog.e(TAG, "getLocalBRPlugins, e =" + e4.getMessage());
                strArr2 = null;
            }
            if (strArr2 == null) {
                return bRPluginConfigArr2;
            }
            int length2 = strArr2.length;
            for (int i4 = 0; i4 < length2; i4++) {
                if (strArr2[i4].endsWith(".config")) {
                    BRLog.d(TAG, strArr2[i4]);
                    try {
                        inputStream = context.getAssets().open("br_plugins/" + strArr[i3] + "/" + strArr2[i4]);
                        try {
                            try {
                                BRPluginConfig parse = BRPluginConfigParser.parse(inputStream);
                                if (parse != null) {
                                    arrayList.add(parse);
                                    BRLog.d(TAG, "add success");
                                } else {
                                    BRLog.w(TAG, "BRPluginConfigParser.parse(inputStream) failed:");
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5) {
                                        iOException = e5;
                                        sb = new StringBuilder();
                                        sb.append("getLocalBRPlugins, e =");
                                        sb.append(iOException.getMessage());
                                        BRLog.e(TAG, sb.toString());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                if (inputStream2 == null) {
                                    throw th;
                                }
                                try {
                                    inputStream2.close();
                                    throw th;
                                } catch (IOException e6) {
                                    BRLog.e(TAG, "getLocalBRPlugins, e =" + e6.getMessage());
                                    throw th;
                                }
                            }
                        } catch (IOException e7) {
                            e = e7;
                            BRLog.e(TAG, "getLocalBRPlugins, e =" + e.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e8) {
                                    iOException = e8;
                                    sb = new StringBuilder();
                                    sb.append("getLocalBRPlugins, e =");
                                    sb.append(iOException.getMessage());
                                    BRLog.e(TAG, sb.toString());
                                }
                            }
                        }
                    } catch (IOException e9) {
                        e = e9;
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
        }
        BRPluginConfig[] bRPluginConfigArr3 = (BRPluginConfig[]) arrayList.toArray(new BRPluginConfig[arrayList.size()]);
        sBRPluginConfigs = bRPluginConfigArr3;
        return bRPluginConfigArr3;
    }

    public static File initBaseFolder(Context context) {
        File dir = context.getDir(BR_BASE_DIR, 0);
        FileUtils.setPermissionsReadOnly(dir.getAbsolutePath());
        return dir;
    }

    public static BRPluginConfig[] getLocalBRPlugins(Context context) {
        return getLocalBRPlugins(context, LOCAL_PLUGINS_DIR);
    }
}
