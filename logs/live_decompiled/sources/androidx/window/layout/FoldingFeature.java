package androidx.window.layout;

import D2.g;

/* loaded from: classes.dex */
public interface FoldingFeature extends DisplayFeature {

    public static final class OcclusionType {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f7143b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final OcclusionType f7144c = new OcclusionType("NONE");

        /* renamed from: d, reason: collision with root package name */
        public static final OcclusionType f7145d = new OcclusionType("FULL");

        /* renamed from: a, reason: collision with root package name */
        private final String f7146a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private OcclusionType(String str) {
            this.f7146a = str;
        }

        public String toString() {
            return this.f7146a;
        }
    }

    public static final class Orientation {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f7147b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final Orientation f7148c = new Orientation("VERTICAL");

        /* renamed from: d, reason: collision with root package name */
        public static final Orientation f7149d = new Orientation("HORIZONTAL");

        /* renamed from: a, reason: collision with root package name */
        private final String f7150a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private Orientation(String str) {
            this.f7150a = str;
        }

        public String toString() {
            return this.f7150a;
        }
    }

    public static final class State {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f7151b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        public static final State f7152c = new State("FLAT");

        /* renamed from: d, reason: collision with root package name */
        public static final State f7153d = new State("HALF_OPENED");

        /* renamed from: a, reason: collision with root package name */
        private final String f7154a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private State(String str) {
            this.f7154a = str;
        }

        public String toString() {
            return this.f7154a;
        }
    }

    Orientation a();

    State getState();
}
