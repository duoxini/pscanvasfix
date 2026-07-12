package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4922a;

    /* renamed from: b, reason: collision with root package name */
    private b f4923b;

    /* renamed from: c, reason: collision with root package name */
    private Object f4924c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4925d;

    static class a {
        static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface b {
        void onCancel();
    }

    private void d() {
        while (this.f4925d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f4922a) {
                    return;
                }
                this.f4922a = true;
                this.f4925d = true;
                b bVar = this.f4923b;
                Object obj = this.f4924c;
                if (bVar != null) {
                    try {
                        bVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f4925d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    a.a(obj);
                }
                synchronized (this) {
                    this.f4925d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public boolean b() {
        boolean z3;
        synchronized (this) {
            z3 = this.f4922a;
        }
        return z3;
    }

    public void c(b bVar) {
        synchronized (this) {
            try {
                d();
                if (this.f4923b == bVar) {
                    return;
                }
                this.f4923b = bVar;
                if (this.f4922a && bVar != null) {
                    bVar.onCancel();
                }
            } finally {
            }
        }
    }
}
