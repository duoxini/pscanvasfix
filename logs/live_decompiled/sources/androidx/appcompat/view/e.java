package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements MenuBuilder.Callback {

    /* renamed from: g, reason: collision with root package name */
    private Context f3727g;

    /* renamed from: h, reason: collision with root package name */
    private ActionBarContextView f3728h;

    /* renamed from: i, reason: collision with root package name */
    private b.a f3729i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference f3730j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3731k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3732l;

    /* renamed from: m, reason: collision with root package name */
    private MenuBuilder f3733m;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z3) {
        this.f3727g = context;
        this.f3728h = actionBarContextView;
        this.f3729i = aVar;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f3733m = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f3732l = z3;
    }

    @Override // androidx.appcompat.view.b
    public void a() {
        if (this.f3731k) {
            return;
        }
        this.f3731k = true;
        this.f3729i.d(this);
    }

    @Override // androidx.appcompat.view.b
    public View b() {
        WeakReference weakReference = this.f3730j;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu c() {
        return this.f3733m;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater d() {
        return new g(this.f3728h.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence e() {
        return this.f3728h.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f3728h.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void i() {
        this.f3729i.a(this, this.f3733m);
    }

    @Override // androidx.appcompat.view.b
    public boolean j() {
        return this.f3728h.j();
    }

    @Override // androidx.appcompat.view.b
    public void k(View view) {
        this.f3728h.setCustomView(view);
        this.f3730j = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void l(int i3) {
        m(this.f3727g.getString(i3));
    }

    @Override // androidx.appcompat.view.b
    public void m(CharSequence charSequence) {
        this.f3728h.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void o(int i3) {
        p(this.f3727g.getString(i3));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f3729i.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        i();
        this.f3728h.l();
    }

    @Override // androidx.appcompat.view.b
    public void p(CharSequence charSequence) {
        this.f3728h.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(boolean z3) {
        super.q(z3);
        this.f3728h.setTitleOptional(z3);
    }
}
