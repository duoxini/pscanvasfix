package androidx.activity;

import M.c;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.view.C0262k;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.C;
import androidx.lifecycle.F;
import androidx.lifecycle.H;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0271g;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import b.C0289a;
import b.InterfaceC0290b;
import c.AbstractC0294a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements o, I, InterfaceC0271g, M.e, k, androidx.activity.result.d, androidx.core.content.b {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    private F.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a> mOnTrimMemoryListeners;
    final M.d mSavedStateRegistryController;
    private H mViewModelStore;
    final C0289a mContextAwareHelper = new C0289a();
    private final C0262k mMenuHostHelper = new C0262k(new Runnable() { // from class: androidx.activity.b
        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.invalidateMenu();
        }
    });
    private final q mLifecycleRegistry = new q(this);

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e3) {
                if (!TextUtils.equals(e3.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e3;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f3355e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AbstractC0294a.C0098a f3356f;

            a(int i3, AbstractC0294a.C0098a c0098a) {
                this.f3355e = i3;
                this.f3356f = c0098a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f3355e, this.f3356f.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        class RunnableC0051b implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f3358e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f3359f;

            RunnableC0051b(int i3, IntentSender.SendIntentException sendIntentException) {
                this.f3358e = i3;
                this.f3359f = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f3358e, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f3359f));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public void f(int i3, AbstractC0294a abstractC0294a, Object obj, androidx.core.app.b bVar) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            AbstractC0294a.C0098a b3 = abstractC0294a.b(componentActivity, obj);
            if (b3 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i3, b3));
                return;
            }
            Intent a3 = abstractC0294a.a(componentActivity, obj);
            if (a3.getExtras() != null && a3.getExtras().getClassLoader() == null) {
                a3.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a3.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = a3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a3.getAction())) {
                String[] stringArrayExtra = a3.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.n(componentActivity, stringArrayExtra, i3);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a3.getAction())) {
                androidx.core.app.a.r(componentActivity, a3, i3, bundle);
                return;
            }
            androidx.activity.result.e eVar = (androidx.activity.result.e) a3.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                androidx.core.app.a.s(componentActivity, eVar.f(), i3, eVar.c(), eVar.d(), eVar.e(), 0, bundle);
            } catch (IntentSender.SendIntentException e3) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0051b(i3, e3));
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class d {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        Object f3361a;

        /* renamed from: b, reason: collision with root package name */
        H f3362b;

        e() {
        }
    }

    public ComponentActivity() {
        M.d a3 = M.d.a(this);
        this.mSavedStateRegistryController = a3;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.l
            public void a(o oVar, AbstractC0272h.b bVar) {
                if (bVar == AbstractC0272h.b.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        c.a(peekDecorView);
                    }
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.l
            public void a(o oVar, AbstractC0272h.b bVar) {
                if (bVar == AbstractC0272h.b.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().a();
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.l
            public void a(o oVar, AbstractC0272h.b bVar) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().c(this);
            }
        });
        a3.c();
        z.c(this);
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new c.InterfaceC0026c() { // from class: androidx.activity.c
            @Override // M.c.InterfaceC0026c
            public final Bundle a() {
                Bundle e3;
                e3 = ComponentActivity.this.e();
                return e3;
            }
        });
        addOnContextAvailableListener(new InterfaceC0290b() { // from class: androidx.activity.d
            @Override // b.InterfaceC0290b
            public final void a(Context context) {
                ComponentActivity.this.f(context);
            }
        });
    }

    private void d() {
        J.a(getWindow().getDecorView(), this);
        K.a(getWindow().getDecorView(), this);
        M.f.a(getWindow().getDecorView(), this);
        m.a(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle e() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Context context) {
        Bundle b3 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b3 != null) {
            this.mActivityResultRegistry.g(b3);
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(androidx.core.view.m mVar) {
        this.mMenuHostHelper.c(mVar);
    }

    @Override // androidx.core.content.b
    public final void addOnConfigurationChangedListener(androidx.core.util.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(InterfaceC0290b interfaceC0290b) {
        this.mContextAwareHelper.a(interfaceC0290b);
    }

    public final void addOnMultiWindowModeChangedListener(androidx.core.util.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(androidx.core.util.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(androidx.core.util.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(androidx.core.util.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f3362b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new H();
            }
        }
    }

    @Override // androidx.activity.result.d
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0271g
    public H.a getDefaultViewModelCreationExtras() {
        H.d dVar = new H.d();
        if (getApplication() != null) {
            dVar.c(F.a.f5711h, getApplication());
        }
        dVar.c(z.f5842a, this);
        dVar.c(z.f5843b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.c(z.f5844c, getIntent().getExtras());
        }
        return dVar;
    }

    public F.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new C(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f3361a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.o
    public AbstractC0272h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.k
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // M.e
    public final M.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.I
    public H getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (this.mActivityResultRegistry.b(i3, i4, intent)) {
            return;
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.f();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        ReportFragment.f(this);
        if (androidx.core.os.a.b()) {
            this.mOnBackPressedDispatcher.g(d.a(this));
        }
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<androidx.core.util.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.d(z3));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<androidx.core.util.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.g(z3));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onPreparePanel(i3, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i3, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        H h3 = this.mViewModelStore;
        if (h3 == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            h3 = eVar.f3362b;
        }
        if (h3 == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f3361a = onRetainCustomNonConfigurationInstance;
        eVar2.f3362b = h3;
        return eVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        AbstractC0272h lifecycle = getLifecycle();
        if (lifecycle instanceof q) {
            ((q) lifecycle).o(AbstractC0272h.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        Iterator<androidx.core.util.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i3));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0294a abstractC0294a, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b bVar) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, abstractC0294a, bVar);
    }

    public void removeMenuProvider(androidx.core.view.m mVar) {
        this.mMenuHostHelper.l(mVar);
    }

    @Override // androidx.core.content.b
    public final void removeOnConfigurationChangedListener(androidx.core.util.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(InterfaceC0290b interfaceC0290b) {
        this.mContextAwareHelper.e(interfaceC0290b);
    }

    public final void removeOnMultiWindowModeChangedListener(androidx.core.util.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(androidx.core.util.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(androidx.core.util.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(androidx.core.util.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (R.a.d()) {
                R.a.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            R.a.b();
        } catch (Throwable th) {
            R.a.b();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        d();
        super.setContentView(i3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i3) {
        super.startActivityForResult(intent, i3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6) {
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6);
    }

    public void addMenuProvider(androidx.core.view.m mVar, o oVar) {
        this.mMenuHostHelper.d(mVar, oVar);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(androidx.core.view.m mVar, o oVar, AbstractC0272h.c cVar) {
        this.mMenuHostHelper.e(mVar, oVar, cVar);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        d();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z3, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<androidx.core.util.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.d(z3, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z3, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<androidx.core.util.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.g(z3, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0294a abstractC0294a, androidx.activity.result.b bVar) {
        return registerForActivityResult(abstractC0294a, this.mActivityResultRegistry, bVar);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        super.setContentView(view, layoutParams);
    }
}
