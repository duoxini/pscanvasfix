package androidx.window.area;

import D2.g;
import D2.k;
import androidx.window.core.ExperimentalWindowApi;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class WindowAreaCapability {

    /* renamed from: a, reason: collision with root package name */
    private final Operation f6863a;

    /* renamed from: b, reason: collision with root package name */
    private final Status f6864b;

    @ExperimentalWindowApi
    public static final class Operation {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f6865b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final Operation f6866c = new Operation("TRANSFER");

        /* renamed from: d, reason: collision with root package name */
        public static final Operation f6867d = new Operation("PRESENT");

        /* renamed from: a, reason: collision with root package name */
        private final String f6868a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private Operation(String str) {
            this.f6868a = str;
        }

        public String toString() {
            return this.f6868a;
        }
    }

    @ExperimentalWindowApi
    public static final class Status {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f6869b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        private static final Status f6870c = new Status("UNKNOWN");

        /* renamed from: d, reason: collision with root package name */
        public static final Status f6871d = new Status("UNSUPPORTED");

        /* renamed from: e, reason: collision with root package name */
        public static final Status f6872e = new Status("UNAVAILABLE");

        /* renamed from: f, reason: collision with root package name */
        public static final Status f6873f = new Status("AVAILABLE");

        /* renamed from: g, reason: collision with root package name */
        public static final Status f6874g = new Status("ACTIVE");

        /* renamed from: a, reason: collision with root package name */
        private final String f6875a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private Status(String str) {
            this.f6875a = str;
        }

        public String toString() {
            return this.f6875a;
        }
    }

    public WindowAreaCapability(Operation operation, Status status) {
        k.e(operation, "operation");
        k.e(status, "status");
        this.f6863a = operation;
        this.f6864b = status;
    }

    public final Status a() {
        return this.f6864b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WindowAreaCapability) {
            WindowAreaCapability windowAreaCapability = (WindowAreaCapability) obj;
            if (k.a(this.f6863a, windowAreaCapability.f6863a) && k.a(this.f6864b, windowAreaCapability.f6864b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f6863a.hashCode() * 31) + this.f6864b.hashCode();
    }

    public String toString() {
        return "Operation: " + this.f6863a + ": Status: " + this.f6864b;
    }
}
