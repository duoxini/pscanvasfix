package androidx.fragment.app;

import M.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.a;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.H;
import androidx.lifecycle.I;
import b.InterfaceC0290b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements a.d {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    boolean mResumed;
    final g mFragments = g.b(new c());
    final androidx.lifecycle.q mFragmentLifecycleRegistry = new androidx.lifecycle.q(this);
    boolean mStopped = true;

    class a implements c.InterfaceC0026c {
        a() {
        }

        @Override // M.c.InterfaceC0026c
        public Bundle a() {
            Bundle bundle = new Bundle();
            FragmentActivity.this.markFragmentsCreated();
            FragmentActivity.this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_STOP);
            Parcelable x3 = FragmentActivity.this.mFragments.x();
            if (x3 != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, x3);
            }
            return bundle;
        }
    }

    class b implements InterfaceC0290b {
        b() {
        }

        @Override // b.InterfaceC0290b
        public void a(Context context) {
            FragmentActivity.this.mFragments.a(null);
            Bundle b3 = FragmentActivity.this.getSavedStateRegistry().b(FragmentActivity.FRAGMENTS_TAG);
            if (b3 != null) {
                FragmentActivity.this.mFragments.w(b3.getParcelable(FragmentActivity.FRAGMENTS_TAG));
            }
        }
    }

    class c extends i implements I, androidx.activity.k, androidx.activity.result.d, p {
        public c() {
            super(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.p
        public void a(l lVar, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.f
        public View c(int i3) {
            return FragmentActivity.this.findViewById(i3);
        }

        @Override // androidx.fragment.app.f
        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.d
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.o
        public AbstractC0272h getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.k
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.I
        public H getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.i
        public LayoutInflater i() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.i
        public boolean k(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.i
        public boolean l(String str) {
            return androidx.core.app.a.q(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.i
        public void o() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.i
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public FragmentActivity h() {
            return FragmentActivity.this;
        }
    }

    public FragmentActivity() {
        g();
    }

    private void g() {
        getSavedStateRegistry().h(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean h(l lVar, AbstractC0272h.c cVar) {
        boolean z3 = false;
        for (Fragment fragment : lVar.r0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z3 |= h(fragment.getChildFragmentManager(), cVar);
                }
                x xVar = fragment.mViewLifecycleOwner;
                if (xVar != null && xVar.getLifecycle().b().a(AbstractC0272h.c.STARTED)) {
                    fragment.mViewLifecycleOwner.f(cVar);
                    z3 = true;
                }
                if (fragment.mLifecycleRegistry.b().a(AbstractC0272h.c.STARTED)) {
                    fragment.mLifecycleRegistry.o(cVar);
                    z3 = true;
                }
            }
        }
        return z3;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().W(str, fileDescriptor, printWriter, strArr);
    }

    public l getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    void markFragmentsCreated() {
        while (h(getSupportFragmentManager(), AbstractC0272h.c.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i3, i4, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_CREATE);
        this.mFragments.f();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return super.onCreatePanelMenu(i3, menu);
        }
        return this.mFragments.g(menu, getMenuInflater()) | super.onCreatePanelMenu(i3, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i3 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z3) {
        this.mFragments.j(z3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        if (i3 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3) {
        this.mFragments.n(z3);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return super.onPreparePanel(i3, view, menu);
        }
        return this.mFragments.o(menu) | onPrepareOptionsPanel(view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_RESUME);
        this.mFragments.p();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_START);
        this.mFragments.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.u();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(AbstractC0272h.b.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.h hVar) {
        androidx.core.app.a.o(this, hVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.h hVar) {
        androidx.core.app.a.p(this, hVar);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i3) {
        startActivityFromFragment(fragment, intent, i3, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 == -1) {
            androidx.core.app.a.s(this, intentSender, i3, intent, i4, i5, i6, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.k(this);
    }

    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.l(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.t(this);
    }

    @Override // androidx.core.app.a.d
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i3) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i3, Bundle bundle) {
        if (i3 == -1) {
            androidx.core.app.a.r(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i3, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }
}
