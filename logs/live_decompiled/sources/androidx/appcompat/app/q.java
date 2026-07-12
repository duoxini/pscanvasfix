package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.g;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Y;
import androidx.core.view.y;
import java.util.ArrayList;

/* loaded from: classes.dex */
class q extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    final D f3654a;

    /* renamed from: b, reason: collision with root package name */
    final Window.Callback f3655b;

    /* renamed from: c, reason: collision with root package name */
    final g.InterfaceC0055g f3656c;

    /* renamed from: d, reason: collision with root package name */
    boolean f3657d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3658e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3659f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f3660g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f3661h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final Toolbar.h f3662i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.x();
        }
    }

    class b implements Toolbar.h {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return q.this.f3655b.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements MenuPresenter.Callback {

        /* renamed from: e, reason: collision with root package name */
        private boolean f3665e;

        c() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
            if (this.f3665e) {
                return;
            }
            this.f3665e = true;
            q.this.f3654a.h();
            q.this.f3655b.onPanelClosed(108, menuBuilder);
            this.f3665e = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            q.this.f3655b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    private final class d implements MenuBuilder.Callback {
        d() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (q.this.f3654a.c()) {
                q.this.f3655b.onPanelClosed(108, menuBuilder);
            } else if (q.this.f3655b.onPreparePanel(0, null, menuBuilder)) {
                q.this.f3655b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    private class e implements g.InterfaceC0055g {
        e() {
        }

        @Override // androidx.appcompat.app.g.InterfaceC0055g
        public boolean a(int i3) {
            if (i3 != 0) {
                return false;
            }
            q qVar = q.this;
            if (qVar.f3657d) {
                return false;
            }
            qVar.f3654a.f();
            q.this.f3657d = true;
            return false;
        }

        @Override // androidx.appcompat.app.g.InterfaceC0055g
        public View onCreatePanelView(int i3) {
            if (i3 == 0) {
                return new View(q.this.f3654a.getContext());
            }
            return null;
        }
    }

    q(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f3662i = bVar;
        androidx.core.util.h.d(toolbar);
        Y y3 = new Y(toolbar, false);
        this.f3654a = y3;
        this.f3655b = (Window.Callback) androidx.core.util.h.d(callback);
        y3.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        y3.setWindowTitle(charSequence);
        this.f3656c = new e();
    }

    private Menu w() {
        if (!this.f3658e) {
            this.f3654a.i(new c(), new d());
            this.f3658e = true;
        }
        return this.f3654a.l();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f3654a.d();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.f3654a.t()) {
            return false;
        }
        this.f3654a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z3) {
        if (z3 == this.f3659f) {
            return;
        }
        this.f3659f = z3;
        if (this.f3660g.size() <= 0) {
            return;
        }
        p.a(this.f3660g.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f3654a.j();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f3654a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f3654a.o().removeCallbacks(this.f3661h);
        y.a0(this.f3654a.o(), this.f3661h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    void n() {
        this.f3654a.o().removeCallbacks(this.f3661h);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu w3 = w();
        if (w3 == null) {
            return false;
        }
        w3.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return w3.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f3654a.e();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z3) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z3) {
        y(z3 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z3) {
    }

    @Override // androidx.appcompat.app.a
    public void u(CharSequence charSequence) {
        this.f3654a.setWindowTitle(charSequence);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void x() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.w()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.MenuBuilder
            r2 = 0
            if (r1 == 0) goto Ld
            r1 = r0
            androidx.appcompat.view.menu.MenuBuilder r1 = (androidx.appcompat.view.menu.MenuBuilder) r1
            goto Le
        Ld:
            r1 = r2
        Le:
            if (r1 == 0) goto L13
            r1.stopDispatchingItemsChanged()
        L13:
            r0.clear()     // Catch: java.lang.Throwable -> L28
            android.view.Window$Callback r3 = r5.f3655b     // Catch: java.lang.Throwable -> L28
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L2a
            android.view.Window$Callback r5 = r5.f3655b     // Catch: java.lang.Throwable -> L28
            boolean r5 = r5.onPreparePanel(r4, r2, r0)     // Catch: java.lang.Throwable -> L28
            if (r5 != 0) goto L2d
            goto L2a
        L28:
            r5 = move-exception
            goto L33
        L2a:
            r0.clear()     // Catch: java.lang.Throwable -> L28
        L2d:
            if (r1 == 0) goto L32
            r1.startDispatchingItemsChanged()
        L32:
            return
        L33:
            if (r1 == 0) goto L38
            r1.startDispatchingItemsChanged()
        L38:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.q.x():void");
    }

    public void y(int i3, int i4) {
        this.f3654a.w((i3 & i4) | ((~i4) & this.f3654a.j()));
    }
}
