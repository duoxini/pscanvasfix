package androidx.window.embedding;

import D2.g;

/* loaded from: classes.dex */
public final class SplitController {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f7092b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final EmbeddingBackend f7093a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class SplitSupportStatus {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f7094b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final SplitSupportStatus f7095c = new SplitSupportStatus(0);

        /* renamed from: d, reason: collision with root package name */
        public static final SplitSupportStatus f7096d = new SplitSupportStatus(1);

        /* renamed from: e, reason: collision with root package name */
        public static final SplitSupportStatus f7097e = new SplitSupportStatus(2);

        /* renamed from: a, reason: collision with root package name */
        private final int f7098a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private SplitSupportStatus(int i3) {
            this.f7098a = i3;
        }

        public String toString() {
            int i3 = this.f7098a;
            return i3 != 0 ? i3 != 1 ? i3 != 2 ? "UNKNOWN" : "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED" : "SplitSupportStatus: UNAVAILABLE" : "SplitSupportStatus: AVAILABLE";
        }
    }
}
