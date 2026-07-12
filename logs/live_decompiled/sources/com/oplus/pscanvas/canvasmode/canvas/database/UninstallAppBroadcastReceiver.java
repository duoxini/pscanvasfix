package com.oplus.pscanvas.canvasmode.canvas.database;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import w1.C0622f;

/* loaded from: classes.dex */
public class UninstallAppBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        String schemeSpecificPart = data.getSchemeSpecificPart();
        Log.d("UninstallAppBroadcastReceiver", "uninstall:" + schemeSpecificPart + " action:" + intent.getAction());
        if ("oplus.intent.action.MULTI_APP_PACKAGE_REMOVED".equals(intent.getAction())) {
            C0622f.k(context.getApplicationContext()).F(schemeSpecificPart, intent.getIntExtra("android.intent.extra.user_handle", -1));
        } else if ("android.intent.action.PACKAGE_FULLY_REMOVED".equals(intent.getAction())) {
            C0622f.k(context.getApplicationContext()).F(schemeSpecificPart, 0);
        }
    }
}
