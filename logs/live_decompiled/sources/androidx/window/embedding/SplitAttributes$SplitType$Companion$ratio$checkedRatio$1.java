package androidx.window.embedding;

import D2.l;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
final class SplitAttributes$SplitType$Companion$ratio$checkedRatio$1 extends l implements C2.l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ float f7085e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplitAttributes$SplitType$Companion$ratio$checkedRatio$1(float f3) {
        super(1);
        this.f7085e = f3;
    }

    public final Boolean a(float f3) {
        double d3 = this.f7085e;
        return Boolean.valueOf(0.0d <= d3 && d3 <= 1.0d && !AbstractC0538h.q(new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)}, Float.valueOf(this.f7085e)));
    }

    @Override // C2.l
    public /* bridge */ /* synthetic */ Object f(Object obj) {
        return a(((Number) obj).floatValue());
    }
}
