package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* loaded from: classes.dex */
public interface D {
    void a(Menu menu, MenuPresenter.Callback callback);

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    int j();

    void k(int i3);

    Menu l();

    void m(int i3);

    void n(O o3);

    ViewGroup o();

    void p(boolean z3);

    int q();

    androidx.core.view.E r(int i3, long j3);

    void s();

    void setIcon(int i3);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean t();

    void u();

    void v(boolean z3);

    void w(int i3);
}
