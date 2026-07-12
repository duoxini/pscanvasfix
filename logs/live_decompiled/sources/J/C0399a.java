package j;

import java.util.concurrent.Executor;

/* renamed from: j.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0399a extends AbstractC0401c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile C0399a f12128c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f12129d = new ExecutorC0134a();

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f12130e = new b();

    /* renamed from: a, reason: collision with root package name */
    private AbstractC0401c f12131a;

    /* renamed from: b, reason: collision with root package name */
    private AbstractC0401c f12132b;

    /* renamed from: j.a$a, reason: collision with other inner class name */
    static class ExecutorC0134a implements Executor {
        ExecutorC0134a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C0399a.e().c(runnable);
        }
    }

    /* renamed from: j.a$b */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C0399a.e().a(runnable);
        }
    }

    private C0399a() {
        C0400b c0400b = new C0400b();
        this.f12132b = c0400b;
        this.f12131a = c0400b;
    }

    public static Executor d() {
        return f12130e;
    }

    public static C0399a e() {
        if (f12128c != null) {
            return f12128c;
        }
        synchronized (C0399a.class) {
            try {
                if (f12128c == null) {
                    f12128c = new C0399a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12128c;
    }

    @Override // j.AbstractC0401c
    public void a(Runnable runnable) {
        this.f12131a.a(runnable);
    }

    @Override // j.AbstractC0401c
    public boolean b() {
        return this.f12131a.b();
    }

    @Override // j.AbstractC0401c
    public void c(Runnable runnable) {
        this.f12131a.c(runnable);
    }
}
