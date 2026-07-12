package androidx.core.content;

import android.content.Context;
import android.os.Process;

/* loaded from: classes.dex */
public abstract class c {
    public static int a(Context context, String str, int i3, int i4, String str2) {
        if (context.checkPermission(str, i3, i4) == -1) {
            return -1;
        }
        String c3 = androidx.core.app.c.c(str);
        if (c3 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i4);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i4 || !androidx.core.util.c.a(context.getPackageName(), str2)) ? androidx.core.app.c.b(context, c3, str2) : androidx.core.app.c.a(context, i4, c3, str2)) == 0 ? 0 : -2;
    }

    public static int b(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
