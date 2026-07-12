package androidx.window.layout.adapter.extensions;

import D2.k;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ExtensionsWindowLayoutInfoAdapter {

    /* renamed from: a, reason: collision with root package name */
    public static final ExtensionsWindowLayoutInfoAdapter f7215a = new ExtensionsWindowLayoutInfoAdapter();

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    private final boolean d(WindowMetrics windowMetrics, Bounds bounds) {
        Rect a3 = windowMetrics.a();
        if (bounds.e()) {
            return false;
        }
        if (bounds.d() != a3.width() && bounds.a() != a3.height()) {
            return false;
        }
        if (bounds.d() >= a3.width() || bounds.a() >= a3.height()) {
            return (bounds.d() == a3.width() && bounds.a() == a3.height()) ? false : true;
        }
        return false;
    }

    public final FoldingFeature a(WindowMetrics windowMetrics, androidx.window.extensions.layout.FoldingFeature foldingFeature) {
        HardwareFoldingFeature.Type a3;
        FoldingFeature.State state;
        k.e(windowMetrics, "windowMetrics");
        k.e(foldingFeature, "oemFeature");
        int type = foldingFeature.getType();
        if (type == 1) {
            a3 = HardwareFoldingFeature.Type.f7159b.a();
        } else {
            if (type != 2) {
                return null;
            }
            a3 = HardwareFoldingFeature.Type.f7159b.b();
        }
        int state2 = foldingFeature.getState();
        if (state2 == 1) {
            state = FoldingFeature.State.f7152c;
        } else {
            if (state2 != 2) {
                return null;
            }
            state = FoldingFeature.State.f7153d;
        }
        Rect bounds = foldingFeature.getBounds();
        k.d(bounds, "oemFeature.bounds");
        if (!d(windowMetrics, new Bounds(bounds))) {
            return null;
        }
        Rect bounds2 = foldingFeature.getBounds();
        k.d(bounds2, "oemFeature.bounds");
        return new HardwareFoldingFeature(new Bounds(bounds2), a3, state);
    }

    public final WindowLayoutInfo b(Context context, androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
        k.e(context, "context");
        k.e(windowLayoutInfo, "info");
        return c(WindowMetricsCalculatorCompat.f7199b.a(context), windowLayoutInfo);
    }

    public final WindowLayoutInfo c(WindowMetrics windowMetrics, androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
        FoldingFeature foldingFeature;
        k.e(windowMetrics, "windowMetrics");
        k.e(windowLayoutInfo, "info");
        List<androidx.window.extensions.layout.FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        k.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (androidx.window.extensions.layout.FoldingFeature foldingFeature2 : displayFeatures) {
            if (foldingFeature2 instanceof androidx.window.extensions.layout.FoldingFeature) {
                ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = f7215a;
                k.d(foldingFeature2, "feature");
                foldingFeature = extensionsWindowLayoutInfoAdapter.a(windowMetrics, foldingFeature2);
            } else {
                foldingFeature = null;
            }
            if (foldingFeature != null) {
                arrayList.add(foldingFeature);
            }
        }
        return new WindowLayoutInfo(arrayList);
    }
}
