package U2;

import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public class q {

    /* renamed from: c, reason: collision with root package name */
    public static final b f2500c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final q f2501d = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f2502a;

    /* renamed from: b, reason: collision with root package name */
    private long f2503b;

    public static final class a extends q {
        a() {
        }

        @Override // U2.q
        public void a() {
        }
    }

    public static final class b {
        public /* synthetic */ b(D2.g gVar) {
            this();
        }

        private b() {
        }
    }

    public void a() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f2502a && this.f2503b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
