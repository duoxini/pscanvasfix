package a;

/* renamed from: a.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0215b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3146a = "_COROUTINE";

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackTraceElement b(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f3146a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
