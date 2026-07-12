package com.oplus.flexibletask.setting.utils;

import V.a;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Slog;
import com.oplus.content.OplusFeatureConfigManager;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class FlexibleSettingHelper {
    private static final String BANNER_TIP_INTENT = "message_entry_source_settings";
    private static final String FEATURE_FOLD_REMAP_DISPLAY_DISABLED = "oplus.software.fold_remap_display_disabled";
    private static final String FEATURE_TABLET = "oplus.hardware.type.tablet";
    private static final String FIRST_TIME = "zoom_banner_first_time_create";
    private static final String FOLD_SCREEN_PROPERTY = "persist.debug.fold_screen";
    private static final int ORDER = 7500;
    private static final int SYSTEM_FOLDING_MODE_CLOSE = 0;
    private static final String SYSTEM_FOLDING_MODE_KEYS = "oplus_system_folding_mode";
    private static final int SYSTEM_FOLDING_MODE_OPEN = 1;
    private static final int SYSTEM_GENERAL = -1;
    private static final String TAG = "ZoomSettingHelper";
    public static final String ZOOM_ALPHA_ADJUST = "alpha_adjust";
    public static final String ZOOM_EXCHANGE_APPLICATION = "exchange_application";
    public static final String ZOOM_GAME_BEHAVIOR = "setting_zoomwindow_game_shrink";
    public static final String ZOOM_GAME_REDIRECT_BEHAVIOR = "flexible_freeform_light_open";
    private static final String ZOOM_SETTING_ACTION = "oplus.intent.action.ZOOM_SETTINGS_ACTIVITY";
    public static final String ZOOM_SHARE_BEHAVIOR = "setting_zoomwindow_open_from_share";
    public static final String ZOOM_SIMPLE_MODE = "setting_zoom_simple_mode";
    private static volatile FlexibleSettingHelper sInstance;
    private Context mContext;
    private boolean mFoldFrontScreen;
    private int mIndex = 0;
    private boolean mFoldScreen = false;
    private boolean mPad = false;
    private boolean mFlip = false;

    private boolean alreadyOpenActivity(Context context) {
        if (context != null) {
            try {
                if (Settings.System.getInt(context.getContentResolver(), FIRST_TIME, 0) == 1) {
                    return true;
                }
            } catch (Exception e3) {
                AbstractC0652e.e(TAG, "alreadyOpenActivity: ", e3);
            }
        }
        return false;
    }

    public static FlexibleSettingHelper getInstance() {
        if (sInstance == null) {
            synchronized (FlexibleSettingHelper.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new FlexibleSettingHelper();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public static boolean isExportVersion(Context context) {
        return false;
    }

    public void createSettingBanner() {
        if (alreadyOpenActivity(this.mContext)) {
            AbstractC0652e.b(TAG, "createSettingBanner: already open banner tip, not create one more");
            return;
        }
        a.b bVar = new a.b("zoomBanner", "com.oplus.exserviceui");
        bVar.o("zoom_name_a").q("zoom_setting_learn_zoom").m(ORDER).p("oplus.intent.action.ZOOM_SETTINGS_ACTIVITY").n("settings_zoom_ic");
        try {
            Slog.d(TAG, "createSettingBanner: success " + V.b.c(this.mContext, bVar.l()));
        } catch (Exception e3) {
            Slog.e(TAG, "createSettingBanner: ", e3);
        }
    }

    public boolean deleteSettingBannerTip(Intent intent) {
        Context context;
        if (intent == null || !BANNER_TIP_INTENT.equals(intent.getIdentifier()) || (context = this.mContext) == null) {
            return false;
        }
        try {
            V.b.a(context, "zoomBanner", "com.oplus.exserviceui");
            Settings.System.putInt(this.mContext.getContentResolver(), FIRST_TIME, 1);
        } catch (Exception e3) {
            AbstractC0652e.e(TAG, "deleteSettingBannerTip: ", e3);
        }
        return true;
    }

    public int getSwitchValue(String str) {
        Context context = this.mContext;
        if (context != null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), str);
            } catch (Settings.SettingNotFoundException e3) {
                AbstractC0652e.e(TAG, "getSwitchValue: ", e3);
            }
        }
        return 1;
    }

    public void initContext(Context context) {
        this.mContext = context;
    }

    public boolean isFlip() {
        this.mFlip = OplusFeatureConfigManager.getInstance().hasFeature(FEATURE_FOLD_REMAP_DISPLAY_DISABLED);
        AbstractC0652e.b(TAG, "isFlip: " + this.mFlip);
        return this.mFlip;
    }

    public boolean isFoldFrontScreen() {
        this.mFoldFrontScreen = Settings.Global.getInt(this.mContext.getContentResolver(), SYSTEM_FOLDING_MODE_KEYS, -1) == 0;
        AbstractC0652e.b(TAG, "isFoldScreen: " + this.mFoldFrontScreen);
        return this.mFoldFrontScreen;
    }

    public boolean isFoldScreen() {
        this.mFoldScreen = Settings.Global.getInt(this.mContext.getContentResolver(), SYSTEM_FOLDING_MODE_KEYS, 0) == 1;
        AbstractC0652e.b(TAG, "isFoldScreen: " + this.mFoldScreen);
        return this.mFoldScreen;
    }

    public boolean isPadScreen() {
        this.mPad = OplusFeatureConfigManager.getInstance().hasFeature(FEATURE_TABLET);
        AbstractC0652e.b(TAG, "isPadScreen: " + this.mPad);
        return this.mPad;
    }
}
