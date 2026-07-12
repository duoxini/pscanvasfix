package androidx.window.core;

import C2.l;
import D2.k;
import p2.C0509i;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
final class FailedSpecification<T> extends SpecificationComputer<T> {

    /* renamed from: b, reason: collision with root package name */
    private final Object f6958b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6959c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6960d;

    /* renamed from: e, reason: collision with root package name */
    private final Logger f6961e;

    /* renamed from: f, reason: collision with root package name */
    private final VerificationMode f6962f;

    /* renamed from: g, reason: collision with root package name */
    private final WindowStrictModeException f6963g;

    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6964a;

        static {
            int[] iArr = new int[VerificationMode.values().length];
            try {
                iArr[VerificationMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationMode.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationMode.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6964a = iArr;
        }
    }

    public FailedSpecification(Object obj, String str, String str2, Logger logger, VerificationMode verificationMode) {
        k.e(obj, "value");
        k.e(str, "tag");
        k.e(str2, "message");
        k.e(logger, "logger");
        k.e(verificationMode, "verificationMode");
        this.f6958b = obj;
        this.f6959c = str;
        this.f6960d = str2;
        this.f6961e = logger;
        this.f6962f = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(b(obj, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        k.d(stackTrace, "stackTrace");
        windowStrictModeException.setStackTrace((StackTraceElement[]) AbstractC0538h.r(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f6963g = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        int i3 = WhenMappings.f6964a[this.f6962f.ordinal()];
        if (i3 == 1) {
            throw this.f6963g;
        }
        if (i3 == 2) {
            this.f6961e.a(this.f6959c, b(this.f6958b, this.f6960d));
            return null;
        }
        if (i3 == 3) {
            return null;
        }
        throw new C0509i();
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String str, l lVar) {
        k.e(str, "message");
        k.e(lVar, "condition");
        return this;
    }
}
