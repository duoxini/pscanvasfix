package U2;

import java.io.InputStream;
import java.util.logging.Logger;

/* loaded from: classes.dex */
abstract /* synthetic */ class h {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2471a = Logger.getLogger("okio.Okio");

    public static final boolean a(AssertionError assertionError) {
        D2.k.e(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? K2.e.w(message, "getsockname failed", false, 2, null) : false;
    }

    public static final p b(InputStream inputStream) {
        D2.k.e(inputStream, "<this>");
        return new f(inputStream, new q());
    }
}
