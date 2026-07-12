package J1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h extends HandlerThread {

    /* renamed from: e, reason: collision with root package name */
    private final List f1148e;

    /* renamed from: f, reason: collision with root package name */
    private final SparseArray f1149f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f1150g;

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f1151a;

        /* renamed from: b, reason: collision with root package name */
        private final long f1152b;

        public b(Runnable runnable, long j3) {
            this.f1151a = runnable;
            this.f1152b = j3;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final h f1153a = new h();
    }

    public static void b(Runnable runnable) {
        c().f(runnable);
    }

    public static h c() {
        return c.f1153a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e() {
        return "onLooperPrepared, but looper is null";
    }

    public synchronized boolean d(int i3) {
        Handler handler = this.f1150g;
        if (handler != null) {
            return handler.hasMessages(i3);
        }
        return this.f1149f.get(i3) != null;
    }

    public synchronized void f(Runnable runnable) {
        try {
            Handler handler = this.f1150g;
            if (handler != null) {
                handler.post(runnable);
            } else {
                this.f1148e.add(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void g(int i3, Runnable runnable, long j3) {
        Handler handler = this.f1150g;
        if (handler != null) {
            handler.postDelayed(runnable, j3);
        } else {
            this.f1149f.put(i3, new b(runnable, j3));
        }
    }

    public synchronized void h(int i3) {
        try {
            Handler handler = this.f1150g;
            if (handler != null) {
                handler.removeMessages(i3);
            } else {
                this.f1149f.remove(i3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        Looper looper = getLooper();
        if (looper == null) {
            K1.f.b("WorkThread", new K1.g() { // from class: J1.g
                @Override // K1.g
                public final Object get() {
                    String e3;
                    e3 = h.e();
                    return e3;
                }
            });
            return;
        }
        synchronized (this) {
            try {
                this.f1150g = new Handler(looper);
                Iterator it = this.f1148e.iterator();
                while (it.hasNext()) {
                    this.f1150g.post((Runnable) it.next());
                }
                this.f1148e.clear();
                for (int i3 = 0; i3 < this.f1149f.size(); i3++) {
                    b bVar = (b) this.f1149f.valueAt(i3);
                    this.f1150g.postDelayed(bVar.f1151a, bVar.f1152b);
                }
                this.f1149f.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private h() {
        super("OplusTrack-thread");
        this.f1148e = new ArrayList();
        this.f1149f = new SparseArray();
        start();
    }
}
