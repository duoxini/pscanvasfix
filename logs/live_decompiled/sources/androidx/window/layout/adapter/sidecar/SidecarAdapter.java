package androidx.window.layout.adapter.sidecar;

import D2.g;
import D2.k;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class SidecarAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f7226b = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final String f7227c = SidecarAdapter.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final VerificationMode f7228a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    k.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) invoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            int a3 = a(sidecarDeviceState);
            if (a3 < 0 || a3 > 4) {
                return 0;
            }
            return a3;
        }

        public final List c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            k.e(sidecarWindowLayoutInfo, "info");
            try {
                try {
                    List list = sidecarWindowLayoutInfo.displayFeatures;
                    return list == null ? AbstractC0544n.j() : list;
                } catch (NoSuchFieldError unused) {
                    Object invoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                    k.c(invoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) invoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return AbstractC0544n.j();
            }
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i3) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i3;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i3));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidecarAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (k.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return k.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    private final boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!b((SidecarDisplayFeature) list.get(i3), (SidecarDisplayFeature) list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (k.a(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        Companion companion = f7226b;
        return companion.b(sidecarDeviceState) == companion.b(sidecarDeviceState2);
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (k.a(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        Companion companion = f7226b;
        return c(companion.c(sidecarWindowLayoutInfo), companion.c(sidecarWindowLayoutInfo2));
    }

    public final WindowLayoutInfo e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        k.e(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new WindowLayoutInfo(AbstractC0544n.j());
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        Companion companion = f7226b;
        companion.d(sidecarDeviceState2, companion.b(sidecarDeviceState));
        return new WindowLayoutInfo(f(companion.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final List f(List list, SidecarDeviceState sidecarDeviceState) {
        k.e(list, "sidecarDisplayFeatures");
        k.e(sidecarDeviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DisplayFeature g3 = g((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (g3 != null) {
                arrayList.add(g3);
            }
        }
        return arrayList;
    }

    public final DisplayFeature g(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
        HardwareFoldingFeature.Type a3;
        FoldingFeature.State state;
        k.e(sidecarDisplayFeature, "feature");
        k.e(sidecarDeviceState, "deviceState");
        SpecificationComputer.Companion companion = SpecificationComputer.f6971a;
        String str = f7227c;
        k.d(str, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) SpecificationComputer.Companion.b(companion, sidecarDisplayFeature, str, this.f7228a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.f7229e).c("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.f7230e).c("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.f7231e).c("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.f7232e).a();
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type = sidecarDisplayFeature2.getType();
        if (type == 1) {
            a3 = HardwareFoldingFeature.Type.f7159b.a();
        } else {
            if (type != 2) {
                return null;
            }
            a3 = HardwareFoldingFeature.Type.f7159b.b();
        }
        int b3 = f7226b.b(sidecarDeviceState);
        if (b3 == 0 || b3 == 1) {
            return null;
        }
        if (b3 == 2) {
            state = FoldingFeature.State.f7153d;
        } else if (b3 == 3) {
            state = FoldingFeature.State.f7152c;
        } else {
            if (b3 == 4) {
                return null;
            }
            state = FoldingFeature.State.f7152c;
        }
        Rect rect = sidecarDisplayFeature.getRect();
        k.d(rect, "feature.rect");
        return new HardwareFoldingFeature(new Bounds(rect), a3, state);
    }

    public SidecarAdapter(VerificationMode verificationMode) {
        k.e(verificationMode, "verificationMode");
        this.f7228a = verificationMode;
    }

    public /* synthetic */ SidecarAdapter(VerificationMode verificationMode, int i3, g gVar) {
        this((i3 & 1) != 0 ? VerificationMode.QUIET : verificationMode);
    }
}
