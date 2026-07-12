package com.oplus.flexibletask.setting.utils;

import D2.g;
import D2.k;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.oplus.backup.sdk.common.utils.Constants;
import org.json.JSONObject;
import p2.AbstractC0506f;
import p2.C0511k;
import p2.InterfaceC0505e;
import p2.l;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public final class UmsZoomQueryProvider extends ContentProvider {
    private static final String ACTION_ZOOM_SETTINGS_ACTIVITY = "oplus.intent.action.ZOOM_SETTINGS_ACTIVITY";
    private static final String CLOSE_GAMING_QUICK_RETRACT_ZOOM_WINDOW = "close_gaming_quick_retract_zoom_window";
    private static final String CLOSE_ZOOM_WINDOW_SHARE = "close_zoom_window_share";
    public static final Companion Companion = new Companion(null);
    private static final int ERR_UNKNOWN = 50;
    private static final String KEY_API_SWITCH_CLOSE_API = "apiproxy_biz_switch_close_api";
    private static final String KEY_API_SWITCH_OPEN_API = "apiproxy_biz_switch_open_api";
    private static final String KEY_JUMP_DATA = "apiproxy_biz_jump_data";
    private static final String KEY_RESULT_CARD_TYPE = "apiproxy_biz_ui_card_type";
    private static final String KEY_RESULT_CODE = "apiproxy_biz_code";
    private static final String KEY_RESULT_SWITCH_STATUS = "apiproxy_biz_switch_status";
    private static final String OPEN_GAMING_QUICK_RETRACT_ZOOM_WINDOW = "open_gaming_quick_retract_zoom_window";
    private static final String OPEN_ZOOM_WINDOW_SHARE = "open_zoom_window_share";
    private static final String QUERY_GAMING_QUICK_RETRACT_ZOOM_WINDOW_SETTINGS = "query_gaming_quick_retract_zoom_window_settings";
    private static final String QUERY_ZOOM_WINDOW_SHARE_SETTINGS = "query_zoom_window_share_settings";
    private static final int SUCCESS = 0;
    private static final String TAG = "UmsZommQueryProvider";
    private static final int VALUE_CARD_TYPE_SWITCH = 1;
    private static final int VALUE_JUMP_TYPE = 3;
    private final InterfaceC0505e mContext$delegate = AbstractC0506f.a(new UmsZoomQueryProvider$mContext$2(this));

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    private final String buildJumpDataString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 3);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("packageName", "com.oplus.pscanvas");
        jSONObject2.put("actionName", "oplus.intent.action.ZOOM_SETTINGS_ACTIVITY");
        jSONObject.put("data", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        k.d(jSONObject3, "toString(...)");
        return jSONObject3;
    }

    private final Bundle queryGamingQuickRetractZoomWindow() {
        Context mContext = getMContext();
        k.b(mContext);
        int i3 = Settings.System.getInt(mContext.getContentResolver(), FlexibleSettingHelper.ZOOM_GAME_BEHAVIOR);
        AbstractC0652e.b(TAG, "currentState = " + i3);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RESULT_CODE, 0);
        bundle.putInt(KEY_RESULT_CARD_TYPE, 1);
        bundle.putInt(KEY_RESULT_SWITCH_STATUS, i3);
        bundle.putString(KEY_API_SWITCH_CLOSE_API, CLOSE_GAMING_QUICK_RETRACT_ZOOM_WINDOW);
        bundle.putString(KEY_API_SWITCH_OPEN_API, OPEN_GAMING_QUICK_RETRACT_ZOOM_WINDOW);
        bundle.putString(KEY_JUMP_DATA, buildJumpDataString());
        return bundle;
    }

    private final Bundle queryZoomWindowShare() {
        Context mContext = getMContext();
        k.b(mContext);
        int i3 = Settings.System.getInt(mContext.getContentResolver(), FlexibleSettingHelper.ZOOM_SHARE_BEHAVIOR);
        AbstractC0652e.b(TAG, "currentState = " + i3);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RESULT_CODE, 0);
        bundle.putInt(KEY_RESULT_CARD_TYPE, 1);
        bundle.putInt(KEY_RESULT_SWITCH_STATUS, i3);
        bundle.putString(KEY_API_SWITCH_CLOSE_API, CLOSE_ZOOM_WINDOW_SHARE);
        bundle.putString(KEY_API_SWITCH_OPEN_API, OPEN_ZOOM_WINDOW_SHARE);
        bundle.putString(KEY_JUMP_DATA, buildJumpDataString());
        return bundle;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        k.e(str, Constants.MessagerConstants.METHOD_KEY);
        AbstractC0652e.b(TAG, "call, method, " + str + ",arg:" + str2);
        try {
            C0511k.a aVar = C0511k.f12803f;
            if (k.a(str, QUERY_ZOOM_WINDOW_SHARE_SETTINGS)) {
                return queryZoomWindowShare();
            }
            if (k.a(str, QUERY_GAMING_QUICK_RETRACT_ZOOM_WINDOW_SETTINGS)) {
                return queryGamingQuickRetractZoomWindow();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(KEY_RESULT_CODE, ERR_UNKNOWN);
            return bundle2;
        } catch (Throwable th) {
            C0511k.a aVar2 = C0511k.f12803f;
            Throwable d3 = C0511k.d(C0511k.b(l.a(th)));
            if (d3 != null) {
                AbstractC0652e.b(TAG, "call, err, " + d3.getMessage());
                new Bundle().putInt(KEY_RESULT_CODE, ERR_UNKNOWN);
            }
            return super.call(str, str2, bundle);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        k.e(uri, "uri");
        return 0;
    }

    public final Context getMContext() {
        return (Context) this.mContext$delegate.getValue();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        k.e(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        k.e(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        k.e(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        k.e(uri, "uri");
        return 0;
    }
}
