package com.customer.feedback.sdk.util;

import D2.k;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public final class NetworkUtil {
    public static final NetworkUtil INSTANCE = new NetworkUtil();
    public static final String TAG = "NoNetworkUtil";

    private NetworkUtil() {
    }

    public static final boolean hasNetworkConnect(Context context) {
        k.e(context, "context");
        return isMobileDataConnected(context) || isWifiConnected(context);
    }

    public static final boolean isMobileDataConnected(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService("connectivity");
        k.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(0);
        return (networkInfo != null ? networkInfo.getState() : null) == NetworkInfo.State.CONNECTED;
    }

    public static final boolean isWifiConnected(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService("connectivity");
        k.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
        return (networkInfo != null ? networkInfo.getState() : null) == NetworkInfo.State.CONNECTED;
    }
}
