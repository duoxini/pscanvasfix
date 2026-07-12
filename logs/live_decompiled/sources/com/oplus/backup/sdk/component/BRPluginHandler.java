package com.oplus.backup.sdk.component;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface BRPluginHandler {
    void error(Bundle bundle);

    void sendMsg(Intent intent, boolean z3);

    void updateProgress(Bundle bundle);
}
