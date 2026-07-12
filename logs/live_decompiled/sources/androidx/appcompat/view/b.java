package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e, reason: collision with root package name */
    private Object f3719e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3720f;

    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, MenuItem menuItem);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f3719e;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.f3720f;
    }

    public abstract void i();

    public abstract boolean j();

    public abstract void k(View view);

    public abstract void l(int i3);

    public abstract void m(CharSequence charSequence);

    public void n(Object obj) {
        this.f3719e = obj;
    }

    public abstract void o(int i3);

    public abstract void p(CharSequence charSequence);

    public void q(boolean z3) {
        this.f3720f = z3;
    }
}
