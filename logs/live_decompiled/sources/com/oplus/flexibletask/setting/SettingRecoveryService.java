package com.oplus.flexibletask.setting;

import android.content.Context;
import android.provider.Settings;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import com.oplus.settingslib.service.RecoveryService;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SettingRecoveryService extends RecoveryService {
    private static int DEFAULT_VALUE_CLOSE = 0;
    private static int DEFAULT_VALUE_OPEN = 1;
    private static final String TAG = "SettingRecoveryService";

    @Override // com.oplus.settingslib.service.RecoveryService
    public boolean doRecoveryOperation(Context context) {
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_GAME_BEHAVIOR, DEFAULT_VALUE_CLOSE);
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_SIMPLE_MODE, DEFAULT_VALUE_OPEN);
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_SHARE_BEHAVIOR, DEFAULT_VALUE_OPEN);
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_GAME_REDIRECT_BEHAVIOR, DEFAULT_VALUE_OPEN);
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_EXCHANGE_APPLICATION, DEFAULT_VALUE_CLOSE);
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_ALPHA_ADJUST, DEFAULT_VALUE_CLOSE);
        AbstractC0652e.b(TAG, "Change game behavior and share behavior to default value");
        return false;
    }
}
