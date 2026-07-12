package androidx.window.embedding;

import D2.g;
import D2.k;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;

/* loaded from: classes.dex */
public class SplitRule extends EmbeddingRule {

    /* renamed from: h, reason: collision with root package name */
    public static final Companion f7120h = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    public static final EmbeddingAspectRatio f7121i = EmbeddingAspectRatio.f7014c.a(1.4f);

    /* renamed from: j, reason: collision with root package name */
    public static final EmbeddingAspectRatio f7122j = EmbeddingAspectRatio.f7015d;

    /* renamed from: b, reason: collision with root package name */
    private final int f7123b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7124c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7125d;

    /* renamed from: e, reason: collision with root package name */
    private final EmbeddingAspectRatio f7126e;

    /* renamed from: f, reason: collision with root package name */
    private final EmbeddingAspectRatio f7127f;

    /* renamed from: g, reason: collision with root package name */
    private final SplitAttributes f7128g;

    public static final class Api30Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api30Impl f7129a = new Api30Impl();

        private Api30Impl() {
        }

        public final Rect a(WindowMetrics windowMetrics) {
            k.e(windowMetrics, "windowMetrics");
            Rect bounds = windowMetrics.getBounds();
            k.d(bounds, "windowMetrics.bounds");
            return bounds;
        }
    }

    public static final class Api34Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api34Impl f7130a = new Api34Impl();

        private Api34Impl() {
        }

        public final float a(WindowMetrics windowMetrics, Context context) {
            k.e(windowMetrics, "windowMetrics");
            k.e(context, "context");
            try {
                return windowMetrics.getDensity();
            } catch (NoSuchMethodError unused) {
                return context.getResources().getDisplayMetrics().density;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class FinishBehavior {

        /* renamed from: c, reason: collision with root package name */
        public static final Companion f7131c = new Companion(null);

        /* renamed from: d, reason: collision with root package name */
        public static final FinishBehavior f7132d = new FinishBehavior("NEVER", 0);

        /* renamed from: e, reason: collision with root package name */
        public static final FinishBehavior f7133e = new FinishBehavior("ALWAYS", 1);

        /* renamed from: f, reason: collision with root package name */
        public static final FinishBehavior f7134f = new FinishBehavior("ADJACENT", 2);

        /* renamed from: a, reason: collision with root package name */
        private final String f7135a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7136b;

        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        private FinishBehavior(String str, int i3) {
            this.f7135a = str;
            this.f7136b = i3;
        }

        public String toString() {
            return this.f7135a;
        }
    }

    private final int d(float f3, int i3) {
        return (int) ((i3 * f3) + 0.5f);
    }

    public final boolean b(float f3, Rect rect) {
        k.e(rect, "bounds");
        int width = rect.width();
        int height = rect.height();
        if (width == 0 || height == 0) {
            return false;
        }
        return (this.f7123b == 0 || width >= d(f3, this.f7123b)) && (this.f7124c == 0 || height >= d(f3, this.f7124c)) && (this.f7125d == 0 || Math.min(width, height) >= d(f3, this.f7125d)) && (height < width ? k.a(this.f7127f, EmbeddingAspectRatio.f7015d) || (((((float) width) * 1.0f) / ((float) height)) > this.f7127f.a() ? 1 : (((((float) width) * 1.0f) / ((float) height)) == this.f7127f.a() ? 0 : -1)) <= 0 : k.a(this.f7126e, EmbeddingAspectRatio.f7015d) || (((((float) height) * 1.0f) / ((float) width)) > this.f7126e.a() ? 1 : (((((float) height) * 1.0f) / ((float) width)) == this.f7126e.a() ? 0 : -1)) <= 0);
    }

    public final boolean c(Context context, WindowMetrics windowMetrics) {
        k.e(context, "context");
        k.e(windowMetrics, "parentMetrics");
        int i3 = Build.VERSION.SDK_INT;
        return b(i3 <= 33 ? context.getResources().getDisplayMetrics().density : Api34Impl.f7130a.a(windowMetrics, context), Api30Impl.f7129a.a(windowMetrics));
    }

    public final SplitAttributes e() {
        return this.f7128g;
    }

    @Override // androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule) || !super.equals(obj)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        return this.f7123b == splitRule.f7123b && this.f7124c == splitRule.f7124c && this.f7125d == splitRule.f7125d && k.a(this.f7126e, splitRule.f7126e) && k.a(this.f7127f, splitRule.f7127f) && k.a(this.f7128g, splitRule.f7128g);
    }

    public final EmbeddingAspectRatio f() {
        return this.f7127f;
    }

    public final EmbeddingAspectRatio g() {
        return this.f7126e;
    }

    public final int h() {
        return this.f7124c;
    }

    @Override // androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((((((((((super.hashCode() * 31) + this.f7123b) * 31) + this.f7124c) * 31) + this.f7125d) * 31) + this.f7126e.hashCode()) * 31) + this.f7127f.hashCode()) * 31) + this.f7128g.hashCode();
    }

    public final int i() {
        return this.f7125d;
    }

    public final int j() {
        return this.f7123b;
    }

    public String toString() {
        return SplitRule.class.getSimpleName() + "{ tag=" + a() + ", defaultSplitAttributes=" + this.f7128g + ", minWidthDp=" + this.f7123b + ", minHeightDp=" + this.f7124c + ", minSmallestWidthDp=" + this.f7125d + ", maxAspectRatioInPortrait=" + this.f7126e + ", maxAspectRatioInLandscape=" + this.f7127f + '}';
    }
}
