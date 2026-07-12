package androidx.window.layout;

import D2.g;
import D2.k;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;

/* loaded from: classes.dex */
public final class HardwareFoldingFeature implements FoldingFeature {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f7155d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final Bounds f7156a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f7157b;

    /* renamed from: c, reason: collision with root package name */
    private final FoldingFeature.State f7158c;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void a(Bounds bounds) {
            k.e(bounds, "bounds");
            if (bounds.d() == 0 && bounds.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            }
            if (bounds.b() != 0 && bounds.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }

        private Companion() {
        }
    }

    public static final class Type {

        /* renamed from: b, reason: collision with root package name */
        public static final Companion f7159b = new Companion(null);

        /* renamed from: c, reason: collision with root package name */
        private static final Type f7160c = new Type("FOLD");

        /* renamed from: d, reason: collision with root package name */
        private static final Type f7161d = new Type("HINGE");

        /* renamed from: a, reason: collision with root package name */
        private final String f7162a;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final Type a() {
                return Type.f7160c;
            }

            public final Type b() {
                return Type.f7161d;
            }

            private Companion() {
            }
        }

        private Type(String str) {
            this.f7162a = str;
        }

        public String toString() {
            return this.f7162a;
        }
    }

    public HardwareFoldingFeature(Bounds bounds, Type type, FoldingFeature.State state) {
        k.e(bounds, "featureBounds");
        k.e(type, "type");
        k.e(state, "state");
        this.f7156a = bounds;
        this.f7157b = type;
        this.f7158c = state;
        f7155d.a(bounds);
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.Orientation a() {
        return this.f7156a.d() > this.f7156a.a() ? FoldingFeature.Orientation.f7149d : FoldingFeature.Orientation.f7148c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(HardwareFoldingFeature.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
        return k.a(this.f7156a, hardwareFoldingFeature.f7156a) && k.a(this.f7157b, hardwareFoldingFeature.f7157b) && k.a(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.State getState() {
        return this.f7158c;
    }

    public int hashCode() {
        return (((this.f7156a.hashCode() * 31) + this.f7157b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return HardwareFoldingFeature.class.getSimpleName() + " { " + this.f7156a + ", type=" + this.f7157b + ", state=" + getState() + " }";
    }
}
