package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* renamed from: b, reason: collision with root package name */
    private SidecarDeviceState f7222b;

    /* renamed from: d, reason: collision with root package name */
    private final SidecarAdapter f7224d;

    /* renamed from: e, reason: collision with root package name */
    private final SidecarInterface.SidecarCallback f7225e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f7221a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final Map f7223c = new WeakHashMap();

    DistinctElementSidecarCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f7224d = sidecarAdapter;
        this.f7225e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f7221a) {
            try {
                if (this.f7224d.a(this.f7222b, sidecarDeviceState)) {
                    return;
                }
                this.f7222b = sidecarDeviceState;
                this.f7225e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f7221a) {
            try {
                if (this.f7224d.d((SidecarWindowLayoutInfo) this.f7223c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f7223c.put(iBinder, sidecarWindowLayoutInfo);
                this.f7225e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
