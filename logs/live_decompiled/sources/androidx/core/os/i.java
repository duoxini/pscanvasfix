package androidx.core.os;

import android.os.Trace;

/* loaded from: classes.dex */
public abstract class i {

    static class a {
        static void a(String str) {
            Trace.beginSection(str);
        }

        static void b() {
            Trace.endSection();
        }
    }

    public static void a(String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
