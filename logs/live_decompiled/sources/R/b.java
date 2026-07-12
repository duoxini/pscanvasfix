package R;

import android.os.Trace;

/* loaded from: classes.dex */
abstract class b {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
