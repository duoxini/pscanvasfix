package F0;

import android.os.SystemClock;
import android.view.Choreographer;

/* loaded from: classes.dex */
abstract class a {

    /* renamed from: F0.a$a, reason: collision with other inner class name */
    private static class C0010a extends h {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f390b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f391c = new ChoreographerFrameCallbackC0011a();

        /* renamed from: d, reason: collision with root package name */
        private boolean f392d;

        /* renamed from: e, reason: collision with root package name */
        private long f393e;

        /* renamed from: F0.a$a$a, reason: collision with other inner class name */
        class ChoreographerFrameCallbackC0011a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0011a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j3) {
                if (!C0010a.this.f392d || C0010a.this.f424a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                C0010a.this.f424a.e(uptimeMillis - r0.f393e);
                C0010a.this.f393e = uptimeMillis;
                C0010a.this.f390b.postFrameCallback(C0010a.this.f391c);
            }
        }

        public C0010a(Choreographer choreographer) {
            this.f390b = choreographer;
        }

        public static C0010a i() {
            return new C0010a(Choreographer.getInstance());
        }

        @Override // F0.h
        public void b() {
            if (this.f392d) {
                return;
            }
            this.f392d = true;
            this.f393e = SystemClock.uptimeMillis();
            this.f390b.removeFrameCallback(this.f391c);
            this.f390b.postFrameCallback(this.f391c);
        }

        @Override // F0.h
        public void c() {
            this.f392d = false;
            this.f390b.removeFrameCallback(this.f391c);
        }
    }

    public static h a() {
        return C0010a.i();
    }
}
