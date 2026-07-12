package com.oplus.backup.sdk.common.plugin;

import W0.a;
import W0.b;
import W0.e;
import W0.g;
import W0.h;
import android.os.Bundle;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* loaded from: classes.dex */
public class BRPluginConfigParser {
    public static final String JSON_ENCODE = "json";
    private static final String TAG = "BRPluginConfigParser";

    private static Bundle fromJson(b bVar) {
        Bundle bundle = new Bundle();
        if (!bVar.f()) {
            return null;
        }
        for (Map.Entry entry : ((e) bVar).i()) {
            String str = (String) entry.getKey();
            b bVar2 = (b) entry.getValue();
            a aVar = bVar2.d() ? (a) bVar2 : null;
            h hVar = bVar2.g() ? (h) bVar2 : null;
            if (aVar != null && aVar.size() <= 0) {
                bundle.putStringArray(str, new String[0]);
            } else if (aVar != null && aVar.i(0).g()) {
                int size = aVar.size();
                String[] strArr = new String[size];
                for (int i3 = 0; i3 < size; i3++) {
                    h hVar2 = (h) aVar.i(i3);
                    if (hVar2.n()) {
                        strArr[i3] = hVar2.j();
                    }
                }
                bundle.putStringArray(str, strArr);
            } else if (hVar != null) {
                if (hVar.k()) {
                    bundle.putBoolean(str, hVar.h());
                } else if (hVar.m()) {
                    bundle.putDouble(str, hVar.i().doubleValue());
                } else if (hVar.n()) {
                    bundle.putString(str, hVar.j());
                } else {
                    BRLog.d(TAG, "unable to transform json to bundle " + str);
                }
            }
        }
        return bundle;
    }

    private static String getValue(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("=", indexOf) + 1;
        int indexOf3 = str.indexOf(Constants.DataMigration.SPLIT_TAG, indexOf2);
        if (indexOf3 == -1) {
            indexOf3 = str.length();
        }
        return str.substring(indexOf2, indexOf3);
    }

    public static BRPluginConfig parse(InputStream inputStream) {
        String readInputStream = readInputStream(inputStream);
        String value = getValue(readInputStream, "encode");
        String value2 = getValue(readInputStream, BRPluginConfig.VERSION);
        String value3 = getValue(readInputStream, "context");
        if (value3 != null) {
            value3 = value3.replaceAll("\r|\n", "");
        }
        return parse(value, value2, value3);
    }

    private static String readFile(File file) {
        FileInputStream fileInputStream = null;
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e3) {
            BRLog.e(TAG, "new FileInputStream failed, " + e3.getMessage());
        }
        return readInputStream(fileInputStream);
    }

    private static String readInputStream(InputStream inputStream) {
        StringBuilder sb;
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            BRLog.w(TAG, "close failed, " + e3.getMessage());
                            throw th;
                        }
                    }
                    bufferedReader.close();
                    throw th;
                }
            } catch (IOException e4) {
                BRLog.e(TAG, "readInputStream, e =" + e4.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                        e = e5;
                        sb = new StringBuilder();
                        sb.append("close failed, ");
                        sb.append(e.getMessage());
                        BRLog.w(TAG, sb.toString());
                        return stringBuffer.toString();
                    }
                }
                bufferedReader.close();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e6) {
                e = e6;
                sb = new StringBuilder();
                sb.append("close failed, ");
                sb.append(e.getMessage());
                BRLog.w(TAG, sb.toString());
                return stringBuffer.toString();
            }
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    public static BRPluginConfig parse(File file) {
        String readFile = readFile(file);
        String value = getValue(readFile, "encode");
        String value2 = getValue(readFile, BRPluginConfig.VERSION);
        String value3 = getValue(readFile, "context");
        if (value3 != null) {
            return parse(value, value2, value3.replaceAll("\r|\n", ""));
        }
        return null;
    }

    protected static BRPluginConfig parse(String str, String str2, String str3) {
        Bundle bundle;
        BRLog.d(TAG, str + ", " + str2 + ", " + str3);
        if (!JSON_ENCODE.equals(str)) {
            return null;
        }
        try {
            bundle = fromJson(new g().a(str3));
        } catch (Exception e3) {
            BRLog.w(TAG, "parse failed: " + e3.getMessage());
            bundle = null;
        }
        if (bundle != null) {
            return new BRPluginConfig(bundle);
        }
        return null;
    }
}
