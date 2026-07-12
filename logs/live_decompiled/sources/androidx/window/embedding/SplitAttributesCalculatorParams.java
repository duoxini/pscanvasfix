package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;

/* loaded from: classes.dex */
public final class SplitAttributesCalculatorParams {

    /* renamed from: a, reason: collision with root package name */
    private final WindowMetrics f7086a;

    /* renamed from: b, reason: collision with root package name */
    private final Configuration f7087b;

    /* renamed from: c, reason: collision with root package name */
    private final WindowLayoutInfo f7088c;

    /* renamed from: d, reason: collision with root package name */
    private final SplitAttributes f7089d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f7090e;

    /* renamed from: f, reason: collision with root package name */
    private final String f7091f;

    public String toString() {
        return SplitAttributesCalculatorParams.class.getSimpleName() + ":{windowMetrics=" + this.f7086a + ", configuration=" + this.f7087b + ", windowLayoutInfo=" + this.f7088c + ", defaultSplitAttributes=" + this.f7089d + ", areDefaultConstraintsSatisfied=" + this.f7090e + ", tag=" + this.f7091f + '}';
    }
}
