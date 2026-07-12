package com.oplus.flexibletask.setting.guide;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class SettingsGuideContentView extends BaseGuideContentView {
    public SettingsGuideContentView(Context context) {
        this(context, null);
    }

    @Override // com.oplus.flexibletask.setting.guide.BaseGuideContentView
    protected boolean delayBeforeStartPlay() {
        return false;
    }

    public SettingsGuideContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingsGuideContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
