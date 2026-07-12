package androidx.loader.app;

import androidx.appcompat.app.p;
import androidx.lifecycle.E;
import androidx.lifecycle.F;
import androidx.lifecycle.H;
import androidx.lifecycle.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import m.h;

/* loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* renamed from: a, reason: collision with root package name */
    private final o f5846a;

    /* renamed from: b, reason: collision with root package name */
    private final a f5847b;

    static class a extends E {

        /* renamed from: f, reason: collision with root package name */
        private static final F.b f5848f = new C0088a();

        /* renamed from: d, reason: collision with root package name */
        private h f5849d = new h();

        /* renamed from: e, reason: collision with root package name */
        private boolean f5850e = false;

        /* renamed from: androidx.loader.app.b$a$a, reason: collision with other inner class name */
        static class C0088a implements F.b {
            C0088a() {
            }

            @Override // androidx.lifecycle.F.b
            public E a(Class cls) {
                return new a();
            }
        }

        a() {
        }

        static a g(H h3) {
            return (a) new F(h3, f5848f).a(a.class);
        }

        @Override // androidx.lifecycle.E
        protected void d() {
            super.d();
            if (this.f5849d.j() <= 0) {
                this.f5849d.b();
            } else {
                p.a(this.f5849d.k(0));
                throw null;
            }
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f5849d.j() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f5849d.j() <= 0) {
                    return;
                }
                p.a(this.f5849d.k(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f5849d.h(0));
                printWriter.print(": ");
                throw null;
            }
        }

        void h() {
            if (this.f5849d.j() <= 0) {
                return;
            }
            p.a(this.f5849d.k(0));
            throw null;
        }
    }

    b(o oVar, H h3) {
        this.f5846a = oVar;
        this.f5847b = a.g(h3);
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f5847b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f5847b.h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.f5846a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
