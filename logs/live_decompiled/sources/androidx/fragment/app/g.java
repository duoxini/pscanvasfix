package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.I;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final i f5437a;

    private g(i iVar) {
        this.f5437a = iVar;
    }

    public static g b(i iVar) {
        return new g((i) androidx.core.util.h.e(iVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        i iVar = this.f5437a;
        iVar.f5443i.k(iVar, iVar, fragment);
    }

    public void c() {
        this.f5437a.f5443i.y();
    }

    public void d(Configuration configuration) {
        this.f5437a.f5443i.A(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f5437a.f5443i.B(menuItem);
    }

    public void f() {
        this.f5437a.f5443i.C();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f5437a.f5443i.D(menu, menuInflater);
    }

    public void h() {
        this.f5437a.f5443i.E();
    }

    public void i() {
        this.f5437a.f5443i.G();
    }

    public void j(boolean z3) {
        this.f5437a.f5443i.H(z3);
    }

    public boolean k(MenuItem menuItem) {
        return this.f5437a.f5443i.J(menuItem);
    }

    public void l(Menu menu) {
        this.f5437a.f5443i.K(menu);
    }

    public void m() {
        this.f5437a.f5443i.M();
    }

    public void n(boolean z3) {
        this.f5437a.f5443i.N(z3);
    }

    public boolean o(Menu menu) {
        return this.f5437a.f5443i.O(menu);
    }

    public void p() {
        this.f5437a.f5443i.Q();
    }

    public void q() {
        this.f5437a.f5443i.R();
    }

    public void r() {
        this.f5437a.f5443i.T();
    }

    public boolean s() {
        return this.f5437a.f5443i.a0(true);
    }

    public l t() {
        return this.f5437a.f5443i;
    }

    public void u() {
        this.f5437a.f5443i.S0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f5437a.f5443i.t0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        i iVar = this.f5437a;
        if (!(iVar instanceof I)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        iVar.f5443i.f1(parcelable);
    }

    public Parcelable x() {
        return this.f5437a.f5443i.h1();
    }
}
