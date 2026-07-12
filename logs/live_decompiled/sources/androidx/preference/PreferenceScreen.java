package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.j;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: m, reason: collision with root package name */
    private boolean f5925m;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.content.res.i.a(context, m.f6036h, R.attr.preferenceScreenStyle));
        this.f5925m = true;
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        j.b g3;
        if (getIntent() != null || getFragment() != null || o() == 0 || (g3 = getPreferenceManager().g()) == null) {
            return;
        }
        g3.onNavigateToScreen(this);
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean p() {
        return false;
    }

    public boolean w() {
        return this.f5925m;
    }
}
