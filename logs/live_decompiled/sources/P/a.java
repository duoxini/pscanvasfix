package P;

import D2.g;
import D2.k;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final C0035a f1745e = new C0035a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Map f1746f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1747a;

    /* renamed from: b, reason: collision with root package name */
    private final File f1748b;

    /* renamed from: c, reason: collision with root package name */
    private final Lock f1749c;

    /* renamed from: d, reason: collision with root package name */
    private FileChannel f1750d;

    /* renamed from: P.a$a, reason: collision with other inner class name */
    public static final class C0035a {
        public /* synthetic */ C0035a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (a.f1746f) {
                try {
                    Map map = a.f1746f;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private C0035a() {
        }
    }

    public a(String str, File file, boolean z3) {
        k.e(str, "name");
        k.e(file, "lockDir");
        this.f1747a = z3;
        File file2 = new File(file, str + ".lck");
        this.f1748b = file2;
        C0035a c0035a = f1745e;
        String absolutePath = file2.getAbsolutePath();
        k.d(absolutePath, "lockFile.absolutePath");
        this.f1749c = c0035a.b(absolutePath);
    }

    public static /* synthetic */ void c(a aVar, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z3 = aVar.f1747a;
        }
        aVar.b(z3);
    }

    public final void b(boolean z3) {
        this.f1749c.lock();
        if (z3) {
            try {
                File parentFile = this.f1748b.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f1748b).getChannel();
                channel.lock();
                this.f1750d = channel;
            } catch (IOException e3) {
                this.f1750d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e3);
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f1750d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f1749c.unlock();
    }
}
