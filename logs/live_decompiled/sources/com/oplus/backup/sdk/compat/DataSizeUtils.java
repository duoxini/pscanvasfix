package com.oplus.backup.sdk.compat;

/* loaded from: classes.dex */
public class DataSizeUtils {
    private static final long ACCOUNT_FILE_SIZE = 620;
    private static final long BROWSER_FILE_SIZE = 350;
    private static final long CALENDAR_FILE_SIZE = 700;
    private static final long CALLRECORD_FILE_SIZE = 450;
    private static final long CLOCK_FILE_SIZE = 250;
    private static final long CONTACTS_BLACKLIST_FILE_SIZE = 170;
    private static final long CONTACTS_HEAD_SIZE = 30720;
    private static final long CONTACTS_TEXT_SIZE = 400;
    private static final long LAUNCHER_FILE_SIZE = 450560;
    private static final long MMS_FILE_SIZE = 256000;
    private static final long SMS_FILE_SIZE = 750;
    private static final long SYSTEM_SETTING_FILE_SIZE = 81920;
    private static final long WEATHER_FILE_SIZE = 320;

    public static long estimateSize(int i3, int i4) {
        long j3;
        if (i3 == 1) {
            return ((i4 / 2) * CONTACTS_HEAD_SIZE) + (i4 * CONTACTS_TEXT_SIZE);
        }
        if (i3 == 2) {
            j3 = SMS_FILE_SIZE;
        } else if (i3 == 4) {
            j3 = MMS_FILE_SIZE;
        } else if (i3 == 8) {
            j3 = CALENDAR_FILE_SIZE;
        } else if (i3 == 272) {
            j3 = CALLRECORD_FILE_SIZE;
        } else if (i3 == 288) {
            j3 = CLOCK_FILE_SIZE;
        } else if (i3 == 304) {
            j3 = BROWSER_FILE_SIZE;
        } else if (i3 == 320) {
            j3 = WEATHER_FILE_SIZE;
        } else {
            if (i3 == 336) {
                return ACCOUNT_FILE_SIZE;
            }
            if (i3 == 352) {
                return LAUNCHER_FILE_SIZE;
            }
            if (i3 == 384) {
                return SYSTEM_SETTING_FILE_SIZE;
            }
            if (i3 != 592) {
                return 0L;
            }
            j3 = CONTACTS_BLACKLIST_FILE_SIZE;
        }
        return i4 * j3;
    }
}
