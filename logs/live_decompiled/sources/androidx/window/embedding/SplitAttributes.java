package androidx.window.embedding;

import D2.g;
import D2.k;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;

/* loaded from: classes.dex */
public final class SplitAttributes {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f7065c = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f7066d = SplitAttributes.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final SplitType f7067a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutDirection f7068b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private SplitType f7069a = SplitType.f7081e;

        /* renamed from: b, reason: collision with root package name */
        private LayoutDirection f7070b = LayoutDirection.f7072d;

        public final SplitAttributes a() {
            return new SplitAttributes(this.f7069a, this.f7070b);
        }

        public final Builder b(LayoutDirection layoutDirection) {
            k.e(layoutDirection, "layoutDirection");
            this.f7070b = layoutDirection;
            return this;
        }

        public final Builder c(SplitType splitType) {
            k.e(splitType, "type");
            this.f7069a = splitType;
            return this;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class LayoutDirection {

        /* renamed from: c, reason: collision with root package name */
        public static final Companion f7071c = new Companion(null);

        /* renamed from: d, reason: collision with root package name */
        public static final LayoutDirection f7072d = new LayoutDirection("LOCALE", 0);

        /* renamed from: e, reason: collision with root package name */
        public static final LayoutDirection f7073e = new LayoutDirection("LEFT_TO_RIGHT", 1);

        /* renamed from: f, reason: collision with root package name */
        public static final LayoutDirection f7074f = new LayoutDirection("RIGHT_TO_LEFT", 2);

        /* renamed from: g, reason: collision with root package name */
        public static final LayoutDirection f7075g = new LayoutDirection("TOP_TO_BOTTOM", 3);

        /* renamed from: h, reason: collision with root package name */
        public static final LayoutDirection f7076h = new LayoutDirection("BOTTOM_TO_TOP", 4);

        /* renamed from: a, reason: collision with root package name */
        private final String f7077a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7078b;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private LayoutDirection(String str, int i3) {
            this.f7077a = str;
            this.f7078b = i3;
        }

        public String toString() {
            return this.f7077a;
        }
    }

    public static final class SplitType {

        /* renamed from: c, reason: collision with root package name */
        public static final Companion f7079c;

        /* renamed from: d, reason: collision with root package name */
        public static final SplitType f7080d;

        /* renamed from: e, reason: collision with root package name */
        public static final SplitType f7081e;

        /* renamed from: f, reason: collision with root package name */
        public static final SplitType f7082f;

        /* renamed from: a, reason: collision with root package name */
        private final String f7083a;

        /* renamed from: b, reason: collision with root package name */
        private final float f7084b;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final SplitType a(float f3) {
                SplitType splitType = SplitType.f7080d;
                return f3 == splitType.a() ? splitType : b(f3);
            }

            public final SplitType b(float f3) {
                SpecificationComputer.Companion companion = SpecificationComputer.f6971a;
                Float valueOf = Float.valueOf(f3);
                String str = SplitAttributes.f7066d;
                k.d(str, "TAG");
                Object a3 = SpecificationComputer.Companion.b(companion, valueOf, str, VerificationMode.STRICT, null, 4, null).c("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new SplitAttributes$SplitType$Companion$ratio$checkedRatio$1(f3)).a();
                k.b(a3);
                float floatValue = ((Number) a3).floatValue();
                return new SplitType("ratio:" + floatValue, floatValue);
            }

            private Companion() {
            }
        }

        static {
            Companion companion = new Companion(null);
            f7079c = companion;
            f7080d = new SplitType("expandContainers", 0.0f);
            f7081e = companion.b(0.5f);
            f7082f = new SplitType("hinge", -1.0f);
        }

        public SplitType(String str, float f3) {
            k.e(str, "description");
            this.f7083a = str;
            this.f7084b = f3;
        }

        public final float a() {
            return this.f7084b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SplitType)) {
                return false;
            }
            SplitType splitType = (SplitType) obj;
            return this.f7084b == splitType.f7084b && k.a(this.f7083a, splitType.f7083a);
        }

        public int hashCode() {
            return this.f7083a.hashCode() + (Float.hashCode(this.f7084b) * 31);
        }

        public String toString() {
            return this.f7083a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SplitAttributes() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitAttributes)) {
            return false;
        }
        SplitAttributes splitAttributes = (SplitAttributes) obj;
        return k.a(this.f7067a, splitAttributes.f7067a) && k.a(this.f7068b, splitAttributes.f7068b);
    }

    public int hashCode() {
        return (this.f7067a.hashCode() * 31) + this.f7068b.hashCode();
    }

    public String toString() {
        return SplitAttributes.class.getSimpleName() + ":{splitType=" + this.f7067a + ", layoutDir=" + this.f7068b + " }";
    }

    public SplitAttributes(SplitType splitType, LayoutDirection layoutDirection) {
        k.e(splitType, "splitType");
        k.e(layoutDirection, "layoutDirection");
        this.f7067a = splitType;
        this.f7068b = layoutDirection;
    }

    public /* synthetic */ SplitAttributes(SplitType splitType, LayoutDirection layoutDirection, int i3, g gVar) {
        this((i3 & 1) != 0 ? SplitType.f7081e : splitType, (i3 & 2) != 0 ? LayoutDirection.f7072d : layoutDirection);
    }
}
