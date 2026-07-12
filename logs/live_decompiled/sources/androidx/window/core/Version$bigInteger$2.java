package androidx.window.core;

import C2.a;
import D2.l;
import java.math.BigInteger;

/* loaded from: classes.dex */
final class Version$bigInteger$2 extends l implements a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Version f6990e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Version$bigInteger$2(Version version) {
        super(0);
        this.f6990e = version;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final BigInteger invoke() {
        return BigInteger.valueOf(this.f6990e.d()).shiftLeft(32).or(BigInteger.valueOf(this.f6990e.e())).shiftLeft(32).or(BigInteger.valueOf(this.f6990e.f()));
    }
}
