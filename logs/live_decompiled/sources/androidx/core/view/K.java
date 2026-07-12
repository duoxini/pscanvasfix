package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    private final b f5048a;

    private static class b {
        b() {
        }

        public abstract void a(boolean z3);

        public abstract void b(boolean z3);
    }

    public K(Window window, View view) {
        this.f5048a = new a(window, this);
    }

    public void a(boolean z3) {
        this.f5048a.a(z3);
    }

    public void b(boolean z3) {
        this.f5048a.b(z3);
    }

    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        final K f5049a;

        /* renamed from: b, reason: collision with root package name */
        final WindowInsetsController f5050b;

        /* renamed from: c, reason: collision with root package name */
        private final m.g f5051c;

        /* renamed from: d, reason: collision with root package name */
        protected Window f5052d;

        a(Window window, K k3) {
            this(window.getInsetsController(), k3);
            this.f5052d = window;
        }

        @Override // androidx.core.view.K.b
        public void a(boolean z3) {
            if (z3) {
                if (this.f5052d != null) {
                    c(16);
                }
                this.f5050b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f5052d != null) {
                    d(16);
                }
                this.f5050b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.K.b
        public void b(boolean z3) {
            if (z3) {
                if (this.f5052d != null) {
                    c(8192);
                }
                this.f5050b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f5052d != null) {
                    d(8192);
                }
                this.f5050b.setSystemBarsAppearance(0, 8);
            }
        }

        protected void c(int i3) {
            View decorView = this.f5052d.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void d(int i3) {
            View decorView = this.f5052d.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }

        a(WindowInsetsController windowInsetsController, K k3) {
            this.f5051c = new m.g();
            this.f5050b = windowInsetsController;
            this.f5049a = k3;
        }
    }
}
