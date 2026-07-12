package com.oplus.backup.sdk.component.plugin;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface IBRPlugin {
    void onBackup(Bundle bundle);

    void onCancel(Bundle bundle);

    void onContinue(Bundle bundle);

    Bundle onDestroy(Bundle bundle);

    void onPause(Bundle bundle);

    Bundle onPrepare(Bundle bundle);

    Bundle onPreview(Bundle bundle);

    void onRestore(Bundle bundle);

    void onReveiveMsg(Intent intent, boolean z3);
}
