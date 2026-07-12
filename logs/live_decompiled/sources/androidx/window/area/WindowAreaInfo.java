package androidx.window.area;

import D2.g;
import D2.k;
import android.os.Binder;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.layout.WindowMetrics;
import java.util.HashMap;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class WindowAreaInfo {

    /* renamed from: a, reason: collision with root package name */
    private WindowMetrics f6911a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f6912b;

    /* renamed from: c, reason: collision with root package name */
    private final Binder f6913c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowAreaComponent f6914d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f6915e;

    @ExperimentalWindowApi
    public static final class Type {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f6916b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final Type f6917c = new Type("REAR FACING");

        /* renamed from: a, reason: collision with root package name */
        private final String f6918a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private Type(String str) {
            this.f6918a = str;
        }

        public String toString() {
            return this.f6918a;
        }
    }

    public WindowAreaInfo(WindowMetrics windowMetrics, Type type, Binder binder, WindowAreaComponent windowAreaComponent) {
        k.e(windowMetrics, "metrics");
        k.e(type, "type");
        k.e(binder, "token");
        k.e(windowAreaComponent, "windowAreaComponent");
        this.f6911a = windowMetrics;
        this.f6912b = type;
        this.f6913c = binder;
        this.f6914d = windowAreaComponent;
        this.f6915e = new HashMap();
    }

    public final HashMap a() {
        return this.f6915e;
    }

    public final void b(WindowMetrics windowMetrics) {
        k.e(windowMetrics, "<set-?>");
        this.f6911a = windowMetrics;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WindowAreaInfo) {
            WindowAreaInfo windowAreaInfo = (WindowAreaInfo) obj;
            if (k.a(this.f6911a, windowAreaInfo.f6911a) && k.a(this.f6912b, windowAreaInfo.f6912b) && k.a(this.f6915e.entrySet(), windowAreaInfo.f6915e.entrySet())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f6911a.hashCode() * 31) + this.f6912b.hashCode()) * 31) + this.f6915e.entrySet().hashCode();
    }

    public String toString() {
        return "WindowAreaInfo{ Metrics: " + this.f6911a + ", type: " + this.f6912b + ", Capabilities: " + this.f6915e.entrySet() + " }";
    }
}
