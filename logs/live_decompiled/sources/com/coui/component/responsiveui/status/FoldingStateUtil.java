package com.coui.component.responsiveui.status;

import D2.k;
import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import android.util.Log;
import com.coui.component.responsiveui.ResponsiveUILog;

/* loaded from: classes.dex */
public final class FoldingStateUtil {
    public static final FoldingStateUtil INSTANCE = new FoldingStateUtil();

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f9353a;

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9353a = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("FoldingStateUtil", 3);
    }

    private FoldingStateUtil() {
    }

    public static final FoldingState getFoldingState(Context context) {
        k.e(context, "context");
        int i3 = Settings.Global.getInt(context.getContentResolver(), "oplus_system_folding_mode", -1);
        FoldingState foldingState = i3 != 0 ? i3 != 1 ? FoldingState.UNKNOWN : FoldingState.UNFOLD : FoldingState.FOLD;
        if (f9353a) {
            Log.d("FoldingStateUtil", "[getFoldingState]: " + foldingState);
        }
        return foldingState;
    }

    public static final void registerFoldingStateObserver(Context context, ContentObserver contentObserver) {
        k.e(context, "context");
        k.e(contentObserver, "observer");
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor("oplus_system_folding_mode"), false, contentObserver);
    }

    public static final void unregisterFoldingStateObserver(Context context, ContentObserver contentObserver) {
        k.e(context, "context");
        k.e(contentObserver, "observer");
        context.getContentResolver().unregisterContentObserver(contentObserver);
    }
}
