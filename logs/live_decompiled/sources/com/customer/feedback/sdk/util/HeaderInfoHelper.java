package com.customer.feedback.sdk.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.customer.feedback.sdk.feedbacka;
import i2.AbstractC0398b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import k2.AbstractC0444a;
import m2.AbstractC0466a;
import m2.AbstractC0468c;
import m2.g;
import m2.i;
import o2.AbstractC0493a;

/* loaded from: classes.dex */
public class HeaderInfoHelper {
    private static String APP_CODE = null;
    private static final int BUILD_DISPLAY_SPLIT_SIZE = 3;
    public static final boolean IS_BASE64 = false;
    private static final String PRODUCT_EXP_VERSION = "ro.vendor.oplus.exp.version";
    public static final String RO_BUILD_ID = "ro.build.display.id";
    private static final String SDK_VERSION = "16.1.4";
    public static final String SYS_BUILD_ID = "sys.build.display.id";
    private static final String TAG = "HeaderInfoHelper";

    public static String getAppCode(Context context) {
        String str = APP_CODE;
        if (str != null && !TextUtils.isEmpty(str) && !APP_CODE.equals("0") && !APP_CODE.equals("")) {
            return specCode(APP_CODE);
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                int i3 = bundle.getInt("feedback_product_code");
                if (i3 == 0) {
                    i3 = bundle.getInt("upgrade_product_code");
                }
                return specCode(i3);
            }
            try {
                throw new Exception("You should set meta-data with upgrade_product_code first ");
            } catch (Exception e3) {
                LogUtil.e(TAG, "exceptionInfo：" + e3);
                return "0";
            }
        } catch (PackageManager.NameNotFoundException e4) {
            LogUtil.e(TAG, "exceptionInfo：" + e4);
            return "0";
        }
    }

    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    private static String getBuildNumber(String str) {
        String str2 = Build.DISPLAY;
        boolean equals = TextUtils.equals(str, "CN");
        if (equals) {
            String e3 = AbstractC0468c.e(PRODUCT_EXP_VERSION, "");
            if (!TextUtils.isEmpty(e3)) {
                return e3;
            }
        }
        String e4 = AbstractC0468c.e("ro.build.time.fix", "");
        if (!TextUtils.isEmpty(e4)) {
            return e4;
        }
        String e5 = AbstractC0468c.e(SYS_BUILD_ID, null);
        if (!TextUtils.isEmpty(e5)) {
            return e5;
        }
        if (equals) {
            String[] split = str2.split("_");
            if (split.length >= 3) {
                if (TextUtils.equals(str, "MX")) {
                    return split[0] + "_" + split[1];
                }
                String format = String.format("%s_%s_%s", split[0], split[1], split[2]);
                if (split.length <= 3) {
                    return format;
                }
                return format + "_" + split[3];
            }
        }
        return str2;
    }

    public static String getCommonLanguage(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        if (str.startsWith("ar")) {
            return "ar_EG";
        }
        if (TextUtils.isEmpty(str) || !str.contains("#")) {
            return str;
        }
        if (str.startsWith("zh") || str.startsWith("yue")) {
            str2 = "zh_CN";
            if (!str.contains("Hans") && str.contains("Hant")) {
                str2 = str.contains("TW") ? "zh_TW" : "zh_HK";
            }
        } else {
            str2 = str;
        }
        LogUtil.d(TAG, "getCommonLanguage -> " + str + " | " + str2);
        return str2;
    }

    public static String getCountry(Context context) {
        return Locale.getDefault().getCountry();
    }

    private static String getEncryptString(String str) {
        return TextUtils.isEmpty(str) ? str : " not empty";
    }

    public static String getFirmwareVersion(Context context) {
        return Build.DISPLAY;
    }

    public static Map<String, String> getHeader(Context context, boolean z3) {
        return getHeader(context);
    }

    public static String getIAdd() {
        return "empty";
    }

    public static String getLanguage(Context context) {
        return AbstractC0468c.f() == null ? "" : AbstractC0468c.f().toString();
    }

    public static String getModel() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static String getNetType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String trim = activeNetworkInfo.getTypeName().toLowerCase().trim();
                if (trim != null && trim.equals("mobile")) {
                    trim = activeNetworkInfo.getExtraInfo().toLowerCase();
                }
                return trim == null ? "null" : trim;
            }
        } catch (Exception e3) {
            LogUtil.e(TAG, "exceptionInfo：" + e3);
        }
        return "null";
    }

    public static String getRegion(Context context) {
        try {
            String e3 = AbstractC0468c.e("persist.sys.oem.region", "NOTHING");
            String e4 = AbstractC0468c.e(AbstractC0466a.f12428a, "NOTHING");
            if (e4.equals("NOTHING")) {
                e4 = AbstractC0468c.e("persist.sys.oplus.region", "NOTHING");
            }
            boolean equals = "NOTHING".equals(e4);
            boolean equals2 = "NOTHING".equals(e3);
            return equals ^ equals2 ? equals2 ? e4 : e3 : "CN";
        } catch (Exception e5) {
            LogUtil.e(TAG, "exceptionInfo：" + e5);
            return "CN";
        }
    }

    public static String getRomVersion() {
        String str = Build.VERSION.RELEASE;
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static String getSdkVersion(Context context) {
        return SDK_VERSION;
    }

    public static String getStandardLanguage(Context context, String str) {
        if ("bo_CN".equalsIgnoreCase(str)) {
            return str;
        }
        try {
            int identifier = context.getResources().getIdentifier("language_values_exam", "string", "oplus");
            if (identifier <= 0) {
                return "";
            }
            String string = context.getResources().getString(identifier);
            return !TextUtils.isEmpty(string) ? string.replace("-", "_") : string;
        } catch (Exception e3) {
            LogUtil.w(TAG, "get standard language mark failed: " + e3.getMessage());
            return "";
        }
    }

    public static String getSysBuildID() {
        String e3 = AbstractC0468c.e(SYS_BUILD_ID, "");
        if (TextUtils.isEmpty(e3)) {
            e3 = AbstractC0468c.e(RO_BUILD_ID, "");
        }
        try {
            return e3.length() > 31 ? e3.substring(0, 31) : e3;
        } catch (Exception e4) {
            LogUtil.e(TAG, "catch exception when split string:" + e4.getMessage());
            return e3;
        }
    }

    public static String getTimezone() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getVersion() {
        if (TextUtils.isEmpty(AbstractC0398b.f12127a)) {
            return AbstractC0493a.b();
        }
        return "V" + AbstractC0398b.f12127a;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private static String intIP2StringIP(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    public static void setAppCode(String str) {
        APP_CODE = str;
    }

    private static String specCode(int i3) {
        return specCode(String.valueOf(i3));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static Map<String, String> getHeader(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = feedbacka.feedbackq;
        String appCode = getAppCode(context);
        String appVersion = TextUtils.isEmpty(feedbacka.feedbackk) ? getAppVersion(context) : feedbacka.feedbackk;
        String model = getModel();
        String romVersion = getRomVersion();
        String version = getVersion();
        String region = getRegion(context);
        String language = getLanguage(context);
        String standardLanguage = getStandardLanguage(context, language);
        String country = getCountry(context);
        String sdkVersion = getSdkVersion(context);
        String firmwareVersion = getFirmwareVersion(context);
        String netType = getNetType(context);
        String iAdd = getIAdd();
        String str3 = feedbacka.feedbackh;
        String str4 = feedbacka.feedbackg;
        String str5 = AbstractC0444a.f12288b;
        String str6 = feedbacka.feedbackp;
        String sysBuildID = getSysBuildID();
        String buildNumber = getBuildNumber(region);
        String str7 = feedbacka.f9387b;
        String valueOf = String.valueOf(g.a() ? 1 : 0);
        hashMap.put("FB-PC", AbstractC0468c.d(appCode));
        hashMap.put("FB-PV", AbstractC0468c.d(appVersion));
        hashMap.put("FB-PVC", String.valueOf(getVersionCode(context)));
        hashMap.put("FB-SVC", String.valueOf(16010040));
        try {
            hashMap.put("FB-IMEI", URLEncoder.encode(i.a(context, str2), "UTF-8"));
            str = appVersion;
        } catch (UnsupportedEncodingException e3) {
            str = appVersion;
            LogUtil.e(TAG, "IMEI  encode error-> " + e3.getMessage());
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("FB-VAID", AbstractC0468c.d(str2));
        }
        hashMap.put("FB-MODEL", AbstractC0468c.d(model));
        hashMap.put("FB-VERSION", AbstractC0468c.d(romVersion));
        hashMap.put("FB-".concat(AbstractC0468c.p()), AbstractC0468c.d(version));
        hashMap.put("FB-WIDTH", AbstractC0468c.d("320"));
        hashMap.put("FB-OPERATOR", AbstractC0468c.d(""));
        hashMap.put("FB-IP", AbstractC0468c.d(iAdd));
        hashMap.put("FB-APPNAME", AbstractC0468c.d(str7));
        hashMap.put("FB-REGION", AbstractC0468c.d(region));
        hashMap.put("FB-LANGUAGE", getCommonLanguage(language));
        hashMap.put("FB-SLANGUAGE", getCommonLanguage(standardLanguage));
        hashMap.put("FB-COUNTRY", AbstractC0468c.d(country));
        hashMap.put("FB-TIMEZONE", AbstractC0468c.d(getTimezone()));
        hashMap.put("FB-BRAND", AbstractC0468c.d(getBrand()));
        hashMap.put("FB-FIRMWARE", AbstractC0468c.d(firmwareVersion));
        hashMap.put("FB-NETTYPE", AbstractC0468c.d(netType));
        hashMap.put("FB-UID", AbstractC0468c.d(str3));
        hashMap.put("FB-UNAME", AbstractC0468c.d(str4));
        hashMap.put("FB-ENCODE", "0");
        hashMap.put("FB-SDKVER", sdkVersion);
        hashMap.put("FB-RESTURL", str5);
        hashMap.put("FB-MULTIAPPFLAG", str6);
        try {
            hashMap.put("FB-SYSBUILDID", URLEncoder.encode(i.a(context, sysBuildID), "UTF-8"));
        } catch (UnsupportedEncodingException e4) {
            LogUtil.e(TAG, "SYSBUILDID  encode error-> " + e4.getMessage());
        }
        hashMap.put("FB-PRODUCTVER", buildNumber);
        hashMap.put("FB-SUPPORT_LOGKIT", valueOf);
        HashMap hashMap2 = feedbacka.f9389d;
        if (!hashMap2.isEmpty()) {
            Iterator it = hashMap2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                LogUtil.v(TAG, "extra data key is:" + ((String) entry.getKey()));
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
                it = it;
                valueOf = valueOf;
            }
        }
        LogUtil.v(TAG, "\nFB-PC=" + appCode + "\nFB-PV=" + str + "\nFB-SVC=16010040\nFB-DEVICE=" + getEncryptString(str2) + "\nFB-VID=" + getEncryptString(str2) + "\nFB-MODEL=" + model + "\nFB-VERSION=" + romVersion + "\nFB-OsVERSION=" + version + "\nFB-WIDTH=320\nFB-OPERATOR=\nFB-IADD=" + getEncryptString(iAdd) + "\nFB-Region=" + region + "\nFB-Language=" + language + "\nFB-SLanguage=" + standardLanguage + "\nFB-CT=" + country + "\nFB-TIMEZONE=" + getTimezone() + "\nFB-BRAND=" + getBrand() + "\nFB-FIRMWARE=" + getEncryptString(firmwareVersion) + "\nFB-NETTYPE=" + netType + "\nFB-UID=" + getEncryptString(str3) + "\nFB-UNAME=" + str4 + "\nFB-SDKVER=" + sdkVersion + "\nFB-SYSBUILDID=" + sysBuildID + "\nFB-MULTIAPPFLAG=" + str6 + "\nFB-RESTURL=" + str5 + "\nFB-PRODUCTVER" + buildNumber + "\nFB-SUPPORT_LOGKIT" + valueOf);
        return hashMap;
    }

    private static String specCode(String str) {
        str.getClass();
        switch (str) {
            case "1":
                return "001";
            case "2":
                return "002";
            case "3":
                return "003";
            case "4":
                return "004";
            default:
                return str.concat("");
        }
    }
}
