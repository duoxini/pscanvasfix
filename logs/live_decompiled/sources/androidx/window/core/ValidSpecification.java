package androidx.window.core;

import C2.l;
import D2.k;

/* loaded from: classes.dex */
final class ValidSpecification<T> extends SpecificationComputer<T> {

    /* renamed from: b, reason: collision with root package name */
    private final Object f6972b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6973c;

    /* renamed from: d, reason: collision with root package name */
    private final VerificationMode f6974d;

    /* renamed from: e, reason: collision with root package name */
    private final Logger f6975e;

    public ValidSpecification(Object obj, String str, VerificationMode verificationMode, Logger logger) {
        k.e(obj, "value");
        k.e(str, "tag");
        k.e(verificationMode, "verificationMode");
        k.e(logger, "logger");
        this.f6972b = obj;
        this.f6973c = str;
        this.f6974d = verificationMode;
        this.f6975e = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        return this.f6972b;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String str, l lVar) {
        k.e(str, "message");
        k.e(lVar, "condition");
        return ((Boolean) lVar.f(this.f6972b)).booleanValue() ? this : new FailedSpecification(this.f6972b, this.f6973c, str, this.f6975e, this.f6974d);
    }
}
