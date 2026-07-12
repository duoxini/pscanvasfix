package s1;

import android.view.Choreographer;
import p1.AbstractC0497b;

/* renamed from: s1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0578e {

    /* renamed from: d, reason: collision with root package name */
    private a f13300d;

    /* renamed from: b, reason: collision with root package name */
    private Choreographer.FrameCallback f13298b = new Choreographer.FrameCallback() { // from class: s1.d
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j3) {
            C0578e.this.b(j3);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private boolean f13299c = false;

    /* renamed from: a, reason: collision with root package name */
    private Choreographer f13297a = Choreographer.getInstance();

    /* renamed from: s1.e$a */
    interface a {
        void doFrame(long j3);
    }

    C0578e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(long j3) {
        this.f13299c = false;
        if (this.f13300d != null) {
            if (AbstractC0497b.a()) {
                AbstractC0497b.d("PhysicsWorld-Frame", "doFrame ----------------------- frameTime =:" + j3);
            }
            this.f13300d.doFrame(j3);
        }
    }

    void d() {
        if (this.f13299c || this.f13300d == null) {
            return;
        }
        this.f13297a.postFrameCallback(this.f13298b);
        if (AbstractC0497b.a()) {
            AbstractC0497b.d("PhysicsWorld-Frame", "scheduleNextFrame ----------------------- ");
        }
        this.f13299c = true;
    }

    void e(a aVar) {
        this.f13300d = aVar;
    }

    void f() {
        if (this.f13299c) {
            if (AbstractC0497b.a()) {
                AbstractC0497b.d("PhysicsWorld-Frame", "unScheduleNextFrame ----------------------- ");
            }
            this.f13297a.removeFrameCallback(this.f13298b);
            this.f13299c = false;
        }
    }
}
