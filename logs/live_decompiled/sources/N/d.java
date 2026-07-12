package N;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1604a = new d();

    private d() {
    }

    public static final File a(Context context) {
        D2.k.e(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        D2.k.d(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
