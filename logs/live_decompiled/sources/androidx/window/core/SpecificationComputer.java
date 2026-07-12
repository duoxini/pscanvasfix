package androidx.window.core;

import C2.l;
import D2.g;
import D2.k;

/* loaded from: classes.dex */
public abstract class SpecificationComputer<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f6971a = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer b(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i3, Object obj2) {
            if ((i3 & 2) != 0) {
                verificationMode = BuildConfig.f6942a.a();
            }
            if ((i3 & 4) != 0) {
                logger = AndroidLogger.f6937a;
            }
            return companion.a(obj, str, verificationMode, logger);
        }

        public final SpecificationComputer a(Object obj, String str, VerificationMode verificationMode, Logger logger) {
            k.e(obj, "<this>");
            k.e(str, "tag");
            k.e(verificationMode, "verificationMode");
            k.e(logger, "logger");
            return new ValidSpecification(obj, str, verificationMode, logger);
        }

        private Companion() {
        }
    }

    public abstract Object a();

    protected final String b(Object obj, String str) {
        k.e(obj, "value");
        k.e(str, "message");
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer c(String str, l lVar);
}
