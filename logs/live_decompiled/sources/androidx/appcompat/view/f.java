package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import java.util.ArrayList;
import w.InterfaceMenuC0613a;
import w.InterfaceMenuItemC0614b;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f3734a;

    /* renamed from: b, reason: collision with root package name */
    final b f3735b;

    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f3736a;

        /* renamed from: b, reason: collision with root package name */
        final Context f3737b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList f3738c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        final m.g f3739d = new m.g();

        public a(Context context, ActionMode.Callback callback) {
            this.f3737b = context;
            this.f3736a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f3739d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f3737b, (InterfaceMenuC0613a) menu);
            this.f3739d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f3736a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, MenuItem menuItem) {
            return this.f3736a.onActionItemClicked(e(bVar), new MenuItemWrapperICS(this.f3737b, (InterfaceMenuItemC0614b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f3736a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public void d(b bVar) {
            this.f3736a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f3738c.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = (f) this.f3738c.get(i3);
                if (fVar != null && fVar.f3735b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f3737b, bVar);
            this.f3738c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f3734a = context;
        this.f3735b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f3735b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f3735b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f3734a, (InterfaceMenuC0613a) this.f3735b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f3735b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f3735b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f3735b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f3735b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f3735b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f3735b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f3735b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f3735b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f3735b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f3735b.n(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f3735b.p(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z3) {
        this.f3735b.q(z3);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i3) {
        this.f3735b.l(i3);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i3) {
        this.f3735b.o(i3);
    }
}
