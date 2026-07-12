package o0;

import android.os.Bundle;
import com.oplus.dynamicframerate.DynamicFrameRateManager;
import h0.AbstractC0371a;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f12648a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f12649b = false;

    public d(boolean z3) {
        a(z3);
    }

    public final void a(boolean z3) {
        if (!z3 || !AbstractC0647b.b(34, 10)) {
            this.f12648a = false;
            return;
        }
        int dynamicFrameRateType = DynamicFrameRateManager.getDynamicFrameRateType();
        if (dynamicFrameRateType == 1 || dynamicFrameRateType == 2) {
            this.f12648a = true;
        }
    }

    public void b(boolean z3) {
        if (!this.f12648a) {
            AbstractC0371a.a("COUlFrameRateHelper", "SetFrameRate not success, mSupportRateVSdk is false");
            return;
        }
        if (this.f12649b != z3) {
            DynamicFrameRateManager.setFrameRate(this, 10102, z3 ? -1 : -2, (Bundle) null);
            AbstractC0371a.a("COUlFrameRateHelper", "setFrameRate isStart:" + z3);
            this.f12649b = z3;
        }
    }
}
